//Test Case E4-326: WP-BB Int - Finished class: GetWileyPlusTools (BB interface)

//Test Case E4-328: WP-BB Int - Finished class. Content access > Gradebook. Instructors. 
//Test Case E4-336: WP-BB Int - Finished class: user's FirstName/LastName update



package Scripts.WPBlackBoardIntegration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.LMSIntegration.InstructorPage;

import Pages.MapleGraph.MapleGraphPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoveryContentLinksPage;
import Pages.WPBlackboardIntegration.LTIContentDiscoverySupportHelpPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;

@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
public class BBWPIntFinishedclassLTITarget {
	
	/************************Test Case E4-328: WP-BB Int - Finished class. Content access > Gradebook. Instructors ***********************************************/
	public void E4_328(Map<String,String> dataMap) throws Exception{
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPAssignmentsDetails-GradeBookIntegrationBB",dataMap);
	
		
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
			
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);
		
		//select ag test course 1
		blackBoardIntegrationPage.selectCourseName2(dataMap);
		//select wiley plus
		blackBoardIntegrationPage.contentTools();
		
		blackBoardIntegrationPage.clickGradebook();
			//click on gradebook
		blackBoardIntegrationPage.returnToBlackboard();
		
		//close the browser
		blackBoardIntegrationPage.closeBrowser();
}

	/************************Test Case E4-326: WP-BB Int - Finished class: GetWileyPlusTools (BB interface)***********************************************/
	public void E4_326(Map<String,String> dataMap) throws Exception{
		
	
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);
		
		blackBoardIntegrationPage.selectCourseName3(dataMap);
		
		blackBoardIntegrationPage.tools();
		
		blackBoardIntegrationPage.wileyplus();
		
		blackBoardIntegrationPage.wPGBLinkArchive();
		
		blackBoardIntegrationPage.closeBrowser();
}



	/************************Test Case E4-336: WP-BB Int - Finished class: user's FirstName/LastName update***********************************************/
	public void E4_336(Map<String,String> dataMap) throws Exception{
	
		

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");
	
		ResultUtil.createReport("BBWPIntUpdateFirstLastName-E4_336", dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
			
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
				
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);
		
		blackBoardIntegrationPage.personalInfo();

		//select wiley plus
		blackBoardIntegrationPage.enterPersonalInfo();
		
		
		//close the browser
		
		blackBoardIntegrationPage.closeBrowser();
}



}