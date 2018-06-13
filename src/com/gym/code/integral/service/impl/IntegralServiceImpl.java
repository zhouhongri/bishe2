package com.gym.code.integral.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.integral.dao.IntegralDaoInter;
import com.gym.code.integral.service.IntegralServiceInter;
import com.gym.code.model.Integral;
import com.gym.code.model.User;

@Service
public class IntegralServiceImpl implements IntegralServiceInter{
	
	@Autowired
	public IntegralDaoInter integralDaoInter;
	
	@Override
	public Integral getIntegralByIdService(Integral integral) {
		Integral IntegralInstance = this.integralDaoInter.getIntegralByIdDao(integral);
		return IntegralInstance;
	}

	@Override
	public void insertIntegralService(Integral integral) {
		this.integralDaoInter.insertIntegralDao(integral);
	}

	@Override
	public String delIntegralService(Integral integral) {
		int num = this.integralDaoInter.delIntegralDao(integral);
		if(num == 1) {
			return "success";
		}else {
			return "false";
		}
	}

	@Override
	public void updateIntegralService(Integral integral) {
		this.integralDaoInter.updateIntegralDao(integral);
	}

	@Override
	public void queryIntegralService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.integralDaoInter.queryIntegralDao(req, intcurrpage);
	}

	@Override
	public Integral getIntegralByUserIdService(User user) {
		return this.integralDaoInter.getIntegralByUserIdDao(user);
	}

}
