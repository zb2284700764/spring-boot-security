package com.example.common.core.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security 基本配置
 */
@Configuration
@EnableWebSecurity // 开启 Spring Security 功能
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    @Qualifier("authenticationSuccessHandler")
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    @Qualifier("authenticationFailHandler")
    private AuthenticationFailHandler failHandler;

    @Autowired
    @Qualifier("authenticationEntryPointImpl")
    private AuthenticationEntryPointImpl entryPoint;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // permitAll 表示这些 url 不需要认证
                .antMatchers("/test/**", "/res/**").permitAll()
                .antMatchers("/user/**").hasAnyRole("user")
                .antMatchers("/admin/**").hasAnyRole("admin")
                // 其他链接都需要认证
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .successForwardUrl("/index")
//                .and().formLogin().loginProcessingUrl("/login")
//                .successHandler(successHandler)
//                .failureHandler(failHandler)
                .and().logout().permitAll()
                .and().exceptionHandling().authenticationEntryPoint(entryPoint);

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 设置密码的加密策略 默认是 BCryptPasswordEncoder
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());

        // 从内存加载用户
        BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123456");
        auth.inMemoryAuthentication()
                .passwordEncoder(bCryptPasswordEncoder)
                .withUser("zhangsan").password(password).roles("user")
//                .authorities("BookAdd","BookList")
                .and()
                .withUser("admin").password(password).roles("admin")
//                .authorities("BookAdd","BookList","BookDetail","UserIndex")
        ;
    }


}
