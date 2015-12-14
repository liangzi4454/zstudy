package cn.com.stuty.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import cn.com.study.redis.example.RedisJava;

public class RedisJavaTest {
	@Test
	public void redisConnetctTest() {
		RedisJava redisJava = new RedisJava();
		Jedis jedis = redisJava.redisConnetct();
//		redisJava.redisString(jedis);
//		redisJava.redisList(jedis);
//		redisJava.redisKeys(jedis);
		redisJava.redisSet(jedis);
	}
}
