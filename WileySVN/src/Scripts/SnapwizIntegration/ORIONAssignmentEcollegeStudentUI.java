package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.EcollegeLoginPage;
import Pages.SnapwizIntegration.EcollegeHomePage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentEcollegeStudentUI {
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EcollegeAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentEcollegeStudentUI(Map<String,String> dataMap) {
		this.dataMap=dataMap;
	}

	@Test
	public void ecollegeLogin_Prerequisite(Map<String,String> dataMap ) throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentEcollegeStudentUI-ecollege_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strECOLLEGE_URL=Prerequsite.configMap.get(strEnv+".ECOLLEGE_URL");
		
		//Launch URL				
		 driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strECOLLEGE_URL);
	}
	
	/*********************TODO:PENDING
	@Test
	public void E4_5516() throws InterruptedException
	{
		EcollegeLoginPage ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		EcollegeHomePage ecollegeHomePage =ecollegeLoginPage.eCollegeStudentLogin(dataMap);
		 
		//Validate the home page
		ecollegeHomePage.ecollegeHomePage();
			
		//Go to academic PSH tab
		ecollegeHomePage.goToAcademicsPshTab();
			
		//Select any course
		ecollegeHomePage.selectCourse(dataMap);
			
		//Validate course home page
		ecollegeHomePage.validateCourseHomePage();
			
		//Go to Assignment page
		ecollegeHomePage.goToAssignmentPage();
		 
		//Switch assignment window
		ecollegeHomePage.switchtToWindow();
		 
		//Student Assignment page
		StudentAssignmentPage studentAssignmentPage =  ecollegeHomePage.eCollegeStudentAssignmentPage();
		 
		//Validate the unassigned orion assignments
		studentAssignmentPage.validateUnassignedAssignments(dataMap);
			
		//select not attempted assignments
		SnapwizOrionDashboardPage	snapwizOrionDashboardPage = studentAssignmentPage.selectNotAttemptedOrionAssignment(dataMap,"Second Assignment");
			 
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
		
		ecollegeHomePage.switchBackToParentWindow();		
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//close the main window
		Browser.closeDriver(driver);
	
	}*******************************************/
}
