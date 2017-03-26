package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.Common.SnapwizLoginPage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.CourseAdmin.CourseAdminClassSectionPage;
import Pages.CourseAdmin.CourseAdminPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwizSubDomainPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPropertiesPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class studentSnapwizEulaStandalone {

	WebDriver driver;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="StudentSnapwizEula",dataProviderClass=staticProviderClass.class)
	public studentSnapwizEulaStandalone(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	

	@Test
	public void snapwizEula_Prerequisite() throws Exception
	{
		ResultUtil.createReport("studentSnapwizEulaStandalone-snapwizEula_Prerequisite", dataMap);

		String getDomainUrl = getDomainUrl_Preconditions(dataMap,Prerequsite.configMap);

		getStudentUrl_Preconditions(getDomainUrl);

		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), dataMap.get("StudentUrl"));
	}

	public String getDomainUrl_Preconditions(Map<String,String> dataMap, Map<String,String> configMap) throws InterruptedException
	{
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

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
		String strDomainUrl = snapwizSubDomainPropertiesPage.getDomainURL(dataMap);		 

		//Clear the cookies
		Browser.clearAllCookies(driver);

		//Close the driver.
		Browser.closeDriver(driver);

		return strDomainUrl;
	}

	public String getStudentUrl_Preconditions(String getDomainUrl) throws Exception
	{
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), getDomainUrl);

		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
		CourseAdminClassSectionPage courseAdminClassSectionPage = PageFactory.initElements(driver, CourseAdminClassSectionPage.class);

		CourseHomePage courseHomePage=home.domainOwnerLogin(dataMap);

		//Go to instructor view
		//courseHomePage.goToInstructorView();

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

		return studentDomainUrl;
	}

	@Test
	/*******************************Test Case E4-5537: WP-SW Int - EULA. Standalone - student*************************************************/
	public void E4_5537()throws MalformedURLException, Exception{	

		ResultUtil.report("INFO", "SnapwizIntegration>E4_5537", driver);

		//Login
		StudentLoginpage home = PageFactory.initElements(driver, StudentLoginpage.class);
		StudentHomepage studentHomepage=home.loginPage(dataMap);

		//Student Eula
		studentHomepage.studentEula();	
	}

}

