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
    private String title;
    private String href;
    private String icon;
    private Integer order;
    private Integer view;
    private Integer open;
    private Integer enable;
    private Integer type;
    private String parent;
    private boolean spread;
    private List<Menu> children;

    public Menu(String title, String icon, String href, boolean spread, List<Menu> children) {
        this.title = title;
        this.href = href;
        this.icon = icon;
        this.spread = spread;
        this.children = children;
    }
}
