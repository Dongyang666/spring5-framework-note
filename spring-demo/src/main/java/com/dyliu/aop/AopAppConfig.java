package com.dyliu.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author liudongyang
 * @Configuration这个注解主要是为了保证bean的作用域
 * 把带上了@Configuration的配置类称之为Full配置类，
 * 把没有带上@Configuration，但是带上了@Component @ComponentScan @Import @ImportResource等注解的配置类称之为Lite配置类。
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.dyliu.aop"})
public class AopAppConfig {

}
