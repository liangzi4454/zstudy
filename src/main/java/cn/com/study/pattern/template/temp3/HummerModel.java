package cn.com.study.pattern.template.temp3;

public abstract class HummerModel {
	/**
	 * 首先，这个模型要能够被发动起来，别管是手摇发动，还是电力发动，反正
	 * 是要能够发动起来，那这个实现要在实现类里了
	 * @author LHY 2015-11-17 上午10:50:34
	 */
	protected abstract void start();
	
	protected abstract void stop();
	
	protected abstract void alarm();
	
	protected abstract void engineBoom();
	
	final void run() {
		this.start();
		this.engineBoom();
		if(this.isAlarm()) {
			this.alarm();
		}
		this.stop();
	}
	
	protected boolean isAlarm() {
		return true;
	}
}
