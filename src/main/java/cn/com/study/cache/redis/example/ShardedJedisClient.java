package cn.com.study.cache.redis.example;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

/**
 * 切片操作(集群),3.0开始<br>
 * 目前Redis3.0实现集群的方法主要是采用一致性哈稀分片（Shard），将不同的key分配到不同的redis server上，达到横向扩展的目的<br>
 * 客户端jedis的一致性哈稀进行分片原理：初始化ShardedJedisPool的时候，会将上面程序中的jdsInfoList数据进行一个算法技术，主要计算依据为list中的index位置来计算;
 * @author LHY
 * 2015年12月15日 下午3:17:24
 */
public class ShardedJedisClient {
	
	public static final ShardedJedisClient instance = new ShardedJedisClient();
	
	/** 切片客户端 */
	private ShardedJedis shardedJedis;
	
	private ShardedJedisClient() {
		if (shardedJedis == null) {
			ShardedJedisPool shardedJedisPool = initialShardedPool();
			shardedJedis = shardedJedisPool.getResource();
		}
	}
	
	/**
	 * 切片连接池,可以在同一个Redis服务器上启动两个实例
	 * @return
	 */
	private ShardedJedisPool initialShardedPool() {
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(20);
		config.setMaxIdle(5);
		config.setMaxWaitMillis(1000l);
		config.setTestOnBorrow(false);

		// slave链接
		List<JedisShardInfo> shareds = new ArrayList<JedisShardInfo>();
		shareds.add(new JedisShardInfo("192.168.79.128", 6379, "master"));
		shareds.add(new JedisShardInfo("192.168.79.128", 6380, "master1"));
		
//		shareds.add(new JedisShardInfo("192.168.79.129", 6379, "slave1"));
//		shareds.add(new JedisShardInfo("192.168.79.131", 6379, "slave2"));

		return new ShardedJedisPool(config, shareds, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
	}
	
	private static int index = 1;
    public static String generateKey(){
        return String.valueOf(Thread.currentThread().getId())+"_"+(index++);
    }
	
	public void operateShardedJedis() {
		for(int i=0; i<10; i++) {
			shardedJedis.set(generateKey(), "LHY-"+i);
		}
		shardedJedis.close();
	}
	
	/**
	 * 分片操作数据库;
	 * 当调用shardedJedis.close();将关闭连接池
	 */
	public void KeyOperate() {
		System.out.println("判断key001键是否存在：" + shardedJedis.exists("key001"));
		System.out.println("新增key001,value001键值对：" + shardedJedis.set("key001", "value001"));
		System.out.println("判断key001是否存在：" + shardedJedis.exists("key001"));
		shardedJedis.close();
	}
	public void StringOperate() {

		System.out.println("=============新增键值对时防止覆盖原先值=============");
		System.out.println("原先key301不存在时，新增key301：" + shardedJedis.setnx("key301", "value301"));
		System.out.println("原先key302不存在时，新增key302：" + shardedJedis.setnx("key302", "value302"));
		System.out.println("当key302存在时，尝试新增key302：" + shardedJedis.setnx("key302", "value302_new"));
		System.out.println("获取key301对应的值：" + shardedJedis.get("key301"));
		System.out.println("获取key302对应的值：" + shardedJedis.get("key302"));

		System.out.println("=============超过有效期键值对被删除=============");
		// 设置key的有效期，并存储数据
		System.out.println("新增key303，并指定过期时间为2秒" + shardedJedis.setex("key303", 2, "key303-2second"));
		System.out.println("获取key303对应的值：" + shardedJedis.get("key303"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("3秒之后，获取key303对应的值：" + shardedJedis.get("key303"));

		System.out.println("=============获取原值，更新为新值一步完成=============");
		System.out.println("key302原值：" + shardedJedis.getSet("key302", "value302-after-getset"));
		System.out.println("key302新值：" + shardedJedis.get("key302"));

		System.out.println("=============获取子串=============");
		System.out.println("获取key302对应值中的子串：" + shardedJedis.getrange("key302", 5, 7));
	}
	
	public void ListOperate() {
		
		System.out.println("=============增=============");
		shardedJedis.lpush("stringlists", "vector");
		shardedJedis.lpush("stringlists", "ArrayList");
		shardedJedis.lpush("stringlists", "vector");
		shardedJedis.lpush("stringlists", "vector");
		shardedJedis.lpush("stringlists", "LinkedList");
		shardedJedis.lpush("stringlists", "MapList");
		shardedJedis.lpush("stringlists", "SerialList");
		shardedJedis.lpush("stringlists", "HashList");
		shardedJedis.lpush("numberlists", "3");
		shardedJedis.lpush("numberlists", "1");
		shardedJedis.lpush("numberlists", "5");
		shardedJedis.lpush("numberlists", "2");
		System.out.println("所有元素-stringlists：" + shardedJedis.lrange("stringlists", 0, -1));
		System.out.println("所有元素-numberlists：" + shardedJedis.lrange("numberlists", 0, -1));

		System.out.println("=============删=============");
		// 删除列表指定的值 ，第二个参数为删除的个数（有重复时），后add进去的值先被删，类似于出栈
		System.out.println("成功删除指定元素个数-stringlists：" + shardedJedis.lrem("stringlists", 2, "vector"));
		System.out.println("删除指定元素之后-stringlists：" + shardedJedis.lrange("stringlists", 0, -1));
		// 删除区间以外的数据
		System.out.println("删除下标0-3区间之外的元素：" + shardedJedis.ltrim("stringlists", 0, 3));
		System.out.println("删除指定区间之外元素后-stringlists：" + shardedJedis.lrange("stringlists", 0, -1));
		// 列表元素出栈
		System.out.println("出栈元素：" + shardedJedis.lpop("stringlists"));
		System.out.println("元素出栈后-stringlists：" + shardedJedis.lrange("stringlists", 0, -1));

		System.out.println("=============改=============");
		// 修改列表中指定下标的值
		shardedJedis.lset("stringlists", 0, "hello list!");
		System.out.println("下标为0的值修改后-stringlists：" + shardedJedis.lrange("stringlists", 0, -1));
		System.out.println("=============查=============");
		// 数组长度
		System.out.println("长度-stringlists：" + shardedJedis.llen("stringlists"));
		System.out.println("长度-numberlists：" + shardedJedis.llen("numberlists"));
		// 排序
		/*
		 * list中存字符串时必须指定参数为alpha，如果不使用SortingParams，而是直接使用sort("list")，
		 * 会出现"ERR One or more scores can't be converted into double"
		 */
		SortingParams sortingParameters = new SortingParams();
		sortingParameters.alpha();
		sortingParameters.limit(0, 3);
		System.out.println("返回排序后的结果-stringlists：" + shardedJedis.sort("stringlists", sortingParameters));
		System.out.println("返回排序后的结果-numberlists：" + shardedJedis.sort("numberlists"));
		// 子串： start为元素下标，end也为元素下标；-1代表倒数一个元素，-2代表倒数第二个元素
		System.out.println("子串-第二个开始到结束：" + shardedJedis.lrange("stringlists", 1, -1));
		// 获取列表指定下标的值
		System.out.println("获取下标为2的元素：" + shardedJedis.lindex("stringlists", 2) + "\n");
	}
	
	public void SortedSetOperate() { 
		
        System.out.println("=============增=============");
        System.out.println("zset中添加元素element001："+shardedJedis.zadd("zset", 7.0, "element001")); 
        System.out.println("zset中添加元素element002："+shardedJedis.zadd("zset", 8.0, "element002")); 
        System.out.println("zset中添加元素element003："+shardedJedis.zadd("zset", 2.0, "element003")); 
        System.out.println("zset中添加元素element004："+shardedJedis.zadd("zset", 3.0, "element004"));
        System.out.println("zset集合中的所有元素："+shardedJedis.zrange("zset", 0, -1));//按照权重值排序
        System.out.println();
        
        System.out.println("=============删=============");
        System.out.println("zset中删除元素element002："+shardedJedis.zrem("zset", "element002"));
        System.out.println("zset集合中的所有元素："+shardedJedis.zrange("zset", 0, -1));
        System.out.println();
        
        System.out.println("=============改=============");
        System.out.println();
        
        System.out.println("=============查=============");
        System.out.println("统计zset集合中的元素中个数："+shardedJedis.zcard("zset"));
        System.out.println("统计zset集合中权重某个范围内（1.0——5.0），元素的个数："+shardedJedis.zcount("zset", 1.0, 5.0));
        System.out.println("查看zset集合中element004的权重："+shardedJedis.zscore("zset", "element004"));
        System.out.println("查看下标1到2范围内的元素值："+shardedJedis.zrange("zset", 1, 2));

    }
	public void HashOperate() { 
		
        System.out.println("=============增=============");
        System.out.println("hashs中添加key001和value001键值对："+shardedJedis.hset("hashs", "key001", "value001")); 
        System.out.println("hashs中添加key002和value002键值对："+shardedJedis.hset("hashs", "key002", "value002")); 
        System.out.println("hashs中添加key003和value003键值对："+shardedJedis.hset("hashs", "key003", "value003"));
        System.out.println("新增key004和4的整型键值对："+shardedJedis.hincrBy("hashs", "key004", 4l));
        System.out.println("hashs中的所有值："+shardedJedis.hvals("hashs"));
        System.out.println();
        
        System.out.println("=============删=============");
        System.out.println("hashs中删除key002键值对："+shardedJedis.hdel("hashs", "key002"));
        System.out.println("hashs中的所有值："+shardedJedis.hvals("hashs"));
        System.out.println();
        
        System.out.println("=============改=============");
        System.out.println("key004整型键值的值增加100："+shardedJedis.hincrBy("hashs", "key004", 100l));
        System.out.println("hashs中的所有值："+shardedJedis.hvals("hashs"));
        System.out.println();
        
        System.out.println("=============查=============");
        System.out.println("判断key003是否存在："+shardedJedis.hexists("hashs", "key003"));
        System.out.println("获取key004对应的值："+shardedJedis.hget("hashs", "key004"));
        System.out.println("批量获取key001和key003对应的值："+shardedJedis.hmget("hashs", "key001", "key003")); 
        System.out.println("获取hashs中所有的key："+shardedJedis.hkeys("hashs"));
        System.out.println("获取hashs中所有的value："+shardedJedis.hvals("hashs"));
        System.out.println();
              
    }
}