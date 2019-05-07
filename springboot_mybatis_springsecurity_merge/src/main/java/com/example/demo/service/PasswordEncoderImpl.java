package com.example.demo.service;
/**
 * 
 */
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
public class PasswordEncoderImpl implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return encodedPassword.equals(rawPassword.toString());
	}

}
