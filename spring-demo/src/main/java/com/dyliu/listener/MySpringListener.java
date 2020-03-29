package com.dyliu.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 * ContextRefreshedEvent 容器刷新后执行
 * ContextStartedEvent   容器start
 * ContextStoppedEvent   容器stop
 * ContextClosedEvent    容器关闭
 * RequestHandledEvent   请求已经被处理后执行
 * ServletRequestHandledEvent
 */
@Component
public class MySpringListener  {


	@EventListener({BlackEvent.class})
	public void process(ApplicationEvent event){
		System.out.println("注解通知");
	}
}
