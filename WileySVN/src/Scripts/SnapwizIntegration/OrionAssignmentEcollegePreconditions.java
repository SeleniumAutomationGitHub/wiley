package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.EcollegeLoginPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.EcollegeHomePage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class OrionAssignmentEcollegePreconditions {
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EcollegeAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public OrionAssignmentEcollegePreconditions(Map<String,String> dataMap) {
		this.dataMap=dataMap;
	}
	
	@Test
	public void ecollegeLogin_Prerequisite(Map<String,String> dataMap )
	{
		ResultUtil.createReport("ORIONAssignmentsECollege-ecollege_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strECOLLEGE_URL=Prerequsite.configMap.get(strEnv+".ECOLLEGE_URL");
		
		//Launch URL				
		 driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strECOLLEGE_URL);
	}
	/**********************************TODO: PENDING
	
	@Test
	public void assignAssignmentsEcollege_Prerequisite(Map<String,String> dataMap) throws Exception
	{
		EcollegeLoginPage ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		EcollegeHomePage ecollegeHomePage = ecollegeLoginPage.eCollegeInstructorLogin(dataMap);
		AssignOrionPage assignOrionPage = PageFactory.initElements(driver, AssignOrionPage.class);
		//Validate the home page
		ecollegeHomePage.ecollegeHomePage();
		
		//Go to academinc PSH tab
		ecollegeHomePage.goToAcademicsPshTab();
		
		//Select any course
		ecollegeHomePage.selectCourse(dataMap);
		
		//Validate course home page
		ecollegeHomePage.validateCourseHomePage();
		
		//Go to Assignment page
		ecollegeHomePage.goToAssignmentPage();
		
		//Switch to assignment window
		ecollegeHomePage.switchtToWindow();
		
		//Validate ecollege assignment page
		AssignmentPage assignmentPage = ecollegeHomePage.eCollegeInstructorAssignmentPage();
		
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		assignOrionPage =assignmentPage.selectActionsByAssign("Assign",  dataMap, "First Assignment");
		
		assignOrionPage.assignOrionAssignment(dataMap);
		
		assignmentPage.validateAssignedAssignments(dataMap);	
		
		assignOrionPage =assignmentPage.selectActionsByAssign("Assign",  dataMap, "Second Assignment");
		
		assignOrionPage.assignOrionAssignment(dataMap);
		
		assignmentPage.validateAssignedAssignments(dataMap);	
		
		//Close the assignment window
		Browser.closeDriver(driver);
		
		ecollegeHomePage.switchBackToParentWindow();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//close the main window
		Browser.closeDriver(driver);		
	}
	
	@Test
	public void attemptAssignmentsEcollege_Prerequisite() throws InterruptedException
	{
		EcollegeLoginPage ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		EcollegeHomePage ecollegeHomePage = PageFactory.initElements(driver, EcollegeHomePage.class);
				
		ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		ecollegeHomePage =ecollegeLoginPage.eCollegeStudentLogin(dataMap);
		 
		//Validate the home page
		ecollegeHomePage.ecollegeStudentHomePage();
			
		//Go to academinc PSH tab
		ecollegeHomePage.goToAcademicsPshTab();
			
		//Select any course
		ecollegeHomePage.selectCourse(dataMap);
			
		//Validate course home page
		ecollegeHomePage.validateStudentsCourseHomePage();
			
		//Go to Assignment page
		ecollegeHomePage.goToAssignmentPage();
		 
		//Switch assignment window
		ecollegeHomePage.switchtToWindow();
		 
		//Student Assignment page
		StudentAssignmentPage studentAssignmentPage =  ecollegeHomePage.eCollegeStudentAssignmentPage();
		 
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
		 
		ecollegeHomePage.switchBackToParentWindow();
		 
		//Clear cookies
		Browser.clearAllCookies(driver);
	 
		//close the main window
		Browser.closeDriver(driver);
	}*********************************/
}
