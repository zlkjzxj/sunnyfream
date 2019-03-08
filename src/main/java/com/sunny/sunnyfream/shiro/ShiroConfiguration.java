package com.sunny.sunnyfream.shiro;


import com.sunny.sunnyfream.fream.model.RolePermission;
import com.sunny.sunnyfream.fream.service.PermissionConfigService;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author sunny
 */
@Configuration
public class ShiroConfiguration {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    PermissionConfigService permissionConfigService;


    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactory(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/");

        shiroFilterFactoryBean.setSuccessUrl("/index");

        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/to_main", "authc");
        filterChainDefinitionMap.put("/index", "authc");
        filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/user/*", "anon");
//        //这个接口不需要身份认证（登录）
        filterChainDefinitionMap.put("/login", "anon");
//        //需要权限的接口
//        filterChainDefinitionMap.put("/admin", "roles[admin]");
//        //具有edit权限才能够访问
//        filterChainDefinitionMap.put("/edit", "perms[edit]");

        //不需要拦截static开头的请求
        filterChainDefinitionMap.put("/getVerifyImg", "anon");
        filterChainDefinitionMap.put("/static/**", "anon");

        //这个必须放到最下面不然他下面的其他权限就不起作用了（一个大坑）
        //其他接口都需要登录
//        filterChainDefinitionMap.put("/**", "user");
        filterChainDefinitionMap.put("/**", "anon");

        //从数据库获取
//        List<RolePermission> list = permissionConfigService.getAllPermission();
//
//        for (RolePermission sysPermissionInit : list) {
//            filterChainDefinitionMap.put(sysPermissionInit.getPid(),
//                    sysPermissionInit.getRid());
//        }

        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        logger.info("配置项shiroFilter");
        return shiroFilterFactoryBean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        securityManager.setRememberMeManager(rememberMeManager());
        logger.info("配置项securityManager");
        return securityManager;

    }

    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher credentialMatcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(credentialMatcher);
        logger.info("配置项authRealm");
        return authRealm;

    }

    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher() {
        return new CredentialMatcher();
    }

    /**
     * 下面两个方法是结合spring的
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    /**
     * cookie对象;
     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     *
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     *
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }
   /* @Bean("rememberFilter")
    public RememberAuthenticationFilter rememberFilter() {
        return new RememberAuthenticationFilter();
    }*/
    /**
     *
     * anon 任何用户发送的请求都能够访问
     authc 经过认证的请求可访问，否则将会将请求重定向到 ini 配置文件配置的 authc.loginUrl 资源，进行认证操作
     authc.loginUrl=/login.jsp
     用户认证资源地址是/login
     authc.successUrl=/
     #认证成功后重定向到此资源
     authc.usernameParam=username
     #从请求参数中获取key=username的value作为用户名
     authc.passwordParam=password
     #从请求参数中获取key=password的value作为密码
     authc.rememberMeParam=rememberMe
     #从请求参数中获取key=rememberMe的value作为是否记住密码的标识
     logout 结束会话 logout.redirectUrl=/
     #结束会话后重定向到此资源
     port 指定请求端口 port=8080
     #8080端口的请求可通过
     */
}
