package cn.com.study.pattern.command.command;


public class AddRequirementCommand extends Command {

	
	public void execute() {
		super.rg.find();
		super.rg.add();
		super.rg.plan();
	}
}
