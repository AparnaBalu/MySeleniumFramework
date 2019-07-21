package sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragdrop {

	public static void main(String[] args) throws InterruptedException {
				// TODO Auto-generated method stub
		//Drag and drop
		//http://jqueryui.com/droppable/#default
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/#default");
		Actions act=new Actions(driver);
		WebElement iFrame=driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html\']"));
		driver.switchTo().frame(iFrame);
		WebElement from=driver.findElement(By.id("draggable"));
		WebElement to=driver.findElement(By.id("droppable"));
		act.dragAndDrop(from, to).build().perform();
		Thread.sleep(50000);
		driver.close();
	}

}
