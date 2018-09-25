package com.hb.sb.shell.app.commands;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.stereotype.Component;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.hb.sb.shell.app.services.HelloService;

@Component
@ShellComponent
public class AppCommands {
	
	private final HelloService helloService;
	
	@Autowired
	public AppCommands(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@ShellMethod(value = "Command that greets you", 
		key = "sayHello")
	public String sayHello(@ShellOption (defaultValue = "Guest") String name) {
		return helloService.sayHello(name);
	}
}

