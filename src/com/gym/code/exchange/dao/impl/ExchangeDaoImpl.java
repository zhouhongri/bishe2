package com.gym.code.exchange.dao.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

}
