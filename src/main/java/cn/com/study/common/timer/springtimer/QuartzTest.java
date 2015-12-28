package cn.com.study.common.timer.springtimer;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
	public static void main(String[] args) {  
        QuartzTest quartzTest=new QuartzTest();  
        quartzTest.startSchedule();  
  
    }  
  
    public void startSchedule() {  
        try {  
            // 1、创建一个JobDetail实例，指定Quartz  
            JobDetail jobDetail = JobBuilder.newJob(NewJob.class)  
            // 任务执行类  
            .withIdentity("job1_1", "jGroup1")  
            // 任务名，任务组  
            .build();     
            //2、创建Trigger  
            SimpleScheduleBuilder builder=SimpleScheduleBuilder.simpleSchedule()  
            //设置间隔执行时间  
            .withIntervalInSeconds(5)  
            //设置执行次数  
            .repeatForever();  
            //CronScheduleBuilder builder2 = CronScheduleBuilder.cronSchedule("0 0/5 8 * * *");//8：00-8：55，每隔5分钟执行  
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("trigger1_1","tGroup1").startNow().withSchedule(builder).build();  
            //3、创建Scheduler  
            Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();  
            scheduler.start();        
            //4、调度执行  
            scheduler.scheduleJob(jobDetail, trigger);                
            try {  
                Thread.sleep(60000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
   
            scheduler.shutdown();  
              
        } catch (SchedulerException e) {  
            e.printStackTrace();  
        }  
    }
}