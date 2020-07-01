package com.dyliu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Aspect
@Component
public class AspectJConfig {
	public AspectJConfig(){
		//System.out.println("create AspectJConfig");
	}
	@Pointcut("execution(* com.dyliu.aop.*.*(..))")
	public void pointCut(){
	}


	/*@Before("pointCut()")
	public void beforey(){
		System.out.println("before1");
	}*/

	//@Before("pointCut()")
	public void before() throws Exception {
		System.out.println("before");

	}



	@After("pointCut()")
	public void after(JoinPoint joinPoint) throws Exception {
		System.out.println("After");
		System.out.println(joinPoint.getClass().getName());

	}

	//@AfterReturning("pointCut()")
	public void afterReturn() throws Exception {
		System.out.println("afterReturn");

	}

	//@AfterThrowing("pointCut()")
	public void afterThrowing() throws Exception {
		System.out.println("afterThrowing");

	}

	//@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around before");
		//这个执行回调用链了
		Object proceed = pjp.proceed();
		System.out.println("around after");
		return proceed;
	}
}
