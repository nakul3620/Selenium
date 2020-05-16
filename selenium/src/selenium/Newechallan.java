package selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newechallan {
	WebDriver driver;
	
	// Lanching the firefox browser
public void LaunchBrowser() {
	System.setProperty("webdriver.gecko.driver", "/home/nakul/selenium/geckodriver");
	driver = new FirefoxDriver();
	driver.get("https://echallan.parivahan.gov.in/");
	
	}

	// Click on the link("Get Challan Details") of website
public void sublink() {
	driver.findElement(By.xpath("//a[@href='https://echallan.parivahan.gov.in/index/accused-challan']")).click();
	System.out.println("Link is open succusfully");
	driver.navigate().back();
}

	// Perform actions on HTML elements, entering text and submitting the form
public void enterinput() {
	driver.findElement(By.name("userName")).sendKeys("delhistate@nic.in");
	driver.findElement(By.name("next")).click();
	driver.findElement(By.id("password")).sendKeys("98765");
	driver.findElement(By.name("login")).submit();
	System.out.println("Login succusfully done");
	
}

public void verifylinks() throws InterruptedException {
	Thread.sleep(5000);
	/*Actions builder = new Actions(driver);
	WebElement link_Home = driver.findElement(By.id("fixed-btn"));
	Action mouseOverHome = builder.moveToElement(link_Home).build();
	mouseOverHome.perform();
	*/List<WebElement> links=driver.findElements(By.tagName("a"));
	System.out.println("Total links are "+links.size());
	for(int i=0;i<links.size();i++)
	{
		
		WebElement ele= links.get(i);
		
		String url=ele.getAttribute("href");
		
		verifyLinkActive(url);
		
	}
	
}

public static void verifyLinkActive(String linkUrl) {
	// TODO Auto-generated method stub
	{
		try
		{
			URL url = new URL(linkUrl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	            }
	        } catch (Exception e) {
		}
	}
	
}

// Perform action for logout the page
public void pagelogout() throws InterruptedException {
//Thread.sleep(5000);
WebDriverWait wait=new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='https://echallan.parivahan.gov.in/www/img/user1.png']"))).click();
driver.findElement(By.xpath("//a[@href='https://echallan.parivahan.gov.in/index/logout']")).click();


}

public static void main(String[] args) throws InterruptedException {
	Newechallan obj = new Newechallan();
	obj.LaunchBrowser();
	obj.sublink();
	obj.enterinput();
	obj.verifylinks();
	obj.pagelogout();
	
	
	}


}
