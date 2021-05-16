package com.imhui.core.config;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author: zyixh
 * @date: 2021/5/15
 * @description:
 */
public class MessageSourceConfiguration {

    /**
     * {@link org.springframework.context.support.StaticMessageSource}  测试环境
     * {@link org.springframework.security.core.SpringSecurityMessageSource}    用于spring security的国际化
     * {@link ReloadableResourceBundleMessageSource}    不用重启服务器读取配置文件
     * {@link org.springframework.context.support.ResourceBundleMessageSource}  生产环境
     *
     * http://www.shouce.ren/api/spring2.5/ch13s06.html
     * @return
     */
    public MessageSource messageSource(){
        return new ReloadableResourceBundleMessageSource();
    }

    /**
     * 一个DispatcherServlet只能注册一个区域解析器
     * {@link org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver}  默认
     * {@link org.springframework.web.servlet.i18n.SessionLocaleResolver}
     * {@link org.springframework.web.servlet.i18n.CookieLocaleResolver}
     * {@link org.springframework.web.servlet.i18n.FixedLocaleResolver}
     */

    /**
     *
     * <bean class="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"/>
     * <bean id="localeResolver" class="org.springframework.web.servlet.i18n.CookieLocaleResolver">
     *     <property name="cookieName" value="lang"/>
     *     <property name="cookiePath" value="/"/>
     *     <property name="cookieMaxAge" value="-1"/>
     *     <property name="defaultLocale" value="zh_CN"/>
     * </bean>
     *
     * https://www.cnblogs.com/panxuejun/p/7155550.html
     */
}
