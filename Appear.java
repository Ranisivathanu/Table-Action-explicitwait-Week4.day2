package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args)throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/appear.html");
		driver.manage().window().maximize();
	   
	
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("button"))));
		String text = driver.findElement(By.xpath("//b[text()='I know you can find him']")).getText();
		System.out.println(text);
	       File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File storage=new File("./snap/shot1.jpg");
		FileUtils.copyFile(screenshotAs, storage);
	}

}
