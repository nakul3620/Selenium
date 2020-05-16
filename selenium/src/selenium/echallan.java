package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class echallan {
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "/home/nakul/selenium/geckodriver");
		// Create an instance of the driver
		WebDriver driver = new FirefoxDriver();
		// Create an instance of wait
		WebDriverWait wait=new WebDriverWait(driver, 20);
		// Navigate to a web page
		driver.get("http://164.100.161.91");
		// Click on the link("Get Challan Details") of website 
		driver.findElement(By.xpath("//a[@href='http://164.100.161.91/index/update-mobile']")).click();
		String at = driver.getCurrentUrl();
		driver.close();
		System.out.println(at);
		System.out.println("Link is open succusfully");
		driver.navigate().back();
		// Perform actions on HTML elements, entering text and submitting the form
	    driver.findElement(By.name("userName")).sendKeys("delhistate@nic.in");
		driver.findElement(By.name("next")).click();
		driver.findElement(By.id("password")).sendKeys("98765");
		driver.findElement(By.name("login")).submit();
		System.out.println("Login succusfully done");
		// Perform action for logout the page
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='http://164.100.161.91/www/img/user1.png']"))).click();
		driver.findElement(By.xpath("//a[@href='http://164.100.161.91/index/logout']")).click();
	
	    
	}	
	

}
