package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SecurityUserMapper;
import com.example.demo.domain.SecurityUser;

/**
 * service注解是必须的，还要记得在配置类当中加载
 * @author 11366
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SecurityUserMapper dao;

	//通过用户名得到用户信息并注册进去
	//重写这个方法自己来实现登录验证
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SecurityUser suuser = dao.findSecurityUserByUsername(username);

		if (suuser == null) {
			System.out.println(username + "is not exist!");
			throw new UsernameNotFoundException(username + "不存在");
		}

		UserDetails user = new User(username, suuser.getPassword(), true, true, true, true,
				getAuthorities(suuser.getAccess_level()));

		return user;
	}

	// 得到用户所拥有的权限
	public Collection<GrantedAuthority> getAuthorities(int access){
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		//首先所有的都拥有用户权限
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		//如果是0，那就是用户加管理员
		if(access==0) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		//如果是2，那就是双重权限
		if(access == 2) {
			authorities.add(new SimpleGrantedAuthority("ROLE_TWO"));
		}
		
		return authorities;
	}
	
}
