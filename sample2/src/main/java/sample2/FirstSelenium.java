package sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String actualtitle="";
		String expectedTitle="Find a Flight: Mercury Tours:";
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("arjun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("arjun");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(5000);
		actualtitle=driver.getTitle();
		System.out.println(actualtitle);
		if(actualtitle.contentEquals(expectedTitle))
			System.out.println("Passed");
		else
			System.out.println("Failed");
		driver.close();
		// TODO Auto-generated method stub

	}

}
