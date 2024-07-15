package seleniumWorkspace;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Argument;

public class AddNewRecords {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;  
		js1.executeScript("scrollBy(0, 4500)");  
		driver.findElement(By.xpath("//*[text()='Elements']")).click();//to click elements in DemoQA
		driver.findElement(By.xpath("//*[text()='Web Tables']")).click();
		
		//adding new records to web table
		  String[] firstnames= {"Sushma","Sahithya","Shravya","Thanya","Supriya","Sambrama","Deeksha"};
		  String[] lastNames= {"kumar","ravi","kumar","ravi","kumar","ravi","kumar"};
		  String[] email= {"kumar@gmail.com","ravi@gmail.com","Shravy@gmail.com","Thanya@gmail.com","supriya@gmail.com","sambrama@gmail.com","Deeksha@gmail.com"};
		  String[] age= {"23","25","23","25","23","25","23"};
		  String[] salary= {"35000","25000","35000","25000","35000","25000","35000"};
		  String[] dept= {"sales","IT","sales","IT","sales","IT","sales"};
		  
		  driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();	  
		  for(int i=0;i<firstnames.length;i++) {
			  driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstnames[i]);  
			  driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastNames[i]);
			  driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys(email[i]);
			  driver.findElement(By.xpath("//*[@id=\"age\"]")).sendKeys(age[i]);
			  driver.findElement(By.xpath("//*[@id=\"salary\"]")).sendKeys(salary[i]);
			  driver.findElement(By.xpath("//*[@id=\"department\"]")).sendKeys(dept[i]);
			  driver.findElement(By.xpath("//*[@id=\"submit\"]")).submit();
			  
			  if(i<firstnames.length-1) {
			  driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]")).click();
			  }
		  }
		  
		  List<WebElement> rows=driver.findElements(By.xpath("//div[@role='rowgroup']//div[contains(@class, 'action-buttons')]/ancestor::div[@role='row']"));
			
			for(WebElement row:rows) {
				List<WebElement> cols=row.findElements(By.xpath("div"));
				for(int col=0;col<cols.size();col++) {
					System.out.print(cols.get(col).getText()+"\t");
					
				}
				System.out.println();
			}
			Thread.sleep(5000);
			driver.close();
		}

}
