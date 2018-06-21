package com.gym.code.goods.service;

import javax.servlet.http.HttpServletRequest;

import com.gym.code.model.Goods;

public interface GoodsServiceInter {
	public Goods getGoodsByIdService(Goods goods);
	public void insertGoodsService(Goods goods);
	public boolean delGoodsService(Goods goods);
	public void updateGoodsService(Goods goods);
	public void queryGoodsService(HttpServletRequest req, String currpage, boolean flag);
	public String checkGoodsnameService(Goods goods);
}
