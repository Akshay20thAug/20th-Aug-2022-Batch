package dashBoard;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClasses.Base1;
import pomClasses.FundPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyUserCanAddStocksToWatchList {

WebDriver driver;
	
	LoginPage lp;
	HomePage hp;
	FundPage fp;
	
	@BeforeClass
	public void beforeClass() {
		driver = Base1.getDriver();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		fp = new FundPage(driver);
	}
	
	
	@Test(priority=1)
	public void VerifyUserCanLogin() throws IOException {
		
		lp.enterUserName();
		lp.enterPassword();
		lp.clickOnLoginBtn();
		Assert.assertTrue(hp.checkForHomePage());
	}
	
	
	@Test(priority=2)
	public void VerifyUserCanSearchProductAndGetList() {
		
		hp.searchStocks();
		Assert.assertTrue(hp.getSearchedStockListAndValidate());
	}
	
	
	@Test(priority=3)
	public void VerifyUserCanClickOnAddButton() {
		Assert.assertEquals(hp.clickOnAddToWatchListButton(), "Added");
	}
	
	
	@Test(priority=4)
	public void VerifySearchedStockIsAddedInWatchList() {
		Assert.assertEquals(hp.getWatchListStock(), "TATAMOTORS");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	
}
