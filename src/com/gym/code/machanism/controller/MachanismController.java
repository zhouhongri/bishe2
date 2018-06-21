package com.gym.code.machanism.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.machanism.service.MachanismServiceInter;
import com.gym.code.model.Machanism;

@Controller
@RequestMapping("machanismCtrl")
public class MachanismController {
	@Autowired
	public MachanismServiceInter machanismServiceInter;
	
	@RequestMapping("queryMachanism")
	public String queryMachanism(HttpServletRequest req,String currpage) {
		this.machanismServiceInter.queryMachanismService(req, currpage);
		return "admin/machanism";
	}
	
	@RequestMapping("queryMachanismById")
	public String queryMachanismByIdCtrl(HttpServletRequest req, Machanism machanism) {
		Machanism MachanismInstance = this.machanismServiceInter.getMachanismByIdService(machanism);
		req.setAttribute("Machanism", MachanismInstance);
		return "admin/machanism_update";
	}
	
	@RequestMapping("updateMachanism")
	@ResponseBody
	public boolean updateDemp(Machanism machanism) {
		this.machanismServiceInter.updateMachanismService(machanism);
		return true;
	}
	
	@RequestMapping("delMachanismById")
	@ResponseBody
	public boolean delDempById(Machanism machanism) {
		boolean flag = this.machanismServiceInter.delMachanismService(machanism);
		return flag;
	}
	
	@RequestMapping("insertMachanism")
	@ResponseBody
	public boolean insertMachanism(Machanism machanism) {
		this.machanismServiceInter.insertMachanismService(machanism);
		return true;
	}
	
	@RequestMapping("checkMachanismname")
	@ResponseBody
	public String checkMachanismname(Machanism machanism) {
		String flag = this.machanismServiceInter.checkMachanismnameService(machanism);
		return flag;
	}
}
