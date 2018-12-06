package com.beyontec.mol.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.config.security.PasswordEncoderConfig;
import com.beyontec.mol.entity.User;
import com.beyontec.mol.entity.UserGroup;
import com.beyontec.mol.entity.UserRole;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.exception.ValidationException;
import com.beyontec.mol.modal.Password;
import com.beyontec.mol.modal.UserDTO;
import com.beyontec.mol.modal.UserGroupDTO;
import com.beyontec.mol.modal.UserGroupMenuDTO;
import com.beyontec.mol.repository.UserGroupMenuRepo;
import com.beyontec.mol.repository.UserRepository;
import com.beyontec.mol.util.AppConstants;
import com.beyontec.mol.util.JWTUtil;

@Service
public class UserService extends BaseService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupMenuRepo userGroupMenuRepo;

    @Autowired
    private PasswordEncoderConfig passwordEncoderConfig;

    @Transactional(readOnly = true)
    public UserDTO findUserByLoginId(String loginId) {

        User userDetails = userRepository.findByLoginId(loginId);

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);

        Set<UserGroupDTO> userGroupDTOList = new HashSet<>();
        List<UserGroupMenuDTO> userMenu = new ArrayList<>();
        String defaultUserGroupId = "";
        for (UserGroup userGroup : userDTO.getUserGroups()) {
            UserGroupDTO userGroupDTO = modelMapper.map(userGroup, UserGroupDTO.class);
            for (UserRole userRole : userGroup.getUserRoles()) {
                if (StringUtils.equals(userRole.getUserId(), userDetails.getUserId())) {
                    userGroupDTO.setIsDefault(userRole.getIsDefault());
                    if (userRole.getIsDefault().equals("Y")) {
                        defaultUserGroupId = userRole.getUserGroupid();
                    }
                }
            }
            userGroupDTOList.add(userGroupDTO);
        }
        String isEngLocale = LocaleContextHolder.getLocale().getLanguage().equals(AppConstants.ENGLISH) ? "true" : "false";
        if (StringUtils.isNotEmpty(defaultUserGroupId)) {
            userMenu = userGroupMenuRepo.getUserGroupMenu(userDetails.getUserId(),
                                                          defaultUserGroupId, isEngLocale);
        }
        userDTO.setUserMenu(userMenu);
        userDTO.setUserGroupIdAndName(userGroupDTOList);
        return userDTO;
    }

    @Transactional
	public User resetPassword(Password password) {

        User rpUser = userRepository.findByLoginId(password.getLoginId());
        if (rpUser == null) {
            throw new ValidationException(ErrorCode.USER_NOT_FOUND);
        }

        rpUser.setPassword(passwordEncoderConfig.userPasswordEncoder().encode(password.getNewPassword()));
        rpUser.setLoginStatus("Y");
        return userRepository.save(rpUser);
    }

    @Transactional
    public List<UserGroupMenuDTO> changeUserGroup(String userGroupId, Locale locale) {

        if (StringUtils.isEmpty(userGroupId)) {
            throw new ValidationException(ErrorCode.USER_GROUP_ID_REQUIRED);
        }
        String isEngLocale = locale.getLanguage().equals(AppConstants.ENGLISH) ? "true" : "false";
        Map<String, List<UserGroupMenuDTO>> response = new HashMap<>();
        List<UserGroupMenuDTO> menu = invokeRepo(() -> userGroupMenuRepo.getUserGroupMenu(JWTUtil.getUserId(),
                                                                                          userGroupId,
                                                                                          isEngLocale),
                                                 " userGroupMenuRepo.getUserGroupMenu()");
        return menu;
    }
}
