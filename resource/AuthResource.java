package com.beyontec.mol.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;

@RestController
@RequestMapping("/auth")
public class AuthResource {

	@Value("${security.oauth2.client.web.accessTokenUri}")
	private String accessTokenUri;

	@Value("${security.oauth2.client.web.clientId}")
	private String clientId;

	@Value("${security.oauth2.client.web.clientSecret}")
	private String clientSecret;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private TokenStore tokenStore;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, HttpServletRequest req) {

		// Checking login id and password
		if (StringUtils.isEmpty(username)) {
			throw new ApplicationException(ErrorCode.EMPTY_USERNAME);
		}

		if (StringUtils.isEmpty(password)) {
			throw new ApplicationException(ErrorCode.EMPTY_PASSWORD);
		}

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("username", username);
		map.add("password", password);
		map.add("grant_type", "password");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
				getReqHeaders(req));

		ResponseEntity<String> response = restTemplate.postForEntity(accessTokenUri, request, String.class);

		return response;
	}

	private HttpHeaders getReqHeaders(HttpServletRequest req) {

		HttpHeaders headers = new HttpHeaders();
		String auth = clientId + ":" + clientSecret;
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString(auth.getBytes()));
		headers.add(HttpHeaders.ACCEPT_LANGUAGE, req.getHeader(HttpHeaders.ACCEPT_LANGUAGE));
		return headers;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> logout(HttpServletRequest request) {

		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (authHeader != null) {
			try {
				String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE, "").trim();
				OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
				tokenStore.removeAccessToken(accessToken);
			} catch (Exception e) {
				return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
			}
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
