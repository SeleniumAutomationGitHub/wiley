package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.StudentHomepage;
import Pages.SnapwizIntegration.ReadStudyPracticePage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Pages.SnapwizIntegration.WileyPlusOrionPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;


public class BBOrionNavigationalTab {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="BBOrionNavigation",dataProviderClass=staticProviderClass.class)
	public BBOrionNavigationalTab(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	public  WebDriver BBLogin_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("BBOrionNavigationalTab-BBLogin_Prerequisite", dataMap);	
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
			
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		return driver;
	}
	
	@Test
	/**********************Test Case E4-5512: SW Int. Nav Tab. New LTI. Domain owner.***********************************************/
	public void E4_5512 () throws Exception
	{				
		ResultUtil.report("INFO", "BBOrionNavigationalTab>E4_5512", driver);
		
		driver = BBLogin_Prerequisite();
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		
			
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
			
		//Select wiley home page link
		CourseHomePage courseHomePage =  blackBoardIntegrationPage.selectWPHomePageLink();
			 
		//Validating wileyplus home page
		blackBoardIntegrationPage.wileyPlusHomePage();
		
		//Add - Blackboard Eula
		blackBoardIntegrationPage.bbInstructorEula();
			
		//Accept the license
		blackBoardIntegrationPage.instructorEulaAcceptance();
			
		//Go to orion tab
		WileyPlusOrionPage wileyPlusOrionPage =  courseHomePage.goToOrionTab();
			
		//Wiley plus orion page
		SnapwizOrionDashboardPage snapwizOrionDashboardPage =  wileyPlusOrionPage.wileyPlusOrionPage(dataMap);		 
			 
		//Validate the snapwiz orion dashboard course title page
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		
		//Validate the course home page
		snapwizOrionDashboardPage.validateOrionCourseHomepage();
		
		//Validate the user attributes
		snapwizOrionDashboardPage.validateUserAttributes(dataMap);
			 
		//Return to wileyplus page
		snapwizOrionDashboardPage.returnToWileyplusPView();
			 
		//Go to ready, study practice tab
		ReadStudyPracticePage readStudyPracticePage=courseHomePage.goToReadStudyPracticeTab();
			 
		//Select class and chapter
		readStudyPracticePage.selectClassSectionAndChapter();
			 
		//Go to orion tab
		courseHomePage.goToOrionTab();
			 
		//wiley plus orion page
		wileyPlusOrionPage.wileyPlusOrionPage(dataMap);	
			 
		//Validate orion dashboard course title page
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		
		//Validate the course home page
		snapwizOrionDashboardPage.validateOrionCourseHomepage();
					 
		//Return to wileyplus page
		snapwizOrionDashboardPage.returnToWileyplusPView();
			 
		//Go to student view button
		StudentViewChooseClassSection studentViewChooseClassSection = courseHomePage.goToStudentView();
			 
		//Choose the class section
		StudentHomepage studentHomepage =  studentViewChooseClassSection.chooseClassSection(dataMap);
			 
		//Student home screen
		studentHomepage.studentHomeScreen(dataMap);
			 
		//Go to orion tab
		snapwizOrionDashboardPage =  studentHomepage.goToStudentOrionTab();
			  
		//Validate orion dashboard course title page
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		
		//Validate the course home page
		snapwizOrionDashboardPage.validateOrionCourseHomepage();
			  
		//Return to student home screen
		snapwizOrionDashboardPage.returnToStudentWPHomeScreen();
		
		//Navigate to course admin page
		courseHomePage.validateDomainRole(dataMap);
		
		//Go to instructor view
		courseHomePage.goToInstructorView();
		  
		//Clear cookies
		Browser.clearAllCookies(driver);
		  
		//Close the browser
		Browser.closeDriver(driver);
	}
	/***************************************Excluded: Test Case E4-5513: SW Int. Nav Tab. New LTI. Student*********************************************/	
	/***************************************TODO:PENDING
	@Test(dependsOnMethods = { "E4_5512" })	
	public void E4_5513 (Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "BBOrionNavigationalTab>E4_5513", driver);
		
		driver=BBLogin_Prerequisite();
		
		//Initialize the page
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		  
		//Login as Student 
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);
		  
		//Select the course name
		blackBoardIntegrationPage.selectCourseName(dataMap);
		   
		//Select the content link
		blackBoardIntegrationPage.selectcontent2();
		   
		//Select the WP home page link
		StudentHomepage	studentHomepage = blackBoardIntegrationPage.selectStudentWPHomePageLink();
		
		//Add- Student Eula if present
		blackBoardIntegrationPage.bbStudentEula();
		
		//Accept if EULA displayed
		blackBoardIntegrationPage.instructorEulaAcceptance();
		   
		//Student home screen
		studentHomepage.studentHomeScreen(dataMap);
		   
		//Reach to snapwiz dashboard page.
		SnapwizOrionDashboardPage snapwizOrionDashboardPage= studentHomepage.goToStudentOrionTab();
					
		//Validate the orion dashboard title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
		//Return to wiley plus screen
		snapwizOrionDashboardPage.returnToStudentScreen();
			
		//Click ready study practice tab
		studentHomepage.goToReadStudyPracticeTab();
			
		//Return to the page
		studentHomepage.StudentOrionIcon();
			
		//Reach to snapwiz dashboard page.
		studentHomepage.goToStudentOrionTab();
						
		//Validate the orion dashboard title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
					
		//Return to wiley plus screen
		snapwizOrionDashboardPage.returnToStudentWPHomeScreen();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
	  
		//Close the browser
		Browser.closeDriver(driver);
	}	****************************************************/
}
