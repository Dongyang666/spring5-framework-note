package com.dyliu.springlife;

import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component("test1")
public class Test implements ITest {
	public Test(){
		System.out.println("create Test");
	}

}
