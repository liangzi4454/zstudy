package cn.com.study.pattern.template.temp3;

public class BenzModel extends HummerModel {

	
	protected void start() {
		System.out.println("奔驰启动");
	}

	
	protected void stop() {
		System.out.println("奔驰停止");
	}

	
	protected void alarm() {
		System.out.println("喇叭响。。。。。");
	}

	
	protected void engineBoom() {
		System.out.println("奔驰发动引擎");
	}

	
	protected boolean isAlarm() {
		return false;
	}

}
