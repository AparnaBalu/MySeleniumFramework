package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class loginpage {
	WebDriver driver;
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
		
		
	}

	
public void enterusername(String username) throws IOException
{
driver.findElement(By.xpath(utilityPackage.utilityFetchProperty.fetchlocatorvalue("login_username_xpath"))).sendKeys(username);


	}
public void enterpassword(String password) throws IOException
{
driver.findElement(By.xpath(utilityPackage.utilityFetchProperty.fetchlocatorvalue("login_password_xpath"))).sendKeys(password);


	}
public void clicksignin() throws IOException
{
driver.findElement(By.xpath(utilityPackage.utilityFetchProperty.fetchlocatorvalue("login_signin_xpath"))).click();


	}
}
