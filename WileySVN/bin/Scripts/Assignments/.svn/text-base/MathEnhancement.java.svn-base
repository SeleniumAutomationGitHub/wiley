package Scripts.Assignments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.OpenAssignment;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.GradeBookPage;
import Pages.Common.HomePage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.AssignmentsDataProviderUtil.staticProviderClass;

public class MathEnhancement 
{
	WebDriver driver=null;
	Map<String,String> dataMap =null;

	@Factory(dataProvider="MathEnhancement",dataProviderClass=staticProviderClass.class)
	public MathEnhancement(Map<String,String> dataMap){
		this.dataMap=dataMap;

	}

	@Test
	public void mathEnhancementPrerequsite() throws Exception{

		ResultUtil.createReport("MathEnhancement-mathEnhancementPrerequsite", dataMap);

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

	/*******Test Case E4-5313: Question assignment initial state********/

	/*******Test Case E4-5305: Question assignment initial state*******/
	/***TO DO PENDING***
	@Test
	public void E4_5313( ) throws Exception{
		ResultUtil.report("INFO", "MathEnhancement-E4_5313", driver);
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);
		//Goto Create Edit Assignment page
		CreateEditAssignmentPage createEditAssignmentPage =assignmentPage.goToCreateEditAssignmentPage();

		//Select multi choice question
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//Click next button
		openAssignment.clickNext();

		//Verify show work
		openAssignment.verifyShowWork();

		//Edit in Show work
		openAssignment.editInShowWork();

		//Close show work window
		openAssignment.closeWindow();

		//Focu main window
		createEditAssignmentPage.focusMainWindow();

		//Verify show work
		openAssignment.verifyShowWork();		

		//Edit in show work
		openAssignment.editInShowWork();

		//Close show work window
		openAssignment.closeWindow();

		//Focus main window
		createEditAssignmentPage.focusMainWindow();

		//Select an answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//Click submit answer
		openAssignment.selectSubmitAnswer();

		//Verify show work after submitting the answer
		openAssignment.verifyShowWorkLinkAfterSubmittingAnswer();

		//Navigate to Assignment page
		openAssignment.selectAssignmentLink();

		driver= openAssignment.getDriver();

	}*****/

	/******Test Case E4-5309: Question assignment show work behavior*****/
	/******TO DO PENDING****
	@Test
	public void E4_5309( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4_5309", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);	

		//Select multi choice question
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//Click next button
		openAssignment.clickNext();

		//Click next button
		openAssignment.clickNext();

		//Verify show work
		openAssignment.verifyShowWork();

		//openAssignment.editInShowWork();

		//Close show work window
		createEditAssignmentPage.closeWindow1();

		//Focu main window
		createEditAssignmentPage.focusMainWindow();

		//Verify show work
		openAssignment.verifyShowWork();

		//Select an answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//Click submit answer button
		openAssignment.selectSubmitAnswer();

		//Select open blank show work
		openAssignment.selectOpenBlankShowWork();

		//Edit in show work
		openAssignment.editInShowWork();

		//Close show work window
		openAssignment.closeWindow();

		//Focus main window
		createEditAssignmentPage.focusMainWindow();

		//Verify show work
		openAssignment.verifyShowWork();

		//Select an answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//Click submitanswer button
		openAssignment.selectSubmitAnswer();

		//Select copy show work previous attempt
		openAssignment.selectCopyShowWorkPreviousAttempt();

		//Edit in show work
		openAssignment.editInShowWork();

		//Close show work window
		openAssignment.closeWindow();

		//Focus main window
		createEditAssignmentPage.focusMainWindow();

		//Navigate to Assignment page
		openAssignment.selectAssignmentLink();

		driver= openAssignment.getDriver();
	}****/

	/*****Test Case E4-5319: Question(Practice) assignment initial state******/
	/*****TO DO PENDING*****
	@Test
	public void E4_5319( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4_5319", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);		

		//Select practice question
		openAssignment.selectAssignment(dataMap,"AssignmentName");

		//Click next button
		openAssignment.clickNext();

		//Verify show work
		openAssignment.verifyShowWork();

		//Edit in show work
		openAssignment.editInShowWork();

		//Close show work window
		openAssignment.closeWindow();

		//focus main window
		createEditAssignmentPage.focusMainWindow();

		//Verify show work
		openAssignment.verifyShowWork();		

		//Select an answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//Click submit answer button
		openAssignment.selectSubmitAnswer();

		//Verify shoe work after submitting the answer
		openAssignment.verifyShowWorkLinkAfterSubmittingAnswer();

		//Click next button
		openAssignment.clickNext();

		//open show work
		openAssignment.verifyShowWork();

		//Edit in show work
		openAssignment.editInShowWork();

		//Close window
		createEditAssignmentPage.closeWindow1();

		//focus mainwindow
		createEditAssignmentPage.focusMainWindow();

		//Select first answer in true false
		openAssignment.selectFirstAnswerInTrueFalse();

		//Click submit answer button
		openAssignment.selectSubmitAnswer();

		//Navigate to Assignment page
		openAssignment.selectAssignmentLink();

		driver= openAssignment.getDriver();
	}****/

	/********Test Case E4-5327: Show Work is submitted\opened********/	
	@Test
	public void E4_5327( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4_5327", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);
		/*******PRECONDITION******/
		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment .class); 
		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);
		
		studentHomepage.goToAssignment();
		
		//open assignment with show work enabled
		openAssignment.selectTextEntryWithDropdown(dataMap);
		
		//click next
		openAssignment.clickNext();
			
		//Enter Answer
		openAssignment.answerQuestions();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//handle alert
		openAssignment.alertDismiss();
		
		//clikc submit answer
		openAssignment.selectSubmitAnswer();
		
		//handle alert
		openAssignment.alertAccept();
		
		//click assignment link
		openAssignment.selectAssignmentLink();
		/*****/

		HomePage home=PageFactory.initElements(driver, HomePage.class);

		CourseSelectionPage courseSelectionPage=PageFactory.initElements(driver, CourseSelectionPage.class);

		//Select Course
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);

		//GoTo Assignment page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);		

		//Navigate to instructor URL
		Browser.navigateURL(driver, strURL);

		//Login as instructor
		home.login(dataMap);

		//Select course
		courseSelectionPage.selectCourse(dataMap);

		//Click gradebook tab
		courseHomePage.goToGradebookPage();

		//Assign one assignment to all students
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click go button
		gradeBookPage.clickGoButton();

		//Click student name link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");

		//Click assignment name link
		gradeBookPage.clickAssignmentLink(dataMap, "AssignmentName");

		//Select question with submitted show work
		gradeBookPage.selectQuestionSubmittedShowWork(dataMap);

		//Switch to Window1
		gradeBookPage.switchToWindow();

		//Select open student show work
		gradeBookPage.selectOpenStudentShowWork();

		//Switch to window1
		gradeBookPage.switchToWindow();

		//Verify student show work window
		gradeBookPage.verifyStudentShowWorkWindow(dataMap);

		//Close show work window
		gradeBookPage.closeWindow();

		//Close window
		gradeBookPage.closeWindow();

		//Select questions with no show work
		gradeBookPage.selectQuestionNoShowWork(dataMap);

		//Switch to window1
		gradeBookPage.switchToWindow();

		//Select open student show work
		gradeBookPage.selectOpenStudentShowWork();

		//Switch to window1
		gradeBookPage.switchToWindow();

		//Verify show work 
		gradeBookPage.verifyStudentShowWorkWindow(dataMap);

		//Navigate to Assignment page
		openAssignment.selectAssignmentLink();

		driver= openAssignment.getDriver();
	}

	/*****Test Case E4-5328: Show Work is not submitted******/
	@Test
	public void E4_5328( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4-5328", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");
		
		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment .class); 
		
		/*******PRECONDITION*********/
		studentHomepage.goToAssignment();
		
		//open assignment with show work enabled
		openAssignment.selectTextEntryWithDropdown(dataMap);
		
		//click next
		openAssignment.clickNext();
			
		//Enter Answer
		openAssignment.answerQuestions();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//handle alert
		openAssignment.alertDismiss();
		
		//clikc submit answer
		openAssignment.selectSubmitAnswer();
		
		//handle alert
		openAssignment.alertAccept();
		
		//click assignment link
		openAssignment.selectAssignmentLink();
		

		HomePage home=PageFactory.initElements(driver, HomePage.class);

		CourseSelectionPage courseSelectionPage=PageFactory.initElements(driver, CourseSelectionPage.class);
		
		//Select Course
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);

		//GoTo Assignment page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);


		//Navigate to instructor URL
		Browser.navigateURL(driver, strURL);

		//Login as instructor
		home.login(dataMap);

		//Select course
		courseSelectionPage.selectCourse(dataMap);

		//Click gradebook tab
		courseHomePage.goToGradebookPage();

		//Assign one assignment to all students
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");

		//Click go button
		gradeBookPage.clickGoButton();

		//Click student name link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");

		//Click assignment name link
		gradeBookPage.clickAssignmentLink(dataMap, "AssignmentName");

		//Select question without show work
		gradeBookPage.selectQuestionWithoutShowWork(dataMap);

		//Switch to window
		gradeBookPage.switchToWindow();

		//Select open student show work
		gradeBookPage.selectOpenStudentShowWork();

		courseHomePage.goToAssigmentPage();

		driver = courseHomePage.getDriver();
	}


	/*****Test Case E4-5335: Show Work is annotated*******/

	/****Test Case E4-5336: Show Work is NOT annotated*****/
	
	@Test

	public void E4_5335( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4_5335", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment .class);
		//GoTo Assignment page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);

		StudentGradeBookPage studentGradeBookPage= PageFactory.initElements(driver, StudentGradeBookPage.class);	
		
		/*******PRECONDITION*******/
		studentHomepage.goToAssignment();
		
		//open assignment with show work enabled
		openAssignment.selectTextEntryWithDropdown(dataMap);
		
		//click next
		openAssignment.clickNext();
			
		//Enter Answer
		openAssignment.answerQuestions();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//handle alert
		openAssignment.alertDismiss();
		
		//clikc submit answer
		openAssignment.selectSubmitAnswer();
		
		//handle alert
		openAssignment.alertAccept();
		
		//click assignment link
		openAssignment.selectAssignmentLink();
		
		//Click gradebook tab
		studentHomepage.goToGradeBook();

		//Select assignment gradebook
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AssignmentName");

		//Select question with submitted show work
		gradeBookPage.selectQuestionSubmittedShowWork(dataMap);

		//Switch to window
		gradeBookPage.switchToWindow();

		//Select open student show work
		gradeBookPage.selectOpenStudentShowWork();

		//Switch to window
		gradeBookPage.switchToWindow();

		//Verify student show work window
		gradeBookPage.verifyStudentShowWorkWindow(dataMap);

		//Close  show work window
		gradeBookPage.closeWindow();

		//Close window
		gradeBookPage.closeWindow();

		//Select question without show work
		gradeBookPage.selectQuestionWithoutShowWork(dataMap);

		//Switch to window
		gradeBookPage.switchToWindow();

		//Select open student show work
		gradeBookPage.selectOpenStudentShowWork();

	}

	/******Test Case E4-5341: Accounting Tools*****/

	/******Test Case E4-5343: Math/Engineering Tools*****/

	/******Test Case E4-5344: Modern Language Tools*****/

	/******Test Case E4-5345: COMBINATION ********/

	@Test

	public void E4_5341( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4_5341", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);			

		//Navigate to admin URL
		Browser.navigateURL(driver, dataMap.get("AdminUrl"));

		//Login as admin
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();
		
		CreateEditAssignmentPage createEditAssignmentPage= PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();

		//Validate the list of courses in the course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		//Verify allow show work frame
		coursePropertiesPage.verifyAllowShowWorkFrame();

		//Select multi variable calculus tools
		coursePropertiesPage.selectMultiVariableCalculusTools();

		//Save the settings
		coursePropertiesPage.saveSettings();

		//Navigate to student URL
		Browser.navigateURL(driver, strStudentURL);

		//Login as student
		studenthome.loginPage(dataMap);

		//Go to assignment page
		studentHomepage.goToAssignment();

		//Click next
		openAssignment.clickNext();

		//Verify show work
		openAssignment.verifyShowWork();

		//Edit in show work
		openAssignment.editInShowWork();

		//Click Assigment Link
		createEditAssignmentPage.assignmentLink();

		driver = createEditAssignmentPage.getDriver();
	}

	/******Test Case E4-5342: Chemistry Tools*******/
	@Test
	public void E4_5342( ) throws Exception{

		ResultUtil.report("INFO", "MathEnhancement-E4_5342", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		StudentLoginpage studenthome = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studenthome.loginPageStudent(dataMap, "Email", "Password");

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);


		//Navigate to admin URL
		Browser.navigateURL(driver, dataMap.get("AdminUrl"));
		//Login as admin
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Validate home page
		SnapwziCoursesListPage snapwziCoursesListPage = snapwizHomePage.validateSnapwizHomepage();

		//Goto courses tab
		snapwizHomePage.gotoCoursesTab();
		
		CreateEditAssignmentPage createEditAssignmentPage= PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//Validate course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		//Verify allow show work frame
		coursePropertiesPage.verifyAllowShowWorkFrame();

		//Select chemistry tools
		coursePropertiesPage.selectChemistryTools();

		//Save the settings
		coursePropertiesPage.saveSettings();

		//Navigate to student URL
		Browser.navigateURL(driver, strStudentURL);

		//Login as student
		studenthome.loginPage(dataMap);

		//Go to assignment page
		studentHomepage.goToAssignment();

		//Click next button
		openAssignment.clickNext();

		//Verfi show work
		openAssignment.verifyShowWork();

		//Edit in show work
		openAssignment.editInShowWork();

		//Click Assigment Link
		createEditAssignmentPage.assignmentLink();

		driver = createEditAssignmentPage.getDriver();

	}
	/******Test Case E4-5303: Course Details (Properties) screen Show Work options appearance*****/
	@Test
	public void E4_5303() throws Exception{
		ResultUtil.report("INFO", "MathEnhancement-E4_5303", driver);
		
		//Navigate to admin URL
		Browser.navigateURL(driver, dataMap.get("AdminUrl"));
		//Login as admin
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Validate home page
		SnapwziCoursesListPage snapwziCoursesListPage = snapwizHomePage.validateSnapwizHomepage();

		//Goto courses tab
		snapwizHomePage.gotoCoursesTab();
		
		//Validate course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		//Verify allow show work frame
		coursePropertiesPage.verifyAllowShowWorkFrame();
		
	}

}
