package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
        WebElement Item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
        WebElement Item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));	
        WebElement Item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));	
        WebElement Item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));	

       Actions build = new Actions(driver);
       build.keyDown(Keys.CONTROL).click(Item1).click(Item2).click(Item3).click(Item4).keyUp(Keys.CONTROL).perform();

	
	}

}
