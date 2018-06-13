package com.gym.code.goods.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.code.goods.service.GoodsServiceInter;
import com.gym.code.model.Goods;

@Controller
@RequestMapping("goodsCtrl")
public class GoodsController {
	@Autowired
	public GoodsServiceInter goodsServiceInter;
	
	@RequestMapping("queryGoods")
	public String queryGoods(HttpServletRequest req,String currpage) {
		this.goodsServiceInter.queryGoodsService(req, currpage);
		return "admin/goodss";
	}
	
	@RequestMapping("queryGoodsById")
	public String queryGoodsByIdCtrl(HttpServletRequest req, Goods goods) {
		Goods GoodsInstance = this.goodsServiceInter.getGoodsByIdService(goods);
		req.setAttribute("Goods", GoodsInstance);
		return "admin/goodss_update";
	}
	
	@RequestMapping("updateGoods")
	public String updateDemp(Goods goods) {
		this.goodsServiceInter.updateGoodsService(goods);
		return "redirect:/goodsCtrl/queryGoods?currpage=1";
	}
	
	@RequestMapping("delGoodsById")
	@ResponseBody
	public String delDempById(Goods goods) {
		String flag = this.goodsServiceInter.delGoodsService(goods);
		return flag;
	}
	
	@RequestMapping("insertGoods")
	public String insertGoods(Goods goods) {
		this.goodsServiceInter.insertGoodsService(goods);
		return "redirect:/goodsCtrl/queryGoods?currpage=1";
	}
	
	@RequestMapping("checkGoodsname")
	@ResponseBody
	public String checkGoodsname(Goods goods) {
		String flag = this.goodsServiceInter.checkGoodsnameService(goods);
		return flag;
	}
}
