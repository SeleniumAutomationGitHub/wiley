package Pages.WPBlackboardIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class LTIContentDiscoveryStaticTargetPage 
{
	private final WebDriver driver;
	
@FindBy(how = How.NAME, using = "static_url")
private WebElement elmntURLTextBox;
	
@FindBy(how = How.XPATH, using = "//input[@type='submit']")
private WebElement elmntSavebtn;
	
@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
private WebElement elmntCancelbtn;	
	
@FindBy(how = How.ID, using = "all")
private WebElement elmntVisibilityAllRadioButton;
	
@FindBy(how = How.ID, using = "instructors")
private WebElement elmntVisibilityInstructorRadioButton;
	
@FindBy(how = How.ID, using = "students")
private WebElement elmntVisibilityStudentRadioButton;
	
public LTIContentDiscoveryStaticTargetPage(WebDriver driver)
{
this.driver=driver;
	}
	
	//Description:Static target Home page
public void staticTargetHomePage()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>staticTargetHomePage", driver);
	}
	
	//Description:Validate static target home pageGUI
public void staticBBTargetsAutoRefresh(Map<String,String> dataMap)
	    {
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>staticBBTargetsAutoRefresh", driver);
		String strAutoRefreshText = dataMap.get("AutoGradeRefresh");
		String strAutoRefreshUrl = dataMap.get("AutoGradeUrl");
		Element.verify("Auto Refresh", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strAutoRefreshText+"']]//a[text()='"+strAutoRefreshText+"']")), driver);
		Element.verify("LTI Target", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strAutoRefreshText+"']]//td[text()='wp4-scheduledRefreshInfo']")), driver);
		Element.verify("Visisbility", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strAutoRefreshText+"']]//td[text()='All']")), driver);
		Element.verify("Auto grade refresh url", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strAutoRefreshText+"']]//td[text()='"+strAutoRefreshUrl+"']");
		Link.click("Any Edit Link", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strAutoRefreshText+"']]//a[text()='"+strAutoRefreshText+"']")), driver);
		Sync.waitForSeconds(5, driver);
	    }
	
	//Description:Auto refresh edit content screen
public void staticBBTargetsAutoRefreshEditContent(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>staticBBTargetsAutoRefreshEditContent", driver);
		String strAutoRefreshText = dataMap.get("AutoGradeRefresh");
		String strAutoRefreshUrl = dataMap.get("AutoGradeUrl");
		Element.verify("Auto Refresh", driver.findElement(By.xpath("//td[contains(text(),'"+strAutoRefreshText+"')]")), driver);
		Element.verify("Auto Refresh", driver.findElement(By.xpath("//td[contains(text(),'wp4-scheduledRefreshInfo')]")), driver);
		Radiobutton.verify("All", elmntVisibilityAllRadioButton, driver);
		Radiobutton.verify("Instructo", elmntVisibilityInstructorRadioButton, driver);
		Radiobutton.verify("Student", elmntVisibilityStudentRadioButton, driver);
		TextBox.verifyValue("Url", driver.findElement(By.xpath("//input[@value='"+strAutoRefreshUrl+"']")), "http://help.wileyplus.com/bb/bbgetstarted/Instructor/Gradebook.htm", driver);
		Sync.waitForSeconds(3, driver);
		Button.verify("SAve", elmntSavebtn, driver);
		Button.verify("Cancel", elmntCancelbtn, driver);
	    }
	
	//Description:Select any Static target link
public void selectStaticTargetLink(Map<String,String> dataMap)
	    {
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>selectStaticTargetLink", driver);			
		String strEditLinkName = dataMap.get("StaticEditLinkName");
		Link.click("Any Edit Link", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strEditLinkName+"']]//a[text()='"+strEditLinkName+"']")), driver);
		Sync.waitForSeconds(5, driver);
	    }
	
	//Description:Change the URL
public void changeUrl(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>changeUrl", driver);
		String editedURL = dataMap.get("EditUrlChange");
		TextBox.clearValue("Clear URL", elmntURLTextBox, driver);
		Sync.waitForSeconds(3, driver);
		TextBox.enterValue("URL", elmntURLTextBox, editedURL, driver);
		Sync.waitForSeconds(3, driver);
	    }
	
	//Description:Revert to default url
public void revertUrl(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>revertUrl", driver);
		String editedURL = dataMap.get("UrlChange");
		TextBox.clearValue("Clear URL", elmntURLTextBox, driver);
		Sync.waitForSeconds(3, driver);
		TextBox.enterValue("URL", elmntURLTextBox, editedURL, driver);
		Sync.waitForSeconds(3, driver);
	    }
	
	//Description:Verify the edit change url table
public void validateEditChangeUrlTable(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>validateEditChangeUrlTable", driver);
		String editedURL = dataMap.get("EditUrlChange");
		String strStaticeditedURL = dataMap.get("StaticEditLinkName");
		String strEnteredName = dataMap.get("EditLinkName");
		if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strStaticeditedURL+"']]"))
		{
		ResultUtil.report("PASS", "Edited url is displayed in the static  table", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strStaticeditedURL+"']]//a[text()='"+strStaticeditedURL+"']")), driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strStaticeditedURL+"']]/td[text()='"+editedURL+"']")), driver);				
		}
		else
		{	
		ResultUtil.report("Fail", "Edited url is not displayed in the static table", driver);
		}
		}
	
	//Description:Verify the reverted change url table
public void validaterevertChangeUrlTable(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>validaterevertChangeUrlTable", driver);
		String editedURL = dataMap.get("UrlChange");
		String strStaticeditedURL = dataMap.get("StaticEditLinkName");
		String strEnteredName = dataMap.get("EditLinkName");
		if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strStaticeditedURL+"']]"))
		{
		ResultUtil.report("PASS", "Edited url is displayed in the static  table", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strStaticeditedURL+"']]//a[text()='"+strStaticeditedURL+"']")), driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strStaticeditedURL+"']]/td[text()='"+editedURL+"']")), driver);				
		}
		else
		{	
		ResultUtil.report("Fail", "Edited url is not displayed in the static table", driver);
		}
		}
	
	//Description:Save Settings
public void saveSettings()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>saveSettings", driver);
		Button.click("Save", elmntSavebtn, driver);
		Sync.waitForSeconds(10, driver);
	    }
					
	//Description:Cancel Settings
public void cancelSettings()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryStaticTargetPage>cancelSettings", driver);
		Button.click("Cancel", elmntCancelbtn, driver);
		Sync.waitForSeconds(5, driver);
	}
}
