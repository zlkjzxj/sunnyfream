package com.sunny.sunnyfream.model;

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
    private Integer id;
    private String name;
    private String password;
    private Set<Role> roles = new HashSet<>();


}
