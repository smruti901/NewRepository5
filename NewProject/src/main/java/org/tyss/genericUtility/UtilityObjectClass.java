package org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;

public class UtilityObjectClass {
	private static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
	private static ThreadLocal<WebdriverUtility> webdriverutility= new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javautility= new ThreadLocal<>();
	private static ThreadLocal<ExcelUtility> excelutility= new ThreadLocal<>();
	private static ThreadLocal<FileUtility> fileutility= new ThreadLocal<>();
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actdriver) {
		driver.set(actdriver);
	}
	public static WebdriverUtility getWebdriverutility() {
		return webdriverutility.get();
	}
	public static void setWebdriverutility(WebdriverUtility webdriver) {
			webdriverutility.set(webdriver);
	}
	public static JavaUtility getJavautility() {
		return javautility.get();
	}
	public static void setJavautility(JavaUtility java) {
		javautility.set(java);;
	}
	public static ExcelUtility getExcelutility() {
		return excelutility.get();
	}
	public static void setExcelutility(ExcelUtility excel) {
		excelutility.set(excel);;
	}
	public static FileUtility getFileutility() {
		return fileutility.get();
	}
	public static void setFileutility(FileUtility file) {
		fileutility.set(file);;
	}
	
	
	
	
	
	
	
	
	
	

}
