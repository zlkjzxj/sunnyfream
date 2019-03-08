package com.sunny.sunnyfream.business.controller;

import com.sunny.sunnyfream.business.model.Project;
import com.sunny.sunnyfream.result.Result;
import com.sunny.sunnyfream.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebResult;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-07 14:15
 */
@Controller
@Slf4j
public class ProjectController {
    @RequestMapping("/toProjectList")
    public String toUserCenter() {
        return "project/projectList";
    }

    @RequestMapping("/toProjectAdd")
    public String toUserAdd() {
        return "project/projectAdd";
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    @ResponseBody
    public Result getProjectList(Project project) {
        return Result.success(Constant.PROJECT_LIST);
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    @ResponseBody
    public Result addProject(Project project) {
        log.warn(project.toString());
        Constant.PROJECT_LIST.add(project);
        return Result.success(null);
    }
}
