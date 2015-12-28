package cn.com.study.pattern.command.execute;

public class PageGroup extends Group {

	
	public void add() {
		System.out.println("增加一个页面");
	}

	
	public void delete() {
		System.out.println("删除一个页面");
	}

	
	public void change() {
		System.out.println("修改一个页面");
	}

	
	public void find() {
		System.out.println("找到美工组...");
	}

	
	public void plan() {
		System.out.println("客户要求页面变更计划");
	}
}
