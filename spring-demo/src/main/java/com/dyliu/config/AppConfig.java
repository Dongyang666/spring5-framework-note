package com.dyliu.config;

import com.dyliu.springlife.SpringBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @author liudongyang
 * @Configuration这个注解主要是为了保证bean的作用域
 * 把带上了@Configuration的配置类称之为Full配置类，
 * 把没有带上@Configuration，但是带上了@Component @ComponentScan @Import @ImportResource等注解的配置类称之为Lite配置类。
 */
//@EnableJdkProxy
@Configuration
@EnableAspectJAutoProxy
//@ComponentScan(value = {"com.dyliu.config","com.dyliu.springlife","com.dyliu.profile","com.dyliu.lookup"})、
//@ComponentScan(value = {"com.dyliu.springlife"})
//@ComponentScan(value = {"com.dyliu.factorybean"})
//@ComponentScan(value = {"com.dyliu.prototype"})
//@MyMapperScanner("com.dyliu.importBeanDefinitionRegistrar")
@ComponentScan(value = {"com.dyliu.value"})
@PropertySource(value = "classpath:app.properties")
public class AppConfig {
	/*@Bean
	public TestClass getTestClass(){
		return new TestClass();
	}

	@Bean
	public OtherClass getOtherClass(){
		getTestClass();
		return new OtherClass();
	}*/

	//@Bean(initMethod = "initMethod",destroyMethod = "destroyMethod")
	public SpringBean springBean(){
		return new SpringBean();
	}


}
