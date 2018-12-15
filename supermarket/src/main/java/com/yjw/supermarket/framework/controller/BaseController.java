package com.yjw.supermarket.framework.controller;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yjw.supermarket.framework.interceptors.DateConvertEditor;
import com.yjw.supermarket.framework.interceptors.TimestampEditor;

public class BaseController extends MultiActionController{
	@InitBinder
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
		try {
			binder.registerCustomEditor(Date.class, new DateConvertEditor());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//binder.registerCustomEditor(Timestamp.class, new TimestampEditor(df,true));
			binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
			//在这里可以注册其他属性编辑器，在使用的过程中可以不断添加
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView toPage(HttpServletRequest request,HttpServletResponse response){
		System.out.println("====this is go to page common====");
		String page = request.getParameter("pageName");
		ModelAndView mav = new ModelAndView();
		if(null != page && !"".equals(page)){
			mav.setViewName(page);
		}else{
			mav.setViewName("common/error");
		}
		return mav;
	}
}
