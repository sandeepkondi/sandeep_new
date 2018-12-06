package com.beyontec.mol.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginId(String loginId);

    @Query(value = "SELECT AU_ID FROM ADS_USER WHERE AU_LOGIN_ID = ?1", nativeQuery = true)
	String findAuIdByloginId(String loginId);

    @Query(value = "SELECT AUR_DFLT_YN FROM ADS_USER_ROLES WHERE AUR_AU_ID = ?1 AND AUR_AUG_ID = ?2", nativeQuery = true)
    String findUserDefaultRole(String userId, String userGroupId);

    @Query(value = "SELECT AUDD_DEFAULT_YN FROM ads_user_divn_dept WHERE AUDD_AU_ID = ?1", nativeQuery = true)
	Set<String> findUserDefaultDivision(String userId);

    @Query(value = "SELECT SPP_EXP_DAYS FROM sds_pwd_profile WHERE SPP_COMP_ID = ?1 AND  SPP_ID = ?2", nativeQuery = true)
	long findUserPwdExpiration(String companyId, String profileId);

    void deleteByLoginId(String loginId);
}
