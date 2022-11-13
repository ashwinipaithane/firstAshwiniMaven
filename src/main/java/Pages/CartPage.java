package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase {
//TC-1:Verify that "Your Cart is present or not"
//TC-2:Remove any 1 product
//TC=3:Click on CheckoutButton
	
	//object repository
	@FindBy(xpath="//span[@class='title']")private WebElement yourCartTitle;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement anyoneProductRemove;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement getcartValue;
	@FindBy(xpath=" //button[@id='checkout']")private WebElement CheckOutButton;
	@FindBy(xpath=" //span[@class='title']")private WebElement CheckOutInfo;
	
	
	//constructor
	public CartPage()
	{
	PageFactory.initElements(driver, this);
	}

	//Methods
	
	public String verifyCartTitle()
	{
	
		String cartURL=driver.getCurrentUrl();
		return cartURL;
	}
	
	public String removeCartPageItem()
	{
		anyoneProductRemove.click();
		String value = getcartValue.getText();
		return value;	
	}
	
	public String clickCheckOut()
	{
		CheckOutButton.click();
		String checkOutPage = CheckOutInfo.getText();
		return checkOutPage;
	}
	
	
	
}
