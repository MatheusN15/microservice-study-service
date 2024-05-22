package br.com.matheusmn.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheusmn.configuration.MicroserviceConfiguration;

@RestController
@RequestMapping("/hello")
public class GreetingController {
	
	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private MicroserviceConfiguration configuration;

	@GetMapping
	public String hello(@RequestParam(value="name", defaultValue="") String name) {
		if (name.isEmpty()) name = configuration.getDefaultValue();
		return "id:" + counter.incrementAndGet()+" message:" + String.format(template, configuration.getGreeting(),name);
	}
}
