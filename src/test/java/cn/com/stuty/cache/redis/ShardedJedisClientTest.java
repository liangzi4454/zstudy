package cn.com.stuty.cache.redis;

import org.junit.Test;

import cn.com.study.cache.redis.example.ShardedJedisClient;

public class ShardedJedisClientTest {
	@Test
	public void test() {
//		ShardedJedisClient.instance.KeyOperate();
//		ShardedJedisClient.instance.StringOperate();
//		ShardedJedisClient.instance.ListOperate();
//		ShardedJedisClient.instance.SortedSetOperate();
		
		ShardedJedisClient.instance.operateShardedJedis();
	}
}
