package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utility.ReadData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver; // declear as global with public access specifier bcoz aaplyala dusrya pakge madhe use krta aal pahije
	public void Initialization() throws Exception
	{
		
		//cross browser testing
		String browser=ReadData.readPropertyFile("browser");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//WebDriver driver=new ChromeDriver(); local declare ahe tyala access krayla global declear krav lagel
			driver=new ChromeDriver();	
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			//WebDriver driver=new ChromeDriver(); local declare ahe tyala access krayla global declear krav lagel
			driver=new EdgeDriver();	
		}
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.get("https://www.saucedemo.com/");
		//use Read Data Method with driver.get with class name (ReadData)
		driver.get(ReadData.readPropertyFile("url")); 
		
	}

}
