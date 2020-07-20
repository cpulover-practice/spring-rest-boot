package com.cpulover.rest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //disable Spring Security
public class SpringRestBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestBootApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		//Option 1
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		//Option 2: use with LocaleContextHolder, get locale from "Accept-Language" key
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		// set default locale to US
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("message"); // include all message*.properties files
//		return messageSource;
//	}

}
