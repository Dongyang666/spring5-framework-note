package com.dyliu.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
//@Profile("pro")
public class Config {
	@Value("#{temp.string}")
	//@Value("${spring.profiles.active}")
	private String username;

	public void config(){
		System.out.println(username);
	}
}
