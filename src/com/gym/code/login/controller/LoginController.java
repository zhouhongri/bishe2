package com.gym.code.login.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.login.service.LoginServiceInter;
import com.gym.code.model.User;

@Controller
@RequestMapping("loginCtrl")
public class LoginController {
	
	@Autowired
	private LoginServiceInter loginService;
	//登录
	@RequestMapping("/login")
	@ResponseBody
	public Map login(HttpSession session, User user) {
		return this.loginService.login(session, user);
	}
	//注销
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login/login";
	}
	
}
