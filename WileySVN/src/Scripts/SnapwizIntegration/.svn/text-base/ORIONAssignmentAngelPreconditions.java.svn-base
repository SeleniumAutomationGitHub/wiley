package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.AngelCourseLoginPage;
import Pages.SnapwizIntegration.AngelHomePage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentAngelPreconditions {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="AngelAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentAngelPreconditions(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	/***************TODO:PENDING
	@Test
	public void assignAssignmentsAngel_Prerequisite(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{
		String strEnv=Prerequsite.configMap.get("ENV");
		String strANGEL_URL=Prerequsite.configMap.get(strEnv+".ANGEL_URL");
		
		//Launch URL				
		 driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strANGEL_URL);
		 
		 AngelCourseLoginPage angelLoginPage = PageFactory.initElements(driver, AngelCourseLoginPage.class);
		AngelHomePage angelHomePage = angelLoginPage.angelInstructorLogin(dataMap);
		
		//Validate the home page
		angelHomePage.angelHomePage();
		
		//Select the angel course
		angelHomePage.selectAngelcourse(dataMap);
		
		//Select lesson tab
		angelHomePage.selectLessonTab();
		
		//Select assignment link in lessons tab
		angelHomePage.selectAssignmentLink();
		
		//Switch to assignment window
		angelHomePage.switchToWindow();
		
		//Assignment page
		AssignmentPage assignmentPage = angelHomePage.angelInstructorAssignmentPage();
		
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		//Validating ORION assignment in the assignment list
		assignmentPage.validateOrionAssignments();
		
		//Assign assignments
		assignmentPage.assignAssignments(dataMap);
		
		//Again assign the assignment as a precondition for another testcases
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign",  dataMap, "First Assignment");	
		
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
		
		//go to main window
		angelHomePage.switchBackToParentWindow();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//close the main window
		Browser.closeDriver(driver);
	}
	
	@Test
	public void attemptAssignmentsAngel_Prerequisite(Map<String,String> dataMap, Map<String,String> configMap) throws InterruptedException
	{
		String strEnv=Prerequsite.configMap.get("ENV");
		String strANGEL_URL=Prerequsite.configMap.get(strEnv+".ANGEL_URL");
				
		//Launch URL				
		 driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strANGEL_URL);
		 AngelCourseLoginPage angelLoginPage = PageFactory.initElements(driver, AngelCourseLoginPage.class);
		 		 
		 AngelHomePage angelHomePage = angelLoginPage.angelStudentLogin(dataMap);
		
		//Validate the home page
		angelHomePage.angelHomePage();
			
		//Select the angel course
		angelHomePage.selectAngelcourse(dataMap);
			
		//Select lesson tab
		angelHomePage.selectLessonTab();		 
		
		//Select assingment link in lessons tab
		angelHomePage.selectAssignmentLink();
		
		//Switch to  window
		angelHomePage.switchToWindow();
		
		//Return to student assignment page
		StudentAssignmentPage studentAssignmentPage =  angelHomePage.angelStudentAssignmentPage();		 
		 
		//select not attempted assignments
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"First Assignment");
		 
		//Validate the orion dashboard
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
			
		//Validate the attempted Assignment
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "First Assignment");
		
		studentAssignmentPage.validateOrionAssignmentsNotAttempted(dataMap, "Second Assignment");
		 
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		 
		//Close the assignment window
		Browser.closeDriver(driver);
		 
		angelHomePage.switchBackToParentWindow();
		 
		//Clear cookies
		Browser.clearAllCookies(driver);
	 
		//close the main window
		Browser.closeDriver(driver);
	}*********************************************/
}
