package com.dyliu.jdbc;

import com.dyliu.jdbc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author liudongyang
 */
public class JdbcMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		// 激活pro环境.
		// ac.getEnvironment().setDefaultProfiles("dev");
		// ac.getEnvironment().setActiveProfiles("pro");
		ac.register(JdbcConfig.class);
		ac.refresh();

		UserService bean = ac.getBean(UserService.class);
		System.out.println("save 调用者:"+ bean.getClass());
		bean.save();

	}


}
