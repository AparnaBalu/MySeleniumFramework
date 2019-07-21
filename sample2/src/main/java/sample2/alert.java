package sample2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/selenium/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("123456");
		driver.findElement(By.name("submit")).submit();
		//Switching to alert
		Alert alert=driver.switchTo().alert();
		//Capturing alert message
		String alertMessage=alert.getText();
		//Displaying alert message
		System.out.println(alertMessage);
		Thread.sleep(5000);
		//Accepting alert
		alert.accept();
		
		
			



	}

}
