package com.dyliu.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
public class Config {
	@Value("${username}")
	private String username;

	public void config(){
		System.out.println(username);
	}
}
