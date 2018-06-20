package com.gym.code.pay.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Pay;

public interface PayServiceInter {
	public void insertPayService(Pay pay);
	public void queryPayService(HttpServletRequest req,String currpage);
}
