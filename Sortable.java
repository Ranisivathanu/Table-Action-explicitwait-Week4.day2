package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
	WebElement fromElement = elements.get(4);
	
	WebElement toElement = elements.get(0);
	
	Actions build=new Actions(driver);
	
	build.clickAndHold(fromElement).moveToElement(toElement).release(toElement).perform();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
