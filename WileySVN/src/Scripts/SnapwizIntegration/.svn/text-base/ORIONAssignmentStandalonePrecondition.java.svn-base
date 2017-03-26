package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentStandalonePrecondition {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentStandalonePrecondition(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	/****************************TODO: PENDING
	
	@Test
	public void assignAssignments_Prerequisite(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
		
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		//Select the course and reach course home page.
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		//Reach to assignments page.
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		assignmentPage.assignAssignments(dataMap);
		
		//Again assign the assignment as a precondition for another testcases
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign", dataMap, "First Assignment");
		
		//Assign orion page
		assignOrionPage.assignOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);	
		
		//Assign 2 assignments to validate the gradebook testcases - Preconditions
		assignmentPage.selectActionsByAssign("Assign",  dataMap, "Second Assignment");
				
		//Assign orion page
		assignOrionPage.assignBBOrionAssignment(dataMap);
						
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);	
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
	}
	
	@Test
	public void attemptAssignment_StudentUI() throws Exception
	{
		String strEnv=Prerequsite.configMap.get("ENV");
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
	 	driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
	 	
	 	//Login
	 	StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
	 	StudentHomepage studentHomepage = PageFactory.initElements(driver, StudentHomepage.class);
	 	SnapwizOrionDashboardPage snapwizOrionDashboardPage = PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
		studentHome.loginPage(dataMap);
	 		
		//Reach to assignments page.
		StudentAssignmentPage	studentAssignmentPage = studentHomepage.goToAssignment();
		
		studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap, "First Assignment");
		
		//Validate orion dashboard course title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		  
		//Return to wiley plus view page
		snapwizOrionDashboardPage.returnToWPView();
		
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "First Assignment");
		
		studentAssignmentPage.validateOrionAssignmentsNotAttempted(dataMap, "Second Assignment");
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
	}***************/
}
