package com.hb.sb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.hb")
@SpringBootApplication
public class MyApp {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MyApp.class);
		ApplicationContext ctx = app.run(args);
	}
}