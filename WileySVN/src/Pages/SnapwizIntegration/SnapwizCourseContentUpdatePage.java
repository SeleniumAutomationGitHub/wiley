package Pages.SnapwizIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class SnapwizCourseContentUpdatePage extends Initializer
{
	@FindBy(how = How.XPATH, using = "//table[2]//strong//a")
	private WebElement elmntTestBankLink;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Assignment Management']")
	private WebElement elmntTestBankAssignmentManagementLink;
	
	public SnapwizCourseContentUpdatePage(WebDriver driver){
		super(driver);
	}
	
	public void contentUpdateHomepage()
	{
		ResultUtil.report("INFO", "SnapwizCourseContentUpdatePage>contentUpdateHomepage", driver);
	}
	
	public void selectTestBankLink()
	{
		ResultUtil.report("INFO", "SnapwizCourseContentUpdatePage>testBanks", driver);
		switchFrameContentUpdatePage();
		if(Element.verify("Test Banks", driver, "XPATH", "//table[2]//strong//a"))
		{
			ResultUtil.report("MESSAGE", "Test Banks link is displayed", driver);
			Link.click("Test Banks", elmntTestBankLink, driver);
		}
		else{
			ResultUtil.report("MESSAGE", "Test Banks is clicked already", driver);
			Element.verify("Test Banks", driver, "XPATH", "//table[2]//p");
		}
	}
	
	
	public TestBankAssignmentManagementPage goToTestBanksAssignmentManagement()
	{
		ResultUtil.report("INFO", "SnapwizCourseContentUpdatePage>goToTestBanksAssignmentManagement", driver);
		Link.click("Assignment Management", elmntTestBankAssignmentManagementLink, driver);
		return PageFactory.initElements(driver, TestBankAssignmentManagementPage.class);
	}
	
	//Switch to courseworkframe
		public void switchFrameContentUpdatePage()
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Main frame", "mainframe", 6);
			Sync.waitForFrame(driver, "userframe frame", "userframe", 6);
			Sync.waitForFrame(driver, "workframe frame", "workframe", 6);
			Sync.waitForFrame(driver, "courseworkframe", "courseworkframe", 6);

		}
}
