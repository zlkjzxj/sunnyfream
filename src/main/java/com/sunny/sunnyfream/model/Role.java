package com.sunny.sunnyfream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer rid;
    private String rname;
    private Set<Permission> permissions = new HashSet<>();

}