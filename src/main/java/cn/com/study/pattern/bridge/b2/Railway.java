package cn.com.study.pattern.bridge.b2;

import cn.com.study.pattern.bridge.AbstractRoad;

public class Railway extends AbstractRoad {

	
	public void run() {
		System.out.println("铁路运行中..........");
		abstractCart.run();
	}

}
