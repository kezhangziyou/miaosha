package com.imooc.miaosha.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.dao.MiaoshaUserDao;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.exception.GlobalException;
import com.imooc.miaosha.redis.MiaoshaUserKey;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.util.MD5Util;
import com.imooc.miaosha.util.UUIDUtil;
import com.imooc.miaosha.vo.LoginVo;
/**
 * @description
 * @author zhangke
 * @date 4:03 PM 2019/12/9
 * @version 1.0
 **/
@Service
public class MiaoshaUserService {
	
	
	public static final String COOKI_NAME_TOKEN = "token";
	
	@Autowired
	MiaoshaUserDao miaoshaUserDao;
	
	@Autowired
	RedisService redisService;

	/**
	 * 通过 id 得到用户信息
	 * @param id 手机号
	 * @return
	 */
	public MiaoshaUser getById(long id) {
		return miaoshaUserDao.getById(id);
	}

	/**
	 * 通过 token 在 redis缓存中取出token对应的用户信息
	 * @param response
	 * @param token
	 * @return
	 */
	public MiaoshaUser getByToken(HttpServletResponse response, String token) {
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		MiaoshaUser user = redisService.get(MiaoshaUserKey.token, token, MiaoshaUser.class);
		//延长有效期,意思就是重新再缓存设置值,然后再返回 cookie
		if(user != null) {
			addCookie(response, token, user);
		}
		return user;
	}

	/**
	 * 登录
	 * @param response
	 * @param loginVo 登录表单
	 * @return
	 */
	public boolean login(HttpServletResponse response, LoginVo loginVo) {
		if(loginVo == null) {
			throw new GlobalException(CodeMsg.SERVER_ERROR);
		}
		//拿到 from 表单的密码
		String mobile = loginVo.getMobile();
		String formPass = loginVo.getPassword();
		//判断手机号是否存在，id 即为手机号
		MiaoshaUser user = getById(Long.parseLong(mobile));
		if(user == null) {
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		//验证密码与用户查询的密码时候相同
		String dbPass = user.getPassword();
		String saltDB = user.getSalt();
		//两次加密的密码
		String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
		//用户输入的加密密码和数据库的是否相同
		if(!calcPass.equals(dbPass)) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		//登录成功后,生成随机cookie
		String token = UUIDUtil.uuid();
		//response 中返回 cookie,下次再请求的时候会再 requset中,
		// 没有产生一个新的 cookie,把旧的 cookie 放进去就够了
		addCookie(response, token, user);
		return true;
	}

	/**
	 * 把生成的 token 和用户绑定存在redis中
	 * @param response 返回对象response
	 * @param token
	 * @param user
	 */
	private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {
		redisService.set(MiaoshaUserKey.token, token, user);
		Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
		//设置 Cookie 的有效期
		cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
