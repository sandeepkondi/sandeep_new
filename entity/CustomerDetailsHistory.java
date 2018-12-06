package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UDSH_CUSTOMER_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class CustomerDetailsHistory extends CustomerDetailsBase {

    @Id @Column(name = "UCD_ID", updatable = false, nullable = false) private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
