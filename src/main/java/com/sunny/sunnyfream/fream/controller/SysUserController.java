package com.sunny.sunnyfream.fream.controller;

import com.sunny.sunnyfream.business.model.Project;
import com.sunny.sunnyfream.fream.model.SysUser;
import com.sunny.sunnyfream.result.Result;
import com.sunny.sunnyfream.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-06 14:26
 */
@Controller
@Slf4j
public class SysUserController {
    @RequestMapping("/toUserList")
    public String toUserCenter() {
        return "user/userList";
    }

    @RequestMapping("/toUserAdd")
    public String toUserAdd() {
        return "user/userAdd";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserList(SysUser sysUser) {
        return Result.success(Constant.USER_LIST);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Result addUser(SysUser sysUser) {
        log.warn(sysUser.toString());
        Constant.USER_LIST.add(sysUser);
        return Result.success(null);
    }
}
