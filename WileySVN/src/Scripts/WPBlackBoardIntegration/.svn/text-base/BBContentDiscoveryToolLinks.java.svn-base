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
import Pages.WPBlackboardIntegration.LTIContentDiscoveryToolsLinksPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test (dataProvider="BBContentToolLinks",dataProviderClass=staticProviderClass.class)
public class BBContentDiscoveryToolLinks {
	public void validateBBContentDiscoveryToolLinks(Map<String,String> dataMap) throws MalformedURLException, Exception{
		
		ResultUtil.createReport("BBContentDiscoveryToolLinks-validateBBContentDiscoveryToolLinks", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");		
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
	
		/***************************************************Pre-condition - Test Case E4-112************************************************************/
		
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
		 
		//Navigate to tools links tab
		LTIContentDiscoveryToolsLinksPage ltiContentDiscoveryToolsLinksPage =  ltiContentDiscoveryContentLinksPage.goToToolsLinkTab();
		 
		//Active class home page
		ltiContentDiscoveryToolsLinksPage.toolsLinkActiveClassHomePage();
		 
		//Go to add content
		ltiContentDiscoveryToolsLinksPage.goToAddContent();
		 
		//Add Too area values
		ltiContentDiscoveryToolsLinksPage.addToolAreaValues(dataMap);
		
		//Click Save settings button
		ltiContentDiscoveryToolsLinksPage.saveSettings();
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/****************************************Test Case E4-112: BB Instructor - Content Discovery - Addition of a Tool ****************************************/
		 		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage userPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		
		//Select Tools link
		userPage.tools();
		
		//Select the wileyplus link
		BlackboardToolsWileyPlusPage blackboardToolsWileyPlusPage = userPage.wileyplus();
			
		//Validate the add content link in blackboard page
		blackboardToolsWileyPlusPage.validateBBAddContentLink(dataMap);
		 
		//Validate the wiley plus page by logo
		blackboardToolsWileyPlusPage.validateWileyplusPage();
		 
		//return to Blackboard
		blackboardToolsWileyPlusPage.returnToBlackboard();
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/*******************************Test Case E4-823: BB Student - Content Discovery - Addition of a Tool******************************************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBStudentLogin(dataMap);
		 
		//Select the course
		userPage.selectCourseName(dataMap);
		
		//Select Tools link
		userPage.tools();
		
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
			
		//Validate the add content link in blackboard page
		blackboardToolsWileyPlusPage.validateBBAddContentLink(dataMap);
		 
		//Validate the wiley plus page by logo
		blackboardToolsWileyPlusPage.validateWileyplusPage();
		 
		//return to Blackboard
		blackboardToolsWileyPlusPage.returnToBlackboard();
		
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/********************************************************Pre-condition - Test Case E4-111************************************************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
		 
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
			 
		//Navigate to tools links tab
		ltiContentDiscoveryToolsLinksPage =  ltiContentDiscoveryContentLinksPage.goToToolsLinkTab();
		 
		//Active class home page
		ltiContentDiscoveryToolsLinksPage.toolsLinkActiveClassHomePage();
			 
		//Click edit link
		ltiContentDiscoveryToolsLinksPage.editToolLink(dataMap);
			 
		//Enter the value to be edited
		ltiContentDiscoveryToolsLinksPage.editToolLinkValues(dataMap);
		 
		//Click Save settings
		ltiContentDiscoveryToolsLinksPage.saveSettings();
			 
		//Validate the edit tool table
		ltiContentDiscoveryToolsLinksPage.validateEditToolsLinkTable(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/****************************************Test Case E4-111: BB Instructor - Content Discovery - Tool edition****************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		
		//Select Tools link
		userPage.tools();
		
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		  
		//Validate edit content link in BB
		blackboardToolsWileyPlusPage.validateBBEditContentLink(dataMap);
		 
		//Validate the wiley plus page by logo
		blackboardToolsWileyPlusPage.validateWileyplusPage();
			 
		//return to Blackboard
		blackboardToolsWileyPlusPage.returnToBlackboard();
		  
		//Check the default order of the links
		blackboardToolsWileyPlusPage.getDefaultWileyLinksOrder();
			 
		//Clear the cookies
		Browser.clearAllCookies(driver);
			 
		//Close the driver
		Browser.closeDriver(driver);
		  
		/************************************Test Case E4-824: BB Student - Content Discovery - Tool edition***************************************************/
		  
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
			 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBStudentLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		
		//Select Tools link
		userPage.tools();
		
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		  
		//Validate edit content link in BB
		blackboardToolsWileyPlusPage.validateBBEditContentLink(dataMap);
		  
		//Validate the wiley plus page by logo
		blackboardToolsWileyPlusPage.validateWileyplusPage();
			 
		//return to Blackboard
		blackboardToolsWileyPlusPage.returnToBlackboard();
		  
		//Check the default order of the links
		blackboardToolsWileyPlusPage.getDefaultWileyLinksOrder();
			 
		//Clear the cookies
		Browser.clearAllCookies(driver);
			 
		//Close the driver
		Browser.closeDriver(driver);
		  
		/***************************************************Pre-condition - Test Case E4-113***************************************************************/
		  
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
			 
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
				 
		//Navigate to tools links tab
		ltiContentDiscoveryToolsLinksPage =  ltiContentDiscoveryContentLinksPage.goToToolsLinkTab();
			 
		//Active class home page
		ltiContentDiscoveryToolsLinksPage.toolsLinkActiveClassHomePage();
			 
		//Change the order
		//ltiContentDiscoveryToolsLinksPage.toolLinkReordering(dataMap, strBBURL, strBBURL);
		  
		String strEditedToolLinkOrder =  ltiContentDiscoveryToolsLinksPage.orderEditedToolLink(dataMap);
			 
		//Clear the cookies
		Browser.clearAllCookies(driver);
				 
		//Close the driver
		Browser.closeDriver(driver);
			  
		/*****************************************Test Case E4-113: BB Instructor - Content Discovery - Re-ordering Tools********************************/
		  
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
				 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBInstructorLogin(dataMap);
			
		//Select the course
		userPage.selectCourseName(dataMap);
			
		//Select Tools link
		userPage.tools();
			
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
			  
		//Get the order of the changed wiley link order
		blackboardToolsWileyPlusPage.getChangeWileyLinksOrder();
			  
		//Validate the wiley link order
		blackboardToolsWileyPlusPage.validateBBWileyLinksOrder();
		  
		//Clear the cookies
		Browser.clearAllCookies(driver);
				 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/*************************************Test Case E4-825: BB Student - Content Discovery - Re-ordering Tools*******************************************/
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
			 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBStudentLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
			
		//Select Tools link
		userPage.tools();
			
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
			  
		//Get the order of the changed wiley link order
		blackboardToolsWileyPlusPage.getChangeWileyLinksOrder();
			  
		//Validate the wiley link order
		blackboardToolsWileyPlusPage.validateBBWileyLinksOrder();
		  
		//Clear the cookies
		Browser.clearAllCookies(driver);
				 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/***************************************************Pre-condition - Test Case E4-114************************************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
			 
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
		  
		//Delete the content
		ltiContentDiscoveryContentLinksPage.deleteContent(dataMap);
		  
		//Clear the cookies
		Browser.clearAllCookies(driver);
				 
		//Close the driver
		Browser.closeDriver(driver);
	
		/**********************************Test Case E4-114: BB Instructor - Content Discovery - Tool deleting***************************************/
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
			 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBInstructorLogin(dataMap);
			
		//Select the course
		userPage.selectCourseName(dataMap);
			
		//Select Tools link
		userPage.tools();
			
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		  
		//Validate the deleted content
		blackboardToolsWileyPlusPage.validateDeletedContent(dataMap);

		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		  
		/*************************************Test Case E4-826: BB Student - Content Discovery - Tool deleting************************************************/
		  
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
			 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBStudentLogin(dataMap);
			
		//Select the course
		userPage.selectCourseName(dataMap);
			
		//Select Tools link
		userPage.tools();
			
		//Select the wileyplus link
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		  
		//Validate the deleted content
		blackboardToolsWileyPlusPage.validateDeletedContent(dataMap);

		//Clear the cookies
		Browser.clearAllCookies(driver);
				 
		//Close the driver
		Browser.closeDriver(driver);
	}
}
