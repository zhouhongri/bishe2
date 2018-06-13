package com.gym.code.model;
// Generated 2018-6-12 10:00:57 by Hibernate Tools 4.0.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Exchange generated by hbm2java
 */
@Entity
@Table(name = "exchange", catalog = "gym")
public class Exchange implements java.io.Serializable {

	private Integer exchangeId;
	private Integer userId;
	private Integer goodsId;

	public Exchange() {
	}

	public Exchange(Integer userId, Integer goodsId) {
		this.userId = userId;
		this.goodsId = goodsId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "exchange_id", unique = true, nullable = false)
	public Integer getExchangeId() {
		return this.exchangeId;
	}

	public void setExchangeId(Integer exchangeId) {
		this.exchangeId = exchangeId;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "goods_id")
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

}