package com.gym.code.user.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.User;

public interface UserServiceInter {
	public User getUserByIdService(User user);
	public void insertUserService(User user);
	public boolean delUserService(User user);
	public void updateUserService(User user);
	public void queryUserService(HttpServletRequest req,String currpage);
	public String checkUsernameService(User user);
	public boolean changePasswordService(User user);
	public void queryUserByIdentityService(HttpServletRequest req,String currpage, boolean flag);
	public void updateUserByIdentityService(User user, String flag);
}
