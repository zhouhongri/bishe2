package com.gym.code.goods.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Goods;

public interface GoodsDaoInter {
	public Goods getGoodsByIdDao(Goods goods);
	public void insertGoodsDao(Goods goods);
	public int delGoodsDao(Goods goods);
	public void updateGoodsDao(Goods goods);
	public void queryGoodsDao(HttpServletRequest req,int currpage);
	public List checkGoodsnameDao(Goods goods);
	public int updateGoodsNumById(String subNum, Integer goodsId);
}
