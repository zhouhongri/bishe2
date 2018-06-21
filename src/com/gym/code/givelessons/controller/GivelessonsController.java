package com.gym.code.givelessons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.givelessons.service.GivelessonsServiceInter;
import com.gym.code.model.Givelessons;

@Controller
@RequestMapping("givelessonsCtrl")
public class GivelessonsController {
	
	@Autowired
	public GivelessonsServiceInter givelessonsServiceInter;
	@RequestMapping("queryGivelessons")
	public String queryGivelessons(HttpServletRequest req,String currpage) {
		this.givelessonsServiceInter.queryGivelessonsDao(req, currpage);
		return "coach/timetable_list";
	}
	//管理员添加课程与教练关系
		@RequestMapping("insertGivelessons")
		@ResponseBody
		public boolean insertGivelessons(Givelessons givelessons) {
			this.givelessonsServiceInter.insertGivelessons(givelessons);
			return true;
		}
	
}
