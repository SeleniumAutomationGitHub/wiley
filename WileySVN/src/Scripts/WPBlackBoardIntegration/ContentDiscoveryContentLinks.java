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
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="ContentDiscoveryContentLinks",dataProviderClass=staticProviderClass.class)
public class ContentDiscoveryContentLinks {

	public void validateLTIContentDiscovery(Map<String,String> dataMap)throws MalformedURLException, Exception{
		ResultUtil.createReport("ContentDiscoveryContentLinks-validateLTIContentDiscovery", dataMap);
		
		
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
		 
		 /****************************************Test Case E4-916: WP Admin - Content Discovery. Addition Content Links***************************/
		
		 //Content link page
		 ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		 
		 //Navigate to add content
		 ltiContentDiscoveryContentLinksPage.goToAddContent();
		 
		 //Validate the add content page
		 ltiContentDiscoveryContentLinksPage.validateAddContenPage();
		 
		 //Enter values in add content area
		 ltiContentDiscoveryContentLinksPage.addContentAreaValues(dataMap);
		 
		 //Enter cancel button
		 ltiContentDiscoveryContentLinksPage.cancelSettings();
		 
		//validate the content table-**on cancel
		 ltiContentDiscoveryContentLinksPage.validateContentLinkTableOnCancel(dataMap);
		 
		 //Content link page
		 ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		 
		 //Navigate to add content
		 ltiContentDiscoveryContentLinksPage.goToAddContent();
		 
		 //Add content area values
		 ltiContentDiscoveryContentLinksPage.addContentAreaValues(dataMap);
		 
		 //Save the settings
		 ltiContentDiscoveryContentLinksPage.saveSettings();
		 
		 //validate the content table
		 ltiContentDiscoveryContentLinksPage.validateContentLinkTable(dataMap);
		 
		//Get the order of added content link
		 String strAddedContentLinkOrder = ltiContentDiscoveryContentLinksPage.orderAddedContentLink(dataMap);
		 
		 /***************************Test Case E4-929: WP Admin - Content Discovery - Edition Content Links*************************************/
		 
		 //Click Content to edit 
		 ltiContentDiscoveryContentLinksPage.editContentLink(dataMap);
		 
		 //Edit content values
		 ltiContentDiscoveryContentLinksPage.editContentValues(dataMap);
		 
		 //Cancel settings
		 ltiContentDiscoveryContentLinksPage.cancelSettings();
		 
		 //Content link home page
		 ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		 
		 //Validate the edited table-** cancel
		 ltiContentDiscoveryContentLinksPage.validateEditContentLinkTable(dataMap);
		 		 
		 //Edit content link
		 ltiContentDiscoveryContentLinksPage.editContentLink(dataMap);
		 
		 //Edit the content page
		 ltiContentDiscoveryContentLinksPage.editContentValues(dataMap);
		 
		 //Save settings
		 ltiContentDiscoveryContentLinksPage.saveSettings();
		 
		 //Validate the edited table
		 ltiContentDiscoveryContentLinksPage.validateEditContentLinkTable(dataMap);
		 
		 //Get the order of edited tool link
		 String strEditedContentLinkOrder =  ltiContentDiscoveryContentLinksPage.orderEditedContentLink(dataMap);
		 
		 /*****************************Test Case E4-938: WP Admin - Content Discovery - Re-ordering Content Links******************************/
		 
		 //Validate the order
		 ltiContentDiscoveryContentLinksPage.ContentLinkReordering(dataMap,strAddedContentLinkOrder,strEditedContentLinkOrder);
		 
		 /**************************Test Case E4-945: WP Admin - Content Discovery - Deleting Content Links***********************************/
		 
	}
}
