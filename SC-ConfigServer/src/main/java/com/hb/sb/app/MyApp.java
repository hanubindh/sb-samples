package com.hb.sb.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.config.server.EnableConfigServer;

@ComponentScan("com.hb")
@SpringBootApplication
@EnableConfigServer
public class MyApp {

	private static Logger logger = LoggerFactory.getLogger(MyApp.class);

	public static void main(String[] args) {
		logger.info("Application is starting... ");
		SpringApplication app = new SpringApplication(MyApp.class);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.setLogStartupInfo(false);
		ApplicationContext ctx = app.run(args);
		logger.info("Application started");
	}
}