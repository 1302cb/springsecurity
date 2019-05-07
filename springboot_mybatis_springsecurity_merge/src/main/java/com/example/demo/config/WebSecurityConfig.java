package com.example.demo.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
/**
 * 配置类，重写他的一些方法来设置一些web安全的细节如配置security的登录页面和传递参数，公共路径权限属性
 */
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.service.PasswordEncoderImpl;
import com.example.demo.service.UserDetailsServiceImpl;
@Configuration
//请求控制权限到方法级别
@EnableGlobalMethodSecurity(securedEnabled = true)
//可以达到禁用默认登录界面
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//自定义认证对象
	@Autowired
	private UserDetailsServiceImpl serviceImpl;

	//自定义登录规则就必须要重写这个方法
	//身份验证管理生成器
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//不加.passwordEncoder(new PasswordEncoderImpl())
        //就不是以明文的方式进行匹配，会报错
		auth.userDetailsService(serviceImpl).passwordEncoder(new PasswordEncoderImpl());
	}

	//http请求安全处理
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//请求权限配置
		
		http.authorizeRequests()
		.antMatchers("/","/login").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/hello").permitAll()
		.and().logout().logoutSuccessUrl("/login").permitAll()
		.and().exceptionHandling().accessDeniedPage("/denied");
		
		http.csrf().disable();
	}
	
	
}
