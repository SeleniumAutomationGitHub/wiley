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

public class InstructorEditOneStudent {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EditOneStudPreCondition",dataProviderClass=staticProviderClass.class)
	public InstructorEditOneStudent(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void instructorEditOneStudentPrerequsite() throws Exception{
		ResultUtil.createReport("GradeBookInstructorEditOneStudent-GBInstructorEditOneStudentPrerequsite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
						
		//Object for HomePage
		HomePage home=PageFactory.initElements(driver, HomePage.class);
				
		//Login
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		//Goto Instructor GradeBook
		driver=courseHomePage.goToGradebookPage().getDriver();    
	}
		
			
 	/******Test Case E4-932: GB - ASOI (Q) - Edit - St. Q. Assignment Scoring*******/
	@Test
	public void E4_932() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
 	
	/***Test Case E4-1004: GB - ASOI (Q) - Edit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_1004() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/***Test Case E4-1183: GB - ASOI (Q) - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1183() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	

	/***Test Case E4-1327: GB - ASOI (Q) - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1327() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/***Test Case E4-1508: GB - ASOI (Q) - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1508() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1609: GB - ASOI (Q) - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1609() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntEditName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
		
	/******Test Case E4-931: GB - ASOA (Q) - Edit - St. Q. Assignment Scoring*******/
	@Test
	public void E4_931() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
		
	/******Test Case E4-941: GB - ASOA (Q) - Edit - St. Q. Assignment Scoring*******/
	@Test
	public void E4_941() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}	
	
	/***Test Case E4-1003: GB - ASOA (Q) - Edit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_1003() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1182: GB - ASOA (Q) - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1182() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1326: GB - ASOA (Q) - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1326() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1507: GB - ASOA (Q) - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1507() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1608: GB - ASOA (Q) - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1608() throws Exception{
			
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntEditID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntEditID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "AsgntEditID1");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/******Test Case E4-930 --------- GB - ASAA - Edit - St. Q Assignment Scoring*******/
	@Test
	public void E4_930() throws Exception{
							
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
	
	/****Test Case E4-1002: GB - ASAA - Edit - Sp. Q Assignment Scoring***/
	@Test
	public void E4_1002() throws Exception{
					
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
	
	/***Test Case E4-1181: GB - ASAA - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1181() throws Exception{
					
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
	
	/***Test Case E4-1325: GB - ASAA - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1325() throws Exception{
					
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
	
	/***Test Case E4-1506: GB - ASAA - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1506() throws Exception{
					
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
	
	/***Test Case E4-1607: GB - ASAA - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1607() throws Exception{
					
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
	
	/***Test Case E4-846: GB - OSOA (Q) - Edit - Sp. Q. Assignment Scoring***/
	@Test
	public void E4_846() throws Exception{
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1185: GB - OSOA (Q) - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1185() throws Exception{
				
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1329: GB - OSOA (Q) - Edit - Manually Graded Assignment Scoring - Student A***/
	@Test
	public void E4_1329() throws Exception{
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1440: GB - OSOA (Q) - Edit - Manually Graded Assignment Scoring - Student B***/
	@Test
	public void E4_1440() throws Exception{
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1441: GB - OSOA (Q) - Edit - Manually Graded Assignment Scoring - Student C***/
	@Test
	public void E4_1441() throws Exception{
		
		CourseHomePage courseHomePage=PageFactory.initElements(driver,CourseHomePage.class );
		
		//Goto GradebookPage
		GradeBookPage gradeBookPage=courseHomePage.goToGradebookPage();
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameC");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1510: GB - OSOA (Q) - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1510() throws Exception{
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1611: GB - OSOA (Q) - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1611() throws Exception{
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
	
	/***Test Case E4-1319: GB - OSOA (Q) - Submit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1319() throws Exception{
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
		gradeBookPage.clickGradeBookBreadCrumb();
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

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
												
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-812: GB - OSAA - Edit - St. Q Assignment Scoring***/
	@Test
	public void E4_812() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
		
	/***Test Case E4-845: GB - OSAA - Edit - St. Q Assignment Scoring***/
	@Test
	public void E4_845() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1184: GB - OSAA - Edit - Question Pool Assignment Scoring***/
	@Test
	public void E4_1184() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1328: GB - OSAA - Edit - Manually Graded Assignment Scoring***/
	@Test
	public void E4_1328() throws Exception{
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassSelectorCombo");
		
		//click Go button
		gradeBookPage.clickGoButton();
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		//Student B
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameC");
		
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
		 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/***Test Case E4-1509: GB - OSAA - Edit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1509() throws Exception{
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
											
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = courseHomePage.goToGradebookPage();		
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1610: GB - OSAA - Edit - Complex Assignments Scoring***/
	@Test
	public void E4_1610() throws Exception{
					
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassSelectorCombo");
		
		//click Go button
		gradeBookPage.clickGoButton();
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		//Student B
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameB");
		
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntEditName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
		 				
 		driver=gradeBookPage.getDriver();
	}	
		
	/******Test Case E4-814: GB - OSOI (Q) - Edit - St. Q. Assignment Scoring*******/
	@Test
	public void E4_814() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntEditName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
}
