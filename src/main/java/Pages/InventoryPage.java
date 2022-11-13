package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.ReadData;
import Utility.utilityClass;

public class InventoryPage extends TestBase{
	//TC-1 : select drop down and select any text
	//TC-2: as per select dropdown add all product in cart
	//TC-3 : as selected item get countfrom cart
	//TC-4 :  remove 2 product 
	//TC-5: get cart amount
	//TC-6 : verify next page url
	
	//Object Repository
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement selectDroupDown;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement addFirstProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement addsecondProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement addThiredProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement addFourthProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement addFifthProduct;
	@FindBy(xpath="add-to-cart-test.allthethings()-t-shirt-(red)")private WebElement addsixProduct;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement getaddcardCount;
	@FindBy(xpath=" //button[@name='remove-sauce-labs-backpack']")private WebElement removeFirstProduct;
	//@FindBy(xpath="")private WebElement  removeSecondElement;
	@FindBy(xpath=" //div[@class='cart_desc_label']")private WebElement addCartdiscription;
	@FindBy(xpath=" //a[@class='shopping_cart_link']")private WebElement verifynextPageURL;
	
	//Constructor
	public InventoryPage()
	{
	PageFactory.initElements(driver,this);
	}
	
	//methods
	
	//
//	public String url()
//	{
//		
//		String URL = driver.getCurrentUrl();
//		return URL;
//	}
	//select dropdown
	public String selectBox() throws Exception
	{
		Select dropdown=new Select(selectDroupDown);
		
		//dropdown.selectByVisibleText("Price (low to high)");
		//use here excel method  readdata file present in config file
		Thread.sleep(2000);
		//utilityClass.selectDropdownMethod(selectDroupDown, "Price (low to high)");
		utilityClass.selectDropdownMethod(selectDroupDown, ReadData.readExcelFile(0,0));
		//dropdown.selectByVisibleText(ReadData.readExcelFile(0,0));
		Thread.sleep(1500);
		addFirstProduct.click();
		addsecondProduct.click();
		addThiredProduct.click();
		addFourthProduct.click();
		addFifthProduct.click();
		//addsixProduct.click();	
		String cartCount = getaddcardCount.getText();
		return cartCount;
		
	}
	public String remove()
	{
		addFirstProduct.click();
		addsecondProduct.click();
		addThiredProduct.click();
		removeFirstProduct.click();
		String removecount = getaddcardCount.getText();
		return removecount;
	}
	
	public String gotonextpage()
	{
		verifynextPageURL.click();
		 String discription=addCartdiscription.getText();
		 return discription;
	
	}
	
	
	
	
	
	

}
