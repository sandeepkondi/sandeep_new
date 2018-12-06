package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.WorkBasketTransactionActivity;

@Repository
public interface WorkBasketTransactionActivityRepository extends JpaRepository<WorkBasketTransactionActivity, Long>{

    WorkBasketTransactionActivity findByFnolSgsId(Long fnolSgsId);

    List<WorkBasketTransactionActivity> findByAssignedUser(String user);

    @Query(value = "select * from wtds_level_a where WLA_TXN_REF = ?1 and WLA_ACT_ID = ?2 and WLA_TXN_AUG_ID = ?3", nativeQuery = true)
    List<WorkBasketTransactionActivity> findByFnolSgsIdAndActivityId(Long fnolSgsId,
                                                                     String activityId,
                                                                     String userGroupId);
}
