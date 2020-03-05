package com.dyliu.importBeanDefinitionRegistrar;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Import(MapperScannerRegistrar.class)
public @interface MyMapperScanner {
	String value() default "";
}
