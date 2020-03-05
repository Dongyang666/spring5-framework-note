package com.dyliu.springlife;

import com.dyliu.lookup.Prototype;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
public class SpringBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, BeanClassLoaderAware{
	public static ApplicationContext applicationContext = null;


	public SpringBean(Test test) {
		System.out.println("SpringBean构造方法:" + studentService);
		System.out.println("SpringBean---Test构造方法");
	}
	@Autowired
	public SpringBean(){
		System.out.println("SpringBean---默认构造方法");
	}

	public SpringBean(Prototype prototype){
		System.out.println("SpringBean---prototype构造方法");
	}

	@Lookup
	public Prototype prototype(){
		return null;
	}
	@Autowired
	private StudentService studentService;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("setBeanClassLoader");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("setBeanName:" + studentService);
		System.out.println("setBeanName");
	}

	public void initMethod() {
		System.out.println("initMethod");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod");
	}

	@Lookup
	public Prototype getPrototype(){
		return null;
	}

}
