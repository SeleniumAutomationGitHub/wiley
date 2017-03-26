package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
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
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class SnapwizIntegrationOrionProductDisabled {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public SnapwizIntegrationOrionProductDisabled(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}		
	
	@Test
	//Preconditions
	public void SnapwizIntegrationOrionProductDisabled_Prerequisite() throws Exception
	{
		ResultUtil.createReport("SnapwizIntegrationOrionProductDisabled-SnapwizIntegrationOrionProductDisabled_Prerequisite", dataMap);
		
		ResultUtil.report("INFO", "SnapwizIntegration>SnapwizIntegrationOrionProductDisabled_Prerequisite", driver);

		//As a precondition, assign orion assignments
		assignOrionAssignments_Precondition(dataMap,Prerequsite.configMap);
		
		//As a precondition, disable the ORION chackbox for the product
		disableProduct_Precondition(dataMap,Prerequsite.configMap);
		
		//Login in to Student edugen environment
		String strEnv=Prerequsite.configMap.get("ENV");		
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
	    	    
		StudentLoginpage  studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
		StudentHomepage studentHomepage =PageFactory.initElements(driver, StudentHomepage.class);
		
		//Login
		studentHome.loginPage(dataMap);		
		
		//Navigate to assignments page.
		driver = studentHomepage.goToAssignment().getDriver();
	}
	
	public void assignOrionAssignments_Precondition(Map<String,String> dataMap, Map<String,String> configMap) throws Exception
	{
		String strEnv=Prerequsite.configMap.get("ENV");
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//As a precondition, assigned 2 orion assignments in this class section
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
		 
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
						
		//Select the course and reach course home page.
		courseSelectionPage.selectCourse(dataMap);
		
		//Reach to assignments page.
		AssignmentPage assignmentPage =PageFactory.initElements(driver, AssignmentPage.class);
		CourseHomePage courseHomePage =PageFactory.initElements(driver, CourseHomePage.class);
		
		courseHomePage.goToAssigmentPage();
		
		//Assignment list selection
		assignmentPage.goToAssignmentList(dataMap);
				
		//Validating ORION assignment in the assignment list
		assignmentPage.validateOrionAssignments();
			
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedOrionAssignments(dataMap);
		
		//Clear all the cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);	
	}
	
	public void disableProduct_Precondition(Map<String,String> dataMap, Map<String,String> configMap) throws InterruptedException
	{
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = PageFactory.initElements(driver, SnapwizHomePage.class);
		SnapwziCoursesListPage snapwziCoursesListPage =PageFactory.initElements(driver, SnapwziCoursesListPage.class);
		CoursePropertiesPage coursePropertiesPage =PageFactory.initElements(driver, CoursePropertiesPage.class);
		
		//Login in to Wileyplus admin
		snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();
				 		 
		//Navigate to Course tab
		snapwizHomePage.gotoCoursesTab();
		 
		//Validate the list of courses in the course list
		snapwziCoursesListPage.validateCoursesList(dataMap).getDriver();
		
		//As a precondition, Click Update link to upload the mapping id
		coursePropertiesPage.goToUpdateLink();
		
		//Validate the course mapping ID
		coursePropertiesPage.validateCourseMappingID();
		
		//As a precondition, upload Course Mapping ID
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPath");
		
		//Disable ORION option for product
		coursePropertiesPage.disableOrionCheckboxOption();
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
	}
	
	/*****************************Test Case E4-5530: SW Int. Assignment Access. Disabled Int, Product*********************************************************************/
	/****************************TODO:PENDING
	@Test
	public void E4_5530() throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5530", driver);
		
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);
		
		//Click on the first ORION assignment link
		studentAssignmentPage.studentAssignmentPageOnProductDisable();
					
		//Handle ORION disable alert
		studentAssignmentPage.alertWarningOnOrionProductDisabled();
		
		driver = studentAssignmentPage.getDriver();
	}***************************/
	
	/***************************************Test Case E4-5532: SW Int. Assignment List. Disabled Int, Product****************************************************************/
	/*****************************TODO:PENDING
	@Test
	public void E4_5532() throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5532", driver);
		
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);
		
		//Validate the orion student assignment page
		studentAssignmentPage.validateUnassignedAssignments(dataMap);
		
		driver = studentAssignmentPage.getDriver();
	}*************************/
	
}
