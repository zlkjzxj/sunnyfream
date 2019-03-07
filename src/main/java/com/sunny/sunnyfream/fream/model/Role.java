package com.sunny.sunnyfream.fream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /**
     * 角色id
     */
    private Integer id;
    /**
     * 角色名
     */
    private String name;
    /**
     * 角色描述
     */
    private String desc;
    /**
     * 继承模式，暂时不用
     */
    private Integer pid;
    /**
     * 权限组
     */
    private Set<PermissionGroup> permissions = new HashSet<>();

}