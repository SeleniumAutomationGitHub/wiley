package Scripts.GradeBook;

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
import Pages.Common.StudentHomepage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class GradebookPreCondition{
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="Preconditions",dataProviderClass=staticProviderClass.class)
	public GradebookPreCondition(Map<String,String> dataMap) {
		this.dataMap=dataMap;
	}
	
	@Test
	public void loginToCreateAssignment() throws Exception{
		
		ResultUtil.createReport("GradeBookInstructorVerification-gradeBookPre", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		driver=courseSelectionPage.getDriver();
		
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
				
		//GoTo Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		//Goto Create Edit Assignment page
		assignmentPage.goToCreateEditAssignmentPage().getDriver();
	}
		
	@Test
	public void createFirstAssignmentForSubmit() throws Exception{
		
		//Object for CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
				
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntSubmitID1", "AsgntSubmitName1");

		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForFirstAssignmentInPre(dataMap);
		
		//call Assignment Scripts
		createAsgntSteps();
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	@Test
	public void createSecondAssignmentForSubmit() throws Exception{
		
		//Object for CreateEditAssignment Page
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
				
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntSubmitID2", "AsgntSubmitName2");
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForSecondAssignmentInPre(dataMap);
		
		//call Assignment Scripts
		createAsgntSteps();
		
		//Check study objective
		createEditAssignmentPage.verifyAndCheckStudyObjective();
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	//Description: Attend Test
	public void attendTestForSubmit(){
		
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		studentHomePage.goToAssignment().getDriver();
		
		//Initializing open assignment page
		OpenAssignment openAssignment=PageFactory.initElements(driver, OpenAssignment.class);

		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntSubmitName1");
		
		//Answering Questions
		testAnswer();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntA(dataMap,"WorkSheetNameSubmit");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntA(dataMap,"WorkSheetNameSubmit");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntA(dataMap,"WorkSheetNameSubmit");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntA(dataMap,"WorkSheetNameSubmit");
		
		//insert question attempts in column
		openAssignment.getQuestionAttemptsAsgntA(dataMap,"WorkSheetNameSubmit");
		
		//click on assignment link
		openAssignment.selectAssignmentLink();
		
		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntSubmitName2");
		
		//Answering Questions
		testAnswer();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntB(dataMap,"WorkSheetNameSubmit");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntB(dataMap,"WorkSheetNameSubmit");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntB(dataMap,"WorkSheetNameSubmit");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntB(dataMap,"WorkSheetNameSubmit");
		
		//insert question attempts in column
		openAssignment.getQuestionAttemptsAsgntB(dataMap,"WorkSheetNameSubmit");
	}
	
	@Test
	//Description: Attending test By student B
	public void attendTestStudentBForSubmit() throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");

		attendTestForSubmit();
		
		Browser.closeDriver(driver);
	}
	
	@Test
	public void attendTestStudentAForSubmit() throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
		
		attendTestForSubmit();
		
		Browser.closeDriver(driver);
	}
	
	@Test
	public void createFirstAssignmentForEdit() throws Exception{
		
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
				
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntEditID1", "AsgntEditName1");
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForFirstAssignmentInPre(dataMap);
		
		//call Assignment Scripts
		createAsgntSteps();
			
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	@Test
	public void createSecondAssignmentForEdit() throws Exception{
		
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
				
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntEditID2", "AsgntEditName2");
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForSecondAssignmentInPre(dataMap);
		
		//call Assignment Scripts
		createAsgntSteps();
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	//Description: Attend Test
	public void attendTestForEdit(){
		
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		studentHomePage.goToAssignment().getDriver();
		
		//Initializing open assignment page
		OpenAssignment openAssignment=PageFactory.initElements(driver, OpenAssignment.class);

		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntEditName1");
		
		//Answering Questions
		testAnswer();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntA(dataMap,"WorkSheetNameEdit");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntA(dataMap,"WorkSheetNameEdit");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntA(dataMap,"WorkSheetNameEdit");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntA(dataMap,"WorkSheetNameEdit");
		
		//insert question attempts in column
		openAssignment.getQuestionAttemptsAsgntA(dataMap,"WorkSheetNameEdit");
		
		//click on assignment link
		openAssignment.selectAssignmentLink();
		
		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntEditName2");
		
		//Answering Questions
		testAnswer();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntB(dataMap,"WorkSheetNameEdit");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntB(dataMap,"WorkSheetNameEdit");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntB(dataMap,"WorkSheetNameEdit");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntB(dataMap,"WorkSheetNameEdit");
		
		//insert question attempts in column
		openAssignment.getQuestionAttemptsAsgntB(dataMap,"WorkSheetNameEdit");
	}
	
	@Test
	//Description: Attending test By student B
	public void attendTestStudentBForEdit() throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");

		attendTestForEdit();
		
		Browser.closeDriver(driver);
	}
	
	@Test
	public void attendTestStudentAForEdit() throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
		
		attendTestForEdit();
		
		Browser.closeDriver(driver);
	}
	
	@Test
	public void loginNavigateGradeBook() throws Exception{
		
		ResultUtil.createReport("GradeBookInstructorVerification-gradeBookSubmitPre", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		driver=courseSelectionPage.getDriver();
		
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		//go to gradebook
		courseHomePage.goToGradebookPage();
	}

	@Test
	public void editScore() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =PageFactory.initElements(driver, GradeBookPage.class);
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
			
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
		
		//click on assignment link
		gradeBookPage.clickAssignmentLink(dataMap, "AsgntEditName1");
		
		//Score Edit for Question1
		gradeBookPage.clickFirstQuestionAttempt(dataMap);
		
		//Score Edit For Question 2
		gradeBookPage.clickSecondQuestionAttempt(dataMap);
		
		//Score Edit For Question 2
		gradeBookPage.clickThirdQuestionAttempt(dataMap);
	}
	
	@Test
	public void editAllScore() throws Exception{
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =PageFactory.initElements(driver, GradeBookPage.class);
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
			
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//Click All student and Edit Score
		gradeBookPage.clickAllStudentLink(dataMap);
	}
	
	private void createAsgntSteps(){
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);

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

	}
	
	private void testAnswer(){
		//Initializing open assignment page
		OpenAssignment openAssignment=PageFactory.initElements(driver, OpenAssignment.class);

		//click next
		openAssignment.clickNext();
		
		//answering multi choice question
		openAssignment.selectSecondAnswerInMultiChoice();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();

		//answering multichoice question
		openAssignment.selectThirdAnswerInMultiChoice();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();

		//answering multi choice question
		openAssignment.selectFirstAnswerInTrueFalse();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();

		//answering multichoice question
		openAssignment.selectSecondAnswerInTrueFalse();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();
		
		//answer every textbox in multip step question
		openAssignment.exhaustAttemptsForMultistep(dataMap);
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();

		//answering fill question
		openAssignment.answerFillQuestion(dataMap);
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();
		
		//answering wrong
		openAssignment.answerIncorret(dataMap);
		
		//click submit answer
		openAssignment.selectSubmitAnswer();
		
		//click next
		openAssignment.clickNext();
	}
	
	@Test
	public void createFirstAssignmentForEditAll(){
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
		
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntEditAllID1", "AsgntEditAllName1");
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForFirstAssignmentInPre(dataMap);
		
		//call Assignment Scripts
		createAsgntSteps();
			
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	@Test
	public void createSecondAssignmentForEditAll(){
		CreateEditAssignmentPage createEditAssignmentPage=PageFactory.initElements(driver, CreateEditAssignmentPage.class);
		
		//input description details
		createEditAssignmentPage.inputDescriptionDetails(dataMap, "AsgntEditAllID2", "AsgntEditAllName2");
		
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Description: Choose Chapter  in Select Question screen
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		createEditAssignmentPage.selectGo();
		
		//Description: select questions
		createEditAssignmentPage.selectQuestionsForSecondAssignmentInPre(dataMap);
		
		//call Assignment Scripts
		createAsgntSteps();
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	//Attent Test for Edit All Student
	public void attendTestEditALLStudent(){
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		studentHomePage.goToAssignment().getDriver();
		
		//Initializing open assignment page
		OpenAssignment openAssignment=PageFactory.initElements(driver, OpenAssignment.class);

		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntEditAllName1");
		
		//Answering Questions
		testAnswer();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntA(dataMap,"WorkSheetNameEditAll");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntA(dataMap,"WorkSheetNameEditAll");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntA(dataMap,"WorkSheetNameEditAll");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntA(dataMap,"WorkSheetNameEditAll");
		
		//insert question attempts in column
		openAssignment.getQuestionAttemptsAsgntA(dataMap,"WorkSheetNameEditAll");
		
		//click on assignment link
		openAssignment.selectAssignmentLink();
		
		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntEditAllName2");
		
		//Answering Questions
		testAnswer();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntB(dataMap,"WorkSheetNameEditAll");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntB(dataMap,"WorkSheetNameEditAll");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntB(dataMap,"WorkSheetNameEditAll");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntB(dataMap,"WorkSheetNameEditAll");
		
		//insert question attempts in column
		openAssignment.getQuestionAttemptsAsgntB(dataMap,"WorkSheetNameEditAll");
	}
	
	@Test
	//Description: Attending test By student B
	public void attendTestStudentBForEditAll() throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");

		attendTestEditALLStudent();
		
		Browser.closeDriver(driver);
	}
	
	@Test
	public void attendTestStudentAForEditAll() throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
		
		attendTestEditALLStudent();
		
		Browser.closeDriver(driver);
	}

	
	@Test
	public void createAssignmentSubmitScoreEdit() throws Exception{
		
		ResultUtil.createReport("GradeBookInstructorVerification-gradeBookPre", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".SPECIFIC_QUESTION_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
						
		home.studentLogin(dataMap, "Email", "Password");
				
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
		
		//call Assignment Scripts
		createAsgntSteps();
		
		//Click Submit Button
		createEditAssignmentPage.selectSubmitButton();
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		//focus main window
		createEditAssignmentPage.focusMainWindow();

		Browser.closeDriver(driver);
	}
	
	@Test
	public void attendQuestionForSubmitEditScore() throws InterruptedException{
		ResultUtil.createReport("GradeBookInstructorVerification-gradeBook", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_SCORE_EDIT_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
				
		//Login
		StudentHomepage studentHomePage=home.studentLogin(dataMap, "StudentA", "PasswordA");
			
		studentHomePage.goToAssignment().getDriver();
		
		//Initializing open assignment page
		OpenAssignment openAssignment=PageFactory.initElements(driver, OpenAssignment.class);

		//selecting first assignment
		openAssignment.selectAssignment(dataMap, "AsgntSubmitScoreEditName1");
		
		//Click next Button
		openAssignment.clickNext();
		
		//Enter Value in Answer Field
		openAssignment.attemptQuestionBriefExcercise11(dataMap);
		
		//Submit Answer Button
		openAssignment.selectSubmitAnswer();
		
		//Submit Answer Button
		openAssignment.selectSubmitAnswer();
		
		//Click Next Button
		openAssignment.clickNext();
		
		//Enter Value in Answer field
		openAssignment.attemptIFRSquestion(dataMap);
		
		//Submit Answer Button
		openAssignment.selectSubmitAnswer();
		
		//Submit Answer Button
		openAssignment.selectSubmitAnswer();
		
		//Click Next Button
		openAssignment.clickNext();
		
		//Attempt Answer For Questions
		openAssignment.attemptAssignmentQuestion20(dataMap);
		
		//Click Next Button
		openAssignment.clickNext();
		
		//Click Submit button
		openAssignment.attemptProblem12A(dataMap);
		
		//Click Submit
		openAssignment.selectSubmitAnswer();
		
		//Click Next Button
		openAssignment.clickNext();
		
		//Click Submit button
		openAssignment.attemptProblem12A(dataMap);
		
		//Click Next Button
		openAssignment.selectSubmitAnswer();
		
		//Click Next Button
		openAssignment.clickNext();
		
		//Attempt the Question
		openAssignment.attemptProblem12A(dataMap);
		
		//Click Submit button
		openAssignment.selectSubmitAnswer();
		
		//Click Next Button
		openAssignment.clickNext();
		 
		//Click Submit button
		openAssignment.selectSubmitAnswer();
		
		//Click Next Button
		openAssignment.clickNext();
		
		//insert answered column
		openAssignment.getAnsweredColumnAsgntA(dataMap,"WorkSheetNameScoreSubmit");
		
		//insert points earned in column
		openAssignment.getPointsEarnedAsgntA(dataMap,"WorkSheetNameScoreSubmit");
		
		//insert maximum points in column
		openAssignment.getMaximumPointsAsgntA(dataMap,"WorkSheetNameScoreSubmit");
		
		//inser total score in column
		openAssignment.getTotalEarnedAndMaxScoreAsgntA(dataMap,"WorkSheetNameScoreSubmit");
		
		Browser.closeDriver(driver);
	}
	
	@Test
	//Description: Edit the Score in Edited Column
	public void submitEditScore() throws Exception{
		ResultUtil.createReport("GradeBookInstructorVerification-gradeBookPre", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".SPECIFIC_QUESTION_URL");
				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
						
		home.studentLogin(dataMap, "Email", "Password");
				
		//Select Course
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
				
		courseHomePage.getDriver();
		
		//Go to GradeBook
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class NAme from drop down
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap, "ClassName");
		
		//Select the Assignment from list box
		gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
		
		//Click go button
		gradeBookPage.clickGoButton();
		
		//Click the Assignment Link
		gradeBookPage.clickAssignmentId(dataMap, "AsgntSubmitScoreEditID1");
		
		//Edit the Score
		gradeBookPage.editScoreForSubmitPre(dataMap);
		
		Browser.closeDriver(driver);
	}
	
}
