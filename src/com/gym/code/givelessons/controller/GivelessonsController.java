package com.gym.code.givelessons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gym.code.givelessons.service.GivelessonsServiceInter;

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
}
