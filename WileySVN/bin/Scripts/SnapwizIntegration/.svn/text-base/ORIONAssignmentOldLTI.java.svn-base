package Scripts.SnapwizIntegration;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.LMSIntegration.InstructorPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Toolbox.Window;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentOldLTI {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentOldLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentOldLTI(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
		
	@Test
	public void d2l_Prerequisite() throws Exception
	{		
		ResultUtil.createReport("ORIONAssignmentOldLTI-d2l_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strLMS_URL=Prerequsite.configMap.get(strEnv+".LMS_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strLMS_URL);
			
		InstructorPage home=PageFactory.initElements(driver, InstructorPage.class);
			
		//Create a Instructor login
		InstructorPage instructor=home.instructorLogin(dataMap);
			
		//select a "WP QA Hoboken Regression Testing Section
		instructor.selectCourseName(dataMap);
		
		//Select content link
		instructor.selectContentLink();
		
		driver = instructor.getDriver();
	}	
	
	/******************************Test Case E4-5502: SW Int. Old LTI. Instructor UI - Assignments List************************************/
	/******************************TODO:PENDING
	@Test
	public void E4_5502() throws Exception
	{
		InstructorPage instructor =PageFactory.initElements(driver, InstructorPage.class);
		
		//Select assignment name
		AssignmentPage assignmentPage = instructor.selectSnapwizAssignmentLinkUnit(dataMap);
		
		instructor.switchToWindow();		
		
		//Go to Assignment table
		assignmentPage.goToOrionAssignmentTable(dataMap);
				
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
	}************************************/
	
	/**************************Test Case E4-5503: SW Int. Old LTI. Instructor UI - Assign Assignment **************************************/
	/***************************TODO:PENDING
	@Test
	public void E4_5503() throws Exception
	{
		Window.focusWindow("D2LWindow", driver,driver.getWindowHandles().toArray()[0].toString() );
		
		InstructorPage instructor =PageFactory.initElements(driver, InstructorPage.class);
		
		//Select assignment name
		AssignmentPage assignmentPage = instructor.selectSnapwizAssignmentLinkUnit(dataMap);
		
		instructor.switchToWindow();		
		
		//Go to Assignment table
		assignmentPage.goToOrionAssignmentTable(dataMap);
		
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
	
		//Edit due date
		assignOrionPage.editDateAssignOrionAssignment(dataMap);
		
		//Select the assignment using unassign option
		assignmentPage.selectActionsByUnassign("Unassign", intOrionAssignmentValue, dataMap);
		
		//Validate the warning message
		assignmentPage.unassignedWarningMessage();			
	}*****************************/
	
}
