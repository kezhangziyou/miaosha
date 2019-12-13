package com.imooc.miaosha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @description controller的方法参数赋值器处理函数参数的分解器的 springboot 的配置
 * @author zhangke
 * @date 4:25 PM 2019/12/9
 * @version 1.0
 **/
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter{
	
	@Autowired
	UserArgumentResolver userArgumentResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(userArgumentResolver);
	}
	
	
}
