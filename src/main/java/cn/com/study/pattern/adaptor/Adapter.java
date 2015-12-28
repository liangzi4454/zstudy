package cn.com.study.pattern.adaptor;

public class Adapter extends Adaptee implements Target {

	public void request() {
		super.doSomething();
	}

}
