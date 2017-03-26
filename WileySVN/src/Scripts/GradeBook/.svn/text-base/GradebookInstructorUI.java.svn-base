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
import Pages.GradeBook.GradeBookStudyObjectivePage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class GradebookInstructorUI {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="GradeBookInstructors",dataProviderClass=staticProviderClass.class)
	public GradebookInstructorUI(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void GradebookInstructorUIPrerequsite() throws Exception{
		ResultUtil.createReport("GradeBookInstructor-studentGradeBookPrerequsite", dataMap);
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
		
	/****** Test Case E4-437: All Students - Total Diagnostic Results *******/
	@Test
	public void E4_437() throws Exception{
				
		//Select Course
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		
		//Navigate to Study Objectives page
		GradeBookStudyObjectivePage gradeBookStudyObjectivePage=gradeBookPage.clickStudyObjectivesPage();
						
		//Verify the Find Student TextBox
		gradeBookStudyObjectivePage.verifyFindStudentTextBox();
		 
		//Verify the Class Drop Down
		gradeBookStudyObjectivePage.verifyClassDropDown();
		 
		//Select Summary by class section
		gradeBookStudyObjectivePage.summaryByClassSection(dataMap, "ClassSelectorCombo");
		
		//Click Go Button
		gradeBookPage.clickGoButton(); 
		
		//validateAllStudentTotalDiagnostic
		gradeBookPage.validateAllStudentTotalDiagnostic();
		
		//Goto HomePage
		gradeBookPage.goToHome();
		
		driver=gradeBookPage.getDriver();
	}	
		
	/****** Test Case E4-442: All Students - Study Objectives *******/
	@Test
	public void E4_442() throws Exception{
					
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		
		//Navigate to Study Objectives page
		GradeBookStudyObjectivePage gradeBookStudyObjectivePage=gradeBookPage.clickStudyObjectivesPage();
			
		//Select Class Section 
		gradeBookStudyObjectivePage.selectClassFromComboStudyObjective(dataMap, "StudyObjectiveClassName");
		 
		//Select Chapter From Drop Down
		gradeBookStudyObjectivePage.selectChapterDropDown(dataMap,"StudyobjectiveChapter");
		 
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//validateAllStudentAllStudyObjective
		gradeBookPage.validateAllStudentAllStudyObjective();
		
		//Goto HomePage
		gradeBookPage.goToHome();
		
		driver=gradeBookPage.getDriver();
	}	
	
	/****** Test Case E4-443: One Student - Study Objectives*******/
	@Test
	public void E4_443() throws Exception{
						
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		
		//Navigate to Study Objectives page
		GradeBookStudyObjectivePage gradeBookStudyObjectivePage=gradeBookPage.clickStudyObjectivesPage();
				
		//Select Class Section 
		gradeBookStudyObjectivePage.selectClassFromComboStudyObjective(dataMap, "StudyObjectiveClassName");
		 
		//Select Chapter From Drop Down
		gradeBookStudyObjectivePage.selectChapterDropDown(dataMap,"StudyobjectiveChapter");
		 
		//Click Go Button
		gradeBookPage.clickGoButton();	
	
		//Click Student Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudyObjectiveStudentNameLink");
		 
		//Click Study Objective Link
		gradeBookStudyObjectivePage.clickStudyObjectivesLink(dataMap);
		 
		//Click Question Link
		gradeBookStudyObjectivePage.clickQuestionLink(dataMap);
		
		//validateOneStudentOneItem
		gradeBookPage.validateOneStudentOneItem();
		
		//Goto HomePage
		gradeBookPage.goToHome();
		
		driver=gradeBookStudyObjectivePage.getDriver();
	}
	
	/***Test Case E4-447: All Students - Questions for Study Objective***/
	@Test
	public void E4_447() throws Exception{
		
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
		
		// Navigate to Study Objectives page
		GradeBookStudyObjectivePage gradeBookStudyObjectivePage=gradeBookPage.clickStudyObjectivesPage();
		
		//Select Class Section 
		gradeBookStudyObjectivePage.selectClassFromComboStudyObjective(dataMap, "StudyObjectiveClassName");
		 
		//Select Chapter From Drop Down
		gradeBookStudyObjectivePage.selectChapterDropDown(dataMap,"StudyobjectiveChapter");
		 
		//Click Go Button
		gradeBookPage.clickGoButton();	
			
		//Click Study Objective ID
		gradeBookStudyObjectivePage.clickStudyObjectiveID(dataMap);
				
		//Click Question link from Assignment Id
		gradeBookStudyObjectivePage.clickQuestionLinkObjectiveID(dataMap);
		
		//validateOneStudentOneItem
		gradeBookPage.validateOneStudentOneItem();
		
		//Goto HomePage
		gradeBookPage.goToHome();
		
		driver=gradeBookStudyObjectivePage.getDriver();
	}	
}
