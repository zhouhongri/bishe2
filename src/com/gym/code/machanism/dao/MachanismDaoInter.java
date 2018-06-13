package com.gym.code.machanism.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Machanism;

public interface MachanismDaoInter {
	public Machanism getMachanismByIdDao(Machanism machanism);
	public void insertMachanismDao(Machanism machanism);
	public int delMachanismDao(Machanism machanism);
	public void updateMachanismDao(Machanism machanism);
	public void queryMachanismDao(HttpServletRequest req,int currpage);
	public List checkMachanismnameDao(Machanism machanism);
}
