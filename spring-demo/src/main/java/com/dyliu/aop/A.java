package com.dyliu.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
public class A {
	@Autowired
	private B b;

	public void testPublic(){
		System.out.println("testPublic");
	}
}
