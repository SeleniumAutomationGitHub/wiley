package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.AngelCourseLoginPage;
import Pages.Common.GradeBookPage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.AngelHomePage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentsAngelStudent {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="AngelAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentsAngelStudent(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	/****************************TODO:PENDING
	@Test
	public void angel_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentAngelStudentUI-angel_Prerequisite", dataMap);
		
		//Assign assignments
		assignAssignmentsAngel_Prerequisite(dataMap,Prerequsite.configMap);
		
		//Attempt the assignments
		attemptAssignmentsAngel_Prerequisite(dataMap,Prerequsite.configMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strANGEL_URL=Prerequsite.configMap.get(strEnv+".ANGEL_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strANGEL_URL);
	}
	
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
		
		//Assign assigments
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
		
		//Validate not attempted
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
	}***********************************/

	/***************************************Test Case E4-5522: SW Int. Angel. Instructor UI - Gradebook**********************************************/
	/**************************************TODO:PENDING
	@Test
	public void E4_5522() throws Exception
	{
		AngelCourseLoginPage	angelLoginPage = PageFactory.initElements(driver, AngelCourseLoginPage.class);
		AngelHomePage	angelHomePage = PageFactory.initElements(driver, AngelHomePage.class);
		angelHomePage = angelLoginPage.angelInstructorLogin(dataMap);
		
		//Validate the home page
		angelHomePage.angelHomePage();
		
		//Select the angel course
		angelHomePage.selectAngelcourse(dataMap);
		
		//Select lesson tab
		angelHomePage.selectLessonTab();
		
		//Select Gradebook link
		angelHomePage.selectGradebookLink();
		
		//Switch to window
		angelHomePage.switchToWindow();
		
		//Angel instructor gradebook page
		GradeBookPage gradeBookPage = angelHomePage.angelInstructorGradebookPage();
		
		//Click "Go" button
		gradeBookPage.showAllStudentsAssignment(dataMap);		
		
		//Select orion class section
		gradeBookPage.selectOrionClassSection(dataMap);
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
		
		//Click Assignment Name Link
		gradeBookPage.selectOrionAssignment(dataMap, "First Assignment");
				
		//Verify Complete Status
		gradeBookPage.verifyCompleteStatus();
		
		//Verify Assignment Type
		gradeBookPage.verifyAssignmentType();
		
		//Verify Assignment Name
		gradeBookPage.verifyAssignmentName();
		
		//Verify Due and Start Date
		gradeBookPage.verifyStartandDueDate();

		//Click "Result of" link
		gradeBookPage.resultsbreadcrumb();
		
		//Click Second Assignment Name Link
		gradeBookPage.selectOrionAssignment(dataMap,"Second Assignment");
		
		//Verify Complete Status
		gradeBookPage.verifyCompleteStatus();
		
		//Verify Assignment Type
		gradeBookPage.verifyAssignmentType();
		
		//Verify Assignment Name
		gradeBookPage.verifyAssignmentName();
		
		//Verify Due and Start Date
		gradeBookPage.verifyStartandDueDate();
		
		//Click BreadCrumb GradeBook
		gradeBookPage.clickGradeBookBreadCrumb();
		
		//Click Printer version button
		gradeBookPage.clickPrinterVersion();
		
		//Validate the printer page
		gradeBookPage.validatePrinterPage(dataMap);

		//Click Export Grades button
		gradeBookPage.clickExportGrades();		
		
		//Close the Gradebook window driver
		Browser.closeDriver(driver);
		
		angelHomePage.switchBackToParentWindow();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);
	}****************************/

	/*********************************Test Case E4-5523: SW Int. Angel. Student UI - Gradebook*****************************************************/
	/********************************TODO:PENDING
	@Test
	public void E4_5523() throws Exception
	{
		AngelCourseLoginPage	angelLoginPage = PageFactory.initElements(driver, AngelCourseLoginPage.class);
		AngelHomePage	angelHomePage = PageFactory.initElements(driver, AngelHomePage.class);
		angelLoginPage.angelStudentLogin(dataMap);
		
		//Validate the home page
		angelHomePage.angelHomePage();
			
		//Select the angel course
		angelHomePage.selectAngelcourse(dataMap);
			
		//Select lesson tab
		angelHomePage.selectLessonTab();		 
		 
		//Select gradebook link
		angelHomePage.selectGradebookLink();
		 
		//Switch to  window
		angelHomePage.switchToWindow();
		 
		//Gradebook page
		StudentGradeBookPage studentGradeBookPage =  angelHomePage.angelStudentGradebookPage();
		 
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
		 
		//Close the Gradebook window driver
		Browser.closeDriver(driver);
			
		angelHomePage.switchBackToParentWindow();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
				
		//Close the driver
		Browser.closeDriver(driver);
	}***************************************/

}
