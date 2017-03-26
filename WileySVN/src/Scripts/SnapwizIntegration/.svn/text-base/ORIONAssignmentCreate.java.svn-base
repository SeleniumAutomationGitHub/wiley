package Scripts.SnapwizIntegration;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizCourseContentUpdatePage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Pages.SnapwizIntegration.TestBankAssignmentManagementPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;


public class ORIONAssignmentCreate {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentCreate(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	public void testBanks_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("ORIONAssignmentCreate-testBanks_Prerequisite", dataMap);
		
		ResultUtil.report("INFO", "ORIONAssignmentCreate>testBanks_Prerequisite", driver);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
		
		/***************************************************Login-Page************************************************************/
		
		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();		 
		 
 		//Navigate to Course tab
		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();
 
		//Validate the list of courses in the course list
		driver = snapwziCoursesListPage.validateCoursesList(dataMap).getDriver();
	}	
	
	/*********************Test Case E4-5483: SW Int. Create assignment - File upload *********************************************/
	/**********************TO BE DELETED***************************/
	
	/**********************TODO:PENDING***************************
	@Test
	public void E4_5483() throws InterruptedException
	{
		ResultUtil.report("INFO", "ORIONAssignmentCreate>E4_5483", driver);
		
		CoursePropertiesPage coursePropertiesPage = PageFactory.initElements(driver, CoursePropertiesPage.class);
		
		//Click Update link
		coursePropertiesPage.goToUpdateLink();
		 
		//Validate course mapping id
		coursePropertiesPage.validateCourseMappingID();
		 
		//Upload valid course mapping id
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPath");
		 
		//Click "Save settings"
		coursePropertiesPage.saveSettings();
		 
		//Navigate to course content update tab
		SnapwizCourseContentUpdatePage snapwizCourseContentUpdatePage = coursePropertiesPage.gotoContentUpdatesTab();

		//Content update home page
		snapwizCourseContentUpdatePage.contentUpdateHomepage();
		 
		//Select Test Bank link
		snapwizCourseContentUpdatePage.selectTestBankLink();
		 
		//Click Assignment Management link
		TestBankAssignmentManagementPage testBankAssignmentManagementPage =  snapwizCourseContentUpdatePage.goToTestBanksAssignmentManagement();
		 
		testBankAssignmentManagementPage.orionAssignments();
		 
		//Select orion assignment link
		testBankAssignmentManagementPage.selectOrionAssignments();
		 
		//Validate assignment properties pgge
		testBankAssignmentManagementPage.validateAssignmentPropertiesPage();
		
		driver = testBankAssignmentManagementPage.getDriver();

	}*/
	
	/**********************Test Case E4-5484: SW Int. Admin UI - Assignments List***********************************************/
	/**********************TODO: PENDING
	@Test(dependsOnMethods = { "E4_5483" })
	public void E4_5484()
	{		
		TestBankAssignmentManagementPage testBankAssignmentManagementPage = PageFactory.initElements(driver, TestBankAssignmentManagementPage.class);
		
		//Back to assignment page
		testBankAssignmentManagementPage.goToAssignmentsPage();		 
		  
		//Validate the Orion assignment is displayed.
		testBankAssignmentManagementPage.validateAssignmentsAssignmentManagement();		 
		 
		Browser.clearAllCookies(driver);
		 
		Browser.closeDriver(driver);
	}***************************************/

}