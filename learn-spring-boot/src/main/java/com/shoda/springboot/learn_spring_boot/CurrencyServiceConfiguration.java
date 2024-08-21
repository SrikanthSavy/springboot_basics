package com.shoda.springboot.learn_spring_boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "currency-service")  // Helps wire properties defined in the application.properties
@Component // As we want Spring to Manage it
public class CurrencyServiceConfiguration {
	
	private String url;
	private String name;
	private String key;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	

}
