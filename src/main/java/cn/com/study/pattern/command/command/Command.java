package cn.com.study.pattern.command.command;

import cn.com.study.pattern.command.execute.CodeGroup;
import cn.com.study.pattern.command.execute.PageGroup;
import cn.com.study.pattern.command.execute.RequirementGroup;

public abstract class Command {
	protected final RequirementGroup rg = new RequirementGroup();
	protected final CodeGroup cg = new CodeGroup();
	protected final PageGroup pg = new PageGroup();
	public abstract void execute();
}
