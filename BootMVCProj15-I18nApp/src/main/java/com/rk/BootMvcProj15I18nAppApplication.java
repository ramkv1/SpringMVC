package com.rk;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj15I18nAppApplication {
	
	@Bean(name = "localeResolver")
	public SessionLocaleResolver createlocalresolver() {
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","IN"));
		return resolver;
	}
	
	@Bean
	public LocaleChangeInterceptor createInterupter() {
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj15I18nAppApplication.class, args);
	}

}
