package com.sunny.sunnyfream.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Description TODO
 * @Author sunny
 * Date 2019\1\30 0030 14:39
 */
public class RememberAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request, response);
        //不是登录过的，而是rememberMe的
        if (!subject.isAuthenticated() && subject.isRemembered()) {
            Session session = subject.getSession();
            if (session.getAttribute("user") == null) {
                String userName = subject.getPrincipal().toString();

            }
        }
        boolean b = subject.isAuthenticated() || subject.isRemembered();
        return b;
    }
}
