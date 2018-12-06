package com.beyontec.mol.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.beyontec.mol.entity.User;
import com.beyontec.mol.entity.UserGroup;
import com.beyontec.mol.entity.UserRole;
import com.beyontec.mol.modal.UserGroupMenuDTO;
import com.beyontec.mol.repository.UserGroupMenuRepo;
import com.beyontec.mol.repository.UserRepository;
import com.beyontec.mol.util.AppConstants;

@Service("userDetailsService")
public class UserSecurityDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
    private UserGroupMenuRepo userGroupMenuRepo;

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByLoginId(username);
		if (null == user) {
			throw new UsernameNotFoundException(String.format("Invalid Credentials: User %s does not exist", username));
		}

        String defaultUserGroupId = "";
        for (UserGroup userGroup : user.getUserGroups()) {
            for (UserRole userRole : userGroup.getUserRoles()) {
                if (StringUtils.equals(userRole.getUserId(), user.getUserId())
                    && "Y".equalsIgnoreCase(userRole.getIsDefault())) {
                    defaultUserGroupId = userRole.getUserGroupid();
                }
            }
        }
		Set<GrantedAuthority> authorities = generateAuthorities(user.getUserId(), defaultUserGroupId);
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLoginId(),
				user.getPassword(), authorities);
		return userDetails;
	}

    private Set<GrantedAuthority> generateAuthorities(String userId, String userGroupId) {

        String isEngLocale = LocaleContextHolder.getLocale().getLanguage().equals(AppConstants.ENGLISH) ? "true"
                                                                                                        : "false";
        List<UserGroupMenuDTO> menu = userGroupMenuRepo.getUserGroupMenu(userId,
                                                                         userGroupId,
                                                                         isEngLocale);
        Set<String> userPermissionList = new HashSet<String>();
        for (UserGroupMenuDTO userMenu : menu) {
            String permission = userMenu.getFunctionId();
            userPermissionList.add(permission);
//            if ("Y".equalsIgnoreCase(userMenu.getCreate())) {
//                userPermissionList.add(permission + "_CREATE");
//            }
//
//            if ("Y".equalsIgnoreCase(userMenu.getDelete())) {
//                userPermissionList.add(permission + "_DELETE");
//            }
//
//            if ("Y".equalsIgnoreCase(userMenu.getEdit())) {
//                userPermissionList.add(permission + "_UPDATE");
//            }
//
//            if ("Y".equalsIgnoreCase(userMenu.getView())) {
//                userPermissionList.add(permission + "_READ");
//            }
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        for (String permission : userPermissionList) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }

        return authorities;
    }
}
