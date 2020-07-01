package com.dyliu.jdbc.service;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.Types;

/**
 *
 * @author liudongyang
 */
@Component
public class UserService implements ApplicationContextAware {

	private JdbcTemplate jdbcTemplate;
	private ApplicationContext applicationContext;

	@PostConstruct
	public void setDataSource(){
		jdbcTemplate = new JdbcTemplate();
		DruidDataSource dataSource = applicationContext.getBean(DruidDataSource.class);
		jdbcTemplate.setDataSource(dataSource);
	}

	@Transactional
	public void save(){
		jdbcTemplate.update("insert into user(name,sex,age) values (?,?,?)",
				new Object[]{"dyliu","男",25},new int[]{Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		 UserService userService = (UserService) AopContext.currentProxy();
		 userService.save1();
		 save1();
		throw new RuntimeException("aaa");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save1(){
		System.out.println("save1 调用者是:"+this.getClass());
		jdbcTemplate.update("insert into user(name,sex,age) values (?,?,?)",
				new Object[]{"dyliu2","男",25},new int[]{Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
		//throw new RuntimeException("aaa");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
