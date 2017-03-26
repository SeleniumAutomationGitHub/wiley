package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwizSubDomainPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPropertiesPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIConfigurationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

public class LTIConfigurationGUIValidation {

	WebDriver driver = null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="LTIConfigurationGUIValidation",dataProviderClass=staticProviderClass.class)
	public LTIConfigurationGUIValidation(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	

	@Test
	public void ltiConfiguration_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("LTIConfigurationGUIValidation-validateLtiGUIConfigurationFucntionality", dataMap);		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strWPADMIN_URL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strWPADMIN_URL);

		//Login
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = snapwizloginPage.snapLogin(dataMap);

		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();	 

		//Navigate to configuration tab
		ConfigurationPage configurationPage =  snapwizHomePage.gotoConfigurationTab();

		//Navigate to LTI sub tab
		LTIConfigurationPage ltiConfigurationPage = configurationPage.goToLTISubTab();

		//Validate LTI configuration home page
		ltiConfigurationPage.LTIConfigurationDefaultPage();

		driver=ltiConfigurationPage.getDriver();
	}

	/*****************************Test Case E4-1: LTI conf - "LTI Configuration" tab. GUI, page elements****************************/

	@Test 
	public void E4_1()
	{		
		ResultUtil.report("INFO", "LTIConfigurationGUIValidation>E4_1", driver);

		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Navigate to LTI configuration page
		//ltiConfigurationPage.goToLTIConfigurationLTISubTab();

		//Validate the LTI configuration GUI page
		ltiConfigurationPage.validateLTIConfigurationGUIPage(dataMap);		
	}

	/***************************** Test Case E4-4: LTI conf - "Create New Consumer" tab. GUI, page elements****************************/

	@Test 
	public void E4_4()
	{
		ResultUtil.report("INFO", "LTIConfigurationGUIValidation>E4_4", driver);

		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);	

		//Click Add new consumers button
		ltiConfigurationPage.goToAddNewConsumers();

		//Validate the create new consumers GUI
		ltiConfigurationPage.validateCreateNewConsumerGUI();
	}

	/******************************Test Case E4-1680: LTI conf - "Edit Consumer" tab. GUI, page elements******************************/

	@Test
	public void E4_1680()
	{
		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Check one consumer in the Integrated Consumers
		ltiConfigurationPage.integratedConsumers(dataMap);

		//Select Edit link in any of the consumers
		ltiConfigurationPage.selectEditLink();

		//Validate the Edit new consumers GUI
		ltiConfigurationPage.validateEditNewConsumerGUI();
	}

	/***************************Test Case E4-5: LTI conf - "Create New Consumer" tab. Input fields restrictions************************/

	@Test
	public void E4_5()
	{
		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);		

		//Click Add new consumers button
		ltiConfigurationPage.goToAddNewConsumers();

		//No value is entered
		ltiConfigurationPage.noValueInputFieldrestriction(dataMap);

		//Enter exisiting consumers validation
		ltiConfigurationPage.exisitingConsumerInputFieldRestriction(dataMap);

		//Special characters input in consumer textbox
		ltiConfigurationPage.specialCharactersInputFieldRestriction(dataMap);

		//Special characters input in other textboxes
		ltiConfigurationPage.specialCharactersOtherInputFieldRestriction(dataMap);

		//Empty Space validation
		ltiConfigurationPage.emptySpaceCharacters();
	}

	/***************************Test Case E4-7: LTI conf - "Create New Consumer" tab. Email validity************************/

	@Test
	public void E4_7()
	{
		LTIConfigurationPage ltiConfigurationPage =  PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Click Add new consumers button
		ltiConfigurationPage.goToAddNewConsumers();

		//Validate Email address format
		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress1");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress2");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress3");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress4");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress5");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress6");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress7");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress8");

		ltiConfigurationPage.validateEmailAddressFormat(dataMap,"InvalidTestEmailAddress9");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress1");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress2");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress3");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress4");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress5");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress6");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress7");

		ltiConfigurationPage.validateValidEmailAddressFormat(dataMap, "ValidTestEmailAddress8");

	}

}
