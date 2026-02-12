package com.app.service;

public class ExcelExportService {
	
	private String filename;
	private String mode;
	
	static {
		System.out.println("ExcelExportService.class file is loaded");
	}
	
	
	public ExcelExportService() {
		super();
		System.out.println("ExcelExportService object is created by Spring F/W...");
	}

	public void initLogic() {
		System.out.println("**********some logic to process before calling the methods****************");
	}
	
	public void cleanUpLogic() {
		System.out.println("**********some logic to process after calling the methods****************");		
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	@Override
	public String toString() {
		return "ExcelExportService [filename=" + filename + ", mode=" + mode + "]";
	}
}
