package com.imooc.miaosha.redis;

/**
 * @author zhangke
 * @version 1.0
 * @description 模板模式的接口
 * @date 2:24 PM 2019/12/9
 **/
public interface KeyPrefix {
	/**
	 * 过期时间
	 * @return
	 */
	public int expireSeconds();

	/**
	 * 前缀
	 * @return
	 */
	public String getPrefix();

}
