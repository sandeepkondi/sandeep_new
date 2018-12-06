package com.beyontec.mol.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.PolicyHistory;
import com.beyontec.mol.modal.ActivePolicy;
import com.beyontec.mol.modal.DashBoardCoInsurerSummary;
import com.beyontec.mol.modal.DashBoardWorkerSummary;

@Repository
public interface PolicyHistoryRepository extends PolicyBaseRepository<PolicyHistory> {

    @Query(value = "SELECT * FROM UHDS_LEVEL_M "
                   + "WHERE (ULM_SGS_ID, ULM_AMND_VER_NO) = (SELECT ULM_SGS_ID, MAX(ULM_AMND_VER_NO) FROM UHDS_LEVEL_M, UHDS_LEVEL_R "
                                                           + "WHERE ULM_SGS_ID = ULR_ULM_SGS_ID "
                                                           + "AND ULR_RISK_TYP = :riskType AND ULM_BTYP_ID = 'O'"
                                                           + "AND :visaApprovalDate BETWEEN NVL (ULM_AMND_FMD, ULM_FMD) AND NVL(ULM_AMND_TOD, ULM_TOD)	"
                                                           + "GROUP BY ULM_SGS_ID) "
                   + "AND ULM_BTYP_ID = 'O' and ULM_STATUS = 'CTP'", nativeQuery = true)
    PolicyHistory findMasterPolicy(@Param("riskType") String riskType,
                                   @Param("visaApprovalDate") Date visaApprovalDate);

    @Query(value = "SELECT UD_DIVN_DISP_NAME AS DIV_EN, UD_DIVN_NAME_1 AS DIV_AR, UDD_DEPT_DISP_NAME AS DEPT_EN, UDD_DEPT_DISP_NAME_1 AS DEPT_AR FROM UDS_DIVISION DIV, UDS_DEPT_DTL DEPT "
                   + "WHERE DIV.UD_DIVN_ID = DEPT.UDD_UD_DIVN_ID AND DIV.UD_DIVN_ID = :divId AND DEPT.UDD_DEPT_ID = :deptId AND DEPT.UDD_APPRV_STATUS = 'A'", nativeQuery = true)
    List<Object[]> getDivDeptName(@Param("divId") String divId, @Param("deptId") String deptId);

    @Query(name = "getDashBoardWorkerSummarySplitUps", nativeQuery = true)
    List<DashBoardWorkerSummary> getDashBoardWorkerSummarySplitUps(@Param("dateFormat") String dateFormat,
                                                                   @Param("fromDate") String fromDate,
                                                                   @Param("toDate") String toDate,
                                                                   @Param("workerType") String workerType,
                                                                   @Param("jobTitle") String jobTitle,
                                                                   @Param("nationality") String nationality,
                                                                   @Param("gender") String gender,
                                                                   @Param("industry") String industry);

    @Query(name = "getDashBoardCoInsurerSummarySplitUps", nativeQuery = true)
    List<DashBoardCoInsurerSummary> getDashBoardCoInsurerSummarySplitUps(@Param("dateFormat") String dateFormat,
                                                                         @Param("fromDate") String fromDate,
                                                                         @Param("toDate") String toDate,
                                                                         @Param("workerType") String workerType,
                                                                         @Param("jobTitle") String jobTitle,
                                                                         @Param("nationality") String nationality,
                                                                         @Param("gender") String gender,
                                                                         @Param("industry") String industry);

    @Query(name = "getActivePolicy", nativeQuery = true)
    List<ActivePolicy> getActivePolicy();
}