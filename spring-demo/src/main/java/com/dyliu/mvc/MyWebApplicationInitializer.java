package com.dyliu.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @author liudongyang
 */
public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt) {

		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext rootAC = new AnnotationConfigWebApplicationContext();

		//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		//ac.setParent();
		rootAC.register(WebAppConfig.class);
		rootAC.refresh();
		//rootAC.refresh();
		//servletCxt.setAttribute("org.springframework.web.context.WebApplicationContext.ROOT",rootAC);

		/**
		 * 假如你没有传给DispatcherServlet一个WebApplicationContext对象的话
		 * 他会自动创建一个XML类型的WebApplicationContext
		 */
		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet();
		servlet.setApplicationContext(rootAC);

		ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("*.do");
	}


	@Override
	protected String[] getServletMappings() {
		return new String[0];
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}
}
