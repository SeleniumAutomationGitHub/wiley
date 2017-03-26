package Pages.SnapwizIntegration;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Link;
import Toolbox.Sync;

public class SnapwizSubDomainPage extends Initializer
{
	@FindBy(how = How.XPATH, using = "//span[text()='Properties']")
	private WebElement elmntPropertiesTab;
	
	public SnapwizSubDomainPage(WebDriver driver){
		super(driver);
	}	
	
	//Validate the given domain name and click the domain name
	public SnapwizSubDomainPropertiesPage selectDomainName(Map<String,String>dataMap)
	{
		switchDomainNameTable();
		String strDomainName = dataMap.get("DomainName");
		String strDomainXpath= "//table//tbody[./tr/td]/tr[not(.//td[.//img])]";
		List<WebElement> elmntDomainNames = driver.findElements(By.xpath(strDomainXpath));
		
		for(int i=2;i<elmntDomainNames.size();i++)
		{
			WebElement elmntDomainName = driver.findElement(By.xpath(strDomainXpath+"["+i+"]//a[not(starts-with(text(),'dmn'))]"));
			if(elmntDomainName.getText().equals(strDomainName))
			{
				Link.click("Domain name", elmntDomainName, driver);
				break;
			}
		}
		return PageFactory.initElements(driver, SnapwizSubDomainPropertiesPage.class);
	}
	
	//Navigate to properties tab
	public CoursePropertiesPage gotoPropertiesTab()
	{
		switchFrameCoursePropertiesSubTabs();
		Button.click("Properties tab", elmntPropertiesTab, driver);		
		return PageFactory.initElements(driver, CoursePropertiesPage.class);
	}

	//Switch to coursenav
	public void switchFrameCoursePropertiesSubTabs()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame", "workframe", 6);
		Sync.waitForFrame(driver, "coursenav frame", "coursenav", 6);
	}	
	
	//Switch to course work frame
	public void switchDomainNameTable()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame", "workframe", 6);
		Sync.waitForFrame(driver, "courseworkframe frame", "courseworkframe", 6);		
	}	
}
