package com.imooc.miaosha.exception;

import com.imooc.miaosha.result.CodeMsg;
/**
 * @description 定义全局异常类
 * @author zhangke
 * @date 4:04 PM 2019/12/9
 * @version 1.0
 **/
public class GlobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private CodeMsg cm;
	
	public GlobalException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}

	public CodeMsg getCm() {
		return cm;
	}

}
