package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwizSubDomainPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPropertiesPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIConfigurationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="LTIConfigurationFunctionality",dataProviderClass=staticProviderClass.class)
public class LTIConfigurationFunctionality {
	public void validateLtiConfigurationFucntionality(Map<String,String> dataMap)throws MalformedURLException, Exception{
	
		String strEnv=Prerequsite.configMap.get("ENV");
		String strAdminURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strAdminURL);
		
		/***************************************************Login-Page************************************************************/
		
		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		 snapwizHomePage.validateSnapwizHomepage();	 
		 
		ConfigurationPage configurationPage =  snapwizHomePage.gotoConfigurationTab();
		 
		LTIConfigurationPage ltiConfigurationPage = configurationPage.goToLTISubTab();
		 
		ltiConfigurationPage.LTIConfigurationDefaultPage();
		 
		/*****************************Test Case E4-1: LTI conf - "LTI Configuration" tab. GUI, page elements****************************/
		 
		ltiConfigurationPage.validateLTIConfigurationGUIPage(dataMap);
		 
		/***************************** Test Case E4-4: LTI conf - "Create New Consumer" tab. GUI, page elements****************************/
		 
		ltiConfigurationPage.goToAddNewConsumers();
		 
		ltiConfigurationPage.validateCreateNewConsumerGUI();
	}
}
