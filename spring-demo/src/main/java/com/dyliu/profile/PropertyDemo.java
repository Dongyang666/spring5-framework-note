package com.dyliu.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
@Configuration
@PropertySource("classpath:app-pro.properties")
public class PropertyDemo {
	@Autowired
	private Environment environment;

	@Value("${username}")
	private String u;

	public PropertyDemo(){
	}

	public void printEnv(){
		System.out.println(u);
		System.out.println(environment.getProperty("username"));

	}

}
