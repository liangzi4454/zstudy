package cn.com.study.common.timer.jdk;

import java.util.Date;
import java.util.Random;

public class Task implements Runnable {

	public void run() {
		System.out.println("当前线程：" + Thread.currentThread() + "，执行时间：" + new Date().getTime());
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}