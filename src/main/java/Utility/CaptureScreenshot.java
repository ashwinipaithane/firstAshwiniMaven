package Utility;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class CaptureScreenshot extends TestBase{
	public static void screenshotcapture(String name) throws Exception
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desc=new File("C:\\Users\\ashwi\\eclipse-workspace\\FirstAshwiniMaven\\Screenshot\\photo"+name+".jpg");
		FileHandler.copy(source, desc);
	}

}
