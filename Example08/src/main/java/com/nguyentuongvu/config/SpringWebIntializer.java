package com.nguyentuongvu.config;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebIntializer implements WebApplicationInitializer
{
	public void onStartup (ServletContext container) throws ServletException {
		  AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	        ctx.register(SpringConfiguration.class);
	        ctx.setServletContext(container);
	        container.addListener(new ContextLoaderListener(ctx));
	        try {
	            ctx.getResources("/images/**");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("No resources found");
	        }
    

        ServletRegistration.Dynamic servlet =container.addServlet("springDispatcherServlet",new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
       
	}
	  }
