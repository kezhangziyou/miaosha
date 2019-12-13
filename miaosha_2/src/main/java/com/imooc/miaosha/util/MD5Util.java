package com.imooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * @description md5的工具类
 * @author zhangke
 * @date 2:53 PM 2019/12/9
 * @version 1.0
 **/
public class MD5Util {
	/**
	 * md5加密
	 * @param src
	 * @return
	 */
	public static String md5(String src) {
		return DigestUtils.md5Hex(src);
	}
	
	private static final String salt = "1a2b3c4d";

	/**
	 * 把用户输入的密码转我为 md5密码
	 *
	 * @param inputPass 用户输入的密码
	 * @return
	 */
	public static String inputPassToFormPass(String inputPass) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
		System.out.println(str);
		return md5(str);
	}

	/**
	 * 把表单里面的 password再加密一次 md5存储到数据库
	 * @param formPass 表单的密码
	 * @param salt 随机加密的盐
	 * @return
	 */
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
		return md5(str);
	}

	/**
	 *
	 * @param inputPass
	 * @param saltDB
	 * @return
	 */
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		String formPass = inputPassToFormPass(inputPass);
		String dbPass = formPassToDBPass(formPass, saltDB);
		return dbPass;
	}
	
	public static void main(String[] args) {
		System.out.println(inputPassToFormPass("123456"));//d3b1294a61a07da9b49b6e22b2cbd7f9
//		System.out.println(formPassToDBPass(inputPassToFormPass("123456"), "1a2b3c4d"));
//		System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));//b7797cce01b4b131b433b6acf4add449
	}
	
}
