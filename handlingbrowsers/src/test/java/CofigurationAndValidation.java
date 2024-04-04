

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CofigurationAndValidation 
{
	public void configureCar(WebDriver driver)
	{
		//selecting make dropdown by creating select class
		Select makeDropDown = createSelect(driver.findElement(By.name("make")));
		makeDropDown.selectByIndex(0);
		
		//Saving in a list to select diesel option
		List<WebElement> selectOption = driver.findElements(By.name("fuel_type"));
		selectOption.get(1).click();
		
		//Clicking parking sensor
		driver.findElement(By.name("parksensor")).click();
		
		//Select color dropdown to select a color from options
		Select colorDropDown = createSelect(driver.findElement(By.name("color")));
		colorDropDown.selectByValue("wt");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	
	public Select createSelect(WebElement ele)
	{
		Select test = new Select(ele);
		return test;
	}
	
	//Clicking Help Button
	public void clickHelp(WebDriver driver)
	{
		driver.findElement(By.id("helpbutton")).click();
	}
	
	//Clicking Online Chat Support
	public void clickOnlineChatSupport(WebDriver driver)
	{
		driver.findElement(By.id("chatbutton")).click();
	}
	
	//Clicking Visit Us button
	public void clickVisitUs(WebDriver driver)
	{
		driver.findElement(By.id("visitbutton")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	//To print all the visited browser handles
	public Set<String> displayVisitPages(WebDriver driver)
	{
		Set<String> visitedPages = driver.getWindowHandles();
		
		System.out.println("Number of pages opened : "+visitedPages.size());
		System.out.println("-------------Visited Pages---------------");
		for(String s : visitedPages) 
		{
			System.out.println(s);
		}
		return visitedPages;
	}
	
	//To check the Visit Us page handle
	public void checkVisitUspage(Set <String> pages,WebDriver driver )
	{
		String reqPage = "";
		for(String page : pages)
		{
			driver.switchTo().window(page);
			if(driver.getTitle().equals("Visit Us"))
			{
				System.out.println("It is found");
				reqPage = driver.getWindowHandle();
			}
		}
		System.out.println("Driver Handle for the Visit Us page  : " + reqPage);
		driver.close();
	}
	
	//To navigate driver to Homepage
	public WebDriver navigateBack(Set<String> pages , WebDriver driver )
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//Converting the set into list 
		List<String> pagesList = new ArrayList<String>(pages);
		driver.switchTo().window(pagesList.get(0));
		return driver;
	}
}
