package com.beyontec.mol.config.security;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private ResourceServerTokenServices tokenServices;

    @Value("${security.oauth2.resource.id}")
    private String resourceId;

    @Autowired
    private RouteAclConfig routeAclConfig;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceId).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .requestMatchers()
            .and()
            .cors()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .antMatchers("/oauth/token/**",
                         "/auth/login/**",
                         "/auth/logout/**",
                         "/api/certificate/download",
                         "/api/configs/global")
            .permitAll()
            .antMatchers("/h2/**", "/manage/**").permitAll();

        Properties props = routeAclConfig.getProperties();
        props.forEach((key, value) -> {
            String[] url = key.toString().split("\\|");
            try {
                if (url.length == 1) {
                    http.authorizeRequests().antMatchers(url[0]).access(getAccessExpression(value.toString()));
                } else if (url.length == 2) {
                    http.authorizeRequests().antMatchers(HttpMethod.valueOf(url[1]), url[0])
                            .access(getAccessExpression(value.toString()));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .headers().frameOptions().disable();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setMaxAge(3600L);
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    private String getAccessExpression(String value) {

        StringBuilder exp = new StringBuilder();
        String[] access = value.split("\\|");
        int len = access.length;
        if (len == 1) {
            exp.append("hasAnyAuthority('");
            exp.append(access[0]);
            exp.append("')");
            return exp.toString();
        } else if (len == 2) {
            exp.append("#oauth2.hasScope('");
            exp.append(access[1]);
            exp.append("')");

            if (!StringUtils.isEmpty(access[0])) {

                exp.append(" and ");
                exp.append("hasAnyAuthority('");
                exp.append(access[0]);
                exp.append("')");
            }
            return exp.toString();
        }

        return null;
    }
}
