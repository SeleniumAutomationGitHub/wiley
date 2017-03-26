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
public class BBInstructorContentDAToolsLinks {	
public void validateBBInstructorContentDAToolsLinks(Map<String,String> dataMap) throws MalformedURLException, Exception{
		
		ResultUtil.createReport("BBInstructorContentDAToolsLinks-validateBBInstructorContentDAToolsLinks", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBBURL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBBURL);
		
		/*******************************************************Login as BB admin*****************************************************************/
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage userPage = home.BBAdminLogin(dataMap);
		
		//Select System admin link
		userPage.goToSystemAdmin();
		
		//Select building blocks link
		userPage.goToBuildingBlocks();
		
		//Select installed tools link
		userPage.goToInstalledTools();
		
		//Select Wileyplsu integrated settings link
		userPage.goToWPIBlackboardSettings();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);		
	
		/**************************Test Case E4-123: WP-BB Int - Content D&A - Tools Links (instructor) - General**************************************************/
		
		home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
		
		Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBBURL);
		
		userPage = home.BBInstructorLogin(dataMap);
		
		//Select the course
		userPage.selectCourseName(dataMap);
		
		//Select Tools link
		userPage.tools();
		
		//Select the wileyplus link
		BlackboardToolsWileyPlusPage blackboardToolsWileyPlusPage = userPage.wileyplus();
		
		//validate the links in wileyplus page
		blackboardToolsWileyPlusPage.validateContentDAInstructor();
		
		/**************************Test Case E4-132: WP-BB Int - Content D&A - Tools Links (instructor) - Learn More About WileyPLUS**************************************************/
		
		//select Learn More About WileyPLUS 
		blackboardToolsWileyPlusPage.selectLearnMoreWileyplus();
		
		//switch to Learn more window
		blackboardToolsWileyPlusPage.swtichToLearnMoreWP();
		
		/**************************Test Case E4-134: WP-BB Int - Content D&A - Tools Links (instructor) - WP Grade Refresh**************************************************/
		
		//select WileyPLUS Grade Refresh  
		blackboardToolsWileyPlusPage.selectWPGradeRefresh();
		
		//Validate WileyPLUS Grade Refresh
		blackboardToolsWileyPlusPage.validateWPGradeRefresh();		
		
		blackboardToolsWileyPlusPage.cancelSettings();
		
		/**************************Test Case E4-786: WP-BB Int - Content D&A - Tools Links (instructor) - WP Content Refresh**************************************************/
		
		//select WileyPLUS Grade Refresh  
		blackboardToolsWileyPlusPage.selectWPContentRefresh();
		
		//Validate WileyPLUS Grade Refresh
		blackboardToolsWileyPlusPage.validateWPContentRefresh();
		
		//Click cancel button
		blackboardToolsWileyPlusPage.cancelSettings();
		
		/**************************Test Case E4-135: WP-BB Int - Content D&A - Tools Links (instructor) - Update WileyPLUS user Info**************************************************/
		
		//Select update user info
		blackboardToolsWileyPlusPage.selectUpdateWPuserInfo();
		
		//Validate user info page
		blackboardToolsWileyPlusPage.validateUpdateWPuserInfo();
		
		//Return to Blackboard
		blackboardToolsWileyPlusPage.returnToBlackboard();
		
		/**************************Test Case E4-133: WP-BB Int - Content D&A - Tools Links (instructor) - WP Help & Support**************************************************/
		
		blackboardToolsWileyPlusPage.selectHelpAndSupport();
		
		blackboardToolsWileyPlusPage.swtichToHelpAndSupport();
	}
}
