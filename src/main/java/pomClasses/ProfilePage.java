package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.Util1;

public class ProfilePage extends Util1{
	
WebDriver driver;
	
	@FindBy(xpath="//button[text()='Add funds ']")
	private WebElement addFundButton;
	
	
	@FindBy(xpath="//h1[text()='Deposit funds']")
	private WebElement depositeText;
	
	@FindBy(xpath="//input[@id='addfunds_amount']")
	private WebElement depositeAmountInputField;
	
	@FindBy(xpath="//input[@id='addfunds_vpa']")
	private WebElement upiInputField;
	
	@FindBy(xpath="//button[@id='addfunds_submit']")
	private WebElement continueButton;
	
	@FindBy(xpath="//h4[@class='upi-status-amount']")
	private WebElement conformationAmount;
	
	
	
	public ProfilePage(WebDriver driver) {
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
	

}
