package com.beyontec.mol.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.beyontec.mol.modal.UserGroupMenuDTO;

@Entity
@Table(name = "ads_menu_hier")

@SqlResultSetMappings({
    @SqlResultSetMapping(
                      name = "userGroupMenuRsMapping",
                      classes = @ConstructorResult(
                                                   targetClass = UserGroupMenuDTO.class,
                                                   columns = {
                                    @ColumnResult(name = "FUNCTION_ID", type = String.class),
                                    @ColumnResult(name = "MENU_NAME", type = String.class),
                                    @ColumnResult(name = "CREATE_FLAG", type = String.class),
                                    @ColumnResult(name = "VIEW_FLAG", type = String.class),
                                    @ColumnResult(name = "EDIT_FLAG", type = String.class),
                                    @ColumnResult(name = "DELETE_FLAG", type = String.class)
                                                   })
                      )
})

@NamedNativeQueries({
    @NamedNativeQuery(
                      name = "getUserGroupMenu",
                      resultSetMapping = "userGroupMenuRsMapping",
                      query = "SELECT UPPER(AMH_FUNC_ID) FUNCTION_ID, "
                              + "             CASE WHEN :isEngLocale = 'true' "
                              + "                  then AMH_MENU_NAME "
                              + "                  else AMH_MENU_NAME_1 "
                              + "                  end as MENU_NAME, "
                              + "             AUGD_DA_CRTE_IND CREATE_FLAG, "
                              + "             AUGD_DA_VIEW_IND VIEW_FLAG, "
                              + "             AUGD_DA_EDIT_IND EDIT_FLAG, "
                              + "             AUGD_DA_DEL_IND DELETE_FLAG "
                              + "FROM ADS_MENU_HIER, "
                              + "     ADS_USER_GROUP_MENU, "
                              + "     ADS_USER_GROUP_DAR "
                              + "WHERE AMH_COMP_ID = AUGM_COMP_ID "
                              + "AND   AMH_MENU_ID = AUGM_MENU_ID "
                              + "AND   AUGM_AUG_ID = :userGroupId "
                              + "AND   (AUGM_COMP_ID, AUGM_AUG_ID) IN (SELECT AUR_COMP_ID, AUR_AUG_ID FROM ADS_USER_ROLES WHERE AUR_AU_ID = :userId AND AUR_COMP_ID = AUGM_COMP_ID) "
                              + "AND   AUGD_COMP_ID = AUGM_COMP_ID "
                              + "AND   AUGD_AUG_ID = :userGroupId "
                              + "AND   AUGD_FUNCTION_ID = AUGM_MENU_ID "
                              + "AND   EXISTS (SELECT 1 FROM SDS_FUNCTION WHERE SF_COMP_ID = AMH_COMP_ID AND SF_ID = AMH_FUNC_ID AND SF_MODULE_ID = '91') "
                              + "ORDER BY AMH_DISP_SR_NO "
                      )
})
@EntityListeners(AuditingEntityListener.class)
public class UserGroupMenu {

    @Id
    @Column(name = "AMH_MENU_ID")
    private String id;
    
    @Column(name = "AMH_FUNC_ID")
    private String functionId;
    
    @Column(name = "AMH_MENU_NAME")
    private String name;

    @Column(name = "AMH_COMP_ID") private String companyId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "userGroupMenus")
    private Set<UserGroup> userGroups = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
