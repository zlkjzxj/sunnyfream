package com.sunny.sunnyfream.fream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 5528101080905698238L;
    /**
     * 用户代号
     */

    private Long yhdh;
    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户登录密码
     */
    private String password;
    /**
     * 部门编号
     */
    private String bmdh;
    /**
     * 职务
     */
    private String zw;
    /**
     * 用户密码过期，重新设置
     */
    private Integer ISEXPIRED;
    /**
     * 用户被锁定，不能登录了
     */
    private Integer ISLOCKED;

    private Integer ISCREDENTIALSEXPIRED;
    /**
     * 是否可用
     */
    private Integer ISENABLED;

    private String yhyxq;
    private String mmyxq;
    private String sfzmhm;
    private String lxdh;
    private String lxdz;
    private String ip;
    private String csrq;
    private Integer gender;
    private String email;

    private Set<Role> roles = new HashSet<>();

    public SysUser(Long id, String name, String password) {
        this.yhdh = id;
        this.name = name;
        this.password = password;
    }
}
