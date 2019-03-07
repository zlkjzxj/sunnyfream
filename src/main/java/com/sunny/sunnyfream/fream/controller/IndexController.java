package com.sunny.sunnyfream.fream.controller;

import com.sunny.sunnyfream.exception.GlobalException;
import com.sunny.sunnyfream.fream.model.SysUser;
import com.sunny.sunnyfream.result.CodeMsg;
import com.sunny.sunnyfream.result.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String toLogin() {
        return "login2";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/to_main")
    public String toMain() {
        return "main";
    }


    /**
     * 登录提交方法
     *
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Result<SysUser> login(HttpServletRequest request,
                                 @RequestParam(value = "userName") String userName,
                                 @RequestParam("password") String password,
                                 @RequestParam("verifyCode") String verifyCode
    ) {
//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName() + ":" + cookie.getValue());
//        }

        //先判断验证码是否正确
//        HttpSession httpSession = request.getSession();
//        String code = (String) httpSession.getAttribute("verifyCode");
//        if (!code.equals(verifyCode.toUpperCase())) {
//            logger.error("验证码错误");
//            return Result.error(CodeMsg.VERIFYCODE_ERR);
//        }

        //登录验证
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            SysUser user = (SysUser) subject.getPrincipal();
            Session session = subject.getSession();
            session.setAttribute("user", user);
            return Result.success(user);
        } catch (UnknownAccountException e) {
            logger.error("账户不存在");
            throw new GlobalException(CodeMsg.USER_NOT_EXIST);
        } catch (DisabledAccountException e) {
            logger.error("账户存在问题");
            throw new GlobalException(CodeMsg.DISABLE_ACCOUT_ERR);
        } catch (AuthenticationException e) {
            logger.error("用户名或密码错误");
            throw new GlobalException(CodeMsg.USERNAME_PASSOERD_ERR);
        } catch (Exception e) {
            e.printStackTrace();
//            logger.error("登录错误");
//            throw new GlobalException(CodeMsg.LOGIN_EXCEPTION_ERR);
        }
        return null;
    }

    /**
     * 没有访问权限
     */
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }
}
