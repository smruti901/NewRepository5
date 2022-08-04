package org.tyss.genericUtility;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.tyss.objectRepository.CommonPage;

public class BaseClass extends InstanceClass{
	
	public static WebDriver listenerdriver;
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void classSetup() throws MalformedURLException {

		
		//Creating objects for GenericUtility
		fileutility= new FileUtility();
		excelutility = new ExcelUtility();
		javautility= new JavaUtility();
		webdriverutility= new WebdriverUtility();
		
		UtilityObjectClass.setWebdriverutility(webdriverutility);
		UtilityObjectClass.setJavautility(javautility);
		

		//Initialize data from Property file
		fileutility.initializethePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);



		//Get the control for particular sheet in excel
		excelutility.initializeExcelFile(IpathConstants.VTIGEREXELFILEPATH);

		//Fetch the data from Property file
		browser=fileutility.getDataFromProperty("browser");
		url=fileutility.getDataFromProperty("url");
		username=fileutility.getDataFromProperty("username");
		password=fileutility.getDataFromProperty("password");
		timeout=fileutility.getDataFromProperty("timeout");

		//covert string to long
		time=javautility.convertStringToLong(timeout);

		//run time polymorphism
		driver=webdriverutility.Webdriversetupdriver(browser);
		UtilityObjectClass.setDriver(driver);
		ListenerImplementation.testLog.info("Browser launched successfully");
		//ThreadSafeClass.setDriver(driver);
		listenerdriver=driver;

		//pre-setting for browser
		webdriverutility.maximizeBrowser();
		ListenerImplementation.testLog.info("Browser maximized successfully");
		webdriverutility.implicitwait(time);
		ListenerImplementation.testLog.info("Browser waited successfully");


		//login to the app
		commonPage= new CommonPage(driver);
		
		//creating object for Actions class
		webdriverutility.initializeActions();

		//navigate the application
		webdriverutility.enterUrl(url);
		ListenerImplementation.testLog.info("Url entered successfully");

	}

	@BeforeMethod(alwaysRun = true)
	public void randomSetup()
	{
		//Generate the random number
		randomNumber= javautility.getRandomNumber();

		commonPage.Login(username, password);
		ListenerImplementation.testLog.info("Credentials entered  successfully");
	}

	@AfterMethod(alwaysRun = true)
	public void methodTearDown()
	{
		//Closing the workbook and driver
		commonPage.Logout(webdriverutility);
		ListenerImplementation.testLog.info("Application logouted successfully");
	}

	@AfterClass(alwaysRun = true)
	public void classTearDown()
	{

		excelutility.workbookclose();
		ListenerImplementation.testLog.info("Workbook closed successfully");
		webdriverutility.closeBrowser();
		ListenerImplementation.testLog.info("Browser closed successfully");
	}
}
