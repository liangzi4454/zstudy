package cn.com.study.common.timer.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LHY Quartz的任务的临时启动和暂停和恢复
 */
public class HelloJob implements Job {

	private static Logger _log = LoggerFactory.getLogger(HelloJob.class);

	public HelloJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {
		_log.info("Hello World! - " + new Date());
	}

}
