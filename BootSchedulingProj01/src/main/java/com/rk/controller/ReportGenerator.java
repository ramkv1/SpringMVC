package com.rk.controller;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportGenerator {
	
	//@Scheduled(fixedDelay = 10000,initialDelay = 10000)
	//@Scheduled(fixedDelay = 30000 )
	//@Scheduled(fixedDelayString = "30000")
	//@Scheduled(fixedRate = 10000)
	//@Scheduled(fixedDelay = 1000,fixedRate = 5000)
	//@Scheduled(cron = "15 * * * * *")
	@Scheduled(cron = "15 * * * * *")
	public void showReport() {
		
		System.out.println("Report Generation on:::"+new Date());
		/*System.out.println("Report Generation On(Start):::"+new Date());
		try {
			Thread.sleep(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Report Generation On(end):::"+new Date());*/
	}
}
