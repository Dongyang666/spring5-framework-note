package com.dyliu.imports;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liudongyang
 */
public class JdkProxyBeanPostProcess implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("serviceImpl")){
			return Proxy.newProxyInstance(bean.getClass().getClassLoader(),bean.getClass().getInterfaces(),(object,method,arg)->{
				System.out.println("方法开始执行");
				object = method.invoke(bean,arg);
				System.out.println("方法执行完毕");
				return object;
			});
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
