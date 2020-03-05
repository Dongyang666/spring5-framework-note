package com.dyliu.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author liudongyang
 * BeanDefinitionRegistryPostProcessor用户的实现这个接口的类优先级是最高的
 * 会率先执行这个，，，不过需要手动addBeanFactoryPostProcessor并且refresh容器
 */
public class BeanDefinitionRegisterPostProcessorDemo implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("手动添加工厂后置处理器");
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println(registry);
	}

}
