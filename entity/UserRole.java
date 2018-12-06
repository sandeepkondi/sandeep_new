package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ads_user_roles")
@EntityListeners(AuditingEntityListener.class)
public class UserRole {

    @Id @Column(name = "AUR_SGS_ID") private String id;

    @Column(name = "AUR_AU_ID") private String userId;

    @Column(name = "AUR_AUG_ID") private String userGroupid;

    @Column(name = "AUR_DFLT_YN") private String isDefault;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserGroupid() {
        return userGroupid;
    }

    public void setUserGroupid(String userGroupid) {
        this.userGroupid = userGroupid;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
