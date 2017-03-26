package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.AngelCourseLoginPage;
import Pages.SnapwizIntegration.AngelHomePage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentAngelStudentUI {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="AngelAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentAngelStudentUI(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	public void angel_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentAngelStudentUI-angel_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strANGEL_URL=Prerequsite.configMap.get(strEnv+".ANGEL_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strANGEL_URL);
	}	
	
	/*************************************** Test Case E4-5521: SW Int. Angel. Student UI - Assignment Access**********************************************/
	/**************************************TODO:PENDING
	@Test
	public void E4_5521() throws InterruptedException{
		
		AngelCourseLoginPage angelLoginPage = PageFactory.initElements(driver, AngelCourseLoginPage.class);
		StudentAssignmentPage studentAssignmentPage=PageFactory.initElements(driver, StudentAssignmentPage.class);
		SnapwizOrionDashboardPage snapwizOrionDashboardPage=PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
		 
		 AngelHomePage angelHomePage = angelLoginPage.angelStudentLogin(dataMap);
			
		//Validate the home page
		angelHomePage.angelHomePage();
			
		//Select the angel course
		angelHomePage.selectAngelcourse(dataMap);
			
		//Select lesson tab
		angelHomePage.selectLessonTab();		 
		
		//Select assingment link in lessons tab
		angelHomePage.selectAssignmentLink();
		
		//Switch to  window
		angelHomePage.switchToWindow();
		
		//Return to student assingment page
		studentAssignmentPage =  angelHomePage.angelStudentAssignmentPage();		 
		 
		//Validate the unassigned orion assignments
		studentAssignmentPage.validateUnassignedAssignments(dataMap);
			
		//select not attempted assignments
		snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"Second Assignment");
			
		//Validate the orion dashboard
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
			
		//Validate the attempted Assignment
		studentAssignmentPage.validateAttemptedOrionAssignment(dataMap,"Second Assignment");
		 
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		 
		//Select another assignments
		studentAssignmentPage.selectAttemptedOrionAssignment(dataMap, "First Assignment");
		 
		//return to wp 
		snapwizOrionDashboardPage.returnToWPView();
		 
		//Close the assignment window
		Browser.closeDriver(driver);		
	}*******************************/
}
