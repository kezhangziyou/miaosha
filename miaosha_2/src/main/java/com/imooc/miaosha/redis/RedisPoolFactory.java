package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @description 构造RedisPoolFactory来得到RedisPool
 * @author zhangke
 * @date 2:04 PM 2019/12/9
 * @version 1.0
 **/
@Service
public class RedisPoolFactory {

	@Autowired
	RedisConfig redisConfig;
	
	@Bean
	public JedisPool JedisPoolFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
		//redis 默认有6个库,不指定是0库
		JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(),
				redisConfig.getTimeout()*1000, redisConfig.getPassword(), 0);
		return jp;
	}
	
}
