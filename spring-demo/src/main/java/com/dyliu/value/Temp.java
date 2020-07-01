package com.dyliu.value;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liudongyang
 */
@Component
public class Temp {
	private String string;

	@PostConstruct
	public void test(){
		string = "aaa";
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
