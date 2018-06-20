package com.gym.code.machanism.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Machanism;

public interface MachanismServiceInter {
	public Machanism getMachanismByIdService(Machanism machanism);
	public void insertMachanismService(Machanism machanism);
	public boolean delMachanismService(Machanism machanism);
	public void updateMachanismService(Machanism machanism);
	public void queryMachanismService(HttpServletRequest req,String currpage);
	public String checkMachanismnameService(Machanism machanism);
}
