package com.gym.code.exchange.dao;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Exchange;

public interface ExchangeDaoInter {
	public void insertExchangeDao(Exchange exchange);
	public void queryExchangeDao(HttpServletRequest req,int currpage);
}
