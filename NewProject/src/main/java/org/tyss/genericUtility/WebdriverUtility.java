package org.tyss.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

/**
 * This class contains all WebDriver actions used in programs
 * @author DELL
 *
 */
public class WebdriverUtility {
	private WebDriver driver;
	private Actions act;
	JavascriptExecutor jse;
	
	
	/**
	 * This method is used to choose browser
	 * @param browser
	 * @return
	 */
	
	public WebDriver Webdriversetupdriver(String browser)
	{
		switch(browser) {
		case "edge":WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
		case"chrome":WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
					break;
		default		:System.out.println("Pleasen enter either Edge or Chrome browser");
		}
		return driver;
		
	}
	
	/**
	 * This method is used to maximize browser
	 */
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to select Url
	 * @param url
	 */
	public void enterUrl(String url)
	{
		driver.get(url);
	}
	
	/**
	 * This method is used to use implicitwait
	 * @param longTimeout
	 */
	public void implicitwait(long timeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}
	
	/**
	 * This method is used to use explicitwait
	 * @param longTimeout
	 */
	public void explicitwait(By locator, long timeout)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * This method is used for Actions
	 */

	public void initializeAction() {
		 act= new Actions(driver);
	}
	
		
	/**
	 * This method is used to handle <Select> tag Dropdown by using visibletext
	 * @param dropdownElement
	 * @param visibleText
	 */
	public void handleSelectDropdown(WebElement dropdownElement, String visibleText)
	{
		Select select= new Select(dropdownElement);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * Initialize the JavaScript Executor
	 */
	public void initializeJSExecutor(WebDriver driver)
	{
		jse = (JavascriptExecutor)driver;
	}
	
	/**
	 * Navigate app by using JSExecutor
	 * @param url
	 */
	public void navigateApp()
	{

		jse.executeScript("window.scrollBy(0,500);");
	}
	
	/**
	 * This method is used to take screen shots of whole page
	 */

	public void takesScreenShotElement() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("./screenShot/studentAttendance.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	/**
	 * This method is used to take screen shots of whole page using BASE64
	 */
	
	public String takesScreenShotElementBase64(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		String path = ts.getScreenshotAs(OutputType.BASE64);
		return path;
		

	}
	/**
	 * This method is used to take screen shots of whole page using BYTES
	 */
	@Attachment(value="abc", type="img/png")
	public byte[] takesScreenShotElementBytes(WebDriver driver) {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		byte[] path = ts.getScreenshotAs(OutputType.BYTES);
//		return path;
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		

	}
	
	
	/**
	 * This method is used to take screen shot of particular WebElement
	 * @param element
	 */
	public void takesScreenShotElement(WebElement element) {
		TakesScreenshot ts = (TakesScreenshot)element;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("./screenShot/studentAttendance.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	/**
	 * This method is used to close the browser
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	
	/**
	 * 
	 * @param totalDuration
	 * @param pollingTime
	 * @param element
	 */
	public void waitTillElementClickable(int totalDuration, long pollingTime,WebElement element)
	{
		int currentTime=0;
		while(currentTime<=totalDuration) {
			try {
				element.click();
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				currentTime++;
			}
		}
	}

	
	/**
	 * This method is used for Actions
	 */

	public void initializeActions()
	{
		act= new Actions(driver);
	}
	/**
	 * This method is used for moving mouse to webElement
	 * @param element
	 */
	public void mouseOverElement(WebElement element)
	{
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to switch frame using Index
	 * @param frame
	 */
	public void switchFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

}