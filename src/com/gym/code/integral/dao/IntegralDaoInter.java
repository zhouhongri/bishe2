package com.gym.code.integral.dao;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Integral;
import com.gym.code.model.User;

public interface IntegralDaoInter {
	public Integral getIntegralByIdDao(Integral integral);
	public void insertIntegralDao(Integral integral);
	public int delIntegralDao(Integral integral);
	public void updateIntegralDao(Integral integral);
	public void queryIntegralDao(HttpServletRequest req,int currpage);
	public Integral getIntegralByUserIdDao(User user);
	public int updateIntegralNumByUserIdDao(Integer goodsIntegral, Integer userId);
	public int updateIntegralNumByUserIdDao(Integer userId);
}
