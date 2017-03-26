package Scripts.CourseAdmin;


import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.CourseAdmin.CourseAdminPage;
import Pages.CourseAdmin.CoursePropertiesPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.CourseAdminDataProviderUtil.staticProviderClass;

@Test
public class CoursePropertiesChange {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="CourseAdminInstructors",dataProviderClass=staticProviderClass.class)
	public CoursePropertiesChange(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	/*******************************Test Case E4-416: Course Admin - Domain Owner - Course Properties page.**********************************/
	@Test
	public void E4_416() throws InterruptedException
	{
		ResultUtil.createReport("CoursePropertiesChange-validatingCourse", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);		
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		//Select course in home page
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
		
		/*********************Test Case E4-416: Course Admin - Domain Owner - Course Properties page****************************/
		
		//Select course admin tab
		CourseAdminPage courseAdminPage = courseHomePage.goToCourseAdminTab();
		
		//Select course properties tab
		CoursePropertiesPage coursePropertiesPage = courseAdminPage.navigateCoursePropertiesTab();
		
		//Change the course name and verifying the updated copy text
		LogoutSessionPage LogoutSessionPage = coursePropertiesPage.changeCourseName(dataMap);
		
		//Logout from the session
		LogoutSessionPage.logOutSession();
		
		Browser.closeDriver(driver);
	}
}