package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


import Pages.Assignments.StudentAssignmentPage;
import Pages.LMSIntegration.StudentPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentOldLTIStudentUI {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentOldLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentOldLTIStudentUI(Map<String,String> dataMap)
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
	}
	

	/*******************************Test Case E4-5504: SW Int. Old LTI. Student UI - Assignment Access************************************/
	/*******************************TODO:PENDING
	@Test
	public void E4_5504() throws Exception
	{
		//Get login class
		StudentPage home=PageFactory.initElements(driver, StudentPage.class);
		StudentAssignmentPage studentAssignmentPage=PageFactory.initElements(driver, StudentAssignmentPage.class);
		SnapwizOrionDashboardPage snapwizOrionDashboardPage=PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
		
		//creating new object for student login
		StudentPage studentPage=home.studentLogin(dataMap);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentPage.selectCourseName(dataMap);
		
		//Select the content link in student login
		studentPage.selectContentLink();
		
		//Navigate to assignment link
		studentAssignmentPage = studentPage.selectStudentSnapwizAssignmentLinkUnit(dataMap);
		
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
		 
		//Close the Assignment window
		Browser.closeDriver(driver);
	}	****************/
	
}
