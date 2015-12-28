package cn.com.study.pattern.command.invoke;

import cn.com.study.pattern.command.command.Command;
import cn.com.study.pattern.command.command.DeletePageCommand;

public class ClientTest {
	public static void main(String[] args) {
		Invoker invoker = new Invoker();
//		Command command = new AddRequirementCommand();
		Command command = new DeletePageCommand();
		invoker.setCommand(command);
		invoker.execute(command);
//		invoker.execute();
	}
}
