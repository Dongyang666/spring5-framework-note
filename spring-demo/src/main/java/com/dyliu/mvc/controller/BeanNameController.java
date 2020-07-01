package com.dyliu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liudongyang
 */
@Controller
@RequestMapping("v1")
public class BeanNameController {

	@GetMapping("/test.do")
	@ResponseBody
	public String test(){
		System.out.println("-------");
		return "abccccc";
	}
}
