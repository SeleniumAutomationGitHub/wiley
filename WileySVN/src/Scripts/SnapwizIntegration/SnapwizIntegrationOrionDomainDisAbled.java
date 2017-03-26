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
import Pages.SnapwizIntegration.SnapwizSubDomainPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPropertiesPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="SnapwizIntegrationOrionDisAbled",dataProviderClass=staticProviderClass.class)
public class SnapwizIntegrationOrionDomainDisAbled {	
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public SnapwizIntegrationOrionDomainDisAbled(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	//Preconditions
	public void SnapwizIntegrationOrionDomainDisAbled_Prerequisite() throws Exception
	{
		ResultUtil.createReport("SnapwizIntegrationOrionDomainDisAbled-SnapwizIntegrationOrionDomainDisAbled_Prerequisite", dataMap);
		
		ResultUtil.report("INFO", "SnapwizIntegration>SnapwizIntegrationOrionDomainDisAbled_Prerequisite", driver);
		
		//As a precondition, Assign Orion assignments
		assignOrionAssignments_Precondition(dataMap,Prerequsite.configMap);
		
		//As a precondition, disable the ORION for the domain
		disableDomain_Precondition(dataMap,Prerequsite.configMap);
		
		//Login into Student page
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
	
	public void disableDomain_Precondition(Map<String,String> dataMap, Map<String,String> configMap) throws InterruptedException
	{
		//Launch URL
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = PageFactory.initElements(driver, SnapwizHomePage.class);
		SnapwziCoursesListPage snapwziCoursesListPage =PageFactory.initElements(driver, SnapwziCoursesListPage.class);
		CoursePropertiesPage coursePropertiesPage =PageFactory.initElements(driver, CoursePropertiesPage.class);
		SnapwizSubDomainPage snapwizSubDomainPage =PageFactory.initElements(driver, SnapwizSubDomainPage.class);
		SnapwizSubDomainPropertiesPage snapwizSubDomainPropertiesPage =PageFactory.initElements(driver, SnapwizSubDomainPropertiesPage.class);
		
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
		
		//Enable ORION option for product
		coursePropertiesPage.enableOrionCheckboxOption();
		
		//"Current State for Existing Domains:" option = "All enabled";
		coursePropertiesPage.validateCurrentStateEnabled();
		 
		//"Default State for Newly Added Domains:" = "Enabled";
		coursePropertiesPage.validateDefaultStateEnabled();
		 
		//Navigate to Course-Domain page
		coursePropertiesPage.gotoDomainSubTab();
		
		//Select the domain from the dataMap
		snapwizSubDomainPage.selectDomainName(dataMap);
		
		//Disable the orion domain 
		snapwizSubDomainPropertiesPage.disableOrionDomain();
		
		//Save settings 
		snapwizSubDomainPropertiesPage.saveSettings();
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);
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
	
	/*******************************************************Test Case E4-5529: SW Int. Assignment Access. Disabled Int, Domain**********************************************************/
	/****************************TODO:PENDING
	@Test
	public void E4_5529 () throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5529", driver);	
					
		StudentAssignmentPage studentAssignmentPage =PageFactory.initElements(driver, StudentAssignmentPage.class);
		
		//Click on the first ORION assignment link
		studentAssignmentPage.studentAssignmentPageOnProductDisable();
				
		//Handle ORION disable alert
		studentAssignmentPage.alertWarningOnOrionProductDisabled();
	}**********************/
	
	/*******************************************************Test Case E4-5531: SW Int. Assignment List. Disabled Int, Domain**********************************************************/
	/*****************************TODO:PENDING
	@Test
	public void E4_5531() throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5531", driver);
		
		StudentAssignmentPage studentAssignmentPage =PageFactory.initElements(driver, StudentAssignmentPage.class);
		
		//Validate the orion student assignment page
		studentAssignmentPage.validateUnassignedAssignments(dataMap);	
	}**********************/
		
}
