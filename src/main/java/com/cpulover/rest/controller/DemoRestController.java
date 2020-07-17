package com.cpulover.rest.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/good-morning")
	//Option 1: get locale from "Accept-Language" key of Request Header
//	public String goodMorning(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
//		return messageSource.getMessage("good.morning", null, locale);
//	}
	
	//Option 2: get locale LocaleContextHolder (recommend)
	public String goodMorning() {
		return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping("/hello/{name}")
	public String sayHelloName(@PathVariable String name) {
		return "Hello, " + name;
	}
	
	@GetMapping("/hello")
	public String sayHello2(@RequestParam("name") String name) {
		return "Hello, " + name;
	}
}
