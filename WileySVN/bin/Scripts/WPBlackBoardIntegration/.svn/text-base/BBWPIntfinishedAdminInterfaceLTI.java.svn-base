//Test Case E4-335: WP-BB Int - Finished class: Admin Interface - Tools Links
//Test Case E4-338: WP-BB Int - Finished class: Admin Interface - Support Tools Links

package Scripts.WPBlackBoardIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryContentLinksPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoverySupportHelpPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
public class BBWPIntfinishedAdminInterfaceLTI {

	/**********************************************Test Case E4-335: WP-BB Int - Finished class: Admin Interface - Tools Links******************************/
	public void AdminInterfaceToolsLinks(Map<String,String> dataMap) throws Exception{
	
		System.out.println(" E4-335");
	
		ResultUtil.createReport("BBWPIntFinishClassSupportTools-AdminInterfaceToolsLinks",dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
			
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
					
		BlackBoardIntegrationPage wpAdminPage = home.WPAdminLogin(dataMap);
			
		wpAdminPage.selectconfiguaration();
		
		wpAdminPage.selectLTIContent();
		
		wpAdminPage.selectToolsLink();
		
		wpAdminPage.selectFinishedClass();
		
		wpAdminPage.selectAdminWileyPLus();
		
		Browser.closeDriver(driver);
		
		Browser.clearAllCookies(driver);
				 
	}
	
	/**********************************************Test Case E4-338: WP-BB Int - Finished class: Admin Interface - Support Tools Links******************************/
	public void AdminInterfaceSupportTools(Map<String,String> dataMap) throws Exception{
	
		System.out.println(" E4-338");
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		ResultUtil.createReport("BBWPIntFinishClassSupportTools-AdminInterfaceSupportTools", dataMap);
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
			
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
					
		BlackBoardIntegrationPage wpAdminPage = home.BBAdminLogin(dataMap);
			
		wpAdminPage.selectconfiguaration();
		
		wpAdminPage.selectLTIContent();
		
		wpAdminPage.elmntSupportHelp();
		
		wpAdminPage.selectFinishedClass();
		
		wpAdminPage.selectAdminWileyPLus();
		
		
		Browser.closeDriver(driver);
		 
		Browser.clearAllCookies(driver);
				
				
			
				 
	}
}
