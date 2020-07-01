package com.dyliu.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
public class B {

	@Autowired
	private A a;

	public B (){
		System.out.println("create B ----");
	}
	public void test(){
		System.out.println("testB");
	}

}
