package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootBatchProj05DbToCsvSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj05DbToCsvSchedulingApplication.class, args);
	}

}
