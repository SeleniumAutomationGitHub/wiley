package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.HomePage;
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

public class SnapwizEulaStandalone {

	WebDriver driver = null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="InstructorSnapwizEula",dataProviderClass=staticProviderClass.class)
	public SnapwizEulaStandalone(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	

	@Test
	public void snapwizEula_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("SnapwizEulaStandalone-snapwizEula_Prerequisite", dataMap);

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

		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strDomainUrl);
	}

	/**********************************Test Case E4-5536: WP-SW Int - EULA. Standalone - instructor***************************************/
	@Test(dependsOnMethods={"snapwizEula_Prerequisite"})
	public void E4_5536()throws MalformedURLException, Exception{

		ResultUtil.report("INFO", "SnapwizIntegration>E4_5536", driver);
		//Login
		HomePage home = PageFactory.initElements(driver, HomePage.class);

		CourseHomePage courseHomePage=home.domainOwnerLogin(dataMap);

		//Go to Instructor Eula page
		courseHomePage.InstructorEula();
	}



}

