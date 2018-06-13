package com.gym.code.goods.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.gym.code.goods.dao.GoodsDaoInter;
import com.gym.code.model.Goods;

import framework.base.BaseDao;
import framework.util.PageUtil;

@Repository
public class GoodsDaoImpl extends BaseDao implements GoodsDaoInter{

	@Override
	public Goods getGoodsByIdDao(Goods goods) {
		Session session = this.getSession();
		Goods goodsInstance = (Goods) session.get(goods.getClass(), goods.getGoodsId());
		return goodsInstance;
	}

	@Override
	public void insertGoodsDao(Goods goods) {
		Session session = this.getSession();
		session.save(goods);
	}

	@Override
	public int delGoodsDao(Goods goods) {
		Session session = this.getSession();
		String hql = "delete from Goods where GoodsId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, goods.getGoodsId());
		return query.executeUpdate();
	}

	@Override
	public void updateGoodsDao(Goods goods) {
		Session session = this.getSession();
		session.update(goods);
	}

	@Override
	public void queryGoodsDao(HttpServletRequest req, int currpage) {
		String sql = "select * from Goods";
		PageUtil pageUtil = new PageUtil();
		pageUtil.doPage(sql, this.getSession(), req, currpage);
	}

	@Override
	public List checkGoodsnameDao(Goods goods) {
		Session session = this.getSession();
		String hql = "from Goods where goodsName=?";
		Query query = session.createQuery(hql);
		query.setString(0, goods.getGoodsName());
		return query.list();
	}
	
}
