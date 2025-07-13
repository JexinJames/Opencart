package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver, Logger logger) {
		
		super(driver,logger);
	}
	
	
	//locators
	
	By inputEmail    = By.id("input-email");
	By inputPassword = By.id("input-password");
	By btnLogin   = By.cssSelector("input[type='submit']");
	
	
	// action methods
	
	
	public void setEmail(String email) {
		
		driver.findElement(inputEmail).sendKeys(email);
		logger.debug("Entered email");
	}
	
	public void setPassword(String pwd) {
		
		driver.findElement(inputPassword).sendKeys(pwd);
		logger.debug("Entered password");
	}
	
	public void clickLoginBtn() {
		
		driver.findElement(btnLogin).click();
		logger.debug("Clicked on login button");
	}
	
	

}
