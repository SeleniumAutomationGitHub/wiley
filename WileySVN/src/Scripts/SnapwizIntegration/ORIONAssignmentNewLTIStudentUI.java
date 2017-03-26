package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentNewLTIStudentUI {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentNewLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentNewLTIStudentUI(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void bbNewLTIStudent_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentStudentUI-bbNewLTIStudent_Prerequisite", dataMap);				
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
			
		//Login as Student
		BlackBoardIntegrationPage blackBoardIntegrationPage =home.BBStudentLogin(dataMap);
		
		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		
				
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
		
		//attempt the assignment
		attemptAssignment_StudentUI(dataMap);
	}		
	
	public void attemptAssignment_StudentUI(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentStudentUI>attemptAssignment_StudentUI", driver);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);
				
		//Click "Wiley plus" assignment link
		blackBoardIntegrationPage.goToWileyPlusAssignment();
		 
		//Go to student assignment page
		assignmentPage.goToStudentAssignmentPage();
		 
		//Select not attempted assignments
		studentAssignmentPage.selectBBNotAttemptedOrionAssignment(dataMap,"First Assignment");
		  
		//Validate orion dashboard course title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		  
		//Return to wiley plus view page
		snapwizOrionDashboardPage.returnToWPView();
		
		//Validate orion assignments attempted
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "First Assignment");
		
		//Validate orion assignments not attempted
		studentAssignmentPage.validateOrionAssignmentsNotAttempted(dataMap, "Second Assignment");
		
		//Return to blackboard
		studentAssignmentPage.returnToBlackboard();
		
		driver = blackBoardIntegrationPage.getDriver();
	}


	/***********************************Test Case E4-5496: SW Int. New LTI. Student UI - Gradebook**********************************************************/
	/*********************************TODO:PENDING
	@Test
	public void E4_5496 ()  throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "ORIONModifyAssignment>E4_5496", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
						
		//Select gradebook
		blackBoardIntegrationPage.clickGradebook();
		  
		StudentGradeBookPage studentGradeBookPage =   blackBoardIntegrationPage.validateBBStudentGradebookPage();
		  
		//Click the First Assignment Link
		AssignmentResultsPage assignmentResultPage=studentGradeBookPage.selectAssignmentGradeBook(dataMap, "First Assignment");
			
		//Verify the Assignment Name
		assignmentResultPage.verifyAssignmentName();
			
		//verify the Assignment Type
		assignmentResultPage.verifyAssignmentType();
			
		//Verify the Start and Due date
		assignmentResultPage.verifyStartandDueDate();
			
		//Verify the Complete Status
		assignmentResultPage.verifyCompleteStatus();
			
		//Click GradeBookBreadCrumb
		assignmentResultPage.clickGradeBookBreadCrumb();
			
		//Click Second Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "Second Assignment");
			
		//Verify the Assignment Name
		assignmentResultPage.verifyAssignmentName();
			
		//verify the Assignment Type
		assignmentResultPage.verifyAssignmentType();
			
		//Verify the Start and Due date
		assignmentResultPage.verifyStartandDueDate();
			
		//Verify the Complete Status
		assignmentResultPage.verifyCompleteStatus();
				
		//Click BreadCrumb GradeBook
		assignmentResultPage.clickGradeBookBreadCrumb();
			 
		//Clear Cookies
		Browser.clearAllCookies(driver);
			 
		//Close Drivers
		Browser.closeDriver(driver);
		  
	}********************************************/
	
}
