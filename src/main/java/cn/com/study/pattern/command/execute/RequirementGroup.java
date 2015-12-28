package cn.com.study.pattern.command.execute;

public class RequirementGroup extends Group {

	
	public void add() {
		System.out.println("增加一个需求");
	}

	
	public void delete() {
		System.out.println("删除一个需求");
	}

	
	public void change() {
		System.out.println("修改一个需求");
	}

	
	public void find() {
		System.out.println("找到需求组...");
	}

	
	public void plan() {
		System.out.println("客户要求需求变更计划");
	}
}