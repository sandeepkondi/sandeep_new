package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.UserGroupMenu;
import com.beyontec.mol.modal.UserGroupMenuDTO;

@Repository
public interface UserGroupMenuRepo extends JpaRepository<UserGroupMenu, Long> {

    @Query(name = "getUserGroupMenu", nativeQuery = true)
    List<UserGroupMenuDTO> getUserGroupMenu(@Param("userId") String userId,
                                            @Param("userGroupId") String userGroupId,
                                            @Param("isEngLocale") String isEngLocale);

}
