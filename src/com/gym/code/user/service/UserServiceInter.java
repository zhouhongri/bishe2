package com.gym.code.user.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.User;

public interface UserServiceInter {
	public User getUserByIdService(User user);
	public void insertUserService(User user);
	public String delUserService(User user);
	public void updateUserService(User user);
	public void queryUserService(HttpServletRequest req,String currpage);
	public String checkUsernameService(User user);
}
