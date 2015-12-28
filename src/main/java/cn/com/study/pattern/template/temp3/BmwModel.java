package cn.com.study.pattern.template.temp3;

public class BmwModel extends HummerModel {
	private boolean alarmFlag = true;
	
	protected void start() {
		System.out.println("宝马启动");
	}

	
	protected void stop() {
		System.out.println("宝马停止");
	}

	
	protected void alarm() {
		System.out.println("喇叭响..........");
	}

	
	protected void engineBoom() {
		System.out.println("宝马发动引擎");
	}

	
	protected boolean isAlarm() {
		return this.alarmFlag;
	}
	public void setAlarm(boolean isAlarm) {
		this.alarmFlag = isAlarm;
	}
}