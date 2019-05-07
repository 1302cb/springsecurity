package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.SecurityUser;
@Mapper
@Repository
public interface SecurityUserMapper {
	@Select("SELECT * FROM security_user WHERE username=#{username}")
	SecurityUser findSecurityUserByUsername(String username);
}
