package com.beyontec.mol.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beyontec.mol.config.CommonConfig;
import com.beyontec.mol.config.UdsIdDefConfig;
import com.beyontec.mol.entity.CertificateDetails;
import com.beyontec.mol.entity.CustomerDetailsHistory;
import com.beyontec.mol.entity.CustomerDetailsMain;
import com.beyontec.mol.entity.PolicyHistory;
import com.beyontec.mol.repository.CustomerDetailsHistoryRepository;
import com.beyontec.mol.repository.CustomerDetailsMainRepository;

@Service
public class CustomerService extends BaseService {

    @Autowired private CustomerDetailsMainRepository customerDetailsMainRepo;

    @Autowired private CustomerDetailsHistoryRepository customerDetailsHistoryRepo;

    @Autowired private ModelMapper modelMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CustomerDetailsMain getCustomerDetails(CertificateDetails certificateDetails, PolicyHistory masterPolicy) {
        CustomerDetailsMain customerDetailsMain = getCustomerDetails(certificateDetails);
        if (customerDetailsMain == null) {
            customerDetailsMain = createCustomerDetails(certificateDetails, masterPolicy);
            createCustomerDetailsHistory(customerDetailsMain);
        }
        return customerDetailsMain;
    }
    
    public CustomerDetailsMain getCustomerDetails(CertificateDetails certificateDetails) {
        String defaultCustomerIdType1 = UdsIdDefConfig.getUdsIdDefinitionValue(UdsIdDefConfig.ID_TYPE_DEFAULT_DATA,
                                                                               UdsIdDefConfig.ID_DEFAULT_CUST_ID_TYPE1);
        return invokeRepo(() -> customerDetailsMainRepo.findByIdTypeAndId(CommonConfig.COMPANY_ID,
                                                                                                             defaultCustomerIdType1,
                                                                                                             certificateDetails.getEmployerLicenseNo()),
                                                             "customerDetailsRepo.findByIdTypeAndId(CommonConfig.COMPANY_ID, customerDetailsDefinition.getUID_VALUE(), certificateDetails.getEmployerLicenseNo()");
    }

    private CustomerDetailsMain createCustomerDetails(CertificateDetails certificateDetails,
                                                      PolicyHistory masterPolicy) {
        CustomerDetailsMain customerDetailsMain = new CustomerDetailsMain();
        customerDetailsMain.loadDefaults();
        customerDetailsMain.loadFromCertificateDetails(certificateDetails);
        customerDetailsMain.loadFromUdsIdDefinition(certificateDetails);
        customerDetailsMain.loadFromMasterPolicy(masterPolicy);

        CustomerDetailsMain existCustomerDetailsMain = getCustomerDetails(certificateDetails);
        if (existCustomerDetailsMain == null) {
            return invokeRepo(() -> customerDetailsMainRepo.save(customerDetailsMain),
                                                                    "customerDetailsMainRepo.save(customerDetailsMain)");
        }
        return existCustomerDetailsMain;
    }

    private void createCustomerDetailsHistory(CustomerDetailsMain customerDetailsMain) {
        CustomerDetailsHistory customerDetailsHistory = invokeModelMapper(() -> modelMapper.map(customerDetailsMain,
                                                                                                CustomerDetailsHistory.class),
                                                                          "modelMapper.map(customerDetails, CustomerDetailsHistory.class)");
        invokeRepo(() -> customerDetailsHistoryRepo.save(customerDetailsHistory),
                   "customerDetailsHistoryRepo.save(customerDetailsHistory)");
    }
}
