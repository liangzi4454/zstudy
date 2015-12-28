package cn.com.stuty.pattern;

import org.junit.Test;

import cn.com.study.pattern.adaptor.Adapter;
import cn.com.study.pattern.adaptor.ConcreteTarget;
import cn.com.study.pattern.adaptor.Target;
import cn.com.study.pattern.bridge.AbstractRoad;
import cn.com.study.pattern.bridge.b1.Man;
import cn.com.study.pattern.bridge.b1.People;
import cn.com.study.pattern.bridge.b2.Railway;
import cn.com.study.pattern.bridge.b2.RailwayTrain;
import cn.com.study.pattern.bridge.b2.Subway;
import cn.com.study.pattern.bridge.b2.SubwayTrain;
import cn.com.study.pattern.command.command.Command;
import cn.com.study.pattern.command.command.DeletePageCommand;
import cn.com.study.pattern.command.invoke.Invoker;
import cn.com.study.pattern.decorator.Father;
import cn.com.study.pattern.decorator.Mother;
import cn.com.study.pattern.decorator.Son;
import cn.com.study.pattern.decorator.Work;

public class DesignPatternTest {
	
	/**
	 * 适配器模式
	 */
	@Test
	public void adaptorTest() {
		Target target = new ConcreteTarget();  
        target.request();  
        /** 
         * 适配其他的角色 
         */  
        Target targetAdapter = new Adapter();  
        targetAdapter.request();  
	}
	
	/**
	 * 桥接模式
	 */
	@Test
	public void bridgeTest1() {
		AbstractRoad subway = new Subway();
		subway.abstractCart = new SubwayTrain();
		subway.run();
		
		AbstractRoad railway = new Railway();
		railway.abstractCart = new RailwayTrain();
		railway.run();
	}
	
	/**
	 * 桥接模式
	 */
	public void bridgeTest2() {
		AbstractRoad subway = new Subway();
		subway.abstractCart = new SubwayTrain();
		People man = new Man();
		man.abstractRoad = subway;
		man.run();
	}
	
	/**
	 * 命令模式
	 */
	@Test
	public void commandTest() {
		Invoker invoker = new Invoker();
//		Command command = new AddRequirementCommand();
		Command command = new DeletePageCommand();
		invoker.setCommand(command);
		invoker.execute(command);
//		invoker.execute();
	}
	
	@Test
	public void decoratorTest() {
		/*Work work = new Son();
		work.paint();
		System.out.println();
		work = new Mother(work);
		work.paint();
		System.out.println();
		work = new Father(work);
		work.paint();*/
		
		Work work = new Father(new Mother(new Son()));
		work.paint();
	}
}
