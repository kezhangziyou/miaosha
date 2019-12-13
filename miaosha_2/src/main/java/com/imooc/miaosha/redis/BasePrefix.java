package com.imooc.miaosha.redis;

/**
 * @author zhangke
 * @version 1.0
 * @description 基础前缀类
 * @date 2:24 PM 2019/12/9
 **/
public abstract class BasePrefix implements KeyPrefix {
	/**
	 * 过期时间
	 */
	private int expireSeconds;

	private String prefix;

	/**
	 * 0代表永不过期
	 * @param prefix
	 */
	public BasePrefix(String prefix) {
		this(0, prefix);
	}

	public BasePrefix(int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	@Override
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className + ":" + prefix;
	}

}
