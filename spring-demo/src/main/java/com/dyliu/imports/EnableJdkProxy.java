package com.dyliu.imports;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Import({AspectSelector.class,A.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableJdkProxy {
}
