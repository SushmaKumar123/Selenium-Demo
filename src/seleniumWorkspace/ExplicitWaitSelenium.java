package seleniumWorkspace;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitSelenium {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js1 = (JavascriptExecutor)driver;   
		driver.navigate().to("https://demoqa.com/");
		WebDriverWait wait = new WebDriverWait(driver,30); 
		js1.executeScript("scrollBy(0, 4500)");  
		driver.findElement(By.xpath("//*[text()='Elements']")).click();//to click elements in DemoQA
		driver.findElement(By.id("item-8")).click();////to click on dynamic properties
		js1.executeScript("scrollBy(0, 2500)");
		
		//explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Explicit wait: "+driver.findElement(By.id("visibleAfter")).getText());
		
		//Thread Sleep
		
		driver.navigate().to("https://demoqa.com/");
		js1.executeScript("scrollBy(0, 4500)");  
		driver.findElement(By.xpath("//*[text()='Elements']")).click();//to click elements in DemoQA
		driver.findElement(By.id("item-8")).click();////to click on dynamic properties
		js1.executeScript("scrollBy(0, 2500)"); 
		Thread.sleep(6000);
		System.out.println("Thread sleep: "+driver.findElement(By.id("visibleAfter")).getText());
		
}
}
