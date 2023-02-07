package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Util1;

public class OrdersPage extends Util1{

WebDriver driver;
	
	@FindBy(xpath="//button[text()='Add funds ']")
	private WebElement addFundButton;
	
	
	@FindBy(xpath="//h1[text()='Deposit funds']")
	private WebElement depositeText;
	
	

	public OrdersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public boolean checkForFundPage() {
		try {
			explicitWait(driver, addFundButton, 5);
		}catch(Exception e) {
			return false;
		}
		return true;	
	}
	
	
	public boolean checkForFundPage(int a) {
		try {
			explicitWait(driver, addFundButton, 5);
		}catch(Exception e) {
			return false;
		}
		return true;	
	}
	
	
}
