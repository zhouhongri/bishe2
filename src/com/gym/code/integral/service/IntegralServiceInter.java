package com.gym.code.integral.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Integral;
import com.gym.code.model.User;

public interface IntegralServiceInter {
	public Integral getIntegralByIdService(Integral integral);
	public void insertIntegralService(Integral integral);
	public String delIntegralService(Integral integral);
	public void updateIntegralService(Integral integral);
	public void queryIntegralService(HttpServletRequest req,String currpage);
	public Integral getIntegralByUserIdService(User user);
}
