package com.beyontec.mol.modal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ActivePolicy {

    private String workerType;
    @JsonIgnore
    private String workerTypeEn;
    @JsonIgnore
    private String workerTypeAr;
    private long count;
    private BigDecimal premium;

    public ActivePolicy(String workerTypeEn, String workerTypeAr, long count, BigDecimal premium) {
        this.workerTypeEn = workerTypeEn;
        this.workerTypeAr = workerTypeAr;
        this.count = count;
        this.premium = premium;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public String getWorkerTypeEn() {
        return workerTypeEn;
    }

    public void setWorkerTypeEn(String workerTypeEn) {
        this.workerTypeEn = workerTypeEn;
    }

    public String getWorkerTypeAr() {
        return workerTypeAr;
    }

    public void setWorkerTypeAr(String workerTypeAr) {
        this.workerTypeAr = workerTypeAr;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

}
