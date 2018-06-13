package com.gym.code.integral.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.integral.service.IntegralServiceInter;
import com.gym.code.model.Integral;
import com.gym.code.model.User;

@Controller
@RequestMapping("integralCtrl")
public class IntegralController {
	@Autowired
	public IntegralServiceInter integralServiceInter;
	
	@RequestMapping("queryIntegral")
	public String queryIntegral(HttpServletRequest req,String currpage) {
		this.integralServiceInter.queryIntegralService(req, currpage);
		return "admin/integrals";
	}
	
	@RequestMapping("queryIntegralById")
	public String queryIntegralByIdCtrl(HttpServletRequest req, Integral integral) {
		Integral integralInstance = this.integralServiceInter.getIntegralByIdService(integral);
		req.setAttribute("Integral", integralInstance);
		return "admin/integrals_update";
	}
	
	@RequestMapping("updateIntegral")
	public String updateDemp(Integral integral) {
		this.integralServiceInter.updateIntegralService(integral);
		return "redirect:/integralCtrl/queryIntegral?currpage=1";
	}
	
	@RequestMapping("delIntegralById")
	@ResponseBody
	public String delDempById(Integral integral) {
		String flag = this.integralServiceInter.delIntegralService(integral);
		return flag;
	}
	
	@RequestMapping("insertIntegral")
	public String insertIntegral(Integral integral) {
		this.integralServiceInter.insertIntegralService(integral);
		return "redirect:/integralCtrl/queryIntegral?currpage=1";
	}
	
	@RequestMapping("queryIntegralByUserId")
	@ResponseBody
	public Integral getIntegralByUserId(User user) {
		return this.integralServiceInter.getIntegralByUserIdService(user);
	}
}
