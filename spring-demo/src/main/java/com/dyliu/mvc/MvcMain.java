package com.dyliu.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;

/**
 * @author liudongyang
 */
public class MvcMain {
	public static void main(String[] args) {
		//String webappDirLocation = "spring-demo/src/main/java/com/dyliu/mvc";
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9998);
		//tomcat.addContext("/",MvcMain.class.getResource("/").getPath().replaceAll(".","/"));
		try {
			tomcat.addWebapp("/","/Users/liudongyang/Desktop/tom");
			tomcat.start();
			tomcat.getServer().await();
		} catch (ServletException | LifecycleException e) {
			e.printStackTrace();
		}

	}
}
