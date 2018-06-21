package com.gym.code.givelessons.dao;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Givelessons;

public interface GivelessonsDaoInter {
	public void queryGivelessonsDao(HttpServletRequest req,int currpage);
	public void insertGivelessons(Givelessons givelessons);
}
