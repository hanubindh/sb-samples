package com.hb.sb.services;

import com.hb.sb.framework.exception.InvalidMessageException;

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
	
	@RequestMapping("/getMessage")
	public Message getMessage(
		@RequestParam(value="message", defaultValue="") String message) {
		logger.info("{}:{} : Responding to request - {}", appID, env, message);
		long id = (long) (Math.random() * 1000000);
		if(message.equals("")) {
			throw new InvalidMessageException(
				new StringBuilder().append(id).toString(), 
				appID,
				"A blank message encountered");
		} 
		// Else		
		return new Message(id, message);
	}
}