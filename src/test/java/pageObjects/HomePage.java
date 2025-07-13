package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver, Logger logger) {
		
		super(driver, logger);
	}
	
	
	//locators
	
	
	By linkMyAccount = By.cssSelector("a[title='My Account']");
	By linkRegister  = By.linkText("Register");
	By linkLogin	 = By.linkText("Login");
	
	
	
	
	
	// Action methods
	
	
	public void clickMyAccount() {
		
		driver.findElement(linkMyAccount).click();
		logger.debug("Clicked on My Account link");
	}

	
	public void clickRegister() {
		
		driver.findElement(linkRegister).click();
		logger.debug("Clicked on Register link");
	}
	
	public void clickLogin() {
		
		driver.findElement(linkLogin).click();
		logger.debug("Clicked on Login link");
	}
}
