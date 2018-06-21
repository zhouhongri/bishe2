package com.gym.code.exchange.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.code.exchange.dao.ExchangeDaoInter;
import com.gym.code.exchange.service.ExchangeServiceInter;
import com.gym.code.goods.dao.GoodsDaoInter;
import com.gym.code.integral.dao.IntegralDaoInter;
import com.gym.code.model.Exchange;
import com.gym.code.model.Goods;
import com.gym.code.model.Integral;
import com.gym.code.model.User;

@Service
public class ExchangeServiceImpl implements ExchangeServiceInter {

	@Autowired
	public ExchangeDaoInter exchangeDaoInter;
	@Autowired
	public GoodsDaoInter goodsDaoInter;
	@Autowired
	public IntegralDaoInter integralDaoInter;
	
	@Override
	public boolean insertExchangeService(Exchange exchange, Goods goods, String subNum) {
		User user = new User();
		user.setUserId(exchange.getUserId());
		Integral integral = this.integralDaoInter.getIntegralByUserIdDao(user);
		if(integral.getIntegralNum()>=goods.getGoodsIntegral()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());
			exchange.setExchangeNum(Integer.parseInt(subNum));
			exchange.setExchangeTime(time);
			this.goodsDaoInter.updateGoodsNumById(subNum, goods.getGoodsId());
			this.integralDaoInter.updateIntegralNumByUserIdDao(goods.getGoodsIntegral()*Integer.parseInt(subNum), exchange.getUserId());
			this.exchangeDaoInter.insertExchangeDao(exchange);
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void queryExchangeService(HttpServletRequest req, String currpage) {
		this.exchangeDaoInter.queryExchangeDao(req, Integer.parseInt(currpage));
	}
	@Override
	public void queryExchangeadmin(HttpServletRequest req, String currpage) {
		this.exchangeDaoInter.queryExchangeadmin(req, Integer.parseInt(currpage));
	}
	@Override
	public Exchange queryExchangeByIdService(Exchange exchange) {
		return this.queryExchangeByIdService(exchange);
	}
	@Override
	public boolean updateExchangeByIdService(Exchange exchange) {
		int num = this.exchangeDaoInter.updateExchangeByIdDao(exchange);
		if(num==1){
			return true;
		}else{
			return false;
		}
	}
	
}
