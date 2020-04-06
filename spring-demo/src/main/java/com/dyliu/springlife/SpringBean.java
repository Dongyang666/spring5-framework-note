package com.dyliu.springlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author liudongyang
 */
//@Component
public class SpringBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, ApplicationListener<ContextClosedEvent> {
	public static ApplicationContext applicationContext = null;

	private String aa = "123";
	private int i =567 ;
	@Autowired
	/**
	 * 这个方法中会判断注入的是不是spring自己的bean 然后注入
	 * DefaultListableBeanFactory#findAutowireCandidates
	 */
	private ApplicationContext context;

	@Autowired
	private void setStudentService(StudentService studentService){
		this.studentService = studentService;
	}


	//@Autowired
	public SpringBean(Map<String,Test> map) {
		System.out.println(map.get("test1111"));
		System.out.println("SpringBean构造方法:" + studentService);
		System.out.println("SpringBean---Test构造方法");
	}

	//@Autowired
	public SpringBean(List<ITest> testList) {
		System.out.println(testList.size());
		System.out.println(testList.get(0));
		System.out.println("SpringBean构造方法:" + studentService);
		System.out.println("SpringBean---Test构造方法");
	}

	//@Autowired
	public SpringBean(Optional<Test> optionalTest) {
		System.out.println(optionalTest.get());
		System.out.println("SpringBean构造方法:" + studentService);
		System.out.println("SpringBean---Test构造方法");
	}

	//@Autowired
	public SpringBean(){
		System.out.println("SpringBean---默认构造方法");
	}

	//@Autowired
	public SpringBean(Test test){
		System.out.println(test);
		System.out.println("SpringBean---prototype构造方法");
	}
	@Autowired
	public SpringBean(Test test,Test test1,List<ITest> list){
		System.out.println(test);
		System.out.println("SpringBean---prototype构造方法");
	}

	/*@Lookup
	public Prototype prototype(){
		return null;
	}*/
	private StudentService studentService;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("interface afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("interface destroy");
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

	public void test(){
		System.out.println(context);
	}
	@PostConstruct
	private void postConstruct(){
		System.out.println("postConstruct");
	}

	@PreDestroy
	private void preDestroy(){
		System.out.println("preDestroy");
	}

	public void initMethod() {
		System.out.println("initMethod");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod");
	}

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		System.out.println("contextClosedEvent");
	}
}
