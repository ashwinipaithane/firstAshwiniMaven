
package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class GroupPageTest extends TestBase{
	
	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartpageobject;
	CheckOutPage checkOutPageObj;
	
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception
	{
	Initialization();
	login=new LoginPage();
	inventoryPage=new InventoryPage();
	cartpageobject=new CartPage();
	checkOutPageObj=new CheckOutPage();
	
	}
	
	
	@Test(groups="sanity")
	public void checkOutPageTest() throws Exception
	{
		login.loginToAcc();	
		inventoryPage.gotonextpage();
		cartpageobject.clickCheckOut();
		checkOutPageObj.checkOutPage();
		
		}
	@Test(groups= {"smoke","Regration"})
	public void getcheckoutfinalTest() throws Exception
	{
		login.loginToAcc();	
		inventoryPage.gotonextpage();
		cartpageobject.clickCheckOut();
		checkOutPageObj.checkOutPage();
		String finaltext=checkOutPageObj.getcheckoutfinal();
		//System.out.println(finaltext);
		assertEquals(finaltext, "CHECKOUT: OVERVIEW");
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser()
	{
		driver.close();
	}

}
