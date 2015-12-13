package cn.com.study.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {

	/**
	 * 连接到redis服务
	 */
	public Jedis redisConnetct() {
		// 连接本地的 Redis 服务
		Jedis jedis = new Jedis("192.168.64.132");
		System.out.println("Connection to server successfully");
		// 查看服务是否运行
		System.out.println(jedis.ping());
		return jedis;
	}

	/**
	 * 设置 redis 字符串数据
	 * 
	 * @param jedis
	 */
	public void redisString(Jedis jedis) {
		jedis.set("a", "LHY");
		System.out.println(jedis.get("a"));
	}

	/**
	 * 存储数据到列表中 list
	 * 
	 * @param jedis
	 */
	public void redisList(Jedis jedis) {
		//存储数据到列表中
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
	}

	/**
	 * lrange(key, 0, 5): 从指定key中取值,取值个数从0到5,总共四个;
	 * @param jedis
	 */
	public void redisRange(Jedis jedis) {
		//获取存储的数据并输出
		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for(int i=0; i<list.size(); i++) {
			System.out.println("Stored string in redis:: "+list.get(i));
		}
	}
	
	/**
	 * 获取所有key
	 * @param jedis
	 */
	public void redisKeys(Jedis jedis) {
		Set<String> list2 = jedis.keys("*");
		Iterator<String> iterator = list2.iterator();
		for(;iterator.hasNext();) {
			String key = iterator.next();
			System.out.println(key);
		}
	}
	/**
	 * set 集合
	 * @param jedis
	 */
	public void redisSet(Jedis jedis) {
		jedis.sadd("LHY_sets", "LHY_sets");
		System.out.println(jedis.smembers("LHY_sets"));
	}
}