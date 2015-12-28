package cn.com.study.pattern.strategy;

/**
 * 策略执行者
 * @author LHY
 *
 */
public class ClientTest {
	public static void main(String[] args) {
		Context context;
		context = new Context(new PlusStrategy());
		context.operate();
		context = new Context(new MinusStrategy());
		context.operate();
		context = new Context(new MultiplyStrategy());
		context.operate();
		context = new Context(new DivideStrategy());
		context.operate();
	}
}
