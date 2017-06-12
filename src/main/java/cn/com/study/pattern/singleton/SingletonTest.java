package cn.com.study.pattern.singleton;

public class SingletonTest {
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
