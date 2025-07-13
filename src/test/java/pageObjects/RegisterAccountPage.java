package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage extends BasePage{
	
	
	public RegisterAccountPage(WebDriver driver, Logger logger) {
		
		super(driver,logger);
	}

	
	
	//locators
	
	By inputFirstName        = By.id("input-firstname");
	By inputLastName         = By.id("input-lastname");
	By inputEmail	         = By.id("input-email");
	By inputTelephone        = By.id("input-telephone");
	By inputPassword         = By.id("input-password");
	By inputConfirmPassword  = By.id("input-confirm");
	By radioYesNewsLetter    = By.cssSelector("input[value=\"1\"][name=\"newsletter\"]");
	By radioNoNewsLetter     = By.cssSelector("input[value=\"0\"][name=\"newsletter\"]");
	By checkboxPrivacyPolicy = By.cssSelector("input[name=\"agree\"]");
	By btnSubmitRegister     = By.cssSelector("input[type=\"submit\"]");
	By textRegisterSuccess   = By.xpath("//*[@id=\"common-success\"]//h1");
	
	// Action methods
	
	public void setFirstName(String FirstName) {
		
		driver.findElement(inputFirstName).sendKeys(FirstName);
		logger.debug("First name entered: {}",FirstName);
	}
	
	public void setLastName(String LastName) {
			
			driver.findElement(inputLastName).sendKeys(LastName);
			logger.debug("Last name entered:{}",LastName);
		}
	
	public void setEmail(String email) {
		
		driver.findElement(inputEmail).sendKeys(email);
		logger.debug("Email entered: {}",email);
	}
	
	public void setTelephone(String telephone) {
		
		driver.findElement(inputTelephone).sendKeys(telephone);
		logger.debug("Telephone number entered: {}",telephone);
	}
	
	public void setPassword(String pwd) {
		
		driver.findElement(inputPassword).sendKeys(pwd);
		logger.debug("Password entered: {}",pwd);
	}
	
	public void setConfirmPassword(String conf_pwd) {
		
		driver.findElement(inputConfirmPassword).sendKeys(conf_pwd);
		logger.debug("Confirm Password entered: {} ",conf_pwd);
	}
	
	public void checkYesNewsLetterRadio() {
		
		driver.findElement(radioYesNewsLetter).click();
		logger.debug("Clicked on NewsLetter radio button -Yes ");
	}
	
	public void checkNoNewsLetterRadio() {
			
			driver.findElement(radioNoNewsLetter).click();
			logger.debug("Clicked on NewsLetter radio button- No ");
			
		}
	
	public void checkPrivacyPolicyCheckbox() {
		
		driver.findElement(checkboxPrivacyPolicy).click();
		logger.debug("Checked on Privacy & Policy check box ");
	}
	
	
	public void submitRegister() {
			
			driver.findElement(btnSubmitRegister).click();
			logger.debug("Clicked on Register submit button");
		}
	
	
	public String getRegisterMsg() {
		
		try {
			String msg =driver.findElement(textRegisterSuccess).getText();
			logger.debug("Post register success message retrieved");
			return msg;
		}
		catch(Exception e) {
			
			logger.error("Post register success message not retrieved");
			return e.getMessage();
			
		}
		
	}
	
	
	
	
	
	
	
	
	
}
