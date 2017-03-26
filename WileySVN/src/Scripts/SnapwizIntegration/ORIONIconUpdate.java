package Scripts.SnapwizIntegration;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.SnapwizLogoutPage;
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

public class ORIONIconUpdate {

	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationOrionDisAbled",dataProviderClass=staticProviderClass.class)
	public ORIONIconUpdate(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	public void orionIconUpdate_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("ORIONIconUpdate-orionIconUpdate_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);		
		
		/***************************************************Login-Page and get the domain URL from super administrator************************************************************/
		
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
		 
		//logout from the super administrator page
		SnapwizLogoutPage snapwizLogoutPage =  coursePropertiesPage.gotoLogoutPage();
		 
		//Logout functionalitu
		snapwizLogoutPage.logOutSession();
		 
		//Alert handling
		snapwizLogoutPage.SnapwizLoginPagealertHandling();
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver.
		Browser.closeDriver(driver);
		
		/**************************************************Test Case E4-5540: SW Int. Orion icon update********************************************************/
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strDomainURL);
	}
	
	/************************TODO:PENDING
	@Test
	public void E4_5540() throws Exception
	{
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseHomePage courseHomePage=home.domainOwnerLogin(dataMap);
			
		//Instructor Orion icon
		LogoutSessionPage logoutSessionPage = courseHomePage.InstructorOrionIcon();		
			
		//Logout from the session
		logoutSessionPage.logOutSession();
		 
		String strEnv=Prerequsite.configMap.get("ENV");
		String strSTUDENT_URL=Prerequsite.configMap.get(strEnv+".STUDENT_ORION_EDUGEN_URL");				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strSTUDENT_URL);
		 
		//Login
		StudentLoginpage studentHome = PageFactory.initElements(driver, StudentLoginpage.class);
		StudentHomepage studentHomepage=studentHome.loginPage(dataMap);
		
		//Student Home screen
		studentHomepage.studentHomeScreen(dataMap);
		
		//Student orion icon
		studentHomepage.StudentOrionIcon();		
	}	********************/
}
