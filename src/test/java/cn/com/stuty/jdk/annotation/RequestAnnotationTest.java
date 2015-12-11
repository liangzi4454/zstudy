package cn.com.stuty.jdk.annotation;

import org.junit.Test;

import cn.com.study.jdk.annotation.RequestMappingAdapter;
import cn.com.study.jdk.annotation.User;

public class RequestAnnotationTest {
	@Test
	public void testRequest() throws Exception {
		User user = new User();
		user.setName("LHY");
		user.setAge(123);
		RequestMappingAdapter.handle(user);
	}
}
