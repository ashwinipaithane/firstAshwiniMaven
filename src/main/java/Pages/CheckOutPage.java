package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class CheckOutPage extends TestBase {
	//Object Repo
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstNameField;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastNameField;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement zipCode;
	@FindBy(xpath="//input[@id='continue']")private WebElement countinueBtn;
	@FindBy(xpath="//span[@class='title']")private WebElement checkOutpagetwo;
	//Constructor
	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	public void checkOutPage() throws Exception
	{
		/*firstNameField.sendKeys("ashwini");
		lastNameField.sendKeys("ppp");
		zipCode.sendKeys("123");*/
		firstNameField.sendKeys(ReadData.readPropertyFile("firstName"));
		lastNameField.sendKeys(ReadData.readPropertyFile("lastName"));
		zipCode.sendKeys(ReadData.readPropertyFile("zipcode"));
		Thread.sleep(3000);
		countinueBtn.click();
		//return checkOutpagetwo.getText();
		
	}
	
	public String getcheckoutfinal()
	{
		
		String result=checkOutpagetwo.getText()
;		return result;
	}
	
	

}
