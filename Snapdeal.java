package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    
	    WebElement brand = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		 Actions build = new Actions(driver);
		 build.moveToElement(brand).perform();
		 build.click();
		 
		 Thread.sleep(3000);
		 
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String Totalcount= driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Product count :"+Totalcount);
	    driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
	    driver.findElement(By.xpath("//span[@class='sort-label']")).click();
	    driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
	    Thread.sleep(3000);
	    String sortcheck = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getText();
		System.out.println("first product amount to check the sort :"+sortcheck);
		String sortcheck1= driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]")).getText();
		System.out.println("Second product amount to check the sort :"+sortcheck1);
        driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
        
        //No product available in the given price range
        
        /*WebElement fromval = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromval.clear();
		fromval.sendKeys("900",Keys.TAB);
		WebElement toval = driver.findElement(By.xpath("//input[@name='toVal']"));
		toval.clear();
		toval.sendKeys("1200",Keys.ENTER);*/
	    String Fliter1 = driver.findElement(By.xpath("(//a[@data-key='Color_s|Color'])[1]")).getText();
		System.out.println("Filter products1:" +Fliter1); 
	    //String Fliter2 = driver.findElement(By.xpath("(//a[@data-key='Price|Price'])[1]")).getText();
		//System.out.println("Filter products2:" +Fliter2);
	
		//WebElement Quick = driver.findElement(By.xpath("(//div[@class='product-tuple-image '] )[1]"));
		 WebElement QuickView =driver.findElement(By.xpath("(//p[@class='product-title'])[1]"));
		 Actions build1 = new Actions(driver);
		 build1.moveToElement(QuickView).perform();
		
		 driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();
	
		 Set<String> windowHandles = driver.getWindowHandles();
			List<String> newWindow=new ArrayList<String>(windowHandles);
			driver.switchTo().window(newWindow.get(0));
		 String Totalamount = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		 System.out.println("Total amount :" +Totalamount); 
			String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
			System.out.println("Total discount :" +discount);
			//to take screenshot
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File storage=new File("./snap/shot.jpg");
		FileUtils.copyFile(screenshotAs, storage);

		driver.close();	
	
	
	}

}
