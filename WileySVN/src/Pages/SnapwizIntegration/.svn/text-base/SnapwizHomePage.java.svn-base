package Pages.SnapwizIntegration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Toolbox.Button;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class SnapwizHomePage extends Initializer
{
	
	@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Courses']")
	private WebElement elmntCourseTab;
	
	@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Configuration']")
	private WebElement elmntConfigurationTab;
	
	public SnapwizHomePage(WebDriver driver){
		super(driver);
	}
	
	public SnapwziCoursesListPage validateSnapwizHomepage() throws InterruptedException{		
		ResultUtil.report("INFO", "SnapwizHomePage>validateSnapwizHomepage", driver);
		return(PageFactory.initElements(driver, SnapwziCoursesListPage.class));
	}
	
	//Go to course Tab
	public SnapwziCoursesListPage gotoCoursesTab() throws InterruptedException
	{
		ResultUtil.report("INFO", "SnapwizHomePage>gotoCoursesTab", driver);
		switchFrameNavigationBar();
		Button.click("Courses tab", elmntCourseTab, driver);		
		ResultUtil.report("MESSAGE", "Clicked Course button", driver);
		return PageFactory.initElements(driver, SnapwziCoursesListPage.class);
	}
	
	//Go to configuration tab
	public ConfigurationPage gotoConfigurationTab()
	{
		ResultUtil.report("INFO", "SnapwizHomePage>gotoConfigurationTab", driver);
		switchFrameNavigationBar();
		Button.click("Configuration Tab", elmntConfigurationTab, driver);
		return PageFactory.initElements(driver, ConfigurationPage.class);
	}	
	
	//Switch to navigator frame
	public void switchFrameNavigationBar()
	{
		Sync.waitForFrame(driver, "MainFrame", "mainframe", 6);
		Sync.waitForFrame(driver, "UserFrame", "userframe", 5);
		Sync.waitForFrame(driver, "Navigator", "navigator", 4);
	}
}
