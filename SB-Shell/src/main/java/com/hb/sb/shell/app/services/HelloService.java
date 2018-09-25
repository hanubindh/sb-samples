package com.hb.sb.shell.app.services;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	
	public String sayHello(String name) {
		return String.format("Hello %s", name);
	}
}