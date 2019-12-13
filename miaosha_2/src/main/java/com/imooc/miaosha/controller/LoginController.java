package com.imooc.miaosha.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.MiaoshaUserService;
import com.imooc.miaosha.vo.LoginVo;
/**
 * @description 登录控制器
 * @author zhangke
 * @date 3:33 PM 2019/12/9
 * @version 1.0
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MiaoshaUserService miaoshaUserService;
	
	@Autowired
	RedisService redisService;

	/**
	 *登录页面，http://localhost:8080/login/to_login，18912341234，123456；17671718605 111111
	 * @return
	 */
    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

	/**
	 *登录校验，登录成功后会跳转到商品页面
	 * @param response
	 * @param loginVo
	 * @return
	 */
    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
    	log.info(loginVo.toString());
    	//登录
		miaoshaUserService.login(response, loginVo);
    	return Result.success(true);
    }
}
