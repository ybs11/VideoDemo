package com.zhiyou.config.redis;



import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration  
@EnableCaching  
public class RedisCacheConfig extends CachingConfigurerSupport{

	private JedisConnectionFactory jedisConnectionFactory;
	private RedisTemplate<String, String> redisTemplate;
	private RedisCacheManager redisCacheManager;
	
	
	
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, String> redisTemplate,
			RedisCacheManager redisCacheManager) {
		super();
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}



	public RedisCacheConfig() {
	
	}



	public JedisConnectionFactory getJedisConnectionFactory() {
		return jedisConnectionFactory;
	}



	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}



	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}
	
	@Bean
	public KeyGenerator customKeyGenerator() {
		
	return	new KeyGenerator() {
			
			public Object generate(Object target, Method method, Object... params) {
	
				StringBuilder sb =new StringBuilder();

				sb.append(target.getClass().getName());
	
				sb.append(method.getName());
				for (Object object : params) {
					sb.append(object.toString());
				}
				
				
				return sb.toString();
			}
		};
		
		
		
	}
	
}
