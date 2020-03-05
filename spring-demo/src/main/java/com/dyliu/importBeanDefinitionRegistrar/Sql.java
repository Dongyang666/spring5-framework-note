package com.dyliu.importBeanDefinitionRegistrar;



import java.lang.annotation.*;


/**
 * 此注解是用来写sql语句的
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Sql {
	String value() default "";
}
