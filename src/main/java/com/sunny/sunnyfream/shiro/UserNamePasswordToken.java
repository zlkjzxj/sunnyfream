package com.sunny.sunnyfream.shiro;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Description 用户和密码（包含验证码）令牌类
 * @Author sunny
 * Date 2019\1\29 0029 10:46
 */

@Getter
@Setter
public class UserNamePasswordToken extends UsernamePasswordToken {

    private static final long serialVersionUID = 1L;
    private String captcha;
    private String locale;

    public UserNamePasswordToken() {
        super();
    }

    public UserNamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }

    public UserNamePasswordToken(String username, char[] password, String locale, boolean rememberMe, String host, String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
        this.locale = locale;
    }
}
