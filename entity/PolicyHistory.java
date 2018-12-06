package com.beyontec.mol.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.modal.ActivePolicy;
import com.beyontec.mol.modal.DashBoardCoInsurerSummary;
import com.beyontec.mol.modal.DashBoardWorkerSummary;

@Entity
@Table(name = "UHDS_LEVEL_M")
//@formatter:off
@SqlResultSetMappings({
    @SqlResultSetMapping(
                      name = "dashBoardWorkerSummaryRsMapping",
                      classes = @ConstructorResult(
                                                   targetClass = DashBoardWorkerSummary.class,
                                                   columns = {
                                                              @ColumnResult(name = "ULM_APD"              , type = Date.class),
                                                              @ColumnResult(name = "ULM_PROD_NAME"        , type = String.class),
                                                              @ColumnResult(name = "ULM_PROD_NAME_1"      , type = String.class),
                                                              @ColumnResult(name = "certificateCount"     , type = Long.class),
                                                              @ColumnResult(name = "totalPremium"         , type = BigDecimal.class),
                                                              @ColumnResult(name = "totalCoInsurerPremium", type = BigDecimal.class)
                                                   })
                      ),
    @SqlResultSetMapping(
                         name = "dashBoardCoInsurerSummaryRsMapping",
                         classes = @ConstructorResult(
                                                      targetClass = DashBoardCoInsurerSummary.class,
                                                      columns = {
                                                                 @ColumnResult(name = "ULM_PROD_NAME"         , type = String.class),
                                                                 @ColumnResult(name = "ULM_PROD_NAME_1"       , type = String.class),
                                                                 @ColumnResult(name = "ULIC_IC_NAME"          , type = String.class),
                                                                 @ColumnResult(name = "ULIC_IC_NAME_BL"       , type = String.class),
                                                                 @ColumnResult(name = "ULIC_SHARE_PREM_BC"    , type = BigDecimal.class),
                                                                 @ColumnResult(name = "ULIC_SHARE_SI_BC"      , type = BigDecimal.class),
                                                                 @ColumnResult(name = "ULIC_LEADER_FEE_AMT_BC", type = BigDecimal.class),
                                                                 @ColumnResult(name = "ULIC_RETRO_AMT_BC"     , type = BigDecimal.class),
                                                                 @ColumnResult(name = "ULIC_RETRO_SI_BC"      , type = BigDecimal.class),
                                                                 @ColumnResult(name = "ULIC_RETRO_COMM_AMT"   , type = BigDecimal.class)
                                                      })),
    @SqlResultSetMapping(
                         name = "activePolicyRsMapping",
                         classes = @ConstructorResult(
                                                      targetClass = ActivePolicy.class,
                                                      columns = {
                                                                 @ColumnResult(name = "WORKER"   , type = String.class),
                                                                 @ColumnResult(name = "WORKER_1" , type = String.class),
                                                                 @ColumnResult(name = "COUNT"    , type = Long.class),
                                                                 @ColumnResult(name = "PREMIUM"  , type = BigDecimal.class)
                                                      }))
})

@NamedNativeQueries({
                    @NamedNativeQuery(
                                      name = "getDashBoardWorkerSummarySplitUps",
                                      resultSetMapping = "dashBoardWorkerSummaryRsMapping",
                                      query = "SELECT ULM_APD, "
                                      + "             ULM_PROD_ID, "
                                      + "             ULM_PROD_NAME, "
                                      + "             ULM_PROD_NAME_1, "
                                      + "             COUNT (ULM_NO) AS certificateCount, "
                                      + "             SUM (ULM_PREM) AS totalPremium, "
                                      + "             SUM (ULM_COINS_PREM) AS totalCoInsurerPremium "
                                      + "FROM ( "
                                      + "       SELECT ULM_NO, "
                                      + "              NVL ( (SELECT SUM(ULCS_TXN_PREM) FROM UHDS_LEVEL_CS WHERE ULCS_ULC_MST_ID ='*' AND ULCS_ULM_SGS_ID = ULM_SGS_ID AND ULCS_AMND_VER_NO  = ULM_AMND_VER_NO), 0 ) ULM_PREM, "
                                      + "              (SELECT UP_PROD_ID FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) ULM_PROD_ID, "
                                      + "              (SELECT UP_PROD_NAME FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) ULM_PROD_NAME, "
                                      + "              (SELECT UP_PROD_NAME_1 FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) ULM_PROD_NAME_1, "
                                      + "              TRUNC (ULM_APD) ULM_APD, "
                                      + "              NVL ( (SELECT SUM(ULIC_SHARE_PREM_BC) FROM UHDS_LEVEL_IC WHERE ULIC_ULM_SGS_ID=ULM_SGS_ID AND ULIC_AMND_VER_NO =ULM_AMND_VER_NO), 0 ) ULM_COINS_PREM, "
                                      + "              ULM_POL_TYP "
                                      + "       FROM UHDS_LEVEL_M "
                                      + "       WHERE TRUNC(ULM_APD) BETWEEN NVL (TO_DATE(:fromDate, :dateFormat),TRUNC(ULM_APD)) AND NVL(TO_DATE(:toDate, :dateFormat),TRUNC(ULM_APD)) "
                                      + "       AND EXISTS (SELECT 1 FROM UHDS_LEVEL_RMBR WHERE ULRMB_ULM_SGS_ID = ULM_SGS_ID AND ULRMB_AMND_VER_NO = ULM_AMND_VER_NO "
                                      + "                         AND DECODE (:jobTitle, '*', '*', ULRMB_DESIG) = DECODE (:jobTitle, '*', '*', :jobTitle) "
                                      + "                         AND DECODE (:nationality, '*', '*', ULRMB_NATIONALITY) = DECODE (:nationality, '*', '*', :nationality) "
                                      + "                         AND DECODE (:gender, '*', '*', ULRMB_GENDER) = DECODE (:gender, '*', '*', :gender)) "
                                      + "       AND EXISTS (SELECT 1 FROM IDS_CERT_DTLS WHERE ICD_ULM_NO = ULM_NO AND DECODE (:industry, '*', '*', ICD_EMPL_INDUST_TYP) = DECODE (:industry, '*', '*', :industry)) "
                                      + "       AND ULM_TMPL_ID !='1' ) "
                                      + "WHERE DECODE (:workerType, '*', '*', ULM_PROD_ID) = DECODE (:workerType, '*', '*', :workerType) "
                                      + "GROUP BY ULM_APD, "
                                      + "         ULM_PROD_ID, "
                                      + "         ULM_PROD_NAME, "
                                      + "         ULM_PROD_NAME_1 "
                                      + "ORDER BY 1, 3"
                                      ),
                    @NamedNativeQuery(
                                      name = "getDashBoardCoInsurerSummarySplitUps",
                                      resultSetMapping = "dashBoardCoInsurerSummaryRsMapping",
                                      query = "SELECT ULM_PROD_ID, "
                                      + "             ULM_PROD_NAME, "
                                      + "             ULM_PROD_NAME_1, "
                                      + "             ULIC_IC_ID, "
                                      + "             ULIC_IC_NAME, "
                                      + "             ULIC_IC_NAME_BL, "
                                      + "             SUM (ULIC_SHARE_PREM_BC) ULIC_SHARE_PREM_BC, "
                                      + "             SUM (ULIC_SHARE_SI_BC) ULIC_SHARE_SI_BC, "
                                      + "             SUM (ULIC_LEADER_FEE_AMT_BC) ULIC_LEADER_FEE_AMT_BC, "
                                      + "             SUM (ULIC_RETRO_AMT_BC) ULIC_RETRO_AMT_BC, "
                                      + "             SUM (ULIC_RETRO_SI_BC) ULIC_RETRO_SI_BC, "
                                      + "             SUM (ULIC_RETRO_COMM_AMT) ULIC_RETRO_COMM_AMT "
                                      + "FROM ( "
                                      + "       SELECT ULM_NO, "
                                      + "              TRUNC(ULM_APD) ULM_APD, "
                                      + "              (SELECT UP_PROD_ID FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) ULM_PROD_ID, "
                                      + "              (SELECT UP_PROD_NAME FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) ULM_PROD_NAME, "
                                      + "              (SELECT UP_PROD_NAME_1 FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) ULM_PROD_NAME_1, "
                                      + "              ULIC_IC_ID, "
                                      + "              (SELECT UPD_NAME FROM UDS_PARTY_DTLS WHERE UPD_ID = ULIC_IC_ID AND UPD_COMP_ID = ULM_COMP_ID) ULIC_IC_NAME, "
                                      + "              (SELECT UPD_NAME_BL FROM UDS_PARTY_DTLS WHERE UPD_ID = ULIC_IC_ID AND UPD_COMP_ID = ULM_COMP_ID) ULIC_IC_NAME_BL, "
                                      + "              ULIC_SHARE_PREM_BC, "
                                      + "              ULIC_SHARE_SI_BC, "
                                      + "              ULIC_LEADER_FEE_AMT_BC,  "
                                      + "              ULIC_RETRO_AMT_BC, "
                                      + "              ULIC_RETRO_SI_BC, "
                                      + "              ULIC_RETRO_COMM_AMT "
                                      + "        FROM UHDS_LEVEL_IC,UHDS_LEVEL_M "
                                      + "        WHERE ULM_TMPL_ID !='1' "
                                      + "        AND EXISTS (SELECT 1 FROM UHDS_LEVEL_RMBR WHERE ULRMB_ULM_SGS_ID = ULM_SGS_ID AND ULRMB_AMND_VER_NO = ULM_AMND_VER_NO "
                                      + "                            AND DECODE (:jobTitle, '*', '*', ULRMB_DESIG) = DECODE (:jobTitle, '*', '*', :jobTitle) "
                                      + "                            AND DECODE (:nationality, '*', '*', ULRMB_NATIONALITY) = DECODE (:nationality, '*', '*', :nationality) "
                                      + "                            AND DECODE (:gender, '*', '*', ULRMB_GENDER) = DECODE (:gender, '*', '*', :gender)) "
                                      + "        AND EXISTS (SELECT 1 FROM IDS_CERT_DTLS WHERE ICD_ULM_NO = ULM_NO AND DECODE (:industry, '*', '*', ICD_EMPL_INDUST_TYP) = DECODE (:industry, '*', '*', :industry)) "
                                      + "        AND TRUNC(ULM_APD) BETWEEN NVL(TO_DATE(:fromDate, :dateFormat),TRUNC(ULM_APD)) AND NVL(TO_DATE(:toDate, :dateFormat),TRUNC(ULM_APD)) "
                                      + "        AND ULIC_ULM_SGS_ID = ULM_SGS_ID "
                                      + "        AND ULIC_AMND_VER_NO = ULM_AMND_VER_NO) "
                                      + "WHERE DECODE (:workerType, '*', '*', ULM_PROD_ID) = DECODE (:workerType, '*', '*', :workerType) "
                                      + "GROUP BY ULM_PROD_ID, "
                                      + "         ULM_PROD_NAME, "
                                      + "         ULM_PROD_NAME_1, "
                                      + "         ULIC_IC_ID, "
                                      + "         ULIC_IC_NAME, "
                                      + "         ULIC_IC_NAME_BL "
                                      + "ORDER BY 2, 4, 7 "
                                      ),
                    @NamedNativeQuery(
                                      name = "getActivePolicy",
                                      resultSetMapping = "activePolicyRsMapping",
                                      query = "SELECT "
                                      + "             (SELECT UP_PROD_NAME FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) Worker, "
                                      + "             (SELECT UP_PROD_NAME_1 FROM UDS_PRODUCT WHERE UP_PROD_ID = ULM_PROD_ID AND UP_COMP_ID = ULM_COMP_ID) Worker_1, "
                                      + "             COUNT (ULM_NO) Count, "
                                      + "             SUM ((SELECT SUM(ULCS_TXN_PREM) FROM UPDS_LEVEL_CS WHERE ULCS_ULC_MST_ID ='*' AND ULCS_ULM_SGS_ID = ULM_SGS_ID AND ULCS_AMND_VER_NO  = ULM_AMND_VER_NO)) Premium "
                                      + "FROM UPDS_LEVEL_M "
                                      + "WHERE ULM_BTYP_ID = 'C' "
                                      + "GROUP BY ULM_COMP_ID, ULM_PROD_ID"
                                      )
})
// @formatter:on
@EntityListeners(AuditingEntityListener.class)
public class PolicyHistory extends PolicyBase {

    @Embeddable
    private static class PolicyHistoryId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "ULM_SGS_ID") private Long sgsId;
        @Column(name = "ULM_AMND_VER_NO") private Long amendmentVersionNumber;

        public Long getSgsId() {
            return sgsId;
        }

        public void setSgsId(Long sgsId) {
            this.sgsId = sgsId;
        }

        public Long getAmendmentVersionNumber() {
            return amendmentVersionNumber;
        }

        public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
            this.amendmentVersionNumber = amendmentVersionNumber;
        }
    }

    @EmbeddedId private PolicyHistoryId id;

    public PolicyHistoryId getId() {
        if (id != null) { return id; }
        id = new PolicyHistoryId();
        return id;
    }

    public Long getSgsId() {
        return getId().getSgsId();
    }

    public void setSgsId(Long sgsId) {
        getId().setSgsId(sgsId);
    }

    public Long getAmendmentVersionNumber() {
        return getId().getAmendmentVersionNumber();
    }

    public void setAmendmentVersionNumber(Long amendmentVersionNumber) {
        getId().setAmendmentVersionNumber(amendmentVersionNumber);
    }

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_I;
    }
}
