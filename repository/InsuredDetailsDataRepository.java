package com.beyontec.mol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.beyontec.mol.entity.ClaimTransactionClaimantDetails;

@Repository
public interface InsuredDetailsDataRepository extends JpaRepository<ClaimTransactionClaimantDetails, Long> {

    @Query(value = "SELECT UCD_FIRST_NAME AS firstName, UCD_LAST_NAME AS lastName, UCD_NAME AS name, UCD_ADDRESS_1 AS address1, UCD_ADDRESS_2 AS address2, UCD_ADDRESS_3 AS address3, UCD_ADDRESS_4 AS address4, UCD_PIN_CODE AS pincode, UCD_CITY AS city, UCD_STATE AS state, UCD_COUNTRY_ID AS countryId, UCD_PY_PHONE_NO AS phoneNo, UCD_PY_MOBILE_NO AS mobileNo, UCD_PY_EMAIL_ID AS emailId, UCD_DOB AS dob, UCD_GENDER AS gender, UCD_NATIONALITY AS nationality, UCD_PREFIX_NAME AS prefixName FROM UDS_CUSTOMER_DTLS WHERE UCD_ID=?1", nativeQuery = true)
    List<Object[]> getInsuredData(String insuredId);
    
    @Query(value = "select CLCP_NAME from CTDS_LEVEL_CP WHERE CLCP_CLF_SGS_ID=?1", nativeQuery = true)
    public String getInsuredName(Long fnolSgsId);
    
    public ClaimTransactionClaimantDetails findByFnolSgsId(Long fnolSgsId);
}
