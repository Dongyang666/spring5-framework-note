package com.dyliu.lookup;

import com.dyliu.imports.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
@Scope("prototype")
public class Prototype {
	@Autowired
	public A a;
	public Prototype(){
		System.out.println("create Prototype");
	}

	public void say(){
		System.out.println(this);
		a.say();
	}
}
