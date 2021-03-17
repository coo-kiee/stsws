package org.tufcookie.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import lombok.extern.log4j.Log4j;

@EnableWebMvc
@ComponentScan(basePackages = {"org.tufcookie.main", 
								"org.tufcookie.time.controller",
								"org.tufcookie.board.controller",
								"org.tufcookie.board.controller"})
@EnableAspectJAutoProxy

public class ServletConfig implements WebMvcConfigurer{
	
	@Override
	  public void configureViewResolvers(ViewResolverRegistry registry) {

	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    registry.viewResolver(bean);
	  }

	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {

	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	  }

}
