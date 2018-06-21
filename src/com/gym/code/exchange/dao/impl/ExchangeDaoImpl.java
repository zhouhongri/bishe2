package com.gym.code.exchange.dao.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.exchange.dao.ExchangeDaoInter;
import com.gym.code.model.Exchange;
import com.gym.code.model.User;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class ExchangeDaoImpl extends BaseDao implements ExchangeDaoInter {

	@Override
	public void insertExchangeDao(Exchange exchange) {
		Session session = this.getSession();
		session.save(exchange);
	}

	@Override
	public void queryExchangeDao(HttpServletRequest req, int currpage) {
		HttpSession session  = req.getSession();
		User user = (User) session.getAttribute("user");
		String sql = "select goods.*,exchange.exchange_time,exchange.exchange_num from goods,exchange " + 
				" where exchange.goods_id=goods.goods_id and exchange.user_id='"+user.getUserId()+"' ";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}
	
	@Override
	public void queryExchangeadmin(HttpServletRequest req, int currpage) {
		HttpSession session  = req.getSession();
		User user = (User) session.getAttribute("user");
		String sql = "select exchange.*,user.name,goods.goods_name from exchange,goods,user where exchange.goods_id=goods.goods_id and exchange.user_id=user.user_id";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public Exchange queryExchangeByIdDao(Exchange exchange) {
		Session session = this.getSession();
		return (Exchange) session.get(exchange.getClass(), exchange.getExchangeId());
	}

	@Override
	public int updateExchangeByIdDao(Exchange exchange) {
		Session session = this.getSession();
		String hql = "update Exchange set exchangeStatus=1 where exchangeId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, exchange.getExchangeId());
		return query.executeUpdate();
	}

}
