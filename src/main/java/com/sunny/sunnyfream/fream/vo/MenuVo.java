package com.sunny.sunnyfream.fream.vo;

import com.sunny.sunnyfream.fream.model.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-06 13:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVo {
    private List<Menu> contentManagement;
}
