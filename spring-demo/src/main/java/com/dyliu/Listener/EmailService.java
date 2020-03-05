package com.dyliu.Listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.util.List;

/**
 * @author liudongyang
 */
public class EmailService implements ApplicationEventPublisherAware {
	private List<String> blackList;
	private ApplicationEventPublisher publisher;

	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void sendEmail(String address,String content){
		if(blackList.contains(address)){
			publisher.publishEvent(new BlackEvent(this,address,content));
			return;
		}
		//send email
	}
}
