package cn.com.stuty.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.study.redis.RedisClientTemplate;

public class RedisClientTemplateTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/redis-datasource.xml");
		RedisClientTemplate redisClient = (RedisClientTemplate)context.getBean("redisClientTemplate");
		for(int i=0; i<10; i++) {
			redisClient.set("a_b_c_"+i, "abc_"+i);
		}
		System.out.println(redisClient.get("a_b_c"));
	}
}
