package com.sunny.sunnyfream.fream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-11 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode<T> {
    private String name;
    private List<T> children;
    private String href;
}
