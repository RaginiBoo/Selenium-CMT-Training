package com.amazonSearch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	//1.Locators
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement _txtSearch;
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")
	private WebElement _addtoCart;
	@FindBy(linkText="Cart")
	private WebElement _cartList;
	
	
	//2.Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//3.Actions 
	public void enterSearchTxt(String searchText) {
		_txtSearch.clear();
		_txtSearch.sendKeys(searchText+Keys.ENTER);
	}
	
	public SearchItemPage selectSearchedItem(String value) {
		getDriver().findElement(By.xpath("//*text()='"+value+"']")).click();
		return new SearchItemPage(getDriver());
	}
	
	public void addtoList() {
		_addtoCart.click();
	}
	
	public void cartList() {
		_cartList.click();
	}

}
