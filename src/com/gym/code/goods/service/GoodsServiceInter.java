package com.gym.code.goods.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Goods;

public interface GoodsServiceInter {
	public Goods getGoodsByIdService(Goods goods);
	public void insertGoodsService(Goods goods);
	public String delGoodsService(Goods goods);
	public void updateGoodsService(Goods goods);
	public void queryGoodsService(HttpServletRequest req,String currpage);
	public String checkGoodsnameService(Goods goods);
}
