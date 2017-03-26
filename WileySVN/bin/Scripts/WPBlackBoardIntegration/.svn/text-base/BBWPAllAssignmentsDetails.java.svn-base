//Test Case E4-140: WP Assignment one student - all assignments
//Test Case E4-141: WP Assignment Details
//Test Case E4-148: Gradebook Integration - Question assignment column in GC
//Test Case E4-149: Gradebook Integration - Mastery Assignment column in GC

package Scripts.WPBlackBoardIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;


public class BBWPAllAssignmentsDetails {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="BlackBoard",dataProviderClass=staticProviderClass.class)
	public BBWPAllAssignmentsDetails(Map<String,String> dataMap)
	{

		this.dataMap=dataMap;

	}

	public void BBWPAllAssignmentsDetailsPrerequiste() throws Exception{


		ResultUtil.createReport("BBWPAllAssignmentsDetails-BBWPAllAssignmentsDetailsPrerequiste", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".BB_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		//Login
		BlackBoardIntegrationPage Login =PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		BlackBoardIntegrationPage blackBoardIntegrationPage =Login.BBInstructorLogin(dataMap);


		//Navigate to instructor page
		driver=blackBoardIntegrationPage.getDriver();
	}


	@Test
	public void E4_140() throws Exception{

		ResultUtil.createReport("BBWPAssignmentsDetails-E4_140",dataMap);

		//luanch url	
		BBWPAllAssignmentsDetailsPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//select kunals
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//click on tools
		blackBoardIntegrationPage.tools();

		//select wiley plus
		blackBoardIntegrationPage.wileyplus();

		//click on gradebook
		blackBoardIntegrationPage.wileyplusGB();

		//verify the help link
		blackBoardIntegrationPage.verifyhelplink();

		//verify the sys announcements
		blackBoardIntegrationPage.verifysystemannouncement();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-141: Test Case E4-141: WP Assignment Details***********************/
	@Test
	public void E4_141() throws Exception{

		ResultUtil.createReport("BBWPAssignmentsDetails-E4_141",dataMap);


		//launch the url from pre-requisite methods
		BBWPAllAssignmentsDetailsPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//select kunals
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		blackBoardIntegrationPage.tools();

		//select wiley plus
		blackBoardIntegrationPage.wileyplus();

		//click on gradebook
		blackBoardIntegrationPage.wileyplusGB();

		//verify the help link
		blackBoardIntegrationPage.verifyhelplink();

		//verify the sysannouncements
		blackBoardIntegrationPage.verifysystemannouncement();

		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-148: Gradebook Integration - Question assignment column in GC***********************/
	@Test
	public void E4_148() throws Exception{


		ResultUtil.createReport("BBWPAssignmentsDetails-E4_148",dataMap);

		//launch the url
		BBWPAllAssignmentsDetailsPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);


		//select kunals
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		//select wiley plus
		blackBoardIntegrationPage.tools();

		//click on wiley plus
		blackBoardIntegrationPage.wileyplus();

		//click on gradebook
		blackBoardIntegrationPage.wileyplusGB();

		//verify the link
		blackBoardIntegrationPage.verifyhelplink();

		blackBoardIntegrationPage.verifysystemannouncement();
		//close the browser
		blackBoardIntegrationPage.closeBrowser();
	}

	/******************************************Test Case E4-149: Gradebook Integration - Mastery Assignment column in GC***********************/
	@Test
	public void E4_149() throws Exception{


		ResultUtil.createReport("BBWPAssignmentsDetails-E4_149",dataMap);

		//launching the url from pre-requisite
		BBWPAllAssignmentsDetailsPrerequiste();

		BlackBoardIntegrationPage blackBoardIntegrationPage=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//select kunals course for testing from input sheet
		blackBoardIntegrationPage.selectCourseName4(dataMap);

		blackBoardIntegrationPage.clickGradecenter();

		//select wiley plus
		blackBoardIntegrationPage.clickassignments();

		//click on gradebook

		blackBoardIntegrationPage.closeBrowser();
	}



}