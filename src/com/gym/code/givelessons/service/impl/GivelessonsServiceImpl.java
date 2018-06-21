package com.gym.code.givelessons.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.givelessons.dao.GivelessonsDaoInter;
import com.gym.code.givelessons.service.GivelessonsServiceInter;
import com.gym.code.model.Givelessons;

@Service
public class GivelessonsServiceImpl implements GivelessonsServiceInter {

	@Autowired
	public GivelessonsDaoInter givelessonsDaoInter;	
	@Override
	public void queryGivelessonsDao(HttpServletRequest req, String currpage) {
		this.givelessonsDaoInter.queryGivelessonsDao(req, Integer.parseInt(currpage));
	}
	@Override
	public void insertGivelessons(Givelessons givelessons) {
		this.givelessonsDaoInter.insertGivelessons(givelessons);
	}

}
