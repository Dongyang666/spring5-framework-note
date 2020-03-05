package com.dyliu.importBeanDefinitionRegistrar;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.io.IOException;

/**
 * @author liudongyang
 */
public class MapperScannerRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
	private ResourceLoader resourceLoader;

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		try {
			//拿到加了MyMapperScanner扫描类的扫描mapper包
			AnnotationAttributes annotationAttributes = AnnotationAttributes.
					fromMap(importingClassMetadata.getAnnotationAttributes(
							MyMapperScanner.class.getName()));
			String packageValue = annotationAttributes.getString("value");
			String valuePath = packageValue.replace(".","/");
			File[] files = resourceLoader.getResource(valuePath).getFile().listFiles();
			//挨个遍历这个包底下的所有class文件
			for (File file : files) {
				String name = file.getName().replace(".class", "");
				//加载这个类
				Class<?> aClass = Class.forName(packageValue + "." + name);
				//判断这个类是不是接口并且是不是加了MyMapper注解
				if(aClass.isInterface() && aClass.isAnnotationPresent(MyMapper.class)){
					//生成beanDefinition 并注册到spring中去--
					BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
					AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
					//注册的时候使用FactoryBean方法
					beanDefinition.setBeanClass(MyFactoryBean.class);
					beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(packageValue+"."+name);
					registry.registerBeanDefinition(name,beanDefinition);
				}

			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
