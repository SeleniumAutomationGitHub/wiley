package Scripts.Assignments;

import java.util.Map;

import mx4j.tools.config.DefaultConfigurationBuilder.Create;
import net.sourceforge.htmlunit.corejs.javascript.ast.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.CreateNewQuestionPage;
import Pages.Assignments.CreateQuestionPoolPage;
import Pages.Assignments.CreatingAssignmentHelpPage;
import Pages.Assignments.OpenAssignment;
import Pages.Assignments.StudentReadStudyPracticePage;
import Pages.Common.*;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.Common.GradeBookPage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.GradeBook.GradebookPreCondition;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.AssignmentsDataProviderUtil.staticProviderClass;


public class AssignmentInstructor 
{
	WebDriver driver=null;
	Map<String,String> dataMap =null;

	@Factory(dataProvider="AssignmentInstructor",dataProviderClass=staticProviderClass.class)
	public AssignmentInstructor(Map<String,String> dataMap){
		this.dataMap=dataMap;

	}
	@Test
	public void assignmentInstructorPrerequsite() throws Exception
	{

		ResultUtil.createReport("AssignmentInstructor-assignmentInstructorPrerequsite", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		driver =courseHomePage.goToAssigmentPage().getDriver();

	}

	/******Test Case E4-799: Assignments - AC - Q/E Assignment - Step 1. Symbols count limit***/	
	@Test
	public void E4_799() throws Exception 
	{

		ResultUtil.report("INFO", "AssignmentInstructor-E4_799", driver);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//verify Long Name Alert Message	
		createEditAssignmentPage.verifyLongAssignmentName(dataMap);

		//Verify Long ID Alert Message
		createEditAssignmentPage.verifyLongAssignmentID(dataMap);

		//Verify Long Description Alert Message
		createEditAssignmentPage.verifyLongDescription(dataMap);

		//Verify Long Assignment Name and ID Alert Message
		createEditAssignmentPage.verifyLongAssignmentNameAndID(dataMap);

		//Verify Long Assignment ID and Description Alert Message
		createEditAssignmentPage.verifyLongAssignmentIDAndDescription(dataMap);

		//Verify Long Assignment Name and Description Alert Message
		createEditAssignmentPage.verifyLongAssignmentNameAndDescription(dataMap);

		//Verify Long Assignment ID, Name and Description Alert Message
		createEditAssignmentPage.verifyLondIdNameAndDescription(dataMap);

		//Click Assigment Link
		createEditAssignmentPage.assignmentLink();

		driver = createEditAssignmentPage.getDriver();	
	}

	/*****Test Case E4-797: Assignments - AC - Q/E Assignment - Step 1. Required fields****/
	
	@Test
	public void E4_797() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_797", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		driver = assignmentPage.getDriver();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();		

		//Verifying Untitled Alert Message		
		createEditAssignmentPage.verifyAssignmentisUntitledAlert(dataMap);

		//Verify Assignment Id Empty Alert Message
		createEditAssignmentPage.verifyAssignmentIDEmptyAlert(dataMap);

		//Verify Assignment Name Untitled Alert Message 
		createEditAssignmentPage.verifyAssignmentUntitledAlert(dataMap);		

		//Click Assigment Link
		createEditAssignmentPage.assignmentLink();

		driver = createEditAssignmentPage.getDriver();

	}

	/**********Test Case E4-958: Assignments - AC - Q/E Assignment. "Creating an Assignment" link************/	
	/*******TO DO PENDING**
	@Test
	public void E4_958() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_958", driver);		

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		driver = assignmentPage.getDriver();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();				

		CreatingAssignmentHelpPage creatingAssignmentHelpPage=PageFactory.initElements(driver, CreatingAssignmentHelpPage.class);



		//Verify Creating Assignment Help Page title
		creatingAssignmentHelpPage.verifyCreateNewAssignmentTitle();

		//Verify Overview section in Creating Assignment Help Page
		creatingAssignmentHelpPage.verifyOverviewSection();

		//Verify Creating New Question in Creating Assignment Help Page
		creatingAssignmentHelpPage.verifyCreatingNewQuestion();

		//Verify Selecting Question/Resources in Creating Assignment Help Page
		creatingAssignmentHelpPage.verifySelectingQuestionsResources();

		//Verify Close Window 
		creatingAssignmentHelpPage.closingWindow();

		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();	

		driver = createEditAssignmentPage.getDriver();

	}***/

	/******Test Case E4-807: Assignments - AC - Q/E Assignment - Step 1. "Display to students" checkbox********/
	@Test
	public void E4_807() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_807", driver);	

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=PageFactory.initElements(driver, CourseSelectionPage.class);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DisplayID", "DisplayName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Description: Select Questions displayed in Select Question screen
		createEditAssignmentPage.selectQuestions();

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Description: Select Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Description: Select Question Policies in Set Question Policies screen
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to class button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Description: Select Class from the Select Assign to class screen
		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//openAssignment.alertDismiss();

		Browser.navigateURL(driver, strStudentURL);

		//Login Page
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "DisplayName");			

		//Verify the Description/Instructions is displayed in the assignment screen
		openAssignment.verifyDescription(dataMap);	

		Browser.navigateURL(driver, strURL);

		home.login(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		//Re-login as Instructor and selecting assignment list from Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//Description: Selecting Assignment and Editing the Assignment
		assignmentPage.selectActionsEditAssignment(dataMap, "DisplayName");

		assignmentPage.selectAssignmentGobutton(dataMap, "DisplayName");

		//Description: Un-check Display to Students Check box and click Next
		createEditAssignmentPage.unselectDisplayStudentCheckbox(dataMap);

		createEditAssignmentPage.selectNextButton();

		//Save and Exit the Edit Assignment Page
		createEditAssignmentPage.selectSaveAndExit();

		Browser.navigateURL(driver, strStudentURL);

		//Login Page
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "DisplayName");	

		//Verify the Description/Instructions is displayed in the assignment screen
		openAssignment.verifyDescription(dataMap);

		Browser.navigateURL(driver, strURL);

		home.login(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		driver=courseHomePage.goToAssigmentPage().getDriver();		

	}

	/**********Test Case E4-893: Assignments - AC - Q/E Assignment - Step 2. "Show per page" drop-down***********/
	@Test
	public void E4_893() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_893", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Question Screen Verifying the 10 questions displayed.		
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();		

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 20 questions displayed
		createEditAssignmentPage.selectTwentyQuestionPerPage(dataMap);

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 30 questions displayed
		createEditAssignmentPage.selectThirtyQuestionsPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 50 questions displayed
		createEditAssignmentPage.selectFiftyQuestionsPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 100 questions displayed
		createEditAssignmentPage.selectHundredQuestionPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying All questions displayed
		createEditAssignmentPage.selectAllQuestionPerPage(dataMap);

		//select go
		createEditAssignmentPage.selectGo();

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		createEditAssignmentPage.assignmentLink();	

		driver = assignmentPage.getDriver();

	}

	/****Test Case E4-1536: Assignments - AC - Q/E Assignment - Step 2. Multiselection menus*****/
	@Test
	public void E4_1536() throws Exception
	{
		ResultUtil.createReport("AssignmentInstructor-E4_1536", dataMap);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter assignment Name and ID
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//select Assignment link
		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();

	}

	/******Test Case E4-968: Assignments - AC - Q/E Assignment - Step 2 - Question preview. Question Assistance buttons*******/
	@Test
	public void E4_968() throws Exception 
	{
		ResultUtil.report("INFO", "AssignmenInstructor-E4_968", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select one question link for the preview
		createEditAssignmentPage.selectQuestionPreview(dataMap);

		//Select show solution button and verify the window
		createEditAssignmentPage.verifyShowSolutionButton(dataMap);

		//Select Link to Text button and verify the window
		createEditAssignmentPage.verifyLinktoText(dataMap);	

		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.selectSaveAndFindButton();

		//select Assignment link
		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();

	}

	/******Test Case E4-1538: Assignments - AC - Q/E Assignment - Step 2. Question search - intersection - 3 fields ********/
	@Test
	public void E4_1538() throws Exception 
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1538", driver);	

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		createEditAssignmentPage.selectNextButton();

		//Select one chapter, one section and one 
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneLevel();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one section, one level and one source
		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneLevel();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one Chapter, one Section and one Source
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		//Select one chapter, one level and one source
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneLevel();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();		

		//Verify the Chapter Menu present from the list
		createEditAssignmentPage.verifyChapterMenuPresent();

		//Verify the Section Menu if Present
		createEditAssignmentPage.verifySectionMenuPresent();

		//Verify the level Menu present from the list
		createEditAssignmentPage.verifySourceMenu();

		//Verify Source Menu present from the list
		createEditAssignmentPage.verifyLevelMenuPresent();

		createEditAssignmentPage.selectSaveAndFindButton();

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();		
	}

	/*******Test Case E4-956: Assignments - AC - Q/E Assignment - Step 2 - Question preview. Question Preview window******/
	@Test
	public void E4_956() throws Exception 
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_956", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);				
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select NonAlgorithmQuestion preview link
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		createEditAssignmentPage.clickCloseButton();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Select Algorithm Question preview window
		createEditAssignmentPage.selectAlgorithmQuestionPreview(dataMap);

		//close window 1
		createEditAssignmentPage.clickCloseButton();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();

	}

	/*****Test Case E4-1344: Assignments - AC - Q/E Assignment - Step 2. Question search - single selection******/
	@Test
	public void E4_1344() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstuctor-E4_1344", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select one Chapter from the list and verify the table
		createEditAssignmentPage.selectSingleChapter(dataMap);

		//Select level from the list and verify the table
		createEditAssignmentPage.selectSingleLevel(dataMap);

		//Select Source from the list and verify the table
		createEditAssignmentPage.selectSingleSource(dataMap);

		//Select Chapter, Level and Source from the list and verify the table
		createEditAssignmentPage.selectSingleChapterSingleLevelSingleSource(dataMap);

		//Description: Select Chapter, Level and Source from the list and Select Learn Objective from the dropdown
		createEditAssignmentPage.SelectLearningObjective(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();
	}

	/*****Test Case E4-881: Assignments - AC - Q/E Assignment - Step 2. Navigation buttons*****/
	@Test
	public void E4_881() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_881", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//Verify the Alert Message When no question selected
		createEditAssignmentPage.verifyAlertMessage(dataMap);

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select Questions from the displayed list
		createEditAssignmentPage.selectQuestions();

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Select Back button Navigate to Select Questions screen
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify the SelectQuestionScreen
		createEditAssignmentPage.verifySelectQuestiontab();

		//Select Back button to Navigate previous Page and Cancel the Assignment.
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify the Describe Assignment
		createEditAssignmentPage.verifyDescribeAssignmentTab();

		//Select Cancel button and navigate to Assignment page
		createEditAssignmentPage.selectCancelButton();

		//Verifying the assignment displayed
		assignmentPage.goToAssignmentList(dataMap);

		//Verify Assignment not Created
		assignmentPage.verifyAssignmentDisplayed(dataMap,"AsgntName");

		//Re- Select Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage();

		//Re-Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");
		createEditAssignmentPage.selectNextButton();

		//Re-Enter Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//Select go button
		createEditAssignmentPage.selectGo();

		//Re-Enter Select Questions from the displayed list
		createEditAssignmentPage.selectQuestions();

		//Select Save and Exit Button to navigate to main screen
		createEditAssignmentPage.selectSaveAndExit();	

		//Verify Assignment is Create
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		driver= assignmentPage.getDriver();	
	}	

	/*****Test Case E4-883: Assignments - AC - Q/E Assignment - Step 2. Page Navigator drop-down*******/	
	@Test
	public void E4_883() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_883", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select show per page
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);

		//select go button
		createEditAssignmentPage.selectGo();

		//verify page navigator
		createEditAssignmentPage.verifyPageNavigator(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver = createEditAssignmentPage.getDriver();			
	}

	/******Test Case E4-909: Assignments - AC - Q/E Assignment - Step 2. Question checkboxes*******/
	@Test
	public void E4_909() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_909", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select questions from the list displayed
		createEditAssignmentPage.selectQuestions();	

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Verify questions
		createEditAssignmentPage.verifyOrganizeQuestions();

		//Select Back button Navigate to Select Questions screen
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify Select Questions
		createEditAssignmentPage.verifySelectQuestiontab();

		//Select AllQuestion Checkbox
		createEditAssignmentPage.selectAllQuestion(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Question Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Verify questions
		createEditAssignmentPage.verifyOrganizeQuestions();

		//Select Back button Navigate to Select Questions screen
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify Select Questions
		createEditAssignmentPage.verifySelectQuestiontab();

		//Un-Check few Questions from the Question list
		createEditAssignmentPage.unCheckQuestion();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Question Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Select Back button Navigate to Select Questions screen
		createEditAssignmentPage.selectBackButtonNavigate();

		//Uncheck All Questions from the list
		createEditAssignmentPage.unCheckAllQuestionAndVerifyAlert(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();		
	}	

	/*****Test Case E4-924: Assignments - AC - Q/E Assignment - Step 2. Select all Questions******/	
	@Test
	public void E4_924() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_924", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//set per page 
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);

		//select go button
		createEditAssignmentPage.selectGo();

		//Select AllQuestion Checkbox
		createEditAssignmentPage.selectAllQuestionCheckBox(dataMap);

		//Uncheck the Question and verify the Select All Checkbox
		createEditAssignmentPage.unCheckQuestion();

		//Select Question which is Unselected in previous step
		createEditAssignmentPage.selectUnselectedQuestion(dataMap);

		//Navigate to next page of the question list and Click next button
		createEditAssignmentPage.navigateToNextPage(dataMap);

		//Select Back button Navigate to Select Questions screen
		createEditAssignmentPage.verifyPageNavigator(dataMap);

		createEditAssignmentPage.selectNextButton();

		//Verify Select Questions
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Verify Questions list in organize score tab
		createEditAssignmentPage.verifyOrganizeQuestions();

		createEditAssignmentPage.selectBackButtonNavigate();

		//Uncheck All Questions from the list
		createEditAssignmentPage.unCheckAllQuestionAndVerifyAlert(dataMap); 

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();
	}

	/*****Test Case E4-1006: Assignments - AC - Q/E Assignment - Step 2. Navigation between Steps******/
	@Test
	public void E4_1006() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1006", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//Select questions from the list displayed
		createEditAssignmentPage.selectQuestions();	

		//Select Back button to Navigate previous Page and Cancel the Assignment.
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify Description Screen
		createEditAssignmentPage.verifyDescribeAssignmentTab();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Verify Select Questions screen
		createEditAssignmentPage.verifySelectQuestiontab();

		//Verify Question table present with selected question		
		createEditAssignmentPage.verifyQuestionTable();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();		
	}

	/*****Test Case E4-1880: Assignments - AC - Q/E Assignment - Step 3 - Question preview. Question Preview window*****/
	@Test
	public void E4_1880() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1880", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Select NonAlgorithmQuestion preview link
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Select Algorithm Question preview window
		createEditAssignmentPage.selectAlgorithmQuestionPreview(dataMap);

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();
	}

	/******Test Case E4-1881: Assignments - AC - Q/E Assignment - Step 3 - Question preview. Question Assistance buttons********/				
	@Test
	public void E4_1881() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1881", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();		

		//Select one question link for the preview
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		//Select show solution button and verify the window
		createEditAssignmentPage.verifyShowSolutionButton(dataMap);

		//Select Link to Text button and verify the window
		createEditAssignmentPage.verifyLinktoText(dataMap);

		//focus window
		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver = assignmentPage.getDriver();	

	}


	/****Test Case E4-1010: Assignments - AC - Q/E Assignment - Step 3. "Score" column*****/	
	@Test
	public void E4_1010() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1010", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Verify Default Value in Score column
		createEditAssignmentPage.verifyDefaultValueofScoreColumn(dataMap);

		//Change Score value and verify the Total
		createEditAssignmentPage.changeScoreValue(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Back button Navigate 
		createEditAssignmentPage.selectBackButtonNavigate();

		// Verify Total Score value after changing the value
		createEditAssignmentPage.verifyTotalScorevalue(dataMap);	

		//Enter symbol value
		createEditAssignmentPage.enterSybmbolInScoreValue(dataMap);

		//Enter value Highest Value in the Score textbox
		createEditAssignmentPage.enterHighestValues(dataMap);

		//Enter value Decimal Value in the Score textbox
		createEditAssignmentPage.enterDecimalValue(dataMap);

		//Enter value Fractional Value in the Score textbox
		createEditAssignmentPage.enterFractiolValue(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Back button Navigate 
		createEditAssignmentPage.selectBackButtonNavigate();

		// Verify Total Score value after changing the value
		createEditAssignmentPage.verifyTotalScorevalue(dataMap);

		//Select Save and Exit Button
		createEditAssignmentPage.selectSaveAndExit();

		//Go to assigmnent List
		assignmentPage.goToAssignmentList(dataMap);

		//Verify Assignment Displayed in the list
		assignmentPage.verifyAssignmentDisplayed(dataMap,"AsgntName");

		//Select Assignment link from the list
		assignmentPage.selectAssignmentLink(dataMap);

		//Verify Preview window and total score
		assignmentPage.verifyPreviewWindowAndTotalScore();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();
	}

	/*****Test Case E4-1016: Assignments - AC - Q/E Assignment - Step 3. Order****/
	/*********TO DO PENDING*******
	@Test
	public void E4_1016() throws Exception{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1016", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "QuestionorderID", "QuestionorderName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//Select all question per page
		createEditAssignmentPage.selectAllQuestionPerPage(dataMap);

		//click go
		createEditAssignmentPage.selectGo();

		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Verify Order of the questions
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();			

		//Description: Select Question Policies in Set Question Policies screen
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to class button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Description: Select Class from the Select Assign to class screen
		createEditAssignmentPage.assigntoclass(dataMap);

		//click submit button
		createEditAssignmentPage.selectSubmitButton();	

		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Select created assignment list from Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//Verify the assignment displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "QuestionorderName");

		//Selecting Assignment and Editing the Assignment
		assignmentPage.selectAssingmentInList(dataMap, "QuestionorderName");

		//select Go action button
		assignmentPage.selectGoActionButton(dataMap, "QuestionorderName");

		//assignmentPage.selectEditOption(dataMap, elmntAssignmentAction);

		assignmentPage.EditAssignmentAlertMessage(dataMap, "QuestionorderName");

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectQuestiontab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Check the possible values of the order
		createEditAssignmentPage.checkPossibleValues(dataMap);

		//Change Question order 3 to 1
		createEditAssignmentPage.changeQuestionOrder(dataMap);

		//Select Save and Exit Button
		createEditAssignmentPage.selectSaveAndExit();

		//Validate alert message
		createEditAssignmentPage.validateAlertMessage();

		//select assignment link
		assignmentPage.selectAssignmentLink(dataMap);

		//open preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();	

	}**/

	/*****Test Case E4-1679: Assignments - AC - Q/E Assignment - Step 4. Navigation between steps******/
	@Test
	public void E4_1679() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1679", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//set question policies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//navigate to describe assignment tab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify select question tab
		createEditAssignmentPage.verifySelectQuestiontab();

		//select next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//select next button
		createEditAssignmentPage.selectNextButton();

		//navigate to select question page
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//verify selected question
		createEditAssignmentPage.verifySelectedQuestion();

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question  tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//select next button
		createEditAssignmentPage.selectNextButton();

		//navigate to organize question tab
		createEditAssignmentPage.navigateToOrganizeAndScoreTab();

		//verify question order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}


	/*****Test Case E4-1353: Assignments - AC - Q/E Assignment - Step 4. Disable Show work******/
	@Test
	public void E4_1353() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1353", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();	

		//input assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DisbleFeedback", "DisbleFeedback");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//Select go
		createEditAssignmentPage.selectGo();

		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//select required show work check box
		createEditAssignmentPage.selectRequiredShowWork();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify show work checkbox
		createEditAssignmentPage.verifyShowWorkCheckbox();

		//click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//select required show work
		createEditAssignmentPage.selectRequiredShowWork();

		//click  next button
		createEditAssignmentPage.selectNextButton();

		//verify show work check box
		createEditAssignmentPage.verifyShowWorkCheckbox();

		//set question policies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to class button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Description: Select Class from the Select Assign to class screen
		createEditAssignmentPage.assigntoclass(dataMap);

		//click submit button
		createEditAssignmentPage.selectSubmitButton();

		//close pop up window
		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		Browser.navigateURL(driver, strStudentURL);

		//Login Page
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "DisbleFeedback");	

		openAssignment.verifyShowWorkLinks();

		//close driver()
		Browser.closeDriver(driver);

	}

	/******Test Case E4-1354: Assignments - AC - Q/E Assignment - Step 4. Point Potential Setting*******/
	@Test
	public void E4_1354() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1354", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();				
		//Select Questions from the list
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Verify Organize and Score Questions Screen
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//verify potential setting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		// select potential settings
		createEditAssignmentPage.selectPointPotentialAndVerifyPossibleValues(dataMap);

		//verify attempt policy
		createEditAssignmentPage.verifyAttemptsAndPolicy();

		//verify possible attempts
		createEditAssignmentPage.verifyPossibleAttemptsAndAttempts();

		//select unlimited attempts
		createEditAssignmentPage.selectUnlimitedAttempts();

		//uncheck potential settings
		createEditAssignmentPage.unCheckPointPotentialSetting(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();
	}

	/******Test Case E4-1362: Assignments - AC - Q/E Assignment - Step 3. Navigation*******/	
	@Test
	public void E4_1362() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1362", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "NavigationID", "NavigationName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click cancel button
		createEditAssignmentPage.selectCancelButton();

		//go to assignment list
		assignmentPage.goToAssignmentList(dataMap);

		//verify assignment displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "NavigationName");

		//click create edit button
		assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "NavigationID", "NavigationName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();		

		//verify organize question tab		
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//select save and exit button		
		createEditAssignmentPage.selectSaveAndExit();

		//go to assignment list
		assignmentPage.goToAssignmentList(dataMap);

		//verify assignment displayed		
		assignmentPage.verifyAssignmentDisplayed(dataMap, "NavigationName");

		//go to assignment list
		assignmentPage.selectAssingmentInList(dataMap, "NavigationName");

		//select go
		assignmentPage.selectGoActionButton(dataMap, "NavigationName");

		//verify alert
		assignmentPage.EditAssignmentAlertMessage(dataMap, "NavigationName");

		//verify describe assignment tab
		createEditAssignmentPage.verifyDescribeAssignmentTab();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify select question tab
		createEditAssignmentPage.verifySelectQuestiontab();

		////click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		createEditAssignmentPage.descriptionDetails(dataMap,  "NavigationID", "NavigationName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify select question tab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//select question 
		createEditAssignmentPage.verifySelectedQuestion();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();		
	}

	/******Test Case E4-1356: Assignments - AC - Q/E Assignment - Step 4. Question Attempts*******/
	@Test
	public void E4_1356() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1356", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Check default state of attempts
		createEditAssignmentPage.checkDefaultStateOfAttemptsAndAssistance();

		//set question attempts
		createEditAssignmentPage.setQuestionAttempts();

		//set unlimited attempts
		createEditAssignmentPage.setUnlimtedAttempts();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/*****Test Case E4-1358: Assignments - AC - Q/E Assignment - Step 4. Question Assistance*******/
	@Test
	public void E4_1358() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1358", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//selet go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();	

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//check question assistance
		createEditAssignmentPage.checkQuestionAssistance();

		//list possible values
		createEditAssignmentPage.listPossibleValues();

		//set question attempts
		createEditAssignmentPage.setQuestionAttempts();

		//set unlimited attempts
		createEditAssignmentPage.setUnlimtedAttempts();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/*****Test Case E4-1359: Assignments - AC - Q/E Assignment - Step 4. Save policy settings******/
	@Test
	public void E4_1359() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1359", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify select checkbox
		createEditAssignmentPage.VerifyAndSelectCheckbox();

		//select potential values
		createEditAssignmentPage.selectPotentialValues();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select assign later button
		createEditAssignmentPage.selectAssignLaterButton();

		//click create edit button
		assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select question
		createEditAssignmentPage.selectQuestions();
		
		//select next button
		createEditAssignmentPage.selectNextButton();

		//verify organize question tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//select next button
		createEditAssignmentPage.selectNextButton();

		//verify and select checkbox
		createEditAssignmentPage.VerifyAndSelectCheckbox();

		//potential value
		createEditAssignmentPage.changePotentialValue();

		//select next button
		createEditAssignmentPage.selectNextButton();

		//assign later button
		createEditAssignmentPage.selectAssignLaterButton();

		//select create edit button
		assignmentPage.goToCreateEditAssignmentPage();

		//input assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/******Test Case E4-1712: Assignments - AC - Q/E Assignment - Step 4. Navigation buttons******/	
	@Test
	public void E4_1712() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1712", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//chooseChapter
		createEditAssignmentPage.chooseChapter();

		//selectGo
		createEditAssignmentPage.selectGo();
		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();		

		createEditAssignmentPage.selectBackButtonNavigate();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectCancelButton
		createEditAssignmentPage.selectCancelButton();

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		//goToCreateEditAssignmentPage
		assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//selectNextButton
		createEditAssignmentPage.selectNextButton();
	
		//chooseChapter
		createEditAssignmentPage.chooseChapter();

		//selectGo
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectSaveAndExit
		createEditAssignmentPage.selectSaveAndExit();

		//goToAssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verifyAssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		driver= assignmentPage.getDriver();
	}

	/*****Test Case E4-1884: Assignments - AC - Q/E Assignment - Step 5 - Question preview. Question Preview window*****/	
	@Test
	public void E4_1884() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1884", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//setQuestionPolicies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//Select NonAlgorithmQuestion preview link
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		createEditAssignmentPage.clickCloseButton();

		createEditAssignmentPage.focusMainWindow();

		//Select Algorithm Question preview window
		createEditAssignmentPage.selectAlgorithmQuestionPreview(dataMap);

		createEditAssignmentPage.clickCloseButton();

		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/******Test Case E4-1885: Assignments - AC - Q/E Assignment - Step 5 - Question preview. Question Assistance buttons*****/
	@Test
	public void E4_1885() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1885", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		///Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.setQuestionPolicies(dataMap);

		createEditAssignmentPage.selectNextButton();		

		//Select one question link for the preview
		createEditAssignmentPage.selectAlgorithmQuestionPreview(dataMap);

		//Select show solution button and verify the window
		createEditAssignmentPage.verifyShowSolutionButton(dataMap);

		//Select Link to Text button and verify the window
		createEditAssignmentPage.verifyLinktoText(dataMap);

		createEditAssignmentPage.clickCloseButton();

		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();
	}

	/******	Test Case E4-1779: Assignments - AC - Q/E Assignment - Step 5. Assignment Description*****/
	@Test
	public void E4_1779() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1779", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();	

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();

		//selectGo
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//setQuestionPolicies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//navigateToDescribeAssignmentTab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//changeAssignmentNameAndId
		createEditAssignmentPage.changeAssignmentNameAndId(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifySelectQuestiontab
		createEditAssignmentPage.verifySelectQuestiontab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//setQuestionPolicies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentNameAndId
		createEditAssignmentPage.verifyAssignmentNameAndId(dataMap, "AsgntID");

		//navigateToDescribeAssignmentTab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifySelectedQuestion
		createEditAssignmentPage.verifySelectedQuestion();

		//selectAlgorithmQuestionPreview
		createEditAssignmentPage.selectAlgorithmQuestionPreview(dataMap);

		//closeWindow1
		createEditAssignmentPage.closeWindow1();

		//focusMainWindow
		createEditAssignmentPage.focusMainWindow();

		//unCheckAllQuestion
		createEditAssignmentPage.unCheckAllQuestion();

		//selectAlgorthimicQuestions
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentNameAndId
		createEditAssignmentPage.verifyAssignmentNameAndId(dataMap, "AsgntID");

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();
	}

	/*****Test Case E4-1925: Assignments - AC - Q/E Assignment - Step 4. "Change Values" radio buttons******/
	@Test
	public void E4_1925() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1925", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.selectAlgorthimicQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyChangeValuesRadioButtons
		createEditAssignmentPage.verifyChangeValuesRadioButtons();

		//navigateToSelectQuestionTab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//unCheckAllQuestion
		createEditAssignmentPage.unCheckAllQuestion();

		//selectNonAlgorthimicQuestions
		createEditAssignmentPage.selectNonAlgorthimicQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();
		//verifyChangeValuesRadioButtons
		createEditAssignmentPage.verifyChangeValuesRadioButtons();

		//navigateToSelectQuestionTab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//unCheckAllQuestion
		createEditAssignmentPage.unCheckAllQuestion();

		//selectAlgorthimicQuestions
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrganizeAndScoreQuestionTab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyChangeValuesRadioButtons	
		createEditAssignmentPage.verifyChangeValuesRadioButtons();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/*******Test Case E4-1780: Assignments - AC - Q/E Assignment - Step 5. Question Policies********/	
	@Test
	public void E4_1780() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1780", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();


		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verify Organize And ScoreQuestion Tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//setQuestionPolicies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionPolicies
		createEditAssignmentPage.verifyQuestionPolicies();

		//navigate To SetQuestions PoliciesTab
		createEditAssignmentPage.navigateToSetQuestionsPoliciesTab();

		//VerifyAndSelectCheckbox
		createEditAssignmentPage.VerifyAndSelectCheckbox();

		//selectPotentialValues
		createEditAssignmentPage.selectPotentialValues();

		//select NextButton
		createEditAssignmentPage.selectNextButton();

		//verify Question Policies
		createEditAssignmentPage.verifyQuestionPolicies();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();		
	}

	/******Test Case E4-1796: Assignments - AC - Q/E Assignment - Step 5. Selected Questions*****/	
	@Test
	public void E4_1796() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1796", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//select Non Algorthimic Questions
		createEditAssignmentPage.selectNonAlgorthimicQuestions();

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//set Question Policies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//verifyQuestionTable
		createEditAssignmentPage.verifyQuestionTable();

		//navigateToSelectQuestionTab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//unCheckAllQuestion
		createEditAssignmentPage.unCheckAllQuestion();

		//select Algorthimic Questions
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectNextButton();

		//verifyQuestionTable
		createEditAssignmentPage.verifyQuestionTable();

		//selectBackButtonNavigate
		createEditAssignmentPage.selectBackButtonNavigate();

		createEditAssignmentPage.selectBackButtonNavigate();

		//selectRequiredShowWork
		createEditAssignmentPage.selectRequiredShowWork();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectNextButton();

		//verifyQuestionTable
		createEditAssignmentPage.verifyQuestionTable();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/*****Test Case E4-1798: Assignments - AC - Q/E Assignment - Step 5. Navigation between steps*****/	
	@Test
	public void E4_1798() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1798", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrder
		createEditAssignmentPage.verifyOrder();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//navigateToDescribeAssignmentTab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//verifyDescribeAssignmentTab
		createEditAssignmentPage.verifyDescribeAssignmentTab();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifySelectedQuestion
		createEditAssignmentPage.verifySelectedQuestion();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//navigateToSelectQuestionTab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//verifySelectedQuestion
		createEditAssignmentPage.verifySelectedQuestion();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//setQuestionPolicies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionPolicies
		createEditAssignmentPage.verifyQuestionPolicies();

		//selectBackButtonNavigate
		createEditAssignmentPage.selectBackButtonNavigate();

		//selectBackButtonNavigate
		createEditAssignmentPage.selectBackButtonNavigate();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//Select Next Button
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);			

		//verifyQuestionPolicies
		createEditAssignmentPage.verifyQuestionPolicies();

		//navigateToSetQuestionsPoliciesTab
		createEditAssignmentPage.navigateToSetQuestionsPoliciesTab();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);			

		//verifyQuestionPolicies
		createEditAssignmentPage.verifyQuestionPolicies();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();
	}

	/******Test Case E4-1799: Assignments - AC - Q/E Assignment - Step 5. Navigation buttons*****/	
	@Test
	public void E4_1799() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1799", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "NavigationID", "NavigationName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrder
		createEditAssignmentPage.verifyOrder();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectBackButtonNavigate
		createEditAssignmentPage.selectBackButtonNavigate();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectCancelButton
		createEditAssignmentPage.selectCancelButton();

		//goToAssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verifyAssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "NavigationName");

		//goToCreateEditAssignmentPage
		assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "NavigationID", "NavigationName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyOrder
		createEditAssignmentPage.verifyOrder();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectBackButtonNavigate
		createEditAssignmentPage.selectBackButtonNavigate();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssignLaterButton
		createEditAssignmentPage.selectAssignLaterButton();

		//goToAssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verifyAssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "NavigationName");

		//goToCreateEditAssignmentPage
		assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "NavigationID", "NavigationName");

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//chooseChapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//selectQuestions
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//setQuestionPolicies
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//selectNextButton		
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		//goToAssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verifyAssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "NavigationName");

		//selectAssignmentLink
		assignmentPage.selectAssignmentLink(dataMap);

		//closeWindow2
		createEditAssignmentPage.closeWindow2();

		//closeWindow1
		createEditAssignmentPage.closeWindow1();

		//focusMainWindow
		createEditAssignmentPage.focusMainWindow();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();		
	}

	/*****Test Case E4-1829: Assignments - AC - Q/E Assignment - Assign Q/E page. Select Class Sections*******/
	@Test
	public void E4_1829() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1829", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "ClassSelectionID", "ClassSelectionName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//verifyElementPresent
		createEditAssignmentPage.verifyElementPresent(dataMap);

		//checkAllClassSection
		createEditAssignmentPage.checkAllClassSection(dataMap);

		//unCheckAllClassSection
		createEditAssignmentPage.unCheckAllClassSection(dataMap);

		//uncheckSelectedClassSection
		createEditAssignmentPage.uncheckSelectedClassSection(dataMap);

		//verifyAlertMessageClassSection
		createEditAssignmentPage.verifyAlertMessageClassSection();

		createEditAssignmentPage.assignmentLink();

		driver= createEditAssignmentPage.getDriver();		
	}

	/*****Test Case E4-1830: Assignments - AC - Q/E Assignment - Assign Q/E page. Start Date/Due Date settings******/
	@Test
	public void E4_1830() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1830", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		driver= assignmentPage.getDriver();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DueDateID", "DueDatEName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyQuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyPointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		//verifyDefaultValueDate
		createEditAssignmentPage.verifyDefaultValueDate(dataMap);

		//Verify Calender
		createEditAssignmentPage.verifycalender(dataMap);

		//assignmentLink
		createEditAssignmentPage.assignmentLink();

		driver= createEditAssignmentPage.getDriver();		
	}	

	/*****Test Case E4-1877: Assignments - AC - Q/E Assignment - Assign Q/E page. Start Date/Due Time settings****/
	@Test
	public void E4_1877() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1877", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		driver= assignmentPage.getDriver();	

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input Description Details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DueDateID", "DueDatEName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		////Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//verify PointPotential Setting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Assignment Description
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select Assignto ClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//verifyDefaultValueTime
		createEditAssignmentPage.verifyDefaultValueTime(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver= createEditAssignmentPage.getDriver();

	}

	/*****Test Case E4-1831: Assignments - AC - Q/E Assignment - Assign Q/E page. Access after the Due Date******/
	@Test
	public void E4_1831() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1831", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		driver= assignmentPage.getDriver();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DueDateID", "DueDatEName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		//verify PointPotential Setting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verifyAssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//verify Student Access
		createEditAssignmentPage.verifyStudentAccess();

		//select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//closeWindow1
		createEditAssignmentPage.closeWindow1();

		//focusMainWindow
		createEditAssignmentPage.focusMainWindow();

		//goToAssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verifyAssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "DueDatEName");

		//select Assignment Link
		assignmentPage.selectAssignmentLink(dataMap);

		//verifyStudentAccessSettingInPreviewWindow
		assignmentPage.verifyStudentAccessSettingInPreviewWindow();

		//closeWindow1
		createEditAssignmentPage.closeWindow1();

		//focusMainWindow
		createEditAssignmentPage.focusMainWindow();

		//selectEditAvailabilityAssignedToClass
		assignmentPage.selectEditAvailabilityAssignedToClass(dataMap);

		//select Student AccessView Only
		createEditAssignmentPage.selectStudentAccessViewOnly();

		//verify AlertMessage InAssignPage
		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		//closeWindow1
		createEditAssignmentPage.closeWindow1();

		//focusMain Window
		createEditAssignmentPage.focusMainWindow();

		//go To Assignment List
		assignmentPage.goToAssignmentList(dataMap);

		//verify Assignment Displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "DueDatEName");

		//select Assignment Link
		assignmentPage.selectAssignmentLink(dataMap);

		//verifyStudentAccessSettingInPreviewWindow
		assignmentPage.verifyStudentAccessSettingInPreviewWindow();

		//closeWindow1
		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//select Edit Availability Assigned To Class
		assignmentPage.selectEditAvailabilityAssignedToClass(dataMap);

		//select Student Access View With Assistance
		createEditAssignmentPage.selectStudentAccessViewWithAssistance();

		//verify Alert Message In AssignPage
		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//go To Assignment List
		assignmentPage.goToAssignmentList(dataMap);

		//verify Assignment Displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "DueDatEName");

		//select Assignment Link
		assignmentPage.selectAssignmentLink(dataMap);

		//verify Student Access Setting InPreviewWindow
		assignmentPage.verifyStudentAccessSettingInPreviewWindow();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//assignment link
		createEditAssignmentPage.assignmentLink();

		driver= createEditAssignmentPage.getDriver();		
	}

	/******Test Case E4-1832: Assignments - AC - Q/E Assignment - Assign Q/E page. Current date********/
	@Test
	public void E4_1832() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1832", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		driver= assignmentPage.getDriver();
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input Description Details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "CurrentID", "CurrentName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verify PointPotential Setting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verify Assignment Description
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select  AssigntoClass Button
		createEditAssignmentPage.selectAssigntoClassButton();

		//assign to class
		createEditAssignmentPage.assigntoclass(dataMap);

		//verify CurrentDate		
		createEditAssignmentPage.verifyCurrentDate();

		createEditAssignmentPage.assignmentLink();

		driver=createEditAssignmentPage.getDriver();
	}

	/******Test Case E4-1833: Assignments - AC - Q/E Assignment - Assign Q/E page. Assignment Scoring*****/
	@Test
	public void E4_1833() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1833", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input DescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "CurrentID", "CurrentName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		//select Next Button
		createEditAssignmentPage.selectNextButton();

		//verify QuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify PointPotential Setting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify Assignment Description
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select Assignto ClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assign to class
		createEditAssignmentPage.assigntoclass(dataMap);

		//verify Assignment Scoring
		createEditAssignmentPage.verifyAssignmentScoring();

		//select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();		

		//goTo AssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verify Assignment Displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "CurrentName");

		//select AssignmentLink
		assignmentPage.selectAssignmentLink(dataMap);

		//verify GradedAssignmentPolicies
		assignmentPage.verifyGradedAssignmentPolicies();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//select EditAvailability AssignedToClass
		assignmentPage.selectEditAvailabilityAssignedToClass(dataMap);

		//verify AssignmentScoring
		createEditAssignmentPage.verifyAssignmentScoring();

		//select SubmitButton
		createEditAssignmentPage.selectSubmitButton();

		//verify AlertMessage InAssignPage
		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//goTo AssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verify AssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "CurrentName");

		//select ActionsUnAssign
		assignmentPage.selectActionsUnAssign(dataMap, "CurrentName");

		//select AssignmentGobutton
		assignmentPage.selectAssignmentGobutton(dataMap, "CurrentName");

		//select ActionsAssign
		assignmentPage.selectActionsAssign(dataMap, "CurrentName");

		//select AssignmentGobutton
		assignmentPage.selectAssignmentGobutton(dataMap, "CurrentName");

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//verify UnGradedAssignment
		createEditAssignmentPage.verifyUnGradedAssignment();

		//select SubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();	

		//goTo AssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verify AssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "CurrentName");

		//select AssignmentLink
		assignmentPage.selectAssignmentLink(dataMap);

		//verify GradedAssignmentPolicies
		assignmentPage.verifyGradedAssignmentPolicies();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		driver= createEditAssignmentPage.getDriver();
	}

	/******Test Case E4-1834: Assignments - AC - Q/E Assignment - Assign Q/E page. "Use Generic Question Titles" checkbox*******/
	@Test
	public void E4_1834() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1834", driver);		

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);


		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		driver= assignmentPage.getDriver();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "GenericID", "GenericName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		//verify QuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify PointPotential Setting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//verify Assignment Description
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select AssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assign toclass		
		createEditAssignmentPage.assigntoclass(dataMap);

		//verify UseGenericQuestion Titles
		createEditAssignmentPage.verifyUseGenericQuestionTitles();

		//select SubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//Navigate to domain
		Browser.navigateURL(driver, strStudentURL);

		//Login Page
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "GenericName");

		//verifyOrderOfQuestions
		openAssignment.verifyOrderOfQuestions();

		//Navigate to domain
		Browser.navigateURL(driver, strURL);
		//Login
		home.login(dataMap);
		//select course
		courseSelectionPage.selectCourse(dataMap);

		//go to assignment page
		courseHomePage.goToAssigmentPage();

		//go to assignment list
		assignmentPage.goToAssignmentList(dataMap);

		//verify assignment displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "GenericName");

		//select Actions EditAvailability
		assignmentPage.selectActionsEditAvailability(dataMap, "GenericName");

		//select GoActionButton
		assignmentPage.selectGoActionButton(dataMap, "GenericName");

		//select UseGenericQuestionTitle
		createEditAssignmentPage.selectUseGenericQuestionTitle();

		//select SubmitButton
		createEditAssignmentPage.selectSubmitButton();

		//verify AlertMessageInAssignPage
		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//navigate domain
		Browser.navigateURL(driver, strStudentURL);

		//Login
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "GenericName");

		//verify OrderOfQuestions
		openAssignment.verifyOrderOfQuestions();

		//clear cookies
		Browser.clearAllCookies(driver);

		//close driver()
		Browser.closeDriver(driver);

	}

	/******Test Case E4-1835: Assignments - AC - Q/E Assignment - Assign Q/E page. "Allow Printing" checkbox*******/	
	@Test
	public void E4_1835() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1835", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		//verify QuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify PointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify AssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select AssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//verify AllowPrinting
		createEditAssignmentPage.verifyAllowPrinting();

		//select SubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//navigate url
		Browser.clearAllCookies(driver);

		Browser.navigateURL(driver, strStudentURL);

		//login Page
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//verify PrintAssignment
		openAssignment.verifyPrintAssignment();

		Browser.navigateURL(driver, strURL);

		//login
		home.login(dataMap);

		//select Course
		courseSelectionPage.selectCourse(dataMap);

		//goTo AssigmentPage
		courseHomePage.goToAssigmentPage();

		//goTo AssignmentList
		assignmentPage.goToAssignmentList(dataMap);

		//verify AssignmentDisplayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		//select ActionsEditAvailability
		assignmentPage.selectActionsEditAvailability(dataMap, "AsgntName");

		//select AssignmentGobutton
		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");

		//select AllowPrinting
		createEditAssignmentPage.selectAllowPrinting();

		//select SubmitButton
		createEditAssignmentPage.selectSubmitButton();

		//verify AlertMessageInAssignPage
		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.closeWindow1();
		createEditAssignmentPage.focusMainWindow();

		Browser.clearAllCookies(driver);
		//navigate url
		Browser.navigateURL(driver, strStudentURL);

		//login
		studentLoginpage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		openAssignment.verifyPrintAssignment();

		//close driver()
		Browser.closeDriver(driver);		
	}

	/******Test Case E4-1836: Assignments - AC - Q/E Assignment - Assign Q/E page. Gradebook Weighting settings******/	
	@Test
	public void E4_1836() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1836", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");					

		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);						
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);		

		/**********PRECONDITION***************/
		courseHomePage.goToGradebookPage();
		//Select Class Section
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click Go Button
		gradeBookPage.clickGoButton();		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.gradeBookWeightedButton();

		createEditAssignmentPage.setGradebookWeighted(dataMap);

		createEditAssignmentPage.selectSubmitButton();		

		/****Creating Three Assignment****/
		courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentA", "AssignmentA");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		//verify QuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify PointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify AssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select assign later
		createEditAssignmentPage.selectAssignLaterButton();


		/******Creating 2nd Assignment*******/		
		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentB", "AssignmentB");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		//verify QuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify PointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify AssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select assign later
		createEditAssignmentPage.selectAssignLaterButton();

		/******Creating 3rd Assignment******/
		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage();

		//inputDescriptionDetails
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentC", "AssignmentC");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		//verify QuestionOrder
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify PointPotentialSetting
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		//verify AssignmentDescription
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//select assign later
		createEditAssignmentPage.selectAssignLaterButton();

		/******PRECONDITION ENDED******/

		//GoTo Assignment page
		courseHomePage.goToAssigmentPage();		

		courseSelectionPage.selectCourse(dataMap);	

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		//Select Assignment not assigned to class
		assignmentPage.selectActionsAssign(dataMap, "AssignmentA");

		//Click Go Button
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentA");

		//Assign to class
		createEditAssignmentPage.assigntoclass(dataMap);

		//Select GradeBook Weighting setting
		createEditAssignmentPage.gradebookWeightingSetting();			

		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		//click GradeBook Tab
		courseHomePage.goToGradebookPage();

		//Select Class Section
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click Go Button
		gradeBookPage.clickGoButton();

		//Select student  Link
		gradeBookPage.clickStudentNameLink(dataMap, "AssignmentA");		

		//Verify Weighted Score
		gradeBookPage.weightedScore(dataMap, "AssignmentA");

		//click Assignment Tab
		courseHomePage.goToAssigmentPage();

		//Go to Assignment List
		assignmentPage.goToAssignmentList(dataMap);

		//Select Assignment not assigned to class
		assignmentPage.selectActionsAssign(dataMap, "AssignmentB");

		//Click Go Button
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentB");

		//Assign to class
		createEditAssignmentPage.assigntoclass(dataMap);

		//Select GradeBook Weighting setting
		createEditAssignmentPage.gradebookWeightingSetting();			

		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//click GradeBook Tab
		courseHomePage.goToGradebookPage();

		//Select Class Section
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click Go Button
		gradeBookPage.clickGoButton();

		//Select student  Link
		gradeBookPage.clickStudentNameLink(dataMap, strStudentURL);

		//Verify Weighted Score
		gradeBookPage.weightedScore(dataMap, "AssignmentB");

		//click Assignment Tab
		courseHomePage.goToAssigmentPage();

		//Go to Assignment List
		assignmentPage.goToAssignmentList(dataMap);

		//Select Assignment not assigned to class
		assignmentPage.selectActionsAssign(dataMap, "AssignmentC");

		//Click Go Button
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentC");

		//Assign to class
		createEditAssignmentPage.assigntoclass(dataMap);

		//Select GradeBook Weighting setting
		createEditAssignmentPage.gradebookWeightingSetting();			

		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//click GradeBook Tab
		courseHomePage.goToGradebookPage();

		//Select Class Section
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click Go Button
		gradeBookPage.clickGoButton();

		//Select student  Link
		gradeBookPage.clickStudentNameLink(dataMap, strStudentURL);

		//Verify Weighted Score
		gradeBookPage.weightedScore(dataMap, "AssignmentC");

		//close driver()
		Browser.closeDriver(driver);		
	}

	/******Test Case E4-1837: Assignments - AC - Q/E Assignment - Assign Q/E page. "Timed assignment" checkbox******/
	@Test
	public void E4_1837() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1837", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Launch URL
		Browser.navigateURL(driver, strURL);

		home.login(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToCreateEditAssignmentPage();

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.verifyTimedAssignment();

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyTimedAssignmentDisplayed();

		driver= assignmentPage.getDriver();
	}	

	/******Test Case E4-1838: Assignments - AC - Q/E Assignment - Assign Q/E page. "Time on task" checkbox******/
	@Test
	public void E4_1838() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1838", driver);

		CourseHomePage courseHomePage= PageFactory.initElements(driver, CourseHomePage.class);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");
		
		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();


		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);

		AssignmentResultsPage assignmentResultsPage = PageFactory.initElements(driver, AssignmentResultsPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.verifyTimeOnTask();

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		courseHomePage.goToGradebookPage();

		gradeBookPage.clickGoButton();

		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");

		gradeBookPage.clickAssignmentLink(dataMap, "AssignmentName");

		assignmentResultsPage.getAllQuestionsForTotalTime();

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectActionsEditAvailability(dataMap, "AsgntName");

		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");

		createEditAssignmentPage.selectTimeOnTask();

		createEditAssignmentPage.selectSubmitButton();

		courseHomePage.goToGradebookPage();

		gradeBookPage.clickGoButton();

		gradeBookPage.clickStudentNameLink(dataMap, strStudentURL);

		gradeBookPage.clickAssignmentId(dataMap, strStudentURL);

		assignmentResultsPage.getAllQuestionsForTotalTime();		
		
		//close driver()
		Browser.closeDriver(driver);		
	}

	/*******Test Case E4-1846: Assignments - AC - Q/E Assignment - Assign Q/E page. Late Submissions********/
	@Test
	public void E4_1846() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1846", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");	

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "LateSubmission", "LateSubmission");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.verifyLateSubmission();

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "LateSubmission");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.verifyLateScorePolicy();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		assignmentPage.selectActionsEditAvailability(dataMap, "LateSubmission");

		assignmentPage.selectAssignmentGobutton(dataMap, "LateSubmission");

		createEditAssignmentPage.selectLateSubmission();

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.assignmentLink();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "LateSubmission");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.verifyLateScorePolicy();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		driver= createEditAssignmentPage.getDriver();		
	}

	/******Test Case E4-1839: Assignments - AC - Q/E Assignment - Assign Q/E page. "No Due Date" checkbox*******/	
	@Test
	public void E4_1839() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1839", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.verifyAndCheckDueDate(dataMap);

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.verifyDueDate();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectActionsEditAvailability(dataMap, "AsgntName");

		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");

		createEditAssignmentPage.verifyAndCheckDueDate(dataMap);

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.verifyDueDate();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		driver= createEditAssignmentPage.getDriver();		
	}

	/******Test Case E4-1883: Assignments - AC - Q/E Assignment - Assign Q/E page. "Study Objective Reporting" checkbox******/
	@Test
	public void E4_1883() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1883", driver);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "StudyAssigntID", "StudyAssigntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.SelectLearningObjective(dataMap);

		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.verifyAndCheckStudyObjective();

		createEditAssignmentPage.selectSubmitButton();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "StudyAssigntName");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.verifyStudyObjectiveEnabled();

		createEditAssignmentPage.closeWindow1();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "StudyAssigntName");

		assignmentPage.selectActionsEditAvailability(dataMap, "StudyAssigntName");

		assignmentPage.selectAssignmentGobutton(dataMap, "StudyAssigntName");

		createEditAssignmentPage.verifyAndCheckStudyObjective();

		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "StudyAssigntName");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.verifyStudyObjectiveEnabled();

		createEditAssignmentPage.closeWindow();

		createEditAssignmentPage.focusMainWindow();

		driver= createEditAssignmentPage.getDriver();		
	}

	/*******Test Case E4-391: Assignments - AC - Questions/Exercises Assignment. Create new Assignment*******/
	@Test
	public void E4_391() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_391", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntNameVariousSettings", "AsgntNameVariousSettings");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();
		
		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.selectSubmitButton();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntNameVariousSettings");

		driver= assignmentPage.getDriver();
	}	

	/*****Test Case E4-407: Assignments - AC - Questions/Exercises Assignment. Edit Assignment********/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_407() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_407", driver);
		E4_391();
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);		

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntNameVariousSettings");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntNameVariousSettings");

		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntNameVariousSettings");

		assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntNameVariousSettings");

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectedQuestion();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.removeOneQuestion();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionFeedbackCheckbox();

		createEditAssignmentPage.selectSaveAndExit();

		driver= createEditAssignmentPage.getDriver();
	}

	/*****Test Case E4-386: Assignment - Instructor's Assignments page - Assignment Preview.*****/
	/*****Test Case E4-477: Assignment - Student's Assignments page - Assignment preview***/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_477() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_477", driver);
		E4_391();
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntNameVariousSettings");

		driver= assignmentPage.getDriver();

	}

	/******Test Case E4-463: Assignments - Question page. Exceptions and errors*****/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_463() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_463", driver);
		E4_391();		
		CourseHomePage courseHomePage= PageFactory.initElements(driver, CourseHomePage.class);
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		
		assignmentPage.goToAssignmentList(dataMap);
		
		assignmentPage.selectionQuestionLink();

		QuestionPage questionPage=PageFactory.initElements(driver,QuestionPage.class);

		questionPage.verifyQuestionPage();

		courseHomePage.goToAssigmentPage();

		driver= courseHomePage.getDriver();		

	}
	
	/*******Test Case E4-465: Assignments - Question page. Create new question********/
	@Test
	public void E4_465() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_465", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		CreateEditAssignmentPage  createEditAssignmentPage= PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		QuestionPage questionPage=PageFactory.initElements(driver,QuestionPage.class);

		assignmentPage.selectionQuestionLink();

		CreateNewQuestionPage createNewQuestionPage = questionPage.goToCreateNewQuestion();

		createNewQuestionPage.inputDescribeQuestion(dataMap);

		createNewQuestionPage.selectNextButton();

		createNewQuestionPage.inputCreateQuestion(dataMap);

		createNewQuestionPage.selectNextButton();

		createNewQuestionPage.verifyQuestionAssistanceTab();

		createNewQuestionPage.selectNextButton();

		createNewQuestionPage.verifyConfirmation();

		createNewQuestionPage.selectFinishButton();

		createEditAssignmentPage.closeWindow1();

		createEditAssignmentPage.focusMainWindow();

		driver= createEditAssignmentPage.getDriver();		

	}

	/****Test Case E4-428: Assignment Player - Instructor - Questions/Exercises Assignment****/		
	/*******PRECONDITION DEPENDS ON E4-391*****/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_428() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_428", driver);
		E4_391();
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);	
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//select go button
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment
		assignmentPage.selectAssignmentLink(dataMap);

		//navigate to assignment window
		assignmentPage.navigateToAssignmentWindow();

		//click on first question link
		openAssignment.clickOnFirstQuestion();

		//click next
		openAssignment.clickNext();

		//click back
		openAssignment.clickBack();

		//click review score
		openAssignment.clickReviewScore();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();
	}

	/****Test Case E4-4504: Question Assignment Player - Instructor - Assigned. Description & Policies****/
	
	@Test
	public void E4_4504() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4504", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);		
		
		CreateEditAssignmentPage createEditAssignmentPage= assignmentPage.goToCreateEditAssignmentPage();
		
		/**************PRECONDITION*********************************/
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DescribeAssignment", "DescribeAssignment");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGoBtn();
		
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.VerifyAndSelectCheckbox();
		
		createEditAssignmentPage.changePotentialValue();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectAssigntoClassButton();
		
		createEditAssignmentPage.assigntoclass(dataMap);
		
		createEditAssignmentPage.selectSubmitButton();
		/**************/
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//openAssignment
		openAssignment.selectDescribeAssignment(dataMap);
		
		openAssignment.verifyDescribeAssignmentScreenShot();

		//verify the assignment name
		openAssignment.verifyAssignmentName(dataMap);

		//click next
		openAssignment.clickNext();

		//click back 
		openAssignment.clickBack();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();
		
	}

	/****Test Case E4-4506: Question Assignment Player - Instructor - Assigned. Current Date****/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_4506() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4506", driver);
		
		E4_391();
		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment with all types of settings
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//verify current date
		openAssignment.verifyCurrentDate();

		//click next
		openAssignment.clickNext();

		//click back
		openAssignment.clickBack();

		//verify current date
		openAssignment.verifyCurrentDate();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//verify current date
		openAssignment.verifyCurrentDate();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();

	}

	
	/****Test Case E4-4510: Question Assignment Player - Instructor - Assigned. Review Results by Study Objective****/
	@Test
	public void E4_4510() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4565", driver);
		
		/*******PRECONDITION********/
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".SPECIFIC_QUESTION_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
	
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
						
		home.studentLogin(dataMap, "DomainEmail", "DomainPassword");
				
		//Select Course
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
				
		courseHomePage.getDriver();
		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage().getDriver();
		
		//Object for CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
				
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntSubmitScoreEditID1", "AsgntSubmitScoreEditName1");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.deselectAllChapter();
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForSubmitScoreEditPre(dataMap);
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Check Apply point potential
		createEditAssignmentPage.setQuestionPolicies(dataMap);
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Click Assign to class button
		createEditAssignmentPage.selectAssigntoClassButton();
		
		//Select the Class to be Assigned
		createEditAssignmentPage.assigntoclass(dataMap);
		
		//Check No due Date
		createEditAssignmentPage.verifyAndCheckDueDate(dataMap);
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();
		/******************************************/		

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment for studyobjective		
		openAssignment.selectMultiQuestionAssignment(dataMap);
		
		assignmentPage.focusAssignmentWindow();
		
		openAssignment.verifyReviewScoreStudyObjectiveScreenshot();

		//verify the presence and click  study objective
		openAssignment.verifyAndClickReviewStudyObjective();
		
		assignmentPage.focusAssignmentWindow();		
		
		//verify Results
		openAssignment.verifyResultsColumn();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();
	}

	/****Test Case E4-4511: Question Assignment Player - Instructor - Assigned. Added questions****/	
	@Test
	public void E4_4511() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4511", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		/****PRECONDITION******/
		CreateEditAssignmentPage createEditAssignmentPage= assignmentPage.goToCreateEditAssignmentPage();
		
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntName100Question", "AsgntName100Question");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGoBtn();
		
		createEditAssignmentPage.select100Question();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.removeOneQuestion();
		
		createEditAssignmentPage.DuplicateQuestion();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectAssigntoClassButton();
		
		createEditAssignmentPage.assigntoclass(dataMap);
		
		createEditAssignmentPage.selectSubmitButton();		
		/******/
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);

		//open 100 question assignment
		openAssignment.select100QuestionAssignment(dataMap);
		
		assignmentPage.focusAssignmentWindow();

		//verify question size
		openAssignment.verifyQuestionSize();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();

	}

	/****Test Case E4-4512: Question Assignment Player - Instructor - Assigned. Potential Score****/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_4512() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4512", driver);
		/****PRECONDITION****/
		E4_391();
		/***/
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment with potential score modified
		openAssignment.selectVariousSettingsAssignment(dataMap);
		
		assignmentPage.focusAssignmentWindow();
		
		//click next
		openAssignment.clickNext();

		//click review score
		openAssignment.clickReviewScore();

		//verify the maximum potential
		openAssignment.verifyMaximumPotential();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();

	}

	/****Test Case E4-4515: Question Assignment Player - Instructor - Assigned. Order of questions****/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_4515() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4515", driver);
		/****PRECONDITION****/
		E4_391();
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);		
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);
		
		assignmentPage.focusAssignmentWindow();
		
		//verify the order of questions
		openAssignment.verifyOrderOfQuestions();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();
	}

	/****Test Case E4-4517: Question Assignment Player - Instructor - Assigned. Quest. Count****/
	@Test(dependsOnMethods={"E4_391"})
	public void E4_4517() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4517", driver);
		/*******PRECONDITION*******/
		E4_391();
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);		

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);
		
		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);
		
		assignmentPage.focusAssignmentWindow();

		//verify the no of question
		openAssignment.verifyQuestionSize();

		//close window
		assignmentPage.closeWindow();

		driver= assignmentPage.getDriver();
	}

	/****Test Case E4-4520: Question Assignment Player - Instructor - Assigned. Attempts counter****/	
	@Test(dependsOnMethods={"E4_391"})
	public void E4_4520() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4520", driver);
		/*******PRECONDITION*******/
		E4_391();
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		assignmentPage.goToAssignmentList(dataMap);
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);	

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//create a method to attempt question

		//close window
		assignmentPage.closeWindow();	
		
		driver= assignmentPage.getDriver();

	}

	/****Test Case E4-4519: Question Assignment Player - Instructor - Assigned. Submit Answer button****/
	 @Test(dependsOnMethods={"E4_391"})	 
	public void E4_4519() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4519", driver);
		/******PRECONDITION****/
		E4_391();
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		assignmentPage.goToAssignmentList(dataMap);	
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify submit answer button
		openAssignment.verifySubmitanswer();

		driver=assignmentPage.getDriver();
		
	}
	/****Test Case E4-4555: Question Assignment Player - Instructor - Assigned. Save for Later****/	
	@Test(dependsOnMethods={"E4_391"})	
	public void E4_4555() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4555", driver);
		/******PRECONDITION****/
		E4_391();
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		assignmentPage.goToAssignmentList(dataMap);			
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
	
		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify submit answer button
		openAssignment.verifySubmitanswer();
		
		driver=assignmentPage.getDriver();
		
	}

	/****Test Case E4-4529: Question Assignment Player - Instructor - Assigned. Disable immediate feedback****/
	
	@Test
	public void E4_4529() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4519", driver);		

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		CreateEditAssignmentPage createEditAssignmentPage= assignmentPage.goToCreateEditAssignmentPage();
		
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DisbleFeedback1", "DisbleFeedback1");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGoBtn();
		
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.disableFeedback();
		
		createEditAssignmentPage.selectAssignLaterButton();
		
		assignmentPage.goToAssignmentList(dataMap);
		
		assignmentPage.verifyAssignmentDisplayed(dataMap, "DisbleFeedback1");
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectDisableAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify show solution button
		openAssignment.verifyAssistanceButtons();
		
		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-4532: Question Assignment Player - Instructor - Assigned. Question Assistance: SHOW ALWAYS****/
	
	@Test
	public void E4_4532() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4532", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		CreateEditAssignmentPage createEditAssignmentPage= assignmentPage.goToCreateEditAssignmentPage();
		
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "ShowAlways", "ShowAlways");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGoBtn();
		
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectAssistanceShowAlways(dataMap);
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectAssigntoClassButton();
		
		createEditAssignmentPage.assigntoclass(dataMap);
		
		createEditAssignmentPage.selectSubmitButton();
		
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment 
		openAssignment.selectAssistanceShowalways(dataMap);
		
		assignmentPage.focusAssignmentWindow();

		//click next
		openAssignment.clickNext();

		//verify assistance buttons
		openAssignment.verifyAssistanceButtons();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-4534: Question Assignment Player - Instructor - Assigned. Question Assistance: SHOW NEVER****/
	/**********TO DO PENDING
	@Test
	public void E4_4534() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4534", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assistance buttons
		openAssignment.verifyAssistanceButtons();

		driver=assignmentPage.getDriver();

	}****/
	/****Test Case E4-4535: Question Assignment Player - Instructor - Assigned. Question Assistance: SHOW AFTER****/
	/*******TO DO PENDING
	@Test
	public void E4_4535() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4535", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectTextEntryAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assistance buttons
		openAssignment.verifyAssistanceButtons();

		driver=assignmentPage.getDriver();
		
	}***/

	/****Test Case E4-4543: Question Assignment Player - Instructor - Assigned. Student Access after the Due Date: No****/
	/******TO DO PENDING ******
	@Test
	public void E4_4543() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4543", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectNoDueAssignment(dataMap);
	
		driver=assignmentPage.getDriver();
	}***/
	
	/****Test Case E4-4540: Question Assignment Player - Instructor - Assigned. Generic Question Titles****/
	/*******TO DO PENDING****
	@Test
	public void E4_4540() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4540", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//verify hided question title
		openAssignment.verifyHidedQuestionTitle();
		
		driver=assignmentPage.getDriver();

	}**/

	/****Test Case E4-4541: Question Assignment Player - Instructor - Assigned. Allowed Printing****/
	/********TO DO PENDING*****
	@Test
	public void E4_4541() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4541", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);
		
		driver=assignmentPage.getDriver();

	}****/
	
	/****Test Case E4-4547: Question Assignment Player - Instructor - Assigned. Navigation buttons****/	
	@Test(dependsOnMethods={"E4_391"})	
	public void E4_4547() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4547", driver);
		E4_391();
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);		
				
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//verify back button
		openAssignment.clickBack();

		//verify next button
		openAssignment.clickNext();

		//click study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//verify next button
		openAssignment.clickNext();
		
		driver=assignmentPage.getDriver();
	}
	
	/****Test Case E4-4551: Question Assignment Player - Instructor - Assigned. Printer Version****/	
	@Test(dependsOnMethods={"E4_391"})	
	public void E4_4551() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4551", driver);
		E4_391();
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);	

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignmnet
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//verify printer version
		openAssignment.clickPrinterVersion();

		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-4549: Question Assignment Player - Instructor - Assigned. Calculator****/
	
	@Test(dependsOnMethods={"E4_391"})	
	public void E4_4549() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4549", driver);
		E4_391();
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click calculator button
		openAssignment.clickCalculator();
		
		driver=assignmentPage.getDriver();
		
	}
	
	/****Test Case E4-4553: AQuestion ssignment Player - Instructor - Assigned. Full Screen****/
	
	@Test(dependsOnMethods={"E4_391"})	
	public void E4_4553() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4553", driver);
		
		E4_391();
		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click full screen
		openAssignment.clickFullscreen();
		
		driver=assignmentPage.getDriver();

	}

	/****Test Case E4-4557: Question Assignment Player - Instructor - Assigned. Show Work****/
	/*********TO DO PENDING******
	@Test
	public void E4_4557() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4557", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectMatching(dataMap);

		//click next
		openAssignment.clickNext();

		//click open show work
		openAssignment.selectShowWork();
		
		driver=assignmentPage.getDriver();

	}*****/

	/*******Test Case E4-474: Assignments - Question page. Create Question Pool*******/
	@Test
	public void E4_474() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_474", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		QuestionPage questionPage=PageFactory.initElements(driver, QuestionPage.class);

		CreateNewQuestionPage createNewQuestionPage=PageFactory.initElements(driver, CreateNewQuestionPage.class);	

		assignmentPage.selectionQuestionLink();

		CreateQuestionPoolPage createQuestionPoolPage = questionPage.goToCreateQuestionPool();

		createQuestionPoolPage.inputDefinePool(dataMap);

		createNewQuestionPage.selectNextButton();

		createQuestionPoolPage.verifySelectQuestionTab();

		createEditAssignmentPage.selectQuestions();

		createNewQuestionPage.selectNextButton();

		createQuestionPoolPage.verifyOrganizeQuestion();

		createNewQuestionPage.selectNextButton();

		createNewQuestionPage.selectFinishButton();
		
		driver=assignmentPage.getDriver();
		
	}
	
	
	/*******Test Case E4-1891: Assignments - AE - EA - No Access - No progress - Q/E A - Step 1. Change Assignment Describing*******/		
	/*********TO DO PENDING****
	@Test
	public void E4_1891() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1891", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();		

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.SelectLearningObjective(dataMap);

		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.verifyAndCheckStudyObjective();

		createEditAssignmentPage.selectSubmitButton();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		createEditAssignmentPage.changeAssignmentNameAndId(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectSaveAndExit();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyNewAssignmentDisplayed(dataMap);
		
		driver=assignmentPage.getDriver();

	}*****/
	
	/*****Test Case E4-1902: Assignments - AE - EA - No Access - No progress - Q/E A - Step 2. Navigation*****/
	/******TO DO PENDEING*****
	@Test
	public void E4_1902() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1902", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectQuestiontab();

		createEditAssignmentPage.selectBackButtonNavigate();

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectCancelButton();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectQuestiontab();

		createEditAssignmentPage.selectNonAlgorthimicQuestions();

		createEditAssignmentPage.selectSaveAndExit();

		driver=assignmentPage.getDriver();

	}*****/
	
	/*****Test Case E4-1903: Assignments - AE - EA - No Access - No progress - Q/E A - Step 3. Removing and duplication****/
	/*****
	@Test
	public void E4_1903() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1903", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		
		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectQuestiontab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.removeOneQuestion();

		createEditAssignmentPage.selectSaveAndExit();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.navigateToAssignmentWindow();

		openAssignment.verifyQuestionSize();

		createEditAssignmentPage.closeWindow();

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		createEditAssignmentPage.verifyDescribeAssignmentTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectQuestiontab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.DuplicateQuestion();

		createEditAssignmentPage.selectSaveAndExit();

		assignmentPage.selectAssignmentLink(dataMap);

		assignmentPage.navigateToAssignmentWindow();

		openAssignment.verifyQuestionSize();

		createEditAssignmentPage.closeWindow();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-4542: Question Assignment Player - Instructor - Assigned. Timed assignment****/
	/******TO DO PENDING****
	@Test
	public void E4_4542() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4542", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open timed asssignment
		openAssignment.selectAssignment(dataMap, "AsgntNameTimed");

		//verify time counter
		openAssignment.verifyTimeCounter();
		
		driver=assignmentPage.getDriver();

		
	}*****/
	
	/****Test Case E4-4544: Question Assignment Player - Instructor - Assigned. Start Date in the Future****/	
	@Test
	public void E4_4544() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4544", driver);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		CreateEditAssignmentPage createEditAssignmentPage= assignmentPage.goToCreateEditAssignmentPage();
		
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "StartFutureDate", "StartFutureDate");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGoBtn();
		
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.verifyQuestionOrder(dataMap);
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectAssigntoClassButton();
		
		createEditAssignmentPage.assigntoclass(dataMap);
		
		createEditAssignmentPage.selectfutureDate(dataMap);
		
		createEditAssignmentPage.selectSubmitButton();		
		
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();				
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);
		
		//verify the assignment is displayed in the list
		assignmentPage.verifyAssignmentDisplayed(dataMap, "StartFutureDate");

		driver=assignmentPage.getDriver();

	}

	/****Test Case E4-5943: Q/E Assignment - Edit Availability - Data Selector. Due Date value****/
	/********TO DO PENDING***
	@Test
	public void E4_5943() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_5943", driver);

		//Select Course
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//select edit availability 
		assignmentPage.selectActionsEditAvailability(dataMap, "AsgntName");

		//select go
		assignmentPage.selectGoActionButton(dataMap, "AsgntName");

		//verify editable due date
		assignmentPage.verifyEditableDueDate();

		driver=assignmentPage.getDriver();		
	}***/

	/****Test Case E4-1901: Assignments - AE - EA - No Access - No progress - Q/E A - Step 2. Adding/Removing of a new questions******/
	/*******TO DO PENDING*****
	@Test
	public void E4_1901() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1901", driver);
		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		assignmentPage.selectGoActionButton(dataMap, "AsgntName");

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.chooseChapter();

		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.AddNewQuestions(dataMap);

		createEditAssignmentPage.selectSaveAndExit();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.selectAssignmentLink(dataMap);

		createEditAssignmentPage.closeWindow();

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		assignmentPage.selectGoActionButton(dataMap, "AsgntName");

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.chooseChapter();

		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.unCheckfewQuestion();

		createEditAssignmentPage.selectSaveAndExit();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.selectAssignmentLink(dataMap);

		driver= assignmentPage.getDriver();		

	}******/

	/***Test Case E4-1906: Assignments - AE - EA - No Access - No progress - Q/E A - Step 3. "Score" column***/	
	@Test
	public void E4_1906() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1906", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();
		
		/*******PRECONDITION*********/
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectSaveAndExit();
		
		/*******/	

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		assignmentPage.selectGoActionButton(dataMap, "AsgntName");

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.VerifyScoreColumn();

		driver=assignmentPage.getDriver();

	}

	/***Test Case E4-1282: Assignment - Assignment Creator - Questions/Exercises Assignment. Edit Assignment - Unassigned***/	
	/******TO DO PENDING****
	@Test
	public void E4_1282() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1282", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);	

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.removeOneQuestion();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.setAttempts(dataMap);

		createEditAssignmentPage.selectSaveAndExit();

		createEditAssignmentPage.verifyAlertMessageInChangeAttempts();	
		
		driver= assignmentPage.getDriver();		

	}******/
	
	/********Test Case E4-5303: Course Details (Properties) screen Show Work options appearance**********/
	/********TO DO PENDING******
	@Test
	public void E4_5303() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_5303", driver);
	
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), dataMap.get("AdminUrl"));

		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);

		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();

		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();

		//Validate the list of courses in the course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		coursePropertiesPage.verifyAllowShowWorkFrame();

		//close driver()
		Browser.closeDriver(driver);

	}	****/

	/****Test Case E4-1060: Assignments - AC - Q/E Assignment - Step 1. Date and Source***/
	/************TO DO PENDING INPUT FROM CLIENT****
	@Test
	public void E4_1060() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1060", driver);

		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
		
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//verify date
		createEditAssignmentPage.verifyDate(dataMap);

		//verify source
		createEditAssignmentPage.verifySource(dataMap);

		//click my profile
		createEditAssignmentPage.MyProfile(dataMap);

		//click Assignment tab
		courseHomePage.goToAssigmentPage();

		//Click create new assignment
		assignmentPage.goToCreateReadingsAssignment();

		//verify modified source name
		createEditAssignmentPage.verifyModifiedSource(dataMap);		
		
		driver= assignmentPage.getDriver();		

	}*****/

	/****Test Case E4-977: Assignments - AC - Q/E Assignment - Step 2 - Question preview. Links***/

	/*******TO BE DELETED*****
	  @Test 
	public void E4_977() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor- E4-977", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//select Algorithm Quetion Preview
		createEditAssignmentPage.chooseAlgorithmQuestionPreview(dataMap);

		//Select ReportContent
		createEditAssignmentPage.selectReportContent();

		//Select Cancel Button
		createEditAssignmentPage.SelectCancel();

		//Select No in Cancel Window
		createEditAssignmentPage.selectNo();

		//Select Cancel Button
		createEditAssignmentPage.SelectCancel();

		//Select Yes in Cancel Window
		createEditAssignmentPage.selectYes();

		//Select Report Content
		createEditAssignmentPage.selectReportContent();

		//Select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Verify the Alert message
		createEditAssignmentPage.VerifyAlertmessageinQuestionPreview();

		//Verify Report Comment Input
		createEditAssignmentPage.verifylongReportcomments(dataMap);

		createEditAssignmentPage.verifyReportcomments(dataMap);

		createEditAssignmentPage.assignmentLink();		
	}****/
	
	/*****Test Case E4-819: Assignments - AC - Q/E Assignment - Step 1. Sharing*******/	
	@Test
	public void E4_819() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_819", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		LogoutSessionPage logoutSessionPage= PageFactory.initElements(driver, LogoutSessionPage.class);

		//Select Make available to Other Instructor Radio Button 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.chooseChapter();

		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.selectQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionPolicies();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectAssignLaterButton();

		logoutSessionPage.logOutSession();

		home.loginB(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap,"AsgntName");

		logoutSessionPage.logOutSession();

		//Selecting Do Not Share with Other Instructor Radio Button
		home.login(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);

		assignmentPage.selectGoActionButtonNotAssignedToClass(dataMap, "AsgntName");

		createEditAssignmentPage.doNotShareWithOthers();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectSaveAndExit();

		logoutSessionPage.logOutSession();

		home.loginB(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		logoutSessionPage.logOutSession();

		//Selecting Work In Draft Mode Radio Button
		home.login(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);

		assignmentPage.selectGoActionButtonNotAssignedToClass(dataMap, "AsgntName");

		createEditAssignmentPage.workInDraftMode();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectSaveAndExit();

		logoutSessionPage.logOutSession();

		home.loginB(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		logoutSessionPage.logOutSession();

		//Assign to class and verify
		home.login(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);

		assignmentPage.selectGoActionButtonNotAssignedToClass(dataMap, "AsgntName");

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifySelectQuestiontab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionPolicies();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectAssigntoClassButton();

		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.selectSubmitButton();

		logoutSessionPage.logOutSession();

		home.loginB(dataMap);

		courseSelectionPage.selectCourse(dataMap);

		courseHomePage.goToAssigmentPage();

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		logoutSessionPage.logOutSession();

		//close driver()
		Browser.closeDriver(driver);

	}

	/******Test Case E4-1882: Assignments - AC - Q/E Assignment - Step 3 - Question preview. Links******/
	/*****TO BE DELETED*
	@Test
	public void E4_1882() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1882", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectAlgorthimicQuestions();

		createEditAssignmentPage.selectNextButton();

		//select Algorithm Quetion Preview
		createEditAssignmentPage.chooseAlgorithmQuestionPreview(dataMap);

		//Select ReportContent
		createEditAssignmentPage.selectReportContent();

		//Select Cancel Button
		createEditAssignmentPage.SelectCancel();

		//Select No in Cancel Window
		createEditAssignmentPage.selectNo();

		//Select Cancel Button
		createEditAssignmentPage.SelectCancel();

		//Select Yes in Cancel Window
		createEditAssignmentPage.selectYes();

		//Select Report Content
		createEditAssignmentPage.selectReportContent();

		//Select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Verify the Alert message
		createEditAssignmentPage.VerifyAlertmessageinQuestionPreview();

		//Verify Report Comment Input
		createEditAssignmentPage.verifylongReportcomments(dataMap);

		createEditAssignmentPage.verifyReportcomments(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();		
	}***/

	/*******Test Case E4-1886: Assignments - AC - Q/E Assignment - Step 5 - Question preview. Links*******/
	/****TO BE DELETED***
	@Test
	public void E4_1886() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1886", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectAlgorthimicQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionFeedbackCheckbox();

		createEditAssignmentPage.selectNextButton();

		//select Algorithm Quetion Preview
		createEditAssignmentPage.chooseAlgorithmQuestionPreview(dataMap);

		//click change values
		createEditAssignmentPage.clickChangeValues();

		//Select ReportContent
		createEditAssignmentPage.selectReportContent();

		//Select Cancel Button
		createEditAssignmentPage.SelectCancel();

		//Select No in Cancel Window
		createEditAssignmentPage.selectNo();

		//Select Cancel Button
		createEditAssignmentPage.SelectCancel();

		//Select Yes in Cancel Window
		createEditAssignmentPage.selectYes();

		//Select Report Content
		createEditAssignmentPage.selectReportContent();

		//Select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Verify the Alert message
		createEditAssignmentPage.VerifyAlertmessageinQuestionPreview();

		//Verify Report Comment Input
		createEditAssignmentPage.verifylongReportcomments(dataMap);

		createEditAssignmentPage.verifyReportcomments(dataMap);

		//close driver()
		Browser.closeDriver(driver);

	}****/

	/******Test Case E4-1108: Assignments - AC - Q/E Assignment - Step 3. Actions*******/	
	/*******TO DO PENDING*****
	@Test
	public void E4_1108() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1108", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		OpenAssignment openAssignment = PageFactory.initElements(driver, OpenAssignment.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectAlgorthimicQuestions();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		createEditAssignmentPage.verifyRemoveAndDuplicateLink();

		createEditAssignmentPage.removeOneQuestion();

		createEditAssignmentPage.verifyTotalScorevalue(dataMap);

		createEditAssignmentPage.DuplicateQuestion();

		createEditAssignmentPage.verifyTotalScorevalue(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();


		//Description: Select Question Policies in Set Question Policies screen
		createEditAssignmentPage.setQuestionPolicies(dataMap);

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to class button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Description: Select Class from the Select Assign to class screen
		createEditAssignmentPage.assigntoclass(dataMap);

		createEditAssignmentPage.selectSubmitButton();

		//Select created assignment list from Assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//Verify the assignment displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");

		//Selecting Assignment and Editing the Assignment
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		assignmentPage.verifyPreviewWindowAndTotalScore();

		openAssignment.clickNext();

		createEditAssignmentPage.closeWindow();

		driver= assignmentPage.getDriver();

	}****/

	/*****Test Case E4-1473: Assignments - AC - Q/E Assignment - Step 2. Question list sorting******/
	/****TO DO PENDING*****
	@Test
	public void E4_1473() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1473", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input Description Details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//select and verify sorting triangle
		createEditAssignmentPage.selectQuestionNameTriangle();

		//Verify Question Name list
		createEditAssignmentPage.verifyQuestionNameList();

		createEditAssignmentPage.selectQuestionAssistanceTriangle();

		//verify Question Assistance List
		createEditAssignmentPage.verifyQuestionAssistanceList();

		createEditAssignmentPage.selectQuestionTypeTriangle();

		//Verify Question Type List
		createEditAssignmentPage.verifyQuestionTypeList();

		//Verify Question Type List
		createEditAssignmentPage.verifyQuestionTypeList();

		createEditAssignmentPage.selectSourceTriangle();

		//verify source
		createEditAssignmentPage.selectSourceTriangle();

		createEditAssignmentPage.selectDifficultyTriangle();

		//Verify Difficulty list
		createEditAssignmentPage.verifyDifficultyList();

		createEditAssignmentPage.selectTextAssociationTriangle();

		//Verify TextAssociation List
		createEditAssignmentPage.verifyTextAssociationList();

		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}******/

	/******Test Case E4-1727: Assignments - AC - Q/E Assignment - Step 2. Sort parameters persistence******/
	/******TO DO PENDING*****
	@Test
	public void E4_1727() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1727", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input Description Details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");		

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//verify question name triangle
		createEditAssignmentPage.selectQuestionNameTriangle();

		//Verify Question Name list
		createEditAssignmentPage.verifyQuestionNameList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify text association triangle
		createEditAssignmentPage.selectTextAssociationTriangle();

		//Verify TextAssociation List
		createEditAssignmentPage.verifyTextAssociationList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question type
		createEditAssignmentPage.selectQuestionTypeTriangle();

		//Verify Question Type List
		createEditAssignmentPage.verifyQuestionTypeList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question assistance
		createEditAssignmentPage.selectQuestionAssistanceTriangle();

		//verify Question Assistance List
		createEditAssignmentPage.verifyQuestionAssistanceList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify difficulty 
		createEditAssignmentPage.selectDifficultyTriangle();

		//Verify Difficulty list
		createEditAssignmentPage.verifyDifficultyList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify source
		createEditAssignmentPage.selectSourceTriangle();

		//verify source
		createEditAssignmentPage.selectSourceTriangle();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();	

	}*****/
	
	/******Test Case E4-1735: Assignments - AC - Q/E Assignment - Step 2. Sort parameters persistence - search criteria renewed******/
	/*****TO DO PENDING*****
	@Test
	public void E4_1735() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1735", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input Description Details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");		

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//verify question name triangle
		createEditAssignmentPage.selectQuestionNameTriangle();

		//Verify Question Name list
		createEditAssignmentPage.verifyQuestionNameList();

		//Select Save and FindMore Question Button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		//verify text association triangle
		createEditAssignmentPage.selectTextAssociationTriangle();

		//Verify TextAssociation List
		createEditAssignmentPage.verifyTextAssociationList();

		//Select Save and FindMore Question Button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//verify question type
		createEditAssignmentPage.selectQuestionTypeTriangle();

		//Verify Question Type List
		createEditAssignmentPage.verifyQuestionTypeList();

		//Select Save and FindMore Question Button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		//verify question assistance
		createEditAssignmentPage.selectQuestionAssistanceTriangle();

		//verify Question Assistance List
		createEditAssignmentPage.verifyQuestionAssistanceList();		

		//Select Save and FindMore Question Button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//verify difficulty 
		createEditAssignmentPage.selectDifficultyTriangle();

		//Verify Difficulty list
		createEditAssignmentPage.verifyDifficultyList();

		//Select Save and FindMore Question Button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//verify source
		createEditAssignmentPage.selectSourceTriangle();

		//verify Source List
		createEditAssignmentPage.verifySourceList();

		//Select Save and FindMore Question Button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//verify Source List
		createEditAssignmentPage.verifySourceList();

		//close driver()
		Browser.closeDriver(driver);

	}*****/

	/****Test Case E4-4523: Question Assignment Player - Instructor - Assigned. Use same values****/	
	/*****TO DO PENDING****
	@Test
	public void E4_4523() throws Exception	
	{
		ResultUtil.createReport("AssignmentInstructor-createAndValidateNewAssignment", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class); 

		assignmentPage.goToAssignmentList(dataMap);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with algo and non algo questions
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		//focus window
		assignmentPage.focusAssignmentWindow();

		//click next
		openAssignment.clickNext();

		//verify change value
		openAssignment.verifyChangeValue();

		//click change value link
		createEditAssignmentPage.clickChangeValues();

		//click close
		createEditAssignmentPage.closeWindow();

		//open assignment with algo and non algo questions
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();

		//verify change value
		openAssignment.verifyChangeValue();
		
		driver= assignmentPage.getDriver();		
		
	}*****/
	/****Test Case E4-4524: Question Assignment Player - Instructor - Assigned. Use new values****/
	/******TO DO PENDING*****
	@Test
	public void E4_4524() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4524", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		
		assignmentPage.goToAssignmentList(dataMap);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with algo and non algo questions
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		//focus window
		assignmentPage.focusAssignmentWindow();

		//click next
		openAssignment.clickNext();

		//verify change value
		openAssignment.verifyChangeValue();

		//click change value link
		createEditAssignmentPage.clickChangeValues();

		//click close
		createEditAssignmentPage.closeWindow();

		//open assignment with algo and non algo questions
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();

		//verify change value
		openAssignment.verifyChangeValue();

		//close driver()
		Browser.closeDriver(driver);

	}****/

	/****Test Case E4-4525: Question Assignment Player - Instructor - Assigned. Use static values****/
	/******TO DO PENDING*****
	@Test
	public void E4_4525() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4525", driver);

		AssignmentPage assignmentPage=PageFactory.initElements(driver, AssignmentPage.class);

		assignmentPage.goToAssignmentList(dataMap);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with algo and non algo questions
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		//focus window
		assignmentPage.focusAssignmentWindow();

		//click next
		openAssignment.clickNext();

		//verify change value
		openAssignment.verifyChangeValue();

		//click change value link
		createEditAssignmentPage.clickChangeValues();

		//click close
		createEditAssignmentPage.closeWindow();

		//open assignment with algo and non algo questions
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();

		//verify change value
		openAssignment.verifyChangeValue();
		//click close
		createEditAssignmentPage.closeWindow();

		driver= assignmentPage.getDriver();		
	}*****/

	/*****Test Case E4-955: Assignments - AC - Q/E Assignment - Step 2. Question preview in a pop-up window******/
	/******TO DO PENDING*****
	@Test
	public void E4_955() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_955", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);		
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();	

		//Input Description Details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");		

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		createEditAssignmentPage.selectGoBtn();
		//Verify Mouse Hover
		createEditAssignmentPage.moveOnQuestion();

		//verify Mouse hover Out of the link
		createEditAssignmentPage.quesitonLinkMove();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();	

	}***/

	/*******Test Case E4-1009: Assignments - AC - Q/E Assignment - Step 3. Question preview in a pop-up window********/
	/*****TO DO PENDING****
	@Test
	public void E4_1009() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1009", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input Description Details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");		

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//Select Questions
		createEditAssignmentPage.selectQuestions();

		//Select Next Button
		createEditAssignmentPage.selectNextButton();

		//Verify Mouse Hover
		createEditAssignmentPage.moveOnQuestion();

		//verify Mouse hover Out of the link
		createEditAssignmentPage.quesitonLinkMove();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}*****/

	/********Test Case E4-1293: Assignments - AC - Q/E Assignment - Step 3. Require Show Work******/	
	@Test
	public void E4_1293() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1293", driver);

		String strEnv=Prerequsite.configMap.get("ENV");				

		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();		

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Input Description Details 
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "ShowWorkAssigntID", "ShowWorkAssignName");		

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		createEditAssignmentPage.selectGoBtn();

		//Select Questions
		createEditAssignmentPage.selectQuestions();

		//Select Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Required Show Work
		createEditAssignmentPage.selectRequiredShowWork();

		//click next
		createEditAssignmentPage.selectNextButton();

		//Verify Set Question Policies
		createEditAssignmentPage.verifyQuestionPoliciesTab();

		//click next
		createEditAssignmentPage.selectNextButton();

		//Click Assign to class Button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Select Class Section
		createEditAssignmentPage.assigntoclass(dataMap);

		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//close window 
		createEditAssignmentPage.closeWindow1();

		//Navigate to Student Url
		Browser.navigateURL(driver, strStudentURL);

		//Student Login
		studentLoginpage.loginPage(dataMap);

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "ShowWorkAssignName");

		//click Next
		openAssignment.clickNext();

		//click Next
		openAssignment.clickNext();

		//click Next
		openAssignment.clickNext();

		//answer question
		openAssignment.answerQuestions();

		//Select Submit
		openAssignment.selectSubmitAnswer();

		//select alert Message
		openAssignment.alertDismiss();

		//click Back
		openAssignment.clickBack();

		//answer question
		openAssignment.answerQuestions();

		//Select Submit
		openAssignment.selectSubmitAnswer();

		//close driver()
		Browser.closeDriver(driver);

	}	

	/*****Test Case E4-1907: Assignments - AC - Q/E Assignment - Step 3. Duplication of questions*****/
	/********TO DO PENDING********
	@Test
	public void E4_1907() throws Exception		
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1907", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		String strAdminURL= Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL

		driver= Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strAdminURL);
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);

		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();

		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();

		//Validate the list of courses in the course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		coursePropertiesPage.duplicatingAlgorthimicQuestion();

		Browser.navigateURL(driver, strURL);
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter 
		createEditAssignmentPage.chooseChapter();

		//Select Question
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//click Duplicate link
		createEditAssignmentPage.DuplicateQuestion();

		//Click Back Button
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify question Checkbox
		createEditAssignmentPage.verifyQuestionsCheckBox();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Click Remove Link
		createEditAssignmentPage.removeOneQuestion();

		//Click Back Button
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify question Checkbox
		createEditAssignmentPage.verifyQuestionsCheckBox();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Click Remove Link
		createEditAssignmentPage.removeOneQuestion();

		//Click Back Button
		createEditAssignmentPage.selectBackButtonNavigate();

		//Verify question Checkbox
		createEditAssignmentPage.verifyQuestionsCheckBox();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}*****/
		
	/*****Test Case E4-1355: Assignments - AC - Q/E Assignment - Step 4. Question Feedback******/
	@Test
	public void E4_1355() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1355", driver);

		String strEnv=Prerequsite.configMap.get("ENV");				

		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");	

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();			

		StudentGradeBookPage studentGradeBookPage = PageFactory.initElements(driver, StudentGradeBookPage.class);

		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);

		AssignmentResultsPage assignmentResultsPage = PageFactory.initElements(driver, AssignmentResultsPage.class);

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Input Description Details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Choose Chapter
		createEditAssignmentPage.chooseChapter();

		createEditAssignmentPage.selectGoBtn();

		//select Question
		createEditAssignmentPage.selectQuestions();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//verify question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//click Disable Feedback
		createEditAssignmentPage.disableFeedback();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//click Assign to Class Button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Assign to class
		createEditAssignmentPage.assigntoclass(dataMap);

		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Navigate to Student URl
		Browser.navigateURL(driver, strStudentURL);

		//Login as Student 
		studentLoginpage.loginPage(dataMap);

		//click Assignment tab
		studentHomepage.goToAssignment();

		//select assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//Click Next Button	
		openAssignment.clickNext();

		//Enter text question
		openAssignment.answerQuestions();

		//click Submit Answer
		openAssignment.selectSubmitAnswer();

		//Verify comment
		openAssignment.verifyComment();

		//click Gradebook
		studentHomepage.goToGradeBook();	

		//Select Assignment GradeBook
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntName");

		//Verify First Attempt
		assignmentResultsPage.verifyFirstAttempt();

		//Navigate to Instructor Page
		Browser.navigateURL(driver, strURL);

		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//Select GradeBook Tab
		courseHomePage.goToGradebookPage();

		//Select Class Section
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click Go Button
		gradeBookPage.clickGoButton();

		//Select student  Link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");

		//Select Assignment Link
		gradeBookPage.clickAssignmentLink(dataMap, "AsgntName");

		//select Question Link
		gradeBookPage.clickByQuestionName(dataMap, "NonAlgorthimQuestion");

		//Focus window
		assignmentPage.focusAssignmentWindow();

		//verify the feedback
		gradeBookPage.verifyStudentGradedFeedback();

		//Navigate to Student Page
		Browser.navigateURL(driver, strStudentURL);

		//Login as Student 
		studentLoginpage.loginPage(dataMap);

		//click Assignment tab
		studentHomepage.goToAssignment();

		//select assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//Click Next Button	
		openAssignment.clickNext();

		//Verify FeedBack
		openAssignment.verifyComment();

		//Navigate to GradeBook
		studentHomepage.goToGradeBook();	

		//Select Assignment GradeBook
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntName");

		//Verify First Attempt
		assignmentResultsPage.verifyFirstAttempt();

		//close driver()
		Browser.closeDriver(driver);

	}	

	/******Test Case E4-1537: Assignments - AC - Q/E Assignment - Step 2. Question search - multiselect - intersection - 3 fields********/		
	@Test
	public void E4_1537() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1537", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//select Multiple chapters, sections and level
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		createEditAssignmentPage.multiSelectSection(dataMap);

		createEditAssignmentPage.multiSelectLevel(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();	

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple chapters, sections and source
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		createEditAssignmentPage.multiSelectSection(dataMap);

		createEditAssignmentPage.multiSelectSource(dataMap);		

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple section, source and levels
		createEditAssignmentPage.multiSelectSection(dataMap);

		createEditAssignmentPage.multiSelectLevel(dataMap);

		createEditAssignmentPage.multiSelectSource(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple chapters, levels and sources
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		createEditAssignmentPage.multiSelectLevel(dataMap);

		createEditAssignmentPage.multiSelectSource(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();		
	}
	/******Test Case E4-875: Assignments - AC - Q/E Assignment - Step 2. Question search - multiselect - intersection - 2 fields*********/
	@Test
	public void E4_875() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_875", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Multiple chapters and section
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		createEditAssignmentPage.multiSelectSection(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple sections and levels
		createEditAssignmentPage.multiSelectSection(dataMap);

		createEditAssignmentPage.multiSelectLevel(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select multiple levels and sources
		createEditAssignmentPage.multiSelectLevel(dataMap);

		createEditAssignmentPage.multiSelectSource(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select multiple chapters and levels
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		createEditAssignmentPage.multiSelectLevel(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select multiple chapters and sources
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		createEditAssignmentPage.multiSelectSource(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select multiple sections and sources 
		createEditAssignmentPage.multiSelectSection(dataMap);

		createEditAssignmentPage.multiSelectSource(dataMap);

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableDisplayed();

		createEditAssignmentPage.selectSaveAndFindButton();

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();	
	}

	/******Test Case E4-1382: Assignments - AC - Q/E Assignment - Step 2. Question search - multiselect - single field*******/	
	@Test
	public void E4_1382() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1382", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Multiple Chapter
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple chapter
		createEditAssignmentPage.multiSelectSection(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple Level
		createEditAssignmentPage.multiSelectLevel(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple Source
		createEditAssignmentPage.multiSelectSource(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();		

		createEditAssignmentPage.SelectLearningObjective(dataMap);

		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();			

	}

	/****Test Case E4-4538: Question Assignment Player - Instructor - Assigned. Numeric Policies****/
	/*****TO DO PENDING******
	@Test
	public void E4_4538() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4538", driver);		
		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);	
		
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
		
		//Goto Create Edit Assignment page
		assignmentPage.goToAssignmentList(dataMap);	

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open an assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//navigate to first window
		assignmentPage.focusAssignmentWindow();

		//verify description page
		openAssignment.verifyDescriptionPage(); 

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();

	}***/

	/*******Test Case E4-1357: Assignments - AC - Q/E Assignment - Step 4. Change Values of Algorithmic Questions - same values********/
	/******TO DO PENDING*****
	@Test
	public void E4_1357() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1357", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");		

		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		LogoutSessionPage logoutSessionPage= PageFactory.initElements(driver, LogoutSessionPage.class);


		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Choose Chapter
		createEditAssignmentPage.chooseChapter();

		//select Algorthimic Question
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Use Same Values Radio Button
		createEditAssignmentPage.selectSameValuesRadioButton();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to Class Button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Select Class Section Check box
		createEditAssignmentPage.assigntoclass(dataMap);

		//Select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Navigate to Student Url
		Browser.navigateURL(driver, strStudentURL);

		//Student Login A
		studentLoginpage.loginPage(dataMap);

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click Next
		openAssignment.clickNext();

		//Verify Questions present
		openAssignment.verifyQuestions();

		//Answer Questions
		openAssignment.answerQuestions();

		//Logout Session
		logoutSessionPage.logOutSession();

		//Student Login B
		studentLoginpage.loginPageStudent(dataMap, "Email B", "Password B");

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click Next
		openAssignment.clickNext();

		//Verify Questions present
		openAssignment.verifyQuestions();

		//Answer Questions
		openAssignment.answerQuestions();

		//Logout Session
		logoutSessionPage.logOutSession();

		//close driver()
		Browser.closeDriver(driver);

	}***/

	/*******Test Case E4-1681: Assignments - AC - Q/E Assignment - Step 4. Change Values of Algorithmic Questions - new values********/	
	/******TO DO PENDING******
	@Test	
	public void E4_1681() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1681", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");


		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		LogoutSessionPage logoutSessionPage= PageFactory.initElements(driver, LogoutSessionPage.class);		

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Choose Chapter
		createEditAssignmentPage.chooseChapter();

		//select Algorthimic Question
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//click New Values Radio Button
		createEditAssignmentPage.selectNewValuesRadioButton();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to Class Button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Select Class Section Check box
		createEditAssignmentPage.assigntoclass(dataMap);

		//Select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Navigate to Student Url
		Browser.navigateURL(driver, strStudentURL);

		//Student Login A
		studentLoginpage.loginPage(dataMap);

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click Next
		openAssignment.clickNext();

		//Verify Questions present
		openAssignment.verifyQuestions();

		//Answer Questions
		openAssignment.answerQuestions();

		//Logout Session
		logoutSessionPage.logOutSession();

		//Student Login B
		studentLoginpage.loginPageStudent(dataMap, "Email B", "Password B");

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click Next
		openAssignment.clickNext();

		//Verify Questions present
		openAssignment.verifyQuestions();

		//Answer Questions
		openAssignment.answerQuestions();

		//Logout Session
		logoutSessionPage.logOutSession();

		//closedriver()
		Browser.closeDriver(driver);

	}*****/

	/*******Test Case E4-1711: Assignments - AC - Q/E Assignment - Step 4. Change Values of Algorithmic Questions - static values*******/
	/***********TO DO PENDING*****
	@Test
	public void E4_1711() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1711", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");			

		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		LogoutSessionPage logoutSessionPage= PageFactory.initElements(driver, LogoutSessionPage.class);

		//Student login
		StudentLoginpage studentLoginpage=PageFactory.initElements(driver,StudentLoginpage.class );

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		//student assignment page
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Choose Chapter
		createEditAssignmentPage.chooseChapter();

		//select Algorthimic Question
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Click static value radio button
		createEditAssignmentPage.selectStaticValuesRadioButton();

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Assign to Class Button
		createEditAssignmentPage.selectAssigntoClassButton();

		//Select Class Section Check box
		createEditAssignmentPage.assigntoclass(dataMap);

		//Select Submit Button
		createEditAssignmentPage.selectSubmitButton();

		//Navigate to Student Url
		Browser.navigateURL(driver, strStudentURL);

		//Student Login A
		studentLoginpage.loginPage(dataMap);

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click Next
		openAssignment.clickNext();

		//Verify Questions present
		openAssignment.verifyQuestions();

		//Answer Questions
		openAssignment.answerQuestions();

		//Logout Session
		logoutSessionPage.logOutSession();

		//Student Login B
		studentLoginpage.loginPageStudent(dataMap, "Email B", "Password B");

		//Select Assignment Tab
		studentHomepage.goToAssignment();

		//Select Assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click Next
		openAssignment.clickNext();

		//Verify Questions present
		openAssignment.verifyQuestions();

		//Answer Questions
		openAssignment.answerQuestions();

		//Logout Session
		logoutSessionPage.logOutSession();

		//clos edriver()
		Browser.closeDriver(driver);

	}*****/

	/******Test Case E4-4505: Question Assignment Player - Instructor - Unassigned. Description & Policies*******/
	/*******TO DO PENDING*****
	@Test
	public void E4_4505() throws Exception	
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4505", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Choose Chapter
		createEditAssignmentPage.chooseChapter();

		//select Algorthimic Question
		createEditAssignmentPage.selectAlgorthimicQuestions();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//verify Question Order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//click Next Button
		createEditAssignmentPage.selectNextButton();

		//Verify and Select Policies settings
		createEditAssignmentPage.VerifyAndSelectCheckbox();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Click Assign Later Button
		createEditAssignmentPage.selectAssignLaterButton();

		//select Assignment
		assignmentPage.goToAssignmentList(dataMap);

		//Click on AssignmentLink
		assignmentPage.selectAssignmentLink(dataMap);

		//Focus Assignment Window
		assignmentPage.focusAssignmentWindow();

		//verify Description Policies
		openAssignment.verifyDescriptionPage();

		//Close the window
		createEditAssignmentPage.closeWindow();

		//close driver()
		Browser.closeDriver(driver);

	}*****/
	/******Test Case E4-4587: Assignments - Questions page. Disappearing drop-down menus. Flow case*******/
	/********TO DO PENDING******
	@Test
	public void E4_4587() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_4587", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		StudentReadStudyPracticePage studentReadStudyPracticePage = PageFactory.initElements(driver, StudentReadStudyPracticePage.class);

		//student home page
		StudentHomepage studentHomepage= PageFactory.initElements(driver, StudentHomepage.class);

		QuestionPage questionPage=PageFactory.initElements(driver, QuestionPage.class);

		//Navigate to Student Window
		courseHomePage.switchToStudentAndInstructorView();

		//Select Class
		courseHomePage.chooseClassSelection(dataMap);

		//Navigate to Read Study & Practice Tab
		studentHomepage.goToReadStudyPracticeTab();

		//Select Study Objective
		studentReadStudyPracticePage.selectStudyObjective(dataMap);

		//Select Chapter
		studentReadStudyPracticePage.selectBrowseChapter(dataMap);

		//Select Study Objective Exercises Link
		studentReadStudyPracticePage.selectStudyObjectiveLink();

		//Focus Assignment Window
		assignmentPage.focusAssignmentWindow();

		//Close the window
		createEditAssignmentPage.closeWindow();

		//Switch to Frames
		courseHomePage.switchToFrames();

		//Navigate to Instructor view
		courseHomePage.switchToStudentAndInstructorView();

		//Go to Assignment Page
		courseHomePage.goToAssigmentPage();

		//Go to Question Page
		assignmentPage.selectionQuestionLink();

		//Go to QuestionList
		questionPage.goToQuestionList(dataMap);

		//verify Question Preview
		questionPage.verifyQuestionDropDown();

		//closedriver()
		Browser.closeDriver(driver);

	}******/
	
	/******Test Case E4-1800: Assignments - AC - Q/E Assignment - Step 4. "Configure numeric questions" link*******/
	@Test
	public void E4_1800() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1800", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();	

		//navigate to domain
		Browser.navigateURL(driver, dataMap.get("DomainURL"));

		//login
		home.algorithmicLogin(dataMap);

		//go to assignment page
		courseHomePage.goToAssigmentPage();

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//Input Description
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseNumericQuestionChapter();

		//Click Go Button
		createEditAssignmentPage.selectGoBtn();

		//select questions
		createEditAssignmentPage.selectNumericQuestions();

		//click next
		createEditAssignmentPage.selectNextButton();

		//click next to navigate to set question policies
		createEditAssignmentPage.selectNextButton();

		//click configure numeric policies
		createEditAssignmentPage.selectConfigureNumericPolicies();

		//focus window 1
		assignmentPage.focusAssignmentWindow();

		//verify configure numeric policies page
		createEditAssignmentPage.verifyConfigureNumericPoliciesWindow(dataMap);

		//verify Default Tolerance
		createEditAssignmentPage.verifyDefaultToleranceValue();

		//verify Enable significant Digits and Question Tolerance
		createEditAssignmentPage.verifyEnableSignificantDigitsQuestionTolerance();

		//close Window
		createEditAssignmentPage.closeWindow();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Click Back Button
		createEditAssignmentPage.selectBackButtonNavigate();

		//click configure numeric policies
		createEditAssignmentPage.selectConfigureNumericPolicies();

		//focus window 1
		assignmentPage.focusAssignmentWindow();

		//Select Enable Significant Digits and Question Tolerance
		createEditAssignmentPage.selectEnableSignificantDigitsQuestionTolerance();

		//Update Window
		createEditAssignmentPage.selectUpdateButton();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Verify Confirmation Page
		createEditAssignmentPage.verifyConfirmationPage();

		//click Assignment Link
		createEditAssignmentPage.assignmentLink();

		//closedriver()
		Browser.closeDriver(driver);

	}

	/*****Test Case E4-1887: Assignments - AC - Q/E Assignment - Step 4. Help for Tolerance and Significant Digits******/
	/******TO DO PENDING*******
	@Test
	public void E4_1887() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1887", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);				
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input Description
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseNumericQuestionChapter();

		//Click Go Button
		createEditAssignmentPage.selectGoBtn();

		//select questions
		createEditAssignmentPage.selectNumericQuestions();

		//click next
		createEditAssignmentPage.selectNextButton();

		//click next to navigate to set question policies
		createEditAssignmentPage.selectNextButton();

		//click configure numeric policies
		createEditAssignmentPage.selectConfigureNumericPolicies();

		//focus window 1
		assignmentPage.focusAssignmentWindow();

		//Verify Help For Tolerance And Significant Digit
		createEditAssignmentPage.verifyHelpToleranceAndSignificantDigit();

		//close Window
		createEditAssignmentPage.closeWindow();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Click Back Button
		createEditAssignmentPage.selectBackButtonNavigate();

		//click configure numeric policies
		createEditAssignmentPage.selectConfigureNumericPolicies();

		//focus window 1
		assignmentPage.focusAssignmentWindow();

		//Select Enable Significant Digits and Question Tolerance
		createEditAssignmentPage.selectEnableSignificantDigitsQuestionTolerance();

		//select Help Tolerance And Significant Digit
		createEditAssignmentPage.selectHelpToleranceAndSignificantDigit();

		//Update Window
		createEditAssignmentPage.selectUpdateButton();

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Verify Confirmation Page
		createEditAssignmentPage.verifyConfirmationPage();

		//click Assignment Link
		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}******/

	/******Test Case E4-1370: Assignments - AC - Q/E Assignment - Step 2. Question search - intersection - 2 fields*****/
	
	@Test
	public void E4_1370() throws Exception
	{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1370", driver);

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);				
		
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();		

		//Select One Chpater and one Section
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one section and one level
		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneLevel(); 

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one Level and one Source
		createEditAssignmentPage.selectOneLevel(); 

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one Chapter and one Level
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneLevel(); 

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one Chapter and one Source
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one Section and one Source
		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//click Assignment Link
		createEditAssignmentPage.assignmentLink();

		driver= assignmentPage.getDriver();

	}

	/******Test Case E4-5944: Q/E Assignment - Edit Availability - Data Selector. Due Date value*****/
	@Test
	public void E4_5944() throws Exception{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_5944", driver);
		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		
		//GoTo CreateEditAssignmentPAge
		CreateEditAssignmentPage createEditAssignmentPage=assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "DueDateSelector", "DueDateSelector");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();
		
		//select questions
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.verifyPointPotentialSetting(dataMap);
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectAssigntoClassButton();
		
		createEditAssignmentPage.assigntoclass(dataMap);
		
		createEditAssignmentPage.selectSubmitButton();
		
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();
				
		assignmentPage.goToAssignmentList(dataMap);
		
		assignmentPage.selectActionsEditAvailability(dataMap, "DueDateSelector");
		
		assignmentPage.selectGoActionButton(dataMap, "DueDateSelector");
		
		assignmentPage.verifyEditableDueDate();
		
		createEditAssignmentPage.assignmentLink();		
	}
	
	/****Test Case E4-4565: Question Assignment Player - Instructor - Assigned. Review Score****/	
	
	@Test
	public void E4_4565() throws Exception{
		ResultUtil.report("INFO", "AssignmnetInstructor-E4_4565", driver);
		
		/*******PRECONDITION********/		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".SPECIFIC_QUESTION_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
	
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
						
		home.studentLogin(dataMap, "DomainEmail", "DomainPassword");
				
		//Select Course
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
				
		courseHomePage.getDriver();
		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage().getDriver();
		
		//Object for CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
				
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntSubmitScoreEditID1", "AsgntSubmitScoreEditName1");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.deselectAllChapter();
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForSubmitScoreEditPre(dataMap);
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Check Apply point potential
		createEditAssignmentPage.setQuestionPolicies(dataMap);
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Click Assign to class button
		createEditAssignmentPage.selectAssigntoClassButton();
		
		//Select the Class to be Assigned
		createEditAssignmentPage.assigntoclass(dataMap);
		
		//Check No due Date
		createEditAssignmentPage.verifyAndCheckDueDate(dataMap);
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();
		/********************************************/
		
		//open assignment page
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment for studyobjective		
		openAssignment.selectMultiQuestionAssignment(dataMap);
		
		assignmentPage.focusAssignmentWindow();	

		//verify the presence and click  review score
		openAssignment.clickReviewScore();
		
		openAssignment.verifyReviewScoreScreenShot();
		
		//verify answered column
		openAssignment.verifyCheckAnsweredColumn();
				
		openAssignment.verifyAllQuestions();			

		//close window
		assignmentPage.closeWindow();
	
	}
	
	/***********Test Case E4-1920: Assignments - AE - EA - UA - No progress - Q/E A - Step 3. "Score" column*********/
	@Test
	public void E4_1920() throws Exception{
		ResultUtil.report("INFO", "AssignmentInstructor-E4_1906", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();
		
		/*******PRECONDITION*********/
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "ScoreValue", "ScoreValue");
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectQuestions();
		
		createEditAssignmentPage.selectNextButton();
		
		createEditAssignmentPage.selectSaveAndExit();
		
		/*******/	

		assignmentPage.goToAssignmentList(dataMap);

		assignmentPage.verifyAssignmentDisplayed(dataMap, "ScoreValue");

		assignmentPage.selectAssingmentInList(dataMap, "ScoreValue");

		assignmentPage.selectGoActionButton(dataMap, "ScoreValue");

		createEditAssignmentPage.verifyAlertMessageInAssignPage();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.selectNextButton();

		createEditAssignmentPage.VerifyScoreColumn();
		
		createEditAssignmentPage.enterDecimalValue(dataMap);
		
		createEditAssignmentPage.enterFractiolValue(dataMap);
		
		createEditAssignmentPage.enterHighestValues(dataMap);
		
		createEditAssignmentPage.enterSybmbolInScoreValue(dataMap);

		driver=assignmentPage.getDriver();
		
	}
	
	
	
}

