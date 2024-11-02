package com.zxw.domain;

import java.util.Objects;

public class MainRole {
    private int id;
    private String RoleName;
    private String RoleSkill;
    private String RoleText;
    private int novelId;

    @Override
    public String toString() {
        return "MainRole{" +
                "id=" + id +
                ", RoleName='" + RoleName + '\'' +
                ", RoleSkill='" + RoleSkill + '\'' +
                ", RoleText='" + RoleText + '\'' +
                ", novelId=" + novelId +
                '}';
    }

    public MainRole() {
    }

    public MainRole(int id, String roleName, String roleSkill, String roleText, int novelId) {
        this.id = id;
        RoleName = roleName;
        RoleSkill = roleSkill;
        RoleText = roleText;
        this.novelId = novelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getRoleSkill() {
        return RoleSkill;
    }

    public void setRoleSkill(String roleSkill) {
        RoleSkill = roleSkill;
    }

    public String getRoleText() {
        return RoleText;
    }

    public void setRoleText(String roleText) {
        RoleText = roleText;
    }

    public int getNovelId() {
        return novelId;
    }

    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainRole mainRole = (MainRole) o;
        return id == mainRole.id && novelId == mainRole.novelId && Objects.equals(RoleName, mainRole.RoleName) && Objects.equals(RoleSkill, mainRole.RoleSkill) && Objects.equals(RoleText, mainRole.RoleText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, RoleName, RoleSkill, RoleText, novelId);
    }
}
