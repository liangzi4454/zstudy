package cn.com.study.pattern.bridge.b1;

public class Woman extends People {

	
	public void run() {
		abstractRoad.run();
		System.out.println("一个女人在行走.......");
	}
	
}
