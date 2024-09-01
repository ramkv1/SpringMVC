package com.rk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@SpringBootApplication
public class BootMvcProj22TilesFrameworkApplication {

	@Bean
	public TilesConfigurer createConfigurer() {
		TilesConfigurer configurer=new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");
		return configurer;
	}
	
	@Bean
	public TilesViewResolver createViewResolver() {
		TilesViewResolver resolver=new TilesViewResolver();
		return resolver;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj22TilesFrameworkApplication.class, args);
	}

}
