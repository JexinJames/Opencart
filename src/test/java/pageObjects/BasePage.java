package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	WebDriver driver;
	Logger logger;
	
	public BasePage(WebDriver driver, Logger logger) {
		
		this.driver =driver;
		this.logger = logger;
		
	}

}
