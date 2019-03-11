package com.sunny.sunnyfream.fream.controller;

import com.sunny.sunnyfream.fream.model.DepTree;
import com.sunny.sunnyfream.fream.model.Department;
import com.sunny.sunnyfream.result.PageResult;
import com.sunny.sunnyfream.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
        Constant.DEPTREE_LIST.clear();


        DepTree dep4 = new DepTree("系统集成部", null, "", "5");
        DepTree dep5 = new DepTree("西安研发中心", null, "", "6");
        DepTree dep6 = new DepTree("西安研发中心", null, "", "7");
        DepTree dep7 = new DepTree("西安研发中心", null, "", "8");
        List<DepTree> list1 = new ArrayList<>();
        list1.add(dep4);
        list1.add(dep5);
        list1.add(dep6);
        list1.add(dep7);

        DepTree dep1 = new DepTree("副总经理", list1, "", "2");
        DepTree dep2 = new DepTree("财务总监", null, "", "3");
        DepTree dep3 = new DepTree("行政总监", null, "", "4");

        List<DepTree> list = new ArrayList<>();
        list.add(dep1);
        list.add(dep2);
        list.add(dep3);


        DepTree dep = new DepTree("总经理", list, "", "1");
        Constant.DEPTREE_LIST.add(dep);
        return PageResult.success(Constant.DEPTREE_LIST);
    }
   /* @RequestMapping(value = "/dep", method = RequestMethod.GET)
    @ResponseBody
    public PageResult getUserList() {
        Constant.DEP_LIST.clear();
        Department department = new Department("1", "总经理", 0, 1, "-1");
        Constant.DEP_LIST.add(department);
        Department department1 = new Department("2", "副总经理", 1, 1, "1");
        Department department2 = new Department("3", "尚总", 1, 1, "1");
        Department department3 = new Department("4", "财务总监", 1, 1, "1");
        Department department4 = new Department("", "尚宝华", 2, 1, "3");
        Department department5 = new Department("", "王大海", 2, 1, "3");
        Department department6 = new Department("", "邓伟", 1, 1, "1");
        Department department7 = new Department("", "刘兰", 2, 1, "2");
        Department department8 = new Department("", "刘大成", 1, 1, "4");
        Constant.DEP_LIST.add(department1);
        Constant.DEP_LIST.add(department2);
        Constant.DEP_LIST.add(department3);
        Constant.DEP_LIST.add(department4);
        Constant.DEP_LIST.add(department5);
        Constant.DEP_LIST.add(department6);
        Constant.DEP_LIST.add(department7);
        Constant.DEP_LIST.add(department8);
        return PageResult.success(Constant.DEP_LIST);
    }*/
//
//    @RequestMapping(value = "/user", method = RequestMethod.POST)
//    @ResponseBody
//    public Result addUser(SysUser sysUser) {
//        log.warn(sysUser.toString());
//        Constant.USER_LIST.add(sysUser);
//        return Result.success(null);
//    }
}
