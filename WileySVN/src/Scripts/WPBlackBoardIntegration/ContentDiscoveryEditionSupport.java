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
import Pages.WPBlackboardIntegration.LTIContentDiscoverySupportHelpPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryToolsLinksPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="ContentDiscoverySupportHelp",dataProviderClass=staticProviderClass.class)
public class ContentDiscoveryEditionSupport {

	public void validateLTISupportHelp(Map<String,String> dataMap)throws MalformedURLException, Exception{
	
		ResultUtil.createReport("ContentDiscoveryEditionSupport-validateLTISupportHelp", dataMap);
		
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
		 
		 /****************************************Test Case E4-935:  WP Admin - Content Discovery - Edition Support/Help Links***************************/
		
		 //Content link page
		 ltiContentDiscoveryContentLinksPage.contentLinksHomePage();
		 
		 //Navigate to support/Help tab
		 LTIContentDiscoverySupportHelpPage ltiContentDiscoverySupportHelpPage =  ltiContentDiscoveryContentLinksPage.goToSupportHelpTab();
		 
		 //Suppot help pahe
		 ltiContentDiscoverySupportHelpPage.SupportHelpHomePage();
		 
		 //Select help link
		 ltiContentDiscoverySupportHelpPage.selectHelpLink(dataMap);
		 
		 //Edit the support column
		 ltiContentDiscoverySupportHelpPage.editContentSupportValues(dataMap);
		 
		 //Cancel settings
		 ltiContentDiscoverySupportHelpPage.cancelSettings();
		 
		 //Validate support/Help table
		 ltiContentDiscoverySupportHelpPage.validateeditContentSupportTableonCancel(dataMap);
		 
		 //Select the help link
		 ltiContentDiscoverySupportHelpPage.selectHelpLink(dataMap);
		 
		 //Edit the support column
		 ltiContentDiscoverySupportHelpPage.editContentSupportValues(dataMap);
		 
		 //save settings
		 ltiContentDiscoverySupportHelpPage.saveSettings();
		 
		 //Validate the support/Help table
		 ltiContentDiscoverySupportHelpPage.validateeditContentSupportTable(dataMap);
		 
	}
}
