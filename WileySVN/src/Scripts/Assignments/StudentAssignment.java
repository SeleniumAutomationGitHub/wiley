package Scripts.Assignments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.OpenAssignment;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.AssignmentsDataProviderUtil.staticProviderClass;

public class StudentAssignment
{
	WebDriver driver=null;
	Map<String,String> dataMap =null;

	@Factory(dataProvider="StudentAssignment",dataProviderClass=staticProviderClass.class)
	public StudentAssignment(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}

	@Test
	public void StudentAssignmentPrerequsite() throws Exception{

		ResultUtil.createReport("StudentAssignment-studentSubmitsAssignment", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login Page
		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Login Page
		StudentHomepage studentHomepage= studentLoginPage.loginPage(dataMap);

		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap).getDriver();

	}

	public void loginInstructor() throws Exception{
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
		courseHomePage.goToAssigmentPage();

		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);

		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage().getDriver();

	}

	/****Test Case E4-4486: Question Assignment Player - Student - Question types. True-False ****/
	@Test
	public void Pre_4486_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes2");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4486() throws Exception
	{

		ResultUtil.createReport("StudentAssignment-studentSubmitsAssignment", dataMap);


		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//select assignment
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");

		//click next buton to attend test
		openAssignment.clickNext();

		//select first radio button
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//review answer
		openAssignment.verifyResult();

		//select second radio buton
		openAssignment.selectSecondAnswerInTrueFalse();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4487: Question Assignment Player - Student - Question types. Multiple-Choice****/

	@Test
	public void Pre_4487_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes1");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4487( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4487", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();

		//verify multiple choice answer
		openAssignment.verifyMultipleChoiceAnswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4489: Question Assignment Player - Student - Question types. Text-Entry****/

	@Test
	public void Pre_4489_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes5");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4489( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4489", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment for txt entry
		openAssignment.selectTextEntryAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify text entry answer
		openAssignment.verifyTextEntryAnswer(dataMap);

		//click on assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4493: Question Assignment Player - Student - Question types. Text-Entry Numeric with Units****/
	@Test
	public void Pre_4493_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes1");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4493( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4493", driver);

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Navigate to another domain
		Browser.navigateURL(driver,dataMap.get("DomainClassURL"));

		//Login
		StudentHomepage studentHomepage=studentLoginPage.loginPageStudent(dataMap, "Email B", "Password B");

		//Navigate to assignment tab
		studentHomepage.studentHomeScreen(dataMap);

		//opent assignment for text entry with units
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "AsgntNametxtentryUnits");

		//click next
		openAssignment.clickNext();

		//verify text entry answer
		openAssignment.verifyTextEntryWithNumericUnits(dataMap);

		//click on assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4492: Question Assignment Player - Student - Question types. Text-Entry Numeric****/
	@Test
	public void Pre_4492_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes1");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4492( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4492", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//for logout session
		LogoutSessionPage logoutSessionPage=PageFactory.initElements(driver, LogoutSessionPage.class);


		//open assignment for text entry with units
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "AsgntNametxtentryUnits");

		//click next
		openAssignment.clickNext();

		//verify text entry answer
		openAssignment.verifyTextEntryWithNumericUnits(dataMap);

		//click on assignment link
		openAssignment.selectAssignmentLink();

		//Logout
		logoutSessionPage.logOutSession();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4490: Question Assignment Player - Student - Question types. Text-Entry with Dropdown****/

	@Test
	public void Pre_4490_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}
	
	@Test
	public void E4_4490( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4490", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");


		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Navigate to domain
		Browser.navigateURL(driver, strURL);

		//Login
		StudentHomepage studentHomepage=studentLoginPage.loginPage(dataMap);

		//navigate assignment page
		studentHomepage.studentHomeScreen(dataMap);

		//open assignment for text entry with dropdown
		openAssignment.selectTextEntryWithDropdown(dataMap);

		//click next
		openAssignment.clickNext();

		//verify text entry answer
		openAssignment.answerQuestions();

		//Submit Answer
		openAssignment.selectSubmitAnswer();

		//Alert Accept
		openAssignment.alertAccept();

		//click on assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4494: Question Assignment Player - Student - Question types. Matching****/
	@Test
	public void E4_4494( ) throws Exception
	{
		ResultUtil.report("INFO", "StudentAssignment-E4_4494", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment for matching
		openAssignment.selectMatching(dataMap);

		//click next
		openAssignment.clickNext();

		//verify matching answer
		openAssignment.verifyMatching();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-387: Assignment Player - Student - Questions/Exercises Assignment****/
	@Test
	public void E4_387( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_387", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with answer
		openAssignment.selectTextEntryWithDropdown(dataMap);

		//click next
		openAssignment.clickNext();	

		//enter answer
		openAssignment.answerQuestions();

		//submit the answer
		openAssignment.selectSubmitAnswer();

		//alert accept
		openAssignment.alertAccept();

		//verify the result
		openAssignment.verifyResult();

		//click review score
		openAssignment.clickReviewScore();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4447: Question Assignment Player - Student. Description & Policies****/
	@Test
	public void E4_4447( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4447", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with all types of settings
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//verify the assignment name
		openAssignment.verifyAssignmentName(dataMap);

		//click next
		openAssignment.clickNext();

		//click back 
		openAssignment.clickBack();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4484: Question Assignment Player - Student. Current Date****/
	@Test
	public void Pre_4484_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

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

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4484( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4484", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

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

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4449: Question Assignment Player - Student. Review Results by Study Objective****/
	@Test
	public void E4_4449( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4449", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment for studyobjective
		openAssignment.selectStudyObjectiveAssignment(dataMap);

		//verify the presence and click  study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//verify Results
		openAssignment.verifyResultsColumn();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4450: Question Assignment Player - Student. Added questions****/
	@Test
	public void E4_4450( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4450", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open 100 question assignment
		openAssignment.select100QuestionAssignment(dataMap);

		//verify question size
		openAssignment.verifyQuestionSize();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4451: Question Assignment Player - Student. Order of questions****/
	@Test
	public void E4_4451( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4451", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//verify the order of questions
		openAssignment.verifyOrderOfQuestions();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4452: Question Assignment Player - Student. Potential Score****/
	@Test
	public void E4_4452( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4452", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with potential score modified
		openAssignment.selectStudyObjectiveAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify matching answer
		openAssignment.verifyMatching();		

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get earned score
		openAssignment.getTotalScore();

		//click review results by study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//verify results column
		openAssignment.verifyResultsColumn();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4453: Question Assignment Player - Student. Required Show Work****/
	@Test
	public void E4_4453( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4453", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

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

		//click open show work
		openAssignment.verifyShowWork();

		//Close window
		createEditAssignment.closeWindow1();

		//focus mainwindow
		createEditAssignment.focusMainWindow();	

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4454: Question Assignment Player - Student. Quest. Count****/
	@Test
	public void E4_4454( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4454", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignemnt question pool
		openAssignment.selectQuestionpoolAssignment(dataMap);

		//verify question in pool
		openAssignment.verifyQuestionsInPool();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open assignment question pool
		openAssignment.selectQuestionpoolAssignment(dataMap);

		//verify question in pool
		openAssignment.verifyQuestionsInPool();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-5764: Question Assignment Player - Student. Question Pool grading****/
	@Test
	public void E4_5764( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5764", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignemnt question pool
		openAssignment.selectQuestionpoolAssignment(dataMap);

		//click next to open question
		openAssignment.clickNext();

		//select show answer
		openAssignment.selectShowAnswer();

		//Enter answer
		openAssignment.answerQuestions();

		//click submit button
		openAssignment.selectSubmitAnswer();

		//handle alert
		openAssignment.alertAccept();

		//click review score
		openAssignment.clickReviewScore();

		//click review for study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4455: Question Assignment Player - Student. Limited Attempts****/
	@Test
	public void E4_4455( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4455", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment multistep //Executed
		openAssignment.selectMultiStepAssignment(dataMap);

		//Click next
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();

		//exhaust all attempts
		openAssignment.selectFirstAnswerInTrueFalse();
		openAssignment.selectSubmitAnswer();
		openAssignment.selectFirstAnswerInTrueFalse();
		openAssignment.selectSubmitAnswer();
		openAssignment.selectFirstAnswerInTrueFalse();
		openAssignment.selectSubmitAnswer();
		openAssignment.selectFirstAnswerInTrueFalse();
		openAssignment.selectSubmitAnswer();

		//verify submit and save for later are displayed
		openAssignment.verifySubmitanswer();

		//click next
		openAssignment.clickNext();

		//exhaust attempts for multistep
		openAssignment.exhaustAttemptsForMultistep(dataMap);

		//verify submit and save for later are displayed
		openAssignment.verifySubmitanswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4456: Question Assignment Player - Student. Unlimited Attempts****/
	@Test
	public void E4_4456( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4456", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment multistep
		openAssignment.selectMultiStepAssignment(dataMap);

		//Click next
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();

		//click first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//submit answer
		openAssignment.clickSubmitAnswerForUnlimited();

		//verify submit and save for later are displayed
		openAssignment.verifySubmitanswer();

		//click next
		openAssignment.clickNext();

		//exhaust attempts for multistep
		openAssignment.exhaustAttemptsForMultistep(dataMap);

		//click submit answer
		openAssignment.clickSubmitAnswerForUnlimited();

		//verify submit and save for later are displayed
		openAssignment.verifySubmitanswer();

		//click assignmetn link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4460: Question Assignment Player - Student. Disable immediate feedback****/
	@Test
	public void E4_4460( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4460", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectMultistepImmediatefeedback(dataMap); // multiple choice with more than 4 attempts

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();

		//verify immediate feed back
		openAssignment.verifyImmediateFeedback();

		//click review score
		openAssignment.clickReviewScore();

		//verify the total score
		openAssignment.getTotalScore();

		//click review study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//click assignmetn link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4461: Question Assignment Player - Student. Disabled Show Work****/
	@Test
	public void E4_4461( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4461", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify show work link
		openAssignment.verifyShowWorkLink();

		//click next
		openAssignment.clickNext();

		//verify show work link
		openAssignment.verifyShowWorkLink();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4462: Question Assignment Player - Student. Question Assistance: SHOW NEVER****/
	@Test
	public void E4_4462( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4462", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assistance buttons
		openAssignment.verifyAssistanceButtons();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4463: Question Assignment Player - Student. Question Assistance: SHOW ALWAYS ****/
	@Test
	public void E4_4463( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4463", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assistance buttons
		openAssignment.verifyAssistanceButtons();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4475: Question Assignment Player - Student. Allowed Printing****/
	@Test
	public void E4_4475( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4475", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click print a copy
		openAssignment.clickAndClosePrintABlankCopy();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click next
		openAssignment.clickNext();

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();		

		//Select Submit Answer
		openAssignment.selectSubmitAnswer();

		//Alert accept
		openAssignment.alertAccept();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open assignment
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click print a copy
		openAssignment.clickAndClosePrintABlankCopy();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//Alert accept
		openAssignment.alertAccept();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4465: Question Assignment Player - Student. Applied Point Potential: Attempt Policy****/
	@Test
	public void E4_4465( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4465", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open multistep assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//click review score
		openAssignment.clickReviewScore();

		//get total score earned
		openAssignment.getTotalScore();

		//click on first question
		openAssignment.clickOnFirstQuestion();

		//click next
		openAssignment.clickNext();

		//click first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get earned score
		openAssignment.getTotalScore();

		//click on first question
		openAssignment.clickOnFirstQuestion();

		//click next
		openAssignment.clickNext();

		//click second answer
		openAssignment.selectSecondAnswerInTrueFalse();

		// click submit answer for unlimited
		openAssignment.clickSubmitAnswerForUnlimited();

		//click review score
		openAssignment.clickReviewScore();

		//get earned score
		openAssignment.getTotalScore();

		//click review score study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//click on first question
		openAssignment.clickOnFirstQuestion();

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();

		//get and enter answer	
		openAssignment.answerQuestions();

		//click on submit answer
		openAssignment.selectSubmitAnswer();
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get earned score
		openAssignment.getTotalScore();

		//click study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4466: Question Assignment Player - Student. Applied Point Potential: Assistance Policy****/
	@Test
	public void E4_4466( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4466", driver);


		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignemnt multistep
		openAssignment.selectMultiStepAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//click show answer button
		openAssignment.selectShowAnswer();

		//click close button
		openAssignment.clickClose();

		//Focus main window
		createEditAssignment.focusMainWindow();

		//click show answer button
		openAssignment.selectShowAnswer();

		//click go button
		openAssignment.clickGo();

		//click close window
		openAssignment.closeWindow();

		createEditAssignment.focusMainWindow();

		//click first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get earned score
		openAssignment.getTotalScore();

		//move to first quesiton
		openAssignment.clickOnFirstQuestion();

		//click show hint
		openAssignment.selectShowHint();

		//click close button
		openAssignment.clickClose();			

		createEditAssignment.focusMainWindow();	

		//click show hint
		openAssignment.selectShowHint();

		//click go button
		openAssignment.clickGo();

		//click close window
		openAssignment.closeWindow();

		createEditAssignment.focusMainWindow();

		//click next
		openAssignment.clickNext();

		//click show solution
		openAssignment.selectShowSolution();

		//click close button
		openAssignment.clickClose();

		createEditAssignment.focusMainWindow();

		//click show answer button
		openAssignment.selectShowSolution();

		//click go button
		openAssignment.clickGo();

		//click close window
		openAssignment.closeWindow();

		createEditAssignment.focusMainWindow();

		//click assignmetn link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4467: Question Assignment Player - Student. Applied Point Potential: Attempt Policy + Assistance Policy****/
	@Test
	public void E4_4467( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4467", driver);

		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment multistep
		openAssignment.selectMultiStepAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//enter correct answer
		//click submit answer
		openAssignment.selectSubmitAnswer();

		//navigate to review score
		openAssignment.clickReviewScore();

		//get earned value
		openAssignment.getTotalScore();

		// go to first question
		openAssignment.clickOnFirstQuestion();

		//click next question
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//click go
		openAssignment.clickGo();

		//close window 
		openAssignment.closeWindow();

		createEditAssignment.focusMainWindow();

		//click submit answer for three times
		openAssignment.selectSubmitAnswer();
		openAssignment.selectSubmitAnswer();
		openAssignment.selectSubmitAnswer();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get earned value
		openAssignment.getTotalScore();

		//click on first question
		openAssignment.clickOnFirstQuestion();

		//click next question
		openAssignment.clickNext();
		openAssignment.clickNext();

		//click submit answer for three times
		openAssignment.selectSubmitAnswer();
		openAssignment.selectSubmitAnswer();
		openAssignment.selectSubmitAnswer();

		//click show answer
		openAssignment.selectShowAnswer();

		//click go
		openAssignment.clickGo();

		//close window 
		openAssignment.closeWindow();

		createEditAssignment.focusMainWindow();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get earned value
		openAssignment.getTotalScore();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4469: Question Assignment Player - Student. Student Access after the Due Date: Yes. Marked Late****/
	@Test
	public void E4_4469( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4469", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//Click Next Button
		openAssignment.clickNext();

		//verify submit and save for later
		openAssignment.verifySubmitanswer();

		//get and enter answer
		//openAssignment.getAndEnterAnswer();
		openAssignment.selectFirstAnswerInTrueFalse();

		//Submit Answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//get Total score
		openAssignment.getTotalScore();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4470: Question Assignment Player - Student. Student Access after the Due Date: Yes. View Only****/
	@Test
	public void E4_4470( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4470", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectViewonlyAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assitance buttons
		openAssignment.verifyAssistanceButtons();

		//verify submit answer
		openAssignment.verifySubmitanswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4471: Question Assignment Player - Student. Student Access after the Due Date: Yes. View Assistance****/
	@Test
	public void E4_4471( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4471", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectViewAssistanceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assitance buttons
		openAssignment.verifyAssistanceButtons();

		//verify submit answer
		openAssignment.verifySubmitanswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4472: Question Assignment Player - Student. Student Access after the Due Date: No****/
	@Test
	public void E4_4472( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4472", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectNoDueAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify assistance buttons
		openAssignment.verifyAssistanceButtons();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open assignment
		openAssignment.selectNoDueAssignment(dataMap);

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();


	}

	/****Test Case E4-4473: Question Assignment Player - Student. Ungraded Assignment****/
	@Test
	public void E4_4473( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4473", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectStudyObjectiveAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//verify matching answer
		openAssignment.verifyMatching();

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//verify result
		openAssignment.verifyResult();

		//click review score
		openAssignment.clickReviewScore();

		//get total score earned
		openAssignment.getTotalScore();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4474: Question Assignment Player - Student. Generic Question Titles****/
	@Test
	public void E4_4474( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4474", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment 
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//verify hided question title
		openAssignment.verifyHidedQuestionTitle();

		//focus Main window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4479: Question Assignment Player - Student. Navigation buttons****/
	@Test
	public void E4_4479( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4479", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//verify back button
		openAssignment.clickBack();

		//verify next button
		openAssignment.clickNext();

		//click study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4480: Question Assignment Player - Student. Printer Version****/
	@Test
	public void E4_4480( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4480", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignmnet
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//click printer version
		openAssignment.clickPrinterVersion();

		//verify page elements
		openAssignment.verifyPrinterVersionElement();

		//click next
		openAssignment.clickNext();

		//click first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//Click Submit Answer
		openAssignment.selectSubmitAnswer();

		//Alert Accept
		openAssignment.alertAccept();

		//click printer version
		openAssignment.clickPrinterVersion();

		//verify page elements
		openAssignment.verifyPrinterVersionElement();

		//click review score
		openAssignment.clickReviewScore();

		//click printer version
		openAssignment.clickPrinterVersion();

		//verify page elements
		openAssignment.verifyPrinterVersionElement();

		//click study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//click printer version
		openAssignment.clickPrinterVersion();

		//verify page elements
		openAssignment.verifyPrinterVersionElement();

		//navigate to description
		openAssignment.navigateToDescription();

		//click printer version
		openAssignment.clickPrinterVersion();

		//verify page elements
		openAssignment.verifyPrinterVersionElement();

		//focus main window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4481: Question Assignment Player - Student. Calculator****/
	@Test
	public void E4_4481( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4481", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);


		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click calculator button
		openAssignment.clickCalculator();

		//Close Window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4482: Question Assignment Player - Student. Full Screen ****/
	@Test
	public void E4_4482( ) throws Exception
	{
		ResultUtil.report("INFO", "StudentAssignment-E4_4482", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//click full screen
		openAssignment.clickFullscreen();

		//click review score
		openAssignment.clickReviewScore();

		//click study objective
		openAssignment.verifyAndClickReviewStudyObjective();

		//navigat to description
		openAssignment.navigateToDescription();

		// click next
		openAssignment.clickNext();

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		// click submit answer
		openAssignment.selectSubmitAnswer();

		//alert accept
		openAssignment.alertAccept();

		//click calculator
		openAssignment.clickCalculator();

		//Close Window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click printer version
		openAssignment.clickPrinterVersion();

		//Close window 
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click standard view
		openAssignment.clickStandarView();

		//Accept Alert
		openAssignment.alertAccept();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4483: Question Assignment Player - Student. Save for Later****/
	@Test
	public void E4_4483( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4483", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment
		openAssignment.selectAssignment(dataMap, "AsgntNameVariousSettings1");

		//navigate to next question
		openAssignment.clickNext();

		//click show work
		openAssignment.verifyShowWork();

		//edit in show work
		openAssignment.editInShowWork();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//navigate to next question
		openAssignment.clickNext();

		//click back
		openAssignment.clickBack();

		//click show work
		openAssignment.verifyShowWork();

		//edit in show work
		openAssignment.editInShowWork();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click save for later
		openAssignment.selectSaveForLater();

		//click next
		openAssignment.clickNext();

		//click Back
		openAssignment.clickBack();

		//click show work
		openAssignment.verifyShowWork();

		//edit in show work
		openAssignment.editInShowWork();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4485: Question Assignment Player - Student. Show Work****/
	@Test
	public void E4_4485( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4485", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment
		openAssignment.selectMatching(dataMap);

		//click next
		openAssignment.clickNext();

		//click open show work
		openAssignment.verifyShowWork();

		//edit in show work
		openAssignment.editInShowWork();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-5762: Question Assignment Player - Student. Check-box "Don't show me this message again." #1****/
	@Test
	public void E4_5762( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5762", driver);

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//for logout session
		LogoutSessionPage logoutSessionPage=PageFactory.initElements(driver, LogoutSessionPage.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//For Student home Page
		StudentHomepage studentHomepage=PageFactory.initElements(driver, StudentHomepage.class);

		//open assignment
		openAssignment.selectAssignment(dataMap, "AsgntNameTimed");

		//check dnt show 
		openAssignment.checkDntShowInTimedAssignment();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//select course and assignment tab
		studentHomepage.studentHomeScreen(dataMap);

		//open assignment
		openAssignment.selectAssignment(dataMap, "AsgntNameTimed");

		//check and go
		openAssignment.checkAndGoInTimedAssignment();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open assignment
		openAssignment.selectAssignment(dataMap, "AsgntNameTimed");

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//logout 
		logoutSessionPage.logOutSession();

		//login
		studentLoginPage.loginPage(dataMap);

		//select course and assignment tab
		studentHomepage.studentHomeScreen(dataMap);

		//open assignment
		openAssignment.selectAssignment(dataMap, "AsgntNameTimed");

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-5772: Question Assignment Player - Student. Check-box "Don't show me this message again. #2****/
	@Test
	public void E4_5772( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5772", driver);

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//for logout session
		LogoutSessionPage logoutSessionPage=PageFactory.initElements(driver, LogoutSessionPage.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//For Student home Page
		StudentHomepage studentHomepage=PageFactory.initElements(driver, StudentHomepage.class);

		//open assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//check dnt show
		openAssignment.checkDntShowInPotentialAssignment();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click show answer
		openAssignment.selectShowAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//check and go
		openAssignment.checkAndGoInPotentialAssignment();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click show answer
		openAssignment.selectShowAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//open another assignment
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//select show answer
		openAssignment.selectShowAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//logout session
		logoutSessionPage.logOutSession();

		//login
		studentLoginPage.loginPage(dataMap);

		//select course and assignment tab
		studentHomepage.studentHomeScreen(dataMap);

		//open assignment
		openAssignment.selectMultiStepAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-390: Assignment Player - Student - Readings/Resources Assignment****/
	@Test
	public void E4_390( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_390", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open reading resource assignment
		openAssignment.selectReadingResourceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//click next
		openAssignment.clickNext();

		//verify feedback column
		openAssignment.verifyFeedbackColumn();

		//click review progress
		openAssignment.clickReviewProgress();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4565: Question Assignment Player - Instructor - Assigned. Review Score****/
	@Test
	public void E4_4565( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4565", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with 4 types of question
		openAssignment.selectMultiStepAssignment(dataMap);

		//click review score
		openAssignment.clickReviewScore();

		//verify maximum potential
		openAssignment.verifyMaximumPotential();

		//verify points earned
		openAssignment.verifyPointsEarned();

		//verify question attempts
		openAssignment.verifyQuestionAttempts();

		//verify check answer column
		openAssignment.verifyCheckAnsweredColumn();

		//get total score
		openAssignment.getTotalScore();

		//verify question title
		openAssignment.verifyQuestionTitle();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4478: Question Assignment Player - Student. Alternative Answers****/
	@Test
	public void E4_4478( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4478", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);


		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open assignment matching
		openAssignment.selectMatching(dataMap);

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//verify Alternative answer
		openAssignment.verifyAlternativeAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//navigate to administrator
		Browser.navigateURL(driver,dataMap.get("AdminUrl"));

		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Navigate to Course tab
		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();

		//Validate the list of courses in the course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);

		//For Student home Page
		StudentHomepage studentHomepage=PageFactory.initElements(driver, StudentHomepage.class);

		//check show alternative answers
		coursePropertiesPage.checkShowAlternativeAnswers();

		//save settings
		coursePropertiesPage.saveSettings();

		//navigate to student login
		Browser.navigateURL(driver, strURL);

		//login
		studentLoginPage.loginPage(dataMap);

		//student home screen
		studentHomepage.studentHomeScreen(dataMap);

		//open assignment matching
		openAssignment.selectMatching(dataMap);

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//verify Alternative answer
		openAssignment.verifyAlternativeAnswer();

		//Close window
		createEditAssignment.closeWindow1();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4477: Question Assignment Player - Student. Start Date in the Future****/
	@Test
	public void E4_4477( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4477", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//For Student home Page
		StudentHomepage studentHomepage=PageFactory.initElements(driver, StudentHomepage.class);

		//create future date assingment while executing		

		//verify assignment is displayed
		openAssignment.verifyAssignmentIsDisplayed(dataMap);

		//navigate to gradebook
		studentHomepage.goToGradeBook();

		//verify assignment is displayed
		openAssignment.verifyAssignmentIsDisplayed(dataMap);

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4476: Question Assignment Player - Student. Timed assignment. Student left the assignment.****/
	@Test
	public void E4_4476( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4476", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open timed assignment
		openAssignment.selectAssignment(dataMap, "AsgntNameTimed");

		//click go button
		openAssignment.clickGo();

		//Focus Window
		createEditAssignment.focusMainWindow();

		//click first question on tree control
		openAssignment.clickOnFirstQuestion();

		//handle alert
		openAssignment.alertAccept();

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//save late
		openAssignment.selectSaveForLater();

		//click next
		openAssignment.clickNext();	

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//click assignment link	
		openAssignment.selectAssignmentLink();

		//accept alert
		openAssignment.alertAccept();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-5685: Question Assignment Player - Student. Timed assignment. Student exhausted all time.****/
	@Test
	public void E4_5685( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5685", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//open timed assignment
		openAssignment.selectAssignment(dataMap,"AsgntNameTimed1");

		//click go button
		openAssignment.clickGo();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//click first question on tree control
		openAssignment.clickOnFirstQuestion();

		//handle alert
		openAssignment.alertAccept();

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//wait for 10 minutes
		//openAssignment.waitFor10Minutes();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//click ok
		openAssignment.alertAccept();	

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}


	/****Test Case E4-5771: Question Assignment Player - Student. Timed assignment****/
	@Test
	public void E4_5771( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5771", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//for logout session
		LogoutSessionPage logoutSessionPage=PageFactory.initElements(driver, LogoutSessionPage.class);

		//Focus CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignment = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//For Student home Page
		StudentHomepage studentHomepage=PageFactory.initElements(driver, StudentHomepage.class);

		//open timed assignment
		openAssignment.selectAssignment(dataMap,"AsgntNameTimed2");

		//click close button
		openAssignment.clickClose();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//open timed assignment
		openAssignment.selectAssignment(dataMap,"AsgntNameTimed2");

		//click go button
		openAssignment.clickGo();

		//Focus Main Window
		createEditAssignment.focusMainWindow();

		//verify time counter absence
		openAssignment.verifyTimeCounter();

		//click studyobjective
		openAssignment.clickStudyObjectiveLink(dataMap);	

		//handle alert
		openAssignment.alertDismiss();

		//verify time counter absence
		openAssignment.verifyTimeCounter();

		//click review score
		openAssignment.clickReviewScore();

		//verify time counter absence
		openAssignment.verifyTimeCounter();

		//click first question on tree control
		openAssignment.clickOnFirstQuestion();

		//handle alert
		openAssignment.alertDismiss();

		//click first question on tree control
		openAssignment.clickOnFirstQuestion();

		//handle alert
		openAssignment.alertAccept();

		//verify time counter
		openAssignment.verifyTimeCounter();

		//click time counter
		openAssignment.clickTimeCounter();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//dismis alert
		openAssignment.alertDismiss();

		//click home tab
		studentHomepage.goToHome();

		//accept alert
		openAssignment.alertAccept();

		//Logout session
		logoutSessionPage.logOutSession();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-5970: Question Assignment Player - Student - Numeric Policies. Percentage tolerance set ****/
	@Test
	public void E4_5970( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5970", driver);

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);



		//navigate url to class 
		Browser.navigateURL(driver,dataMap.get("DomainClassURL"));

		//login
		//For Student home Page
		StudentHomepage studentHomepage=studentLoginPage.loginPageStudent(dataMap, "Email B", "Password B");

		studentHomepage.studentHomeScreen(dataMap);

		//select tolerance assignment
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "AsgntNametxtentryUnits"); 

		//click next
		openAssignment.clickNext();

		//enter answer
		openAssignment.enterExactAnswerForTolerance(dataMap);

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//verify answer column
		openAssignment.verifyResult();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-5967: Question Assignment Player - Student- Numeric Policies.Simultaneous usage of various tolerance types****/
	@Test
	public void E4_5967( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5967", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//select tolerance assignment
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "AsgntNametxtentryUnits"); 

		//click next
		openAssignment.clickNext();

		//mouse move on entry field to check the tool tip
		openAssignment.moveOnEntryField();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();


	}

	/****Test Case E4-4457: Question Assignment Player - Student. Use same values****/	 
	@Test
	public void E4_4457( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4457", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//select tolerance assignment
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "AsgntNametxtentryUnits"); 

		//click next
		openAssignment.clickNext();	 

		//enter answer
		openAssignment.enterExactAnswerForTolerance(dataMap);

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4458: Question Assignment Player - Student. Use new values****/
	@Test
	public void E4_4458( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4458", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//select tolerance assignment
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "SameValues"); 

		//click next
		openAssignment.clickNext();

		//click on first radio button
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//verify repeat questions
		openAssignment.verifyRepeatWithNewValues();

		//verify submit button
		openAssignment.verifySubmitanswer();

		//select repeat with newvalues
		openAssignment.selectRepeatWithNewValues();

		//verify repeat questions
		openAssignment.verifyRepeatWithNewValues();

		//verify submit button
		openAssignment.verifySubmitanswer();

		//click next
		openAssignment.clickNext();

		//click show answer
		openAssignment.selectShowAnswer();

		//click assignment link
		openAssignment.selectAssignmentLink(); 

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4459: Question Assignment Player - Student. Use static values****//*
	@Test
	public void E4_4459( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4459", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);


		//create assignment with static values 

		//select tolerance assignment
		openAssignment.selectTextEntryNumericWithUnits(dataMap, "NewValues"); //create appropriate assignment

		//click next
		openAssignment.clickNext();

		//enter answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//verify submit answer and save for later
		openAssignment.verifySubmitanswer();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//logout 
		logoutSessionPage.logOutSession();

		//Alert Handling
		logoutSessionPage.handlingAlert(); 
	 */
	/****Test Case E4-4488: Question Assignment Player - Student - Question types. Multiple-Selection****/

	@Test
	public void Pre_4488_Condtion() throws Exception{

		loginInstructor();

		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AssignmentId", "AssignmentName");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//select chapter and source
		createEditAssignmentPage.chooseChapter();

		//select go
		createEditAssignmentPage.selectGo();

		//select questions
		createEditAssignmentPage.selectSpecificQuestion(dataMap, "QuestionTypes1");

		//click next button
		createEditAssignmentPage.selectNextButton();

		//click next button
		createEditAssignmentPage.selectNextButton();

		//selectNextButton
		createEditAssignmentPage.selectNextButton();

		//selectAssigntoClassButton
		createEditAssignmentPage.selectAssigntoClassButton();

		//assigntoclass
		createEditAssignmentPage.assigntoclass(dataMap);

		//selectSubmitButton
		createEditAssignmentPage.selectSubmitButton();

		createEditAssignmentPage.closeWindow1();

		driver=createEditAssignmentPage.getDriver();
	}

	@Test
	public void E4_4488( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4487", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();
		openAssignment.clickNext();
		openAssignment.clickNext();

		//verify multiple choice answer
		openAssignment.verifyMultipleChoiceAnswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();
	}

	/****Test Case E4-4491: Question Assignment Player - Student - Question types. Formula****/
	@Test
	public void E4_4491( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4491", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//open assignment with formulas assign appropriate assignment
		openAssignment.selectmultiChoiceAssignment(dataMap);

		//click next
		openAssignment.clickNext();

		//select first answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit
		openAssignment.selectSubmitAnswer();

		//select second answer
		openAssignment.selectSecondAnswerInTrueFalse();

		//click submit
		openAssignment.selectSubmitAnswer();

		//click assignment link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-4468: [DRAFT] Assignment Player - Student. Numeric Policies****/
	@Test
	public void E4_4468( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4468", driver);

		/* //open an assignment
		openAssignment.selectVariousSettingsAssignment(dataMap);

		//verify description page
		openAssignment.verifyDescriptionPage();

		//click assignment link
		openAssignment.selectAssignmentLink();*/


	}

	/****Test Case E4-4448: Question Assignment Player - Student. Review Score ****/
	@Test
	public void E4_4448( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_4448", driver);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//for logout session
		LogoutSessionPage logoutSessionPage=PageFactory.initElements(driver, LogoutSessionPage.class);

		//open assignment name geography
		openAssignment.selectMultipleQuestionAssignment1(dataMap);

		//click review score
		openAssignment.clickReviewScore();

		//get total score
		openAssignment.getTotalScore();

		//verify all questions
		openAssignment.verifyAllQuestions();

		//verify due date stamp
		openAssignment.verifyDueDateStamp();

		//verify gradebook stamp
		openAssignment.verifySavedToGradeBookStamp();

		//move to first question
		openAssignment.clickOnFirstQuestion();

		//click next
		openAssignment.clickNext();

		//click next
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit answer
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//verify saved to gradebook stamp
		openAssignment.verifySavedToGradeBookStamp();

		//click assignment link
		openAssignment.selectAssignmentLink();

		//select microprocessor assignment
		openAssignment.selectMultipleQuestionAssignment2(dataMap);

		//click review scoer
		openAssignment.clickReviewScore();

		//verify answered column
		openAssignment.verifyCheckAnsweredColumn();

		//verify question attempts
		openAssignment.verifyQuestionAttempts();

		//verify due date stamp
		openAssignment.verifyDueDateStamp();

		//verify gradebook stamp
		openAssignment.verifySavedToGradeBookStamp();

		//move to first quesiton
		openAssignment.clickOnFirstQuestion();

		//click next
		openAssignment.clickNext();

		//select First answer
		openAssignment.selectFirstAnswerInTrueFalse();

		//click submit
		openAssignment.selectSubmitAnswer();

		//click review score
		openAssignment.clickReviewScore();

		//verify gradebook stamp
		openAssignment.verifySavedToGradeBookStamp();

		//logout 
		logoutSessionPage.logOutSession();

		driver=openAssignment.getDriver();

	}

	/****Test Case E4-5765: Concept Mastery Assignment Player - Student. Review Score****/
	@Test
	public void E4_5765( ) throws Exception
	{

		ResultUtil.report("INFO", "StudentAssignment-E4_5765", driver);

		StudentLoginpage studentLoginPage = PageFactory.initElements(driver, StudentLoginpage.class);

		//Selecting the assignment link
		OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

		//Navigate to Concept Mastery Page
		Browser.navigateURL(driver, dataMap.get("ConceptMasteryURL"));

		//Login as student
		StudentHomepage studentHomepage=studentLoginPage.loginPageStudent(dataMap, "Email B", "Password B");

		//Click on assignment tab
		studentHomepage.goToAssignment();

		//Select maserty assignment
		openAssignment.selectMasteryAssignment(dataMap);

		//verify and answer the question
		openAssignment.verifyMasteryQuestion();

		//Click next button
		openAssignment.clickNext();

		//Answer second question
		openAssignment.verifyMasteryQuestion();

		//Select Review Score
		openAssignment.clickReviewScore();

		//verify total score
		openAssignment.verifyMasteryScore();

		//move to first quesiton
		openAssignment.clickOnFirstQuestion();

		//Click next button
		openAssignment.clickNext();

		//Click next button
		openAssignment.clickNext();

		//Answer second question
		openAssignment.verifyMasteryQuestion();

		//Select Review Score
		openAssignment.clickReviewScore();

		//verify total score
		openAssignment.verifyMasteryScore(); 

		//Click assignment  link
		openAssignment.selectAssignmentLink();

		driver=openAssignment.getDriver();

	}

}