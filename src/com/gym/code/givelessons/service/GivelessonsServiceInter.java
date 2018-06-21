package com.gym.code.givelessons.service;

import javax.servlet.http.HttpServletRequest;

public interface GivelessonsServiceInter {
	public void queryGivelessonsDao(HttpServletRequest req,String currpage);
}
