package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.WPBlackboardIntegration.ConfigurationPage;
import Pages.WPBlackboardIntegration.LTIConfigurationPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

public class CreateEditDeleteConsumers {

	WebDriver driver = null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="CreateEditDeleteConsumers",dataProviderClass=staticProviderClass.class)
	public CreateEditDeleteConsumers(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	

	@Test
	public void validateAddEditDeleteConsumers()throws MalformedURLException, Exception
	{
		ResultUtil.createReport("CreateEditDeleteConsumers-validateAddEditDeleteConsumers", dataMap);
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

	/***********************************************Test Case E4-2: LTI conf - Add new consumer**********************************/

	@Test
	public void E4_2()
	{
		ResultUtil.report("INFO", "CreateEditDeleteConsumers>E4_1", driver);

		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Click Add new consumers button
		ltiConfigurationPage.goToAddNewConsumers();

		//Create new consumers
		ltiConfigurationPage.createAddConsumers(dataMap);

		//Ok button
		ltiConfigurationPage.selectOkButton();

		ltiConfigurationPage.consumerCreatedSuessStatus(dataMap);

		ltiConfigurationPage.selectLTIconfigurationLink();

		//Validate in integrated table
		ltiConfigurationPage.createdConsumerIntegratedTable(dataMap);

		//Click Go Link
		ltiConfigurationPage.goToEditLink(dataMap);

		//Validate the value
		ltiConfigurationPage.validateCreatedConsumerValue(dataMap);

		//Cancel Button
		ltiConfigurationPage.selectCancelButton();

		//Click Add new consumers button
		ltiConfigurationPage.goToAddNewConsumers();

		//Enter new consumers name
		ltiConfigurationPage.editConsumer(dataMap);

		//Cancel Button
		ltiConfigurationPage.selectCancelButton();

		//Validate LTI configuration home page
		ltiConfigurationPage.LTIConfigurationDefaultPage();

		//Validate the value
		ltiConfigurationPage.createdConsumerIntegratedTable(dataMap);
	}

	/***********************************Test Case E4-217: Auto Grade Refresh Parameters*********************************************************/

	@Test
	public void E4_217()
	{
		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Go to view details link
		ltiConfigurationPage.goToViewDetailsLink(dataMap);

		//Validate the view detail screen
		ltiConfigurationPage.validateViewDetailsScreen();

		//Back to LTI configuration
		ltiConfigurationPage.goToLTIConfigurationLTISubTab();
	}	 

	/*********************************************************Test Case E4-8: LTI conf - Edit consumer**************************************************/

	@Test
	public void E4_8()
	{
		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Check one consumer in the Integrated Consumers
		ltiConfigurationPage.integratedConsumers(dataMap);

		//Click Go Link
		ltiConfigurationPage.goToEditLink(dataMap);

		//Enter Edit consumers value
		ltiConfigurationPage.editConsumer(dataMap);

		//Ok button
		ltiConfigurationPage.selectOkButton();

		ltiConfigurationPage.consumerEditedSuessStatus(dataMap);

		ltiConfigurationPage.selectLTIconfigurationLink();

		//Edit Integrated table
		ltiConfigurationPage.editedConsumerIntegratedTable(dataMap);

		//Click edit link of edited consumer
		ltiConfigurationPage.goToEditedConsumerEditLink(dataMap);

		//Enter consumer edit value
		ltiConfigurationPage.createAddConsumers(dataMap);

		//Cancel Button
		ltiConfigurationPage.selectCancelButton();

		//Validate LTI configuration home page
		ltiConfigurationPage.LTIConfigurationDefaultPage();
	}

	/*********************************************************Test Case E4-6: LTI conf - Delete consumer**********/

	@Test
	public void E4_6() throws Exception  
	{
		LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

		//Click Delete link
		ltiConfigurationPage.goToDeleteLink(dataMap);

		//Cancel the alert
		ltiConfigurationPage.dismissAlertHandling();

		//Click Delete link
		ltiConfigurationPage.goToDeleteLink(dataMap);

		//Cancel the alert
		ltiConfigurationPage.acceptAlertHandling();
	}

}

