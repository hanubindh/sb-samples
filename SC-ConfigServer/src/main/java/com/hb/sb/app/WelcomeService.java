package com.hb.sb.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/welcome")
public class WelcomeService {

	@Value("${app.props.appID}")
	private String appID;
	
	@RequestMapping("/")
	public String welcome() {
		return appID + " : Welcome";
	}
	
}