package Scripts.GradeBook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.HomePage;
import Pages.Common.StudentHomepage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.GradeBookStudyObjectivePage;
import Pages.GradeBook.StudentGradeBookPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class GradebookStudentUI {
		
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="GradeBookStudent",dataProviderClass=staticProviderClass.class)
	public GradebookStudentUI(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void gradebookStudentUIPrerequsite() throws Exception{
		ResultUtil.createReport("GradebookStudentAssignment-gradeBookStudentAssignmentPrerequsite", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".STUDENT_EDUGEN_URL");
			
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
				
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
			
		//Login
		driver=home.studentLogin(dataMap,"StudentUsername","Password").getDriver();
	}
		
	/****** Test Case E4-410: Accessibility of Student's Gradebook Tool *******/
	@Test
	public void E4_410() throws Exception{
				
		//Object for Student Home Page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
						
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
				
		//ValidateGradeBookTab
		studentGradeBookPage.ValidateGradeBookTab();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	/****** Test Case E4-411: One Assignment representation *******/
	@Test
	public void E4_411() throws Exception{
		
		//Object for Student Home Page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
						
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
			
		// Get the Assignment Result Page
		AssignmentResultsPage assignmentResultsPage =studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntName");
		
		//validateOneAssignment
		assignmentResultsPage.validateOneAssignment();
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
		
	/****** Test Case E4-412: One Item representation*******/
	@Test
	public void E4_412() throws Exception{
		
		//Object for Student Home Page	
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
						
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
						
		// Get the Assignment Result Page
		AssignmentResultsPage assignmentResultsPage = studentGradeBookPage.selectAssignmentGradeBook(dataMap, "AsgntName");	
			
		// Show the result for one Question
		assignmentResultsPage.getQuestionResult(dataMap);
		
		//validateOneStudentOneItem
		assignmentResultsPage.validateOneStudentOneItem();
		
		//Goto HomePage
		studentHomePage.goToHome();
				
		driver=studentHomePage.getDriver();	
	}	
	
	/****** Test Case E4-448: All Study Objectives representation *******/
	@Test
	public void E4_448() throws Exception{
		
		//Object for Student Home Page
		StudentHomepage studentHomePage=PageFactory.initElements(driver, StudentHomepage.class);
			
		//Go To Student GradeBook Page 
		StudentGradeBookPage studentGradeBookPage=studentHomePage.goToGradeBook();
				
		// Navigate to Study Objectives page
		GradeBookStudyObjectivePage gradeBookStudyObjectivePage= studentGradeBookPage.clickStudyObjectivesPage();
		
		//Click any Study Objectives link 
		gradeBookStudyObjectivePage.clickStudyObjectivesLink(dataMap);
				
		//Click any Question link 
		gradeBookStudyObjectivePage.clickStudyObjectivesQuestionLink(dataMap);
	
		//validateQuestionModalwindow
		gradeBookStudyObjectivePage.validateQuestionModalwindow(dataMap);
		
		//Goto HomePage
		studentHomePage.goToHome();
		
		driver=studentHomePage.getDriver();
	}
	
	
}
