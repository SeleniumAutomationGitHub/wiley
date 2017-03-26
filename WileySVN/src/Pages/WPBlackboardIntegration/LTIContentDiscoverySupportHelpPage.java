package Pages.WPBlackboardIntegration;

import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Pages.WPBlackboardIntegration.*;
import Pages.WPBlackboardIntegration.LTIConfigurationPage;
public class LTIContentDiscoverySupportHelpPage 
{	
		private final WebDriver driver;
		
@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='Content Links']")
private WebElement elmntContentLink;
		
@FindBy(how = How.XPATH, using = "//input[@value='Add Content']")
private WebElement elmntAddContentBtn;
		
@FindBy(how = How.NAME, using = "name")
private WebElement elmntNameTextBox;
		
@FindBy(how = How.NAME, using = "description")
private WebElement elmntDescriptionTextBox;
		
@FindBy(how = How.ID, using = "parent")
private WebElement elmntParentDropdown;
		
@FindBy(how = How.ID, using = "type-wp4-navigationalLinks")
private WebElement elmntItemTypeDropdown;
		
@FindBy(how = How.ID, using = "all")
private WebElement elmntVisibilityAllRadioButton;
		
@FindBy(how = How.ID, using = "instructors")
private WebElement elmntVisibilityInstructorRadioButton;
		
@FindBy(how = How.ID, using = "students")
private WebElement elmntVisibilityStudentRadioButton;
		
@FindBy(how = How.XPATH, using = "//input[@type='file']")
private WebElement elmntFileUploadbtn;
	
@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Tools Links']")
private WebElement elmntToolsLinkTab;
		
@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Support/Help Links']")
private WebElement elmntSupportHelpTab;
		
@FindBy(how = How.XPATH, using = "//input[@type='submit']")
private WebElement elmntSavebtn;
		
@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
private WebElement elmntCancelbtn;
		
@FindBy(how = How.XPATH, using = "//select[starts-with(@name,'order_')]")
private WebElement elmntOrderDropdown;
		
@FindBy(how = How.XPATH, using = "//table/tbody//span[.='Finished Class']")
private WebElement finishedClass;
		
@FindBy(how = How.XPATH, using = "//table/tbody//a[.='Support Tools']")
private WebElement selectSupport;
		
@FindBy(how = How.XPATH, using = "//table//tr//input[@value='Save']")
private WebElement selectSave;
		
		
@FindBy(how = How.XPATH, using = "//table//tr//td//span[.='Tools Links']")
private WebElement selectTools;
		
@FindBy(how = How.XPATH, using = "//table//tbody//tr//a[.='WileyPLUS']")
private WebElement selectWiley;
		
		
		
public LTIContentDiscoverySupportHelpPage(WebDriver driver)
{
			this.driver=driver;
}
		
		//Description:Support-Help Home page
public void SupportHelpHomePage()
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>SupportHelpHomePage", driver);
}
		
		
		
		//Description:Select any help/ Support link
public void selectHelpLink(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>selectHelpLink", driver);
			driver.switchTo().defaultContent();
			switchFrameCourseListTable();
			String strEditLinkName = dataMap.get("EditLinkName");
			Link.click("Any Support Link", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strEditLinkName+"']]//a[text()='"+strEditLinkName+"']")), driver);
			Sync.waitForSeconds(3, driver);
}
		
		
		//Description:selectfinsihed class
		
public void selectFinishedClass() 
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>selectFinishedClass", driver);
			Sync.waitForSeconds(2, driver);
			driver.switchTo().defaultContent();
			switchFrameCourseListTable();
							
			Sync.waitForSeconds(2, driver);
			Link.click("Finished Class", finishedClass, driver);
			
			
}
		//Description:select supporttools
public void selectSupportTools() 
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>selectSupportTools", driver);
			Sync.waitForSeconds(5, driver);
			driver.switchTo().defaultContent();
			switchFrameCourseListTable();
			Sync.waitForSeconds(4, driver);
			Link.click("selectedsupport", selectSupport, driver);
			
			
}
		
		//Description: select save button
public void selectsavebutton() throws Exception
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>selectsavebutton", driver);
			Sync.waitForSeconds(5, driver);
			driver.switchTo().defaultContent();
			switchFrameCourseListTable();
							
			Sync.waitForSeconds(4, driver);
			Button.click("select save", selectSave, driver);
			
			
}
		
		//Description: select tools
public void selectTools()
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>selectTools", driver);
			Sync.waitForSeconds(5, driver);
			driver.switchTo().defaultContent();
			switchFrameCourseListTable();
			Sync.waitForSeconds(4, driver);
			Link.click("selectedsupport", selectTools, driver);
			
			
}
		
		//Description:select wiley plus
public void selectWileyPlus() 
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>selectWileyPlus", driver);
			Sync.waitForSeconds(5, driver);
			driver.switchTo().defaultContent();
			switchFrameCourseListTable();
			Sync.waitForSeconds(4, driver);
			Link.click("selectWileyPlus", selectWiley, driver);
			
			
}
		//Description:Validate Edit content area function
public void editContentSupportValues(Map<String,String> dataMap) throws InterruptedException
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>editContentSupportValues", driver);
			
			TextBox.clearValue("Name", elmntNameTextBox, driver);
			TextBox.clearValue("Description", elmntDescriptionTextBox, driver);			
			Sync.waitForSeconds(2, driver);
			String strName = dataMap.get("EditContentName");
			String strDescription = dataMap.get("EditContentDescription");
			String strIconPath = dataMap.get("EditIconPath");			
			
			TextBox.enterValue("Name", elmntNameTextBox, strName, driver);
			TextBox.enterValue("Description", elmntDescriptionTextBox, strDescription, driver);
			chooseFile(dataMap.get("EditIconPath"));
			String strEnteredName = dataMap.put("EnteredName", elmntNameTextBox.getText());
}
		
		//Description:Verify the edit Content Support table
public void validateeditContentSupportTable(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>validateeditContentSupportTable", driver);
			String strName = dataMap.get("EditContentName");
			String strEnteredName = dataMap.get("EnteredName");
			String strIconPath = dataMap.get("EditIconPath");	
			if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
			{
				ResultUtil.report("PASS", "The table is edited", driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);								
			}
			else
			{
				ResultUtil.report("Fail", "The table is not edited", driver);
			}
	}
		
		//Description:Choose file functionality
public void chooseFile(String strPathName) throws InterruptedException
{
			ResultUtil.report("INFO", "LTIContentDiscoveryPage>chooseFile", driver);
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(strPathName);
			Sync.waitForSeconds(7, driver);			
		}
		
		//Description:Save Settings
public void saveSettings()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>saveSettings", driver);
			Button.click("Save", elmntSavebtn, driver);
			Sync.waitForSeconds(5, driver);
}
				
		//Description:Cancel Settings
public void cancelSettings()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>cancelSettings", driver);
			Button.click("Cancel", elmntCancelbtn, driver);
			Sync.waitForSeconds(5, driver);
}
		//Description:switch frame
public void switchFrameCourseListTable()
{
			WebDriver myFrame = driver.switchTo().frame("mainframe");
			myFrame = myFrame.switchTo().frame("userframe");
			myFrame = myFrame.switchTo().frame("workframe");
		}
	
		//Description:Verify the edit Content Support table
public void validateeditContentSupportTableonCancel(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoverySupportHelpPage>validateeditContentSupportTableonCancel", driver);
			String strName = dataMap.get("EditContentName");
			String strEnteredName = dataMap.get("EnteredName");
			String strIconPath = dataMap.get("EditIconPath");	
			if(Element.notVerify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
			{
				ResultUtil.report("FAIL", "The table is edited", driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);								
			}
			else
			{
				ResultUtil.report("PASS", "The table is not edited", driver);
			}
			}
				
}
