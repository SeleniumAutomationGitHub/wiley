package Scripts.WPBlackBoardIntegration;

import java.net.MalformedURLException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Pages.SnapwizIntegration.BBPublicContentPage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Pages.WPBlackboardIntegration.InstructorAssignmentAccessPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.WPBlackboardIntegrationDataProviderUtil.staticProviderClass;

	@Test (dataProvider="InstructorAssignmentAccess",dataProviderClass=staticProviderClass.class)
public class BBInstructorAssignmentAccess {
		public void validateInstructorAssignmentAccess(Map<String,String> dataMap)throws MalformedURLException, Exception{
			
			ResultUtil.createReport("BBInstructorAssignmentAccess-validateInstructorAssignmentAccess", dataMap);
			
			String strEnv=Prerequsite.configMap.get("ENV");
			String strBB_URL=Prerequsite.configMap.get(strEnv+".BB_URL");
			
			//Launch URL
			WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strBB_URL);
			
			/***************************************************************************Login************************************************************************/
			
			BlackBoardIntegrationPage home=PageFactory.initElements(driver, BlackBoardIntegrationPage.class);			
			BlackBoardIntegrationPage userPage = home.BBInstructorLogin(dataMap);
			
			//Select the course
			userPage.selectCourseName(dataMap);
			
			userPage.selectcontent();
			
			BBPublicContentPage bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			/****************************************************Test Case E4-1053: WP-BB Int - Content D&A - Content Links(instructor) - Assigned graded Q/E assignment*************************************************/

			bbPublicContentPage.selectAssignmentLink(dataMap, "GradedQEassignment");
			
			bbPublicContentPage.handleWindows();
			
			InstructorAssignmentAccessPage instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "GradedQEassignment");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "GradedQEassignment");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "GradedQEassignment");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			/********************************************Test Case E4-1137: WP-BB Int - Content D&A - Content Links(instructor) - Assignment - Assigned ungraded Q/E**************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "UnGradedQEassignment");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "UnGradedQEassignment");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "UnGradedQEassignment");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "UnGradedQEassignment");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			/*******************************************Test Case E4-1138: WP-BB Int - Content D&A - Content Links(instructor) - Assignment - Assigned Mastery*************************************************/
		
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "MasteryAssigned");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "MasteryAssigned");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "MasteryAssigned");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "MasteryAssigned");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			/*******************************************Test Case E4-1139: WP-BB Int - Content D&A - Content Links(instructor) - Assignment - Assigned reading*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "ReadingAssigned");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "ReadingAssigned");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "ReadingAssigned");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "ReadingAssigned");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			/*******************************************Test Case E4-1141: WP-BB Int - Content D&A - Content Links(instructor) - Assignment - Assigned (no due date)*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "QuestionGraded");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "QuestionGraded");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "QuestionGraded");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "QuestionGraded");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
			/*******************************************Test Case E4-1143: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned with "start date" in future*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "QuestionGradedUnreachable");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "QuestionGradedUnreachable");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "QuestionGradedUnreachable");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "QuestionGradedUnreachable");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
			/*******************************************Test Case E4-1145: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned "no access after DD"*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "QuestionStartdatePast");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "QuestionStartdatePast");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "QuestionStartdatePast");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "QuestionStartdatePast");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();

			/*******************************************Test Case E4-1147: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned ""*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "GradedQEPastPolicy");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "GradedQEPastPolicy");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "GradedQEPastPolicy");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "GradedQEPastPolicy");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.gotoStudentView();
			
			instructorAssignmentAccessPage.validateStudentViewDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.selectQuestions();
			
			instructorAssignmentAccessPage.gotoInstructorView();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			/*******************************************Test Case E4-1148: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned "View only""*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "GradedQuestionViewOnly");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "GradedQuestionViewOnly");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "GradedQuestionViewOnly");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "GradedQuestionViewOnly");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
			/*******************************************Test Case E4-1149: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned "View with Assistance""*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "GradedQuestionViewAssistance");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "GradedQuestionViewAssistance");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "GradedQuestionViewAssistance");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "GradedQuestionViewAssistance");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
			/*******************************************Test Case E4-1150: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned timed*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "TimedQuestionAssignment");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "TimedQuestionAssignment");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "TimedQuestionAssignment");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "TimedQuestionAssignment");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			/*******************************************Test Case E4-1151: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned timed,one more attempt*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "TimedQuestionFutureDueDate");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "TimedQuestionFutureDueDate");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "TimedQuestionFutureDueDate");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "TimedQuestionFutureDueDate");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
			/*******************************************Test Case E4-1152: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Assigned timed "no access after DD"*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "GradedQuestionNoAccess");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "GradedQuestionNoAccess");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "GradedQuestionNoAccess");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "GradedQuestionNoAccess");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
			/*******************************************Test Case E4-1154: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Unassignment and cleared*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "UnassignedQuestion");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "UnassignedQuestion");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "UnassignedQuestion");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "UnassignedQuestion");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
/*******************************************Test Case E4-1164: WP-BB Int - Content D&A - Content Links(instructor)-Assignment -Reading-not assigned*************************************************/
			
			bbPublicContentPage =	userPage.clickPublishContent();
			
			//bbPublicContentPage.selectWileyPlusPublicContent();
			
			bbPublicContentPage.selectAddAssignmentsReadings();
			
			bbPublicContentPage.selectWPAssignmentLinkReadAssignment();
			
			bbPublicContentPage.selectAssignmentLink(dataMap, "UnassignedReading");
			
			bbPublicContentPage.handleWindows();
			
			instructorAssignmentAccessPage = bbPublicContentPage.instructorAssignmenAccess();
			
			instructorAssignmentAccessPage.validateInstructorAssignmentWindow();
			
			instructorAssignmentAccessPage.switchToParentWindow();
			
			bbPublicContentPage.selectAssignment(dataMap, "UnassignedReading");
			
			bbPublicContentPage.submitSettings();
			
			bbPublicContentPage.validateAssignmentBBArea(dataMap, "UnassignedReading");
			
			bbPublicContentPage.selectAssignmentBBLink(dataMap, "UnassignedReading");
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			instructorAssignmentAccessPage.verifyDescriptionPage();
			
			instructorAssignmentAccessPage.clickOnFirstQuestion();
			
			instructorAssignmentAccessPage.validateQuestionsPage();
			
			instructorAssignmentAccessPage.validateDescriptionPage();
			
			bbPublicContentPage.returnToBlackboard();
			
			
	}
}
