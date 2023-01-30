package pomClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Util1;

public class HomePage extends Util1{
	
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Dashboard']")
	private WebElement dashboardText;
	
	@FindBy(xpath="//span[text()='Funds']")
	private WebElement fundText;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement stockSearchField;
	
	
	@FindBy(xpath="//ul[@class='omnisearch-results']//li/span[1]")
	private List<WebElement> searchedStocksWebElements;
	
	@FindBy(xpath="//button[contains(@data-balloon,'Add')]")
	private WebElement addToWatchListBtn;
	
	
	@FindBy(xpath="//div[@class='vddl-list list-flat']//div[contains(@class,'index0')]/div/div/span[1]/span/span")
	private WebElement watchListAddedStock;
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public boolean checkForHomePage() throws IOException {
		try {
			explicitWait(driver, dashboardText, 20);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	public void clickOnFundText() {
		fundText.click();
	}
	
	
	public void searchStocks() {
		stockSearchField.sendKeys("Tata Motors");
	}
	
	public boolean getSearchedStockListAndValidate() {
		
		for(WebElement k : searchedStocksWebElements)
		{
			if(k.getText().contains("TATA") || k.getText().contains("TATAMOTORS"))
			{
				
			}else {
				return false;
			}	
		}
		
		return true;
	}
	
	
	public String clickOnAddToWatchListButton() {
		
		explicitWait(driver, searchedStocksWebElements.get(0), 2);
		
		moveToElement(driver, searchedStocksWebElements.get(0));
		
		explicitWait(driver, addToWatchListBtn, 2);
		
		moveToElement(driver, addToWatchListBtn);
		
		addToWatchListBtn.click();
		
		explicitWait(driver, driver.findElement(By.xpath("//button[@data-balloon='Added']")), 2);
		
		String attributeValue = addToWatchListBtn.getAttribute("data-balloon").trim();
		
		stockSearchField.sendKeys(Keys.ESCAPE);
		
		return attributeValue;
		
	}
	
	
	public String getWatchListStock() {
		
		return watchListAddedStock.getText().trim();
	}
	
	
	
	
	

}
