package com.yjw.supermarket.framework.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

public class BusinessException extends Exception {
	private static final long serialVersionUID = -9190857360219190477L;
	private String code;
	private boolean fullPage;

	private String className;
	private String methodName;
	
	private String info;
	
	
	
	

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public BusinessException() {
		fullPage = false;
	}

	public BusinessException(String message) {
		super(message);
		fullPage = false;
	}

	public BusinessException(Throwable cause) {
		super(cause);
		fullPage = false;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		fullPage = false;

	}

	/**
	 * 异常构造函数
	 * 说明:用于输出异常详细信息的日志
	 * @time 2018-07-16 15:03:42
	 * @author chenkeyuan
	 */
	
	public BusinessException(String code,boolean fullPage, String className,
			String methodName,Throwable cause,String info) {
		super(cause);
		this.code = code;
		this.fullPage = fullPage;
		this.className = className;
		this.methodName = methodName;
		this.info=info;
		Logger logger = Logger.getLogger(BusinessException.class);
		logger.error("======ERROR START======");
		logger.error(cause.toString()+" "+code + " " + className + " " + methodName+"数据还原所需数据:"+info);
		//logger.error("stackTrace(Top 5):");
		StackTraceElement[] _traces=cause.getStackTrace();
		for(int i = 0 ; i < _traces.length ; i++){
			logger.error(_traces[i]);
		}
		logger.error("======ERROR END======");
		
	}

	
	
	
	
	/*public BusinessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}*/

	public void printStackTrace() {
		Throwable t = getRawCause();
		if (!(t instanceof BusinessException) && t != null)
			t.printStackTrace();
	}

	public void printStackTrace(PrintWriter pw) {
		Throwable t = getRawCause();
		if (!(t instanceof BusinessException) && t != null)
			t.printStackTrace(pw);
	}

	public void printStackTrace(PrintStream s) {
		Throwable t = getRawCause();
		if (!(t instanceof BusinessException) && t != null)
			t.printStackTrace(s);
	}

	public Throwable getRawCause() {
		Throwable ct = super.getCause();
		if (ct instanceof BusinessException)
			return ((BusinessException) ct).getRawCause();
		else
			return ct;
	}

	public BusinessException getRawBusinessException() {
		Throwable t = getCause();
		if (t instanceof BusinessException)
			return ((BusinessException) t).getRawBusinessException();
		else
			return this;
	}

	public String getCode() {
		if (code == null) {
			String curm = String.valueOf(System.currentTimeMillis());
			setCode(curm.substring(curm.length() - 10));
		}
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isFullPage() {
		return fullPage;
	}

	public void setFullPage(boolean fullPage) {
		this.fullPage = fullPage;
	}

	

}
