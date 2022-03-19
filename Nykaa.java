package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	 WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
	 Actions build = new Actions(driver);
	 build.moveToElement(brand).perform();
	 build.click();
	 
	 Thread.sleep(3000);
	 
	driver.findElement(By.xpath("//div[@class='css-ov2o3v'][6]/a")).click();
	String title = driver.findElement(By.xpath("//div[@id='title'][1]/h1")).getText();
	System.out.println("Product title:"+title);
	driver.findElement(By.xpath("//span[@class='sort-name']")).click();
	driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
	driver.findElement(By.xpath("//span[text()='Category']")).click();
	driver.findElement(By.xpath("//span[text()='Hair']")).click();
	driver.findElement(By.xpath("//span[text()='Hair Care']")).click(); 
	driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
	driver.findElement(By.xpath("//span[text()='Concern']")).click(); 
	driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[9]")).click();
	String Fliter1 = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
	System.out.println("Filter products1:" +Fliter1); 
	String Fliter2 = driver.findElement(By.xpath("//span[text()='Color Protection']")).getText();
	System.out.println("Filter products2:" +Fliter2); 
	
	driver.findElement(By.xpath("(//div[@class='css-1rd7vky'])[1]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
    System.out.println(windowHandles);
    List<String> list=new ArrayList<String>(windowHandles);
    driver.switchTo().window(list.get(1));
    System.out.println(driver.getCurrentUrl());
    String liter = driver.findElement(By.xpath("(//select[@class='css-2t5nwu'])/option[2]")).getText();
	System.out.println("Available litres:" +liter);
	String Price = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
	System.out.println("Amount:" +Price);
	driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
	
	 driver.findElement(By.xpath("//span[@class='cart-count']")).click();
	 List<WebElement> f= driver.findElements(By.tagName("iframe"));
	 System.out.println("Total number :" +f.size());
	 
	  
	driver.switchTo().frame(0);
	  
	String Total = driver.findElement(By.xpath("(//div[text()='220'])[2]")).getText();
	System.out.println("Total Amount :" +Total);
		
	 driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
	 driver.switchTo().parentFrame();
	 
	 driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click(); 
	
	 String GrandTotal = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		System.out.println("Final Amount :" +GrandTotal);
		
		if (Total!=GrandTotal) {
			System.out.println("The Amount will  be equal");
			
		}else
		{
			System.out.println("The Amount will not  be equal");
			
		}
	
	driver.quit();
	}

}
