package com.nguyentuongvu.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebIntializer implements WebApplicationInitializer
{
	public void onStartup (ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context =new AnnotationConfigWebApplicationContext();
        context.register(SpringConfiguration.class);
        context.setServletContext(container);

        ServletRegistration.Dynamic servlet =container.addServlet("springDispatcherServlet",new DispatcherServlet(context));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
	}
}
