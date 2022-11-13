package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckOutFinishPage;
import Pages.CheckOutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.checkOutCompletePage;

public class checkOutCompletePageTest extends TestBase{
	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartpageobject;
	CheckOutPage checkOutPageObj;
	CheckOutFinishPage lastPageObj;
	checkOutCompletePage compltepageobj;
	@BeforeMethod
	public void setup() throws Exception
	{
		Initialization();
		login=new LoginPage();
		inventoryPage=new InventoryPage();
		cartpageobject=new CartPage();
		checkOutPageObj=new CheckOutPage();
		lastPageObj=new CheckOutFinishPage();
		compltepageobj=new checkOutCompletePage();
	}
	@Test
	public void menuclick() throws Exception
	{
		login.loginToAcc();	
		inventoryPage.gotonextpage();
		cartpageobject.clickCheckOut();
		checkOutPageObj.checkOutPage();
		checkOutPageObj.getcheckoutfinal();
		compltepageobj.menuclick();
		Thread.sleep(1500);
		
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	

}
