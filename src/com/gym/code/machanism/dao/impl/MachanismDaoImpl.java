package com.gym.code.machanism.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.machanism.dao.MachanismDaoInter;
import com.gym.code.model.Machanism;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class MachanismDaoImpl extends BaseDao implements MachanismDaoInter{

	@Override
	public Machanism getMachanismByIdDao(Machanism machanism) {
		Session session = this.getSession();
		Machanism machanismInstance = (Machanism) session.get(machanism.getClass(), machanism.getMachanismId());
		return machanismInstance;
	}

	@Override
	public void insertMachanismDao(Machanism machanism) {
		Session session = this.getSession();
		session.save(machanism);
	}

	@Override
	public int delMachanismDao(Machanism machanism) {
		Session session = this.getSession();
		String hql = "delete from Machanism where MachanismId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, machanism.getMachanismId());
		return query.executeUpdate();
	}

	@Override
	public void updateMachanismDao(Machanism machanism) {
		Session session = this.getSession();
		session.update(machanism);
	}

	@Override
	public void queryMachanismDao(HttpServletRequest req, int currpage) {
		String sql = "select * from Machanism";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public List checkMachanismnameDao(Machanism machanism) {
		Session session = this.getSession();
		String hql = "from Machanism where machanismName=?";
		Query query = session.createQuery(hql);
		query.setString(0, machanism.getMachanismName());
		return query.list();
	}
	
}
