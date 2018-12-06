package com.beyontec.mol.modal;

import java.util.List;

public class CertificateExportCriteria {

    private CertificateSearchCriteria searchCriteria;

    private List<String> certificateNumbers;

    private List<String> deSelectedCertificateNumbers;

    private boolean isExportAll;

    public CertificateSearchCriteria getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(CertificateSearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<String> getCertificateNumbers() {
        return certificateNumbers;
    }

    public void setCertificateNumbers(List<String> certificateNumbers) {
        this.certificateNumbers = certificateNumbers;
    }

    public boolean isExportAll() {
        return isExportAll;
    }

    public void setisExportAll(boolean isExportAll) {
        this.isExportAll = isExportAll;
    }

    public List<String> getDeSelectedCertificateNumbers() {
        return deSelectedCertificateNumbers;
    }

    public void setDeSelectedCertificateNumbers(List<String> deSelectedCertificateNumbers) {
        this.deSelectedCertificateNumbers = deSelectedCertificateNumbers;
    }
}
