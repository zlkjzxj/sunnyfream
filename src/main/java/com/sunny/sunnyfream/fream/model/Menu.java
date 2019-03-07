package com.sunny.sunnyfream.fream.model;

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
    private String id;
    private String name;
    private String url;
    private String icon;
    private Integer order;
    private Integer view;
    private Integer open;
    private Integer enable;
    private Integer type;
    private String parent;
    private boolean spread;
    private List<Menu> children;

    public Menu(String name, String url, String icon, boolean spread, List<Menu> children) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.spread = spread;
        this.children = children;
    }
}
