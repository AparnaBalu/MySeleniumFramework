package sample2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardandSoftAlert {
	
  @Test
  public void f() 
  {
	  System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("https://www.gotchmasters.com/index.php");
		System.out.print("Title is"+driver.getTitle());
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(driver.getTitle().contains("AKTech"));
		driver.close();
		sa.assertAll();
  }
}
