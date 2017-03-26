package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.StudentHomepage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentNewLTIStudent {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentNewLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentNewLTIStudent(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void bbNewLTIStudent_Prerequisite() throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentNewLTIStudent-bbNewLTIStudent_Prerequisite", dataMap);		
				
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
			
		//Login as Student
		BlackBoardIntegrationPage blackBoardIntegrationPage =home.BBStudentLogin(dataMap);
		
		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		
				
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
	}	
	

/*******************************************Test Case E4-5493: SW Int. New LTI. Student UI - Assignment Access*******************************************************/
	/*********************TODO:PENDING
	@Test
	public void E4_5493 () throws MalformedURLException, Exception
	{
		
		ResultUtil.report("INFO", "ORIONAssignmentNewLTIStudent>E4_5493", driver);
		
		BlackBoardIntegrationPage blackBoardIntegrationPage = PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);	
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
		StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);
		StudentHomepage studentHomepage = PageFactory.initElements(driver, StudentHomepage.class);
		
		//Click "Wiley plus" assignment link
		blackBoardIntegrationPage.goToWileyPlusAssignment();
		 
		//Go to student assignment page
		assignmentPage.goToStudentAssignmentPage();
		 
		//Select not attempted assignments
		studentAssignmentPage.selectBBNotAttemptedOrionAssignment(dataMap,"First Assignment");
		  
		//Validate orion dashboard course title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		  
		//Return to wiley plus view page
		snapwizOrionDashboardPage.returnToWPView();
		
		studentAssignmentPage.selectBBNotAttemptedOrionAssignment(dataMap,"Second Assignment");
		
		//Validate orion dashboard course title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
				  
		//Return to wiley plus view page
		snapwizOrionDashboardPage.returnToWPView();
		  
		//Return to blackboard
		studentAssignmentPage.returnToBlackboard();
		  
		//Select wiley home page link
		blackBoardIntegrationPage.selectStudentWPHomePageLink();
		  
		//Go to assignment tab
		studentHomepage.goToAssignment();
		 
		//Validate un attempted assingments
		studentAssignmentPage.validateAttemptedOrionAssignment(dataMap,"First Assignment");
		 
		//Select not attempted assignments
		studentAssignmentPage.selectAttemptedOrionAssignment(dataMap, "Second Assignment");
		 
		//Validate orion dashboard course title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		  
		//Return to wiley plus view page
		snapwizOrionDashboardPage.returnToWPView();
		  
		//Return to blackboard
		studentAssignmentPage.returnToBlackboard();
	}***********************/

}
