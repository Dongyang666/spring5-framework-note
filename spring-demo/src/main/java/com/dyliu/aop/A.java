package com.dyliu.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
public class A  {

	@Autowired
	private B b;

	public A(){
		System.out.println("create A ----");
	}

	public void testPublic() throws Exception {
		System.out.println("testPublic");
//		throw new Exception("---Exception--");
		//其实testB方法按理来说也应该是被代理的但这个调用，spring apo是不会代理这个testB方法的
		//testB();
		//这样写testB方法就会被代理
		//((A)AopContext.currentProxy()).testB();
	}

	public void testA(){
		//System.out.println("testB");
		b.test();
	}
}
