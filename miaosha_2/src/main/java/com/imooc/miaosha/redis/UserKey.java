package com.imooc.miaosha.redis;
/**
 * @description user 的实现
 * @author zhangke
 * @date 2:40 PM 2019/12/9
 * @version 1.0
 **/
public class UserKey extends BasePrefix{

	private UserKey(String prefix) {
		super(prefix);
	}
	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
}
