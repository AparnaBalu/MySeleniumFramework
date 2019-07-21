package baseclass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import utilityPackage.ExtentUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class driverInstance {
  public WebDriver driver;
  
  
  @BeforeMethod
  public void initiateDriverinstance() throws IOException {
	  if(utilityPackage.utilityFetchProperty.fetchpropertvalue("browsername").toString().equalsIgnoreCase("chrome"))
	  { System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 
	  driver=new ChromeDriver();
		 
		  
		 
	  }
	  else if(utilityPackage.utilityFetchProperty.fetchpropertvalue("browsername").toString().equalsIgnoreCase("FireFox"))
	  {System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		  driver=new ChromeDriver();
		  
		  
		 
	  } 
	  else if(utilityPackage.utilityFetchProperty.fetchpropertvalue("browsername").toString().equalsIgnoreCase("IE"))
	  {
		  driver=new ChromeDriver();
		  System.setProperty("webdriver.Chrome.driver", "./driver/IEdriver.exe");
		  
		  
		 
	  }
	  else 
	  {   System.setProperty("Webdriver.Chrome.driver", "./driver/chromedriver.exe");      
	  driver=new ChromeDriver();
	  }
	
	  driver.get(utilityPackage.utilityFetchProperty.fetchpropertvalue("URL").toString());
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  
  }

  @AfterMethod
  public void closeDriverInstance(ITestResult result) throws IOException
  {
 String className = this.getClass().getSimpleName();
 ExtentUtils.finalreport(result, driver, className);
 driver.close();
  }

}
