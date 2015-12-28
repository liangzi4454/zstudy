package cn.com.study.pattern.command.execute;

public class CodeGroup extends Group {

	
	public void add() {
		System.out.println("增加一个功能");
	}

	
	public void delete() {
		System.out.println("删除一个功能");
	}

	
	public void change() {
		System.out.println("修改一个功能");
	}

	
	public void find() {
		System.out.println("找到代码组...");
	}

	
	public void plan() {
		System.out.println("客户要求代码变更计划");
	}
}