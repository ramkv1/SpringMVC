package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingApplication {

	@Bean("multipartResolver")
	public StandardServletMultipartResolver createResolver() {
		StandardServletMultipartResolver resolver=new StandardServletMultipartResolver();
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingApplication.class, args);
	}

}
