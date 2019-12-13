package com.imooc.miaosha.util;

import java.util.UUID;
/**
 * @description UUID工具类
 * @author zhangke
 * @date 4:25 PM 2019/12/9
 * @version 1.0
 **/
public class UUIDUtil {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
