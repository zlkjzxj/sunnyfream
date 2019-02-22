package com.sunny.sunnyfream.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description TODO
 * @Author sunny
 * Date 2019\1\30 0030 17:06
 */
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ErrorPageInterceptor errorPageInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(errorPageInterceptor);
        super.addInterceptors(registry);
    }
}
