package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
	
	
	
	public AccountPage(WebDriver driver, Logger logger) {
		
		super(driver,logger);
	}
	
	
	//locator
	
	By textMyAccount = By.xpath("//*/div[@id=\"content\"]/h2[1]");
	By linkLogout    = By.linkText("Logout");
	By linkLogin	 = By.linkText("Login");
	
	
	
	// Action method
	
	public Boolean isMyAccountTextPresent() {
		
		try {
			
		String txt =driver.findElement(textMyAccount).getText();
		
		if(txt.equals("My Account")) {
			
			logger.debug("My Account text is present");
			return true;
		}
		else {
			logger.debug("My Account text isn't present");
			return false;
		}
		
		
		}
		catch(Exception e){
			
			//logger.error(e.getMessage());
			logger.debug("Exception while fetching My Account text");
			return false;
		}
		
		
	}
	
	public void clickLogout() {
		
		driver.findElement(linkLogout).click();
		logger.debug("Clicked on Logout link on Account page");
	}
	
	public void clickLogin() {
		
		driver.findElement(linkLogin).click();
		logger.debug("Clicked on Login link");
	}
	
  
}
