package com.dyliu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 *
 * @author liudongyang
 */
@Configuration
@ComponentScan("com.dyliu.jdbc")
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class JdbcConfig {

	@Bean
	public DruidDataSource dataSource(){
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUrl("jdbc:mysql://localhost:3306/tran_demo");
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("root");
		return druidDataSource;
	}


	@Bean
  	public DataSourceTransactionManager txManager() {
	  return new DataSourceTransactionManager(dataSource());
  	}
}
