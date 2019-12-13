package com.imooc.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	//1.rest api json输出 2.页面
	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello() {
		return Result.success("hello,imooc");
		// return new Result(0, "success", "hello,imooc");
	}

	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloError() {
		return Result.error(CodeMsg.SERVER_ERROR);
		//return new Result(500102, "XXX");
	}

	/**
	 * @param model
	 * http://localhost:8080/demo/thymeleaf
	 * @return
	 */
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		//給页面添加一个绑定一个数据
		model.addAttribute("name", "Joshua");
		return "hello";
	}

}
