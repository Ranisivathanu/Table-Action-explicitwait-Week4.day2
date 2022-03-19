package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {

	public static void main(String[] args)throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
	    
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//button[@id='btn']"))));
	String text = driver.findElement(By.tagName("strong")).getText();
	System.out.println(text);
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	File storage=new File("./snap/shot2.jpg");
	FileUtils.copyFile(screenshotAs, storage);
	
	}

}
