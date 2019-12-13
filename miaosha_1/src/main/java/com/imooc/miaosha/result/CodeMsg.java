package com.imooc.miaosha.result;
/**
 * @description 状态错误码
 * @author zhangke
 * @date 6:03 PM 2019/12/12
 * @version 1.0
 **/
public class CodeMsg {
	/**
	 * 错误码
	 */
	private int code;
	/**
	 * 错误消息
	 */
	private String msg;
	
	/**
	 * 通用异常
	 */
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	//登录模块 5002XX
	
	//商品模块 5003XX
	
	//订单模块 5004XX
	
	//秒杀模块 5005XX
	
	
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
