package com.dyliu.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @author liudongyang
 */
//@Component
public class BlackEvent extends ApplicationEvent {
	private String address;
	private String content;
	public BlackEvent(Object source,String address,String content) {
		super(source);
		this.address = address;
		this.content = content;
	}
}
