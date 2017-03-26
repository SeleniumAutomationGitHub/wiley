package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.PropertyUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class BlackboardEula {
	WebDriver driver = null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="BlackboardEULA",dataProviderClass=staticProviderClass.class)
	public BlackboardEula(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	public WebDriver BBLogin_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("BlackboardEula-BBLogin_Prerequisite", dataMap);	
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
		return driver;
	}
	
	/**********************************************Test Case E4-5538: WP-SW Int - EULA. Integrated - instructor****************************************************************/
	@Test
	public void E4_5538() throws Exception
	{	
		BBLogin_Prerequisite();
		ResultUtil.report("INFO", "BlackboardEula>E4_5538", driver);
		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBInstructorLogin(dataMap);

		//Eula welcome page
		blackBoardIntegrationPage.bbEulaWelcomePage();

		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		

		//Go to tools link
		blackBoardIntegrationPage.tools();

		//Go to Wileuplus link
		blackBoardIntegrationPage.wileyplus();			

		//Click "Wiley plus ready study" link
		blackBoardIntegrationPage.goToWileyPlusReadStudy();

		//Accept privacy information
		blackBoardIntegrationPage.acceptPrivacyInformation();

		//Validate the instructor Eula
		blackBoardIntegrationPage.bbInstructorEula();

		//Clear cookies
		Browser.clearAllCookies(driver);

		//Close the browser
		Browser.closeDriver(driver);
	}

	/**********************************************Test Case E4-5539: WP-SW Int - EULA. Integrated - student****************************************************************/

	@Test
	public void E4_5539 () throws Exception
	{
		ResultUtil.report("INFO", "BlackboardEula>E4_5539", driver);

		BBLogin_Prerequisite();

		BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);

		//Login into Student
		BlackBoardIntegrationPage blackBoardIntegrationPage = home.BBStudentLogin(dataMap);

		//Eula welcome page
		blackBoardIntegrationPage.bbEulaWelcomePage();

		//Select the course
		blackBoardIntegrationPage.selectCourseName(dataMap);		

		//Go to tools link
		blackBoardIntegrationPage.tools();

		//Go to Wileuplus link
		blackBoardIntegrationPage.wileyplus();		 

		//Click "Wiley plus ready study" link
		blackBoardIntegrationPage.goToWileyPlusReadStudy();

		//Accept privacy information
		blackBoardIntegrationPage.acceptPrivacyInformation();

		//Validate the instructor Eula
		blackBoardIntegrationPage.bbStudentEula();

		//Clear cookies
		Browser.clearAllCookies(driver);

		//Close the browser
		Browser.closeDriver(driver);

	}	

}