package com.app.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("service")
public class ExcelExportService implements InitializingBean, DisposableBean {
	
	@Value("${my.data.filename}")
	private String filename;
	@Value("${my.data.mode}")
	private String mode;
	
	static {
		System.out.println("ExcelExportService.class file is loaded");
	}
	
	
	public ExcelExportService() {
		super();
		System.out.println("ExcelExportService object is created by Spring F/W...");
	}

	private void initLogic() {
		System.out.println("**********some logic to process before calling the methods****************");
	}
	
	private void cleanUpLogic() {
		System.out.println("**********some logic to process after calling the methods****************");		
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		initLogic();
	}
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		cleanUpLogic();
	}
	
	@Override
	public String toString() {
		return "ExcelExportService [filename=" + filename + ", mode=" + mode + "]";
	}

}
