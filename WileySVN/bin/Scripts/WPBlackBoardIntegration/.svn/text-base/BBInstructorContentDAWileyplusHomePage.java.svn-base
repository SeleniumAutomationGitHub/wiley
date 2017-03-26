package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.SnapwizIntegration.BBPublicContentPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.BlackboardToolsWileyPlusPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test (dataProvider="BBContentDAContentLinks",dataProviderClass=staticProviderClass.class)
public class BBInstructorContentDAWileyplusHomePage {
public void validateBBInstructorContentDAWileyPlusHomePage(Map<String,String> dataMap) throws MalformedURLException, Exception{
		
		ResultUtil.createReport("BBInstructorContentDAWileyplusHomePage-validateBBInstructorContentDAWileyPlusHomePage", dataMap);
			
		String strEnv=Prerequsite.configMap.get("ENV");
		String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
		
		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);		
		
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
		
		//Validate wiley plus window settings
		userPage.validateWileyPlusWindowSettings();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);
		
		/******************************************Test Case E4-86: WP-BB Int - Content D&A - Content Links (instructor). WileyPLUS Homepage***********************/
		
		//Login as instructor
		 home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
		 userPage = home.BBInstructorLogin(dataMap);
		 
		//Select Course name
		userPage.selectCourseName(dataMap);
		 
		//Select content 2 link
		userPage.selectcontent2();
		 
		//Select publish content
		BBPublicContentPage bbPublicContentPage =  userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select wiley  plus home page link
		bbPublicContentPage.selectWileyplusHomePage();
		 
		//Validate wiley plus home page
		bbPublicContentPage.validateWileyPlusHomePage();
		 
		//Return to BB
		bbPublicContentPage.returnToBlackboard();
		 
		/***************************************Test Case E4-73: WP-BB Int - Content D&A - Content Links (instructor) - Structure. Upper level****************************/
		 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Validate Wiley plus materials page
		bbPublicContentPage.validateWileyPlusMaterial();
		 
		/*************************************Test Case E4-74: WP-BB Int - Content D&A - Content Links (instructor) - Structure. Tools Content items***************************/
		
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();
		 
		//Validate Add wileyplus tools page
		bbPublicContentPage.validateAddWileyplusToolsPage();
		 
		/**********************************Test Case E4-75: WP-BB Int - Content D&A - Content Links (instructor) - Structure. Readings and Assignments level********************/
		 
		//Cancel settings
		bbPublicContentPage.cancelSettings();
		 
		//Select Add Reading and assignments link
		bbPublicContentPage.selectAddAssignmentsReadings();
		 
		//validate Assignment and reading page
		bbPublicContentPage.validateAddAssignmentReadingPage();
		 
		/**********************************Test Case E4-72: WP-BB Int - Content D&A - Content Links (instructor) - Structure. Chapters Content items*******************************/
		 
		//Select Add Readings and assignments link
		bbPublicContentPage.selectAddWPReadingLink();
		 
		//Wileyplus readingpage
		bbPublicContentPage.validateWPReadingsPage();
		 
		//Select the checkbox in title
		bbPublicContentPage.selectTitleCheckbox();
		 
		//Click Submit button
		bbPublicContentPage.submitSettings();
		 
		//Validate the link
		bbPublicContentPage.validateTitles();
		 
		//Click Return to blackboard
		bbPublicContentPage.returnToBlackboard();
		 
		/*******************************Test Case E4-76: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP Assignments**************************************/
		 
		//Select content 2 link
		userPage.selectcontent2();
		 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();
		 
		//Navigate to assignment page
		bbPublicContentPage.goToWPAssignment();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver);
		 
		//Select the checkbox in wileyplus assignment page
		bbPublicContentPage.selectWPAssignmentLink();
		 
		//Click "Submit" button
		bbPublicContentPage.submitSettings();
		 
		//Select "WileyPLUS Assignment" link in the 
		bbPublicContentPage.selectWileyplusAssignmentLink();
		 
		//Wiley plus home page
		bbPublicContentPage.validateWileyPlusHomePage();
		 
		//Click to return to blackboard button
		bbPublicContentPage.returnToBlackboard();
	
		//Select tools option in top left menu
		userPage.tools();
		 
		//Click "Wiley plus" link in tools page
		BlackboardToolsWileyPlusPage  blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Select "WileyPLUS Assignments" link in wiley plus page
		blackboardToolsWileyPlusPage.selectWileyplusAssignmentLink();
		 
		//Validate return to blackboard button and click on the button
		blackboardToolsWileyPlusPage.returnToBlackboard();
		 
		/******************Test Case E4-77: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP RSP***********************/
		 
		//Select content 2 link
		userPage.selectcontent2();
		 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();

		//Select wileyplus read-Study-Practice link
		bbPublicContentPage.goToWPReadStudyPractice();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver);
		 
		//Select WP Read Study Practice
		bbPublicContentPage.selectWPReadStudyPractice();
		 
		//Click "Submit" button
		bbPublicContentPage.submitSettings();
		 
		//Select WP Read study and practice in Content area
		bbPublicContentPage.selectWileyplusReadStudyPracticeLink();
		 
		//Wiley plus home page
		bbPublicContentPage.validateWileyPlusHomePage();
		 
		//Click to return to blackboard button
		bbPublicContentPage.returnToBlackboard();
	
		//Select tools option in top left menu
		userPage.tools();

		//Click "Wiley plus" link in tools page
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Go to Wileyplus read study practice page
		blackboardToolsWileyPlusPage.selectWileyplusReadStudyPracticeLink();
		 
		//Validate return to blackboard button and click on the button
		blackboardToolsWileyPlusPage.returnToBlackboard();
		 
		/**********************************************Test Case E4-78: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP Gradebook******************************/
		 
		//Select content 2 link
		userPage.selectcontent2();
		 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();
		 
		bbPublicContentPage.goToWPGradebook();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver);
		 
		bbPublicContentPage.selectWPGradebook();
		 
		bbPublicContentPage.submitSettings();
		 
		bbPublicContentPage.selectWileyplusGradebookLink();
		 
		//Wiley plus home page
		bbPublicContentPage.validateWileyPlusHomePage();
		 
		bbPublicContentPage.validateGradebookWileyplus();
		 
		//Click to return to blackboard button
		bbPublicContentPage.returnToBlackboard();
		 
		//Select tools option in top left menu
		userPage.tools();

		//Click "Wiley plus" link in tools page
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Select wiley plus gradebook link in tools page
		blackboardToolsWileyPlusPage.selectWileyplusGradebookLink();
		 
		//Validate return to blackboard button and click on the button
		blackboardToolsWileyPlusPage.returnToBlackboard();
		 
		/**********************************************Test Case E4-79: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP Prepare and Present******************************/
		 
		//Select content 2 link
		userPage.selectcontent2();
 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();
		 
		//click "WileyPLUS Prepare & Present" link 
		bbPublicContentPage.WPPreparePresent();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver);
		 
		//click "WileyPLUS Prepare & Present" check box 
		bbPublicContentPage.selectWPPreparePresent();
		 
		//click Submit button 
		bbPublicContentPage.submitSettings();
		 
		//Click Wiley plus Prepare & Present
		bbPublicContentPage.selectWileyplusPreparePresent();
		 
		//validate Wiley plus Prepare & Present
		bbPublicContentPage.validateWPPreparePresentHomePage();
		 
		//Click to return to blackboard button
		bbPublicContentPage.returnToBlackboard();
		 
		//Select tools option in top left menu
		userPage.tools();

		//Click "Wiley plus" link in tools page
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Select wiley plus Prepare & Present link in tools page
		blackboardToolsWileyPlusPage.selectWileyplusPreparePresent();
		 
		//Validate return to blackboard button and click on the button
		blackboardToolsWileyPlusPage.returnToBlackboard();
		 
		 
		/**********************************************Test Case E4-80: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP Class Section Info******************************/
		 
		//Select content 2 link
		userPage.selectcontent2();
 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();
		 		 
		//click "WileyPLUS Class Section Info" link 
		bbPublicContentPage.WPClassSectionInfo();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver);
		 
		//click "WileyPLUS Class Section Info" check box 
		bbPublicContentPage.selectWPClassSectionInfo();
		 
		//click Submit button 
		bbPublicContentPage.submitSettings();
		 
		//Click Wiley plus Class Section Info
		bbPublicContentPage.selectWileyplusClassSectionInfo();
		 
		//validate Wiley plus Class Section Info
		bbPublicContentPage.validateWPClassSectionInfoHomePage();
		 
		//Click to return to blackboard button
		bbPublicContentPage.returnToBlackboard();
		 
		//Select tools option in top left menu
		userPage.tools();

		//Click "Wiley plus" link in tools page
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Select wiley plus Class Section Info link in tools page
		blackboardToolsWileyPlusPage.selectWileyplusClassSectionInfo();
		 
		//Validate return to blackboard button and click on the button
		blackboardToolsWileyPlusPage.returnToBlackboard();
		
		/**********************************************Test Case E4-81: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP Course Administration******************************/
		
		// pending Sorry! This tool is only accessible to your WileyPLUS Course Administrator.//
		//Select content 2 link
		userPage.selectcontent2();
 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();  
		 
		//click "WileyPLUS Course Administration" link 
		bbPublicContentPage.WPCourseAdministration();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate Course Administration page
		bbPublicContentPage.validateCourseAdministrationpage();
	 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver);
		 
		/**********************************************Test Case E4-82: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. WP System announcements*****************************/
			
		//Select content 2 link
		userPage.selectcontent2();
 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();  
		 
		//click "WileyPLUS System announcements" link 
		bbPublicContentPage.WPSystemannouncements();
		 
		//Handle windows - Navigate to the assignment window
		bbPublicContentPage.handleWindows();
		 
		//Validate the blackboard button is not displayed
		bbPublicContentPage.returnToBlackboardAbsent();
		 
		//Close the assignment page window
		Browser.closeDriver(driver); 
		
		//click "WileyPLUS System announcements" check box 
		bbPublicContentPage.selectWPSystemAnnouncements();
		 
		//click Submit button 
		bbPublicContentPage.submitSettings();
		 
		//Click Wiley plus System announcements
		bbPublicContentPage.selectWileyplusSystemAnnouncements(); 
		 
		//validate Wiley plus System announcements
		bbPublicContentPage.validateWPSystemannouncementsHomePage();
		 
		//Click to return to blackboard button
		bbPublicContentPage.returnToBlackboard();
		 
		//Select tools option in top left menu
		userPage.tools();

		//Click "Wiley plus" link in tools page
		blackboardToolsWileyPlusPage = userPage.wileyplus();
		 
		//Select wiley plus System announcements link in tools page
		blackboardToolsWileyPlusPage.selectWileyplusSystemannouncements();
		 
		//Validate return to blackboard button and click on the button
		blackboardToolsWileyPlusPage.returnToBlackboard();
		 
		/**********************************************Test Case E4-83: WP-BB Int - Content D&A - Content Links (instructor) - Tools links. Getting Started with WP*****************************/
		
		//Getting Started with WileyPLUS Link is not displayed 
		//Select content 2 link
		userPage.selectcontent2();
 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select Add WP Tools
		bbPublicContentPage.selectAddWPTool();  
		 
		/**********************************************Test Case E4-87: WP-BB Int - Content D&A - Content Links (instructor) - WileyPLUS Total Score*****************************/
	 
		//Select content 2 link
		userPage.selectcontent2();
 
		//Select publish content page
		userPage.selectPublishContent();
		 
		//Select wiley plus link in public content
		bbPublicContentPage.selectWileyPlusPublicContent();
		 
		//Select total score link
		bbPublicContentPage.selectWPTotalScore();

		//Validate total score/gradebook page
		bbPublicContentPage.validateWPTotalScorePage();
		 
		//Click "Return to Blackboard" button
		bbPublicContentPage.returnToBlackboard();
		 
		//Select "Grade Center" tab
		bbPublicContentPage.goToGradeCenter();
		 
		//Select Full Grade center link - Grade center
		bbPublicContentPage.goToFullGradeCenter();
		 
		//Validate total score column - full grade center page
		bbPublicContentPage.validateTotalScoreFullGradeCenter();
	}
}
