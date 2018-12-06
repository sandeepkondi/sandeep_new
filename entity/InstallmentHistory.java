package com.beyontec.mol.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.config.CommonConfig;

@Entity
@Table(name = "UHDS_LEVEL_I")
@EntityListeners(AuditingEntityListener.class)
public class InstallmentHistory extends InstallmentBase {

    public void loadDefaults() {
        this.recordType = CommonConfig.RECORD_TYPE_I;
    }
}
