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

public class InstructorSubmit {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SubmitPrecondition",dataProviderClass=staticProviderClass.class)
	public InstructorSubmit(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void instructorSubmitPrerequsite() throws Exception{
		ResultUtil.createReport("GradeBookInstructor-instructorSubmitPrerequsite", dataMap);
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
		
		//Goto GradebookPage
		driver=courseHomePage.goToGradebookPage().getDriver();
	}
			
	/***Test Case E4-914: GB - ASOA (Q) - Submit - St. Q. Assignment Scoring***/
	@Test
	public void E4_914() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-1544: GB - ASOA (Q) - Submit - Instructor Created Questions Assignment Scoring***/
	@Test
	public void E4_1544() throws Exception{
		
		//GoTo GradeBook page
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
	   	
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
				
		//Check Score 
		gradeBookPage.verifyScoreAssignmentID(dataMap, "AsgntSubmitID1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check total Score
		gradeBookPage.verifyTotalScoreAssignmentId(dataMap, "StudentNameA");
		
		//Check Name Question Name Link Whether Active or Inactive
		gradeBookPage.questionLinkVerifyAssignmentId();
		
		//Goto GradeBookPage
		gradeBookPage.clickGradeBookBreadCrumb();
		
		driver=gradeBookPage.getDriver();
	}
	
	/***Test Case E4-915: GB - ASOI (Q) - Submit - St. Q. Assignment Scoring***/
	@Test
	public void E4_915() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-1173: GB - ASOI (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1173() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1268: GB - ASOI (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1268() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1317: GB - ASOI (Q) - Submit - Manually Graded Assignment Scoring*****/
	@Test
	public void E4_1317() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1545: GB - ASOI (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1545() throws Exception{
						
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class);    		
 		
 		//Select one student 
 	    gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
 	   
 	    //Click Go Button
 		gradeBookPage.clickGoButton();
				
 		//Click Assignment ID Link
 		gradeBookPage.clickAssignmentId(dataMap,"AsgntSubmitID1");
 		 		 			
 		//Click Question Link
 		gradeBookPage.ClickQuestionLinkAssignmentId();
 		
 		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}

	 /*******Test Case E4-801: GB - OSAA - Submit - St. Q Assignment Scoring @throws Exception *******/
	@Test
	public void E4_801() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-838: GB - OSAA - Submit - Sp. Q Assignment Scoring****/
	@Test
	public void E4_838() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1174: GB - OSAA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1174() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
							
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1269: GB - OSAA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1269() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1318: GB - OSAA - Submit - Manually Graded Assignment Scoring****/
	@Test
	public void E4_1318() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
		
		//Click Student C Name Link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameB");
		
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Click GradeBook BreadCrumb
		gradeBookPage.clickGradeBookBreadCrumb();
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1546: GB - OSAA - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1546() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}
	
	/****Test Case E4-1600: GB - OSAA - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1600() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}

	/****Test Case E4-1826: GB - OSAA - Submit - Ungraded Assignment Scoring****/
	@Test
	public void E4_1826() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();   	
							
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Check Progress Value
		gradeBookPage.verifyAssignmentStudentsResult(dataMap, "AsgntSubmitName1", "TotalPointsEarned1", "TotalMaxScore1");
		
		//Check Total Raw Score and Total Score
		gradeBookPage.verifyTotalRawScore(dataMap);
						
		driver=gradeBookPage.getDriver();
	}

	/****** Test Case E4-913: GB - ASAA - Submit - St. Q Assignment Scoring   @throws Exception *****/
	@Test
	public void E4_913() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
	
		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
															
		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-971: GB - ASAA - Submit - Sp. Q Assignment Scoring****/
	@Test
	public void E4_971() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
	
		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-1171: GB - ASAA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1171() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");
			
		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();
	}	

	/****Test Case E4-1266: GB - ASAA - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1266() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
 	    gradeBookPage.selectAssignmentList(dataMap, "AsgntSubmitName1");

		//Click Go Button
		gradeBookPage.clickGoButton();
				
		//Verify the Score values for Assignment
		gradeBookPage.validateScoreValuesForAsgnments(dataMap,"StudentNameA");
		
		//validate the average score of class
		gradeBookPage.validateClassAverage();
													
		driver=gradeBookPage.getDriver();
	}	
	
	/****Test Case E4-1543: GB - ASAA - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1543() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
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
	
	/****Test Case E4-1597: GB - ASAA - Submit - Complex Assignments Scoring****/
	@Test
	public void E4_1597() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
				 
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
	
	/****Test Case E4-803: GB - OSOA (Q) - Submit - St. Q. Assignment Scoring****/
	@Test
	public void E4_803() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitName1");

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
	
	/****Test Case E4-1175: GB - OSOA (Q) - Submit - Question Pool Assignment Scoring****/
	@Test
	public void E4_1175() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
						
		//Click Go Button
		gradeBookPage.clickGoButton();
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitName1");
		
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
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitName1");
		
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

	/****Test Case E4-1547: GB - OSOA (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	@Test
	public void E4_1547() throws Exception{
		
		GradeBookPage gradeBookPage = PageFactory.initElements(driver, GradeBookPage.class);
		
		//Select Class from Combo Box
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
				
		//Click Go Button
		gradeBookPage.clickGoButton();
			
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitName1");

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
	
	/****Test Case E4-804: GB - OSOI (Q) - Submit - St. Q. Assignment Scoring****/
	//pending
	@Test
	public void E4_804() throws Exception{
							
		//GoTo GradeBook page
		GradeBookPage gradeBookPage =  PageFactory.initElements(driver, GradeBookPage.class); 
				
		//Select one student 
		gradeBookPage.assignOneAssignmentToAllStudents(dataMap,"ClassStudentName");
		
		//click Go button
		gradeBookPage.clickGoButton();    
						
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap,"StudentNameA");
				
		//Click Assignment Name Link
		gradeBookPage.clickAssignmentLink(dataMap,"AsgntSubmitName1");

		//Click Question Link
		gradeBookPage.clickAllQuestionLink();
		
		//Goto GradeBookPage
 		gradeBookPage.clickGradeBookBreadCrumb();
 				
 		driver=gradeBookPage.getDriver();
	}
			
	/****Test Case E4-1271: GB - OSOI (Q) - Submit - Question Pool Assignment Scoring****/
	//pending
	/****Test Case E4-1320: GB - OSOI (Q) - Submit - Manually Graded Assignment Scoring****/
	//pending
	/****Test Case E4-1548: GB - OSOI (Q) - Submit - Instructor Created Questions Assignment Scoring****/
	//pending
	/****Test Case E4-1602: GB - OSOI (Q) - Submit - Complex Assignments Scoring****/
	//pending
}
