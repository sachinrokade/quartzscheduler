package com.example.demo;

import java.text.ParseException;
import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestSechdulerApplication {

	public static void main(String[] args) throws SchedulerException, ParseException {
		//SpringApplication.run(RestSechdulerApplication.class, args);
	
		JobDetailImpl job = new JobDetailImpl();
    	job.setName("dummyJobName");
    	job.setJobClass(HelloJob.class);
    	
    	//configure the scheduler time
    	SimpleTriggerImpl trigger = new SimpleTriggerImpl();
    	trigger.setName("my triggger");
    	trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
    	trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
    	trigger.setRepeatInterval(500);
    	
    	//CronTrigger the scheduler time
    	/*CronTriggerImpl trigger = new CronTriggerImpl();
    	trigger.setName("dummy TriggerName");
    	trigger.setCronExpression("0/30 * * * * ?");
    	*/
    	
    	//schedule it
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
	}

}
 