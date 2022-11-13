package TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.CaptureScreenshot;
import Utility.ReadData;

// here we use TestNG annotation 
public class LoginPageTest extends TestBase{
	LoginPage login;

	
 @BeforeMethod
 public void setup() throws Exception
 {
	 Initialization();
	 //LoginPage login=new LoginPage(); //directly object creat nhi krta yet mhnun login page test and login page he diff diff pakge madhe ahe available mhnun import krav lagte
 //setup method madhl object use nhi krta yet bcoz te local ahe.so te global declr krav lagte
	 login=new LoginPage();
 }
 @Test(enabled=true,priority=2)
 //TC for Verify title
 	public void verifyTitleTest() throws Exception
 	{
	   String title = login.verifyTitle();
	//Assert.assertEquals(title, "Swag Labs");
	  Assert.assertEquals(title, ReadData.readExcelFile(1, 0));
	  System.out.println("verifyTitleTest");
	
}
 
 @Test(enabled=true,priority=1)
 //3)TC for Verify URL
 	 public void verifyCurrentURLTest() throws Exception
 	 {
//	 String expectedURL = "https://www.saucedemo.com/";
//	 String actualURL = verifyCurrentURL();
//	 assertEquals(actualURL, expectedURL);
	 
	String Url=login.verifyCurrentURL();
	//assertEquals(Url, "https://www.saucedemo.com/");
	Assert.assertEquals(Url, ReadData.readExcelFile(1,1));
	System.out.println("verifyCurrentURLTest");
     }
 @Test(enabled=true,priority=3)
 public void loginLogopresentTest()
 {
	boolean logopresent = login.loginLogopresent();
	Assert.assertEquals(logopresent, true);
	System.out.println("loginLogopresentTest");
 }
 
 @Test(enabled=true,/*dependsOnMethods="verifyTitleTest()"*/ priority=4)
 public void loginToAccTest() throws Exception
 {
	String acclog = login.loginToAcc();
	Assert.assertEquals(acclog, "PRODUCTS");
	System.out.println("loginToAccTest");
 }
 @Test(enabled=true)
 public void afterloginURLverifyTest() throws Exception
 {
	 //assertEquals(login.afterloginURLverify(), "https://www.saucedemo.com/inventory.html");
	 Assert.assertEquals(login.afterloginURLverify(),ReadData.readExcelFile(1, 2));
 }
 @Test(enabled=true)
 public void afterloginlogoheaderTest() throws Exception
 {
	 Assert.assertEquals(login.afterloginlogoheader(), true);
 }
 @Test(enabled=true,priority=5)
 public void afterLoginFooterTest() throws Exception
 {
	 Assert.assertEquals(login.afterLoginFooter(), true);
	 System.out.println("afterLoginFooterTest");
 }
 
 @AfterMethod
 public void closeBrowser(ITestResult it) throws Exception  //ITestResult is a interface and it is a reference variable
 {
	 if(ITestResult.FAILURE==it.getStatus())
	 {
		 CaptureScreenshot.screenshotcapture(it.getName());
	 }
	 
	 driver.close();
 }
}
 
