package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONModifyDeleteAssignment {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public ORIONModifyDeleteAssignment(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void modifyAssignment_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONModifyAssignment-modifyAssignment_Prerequisite", dataMap);
		
		ResultUtil.report("INFO", "ORIONModifyAssignment>modifyAssignment_Prerequisite", driver);
		
		uploadMappingID_Prerequisite(dataMap,Prerequsite.configMap);
		
		assignOrionAssingments_Prerequisite(dataMap,Prerequsite.configMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
		
		//Login
		StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
		StudentHomepage studentHomepage=studentHome.loginPage(dataMap);
			
		//Reach to assignments page.
		StudentAssignmentPage studentAssignmentPage = studentHomepage.goToAssignment();
			
		driver = studentAssignmentPage.getDriver();		
	}
	
	public void uploadMappingID_Prerequisite(Map<String,String> dataMap, Map<String,String> configMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "ORIONModifyAssignment>uploadMappingID_Prerequisite", driver);
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
		
		/***************************************************Login-Page************************************************************/
		
		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		CoursePropertiesPage coursePropertiesPage = PageFactory.initElements(driver, CoursePropertiesPage.class);
		
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();		 
		 
 		//Navigate to Course tab
		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();
 
		//Validate the list of courses in the course list
		snapwziCoursesListPage.validateCoursesList(dataMap);
		
		coursePropertiesPage.enableOrionCheckboxOption();
		
		//Click Update link
		coursePropertiesPage.goToUpdateLink();
		 
		//Validate course mapping id
		coursePropertiesPage.validateCourseMappingID();
		 
		//Upload valid course mapping id
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPath");
		 
		//Click "Save settings"
		coursePropertiesPage.saveSettings();
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
	}
	
	public void assignOrionAssingments_Prerequisite(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{
		ResultUtil.report("INFO", "ORIONModifyAssignment>assignOrionAssingments_Prerequisite", driver);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
		
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
			
		//Select the course and reach course home page.
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
			
		//Reach to assignments page.
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
			
		assignmentPage.goToOrionAssignmentTable(dataMap);
			
		//Validating ORION assignment in the assignment list
		assignmentPage.validateOrionAssignments();
		 
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
			
		//Select the assignment using "Assign" option
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign", dataMap, "Chapter Delete");
			
		//Assign orion page
		assignOrionPage.assignOrionAssignment(dataMap);
			
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);
		
		assignmentPage.closeOperationWindow();
			
		//Clear all cookies
		Browser.clearAllCookies(driver);
			  
		//close the browser
		Browser.closeDriver(driver);
	}
	
	/*********************Test Case E4-5535: SW Int. Modify assignment - File upload *********************************************/
	@Test(dependsOnMethods={"modifyAssignment_Prerequisite"})
	public void E4_5535() throws Exception
	{
		ResultUtil.report("INFO", "ORIONModifyAssignment>E4_5535", driver);		
		
		StudentAssignmentPage studentAssignmentPage =   PageFactory.initElements(driver, StudentAssignmentPage.class);
		
		//Validate the unassigned orion assignments
		studentAssignmentPage.validateUnassignedAssignments(dataMap);
			
		//select not attempted assignments
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"Chapter Delete");
			
		//Validate the orion dashboard
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		
		//Validate orion attempted
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "Chapter Delete");
			
		//Clear all cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
			
		//Navigate to admin url
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
			
		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = PageFactory.initElements(driver, SnapwizHomePage.class);
		SnapwziCoursesListPage snapwziCoursesListPage = PageFactory.initElements(driver, SnapwziCoursesListPage.class);
		CoursePropertiesPage coursePropertiesPage = PageFactory.initElements(driver, CoursePropertiesPage.class);
		
		snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
			
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();		 			 
	 		
		//Navigate to Course tab
		snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();
	 
		//Validate the list of courses in the course list
		coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);
			 
		//Click Update link
		coursePropertiesPage.goToUpdateLink();
			 
		//Validate course mapping id
		coursePropertiesPage.validateCourseMappingID();
			 
		//Upload valid course mapping id
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPathWithOneModifiedID");
			 
		//Click "Save settings"
		coursePropertiesPage.saveSettings();
					 
		//Clear all cookies
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
		
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
			 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
			 
		//Login
		StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
		StudentHomepage studentHomepage=studentHome.loginPage(dataMap);	
					 
		//Go to Gradebook tab
		StudentGradeBookPage studentGradeBookPage= studentHomepage.goToGradeBook();
			 
		//Enter the chapter
		studentGradeBookPage.validateModifyAssignment(dataMap, "Chapter Delete");
			
		//Go to assignment tab
		studentAssignmentPage =  studentHomepage.goToAssignment();
			  
		//Validate the assignment 
		studentAssignmentPage.validateModifyAssignmentTab(dataMap, "Chapter Delete");
			  
		//Clear all cookies
		Browser.clearAllCookies(driver);
			  
		//close the browser
		Browser.closeDriver(driver);
		
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
			  
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
			  
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
			 
		//Select the course
		CourseHomePage courseHomePage= courseSelectionPage.selectCourse(dataMap);
			 
		//Go to Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
			 
		//click go button
		assignmentPage.clickGo();
			 
		//Validate the assignment present
		assignmentPage.validateAssignmentPresent(dataMap, "Chapter Delete");
			 
		//Clear all cookies
		Browser.clearAllCookies(driver);
			  
		//close the browser
		Browser.closeDriver(driver);
	}

	/*********************Test Case E4-5534: SW Int. Delete assignment - File upload*********************************************/
	@Test(dependsOnMethods={"modifyAssignment_Prerequisite"})
	public void E4_5534() throws Exception{
		
		ResultUtil.report("INFO", "ORIONModifyAssignment>E4_5534", driver);
		
		StudentAssignmentPage studentAssignmentPage =   PageFactory.initElements(driver, StudentAssignmentPage.class);
		
		//Validate the unassigned orion assignments
		studentAssignmentPage.validateUnassignedAssignments(dataMap);
			
		//select not attempted assignments
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = studentAssignmentPage.selectAttemptedOrionAssignment(dataMap,"Chapter Choosed");			 
				
		//Validate the orion dashboard
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		
		studentAssignmentPage.validateOrionAssignmentsAttempted(dataMap, "Chapter Delete");

		//Clear all cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);
			
		String strEnv=Prerequsite.configMap.get("ENV");		
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Navigate to admin url
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
				
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = PageFactory.initElements(driver, SnapwizHomePage.class);
		SnapwziCoursesListPage snapwziCoursesListPage = PageFactory.initElements(driver, SnapwziCoursesListPage.class);
		CoursePropertiesPage coursePropertiesPage = PageFactory.initElements(driver, CoursePropertiesPage.class);
		
		//Login
		snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
			
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();		 			 
	 		
		//Navigate to Course tab
		snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();
	 
		//Validate the list of courses in the course list
		coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);
			 
		//Click Update link
		coursePropertiesPage.goToUpdateLink();
			 
		//Validate course mapping id
		coursePropertiesPage.validateCourseMappingID();
			 
		//Upload valid course mapping id
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPathWithOneChapterDeleted");
			 
		//Click "Save settings"
		coursePropertiesPage.saveSettings();
			 
		//Clear all cookies
		Browser.clearAllCookies(driver);
		
		//close the browser
		Browser.closeDriver(driver);
			  
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
		 
		//Navigate to Student url
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);	
			 
		//Login
		StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
		StudentHomepage studentHomepage=studentHome.loginPage(dataMap);			 
					 
		//Go to Gradebook tab
		StudentGradeBookPage studentGradeBookPage= studentHomepage.goToGradeBook();
			 
		//Enter the chapter
		studentGradeBookPage.validateDeletedAssignment(dataMap, "Chapter Delete");
			
		//Go to assignment tab
		studentAssignmentPage =  studentHomepage.goToAssignment();
			  
		//Validate the assignment 
		studentAssignmentPage.validateDeleteAssignmentTab(dataMap, "Chapter Delete");
			  
		//Clear all cookies
		Browser.clearAllCookies(driver);
			  
		//close the browser
		Browser.closeDriver(driver);
		
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
			
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
			  
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
			 
		//Select the course
		CourseHomePage courseHomePage= courseSelectionPage.selectCourse(dataMap);
			 
		//Go to Assignment page
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
			 
		//click go button
		assignmentPage.clickGo();
			 
		//Validate the assignment present
		assignmentPage.validateAssignmentAbsent(dataMap, "Chapter Delete");
			 
		//Clear all cookies
		Browser.clearAllCookies(driver);
			  
		//close the browser
		Browser.closeDriver(driver);
	}

}
