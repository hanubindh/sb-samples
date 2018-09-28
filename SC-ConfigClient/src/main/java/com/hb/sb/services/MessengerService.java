package com.hb.sb.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RestController
@RequestMapping("messenger")
public class MessengerService {

	private static final Logger logger 
		= LoggerFactory.getLogger(MessengerService.class);
	@Value("${app.props.appID}")
	private String appID;
	
	@Value("${app.props.env}")
	private String env;
	
	@Value("${myapp.greet}")
	private String message;
	
	@RequestMapping("/getMessage")
	public Message getMessage() {
		logger.info("{}:{} : Responding to request - {}", appID, env, message);
		long id = (long) (Math.random() * 1000000);
		return new Message(id, message);
	}
}