package com.dyliu.lookup;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 * 单例类中注入原型类会发现注入的原型类也是单例的。
 * 因为在spring的单例对象只会走一次初始化，不会重新注入其中的对象导致出现问题。
 * 两种解决方法
 * 1.实现ApplicationContextAware接口注入一个applicationContext对象。通过spring上下文对象获取实例bean即可
 * 2.设置一个get函数返回值用--需要注入的原型类，并且给这个方法加上@Loopup注解，这个注解是调用context对象getBean---
 */
@Component
public class Singleton implements ApplicationContextAware {
	@Autowired
	private Prototype prototype;

	private ApplicationContext applicationContext;
	public Singleton(){
		System.out.println("create Singleton");
	}
	@Lookup
	public Prototype getPrototype(){
		return null;
	}

	public void say(){
		System.out.println(this);
		//applicationContext.getBean(Prototype.class).say();
		getPrototype().say();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
