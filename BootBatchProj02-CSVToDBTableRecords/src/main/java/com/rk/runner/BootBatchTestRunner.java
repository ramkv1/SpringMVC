package com.rk.runner;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootBatchTestRunner implements CommandLineRunner {

	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job job;
	
	@Override
	public void run(String... args) throws Exception {
		JobParameters params=new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();
		JobExecution execution=launcher.run(job, params);
		System.out.println("JOb Execution status::"+execution.getExitStatus());
		System.out.println("Job Started at::"+execution.getStartTime()+" "+execution.getEndTime());
	}

}
