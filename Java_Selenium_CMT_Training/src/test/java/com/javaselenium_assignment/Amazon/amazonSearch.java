package com.javaselenium_assignment.Amazon;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class amazonSearch {
  @Test
  public void search() throws IOException, InterruptedException
  {
		 
	  	//New model for finding the locator paths 
	  	String searchtext = "mobiles"; //Searching path for a item
		String selectValue = "Apple iPhone 11 (128GB) - Black"; //Selected item which we want 
		 
		//Create a driver
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//To get a url
		driver.navigate().to("https://www.amazon.in/");
		
		//Search operation
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchtext+Keys.ENTER); //sendKey is processed from the string variable (searchtext) for searching item
		driver.findElement(By.xpath("//*[text()='"+selectValue+"']")).click(); 
		
		Thread.sleep(100);
		
		//To handle new window
		Set<String> winHandles = driver.getWindowHandles(); 
		System.out.println("The number of windows handles are" +winHandles.size());
		for(String winHandle:winHandles)
		{
			driver.switchTo().window(winHandle); //Switching to Child window
		}
		String title = driver.getTitle();
		System.out.println("The page title is : " +title);
		
		//To take the screenshot
		TakesScreenshot ts =((TakesScreenshot)driver); //Convert web driver object to TakeScreenshot
		File SrcFile = ts.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file
		FileUtils.copyFile(SrcFile, new File("screenshot//search1.png")); //Copy file at destination
		
		//To close the window
		driver.quit();
  }
}
