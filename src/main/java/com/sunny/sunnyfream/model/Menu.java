package com.sunny.sunnyfream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-06 13:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String title;
    private String icon;
    private String href;
    private boolean spread;
    private List<Menu> children;
}
