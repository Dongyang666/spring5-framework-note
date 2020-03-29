package com.dyliu.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoType {

	@Autowired
	public ProtoType(Type type){
		System.out.println("create ProtoType");
	}

}
