package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase{
	
	// driver directly nhi gheta yet mhnun method creat krav lagel ani webdriver la public decler kel ahe
	//object repository
	@FindBy(xpath="//div[@class=\"login_logo\"]")private WebElement loginLogo;
	//@FindBy(xpath="")private WebElement botLogo;
	@FindBy(xpath="//input[@id='user-name']")private WebElement userNameTextBox;
	@FindBy(xpath="//input[@id='password']")private WebElement passwordBox;
	@FindBy(xpath="//input[@id='login-button']")private WebElement loginBtn;
	@FindBy(xpath="//span[@class='title']")private WebElement pagesecondProduct;
	@FindBy(xpath="//div[@class='peek']")private WebElement afterloginpeekLogo;
	@FindBy(xpath="//img[@class='footer_robot']")private WebElement afterLoginFooterLogo;
	
	// here creat constructor and connect all xpath through driver
	//driver ni current class che element connect krto ani this jya page vr ahe tyache
	
	public LoginPage() //constructor to initialize the element
	{
		PageFactory.initElements(driver, this);
	}
	//Method to verify Title
		public String verifyTitle()
		{
			return driver.getTitle();
		}
	//Method to verify URL
		
		public String verifyCurrentURL()
		{
			return driver.getCurrentUrl();
		}
	//Method to verify logo
	public boolean loginLogopresent()
	{
		return loginLogo.isDisplayed();
	}
	
	
	public String loginToAcc() throws Exception
	{
		//userNameTextBox.sendKeys("standard_user");
		//passwordBox.sendKeys("secret_sauce");
		// after creating ReadData class and use config property file so we can not pass hardcode value so use here
		userNameTextBox.sendKeys(ReadData.readPropertyFile("username"));
		passwordBox.sendKeys(ReadData.readPropertyFile("password"));
		loginBtn.click();
	    return pagesecondProduct.getText();
		}
	public String afterloginURLverify() throws Exception
	{
		loginToAcc();
		return driver.getCurrentUrl();
	}
	public boolean afterloginlogoheader() throws Exception
	{
		loginToAcc();
		return afterloginpeekLogo.isDisplayed();
	}
	public boolean afterLoginFooter() throws Exception
	{
	loginToAcc();
	return afterLoginFooterLogo.isDisplayed();
	}
	
	}
	
	
	


