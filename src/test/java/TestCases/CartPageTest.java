package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase{
	
	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartpageobject;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		login=new LoginPage();
		inventoryPage=new InventoryPage();
		cartpageobject=new CartPage();
	}
	
	
	@Test
	public void verifyCartTitleTest() throws Exception
	{
		
		login.loginToAcc();	
		inventoryPage.gotonextpage();
		String resultTitle = cartpageobject.verifyCartTitle();
		//System.out.println(resultTitle);
		assertEquals(resultTitle, "https://www.saucedemo.com/cart.html");
	}
	
	@Test
	public void removeCartPageItemTest() throws Exception
	{
		login.loginToAcc();	
		inventoryPage.selectBox();
		inventoryPage.gotonextpage();
		String resultCartvalue = cartpageobject.removeCartPageItem();
		assertEquals(resultCartvalue, "4");
		Thread.sleep(3000);
	}
	
	@Test
	public void clickCheckOutTest() throws Exception
	{
		login.loginToAcc();	
		inventoryPage.selectBox();
		inventoryPage.gotonextpage();
		String checkoutPage = cartpageobject.clickCheckOut();
		assertEquals(checkoutPage, "CHECKOUT: YOUR INFORMATION");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	

}
