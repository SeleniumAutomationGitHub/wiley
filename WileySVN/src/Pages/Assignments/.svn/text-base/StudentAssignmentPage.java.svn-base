package Pages.Assignments;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.Common.CourseHomePage;
import Pages.Common.Initializer;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.Window;

public class StudentAssignmentPage extends Initializer {
	
	String strQtiPresentXpath="//table[@class='qti-presentation-feedback']";
	String strPlainTableXpath= "//table[contains(@class,'plain-table')]";
	String strReviewTotalScore= "//table[@id='selenium_review_score_table']";
	String strQuestionPresentation= "//div[@class='qti-presentation']//input";
	String strMaximumPointsXpath= "//span[@class='selenium_points_maximum']";
	String strQuestionAttempts= "//span[@class='selenium_question_attempts']";
	 

	@FindBy(how = How.ID, using = "Instructor_View")
	private WebElement elmntGotoInstructorViewbtn;
	
	@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
	private WebElement elmntReturnBlackboard;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Help']")
	private WebElement elmntHelpLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'System Announcements')]")
	private WebElement elmntSystemAnnouncementsLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Assignment')]")
	private WebElement gradeAssignmentBreadCrumb;
	
	public StudentAssignmentPage(WebDriver driver){
		super(driver);
	}
	
	//Description: Select Assignment from Assignment
	public  OpenAssignment selectAssignment(Map<String,String> dataMap, String strAssignment) {
		ResultUtil.report("INFO", "StudentAssignmentPage>>>OpenAssignment", driver);
		String strAssignmentNames = dataMap.get(strAssignment);
		
		Sync.waitForObject(driver,"Assignment Name", "XPATH",strPlainTableXpath+"//a[.='" + strAssignmentNames + "']");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);		
		Link.click("TestAutomation", selectAssignment, driver);
		
		return PageFactory.initElements(driver, OpenAssignment.class);
	}
	
	//Description: Validate the orion assignment page in student login
	public int validateUnassignedAssignments(Map<String,String> dataMap){
		int i=0;
		try
		{
			List<WebElement> elmntUnassignedOrionAssignments = driver.findElements(By.xpath(strPlainTableXpath+"//tr[./td//span[text()='ORION'] and .//span[contains(text(),'Not Attempted')]]"));
			for( i=1;i<elmntUnassignedOrionAssignments.size();i++)
			{
				WebElement elmntChooseChapter = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td//span[text()='ORION'] and .//span[contains(text(),'Not Attempted')]]["+i+"]/td[1]"));			
				ResultUtil.report("MESSAGE", elmntChooseChapter.getText(), driver);
				dataMap.put("Chapter Choosed", elmntChooseChapter.getText());
				break;
			}
		}
		catch(Exception e)
		{
			
		}
		return i;
	}
	
	//Description: Select ORION assignment in assigment tab of student view page 
	public SnapwizOrionDashboardPage selectNotAttemptedOrionAssignment(Map<String,String> dataMap, String strAssignmentType)
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>selectNotAttemptedOrionAssignment", driver);
		String strFirstAssignmentName=dataMap.get(strAssignmentType);			
		Sync.waitForObject(driver, "Assignment table", "XPATH", strPlainTableXpath+"//tr[./td//span[text()='ORION']]");
		List<WebElement> listOfAssignments = driver.findElements(By.xpath(strPlainTableXpath+"//tr[./td//span[text()='ORION']]"));
		listOfAssignments.size();

			if(Element.verify("Find Not attempted assignments", driver, "XPATH", strPlainTableXpath+"//tr[./td//span[text()='ORION'] and .//span[contains(text(),'Not Attempted')]]"))
			{
				ResultUtil.report("MESSAGE", "Not Attempted ORION assignment is displayed", driver);
				WebElement notAttemptedAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td//span[text()='ORION'] and .//span[contains(text(),'Not Attempted')]]/td[.='"+strFirstAssignmentName+"']"));
				ResultUtil.report("MESSAGE", notAttemptedAssignment.getText(), driver);
				Link.click("Click Not attempted Assignment", driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td//span[text()='ORION'] and .//span[contains(text(),'Not Attempted')]]/td[.='"+strFirstAssignmentName+"']/a")), driver);
				
			}
			else
			{
				ResultUtil.report("MESSAGE", "No not attempted ORION assignments displayed.", driver);
			}			
		return PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
	}
		
	
		
	//Description: Navigate to Instructor page
	public CourseHomePage gotoInstructorViewPage(){
		Button.click("Instructor", elmntGotoInstructorViewbtn, driver);
		
		return PageFactory.initElements(driver, CourseHomePage.class);
		
	}
		
	//Description: Validate Student Assignment page on product disable in super administrator
	public void studentAssignmentPageOnProductDisable(){
		List<WebElement> studentAssignmentList = driver.findElements(By.xpath(strPlainTableXpath+"//tr[.//span[.='ORION']]"));
		
		for(int i=1;i<=studentAssignmentList.size();i++)
		{
			
			WebElement orionAssignmentLink = driver.findElement(By.xpath(strPlainTableXpath+"//tr[.//span[.='ORION']]["+i+"]//a"));
			orionAssignmentLink.click();
			
			break;
		}
	}
		
	//Description: Alert warning message Orion disabled in product level
	public void alertWarningOnOrionProductDisabled()
	{
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);
		Assert.assertEquals(alert.getText(), "ORION has been disabled for this course. This assignment is currently unavailable.");
		driver.switchTo().alert().accept();	
	}
	
	private void BlackBoardFrames(){
		try
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("container")));
		}
		catch(Exception e)
		{
			
		}
		
	}
	//Description: Return to Blackboard page 
	public BlackBoardIntegrationPage returnToBlackboard(){
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>returnToBlackboard", driver);
		BlackBoardFrames();
		Button.click("Return to Blackboard", elmntReturnBlackboard, driver);
		
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
	}

	//Description: Validate wiley plus assignment homepage - Blackboard
	public void validateBBWPAssignmentPage()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>validateBBWPAssignmentPage", driver);
		BlackBoardFrames();
		if(Element.verify("Assignment", driver, "XPATH", "//li[text()='Assignment']"))
		{
			Element.verify("Assignment", driver, "XPATH", "//li[text()='Assignment']");			
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help link", elmntHelpLink, driver);
		}
	}
		
	//Description: Validate wiley plus Read Study homepage - Blackboard
	public void validateBBWPReadStudyPage()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>validateBBWPReadStudyPage", driver);
		BlackBoardFrames();
		String strReadStudyXpath= "//li[text()='Read, Study & Practice']";
		if(Element.verify("Read Study and practice", driver, "XPATH", strReadStudyXpath))
		{
			Element.verify("Read Study and practice", driver, "XPATH", strReadStudyXpath);
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help link", elmntHelpLink, driver);
		}
	}
		
	//Description: Validate wiley plus grade book - Blackboard
	public void validateBBWPGradebookPage()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>validateBBWPGradebookPage", driver);
		BlackBoardFrames();		
		if(Element.verify("Gradebook", driver, "XPATH", "//li[text()='Gradebook']"))
		{
			Element.verify("Gradebook", driver, "XPATH", "//li[text()='Gradebook']");
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help link", elmntHelpLink, driver);
			Element.verify("The gradebook link", driver, "XPATH", "//a[text()='The Gradebook']");
		}
	}
		
	//Description: Validate wiley plus grade book - Blackboard
	public void validateBBWPSysAnnouncements()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>validateBBWPSysAnnouncements", driver);
		BlackBoardFrames();
		
		String strSysAnnouncementsXpath="//span[text()='System Announcements']";
		if(Element.verify("SysAnnouncements", driver, "XPATH", strSysAnnouncementsXpath))
		{
			Element.verify("SysAnnouncements", driver, "XPATH", strSysAnnouncementsXpath);
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help link", elmntHelpLink, driver);					
		}
	}
	
	//Description: Validate wiley plus grade book - Blackboard
	public void validateBBWPTraining()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>validateBBWPTraining", driver);
		BlackBoardFrames();
		String strWPTrainingXpath= "//h1[text()='Welcome to Blackboard/WileyPLUS']";
		if(Element.verify("WPTraining", driver, "XPATH", strWPTrainingXpath))
		{
			Element.verify("WPTraining", driver, "XPATH", strWPTrainingXpath);
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
		}
	}
		
	//Description: Handling Windows
	public void handleWindows()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>handleWindows",driver);
		//Switch to another window
		String getWindow = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow(driver.getTitle(), driver, getWindow);
			
	}
		
	//Description: Validate wiley plus Total score - Blackboard
	public void validateBBWPTotalScorePage()
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>>>>>validateBBWPTotalScorePage", driver);
		BlackBoardFrames();
		String strReadStudyXpath= "//li[text()='Gradebook']";
		if(Element.verify("Read Study and practice", driver, "XPATH", strReadStudyXpath))
		{
			Element.verify("Read Study and practice", driver, "XPATH", strReadStudyXpath);
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help link", elmntHelpLink, driver);
			Element.verify("The gradebook link", driver, "XPATH", "//a[text()='The Gradebook']");
		}
	}
		
		
	//Description: Click GradeBook From BreadCrumb
    public void clickAssignmentBreadCrumb()
    {
    	
    	ResultUtil.report("INFO","StudentAssignmentPage >>> clickAssignmentBreadCrumb", driver);
    	driver.switchTo().defaultContent();
    	driver.switchTo().frame(0);    	
    	Link.verify("GradeBook Link in BreadCrumb",gradeAssignmentBreadCrumb, driver);
    	Link.click("GradeBook Link in BraedCrumb",gradeAssignmentBreadCrumb, driver);
    }
	
	//Validate the attempted first  assignments
	public void validateAttemptedOrionAssignment(Map<String,String> dataMap, String strAssignmentType)
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>validateAttemptedOrionAssignment", driver);
		String strAssignmentName=dataMap.get(strAssignmentType);						
		String strListAssignmentXpath= "//table[contains(@class,'plain-table')]//tr[./td//span[text()='ORION']]";
		List<WebElement> listOfAssignments = driver.findElements(By.xpath(strListAssignmentXpath));
		listOfAssignments.size();
		
		for(int i=1;i<listOfAssignments.size();i++)
		{
			if(Element.verify("Find attempted assignments", driver, "XPATH", strListAssignmentXpath+" and .//span[contains(text(),'Not Attempted')]]"))
			{
				ResultUtil.report("MESSAGE", " Attempted ORION assignment is displayed", driver);
				Link.click("Click  attempted Assignment", driver.findElement(By.xpath(strListAssignmentXpath+" and .//span[@class='textBlack' and contains(text(),'Attempted')]]/td[.='"+strAssignmentName+"']/a")), driver);
				
			}
			else
			{
				ResultUtil.report("MESSAGE", "No not attempted ORION assignments displayed.", driver);
			}
			break;
		}
	}
		
	//Description: Select attempted Assignment
	public SnapwizOrionDashboardPage selectAttemptedOrionAssignment(Map<String,String> dataMap, String strAssignmentType)
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>selectAttemptedOrionAssignment", driver);
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container Frame", "container", 6);			
		}
		catch(Exception e){}
		String strFirstAssignmentName=dataMap.get(strAssignmentType);		
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Frame index", 0, 6);
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		}
		catch(Exception e){}
		String strListAssignmentXpath= "//table[contains(@class,'plain-table')]//tr[./td//span[text()='ORION']]";
		List<WebElement> listOfAssignments = driver.findElements(By.xpath(strListAssignmentXpath));
		listOfAssignments.size();

			if(Element.verify("Find  attempted assignments", driver, "XPATH", strListAssignmentXpath+" and .//span[contains(text(),'Attempted')]]"))
			{
				ResultUtil.report("MESSAGE", " Attempted ORION assignment is displayed", driver);
				WebElement notAttemptedAssignment = driver.findElement(By.xpath(strListAssignmentXpath+" and .//span[contains(text(),'Attempted')]]/td[.='"+strFirstAssignmentName+"']"));
				ResultUtil.report("MESSAGE", notAttemptedAssignment.getText(), driver);
				Link.click("Click Attempted Assignment", driver.findElement(By.xpath(strListAssignmentXpath+" and .//span[contains(text(),'Attempted')]]/td[.='"+strFirstAssignmentName+"']/a")), driver);				
			}
			else
			{
				ResultUtil.report("MESSAGE", "No Attempted ORION assignments displayed.", driver);
			}			
		return PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
	}
		
	//Description: Select ORION assignment in assigment tab of student view page - for BB course
	public SnapwizOrionDashboardPage selectBBNotAttemptedOrionAssignment(Map<String,String> dataMap, String strAssignmentType)
	{
		ResultUtil.report("INFO", "StudentAssignmentPage>selectBBNotAttemptedOrionAssignment", driver);
		try
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("container");
		}
		catch(Exception e){}
		String strFirstAssignmentName=dataMap.get(strAssignmentType);	
		String strListAssignmentXpath= "//table[contains(@class,'plain-table')]//tr[./td//span[text()='ORION']]";
		Sync.waitForObject(driver, "Assignment table", "XPATH", strListAssignmentXpath);

		if(Element.verify("Find Not attempted assignments", driver, "XPATH", strListAssignmentXpath+" and .//span[contains(text(),'Not Attempted')]]"))
		{
			ResultUtil.report("MESSAGE", "Not Attempted ORION assignments are displayed", driver);
			String strNotAttemptedAssignmentXpath= "//table[contains(@class,'plain-table')]//tr[./td//span[text()='ORION'] and .//span[contains(text(),'Not Attempted')]]/td[.='"+strFirstAssignmentName+"']";
			WebElement notAttemptedAssignment = driver.findElement(By.xpath(strNotAttemptedAssignmentXpath));
			ResultUtil.report("MESSAGE", notAttemptedAssignment.getText(), driver);
			Link.click("Click Not attempted Assignment", driver.findElement(By.xpath(strNotAttemptedAssignmentXpath+"/a")), driver);
			
		}
		else
		{
			ResultUtil.report("MESSAGE", "No NOT Attempted ORION assignments are displayed.", driver);
		}			
		return PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
	}
		
	//Description: Validate the modify course mapping id process
	public void validateModifyAssignmentTab(Map<String,String> dataMap, String strAssignmentName)
	{
		ResultUtil.report("INFO","StudentAssignmentPage >>> validateModifyAssignmentTab",driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		String strAssignment = dataMap.get(strAssignmentName);
		if(Element.verify("Assignment attempt", driver, "XPATH", "//a[text()='"+strAssignment+"']"))
		{
			ResultUtil.report("PASS", "Assignment attempted is displayed even after the course mapping Id is modified", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Assignment attempted is not displayed even after the course mapping Id is modified", driver);
		}
	}
		
	//Description: Validate the delete course mapping id process
	public void validateDeleteAssignmentTab(Map<String,String> dataMap, String strAssignmentName)
	{
		ResultUtil.report("INFO","StudentAssignmentPage >>> validateDeleteAssignmentTab",driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		String strAssignment = dataMap.get(strAssignmentName);
		if(Element.notVerify("Assignment attempt", driver, "XPATH", "//a[text()='"+strAssignment+"']"))
		{
			ResultUtil.report("PASS", "Assignment attempted is displayed even after the course mapping Id is modified", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Assignment attempted is not displayed even after the course mapping Id is modified", driver);
		}
	}
	
	//Description: Handling Windows
		public void switchToParentWindows()
		{
			ResultUtil.report("INFO", "StudentAssignmentPage>switchToParentWindows",driver);
			this.driver.close();
			
			String getWindow = driver.getWindowHandles().toArray()[0].toString();
			Window.focusWindow(driver.getTitle(), driver, getWindow);
				
		}
		
		//Verify the orion assignment is attempted
		public void validateOrionAssignmentsAttempted(Map<String,String> dataMap, String strAssignmentType)
		{
			ResultUtil.report("INFO", "StudentAssignmentPage>validateOrionAssignmentsAttempted", driver);
			String strAssignmentName=dataMap.get(strAssignmentType);						
			String strListAssignmentXpath= "//table[contains(@class,'plain-table')]//tr[./td//span[text()='ORION']]";
			if(Element.verify("Find attempted assignments", driver, "XPATH", strListAssignmentXpath+" and .//span[@class='textBlack' and contains(text(),'Attempted')]]/td[.='"+strAssignmentName+"']/a"))
			{
				ResultUtil.report("PASS", "ORION Assignment is attempted", driver);				
			}
			else
			{
				ResultUtil.report("FAIL", "ORION Assignment is NOT attempted", driver);
			}			
		}	
		
		//Verify the orion assignment is not attempted
		public void validateOrionAssignmentsNotAttempted(Map<String,String> dataMap, String strAssignmentType)
		{
			ResultUtil.report("INFO", "StudentAssignmentPage>validateOrionAssignmentsNotAttempted", driver);
			String strAssignmentName=dataMap.get(strAssignmentType);						
			String strListAssignmentXpath= "//table[contains(@class,'plain-table')]//tr[./td//span[text()='ORION']]";	
			if(Element.verify("Find attempted assignments", driver, "XPATH", strListAssignmentXpath+" and .//span[@class='textBlack' and contains(text(),'Not Attempted')]]/td[.='"+strAssignmentName+"']/a"))
			{
				ResultUtil.report("PASS", "ORION Assignment is Not attempted", driver);				
			}
			else
			{
				ResultUtil.report("FAIL", "ORION Assignment is attempted", driver);
			}			
		}
}
