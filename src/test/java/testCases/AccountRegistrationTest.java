package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	
	
	
	
  @Test(groups= "Regression")
  public void verify_account_registration() {
	  
	  
	  logger.info("Account registration test started");
	  
	  
	  HomePage home = new HomePage(driver,logger);
	  
	 
	  home.clickMyAccount();
	  home.clickRegister();
	  
	  RegisterAccountPage register = new RegisterAccountPage(driver,logger);
	  
	  register.setFirstName(randomStringGenerator());
	  register.setLastName(randomStringGenerator());
	  register.setEmail(randomStringGenerator()+"@gmail.com");
	  register.setTelephone(randomNumberGenerator());
	  String pwd = randomAlphanumericGenerator();
	  register.setPassword(pwd);
	  register.setConfirmPassword(pwd);
	  register.checkYesNewsLetterRadio();
	  register.checkPrivacyPolicyCheckbox();
	  register.submitRegister();
	 
	  
	  
	  
	  Assert.assertEquals("Your Account Has Been Created!", register.getRegisterMsg(), "Account Registration Failed");
	  logger.info("Account registered successfully");
	  logger.info("Account registration test completed");
	  
	 
	  
	 
  }
  
  
  
}
