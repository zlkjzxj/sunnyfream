package com.sunny.sunnyfream.fream.controller;

import com.sunny.sunnyfream.fream.model.Department;
import com.sunny.sunnyfream.fream.model.SysUser;
import com.sunny.sunnyfream.result.PageResult;
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
public class DepController {
    @RequestMapping("/toDepList")
    public String toDepList() {
        return "dep/depList";
    }

//    @RequestMapping("/toUserAdd")
//    public String toUserAdd() {
//        return "user/userAdd";
//    }

    @RequestMapping(value = "/dep", method = RequestMethod.GET)
    @ResponseBody
    public PageResult getUserList() {
        Constant.DEP_LIST.clear();
        Department department = new Department("1", "总经理", 1, 1, "-1");
        Constant.DEP_LIST.add(department);
        Department department1 = new Department("2", "副总经理", 1, 1, "1");
        Constant.DEP_LIST.add(department1);
        return PageResult.success(Constant.DEP_LIST);
    }
//
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    @ResponseBody
//    public Result addUser(SysUser sysUser) {
//        log.warn(sysUser.toString());
//        Constant.USER_LIST.add(sysUser);
//        return Result.success(null);
//    }
}
