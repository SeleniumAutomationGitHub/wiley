//Test Case E4-316: WP-BB Int - Move students. 1st and 2nd classes are active
//Test Case E4-317: WP-BB Int - Move students. 1st class is finished w/o student, 2nd class is active
//Test Case E4-318: WP-BB Int - Move students. 1st class is finished with a student, 2nd class is active
//Test Case E4-319: WP-BB In-Move students.1st class is finished with a student,2nd class is active(require new regcode)
//Test Case E4-320: WP-BB Int - Move students. Student has never been in the class
//Test Case E4-321: WP-BB Int - Move students. Instructor view
//Test Case E4-322: WP-BB Int - Move students. 1st class is finished w/o a student. Instructor view. 
//Test Case E4-323: WP-BB Int - Move students. 1st class is finished with a student. Instructor view

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
import org.testng.annotations.Test;

import Pages.LMSIntegration.InstructorPage;

import Pages.MapleGraph.MapleGraphPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;
//Below Precondition should be met.
//Preconditions:
//Student must be enrolled in one class.
//"Require new Registration Code for re-entering students" option is enabled on domain level.
//Instructor in BB added student to the second BB course (Log in in BB as a administrator > select course > Users and Groups > Users > Enroll user > Find users to enrol). 
//First and second classes are active.

@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
public class BBWPMoveUsersInActiveandFinishedClass {

	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_316(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-316");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_316",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);

		//select course name for testing
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.contentAssignments();
		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}


	/************************Test Case E4-317: WP-BB Int - Move students. 1st class is finished w/o student, 2nd class is active***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_317(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-317");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_317",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.selectcontent();

		blackBoardIntegrationPage.wileyPlusHomePage();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/************************Test Case E4-318: WP-BB Int - Move students. 1st class is finished with a student, 2nd class is active***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_318(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-318");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_318",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.selectcontent();

		blackBoardIntegrationPage.selectWPHomePage();


		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/************************Test Case E4-319: WP-BB In-Move students.1st class is finished with a student,2nd class is active(require new regcode)***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_319(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-319");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_319",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);

		//select kunals course for testing
		blackBoardIntegrationPage.selectCourseName(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		//click wiley plus
		blackBoardIntegrationPage.clickwileyplus();


		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/************************Test Case E4-320: WP-BB Int - Move students. Student has never been in the class***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_320(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-320");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_320",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		//click on gradebook
		blackBoardIntegrationPage.clickGradebook();

		//return to black board button
		blackBoardIntegrationPage.returnToBlackboard();

		blackBoardIntegrationPage.logoutBB();

		//login the student
		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.wPAssignments();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}


	/************************Test Case E4-321: WP-BB Int - Move students. Instructor view***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_321(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-321");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_321",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);


		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.clickGradebook();

		//click on return black board
		blackBoardIntegrationPage.returnToBlackboard();

		blackBoardIntegrationPage.logoutBB();

		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		//click on kunals course fro testing
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.wPAssignments();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/************************Test Case E4-322: WP-BB Int - Move students. 1st class is finished w/o a student. Instructor view***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_322(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-322");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_322",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.clickGradebook();

		//click on return black board
		blackBoardIntegrationPage.returnToBlackboard();

		//logout the bb
		blackBoardIntegrationPage.logoutBB();

		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.wPAssignments();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}

	/************************Test Case E4-323: WP-BB Int - Move students. 1st class is finished with a student. Instructor view***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_323(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-323");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_323",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		blackBoardIntegrationPage.wPAssignments();

		//click on return to black board
		blackBoardIntegrationPage.returnToBlackboard();

		//logout of black board page
		blackBoardIntegrationPage.logoutBB();

		//click on login
		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//select kunals course from input xl
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.contenttools();

		//wp assignments click
		blackBoardIntegrationPage.wPAssignments();

		//click on wp practice
		blackBoardIntegrationPage.clikwp02pratice();

		//click on assign next
		blackBoardIntegrationPage.clickassignNext();

		blackBoardIntegrationPage.windowclose();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

}