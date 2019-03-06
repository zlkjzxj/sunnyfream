package com.sunny.sunnyfream.fream.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-06 14:26
 */
@Controller
public class SysUserController {
    @RequestMapping("/toUserCenter")
    public String toUserCenter() {
        return "user/userList";
    }

    @RequestMapping("/toUserAdd")
    public String toUserAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/toNewsList")
    public String toNewsList() {
        return "news/newsList";
    }

    @RequestMapping("/toNewsAdd")
    public String toNewsAdd() {
        return "news/newsAdd";
    }
}
