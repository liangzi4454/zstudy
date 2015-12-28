package cn.com.study.common.timer.jdk;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * scheduleAtFixedRate和scheduleWithFixedDelay区别。
 * scheduleAtFixedRate方法按照固定的频率执行线程
 * ，scheduleWithFixedDelay方法不是按照固定频率执行线程。
 * 该方法是（固定的频率+线程执行需要的时间），方才执行下次线程。
 */
public class SchedulePool {
	
	private SchedulePool() {}
	
	public static final SchedulePool getInstance= new SchedulePool();
	
	public void executeTask() {
		Task task = new Task();

		/**
		 * scheduleAtFixedRate固定频率执行某项任务
		 * */
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(task, 1000, 1000 * 2, TimeUnit.MILLISECONDS);

		/**
		 * scheduleWithFixedDelay相对延迟，固定频率执行某项任务
		 * */
		Executors.newScheduledThreadPool(3).scheduleWithFixedDelay(task, 1000, 1000 * 2, TimeUnit.MILLISECONDS);
	}
}