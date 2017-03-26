/*//Test Case E4-179: Smart Content Refresh. Re-assign assignment
//Test Case E4-181: Smart Content Refresh. Restore assignment
//Test Case E4-180: Smart Content Refresh. Delete assignment
//Test Case E4-192: Student accesses broken assignments links in the same course
package Scripts.WPBlackBoardIntegration;
import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.AssignmentsDataProviderUtil.staticProviderClass;
import Util.WPBlackboardIntegrationDataProviderUtil;
import Util.LMSMGDataProviderUtil;

@Test(dataProvider="BlackBoard",dataProviderClass=Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass.class)
public class BBSmartContentRefreshUsecasesTestSuite {

	*//*********TO DO PENDING*********************************Test Case E4-180: Smart Content Refresh. Delete assignment***********************//*
	public void E4_180(Map<String,String> dataMap) throws Exception{

		System.out.println("E4-180");

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		ResultUtil.createReport("BBSmartContentRefreshUsecasesTestSuite-E4_180",dataMap);

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//selecting kunals course
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.wileyplus();

		//click on gradebook
		blackBoardIntegrationPage.smartContent();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}


	*//******************************************Test Case E4-179: Smart Content Refresh. Re-assign assignment***********************//*
	public void E4_179(Map<String,String> dataMap) throws Exception{


		ResultUtil.createReport("BBSmartContentRefreshUsecasesTestSuite-E4_179",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//select kunals course
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.wileyplus();

		//click on gradebook
		blackBoardIntegrationPage.smartContent();

		blackBoardIntegrationPage.SubmitRefresh();

		blackBoardIntegrationPage.smartContent();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	*//******************************************Test Case E4-181: Smart Content Refresh. Restore assignment***********************//*
	public void E4_181(Map<String,String> dataMap) throws Exception{


		ResultUtil.createReport("BBSmartContentRefreshUsecasesTestSuite-E4_181",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBInstructorLogin(dataMap);

		//select kunals course
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		blackBoardIntegrationPage.wileyplus();

		//click on gradebook
		blackBoardIntegrationPage.smartContent();

		//close the browser
		blackBoardIntegrationPage.SubmitRefresh();

		blackBoardIntegrationPage.closeBrowser();
	}

	*//******************************************Test Case E4-192: Student accesses broken assignments links in the same course***********************//*
	public void E4_192(Map<String,String> dataMap) throws Exception{


		ResultUtil.createReport("BBSmartContentRefreshUsecasesTestSuite-E4_192",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		blackBoardIntegrationPage.BBStudentLogin(dataMap);

		//select hoboken test course
		blackBoardIntegrationPage.selectCourseName(dataMap);

		//select course
		blackBoardIntegrationPage.selectcontent();

		//select wiley plus
		blackBoardIntegrationPage.wileyplusassign();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}


}*/