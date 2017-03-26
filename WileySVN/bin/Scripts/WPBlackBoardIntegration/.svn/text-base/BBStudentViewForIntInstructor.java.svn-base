//1.5.9. Test Suite : WP-BB Int - "Student View" button for integrated instructors
//remaining tc's are in other suite

package Scripts.WPBlackBoardIntegration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.LMSIntegration.InstructorPage;
import Pages.MapleGraph.MapleGraphPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

public class BBStudentViewForIntInstructor {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public BBStudentViewForIntInstructor(Map<String,String> dataMap)
	{

		this.dataMap=dataMap;

	}
	public void BBStudentViewForIntInstructorPrerequiste() throws Exception{


		ResultUtil.createReport("WPBlackBoardIntegration-BBStudentViewForIntInstructor", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		//Login
		BlackBoardIntegrationPage Login =PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage =Login.BBInstructorLogin(dataMap);

		//Navigate to instructor page
		driver=blackBoardIntegrationPage.getDriver();
	}

	/************************Test Case E4-289: WP-BB Int - Student View - WP Assignments***********************************************/
	@Test
	public void E4_289() throws Exception{

		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//select kunals course for testing
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		//click on wp assignments
		blackBoardIntegrationPage.wPAssignments();

		//verify the student view button
		blackBoardIntegrationPage.verifystudentView();

		//click on student view button
		blackBoardIntegrationPage.studentView();

		//click on go
		blackBoardIntegrationPage.clickGo();

		//verify the instructor vierw
		blackBoardIntegrationPage.verifyinstructorView();

		//click on instructor view button
		blackBoardIntegrationPage.instructorView();

		//click on student view button
		blackBoardIntegrationPage.studentView();

		//verify the black board
		blackBoardIntegrationPage.verifyBlackBoard();

		//click on treturn to black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-297: Button "Student view" in wp4-assignment. Reading assignment***********************/
	@Test
	public void E4_297() throws Exception{

		//luanch the application
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//select kunals course for testing
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		//click on wprsp
		blackBoardIntegrationPage.clickWPRSP();

		//verify the student view
		blackBoardIntegrationPage.verifystudentView();

		//click on student view
		blackBoardIntegrationPage.studentView();

		//click on go
		blackBoardIntegrationPage.clickGo();

		//click on verification of instrutior view
		blackBoardIntegrationPage.verifyinstructorView();

		//click on instructor view
		blackBoardIntegrationPage.instructorView();

		//click on student view
		blackBoardIntegrationPage.studentView();

		//verify black board
		blackBoardIntegrationPage.verifyBlackBoard();

		//return to black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-298: Button "Student view" in wp4-assignment. Question assignment***********************/
	@Test
	public void E4_298() throws Exception{

		//pre-requisite
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class); 


		//select kunals for testing from input sheet
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus content assignments
		blackBoardIntegrationPage.contentAssignments();

		//click on content tools
		blackBoardIntegrationPage.wileyPlusPractice();

		//verify the head frame student view
		blackBoardIntegrationPage.verifyheadframestudentView();  

		//click on student view in the head frame
		blackBoardIntegrationPage.headframestudentView();

		//verify the head frame instructor view
		blackBoardIntegrationPage.verifyheadframeinstructorView();

		//verify the head frame black board
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		//click on retrun buton to go into black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************to be pending************************Test Case E4-299: Button "Student view" in wp4-assignment. Mastery assignment***********************/
	/*@Test
	public void E4_299() throws Exception{

		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class); 


		//select AG test course
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//click on content assign
		blackBoardIntegrationPage.contentAssignments();

		//click on mastery assignment
		blackBoardIntegrationPage.wileyplusmasteryassign();

		blackBoardIntegrationPage.verifyheadframestudentView();  
		//click on student view in wileyp plus	
		blackBoardIntegrationPage.headframestudentView();

		blackBoardIntegrationPage.verifyheadframeinstructorView();
		//click on instructor view
		blackBoardIntegrationPage.headframeinstructorView();

		//click on student view again
		blackBoardIntegrationPage.headframestudentView();

		//black board verification
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		blackBoardIntegrationPage.returnToBlackboard();

		//click on closebrowser
		blackBoardIntegrationPage.closeBrowser();

	}
*/
	/******To be Pending************************************Test Case E4-300: Button "Student view" in wp4-assignment. Unassigned assignment***********************/
	/*@Test
	public void E4_300() throws Exception{


		//-launch the aplication from prese requisite method
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class); 

		//select ag test course 1
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//click on content assignment
		blackBoardIntegrationPage.contentAssignments();

		//click on wiley plus una ssing
		blackBoardIntegrationPage.wileyplusunassign();

		//verify the unassigned student view
		blackBoardIntegrationPage.verifyUnassignedAssignment();

		//verify the head frame student 
		blackBoardIntegrationPage.verifyheadframestudentView();

		//click on head frame student view
		blackBoardIntegrationPage.headframestudentView();

		//click on go
		blackBoardIntegrationPage.clickGo();

		//verify the head frame instructor view
		blackBoardIntegrationPage.verifyheadframeinstructorView();

		//click on the head frame with instructor view
		blackBoardIntegrationPage.headframeinstructorView();

		//verify the head frame
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		//return to the black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close borwser 
		blackBoardIntegrationPage.closeBrowser();

	}
*/
	//*****************************************//Test Case E4-301: Student view in wp4-assignment. Start-date in the future assignment***********************
	@Test
	public void E4_301() throws Exception{

		//launch the application		
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//select ag test course 1 from input sheet
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contentAssignments();

		//select date is future
		blackBoardIntegrationPage.futureAssignments();

		//verify the head frame student view
		blackBoardIntegrationPage.verifyheadframestudentView();

		//click on head frame student view
		blackBoardIntegrationPage.headframestudentView();

		//verify the head frame instructor view button
		blackBoardIntegrationPage.verifyheadframeinstructorView();

		//click on head frame instructor view
		blackBoardIntegrationPage.headframeinstructorView();

		//click on head frame student view
		blackBoardIntegrationPage.headframestudentView();

		//verify the black board
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		//return to the black board button
		blackBoardIntegrationPage.returnToBlackboard();


		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-302: Button "Student view" in wp4-assignment.Assignment in which the date has passed and no access***********************/
	@Test
	public void E4_302() throws Exception{


		//launch the application from pre-requiste method
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class); 


		//select5 ag test course 1
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//select wiley plus content assignment
		blackBoardIntegrationPage.contentAssignments();

		//select date is future
		blackBoardIntegrationPage.wileyPlusnoduedate();

		//verify the had frame student view button
		blackBoardIntegrationPage.verifyheadframestudentView();

		//head frame student view  button click
		blackBoardIntegrationPage.headframestudentView();

		//verify the head frame instructor view button
		blackBoardIntegrationPage.verifyheadframeinstructorView();

		//head frame instructor view click
		blackBoardIntegrationPage.headframeinstructorView();

		//verify the head frame black bopard 
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		//return to black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/********************to be pending**********************Test Case E4-303: Button "Student view" in wp4-assignment.Assignment in which the date has passed and read-only access***********************/
	/*@Test
	public void E4_303() throws Exception{

		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class); 

		//select ag test course 1 from input sheet 
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//select wiley plus content assignments
		blackBoardIntegrationPage.contentAssignments();

		//select date is future
		blackBoardIntegrationPage.wileyPlusnoduedate();

		//verify the head frame of student view
		blackBoardIntegrationPage.verifyheadframestudentView();

		//click  on student view button present in head frame
		blackBoardIntegrationPage.headframestudentView();

		//verify the instructor view button present in head frame
		blackBoardIntegrationPage.verifyheadframeinstructorView();

		//click on instructor view present in the head frame
		blackBoardIntegrationPage.headframeinstructorView();

		//verify the black board button present in the head frame
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		//return to black board button click
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}
*/
	/********************to be pending**********************Test Case E4-304: Button "Student view" in wp4-assignment.Assignment in which the date has passed,read with assistance***********************/
	/*@Test
	public void E4_304() throws Exception{

		//pre-requsite to luanch the application
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class); 

		//select ag test course 1  the name is mentioned in input data
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//select wiley content assignments link
		blackBoardIntegrationPage.contentAssignments();

		//select date is future
		blackBoardIntegrationPage.readWithAssistance();

		//verify the student view button
		blackBoardIntegrationPage.verifyheadframestudentView();

		//click on student view of the head frame
		blackBoardIntegrationPage.headframestudentView();

		//click on instructor view present in head frame
		blackBoardIntegrationPage.headframeinstructorView();

		//verify the black board button prtesent in head frame
		blackBoardIntegrationPage.verifyheadframeBlackBoard();

		//click on return black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}
*/
	//******************************************Test Case E4-307: Button "Student view" in wp4-homepage***********************//*
	/*@Test
	public void E4_307() throws Exception{

		//pre-requisite for launching the application
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//select ag test course 1 from input sheet
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contentTools();

		//select wp home page
		blackBoardIntegrationPage.selectWPHomePage();

		//verify the student view button
		blackBoardIntegrationPage.verifystudentView();

		//click on student view button
		blackBoardIntegrationPage.studentView();

		//click on ag course go
		blackBoardIntegrationPage.clickAGCourseGo();

		//verify black board button
		blackBoardIntegrationPage.verifyBlackBoard();

		//click on return to black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	//******************************************Test Case E4-309: Button "Student view" in wp4-ebook***********************//*
	@Test
	public void E4_309() throws Exception{

		//for launching the application
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//select kunals course
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		//click on wrsp
		blackBoardIntegrationPage.clickWPRSP();

		//click on verify student view
		blackBoardIntegrationPage.verifystudentView();

		//click on student view
		blackBoardIntegrationPage.studentView();

		//click on go
		blackBoardIntegrationPage.clickGo();

		//verify the instructor view button
		blackBoardIntegrationPage.verifyinstructorView();

		//click on instructor view button
		blackBoardIntegrationPage.instructorView();

		//verify the black board button
		blackBoardIntegrationPage.verifyBlackBoard();

		//click on rertunrn black board
		blackBoardIntegrationPage.returnToBlackboard();



		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}
*/
	/************************Test Case E4-311***********************************************/
	@Test
	public void E4_311() throws Exception{

		//for launching the application
		BBStudentViewForIntInstructorPrerequiste();


		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//click on kunals course for testing
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contentAssignments();

		//click on total score
		blackBoardIntegrationPage.clickTotalScore();


		//student view click
		blackBoardIntegrationPage.studentView();

		//verify the black board
		blackBoardIntegrationPage.verifyBlackBoard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	//*****************************************Test Case E4-312: Button "Student view" in wp4-studentGrades***********************//*
	/*@Test
	public void E4_312() throws Exception{


		//pre requisite for launching the app
		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//select AG course test 1 from xl file data is coming
		blackBoardIntegrationPage.selectCourseName2(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		//click on gradebook
		blackBoardIntegrationPage.wileyplus();

		//click on wiley roster info
		blackBoardIntegrationPage.wileyRosterinfo();

		//click on show all
		blackBoardIntegrationPage.showAll();

		//click on wiley plus account
		blackBoardIntegrationPage.wileyPlusAccount();

		//verify the student view button
		blackBoardIntegrationPage.verifystudentView();

		//click on student view
		blackBoardIntegrationPage.studentView();

		//verify the instructor view button
		blackBoardIntegrationPage.verifyinstructorView();

		//click on instructor view
		blackBoardIntegrationPage.instructorView();

		//verify the black board
		blackBoardIntegrationPage.verifyBlackBoard();

		//close the browser		
		blackBoardIntegrationPage.closeBrowser();
	}
*/
	/******************************************Test Case E4-313: Button "Student view" in wp4-announcements***********************/
	@Test
	public void E4_313() throws Exception{

		BBStudentViewForIntInstructorPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//click on kunals course for testing get the value from xl
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		//click on system announcements
		blackBoardIntegrationPage.clickWPSystemAnnouncements();

		//verify the student view
		blackBoardIntegrationPage.verifystudentView();

		//click on student view
		blackBoardIntegrationPage.studentView();

		//click on go
		blackBoardIntegrationPage.clickGo();

		//verify the instructor view
		blackBoardIntegrationPage.verifyinstructorView();

		//click on instructor view
		blackBoardIntegrationPage.instructorView();

		// verify balck board button is present or not
		blackBoardIntegrationPage.verifyBlackBoard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}


}