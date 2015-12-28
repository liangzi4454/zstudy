package cn.com.study.pattern.command.invoke;

import cn.com.study.pattern.command.command.Command;

public class Invoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}
	public void execute() {
		this.command.execute();
	}
	public void execute(Command command) {
		command.execute();
	}
}