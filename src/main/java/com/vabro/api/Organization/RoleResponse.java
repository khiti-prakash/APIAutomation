package com.vabro.api.Organization;

import com.google.gson.annotations.*;
import com.google.gson.annotations.*;

public class RoleResponse {

    @SerializedName("roleId")
    @Expose
    private long roleId;

    @SerializedName("roleName")
    @Expose
    private String roleName;

    public long getRoleID()
    {
        return roleId;
    }
    public void setRoleID(long value)
    {
        this.roleId = value;
    }

    public String getRoleName()
    {
        return roleName;
    }
    public void setRoleName(String value)
    {
        this.roleName = value;
    }
}
