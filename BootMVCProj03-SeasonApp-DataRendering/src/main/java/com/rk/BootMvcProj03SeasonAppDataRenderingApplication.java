package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class BootMvcProj03SeasonAppDataRenderingApplication {

	/*@Bean
	public InternalResourceViewResolver createViewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj03SeasonAppDataRenderingApplication.class, args);
	}

}
