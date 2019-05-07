package com.example.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@Secured("ROLE_USER")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "home";
	}
	
	@RequestMapping("/denied")
	public String denied() {
		return "denied";
	}
	
	@RequestMapping("/admin")
	@Secured("ROLE_ADMIN")
	public String admin() {
		return "admin";
	}
}
