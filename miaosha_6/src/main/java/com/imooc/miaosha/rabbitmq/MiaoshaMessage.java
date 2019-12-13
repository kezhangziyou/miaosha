package com.imooc.miaosha.rabbitmq;

import com.imooc.miaosha.domain.MiaoshaUser;

/**
 * @author zhangke
 * @version 1.0
 * @description 秒杀的消息
 * @date 1:59 PM 2019/12/12
 **/
public class MiaoshaMessage {
	private MiaoshaUser user;
	private long goodsId;

	public MiaoshaUser getUser() {
		return user;
	}

	public void setUser(MiaoshaUser user) {
		this.user = user;
	}

	public long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
}
