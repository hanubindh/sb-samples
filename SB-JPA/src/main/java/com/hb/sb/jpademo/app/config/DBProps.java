package com.hb.sb.jpademo.app.config;

import java.util.Properties;

//@Configuration 
//@PropertySource("classpath:database.properties")
//@ConfigurationProperties
public class DBProps {
	
	public static class Database {
		private String driverClassName;
		private String url;
		private String username;
		private String password;
	}
} 