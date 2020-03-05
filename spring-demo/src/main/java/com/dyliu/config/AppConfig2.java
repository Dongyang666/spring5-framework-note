package com.dyliu.config;

import com.dyliu.imports.A;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author liudongyang
 * ImportAware这个拿到import这个bean的bean的注解元数据（有点绕）
 * 这个例子中AppConfig2是X类import进来的所以拿到的元注解是X类的
 */
//@ComponentScan("com.dyliu.imports")
@Import(A.class)
public class AppConfig2 implements ImportAware {

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		System.out.println(importMetadata.getClassName());
	}
}
