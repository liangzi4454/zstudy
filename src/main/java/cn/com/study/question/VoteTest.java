package cn.com.study.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 去哪儿网面试题:表决问题<br>
 * 表决问题:如果有一张机票有10个提供商，认为3个可以提供就可以提供。能不能3个返回true之后，停掉正在运行还没结果的以及还没运行的.<br>
 * <Strong>这个可以用JUC包提供的ExecutorCompletionService来做，
 * ThreadPoolExecutor中的invokeAny内部就是用ExecutorCompletionService来做的.</Strong>
 * 
 * @author wu hong
 */
public class VoteTest {
	
	public static class GetTask implements Callable<Boolean> {
		public Boolean call() throws Exception {
			try {
				Random random = new Random();
				boolean result = random.nextBoolean();
				TimeUnit.SECONDS.sleep(random.nextInt(10));
				System.out.println("任务[" + Thread.currentThread().getName() + "]执行完毕，返回结果为:[" + result + "]!");
				return result;
			} catch (Exception e) {
				System.out.println("任务[" + Thread.currentThread().getName() + "]被取消!");
				throw e;
			}
		}
	}

	public static void main(String[] args) {
		GetTask task0 = new GetTask();
		GetTask task1 = new GetTask();
		GetTask task2 = new GetTask();
		GetTask task3 = new GetTask();
		GetTask task4 = new GetTask();
		GetTask task5 = new GetTask();
		GetTask task6 = new GetTask();
		GetTask task7 = new GetTask();
		GetTask task8 = new GetTask();
		GetTask task9 = new GetTask();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		ExecutorCompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(executor);
		List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>(10);
		futures.add(completionService.submit(task0));
		futures.add(completionService.submit(task1));
		futures.add(completionService.submit(task2));
		futures.add(completionService.submit(task3));
		futures.add(completionService.submit(task4));
		futures.add(completionService.submit(task5));
		futures.add(completionService.submit(task6));
		futures.add(completionService.submit(task7));
		futures.add(completionService.submit(task8));
		futures.add(completionService.submit(task9));
		int count = 0;
		while (count < 3) { // 有3个任务返回true就ok了。
			try {
				boolean result = completionService.take().get();
				if (result) {
					count++;
					System.out.println("获取到结果:" + result);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("取消其他任务!");
		for (Future<Boolean> future : futures) {
			future.cancel(true);
		}
	}
}
