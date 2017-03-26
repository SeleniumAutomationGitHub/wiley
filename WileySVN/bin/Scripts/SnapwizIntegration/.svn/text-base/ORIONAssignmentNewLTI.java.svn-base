package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.GradeBookPage;
import Pages.Common.StudentHomepage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.BBPublicContentPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentNewLTI {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentNewLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentNewLTI(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void bbCourseContent_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentNewLTI-bbCourseContent_Prerequisite", dataMap);
	}	
	
	@Test
	public void bbCourseLogin() throws Exception
	{		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		
		//Login as instructor 
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		
		
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
		
		driver= blackBoardIntegrationPage.getDriver();
	}
	
	@Test
	public void assignOrionAssignments_Prerequisite() throws Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>assignOrionAssignments_Prerequisite", driver);		
						
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		//Login as instructor 
		blackBoardIntegrationPage.BBInstructorLogin(dataMap);
		
		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		
		
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
		
		//Click wileyplus assignments link
		AssignmentPage	assignmentPage=blackBoardIntegrationPage.goToWileyPlusAssignment();		
		
		//Validating ORION assignment in the assignment list
		assignmentPage.validateOrionAssignments();
		
		//Assign the assignments
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
		
		//clear cookies
		Browser.clearAllCookies(driver);
		
		//close driver
		Browser.closeDriver(driver);
	}
	
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
	}
	
	/******************************************** Test Case E4-5491: SW Int. New LTI. Instructor UI - Assignments List***********************************************/	
	/********************************************TODO: PENDING
	public void E4_5491 ()  throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>E4_5491", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		 
		//Click wileyplus assignments link
		blackBoardIntegrationPage.goToWileyPlusAssignment();
		
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
		
		//Return to Blackboard page
		orionAssignmentPropertiesPage.returnToBlackboard();
		
		//Select Wileyplus home page link
		CourseHomePage courseHomePage = blackBoardIntegrationPage.selectWPHomePageLink();
		
		//Validate the wiley plus course home screen
		courseHomePage.OrioncourseHomeScreen();
		
		//Go to assingnment page
		courseHomePage.goToOrionAssigmentPage();
		
		//Get the assignment list page
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		//Validating ORION assignment in the assignment list
		intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
		
		//Validate the options in Actions dropdown for ORION assignments
		assignmentPage.validateOrionActionDropdown(intOrionAssignmentValue);
		
		//Select properties in the action dropdown.
		orionAssignmentPropertiesPage = assignmentPage.selectActionsByProperties("Properties", intOrionAssignmentValue);
		
		//Validating Assignment properties - assignment description page.
		orionAssignmentPropertiesPage.validateAssignmentDescription();
		
		//Validating Assignment properties - Class section page.
		orionAssignmentPropertiesPage.validateClassSectionAssignment();
		
		//Validating Assignment properties -Buttons
		orionAssignmentPropertiesPage.ValidateButtonDisplay();
		
		//Return to Blackboard page
		orionAssignmentPropertiesPage.returnToBlackboard();
		
		driver = blackBoardIntegrationPage.getDriver();
	}***************************************/
	
	/******************************************** Test Case E4-5492: SW Int. new LTI. Instructor UI - Assign Assignment***********************************************/
	/********************************************TODO:PENDING
	public void E4_5492 () throws MalformedURLException, Exception
	{	
		
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>E4_5492", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);	
		
		//Click wileyplus assignments link
		blackBoardIntegrationPage.goToWileyPlusAssignment();
		
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
				
		//Select the assignment using "Assign" option
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign", assignmentPage.validateOrionAssignments(), dataMap);	
				
		//Assign orion page
		assignOrionPage.assignBBOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);
				
		//Select the assignment using "Edit Availability" option
		assignmentPage.selectActionsByEditAvailability("Edit Availability", assignmentPage.validateOrionAssignments(), dataMap);
	
		//Edit due date
		assignOrionPage.editDateAssignOrionAssignment(dataMap);
		
		//Select the assignment using unassign option
		assignmentPage.selectActionsByUnassign("Unassign", assignmentPage.validateOrionAssignments(), dataMap);
		
		//Validate the warning message
		assignmentPage.unassignedWarningMessage();	
		
		//Return to Blackboard page
		assignmentPage.returnToBlackboard();
		
		//Select Wileyplus home page link
		courseHomePage = blackBoardIntegrationPage.selectWPHomePageLink();
				
		//Validate the wiley plus course home screen
		courseHomePage.OrioncourseHomeScreen();
				
		//Go to assingnment page
		courseHomePage.goToOrionAssigmentPage();
		
		//Get the assignment list page
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
				
		//Select the assignment using "Assign" option
		assignOrionPage =assignmentPage.selectActionsByAssign("Assign", assignmentPage.validateOrionAssignments(), dataMap);	
				
		//Assign orion page
		assignOrionPage.assignBBOrionAssignment(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);
				
		//Select the assignment using "Edit Availablilty" option
		assignmentPage.selectActionsByEditAvailability("Edit Availability", assignmentPage.validateOrionAssignments(), dataMap);
	
		//Edit due date
		assignOrionPage.editDateAssignOrionAssignment(dataMap);
		
		//Select the assignment using unassign option
		assignmentPage.selectActionsByUnassign("Unassign", assignmentPage.validateOrionAssignments(), dataMap);
		
		//Validate the warning message
		assignmentPage.unassignedWarningMessage();			
		
		//Return to Blackboard page
		assignmentPage.returnToBlackboard();		
		
		driver = blackBoardIntegrationPage.getDriver();
				
	}************************/
	
	/******************************************** Test Case E4-5494: SW Int. New LTI. Student View - Assignment Access******************************************/
	/********************************************TODO:PENDING
	public void E4_5494()  throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "ORIONModifyAssignment>E4_5494", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);	
		
		//As a preconditions, assign orion assignments 
		assignOrionAssignments_Prerequisite();
		
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
		
		//Return to Blackboard page
		studentAssignmentPage.returnToBlackboard();
		
		//Select Wileyplus home page link
		courseHomePage = blackBoardIntegrationPage.selectWPHomePageLink();
						
		//Validate the wiley plus course home screen
		courseHomePage.OrioncourseHomeScreen();
						
		//Go to assingnment page
		courseHomePage.goToOrionAssigmentPage();
				
		//Click Student view button
		assignmentPage.goToStudentView();
		
		//Choose class section
		studentHomepage = studentViewChooseClassSection.chooseClassSection(dataMap);
		
		//Go to student view assignment tab
		studentAssignmentPage = studentHomepage.goToStudentViewAssignmentTab();
		
		//Select not attempted assignmetns
		snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"Second Assignment");
		
		//Navigate to Orion Dashboard page
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
				
		//Return to Wiley plus student view page
		snapwizOrionDashboardPage.returnToWPView();
		
		//Validate the attempted Assignment
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap,"Second Assignment");
		
		//Return to Blackboard page
		studentAssignmentPage.returnToBlackboard();
		
		driver = blackBoardIntegrationPage.getDriver();
	}********************************************/
	
	/******************************************** Test Case E4-5497: SW Int. New LTI. Instructor UI - Gradebook. wp4-gradebook**********************************************/
	/********************************************TODO: PENDING
	 	public void E4_5497()  throws MalformedURLException, Exception	 
		{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>E4_5497", driver);
		
		//Assign Orion assignments
		assignOrionAssignments_Prerequisite();
		
		//Attempt the assignments via student view
		attemptAssignment_StudentView(dataMap);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		//Click Gradebook
		blackBoardIntegrationPage.clickGradebook();
		
		//Go to Gradebook page
		GradeBookPage gradeBookPage = blackBoardIntegrationPage.validateInstructorGradebookPage();
		
		//Click "Go" button
		gradeBookPage.showAllStudentsAssignment(dataMap);		
		
		//Select orion class section
		gradeBookPage.selectOrionClassSection(dataMap);
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");
		
		//Validate the orion assignments are displayed and validate each assignments
		//gradeBookPage.validateOrionAssignments();
		
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
		gradeBookPage.clickBBGradeBookBreadCrumb();
		
		//Click Printer version button
		gradeBookPage.clickPrinterVersion();
		
		//Validate the printer page
		gradeBookPage.validatePrinterPage(dataMap);
		
		//Switch to parent window
		gradeBookPage.switchBackToParentWindow();

		//Click Export Grades button
		gradeBookPage.clickBBExportGrades();		
		
		//Return to Blackboard page
		gradeBookPage.returnToBlackboard();		
		
		driver = blackBoardIntegrationPage.getDriver();

	}*******************************************/
	
	/******************************************** Test Case E4-5498: SW Int. New LTI. Instructor UI - Gradebook. wp4-homepage**************************************************/
	/********************************************TODO: PENDING
	@Test
	public void E4_5498 ()  throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>E4_5498", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);	
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
		
		//Assign Orion assignments
		assignOrionAssignments_Prerequisite();
		
		//Attempt the assignments via student view
		attemptAssignment_StudentView(dataMap);
				
		//Click "Wileyplus home page" link
		courseHomePage =blackBoardIntegrationPage.selectWPHomePageLink();
		 
		//Go to Gradebook page
		gradeBookPage =  courseHomePage.goToOrionGradebookPage();
		 
		//Click "Go" button
		gradeBookPage.showAllStudentsAssignment(dataMap);		
		
		//Select orion class section
		gradeBookPage.selectOrionClassSection(dataMap);
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");
		
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
		gradeBookPage.clickBBGradeBookBreadCrumb();
		
		//Click Printer version button
		gradeBookPage.clickBBPrinterVersion();
		
		//Validate the printer page
		gradeBookPage.validateBBPrinterPage(dataMap);

		//Switch to parent window
		gradeBookPage.switchBackToParentWindow();

		//Click Export Grades button
		gradeBookPage.clickBBExportGrades();		
		
		//Return to Blackboard page
		gradeBookPage.returnToBlackboard();
		
		driver = blackBoardIntegrationPage.getDriver();
	}**********************************/
	
	/******************************************** Test Case E4-5499: SW Int. New LTI. Instructor UI - Gradebook. wp4-studentGrades*******************************************/	
	/********************************************TODO: PENDING************
	@Test
	public void E4_5499 (Map<String,String> dataMap)  throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>E4_5499", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
		
		//Assign Orion assignments
		assignOrionAssignments_Prerequisite();
		
		//Attempt the assignments via student view
		attemptAssignment_StudentView(dataMap);
								
		//Select tools link
		blackBoardIntegrationPage.tools();
		 
		//Select wileyplus link
		blackBoardIntegrationPage.wileyplus();
		
		//click "wiley roster info" link
		blackBoardIntegrationPage.wileyRosterinfo();
		
		//Select student roster page
		gradeBookPage = blackBoardIntegrationPage.selectStudentWileyplusRoster(dataMap);
		
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
		
		//Return to Blackboard page
		gradeBookPage.returnToBlackboard();

	}	**********************************/
	
	/********************************************Test Case E4-5500: SW Int. ORION Assignments. New LTI. GetWileyPlusItems******************************************/	
	@Test
	public void E4_5500 ()  throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "ORIONAssignmentNewLTI>E4_5500", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				   
		//Select public content
		BBPublicContentPage bbPublicContentPage =   blackBoardIntegrationPage.clickPublishContent();
		   
		//Select reading and assignments
		bbPublicContentPage.selectReadingsAndAssignments();
		   
		//Click add wileyplus assignments
		bbPublicContentPage.selectAddWileyplusAssignments();
		   
		//Validate orion assignments
		bbPublicContentPage.validateOrionAssignment();
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
	}

}	

		
		
		
			
		
			
	
		
		
	
		
		  
		
		
	

