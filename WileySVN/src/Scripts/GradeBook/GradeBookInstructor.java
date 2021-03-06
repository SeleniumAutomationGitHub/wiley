package Scripts.GradeBook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.GradeBookPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class GradeBookInstructor {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="GradeBookInstructors",dataProviderClass=staticProviderClass.class)
	public GradeBookInstructor(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void studentGradeBookPrerequsite() throws Exception{
		
		ResultUtil.createReport("GradeBookInstructor-E4_394", dataMap);
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
		driver=courseSelectionPage.selectCourse(dataMap).getDriver();
	}
			
	/******Test Case E4-394: All Students - All Assignments *******/
	@Test
	public void E4_394() throws Exception{
		
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		 
		//Verify Find Student TextBox
		gradeBookPage.verifyFindStudentTextBox();
		 
		//Verify Class DropDown List Box
		gradeBookPage.verifyClassDropDown();
		 
		//Verify Activities Type
		gradeBookPage.verifyActivitiesDropDown();
		 
		//Select One class From Class Section
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click go button
		gradeBookPage.clickGoButton();
		
		//Validate AllStudentAllAssignment
		gradeBookPage.validateAllStudentAllAssignment();
			
		driver=gradeBookPage.getDriver();
	}
		  
	/****** Test Case E4-397: All Students - One Assignment *******/
	@Test
	public void E4_397() throws Exception{
						
		//Select Course
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
			 
		//Go to GradeBook
		GradeBookPage gradeBookPage =courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Click any assignment's ID link in the header of the table 
		gradeBookPage.clickAssignmentId(dataMap,"AssignmentId");
		
		//validateAllStudentOneAssignment
		gradeBookPage.validateAllStudentOneAssignment();
		
		//Goto HomePage
		gradeBookPage.goToHome();
		
		driver=gradeBookPage.getDriver();
	}
		
	/****** Test Case E4-396: One Student - All Assignments *******/
	@Test
	public void E4_396() throws Exception{
						
		//Select Course
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		
		//Select Class Section NAme
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassSelectorCombo");
		
		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Click any Student Name link in the of the table 
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
		
		//validateOneStudentAllAssignment
		gradeBookPage.validateOneStudentAllAssignment();
	
		//Goto HomePage
		gradeBookPage.goToHome();
		
		driver=gradeBookPage.getDriver();
	}	
			
	/****** Test Case E4-408: One Student - One Assignment *******/
	@Test
	public void E4_408() throws Exception{
				
		//Object for CourseHomePage
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
			
		//Select Class Section NAme
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassSelectorCombo");
			
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click any Student Name link in the of the table 
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
	
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AssignmentName");
		
		//validateOneStudentOneAssignment
		gradeBookPage.validateOneStudentOneAssignment();
		
		//Goto HomePage
		gradeBookPage.goToHome();
				
		driver=gradeBookPage.getDriver();
	}	
		
	/****** Test Case E4-409: One Student - One Item * @throws Exception *******/ 
	@Test
	public void E4_409() throws Exception{
							
		//Select Course
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
			
		//Select Class Section NAme
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassSelectorCombo");
			
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click any Student Name link in the of the table 
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AssignmentName");
				
		//Click any Item link for one student in the of the table 
		gradeBookPage.clickByQuestionName(dataMap,"QuestionName");
		
		//validateOneStudentOneItem
		gradeBookPage.validateOneStudentOneItem();
		 
		//Goto HomePage
		gradeBookPage.goToHome();
						
		driver=gradeBookPage.getDriver();
	}
		
	/****** Test Case E4-913: GB - ASAA - Submit - St. Q Assignment Scoring   @throws Exception *****/
	@Test
	public void E4_913() throws Exception{
		
		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
			
		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameLink");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();
	}	
	
	/***Test Case E4-914: GB - ASOA (Q) - Submit - St. Q. Assignment Scoring***/
	/***Test Case E4-1544: GB - ASOA (Q) - Submit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_914() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"FirstAssignment");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "FirstAssignment", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "FirstAssignment");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/****************************TO-Do-Pending*************************************/
	/******Test Case E4-950: GB - ASAA - Submit (Score was edited) - St. Q Assignment Scoring @throws Exception *******
	@Test
	public void E4_950() throws Exception{
					
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();	
		
		//Select Class from Combo Box
	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameLink");
		
		driver=gradeBookPage.getDriver();
	}	
		
	/******Test Case E4-951: GB - ASOA (Q) - Submit (Score was edited) - St. Q. Assignment Scoring@throws Exception *******
	@Test
	public void E4_951() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"FirstAssignment");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "FirstAssignment", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "FirstAssignment");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
		
	/******Test Case E4-952: GB - ASOI (Q) - Submit (Score was edited) - St. Q. Assignment Scoring@throws Exception *******
	@Test
	public void E4_952() throws Exception{
				
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();    
		
		//Click Assignment ID Link
		gradeBookPage.clickAssignmentId(dataMap,"AssignmentId");
		
		//Click Question Link
		gradeBookPage.ClickQuestionLinkAssignmentId();	
		
		//Goto HomePage
		gradeBookPage.goToHome();
										
		driver=gradeBookPage.getDriver();
	}	*/
		
	
	 /*******Test Case E4-801: GB - OSAA - Submit - St. Q Assignment Scoring @throws Exception *******/
	@Test
	public void E4_801() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
		
		//Click GradeBook from the BreadCrumb
		gradeBookPage.clickGradeBookBreadCrumb();
				
		driver=gradeBookPage.getDriver();
	}	
	/*******TO-DO- Pending*************************************************/	
	/******Test Case E4-891: GB - OSOA (Q) - Submit (Score was edited) - St. Q. Assignment Scoring @throws Exception *******
	@Test()
	public void E4_891() throws Exception{
				
		//Object for CourseHomePage
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();	
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AssignmentName");

		//Verify the Score Column
		gradeBookPage.verifyScore();
		
		//Verify Total Score Column
		gradeBookPage.verifyTotalScore();
		
		//Check All Question Attempt column
		gradeBookPage.verifyAllQuestionAttempts();
				
		//Check Question Name link 
		gradeBookPage.questionLinkVerify();
		
		//Check Grading type Column
		gradeBookPage.verifyGradingType();
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}	
		
	/******Test Case E4-892: GB - OSOI (Q) - Submit (Score was edited) - St. Q. Assignment Scoring@throws Exception *******
	@Test
	public void E4_892() throws Exception{		
				
		//Object for CourseHomePage
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();	
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();	
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameLink");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AssignmentName");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto HomePage
		gradeBookPage.goToHome();
														
		driver=gradeBookPage.getDriver();
	}*/
}
