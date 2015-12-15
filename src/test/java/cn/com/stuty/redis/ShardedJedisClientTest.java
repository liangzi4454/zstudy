package cn.com.stuty.redis;

import org.junit.Test;

import cn.com.study.redis.example.ShardedJedisClient;

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
