package seleniumWorkspace;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FluentWait {
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
		//Fluent wait
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(Duration.ofSeconds(30))
			    .pollingEvery(Duration.ofSeconds(5))
			    .ignoring(NoSuchElementException.class);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myElement")));

		
		
		
		System.out.println(driver.findElement(By.id("visibleAfter")).getText());
}

}
