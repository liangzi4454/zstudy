package cn.com.study.pattern.template.temp3;

/**
 * 模板模式
 * @author LHY
 *	那我们总结一下模板方法模式，模板方法模式就是在模板方法中按照一个的规则和顺序调用基本方法，
 *  具体到我们上面那个例子就是run 方法按照规定的顺序(先调用start,然后再调用engineBoom，再调用
 *  alarm，最后调用stop)调用本类的其他方法，并且由isAlarm 方法的返回值确定run 中的执行顺序变更.
 */
public class ClientTest {
	public static void main(String[] args) {
		// 客户开着H1型号，出去遛弯了
		BenzModel h1 = new BenzModel();
		h1.run(); // 汽车跑起来了；
		System.out.println("-------------------");
		// 客户开H2型号，出去玩耍了
		BmwModel h2 = new BmwModel();
		h2.setAlarm(true);
		h2.run();
	}
}
