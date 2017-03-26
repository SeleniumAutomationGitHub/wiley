package Scripts.Assignments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.CreateNewQuestionPage;
import Pages.Assignments.CreateQuestionPoolPage;
import Pages.Assignments.OpenAssignment;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.QuestionPage;
import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Util.AssignmentsDataProviderUtil.staticProviderClass;



public class AssignmentPrintedTest {

	WebDriver driver=null;
	Map<String,String> dataMap =null;

	@Factory(dataProvider="AssignmentPrintedTest",dataProviderClass=staticProviderClass.class)
	public AssignmentPrintedTest(Map<String,String> dataMap){
		this.dataMap=dataMap;		
	}

	@Test
	public void assignmentPrintedTestPrerequisite() throws Exception{

		ResultUtil.report("INFO", "AssignmentPrintedTest-assignmentPrintedTestPrerequisite", driver);

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

	/****Test Case E4-1995: Assignments - AC - PT Assignment - Step 2. Question preview in a pop-up window****/
	/******TO DO PENDING*****
	@Test
	public void E4_1995() throws Exception

	{
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1995", driver);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//GoTo CreateEditAssignmentPAge
		CreateEditAssignmentPage createEditAssignmentPage=assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//mouse hover on question
		createEditAssignmentPage.moveOnQuestion();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}*****/
	
	/******Test Case E4-1420: Assignments - AC - Printed Test Assignment - Step 1. Symbols count limit**/

	@Test
	public void E4_1420() throws Exception
	{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

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

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}
	/******Test Case E4-1421: Assignments - AC - Printed Test Assignment - Step 1. Required fields******/

	@Test

	public void E4_1421() throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();	


		//Verifying Untitled Alert Message		
		createEditAssignmentPage.verifyAssignmentisUntitledAlert(dataMap);

		//Verify Assignment Id Empty Alert Message
		createEditAssignmentPage.verifyAssignmentIDEmptyAlert(dataMap);

		//Verify Assignment Name Untitled Alert Message 
		createEditAssignmentPage.verifyAssignmentUntitledAlert(dataMap);

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		//go to create assignmnet
		assignmentPage.goToCreateEditAssignmentPage();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}

	/**********Test Case E4-1981: Assignments - AC - PT Assignment - Step 2. "Show per page" drop-down***********/

	@Test

	public void E4_1981() throws Exception
	{

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Verify 10 questions displayed
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 20 questions displayed
		createEditAssignmentPage.selectTwentyQuestionPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 30 questions displayed
		createEditAssignmentPage.selectThirtyQuestionsPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 50 questions displayed
		createEditAssignmentPage.selectFiftyQuestionsPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying 100 questions displayed
		createEditAssignmentPage.selectHundredQuestionPerPage(dataMap);

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//Verifying All questions displayed
		createEditAssignmentPage.selectAllQuestionPerPage(dataMap);

		//select go
		createEditAssignmentPage.selectGo();

		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();

		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}
	/*****Test Case E4-956: Assignments - AC - Q/E Assignment - Step 2 - Question preview. Question Preview window****/
	@Test
	public void E4_956() throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//Select NonAlgorithmQuestion preview link
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		//close window1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Select Algorithm Question preview window
		createEditAssignmentPage.selectAlgorithmQuestionPreview(dataMap);

		//close window1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}
	
	/*****Test Case E4-1989: Assignments - AC - PT Assignment - Step 2. Question search - single selection******/
	@Test
	public void E4_1989() throws Exception
	{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Select one Chapter from the list and verify the table
		createEditAssignmentPage.selectSingleChapter(dataMap);

		//Select level from the list and verify the table
		createEditAssignmentPage.selectSingleLevel(dataMap);

		//Select Source from the list and verify the table
		createEditAssignmentPage.selectSingleSource(dataMap);

		//Select Chapter, Level and Source from the list and verify the table
		createEditAssignmentPage.selectSingleChapterSingleLevelSingleSource(dataMap);

		////Description: Select Chapter, Level and Source from the list and Select Learn Objective from the dropdown
		createEditAssignmentPage.SelectLearningObjective(dataMap);

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}

	/******Test Case E4-968: Assignments - AC - Q/E Assignment - Step 2 - Question preview. Question Assistance buttons******/
	@Test
	public void E4_968() throws Exception
	{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Select one chapter for question preview
		createEditAssignmentPage.selectChapterForQuestionPreview(dataMap);

		//Select one question link for the preview
		createEditAssignmentPage.selectQuestionPreview(dataMap);

		//Select Link to Text button and verify the window
		createEditAssignmentPage.verifyLinktoText(dataMap);

		//close window1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}

	/*****Test Case E4-1990: Assignments - AC - PT Assignment - Step 2. Navigation buttons*****/
	@Test
	public void E4_1990() throws Exception
	{

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//Verify the Alert Message When no question selected
		//createEditAssignmentPage.verifyAlertMessage(dataMap);

		//Select Questions from the displayed list
		createEditAssignmentPage.selectQuestions();

		//Select Next button
		createEditAssignmentPage.selectNextButton();

		//Select Back button Navigate to Select Questions screen
		createEditAssignmentPage.selectBackButtonNavigate();

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Cancel button and navigate to Assignment page
		createEditAssignmentPage.selectCancelButton();

		// Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

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
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//Re- Select Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage();

		//Re-Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Re-Enter Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//Re-Enter Select Questions from the displayed list
		createEditAssignmentPage.selectQuestions();

		//Select Save and Exit Button to navigate to main screen
		createEditAssignmentPage.selectSaveAndExit();	

		//Verify Assignment is Created
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		driver=assignmentPage.getDriver();

	}

	/*****Test Case E4-883: Assignments - AC - Q/E Assignment - Step 2. Page Navigator drop-down*******/
	@Test
	public void E4_883() throws Exception
	{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Select Chapter from the list
		createEditAssignmentPage.chooseChapter();

		//select questions ten per page
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);

		//select go
		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.verifyPageNavigator(dataMap);

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}

	/*****Test Case E4-405: Assignment - Assignment Creator - Printed Test Assignment. Create new Assignment***************/
	@Test
	public void E4_405() throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//Select one chapter for question preview
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//Select one question link for the preview
		createEditAssignmentPage.selectQuestions();

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//Click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//Set show per page to all.
		createEditAssignmentPage.selectAllQuestionPerPage(dataMap);

		//select go
		assignmentPage.clickGo();

		//Verify assignment is present in list
		assignmentPage.selectNotAssignedAssignmentLink(dataMap);

		driver=assignmentPage.getDriver();
	}

	

				
	/****Test Case E4-4717: Printed Test AC - Step 1 - Initial View***********/	
	@Test
	public void E4_4717() throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-E4_4717", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Verify the page Elements
		createEditAssignmentPage.verifyPageElements();
		
		createEditAssignmentPage.verifyDescriptionDetailsScreenshot();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-4726: Printed Test AC - Step 1 - Configure Page Setup - Footer****/
	/****TO BE DELETED******/
	
	/****Test Case E4-4725: Printed Test AC - Step 1 - Configure Page Setup - Header*******/
	/*****TO BE DELETED******/
	
	/****Test Case E4-4724: Printed Test AC - Step 1 - Configure Page Setup - Question placement*****/
	/******TO BE DELETED****/
	

	/****Test Case E4-4718: Printed Test AC - Step 1 - Number of Versions - One version****/
	/*******TO BE DELETED******
	@Test
	public void E4_4718( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//check the Versions dropBox
		createEditAssignmentPage.verifyVersionDropbox();

		//Select an version
		createEditAssignmentPage.selectVersion1();

		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectSaveAndExit();

		//Click go
		assignmentPage.clickGo();

		//open Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//Click preview without Answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//Click With Answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//Close Window
		createEditAssignmentPage.closeWindow2();

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}****/
	
	/****Test Case E4-4719: Printed Test AC - Step 1 - Number of Versions - Two versions****/
	/*******TO BE DELETED*****
	@Test
	public void E4_4719( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//check the Versions dropBox
		createEditAssignmentPage.verifyVersionDropbox();

		//Select an version
		createEditAssignmentPage.selectVersion2();

		//Verify Scramble questions
		createEditAssignmentPage.verifyScramble();

		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectSaveAndExit();

		//select go
		assignmentPage.clickGo();

		//open version2 Assignment
		createEditAssignmentPage.openAssignmentVersion2(dataMap);

		//open version1 Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//Click preview without Answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//open version1 Assignment with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close version1 assignment
		createEditAssignmentPage.closeWindow2();

		//close version1 assignment
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//open version2 Assignment
		createEditAssignmentPage.openAssignmentVersion2(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//close version1 assignment
		createEditAssignmentPage.closeWindow2();	

		//Click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close version1 assignment
		createEditAssignmentPage.closeWindow2();

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}****/
	/****Test Case E4-4720: Printed Test AC - Step 1 - Number of Versions - Ten versions****/
	/******TO BE DELETED*****
	@Test
	public void E4_4720( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//check the Versions dropBox
		createEditAssignmentPage.verifyVersionDropbox();

		//Select version ten
		createEditAssignmentPage.selectVersion10();

		//Verify Scramble Questions
		createEditAssignmentPage.verifyScramble();

		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectSaveAndExit();

		//select go
		assignmentPage.clickGo();

		//Open Version10 Assignment
		createEditAssignmentPage.openAssignmentVersion10(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Open Version1 Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//Click preview without Answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//open version2 Assignment
		createEditAssignmentPage.openAssignmentVersion2(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Open Version10 Assignment
		createEditAssignmentPage.openAssignmentVersion10(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}*****/
	
	/****Test Case E4-4721: Printed Test AC - Step 1 - Scramble Questions - Two versions****/
	/******TO BE DELETED*****
	@Test
	public void E4_4721( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//check the Versions dropBox
		createEditAssignmentPage.verifyVersionDropbox();

		//Select an version
		createEditAssignmentPage.selectVersion2();

		//Check Scramble Question
		createEditAssignmentPage.checkScramble();

		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectSaveAndExit();

		//select go
		assignmentPage.clickGo();

		//open version2 Assignment
		createEditAssignmentPage.openAssignmentVersion2(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//open version1 Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//Click preview without Answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//open version2 Assignment
		createEditAssignmentPage.openAssignmentVersion2(dataMap);

		//click preview without answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();

		//close window1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}*****/
	
	/****Test Case E4-4722: Printed Test AC - Step 1 - Scramble Questions - Ten versions****/	
	@Test
	public void E4_4722( ) throws Exception{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//check the Versions dropBox
		createEditAssignmentPage.verifyVersionDropbox();

		//Select version ten
		createEditAssignmentPage.selectVersion10();

		//Check Scramble Question
		createEditAssignmentPage.checkScramble();

		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectSaveAndExit();

		//select go
		assignmentPage.clickGo();

		//Open Version10 Assignment
		createEditAssignmentPage.openAssignmentVersion10(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();
		
		createEditAssignmentPage.verifyPrintedTestScreenshots();
		
		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Open Version1 Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//Click preview without Answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//open version2 Assignment
		createEditAssignmentPage.openAssignmentVersion2(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Open Version10 Assignment
		createEditAssignmentPage.openAssignmentVersion10(dataMap);

		//Click preview without answer1
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//click preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();
		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}

	/****Test Case E4-4723: Printed Test AC - Step 1 - Configure Page Setup - Initial view****/
	@Test
	public void E4_4723( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Verify Additional Setting representation
		createEditAssignmentPage.verifyAdditionalSettings();

		//verify and click Configure Page Setup
		createEditAssignmentPage.verifyAndClickConfigure();
		
		createEditAssignmentPage.verifyPrintedTestScreenshots();
		
		//Verify configure Page
		createEditAssignmentPage.verifyConfigurePage();

		//Close configure page window
		createEditAssignmentPage.closeWindow1();

		//foucs main window
		createEditAssignmentPage.focusMainWindow();

		//Click configure page setup
		createEditAssignmentPage.verifyAndClickConfigure();

		//click assignment link
		createEditAssignmentPage.assignmentLink();	

		
		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-4727: Printed Test AC - Step 2 - Select questions****/
	/********TO DO PENDING******
	@Test

	public void E4_4727( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select Next Button
		createEditAssignmentPage.selectNextButton();

		//Verify Select questions is displayed
		createEditAssignmentPage.verifySelectQuestiontab();

		//Verify explanataion
		createEditAssignmentPage.verifyExplanation();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}*****/
	
	/****Test Case E4-4728: Printed Test AC - Step 3 - Organize questions****/
	/*******TO DO PENDING*******
	@Test
	public void E4_4728( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//Select Chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//Select Questions
		createEditAssignmentPage.selectQuestions();

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize questions
		createEditAssignmentPage.verifyOrganizeTab();

		//verify question count
		createEditAssignmentPage.verifyQuestionCount();

		//Remove questions from Question pool
		createEditAssignmentPage.removeAllQuestions();

		//Navigate and check scramble
		createEditAssignmentPage.navigateAndCheckScramble();

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//Select Question
		createEditAssignmentPage.selectQuestions();

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//verify Order is disabled
		createEditAssignmentPage.verifyOrder();

		//Navigate and check scramble
		createEditAssignmentPage.navigateAndCheckScramble();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Verify order is enabled
		createEditAssignmentPage.verifyOrder(); 

		//Click Next button
		createEditAssignmentPage.selectNextButton();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}*******/

	/****Test Case E4-4729: [DRAFT] Printed Test AC - Step 3 - Question order****/
	/*******TO DO PENDING******
	@Test
	public void E4_4729( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		QuestionPage questionPage=PageFactory.initElements(driver, QuestionPage.class);

		CreateNewQuestionPage createNewQuestionPage=PageFactory.initElements(driver, CreateNewQuestionPage.class);

		Precondition

		assignmentPage.selectionQuestionLink();

		CreateQuestionPoolPage createQuestionPoolPage = questionPage.goToCreateQuestionPool();

		createQuestionPoolPage.inputDefinePool(dataMap);

		createNewQuestionPage.selectNextButton();

		createQuestionPoolPage.verifySelectQuestionTab();
		
		createEditAssignmentPage.chooseChapter();
		
		createEditAssignmentPage.selectGo();

		createEditAssignmentPage.selectQuestions();

		createNewQuestionPage.selectNextButton();

		createQuestionPoolPage.verifyOrganizeQuestion();

		createNewQuestionPage.selectNextButton();

		createNewQuestionPage.selectFinishButton();
		
		//createEditAssignmentPage.closeWindow1();

		//assignmentPage.clickOnAssignment();

		assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Click next button
		createEditAssignmentPage.selectNextButton();

		//Select Chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select Questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//change the question order
		createEditAssignmentPage.changeQuestionOrder(dataMap);

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//select go
		assignmentPage.clickGo();

		//open created Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//open preview without answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//get question name and order
		createEditAssignmentPage.getQuestionNames();

		//verify the order
		createEditAssignmentPage.verifyQuestionNames();

		//close window 2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//select edit assignment in actions dropdown
		assignmentPage.selectActionsEditAssignment(dataMap, "AssignmentValue2");

		//select actions go
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentValue2");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click remove
		createEditAssignmentPage.removeOneQuestion();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//select go
		assignmentPage.clickGo();

		//open created Assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//open preview without answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//get question name and order
		createEditAssignmentPage.getQuestionNames();

		//verify the order
		createEditAssignmentPage.verifyQuestionNames();

		//close window 2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//select edit assignment in actions dropdown
		assignmentPage.selectActionsEditAssignment(dataMap, "AssignmentValue2");

		//select actions go
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentValue2");

		//check scramble
		createEditAssignmentPage.checkScramble();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Verify order is enabled
		createEditAssignmentPage.verifyOrder();

		//Navigate and check scramble
		createEditAssignmentPage.navigateAndCheckScramble();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Verify order is enabled
		createEditAssignmentPage.verifyOrder();

		//Click Next button
		createEditAssignmentPage.selectNextButton();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}****/
	
	/****Test Case E4-4732: Printed Test AC - Step 5 - Confirmation****/
	/*******TO DO PENDING*****
	@Test
	public void E4_4732( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select version one
		createEditAssignmentPage.selectVersion1();

		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();
		createEditAssignmentPage.selectQuestions();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//verify confirmation tab
		createEditAssignmentPage.verifyConfirmationPage();

		//Click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}****/
	
	/****Test Case E4-4733: Assignment Properties****/
	
	/******TO DO PENDING*****
	@Test
	public void E4_4733( ) throws Exception
	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select go
		assignmentPage.clickGo();

		//Select Assignment Properties
		assignmentPage.selectActionsAssignmentProperties(dataMap, "AssignmentValue1");

		//select assignment go btn
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentValue1");

		//verify Assignment properties
		createEditAssignmentPage.verifyAssignmentProperties();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}*****/
	
	/****Test Case E4-1423: Assignments - AC - PT Assignment - Step 1. Sharing****/
	@Test
	public void E4_1423( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description Details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//verify sharing text
		createEditAssignmentPage.verifySharing();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-1424: Assignments - AC - PT Assignment - Step 1. Date and Source****/
	/****TO DO PENDING*****
	@Test

	public void E4_1424( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description Details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//verify date
		createEditAssignmentPage.verifyDate(dataMap);

		//verify source
		createEditAssignmentPage.verifySource(dataMap);

		//click my profile
		//	createEditAssignmentPage.MyProfile(dataMap); //my profile does not exist

		//click Assignment tab
		//	courseHomePage.goToAssigmentPage();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		//Click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//verify modified source name
		//	createEditAssignmentPage.verifyModifiedSource(dataMap);

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}*******/
	/****Test Case E4-1942: Assignments - AC - PT Assignment - Step 1. Printed Test Layout****/
	/****TO DO PENDING******
	@Test

	public void E4_1942( ) throws Exception
	{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description Details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//verify and click Configure Page Setup
		createEditAssignmentPage.verifyAndClickConfigure();

		//Verify configure Page
		createEditAssignmentPage.verifyConfigurePage();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Click on assignment link
		createEditAssignmentPage.assignmentLink();

		//select go
		assignmentPage.clickGo();

		//select Generate printed test
		assignmentPage.selectActionsGeneratePrintedTest(dataMap, "AssignmentValue1");

		//select assignment go btn
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentValue1");

		//open preview with answer
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window 2
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}******/

	

	/****Test Case E4-2000: Assignments - AC - PT Assignment - Step 2 - Question preview. Question Preview window****/

	@Test

	public void E4_1943( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description Details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//SelectNext buton
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//select all questions per page
		createEditAssignmentPage.selectAllQuestionPerPage(dataMap);

		//click go
		createEditAssignmentPage.selectGo();

		//Select question preview
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click close button
		createEditAssignmentPage.selectCancelButton();



		driver=assignmentPage.getDriver();
	}
	/****Test Case E4-1982: Assignments - AC - PT Assignment - Step 2. Multiselection menus****/

	@Test

	public void E4_1982( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//select next button
		createEditAssignmentPage.selectNextButton();

		//verify chapter menu
		createEditAssignmentPage.verifyChapterMenuPresent();

		//verify level menu
		createEditAssignmentPage.verifyLevelMenuPresent();

		//verify source menu
		createEditAssignmentPage.verifySourceMenu();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-1983: Assignments - AC - PT Assignment - Step 2. Question search - intersection - 3 fields****/

	@Test

	public void E4_1983( ) throws Exception

	{
		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//select next button
		createEditAssignmentPage.selectNextButton();

		//Select one chapter, one section and one 
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneLevel();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one section, one level and one source
		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneLevel();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one Chapter, one Section and one Source
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneSection();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		//Select one chapter, one level and one source
		createEditAssignmentPage.selectOneChapter();

		createEditAssignmentPage.selectOneLevel();

		createEditAssignmentPage.selectOneSource();

		createEditAssignmentPage.selectGoBtn();

		createEditAssignmentPage.verifyTableContent();

		createEditAssignmentPage.selectSaveAndFindButton();

		createEditAssignmentPage.assignmentLink();


		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-1986: Assignments - AC - PT Assignment - Step 2. Question search - intersection - 2 fields****/

	/****Test Case E4-1988: Assignments - AC - PT Assignment - Step 2. Question search - multiselect - single field****/

	/****Test Case E4-1990: Assignments - AC - PT Assignment - Step 2. Navigation****/
	/*****TO DO PENDING*****
	@Test

	public void E4_1986( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click cancel button
		createEditAssignmentPage.selectCancelButton();

		//click go button
		assignmentPage.clickGo();

		//verify assignment in the list
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select questions
		createEditAssignmentPage.selectQuestions();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click go button
		assignmentPage.clickGo();

		//verify assignment in the list
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//Select questions
		createEditAssignmentPage.selectQuestions();

		//navigate to describe
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}*****/
	
	/****Test Case E4-1993: Assignments - AC - PT Assignment - Step 2. Question checkboxes****/

	@Test

	public void E4_1993( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();
		createEditAssignmentPage.selectGo();

		//select random quesitons
		createEditAssignmentPage.selectQuestions();

		//verify checkbox
		createEditAssignmentPage.verifyQuestionsCheckBox();

		//select next button
		createEditAssignmentPage.selectNextButton();

		//verify organize tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//Select AllQuestion Checkbox
		createEditAssignmentPage.selectAllQuestion(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//uncheck  questions
		createEditAssignmentPage.unCheckQuestion();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify organize tab
		createEditAssignmentPage.verifyOrganizeAndScoreQuestionTab();

		//click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//uncheck all questions
		createEditAssignmentPage.unCheckAllQuestion();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify alert
		createEditAssignmentPage.verifyAlertMessage(dataMap); 

		//close driver
		Browser.closeDriver(driver);

	}
	/****Test Case E4-1994: Assignments - AC - PT Assignment - Step 2. Select all Questions****/

	@Test

	public void E4_1994( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select all questions
		createEditAssignmentPage.selectAllQuestion(dataMap);

		//uncheck some questions
		createEditAssignmentPage.unCheckQuestion();

		//select all questions
		createEditAssignmentPage.selectAllQuestion(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//close driver
		Browser.closeDriver(driver);

	}
	/****Test Case E4-2007: Assignments - AC - PT Assignment - Step 3. Order****/
	/****TO DO PENDING*****
	@Test

	public void E4_2007( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//verify order drop box
		createEditAssignmentPage.checkPossibleValues(dataMap);

		//change and verify the order of questions
		createEditAssignmentPage.changeOrderOfThirdQuestion();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click go
		createEditAssignmentPage.selectGo();

		//open created assignment
		createEditAssignmentPage.openAssignmentVersion1(dataMap);

		//open preview without answer
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//verify the order of questions
		createEditAssignmentPage.getQuestionNames();
		createEditAssignmentPage.verifyQuestionNames();

		//close window
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//close driver
		Browser.closeDriver(driver);

	}***/
	
	/****Test Case E4-2012: Assignments - AC - PT Assignment - Step 3. Navigation****/
	@Test
	public void E4_2012( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click back button
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click cancel button
		createEditAssignmentPage.selectCancelButton();

		//click go
		assignmentPage.clickGo();

		//verify the assignment is not displayed
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click go
		createEditAssignmentPage.selectGo();

		//verify the assignment is displayed
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//navigate to describe assignment
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//click next
		createEditAssignmentPage.selectNextButton();

		//click next
		createEditAssignmentPage.selectNextButton();

		//navigate to select question tab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//close driver
		Browser.closeDriver(driver);

	}
	/****Test Case E4-2003: Assignments - AC - PT Assignment - Step 3 - Question preview. Question Preview window****/
	@Test
	public void E4_2003( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Select question preview
		createEditAssignmentPage.selectQuestionPreview(dataMap);

		//close window 1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click close button
		createEditAssignmentPage.selectCancelButton();

		//close driver
		Browser.closeDriver(driver);

	}
	/****Test Case E4-2004: Assignments - AC - PT Assignment - Step 3 - Question preview. Question Assistance button****/

	@Test

	public void E4_2004( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//Select one question link for the preview
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		//Select show solution button and verify the window
		createEditAssignmentPage.verifyShowSolutionButton(dataMap);

		//Select Link to Text button and verify the window
		createEditAssignmentPage.verifyLinktoText(dataMap);

		//close window 1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-2021: Assignments - AC - PT Assignment - Step 4. Assignment Description****/

	@Test

	public void E4_2021( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//verify assignment description
		createEditAssignmentPage.verifyAssignmentDescription(dataMap);

		//navigate back to describe tab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//change value of assignment id and name
		createEditAssignmentPage.changeAssignmentNameAndId(dataMap);

		//click next button to navigate to confirmation
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//verify the modified assignment name and id
		createEditAssignmentPage.verifyAssignmentNameAndId(dataMap, "AsgntID");

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}
	/****Test Case E4-2016: Assignments - AC - PT Assignment - Step 4 - Question preview. Question Preview window****/

	@Test

	public void E4_2016( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Select question preview
		createEditAssignmentPage.selectQuestionPreview(dataMap);

		//close window 1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-2017: Assignments - AC - PT Assignment - Step 4 - Question preview. Question Assistance buttons****/

	@Test

	public void E4_2017( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Description: Enter details in Describe Assignment details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();

		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//Select one question link for the preview
		createEditAssignmentPage.selectNonAlgorithmQuestionPreview(dataMap);

		//Select show solution button and verify the window
		createEditAssignmentPage.verifyShowSolutionButton(dataMap);

		//Select Link to Text button and verify the window
		createEditAssignmentPage.verifyLinktoText(dataMap);

		//close window 1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-2020: Assignments - AC - PT Assignment - Step 4. Navigation between steps****/

	@Test

	public void E4_2020( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//go to confirmation
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//navigate to describe assignment tab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();

		//go to confirmation tab
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//navigate to select question tab
		createEditAssignmentPage.navigateToSelectQuestionTab();

		//verify checked check box
		createEditAssignmentPage.verifyQuestionsCheckBox();

		//go to confirmation tab
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//navigate to organize question tab
		//createEditAssignmentPage.navigateToOrganizeAndScoreTab();
		createEditAssignmentPage.selectBackButtonNavigate();
		createEditAssignmentPage.selectBackButtonNavigate();

		//verify the question order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}
	/****Test Case E4-2019: Assignments - AC - PT Assignment - Step 4. Navigation buttons****/

	@Test

	public void E4_2019( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//go to confirmation
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//click back button
		createEditAssignmentPage.selectBackButtonNavigate();
		createEditAssignmentPage.selectBackButtonNavigate();

		//verify the question order
		createEditAssignmentPage.verifyQuestionOrder(dataMap);

		//go to confirmation tab
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//click cancel
		createEditAssignmentPage.selectCancelButton();

		//click go
		createEditAssignmentPage.selectGo();

		//verify assignment is not displayed in list
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//go to confirmation
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click go
		createEditAssignmentPage.selectGo();

		//verify assignment is displayed in list
		assignmentPage.verifyNotAssignedAssignmentDisplayed(dataMap);

		//click create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectQuestions();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//go to confirmation
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//click preview assignment
		createEditAssignmentPage.selectPreviewAssignmentbtn();

		//close window 1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-427: Assignment - Assignment Creator - Printed Test Assignment. Edit Assignment****/
	/*****TO DO PENDING*****
	@Test

	public void E4_427( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select edit assignment in actions dropdown
		assignmentPage.selectActionsEditAssignment(dataMap, "AssignmentValue10");

		//select actions go
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentValue10");

		//navigate to organize questions
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//remove some questions
		createEditAssignmentPage.removeOneQuestion();
		createEditAssignmentPage.removeOneQuestion();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}*****/
	
	/****Test Case E4-5968: Printed Test Creator - Question Preview. Multistep questions.****/

	@Test

	public void E4_5968( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//click go
		createEditAssignmentPage.selectGo();

		//select edit assignment in actions dropdown
		assignmentPage.selectActionsEditAssignment(dataMap, "AssignmentValue10");

		//select actions go
		assignmentPage.selectAssignmentGobutton(dataMap, "AssignmentValue10");

		//click next
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//move on multistep question link
		createEditAssignmentPage.quesitonLinkMove();

		//move to confirmation
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//move on multistep question link
		createEditAssignmentPage.questionLinkMoveInConfirmation();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/****Test Case E4-434: Assignment Player - Instructor - Printed Test Assignment****/

	@Test(dependsOnMethods={"E4_405"})

	public void E4_434( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);
		E4_405();
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select go in assignment page
		assignmentPage.goToAssignmentList(dataMap);

		//select printed test assignmetn
		createEditAssignmentPage.openAssignmentVersion10(dataMap);

		//unselect number questions
		createEditAssignmentPage.uncheckNumberQuestions();

		//open preview with answers
		createEditAssignmentPage.openPreviewWithAnswer();

		//check hide question titles
		createEditAssignmentPage.checkHideQuestionTitle();

		//close the window
		createEditAssignmentPage.closeWindow2();

		//open preview without answers
		createEditAssignmentPage.openPreviewWithoutAnswer();

		//get question names
		createEditAssignmentPage.getQuestionNames();

		//close the window
		createEditAssignmentPage.closeWindow2();
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}


	/****Test Case E4-1984: Assignments - AC - PT Assignment - Step 2. Question search - multiselect - intersection - 3 fields****/
	/****Test Case E4-1985: Assignments - AC - PT Assignment - Step 2. Question search - multiselect - intersection - 2 fields****/
	/*****TO DO PENDING*****
	@Test

	public void E4_1984( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//Click Next Button
		createEditAssignmentPage.selectNextButton();

		//Select Multiple Chapter
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		//Select Multiple Level
		createEditAssignmentPage.multiSelectLevel(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple Level
		createEditAssignmentPage.multiSelectLevel(dataMap);

		//Select Multiple Source
		createEditAssignmentPage.multiSelectSource(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//Select Multiple Source
		createEditAssignmentPage.multiSelectSource(dataMap);

		//Select Multiple Chapter
		createEditAssignmentPage.mulitiSelectChapter(dataMap);

		//Select Go Button
		createEditAssignmentPage.selectGoBtn();

		//Verify the table displayed
		createEditAssignmentPage.verifyTableDisplayed();

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//select Assignment Link
		createEditAssignmentPage.assignmentLink();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}****/
	/*****Test Case E4-1988: Assignments - AC - PT Assignment - Step 2. Question search - multiselect - single field****/
	/*****TO DO PENDING*****
	@Test

	public void E4_1988( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Input description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

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

		//Select Save And Find More Questions
		createEditAssignmentPage.selectSaveAndFindButton();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}****/

	/****Test Case E4-1996: Assignments - AC - PT Assignment - Step 2. Question list sorting****/
	/******TO DO PENDING*******
	@Test

	public void E4_1996( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//show per page
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);
		createEditAssignmentPage.selectGo();

		//select and verify sorting triangle
		createEditAssignmentPage.selectQuestionNameTriangle();
		createEditAssignmentPage.verifyQuestionNameList();
		createEditAssignmentPage.selectQuestionAssistanceTriangle();
		createEditAssignmentPage.verifyQuestionAssistanceList();
		createEditAssignmentPage.selectQuestionTypeTriangle();
		createEditAssignmentPage.verifyQuestionTypeList();
		createEditAssignmentPage.selectSourceTriangle();
		createEditAssignmentPage.verifySourceList();
		createEditAssignmentPage.selectDifficultyTriangle();
		createEditAssignmentPage.verifyDifficultyList();
		createEditAssignmentPage.selectTextAssociationTriangle();
		createEditAssignmentPage.verifyTextAssociationList();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}******/

	/****Test Case E4-1997: Assignments - AC - PT Assignment - Step 2. Sort parameters persistence****/
	/*****TO DO PENDING****
	@Test

	public void E4_1997( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//show per page
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);
		createEditAssignmentPage.selectGo();

		//verify question name triangle
		createEditAssignmentPage.selectQuestionNameTriangle();
		createEditAssignmentPage.verifyQuestionNameList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question name list
		createEditAssignmentPage.verifyQuestionNameList();

		//verify text association triangle
		createEditAssignmentPage.selectTextAssociationTriangle();
		createEditAssignmentPage.verifyTextAssociationList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify text association list
		createEditAssignmentPage.verifyTextAssociationList();

		//verify question type
		createEditAssignmentPage.selectQuestionTypeTriangle();
		createEditAssignmentPage.verifyQuestionTypeList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question type list
		createEditAssignmentPage.verifyQuestionTypeList();

		//verify question assistance
		createEditAssignmentPage.selectQuestionAssistanceTriangle();
		createEditAssignmentPage.verifyQuestionAssistanceList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question assistance list
		createEditAssignmentPage.verifyQuestionAssistanceList();

		//verify difficulty 
		createEditAssignmentPage.selectDifficultyTriangle();
		createEditAssignmentPage.verifyDifficultyList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify difficulty list
		createEditAssignmentPage.verifyDifficultyList();

		//verify source
		createEditAssignmentPage.selectSourceTriangle();
		createEditAssignmentPage.verifySourceList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify soruce list
		createEditAssignmentPage.verifySourceList();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}****/
	/****Test Case E4-1999: Assignments - AC - PT Assignment - Step 2. Sort parameters persistence - search criteria renewed****/
	/*****TO DO PENDING****
	@Test

	public void E4_1999( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//show per page
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);
		createEditAssignmentPage.selectGo();

		//verify question name triangle
		createEditAssignmentPage.selectQuestionNameTriangle();

		//verify question name triangle
		createEditAssignmentPage.selectQuestionNameTriangle();
		createEditAssignmentPage.verifyQuestionNameList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question name list
		createEditAssignmentPage.verifyQuestionNameList();

		//verify text association triangle
		createEditAssignmentPage.selectTextAssociationTriangle();
		createEditAssignmentPage.verifyTextAssociationList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify text association list
		createEditAssignmentPage.verifyTextAssociationList();

		//verify question type
		createEditAssignmentPage.selectQuestionTypeTriangle();
		createEditAssignmentPage.verifyQuestionTypeList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question type list
		createEditAssignmentPage.verifyQuestionTypeList();

		//verify question assistance
		createEditAssignmentPage.selectQuestionAssistanceTriangle();
		createEditAssignmentPage.verifyQuestionAssistanceList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify question assistance list
		createEditAssignmentPage.verifyQuestionAssistanceList();

		//verify difficulty 
		createEditAssignmentPage.selectDifficultyTriangle();
		createEditAssignmentPage.verifyDifficultyList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify difficulty list
		createEditAssignmentPage.verifyDifficultyList();

		//verify source
		createEditAssignmentPage.selectSourceTriangle();
		createEditAssignmentPage.verifySourceList();

		//click back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click next
		createEditAssignmentPage.selectNextButton();

		//verify soruce list
		createEditAssignmentPage.verifySourceList();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}****/
	/****Test Case E4-2002: Assignments - AC - PT Assignment - Step 2 - Question preview. Links****/
	/*****TO BE DELETED****
	@Test
	public void E4_2002( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//click algorithmic question
		createEditAssignmentPage.selectAlgorthmicQuestionforChangeValue(dataMap);

		//focus assignment window
		assignmentPage.focusAssignmentWindow();

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

		//Verify the Alert message
		createEditAssignmentPage.VerifyAlertmessageinQuestionPreview();

		//Verify Report Comment Input
		createEditAssignmentPage.verifylongReportcomments(dataMap);

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}****/
	/****Test Case E4-2005: Assignments - AC - PT Assignment - Step 3 - Question preview. Links****/
	/*****TO BE DELETED*****
	@Test
	public void E4_2005( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//click algorithmic question
		createEditAssignmentPage.selectAlgorthmicQuestionforChangeValue(dataMap);

		//focus assignment window
		assignmentPage.focusAssignmentWindow();

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

		//Verify the Alert message
		createEditAssignmentPage.VerifyAlertmessageinQuestionPreview();

		//Verify Report Comment Input
		createEditAssignmentPage.verifylongReportcomments(dataMap);

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}*****/
	/****Test Case E4-2010: Assignments - AC - PT Assignment - Step 3. Actions****/
	/*********TO DO PENDING*********
	@Test

	public void E4_2010( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select algorithmic and non algorithmic questions
		createEditAssignmentPage.selectAlgorthimicQuestions();
		createEditAssignmentPage.selectNonAlgorthimicQuestions();

		//select next
		createEditAssignmentPage.selectNextButton();

		//verify remove and duplicate link
		createEditAssignmentPage.verifyRemoveAndDuplicateLink();

		//click remove
		createEditAssignmentPage.removeOneQuestion();

		//click duplicate
		createEditAssignmentPage.DuplicateQuestion();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click go
		createEditAssignmentPage.selectGo();

		//select edit assignment in actions dropdown
		assignmentPage.selectActionsGeneratePrintedTest(dataMap,  "AsgntName");

		//select actions go
		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");

		//select preview with answers
		createEditAssignmentPage.openPreviewWithAnswer();

		//close window 1
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}****/
	/****Test Case E4-4730: Setting Tolerance and Significant Digits - pop-up window****/
	/*****TO DO PENDING*****
	@Test
	public void E4_4730( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//select printed test radio button
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseNumericQuestionChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectNumericQuestions();

		//click next
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//click configure numeric policies
		createEditAssignmentPage.selectConfigureNumericPolicies();

		//focus window 1
		assignmentPage.focusAssignmentWindow();

		//verify configure numeric policies page
		createEditAssignmentPage.verifyConfigureNumericPoliciesWindow(dataMap);

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}******/

	/****Test Case E4-4731: Printed Test AC - Step 4 - Set question policies****/

	@Test

	public void E4_4731( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseNumericQuestionChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select algorithmic questions
		createEditAssignmentPage.selectNumericQuestions();

		//click next
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//verify set question policies tab
		createEditAssignmentPage.verifyQuestionPoliciesTab();

		//verify change values
		createEditAssignmentPage.verifyChangeValuesRadioButtons();

		//selct configure numeric policies
		createEditAssignmentPage.selectConfigureNumericPolicies();

		//focus window 1
		assignmentPage.focusAssignmentWindow();

		//verify configure numeric policies page
		createEditAssignmentPage.verifyConfigureNumericPoliciesWindow(dataMap);

		//close window
		createEditAssignmentPage.closeWindow1();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//select back
		createEditAssignmentPage.selectBackButtonNavigate();

		//remove one quesiton
		createEditAssignmentPage.removeOneQuestion();

		//navigate to set question polices
		createEditAssignmentPage.selectNextButton();

		//verify change values
		createEditAssignmentPage.verifyChangeValuesRadioButtons();

		//select next
		createEditAssignmentPage.selectNextButton();

		//select back
		createEditAssignmentPage.selectBackButtonNavigate();

		//click cancel
		createEditAssignmentPage.selectCancelButton();

		//create new assignment
		assignmentPage.goToCreateEditAssignmentPage();

		//input description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseNumericQuestionChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//select algorithmic questions
		createEditAssignmentPage.selectNumericQuestions();

		//click next
		createEditAssignmentPage.selectNextButton();
		createEditAssignmentPage.selectNextButton();

		//verify set question policies tab
		createEditAssignmentPage.verifyQuestionPoliciesTab();

		//verify change values
		createEditAssignmentPage.verifyChangeValuesRadioButtons();

		//click save and exit
		createEditAssignmentPage.selectSaveAndExit();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	
	/****Test Case E4-4545: Question Assignment Player - Instructor - Assigned. Alternative Answers****/
	/*****TO DO PENDING****
	@Test
	public void E4_4545( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);


		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);


		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//navigate to administrator
		Browser.navigateURL(driver,  dataMap.get("AdminUrl"));

		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Navigate to Course tab
		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();

		//Validate the list of courses in the course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		//check show alternative answers
		coursePropertiesPage.checkShowAlternativeAnswers();

		//save settings
		coursePropertiesPage.saveSettings();

		//navigate to instructor
		Browser.navigateURL(driver, strURL);

		//Login
		home.login(dataMap);

		//select course
		courseSelectionPage.selectCourse(dataMap);

		//go to assignment page
		courseHomePage.goToAssigmentPage();

		//select go
		assignmentPage.goToAssignmentList(dataMap);

		//select assignment
		assignmentPage.selectTestMatchingAssignment(dataMap);

		//focus assignmetn window
		assignmentPage.focusAssignmentWindow();

		//click next
		OpenAssignment openAssignment=PageFactory.initElements(driver, OpenAssignment.class);
		openAssignment.clickNext();

		//mouse hover on asterik
		assignmentPage.verifyAlternativeAnswer();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}*****/
	/*****Test Case E4-2001: Assignments - AC - PT Assignment - Step 2 - Question preview. Question Assistance buttons******/
	@Test
	public void E4_2001( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//input description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

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

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/******Test Case E4-1992: Assignments - AC - PT Assignment - Step 2. Page Navigator drop-down****/
	@Test
	public void E4_1992( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();


		//input description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

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

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();

	}
	/*****Test Case E4-2006: Assignments - AC - PT Assignment - Step 3. Question preview in a pop-up window****/
	/*****TO DO PENDING****
	@Test
	public void E4_2006( ) throws Exception{

		ResultUtil.createReport("AssignmentPrintedTest-createEditAssignmentPage", dataMap);

		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Enter description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);

		//click next button
		createEditAssignmentPage.selectNextButton();

		//Choose chapter
		createEditAssignmentPage.chooseChapter();

		//click go
		createEditAssignmentPage.selectGo();

		//Select Questions
		createEditAssignmentPage.selectQuestions();

		//Select Next Button
		createEditAssignmentPage.selectNextButton();

		//mouse hover on question
		createEditAssignmentPage.moveOnQuestion();

		//click assignment link
		createEditAssignmentPage.assignmentLink();

		driver=assignmentPage.getDriver();
	}	*****/
	
	
}