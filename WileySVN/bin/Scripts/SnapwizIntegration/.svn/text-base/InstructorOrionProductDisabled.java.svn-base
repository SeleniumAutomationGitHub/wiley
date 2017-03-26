package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.SnapwizLogoutPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class InstructorOrionProductDisabled {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public InstructorOrionProductDisabled(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	public void InstructorOrionProductDisabled_Prerequisite() throws Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>InstructorOrionProductDisabled_Prerequisite", driver);
		
		ResultUtil.createReport("SnapwizIntegrationOrionDisAbled-E4_5533", dataMap);
				
		/*******************************************************Set ORION product Disable*************************************************************************************/
		
		disableProduct_Precondition(dataMap,Prerequsite.configMap);		
		
		//Preconditions:
		String strEnv=Prerequsite.configMap.get("ENV");		
		String strEDUGEN_URL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//Login as domain owner		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strEDUGEN_URL);
		 
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
						
		//Select the course and reach course home page.
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
						
		//Reach to assignments page.
		AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
		
		//Select the options in the assignment list
		assignmentPage.goToAssignmentList(dataMap);
	}
	
	public void disableProduct_Precondition(Map<String,String> dataMap,Map<String,String> configMap) throws InterruptedException{
		String strWPADMIN_URL=Prerequsite.configMap.get(Prerequsite.configMap.get("ENV")+".WPADMIN_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
		
		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();
		 
		//Navigate to Course tab
		SnapwziCoursesListPage snapwziCoursesListPage =snapwizHomePage.gotoCoursesTab();
		 
		//Validate the list of courses in the course list
		CoursePropertiesPage coursePropertiesPage = snapwziCoursesListPage.validateCoursesList(dataMap);
		 
		//Validate the course properties page of the particular course.
		coursePropertiesPage.validateCourseProperties();			 
		
		//Disable the ORION -product settings
		coursePropertiesPage.disableOrionCheckboxOption();
		 
		//Save the settings
		coursePropertiesPage.saveSettings();
	
		//logout from the super administrator page
		SnapwizLogoutPage snapwizLogoutPage =  coursePropertiesPage.gotoLogoutPage();
		 
		//Logout functionalitu
		snapwizLogoutPage.logOutSession();
		 
		//Alert handling
		snapwizLogoutPage.SnapwizLoginPagealertHandling();
		 
		//Clear the cookies
		snapwizLogoutPage.clearAllCookies();
		 
		//Close the driver
		snapwizLogoutPage.closeDriver();
	}
	
	/******************************************************* Test Case E4-5533: SW Int. Disable Int - Assign Assignment***********************************************************/
	/************************************TODO: PENDING
	@Test	
	public void E4_5533 () throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5533", driver);
			
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Validating ORION assignment in the assignment list
		int intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
			
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
				
		//Validate the assigned assignment
		assignmentPage.validateAssignedOrionAssignments(dataMap);
				
		//Select the assignment using "Edit Availablilty" option
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByEditAvailability("Edit Availability", intOrionAssignmentValue, dataMap);
			
		//Edit due datae
		assignOrionPage.editDateAssignOrionAssignment(dataMap);
				
		//Select the assignment using unassign option
		assignmentPage.selectActionsByUnassign("Unassign", intOrionAssignmentValue, dataMap);
				
		//Validate the warning message
		assignmentPage.unassignedWarningMessage();		
				
		//Validate the unassigned ORION assignments disappear
		assignmentPage.validateOrionAssignmentOnDisableUnassign(dataMap);
		 
		//Clear cookies
		Browser.clearAllCookies(driver);
		 
		//Close driver
		Browser.closeDriver(driver); 
	}*****************************************/
}
