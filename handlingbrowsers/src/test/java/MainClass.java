

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class MainClass {

	public static void functionToDo(WebDriver driver)
	{
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//creating object
		CofigurationAndValidation  c = new CofigurationAndValidation();
		
		
		c.configureCar(driver);
		
		c.clickHelp(driver);
		
		c.clickOnlineChatSupport(driver);
		
		c.clickVisitUs(driver);
		
		Set<String> visitedPages = c.displayVisitPages(driver);
		
		c.checkVisitUspage(visitedPages, driver);
		
		driver = c.navigateBack(visitedPages, driver);
		
		DriverSetup.closeAllBrowsers(driver);
	}
	
	public static void main(String[] args) throws Exception 
	{
		System.out.println("----------------------------------Using Chrome Browser------------------------------------");
		
		functionToDo(DriverSetup.setupChromeDriver());
		
		
		System.out.println("-----------------------------------Using Edge Browser-------------------------------------");
		
		
		functionToDo(DriverSetup.setupEdgeDriver());
	}

}
