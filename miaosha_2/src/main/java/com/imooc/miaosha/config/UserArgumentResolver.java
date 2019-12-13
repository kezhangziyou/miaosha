package com.imooc.miaosha.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.service.MiaoshaUserService;
/**
 * @description 参数分解器
 * @author zhangke
 * @date 4:25 PM 2019/12/9
 * @version 1.0
 **/
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

	@Autowired
	MiaoshaUserService userService;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		//如果函数包含我们的自定义注解，那就走resolveArgument()函数
		Class<?> clazz = parameter.getParameterType();
		return clazz==MiaoshaUser.class;
	}
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		//校验request中的参数
		String paramToken = request.getParameter(MiaoshaUserService.COOKI_NAME_TOKEN);
		String cookieToken = getCookieValue(request, MiaoshaUserService.COOKI_NAME_TOKEN);
		if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
			return null;
		}
		String token = StringUtils.isEmpty(paramToken)?cookieToken:paramToken;
		return userService.getByToken(response, token);
	}

	/**
	 * 得到 cookie的value值
	 * @param request
	 * @param cookieName cookie 的 key
	 * @return
	 */
	private String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie[]  cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
	}

}
