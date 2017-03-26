package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.BBPublicContentPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryContentLinksPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test (dataProvider="BBContentContentLinks",dataProviderClass=staticProviderClass.class)
public class BBContentDiscoveryContentLinks {
	public void validateBBContentDiscoveryContentLinks(Map<String,String> dataMap)throws MalformedURLException, Exception{
		
		ResultUtil.createReport("BBContentDiscoveryContentLinks-validateBBContentDiscoveryContentLinks", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL); 
	
		/***************************************************Pre-condition - Test Case E4-117(112)************************************************************/
		
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
		 
		//Click "Add content" link
		ltiContentDiscoveryContentLinksPage.goToAddContent();
		 
		//Enter data in Add content area values
		ltiContentDiscoveryContentLinksPage.addContentAreaValues(dataMap); 		 
		 
		//Click "Save settings" button
		ltiContentDiscoveryContentLinksPage.saveSettings();
		 
		//Validate the content link table
		ltiContentDiscoveryContentLinksPage.validateContentLinkTable(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/*******************************Test Case E4-117: BB Instructor - Content Discovery - Addition of a Content link***************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage userPage = home.BBInstructorLogin(dataMap);		 
		 
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		//Select the content
		userPage.selectcontent2();
		 
		//Select publish content
		BBPublicContentPage bbPublicContentPage =  userPage.clickPublishContent();
		 
		//Select Add WP tool
		bbPublicContentPage.selectAddWPTool();
		 
		//Validate the addition content link
		bbPublicContentPage.validateAdditionContentLink(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/***************************************************Pre-condition - Test Case E4-118(112)************************************************************/
		 
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
			 
		//Click the link to be edited
		ltiContentDiscoveryContentLinksPage.editContentLink(dataMap);
			 
		//Edit the content values
		ltiContentDiscoveryContentLinksPage.editContentValues(dataMap);
			 
		//Click "Save settings" button
		ltiContentDiscoveryContentLinksPage.saveSettings();
			 
		//Validate the table after editing the table
		ltiContentDiscoveryContentLinksPage.validateEditContentLinkTable(dataMap);
			 
		//Clear the cookies
		Browser.clearAllCookies(driver);
			 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/*******************************Test Case E4-118: BB Instructor - Content Discovery - Content link edition***************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBInstructorLogin(dataMap);		 
		 
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		//Select the content
		userPage.selectcontent2();
		 
		//Select publish content
		bbPublicContentPage =  userPage.clickPublishContent();
		 
		//Select Add WP tool
		bbPublicContentPage.selectAddWPTool();
		
		//Validate the validate edit Addition Content Link
		bbPublicContentPage.validateeditAdditionContentLink(dataMap);
		 
		//Get the order of the add tool links
		bbPublicContentPage.getToolsLinkDefaultOrder();
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/***************************************************Pre-condition - Test Case E4-119(112)************************************************************/
		 
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
 
		String strEditedContentLinkOrder =  ltiContentDiscoveryContentLinksPage.orderEditedContentLink(dataMap);
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/*******************************Test Case E4-119: BB Instructor - Content Discovery - Re-ordering Content links***************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBInstructorLogin(dataMap);		 
		 
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		//Select the content
		userPage.selectcontent2();
		 
		//Select publish content
		bbPublicContentPage =  userPage.clickPublishContent();
		 
		//Select Add WP tool
		bbPublicContentPage.selectAddWPTool();
		 
		//Get the changed order of the links
		bbPublicContentPage.getToolsLinkChangedOrder();
		
		//Validate the default order links and changed order links
		bbPublicContentPage.validateBBWileyToolsLinksOrder();
		 
		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
		 
		/***************************************************Pre-condition - Test Case E4-120(112)************************************************************/
		 
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
		 
		ltiContentDiscoveryContentLinksPage.deleteContent(dataMap);

		//Clear the cookies
		Browser.clearAllCookies(driver);
		 
		//Close the driver
		Browser.closeDriver(driver);
			 
		/***************************************************Test Case E4-120: BB Instructor - Content Discovery - Content link deleting************************************************************/
		 
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);	 
		 
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		userPage = home.BBInstructorLogin(dataMap);		 
		 
		//Select the course
		userPage.selectCourseName(dataMap);
		 
		//Select the content
		userPage.selectcontent2();
		 
		//Select publish content
		bbPublicContentPage =  userPage.clickPublishContent();
		 
		//Select Add WP tool
		bbPublicContentPage.selectAddWPTool();
		 
		//Validate the content link is deleted
		bbPublicContentPage.validateDeleteAddContentLink(dataMap);

	}
}