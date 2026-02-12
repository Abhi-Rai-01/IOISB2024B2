package com.app.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("service")
public class ExcelExportService {
	
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
	
	@PostConstruct
	private void doSetUp() {
		System.out.println("**********some logic to process before calling the methods****************");
	}
	
	@PreDestroy
	private void doCleanUp() {
		System.out.println("**********some logic to process after calling the methods****************");		
	}
	
	@Override
	public String toString() {
		return "ExcelExportService [filename=" + filename + ", mode=" + mode + "]";
	}

}
