package com.yjw.supermarket.framework.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationObjectSupport;

/**
 *author liuyishan
 *date 2012-3-7
 */
@Component
public class ApplicationContextHolder extends WebApplicationObjectSupport{
	 
	
	public static ApplicationContextHolder applicationContextUitl;
	
	public ApplicationContextHolder(){
		applicationContextUitl = this;
	}
	
	public static Object getBean(String name){
		try{
			return applicationContextUitl.getApplicationContext().getBean(name);
		}catch(Exception e){
			return null;
		}
	}
	
	public static <T> Class<?> getBean(Class<T> clazz){
		try {
			return (Class<?>) applicationContextUitl.getApplicationContext().getBean(clazz);
		}catch (Exception e) {
			return null;
		}
	}
	
	/*private static class SingleHolder {
		public static ApplicationContextUitl applicationContextUitl = new ApplicationContextUitl();
	}
	
	public static Object getBean(String name){
		return SingleHolder.applicationContextUitl.getApplicationContext().getBean(name);
	}*/
}