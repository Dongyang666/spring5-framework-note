package com.dyliu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Aspect
@Component
public class AspectJConfig2 {
	public AspectJConfig2(){
		//System.out.println("create AspectJConfig");
	}
	@Pointcut("execution(* com.dyliu.config..*.*(..))")
	public void pointCut(){
	}


	/*@Before("pointCut()")
	public void beforey(){
		System.out.println("before1");
	}*/

	@Before("pointCut()")
	public void before() throws Exception {
		System.out.println("before");

	}



	@After("pointCut()")
	public void after() throws Exception {
		System.out.println("After");

	}

	@AfterReturning("pointCut()")
	public void afterReturn() throws Exception {
		System.out.println("afterReturn");

	}

	@AfterThrowing("pointCut()")
	public void afterThrowing() throws Exception {
		System.out.println("afterThrowing");

	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before");
		//这个执行回调用链了
		Object proceed = pjp.proceed();
		System.out.println("around after");
		return proceed;
	}
}
