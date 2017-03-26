package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryContentLinksPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryToolsLinksPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="ContentDiscoveryToolsLinks",dataProviderClass=staticProviderClass.class)
public class ContentDiscoveryToolsLinks {

	public void validateLTIContentDiscoveryToolLink(Map<String,String> dataMap)throws MalformedURLException, Exception{
	
		ResultUtil.createReport("ContentDiscoveryContentLinks-validateLTIContentDiscoveryToolLink", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);
		
		/***************************************************Login-Page************************************************************/

		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();	 
		 
		//Navigate to configuration tab
		ConfigurationPage configurationPage =  snapwizHomePage.gotoConfigurationTab();
		 
		//Navigate to LTI content discovery
		LTIContentDiscoveryContentLinksPage ltiContentDiscoveryContentLinksPage = configurationPage.goToLTIContentDiscoverySubTab();
		 
		 /****************************************Test Case E4-925: WP Admin - Content Discovery - Addition Tools Links***************************/
		
		 //Content link page
		 ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		 
		 //Navigate to tools links tab
		 LTIContentDiscoveryToolsLinksPage ltiContentDiscoveryToolsLinksPage =  ltiContentDiscoveryContentLinksPage.goToToolsLinkTab();
		 
		 //Active class home page
		 ltiContentDiscoveryToolsLinksPage.toolsLinkActiveClassHomePage();
		 
		 //Go to add content
		 ltiContentDiscoveryToolsLinksPage.goToAddContent();
		 
		 //Validate add tool link page
		 ltiContentDiscoveryToolsLinksPage.validateAddContenPage(dataMap);
		 
		 //Add Too area values
		 ltiContentDiscoveryToolsLinksPage.addToolAreaValues(dataMap);
		 
		 //Cancel settings
		 ltiContentDiscoveryToolsLinksPage.cancelSettings();
		 
		 //Active class home page
		 ltiContentDiscoveryToolsLinksPage.toolsLinkActiveClassHomePage();
		 
		 //Validate active class table
		 ltiContentDiscoveryToolsLinksPage.validateActiveClassTableOnCancel(dataMap);
		 
		 //Go to add content
		 ltiContentDiscoveryToolsLinksPage.goToAddContent();
		 
		 //Validate add tool link page
  		 ltiContentDiscoveryToolsLinksPage.validateAddContenPage(dataMap);
		 
		 //Add Too area values
		 ltiContentDiscoveryToolsLinksPage.addToolAreaValues(dataMap);
		 
		 //Save settings
		 ltiContentDiscoveryToolsLinksPage.saveSettings();
		 
		 //Validate active class table
		 ltiContentDiscoveryToolsLinksPage.validateActiveClassTable(dataMap);
		 
		 //Get the order of added content link
		 String strAddedToolLinkOrder = ltiContentDiscoveryToolsLinksPage.orderAddedToolLink(dataMap);
		 
		 /*************************************Test Case E4-933: WP Admin - Content Discovery - Edition Tools Links**********************************/
		 
		 //Click Tool link name to edit
		 ltiContentDiscoveryToolsLinksPage.editToolLink(dataMap);
		 
		 //Edit tool link values
		 ltiContentDiscoveryToolsLinksPage.editToolLinkValues(dataMap);
		 
		 //Cancel settings
		 ltiContentDiscoveryToolsLinksPage.cancelSettings();
		  
		 //Validate active classs table after edit
		 ltiContentDiscoveryToolsLinksPage.validateEditToolsLinkTableOnCancel(dataMap);
		  
		 //Active class home page
		 ltiContentDiscoveryToolsLinksPage.toolsLinkActiveClassHomePage();
		  
		 //Tool link name to edit
		 ltiContentDiscoveryToolsLinksPage.editToolLink(dataMap);
		  
		 //Edit tool link values
		 ltiContentDiscoveryToolsLinksPage.editToolLinkValues(dataMap);
		
		 //Save settings
		 ltiContentDiscoveryToolsLinksPage.saveSettings();
		  
		 //Validate active classs table after edit
		 ltiContentDiscoveryToolsLinksPage.validateEditToolsLinkTable(dataMap);
		  
		 //Get the order of edited tool link
		 String strEditedToolLinkOrder =  ltiContentDiscoveryToolsLinksPage.orderEditedToolLink(dataMap);
		  
		  /************************************Test Case E4-943: WP Admin - Content Discovery - Re-ordering Tools Links*******************************/
		  
		 //Reordering functionality
		 ltiContentDiscoveryToolsLinksPage.toolLinkReordering(dataMap,strAddedToolLinkOrder,strEditedToolLinkOrder);
		  
		 /************************************Test Case E4-946: WP Admin - Content Discovery - Deleting Tools Links***********************************/
		
	}
}
