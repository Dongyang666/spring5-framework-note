package com.dyliu.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liudongyang
 */
@Component
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
		//if(blackList.contains(address)){
			//发布事件，监听这个事件的事件监听器就会调用他的监听函数---BlackEmailSendListener#onApplicationEvent
			publisher.publishEvent(new BlackEvent(this,address,content));
			return;
		//}
		//send email
	}
}
