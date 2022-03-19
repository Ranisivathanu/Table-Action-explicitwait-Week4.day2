package week4.day2;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drop.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	     WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
	     WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
	    Actions build = new Actions(driver);
	    Point location = drop.getLocation();
	    System.out.println(location);
	    int x=location.getX();
	    int y=location.getY();
	     
	     build.dragAndDropBy(drop, x+50, y-50);
	     build.dragAndDrop(drag, drop).perform();
	
	
	
	
	}

}
