package cn.com.study.pattern.command.command;

public class DeletePageCommand extends Command {

	
	public void execute() {
		super.pg.find();
		super.pg.add();
		super.pg.plan();
	}

}
