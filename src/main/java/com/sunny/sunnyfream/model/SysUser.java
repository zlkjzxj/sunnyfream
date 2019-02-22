package com.sunny.sunnyfream.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SysUser implements Serializable {
    private static final long serialVersionUID = 5528101080905698238L;
    private Integer id;
    private String name;
    private String password;
    private Set<Role> roles = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
