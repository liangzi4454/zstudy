package cn.com.stuty.redis;

import org.junit.Test;

import cn.com.study.redis.RedisClient;

public class RedisClientTest {
	@Test
	public void KeyOperate() {
		RedisClient.instance.KeyOperate();
	}
}