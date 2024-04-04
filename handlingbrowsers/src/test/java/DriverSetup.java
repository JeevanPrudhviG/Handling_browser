

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup 
{
	//driver setup for chrome driver
	public static WebDriver setupChromeDriver() throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ExcelData.getUrl());
		return driver;
	}
	
	//driver setup for edge driver
	public static  WebDriver setupEdgeDriver() throws Exception
	{
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(ExcelData.getUrl());
		return driver;
	}
	
	//method to close driver
	public static void closeAllBrowsers(WebDriver driver)
	{
		driver.quit();
	}
}
