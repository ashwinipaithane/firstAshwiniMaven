package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

import Base.TestBase;

public class CheckOutFinishPage extends TestBase{
	
	
	//object Repository
	
	@FindBy(xpath="//button[@id='finish']")private WebElement finishbtn;
	
	//constructor
	public CheckOutFinishPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String clickOnFinishBtn() throws Exception
	{
		
		//Thread.sleep(3000);
		finishbtn.click();
		System.out.println(finishbtn);
	
		String lastPage=driver.getCurrentUrl();
		System.out.println(lastPage);
		return lastPage;
	}

}
