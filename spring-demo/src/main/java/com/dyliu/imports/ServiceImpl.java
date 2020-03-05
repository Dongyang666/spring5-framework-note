package com.dyliu.imports;

import org.springframework.stereotype.Component;

/**
 * @author liudongyang
 */
@Component
public class ServiceImpl implements Service {
	@Override
	public void query() {
		System.out.println("查询-------");
	}
}
