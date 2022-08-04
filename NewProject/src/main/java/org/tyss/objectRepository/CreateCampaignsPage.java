package org.tyss.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.UtilityObjectClass;
import org.tyss.genericUtility.WebdriverUtility;

public class CreateCampaignsPage {
	WebDriver driver;
	/**
	 * This constructor is used to initialize elements everytime
	 * @param driver2
	 */
	public CreateCampaignsPage(WebDriver driver2) {
		
		PageFactory.initElements(UtilityObjectClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[text()='More']") private WebElement moreTab;
	@FindBy(xpath = "//a[@name=\"Campaign\"]") private WebElement campaignTab;
	@FindBy(xpath = "//img[@title=\"Create Campaign...\"]") private WebElement createCampaign;
	@FindBy(name = "campaignname") private WebElement provideCampaignName;
	@FindBy(xpath = "//input[@onclick=\"this.form.action.value='Save'; displaydeleted(); return formValidate() \"]") private WebElement saveBtn;
	@FindBy(xpath = "//span[@id=\"dtlview_Campaign Name\"]") private WebElement validateText;
	
	
	
	
	
	
	
	
	//business library
	public String createCampaigns(WebdriverUtility webdriverUtility, String campaignName)
	{
		webdriverUtility.mouseOverElement(moreTab);
		campaignTab.click();
		createCampaign.click();
		provideCampaignName.sendKeys(campaignName);
		saveBtn.click();
		return validateText.getText();
	}
	

}
