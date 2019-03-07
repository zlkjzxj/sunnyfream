package com.sunny.sunnyfream.business.controller;

import com.sunny.sunnyfream.business.model.Project;
import com.sunny.sunnyfream.result.Result;
import com.sunny.sunnyfream.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author sunny
 * @Date 2019-03-07 14:15
 */
@RestController
@Slf4j
public class ProjectController {
    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public Result getProjectList(Project project) {
        return Result.success(Constant.PROJECT_LIST);
    }

    @RequestMapping(value = "/project", method = RequestMethod.POST)
    public Result addProject(Project project) {
        log.warn(project.toString());
        Constant.PROJECT_LIST.add(project);
        return Result.success(null);
    }
}
