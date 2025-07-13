package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginAccountTest extends BaseClass{
	
	
  @Test(groups= {"Regression","Sanity"})
  public void verify_login() {
	  
	  logger.info("Login test started");
	  
	  HomePage home = new HomePage(driver,logger);
	  
	  home.clickMyAccount();
	  home.clickLogin();
	  
	  LoginPage login = new LoginPage(driver,logger);
	  
	  login.setEmail(property.getProperty("login_email"));
	  login.setPassword(property.getProperty("login_pwd"));
	  login.clickLoginBtn();
	  
	  AccountPage account = new AccountPage(driver,logger);
	  
	  Assert.assertTrue(account.isMyAccountTextPresent(),"Login failed");
	  
	  logger.info("Login test completed");
	  
  }
  
  
}
