package com.beyontec.mol.config.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.beyontec.mol.entity.User;
import com.beyontec.mol.exception.ApplicationException;
import com.beyontec.mol.exception.ErrorCode;
import com.beyontec.mol.repository.UserRepository;

@Component
public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userDetailsService")
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}

	@Autowired
	@Qualifier("userPasswordEncoder")
	@Override
	public void setPasswordEncoder(Object passwordEncoder) {
		super.setPasswordEncoder(passwordEncoder);
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) {

		super.additionalAuthenticationChecks(userDetails, authentication);

		User user = userRepository.findByLoginId(userDetails.getUsername());

		// Validating user default role
        String defaultRole = userRepository.findUserDefaultRole(user.getUserId(), user.getAU_AUG_ID());
		if (defaultRole == null || "N".equalsIgnoreCase(defaultRole)) {
			throw new ApplicationException(ErrorCode.NO_DEFAULT_ROLES);
		}

		// Validating user default division and department
		Set<String> divnAndDept = userRepository.findUserDefaultDivision(user.getUserId());
		if (divnAndDept == null || divnAndDept.isEmpty() || !divnAndDept.contains("Y")) {
			throw new ApplicationException(ErrorCode.NO_DEFAULT_DIVISION_DEPARTMENT);
		}

		// Validating user default division and department
		long expirationDays = userRepository.findUserPwdExpiration(user.getCompanyId(), user.getPwdProfile());
		if (expirationDays <= 0) {
			throw new ApplicationException(ErrorCode.EXPIRED_PASSWORD);
		}
	}
}
