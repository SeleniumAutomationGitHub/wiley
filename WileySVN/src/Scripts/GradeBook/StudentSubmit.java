package Scripts.GradeBook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.HomePage;
import Pages.Common.StudentHomepage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class StudentSubmit {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SubmitPrecondition",dataProviderClass=staticProviderClass.class)
	public StudentSubmit(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	/****Test Case E4-793: Student's GB - OA (Q) - Submit - St. Q. Assignment Scoring****/
	@Test
	public void E4_793() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_793",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
				
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
				
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
		
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
		
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver, AssignmentResultsPage.class);
		
		//Check the score column
		assignmentResultsPage.verifyScore(dataMap);
		
		//Check the total score value
		assignmentResultsPage.verifyTotalScore();
		
		//Check the Question Attempts column
		assignmentResultsPage.validateNoOfAttempts();
		
		//Check Question attempts
		assignmentResultsPage.QuestionAttempts(dataMap);
		
		//Check the Question Name Link 
		assignmentResultsPage.questionLinkVerify();
		
		//Check Grading Type column 
		assignmentResultsPage.verifyGradingType(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1169: Student's GB - OA (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1169() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1169",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
				
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
				
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
		
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
		
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver, AssignmentResultsPage.class);
		
		//Check the score column
		assignmentResultsPage.verifyScore(dataMap);
		
		//Check the total score value
		assignmentResultsPage.verifyTotalScore();
		
		//Check the Question Attempts column
		assignmentResultsPage.validateNoOfAttempts();
		
		//Check Question attempts
		assignmentResultsPage.QuestionAttempts(dataMap);
		
		//Check the Question Name Link 
		assignmentResultsPage.questionLinkVerify();
		
		//Check Grading Type column 
		assignmentResultsPage.verifyGradingType(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1264: Student's GB - OA (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1264() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1264",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");
				
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
				
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
		
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
		
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver, AssignmentResultsPage.class);
		
		//Check the score column
		assignmentResultsPage.verifyScore(dataMap);
		
		//Check the total score value
		assignmentResultsPage.verifyTotalScore();
		
		//Check the Question Attempts column
		assignmentResultsPage.validateNoOfAttempts();
		
		//Check Question attempts
		assignmentResultsPage.QuestionAttempts(dataMap);
		
		//Check the Question Name Link 
		assignmentResultsPage.questionLinkVerify();
		
		//Check Grading Type column 
		assignmentResultsPage.verifyGradingType(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1313: Student's GB - OA (Q) - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1313() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1313",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
				
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
				
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
		
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
		
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver, AssignmentResultsPage.class);
		
		//Check the score column
		assignmentResultsPage.verifyScore(dataMap);
		
		//Check the total score value
		assignmentResultsPage.verifyTotalScore();
		
		//Check the Question Attempts column
		assignmentResultsPage.validateNoOfAttempts();
		
		//Check Question attempts
		assignmentResultsPage.QuestionAttempts(dataMap);
		
		//Check the Question Name Link 
		assignmentResultsPage.questionLinkVerify();
		
		//Check Grading Type column 
		assignmentResultsPage.verifyGradingType(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1541: Student's GB - OA (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1541() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1541",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
				
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
				
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
		
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
		
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver, AssignmentResultsPage.class);
		
		//Check the score column
		assignmentResultsPage.verifyScore(dataMap);
		
		//Check the total score value
		assignmentResultsPage.verifyTotalScore();
		
		//Check the Question Attempts column
		assignmentResultsPage.validateNoOfAttempts();
		
		//Check Question attempts
		assignmentResultsPage.QuestionAttempts(dataMap);
		
		//Check the Question Name Link 
		assignmentResultsPage.questionLinkVerify();
		
		//Check Grading Type column 
		assignmentResultsPage.verifyGradingType(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****** Test Case E4-792: Student's GB - AA - Submit - St. Q Assignment Scoring *******/
	@Test
	public void E4_792() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	

	/****Test Case E4-835: Student's GB - AA - Submit - Sp. Q Assignment Scoring****/
	@Test
	public void E4_835() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	
	
	/****Test Case E4-1168: Student's GB - AA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1168() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	

	/****Test Case E4-1263: Student's GB - AA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1263() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");
				
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	

	/****Test Case E4-1312: Student's GB - AA - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1312() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	

	/****Test Case E4-1540: Student's GB - AA - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1540() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1594: Student's GB - AA - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1594() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1820: Student's GB - AA - Submit - Ungraded Assignment Scoring****/
	//pending
	@Test
	public void E4_1820() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-794: Student's GB - OI (Q) - Submit - St. Q. Assignment Scoring****/
	@Test
	public void E4_794() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	
	}

	/****Test Case E4-1170: Student's GB - OI (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1170() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	
	}
	
	/****Test Case E4-1265: Student's GB - OI (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1265() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	
	}
	
	/****Test Case E4-1314: Student's GB - OI (Q) - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1314() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1542: Student's GB - OI (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1542() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	
	}
	
	/****Test Case E4-1596: Student's GB - OI (Q) - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1596() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1822: Student's GB - OI (Q) - Submit - Ungraded Assignment Scoring****/
	@Test
	public void E4_1822() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentA", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1255: Student's AP - Submit - Question Pool Assignment Scoring****/
	//pending
	@Test
	public void E4_1255() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}

	/****Test Case E4-1187: Student's AP - Submit - Question Pool Assignment Scoring****/
	//pending
	@Test
	public void E4_1187() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_792",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_PRECONDITION_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "Password");
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
}
