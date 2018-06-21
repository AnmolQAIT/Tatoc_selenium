package test;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;


public class NewTest {
  
	WebDriver driver;
	Cookie cookie;
	
	
  public void Url(WebDriver driver) {
	  this.driver=driver;
	 	
  }
  
    public void GreenBox()
  {
	driver.findElement(By.className("greenbox")).click();
  }
  
  
  public String RepaintBoxTest()
  {
	  driver.switchTo().frame(0);
	WebElement box1 = driver.findElement(By.id("answer"));
	String str=box1.getAttribute("class");
	String str1="";
	while(!str.equals(str1))
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.linkText("Repaint Box 2")).click();
		driver.switchTo().frame(0);
		str1=driver.findElement(By.id("answer")).getAttribute("class");
	
	}
	return str1;
	
  }
  
  
  public void DragTest()
  {
	   /*JavascriptExecutor js = (JavascriptExecutor) driver;
	   WebElement dragbox = driver.findElement(By.xpath("//*[@id=\"dragbox\"]"));
	   js.executeScript("arguments[0].setAttribute('style','position: relative; left: 30px; top: -71px;')",dragbox);	   
	   */
	  
	  Actions action=new Actions(driver);
	  WebElement src=driver.findElement(By.id("dragbox"));
	  WebElement dest=driver.findElement(By.id("dropbox"));		  
	  action.dragAndDrop(src, dest).build().perform();
  }
  
  public void launch_PopUp_Window_Test()
  { 
	  driver.findElement(By.linkText("Launch Popup Window")).click();
	  String parent_window=driver.getWindowHandle();
	  String subwindow=null;
	  Set<String> windows = driver.getWindowHandles();
	  Iterator itr=windows.iterator();
	  while(itr.hasNext())
	  {
		  subwindow=(String) itr.next();
	  }
	  driver.switchTo().window(subwindow);
	   driver.findElement(By.id("name")).sendKeys("ABCD");
	   driver.findElement(By.id("submit")).click();
	   driver.switchTo().window(parent_window);
	   driver.findElement(By.linkText("Proceed")).click();
	   Reporter.log("Pop_Up window is successfully launched",true);
	   
  }
    
  public void CookiesTest()
  {
	  driver.findElement(By.linkText("Generate Token")).click();
	   String token_value=driver.findElement(By.id("token")).getText();
	   //System.out.println(token_value);
	   String str=token_value.substring(token_value.indexOf(":")+2);
	   cookie=new Cookie("Token",str);
	   driver.manage().addCookie(cookie);
	   driver.findElement(By.linkText("Proceed")).click();
  }
  
}
