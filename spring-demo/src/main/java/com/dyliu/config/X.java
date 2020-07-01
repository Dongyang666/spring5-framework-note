package com.dyliu.config;

import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
// @Scope(WebApplicationContext.SCOPE_REQUEST)
// @Import(AppConfig2.class)
// 这个注解的处理是在这个bean进行扫描的时候就处理的，
// 不会把当前bean扫描的beanDefinitionMap中也就不会初始化了
// @Profile("dev")
public class X {

	public X(){
		System.out.println("create X");
	}
}
