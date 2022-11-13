package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class utilityClass {
	public static void selectDropdownMethod(WebElement ele,String value)
	{
		Select selectdropdown=new Select(ele); //accept webElement
		selectdropdown.selectByVisibleText(value);	
	}

}
