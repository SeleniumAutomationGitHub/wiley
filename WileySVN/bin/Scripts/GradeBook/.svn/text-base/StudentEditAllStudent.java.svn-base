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

public class StudentEditAllStudent {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EditALLStudPreCondition",dataProviderClass=staticProviderClass.class)
	public StudentEditAllStudent(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}

	/***Test Case E4-869: Student's GB - AA - Edit - St. Q Assignment Scoring***/
	@Test
	public void E4_869() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
										
		//verify First Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditAllName1","TotalPointsEarned1","TotalMaxScore1");
		        		
		//verify Second Assignment Results
		studentGradeBookPage.verifyAssignmentStudentsResult(dataMap,"AsgntEditAllName2","TotalPointsEarned2","TotalMaxScore2");
		
		//Check the total raw score value
		studentGradeBookPage.verifyTotalRawScore();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-871: Student's GB - OI (Q) - Edit - St. Q. Assignment Scoring***/
	@Test
	public void E4_871() throws Exception{
					
		//Object for StudentHome page
		StudentHomepage studentHomePage=PageFactory.initElements(driver,StudentHomepage.class);
		
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();	
				 
		//Click Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditAllName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
	
	/***Test Case E4-868: Student's AP - Edit - St. Q. Assignment Scoring***/
	@Test
	public void E4_868() throws Exception{
		ResultUtil.createReport("StudentsGBAssignmentScoring - E4_868",dataMap);
		
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
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntEditAllName1");
				
		//Object For Class AssignmentResultsPage
		AssignmentResultsPage assignmentResultsPage=PageFactory.initElements(driver,AssignmentResultsPage.class);
		
		//verify points Earned score, Maximum Point Potential Score
		assignmentResultsPage.selectQuestionsAndValidate(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();
	}
}
