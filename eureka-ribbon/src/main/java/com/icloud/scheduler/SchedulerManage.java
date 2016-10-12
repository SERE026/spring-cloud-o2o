package com.icloud.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import com.icloud.scheduler.job.MqMissCheckJob;

public class SchedulerManage {
	public void startSchedule(Scheduler scheduler){
		startOrderCreateMqMissCheckJob(scheduler);
	}
	

	public  void startOrderCreateMqMissCheckJob(Scheduler scheduler) {
		try {
			TriggerKey triggerKey = TriggerKey.triggerKey("some-trigger", "group");
			CronTrigger trigger;
			trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

			if (null == trigger) {
				// if no task running
				JobDetail jobDetail = JobBuilder.newJob(MqMissCheckJob.class).withIdentity("some-trigger", "group").build();
				  trigger =TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")  
					    .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))  
					    .startNow().build(); 
			 
				scheduler.scheduleJob(jobDetail, trigger);
			} else {
				JobKey jobKey = JobKey.jobKey("some-trigger", "group");
				scheduler.triggerJob(jobKey);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
