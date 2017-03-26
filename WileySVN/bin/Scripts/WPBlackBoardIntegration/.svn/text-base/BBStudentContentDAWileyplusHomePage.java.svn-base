package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.StudentHomepage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.BlackboardToolsWileyPlusPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Toolbox.Window;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

@Test (dataProvider="BBContentDAContentLinks",dataProviderClass=staticProviderClass.class)
public class BBStudentContentDAWileyplusHomePage {
	
	public void validateBBStudentContentDAWileyPlusHomePage(Map<String,String> dataMap) throws MalformedURLException, Exception{

			ResultUtil.createReport("BBStudentContentDAWileyplusHomePage-validateBBStudentContentDAWileyPlusHomePage", dataMap);
			
			String strEnv=Prerequsite.configMap.get("ENV");
			String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
			
			//Launch URL
			WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
			
			/*******************************************************Login as BB admin*****************************************************************/
			
			BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
			
			CreateEditAssignmentPage createEditAssignmentPage =PageFactory.initElements(driver, CreateEditAssignmentPage.class);
			
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
			//userPage.validateWileyPlusWindowSettings();
			
			//Clear cookies
			Browser.clearAllCookies(driver);
			
			//Close the driver
			Browser.closeDriver(driver);
			
			/*********************Test Case E4-1017: WP-BB Int - Content D&A - Content Links (student) - General************************/
			
			driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
			
			//Login as Student
			home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
			userPage = home.BBStudentLogin(dataMap);
			 
			 //Select Course Name
			 userPage.selectCourseName(dataMap);
			 
			//Select content 2 link
			 userPage.selectcontent2();
			 
			 //Validate the student content page
			 userPage.validateStudentContentPage();
			 
			 /*********************Test Case E4-1726: WP-BB Int - Content D&A - Content Links (student) - WP Assignments************************/
			 
			 //Go to wileyplus assignment link - content area
			 StudentAssignmentPage studentAssignmentPage = userPage.goToStudentWileyPlusAssignment();
			 
			 //Validate the assignment page 
			 studentAssignmentPage.validateBBWPAssignmentPage();
			 
			 //Click "Return to blackboard" button
			 studentAssignmentPage.returnToBlackboard();
			 
			 //click "tools" link
			 userPage.tools();
			 
			 //Go to wiley plus link in tools page
			 BlackboardToolsWileyPlusPage blackboardToolsWileyPlusPage = userPage.wileyplus();
			 
			 //Select wileyplus assignments
			 blackboardToolsWileyPlusPage.selectWileyplusAssignmentLink();
			 
			 //Validate return to blackboard button and click on the button
			 blackboardToolsWileyPlusPage.returnToBlackboard();
			 
			 /********************Test Case E4-1019: WP-BB Int - Content D&A - Content Links (student) - WP Read, Study & Practice*****************/
			 
			/* //Select content 2 link
			 userPage.selectcontent2();
			 
			 //Go to read study link
			 studentAssignmentPage =  userPage.goToStudentWileyPlusReadStudy();
			 
			 //Validate WP Read study practice page
			 studentAssignmentPage.validateBBWPReadStudyPage();
			 
			 //Return to blackboard
			 studentAssignmentPage.returnToBlackboard();
			 
			 //click "tools" link
			 userPage.tools();
			 
			 //Go to wiley plus link in tools page
			  blackboardToolsWileyPlusPage = userPage.wileyplus();
			  
			 //Select wiley plus read study practice link in tools page
			 blackboardToolsWileyPlusPage.selectWileyplusReadStudyPracticeLink();
			  
			 //Validate read study page
			 studentAssignmentPage.validateBBWPReadStudyPage();
			  
			 //Validate return to blackboard button and click on the button
			 blackboardToolsWileyPlusPage.returnToBlackboard();*/
			 
			 /**************Test Case E4-1020: WP-BB Int - Content D&A - Content Links (student) - WP Gradebook****************************/
			 
/*			 //Select content 2 link
			 userPage.selectcontent2();
			
			 //Click "Grade book" link in content page
			 studentAssignmentPage =  userPage.goToStudentWileyPlusGradebook();
			 
			 //Validate gradebook page
			 studentAssignmentPage.validateBBWPGradebookPage();
			 
			 //Return to blackboard
			 studentAssignmentPage.returnToBlackboard();
			 
			 //click "tools" link
			 userPage.tools();
			 
			 //Go to wiley plus link in tools page
			 blackboardToolsWileyPlusPage = userPage.wileyplus();
			  
			 //Select gradebook link in tools page
			 blackboardToolsWileyPlusPage.selectWileyplusGradebookLink();
			  
			 //Validate gradebook page
			 studentAssignmentPage.validateBBWPGradebookPage();
			  
			 //Validate return to blackboard button and click on the button
			 blackboardToolsWileyPlusPage.returnToBlackboard();*/
			 
			 /*****************Test Case E4-1021: WP-BB Int - Content D&A - Content Links (student) - WP System Announcements*********************/
			
	/*		 //Select content 2 link
			 userPage.selectcontent2();
			 
			 //Click "System announcements" link
			 studentAssignmentPage =  userPage.goToStudentWileyPlusSysAnnouncements();
			 
			 //Validate system announcements page
			 studentAssignmentPage.validateBBWPSysAnnouncements();
			 
			 //Return to blackboard
			 studentAssignmentPage.returnToBlackboard();
			 
			 //click "tools" link
			 userPage.tools();
			 
			 //Go to wiley plus link in tools page
			 blackboardToolsWileyPlusPage = userPage.wileyplus();
	
			 //Select wileyplus system announcements link
			 blackboardToolsWileyPlusPage.selectWileyplusSysAnnounceLink();
			  
			 //Validate system announcements page
			 studentAssignmentPage.validateBBWPSysAnnouncements();
			  
			 //Validate return to blackboard button and click on the button
			 blackboardToolsWileyPlusPage.returnToBlackboard();*/
			  
			 /*******************************Test Case E4-1022: WP-BB Int - Content D&A - Content Links (student) - Getting Started with WP**************************/
			  
			 //Select content 2 link
			 userPage.selectcontent2();
			  
			 studentAssignmentPage = userPage.goToStudentWileyPlusTraining();
			  
			 //Handle windows
			 studentAssignmentPage.handleWindows();
			  
			 //Validate training page
			 studentAssignmentPage.validateBBWPTraining();
			  
			 //close the training window
			 //Browser.closeDriver(driver);	
			 
			 studentAssignmentPage.switchToParentWindows();
			 
			 //click "tools" link
			 userPage.tools();
			 
			 //Go to wiley plus link in tools page
			 blackboardToolsWileyPlusPage = userPage.wileyplus();
			 
			 //Select training link
			 blackboardToolsWileyPlusPage.selectWileyplusTrainingLink();
			 
			 //Handle windows
			 studentAssignmentPage.handleWindows();
			 
			 //Validate training page
			 studentAssignmentPage.validateBBWPTraining();

			 //close the training window
			 //Browser.closeDriver(driver);
			 
			 studentAssignmentPage.switchToParentWindows();
			 
			 /*****************************Test Case E4-1023: WP-BB Int - Content D&A - Content Links (student) - WP Homepage*****************************************/
			 
			 //Select content 2 link
			 userPage.selectcontent2();
			  
			 //Go to wp home page
			 StudentHomepage studentHomepage=  userPage. selectStudentWPHomePageLink();
			  
			 //Validate gradebook page
			 studentHomepage.validateBBWPGradebookPage();
			  
			 //Validate return to blackboard button and click on the button
			 blackboardToolsWileyPlusPage.returnToBlackboard();
			  
			 /************************Test Case E4-1024: WP-BB Int - Content D&A - Content Links (student) - WP Total Score***********************************************/
			 
			 //Select content 2 link
			 userPage.selectcontent2();
			  
			 //Go to student total score page
			 studentAssignmentPage = userPage.goToStudentWileyPlusTotalscore();			  
			  
			 //Validate total score page
			 studentAssignmentPage.validateBBWPTotalScorePage();
			  
			 //Return to blackboard
			 studentAssignmentPage.returnToBlackboard();
		}
}
