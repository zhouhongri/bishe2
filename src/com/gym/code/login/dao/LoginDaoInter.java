package com.gym.code.login.dao;

import java.util.List;

import com.gym.code.model.User;

public interface LoginDaoInter {
	public List<User> getUserByName(String username);
	public void updateUserprelogintime(String time, User user);
}
