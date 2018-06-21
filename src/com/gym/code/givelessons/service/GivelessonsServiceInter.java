package com.gym.code.givelessons.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Givelessons;

public interface GivelessonsServiceInter {
	public void queryGivelessonsDao(HttpServletRequest req,String currpage);
	public void insertGivelessons(Givelessons givelessons);
}
