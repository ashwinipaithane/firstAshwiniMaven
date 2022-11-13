package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;

public class InventoryPageTest extends TestBase {
	
	LoginPage login;
	InventoryPage inventory;
	@BeforeMethod
	public void setup() throws Exception
	{
	Initialization();
	login=new LoginPage();
	inventory=new InventoryPage();
	}
	
//	@Test
//	public void urlTest()
//	{
//		login.loginToAcc();
//		String inventroyURL=inventory.url();
//		assertEquals(inventroyURL, "https://www.saucedemo.com/inventory.html");
//	}
//	
	@Test (enabled=true,invocationCount=1)
	public void selectBoxTest() throws Exception
	{
		login.loginToAcc();
		String cartResult = inventory.selectBox();
		Assert.assertEquals(cartResult, "5");
		Reporter.log("Get Select Box menu:"+cartResult);
	}
	
	@Test(enabled=true,timeOut=2000)
	public void removeTest() throws Exception
	{
		login.loginToAcc();
		String removeResult = inventory.remove();
		Assert.assertEquals(removeResult, "2","test case fail nhi zali");
	} 
	
	@Test(enabled=true,dependsOnMethods="selectBoxTest")
	public void gotonextpageTest() throws Exception
	{
		login.loginToAcc();
		SoftAssert soft=new SoftAssert();
		System.out.println("soft assert started");
		String result=inventory.gotonextpage();
		//Assert.assertEquals(result,"DESCRIPTION");
		soft.assertEquals(result, "DESCRIPTION");
		System.out.println("soft assert completed");
		soft.assertAll();
		Reporter.log("Next Page verify text:"+result);
	}
	
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
