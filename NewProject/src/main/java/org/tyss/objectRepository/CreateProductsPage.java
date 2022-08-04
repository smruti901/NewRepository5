package org.tyss.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.UtilityObjectClass;

public class CreateProductsPage {
	WebDriver driver;
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver2
	 */
	public CreateProductsPage(WebDriver driver2) {
		//this.driver=driver;
		PageFactory.initElements(UtilityObjectClass.getDriver(), this);
	}
	
	@FindBy(linkText = "Products") private WebElement clickOnProducts;
	@FindBy(xpath = "//img[@title='Create Product...']") private WebElement createProduct;
	@FindBy(name = "productname") private WebElement provideProductName;
	@FindBy(xpath = "//input[@accesskey='S']") private WebElement saveBtn;
	@FindBy(xpath = "//span[@id='dtlview_Product Name']") private WebElement validateText;
	
	//business library
	 public String clickOnproduct(String product)
	 {
		 clickOnProducts.click();
		 createProduct.click();
		 provideProductName.sendKeys(product);
		 saveBtn.click();
		 return validateText.getText();
	 }
	

}
