package cn.com.study.pattern.bridge.b2;

import cn.com.study.pattern.bridge.AbstractRoad;

public class Subway extends AbstractRoad {
	
	
	public void run() {
		abstractCart.run();
		System.out.println("在通往西二旗的地铁上.....");
	}
}
