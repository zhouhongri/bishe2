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
		this.goodsServiceInter.queryGoodsService(req, currpage, true);
		return "member/good_list";
	}
	
	@RequestMapping("queryGoodsById")
	public String queryGoodsByIdCtrl(HttpServletRequest req, Goods goods) {
		Goods goodsInstance = this.goodsServiceInter.getGoodsByIdService(goods);
		req.setAttribute("Goods", goodsInstance);
		return "member/good_update";
	}
	
	@RequestMapping("updateGoods")
	@ResponseBody
	public boolean updateDemp(Goods goods) {
		this.goodsServiceInter.updateGoodsService(goods);
		return true;
	}
	
	@RequestMapping("delGoodsById")
	@ResponseBody
	public boolean delDempById(Goods goods) {
		boolean flag = this.goodsServiceInter.delGoodsService(goods);
		return flag;
	}
	
	@RequestMapping("insertGoods")
	@ResponseBody
	public boolean insertGoods(Goods goods) {
		this.goodsServiceInter.insertGoodsService(goods);
		return true;
	}
	
	@RequestMapping("checkGoodsname")
	@ResponseBody
	public String checkGoodsname(Goods goods) {
		String flag = this.goodsServiceInter.checkGoodsnameService(goods);
		return flag;
	}
	//管理员查询商品
	@RequestMapping("queryGoodsadmin")
	public String queryGoodsadmin(HttpServletRequest req,String currpage) {
		this.goodsServiceInter.queryGoodsService(req, currpage, false);
		return "admin/goods";
	}
	@RequestMapping("queryGoodsByIdadmin")
	public String queryGoodsByIdadmin(HttpServletRequest req, Goods goods) {
		Goods goodsInstance = this.goodsServiceInter.getGoodsByIdService(goods);
		req.setAttribute("Goods", goodsInstance);
		return "admin/good_update";
	}
}
