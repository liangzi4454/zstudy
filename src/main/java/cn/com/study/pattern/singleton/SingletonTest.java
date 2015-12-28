package cn.com.study.pattern.singleton;

import org.junit.Test;

public class SingletonTest {
	@Test
	public void testSingleton() {
		Singleton.getInstance();
	}
	
	public String getName(String id) {
		if(id==null) {
			return null;
		} else {
			if(id!=null) {
				return "LHY";
			}
		}
		return "LHY123";
	}
}
