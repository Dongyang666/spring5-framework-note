package com.dyliu.importBeanDefinitionRegistrar;

/**
 * @author liudongyang
 */
@MyMapper
public interface UserRepo {

	@Sql("SELECT name,age FROM t_user")
	void get();
}
