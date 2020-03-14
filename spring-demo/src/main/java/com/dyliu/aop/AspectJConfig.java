package com.dyliu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Aspect
@Component
public class AspectJConfig {
	@Pointcut("execution(* com.dyliu.aop..*.*(..))")
	public void ponitCut(){
	}

	@Before("ponitCut()")
	public void before(){
		System.out.println("before");
	}

}
