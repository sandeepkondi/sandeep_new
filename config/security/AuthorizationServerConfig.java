package com.beyontec.mol.config.security;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.OAuthException;
import com.beyontec.mol.service.UserSecurityDetailsService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Value("${security.oauth2.client.web.clientId}")
	private String webClientId;

	@Value("${security.oauth2.client.web.clientSecret}")
	private String webClientSecret;

	@Value("${security.oauth2.client.web.authorizedGrantTypes}")
	private String webAuthorizedGrantTypes;

	@Value("${security.oauth2.client.web.scope}")
	private String webScopes;

	@Value("${security.oauth2.client.web.resourceIds}")
	private String webResourceIds;

	@Value("${security.oauth2.client.web.accessTokenValidity}")
	private int webAccessTokenValidity;

	@Value("${security.oauth2.client.web.refreshTokenValidity}")
	private int webRefreshTokenValidity;

	@Value("${security.oauth2.client.ext.clientId}")
	private String extClientId;

	@Value("${security.oauth2.client.ext.clientSecret}")
	private String extClientSecret;

	@Value("${security.oauth2.client.ext.authorizedGrantTypes}")
	private String extAuthorizedGrantTypes;

	@Value("${security.oauth2.client.ext.scope}")
	private String extScopes;

	@Value("${security.oauth2.client.ext.resourceIds}")
	private String extResourceIds;

	@Value("${security.oauth2.client.ext.accessTokenValidity}")
	private int extAccessTokenValidity;

	@Value("${security.oauth2.client.ext.refreshTokenValidity}")
	private int extRefreshTokenValidity;

	@Value("${security.jwt.signing-key}")
	private String signingKey;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private TokenEnhancer tokenEnhancer;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserSecurityDetailsService userDetailsService;

	@Autowired
	private MessageSource messageSource;

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient(webClientId).secret(webClientSecret)
				.authorizedGrantTypes(webAuthorizedGrantTypes.split(",")).scopes(webScopes.split(","))
				.accessTokenValiditySeconds(webAccessTokenValidity).refreshTokenValiditySeconds(webRefreshTokenValidity)
				.resourceIds(webResourceIds).and().withClient(extClientId).secret(extClientSecret)
				.authorizedGrantTypes(extAuthorizedGrantTypes.split(",")).scopes(extScopes.split(","))
				.accessTokenValiditySeconds(extAccessTokenValidity).refreshTokenValiditySeconds(extRefreshTokenValidity)
				.resourceIds(extResourceIds);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer, accessTokenConverter));
		endpoints.tokenStore(tokenStore).accessTokenConverter(accessTokenConverter).tokenEnhancer(enhancerChain)
				.authenticationManager(authenticationManager).userDetailsService(userDetailsService)
				.exceptionTranslator(exception -> {
					if (exception instanceof OAuth2Exception) {
						OAuth2Exception oAuth2Exception = (OAuth2Exception) exception;
						return ResponseEntity.status(oAuth2Exception.getHttpErrorCode())
								.body(new OAuthException(oAuth2Exception.getMessage()));
					} else if (exception instanceof ApplicationException) {
						ApplicationException applicationException = (ApplicationException) exception;
						return ResponseEntity.status(applicationException.getErrorCode().getHttpStatus())
								.body(new OAuthException(
										messageSource.getMessage(applicationException.getErrorCode().getCode(), null,
												LocaleContextHolder.getLocale())));
					} else {
						throw exception;
					}
				});
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
        converter.setAccessTokenConverter(new JWTConverter());
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new OAuth2TokenEnhancer();
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}

    private static class JWTConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer {

        @Override
        public void configure(JwtAccessTokenConverter converter) {
            converter.setAccessTokenConverter(this);
        }

        @Override
        public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
            OAuth2Authentication auth = super.extractAuthentication(map);
            auth.setDetails(map); // this will get spring to copy JWT content into Authentication
            return auth;
        }
    }
}
