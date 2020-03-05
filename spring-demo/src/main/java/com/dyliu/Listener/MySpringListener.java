package com.dyliu.Listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * @author liudongyang
 * ContextRefreshedEvent 容器刷新后执行
 * ContextStartedEvent   容器start
 * ContextStoppedEvent   容器stop
 * ContextClosedEvent    容器关闭
 * RequestHandledEvent   请求已经被处理后执行
 * ServletRequestHandledEvent
 */
public class MySpringListener implements ApplicationListener<ContextClosedEvent> {
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {

	}

	@EventListener({ContextClosedEvent.class, ContextRefreshedEvent.class})
	public void process(ApplicationEvent event){
		System.out.println(event.toString());
	}
}
