package Scripts.GradeBook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.GradeBookPage;
import Pages.Common.HomePage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class InstructorEditAllStudent {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EditALLStudPreCondition",dataProviderClass=staticProviderClass.class)
	public InstructorEditAllStudent(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void instructorEditAllStudentPrerequsite() throws Exception{
		ResultUtil.createReport("GradeBookInstructor-instructorEditAllStudentPrerequsite", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
				
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		//Login		
		home.login(dataMap);
		
		//Object for CourseSelectionPage
		CourseSelectionPage courseSelectionPage=PageFactory.initElements(driver, CourseSelectionPage.class);
		
		//Select Course
		CourseHomePage courseHomePage=courseSelectionPage.selectCourse(dataMap);
		
		driver=courseHomePage.goToGradebookPage().getDriver();
	}

	/******Test Case E4-942: GB - ASOI (Q) - Edit - St. Q. Assignment Scoring*******/
	@Test
	public void E4_942() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditAllName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditAllID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/***Test Case E4-939: GB - ASAA - Edit - St. Q Assignment Scoring***/
	@Test
	public void E4_939() throws Exception{
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//Click refresh Button
		gradeBookPage.clickRefreshGradeBook();
	
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();
	}	
	
	/******Test Case E4-873: GB - OSOA (Q) - Edit - St. Q. Assignment Scoring*****/
	@Test
	public void E4_873() throws Exception{
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditAllName1");

		//Verify the Score Column
		gradeBookPage.verifyScore(dataMap);
		
		//Verify Total Score Column
		gradeBookPage.verifyTotalScore();
								
		//Check Question Name link 
		gradeBookPage.questionLinkVerify();
		
		//Check Grading type Column
		gradeBookPage.verifyGradingType(dataMap);
		
		//Validate No of attempts
		gradeBookPage.validateNoOfAttempts();
		
		//Validate Select question & validate
		gradeBookPage.selectQuestionsAndValidate(dataMap);
				
		//Click GradeBook from the BreadCrumb
		gradeBookPage.clickGradeBookBreadCrumb();
		
		//Student B
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameB");
		
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditAllName1");

		//Verify the Score Column
		gradeBookPage.verifyScore(dataMap);
		
		//Verify Total Score Column
		gradeBookPage.verifyTotalScore();
								
		//Check Question Name link 
		gradeBookPage.questionLinkVerify();
		
		//Check Grading type Column
		gradeBookPage.verifyGradingType(dataMap);
		
		//Validate No of attempts
		gradeBookPage.validateNoOfAttempts();
		
		//Validate Select question & validate
		gradeBookPage.selectQuestionsAndValidate(dataMap);
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/******Test Case E4-872: GB - OSAA - Edit - St. Q Assignment Scoring***/
	@Test
	public void E4_872() throws Exception{
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassSelectorCombo");
		
		//click Go button
		gradeBookPage.clickGoButton();
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditAllName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		//Student c
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameC");
		
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditAllName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
				 				
 		driver=gradeBookPage.getDriver();
	}	
}
