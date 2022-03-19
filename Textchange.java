package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Textchange {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
	  
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("button"))));
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		Alert alert = driver.switchTo().alert();
	    alert.accept();

         String text = driver.findElement(By.xpath("//button[@class='btn']")).getText();
	     System.out.println(text);
	     
	
	
	}

}
