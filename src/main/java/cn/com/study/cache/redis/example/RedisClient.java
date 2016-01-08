package cn.com.study.cache.redis.example;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

	public static final RedisClient instance = new RedisClient();

	/** 非切片客户端 ?? */
	private Jedis jedis;
	
	private RedisClient() {
		if (jedis == null) {
			JedisPool jedisPool = initialPool();
			jedis = jedisPool.getResource();
		}
	}

	/**
	 * 初始化非切片连接池
	 */
	private JedisPool initialPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);

		return new JedisPool(config, "192.168.79.128", 6379);
	}
	
	/**
	 * 返回客户端
	 * @return
	 */
	public Client getClient() {
		return jedis.getClient();
	}

	/**
	 * 操作非分片数据库;
	 * 当调用jedis.close();将关闭连接池
	 */
	public void operateJedis() {
		System.out.println("清空库中所有数据：" + jedis.flushDB());
		System.out.println(jedis.set("key01", "value01"));
		jedis.close();
	}
	
	/**
	 * 当调用jedis.close();将关闭连接池
	 */
	public void KeyOperate() {
		System.out.println("系统中所有键如下：");
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		// 删除某个key,若key不存在，则忽略该命令。
		System.out.println("系统中删除key002: " + jedis.del("key002"));
		// 设置 key001的过期时间
		System.out.println("设置 key001的过期时间为5秒:" + jedis.expire("key001", 5));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		// 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
		System.out.println("查看key001的剩余生存时间：" + jedis.ttl("key001"));
		// 移除某个key的生存时间
		System.out.println("移除key001的生存时间：" + jedis.persist("key001"));
		System.out.println("查看key001的剩余生存时间：" + jedis.ttl("key001"));
		// 查看key所储存的值的类型
		System.out.println("查看key所储存的值的类型：" + jedis.type("key001"));
		/*
		 * 一些其他方法：1、修改键名：jedis.rename("key6", "key0");
		 * 2、将当前db的key移动到给定的db当中：jedis.move("foo", 1)
		 */
		jedis.close();
	}

	public void StringOperate() {
		System.out.println("======================String_1==========================");
		// 清空数据
		System.out.println("清空库中所有数据：" + jedis.flushDB());

		System.out.println("=============增=============");
		jedis.set("key001", "value001");
		jedis.set("key002", "value002");
		jedis.set("key003", "value003");
		System.out.println("已新增的3个键值对如下：");
		System.out.println(jedis.get("key001"));
		System.out.println(jedis.get("key002"));
		System.out.println(jedis.get("key003"));

		System.out.println("=============删=============");
		System.out.println("删除key003键值对：" + jedis.del("key003"));
		System.out.println("获取key003键对应的值：" + jedis.get("key003"));

		System.out.println("=============改=============");
		// 1、直接覆盖原来的数据
		System.out.println("直接覆盖key001原来的数据：" + jedis.set("key001", "value001-update"));
		System.out.println("获取key001对应的新值：" + jedis.get("key001"));
		// 2、直接覆盖原来的数据
		System.out.println("在key002原来值后面追加：" + jedis.append("key002", "+appendString"));
		System.out.println("获取key002对应的新值" + jedis.get("key002"));

		System.out.println("=============增，删，查（多个）=============");
		/**
		 * mset,mget同时新增，修改，查询多个键值对 等价于： jedis.set("name","ssss");
		 * jedis.set("jarorwar","xxxx");
		 */
		System.out.println("一次性新增key201,key202,key203,key204及其对应值：" + jedis.mset("key201", "value201", "key202", "value202", "key203", "value203", "key204", "value204"));
		System.out.println("一次性获取key201,key202,key203,key204各自对应的值：" + jedis.mget("key201", "key202", "key203", "key204"));
		System.out.println("一次性删除key201,key202：" + jedis.del(new String[] { "key201", "key202" }));
		System.out.println("一次性获取key201,key202,key203,key204各自对应的值：" + jedis.mget("key201", "key202", "key203", "key204"));
		System.out.println();
	}
	
	public void SetOperate() {

		System.out.println("======================set==========================");
		// 清空数据
		System.out.println("清空库中所有数据：" + jedis.flushDB());

		System.out.println("=============增=============");
		System.out.println("向sets集合中加入元素element001：" + jedis.sadd("sets", "element001"));
		System.out.println("向sets集合中加入元素element002：" + jedis.sadd("sets", "element002"));
		System.out.println("向sets集合中加入元素element003：" + jedis.sadd("sets", "element003"));
		System.out.println("向sets集合中加入元素element004：" + jedis.sadd("sets", "element004"));
		System.out.println("查看sets集合中的所有元素:" + jedis.smembers("sets"));
		System.out.println();

		System.out.println("=============删=============");
		System.out.println("集合sets中删除元素element003：" + jedis.srem("sets", "element003"));
		System.out.println("查看sets集合中的所有元素:" + jedis.smembers("sets"));
		/*
		 * System.out.println("sets集合中任意位置的元素出栈："+jedis.spop("sets"));//注：
		 * 出栈元素位置居然不定？--无实际意义
		 * System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));
		 */
		System.out.println();

		System.out.println("=============改=============");
		System.out.println();

		System.out.println("=============查=============");
		System.out.println("判断element001是否在集合sets中：" + jedis.sismember("sets", "element001"));
		System.out.println("循环查询获取sets中的每个元素：");
		Set<String> set = jedis.smembers("sets");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		System.out.println();

		System.out.println("=============集合运算=============");
		System.out.println("sets1中添加元素element001：" + jedis.sadd("sets1", "element001"));
		System.out.println("sets1中添加元素element002：" + jedis.sadd("sets1", "element002"));
		System.out.println("sets1中添加元素element003：" + jedis.sadd("sets1", "element003"));
		System.out.println("sets1中添加元素element002：" + jedis.sadd("sets2", "element002"));
		System.out.println("sets1中添加元素element003：" + jedis.sadd("sets2", "element003"));
		System.out.println("sets1中添加元素element004：" + jedis.sadd("sets2", "element004"));
		System.out.println("查看sets1集合中的所有元素:" + jedis.smembers("sets1"));
		System.out.println("查看sets2集合中的所有元素:" + jedis.smembers("sets2"));
		System.out.println("sets1和sets2交集：" + jedis.sinter("sets1", "sets2"));
		System.out.println("sets1和sets2并集：" + jedis.sunion("sets1", "sets2"));
		System.out.println("sets1和sets2差集：" + jedis.sdiff("sets1", "sets2"));// 差集：set1中有，set2中没有的元素

	}
}