package com.dyliu.profile;

import com.dyliu.factorybean.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
@Configuration
public class ProFileConfig {

	@Bean
	@Profile("dev")
	public DataSource dataDev(){
		System.out.println("使用测试环境配置");
		return new DataSource();
	}

	@Bean
	@Profile("pro")
	public DataSource dataPro(){
		System.out.println("使用生产环境配置");
		return new DataSource();
	}
}
