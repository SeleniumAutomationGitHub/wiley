package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.LMSIntegration.InstructorPage;
import Pages.LMSIntegration.StudentPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentOldLTIPrecondition {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentOldLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentOldLTIPrecondition(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void d2l_Prerequisite() throws Exception
	{		
		ResultUtil.createReport("ORIONAssignmentOldLTI-d2l_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strLMS_URL=Prerequsite.configMap.get(strEnv+".LMS_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strLMS_URL);
	}
	/********************************TODO: PENDING
	@Test
	public void assignAssignmentsD2L_Prerequisite(Map<String,String> dataMap, Map<String,String>  configMap ) throws Exception
	{
		InstructorPage instructor =PageFactory.initElements(driver, InstructorPage.class);
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		AssignOrionPage assignOrionPage = PageFactory.initElements(driver, AssignOrionPage.class);
			
		//Create a Instructor login
		instructor=instructor.instructorLogin(dataMap);
			
		//select a "WP QA Hoboken Regression Testing Section
		instructor.selectCourseName(dataMap);
		
		//Select content link
		instructor.selectContentLink();
		
		instructor.switchToWindow();		
		
		//Go to Assignment table
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		//Validating ORION assignment in the assignment list
		assignmentPage.validateOrionAssignments();
		
		assignmentPage.assignAssignments(dataMap);
		
		//Again assign the assignment as a precondition for another testcases
		assignOrionPage =assignmentPage.selectActionsByAssign("Assign",  dataMap, "First Assignment");	
		
		//Assign orion page
		assignOrionPage.assignOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);		
		
		//Assign 2 assignments to validate the gradebook testcases - Preconditions
		assignmentPage.selectActionsByAssign("Assign",  dataMap, "Second Assignment");
		
		//Assign orion page
		assignOrionPage.assignOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);	
		
		//Close the assignment window
		Browser.closeDriver(driver);
		
		instructor.switchBackToParentWindow();
		
		//Close the main d2L window
		Browser.closeDriver(driver);
	}
	
	@Test
	public void attemptAssignmentsD2L_Prerequisite(Map<String,String> dataMap, Map<String,String>  configMap)
	{
		
		//Get login class
		StudentPage home=PageFactory.initElements(driver, StudentPage.class);
		
		//creating new object for student login
		StudentPage studentPage=home.studentLogin(dataMap);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentPage.selectCourseName(dataMap);
		
		//Select the content link in student login
		studentPage.selectContentLink();
		
		//Navigate to assignment link
		StudentAssignmentPage studentAssignmentPage = studentPage.selectStudentSnapwizAssignmentLinkUnit(dataMap);
		
		//Switch to window handle
		studentPage.switchToHandleWindows();
				 
		//select not attempted assignments
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"First Assignment");
		 
		//Validate the orion dashboard
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
			
		//Validate the attempted Assignment
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "First Assignment");
		
		//Validate the not attempted assignment
		studentAssignmentPage.validateOrionAssignmentsNotAttempted(dataMap, "Second Assignment");
		 
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		 
		//Close the assignment window
		Browser.closeDriver(driver);
		 
		//Switch to parent window
		studentPage.switchToParentWindow();
		 
		//Clear cookies
		Browser.clearAllCookies(driver);
	 
		//close the main window
		Browser.closeDriver(driver);
	}********************************/
	
}
