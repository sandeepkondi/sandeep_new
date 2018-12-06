package com.beyontec.mol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.modal.InsurerProcessDTO;
import com.beyontec.mol.modal.PoolInsurerClaimDetailsDTO;
import com.beyontec.mol.modal.PoolInsurerCountDTO;
import com.beyontec.mol.modal.PoolInsurerCrtExportDTO;
import com.beyontec.mol.modal.PoolInsurerIndividualCrtExportDTO;
import com.beyontec.mol.modal.PoolInsurerUwDetailsDTO;

@Entity
@Table(name = "BSDS_BATCH_HDR")

@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "populateBatchDetails", procedureName = "BLK_BATCH_PROCESS.BLP_POP_HDR", parameters = {
                                                                                                                                                         @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_BATCH_ID", type = Long.class) }),
                               @NamedStoredProcedureQuery(name = "populateUwAndClaimsApproveDetails", procedureName = "BLK_BATCH_PROCESS.BLP_BATCH_APPROVAL", parameters = {
                                                                                                                                                                             @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_BATCH_ID", type = Long.class),
                                                                                                                                                                             @StoredProcedureParameter(mode = ParameterMode.IN, name = "P_USER_ID", type = String.class) })
})

@SqlResultSetMappings({
                        @SqlResultSetMapping(name = "getPoolInsurerCountMapping", classes = @ConstructorResult(targetClass = PoolInsurerCountDTO.class, columns = {
                                                                                                                                                                    @ColumnResult(name = "BBP_PROD_ID", type = Long.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_PROD_NAME", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_POL_COUNT", type = Long.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_CLM_COUNT", type = Long.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_PREM_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_CLM_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_PREM_CURR_ID", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "BBP_CLM_CURR_ID", type = String.class)

                        })),
                        @SqlResultSetMapping(name = "underwritingDataRsMapping", classes = @ConstructorResult(targetClass = PoolInsurerUwDetailsDTO.class, columns = {
                                                                                                                                                                       @ColumnResult(name = "BBD_PARTY_ID", type = Long.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_PARTY_NAME", type = String.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_SHARE_RATE", type = Long.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_SHARE_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_SHARE_VAT_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_FEE_RATE", type = Long.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_FEE_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_FEE_VAT_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_RETRO_RATE", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_RETRO_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_RETRO_VAT_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_RETRO_COMM_RATE", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_RETRO_COMM_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_RETRO_COMM_VAT_AMT", type = Double.class),
                                                                                                                                                                       @ColumnResult(name = "PRODUCT_ID", type = Long.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_ACNT_REF_NO_1", type = String.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_ACNT_REF_NO_2", type = String.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_ACNT_REF_NO_3", type = String.class),
                                                                                                                                                                       @ColumnResult(name = "BBD_ACNT_REF_NO_4", type = String.class),
                                                                                                                                                                       @ColumnResult(name = "BBP_PREM_CURR_ID", type = String.class)

                        })),
                        @SqlResultSetMapping(name = "claimDataRsMapping", classes = @ConstructorResult(targetClass = PoolInsurerClaimDetailsDTO.class, columns = {
                                                                                                                                                                   @ColumnResult(name = "BBD_PARTY_ID", type = Long.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_PARTY_NAME", type = String.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_SHARE_RATE", type = Long.class),
                                                                                                                                                                   @ColumnResult(name = "BBP_CLM_CURR_ID", type = String.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_SHARE_AMT", type = Double.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_RETRO_RATE", type = Double.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_RETRO_AMT", type = Double.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_PM_AMT", type = Double.class),
                                                                                                                                                                   @ColumnResult(name = "PRODUCT_ID", type = Long.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_ACNT_REF_NO_1", type = String.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_ACNT_REF_NO_3", type = String.class),
                                                                                                                                                                   @ColumnResult(name = "BBD_APD", type = Date.class)

                        })),
                        @SqlResultSetMapping(name = "insurerProcessRsMapping", classes = @ConstructorResult(targetClass = InsurerProcessDTO.class, columns = {
                                                                                                                                                               @ColumnResult(name = "BATCH_ID", type = String.class),
                                                                                                                                                               @ColumnResult(name = "PROCESS_ID", type = String.class),
                                                                                                                                                               @ColumnResult(name = "PROCESS_NAME", type = String.class),
                                                                                                                                                               @ColumnResult(name = "FROM_DATE", type = Date.class),
                                                                                                                                                               @ColumnResult(name = "TO_DATE", type = Date.class),
                                                                                                                                                               @ColumnResult(name = "STATUS", type = String.class),
                                                                                                                                                               @ColumnResult(name = "STATUS_DESC", type = String.class)
                        })),
                        @SqlResultSetMapping(name = "getOverallCertsMapping", classes = @ConstructorResult(targetClass = PoolInsurerCrtExportDTO.class, columns = {
                                                                                                                                                                    @ColumnResult(name = "ULM_NO", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "ULM_AMND_NO", type = Long.class),
                                                                                                                                                                    @ColumnResult(name = "ULM_CNAME", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "ULM_INSRD_NAME", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "ULM_FMD", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "ULM_TOD", type = String.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_SOURCE_PREM", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_OUR_PREM", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_SHARE_PREM", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_SHARE_PREM_VAT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_LEADER_FEE_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_LEADER_FEE_VAT_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_RETRO_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_RETRO_VAT_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_RETRO_COMM_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_RETRO_COMM_VAT_AMT", type = Double.class),
                                                                                                                                                                    @ColumnResult(name = "ULIC_NET_AMT", type = Double.class)

                        })),
                        @SqlResultSetMapping(name = "getParticipantCertificatesMapping", classes = @ConstructorResult(targetClass = PoolInsurerIndividualCrtExportDTO.class, columns = {
                                                                                                                                                                                         @ColumnResult(name = "ULM_NO", type = String.class),
                                                                                                                                                                                         @ColumnResult(name = "ULM_AMND_NO", type = Long.class),
                                                                                                                                                                                         @ColumnResult(name = "ULM_CNAME", type = String.class),
                                                                                                                                                                                         @ColumnResult(name = "ULM_INSRD_NAME", type = String.class),
                                                                                                                                                                                         @ColumnResult(name = "ULM_FMD", type = String.class),
                                                                                                                                                                                         @ColumnResult(name = "ULM_TOD", type = String.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_SOURCE_PREM", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_OUR_PREM", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_SHARE_PREM", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_SHARE_PREM_VAT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_LEADER_FEE_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_LEADER_FEE_VAT_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_RETRO_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_RETRO_VAT_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_RETRO_COMM_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_RETRO_COMM_VAT_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "ULIC_NET_AMT", type = Double.class),
                                                                                                                                                                                         @ColumnResult(name = "UPD_NAME", type = String.class)

                        })) })

@NamedNativeQueries({
                      @NamedNativeQuery(name = "getPoolInsurerCount", resultSetMapping = "getPoolInsurerCountMapping", query = "SELECT BBP_PROD_ID, "
                                                                                                                               + "(SELECT UP_PROD_NAME FROM UDS_PRODUCT WHERE UP_PROD_ID = BBP_PROD_ID AND UP_COMP_ID = BBP_COMP_ID) BBP_PROD_NAME, "
                                                                                                                               + "BBP_POL_COUNT, "
                                                                                                                               + "BBP_CLM_COUNT, "
                                                                                                                               + "BBP_PREM_AMT, "
                                                                                                                               + "BBP_CLM_AMT, "
                                                                                                                               + "BBP_PREM_CURR_ID, "
                                                                                                                               + "BBP_CLM_CURR_ID "
                                                                                                                               + "FROM BSDS_BATCH_PROD "
                                                                                                                               + "WHERE BBP_BBH_SGS_ID = :batchId "
                                                                                                                               + "ORDER BY BBP_PROD_ID "),
                      @NamedNativeQuery(name = "getPoolInsurerUnderwritingData", resultSetMapping = "underwritingDataRsMapping", query = "SELECT NULL BBD_PARTY_ID, "
                                                                                                                                         + "'Our Share' BBD_PARTY_NAME, "
                                                                                                                                         + "(SELECT 100 - SUM (BBD_SHARE_RATE) FROM BSDS_BATCH_DTL WHERE BBD_BBH_SGS_ID = BBP_BBH_SGS_ID AND BBD_PROD_ID = BBP_PROD_ID AND BBD_TRAN_TYP = '01') BBD_SHARE_RATE, "
                                                                                                                                         + "(SELECT BBP_PREM_AMT - SUM (BBD_SHARE_AMT) FROM BSDS_BATCH_DTL WHERE BBD_BBH_SGS_ID = BBP_BBH_SGS_ID AND BBD_PROD_ID = BBP_PROD_ID AND BBD_TRAN_TYP = '01') BBD_SHARE_AMT, "
                                                                                                                                         + "NULL BBD_SHARE_VAT_AMT, "
                                                                                                                                         + "NULL  BBD_FEE_RATE, "
                                                                                                                                         + "NULL  BBD_FEE_AMT, "
                                                                                                                                         + "NULL  BBD_FEE_VAT_AMT, "
                                                                                                                                         + "NULL  BBD_RETRO_RATE, "
                                                                                                                                         + "NULL  BBD_RETRO_AMT, "
                                                                                                                                         + "NULL  BBD_RETRO_VAT_AMT, "
                                                                                                                                         + "NULL BBD_RETRO_COMM_RATE, "
                                                                                                                                         + "NULL BBD_RETRO_COMM_AMT, "
                                                                                                                                         + "NULL BBD_RETRO_COMM_VAT_AMT, "
                                                                                                                                         + "BBP_PROD_ID PRODUCT_ID, "
                                                                                                                                         + "BBP_ACNT_REF_NO_1 BBD_ACNT_REF_NO_1, "
                                                                                                                                         + "NULL BBD_ACNT_REF_NO_2, "
                                                                                                                                         + "NULL BBD_ACNT_REF_NO_3, "
                                                                                                                                         + "NULL BBD_ACNT_REF_NO_4, "
                                                                                                                                         + "(SELECT TRUNC(BBH_APD) FROM BSDS_BATCH_HDR WHERE BBH_SGS_ID = BBP_BBH_SGS_ID) BBD_APD, "
                                                                                                                                         + "BBP_PREM_CURR_ID "
                                                                                                                                         + "FROM BSDS_BATCH_PROD "
                                                                                                                                         + "WHERE BBP_BBH_SGS_ID = :batchId "
                                                                                                                                         + "AND BBP_PROD_ID = :prodId "
                                                                                                                                         + "UNION ALL "
                                                                                                                                         + "SELECT BBD_PARTY_ID, "
                                                                                                                                         + "(SELECT UPD_NAME FROM UDS_PARTY_DTLS WHERE UPD_ID = BBD_PARTY_ID) BBD_PARTY_NAME, BBD_SHARE_RATE, "
                                                                                                                                         + "BBD_SHARE_AMT, "
                                                                                                                                         + "BBD_SHARE_VAT_AMT, "
                                                                                                                                         + "BBD_FEE_RATE, BBD_FEE_AMT, "
                                                                                                                                         + "BBD_FEE_VAT_AMT, "
                                                                                                                                         + "BBD_RETRO_RATE, "
                                                                                                                                         + "BBD_RETRO_AMT, "
                                                                                                                                         + "BBD_RETRO_VAT_AMT, "
                                                                                                                                         + "BBD_RETRO_COMM_RATE, "
                                                                                                                                         + "BBD_RETRO_COMM_AMT, "
                                                                                                                                         + "BBD_RETRO_COMM_VAT_AMT, "
                                                                                                                                         + "BBD_PROD_ID PRODUCT_ID, "
                                                                                                                                         + "BBD_ACNT_REF_NO_1, "
                                                                                                                                         + "BBD_ACNT_REF_NO_2, "
                                                                                                                                         + "BBD_ACNT_REF_NO_3, "
                                                                                                                                         + "BBD_ACNT_REF_NO_4, "
                                                                                                                                         + "(SELECT TRUNC(BBH_APD) FROM BSDS_BATCH_HDR WHERE BBH_SGS_ID = BBD_BBH_SGS_ID) BBD_APD, "
                                                                                                                                         + "(SELECT BBP_PREM_CURR_ID FROM BSDS_BATCH_PROD WHERE BBP_BBH_SGS_ID = BBD_BBH_SGS_ID AND BBP_PROD_ID = BBD_PROD_ID) BBP_PREM_CURR_ID "
                                                                                                                                         + "FROM BSDS_BATCH_DTL "
                                                                                                                                         + "WHERE BBD_BBH_SGS_ID = :batchId "
                                                                                                                                         + "AND BBD_TRAN_TYP = :transactionType "
                                                                                                                                         + "AND BBD_PROD_ID = :prodId "
                                                                                                                                         + "ORDER BY 1"),
                      @NamedNativeQuery(name = "getPoolInsurerClaimData", resultSetMapping = "claimDataRsMapping", query = "SELECT NULL BBD_PARTY_ID, "
                                                                                                                           + "'Our Share' BBD_PARTY_NAME, "
                                                                                                                           + "(SELECT 100 - SUM (BBD_SHARE_RATE) FROM BSDS_BATCH_DTL WHERE BBD_BBH_SGS_ID = BBP_BBH_SGS_ID AND BBD_PROD_ID = BBP_PROD_ID AND BBD_TRAN_TYP = '02') BBD_SHARE_RATE, "
                                                                                                                           + "BBP_CLM_CURR_ID, "
                                                                                                                           + "(SELECT BBP_CLM_AMT - SUM (BBD_SHARE_AMT) FROM BSDS_BATCH_DTL WHERE BBD_BBH_SGS_ID = BBP_BBH_SGS_ID AND BBD_PROD_ID = BBP_PROD_ID AND BBD_TRAN_TYP = '02') BBD_SHARE_AMT, "
                                                                                                                           + "NULL BBD_RETRO_RATE, "
                                                                                                                           + "NULL BBD_RETRO_AMT, "
                                                                                                                           + "NULL BBD_PM_AMT, "
                                                                                                                           + "BBP_PROD_ID PRODUCT_ID, "
                                                                                                                           + "BBP_ACNT_REF_NO_2 BBD_ACNT_REF_NO_1, "
                                                                                                                           + "NULL BBD_ACNT_REF_NO_3, "
                                                                                                                           + "(SELECT TRUNC(BBH_APD) FROM BSDS_BATCH_HDR WHERE BBH_SGS_ID = BBP_BBH_SGS_ID) BBD_APD "
                                                                                                                           + "FROM BSDS_BATCH_PROD "
                                                                                                                           + "WHERE BBP_BBH_SGS_ID = :batchId "
                                                                                                                           + "AND BBP_PROD_ID = :prodId "
                                                                                                                           + "UNION ALL "
                                                                                                                           + "SELECT BBD_PARTY_ID, "
                                                                                                                           + "(SELECT UPD_NAME FROM UDS_PARTY_DTLS WHERE UPD_ID = BBD_PARTY_ID) BBD_PARTY_NAME, "
                                                                                                                           + "BBD_SHARE_RATE, "
                                                                                                                           + "(SELECT BBP_CLM_CURR_ID FROM BSDS_BATCH_PROD WHERE BBP_BBH_SGS_ID = BBD_BBH_SGS_ID AND BBP_PROD_ID = BBD_PROD_ID) BBP_PREM_CURR_ID, "
                                                                                                                           + "BBD_SHARE_AMT, "
                                                                                                                           + "BBD_RETRO_RATE, "
                                                                                                                           + "BBD_RETRO_AMT, "
                                                                                                                           + "BBD_SHARE_AMT - BBD_RETRO_AMT BBD_PM_AMT, "
                                                                                                                           + "BBD_PROD_ID PRODUCT_ID, "
                                                                                                                           + "BBD_ACNT_REF_NO_1, "
                                                                                                                           + "BBD_ACNT_REF_NO_3, "
                                                                                                                           + "(SELECT TRUNC(BBH_APD) FROM BSDS_BATCH_HDR WHERE BBH_SGS_ID = BBD_BBH_SGS_ID) BBD_APD "
                                                                                                                           + "FROM BSDS_BATCH_DTL "
                                                                                                                           + "WHERE BBD_BBH_SGS_ID = :batchId "
                                                                                                                           + "AND BBD_TRAN_TYP = :transactionType "
                                                                                                                           + "AND BBD_PROD_ID = :prodId "
                                                                                                                           + "ORDER BY 1"),
                      @NamedNativeQuery(name = "getInsurerProcess", resultSetMapping = "insurerProcessRsMapping", query = "SELECT BBH_SGS_ID BATCH_ID, "
                                                                                                                          + "BBH_TYP PROCESS_ID, "
                                                                                                                          + "CASE "
                                                                                                                          + "WHEN :isEngLocale = 'true' "
                                                                                                                          + "THEN (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID = BBH_TYP AND UID_ID_TYP = 'BBH_TYP') "
                                                                                                                          + "ELSE (SELECT UID_DESC_1 FROM UDS_ID_DEFN WHERE UID_ID = BBH_TYP AND UID_ID_TYP = 'BBH_TYP') "
                                                                                                                          + "END AS PROCESS_NAME, "
                                                                                                                          + "BBH_FMD FROM_DATE, "
                                                                                                                          + "BBH_TOD TO_DATE, "
                                                                                                                          + "BBH_STATUS STATUS, "
                                                                                                                          + "CASE "
                                                                                                                          + "WHEN :isEngLocale = 'true' "
                                                                                                                          + "THEN (SELECT UID_DESC FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'BBH_STATUS' AND UID_ID = BBH_STATUS) "
                                                                                                                          + "ELSE (SELECT UID_DESC_1 FROM UDS_ID_DEFN WHERE UID_ID_TYP = 'BBH_STATUS' AND UID_ID = BBH_STATUS) "
                                                                                                                          + "END AS STATUS_DESC "
                                                                                                                          + "FROM BSDS_BATCH_HDR "
                                                                                                                          + "WHERE (:fromDate IS NULL OR TRUNC(BBH_FMD) = TO_DATE(:fromDate, :dateFormat)) "
                                                                                                                          + "AND (:toDate IS NULL OR TRUNC(BBH_TOD) = TO_DATE(:toDate, :dateFormat)) "
                                                                                                                          + "AND (:processId IS NULL OR BBH_TYP = :processId) "
                                                                                                                          + "AND (:batchId IS NULL OR UPPER(BBH_SGS_ID) LIKE UPPER (CONCAT('%', CONCAT(:batchId, '%')))) "
                                                                                                                          + "AND (:status IS NULL OR UPPER(BBH_STATUS) = UPPER(:status)) "),
                      @NamedNativeQuery(name = "getOverallCerts", resultSetMapping = "getOverallCertsMapping", query = "SELECT      ULM_NO, "
                                                                                                                       + "            ULM_AMND_NO, "
                                                                                                                       + "            ULM_CNAME, "
                                                                                                                       + "            ULM_INSRD_NAME, "
                                                                                                                       + "            TO_CHAR (ULM_FMD, :dateFormat) ULM_FMD, "
                                                                                                                       + "            TO_CHAR (ULM_TOD, :dateFormat) ULM_TOD, "
                                                                                                                       + "            ULIC_SOURCE_PREM, "
                                                                                                                       + "            ULIC_SOURCE_PREM - SUM (ULIC_SHARE_PREM) ULIC_OUR_PREM, "
                                                                                                                       + "            SUM (ULIC_SHARE_PREM) ULIC_SHARE_PREM, "
                                                                                                                       + "            SUM (ULIC_SHARE_PREM_VAT) ULIC_SHARE_PREM_VAT, "
                                                                                                                       + "            SUM (ULIC_LEADER_FEE_AMT) ULIC_LEADER_FEE_AMT, "
                                                                                                                       + "            SUM (ULIC_LEADER_FEE_VAT_AMT) ULIC_LEADER_FEE_VAT_AMT, "
                                                                                                                       + "            SUM (ULIC_RETRO_AMT) ULIC_RETRO_AMT, "
                                                                                                                       + "            SUM (ULIC_RETRO_VAT_AMT) ULIC_RETRO_VAT_AMT, "
                                                                                                                       + "            SUM (ULIC_RETRO_COMM_AMT) ULIC_RETRO_COMM_AMT, "
                                                                                                                       + "            SUM (ULIC_RETRO_COMM_VAT_AMT) ULIC_RETRO_COMM_VAT_AMT, "
                                                                                                                       + "            ULIC_SOURCE_PREM - SUM (ULIC_SHARE_PREM) + SUM (ULIC_LEADER_FEE_AMT) + "
                                                                                                                       + "            SUM (ULIC_RETRO_AMT) - SUM (ULIC_RETRO_COMM_AMT) ULIC_NET_AMT "
                                                                                                                       + "FROM        UHDS_LEVEL_M, "
                                                                                                                       + "            UHDS_LEVEL_IC "
                                                                                                                       + "WHERE       ULM_BILL_BATCH_ID = :batchId "
                                                                                                                       + "AND         ULM_PROD_ID = :productId "
                                                                                                                       + "AND         ULM_SGS_ID = ULIC_ULM_SGS_ID "
                                                                                                                       + "AND         ULM_AMND_VER_NO = ULIC_AMND_VER_NO "
                                                                                                                       + "GROUP BY    ULM_NO, "
                                                                                                                       + "            ULM_AMND_NO, "
                                                                                                                       + "            ULM_CNAME, "
                                                                                                                       + "            ULM_INSRD_NAME, "
                                                                                                                       + "            ULM_FMD, "
                                                                                                                       + "            ULM_TOD, "
                                                                                                                       + "            ULIC_SOURCE_PREM, "
                                                                                                                       + "            ULM_AMND_VER_NO, "
                                                                                                                       + "            ULM_SGS_ID "
                                                                                                                       + "ORDER BY    ULM_SGS_ID, ULM_AMND_VER_NO"),
                      @NamedNativeQuery(name = "getParticipantCertificates", resultSetMapping = "getParticipantCertificatesMapping", query = "SELECT      (SELECT UPD_NAME FROM UDS_PARTY_DTLS WHERE UPD_ID = ULIC_IC_ID) UPD_NAME, "
                                                                                                                                             + "            ULM_NO, "
                                                                                                                                             + "            ULM_AMND_NO, "
                                                                                                                                             + "            ULM_CNAME, "
                                                                                                                                             + "            ULM_INSRD_NAME, "
                                                                                                                                             + "            TO_CHAR (ULM_FMD, :dateFormat) ULM_FMD, "
                                                                                                                                             + "            TO_CHAR (ULM_TOD, :dateFormat) ULM_TOD, "
                                                                                                                                             + "            ULIC_SOURCE_PREM, "
                                                                                                                                             + "            ULIC_SOURCE_PREM -  (ULIC_SHARE_PREM) ULIC_OUR_PREM, "
                                                                                                                                             + "             (ULIC_SHARE_PREM) ULIC_SHARE_PREM, "
                                                                                                                                             + "             (ULIC_SHARE_PREM_VAT) ULIC_SHARE_PREM_VAT, "
                                                                                                                                             + "             (ULIC_LEADER_FEE_AMT) ULIC_LEADER_FEE_AMT, "
                                                                                                                                             + "             (ULIC_LEADER_FEE_VAT_AMT) ULIC_LEADER_FEE_VAT_AMT, "
                                                                                                                                             + "             (ULIC_RETRO_AMT) ULIC_RETRO_AMT, "
                                                                                                                                             + "             (ULIC_RETRO_VAT_AMT) ULIC_RETRO_VAT_AMT, "
                                                                                                                                             + "             (ULIC_RETRO_COMM_AMT) ULIC_RETRO_COMM_AMT, "
                                                                                                                                             + "             (ULIC_RETRO_COMM_VAT_AMT) ULIC_RETRO_COMM_VAT_AMT, "
                                                                                                                                             + "            ULIC_SOURCE_PREM -  (ULIC_SHARE_PREM) +  (ULIC_LEADER_FEE_AMT) + "
                                                                                                                                             + "             (ULIC_RETRO_AMT) -  (ULIC_RETRO_COMM_AMT) ULIC_NET_AMT "
                                                                                                                                             + "FROM        UHDS_LEVEL_M, "
                                                                                                                                             + "            UHDS_LEVEL_IC "
                                                                                                                                             + "WHERE       ULM_BILL_BATCH_ID = :batchId "
                                                                                                                                             + "AND         ULM_PROD_ID = :productId "
                                                                                                                                             + "AND         ULM_SGS_ID = ULIC_ULM_SGS_ID "
                                                                                                                                             + "AND         ULM_AMND_VER_NO = ULIC_AMND_VER_NO "
                                                                                                                                             + "AND         ULIC_IC_ID = :partyId "
                                                                                                                                             + "ORDER BY    ULM_SGS_ID, ULM_AMND_VER_NO") })

@EntityListeners(AuditingEntityListener.class)
public class BsdsBatchHdr {

    @Id @Column(name = "BBH_SGS_ID") @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sgs_id_generator") @SequenceGenerator(name = "sgs_id_generator", sequenceName = " SEQ_ICD_SGS_ID_01", allocationSize = 1) private long bbhSgsId;
    @Column(name = "BBH_TYP") private String type;
    @Column(name = "BBH_FMD") private Date fromDate;
    @Column(name = "BBH_CRD") private Date createdDate;
    @Column(name = "BBH_TOD") private Date toDate;
    @Column(name = "BBH_CUST_CATG_ID") private String customerCategoryId;
    @Column(name = "BBH_CUST_ID") private String customerId;
    @Column(name = "BBH_TRAN_DT") private Date transactionDate;
    @Column(name = "BBH_APU") private String aprroverdUser;
    @Column(name = "BBH_CRU") private String createdUser;
    @Column(name = "BBH_APD") private Date approvedDate;
    @Column(name = "BBH_DEPT_ID") private String departmentId;
    @Column(name = "BBH_DIVN_ID") private String divisionId;
    @Column(name = "BBH_STATUS") private String status;

    public long getBbhSgsId() {
        return bbhSgsId;
    }

    public void setBbhSgsId(long bbhSgsId) {
        this.bbhSgsId = bbhSgsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getCustomerCategoryId() {
        return customerCategoryId;
    }

    public void setCustomerCategoryId(String customerCategoryId) {
        this.customerCategoryId = customerCategoryId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAprroverdUser() {
        return aprroverdUser;
    }

    public void setAprroverdUser(String aprroverdUser) {
        this.aprroverdUser = aprroverdUser;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
