package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass {
	
	
	
  @Test(dataProvider ="LoginData", dataProviderClass = DataProviders.class, groups="Regression")
  public void verify_valid_and_invalid_login(String email, String password, String expected) {
	  
	  
      logger.info( expected+" login test started");
	  
	  HomePage home = new HomePage(driver,logger);
	  
	  home.clickMyAccount();
	  home.clickLogin();
	  
	  LoginPage login = new LoginPage(driver,logger);
	  
	  login.setEmail(email);
	  login.setPassword(password);
	  login.clickLoginBtn();
	  
	  AccountPage account = new AccountPage(driver,logger);
	  
	  
	  if(expected.equalsIgnoreCase("valid")) {
		  
		  
		  if(account.isMyAccountTextPresent()) {
			  
			  logger.info("Login successful with valid credential");
			  account.clickLogout();
			  account.clickLogout();
			  Assert.assertTrue(true);
		  }
		  else {
			  
			  logger.error("Login failed with valid credential");
			  Assert.fail();
		  }
		  
		  
	  }
	  
	  if(expected.equalsIgnoreCase("invalid")) {
		  
		  if(account.isMyAccountTextPresent()) {
			  
			  logger.error("Able to login with invalid credential");
			  account.clickLogout();
			  account.clickLogin();
			  Assert.fail();
			  
			  
		  }
		  else {
			  logger.info("Unable to login with invalid credential");
			  Assert.assertFalse(false);
			  
		  }
		  
	  }
	  
	  
	  
	  
	  
	  logger.info(expected+" login test completed");
	  
	  
  }
}
