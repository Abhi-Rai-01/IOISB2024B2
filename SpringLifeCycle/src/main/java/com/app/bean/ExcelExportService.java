package com.app.bean;

public class ExcelExportService {
	private String fileName;
	private String mode;
	
	static {
		System.out.println("ExcelExportService.class file is loading...");
	}
	
	public ExcelExportService() {
		System.out.println("ExcelExportService object is created by Spring F/w...");
	}
	
	public void initLogic() {
		System.out.println("********Some logic to process before calling the method*********");
	}
	
	public void cleanUpLogic() {
		System.out.println("********Some logic to process after calling the method*********");	
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	@Override
	public String toString() {
		return "ExcelExportService [fileName=" + fileName + ", mode=" + mode + "]";
	}
}
