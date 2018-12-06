package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.StringUtils;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.util.DateUtil;

@Entity
@Table(name = "UDS_CUSTOMER_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class CustomerDetailsMain extends CustomerDetailsBase {

    // @formatter:off
	@Id
	@GeneratedValue(generator = "customer_generator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "customer_generator", sequenceName = "SEQ_UCD_ID", allocationSize = 1)
	@Column(name = "UCD_ID", updatable = false, nullable = false)
    private Long id;
	// @formatter:on

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private static final String DEFAULT_TYPE = "C";
    private static final String DEFAULT_STATUS = "A";
    public void loadDefaults() {
        this.type = DEFAULT_TYPE;
        this.status = DEFAULT_STATUS;
        this.approvalStatus = DEFAULT_STATUS;
        this.cashYn = CommonConfig.FLAG_NO;
        this.recordType = CommonConfig.RECORD_TYPE_I;
        this.versionNumber = CommonConfig.DEFAULT_VERSION_NUMBER;
        this.taxApplYn = CommonConfig.FLAG_NO;
        this.preferredLanguage = CommonConfig.PREFERRED_LANG_EN;
        this.createdDate = DateUtil.now();
        this.approvalDate = DateUtil.now();
    }

    public void loadFromCertificateDetails(CertificateDetails certificateDetails) {
        this.name = certificateDetails.getEmployerNameEn();
        this.nameBl = certificateDetails.getEmployerNameAr();
        this.id1 = certificateDetails.getEmployerLicenseNo();
        this.id2 = certificateDetails.getEstablishmentCardNo();
    }

    public void loadFromUdsIdDefinition(CertificateDetails certificateDetails) {
        String defaultCustomerIdType1 = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                             UdsIdDefConfig.ID_DEFAULT_CUST_ID_TYPE1);
        this.idType1 = defaultCustomerIdType1;

        String defaultCreatedUser = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                           UdsIdDefConfig.ID_DEFAULT_CREATED_USER);
        this.createdUser = defaultCreatedUser;
        this.apu = defaultCreatedUser;

        String defaultCustomerCategoryId = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                                  UdsIdDefConfig.ID_DEFAULT_CUST_CATEGORY_ID);
        this.categoryId = defaultCustomerCategoryId;

        if (StringUtils.isEmpty(certificateDetails.getEstablishmentCardNo())) { return; }
        String defaultCustomerIdType2 = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                               UdsIdDefConfig.ID_DEFAULT_CUST_ID_TYPE2);
        this.idType2 = defaultCustomerIdType2;
    }

    public void loadFromMasterPolicy(PolicyHistory masterPolicy) {
        this.companyId = masterPolicy.companyId;
    }
}
