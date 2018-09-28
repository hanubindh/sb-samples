package com.hb.sb.services;

import lombok.Data;
import java.lang.Math;

@Data
public class Message {

	private final long id;
	private final String message;
	
	public String toString() {
		return this.getMessage();
	}
}