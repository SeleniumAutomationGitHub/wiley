package Scripts.Assignments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.CreateNewQuestionPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.QuestionPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.AssignmentsDataProviderUtil.staticProviderClass;

@Test(dataProvider="AssignmentDemo",dataProviderClass=staticProviderClass.class)
public class AssignmentDemo {
	

	
	
	
	public void assignmentsDemo(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("AssignmentDemo-assignmentsDemo", dataMap);
		
		testCaseE41995(dataMap);
		testCaseE4465(dataMap);
		testCaseE44718(dataMap);
		
	}
	
		
	@Test(dataProvider="AssignmentDemo",dataProviderClass=staticProviderClass.class)
		public void testCaseE41995(Map<String,String> dataMap) throws Exception{
		/****Test Case E4-1995: Assignments - AC - PT Assignment - Step 2. Question preview in a pop-up window****/
		System.out.println("Test Case E4-1995:");
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		
		//Create Edit Assignment Intializing
		CreateEditAssignmentPage createEditAssignmentPage = assignmentPage.goToCreateEditAssignmentPage();

		
		//Enter description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntID", "AsgntName");
		
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
		
		//go to create assignmnet
		assignmentPage.goToCreateEditAssignmentPage();
		
		//close driver
		Browser.closeDriver(driver);

		}
		
		@Test(dataProvider="AssignmentDemo",dataProviderClass=staticProviderClass.class)
		public void testCaseE44718(Map<String,String> dataMap) throws Exception{
		/****Test Case E4-4718: Printed Test AC - Step 1 - Number of Versions - One version****/
		System.out.println("Test Case E4-4718");
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();

		
		//Create Edit Assignment Intializing
		CreateEditAssignmentPage createEditAssignmentPage = assignmentPage.goToCreateEditAssignmentPage();


		//Enter Description details
		createEditAssignmentPage.inputDescriptionDetailsForPrintedTest(dataMap);
		
		//check the Versions dropBox
		createEditAssignmentPage.verifyVersionDropbox();
		
		//Select an version
		createEditAssignmentPage.selectVersion1();
		
		//Create an Assignment
		createEditAssignmentPage.selectNextButton();
		
		//Choose Chapters and Source
		createEditAssignmentPage.chooseChapter();
		
		//Click Go button
		createEditAssignmentPage.selectGo();
		
		//Select Questions
		createEditAssignmentPage.selectQuestions();
		
		//Click Next Button
		createEditAssignmentPage.selectNextButton();
		
		//Click Save and Exit button
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
		
		//close driver
		Browser.closeDriver(driver);

		}
		
		@Test(dataProvider="AssignmentDemo",dataProviderClass=staticProviderClass.class)
		public void testCaseE4465(Map<String,String> dataMap) throws Exception{
		
		/*******Test Case E4-465: Assignments - Question page. Create new question********/
		System.out.println("Test Case E4-465:");
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		//Question Page Initializing
		QuestionPage questionPage= PageFactory.initElements(driver, QuestionPage.class);
		
		//Click Question Link
		assignmentPage.selectionQuestionLink();
		
		//Click Create New Question Button
		CreateNewQuestionPage createNewQuestionPage = questionPage.goToCreateNewQuestion();
		
		//Input Description Question
		createNewQuestionPage.inputDescribeQuestion(dataMap);
		
		//Click Next Button
		createNewQuestionPage.selectNextButton();
		
		//Enter Question Details
		createNewQuestionPage.inputCreateQuestion(dataMap);
		
		//Click Next Button
		createNewQuestionPage.selectNextButton();
		
		//Verify Question Assistance Tab
		createNewQuestionPage.verifyQuestionAssistanceTab();
		
		//Click Next Button
		createNewQuestionPage.selectNextButton();
		
		//Verify Confirmation
		createNewQuestionPage.verifyConfirmation();
		
		//Click Finish Button
		createNewQuestionPage.selectFinishButton();
		
		//Create Edit Assignment Intializing
		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver,CreateEditAssignmentPage.class);
		
		//close operation status
		createEditAssignmentPage.closeWindow1();
		
		//Focus Main Window
		createEditAssignmentPage.focusMainWindow();
		
		//close driver
		Browser.closeDriver(driver);
		}

	}

