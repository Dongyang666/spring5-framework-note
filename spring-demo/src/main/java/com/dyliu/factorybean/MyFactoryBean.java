package com.dyliu.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 *
 * 让我们仔细看下main方法和运行结果，可以看到 MyFactoryBean本身的BeanName是&myFactoryBean，
 * MyFactoryBean生产出来的Bean的BeanName是myFactoryBean。
 *
 * 这有什么用呢？可以隐藏构建Bean的细节。如果我们的DataSource是第三方提供的，里面有一堆的字段需要配置，还有一堆的依赖，
 * 如果我们来配置的话，根本无法完成，最好的办法就是还是交给维护第三方去配置，但是DataSource是不能去修改的。
 * 这个时候，就可以用FactoryBean来完成，在getObject配置好DataSource，并且返回。
 * 我们经常使用的Mybatis也利用了FactoryBean接口。
 *
 * FactoryBean不允许用户通过.class获取实例
 */
@Component
public class MyFactoryBean implements FactoryBean<DataSource> {
	@Override
	public DataSource getObject() {
		return new DataSource();
	}

	@Override
	public Class<?> getObjectType() {
		return DataSource.class;
	}
}
