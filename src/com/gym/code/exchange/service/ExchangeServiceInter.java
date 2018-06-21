package com.gym.code.exchange.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Exchange;
import com.gym.code.model.Goods;

public interface ExchangeServiceInter {
	public boolean insertExchangeService(Exchange exchange, Goods goods, String subNum);
	public void queryExchangeService(HttpServletRequest req,String currpage);
	public void queryExchangeadmin(HttpServletRequest req,String currpage);
	public Exchange queryExchangeByIdService(Exchange exchange);
	public boolean updateExchangeByIdService(Exchange exchange);
}
