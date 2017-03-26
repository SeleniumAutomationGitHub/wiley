//1.9. Test Suite : [PC-447] Phase 2 of Maple Graphing/WP integration
//1.9.1. Test Suite : Rename to Graphing-Maple
package Scripts.MapleGraph;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.MapleGraph.MapleGraphPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;


@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
public class GraphingMapleIntegration
{

	/****Test Case E4-5281: WP-MNG security - Shared Secret Field in Admin Workspace *****/	
	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	public void E4_5281(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("GraphingMapleIntegration-E4_5281",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strAdminURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strAdminURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGAdminlogin(dataMap);
		//click on login user name

		//Click Configuration Tab
		mapleGraphPage.clickConfigurationTab();

		//Save Maple Graphing Shared SecretKey into Local variable
		mapleGraphPage.saveMapleGraphingSharedSecretKey();

		//verify modified Maple Graphing Shared SecretKey value after navigate another tab
		mapleGraphPage.verifyMGSharedSecretKeyWithoutApply(dataMap);

		//verify modified Maple Graphing Shared SecretKey value after apply button
		mapleGraphPage.verifyMGSharedSecretKeyWithApply(dataMap);

		//save Initial MapleGraphing SharedSecretKey
		mapleGraphPage.saveIntialMapleGraphingSharedSecretKey();

		mapleGraphPage.closeBrowser();
	}

	/******* Test Case E4-5244: Image Placeholder in pop-up balloon - Admin *******/
	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)

	public void E4_5244(Map<String,String> dataMap) throws Exception{

		/****Test Case E4-5281: WP-MNG security - Shared Secret Field in Admin Workspace *****/
		ResultUtil.createReport("GraphingMapleIntegration-E4_5244",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strAdminURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strAdminURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGAdminlogin(dataMap);

		// Click CoursesTab
		mapleGraphPage.adminCourses();

		//Click CourseLink
		mapleGraphPage.clickCoursesNameLink(dataMap);

		//Click Content Updates
		mapleGraphPage.contentUpdates();

		//click TestBanks
		mapleGraphPage.clicktestbanks();

		//click AssignmentManagement Link
		mapleGraphPage.clickAssignmentManagementLink();

		//click CreateQuestionPool button
		mapleGraphPage.clickCreateQuestionPool();

		//click Next button
		mapleGraphPage.clickNextButton();

		//click Go button
		mapleGraphPage.clickGoButton();

		//verify RollOver Popup Window
		mapleGraphPage.verifyRollOverPopupWindow(dataMap);

		Browser.closeDriver(driver);
	}

	/********** Check  previews  for questions from preconditions opened not done******************/

	/******* Test Case E4-5284: WP-MNG security - Shared Secret is changed during Student's attempt *******/

	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	public void E4_5284(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("GraphingMapleIntegration-E4_5284",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		// Login as Student
		mapleGraphPage.GraphingMapleStudentlogin(dataMap);

		//click AssignmentTab
		mapleGraphPage.clickAssignmentTab();

		//click AssignmentTab
		mapleGraphPage.clickAssignmentlink(dataMap);


		//click Next
		mapleGraphPage.clickmapleNext();

		//click SubmitAnswer
		mapleGraphPage.clickSubmitAnswer();

		Browser.closeDriver(driver);
	}

	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	//Test Case E4-5238: Image Placeholder in pop-up balloon - Instruct//
	public void E4_5238(Map<String,String> dataMap) throws Exception
	{

		ResultUtil.createReport("GraphingMapleIntegration-E4_5238",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strInstructorURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strInstructorURL);

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		driver.manage().window().maximize();

		//login as MGInstructor
		mapleGraphPage.GraphingMapleInstructorlogin(dataMap);

		//click AssignmentTab
		mapleGraphPage.clickAssignmentTab();

		//click Question Tab
		mapleGraphPage.clickMGQuestion();

		//verify RollOver PopupWindow 
		mapleGraphPage.verifyRollOverPopupWindowInstructor(dataMap);

		//click CreateQuestionPool
		mapleGraphPage.clickCreateQuestionPoolInstructor();

		//click Next button
		mapleGraphPage.clickNextButtonInstructor();

		//click Go button
		mapleGraphPage.clickGoButtonInstructor();

		//verify RollOver PopupWindow
		mapleGraphPage.verifyRollOverPopupWindowInstructor(dataMap);

		//Select check box
		mapleGraphPage.selectCheckBox(dataMap);

		//Click Next button
		mapleGraphPage.clickNext();

		//verify RollOver PopupWindow
		mapleGraphPage.verifyRollOverPopupWindowInstructor(dataMap);

		//driver close
		Browser.closeDriver(driver);


	}
	//Below test cases E4_5282_1,E4_5282_2,E4_5282_3,E4_5282_4 are in single test case
	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	public void E4_5282_1(Map<String,String> dataMap) throws Exception
	{

		ResultUtil.createReport("GraphingMapleIntegration-E4_5282",dataMap);

		//Admin Login
		//Launch URL
		String strEnv=Prerequsite.configMap.get("ENV");
		String strAdminURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		WebDriver driver = Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strAdminURL);
		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGAdminlogin(dataMap);
		// Click CoursesTab
		mapleGraphPage.adminCourses();

		//Click CourseLink
		mapleGraphPage.clickCoursesNameLink(dataMap);

		//Click Content Updates
		mapleGraphPage.contentUpdates();

		//click TestBanks
		mapleGraphPage.clicktestbanks();

		//click on questions mgmt link
		mapleGraphPage.clickQuestionsManagementLink();

		//select chapter
		mapleGraphPage.selectChapter(dataMap);

		mapleGraphPage.clickGoImage();

		/**** need to verify above steps *******/

		//Click Configuration Tab
		mapleGraphPage.clickConfigurationTab();

		//verify modified Maple Graphing Shared SecretKey value after apply button
		mapleGraphPage.editMGSharedSecretKeyValue(dataMap);

		Browser.closeDriver(driver);

	}

	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	public void E4_5282_2(Map<String,String> dataMap) throws Exception
	{

		ResultUtil.createReport("GraphingMapleIntegration-E4_5282",dataMap);


		//Launch URL
		String strEnv=Prerequsite.configMap.get("ENV");
		String strInstructorURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strInstructorURL);

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		driver.manage().window().maximize();

		//login as MGInstructor
		mapleGraphPage.GraphingMapleInstructorlogin(dataMap);


		mapleGraphPage.clickAssignmentTab();
		//click Question Tab
		mapleGraphPage.clickMGQuestion();

		//verify RollOver PopupWindow 
		mapleGraphPage.verifyRollOverPopupWindowInstructor(dataMap);

		//click CreateQuestionPool
		mapleGraphPage.clickCreateQuestionPoolInstructor();

		//click Next button
		mapleGraphPage.clickNextButtonInstructor();

		//click Go button
		mapleGraphPage.clickGoButtonInstructor();


		//Select check box
		mapleGraphPage.selectCheckBox(dataMap);

		//Click Next button
		mapleGraphPage.clickNext();

		//verify RollOver PopupWindow for preview
		mapleGraphPage.verifyRollOverPopupWindowInstructor(dataMap);

		// Click Grade book Tab
		mapleGraphPage.clickonGradebook();

		mapleGraphPage.closeBrowser();

	}
	/*******Navigate to Gradebook and preview your attempts  (Need some clarification)  *******/


	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	public void E4_5282_3(Map<String,String> dataMap) throws Exception
	{

		ResultUtil.createReport("GraphingMapleIntegration-E4_5284_3",dataMap);


		String strEnv=Prerequsite.configMap.get("ENV");
		String strStudentURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strStudentURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		// Login as Student
		mapleGraphPage.GraphingMapleStudentlogin(dataMap);

		//click AssignmentTab
		mapleGraphPage.clickAssignmentTab();

		//click AssignmentTab
		mapleGraphPage.clickAssignmentlink(dataMap);

		//click Next
		mapleGraphPage.clickmapleNext();

		mapleGraphPage.clickmapleNext();

		//click Verify SaveForLater
		mapleGraphPage.VerifySaveForLater();

		//click Verify SubmitAnswer
		mapleGraphPage.VerifySubmitAnswer();

		//Click Grade book Tab
		mapleGraphPage.clickonGradebook();

		mapleGraphPage.closeBrowser();
	}
	//Admin Login
	@Test(dataProvider="MapleGraphIntegration",dataProviderClass=staticProviderClass.class)
	public void E4_5282_4(Map<String,String> dataMap) throws Exception
	{

		//Launch URL
		String strEnv=Prerequsite.configMap.get("ENV");
		String strAdminURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		WebDriver driver = Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strAdminURL);
		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGAdminlogin(dataMap);
		// Click CoursesTab
		mapleGraphPage.adminCourses();

		//Click CourseLink
		mapleGraphPage.clickCoursesNameLink(dataMap);

		//Click Content Updates
		mapleGraphPage.contentUpdates();

		//click TestBanks
		mapleGraphPage.clicktestbanks();

		mapleGraphPage.clickQuestionsManagementLink();


		mapleGraphPage.closeBrowser();


	}

}

