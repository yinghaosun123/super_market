package com.yjw.supermarket.framework.exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class HandlerException extends SimpleMappingExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		HandlerMethod handlerMethod = (HandlerMethod) handler;   
		ResponseBody body = handlerMethod.getMethodAnnotation(ResponseBody.class);  
		// 判断有没有@ResponseBody的注解没有的话调用父方法   
		if (body == null) {  
			return super.doResolveException(request,response,handlerMethod,ex);   
			} 
		ModelAndView mv = new ModelAndView();   
		if(ex instanceof BusinessException){
			BusinessException be=(BusinessException) ex;
			String message = be.getMessage();
			String code = be.getCode();
			Map<String,String>  error = new HashMap<String,String>();
			error.put("msg", message== null?"":message);
			error.put("code", code== null?"":code);
			// 设置状态码,注意这里不能设置成500，设成500JQuery不会出错误提示        
			//并且不会有任何反应    
			response.setStatus(HttpStatus.OK.value());   // 设置ContentType    
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);   // 避免乱码   
			response.setCharacterEncoding("UTF-8");   
			response.setHeader("Cache-Control", "no-cache, must-revalidate");   
			try {     
			ex.printStackTrace();   
			PrintWriter writer = response.getWriter();   
			writer.write(JSONObject.fromObject(error).toString());   
			writer.close();    
			} catch (IOException e) {  
				e.printStackTrace();   
			}   			
		}else{
			return super.doResolveException(request, response,handler,ex);   
		}
		return mv;
	}
}
/*PrintWriter out = response.getWriter();
response.setStatus(200);
StringBuilder builder = new StringBuilder();
System.out.println("ae.getMessage()==="+ae.getMessage());
builder.append("{\"ret\":\"101\",\"msg\":\"被迫下线\"}"+ae.getMessage());
//builder.append("{\"msg\":\""+ae.getMessage()+"\",\"code\":\""+ae.getCode()+"\"}");
out.print(builder.toString());
*/
/*else{
	Exception tracet=ex;
	 StringWriter sw = new StringWriter();
     PrintWriter pw = new PrintWriter(sw);
     tracet.printStackTrace(pw);
     String stacktrace = sw.toString();
    //System.out.println(stacktrace);
}*/
