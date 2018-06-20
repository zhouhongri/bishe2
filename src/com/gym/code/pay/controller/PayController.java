package com.gym.code.pay.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.model.Pay;
import com.gym.code.pay.service.PayServiceInter;

@Controller
@RequestMapping("payCtrl")
public class PayController {

	@Autowired
	public PayServiceInter payServiceInter;
	
	@RequestMapping("insertPay")
	@ResponseBody
	public boolean insertPayCtrl(Pay pay) {
		this.payServiceInter.insertPayService(pay);
		return true;
	}
	@RequestMapping("queryPay")
	public String queryPayCtrl(HttpServletRequest req,String currpage) {
		this.payServiceInter.queryPayService(req, currpage);
		return "tourist/pay_list";
	}
}
