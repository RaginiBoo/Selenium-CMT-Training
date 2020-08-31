package com.amazonSearch.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazonSearch.pages.HomePage;
import com.amazonSearch.pages.SearchItemPage;
import com.amazonSearch.utils.BaseTest;

public class E2ETests extends BaseTest {
	HomePage homepage;
	SearchItemPage searchItemPage;
	
	//Data Driven 
	@DataProvider(name="searchItems")
	public static Object[][] searchList() {
		return new Object[][] {
			{"sonytv","Sony KDL32W600D 32\" 720p Smart LED TV - Black"},
			{"mouse","AmazonBasics Wireless Computer Mouse with USB Nano Receiver - Black"},
			{"lipstick","Almay Lip Vibes, Go Wild, matte lipstick,1 Count, 0.14 Ounce"}};
	}
	
	@Test(dataProvider="searchItems")
	public void validateSearchList(String searchKey, String selectItem) throws InterruptedException {
		homepage.enterSearchTxt(searchKey);
		Thread.sleep(2000);
		searchItemPage = homepage.selectSearchedItem(selectItem);
		Assert.assertTrue(searchItemPage.isSearchItemDisplayed(selectItem));
		homepage.addtoList();
		homepage.cartList();
	}
	
	@BeforeClass
	public void setup() {
		homepage = new HomePage(getDriver());
	}
}
