package Scripts.SnapwizIntegration;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Common.AngelCourseLoginPage;
import Pages.SnapwizIntegration.AngelHomePage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentsAngel {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="AngelAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentsAngel(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void angel_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentsAngel-angel_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strANGEL_URL=Prerequsite.configMap.get(strEnv+".ANGEL_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strANGEL_URL);
		
		/**********************************************Login****************************************************************/
		
		AngelCourseLoginPage angelLoginPage = PageFactory.initElements(driver, AngelCourseLoginPage.class);
		AngelHomePage angelHomePage = angelLoginPage.angelInstructorLogin(dataMap);
		
		//Validate the home page
		angelHomePage.angelHomePage();
		
		//Select the angel course
		angelHomePage.selectAngelcourse(dataMap);
		
		//Select lesson tab
		angelHomePage.selectLessonTab();
		
		//Select assignment link in lessons tab
		angelHomePage.selectAssignmentLink();
				
		//Switch to assignment window
		angelHomePage.switchToWindow();
		
		//Assignment page
		AssignmentPage assignmentPage = angelHomePage.angelInstructorAssignmentPage();
		
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
		driver = assignmentPage.getDriver();
	}
	

	/*********************************************Test Case E4-5519: SW Int. Angel. Instructor UI - Assignments List*****************************************/
	/**********************************TODO:PENDING
	@Test
	public void E4_5519(Map<String,String> dataMap) throws Exception
	{			
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Validating ORION assignment in the assignment list
		int intOrionAssignmentValue=assignmentPage.validateOrionAssignments();
				
		//Validate the options in Actions dropdown for ORION assignments
		assignmentPage.validateOrionActionDropdown(intOrionAssignmentValue);
		
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
		
		driver = assignmentPage.getDriver();		
	}*********/
	
	/***************************************Test Case E4-5520: SW Int. Angel. Instructor UI - Assign Assignment**********************************************/
	/*********************************TODO:PENDING
	@Test
	public void E4_5520(Map<String,String> dataMap) throws InterruptedException
	{		
	AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
	AngelHomePage angelHomePage = PageFactory.initElements(driver, AngelHomePage.class);
	
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
			
	//Select the assignment using "Edit Availability" option
	assignmentPage.selectActionsByEditAvailability("Edit Availability", intOrionAssignmentValue, dataMap);
		
	//Edit due datae
	assignOrionPage.editDateAssignOrionAssignment(dataMap);
			
	//Select the assignment using unassign option
	assignmentPage.selectActionsByUnassign("Unassign", intOrionAssignmentValue, dataMap);
			
	//Validate the warning message
	assignmentPage.unassignedWarningMessage();
	
	//Close the assignment window
	Browser.closeDriver(driver);
	
	angelHomePage.switchBackToParentWindow();
	
	//Clear cookies
	Browser.clearAllCookies(driver);
	
	//close the main window
	Browser.closeDriver(driver);
}**************************************************/

}
