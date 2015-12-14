package cn.com.study.redis;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.ShardedJedis;

/**
 * 第二层的封装：RedisClientTemplate，例子实现了放值和取值。最后代码提供了全部命令的实现。
 * 
 * 代码就是映射性质的又一次调用jedis的方法而已，用了个broken来做标示符，决定返还资源的方式。
 * 
 * 这一层的目的主要也是让再上层的调用不需要关心pool中链接的取得和返还问题了。
 * 
 * @author LHY 2015年12月14日 下午5:56:32
 */
@Repository("redisClientTemplate")
public class RedisClientTemplate {
	private static final Logger log = LoggerFactory.getLogger(RedisClientTemplate.class);

	@Resource
	private RedisDataSource redisDataSource;

	public void disconnect() {
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		shardedJedis.disconnect();
	}

	/**
	 * 设置单个值
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(String key, String value) {
		String result = null;

		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}
		boolean broken = false;
		try {
			result = shardedJedis.set(key, value);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}

	/**
	 * 获取单个值
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key) {
		String result = null;
		ShardedJedis shardedJedis = redisDataSource.getRedisClient();
		if (shardedJedis == null) {
			return result;
		}

		boolean broken = false;
		try {
			result = shardedJedis.get(key);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			broken = true;
		} finally {
			redisDataSource.returnResource(shardedJedis, broken);
		}
		return result;
	}
}