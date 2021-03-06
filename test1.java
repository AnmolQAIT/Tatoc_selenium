package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import test.NewTest;
public class NewTest2 extends NewTest
{
  WebDriver driver;
	@BeforeClass
	public void urlTest() 
	{
		driver=new ChromeDriver();
		Url(driver);
		driver.get("http://10.0.1.86/tatoc");
		Assert.assertEquals(driver.getCurrentUrl(),"http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		
	}
	@Test(priority=1)
	public void firstTest()
	{
	Assert.assertEquals(driver.getTitle(),"Grid Gate - Basic Course - T.A.T.O.C");
		
	}
  
	@Test(priority=2)
	public void secondTest()
	{
		Assert.assertTrue(driver.findElement(By.className("greenbox")).isDisplayed());
         GreenBox();
	}
	
	@Test(priority=3)
	public void thirdTest()
	{
		String str=RepaintBoxTest();
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.switchTo().frame(0).findElement(By.xpath("//*[@id=\"answer\"]")).getAttribute("class"),str);
		System.out.println("fsdf");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		Assert.assertTrue(driver.findElement(By.linkText("Proceed")).isEnabled());
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	@Test(priority=4)
	public void fourthTest()
	{
		
				//Assert.assertEquals(driver.getTitle(),"Grid Gate - Basic Course - T.A.T.O.C");
		Assert.assertTrue(driver.findElement(By.id("dropbox")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("dragbox")).isDisplayed());
		DragTest();
		Assert.assertTrue(driver.findElement(By.linkText("Proceed")).isEnabled());
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	@Test(priority=5)
	public void fifthTest()
	{
		String window=launch();
		driver.switchTo().window(window);
		driver.findElement(By.id("name")).sendKeys("ABCD");
		Assert.assertTrue(driver.findElement(By.id("submit")).isEnabled());
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(parent_window);
		driver.findElement(By.linkText("Proceed")).click();
		driver.navigate().back();
		String str1=driver.getWindowHandle();
		Assert.assertEquals(str1, parent_window);
		driver.findElement(By.linkText("Proceed")).click();
	}
}
