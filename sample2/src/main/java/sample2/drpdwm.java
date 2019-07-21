package sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class drpdwm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//String baseUrl="http://newtours.demoaut.com/mercuryreservation.php";
		//driver.get(baseUrl);
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("arjun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("arjun");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Select drpCountry=new Select(driver.findElement(By.name("fromPort")));
		drpCountry.selectByVisibleText("London");
		Select drpMonth=new Select(driver.findElement(By.name("fromMonth")));
		drpMonth.selectByVisibleText("February");
		Select drpDay=new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
		drpDay.selectByVisibleText("10");
		//driver.close();
	}

}
