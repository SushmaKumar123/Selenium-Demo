package seleniumWorkspace;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysToDemoQA {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;  
		js1.executeScript("scrollBy(0, 4500)");  
		driver.findElement(By.xpath("//*[text()='Elements']")).click();//to click elements in DemoQA
		driver.findElement(By.xpath("//*[text()='Text Box']")).click();//To click on Text box item
		//send values
		js1.executeScript("scrollBy(0, 300)");
		driver.findElement(By.id("userName")).sendKeys("Sushma");
		driver.findElement(By.id("userEmail")).sendKeys("Sushma@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Bangalore");
		driver.findElement(By.id("permanentAddress")).sendKeys("Chikmagalur");
		js1.executeScript("scrollBy(0, 300)");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		
		//Radio button
		driver.findElement(By.id("item-2")).click();
		//to select 'Yes' radio button
		driver.findElement(By.xpath("//*[contains(text(),'Yes')]")).click();
		Thread.sleep(2000);
		//to select 'Impressive' radio button
		driver.findElement(By.xpath("//*[contains(text(),'Impressive')]")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
