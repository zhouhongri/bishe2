package com.gym.code.pay.dao;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Pay;

public interface PayDaoInter {
	public void insertPayDao(Pay pay);
	public void queryPayDao(HttpServletRequest req,int currpage);
}
