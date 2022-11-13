package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class checkOutCompletePage extends TestBase{
	
	//object repository
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement menubuttn;
	@FindBy(xpath="//a[text()='Logout']")private WebElement logOut;
	
	//constructor
	public checkOutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//method
	public void menuclick() throws Exception
	{
		menubuttn.click();
		Thread.sleep(2000);
		logOut.click();
	}

}
