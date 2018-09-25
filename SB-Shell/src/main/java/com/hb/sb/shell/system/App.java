package com.hb.sb.shell.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hb")
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(App.class);
		// app.setBannerMode(Banner.Mode.OFF);
		// app.setLogStartupInfo(false);
		ApplicationContext ctx = app.run(args);
	}
}