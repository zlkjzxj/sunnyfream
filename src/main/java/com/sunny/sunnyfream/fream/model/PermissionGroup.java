package com.sunny.sunnyfream.fream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionGroup {
    private int id;
    private String name;
    private Integer type;

}
