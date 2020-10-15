package com.nguyentuongvu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.nguyentuongvu.controller" )
public class SpringConfiguration {
	@Bean(name="jspViewResolver" )
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	@Bean(name="multipartResolver" )
	public MultipartResolver multipartResolver(Environment env) {
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
       return resolver;
	  }
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration resourceRegistration = registry.addResourceHandler("images/**");
        resourceRegistration.addResourceLocations("/webapp/images/");
        registry.addResourceHandler("/**").addResourceLocations("/webapp/images/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images");
        registry.addResourceHandler("*.jpg").addResourceLocations("/images/");
    }
}
