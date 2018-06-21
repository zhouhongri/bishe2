package com.gym.code.user.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.integral.dao.IntegralDaoInter;
import com.gym.code.model.Integral;
import com.gym.code.model.User;
import com.gym.code.user.dao.UserDaoInter;
import com.gym.code.user.service.UserServiceInter;

@Service
public class UserServiceImpl implements UserServiceInter{
	
	@Autowired
	public UserDaoInter userDaoInter;
	@Autowired
	public IntegralDaoInter integralDaoInter; 
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
	public boolean delUserService(User user) {
		int num = this.userDaoInter.delUserDao(user);
		if(num == 1) {
			return true;
		}else {
			return false;
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

	@Override
	public boolean changePasswordService(User user) {
		int num = this.userDaoInter.changePasswordDao(user);
		if(num==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void queryUserByIdentityService(HttpServletRequest req, String currpage, boolean flag) {
		int intcurrpage = Integer.parseInt(currpage);
		this.userDaoInter.queryUserByIdentityDao(req, intcurrpage, flag);
	}

	@Override
	public void updateUserByIdentityService(User user, String flag) {
		if("tourist".equals(flag)) {
			Integral integral = new Integral();
			integral.setIntegralNum(0);
			integral.setUserId(user.getUserId());
			this.integralDaoInter.insertIntegralDao(integral);
		}
		this.userDaoInter.updateUserDao(user);
		this.integralDaoInter.updateIntegralNumByUserIdDao(user.getUserId());
	}
	
	@Override
	public void queryUserincome(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.userDaoInter.queryUserincome(req, intcurrpage);
	}

	
}
