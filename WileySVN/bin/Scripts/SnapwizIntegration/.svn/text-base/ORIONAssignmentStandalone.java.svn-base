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
import Pages.Common.GradeBookPage;
import Pages.Common.HomePage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentStandalone {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentsStandalone",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentStandalone(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	public void ORIONAssignmentStandalone_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentStandalone_Prerequisite-validateORIONAssignmentStandaloneSuiteInstructor", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
				
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
		
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		//Select the course and reach course home page.
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		//Reach to assignments page.
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		driver = assignmentPage.getDriver();
	}
	
	/**************************************Test Case E4-5485: SW Int. Instructor UI - Assignments List*************************************/
	/*****************TODO:PENDING
	@Test
	public void E4_5485() throws Exception
	{
		AssignmentPage assignmentPage =PageFactory.initElements(driver, AssignmentPage.class);
		
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		//Validating ORION assignment in the assignment list
		int intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
		
		//Validate the options in Actions dropdown for ORION assignments
		assignmentPage.validateOrionActionDropdown(intOrionAssignmentValue);
		
		//Select properties in the action dropdown.
		ORIONAssignmentPropertiesPage orionAssignmentPropertiesPage = assignmentPage.selectActionsByProperties("Properties", intOrionAssignmentValue);
		
		//Validating Assignment properties - assignment description page.
		orionAssignmentPropertiesPage.validateAssignmentDescription();
		
		//Validating Assignment properties - Class section page.
		orionAssignmentPropertiesPage.validateClassSectionAssignment();
		
		//Validating Assignment properties -Buttons
		orionAssignmentPropertiesPage.ValidateButtonDisplay();
		
		//Navigate to assignment list page
		orionAssignmentPropertiesPage.gotoAssignmentList();
	}************/
	
	/**************************************Test Case E4-5486: SW Int. Instructor UI - Assign Assignment************************************/
	/**********************************TODO:PENDING
	@Test
	public void E4_5486() throws InterruptedException
	{
		AssignmentPage assignmentPage =PageFactory.initElements(driver, AssignmentPage.class);
		
		//Validating ORION assignment in the assignment list
		int intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
		
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
		
		//Select the assignment using "Assign" option
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign", intOrionAssignmentValue, dataMap);	
		
		//Assign orion page
		assignOrionPage.assignOrionAssignment(dataMap);
		
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);
		
		//Select the assignment using "Edit Availablilty" option
		assignmentPage.selectActionsByEditAvailability("Edit Availability", intOrionAssignmentValue, dataMap);
	
		//Edit due datae
		assignOrionPage.editDateAssignOrionAssignment(dataMap);
		
		//Select the assignment using unassign option
		assignmentPage.selectActionsByUnassign("Unassign", intOrionAssignmentValue, dataMap);
		
		//Validate the warning message
		assignmentPage.unassignedWarningMessage();
	}*******************/
	
	/**************************************Test Case E4-5488: SW Int. Student View - Assignment Access************************************/
	/*******************************TODO:PENDING
	@Test
	public void E4_5488(Map<String,String> dataMap, Map<String,String> configMap)
	{
		AssignmentPage assignmentPage =PageFactory.initElements(driver, AssignmentPage.class);
		
		//Click "Go to Student view" button
		StudentViewChooseClassSection studentViewChooseClassSection = assignmentPage.goToStudentView();
				
		//Select the class name in student view
		StudentHomepage studentHomepage = studentViewChooseClassSection.chooseClassSection(dataMap);
				
		//Navigate to assignment tab in the Student view page
		StudentAssignmentPage studentAssignmentPage = studentHomepage.goToStudentViewAssignmentTab();
				
		//Validate Not attempted Orion assignments
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"First Assignment");
				
		//Navigate to Orion Dashboard page
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
				
		//Return to Wiley plus student view page
		snapwizOrionDashboardPage.returnToWPView();
				
		//Validate the attempted Assignment
		studentAssignmentPage.validateAttemptedOrionAssignment(dataMap,"First Assignment");
				
		//Return to Wiley plus student view page
		snapwizOrionDashboardPage.returnToWPView();
				
		//Return to Instructor view		
		studentAssignmentPage.gotoInstructorViewPage();
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
	}*********************************/
	
	/**************************************Test Case E4-5489: SW Int. Instructor UI - Gradebook************************************/
	/***********************************TODO:PENDING
	@Test(dependsOnMethods={"E4_5488"})
	public void E4_5489(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
		
		//Go to gradebook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		
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
		gradeBookPage.clickWPGradeBookBreadCrumb();
		
		//Click Printer version button
		gradeBookPage.clickPrinterVersion();
		
		//Validate the printer page
		gradeBookPage.validatePrinterPage(dataMap);
		
		//Switch to parent window
		gradeBookPage.switchBackToParentWindow();

		//Click Export Grades button
		gradeBookPage.clickWPExportGrades();
		
		//Clear All Cookies
		Browser.clearAllCookies(driver);
		
		//Close the Browser
		Browser.closeDriver(driver);
	}***************************/
	
	/*************************************Test Case E4-5490: SW Int. Student UI - Gradebook*********************************************************/		
	/*************************TODO:PENDING
	@Test	
	public void E4_5490(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{	
			
		String strEnv=Prerequsite.configMap.get("ENV");
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
			
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
		
		//Login
		StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
	  	StudentHomepage studentHomepage = PageFactory.initElements(driver, StudentHomepage.class);
		studentHomepage=studentHome.loginPage(dataMap);		
		
		//Click gradeBook
		StudentGradeBookPage studentGradeBookPage=studentHomepage.goToGradeBook();
		
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
	}*****************************/
	
	/*****************************************Test Case E4-5487: SW Int. Student UI - Assignment Access ***************************************************/
	/********************************TODO:PENDING
	@Test
	public void E4_5487(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{	
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
		
       	driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
		
		//Login
       	StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
       	
       	StudentHomepage studentHomepage = PageFactory.initElements(driver, StudentHomepage.class);
       	
		studentHome.loginPage(dataMap);
	
		//Reach to assignments page.
		StudentAssignmentPage studentAssignmentPage = studentHomepage.goToAssignment();
		
		//Validate the unassigned orion assignments
		studentAssignmentPage.validateUnassignedAssignments(dataMap);
		
		//select not attempted assignments
		SnapwizOrionDashboardPage	snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"Second Assignment");
		
		//Validate the orion dashboard
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		
		//Validate the attempted Assignment
		studentAssignmentPage.validateAttemptedOrionAssignment(dataMap,"Second Assignment");
		 
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		 
		//Select another assignments
		studentAssignmentPage.selectAttemptedOrionAssignment(dataMap, "First Assignment");
		 
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		 
		//Close the assignment window
		Browser.closeDriver(driver);	
	}***********************/
	
}
