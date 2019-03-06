package com.sunny.sunnyfream.fream.controller;

import com.sunny.sunnyfream.model.Menu;
import com.sunny.sunnyfream.vo.MenuVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-06 14:00
 */
@Controller
public class MenuController {
    @RequestMapping("/getMenu")
    @ResponseBody
    public MenuVo getMenu() {
        /*
        * "title": "文章列表",
			"icon": "icon-text",
			"href": "page/news/newsList.html",
			"spread": false
        * */

        List<Menu> list = new ArrayList<>();
        Menu menu = new Menu("文章列表", "icon-text", "/toNewsList", false, null);
        Menu menu2 = new Menu("用户管理", "icon-text", "/toNewsList", false, null);
        Menu menu3 = new Menu("部门管理", "icon-text", "/toNewsList", false, null);
        List<Menu> list1 = new ArrayList<>();
        list1.add(menu2);
        list1.add(menu3);
        Menu menu1 = new Menu("系统设置", "&#xe612", "/toUserCenter", false, list1);
        list.add(menu);
        list.add(menu1);
        MenuVo menuVo = new MenuVo(list);
        return menuVo;

    }
}
