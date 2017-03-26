package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.BlackboardToolsWileyPlusPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test (dataProvider="BBContentDAToolLinks",dataProviderClass=staticProviderClass.class)
public class BBStudentContentDAToolsLinks {
public void validateBBStudentContentDAToolsLinks(Map<String,String> dataMap) throws MalformedURLException, Exception{
		ResultUtil.createReport("BBStudentContentDAToolsLinks-validateBBStudentContentDAToolsLinks", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
	
		/*******************************************************Login as BB admin*****************************************************************/
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage userPage = home.BBAdminLogin(dataMap);
		
		userPage.goToSystemAdmin();
		
		userPage.goToBuildingBlocks();
		
		userPage.goToInstalledTools();
		
		userPage.goToWPIBlackboardSettings();
		
		userPage.validateWileyPlusWindowSettings();
		
		Browser.clearAllCookies(driver);
		
		Browser.closeDriver(driver);

		/******************************************Test Case E4-100: WP-BB Int - Content D&A - Tools links (student) - General***********************/
		
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		
		userPage = home.BBStudentLogin(dataMap);
		
		userPage.selectCourseName(dataMap);
		
		userPage.tools();
		
		BlackboardToolsWileyPlusPage blackboardToolsWileyPlusPage = userPage.wileyplus();
		
		blackboardToolsWileyPlusPage.validateStudentToolLinks();
		
		/**********************************Test Case E4-109: WP-BB Int - Content D&A - Tools links (student) - Learn More About WileyPLUS*******************/
		
		blackboardToolsWileyPlusPage.selectLearnMoreWileyplus();
		
		blackboardToolsWileyPlusPage.swtichToLearnMoreWP();
		
		/*********************************Test Case E4-110: WP-BB Int - Content D&A - Tools links (student) - WP Help & Support****************************/
		
		blackboardToolsWileyPlusPage.selectHelpAndSupport();
		
		blackboardToolsWileyPlusPage.swtichToHelpAndSupport();
	}
}
