package seleniumWorkspace;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitWaitSelenium {

public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait
		driver.navigate().to("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;  
		js1.executeScript("scrollBy(0, 4500)");  
		driver.findElement(By.xpath("//*[text()='Elements']")).click();//to click elements in DemoQA
		driver.findElement(By.id("item-8")).click();//to click on dynamic properties
		js1.executeScript("scrollBy(0, 2500)");  
		//Thread.sleep(6000);	
		driver.findElement(By.id("enableAfter")).click();
		System.out.println(driver.findElement(By.id("visibleAfter")).getText());
			
}

}
