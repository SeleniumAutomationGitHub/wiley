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

public class StudentSubmitScoreEdited {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SubmitScoreEditedPreCondition",dataProviderClass=staticProviderClass.class)
	public StudentSubmitScoreEdited(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	/****Test Case E4-836: Student's GB - OA (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_836() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_836",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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
	
	/****Test Case E4-1595: Student's GB - OA (Q) - Submit - Complex Assignments Scoring****/
	//pending
	@Test
	public void E4_1595() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1595",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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

	/****Test Case E4-1821: Student's GB - OA (Q) - Submit - Ungraded Assignment Scoring****/
	//pending
	@Test
	public void E4_1821() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1821",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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
	
	/****Test Case E4-837: Student's GB - OI (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_837() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-886: Student's AP - Submit (Score was edited) - St. Q. Assignment Scoring****/
	//pending
	@Test
	public void E4_886() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-1043: Student's AP - Submit - Sp. Q. Assignment Scoring****/
	//pending
	@Test
	public void E4_1043() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1512: Student's AP - Submit - Instructor Created Questions Assignment Scoring****/
	//pending
	@Test
	public void E4_1512() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1623: Student's AP - Submit - Complex Assignments Scoring****/
	//pending
	@Test
	public void E4_1623() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-887: Student's GB - AA - Submit (Score was edited) - St. Q Assignment Scoring****/
	@Test
	public void E4_887() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitScoreEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	

	/****Test Case E4-1044: Student's GB - AA - Submit - Sp. Q Assignment Scoring****/
	@Test
	public void E4_1044() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitScoreEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}	

	/****Test Case E4-1188: Student's GB - AA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1188() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitScoreEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1332: Student's GB - AA - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1332() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitScoreEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}

	/****Test Case E4-1513: Student's GB - AA - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1513() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitScoreEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1624: Student's GB - AA - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1624() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntSubmitScoreEditName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-889: Student's GB - OI (Q) - Submit (Score was edited) - St. Q. Assignment Scoring****/
	@Test
	public void E4_889() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1046: Student's GB - OI (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_1046() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1190: Student's GB - OI (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1190() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1334: Student's GB - OI (Q) - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1334() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/****Test Case E4-1515: Student's GB - OI (Q) - Submit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1515() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}

	/***Test Case E4-1626: Student's GB - OI (Q) - Submit - St. Q. Assignment Scoring***/
	@Test
	public void E4_1626() throws Exception{
		
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-888: Student's GB - OA (Q) - Submit (Score was edited) - St. Q. Assignment Scoring***/
	@Test
	public void E4_888() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_888",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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
	
	/***Test Case E4-1045: Student's GB - OA (Q) - Submit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_1045() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1045",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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
	
	/****Test Case E4-1189: Student's GB - OA (Q) - Submit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1189() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1189",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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

	/***Test Case E4-1333: Student's GB - OA (Q) - Submit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1333() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1333",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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

	/***Test Case E4-1514: Student's GB - OA (Q) - Submit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1514() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1514",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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

	/***Test Case E4-1625: Student's GB - OA (Q) - Submit - Complex Assignments Scoring***/
	@Test
	public void E4_1625() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_1625",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntSubmitScoreEditName1");
		
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
}
