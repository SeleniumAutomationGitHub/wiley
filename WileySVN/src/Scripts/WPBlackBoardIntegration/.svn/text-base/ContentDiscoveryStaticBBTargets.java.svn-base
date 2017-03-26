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
import Pages.WPBlackboardIntegration.LTIContentDiscoveryStaticTargetPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="ContentDiscoveryStaticBBTargets",dataProviderClass=staticProviderClass.class)
public class ContentDiscoveryStaticBBTargets {

	public void validateLTIStaticTargets(Map<String,String> dataMap)throws MalformedURLException, Exception{
	
		ResultUtil.createReport("ContentDiscoveryStaticBBTargets-validateLTIStaticTargets", dataMap);
		
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
		 
		 /****************************************Test Case E4-937:  WP Admin - Content Discovery - Edition Static BB Targets***************************/
		
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
		 
		 //Cancel the settings
		 ltiContentDiscoveryStaticTargetPage.cancelSettings();
		 
		 //Static target home page
		 ltiContentDiscoveryStaticTargetPage.staticTargetHomePage();
		 
		 //Select any static target link
		 ltiContentDiscoveryStaticTargetPage.selectStaticTargetLink(dataMap);
		 
		 //Change the url
		 ltiContentDiscoveryStaticTargetPage.changeUrl(dataMap);
		 
		 //Save the settings
		 ltiContentDiscoveryStaticTargetPage.saveSettings();
		 
		 //Validate the table after changing the url
		 ltiContentDiscoveryStaticTargetPage.validateEditChangeUrlTable(dataMap);
		 
		 //Static home page
		 ltiContentDiscoveryStaticTargetPage.staticTargetHomePage();
		 
		 //Select static target link
		 ltiContentDiscoveryStaticTargetPage.selectStaticTargetLink(dataMap);
		 
		 //Revert back the url
		 ltiContentDiscoveryStaticTargetPage.revertUrl(dataMap);
		 
		 //Save setttings
		 ltiContentDiscoveryStaticTargetPage.saveSettings();
		 
		 //Validate the table
		 ltiContentDiscoveryStaticTargetPage.validaterevertChangeUrlTable(dataMap);
		 
		 /*******************Test Case E4-218: Static BB Targets screen page elements***********************************************************/
		
		 //Auto refresh screen
		 ltiContentDiscoveryStaticTargetPage.staticBBTargetsAutoRefresh(dataMap);
		 
		 //Auto refresh edit screen
		 ltiContentDiscoveryStaticTargetPage.staticBBTargetsAutoRefreshEditContent(dataMap);
		 
		//Cancel the settings
		 ltiContentDiscoveryStaticTargetPage.cancelSettings();
	}
}
