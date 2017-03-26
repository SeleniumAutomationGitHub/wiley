package Pages.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.Initializer;
import Pages.Common.StudentHomepage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class SnapwizOrionDashboardPage extends Initializer
{

	@FindBy(how = How.CLASS_NAME, using = "idb-header-description")
	private WebElement elmntCourseTitle;
	
	@FindBy(how = How.XPATH, using = "//img[@id='al-header-return-url']")
	private WebElement elmntReturnIcon;

	@FindBy(how = How.XPATH, using = "//img[@id='al-error-header-return-url']")
	private WebElement elmntErrorReturnIcon;
	
	@FindBy(how = How.XPATH, using = "//span[@class='idb-student-activity-label']")
	private WebElement elmntCourseHomePage;
	
	@FindBy(how = How.CLASS_NAME, using = "idb-user-profile-name")
	private WebElement elmntProfileName;
	
	@FindBy(how = How.ID, using = "myProfile")
	private WebElement elmntMyProfile;
	
	public SnapwizOrionDashboardPage(WebDriver driver){
		super(driver);
	}
	
	public void orionDashboardCourseTitle()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>orionDashboardCourseTitle", driver);
		try{
			driver.switchTo().defaultContent();
		}
		catch(Exception e){}
		String strWelcomeXpath="//div[@class='al-welcome-slider']/img[contains(@src,'orion-welcome-page-1')]";
		Sync.waitForObject(driver, "Welcome Screen", "XPATH", strWelcomeXpath, 20);
		if(Element.verify("Welcome screen", driver, "XPATH", strWelcomeXpath))
		{
			ResultUtil.report("Message", "Welcome screen is displayed", driver);
			WebElement welcomeScreen = driver.findElement(By.xpath(strWelcomeXpath));
			welcomeScreen.sendKeys(Keys.ESCAPE);			
		}
		else
		{
			ResultUtil.report("Message", "Welcome screen is not displayed", driver);
		}
		
		if(Element.verify("ORION dashboard Course title", driver, "CLASS", "idb-header-description"))
		{			
			ResultUtil.report("PASS", "ORION page "+elmntCourseTitle.getText()+" is  loaded", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "ORION page is not loaded", driver);
		}		
	}
	
	//Returns to student assignment page
	public StudentAssignmentPage returnToWPView()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>returnToWPView", driver);
		String strReturnIconXpath= "//img[@id='idb-header-return-url']";
		if(Element.verify("Orion return icon", driver, "XPATH", "//img[@id='al-header-return-url']"))
		{
			Button.click("Return ICON", elmntReturnIcon, driver);
		}
		else if(Element.verify("Orion return icon", driver, "XPATH", strReturnIconXpath))
		{
			Button.click("Return ICON", driver.findElement(By.xpath(strReturnIconXpath)), driver);
		}
		else
		{
			Button.click("Return Error ICON", elmntErrorReturnIcon, driver);
		}		
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}
	
	public StudentHomepage returnToStudentWPViewHomeScreen()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>returnToWPStudentView", driver);
		Button.click("Return ICON", elmntReturnIcon, driver);		
		return PageFactory.initElements(driver, StudentHomepage.class);
	}
	
	//Returns to course home page
	public CourseHomePage returnToWileyplusPView()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>returnToWileyplusPView", driver);
		String strReturnIconXpath= "//img[@id='idb-header-return-url']";
		if(Element.verify("Orion return icon", driver, "XPATH", "//img[@id='al-header-return-url']"))
		{
			Button.click("Return ICON", elmntReturnIcon, driver);
		}
		else if(Element.verify("Orion return icon", driver, "XPATH", strReturnIconXpath))
		{
			Button.click("Return ICON", driver.findElement(By.xpath(strReturnIconXpath)), driver);
		}
		else
		{
			Button.click("Return Error ICON", elmntErrorReturnIcon, driver);
		}		
		return PageFactory.initElements(driver, CourseHomePage.class);
	}
	
	//Returns to student home page
	public StudentHomepage returnToStudentWPHomeScreen()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>returnToStudentWPHomeScreen", driver);
		String strReturnIconXpath= "//img[@id='idb-header-return-url']";
		if(Element.verify("Orion return icon", driver, "XPATH", "//img[@id='al-header-return-url']"))
		{
			Button.click("Return ICON", elmntReturnIcon, driver);
		}
		else if(Element.verify("Orion return icon", driver, "XPATH", strReturnIconXpath))
		{
			Button.click("Return ICON", driver.findElement(By.xpath(strReturnIconXpath)), driver);
		}
		else
		{
			Button.click("Return Error ICON", elmntErrorReturnIcon, driver);
		}		
		return PageFactory.initElements(driver, StudentHomepage.class);
	}
	
	//Returns to the home screen
	public void returnToStudentScreen()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>returnToStudentScreen", driver);
		String strReturnIconXpath= "//img[@id='idb-header-return-url']";
		if(Element.verify("Orion return icon", driver, "XPATH", "//img[@id='al-header-return-url']"))
		{
			Button.click("Return ICON", elmntReturnIcon, driver);
		}
		else if(Element.verify("Orion return icon", driver, "XPATH", strReturnIconXpath))
		{
			Button.click("Return ICON", driver.findElement(By.xpath(strReturnIconXpath)), driver);
		}
		else
		{
			Button.click("Return Error ICON", elmntErrorReturnIcon, driver);
		}
	}
	
	//Validate orion course home page and users attributes
	public void validateOrionCourseHomepage()
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>validateOrionCourseHomepage", driver);
		Sync.waitForObject(driver, "Course home page", "XPATH", "//span[@class='idb-student-activity-label']");
		Element.verify("Course home page- Student activity text", elmntCourseHomePage, driver);
	}
	
	//User attributes
	public void validateUserAttributes(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "SnapwizOrionDashboardPage>validateUserAttributes", driver);
		String strDomainFirstName = dataMap.get("DomainOwnerFirstName");
		String strDomainSecondName = dataMap.get("DomainOwnerLastName");
		String strEmailID = dataMap.get("Email");
		
		Button.click("Profile Name",elmntProfileName, driver);
		Sync.waitForObject(driver, "My profile", "ID", "myProfile");
		Link.click("My profile", elmntMyProfile, driver);
		String strFirstXpath="//div[@class='right-col' and text()='"+strDomainFirstName+"']";
		Sync.waitForObject(driver, "Profile details", "CLASSNAME", "my-profile-wrapper");
		Element.verify("First Name", driver.findElement(By.xpath(strFirstXpath)), strDomainFirstName, driver);
		Element.verify("Last Name", driver.findElement(By.xpath(strFirstXpath)), strDomainSecondName, driver);
		Element.verify("Last Name", driver.findElement(By.xpath("//div[@class='right-col' and text()='"+strEmailID+"']")), strEmailID, driver);
	}
}
