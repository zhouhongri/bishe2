package com.gym.code.exchange.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.exchange.service.ExchangeServiceInter;
import com.gym.code.model.Exchange;
import com.gym.code.model.Goods;

@Controller
@RequestMapping("exchangeCtrl")
public class ExchangeController {

	@Autowired
	public ExchangeServiceInter exchangeServiceInter;
	
	@RequestMapping("insertExchange")
	@ResponseBody
	public boolean insertPayCtrl(Exchange exchange, Goods goods, String subNum) {
		return this.exchangeServiceInter.insertExchangeService(exchange, goods, subNum);
	}
	@RequestMapping("queryExchange")
	public String queryPayCtrl(HttpServletRequest req,String currpage) {
		this.exchangeServiceInter.queryExchangeService(req, currpage);
		return "member/exchange_list";
	}
}
