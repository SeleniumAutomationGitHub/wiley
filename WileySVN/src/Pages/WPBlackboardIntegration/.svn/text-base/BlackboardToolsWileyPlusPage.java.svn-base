package Pages.WPBlackboardIntegration;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Toolbox.Browser;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.Window;

public class BlackboardToolsWileyPlusPage {
	
	private final WebDriver driver;

@FindBy(how = How.XPATH, using = "//img[@alt='WileyPlus Logo']")
private WebElement elmntWileyPlusLogo;

@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
private WebElement elmntReturnBlackboard;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'Learn More about WileyPLUS')]")
private WebElement elmntLearnMoreLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Help & Support')]")
private WebElement elmntHelpAndSupportLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Grade Refresh')]")
private WebElement elmntWPGradeRefresh;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Content Refresh')]")
private WebElement elmntWPContentRefresh;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'Update WileyPLUS User Information')]")
private WebElement elmntUpdateWPUserInfo;

@FindBy(how = How.ID, using = "Go_To_Student_View")
private WebElement elmntStudentViewbtn;

@FindBy(how = How.NAME, using = "Cancel")
private WebElement elmntCancelbtn;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Assignments')]")
private WebElement elmntWPAssignmentLink;

@FindBy(how = How.XPATH, using = "//a[text()='System Announcements ']")
private WebElement elmntSystemAnnouncementsLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Read, Study & Practice')]")
private WebElement elmntWPReadStudyPracticeLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Gradebook')]")
private WebElement elmntWPGradebookLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Prepare & Present')]")
private WebElement elmntWPPreparePresentLink;


@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Class Section Info')]")
private WebElement elmntWPClassSectionInfoLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS System Announcements')]")
private WebElement elmntWPSystemannouncementsLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS System Announcements')]")
private WebElement elmntWPSysAnnounceLink;

@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Training & How-To')]")
private WebElement elmntWPTrainingLink;

//varibles
StringBuffer defaultOrderWileyLinks=new StringBuffer();
StringBuffer changeOrderWileyLinks=new StringBuffer();

public BlackboardToolsWileyPlusPage(WebDriver driver){
		this.driver=driver;
	}

	//Description:Validate the add content link in Tool link - Wiley plus link page
public void validateBBAddContentLink(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateBBAddContentLink", driver);
		switchcontentFrame();
		String strAddedContentLink = dataMap.get("AddContentName");
		Element.verify("Added link in Super admin", driver, "XPATH", "//h3//a[contains(text(),'"+strAddedContentLink+"')]");
		Sync.waitForSeconds(8, driver);		
		//Link.click("Added Content", driver.findElement(By.linkText("+strAddedContentLink+")), driver);
		Link.click("Added content", driver.findElement(By.xpath("//a[contains(text(),'"+strAddedContentLink+"')]")), driver);
		Sync.waitForSeconds(7, driver);				
	}
	
	//Description:Validate the edit content link in Tool link - Wiley plus link page
public void validateBBEditContentLink(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateBBEditContentLink", driver);
		switchcontentFrame();
		String strEditedContentLink = dataMap.get("EditContentName");
		Element.verify("Edited  link in Super admin", driver, "XPATH", "//h3//a[contains(text(),'"+strEditedContentLink+"')]");
		//Link.click("Edited Content", driver.findElement(By.linkText("+strEditedContentLink+")), driver);
		Link.click("Edited content", driver.findElement(By.xpath("//a[contains(text(),'"+strEditedContentLink+"')]")), driver);
		Sync.waitForSeconds(7, driver);				
	}
	
	//Description:Validate the wileyplus page
public void validateWileyplusPage()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateWileyplusPage", driver);
		switchcontainerFrame();
		Element.verify("Wileyplus Logo", elmntWileyPlusLogo, driver);	
	}
	
	//Description:Get the order of the wiley plus links
public void getDefaultWileyLinksOrder()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>getDefaultWileyLinksOrder", driver);
		switchcontentFrame();
		List<WebElement> wileyLinks= driver.findElements(By.xpath("//div[@id='tools']//div[@class='landingPageColumn twoCol']//li//a"));
		System.out.println(wileyLinks.size());
		for(WebElement link:wileyLinks)
		{
			String defaultLinks=link.getText();
			defaultOrderWileyLinks.append(defaultLinks);
			ResultUtil.report("REPORT", "Default order is added in buffer", driver);
		}
	}
	
	//Description:Get the change order of the wiley plus links
public void getChangeWileyLinksOrder()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>getChangeWileyLinksOrder", driver);
		switchcontentFrame();
		List<WebElement> wileyLinks= driver.findElements(By.xpath("//div[@id='tools']//div[@class='landingPageColumn twoCol']//li//a"));
		System.out.println(wileyLinks.size());
		for(WebElement link:wileyLinks)
		{
			String changeLinks=link.getText();
			changeOrderWileyLinks.append(changeLinks);
			ResultUtil.report("REPORT", "Default order is added in buffer", driver);
		}
	}
		
	//Description:verify the Wiley plus order names
public void validateBBWileyLinksOrder()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateBBWileyLinksOrder", driver);
		switchcontentFrame();
		if(defaultOrderWileyLinks.toString().equals(changeOrderWileyLinks.toString()))
		{
			ResultUtil.report("FAIL", "The Order has not changed after the order has changed in super admin page", driver);
		}
		else
		{
			ResultUtil.report("PASS", "The Order has changed after the order has changed in super admin page", driver);
		}
	}
	//Description:Click "Return to Blackboard" tab
public void returnToBlackboard(){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>returnToBlackboard", driver);
		switchcontainerFrame();
		if(Element.verify("Return to BB button", driver, "XPATH", "//ins[text()='Return to Blackboard']"))
		{
		Button.click("Return to Blackboard", elmntReturnBlackboard, driver);
		}
		Sync.waitForSeconds(7, driver);		
	}
	
	//Description:Validate the deleted content
public void validateDeletedContent(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateDeletedContent", driver);
		switchcontentFrame();
		String strEditedContentLink = dataMap.get("EditContentName");
		if(Element.verify("Added link in Super admin", driver, "XPATH", "//h3//a[contains(text(),'"+strEditedContentLink+"')]"))
		{
			ResultUtil.report("FAIL", "Deleted content is displayed in Blackboard", driver);
		}
		else
		{
			ResultUtil.report("PASS", "Deleted content is displayed in Blackboard", driver);
		}
	}
	
	//Description:Validate the Support tools link edited
public void validateSupportToolLinkEdited(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateSupportToolLinkEdited", driver);
		switchcontentFrame();
		String strEditedContentLink = dataMap.get("EditContentName");
		
		if(Element.verify("Edited support link in Super admin", driver, "XPATH", "//div[@id='supportTools']//div[@class='landingPageColumn twoCol']//li//a"))
		{
			Element.verify("Edited Support link", driver.findElement(By.xpath("//div[@id='supportTools']//div[@class='landingPageColumn twoCol']//li//a[contains(text(),'"+strEditedContentLink+"')]")), driver);
			ResultUtil.report("PASS", "Edited support tools link is displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Edited support tools link is not displayed", driver);
		}		
		Sync.waitForSeconds(7, driver);	
	}
	
	//Description:Validate Static BB url
public void validateStaticBBUrl(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateStaticBBUrl", driver);
		switchcontentFrame();
		String strEditedContentLink = dataMap.get("StaticEditLinkName");
		
		if(Element.verify("Edited support link in Super admin", driver, "XPATH", "//div[@id='supportTools']//div[@class='landingPageColumn twoCol']//li//a"))
		{
			Element.verify("Edited Support link", driver.findElement(By.xpath("//a[contains(text(),'"+strEditedContentLink+"')]")), driver);
			ResultUtil.report("PASS", "Edited support tools link is displayed", driver);
			Link.click("Click on link in tool", driver.findElement(By.xpath("//a[contains(text(),'"+strEditedContentLink+"')]")), driver);
			Sync.waitForSeconds(8, driver);
			validateStaticUrl(dataMap);
		}
		else
		{
			ResultUtil.report("FAIL", "Edited support tools link is not displayed", driver);
		}		
	}
	
	//Description:Validate the url
public void validateStaticUrl(Map<String,String> dataMap)
	{
		try{
			String strAdditionalWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(strAdditionalWindow);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateStaticUrl", driver);			
			Sync.waitForSeconds(10, driver);
			String strEditedUrl = dataMap.get("EditUrlChange");
			String strCurrentUrl = driver.getCurrentUrl();
		
			if(strEditedUrl.contains(strCurrentUrl))
				{
					ResultUtil.report("PASS", "Edited url  is displayed", driver);
				}
			else
				{
					ResultUtil.report("FAIL", "Edited url  is  not displayed", driver);
				}
		}
	}
	
	//Description:Switch to content frame
public void switchcontentFrame(){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>switchcontentFrame", driver);
		driver.switchTo().defaultContent();
		WebDriver myFrame = driver.switchTo().frame("contentFrame");
	}

	//Description:Switch to container frame
public void switchcontainerFrame(){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>switchcontainerFrame", driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		driver.switchTo().frame("container");
	}
	
	//Description:Validate Instructor links
public void validateContentDAInstructor(){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateContentDAInstructor", driver);
		switchcontentFrame();
		Element.verify("WileyPLUS Assignments", driver, "XPATH", "//a[contains(text(),'WileyPLUS Assignments')]");
		Element.verify("WileyPLUS Read, Study & Practice", driver, "XPATH", "//a[contains(text(),'WileyPLUS Read, Study & Practice')]')]");
		Element.verify("WileyPLUS Gradebook", driver, "XPATH", "//a[contains(text(),'WileyPLUS Gradebook')]");
		Element.verify("WileyPLUS Systems Announcement", driver, "XPATH", "//a[contains(text(),'WileyPLUS System Announcements')]");
		Element.verify("Learn about WileyPLUS", driver, "XPATH", "//a[contains(text(),'Learn More about WileyPLUS')]");
		Element.verify("WileyPLUS Grade Refresh", driver, "XPATH", "//a[contains(text(),'WileyPLUS Grade Refresh')]");
		Element.verify("WileyPLUS Content Refresh", driver, "XPATH", "//a[contains(text(),'WileyPLUS Content Refresh')]");
		Element.verify("WileyPLUS Prepare & Present", driver, "XPATH", "//a[contains(text(),'WileyPLUS Prepare & Present')]");
		Element.verify("WileyPLUS Course Administration", driver, "XPATH", "//a[contains(text(),'WileyPLUS Course Administration')]");
		Element.verify("WileyPLUS Class Section Info", driver, "XPATH", "//a[contains(text(),'WileyPLUS Class Section Info')]");
		Element.verify("Update WileyPLUS user Info", driver, "XPATH", "//a[contains(text(),'Update WileyPLUS User Information')]");
		Element.verify("WileyPLUS Help & Support", driver, "XPATH", "//a[contains(text(),'WileyPLUS Help & Support')]");		
	}
	
	//Description:Validate the tool links - Student login
public void validateStudentToolLinks()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateStudentToolLinks", driver);
		switchcontentFrame();
		Element.verify("Wileyplus training", driver, "XPATH", "//a[contains(text(),'WileyPLUS Training & How-To')]");
		Element.verify("Wileyplus Assignments", driver, "XPATH", "//a[contains(text(),'WileyPLUS Assignments')]");
		Element.verify("Wileyplus Read study practice", driver, "XPATH", "//a[contains(text(),'WileyPLUS Read, Study & Practice')]");
		Element.verify("Wileyplus Gradebook", driver, "XPATH", "//a[contains(text(),'WileyPLUS Gradebook')]");
		Element.verify("Wileyplus system announcements", driver, "XPATH", "//a[contains(text(),'WileyPLUS System Announcements')]");
		Element.verify("Wileyplus learn more", driver, "XPATH", "//a[contains(text(),'Learn More about WileyPLUS')]");
	}
	
	//Description:Click "Learn more about Wileyplus" link
public void selectLearnMoreWileyplus()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectLearnMoreWileyplus", driver);
		switchcontentFrame();
		Link.click("Learn more about wileyplus", elmntLearnMoreLink, driver);
		Sync.waitForSeconds(8, driver);
	}
	
	//Description:switch to Learn more window
public void swtichToLearnMoreWP()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>swtichToLearnMoreWP", driver);
		String strWindows = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("Learn more window", driver, strWindows);
		Element.verify("About wiley plus", driver.findElement(By.xpath("//h1[text()='About WileyPLUS']")), "About WileyPLUS", driver);		
		Browser.closeDriver(driver);
	}
	
	//Description:Click "Help and support" link
public void selectHelpAndSupport()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectHelpAndSupport", driver);
		switchcontentFrame();
		Link.click("Help and support", elmntHelpAndSupportLink, driver);
		Sync.waitForSeconds(8, driver);
	}
	
	//Description:switch to Learn more window
public void swtichToHelpAndSupport()
	{
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>swtichToHelpAndSupport", driver);
		
		//Switch to window
		String strWindows = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("WileyPLUS Blackboard Help", driver, strWindows);
		
		//Switch to frame
		driver.switchTo().defaultContent();
		WebDriver myFrame = driver.switchTo().frame("whPfset");
		myFrame = myFrame.switchTo().frame("topic");
		
		//Verify the element
		Element.verify("Blackboard/wileyplus", driver.findElement(By.xpath("//h1[text()='Welcome to Blackboard/WileyPLUS']']")), "Welcome to Blackboard/WileyPLUS", driver);
		
		//Validate Return to blackbboard and Student view button
		if(Element.verify("Return to blackboard", driver, "XPATH","//ins[text()='Return to Blackboard']")){
			ResultUtil.report("FAIL", "Return to blackboard is displayed", driver);
		}
		else
		{
			ResultUtil.report("PASS", "Return to blackboard is not displayed", driver);
		}
				
		if(Element.verify("Go To Student View", driver, "ID", "Go_To_Student_View")){
			ResultUtil.report("FAIL", "Go To Student View is displayed", driver);
		}
		else
		{
			ResultUtil.report("PASS", "Go To Student View is not displayed", driver);
		}
		
		Browser.closeDriver(driver);
	}
	//Description:Click "WileyPLUS Content Refresh" link
public void selectWPContentRefresh()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWPContentRefresh", driver);
			switchcontentFrame();
			Link.click("WileyPLUS Content Refresh", elmntWPContentRefresh, driver);
			Sync.waitForSeconds(8, driver);
		}
			
		//Description:Validate "WileyPLUS Content Refresh" page
public void validateWPContentRefresh()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateWPContentRefresh", driver);
			switchcontentFrame();
			Element.verify("WileyPLUS Content Refresh", driver, "XPATH", "//span[contains (text(),'WileyPLUS Content Refresh')]");
			if(Element.verify("Return to blackboard", driver, "XPATH","//ins[text()='Return to Blackboard']")){
				ResultUtil.report("FAIL", "Return to blackboard is displayed", driver);
			}
			else
			{
				ResultUtil.report("PASS", "Return to blackboard is not displayed", driver);
			}
					
			if(Element.verify("Go To Student View", driver, "ID", "Go_To_Student_View")){
				ResultUtil.report("FAIL", "Go To Student View is displayed", driver);
			}
			else
			{
				ResultUtil.report("PASS", "Go To Student View is not displayed", driver);
			}
		}
		
		
		//Description:Click "Update WileyPLUS user Information" link
public void selectUpdateWPuserInfo()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectUpdateWPuserInfo", driver);
			switchcontentFrame();
			Link.click("WileyPLUS Content Refresh", elmntUpdateWPUserInfo, driver);
			Sync.waitForSeconds(8, driver);
			try
			{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Sync.waitForSeconds(8, driver);
			}
			catch(Exception e)
			{
				
			}
		}
			
		//Description:Validate "Update WileyPLUS user Information" page
public void validateUpdateWPuserInfo()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateUpdateWPuserInfo", driver);
			try
			{
				driver.switchTo().defaultContent();
				WebDriver myFrame = driver.switchTo().frame("container");
			}
			catch(Exception e)
			{
				
			}
			Element.verify("Welcome to wiley plus", driver, "XPATH", "//h2[contains(text(),'Welcome to ')]");
			if(Element.verify("Return to blackboard", driver, "XPATH","//ins[text()='Return to Blackboard']")){
				ResultUtil.report("PASS", "Return to blackboard is displayed", driver);
			}
			else
			{
				ResultUtil.report("FAIL", "Return to blackboard is not displayed", driver);
			}
					
			if(Element.verify("Go To Student View", driver, "ID", "Go_To_Student_View")){
				ResultUtil.report("FAIL", "Go To Student View is displayed", driver);
			}
			else
			{
				ResultUtil.report("PASS", "Go To Student View is not displayed", driver);
			}
		}
		//Description:Click "WileyPLUS Grade Refresh" link
public void selectWPGradeRefresh()
{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWPGradeRefresh", driver);
			switchcontentFrame();
			Link.click("WileyPLUS Grade Refresh", elmntWPGradeRefresh, driver);
			Sync.waitForSeconds(8, driver);
}
		
		//Description:Validate "WileyPLUS Grade Refresh" page
public void validateWPGradeRefresh()
{
	ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateWPGradeRefresh", driver);
	switchcontentFrame();
	Element.verify("WileyPLUS Grade Refresh", driver, "XPATH", "//span[contains (text(),'WileyPLUS Grade Refresh')]");
	if(Element.verify("Return to blackboard", driver, "XPATH","//ins[text()='Return to Blackboard']")){
	ResultUtil.report("FAIL", "Return to blackboard is displayed", driver);
}
			else
			{
				ResultUtil.report("PASS", "Return to blackboard is not displayed", driver);
			}
			
			if(Element.verify("Go To Student View", driver, "ID", "Go_To_Student_View")){
				ResultUtil.report("FAIL", "Go To Student View is displayed", driver);
			}
			else
			{
				ResultUtil.report("PASS", "Go To Student View is not displayed", driver);
			}
		}	
		
		//Description:Cancel settings
public void cancelSettings()
		{
			ResultUtil.report("INFO", "BBPublicContentPage>cancelSettings",driver);
			switchcontentFrame();
			Button.click("Cancel", elmntCancelbtn, driver);
			Sync.waitForSeconds(7, driver);
			try
			{
				Alert alert  = driver.switchTo().alert();
				alert.accept();		
				Sync.waitForSeconds(7, driver);
			}
			catch(Exception e)
			{
				
			}
		}	
		
		//Description:Navigate to wiley plus assignment page - tools
public void selectWileyplusAssignmentLink()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusAssignmentLink", driver);
			switchcontentFrame();
			Link.click("WileyPlus Assignment", elmntWPAssignmentLink, driver);
			Sync.waitForSeconds(8, driver);
		}		
		
		//Description:Navigate to wiley plus assignment page - tools
public void selectWileyplusReadStudyPracticeLink()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusReadStudyPracticeLink", driver);
			switchcontentFrame();
			Link.click("WileyPlus Read Study Practice", elmntWPReadStudyPracticeLink, driver);
			Sync.waitForSeconds(8, driver);
		}		
		
		//Description:Navigate to wiley plus gradebook page - tools
public void selectWileyplusGradebookLink()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusGradebookLink", driver);
			switchcontentFrame();
			Link.click("WileyPlus Gradebook", elmntWPGradebookLink, driver);
			Sync.waitForSeconds(8, driver);
		}	
		//Description:Navigate to wiley plus Prepare Present page - tools
public void selectWileyplusPreparePresent()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusPreparePresent", driver);
			switchcontentFrame();
			Link.click("WileyPlus Prepare Present", elmntWPPreparePresentLink, driver);
			Sync.waitForSeconds(8, driver);
		}	

		
		//Description:Navigate to wiley plus  Class Section Info page - tools
public void selectWileyplusClassSectionInfo()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusClassSectionInfo", driver);
			switchcontentFrame();
			Link.click("WileyPlus Class Section Info", elmntWPClassSectionInfoLink, driver);
			Sync.waitForSeconds(8, driver);
		}	

		//Description:Navigate to wiley plus System announcements  page - tools
public void selectWileyplusSystemannouncements ()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusSystemannouncements", driver);
			switchcontentFrame();
			Link.click("WileyPlus Prepare Present", elmntWPSystemannouncementsLink, driver);
			Sync.waitForSeconds(8, driver);
		}	
		
//Description:Navigate to wiley plus SysAnnounceLink page - tools
public void selectWileyplusSysAnnounceLink()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusSysAnnounceLink", driver);
			switchcontentFrame();
			Link.click("WileyPlus System announcements", elmntWPSysAnnounceLink, driver);
			Sync.waitForSeconds(8, driver);
		}
				
	//Description:Navigate to wiley plus TrainingLink page - tools
public void selectWileyplusTrainingLink()
			{
				ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>selectWileyplusTrainingLink", driver);
				switchcontentFrame();
				Link.click("WileyPlus System announcements", elmntWPTrainingLink, driver);
				Sync.waitForSeconds(8, driver);
			}
	
	//Description:Validate the Support tools link edited in BB
public void validateSupportBBToolLinkEdited(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateSupportBBToolLinkEdited", driver);
		switchcontentFrame();
		String strEditedContentLink = dataMap.get("EditContentName");
		
		if(Element.verify("Edited support link in Super admin", driver, "XPATH", "//span[contains(text(),'"+strEditedContentLink+"')]"))
		{
			Element.verify("Edited Support link", driver.findElement(By.xpath("//span[contains(text(),'"+strEditedContentLink+"')]")), driver);
			ResultUtil.report("PASS", "Edited support tools link is displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Edited support tools link is not displayed", driver);
		}		
		Sync.waitForSeconds(7, driver);	
	}
	
	//Description:Validate Static BB url link in BB
public void validateStaticEditedBBUrl(Map<String,String> dataMap){
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateStaticEditedBBUrl", driver);
			try
			{
				driver.switchTo().defaultContent();
				driver.switchTo().frame("contentFrame");
			}
			catch(Exception e){}
			String strEditedContentLink = dataMap.get("StEditLinkName").trim();
			Sync.waitForObject(driver, "Edited Support link", "XPATH", "//li//a[contains(text(),'"+strEditedContentLink+"')]");
			if(Element.verify("Edited support link in Super admin", driver, "XPATH", "//li//a[contains(text(),'"+strEditedContentLink+"')]"))
			{
				Element.verify("Edited Support link", driver.findElement(By.xpath("//li//a[contains(text(),'"+strEditedContentLink+"')]")), driver);
				ResultUtil.report("PASS", "Edited support tools link is displayed", driver);
				Link.click("Click on link in tool", driver.findElement(By.xpath("//li//a[contains(text(),'"+strEditedContentLink+"')]")), driver);
				Sync.waitForSeconds(8, driver);
				validateStaticUrl(dataMap);
			}
			else
			{
				ResultUtil.report("FAIL", "Edited support tools link is not displayed", driver);
			}		
		}
}
