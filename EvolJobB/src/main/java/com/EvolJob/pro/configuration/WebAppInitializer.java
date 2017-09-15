package com.EvolJob.pro.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
@Override
protected String[] getServletMappings(){

	System.out.println("1 working");
	return new String[]{"/"};
}

@Override
protected Class<?>[]getRootConfigClasses(){
	//TODO Auto-generated method sub

	System.out.println("working1");
	return new Class[]{WebAppConfig.class};
}

@Override
protected Class<?>[]getServletConfigClasses(){
	//TODO Auto-generated method sub

	System.out.println("working2");
	return null;
}
}
