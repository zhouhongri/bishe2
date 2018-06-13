package com.gym.code.machanism.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.machanism.dao.MachanismDaoInter;
import com.gym.code.machanism.service.MachanismServiceInter;
import com.gym.code.model.Machanism;

@Service
public class MachanismServiceImpl implements MachanismServiceInter{
	
	@Autowired
	public MachanismDaoInter machanismDaoInter;
	
	@Override
	public Machanism getMachanismByIdService(Machanism machanism) {
		Machanism MachanismInstance = this.machanismDaoInter.getMachanismByIdDao(machanism);
		return MachanismInstance;
	}

	@Override
	public void insertMachanismService(Machanism machanism) {
		this.machanismDaoInter.insertMachanismDao(machanism);
	}

	@Override
	public String delMachanismService(Machanism machanism) {
		int num = this.machanismDaoInter.delMachanismDao(machanism);
		if(num == 1) {
			return "success";
		}else {
			return "false";
		}
	}

	@Override
	public void updateMachanismService(Machanism machanism) {
		this.machanismDaoInter.updateMachanismDao(machanism);
	}

	@Override
	public void queryMachanismService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.machanismDaoInter.queryMachanismDao(req, intcurrpage);
	}

	@Override
	public String checkMachanismnameService(Machanism machanism) {
		List list = this.machanismDaoInter.checkMachanismnameDao(machanism);
		if(list.size()>0) {
			return "exist";
		}else {
			return "noexist";
		}
	}
	
}
