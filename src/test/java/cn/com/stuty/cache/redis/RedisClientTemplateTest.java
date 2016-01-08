package cn.com.stuty.cache.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import cn.com.study.cache.redis.RedisClientTemplate;

public class RedisClientTemplateTest {
	@Test
	public void test() {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocations(new String[] {"/WEB-INF/spring/redis/redis-datasource.xml"});
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/redis-datasource.xml");
		RedisClientTemplate redisClient = (RedisClientTemplate)context.getBean("redisClientTemplate");
		
		for(int i=0; i<10; i++) {
			redisClient.set("a_b_c_"+i, "abc_"+i);
		}
		System.out.println(redisClient.get("a_b_c"));
	}
}
