

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

import Pages.LMSIntegration.InstructorPage;

import Pages.MapleGraph.MapleGraphPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;


@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
public class StudentAccessBrokenassignLinksCopiedCourse {

	/************************Test Case E4-177: Student accesses broken assignments links in the copied course***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_177(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-177");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPMoveStudents1and2classesActive-E4_177",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.selectcontent();

		blackBoardIntegrationPage.selectStudentWPHomePageLink();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}

	/************************Test Case E4-176: Smart Content Refresh. Assign broken assignments links***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_176(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-176");

		ResultUtil.createReport("SmartContentRefreshassignbrokenlinks-E4_176",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.clickwileyplus();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}

	/************************Test Case E4-173: Instructor accesses WP unassigned assignment via direct links***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_173(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-173");

		ResultUtil.createReport("SmartContentRefreshassignbrokenlinks-E4_173",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.clickwileyplus();

		blackBoardIntegrationPage.wileyplusassign();

		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}

	/************************Test Case E4-178: Instructor accesses WP direct chapter/assignment links in copied Course after modifying Product ID***********************************************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void  E4_178(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-178");

		ResultUtil.createReport("SmartContentRefreshassignbrokenlinks-E4_178",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);

		//select kunals course
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.clickwileyplus();

		blackBoardIntegrationPage.wileyplusassign();

		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}
}