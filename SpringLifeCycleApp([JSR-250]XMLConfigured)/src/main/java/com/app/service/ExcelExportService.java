package com.app.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ExcelExportService {
	
	private String filename;
	private String mode;
	
	public void setFilename(String filename) {
		System.out.println("***********************BEAN INITIALIZATION******************************");
		this.filename = filename;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	static {
		System.out.println("***********************BEAN LOADING******************************");
	}
	
	
	public ExcelExportService() {
		super();
		System.out.println("***********************BEAN INSTANTIATION*****************************");
	}

	@PostConstruct
	public void doSetUp() {
		System.out.println("**********Bean Life Cycle method : init()****************");
	}
	
	@PreDestroy
	public void doCleanUp() {
		System.out.println("**********Bean Life Cycle method : destroy()****************");		
	}
	
	
	@Override
	public String toString() {
		return "ExcelExportService [filename=" + filename + ", mode=" + mode + "]";
	}
}
