package com.gym.code.integral.dao.impl;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.integral.dao.IntegralDaoInter;
import com.gym.code.model.Integral;
import com.gym.code.model.User;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class IntegralDaoImpl extends BaseDao implements IntegralDaoInter{

	@Override
	public Integral getIntegralByIdDao(Integral integral) {
		Session session = this.getSession();
		Integral IntegralInstance = (Integral) session.get(integral.getClass(), integral.getIntegralId());
		return IntegralInstance;
	}

	@Override
	public void insertIntegralDao(Integral integral) {
		Session session = this.getSession();
		session.save(integral);
	}

	@Override
	public int delIntegralDao(Integral integral) {
		Session session = this.getSession();
		String hql = "delete from Integral where IntegralId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, integral.getIntegralId());
		return query.executeUpdate();
	}

	@Override
	public void updateIntegralDao(Integral integral) {
		Session session = this.getSession();
		session.update(integral);
	}

	@Override
	public void queryIntegralDao(HttpServletRequest req, int currpage) {
		String sql = "select * from Integral";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public Integral getIntegralByUserIdDao(User user) {
		Session session = this.getSession();
		String hql = "from Integral where userId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, user.getUserId());
		if(query.list().size()>0) {
			return (Integral) query.list().get(0);
		}else {
			return null;
		}
	}

	@Override
	public int updateIntegralNumByUserIdDao(Integer goodsIntegral, Integer userId) {
		Session session = this.getSession();
		String hql = "update Integral set integralNum=integralNum-"+goodsIntegral+" where userId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, userId);
		return query.executeUpdate();
	}
	
}
