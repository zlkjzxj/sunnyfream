package com.sunny.sunnyfream.fream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-11 16:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepTree extends TreeNode {
    private String bmbh;
    private String bmmc;
    private Integer bmjb;
    private Integer isshow;
    private String pid;

    public DepTree(String name, List<DepTree> children, String href, String bmbh) {
        super(name, children, href);
        this.bmbh = bmbh;
    }
}
