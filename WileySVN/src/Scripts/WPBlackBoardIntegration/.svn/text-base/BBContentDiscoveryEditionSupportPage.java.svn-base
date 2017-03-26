package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.BlackboardToolsWileyPlusPage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryContentLinksPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryStaticTargetPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoverySupportHelpPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test (dataProvider="BBContentSupportLinks",dataProviderClass=staticProviderClass.class)
public class BBContentDiscoveryEditionSupportPage {
	public void validateBBContentDiscoveryEditionSupport(Map<String,String> dataMap)throws MalformedURLException, Exception{
		
		ResultUtil.createReport("BBContentDiscoveryEditionSupportPage-validateBBContentDiscoveryEditionSupport", dataMap);
			
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");		
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
	
		/***************************************************Pre-condition - Test Case E4-115************************************************************/
		
		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();	 
		 
		//Navigate to configuration tab
		ConfigurationPage configurationPage =  snapwizHomePage.gotoConfigurationTab();
		 
		//Navigate to LTI content discovery
		LTIContentDiscoveryContentLinksPage ltiContentDiscoveryContentLinksPage = configurationPage.goToLTIContentDiscoverySubTab();
		 
		//Content link page
		ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		 
		//Navigate to support/Help tab
		LTIContentDiscoverySupportHelpPage ltiContentDiscoverySupportHelpPage =  ltiContentDiscoveryContentLinksPage.goToSupportHelpTab();
		 
		//Suppot help pahe
		ltiContentDiscoverySupportHelpPage.SupportHelpHomePage();
		 
		//Select help link
		ltiContentDiscoverySupportHelpPage.selectHelpLink(dataMap);
		 
		//Validate the home page
		ltiContentDiscoverySupportHelpPage.SupportHelpHomePage();
		 
		//Edit the support content values
		ltiContentDiscoverySupportHelpPage.editContentSupportValues(dataMap);
		 
		//Save the settings
		ltiContentDiscoverySupportHelpPage.saveSettings();
		 
		//Validate the table
		ltiContentDiscoverySupportHelpPage.validateeditContentSupportTable(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/*******************************Test Case E4-115: BB Instructor - Content Discovery - Edition of Support/Help link***************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage userPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		userPage.tools();
		 
		//Select the wileyplus link
		BlackboardToolsWileyPlusPage blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Validate the edited support link
		blackboardToolsWileyPlusPage.validateSupportBBToolLinkEdited(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/********************************Test Case E4-911: BB Student - Content Discovery - Edition of Support/Help link*****************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBStudentLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		userPage.tools();
		 
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Validate the edited support link
		blackboardToolsWileyPlusPage.validateSupportBBToolLinkEdited(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/***************************************************Pre-condition - Test Case E4-116************************************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"),strWPADMIN_URL);
		 
		//Login
		snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
			
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();	 
			 
		//Navigate to configuration tab
		configurationPage =  snapwizHomePage.gotoConfigurationTab();
			 
		//Navigate to LTI content discovery
		ltiContentDiscoveryContentLinksPage = configurationPage.goToLTIContentDiscoverySubTab();
			 
		//Content link page
		ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		
		//Navigate to static target tab
		 LTIContentDiscoveryStaticTargetPage ltiContentDiscoveryStaticTargetPage = ltiContentDiscoveryContentLinksPage.goToStaticTargetTab();
		 		 
		//Static target home page
		ltiContentDiscoveryStaticTargetPage.staticTargetHomePage();
		 
		 //Select static target link
		 ltiContentDiscoveryStaticTargetPage.selectStaticTargetLink(dataMap);
		 
		//Change the url
		ltiContentDiscoveryStaticTargetPage.changeUrl(dataMap);
		 
		//Save setttings
		ltiContentDiscoveryStaticTargetPage.saveSettings();

		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		
		/*****************************************Test Case E4-116: BB Instructor - Content Discovery - Edition of Static BB target******************************/
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
	    userPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		userPage.tools();
		 
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();

		//Validate the static BB target URL
		blackboardToolsWileyPlusPage.validateStaticEditedBBUrl(dataMap);
		  
		//Clear the cookies
		Browser.clearAllCookies(driver);
			 
		//Close the driver
		 Browser.closeDriver(driver);
		  
		/**************************************Test Case E4-912: BB Student - Content Discovery - Edition of Static BB target**************************************/
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
			 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBStudentLogin(dataMap);
				
		//Select the course
		userPage.selectCourseName(dataMap);
		  
		userPage.tools();
		 
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();

		//Validate the static BB target URL
		blackboardToolsWileyPlusPage.validateStaticEditedBBUrl(dataMap);
			  
		//Clear the cookies
		Browser.clearAllCookies(driver);
				 
		//Close the driver
		Browser.closeDriver(driver);
	}
}