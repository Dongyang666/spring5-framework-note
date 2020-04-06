package com.dyliu.value;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

/**
 * @author liudongyang
 */
@Component
public class BeanDefinitionRegistryPostProcessorSupportChin implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		//ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory)registry;

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Map map = beanFactory.getBeansOfType(PropertySourcesPlaceholderConfigurer.class);
		// 可能存在多个PropertySourcesPlaceholderConfigurerbean的情况
		Iterator<Map.Entry<String, PropertySourcesPlaceholderConfigurer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, PropertySourcesPlaceholderConfigurer> entry = it.next();
			PropertySourcesPlaceholderConfigurer pp = entry.getValue();
			pp.setFileEncoding("UTF-8");
			// 终于获取到了设置文件编码类型的地方了
			// 这也是最关键的地方
		}
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
