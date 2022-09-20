package com.zjy.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// AOP:拦截器
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有页可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限跳转的登录页面，需要开启登录的页面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");//定制登录页面
        //注销功能开启  注销成功跳到首页
        http.csrf().disable();//关闭csrf功能 防止网站工具 post与get方式请求
        http.logout().logoutSuccessUrl("/");
        //开启记住功能 cookie实现 默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }
    //认证  但是有密码编码有问题，要增加加密方式
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //正常从数据库读取
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
        .withUser("local").password(new BCryptPasswordEncoder().encode("000")).roles("vip2","vip3")
        .and()
        .withUser("host").password(new BCryptPasswordEncoder().encode("000")).roles("vip1")
        .and()
        .withUser("root").password(new BCryptPasswordEncoder().encode("333")).roles("vip1","vip2","vip3");

    }
}
