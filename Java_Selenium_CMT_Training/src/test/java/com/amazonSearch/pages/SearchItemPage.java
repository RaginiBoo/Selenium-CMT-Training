package com.amazonSearch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchItemPage extends BasePage {
	
	public SearchItemPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean isSearchItemDisplayed(String value) {
		return getDriver().findElement(By.xpath("//*text()='"+value+"'])[1]")).isDisplayed();
	}
	
	

}
