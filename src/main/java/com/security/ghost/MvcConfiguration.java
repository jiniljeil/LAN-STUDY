package com.security.ghost;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor())
		.excludePathPatterns("/css/**", "/fonts/** d", "/plugin/**", "/scripts/**");
		registry.addInterceptor(new LoginInterceptor())
		.excludePathPatterns("/resources/css/**", "/resources/assets/**", "/resources/js/**", "/error/**", "/", "/join", "/login");
		registry.addInterceptor(new GroupInterceptor())
		.addPathPatterns("/board/**");
		registry.addInterceptor(new GroupInterceptor())
		.addPathPatterns("/board/**/manage/**");
		
	}

}