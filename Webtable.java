package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
	    
	    WebElement tablename = driver.findElement(By.xpath("//table[@id='table_id']"));
	   //to find row value
	   List<WebElement> row = tablename.findElements(By.tagName("tr"));
	    int size = row.size();
	    System.out.println(size);
	    //to find column value by inserting row
	    WebElement Col = row.get(1);
	    List<WebElement> column = Col.findElements(By.tagName("td"));
	    int size2 = column.size();
	     System.out.println(size2);
	     
	    //to get row $ column content(data)
	     for (int i = 0; i <size; i++) {
	    	 WebElement rowVal = row.get(i);
	    	 List<WebElement> colVal = rowVal.findElements(By.tagName("td"));
	    	 for (int j = 0; j < colVal.size(); j++) {
	    		 WebElement eachcolVal = colVal.get(j);
	    		 System.out.println(eachcolVal.getText());
	    		 
	    		 
	    		 
	    		 
				
			}
	    	 
	    	 
			
		}
	
	}
	
}
