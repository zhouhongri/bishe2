package com.gym.code.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.model.User;
import com.gym.code.user.service.UserServiceInter;

@Controller
@RequestMapping("userCtrl")
public class UserController {
	@Autowired
	public UserServiceInter userServiceInter;
	
	@RequestMapping("queryUser")
	public String queryUser(HttpServletRequest req,String currpage) {
		this.userServiceInter.queryUserService(req, currpage);
		return "admin/user_list";
	}
	
	@RequestMapping("queryUserById")
	public String queryUserByIdCtrl(HttpServletRequest req, User user) {
		User userInstance = this.userServiceInter.getUserByIdService(user);
		req.setAttribute("User", userInstance);
		return "admin/user_update";
	}
	
	@RequestMapping("getUserById")
	public String getUserById(HttpServletRequest req, User user) {
		User userInstance = this.userServiceInter.getUserByIdService(user);
		req.setAttribute("User", userInstance);
		return "admin/change_password";
	}
	
	@RequestMapping("updateUser")
	@ResponseBody
	public boolean updateDemp(User user) {
		this.userServiceInter.updateUserService(user);
		return true;
	}
	
	@RequestMapping("changePassword")
	@ResponseBody
	public boolean changePassword(User user) {
		boolean flag = this.userServiceInter.changePasswordService(user);
		return flag;
	}
	
	@RequestMapping("delUserById")
	@ResponseBody
	public boolean delDempById(User user) {
		boolean flag = this.userServiceInter.delUserService(user);
		return flag;
	}
	
	@RequestMapping("insertUser")
	@ResponseBody
	public boolean insertUser(User user) {
		this.userServiceInter.insertUserService(user);
		return true;
	}
	
	@RequestMapping("checkUsername")
	@ResponseBody
	public String checkUsername(User user) {
		String flag = this.userServiceInter.checkUsernameService(user);
		return flag;
	}
	
	@RequestMapping("queryTouristByIdentity")
	public String queryTouristByIdentity(HttpServletRequest req,String currpage) {
		this.userServiceInter.queryUserByIdentityService(req, currpage, true);
		return "coach/tourist_list";
	}
	
	@RequestMapping("queryUserIdentityById")
	public String queryUserIdentityByIdCtrl(HttpServletRequest req, User user) {
		User userInstance = this.userServiceInter.getUserByIdService(user);
		req.setAttribute("User", userInstance);
		return "coach/user_update";
	}
	@RequestMapping("updateUserByIdentity")
	@ResponseBody
	public boolean updateUserByIdentity(User user,String flag) {
		this.userServiceInter.updateUserByIdentityService(user, flag);
		return true;
	}
	
	@RequestMapping("queryMemberByIdentity")
	public String queryMenberByIdentity(HttpServletRequest req,String currpage) {
		this.userServiceInter.queryUserByIdentityService(req, currpage, false);
		return "coach/member_list";
	}
	//管理员查询教练收入
	@RequestMapping("queryUserincome")
	public String queryUserincome(HttpServletRequest req,String currpage) {
		this.userServiceInter.queryUserincome(req, currpage);
		return "admin/income";
	}
	
}
