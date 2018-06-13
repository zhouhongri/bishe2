package com.gym.code.goods.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.goods.dao.GoodsDaoInter;
import com.gym.code.goods.service.GoodsServiceInter;
import com.gym.code.model.Goods;

@Service
public class GoodsServiceImpl implements GoodsServiceInter{
	
	@Autowired
	public GoodsDaoInter goodsDaoInter;
	
	@Override
	public Goods getGoodsByIdService(Goods goods) {
		Goods GoodsInstance = this.goodsDaoInter.getGoodsByIdDao(goods);
		return GoodsInstance;
	}

	@Override
	public void insertGoodsService(Goods goods) {
		this.goodsDaoInter.insertGoodsDao(goods);
	}

	@Override
	public String delGoodsService(Goods goods) {
		int num = this.goodsDaoInter.delGoodsDao(goods);
		if(num == 1) {
			return "success";
		}else {
			return "false";
		}
	}

	@Override
	public void updateGoodsService(Goods goods) {
		this.goodsDaoInter.updateGoodsDao(goods);
	}

	@Override
	public void queryGoodsService(HttpServletRequest req, String currpage) {
		int intcurrpage = Integer.parseInt(currpage);
		this.goodsDaoInter.queryGoodsDao(req, intcurrpage);
	}

	@Override
	public String checkGoodsnameService(Goods goods) {
		List list = this.goodsDaoInter.checkGoodsnameDao(goods);
		if(list.size()>0) {
			return "exist";
		}else {
			return "noexist";
		}
	}
	
}
