package com.beyontec.mol.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ads_user_group")
@EntityListeners(AuditingEntityListener.class)
public class UserGroup {

    @Id
    @Column(name = "AUG_ID")
    private String id;

    @Column(name = "AUG_GROUP_NAME")
    private String groupName;

    /* @Column(name = "AUR_DFLT_YN")
     * private String defaultRole; */

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "userGroups")
    private Set<User> users = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "ads_user_group_menu", joinColumns = { @JoinColumn(name = "AUGM_AUG_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "AUGM_MENU_ID") })
    private Set<UserGroupMenu> userGroupMenus;

    @OneToMany(mappedBy = "userGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserGroupPermission> userGroupPermissions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) @JoinColumn(name = "AUR_AUG_ID") private Set<UserRole> userRoles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<UserGroupMenu> getUserGroupMenus() {
        return userGroupMenus;
    }

    public void setUserGroupMenus(Set<UserGroupMenu> userGroupMenus) {
        this.userGroupMenus = userGroupMenus;
    }

    public Set<UserGroupPermission> getUserGroupPermissions() {
        return userGroupPermissions;
    }

    public void setUserGroupPermissions(Set<UserGroupPermission> userGroupPermissions) {
        this.userGroupPermissions = userGroupPermissions;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


    /* public String getDefaultRole() {
     * return defaultRole;
     * }
     * public void setDefaultRole(String defaultRole) {
     * this.defaultRole = defaultRole;
     * } */

}
