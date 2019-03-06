package com.sunny.sunnyfream.model;

import lombok.*;

/**
 * @Description TODO
 * @Author sunny
 * Date 2019\1\28 0028 17:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermissionConfig {
    private String id;
    private String url;
    private String permission;
    private int sort;
}
