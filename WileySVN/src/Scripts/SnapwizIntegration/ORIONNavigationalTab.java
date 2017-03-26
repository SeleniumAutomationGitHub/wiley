package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.HomePage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.StudentHomepage;
import Pages.CourseAdmin.AddClassSectionPage;
import Pages.CourseAdmin.CourseAdminClassSectionPage;
import Pages.CourseAdmin.CourseAdminPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.ReadStudyPracticePage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPropertiesPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Pages.SnapwizIntegration.WileyPlusOrionPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONNavigationalTab {
	public static String strDomainURL;
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentsStandalone",dataProviderClass=staticProviderClass.class)
	public ORIONNavigationalTab(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	public void navigationOrion_Prerequisite() throws MalformedURLException, Exception
	{
		ResultUtil.createReport("ORIONNavigationalTab-navigationOrion_Prerequisite", dataMap);
		
		 strDomainURL = getDomainUrl(dataMap,Prerequsite.configMap);
		
		//Launch URL		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strDomainURL);
	}
	
	
	public String getDomainUrl(Map<String,String> dataMap, Map<String,String> configMap )throws MalformedURLException, Exception
	{		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
				
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
		 
		//Navigate to Course-Domain page
		SnapwizSubDomainPage snapwizSubDomainPage = coursePropertiesPage.gotoDomainSubTab();
		 
		//Validate the given domain and select the domain name
		SnapwizSubDomainPropertiesPage snapwizSubDomainPropertiesPage =  snapwizSubDomainPage.selectDomainName(dataMap);
		 
		//Get the domain url.
		String strDomainURL = snapwizSubDomainPropertiesPage.getDomainURL(dataMap);		 
		
		//Validating the active class validation
		snapwizSubDomainPropertiesPage.activeClassValidation();
		 
		System.out.println(strDomainURL);
				 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver.
		Browser.closeDriver(driver);
		
		return strDomainURL;
		
	}
	
	/**********************Test Case E4-5481: SW Int. Nav Tab. Standalone. Domain owner.	 *  ***********************************************/
	@Test
	public void E4_5481() throws Exception
	{
			//Login
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			CourseHomePage courseHomePage=home.domainOwnerLogin(dataMap);
			 
			//Navigate to Orion tab
			WileyPlusOrionPage wileyPlusOrionPage = courseHomePage.goToOrionTab();
			
			//wileyplus orion page 
			SnapwizOrionDashboardPage snapwizOrionDashboardPage = wileyPlusOrionPage.wileyPlusOrionPage(dataMap);
			
			//Validating the orion dashboard page
			snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
			//Validate the course home page
			snapwizOrionDashboardPage.validateOrionCourseHomepage();
			
			//Validate the user attributes
			snapwizOrionDashboardPage.validateUserAttributes(dataMap);
			
			//Return back to wileyplus application
			snapwizOrionDashboardPage.returnToWileyplusPView();
			
			//Navigate to course admin page
			courseHomePage.validateDomainRole(dataMap);
					
			CourseAdminPage courseAdminPage = courseHomePage.goToCourseAdminTab();
			
			//Navigate to class section sub tab
			CourseAdminClassSectionPage courseAdminClassSectionPage = courseAdminPage.navigateClassSectionTab();
			
			//Click add class section button
			AddClassSectionPage addClassSectionPage = courseAdminClassSectionPage.gotoAddClassSection();
		
			//Enter the value
			addClassSectionPage.addClassSectionName(dataMap, "NewChangeClassName", "NewClassSectionTerm", "NewClassSectionEndDate");
			
			//Enter submit button
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, "NewChangeClassName");
			
			//Click "Orion" tab
			courseHomePage.goToOrionTab();
			
			//Select the class name randomly
			wileyPlusOrionPage.wileyPlusOrionPage(dataMap);
			
			//Validating the orion dashboard page
			snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
			//Validate the course home page
			snapwizOrionDashboardPage.validateOrionCourseHomepage();
					
			//Return back to wileyplus application
			snapwizOrionDashboardPage.returnToWileyplusPView();
			
			//Navigate to course admin page
			courseHomePage.validateDomainRole(dataMap);
			
			//Go to read study and practice tab
			ReadStudyPracticePage readStudyPracticePage = courseHomePage.goToReadStudyPracticeTab();
			
			//Select the chapter and class section
			courseHomePage = readStudyPracticePage.selectClassSectionAndChapter();
			
			//Click "Orion" tab
			courseHomePage.goToWPOrionTab();
					
			//Select the class name randomly
			wileyPlusOrionPage.wileyPlusOrionPage(dataMap);
					
			//Validating the orion dashboard page
			snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
			//Validate the course home page
			snapwizOrionDashboardPage.validateOrionCourseHomepage();
							
			//Return back to wileyplus application
			snapwizOrionDashboardPage.returnToWileyplusPView();
			
			//Navigate to course admin page
			courseHomePage.validateDomainRole(dataMap);
			
			//click go to student view button
			StudentViewChooseClassSection studentViewChooseClassSection =courseHomePage.goToStudentView();
			
			//Select the class section
			StudentHomepage studentHomepage = studentViewChooseClassSection.chooseClassSection(dataMap);
			
			//Click the orion tab
			studentHomepage.goToStudentOrionTab();
			
			//Validating the orion dashboard page
			snapwizOrionDashboardPage.orionDashboardCourseTitle();
			
			//Validate the course home page
			snapwizOrionDashboardPage.validateOrionCourseHomepage();
					
			//Return back to wileyplus application
			snapwizOrionDashboardPage.returnToWileyplusPView();
			
			//Navigate to course admin page
			courseHomePage.validateDomainRole(dataMap);
			
			//Go to instructor view
			courseHomePage.goToInstructorView();
	}
		
	/********************************** Test Case E4-5482: SW Int. Nav Tab. Standalone. Student	  **************************************/
	/**********************************TODO:PENDING
	@Test(dependsOnMethods={"E4_5481"})
	public void E4_5482() throws Exception
	{		
		CourseHomePage courseHomePage = PageFactory.initElements(driver, CourseHomePage.class);
		CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
		CourseAdminClassSectionPage courseAdminClassSectionPage = PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
		SnapwizOrionDashboardPage snapwizOrionDashboardPage = PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
		StudentHomepage studentHomepage = PageFactory.initElements(driver, StudentHomepage.class);
		
		//Navigate to course admin page
		courseHomePage.goToCourseAdminTab();
		
		//Navigate to class section sub tab
		courseAdminPage.navigateClassSectionTab();
		
		//Get student domain url
		String studentDomainUrl=courseAdminClassSectionPage.getStudentClassSectionUrl(dataMap);		

		//Logout from the page
		LogoutSessionPage logoutSessionPage = courseAdminClassSectionPage.logoutFromCourseAdminClassSectionPage();
		
		//Click Loogout link
		logoutSessionPage.logOutSession();
		
		//Launch URL for student url		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), studentDomainUrl);
		
		//Login
		StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);		
		studentHome.loginPage(dataMap);
		
		//Go to Student Eula page
		studentHomepage.studentEula();
	
		//Reach to snapwiz dashboard page.
		studentHomepage.goToStudentOrionTab();
				
		//Validate the orion dashboard title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
		
		//Return to wiley plus screen
		snapwizOrionDashboardPage.returnToStudentWPViewHomeScreen();
		
		//Click ready study practice tab
		studentHomepage.goToReadStudyPracticeTab();
		
		//Return to the page
		studentHomepage.StudentOrionIcon();
		
		//Reach to snapwiz dashboard page.
		studentHomepage.goToStudentOrionTab();
					
		//Validate the orion dashboard title
		snapwizOrionDashboardPage.orionDashboardCourseTitle();
				
		//Return to wiley plus screen
		snapwizOrionDashboardPage.returnToStudentWPViewHomeScreen();
						
	}************************************/
	
}
