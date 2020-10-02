package cn.ekgc.bocaiman.util;


import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-Reds存取工具类</b>
 * <p>
 *     当系统需要使用到Redis 时，需要使用本工具进行操作
 * </p>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */

@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	public void saveToRedis(String key, Object value, Long expireMillis)throws Exception{
		//将对应的需要存储的对象变为json 格式
		JsonMapper jsonMapper = new JsonMapper();
		String valueJSONStr = jsonMapper.writeValueAsString(value);
		//将变为String 的value 存储到Redis 中
		redisTemplate.opsForValue().set(key, valueJSONStr);
		//设定存储的时长
		redisTemplate.expire(key,expireMillis, TimeUnit.MILLISECONDS);
	}

	public Object getFromRedis(String key, Class type)throws Exception{
		//通过key 从Redis 中获取数据
		String valueJSONStr = redisTemplate.opsForValue().get(key);
		//借助于JsonMapper 将json 还原成对象
		JsonMapper jsonMapper = new JsonMapper();
		Object value = jsonMapper.convertValue(valueJSONStr, type);
		return value;
	}
}
