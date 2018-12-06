package com.beyontec.mol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ads_user_group_dar")
@EntityListeners(AuditingEntityListener.class)
public class UserGroupPermission {

    @Column(name = "AUGD_COMP_ID")
    private String id;

    @Id
    @Column(name = "AUGD_FUNCTION_NAME")
    private String name;

    @Column(name = "AUGD_DA_VIEW_IND")
    private String viewPermission;

    @Column(name = "AUGD_DA_EDIT_IND")
    private String editPermission;

    @Column(name = "AUGD_DA_DEL_IND")
    private String deletePermission;

    @Column(name = "AUGD_DA_CRTE_IND")
    private String createPermission;

    @ManyToOne
    @JoinColumn(name = "AUGD_AUG_ID")
    private UserGroup userGroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getViewPermission() {
        return viewPermission;
    }

    public void setViewPermission(String viewPermission) {
        this.viewPermission = viewPermission;
    }

    public String getEditPermission() {
        return editPermission;
    }

    public void setEditPermission(String editPermission) {
        this.editPermission = editPermission;
    }

    public String getDeletePermission() {
        return deletePermission;
    }

    public void setDeletePermission(String deletePermission) {
        this.deletePermission = deletePermission;
    }

    public String getCreatePermission() {
        return createPermission;
    }

    public void setCreatePermission(String createPermission) {
        this.createPermission = createPermission;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

}
