package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public static WebDriver driver; //other wise 2 drivers created. 2nd from screenshot
	public Logger logger;
	public Properties property;
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Regression","Sanity"})
	@Parameters({"browser","os"})
	public void setUp(String br, String os) throws IOException {
		
		
		//log
		logger = LogManager.getLogger(this.getClass());
		ThreadContext.put("browser", br);
		
		//properties
		String path = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(path+"\\src\\test\\resources\\config.properties");
		property = new Properties();
		property.load(file);
		
		
		//remote execution
		if(property.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//os
			
			switch(os.toLowerCase()) {
			
			case "windows" : capabilities.setPlatform(Platform.WIN11); break;
			case "mac"     : capabilities.setPlatform(Platform.MAC); break;
			case "linux"   : capabilities.setPlatform(Platform.LINUX);break;
			default        : System.out.println("Incorrect os"); return;
			}
			
			
			//browser
			switch(br.toLowerCase()) {
			
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge"   : capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			case "safari" : capabilities.setBrowserName("safari"); break;
			default       : System.out.println("Incorrect browser"); return;
			}
			
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				
			
		}
		
		
		
		
		//local execution
		if(property.getProperty("execution_env").equalsIgnoreCase("local")) {
		
		switch(br.toLowerCase()) {
		
		case "chrome": driver = new ChromeDriver(); break;
		case "edge"  : driver = new EdgeDriver();break;
		case "firefox"  : driver = new FirefoxDriver();break;
		default: System.out.println("Invalid browser"); return;
		
		}
		
		}
		
		
		driver.get(property.getProperty("app_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass(groups= {"Regression","Sanity"})
	public void tearDown() {
		
		driver.quit();
		ThreadContext.remove("browser");
	}
	
	

	
	@SuppressWarnings("deprecation")
	public String randomStringGenerator() {
		
		
		return RandomStringUtils.randomAlphabetic(2, 11);
		
	}
	
	@SuppressWarnings("deprecation")
	public String randomAlphanumericGenerator() {
		
		return RandomStringUtils.randomAlphanumeric(5, 10);
	}
 
	@SuppressWarnings("deprecation")
	public String randomNumberGenerator() {
		
		return RandomStringUtils.randomNumeric(10);
	}
  
	
	public String captureScreen(String tname) { //tname is the method name. this name is given to SS
		
		SimpleDateFormat date_format =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date = new Date();
		String currentdatetimestamp =date_format.format(date);
		
		TakesScreenshot takesScreenShot = (TakesScreenshot)driver;
		File sourceFile=takesScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+currentdatetimestamp+".png";
		File targetFile = new File(targetFilePath);
		
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}
  
}
