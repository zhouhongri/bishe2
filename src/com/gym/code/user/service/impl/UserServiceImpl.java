package com.gym.code.user.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.model.User;
import com.gym.code.user.dao.UserDaoInter;
import com.gym.code.user.service.UserServiceInter;

@Service
public class UserServiceImpl implements UserServiceInter{
	
	@Autowired
	public UserDaoInter userDaoInter;
	
	@Override
	public User getUserByIdService(User user) {
		User userInstance = this.userDaoInter.getUserByIdDao(user);
		return userInstance;
	}

	@Override
	public void insertUserService(User user) {
		this.userDaoInter.insertUserDao(user);
	}

	@Override
	public String delUserService(User user) {
		int num = this.userDaoInter.delUserDao(user);
		if(num == 1) {
			return "success";
		}else {
			return "false";
		}
	}

	@Override
	public void updateUserService(User user) {
		this.userDaoInter.updateUserDao(user);
	}

	@Override
	public void queryUserService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.userDaoInter.queryUserDao(req, intcurrpage);
	}

	@Override
	public String checkUsernameService(User user) {
		List list = this.userDaoInter.checkUsernameDao(user);
		if(list.size()>0) {
			return "exist";
		}else {
			return "noexist";
		}
	}
	
}
