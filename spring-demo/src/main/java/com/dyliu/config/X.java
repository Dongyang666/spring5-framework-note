package com.dyliu.config;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
@Import(AppConfig2.class)
public class X {

	public X(){
		//System.out.println("create X");
	}
}
