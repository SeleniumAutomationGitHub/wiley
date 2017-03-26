package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.StudentHomepage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentNewLTIPreconditions {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentNewLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentNewLTIPreconditions(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	/*****************************TODO:PENDING
	
	@Test
	public void assignOrionAssignments_Prerequisite(Map<String,String> configMap) throws Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentStudentUI>assignOrionAssignments_Prerequisite", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		
		home.BBInstructorLogin(dataMap);
		
		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		
		
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
		
		//Click wileyplus assignments link
		blackBoardIntegrationPage.goToWileyPlusAssignment();		
		
		//Validating ORION assignment in the assignment list
		assignmentPage.validateOrionAssignments();
		
		//Assign assignments
		assignmentPage.assignAssignments(dataMap);
		
		//Again assign the assignment as a precondition for another testcases
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign",  dataMap, "First Assignment");	
		
		//Assign orion page
		assignOrionPage.assignBBOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);		
		
		//Assign 2 assignments to validate the gradebook testcases - Preconditions
		assignmentPage.selectActionsByAssign("Assign",  dataMap, "Second Assignment");
		
		//Assign orion page
		assignOrionPage.assignBBOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);	
		
		Browser.closeDriver(driver);
	}
	
	@Test
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
		
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "First Assignment");
		
		studentAssignmentPage.validateOrionAssignmentsNotAttempted(dataMap, "Second Assignment");
		
		studentAssignmentPage.returnToBlackboard();
		
		driver = blackBoardIntegrationPage.getDriver();
	}

	@Test
	public void attemptAssignment_StudentView(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>attemptAssignment_StudentView", driver);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		//Go to Student view
		StudentViewChooseClassSection studentViewChooseClassSection = assignmentPage.goToStudentView();
		
		//choose the class section
		StudentHomepage studentHomepage = studentViewChooseClassSection.chooseClassSection(dataMap);
		
		//go to Student assignment tab
		StudentAssignmentPage studentAssignmentPage = studentHomepage.goToStudentViewAssignmentTab();
		
		//select the not attempted question
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"First Assignment");
		
		//Navigate to Orion Dashboard page
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
				
		//Return to Wiley plus student view page
		snapwizOrionDashboardPage.returnToWPView();
		
		//Validate the attempted Assignment
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap,"First Assignment");
		
		//Validate the not attempted assignment
		studentAssignmentPage.validateOrionAssignmentsNotAttempted(dataMap,"Second Assignment");		
		
		studentAssignmentPage.returnToBlackboard();
		
		driver = blackBoardIntegrationPage.getDriver();
	}***************************/
}
