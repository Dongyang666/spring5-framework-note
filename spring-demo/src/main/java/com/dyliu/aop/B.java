package com.dyliu.aop;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liudongyang
 */
//@Component
public class B {
	@Autowired
	private A a;
	public void test(){
		System.out.println("test");
	}
}
