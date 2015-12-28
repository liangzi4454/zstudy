package cn.com.study.pattern.strategy;

/**
 * 策略场景
 * @author LHY
 *
 */
public class Context {
	private IStrategy strategy;

	public Context(IStrategy strategy) {
		this.strategy = strategy;
	}
	public void operate() {
		this.strategy.operate();
	}
}
