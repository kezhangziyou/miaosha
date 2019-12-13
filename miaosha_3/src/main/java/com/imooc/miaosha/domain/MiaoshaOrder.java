package com.imooc.miaosha.domain;
/**
 * @description 秒杀订单
 * @author zhangke
 * @date 2:46 PM 2019/12/10
 * @version 1.0
 **/
public class MiaoshaOrder {
	private Long id;
	private Long userId;
	private Long  orderId;
	private Long goodsId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
}
