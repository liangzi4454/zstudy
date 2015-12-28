package cn.com.study.common.timer.springtimer;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Quartz implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Hello quzrtz  "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));  
	}
}
