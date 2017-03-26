package Scripts.GradeBook;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.GradeBookPage;
import Pages.Common.HomePage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.GradeBookDataProviderUtil.staticProviderClass;

public class InstructorSubmitScoreEdited {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SubmitScoreEditedPreCondition",dataProviderClass=staticProviderClass.class)
	public InstructorSubmitScoreEdited(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void instructorSubmitScoreEditedPrerequsite() throws Exception{
		ResultUtil.createReport("GradeBookInstructorVerification-instructorSubmitScoreEditedPrerequsite", dataMap);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".SPECIFIC_QUESTION_URL");
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Object for Home Page
		HomePage homePage=PageFactory.initElements(driver,HomePage.class);
		homePage.specificInstructorLogin(dataMap);
		driver=homePage.getDriver();
	}

	/******Test Case E4-951: GB - ASOA (Q) - Submit (Score was edited) - St. Q. Assignment Scoring@throws Exception *******/
	@Test
	public void E4_951() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
	
	/******Test Case E4-1048: GB - ASOA (Q) - Submit - Sp. Q. Assignment Scoring*****/
	@Test
	public void E4_1048() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
	
	/*****Test Case E4-1192: GB - ASOA (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1192() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	

	/*****Test Case E4-1336: GB - ASOA (Q) - Submit - Manually Graded Assignment Scoring****/
	//score was not edited it should in tograde mode
	@Test
	public void E4_1336() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	

	/*****Test Case E4-1517: GB - ASOA (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1517() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-1628: GB - ASOA (Q) - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1628() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1598: GB - ASOA (Q) - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1598() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitScoreEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
	
	/*****Test Case E4-973: GB - ASOI (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_973() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1599: GB - ASOI (Q) - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1599() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-952: GB - ASOI (Q) - Submit (Score was edited) - St. Q. Assignment Scoring****/
	@Test
	public void E4_952() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-1049: GB - ASOI (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_1049() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1193: GB - ASOI (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1193() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1337: GB - ASOI (Q) - Submit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1337() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1518: GB - ASOI (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1518() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1629: GB - ASOI (Q) - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1629() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitScoreEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-890: GB - OSAA - Submit (Score was edited) - St. Q Assignment Scoring****/
	@Test
	public void E4_890() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1050: GB - OSAA - Submit - Sp. Q Assignment Scoring****/
	@Test
	public void E4_1050() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1194: GB - OSAA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1194() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1338: GB - OSAA - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1338() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");

		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1519: GB - OSAA - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1519() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
		
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}

	/****Test Case E4-1630: GB - OSAA - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1630() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
	
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitScoreEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1315: GB - ASAA - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1315() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//select assignment
		gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitScoreEditName1");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValues(dataMap, "StudentNameA");
		
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValues(dataMap, "StudentNameB");

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValues(dataMap, "StudentNameC");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-950: GB - ASAA - Submit (Score was edited) - St. Q Assignment Scoring****/
	@Test
	public void E4_950() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-1047: GB - ASAA - Submit - Sp. Q Assignment Scoring****/
	@Test
	public void E4_1047() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-1191: GB - ASAA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1191() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-1335: GB - ASAA - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1335() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValues(dataMap, "StudentNameB");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-1516: GB - ASAA - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1516() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValues(dataMap, "StudentNameB");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-1627: GB - ASAA - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1627() throws Exception{

		//Object for CourseHomePage
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//Click Go Button
		gradeBookPage.clickGoButton();

		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValues(dataMap, "StudentNameB");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();

	}
	
	/****Test Case E4-839: GB - OSOA (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_839() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-1601: GB - OSOA (Q) - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1601() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-891: GB - OSOA (Q) - Submit (Score was edited) - St. Q. Assignment Scoring****/
	@Test
	public void E4_891() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}

	/****Test Case E4-1051: GB - OSOA (Q) - Submit - Sp. Q. Assignment Scoring****/
	@Test
	public void E4_1051() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}

	/****Test Case E4-1195: GB - OSOA (Q) - Submit - Question Pool Assignment Scoring****/
	//pending
	@Test
	public void E4_1195() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
						
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");
		
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
		
		//Click GradeBook link from the BreadCrumb
		gradeBookPage.clickGradeBookBreadCrumb();
		
		//Click Student B Name
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameB");
		
		//Click assignment link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");
		
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
		
		//Goto HomePage
		gradeBookPage.goToHome();
										
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1339: GB - OSOA (Q) - Submit - Manually Graded Assignment Scoring****/
	//pending
	@Test
	public void E4_1339() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1520: GB - OSOA (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1520() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1270: GB - OSOA (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1270() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
						
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameB");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");
		
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
		
		//Click GradeBook link from the BreadCrumb
		gradeBookPage.clickGradeBookBreadCrumb();
		
		//Click Student B Name
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
		
		//Click assignment link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");
		
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
		
		//Goto HomePage
		gradeBookPage.goToHome();
										
		driver=gradeBookPage.getDriver();
	}

	/****Test Case E4-1631: GB - OSOA (Q) - Submit - Complex Assignments Scoring****/
	//pending
	@Test
	public void E4_1631() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

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
		
		//Goto HomePage
		gradeBookPage.goToHome();
												
		driver=gradeBookPage.getDriver();
	}
		
	/****Test Case E4-892: GB - OSOI (Q) - Submit (Score was edited) - St. Q. Assignment Scoring****/
	@Test
	public void E4_892() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-840: GB - OSOI (Q) - Submit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_840() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
		
	/****Test Case E4-1052: GB - OSOI (Q) - Submit - Sp. Q. Assignment Scoring****/
	//pending
	@Test
	public void E4_1052() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
		
	/****Test Case E4-1196: GB - OSOI (Q) - Submit - Question Pool Assignment Scoring****/
	//pending
	@Test
	public void E4_1196() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
		
	/****Test Case E4-1340: GB - OSOI (Q) - Submit - Manually Graded Assignment Scoring****/
	//pending
	@Test
	public void E4_1340() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 		
 		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameB");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitScoreEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
 				
 		driver=gradeBookPage.getDriver();
	}
		
	/****Test Case E4-1521: GB - OSOI (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	//pending
	
	/****Test Case E4-1632: GB - OSOI (Q) - Submit - Complex Assignments Scoring****/
	//pending
}
