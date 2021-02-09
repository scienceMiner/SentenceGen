package com.scienceminer.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

	private static final String template = "You are dumb, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/sentence")
	public Request greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Request(counter.incrementAndGet(), String.format(template, name));
	}
}