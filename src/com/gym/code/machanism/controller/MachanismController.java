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
		return "admin/machanisms";
	}
	
	@RequestMapping("queryMachanismById")
	public String queryMachanismByIdCtrl(HttpServletRequest req, Machanism machanism) {
		Machanism MachanismInstance = this.machanismServiceInter.getMachanismByIdService(machanism);
		req.setAttribute("Machanism", MachanismInstance);
		return "admin/machanisms_update";
	}
	
	@RequestMapping("updateMachanism")
	public String updateDemp(Machanism machanism) {
		this.machanismServiceInter.updateMachanismService(machanism);
		return "redirect:/machanismCtrl/queryMachanism?currpage=1";
	}
	
	@RequestMapping("delMachanismById")
	@ResponseBody
	public String delDempById(Machanism machanism) {
		String flag = this.machanismServiceInter.delMachanismService(machanism);
		return flag;
	}
	
	@RequestMapping("insertMachanism")
	public String insertMachanism(Machanism machanism) {
		this.machanismServiceInter.insertMachanismService(machanism);
		return "redirect:/machanismCtrl/queryMachanism?currpage=1";
	}
	
	@RequestMapping("checkMachanismname")
	@ResponseBody
	public String checkMachanismname(Machanism machanism) {
		String flag = this.machanismServiceInter.checkMachanismnameService(machanism);
		return flag;
	}
}
