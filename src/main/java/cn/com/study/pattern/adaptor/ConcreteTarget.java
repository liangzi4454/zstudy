package cn.com.study.pattern.adaptor;

/**
 * @author LHY
 * 目标角色实现类 
 */
public class ConcreteTarget implements Target {

	public void request() {
		System.out.println("ConcreteTarget");
	}
}
