package com.dyliu.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 * 监听是个什么概念？？就是说某件事情发生的时候会通知你
 * 怎么叫通知你了呢？就是调用了你的方法。你可以在方法中响应这个通知
 * 两种实现监听的方式
 * 1.实现ApplicationListener此接口，传入要监听的泛型类即可
 * 2.通过@EventListener注解完成时间监听的处理，可以传入多个事件对象
 * @EventListener({ContextClosedEvent.class, ContextRefreshedEvent.class})
 *
 */
@Component
public class BlackEmailSendListener implements ApplicationListener<BlackEvent> {
	@Override
	public void onApplicationEvent(BlackEvent event) {
		System.out.println("接口通知");
	}
}
