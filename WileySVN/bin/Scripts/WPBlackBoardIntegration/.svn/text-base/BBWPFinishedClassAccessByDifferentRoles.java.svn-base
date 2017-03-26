//Test Case E4-326: WP-BB Int - Finished class: GetWileyPlusTools (BB interface)
//Test Case E4-327: WP-BB Int - Finished class: wp4-finishSection LTI target
//Test Case E4-328: WP-BB Int - Finished class. Content access > Gradebook. Instructors. 
//Test Case E4-329: WP-BB Int - Finished class. Content access > Other. Instructors. 
//Test Case E4-330: WP-BB Int - Finished class. Content access > Gradebook. Students. 
//Test Case E4-331: WP-BB Int - Finished class. Content access > Other. Students. 

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
public class BBWPFinishedClassAccessByDifferentRoles {

	/******************************************Test Case E4-326:***********************/
	public void E4_326(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-326");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPFinishedClassAccessByDifferentRoles-E4_326",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//ag test course3
		blackBoardIntegrationPage.selectCourseName3(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.wileyplus();

		//click on wp link diagnostic
		blackBoardIntegrationPage.wPLinkDiagnostic();

		//click on wp link roster
		blackBoardIntegrationPage.wPLinkRoster();

		//click on wp link help
		blackBoardIntegrationPage.wPLinkHelp();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}



	/******************************************Test Case E4-327-1:***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_327_1(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-327-1");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPFinishedClassAccessByDifferentRoles-E4_327_1",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//select kunals course from xl input
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		//click on gradebook
		blackBoardIntegrationPage.wileyplus();

		blackBoardIntegrationPage.wPFinishedClass();

		blackBoardIntegrationPage.verifyFinishClass();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}

	/******************************************Test Case E4-327-2***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_327_2(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-327-2");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPFinishedClassAccessByDifferentRoles-E4_327_2",dataMap);

		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//login
		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//select ag test course 2 from input xl sheet
		blackBoardIntegrationPage.selectCourseName3(dataMap);

		//click on toools
		blackBoardIntegrationPage.tools();

		//click on wiley plus
		blackBoardIntegrationPage.wileyplus();

		blackBoardIntegrationPage.clickWPRSP();

		blackBoardIntegrationPage.closeBrowser();

	}

	/******************************************Test Case E4-328-1:***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_328_1(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-328-1");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPFinishedClassAccessByDifferentRoles-E4_328_1",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		blackBoardIntegrationPage.selectCourseName2(dataMap);

		blackBoardIntegrationPage.contentTools();

		blackBoardIntegrationPage.wileyplusGB();

		blackBoardIntegrationPage.returnToBlackboard();

		blackBoardIntegrationPage.clickTotalScore();

		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}

	/******************************************Test Case E4-328-2***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_328_2(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-328-2");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPStudentPersonalInformation-E4_328_2",dataMap);

		//Launch URL	
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//click on login
		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//slect the ag test course 2 from input sheet
		blackBoardIntegrationPage.selectCourseName3(dataMap);

		blackBoardIntegrationPage.selectsmallercasecontent();

		//click on finish total scode
		blackBoardIntegrationPage.clickFinishTotalScore();

		blackBoardIntegrationPage.closeBrowser();

	}

	/******************************************Test Case E4-329:***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_329(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-329");

		ResultUtil.createReport("BBWPStudentPersonalInformation-E4_329",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");

		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//login
		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//select ag test course for testing
		blackBoardIntegrationPage.selectCourseName3(dataMap);

		//select smaller ocntent
		blackBoardIntegrationPage.selectsmallercasecontent();

		//click on wp assignments
		blackBoardIntegrationPage.wPAssignments();


		blackBoardIntegrationPage.returnToBlackboard();

		//swtic to parent
		blackBoardIntegrationPage.switchtoparent();

		//click on wp rsp
		blackBoardIntegrationPage.clickWPRSP();

		//click on return to black board button
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}


	/******************************************Test Case E4-330:***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_330_1(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("BBWPStudentPersonalInformation-E4_330_1",dataMap);

		System.out.println("E4-330-1");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		//select the course from tools
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//click on content tools
		blackBoardIntegrationPage.contenttools();

		//click on wiley pplus gb
		blackBoardIntegrationPage.wileyplusGB();

		//click on return black board
		blackBoardIntegrationPage.returnToBlackboard();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();


	}


	/******************************************Test Case E4-330-2***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_330_2(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-330-2");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBWPFinishedClassAccessByDifferentRoles-E4_330_2",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		//select course from input xl sheet
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//click on content assignments
		blackBoardIntegrationPage.contentAssignments();

		//click on wiley plus practice
		blackBoardIntegrationPage.wileyPlusPractice();

		//verify the finish error
		blackBoardIntegrationPage.Finisherror();

		//return the black board button
		blackBoardIntegrationPage.returnToBlackboard();

		//close the broswer
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-331***********************/
	@Test(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public void E4_331(Map<String,String> dataMap) throws Exception{

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		System.out.println("E4-331");

		ResultUtil.createReport("BBWPFinishedClassAccessByDifferentRoles-E4_331",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//login
		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		//select hobekon course from xl sheet
		blackBoardIntegrationPage.selectCourseName(dataMap);

		//select the content
		blackBoardIntegrationPage.selectcontent();

		//click on wp assignments
		blackBoardIntegrationPage.wPAssignments();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();

	}
}