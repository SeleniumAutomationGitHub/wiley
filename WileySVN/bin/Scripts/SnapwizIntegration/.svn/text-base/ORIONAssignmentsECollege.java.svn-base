package Scripts.SnapwizIntegration;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;

import Pages.Common.EcollegeLoginPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.EcollegeHomePage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentsECollege {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EcollegeAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentsECollege(Map<String,String> dataMap) {
		this.dataMap=dataMap;
	}
	
	@Test
	public void ecollegeLogin_Prerequisite(Map<String,String> dataMap ) throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentsECollege-ecollege_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strECOLLEGE_URL=Prerequsite.configMap.get(strEnv+".ECOLLEGE_URL");
		
		//Launch URL				
		 driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strECOLLEGE_URL);
		 
		EcollegeLoginPage ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		EcollegeHomePage ecollegeHomePage = ecollegeLoginPage.eCollegeInstructorLogin(dataMap);
		
		//Validate the home page
		ecollegeHomePage.ecollegeHomePage();
		
		//Go to academinc PSH tab
		ecollegeHomePage.goToAcademicsPshTab();
		
		//Select any course
		ecollegeHomePage.selectCourse(dataMap);
		
		//Validate course home page
		ecollegeHomePage.validateCourseHomePage();
		
		//Go to Assignment page
		ecollegeHomePage.goToAssignmentPage();
		
		//Switch to assignment window
		ecollegeHomePage.switchtToWindow();
		
		//Validate ecollege assignment page
		AssignmentPage assignmentPage = ecollegeHomePage.eCollegeInstructorAssignmentPage();
		
		//Go to orion assignment table
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		driver = assignmentPage.getDriver();
			
	}
	
	/*****************************TODO:PENDING
	
	@Test
	public void E4_5514() throws Exception
	{
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
				
		//Validating ORION assignment in the assignment list
		int intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
		
		//Select properties in the action dropdown.
		ORIONAssignmentPropertiesPage orionAssignmentPropertiesPage = assignmentPage.selectActionsByProperties("Properties", intOrionAssignmentValue);
		
		//Validating Assignment properties - assignment description page.
		orionAssignmentPropertiesPage.validateAssignmentDescription();
		
		//Validating Assignment properties - Class section page.
		orionAssignmentPropertiesPage.validateClassSectionAssignment();
		
		//Validating Assignment properties -Buttons
		orionAssignmentPropertiesPage.ValidateButtonDisplay();
		
		//Navigate to assignment list page
		orionAssignmentPropertiesPage.gotoAssignmentList();	
		
		driver =assignmentPage.getDriver();
	}******************************************/
	
	/********************TODO:PENDING
	@Test
	public void E4_5515() throws InterruptedException
	{
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		EcollegeHomePage ecollegeHomePage = PageFactory.initElements(driver, EcollegeHomePage.class);
				
		//Validating ORION assignment in the assignment list
		int intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
		
		//Filter the assignments from the Unassgined one
		assignmentPage.validateUnassignedAssignments(dataMap);
		
		//Select the assignment using "Assign" option
		AssignOrionPage assignOrionPage =assignmentPage.selectActionsByAssign("Assign", intOrionAssignmentValue, dataMap);	
		
		//Assign orion page
		assignOrionPage.assignOrionAssignment(dataMap);
		
		//Validate the assigned assignment
		assignmentPage.validateAssignedAssignments(dataMap);
		
		//Select the assignment using "Edit Availablilty" option
		assignmentPage.selectActionsByEditAvailability("Edit Availability", intOrionAssignmentValue, dataMap);
	
		//Edit due datae
		assignOrionPage.editDateAssignOrionAssignment(dataMap);
		
		//Select the assignment using unassign option
		assignmentPage.selectActionsByUnassign("Unassign", intOrionAssignmentValue, dataMap);
		
		//Validate the warning message
		assignmentPage.unassignedWarningMessage();		
		
		//Close the assignment window
		Browser.closeDriver(driver);
		
		//Switch back to parent window
		ecollegeHomePage.switchBackToParentWindow();

		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//close the main window
		Browser.closeDriver(driver);
	}*************************/		
}
