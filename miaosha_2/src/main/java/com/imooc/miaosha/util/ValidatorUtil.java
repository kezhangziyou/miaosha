package com.imooc.miaosha.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
/**
 * @description 手机号验证的 utils
 * @author zhangke
 * @date 3:13 PM 2019/12/9
 * @version 1.0
 **/
public class ValidatorUtil {
	/**
	 * 1开头后面10位数字的正则表达式
	 */
	private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");
	
	public static boolean isMobile(String src) {
		if(StringUtils.isEmpty(src)) {
			return false;
		}
		Matcher m = mobile_pattern.matcher(src);
		return m.matches();
	}
	
//	public static void main(String[] args) {
//			System.out.println(isMobile("18912341234"));
//			System.out.println(isMobile("1891234123"));
//	}
}
