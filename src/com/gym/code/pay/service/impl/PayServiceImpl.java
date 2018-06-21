package com.gym.code.pay.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.integral.dao.IntegralDaoInter;
import com.gym.code.model.Pay;
import com.gym.code.pay.dao.PayDaoInter;
import com.gym.code.pay.service.PayServiceInter;

@Service
public class PayServiceImpl implements PayServiceInter {

	@Autowired
	public PayDaoInter payDaoInter;
	@Autowired
	public IntegralDaoInter integralDaoInter;
	@Override
	public void insertPayService(Pay pay) {
		this.integralDaoInter.updateIntegralNumByUserIdDao(pay.getUserId());
		this.payDaoInter.insertPayDao(pay);
	}
	@Override
	public void queryPayService(HttpServletRequest req, String currpage) {
		this.payDaoInter.queryPayDao(req, Integer.parseInt(currpage));
	}

}
