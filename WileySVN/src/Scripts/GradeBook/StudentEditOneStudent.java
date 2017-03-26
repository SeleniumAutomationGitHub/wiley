package Scripts.GradeBook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.Common.StudentHomepage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class StudentEditOneStudent {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EditOneStudPreCondition",dataProviderClass=staticProviderClass.class)
	public StudentEditOneStudent(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}

	/***Test Case E4-810: Student's GB - OA (Q) - Edit - St. Q. Assignment Scoring***/
	@Test
	public void E4_810() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_810",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
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
	
	/***Test Case E4-843: Student's GB - OA (Q) - Edit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_843() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_843",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
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
	
	/***Test Case E4-1179: Student's GB - OA (Q) - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1179() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1179",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
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
	
	/***Test Case E4-1323: Student's GB - OA (Q) - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1323() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1323",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
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
	
	/***Test Case E4-1504: Student's GB - OA (Q) - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1504() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1504",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
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
	
	/****Test Case E4-1605: Student's GB - OA (Q) - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1605() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1605",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
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
	
	/***Test Case E4-809: Student's GB - AA - Edit - St. Q Assignment Scoring***/
	@Test
	public void E4_809() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-842: Student's GB - AA - Edit - Sp. Q Assignment Scoring***/
	@Test
	public void E4_842() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1178: Student's GB - AA - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1178() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1322: Student's GB - AA - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1322() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1503: Student's GB - AA - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1503() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1604: Student's GB - AA - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1604() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-811: Student's GB - OI (Q) - Edit - St. Q. Assignment Scoring***/
	@Test
	public void E4_811() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-844: Student's GB - OI (Q) - Edit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_844() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1180: Student's GB - OI (Q) - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1180() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1324: Student's GB - OI (Q) - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1324() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1505: Student's GB - OI (Q) - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1505() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1606: Student's GB - OI (Q) - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1606() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Logout Object
		LogoutSessionPage logoutSessionPage=PageFactory.initElements(driver, LogoutSessionPage.class);
				
		//Logout
		logoutSessionPage.logOutSession();
			
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login
		home.studentLogin(dataMap, "StudentB", "PasswordB");
						
		//Go To Student GradeBook Page 
		studentHomePage.goToGradeBook();
		
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
	}
	
	/***Test Case E4-808: Student's AP - Edit - St. Q. Assignment Scoring***/
	@Test
	public void E4_808() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_808",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}

	/***Test Case E4-841: Student's AP - Edit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_841() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_841",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1502: Student's AP - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1502() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1502",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1603: Student's AP - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1603() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1603",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
}
