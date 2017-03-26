package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
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
import Pages.WPBlackboardIntegration.LTIConfigurationBlackboardConsumersPage;
import Pages.WPBlackboardIntegration.LTIConfigurationPage;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test(dataProvider="BBoardConsumers",dataProviderClass=staticProviderClass.class)
public class LTIConfigurationBlackboardConsumers {
	
	public void validateLtiConfigurationBlackBoardconsumerFucntionality(Map<String,String> dataMap)throws MalformedURLException, Exception{
		
		ResultUtil.createReport("LTIConfigurationBlackboardConsumers-validateLtiConfigurationBlackBoardconsumerFucntionality", dataMap);
			
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), dataMap.get("AdminURL"));
		
		/***************************************************Login-Page************************************************************/
		
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
		 
		/*********************************Test Case E4-221: LTI new tab "Blackboard Consumers" screen*****************************************/
		 
		//Go to Blackboard consumers tab
		LTIConfigurationBlackboardConsumersPage ltiConfigurationBlackboardConsumersPage =  ltiConfigurationPage.goToBlackboardConsumersSubTab();
		 
		//Blackboard consumers 
		ltiConfigurationBlackboardConsumersPage.blackboardConsumersHomePage();
		 
		ltiConfigurationBlackboardConsumersPage.validateBlackboardConsumerTable(dataMap);
		 
		//Blackboard GUI validation
		ltiConfigurationBlackboardConsumersPage.blackboardConsumersGUIvalidation(dataMap);
		 
		/******************************Test Case E4-223: Auto Grade Refresh Actions**********************************************************/
		 
		//Click "View all" link
		ltiConfigurationBlackboardConsumersPage.selectViewAllLink();
		 
		//Enter the start date and end date
		ltiConfigurationBlackboardConsumersPage.enterCalendarData(dataMap);
		 
		//Click Show button
		ltiConfigurationBlackboardConsumersPage.clickShowButton();
		 
		//Validate the auto grade data
		ltiConfigurationBlackboardConsumersPage.validateViewCompletedAutoGradeRefresh(dataMap);
		 
		//Back to LTI consumer page
		ltiConfigurationBlackboardConsumersPage.gotoLTIBlackBoardConsumerScreen();
		 
		//Click "Block All" link
		ltiConfigurationBlackboardConsumersPage.selectBlockAllLink();
		 
		//Block alert message
		ltiConfigurationBlackboardConsumersPage.blockAllBlockedMessage();
		 
		//Click Allow all link
		ltiConfigurationBlackboardConsumersPage.selectAllowAllLink();
		 
		//Validate the text
		ltiConfigurationBlackboardConsumersPage.allowedMessage();
		 
		/**************************Test Case E4-226: Auto Grade Refresh Actions, elements pop-up window*******************************************/
		 
		//Click "View" link for a consumer
		ltiConfigurationBlackboardConsumersPage.selectConsumerViewLink(dataMap);
		 
		//Validate view popup GUI
		ltiConfigurationBlackboardConsumersPage.validateViewPopup(dataMap);
		 
		/******************************Test Case E4-228: Completed Auto Grade Refreshes page elements******************************************/
		
		//Click "View all" link
		ltiConfigurationBlackboardConsumersPage.selectViewAllLink();
		 
		//Enter the start date and end date
		ltiConfigurationBlackboardConsumersPage.enterCalendarData(dataMap);
		 
		//Click Show button
		ltiConfigurationBlackboardConsumersPage.clickShowButton();
		 
		//Validating the table
		ltiConfigurationBlackboardConsumersPage.validateViewCompletedAutoGradeRefresh(dataMap);
		 
		/*******************************************Test Case E4-234: Pagination Control*******************************************************************/
		 
		//Validate the dropdown
		ltiConfigurationBlackboardConsumersPage. validatePaginationLink();
		 
	}
}
