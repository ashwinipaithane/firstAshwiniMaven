package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutFinishPage;
import Pages.CheckOutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
public class CheckOutFineshPageTest extends TestBase {
	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartpageobject;
	CheckOutPage checkOutPageObj;
	CheckOutFinishPage lastPageObj;
	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		login=new LoginPage();
		inventoryPage=new InventoryPage();
		cartpageobject=new CartPage();
		checkOutPageObj=new CheckOutPage();
		lastPageObj=new CheckOutFinishPage();
	}
	
	@Test
	public void clickOnFinishBtnTest() throws Exception
	{
		login.loginToAcc();	
		inventoryPage.gotonextpage();
		cartpageobject.clickCheckOut();
		checkOutPageObj.checkOutPage();
		checkOutPageObj.getcheckoutfinal();
    	String CurrentURL=lastPageObj.clickOnFinishBtn();
    	System.out.println(CurrentURL);
    	assertEquals(CurrentURL, "https://www.saucedemo.com/checkout-complete.html");
		
		
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	

}
