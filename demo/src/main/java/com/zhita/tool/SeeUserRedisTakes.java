package com.zhita.tool;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.zhita.model.SeeUser;
import com.zhita.service.RedisBaiseTakes;


@Component("seeUserRedisTakes")
public class SeeUserRedisTakes implements RedisBaiseTakes<String, String, SeeUser>{

	
	@Resource(name="redisTemplate")
	 private RedisTemplate<String, String> redisTemplate;
	 
	 private Logger logger = Logger.getLogger(String.valueOf(SeeUserRedisTakes.class));

	@Override
	public void add(String key, String value) {
		 if(redisTemplate==null){
	            logger.warning("redisTemplate 实例化失败");
	            return;
	        }else{
	           redisTemplate.opsForValue().set(key,value);
	        }
	}

	@Override
	public void addObj(String objectKey, String key, SeeUser object) {
		if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForHash().put(objectKey,key,object);
        }
		
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		if(redisTemplate==null){
			logger.warning("redisTemplate 实例化失败");
            return;
		}else{
			redisTemplate.delete(key);
		}
		
	}

	@Override
	public void delete(List<String> listKeys) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletObj(String objecyKey, String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObj(String objectKey, String key, SeeUser object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(String key) {
		 String value = (String) redisTemplate.opsForValue().get(key);
	        return value;
	}

	@Override
	public SeeUser getObj(String objectKey, String key) {
		SeeUser seeUser = (SeeUser) redisTemplate.opsForHash().get(objectKey,key);
        return seeUser;
	}

}
