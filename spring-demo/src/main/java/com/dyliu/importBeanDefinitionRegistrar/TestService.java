package com.dyliu.importBeanDefinitionRegistrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liudongyang
 */
@Service
public class TestService {
	@Autowired
	private UserRepo userRepo;
	public void get(){
		userRepo.get();
	}
}
