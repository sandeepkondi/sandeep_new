package com.beyontec.mol.config.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.beyontec.mol.modal.UserDTO;
import com.beyontec.mol.repository.ClaimsRepository;
import com.beyontec.mol.service.UserService;

@Component
public class OAuth2TokenEnhancer implements TokenEnhancer {

    @Autowired
    private ClaimsRepository claimsRepository;

    @Autowired
    private UserService userService;

    @Value("${date.format}") private String dateFormat;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

    	UserDTO user = userService.findUserByLoginId(authentication.getName());

        Map<String, Object> additionalInfo = new HashMap<>();

        additionalInfo.put(OAuth2TokenKeys.USERNAME.toString(), user.getLoginId());
        additionalInfo.put(OAuth2TokenKeys.USER_ID.toString(), user.getUserId());
        additionalInfo.put(OAuth2TokenKeys.FIRST_NAME.toString(), user.getFirstName());
        additionalInfo.put(OAuth2TokenKeys.LAST_NAME.toString(), user.getLastName());
        additionalInfo.put(OAuth2TokenKeys.COMPANY_ID.toString(), claimsRepository.getCompanyId());
        additionalInfo.put(OAuth2TokenKeys.EMAIL.toString(), user.getMailId());
        additionalInfo.put(OAuth2TokenKeys.IS_FIRST_LOGIN.toString(), user.getLoginStatus());
        additionalInfo.put(OAuth2TokenKeys.MENU.toString(), user.getUserMenu());
        additionalInfo.put(OAuth2TokenKeys.USER_GROUPS.toString(), user.getUserGroupIdAndName());
        additionalInfo.put(OAuth2TokenKeys.DATE_FORMAT.toString(), dateFormat.toUpperCase());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
