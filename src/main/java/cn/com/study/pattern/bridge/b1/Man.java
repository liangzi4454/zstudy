package cn.com.study.pattern.bridge.b1;

public class Man extends People {

	
	public void run() {
		abstractRoad.run();
		System.out.println("一个男人在行走......");
	}

}
