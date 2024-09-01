package com.rk.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("jobListener")
public class JobMonitoringListener implements JobExecutionListener{

	private long start,end;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob()");
		start=System.currentTimeMillis();
		
	}
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.afterJob()");
		end=System.currentTimeMillis();
		System.out.println("Job Execution Time is::"+(end-start)+"ms");
		System.out.println("Job Execution status::"+jobExecution.getExitStatus());
	}//method
}//class
