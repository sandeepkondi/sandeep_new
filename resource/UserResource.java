package com.beyontec.mol.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beyontec.mol.modal.Password;
import com.beyontec.mol.modal.UserGroupMenuDTO;
import com.beyontec.mol.service.UserService;
import com.beyontec.mol.util.TokenGenerator;

@RestController
@RequestMapping("/api/users")
public class UserResource extends BaseResource {

    @Autowired
    private UserService userService;

    @Autowired private TokenGenerator tokenGenerator;

    @PutMapping(value = "/resetPassword")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody Password password) {

        userService.resetPassword(password);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(value = "/changeUserGroup")
    public ResponseEntity<?> changeUserGroup(@RequestParam("userGroupId") String userGroupId,
                                             HttpServletRequest request) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<UserGroupMenuDTO> userGroupMenus = userService.changeUserGroup(userGroupId, request.getLocale());
        OAuth2AccessToken accessToken = tokenGenerator.getAccessTokenWithUpdatedAuthority(userGroupMenus,
                                                                                          authentication);

        return ResponseEntity.ok(accessToken);
    }
}
