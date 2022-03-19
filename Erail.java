package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
	    
	    WebElement fromstation = driver.findElement(By.id("txtStationFrom"));
	    fromstation.clear();
	    fromstation.sendKeys("TPJ",Keys.TAB);
	    
	    WebElement tostation = driver.findElement(By.id("txtStationTo"));
	    tostation.clear();
	    tostation.sendKeys("MS",Keys.TAB);
	    
	    WebElement checkbox = driver.findElement(By.id("chkSelectDateOnly"));
	    if(checkbox.isSelected()) {
	    	checkbox.click();
	    }else
	    {
	    	System.out.println("Element is not selected");
	    	
	    }
	    
	    //need to check
	    WebElement table = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
	    
		List<WebElement> row = table.findElements(By.tagName("tr"));
		System.out.println(row);
		
		WebElement singleRow= row.get(1);
		List<WebElement> column = singleRow.findElements(By.tagName("td"));
		System.out.println(column.size());
		
		for (int i = 1; i < row.size(); i++) {
			WebElement row1= row.get(i);
			List<WebElement> column1 = row1.findElements(By.tagName("td"));
			WebElement colelement = column1.get(1);
			String Trainname = colelement.getText();
		System.out.println(Trainname);
		}
		
		
	}

}
