package com.javaselenium_assignment.Amazon;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Search {
  @Test
  public void searchOption() throws IOException, InterruptedException {
	  
	//To create a driver
	WebDriver driver;

	System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	//To get a url
	driver.get("https://www.amazon.in/");
	System.out.println(driver.getTitle());
	
	//For search operation
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("xbox");
	driver.findElement(By.className("nav-input")).click();
	
	driver.findElement(By.linkText("Xbox One S 1TB Console – Roblox Bundle")).click();
	Thread.sleep(200);
	
	//To handle new window
	Set<String> winHandles = driver.getWindowHandles(); 
	System.out.println("The number of windows handles are" +winHandles.size());
	for(String winHandle:winHandles)
	{
		driver.switchTo().window(winHandle); //Switching to Child window
	}
	String title = driver.getTitle();
	System.out.println("The page title is : " +title);
	
	driver.findElement(By.id("add-to-cart-button")).click();
	driver.findElement(By.linkText("Cart")).click();
 
	//To take the screenshot
	TakesScreenshot ts =((TakesScreenshot)driver); //Convert web driver object to TakeScreenshot
	File SrcFile = ts.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
	FileUtils.copyFile(SrcFile, new File("screenshot//search.png")); //Copy file at destination
	
	//To close the window
	driver.quit();
  }
}
