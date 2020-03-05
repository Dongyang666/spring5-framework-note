package com.dyliu.importBeanDefinitionRegistrar;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liudongyang
 */
public class MyFactoryBean implements FactoryBean<Object> {

	private Class<?> clazz;
	public MyFactoryBean(Class<?> clazz){
		this.clazz = clazz;
	}
	
	@Override
	public Object getObject() {
		return Proxy.newProxyInstance(clazz.getClassLoader(),new Class<?>[]{clazz},(proxy,method,args)->{
			String sql = method.getAnnotation(Sql.class).value();
			System.out.println(sql);
			return proxy;
		});
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}
}
