package Pages.Assignments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Pages.Common.Initializer;
import Pages.Common.StudentLoginpage;
import Pages.GradeBook.AssignmentResultsPage;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;
//import Toolbox.ImageUtil;
import Toolbox.Link;
import Toolbox.Listbox;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Toolbox.Window;

public class CreateEditAssignmentPage extends Initializer {	

		String strContentTableXpath ="//td[@class='content-area-top']";
		String strPlainTableXpath= "//table[contains(@class,'plain-table')]";
		String strPaddinglistXpath= "//td[contains(@class,'pagination-padding list-item-padding')]";
		String strTotalScoreXpath="//table[contains(@class,'plain-table')]//tr[.//td/b[.='Total score:']]//td[./input[@class='readonly']]//input";
		String strQuestionAtempts= "//tr[./td[.='Question Attempts:']]//td//select[@id='ag_attempts']";
		String strPossibleAttempts="//tr[./td[.='Attempt Policy:']]//td//select[@name='ag_assistance_apolicy']";
		String strChangeValueXpath= "//td[@class='content-area-top']//tr[./td[text()='Change Values' and text()='(Algorithmic Questions):']]";
		String strContentAreaXpath="//table[@class='content-area']";
		
		Random rand = new Random();
		
		@FindBy(how = How.CLASS_NAME, using = "titlink")
		private WebElement crtngAssignmentLink; 
		
		@FindBy(how = How.CLASS_NAME, using = "input100")
		private WebElement txtAssignId;
		
		@FindBy(how = How.CLASS_NAME, using = "input200")
		private WebElement txtAssignName;

		@FindBy(how = How.ID, using = "reportUserComments")
		private WebElement RptCmnt;
		
		@FindBy(how = How.ID, using = "Next")
		private WebElement btnNext;
		
		@FindBy(how = How.NAME, using = "ag_descr")
		private WebElement txtDescrib;
		
		@FindBy(how = How.ID, using = "ag_type1")
		private WebElement rdobutton1;
		
		@FindBy(how = How.ID, using = "ag_descr1")
		private WebElement chkboxDisplay;
		
		@FindBy(how=How.XPATH, using="//input[@value='2']")
		private WebElement rdobtn2;
		
		@FindBy(how=How.XPATH, using="//input[@value='4']")
		private WebElement rdobtn3;
		
		@FindBy(how=How.XPATH, using="//input[@value='8']")
		private WebElement rdobtn4;

		@FindBy(how=How.ID, using="sharing1")
		private WebElement rdobtn5;
		
		@FindBy(how=How.ID, using="sharing2")
		private WebElement rdobtn6;
		
		@FindBy(how=How.ID, using="sharing3")
		private WebElement rdobtn7;
		
		@FindBy(how=How.XPATH, using="//select[@name='ctb_versions']")
		private WebElement drpboxVersion;
		
		@FindBy(how=How.ID, using="Cancel")
		private WebElement cnclBtn;
		
		@FindBy(how=How.ID, using="No")
		private WebElement NoBtn;
		
		@FindBy(how=How.ID, using="Yes")
		private WebElement YesBtn;
			
		@FindBy(how = How.ID, using = "applyFilters")
		private WebElement gobtn;
		
		@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[2]/td[3]/a")
		private WebElement withoutAnswer;
		
		@FindBy(how=How.XPATH, using="//a[starts-with(.,'Download')]")
		private WebElement downloadSelected;
		
		@FindBy(how=How.NAME, using="chk_ctb_scramble")
		private WebElement scramble;
		
		@FindBy(how=How.XPATH, using="//a[.='Close']")
		private WebElement close;
		
		@FindBy(how=How.XPATH, using="//input[@id='include_answers']")
		private WebElement includeAnswer;
		
		@FindBy(how=How.XPATH, using="//table[2]/tbody/tr[2]/td[4]/a")
		private WebElement withAnswer;
		
		@FindBy(how = How.ID, using = "applyFilterObjectives")
		private WebElement btnLearningObjective;
		
		@FindBy(how = How.ID, using = "applyFilterPages")
		private WebElement btngoPageNavigator;
		
		@FindBy(how=How.XPATH, using="//td[contains(.,'Additional')]")
		private WebElement additional;
		
		@FindBy(how=How.ID, using="page_setup")
		private WebElement configure;
		
		@FindBy(how=How.XPATH, using="//b[starts-with(.,'Page')]")
		private WebElement pageLayout;
		
		@FindBy(how=How.XPATH, using="//td[starts-with(.,'No.')]")
		private WebElement noOfLines;
		
		@FindBy(how=How.XPATH, using="//select[@name='ctb_lines']")
		private WebElement conDrpBox;
		
		@FindBy(how=How.XPATH, using="//td[starts-with(.,'Page')]")
		private WebElement pageBreaks;
		
		@FindBy(how=How.ID, using="ctb_breaks_No")
		private WebElement noRdobtn;
		
		@FindBy(how=How.XPATH, using="//b[.='Header:']")
		private WebElement header;
		
		@FindBy(how=How.ID, using="chk_ctb_masthead")
		private WebElement masthead;

		@FindBy(how=How.ID, using="chk_ctb_show_title")
		private WebElement shwTitle;

		@FindBy(how=How.ID, using="chk_ctb_show_version")
		private WebElement shwVersion;

		@FindBy(how=How.ID, using="chk_ctb_show_name")
		private WebElement shwName;

		@FindBy(how=How.ID, using="chk_ctb_show_head_text")
		private WebElement shwHeadText;

		@FindBy(how=How.ID, using="chk_ctb_show_date")
		private WebElement shwDate;

		@FindBy(how=How.ID, using="ctb_version_type_0")
		private WebElement versionNum;

		@FindBy(how=How.ID, using="ctb_version_type_1")
		private WebElement versionLetter;

		@FindBy(how=How.ID, using="chk_ctb_footer_first")
		private WebElement footerFirst;

		@FindBy(how=How.ID, using="chk_ctb_show_page")
		private WebElement footerPage;

		@FindBy(how=How.ID, using="chk_ctb_show_foot_text")
		private WebElement footerText;

		@FindBy(how=How.XPATH, using="//b[.='Footer:']")
		private WebElement footer;

		@FindBy(how=How.ID, using="chk_save_preferences")
		private WebElement savePref;

		@FindBy(how=How.ID, using="pageSetupUpdate")
		private WebElement updateBtn;
		
		@FindBy(how=How.XPATH, using="//b[contains(.,'questions?')]")
		private WebElement explanation;
		
		@FindBy(how=How.XPATH, using="//div[.='3. Organize Questions']")
		private WebElement organizeTab;
				
		@FindBy(how=How.XPATH, using="//table[contains(@class,'plain-table')]//tr[2]//td//a[.='Remove']")
		private WebElement remove;
		
		@FindBy(how=How.XPATH, using="//table[contains(@class,'plain-table')]//a[.='Remove']")
		private WebElement removeAll;
		
		@FindBy(how=How.XPATH, using="//div[starts-with(.,'1. Describe')][@class='title']")
		private WebElement navigateToDescribe;
		
		@FindBy(how=How.XPATH, using="//table[contains(@class,'plain-table')]//tr[2]//select")
		private WebElement order;
				
		@FindBy(how= How.ID, using ="ag_attempts")
		private WebElement drpAttempts;
		
		@FindBy(how= How.ID, using ="Assign_to_Class_Section(s)")
		private WebElement btnAssigntoClass;
		
		@FindBy(how = How.ID, using= "Submit")
		private WebElement btnSubmit;		
		
		@FindBy(how = How.ID, using = "Save_and_Exit")
		private WebElement btnSaveandExit;
		
		@FindBy(how = How.XPATH, using ="//select[contains(@name,'showperpage')]")
		private WebElement drpShowPerPage;
		
		@FindBy(how = How.ID, using = "Save_and_Find_more_Questions")
		private WebElement btnSaveAndFind;
		
		@FindBy(how = How.XPATH, using ="//tr//select[@name='association']")
		private WebElement listAssociation;
		
		@FindBy(how = How.ID, using = "Show_Solution")
		private WebElement btnShowSolution;
		
		@FindBy(how = How.ID, using = "Link_to_Resource_1")
		private WebElement btnLinktoResource;
		
		@FindBy(how = How.XPATH,using ="//tr//select[@name='difficulty']")
		private WebElement listLevel;
		
		@FindBy(how = How.NAME, using = "objective")
		private WebElement drpLearningObjectives;
		
		@FindBy(how = How.ID, using = "Back")
		private WebElement btnBack;
		
		@FindBy(how = How.ID, using = "Cancel")
		private WebElement btnCancel;
		
		@FindBy(how = How.ID, using = "page")
		private WebElement drpdownPageNavigator;
		
		@FindBy(how = How.XPATH, using ="//table[contains(@class,'plain-table')]//tr//input[@name='chk_ag_question_all']")
		private WebElement chkboxCheckAllQuestions;
		
		@FindBy(how = How.XPATH, using ="//table[contains(@class,'plain-table')]//tr[8]/td/input[@type='checkbox']")
		private WebElement chkboxUncheck;
		
		@FindBy(how = How.XPATH, using ="//table[contains(@class,'plain-table')]//tr//input[@name='chk_quest955613']")
		private WebElement chkboxQuestions;
				
		@FindBy(how=How.XPATH, using="//a[.='Go']")
		private WebElement go;
		
		@FindBy(how=How.XPATH, using="//div[.='5. Confirmation']")
		private WebElement confirmationTab;
			
		@FindBy(how=How.ID,using="Gradebook_Weighting")
		private WebElement btnGradeBookWeighting;
		//varibles
		StringBuffer questionNames=new StringBuffer();
		StringBuffer getQuestionNames=new StringBuffer();
		String version=new String();
		
		@FindBy(how=How.ID, using="sharing1")
		private WebElement sharingRdobtn1;
		
		@FindBy(how=How.ID, using="sharing2")
		private WebElement sharingRdobtn2;

		@FindBy(how=How.ID, using="sharing3")
		private WebElement sharingRdobtn3;
		
		@FindBy(how=How.XPATH, using="//label[@for='sharing1']")
		private WebElement sharingText1;
		
		@FindBy(how=How.XPATH, using="//label[@for='sharing2']")
		private WebElement sharingText2;
		
		@FindBy(how=How.XPATH, using="//label[@for='sharing3']")
		private WebElement sharingText3;
		
		@FindBy(how=How.XPATH, using="//div[@class='right-part']//a[2]")
		private WebElement myprofilebtn;
		
		@FindBy(how=How.NAME, using="lastname")
		private WebElement lastName;
		
		@FindBy(how=How.XPATH, using="//a[.='Update']")
		private WebElement updateMyProfile;

		@FindBy(how=How.XPATH, using="//a[.='Assignments']")
		private WebElement assignmentLnk;
		
		@FindBy(how = How.XPATH, using = "//td[@class='content-area-top']//tr[./td[.='Show Work:']]//td/input[@type='checkbox']")
		private WebElement checkboxShowWork;
		
		@FindBy(how = How.XPATH, using = "//td[@class='content-area-top']//tr[./td[.='Question Feedback:']]//td/input[@type='checkbox']")
		private WebElement checkboxQuestionFeedback;
		
		@FindBy(how = How.XPATH, using = "//td[@class='content-area-top']//tr[./td[.='Point Potential Setting:']]//td/input[@type='checkbox']")
		private WebElement checkboxPointPotential;
		
		@FindBy(how = How.NAME, using ="chk_save_preferences")
		private WebElement checkboxSavePreference;
		
		@FindBy(how = How.ID, using = "Assign_Later")
		private WebElement btnAssignLater;
		
		@FindBy(how=How.ID, using="Preview_Assignment")
		private WebElement btnpreviewassgn;
		
		@FindBy(how= How.XPATH, using= "//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr/td//select")
		private WebElement reduceScore;
		
		@FindBy(how= How.XPATH, using= " //table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr/td//input[@type='checkbox']")
		private WebElement lateSubmission;
		
		@FindBy(how=How.XPATH, using= "//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr//td//input[@id='radio1']")
		private WebElement studentAccess1;
		
		@FindBy(how=How.XPATH, using= "//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr//td//input[@id='radio2']")
		private WebElement studentAccess2;
		
		@FindBy(how=How.XPATH, using= "//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr//td//input[@id='radio3']")
		private WebElement studentAccess3;
		
		@FindBy(how=How.XPATH, using= "//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr//td//input[@id='radio4']")
		private WebElement studentAccess4;
		
		@FindBy(how = How.ID, using="ag_scored2")
		private WebElement gradedAssignment;
		
		@FindBy(how = How.ID, using= "ag_scored2")
		private WebElement unGradedAssignment;
		
		@FindBy(how = How.ID, using = "timing_chbox")
		private WebElement timedAssignment;
		
		@FindBy(how = How.ID, using = "timing_ontask_chbox")
		private WebElement timeOnTask;
		
		@FindBy(how =How.ID, using = "hide_question_titles_chbox")
		private WebElement useGenericQuestionTitles;
		
		@FindBy(how = How.ID, using = "print_chbox")
		private WebElement printCheckbox;
		
		@FindBy(how = How.ID, using = "time_limit_select")
		private WebElement timeLimit;
		
		@FindBy(how = How.ID, using = "diagnostic_reporting_chbox")
		private WebElement studyObjective;
		
		@FindBy(how = How.ID, using = "Save/Update_Settings")
		private WebElement  updateButton;
		
		@FindBy(how = How.NAME, using = "hide_tolerance")
		private WebElement hideTolerance;
		
		@FindBy(how = How.ID, using = "sditext_1")
		private WebElement genericInstruction;
		
		@FindBy(how= How.ID, using = "sdhelp_2")
		private WebElement activeHelp;
		
		@FindBy(how = How.XPATH, using = "//select[contains(@name,'weighting')]")
		private WebElement weightingSetting;
		
		@FindBy(how= How.XPATH, using="//input[@id='weighting_type']")
		private WebElement questionType;
		
		@FindBy(how= How.XPATH, using= "//input[@id='weighting_percentage']")
		private WebElement questionPercentage;
		
		@FindBy(how= How.XPATH, using= "//select[@name='ag_assistance_links']")
		private WebElement drpShowLinks;
		
		@FindBy(how= How.XPATH, using= "//select[@name='ag_assistance_solutions']")
		private WebElement drpShowSolution;
		
		@FindBy(how= How.XPATH, using= "//select[@name='ag_assistance_answer']")
		private WebElement drpShowAnswer;
		
		public CreateEditAssignmentPage(WebDriver driver){
			super(driver);
		}
		
		//Description: Selecting the Create New Assignment Link from Create Edit Assignment Page
		public CreatingAssignmentHelpPage gotToCreatingAssignmentHelpPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>gotToCreatingAssignmentHelpPage", driver);
			crtngAssignmentLink.click();
			return PageFactory.initElements(driver, CreatingAssignmentHelpPage.class);
		}	
				
		//Description: Verifying Alert Message in Assignment Name column by giving more than 256 characters from Assignment page
		public void verifyLongAssignmentName(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLongAssignmentName", driver);
			
			if(Element.verify("Assignment Name", driver, "xpath", strContentTableXpath+"//tr[3]/td[@class='label']")){
				String strlongAsignName=dataMap.get("LongCharacAsgntName");			   
			    TextBox.enterValue("LongCharacAsgntName", txtAssignName, strlongAsignName, driver);			   
			}		
				
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
		}
		
		//Description: Verifying Alert Message in Assignment ID column by giving more than 100 characters from Assignment page
		public void verifyLongAssignmentID(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLongAssignmentID", driver);
			
			if(Element.verify("Assignment ID", driver, "xpath", strContentTableXpath+"//tr[2]/td[@class='label']")){
				String strlongAsignName=dataMap.get("AsgntName");
				String strLongAssignID = dataMap.get("LongCharacAsgntID");				
				TextBox.enterValue("LongCharacAsgntID", txtAssignId, strLongAssignID, driver);
				TextBox.enterValue("LongCharacAsgntName", txtAssignName, strlongAsignName, driver);
			}			
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
				
			TextBox.clearValue("Assignment ID", txtAssignId, driver);
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
		}
		
		//Description: Verifying Alert Message in Assignment Description column by giving more than 2048 characters from Assignment page
		public void verifyLongDescription(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLongDescription", driver);
			
			if(Element.verify("Assignment Description", driver, "xpath", strContentTableXpath+"//tr[4]/td[@class='label']")){
				String strLongDescrib = dataMap.get("LongCharacAsgntDescribtion");				
				String strAssignName = dataMap.get("AsgntName");
				String strLongAssignID = dataMap.get("AsgntID");				
				TextBox.enterValue("LongCharacAsgntID", txtAssignId, strLongAssignID, driver);
				TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, strLongDescrib, driver);				
				TextBox.enterValue("AsgntName", txtAssignName, strAssignName, driver);
			}
			
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);			
			TextBox.clearValue("Assignment ID", txtAssignId, driver);
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
			TextBox.clearValue("Assignment Description", txtDescrib, driver);
		}
		
		//Description: Verifying Alert Message in Assignment Name and ID column by giving more than 100 and 256 characters from Assignment page
		public void verifyLongAssignmentNameAndID(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLongAssignmentNameAndID", driver);
			String strLongAssignID = dataMap.get("LongCharacAsgntID");
			String strLongAsignName = dataMap.get("LongCharacAsgntName");
			
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, strLongAssignID, driver);				
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, strLongAsignName, driver);				
							
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);				
			TextBox.clearValue("Assignment ID", txtDescrib, driver);
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
				
		}
		
		//Description: Verifying Alert Message in Assignment ID and Description column by giving more than 100 and 2048 characters from Assignment page
		public void verifyLongAssignmentIDAndDescription(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLongAssignmentIDAndDescription", driver);		
			String strLongAssignID = dataMap.get("LongCharacAsgntID");
			String strLongDescrib = dataMap.get("LongCharacAsgntDescribtion");
			String strAssignName = dataMap.get("AsgntName");
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, strLongAssignID, driver);
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, strLongDescrib, driver);			
			TextBox.enterValue("AsgntName", txtAssignName, strAssignName, driver);
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);
			TextBox.clearValue("Assignment ID", txtDescrib, driver);
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
			TextBox.clearValue("Assignment Description", txtDescrib, driver);
		}
		
		//Description: Verifying Alert Message in Assignment Name and Description column by giving more than 256 and 2048 characters from Assignment page
		public void verifyLongAssignmentNameAndDescription(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLongAssignmentNameAndDescription", driver);	
			String strLongAsignName= dataMap.get("LongCharacAsgntName");			
			String strLongDescrib = dataMap.get("LongCharacAsgntDescribtion");
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, strLongAsignName, driver);
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, strLongDescrib, driver);			
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);			
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
			TextBox.clearValue("Assignment Description", txtDescrib, driver);			
		}
		
		//Description: Verifying Alert Message in Assignment ID, Name and Description column by giving more than 100, 256 and 2048 characters from Assignment page
		public void verifyLondIdNameAndDescription(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLondIdNameAndDescription", driver);
			String strLongAsignID = dataMap.get("LongCharacAsgntID");
			String strLongAssignName= dataMap.get("LongCharacAsgntName");
			String strLongDescrib = dataMap.get("LongCharacAsgntDescribtion");
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, strLongAsignID, driver);
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, strLongAssignName, driver);
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, strLongDescrib, driver);		
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);
			TextBox.clearValue("Assignment ID", txtDescrib, driver);
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
			TextBox.clearValue("Assignment Description", txtDescrib, driver);		
		}
		
		//Description:verify Untitled Alert Message
		public void verifyAssignmentisUntitledAlert(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyAssignmentisUntitledAlert", driver);
			
			if(Element.verify("Assignment- Type", driver, "xpath", strContentTableXpath+"//tr[1]/td[@class='label']")){
				Radiobutton.select("Question/Exercises",rdobutton1 , driver);
				ResultUtil.report("INFO", "Question/Exercises is Selected", driver);
			}
			
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			
		}		
		
		//Description: Verify Assignment ID Empty Alert Message
		public void verifyAssignmentIDEmptyAlert(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyAssignmentIDEmptyAlert", driver);

			if(Element.verify("Assignment Name", driver, "xpath", strContentTableXpath+"//tr[3]/td[@class='label']")){
				String strAssignName= dataMap.get("AsgntName");
				TextBox.enterValue("AsgntName", txtAssignName, strAssignName, driver);				
			}
			
			btnNext.click();	
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);
			TextBox.clearValue("Assingment-Name", txtAssignName, driver);	
		}
		
		//Description: Verify Assignment Untitled Alert Message
		public void verifyAssignmentUntitledAlert(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyAssignmentUntitledAlert", driver);
			
			if(Element.verify("Assignment ID", driver, "xpath", strContentTableXpath+"//tr[2]/td[@class='label']"))
			{
				String strAssignId = dataMap.get("AsgntID");
				TextBox.enterValue("AsgntID", txtAssignId, strAssignId, driver);			
			}
			
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);
			TextBox.clearValue("Assignment ID", txtAssignId, driver);
		}
		
		//Description: Enter details in Describe Assignment details
		public void inputDescriptionDetails(Map<String,String> dataMap,String strAssignmentId,String strAssignmentName) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>inputDescriptionDetails", driver);
			
			if(Element.verify("Description", driver, "ID", "ag_descr1")){
				
				Radiobutton.select("Question/Exercises",rdobutton1 , driver);
				String strAssignId = dataMap.get(strAssignmentId);
				String strAssignName= dataMap.get(strAssignmentName);
				String strAssignDescr= dataMap.get(strAssignmentName);
				TextBox.enterValue("AsgntID", txtAssignId, strAssignId, driver);
				TextBox.enterValue("AsgntName", txtAssignName, strAssignName, driver);
				TextBox.enterValue("AsgntDescribtion", txtDescrib, strAssignDescr, driver);
				
				if(Checkbox.isChecked("Display to Students", chkboxDisplay, driver)){
					Element.verify("Display to Students", driver, "xpath", "//tr[4]//label[contains(.,'Display')]");
					Checkbox.unCheck("Display to Students", chkboxDisplay, driver);
					Checkbox.check("Display to Students", chkboxDisplay, driver);
					Radiobutton.isSelected("Make Available to Others", sharingRdobtn1, driver);
				}
				else{
					Checkbox.check("Display to Students", chkboxDisplay, driver);
				}	
			}	
		}
		
		
		public void descriptionDetails(Map<String,String> dataMap,String strAssignmentId,String strAssignmentName){
			
			Radiobutton.isSelected("Question/Exercises",rdobutton1 , driver);
			String strAssignId = dataMap.get(strAssignmentId);
			String strAssignName= dataMap.get(strAssignmentName);
			String strAssignDescr= dataMap.get(strAssignmentName);
			TextBox.verifyValue("Verify ID", txtAssignId, strAssignId, driver);
			TextBox.verifyValue("Verify Name",  txtAssignName, strAssignName, driver);
			TextBox.verifyValue("Verify Describtion", txtDescrib, strAssignDescr, driver);
		}
		//Description: Choose Chapter  in Select Question screen
		public void chooseChapter() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>chooseChapter", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH",strPlainTableXpath )){
				Element.verify("Chapter List", driver, "Name", "association");		
				WebElement select=driver.findElement(By.name("association"));
				List<WebElement> allOptions = select.findElements(By.tagName("option"));
				ResultUtil.report("MESSAGE", "Dropdown size"+allOptions.size(), driver);
				
			}		
		}
		
		//Description: Select Questions displayed in Select Question screen
		public void selectQuestions(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestions", driver);
			List<WebElement> listcheckbox = driver.findElements(By.xpath(strPlainTableXpath+"//tr//input[@type='checkbox']"));
			listcheckbox.size();			
			for(int i=1;i<=listcheckbox.size();i++)
			{
				if((i==2 || i==3 || i==4 ||i==5 ||i==6)){
					WebElement checkboxclick = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
					Checkbox.isEnabled(checkboxclick, "verify Checkbox", driver);
					Checkbox.check("Select Questions", checkboxclick, driver);
					String questionName=driver.findElement(By.xpath(strPlainTableXpath+"/tbody/tr["+i+"]//td[2]")).getText();
					questionNames.append(questionName);
				}
			}
			Element.verify("Search Questions", driver, "XPATH", "//select[contains(@name,'showperpage')]");
		}
		
		//Description: Get Question names in Preview
		public void getQuestionNames(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>getQuestionNames", driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
			List<WebElement> questions=driver.findElements(By.xpath("//table[1]//table[1]//table/tbody/tr[1]/td[1]/span[2]"));
			questions.size();
			for(WebElement getQuestions:questions)
			{
				String ques=getQuestions.getText();
				getQuestionNames.append(ques);				
				ResultUtil.report("MESSAGE", ques, driver);
			}
		}
		
		//Description: verify the question names
		public void verifyQuestionNames(){
			if(questionNames.toString().equals(getQuestionNames.toString())){
				ResultUtil.report("PASS", "The question order and question name are same", driver);
			}
		}
		
		//Description: Verify Description Assignment
		public void verifyDescribeAssignmentTab() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyDescribeAssignmentTab", driver);
			WebElement selectQuestion = driver.findElement(By.xpath("//div[@class='title'][.='1. Describe Assignment']"));
			Assert.assertTrue(selectQuestion.getText().equals("1. Describe Assignment"));	
		}
		
		//Description: Verify SelectQuestionscreen
		public void verifySelectQuestiontab() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySelectQuestiontab", driver);
			WebElement selectQuestion = driver.findElement(By.xpath("//div[@class='title'][.='2. Select Questions']"));
			Assert.assertTrue(selectQuestion.getText().equals("2. Select Questions"));
			ResultUtil.report("MESSAGE", "Select question tab is verified", driver);
		}
		
		//Description: Verify Organize and Score Questions Screen
		public void verifyOrganizeAndScoreQuestionTab(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyOrganizeAndScoreQuestionTab", driver);
			WebElement scorequestions = driver.findElement(By.xpath("//li[@class='tab active']")); 
			Element.verify("Organize Question Tab", scorequestions, driver);
			if(driver.findElement(By.xpath("//table[contains(@class,'plain-table')]//tr")).isDisplayed()){
				ResultUtil.report("MESSAGE", "Question Table Displayed", driver);
			}				
		}
		
		//Description: Select Question Policies in Set Question Policies screen
		public void setQuestionPolicies(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>setQuestionPolicies", driver);
			String strSetQuestionPolicies = dataMap.get("SetQuestionPolicies");
			
			if(Element.verify("Question Policies", driver, "XPATH", strContentTableXpath+"//tr[./td[.='"+strSetQuestionPolicies+"']]")){
				WebElement selectPolicies = driver.findElement(By.xpath(strContentTableXpath+"//tr[./td[.='"+strSetQuestionPolicies+"']]//td/input[@type='checkbox']"));
				Checkbox.check("CheckSetQuestionPolicies", selectPolicies, driver);
			}
			
			Combobox.selectItemByIndex("No. of Attempts", drpAttempts,3, driver);	
		}
		
		//Description: Select Assign to Class Button
		public void selectAssigntoClassButton() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAssigntoClassButton", driver);
			Button.click("Assign To Class", btnAssigntoClass, driver);
			
		}
		
		//Description: Select Class from the Select Assign to class screen
		public void assigntoclass(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>assigntoclass", driver);
			String strClassAssignment = dataMap.get("ClassName");			
			if(Element.verify("Class", driver, "XPATH", strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]")){	
			WebElement classChecbox = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));	
				if(Checkbox.isUnchecked("Class Selection",classChecbox , driver)){
					Checkbox.check("Class Selection", classChecbox, driver);
				}	
			}
		}
		
		//Description: Uncheck Display to Students Check box and click Next
		public void unselectDisplayStudentCheckbox(Map<String,String> dataMap)  {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>unselectDisplayStudentCheckbox", driver);
			
			if(Element.verify("Description", driver, "ID", "ag_descr1")){
				if(Checkbox.isChecked("Display to Students", chkboxDisplay, driver)){
					Checkbox.unCheck("Display to Students", chkboxDisplay, driver);									
				}
			}	
		}
		
		//Save and Exit the Edit Assignment Page
		public void selectSaveAndExit() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectSaveAndExit", driver);
			driver.findElement(By.id("Save_and_Exit")).click();
			
		}
		
		//Description: verify Alert message displayed after selecting Save and Exit button in Organize and Score screen
		public void validateAlertMessage() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>validateAlertMessage", driver);
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);			
			driver.switchTo().alert().accept();
		}
		
		//Description: Step 2 of Create/Edit Assignment Page in Select Question Screen Verifying the 10 questions displayed.
		public void selectTenQuestionsPerPage(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectTenQuestionsPerPage", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH", strPaddinglistXpath)){				
				String strShow10PerPage = dataMap.get("Showperpage10");
				Combobox.selectItemByValue("Showperpage10", drpShowPerPage, strShow10PerPage, driver);
				Button.click("Go Button", gobtn, driver);	
			}			
		}
				
		//Description: Verifying 20 questions displayed
		public void selectTwentyQuestionPerPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectTwentyQuestionPerPage", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH", strPaddinglistXpath))
			{
				String strShow20PerPage = dataMap.get("Showperpage20");				
				Combobox.selectItemByValue("Showperpage20", drpShowPerPage, strShow20PerPage, driver);
				Button.click("Go Button", gobtn, driver);	
				
			}
		}
		
		//Description: Verifying 30 question displayed
		public void selectThirtyQuestionsPerPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectThirtyQuestionsPerPage", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH", strPaddinglistXpath)){
				String strShow30PerPage = dataMap.get("Showperpage30");
				Combobox.selectItemByValue("Showperpage30", drpShowPerPage, strShow30PerPage, driver);
				Button.click("Go Button", gobtn, driver);	
				
			}
		}
		
		//Description: Verifying 50 question displayed
		public void selectFiftyQuestionsPerPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectFiftyQuestionsPerPage", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH", strPaddinglistXpath)){
				String strShow50PerPage = dataMap.get("Showperpage50");
				Combobox.selectItemByValue("Showperpage50", drpShowPerPage, strShow50PerPage, driver);
				Button.click("Go Button", gobtn, driver);	
					
			}	
		}		
			
		//Description: Verifying 100 question displayed
		public void selectHundredQuestionPerPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectHundredQuestionPerPage", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH", strPaddinglistXpath)){
				String strShow100PerPage = dataMap.get("Showperpage100");
				Combobox.selectItemByValue("Showperpage100", drpShowPerPage, strShow100PerPage, driver);			
				Button.click("Go Button", gobtn, driver);
				
			}
		}
		
		//Description: Verifying All question displayed
		public void selectAllQuestionPerPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAllQuestionPerPage", driver);
			
			if(Element.verify("Search Questions", driver, "XPATH", "//select[contains(@name,'showperpage')]")){
				String strShowAllPerPage = dataMap.get("ShowperpageAll");
				Combobox.selectItemByValue("ShowperpageAll", drpShowPerPage, strShowAllPerPage, driver);
			}
		}
		
		public void verifySizeOfTable() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySizeOfTable", driver);
			List<WebElement> getCountdisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			ResultUtil.report("MESSAGE", "Size of Table:" +getCountdisplayed.size(), driver);
			
			WebElement learnObjectives = driver.findElement(By.xpath("//td[.='Questions Associated with Study Objective:']"));
			learnObjectives.getText();
		}
		
		
		public void selectSaveAndFindButton() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectSaveAndFindButton", driver);
			Button.click("Save and Find More Questions", btnSaveAndFind, driver);
			
		}
		
		//Description: Step2: Verify the Chapter Menu present from the list
		public void verifyChapterMenuPresent(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyChapterMenuPresent", driver);
			String strAssociationXpath= "//td[contains(@class,'pagination-padding list-item-padding')]//tr//select[@name='association']";
			if(Element.verify("Search Questions", driver, "XPATH", strAssociationXpath)){
				List<WebElement> chapter = driver.findElements(By.xpath(strAssociationXpath));
				for(WebElement list:chapter ){
					ResultUtil.report("MESSAGE",list.getText() , driver);
				}				
			}else{
				ResultUtil.report("MESSAGE","Chapter Menu is absent" , driver);
			}
		}
		
		//Description: Verify the Section menu present
		public void verifySectionMenuPresent(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySectionMenuPresent", driver);
			String strSectionXpath= "//td[contains(@class,'pagination-padding list-item-padding')]//tr//select[@id='section']";
			if(Element.verify("Section Menu", driver, "xpath", strSectionXpath)){
				List<WebElement> section = driver.findElements(By.xpath(strSectionXpath));
				for(WebElement list: section){
					ResultUtil.report("MESSAGE", list.getText(), driver);					
				}				
			}else{
				ResultUtil.report("MESSAGE", "Section Menu is not Available", driver);
			}
		}
		
		//Description: Verify the level Menu present from the list
		public void verifyLevelMenuPresent() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLevelMenuPresent", driver);
			String strLevelXpath= "//td[contains(@class,'pagination-padding list-item-padding')]//tr//select[@name='difficulty']";
			if(Element.verify("Search Questions", driver, "XPATH", strLevelXpath)){
				List<WebElement> level = driver.findElements(By.xpath(strLevelXpath));
				for(WebElement list:level ){
					ResultUtil.report("MESSAGE",list.getText() , driver);
				}
			}else{
				ResultUtil.report("MESSAGE","Level Menu is absent" , driver);
				}
		}
		
		//Description: Verify Source Menu present from the list
		public void verifySourceMenu(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLevelMenuPresent", driver);
			String strSourceXpath="//td[contains(@class,'pagination-padding list-item-padding')]//tr//select[@name='owner']";
			if(Element.verify("Search Questions", driver, "XPATH", strSourceXpath)){
				List<WebElement> source = driver.findElements(By.xpath(strSourceXpath));
				for(WebElement list:source ){
					ResultUtil.report("MESSAGE",list.getText() , driver);
				}
			}else{
				ResultUtil.report("MESSAGE","Source Menu is absent" , driver);
				}
		}
					
		//Description: Select one Question link from the list displayed and verify the preview window
		public void selectQuestionPreview(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionPreview", driver);
			String strQuestion = dataMap.get("NonAlgorthimQuestion");
			WebElement linkText = driver.findElement(By.xpath(strPlainTableXpath+"//tr//td/a[.='"+strQuestion+"']"));
			linkText.click();			
			String questionPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(questionPreviewWindow);
			driver.findElement(By.xpath("//b[.='"+strQuestion+"']"));
			ResultUtil.report("MESSAGE",strQuestion , driver);
		}
		
		//Description: Select show solution button  and verify the solution window
		public void verifyShowSolutionButton(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyShowSolutionButton", driver);
			String showSolution = "Show Solution";
			
			if(Button.verify("Show Solution", btnShowSolution, showSolution, driver)){
				Button.click(showSolution, btnShowSolution, driver);			
			}
			String showSolutionWindow=driver.getWindowHandles().toArray()[2].toString();
			driver.switchTo().window(showSolutionWindow);
			driver.findElement(By.xpath("//h1")).isDisplayed();
			Element.verify("Close Button", driver, "xpath", "//a[.='Close']");
			Button.click("Close button", close, driver);
		}
		
		//Description: Select Link to text button and verify the link to text window
		public void verifyLinktoText(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyLinktoText", driver);
			String questionPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(questionPreviewWindow);
			String linkText = "Link To Text";
			
			if(Button.verify("Link To Text", btnLinktoResource, linkText, driver)){
				Button.click("Link To Text", btnLinktoResource, driver);
			}
			
			String linktoText=driver.getWindowHandles().toArray()[2].toString();
			driver.switchTo().window(linktoText);
			
			driver.switchTo().frame("ref_head");
			Element.verify("Link To Text", driver, "xpath", "//h1");
			Element.verify("Close Button", driver, "xpath", "//a[.='Close']");
			Button.click("Close button", close, driver);
		}
		
		//Description: Select one chapter from the list
		public void selectOneChapter(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectOneChapter", driver);
			
			List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
			for(WebElement list:chapter ){
				Listbox.deselectAll(list, "Deselect All", driver);
				Listbox.selectItemByIndex("Chapter", list, 0, driver);
			}			
		}
		
		//Description: Select one section from the list
		public void selectOneSection(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectOneSection", driver);
			if(Element.verify("Section Menu", driver, "xpath", strPaddinglistXpath+"//tr//select[@id='section']")){
				List<WebElement> section = driver.findElements(By.xpath(strPaddinglistXpath+"//tr//select[@id='section']"));
				for(WebElement list: section){
					Listbox.deselectAll(list, "DeselectAll", driver);
					Listbox.selectItemByIndex("Section", list, 1, driver);
				}				
			}else{
				ResultUtil.report("FAIL", "Section Menu is not Available", driver);
			}
		}
		
		//Description: Select one level from the list box
		public void selectOneLevel(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectOneLevel", driver);
			
			List<WebElement> level = driver.findElements(By.xpath("//tr//select[@name='difficulty']"));
			for(WebElement listlevel:level ){
				Listbox.deselectAll(listlevel, "DeselectAll", driver);				
				Listbox.selectItemByIndex("Level", listlevel, 1, driver);
			}
		}
		
		//Description: Select One source from the list box
		public void selectOneSource(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectOneSource", driver);
			
			List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));
			for(WebElement listsource:source ){
				Listbox.deselectAll(listsource, "DeselectAll", driver);
				Listbox.selectItemByIndex("Level", listsource, 3, driver);
			}
		}
		
		//Description: Verify Table Contents
		public void verifyTableContent(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyTable", driver);
			String strTextAssociationXpath= "//table[contains(@class,'plain-table')]//td[.='Text Association']";
			if(Element.verify("Verify Chapter", driver, "xpath", strTextAssociationXpath)){
				List<WebElement> getCountdisplayed = driver.findElements(By.xpath(strTextAssociationXpath+"//parent::tr//following-sibling::tr/td[3]"));
				for(WebElement list:getCountdisplayed){
					ResultUtil.report("MESSAGE", list.getText(), driver);
				}
			}
			String strQuestionTypeXpath="//table[contains(@class,'plain-table')]//td[.='Question Type']";
			if(Element.verify("Question Type", driver, "xpath", strQuestionTypeXpath)){
				List<WebElement> getQuestionType = driver.findElements(By.xpath(strQuestionTypeXpath+"//parent::tr//following-sibling::tr/td[4]"));
				for(WebElement list:getQuestionType){
					ResultUtil.report("MESSAGE", list.getText(), driver);
				}				
			}
			String strDifficultyXpath= "//table[contains(@class,'plain-table')]//td[.='Difficulty']";
			if(Element.verify("Difficulty", driver, "xpath", strDifficultyXpath)){
				List<WebElement> getDifficulty = driver.findElements(By.xpath(strDifficultyXpath+"//parent::tr//following-sibling::tr/td[6]"));
				for(WebElement list:getDifficulty){
					ResultUtil.report("MESSAGE", list.getText(), driver);
				}				
			}
			String strSourceXpath="//table[contains(@class,'plain-table')]//td[.='Source']";
			if(Element.verify("Source", driver, "xpath", strSourceXpath)){
				List<WebElement> getSource = driver.findElements(By.xpath(strSourceXpath+"//parent::tr//following-sibling::tr/td[7]"));
				for(WebElement list:getSource){
					ResultUtil.report("MESSAGE", list.getText(), driver);
				}	
			}
			
			Combobox.isEnabled(drpLearningObjectives, "Study Objective", driver);
			
		}
		
		//Description: Select NonAlgorithmQuestion preview link
		public void selectNonAlgorithmQuestionPreview(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectNonAlgorithmQuestionPreview", driver);
			String nonAlgorthimQuestion = dataMap.get("NonAlgorthimQuestion");
			WebElement linkText = driver.findElement(By.xpath(strPlainTableXpath+"//tr//td/a[.='"+nonAlgorthimQuestion+"']"));
			Link.click("Question", linkText, driver);
			String questionPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(questionPreviewWindow);
			
			String strWindowTitle= driver.getTitle();
			if(strWindowTitle.equals(nonAlgorthimQuestion)){
				ResultUtil.report("PASS", "Name Displayed", driver);
			}else{
				ResultUtil.report("FAIL", "Name not Displayed", driver);
			}
			String questions=driver.findElement(By.xpath("//b[.='"+nonAlgorthimQuestion+"']")).getText();
			ResultUtil.report("MESSAGE", questions, driver);
			String reportContent=driver.findElement(By.xpath("//table[@id='change_value_labels_1']//tr//td/a")).getText();
			ResultUtil.report("MESSAGE", reportContent, driver);
			Element.verify("ShowSolution buton", driver, "ID", "Show_Solution");
			Element.verify("Link to Text", driver, "ID", "Link_to_Resource_1");
			Element.verify("Close button", driver, "xpath", "//a[.='Close']");
			
		
		}
		
		//Description: Select Algorithm Question preview window
		public void selectAlgorithmQuestionPreview(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAlgorithmQuestionPreview", driver);
			String questionSelectionWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(questionSelectionWindow);
			String algorthimQuestion = dataMap.get("AlgorthimQuestions");
			WebElement linkText = driver.findElement(By.xpath(strPlainTableXpath+"//tr//td/a[.='"+algorthimQuestion+"']"));
			linkText.click();
			
			String questionPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(questionPreviewWindow);
			driver.findElement(By.xpath("//b[.='"+algorthimQuestion+"']"));			
			driver.findElement(By.id("Show_Solution"));
			WebElement report = driver.findElement(By.xpath("//table[@id='change_value_labels_1']//tr//td//a[2]"));
			ResultUtil.report("MESSAGE", report.getText(), driver);
			WebElement changevalue = driver.findElement(By.xpath("//table[@id='change_value_labels_1']//tr//td//a[.='Change Values']"));
			ResultUtil.report("MESSAGE", changevalue.getText(), driver);	
			Element.verify("ShowSolution buton", driver, "ID", "Show_Solution");
			Element.verify("Link to Text", driver, "ID", "Link_to_Resource_1");
			Element.verify("Close Button", driver, "xpath", "//a[.='Close']");
			
		}
		
		//Description: Select Multiple Chapter Multiple Level from the  list
		public void selectMultipleChapterMultipleLevel(Map<String,String> dataMap) {
			List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
			for(WebElement list:chapter ){
				ResultUtil.report("MESSAGE", list.getText(), driver);
				Combobox.selectItemByIndex("Chapter",list, 0, driver);	
			}
			List<WebElement> level = driver.findElements(By.xpath("//tr//select[@name='difficulty']"));
			for(WebElement listlevel:level ){
				ResultUtil.report("MESSAGE", listlevel.getText(), driver);
				Combobox.selectItemByIndex("Chapter",listlevel, 1, driver);		
			}
			Button.click("Go Button", gobtn, driver);
			
			List<WebElement> getCountdisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='Chapter 1. Accounting in Action']"));
			for(WebElement list:getCountdisplayed){
				ResultUtil.report("MESSAGE", list.getText(), driver);
			}
			Button.click("Save and Find More Questions", btnSaveAndFind, driver);	
		}
			
		//Description: Select Chapter from the list and verify the table
		public void selectSingleChapter(Map<String,String> dataMap) {
			List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
			for(WebElement list:chapter ){
				ResultUtil.report("MESSAGE", list.getText(), driver);
				Combobox.selectItemByIndex("Chapter",list, 0, driver);	
				
			}
			Button.click("Go Button", gobtn, driver);
		
			driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='Chapter 1. Accounting in Action']"));
			Combobox.isEnabled(drpLearningObjectives,"LearningObjectives", driver);
			Button.click("Save and Find More Questions", btnSaveAndFind, driver);	
		}
		
		//Description:Select level from the list and verify the table
		public void selectSingleLevel(Map<String,String> dataMap) {
			List<WebElement> level = driver.findElements(By.xpath("//tr//select[@name='difficulty']"));
			for(WebElement listlevel:level ){
				ResultUtil.report("MESSAGE", listlevel.getText(), driver);
				Combobox.selectItemByIndex("Chapter",listlevel, 1, driver);	
			}
			Button.click("Go Button", gobtn, driver);
			
			driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='Easy']"));
			Combobox.isEnabled(drpLearningObjectives,"Learning Objectives", driver);
			Button.click("Save and Find More Questions", btnSaveAndFind, driver);
		}
		
		//Description: Select Source from the list and verify the table
		public void selectSingleSource(Map<String,String> dataMap) {
			List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
			for(WebElement listsource:source ){
				ResultUtil.report("MESSAGE", listsource.getText(), driver);
				Combobox.selectItemByIndex("Chapter",listsource, 3, driver);	
			}
			Button.click("Go Button", gobtn, driver);
			String questionSource = dataMap.get("AssignmentSource");
			driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+questionSource+"']"));
			Combobox.isEnabled(drpLearningObjectives,"Learning Objectives", driver);
			Button.click("Save and Find More Questions", btnSaveAndFind, driver);
		}
		
		//Description: Select Chapter, Level and Source from the list and verify the table
		public void selectSingleChapterSingleLevelSingleSource(Map<String,String> dataMap) {
			List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
			for(WebElement list:chapter ){
				ResultUtil.report("MESSAGE", list.getText(), driver);
				Combobox.selectItemByIndex("Chapter",list, 0, driver);	
				
			}
			List<WebElement> level = driver.findElements(By.xpath("//tr//select[@name='difficulty']"));
			for(WebElement listlevel:level ){
				ResultUtil.report("MESSAGE", listlevel.getText(), driver);
				Combobox.selectItemByIndex("Chapter",listlevel, 1, driver);	
			}
			List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
			for(WebElement listsource:source ){
				ResultUtil.report("MESSAGE", listsource.getText(), driver);
				Combobox.selectItemByIndex("Chapter",listsource, 3, driver);	
			}
			Button.click("Go Button", gobtn, driver);
			String questionSource = dataMap.get("AssignmentSource");
			driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+questionSource+"']"));
			Combobox.isEnabled(drpLearningObjectives,"Learning Objectives", driver);
			Button.click("Save and Find More Questions", btnSaveAndFind, driver);
		}
		
		//Description: Select Chapter, Level and Source from the list and Select Learn Objective from the dropdown
		public void SelectLearningObjective(Map<String,String> dataMap) {
			List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
			for(WebElement list:chapter ){
				ResultUtil.report("MESSAGE", list.getText(), driver);
				Combobox.selectItemByIndex("Chapter",list, 0, driver);		
			}
			List<WebElement> level = driver.findElements(By.xpath("//tr//select[@name='difficulty']"));
			for(WebElement listlevel:level ){
				ResultUtil.report("MESSAGE", listlevel.getText(), driver);
				Combobox.selectItemByIndex("Difficulty",listlevel, 1, driver);	
			}
			List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
			for(WebElement listsource:source ){
				ResultUtil.report("MESSAGE", listsource.getText(), driver);
				Combobox.selectItemByIndex("Owner",listsource, 3, driver);	
			}
			Button.click("Go Button", gobtn, driver);
			String questionSource = dataMap.get("AssignmentSource");
			driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+questionSource+"']"));
			Combobox.isEnabled(drpLearningObjectives,"Learning Objectives", driver);
			Combobox.selectItemByIndex("Learning Objective", drpLearningObjectives, 3, driver);
			Button.click("Go Button", btnLearningObjective, driver);
			
			driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+questionSource+"']"));
		}
		
		//Description: Verify the Alert Message When no question selected
		public void verifyAlertMessage(Map<String,String> dataMap) {
				
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			//driver.switchTo().alert().accept();
		}
		
		//Description: Select Back button Navigate to Select Questions screen
		public void selectBackButtonNavigate() {
			
			Button.click("BackButton", btnBack, driver);
			
		}
		
		//Description: Select Cancel button and navigate Assignment Page
		public void selectCancelButton() {
			Button.click("Cancel Button", btnCancel, driver);
					
		}
		
		//Description: Verify Page navigator after selecting the 
		public void verifyPageNavigator(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyPageNavigator", driver);
			String strFirstValue = dataMap.get("PageNavigator1");
			Combobox.selectItemByValue("Page 1", drpdownPageNavigator, strFirstValue, driver);
			Button.click("Go Button", btngoPageNavigator, driver);	
			List<WebElement> listcheckbox = driver.findElements(By.xpath(strPlainTableXpath+"//tr//input[@type='checkbox']"));
			listcheckbox.size();				
			for(int i=1;i<=listcheckbox.size();i++)
			{
				//Remove the not equals condition and add checkbox condition
				if((i==2 || i==3 || i==4)){
					WebElement checkboxclick = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
					checkboxclick.click();	
				}
			}
			String strSecondValue = dataMap.get("PageNavigator2");
			Combobox.selectItemByValue("Page 2", drpdownPageNavigator, strSecondValue, driver);
			Button.click("Go Button", btngoPageNavigator, driver);
			
			Combobox.selectItemByValue("Page 1", drpdownPageNavigator, strFirstValue, driver);
			Button.click("Go Button", btngoPageNavigator, driver);	
		}
		
		//Description: Select All questions displayed in the list
		public void selectAllQuestion(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAllQuestion", driver);
			Checkbox.check("CheckAll", chkboxCheckAllQuestions, driver);
		}
		
		//Description: UnCheck few question from the list
		public void unSelectQuestionsInList() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>unSelectQuestionsInList", driver);
			int removecolumn;
			List<WebElement>scoreElement = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			for(int i=1;i<=scoreElement.size();i++){
				List<WebElement> scorecolumn = driver.findElements(By.xpath(strPlainTableXpath+"//tr["+i+"]/td"));
	    		for(int j=1;j<=scorecolumn.size();j++){
	    			WebElement displayedscoretext = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td["+j+"]"));
	    			displayedscoretext.getText();
	    		}        	
			}			
			scoreElement.size();
			int removeelement = (scoreElement.size())-2;
				if((scoreElement.size())==4){
					Button.click("NextButton", btnNext, driver);
				}
				else{
					removecolumn = rand.nextInt(removeelement);
					
					if(!(removecolumn==0 || removecolumn==1)){
						WebElement removelink = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+removecolumn+"]/td/input[@type='checkbox']"));
						removelink.click();
						Button.click("NextButton", btnNext, driver);
					}
					else{
					       if((removecolumn==0))
					    	   removecolumn =removecolumn+2;
					       if((removecolumn==1))
					    	   removecolumn =removecolumn+1;					       
					       	WebElement removelink = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+removecolumn+"]/td/input[@type='checkbox']"));
							removelink.click();
					}
				}
		}
		
		//Describe: Uncheck All Questions from the list
		public void unCheckAllQuestionAndVerifyAlert(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>unCheckAllQuestionAndVerifyAlert", driver);
			
			if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllQuestions, driver)){
				
				Checkbox.check("Check All Question", chkboxCheckAllQuestions, driver);
				Checkbox.unCheck("Uncheck All Questions", chkboxCheckAllQuestions, driver);
				
			}
			else{
				Checkbox.unCheck("Uncheck All Questions", chkboxCheckAllQuestions, driver);
			}
			btnNext.click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);			
			driver.switchTo().alert().accept();
		}
		
		//Description: Verify select All checkbox in the question table
		public void selectAllQuestionCheckBox(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>> selectAllQuestionCheckBox", driver);
			if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllQuestions, driver)){
				Checkbox.check("CheckAll", chkboxCheckAllQuestions, driver);
			}
			
		}
		
		//Description: Uncheck question from the list
		public void unCheckQuestion() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>> unCheckQuestion", driver);
			
			if(Checkbox.isChecked("CheckAll", chkboxCheckAllQuestions, driver)){
				Checkbox.unCheck("Uncheck", chkboxUncheck, driver);
			}				
		}
		
		//Description: Select Question which is Unselected in previous step
		public void selectUnselectedQuestion(Map<String,String> dataMap)  {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>> selectUnselectedQuestion", driver);
			
			if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllQuestions, driver)){
				Checkbox.check("Uncheck", chkboxUncheck, driver);
			}
			Checkbox.isChecked("CheckAll", chkboxCheckAllQuestions, driver);
			
		}
		
		//Description: Navigate to next page of the question list and Click next button
		public void navigateToNextPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>navigateToNextPage", driver);
			
			if(Checkbox.isChecked("CheckAll", chkboxCheckAllQuestions, driver)){
				String strSecondvalue = dataMap.get("PageNavigator2");
				Combobox.selectItemByValue("Page 2", drpdownPageNavigator, strSecondvalue, driver);
				Button.click("Go Button", btngoPageNavigator, driver);
				
			}
			Checkbox.isUnchecked("CheckAll", chkboxCheckAllQuestions, driver);
		}
		
		//Description: Navigate to previous page to validate Select All Check box 
		public void navigateToPreviousPage(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>navigateToPreviousPage", driver);
			
			if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllQuestions, driver)){
			Combobox.selectItemByIndex("Page 1", drpdownPageNavigator, 0, driver);
			Button.click("Go Button", btngoPageNavigator, driver);			
			}
		}

		//Description: Verify Question table present with selected question
		public void verifyQuestionTable() {	
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySelectedQuestion", driver);
			List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			tableList.size();				
			for(int i=1;i<=tableList.size();i++){
					WebElement tableContent = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td"));
					ResultUtil.report("MESSAGE", tableContent.getText(), driver);		
			}
		}
		
		//Click Next Button
		public void selectNextButton() {			
			btnNext.click();
					
		}
		
		//Description: Verify Default Value in Score column
		public void verifyDefaultValueofScoreColumn(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyDefaultValueofScoreColumn", driver);
			String _scoreValue = dataMap.get("ScoreDefaultValue");
			String questiontextbox = dataMap.get("NonAlgorthimQuestion");
			WebElement txtScore = driver.findElement(By.xpath(strPlainTableXpath+"//tr[.//td/a[.='"+questiontextbox+"']]//td[./input[@name='score']]//input"));
			TextBox.verifyValue("ScoreDefaultValue", txtScore, _scoreValue, driver);
		}
		
		//Description: Change Score value and verify the Total
		public void changeScoreValue(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>changeScoreValue", driver);
			WebElement totalScore=driver.findElement(By.xpath(strTotalScoreXpath));
			String _totalScore = dataMap.get("TotalScoreValue");
			Element.verify("TotalScoreValue", totalScore, _totalScore, driver);
			String _changeValue = dataMap.get("ChangeScoreValue");
			String questiontextbox = dataMap.get("NonAlgorthimQuestion");
			WebElement txtScore = driver.findElement(By.xpath(strPlainTableXpath+"//tr[.//td/a[.='"+questiontextbox+"']]//td[./input[@name='score']]//input"));
			txtScore.clear();
			TextBox.enterValue("ChangeScoreValue", txtScore, _changeValue, driver);
			txtScore.sendKeys(Keys.ENTER);	
		}
		
		//Description: Verify Total Score value
		public void verifyTotalScorevalue(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyTotalScorevalue", driver);
			String _totalScore = dataMap.get("TotalScoreValue 1");
			WebElement totalScore=driver.findElement(By.xpath(strTotalScoreXpath));
			Element.verify("TotalScoreValue", totalScore, _totalScore, driver);	
		}
		
		//Description: Enter Symbols in Score Textbox
		public void enterSybmbolInScoreValue(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>enterSybmbolInScoreValue", driver);
			String questiontextbox = dataMap.get("NonAlgorthimQuestion");
			WebElement txtScore = driver.findElement(By.xpath(strPlainTableXpath+"//tr[.//td/a[.='"+questiontextbox+"']]//td[./input[@name='score']]//input"));
			txtScore.clear();
			String symbol = dataMap.get("SymbolValue");
			TextBox.enterValue("SymbolValue", txtScore, symbol, driver);
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			driver.switchTo().alert().accept();
		}
		
		//Description: Enter Highest Value more than 100 
		public void enterHighestValues(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>enterHighestValues", driver);
			String questiontextbox = dataMap.get("NonAlgorthimQuestion");
			String strTextScoreXpath= "//table[contains(@class,'plain-table')]//tr[.//td/a[.='"+questiontextbox+"']]//td[./input[@name='score']]//input";
			WebElement txtScore = driver.findElement(By.xpath(strTextScoreXpath));
			txtScore.clear();
			String highestValue = dataMap.get("HighestValue").trim();
			driver.findElement(By.xpath(strTextScoreXpath)).sendKeys(highestValue);;						
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			driver.switchTo().alert().accept();
		}
		
		//Description: Enter Least Value less than 1
		public void enterDecimalValue(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>enterDecimalValue", driver);
			String questiontextbox = dataMap.get("NonAlgorthimQuestion");
			String strTextScoreXpath= "//table[contains(@class,'plain-table')]//tr[.//td/a[.='"+questiontextbox+"']]//td[./input[@name='score']]//input";
			WebElement txtScore = driver.findElement(By.xpath(strTextScoreXpath));
			txtScore.clear();
			String decimalValue = dataMap.get("DecimalValue");
			driver.findElement(By.xpath(strTextScoreXpath)).sendKeys(decimalValue);;					
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);			
			driver.switchTo().alert().accept();
			
		}
		
		public void navigateToDescribeAssignmentTab() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>navigatingToDescribeAssignmentTab", driver);
			WebElement describeAssignmentTab = driver.findElement(By.xpath("//div[@class='title'][.='1. Describe Assignment']"));
			Button.click("Navigate To Describe Assignment screen", describeAssignmentTab, driver);
			
		}
		
		public void navigateToSelectQuestionTab() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>navigateToSelectQuestionTab", driver);
			WebElement selectQuestion = driver.findElement(By.xpath("//div[@class='title'][.='2. Select Questions']"));
			Button.click("Navigate To Select Question Tab", selectQuestion, driver);
			
		}
		
		public void navigateToSetQuestionsPoliciesTab(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>navigateToSelectQuestionTab", driver);
			WebElement selectSetQuestionPolicies = driver.findElement(By.xpath("//div[@class='title'][.='4. Set Question Policies']"));
			Button.click("Navigate To Select Set Question Policy Tab", selectSetQuestionPolicies, driver);
			
		}
		
		public void verifySelectedQuestion() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySelectedQuestion", driver);
			List<WebElement> listcheckbox = driver.findElements(By.xpath(strPlainTableXpath+"//tr//input[@type='checkbox']"));
			listcheckbox.size();				
			for(int i=1;i<=listcheckbox.size();i++){
				//Remove the not equals condition and add checkbox condition
				if((i==2 || i==3 || i==4 ||i==5 ||i==6)){
					WebElement checkboxclick = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
					ResultUtil.report("MESSAGE",checkboxclick.getText(),driver);	
				}
			}
		}
		
		public void navigateToOrganizeAndScoreTab() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>navigateToOrganizeAndScoreTab", driver);
			WebElement scorequestions = driver.findElement(By.xpath("//li[@class='tab active']")); 
			Button.click("Navigate To Organzie And Score Tab", scorequestions, driver);
			
		}
		
		public void selectGo()
		{
			ResultUtil.report("INFO", "CreateEditAssignment>>>selectGo", driver);
			Button.click("Go", go, driver);
			
		}
		
		public void verifyPageElements()
		{
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifyPageElements", driver);
			
			Radiobutton.select("Printed Test",rdobtn4 , driver);
			Element.verify("Assignment ID", driver, "CLASS_NAME", "input100");
			Element.verify("Assignment Name", driver, "CLASS_NAME", "input200");
			Element.verify("Descriptions", driver, "NAME", "ag_descr");
			Element.verify("Next Button", driver, "ID", "Next");
			Element.verify("Question/Exercise Type", driver, "ID", "ag_type1");
			Element.verify("Display to Students", driver, "ID", "ag_descr1");
			Element.verify("Reading/Resources Type", driver, "XPATH", "//input[@value='2']");
			Element.verify("Survey Type", driver, "XPATH", "//input[@value='4']");
			Element.verify("Printed Test Type", driver, "XPATH", "//input[@value='8']");
			Element.verify("Make Available", driver, "ID", "sharing1");
			Element.verify("Do not share", driver, "ID", "sharing2");
			Element.verify("Work in draft", driver, "ID", "sharing3");
			Element.verify("Cancel Button", driver, "ID", "Cancel");			
		}

		//Description: Enter Fraction value 
		public void enterFractiolValue(Map<String,String> dataMap) {
			String questiontextbox = dataMap.get("NonAlgorthimQuestion");
			WebElement txtScore = driver.findElement(By.xpath(strPlainTableXpath+"//tr[.//td/a[.='"+questiontextbox+"']]//td[./input[@name='score']]//input"));
			txtScore.clear();
			String fractionValue = dataMap.get("FractionValue");
			TextBox.enterValue("Value- 5.6", txtScore, fractionValue, driver);
		}

		public void verifyVersionDropbox(){	
			WebElement versionbox=driver.findElement(By.xpath("//select[@name='ctb_versions']"));
			Select select=new Select(versionbox);
			List<WebElement>versionOptions = select.getOptions();
			for (WebElement versiondbox: versionOptions){	
				ResultUtil.report("PASS", versiondbox.getText()+" verified", driver);	
			}
		}
		
		public void selectVersion1(){
			Combobox.selectItemByIndex("Version No.", drpboxVersion, 0, driver);
		}
		
		public void selectVersion2(){
			Combobox.selectItemByIndex("Version No.", drpboxVersion, 1, driver);
		}

		public void selectVersion10(){
			Combobox.selectItemByIndex("Version No.", drpboxVersion, 9, driver);
		}

		public void openAssignmentVersion1(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>openAssignmentVersion1", driver);
			String assign=dataMap.get("AssignmentValue1");
			WebElement opnAssign=driver.findElement(By.xpath("//a[.='"+assign+"']"));
			Link.click(assign, opnAssign, driver);
			
		}
		
		public void openAssignmentVersion2(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>openAssignmentVersion2", driver);
			String assign=dataMap.get("AssignmentValue2");
			WebElement opnAssign=driver.findElement(By.xpath("//a[.='"+assign+"']"));
			Link.click(assign, opnAssign, driver);
		}
		
		public void openAssignmentVersion10(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>openAssignmentVersion10", driver);
			String assign=dataMap.get("AssignmentValue10").trim();
			WebElement opnAssign=driver.findElement(By.xpath("//a[.='"+assign+"']"));
			Link.click(assign, opnAssign, driver);
		}
		
		public void openPreviewWithoutAnswer(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>openPreviewWithoutAnswe", driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			Link.click("without Answers", withoutAnswer, driver);
			
		}
		
		public void downloadSelected(){
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			Button.click("Download Selected", downloadSelected , driver);
		}
		
		public void verifyScramble(){
			if(scramble.isEnabled()){
				Checkbox.isUnchecked("ScrambleQuestions", scramble, driver);
			}
		}
			
		public void selectCloseButton(){
			Button.click("Close", close, driver);
		}
		
		public void openPreviewWithAnswer(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>openPreviewWithAnswer", driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			Checkbox.check("Include Answers", includeAnswer , driver);	
			Link.click("with answer", withAnswer, driver);
		}
		
		public void checkScramble(){
			if(scramble.isEnabled()){
				Checkbox.check("Scramble Question", scramble, driver);
			}
		}
		
		public void verifyAdditionalSettings(){
			Element.verify("Additional Settings", additional, driver);
		}
		
		public void verifyAndClickConfigure(){
			Link.click("Configure Page Setup", configure, driver);
		}
		
		public void verifyConfigurePage(){
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			String title=driver.getTitle();
			if(title.equals("Page Setup")){
				Element.verify("Page Layout", pageLayout, driver);
				Element.verify("No of lines", noOfLines, driver);
				if(conDrpBox.isDisplayed()){
					Select select=new Select(conDrpBox);
					List<WebElement>versionOptions = select.getOptions();
					for (WebElement versiondbox: versionOptions){
						ResultUtil.report("PASS", versiondbox.getText()+" verified", driver);
					}					
				}
				else{
					ResultUtil.report("No of lines drop down", "is not displayed", driver);
				}
				Element.verify("Page Breaks", pageBreaks, driver);
				Radiobutton.verify("Page breaks no button",noRdobtn, driver);
				Element.verify("Header", header, driver);
				Checkbox.verify("masthead info", masthead, driver);
				Checkbox.verify("Assignment title", shwTitle, driver);
				Checkbox.verify("Assignment version", shwVersion, driver);
				Checkbox.verify("Student Name Holder", shwName, driver);
				Checkbox.verify("Header Text", shwHeadText, driver);
				Checkbox.verify("Current Date", shwDate, driver);
				Element.verify("Footer", footer, driver);
				Checkbox.verify("Footer first page", footerFirst, driver);
				Checkbox.verify("Footer Page Number ", footerPage, driver);
				Checkbox.verify("Footer Text", footerText, driver);
				Checkbox.verify("Save Preference", savePref, driver);
				Button.verify("Update Button", updateBtn, driver);			
			}
		}
		
		public void closeWindow1(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>closeWindow1", driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			this.driver.close();
			ResultUtil.report("PASS", "Window Closed", driver);
		}
		
		public void closeWindow2(){
			ResultUtil.report("INFO", "CreateEditAssignment>>> closeWindow2", driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
			this.driver.close();
			ResultUtil.report("PASS", "Window Closed", driver);
		}
		
		public void verifyExplanation(){
			ResultUtil.report("INFO", "CreateEditAssignment>>> verifyExplanation", driver);
			Element.verify("Explanation", explanation, driver);
		}
		
		public void verifyOrganizeTab(){
			ResultUtil.report("INFO", "CreateEditAssignment>>> verifyOrganizeTab", driver);
			Element.verify("Organize Questions", organizeTab, driver);
		}
		
		public void verifyQuestionCount(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifyQuestionCount", driver);
			Element.verify("Total no of questions", driver, "XPATH", strPlainTableXpath+"//tr[4]");
		}
		
		public void removeAllQuestions(){
			ResultUtil.report("INFO", "CreateEditAssignment>>> removeAllQuestions", driver);
			List<WebElement>questions=driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			int ques=questions.size()-2;
			for(int i=1;i<=ques;i++){
			Link.click("Remove", removeAll, driver);
			}
		}
		public void removeOneQuestion(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>removeOneQuestions", driver);
			Link.click("Remove", remove, driver);
		}
		
		public void navigateAndCheckScramble(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>navigateAndCheckScramble", driver);
			Button.click("Describe Assignment", navigateToDescribe, driver);
			Combobox.selectItemByIndex("Version DropBox", drpboxVersion, 1, driver);
			if(scramble.isSelected()){
				Checkbox.unCheck("Scramble question", scramble, driver);
			}
			else{
				Checkbox.check("Scramble question", scramble, driver);
			}
		}
		
		public void verifyOrder(){			
			ResultUtil.report("INFO", "CreateEditAssignment>>> verifyOrder", driver);
			if(order.isEnabled()){
				ResultUtil.report("MESSAGE", "ComboBox is Enabled", driver);
			}
			else{
				 ResultUtil.report("MESSAGE", "ComboBox is Disabled", driver);
			}
		}
		
		
		//Description: Verify Order of the questions
		public List<WebElement> verifyQuestionOrder(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignment>>> verifyQuestionOrder", driver);
			List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
			List<WebElement> elmntQuestionScore = new ArrayList<WebElement>();
			//List of rows displayed
			List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			elmntQuestionsDisplayed.size();
			//Adding question name and the question score in arrays
			for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++){
				WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
				elmntQuestionNames.add(elmntQuestionName);
				ResultUtil.report("MESSAGE", elmntQuestionName.getText(), driver);
				WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[./a[not(text()='Remove' or text()='Duplicate')]]]["+i+"]/td[.//option]//option[@selected='selected']"));
				elmntQuestionScore.add(elmntScoreValue);
				ResultUtil.report("MESSAGE", elmntScoreValue.getText(), driver);
			}		
			return elmntQuestionNames;
		}
		
		//Description: Check the possible value of the order like if 5 question are selected then order dropdown also should display 5
		public List<WebElement> checkPossibleValues(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignment>>>checkPossibleValues", driver);
			List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
			List<WebElement> elmntQuestionScore = new ArrayList<WebElement>();
			//List of rows displayed
			List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			elmntQuestionsDisplayed.size();
			//Adding question name and the question score in arrays
			for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++){
				WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
				elmntQuestionNames.add(elmntQuestionName);
				ResultUtil.report("MESSAGE", elmntQuestionName.getText(), driver);
				for(int j=1; j<=5;j++){
				WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[./a[not(text()='Remove' or text()='Duplicate')]]]["+j+"]/td[.//option]//option[@selected='selected']"));
				elmntQuestionScore.add(elmntScoreValue);
				ResultUtil.report("MESSAGE", elmntScoreValue.getText(), driver);
				}
			}		
			return elmntQuestionNames;	
		}
		
		//Description: Change Third Question order 3 to 1
		public void changeQuestionOrder(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignment>>>changeQuestionOrde", driver);
			List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
			List<WebElement> elmntQuestionScore = new ArrayList<WebElement>();
			//List of rows displayed
			List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath("//table[contains(@class,'plain-table')]//tr"));
			elmntQuestionsDisplayed.size();
			
			//Adding question name and the question score in arrays
			for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++){
				WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
				elmntQuestionNames.add(elmntQuestionName);
				ResultUtil.report("MESSAGE", elmntQuestionName.getText(), driver);
				
				if(i==3){					
				WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td//option]["+i+"]//td//select"));
				String strOrderValue = dataMap.get("QuestionOrder");
				Combobox.selectItemByValue("Order 1", elmntScoreValue, strOrderValue, driver);
				break;
				}else{
					WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[./a[not(text()='Remove' or text()='Duplicate')]]]["+i+"]/td[.//option]//option[@selected='selected']"));
					elmntQuestionScore.add(elmntScoreValue);
					ResultUtil.report("MESSAGE", elmntScoreValue.getText(), driver);
				}
			}		
		} 
				
		public void verifyConfirmationPage(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifyConfirmationPage", driver);
			Link.verify("Confirmation tab", confirmationTab, driver);
			WebElement versionNo=driver.findElement(By.xpath("//table[2]//tr[2]/td[2]"));
			String versionConfirm=versionNo.getText();
			
			if(version.equals(versionConfirm)){
				ResultUtil.report("PASS", "Version number is validated", driver);
			}
			WebElement scramble=driver.findElement(By.xpath("//table[2]//tr[3]/td[2]"));
			String scrambleverify=scramble.getText();
			Element.verify("Scramble Questions", scramble,scrambleverify, driver);
			WebElement noOfLines=driver.findElement(By.xpath("//table[2]//tr[5]/td[2]"));
			String nooflines=noOfLines.getText();
			Element.verify("No of Lines",noOfLines, nooflines, driver);
			WebElement pageBreaks=driver.findElement(By.xpath("//table[2]//tr[6]/td[2]"));
			String pagebreaks=pageBreaks.getText();
			Element.verify("Page breaks", pageBreaks, pagebreaks, driver);
			WebElement changeValues=driver.findElement(By.xpath("//table[2]//tr[8]/td[2]"));
			String changevalue=changeValues.getText();
			Element.verify("Change Value", changeValues, changevalue, driver);
			WebElement numericQuestions=driver.findElement(By.xpath("//table[2]//tr[9]/td[2]"));
			String numericquestions=numericQuestions.getText();
			Element.verify("Numeric Questions", numericQuestions, numericquestions, driver);
		}
		
		
		public void verifyAssignmentProperties(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifyAssignmentProperties", driver);
			WebElement versionNo=driver.findElement(By.xpath("//td[.='Number of versions:']/following-sibling::td"));
			String versionConfirm=versionNo.getText();
			
			if(version.equals(versionConfirm)){
				ResultUtil.report("PASS", "Version number is validated", driver);
			}
			WebElement scramble=driver.findElement(By.xpath("//td[.='Scramble questions:']/following-sibling::td"));
			String scrambleverify=scramble.getText();
			Element.verify("Scramble Questions", scramble,scrambleverify, driver);
			WebElement noOfLines=driver.findElement(By.xpath("//td[contains(.,'lines')]/following-sibling::td"));
			String nooflines=noOfLines.getText();
			Element.verify("No of Lines",noOfLines, nooflines, driver);
			WebElement pageBreaks=driver.findElement(By.xpath("//td[contains(.,'breaks')]/following-sibling::td"));
			String pagebreaks=pageBreaks.getText();
			Element.verify("Page breaks", pageBreaks, pagebreaks, driver);
			WebElement changeValues=driver.findElement(By.xpath("//td[contains(.,'Change')]/following-sibling::td"));
			String changevalue=changeValues.getText();
			Element.verify("Change Value", changeValues, changevalue, driver);
			WebElement numericQuestions=driver.findElement(By.xpath("//td[contains(.,'Numeric')]/following-sibling::td"));
			String numericquestions=numericQuestions.getText();
			Element.verify("Numeric Questions", numericQuestions, numericquestions, driver);
		}
		
		public void verifySharing(){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifySharing", driver);
			Radiobutton.verify("Sharing RadioButton 1", sharingRdobtn1, driver);
			Radiobutton.isSelected("Sharing RadioButton 1", sharingRdobtn1, driver);
			Radiobutton.verify("Sharing RadioButton 2", sharingRdobtn2, driver);
			Radiobutton.verify("Sharing RadioButton 3", sharingRdobtn3, driver);
			String text1=sharingText1.getText();
			String cmptext1="Make available to other instructors";
			
			if(text1.equals(cmptext1)){
				ResultUtil.report("PASS", "Sharing text 1 is validated", driver);
			}
			String text2=sharingText1.getText();
			String cmptext2="Make available to other instructors";
			
			if(text2.equals(cmptext2)){
				ResultUtil.report("PASS", "Sharing text 1 is validated", driver);
			}
			String text3=sharingText1.getText();
			String cmptext3="Make available to other instructors";
			
			if(text3.equals(cmptext3)){
				ResultUtil.report("PASS", "Sharing text 1 is validated", driver);
			}	
		}
		 
		public void verifyDate(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifyDate", driver);
			WebElement date=driver.findElement(By.xpath("//td[starts-with(.,'Date')]//following-sibling::td[2]"));
			String Date=date.getText();
			ResultUtil.report("MESSAGE",date.getText(), driver);
			SimpleDateFormat sdfDate = new SimpleDateFormat("M,dd,yyyy,HH:mm,aa");//dd/MM/yyyy
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		    ResultUtil.report("Current Date",strDate, driver);
				 if(Date==strDate){
					 ResultUtil.report("PASS", "Date is verified", driver);
       			}
		}
		
		public void verifySource(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifySource", driver);
			WebElement source=driver.findElement(By.xpath("//td[starts-with(.,'Source')]//following-sibling::td[2]"));
			String Source=source.getText();
			String actualName=dataMap.get("ActualName");
			
			if(Source.equals(actualName)){
				ResultUtil.report("PASS", "The Source name is verified", driver);
			}
		}
		
		public void MyProfile(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>MyProfile", driver);
			Button.click("My Profile", myprofilebtn, driver);			
			String modifyName=dataMap.get("ModifyName");
			TextBox.enterValue("LastName", lastName, modifyName, driver);	
			
			Button.click("Update", updateMyProfile, driver);
			
		}
		
		public void verifyModifiedSource(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignment>>>verifyModifiedSource", driver);
			WebElement source=driver.findElement(By.xpath("//td[starts-with(.,'Source')]//following-sibling::td[2]"));
			String Source=source.getText();
			String modifyName=dataMap.get("ModifyName");
			if(Source.equals(modifyName)){
				ResultUtil.report("PASS", "The Source name is verified", driver);
			}
		}
		
		public void assignmentLink(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>assignmentLink", driver);
			Link.click("Assignments", assignmentLnk, driver);
		}
		
		
		public void selectRequiredShowWork() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectRequiredShowWork", driver);
			List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
			List<WebElement> elmntQuestionScore = new ArrayList<WebElement>();
			//List of rows displayed
			List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath("strPlainTableXpath+//tr"));
			elmntQuestionsDisplayed.size();
			//Adding question name and the question score in arrays
			for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++){
				WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
				elmntQuestionNames.add(elmntQuestionName);
				ResultUtil.report("MESSAGE",elmntQuestionName.getText(), driver);
				if(i==3||i==4){					
				WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td//option]["+i+"]//td//input[@type='checkbox']"));
				if(Checkbox.isUnchecked("CheckBox is unchecked", elmntScoreValue, driver)){
					Checkbox.check("Review Score Checked", elmntScoreValue, driver);
				}else{
					Checkbox.unCheck("Review Score Unchecked", elmntScoreValue, driver);
					}
				break;
				}else{
					WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[./a[not(text()='Remove' or text()='Duplicate')]]]["+i+"]/td[.//option]//option[@selected='selected']"));
					elmntQuestionScore.add(elmntScoreValue);
					ResultUtil.report("MESSAGE",elmntScoreValue.getText(), driver);
					}	
				}	
			}
		
		public void verifyShowWorkCheckbox() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyShowWorkCheckbox", driver);
			if(checkboxShowWork.isEnabled()){
				Checkbox.check("Check Show Work", checkboxShowWork, driver);
			}else{
				ResultUtil.report("PASS", "Show Work Disable Checkbox is Disabled", driver);	
			}
		}
		
		public void verifyPointPotentialSetting(Map<String,String> dataMap) {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyPointPotentialSetting", driver);
			String strSetQuestionPolicies = dataMap.get("SetQuestionPolicies");
			String strQuestionPoliciesXpath= "//td[@class='content-area-top']//tr[./td[.='"+strSetQuestionPolicies+"']]";
			
			if(Element.verify("Question Policies", driver, "XPATH", strQuestionPoliciesXpath)){
				WebElement selectPolicies = driver.findElement(By.xpath(strQuestionPoliciesXpath+"//td/input[@type='checkbox']"));
				Checkbox.unCheck("Verify PointPotential Setting", selectPolicies, driver);
			}
		}
		
		public void selectPointPotentialAndVerifyPossibleValues(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectPointPotentialAndVerifyPossibleValues", driver);
			WebElement selectPolicies = driver.findElement(By.xpath("//input[@name='ag_use_penalties_control']"));
			Checkbox.check("Verify PointPotential Setting", selectPolicies, driver);
			
		}
		
		public void verifyAttemptsAndPolicy(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyAttemptsAndPolicy", driver);
			WebElement attempts = driver.findElement(By.xpath("//tr[./td[.='Question Attempts:']]//td//select[@id='ag_attempts']"));
			
			if(Combobox.isEnabled(attempts, "No. of Attempts", driver)){
				String strattemptValue = "1 attempt";
				Combobox.selectItemByValue("1 attempt", attempts, strattemptValue, driver);
				String strPossibleAttemptsXpath="//tr[./td[.='Attempt Policy:']]//td//select[@name='ag_assistance_apolicy']";
				Element.verify("Verify Possible Attempts", driver, "xpath", strPossibleAttemptsXpath);
				WebElement possibleAttempts = driver.findElement(By.xpath(strPossibleAttemptsXpath));
				ResultUtil.report("MESSAGE",possibleAttempts.getText(), driver);
			}
		}
		
		public void verifyPossibleAttemptsAndAttempts(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyPossibleAttemptsAndAttempts", driver);
			WebElement attempts = driver.findElement(By.xpath(strQuestionAtempts));	
			String strattemptValue = "2 attempts";
			Combobox.selectItemByValue("2 attempt", attempts, strattemptValue, driver);
			WebElement possibleAttempts = driver.findElement(By.xpath(strPossibleAttempts));
			ResultUtil.report("MESSAGE",possibleAttempts.getText(), driver);
		}
		
		public void selectUnlimitedAttempts() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectUnlimitedAttempts", driver);
			WebElement attempts = driver.findElement(By.xpath(strQuestionAtempts));
			String strattemptValue = "Unlimited";
			Combobox.selectItemByValue("Unlimited", attempts, strattemptValue, driver);
			WebElement possibleAttempts = driver.findElement(By.xpath(strPossibleAttempts));
			ResultUtil.report("MESSAGE",possibleAttempts.getText(), driver);
		}
		
		public void unCheckPointPotentialSetting(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyPointPotentialSetting", driver);
			String strSetQuestionPolicies = dataMap.get("SetQuestionPolicies");
			WebElement selectPolicies = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.='"+strSetQuestionPolicies+"']]//td/input[@type='checkbox']"));
			Checkbox.unCheck("Verify PointPotential Setting", selectPolicies, driver);
			
		}
		
		public void checkDefaultStateOfAttemptsAndAssistance(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>checkDefaultStateOfAttemptsAndAssistance", driver);			
			WebElement attempts = driver.findElement(By.xpath("//tr[./td[.='Question Attempts:']]//td//select[@id='ag_attempts']"));
			Combobox.isEnabled(attempts, "Check default State", driver);
			ResultUtil.report("MESSAGE",attempts.getText(), driver);
			String strQuestionAssistance="//tr[./td[.='Question Assistance:']]//parent::td//following-sibling::td";
			WebElement showLinks = driver.findElement(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_links']"));
			ResultUtil.report("MESSAGE",showLinks.getText(),driver);
			WebElement showSolution = driver.findElement(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_solutions']"));
			ResultUtil.report("MESSAGE",showSolution.getText(),driver);
			WebElement showAnswer =driver.findElement(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_answer']"));
			ResultUtil.report("MESSAGE",showAnswer.getText(),driver);
		}
		
		public void setQuestionAttempts(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>setQuestionAttempts", driver);
			List<WebElement> elmntattempts = new ArrayList<WebElement>();
			List<WebElement> elmntShowLinks = new ArrayList<WebElement>();
			List<WebElement> elmntShowSolutions = new ArrayList<WebElement>();
			List<WebElement> elmntShowAnswers = new ArrayList<WebElement>();
			String strQuestionsAttemptsXpath= "//tr[./td[.='Question Attempts:']]//td//select[@id='ag_attempts']";
			List<WebElement> elmntAttemptsDisplayed = driver.findElements(By.xpath(strQuestionsAttemptsXpath));
			elmntAttemptsDisplayed.size();
			//Adding question name and the question score in arrays
			for(int i=1;i<6;i++){
				WebElement elmntattempt = driver.findElement(By.xpath(strQuestionsAttemptsXpath));
				elmntattempts.add(elmntattempt);
				ResultUtil.report("MESSAGE",elmntattempt.getText(),driver);
				Combobox.selectItemByIndex("Select Attempts", elmntattempt, i, driver);		
				String strQuestionAssistance="//tr[./td[.='Question Assistance:']]//parent::td//following-sibling::td";
				WebElement elmntShowLink = driver.findElement(By.xpath(strQuestionAssistance+"//tr[./td[.='Question Assistance:']]//parent::td//following-sibling::td/select[@name='ag_assistance_links']//option["+i+"]"));
				elmntShowLinks.add(elmntShowLink);
				ResultUtil.report("MESSAGE",elmntShowLink.getText(),driver);
				WebElement elmntShowSolution = driver.findElement(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_solutions']//option["+i+"]"));
				elmntShowSolutions.add(elmntShowSolution);
				ResultUtil.report("MESSAGE",elmntShowSolution.getText(),driver);
				WebElement elmntShowAnswer = driver.findElement(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_answer']//option["+i+"]"));
				elmntShowAnswers.add(elmntShowAnswer);
				ResultUtil.report("MESSAGE",elmntShowAnswer.getText(),driver);
			}
		}
		
		public void setUnlimtedAttempts(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>setUnlimtedAttempts", driver);
			WebElement attempts = driver.findElement(By.xpath(strQuestionAtempts));
			Combobox.selectItemByValue("Unlimited Attempts", attempts, "Unlimited", driver);
			String strQuestionAssistance="//tr[./td[.='Question Assistance:']]//parent::td//following-sibling::td";
			Element.verify("Show Links", driver, "xpath", strQuestionAssistance+"/select[@name='ag_assistance_links']");
			Element.verify("Show Solutions", driver, "xpath", strQuestionAssistance+"/select[@name='ag_assistance_solutions']");
			Element.verify("Show Answer", driver, "xpath", strQuestionAssistance+"/select[@name='ag_assistance_answer']");
		}
		
		public void checkQuestionAssistance(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>checkQuestionAssistance", driver);
			String strQuestionAssistance="//tr[./td[.='Question Assistance:']]//parent::td//following-sibling::td";
			if(Element.verify("Question Assistance", driver, "xpath", strQuestionAssistance+"/select")){
				Element.verify("Show Links", driver, "xpath", strQuestionAssistance+"/select[@name='ag_assistance_links']");
				Element.verify("Show Solutions", driver, "xpath", strQuestionAssistance+"/select[@name='ag_assistance_solutions']");
				Element.verify("Show Answer", driver, "xpath", strQuestionAssistance+"/select[@name='ag_assistance_answer']");
			}
		}
		
		public void listPossibleValues(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>listPossibleValues", driver);
			String strQuestionAssistance="//tr[./td[.='Question Assistance:']]//parent::td//following-sibling::td";
			List<WebElement> showLink = driver.findElements(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_links']"));
			for(WebElement link:showLink ){
				link.getSize();
			}
			List<WebElement> showSolution = driver.findElements(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_solutions']"));
			for(WebElement solution:showSolution){
				solution.getSize();
			}
			List<WebElement> showAnswer = driver.findElements(By.xpath(strQuestionAssistance+"/select[@name='ag_assistance_answer']"));
			for(WebElement answer:showAnswer){
				answer.getSize();
			}
		}
		
		public void VerifyAndSelectCheckbox() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>VerifyAndSelectCheckbox", driver);
			
			if(Checkbox.isUnchecked("Save Preferences", checkboxSavePreference, driver)){
				Checkbox.check("PointPotential", checkboxPointPotential, driver);
				
				Checkbox.check("Question Feedback", checkboxQuestionFeedback, driver);
				Checkbox.check("Show Work", checkboxShowWork, driver);
				Checkbox.isChecked("SavePrferences", checkboxSavePreference, driver);
			} else{
				Checkbox.unCheck("Question Feedback", checkboxQuestionFeedback, driver);
				Checkbox.unCheck("Show Work", checkboxShowWork, driver);
			}
		}
		
		public void selectPotentialValues(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectPotentialValues", driver);
			WebElement potentialPercentage = driver.findElement(By.xpath("//td/select[@name='ag_assistance_apolicy_penalty']"));
			String potentialvalue = "50% point potential";
			Combobox.selectItemByValue("50% point Potential", potentialPercentage, potentialvalue, driver);
			WebElement potentialShowLinks = driver.findElement(By.xpath("//td/select[@name='ag_assistance_links_penalty']"));
			Combobox.selectItemByValue("50% point Potential", potentialShowLinks, potentialvalue, driver);
			WebElement potentialShowSolution = driver.findElement(By.xpath("//td/select[@name='ag_assistance_solution_penalty']"));
			Combobox.selectItemByValue("50% point Potential", potentialShowSolution, potentialvalue, driver);
			WebElement potentialShowAnswer = driver.findElement(By.xpath("//td/select[@name='ag_assistance_answer_penalty']"));
			Combobox.selectItemByValue("50% point Potential", potentialShowAnswer, potentialvalue, driver);
		}
		
		public void selectAssignLaterButton(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAssignLaterButton", driver);			
			Button.click("Assign Later", btnAssignLater, driver);
			
		}
		
		public void changePotentialValue(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>changePotentialValue", driver);
			WebElement potentialPercentage = driver.findElement(By.xpath("//td/select[@name='ag_assistance_apolicy_penalty']"));
			String potentialvalue = "20% point potential";
			Combobox.selectItemByValue("20% point potential", potentialPercentage, potentialvalue, driver);
			WebElement potentialShowLinks = driver.findElement(By.xpath("//td/select[@name='ag_assistance_links_penalty']"));
			Combobox.selectItemByValue("20% point potential", potentialShowLinks, potentialvalue, driver);
			WebElement potentialShowSolution = driver.findElement(By.xpath("//td/select[@name='ag_assistance_solution_penalty']"));
			Combobox.selectItemByValue("20% point Potential", potentialShowSolution, potentialvalue, driver);
			WebElement potentialShowAnswer = driver.findElement(By.xpath("//td/select[@name='ag_assistance_answer_penalty']"));
			Combobox.selectItemByValue("20% point Potential", potentialShowAnswer, potentialvalue, driver);
		}
		
		public void verifyQuestionsCheckBox(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyQuestionCheckbox", driver);
			WebElement chkbox=driver.findElement(By.xpath(strPlainTableXpath+"//tr[2]//td[1]//input[3]"));
			if (Checkbox.isEnabled(chkbox, "Verify Checkbox", driver)){
				Checkbox.isChecked("Verify ChecKBox", chkbox, driver);
			}	
			else{
				ResultUtil.report("Verify:", "Checkbox is not enabled", driver);
			}
		}
		
		public void changeOrderOfThirdQuestion(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>Organize Question>>changeOrderOfThirdQuestion", driver);
			WebElement order=driver.findElement(By.xpath(strPlainTableXpath+"//tr[4]/td[6]/select"));
			String questionName=driver.findElement(By.xpath(strPlainTableXpath+"//tr[4]/td[1]/a")).getText();
			Combobox.selectFirstItem("Order", order, driver);
			
			String  questionNameSame=driver.findElement(By.xpath(strPlainTableXpath+"//tr[2]/td[1]/a")).getText();
			if(questionName.equals(questionNameSame)){
				ResultUtil.report("PASS", "The order of the question was changed successfully", driver);
			}
		}
		
		public void verifyAssignmentDescription(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>Confirmation>>verifyAssignmentDescription", driver);
			String assgnType=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[2]/td[3]")).getText();
			if(assgnType.equals("Printed Test")){
				ResultUtil.report("PASS", "The assignment type is printed test", driver);
			}
			else{
				ResultUtil.report("FAIL", "The assignment type is not printed test", driver);
			}
			String assgnId=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[3]/td[3]")).getText();
			if(assgnId.equals(dataMap.get("AsgntID").trim())){
				ResultUtil.report("PASS", "The assignment ID" +assgnId+ "and" +dataMap.get("AsgntID")+ "are same", driver);
			}
			else{
				ResultUtil.report("FAIL", "The assignment ID is" +assgnId, driver);
			}
			String assgnName=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[4]/td[3]")).getText();
			if(assgnName.equals(dataMap.get("AsgntName").trim())){
				ResultUtil.report("PASS", "The assignment Name is" +assgnName+ "and" +dataMap.get("AsgntName")+ "are same", driver);
			}
			else{
				ResultUtil.report("FAIL", "The assignment Name is" +assgnName, driver);
			}
			String desc=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[5]/td[3]")).getText();
			if(desc.equals("Display to students ")){
				ResultUtil.report("PASS", "The display to students is checked", driver);
			}
			else{
				ResultUtil.report("FAIL", "The display to students is  not checked", driver);
			}
			String associatedwith=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[6]/td[3]")).getText();
			if(associatedwith.equals("Chapter 1. Accounting in Action")){
				ResultUtil.report("PASS", "The selected chapter is" +associatedwith, driver);
			}
			else{
				ResultUtil.report("FAIL", "Some other chapter is not selected", driver);
			}
			String source=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[7]/td[3]")).getText();
			if(source.equals(dataMap.get("Source"))){
				ResultUtil.report("PASS", "The Source Name" +source+ "and" +dataMap.get("Source")+ "are same", driver);
			}
			else{
				ResultUtil.report("FAIL", "The Source Name" +source+"is not same", driver);
			}
			String date=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[8]/td[3]")).getText();
			if(date.equals("September 12, 2013, 05:06 AM")){
				ResultUtil.report("PASS", "The created Date is" +date, driver);
			}
			else{
				ResultUtil.report("FAIL", "The created Date is" +date+"is not same" , driver);
			}
			String sharing=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[9]/td[3]")).getText();
			if(sharing.equals("Make available to other instructors")){
				ResultUtil.report("PASS", "The sharing policy selected is" +sharing, driver);
			}
			else{
				ResultUtil.report("FAIL", "The sharing policy selected is" +sharing, driver);
			}
		}
		
		public void selectAlgorthimicQuestions() {
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAlgorthimicQuestions", driver);
			String strAlgorthimicXpath="//table[contains(@class,'plain-table')]//tr[./td[contains(.,'Algorithm')]]";
			List<WebElement> listcheckbox = driver.findElements(By.xpath(strAlgorthimicXpath+"/td/input[@type='checkbox']"));
			listcheckbox.size();		
			for(int i=1;i<=listcheckbox.size();i++){
				//Remove the not equals condition and add checkbox condition
				if((i==1 || i==2 || i==3 ||i==4 ||i==5)){
					WebElement checkboxclick = driver.findElement(By.xpath(strAlgorthimicXpath+"["+i+"]/td/input[@type='checkbox']"));
					Checkbox.check("Algorithim Questiosn", checkboxclick, driver);					
					WebElement questionName=driver.findElement(By.xpath(strAlgorthimicXpath+"["+i+"]/td[2]"));
					questionNames.append(questionName);
				}
			}
		}
		
		public void selectNonAlgorthimicQuestions(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectNonAlgorthimicQuestions", driver);
			String strNonAlgorthimicXpath="//table[contains(@class,'plain-table')]//tr[./td[.='Accounting Text-Entry with Dropdown']]";
			List<WebElement> listcheckbox = driver.findElements(By.xpath(strNonAlgorthimicXpath+"/td/input[@type='checkbox']"));
			listcheckbox.size();				
			for(int i=1;i<=listcheckbox.size();i++){
				//Remove the not equals condition and add checkbox condition
				if((i==1 || i==2 || i==3 ||i==4 ||i==5)){
					WebElement checkboxclick = driver.findElement(By.xpath(strNonAlgorthimicXpath+"["+i+"]/td/input[@type='checkbox']"));
					checkboxclick.click();
					WebElement questionName=driver.findElement(By.xpath(strNonAlgorthimicXpath+"["+i+"]/td[2]"));
					questionNames.append(questionName);
				}
			}
		}
			
		public void changeAssignmentNameAndId(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>changeAssignmentNameAndId", driver);
			TextBox.clearValue("Assignment ID", txtAssignId, driver);
			TextBox.enterValue("AssignmentID", txtAssignId, dataMap.get("NewAssginId"), driver);
			TextBox.clearValue("Assignment Name", txtAssignName, driver);
			TextBox.enterValue("Assignment Name", txtAssignName, dataMap.get("NewAssignName"), driver);
			if(Radiobutton.isEnabled(sharingRdobtn3, "Work in draft mode", driver)){
				Radiobutton.select("Work in draft mode", sharingRdobtn3, driver);
			}
			TextBox.clearValue("Description", txtDescrib, driver);
			TextBox.enterValue("Description", txtDescrib, dataMap.get("LongCharacAsgntName"), driver);
		}
		
		public void verifyAssignmentNameAndId(Map<String,String> dataMap,String strAssignmentID){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyAssignmentNameAndId", driver);
			String assgnId=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[3]/td[3]")).getText();
			if(assgnId.equals(dataMap.get(strAssignmentID).trim())){
				ResultUtil.report("PASS", "The assignment ID" +assgnId+ "and" +dataMap.get("NewAssginId")+ "are same", driver);
			}
			else{
				ResultUtil.report("FAIL", "The assignment ID is" +assgnId, driver);
			}
			String assgnName=driver.findElement(By.xpath("//table[2]//preceding-sibling::table//table//tr[4]/td[3]")).getText();
			if(assgnName.equals(dataMap.get("AsgntName").trim())){
				ResultUtil.report("PASS", "The assignment Name is" +assgnName+ "and" +dataMap.get("NewAssignName")+ "are same", driver);
			}
			else{
				ResultUtil.report("FAIL", "The assignment Name is" +assgnName+ "is not displayed", driver);
			}
		}
		
		public void selectPreviewAssignmentbtn(){
			Button.click("preview assignment", btnpreviewassgn, driver);
			
		}
		
		public void inputDescriptionDetailsForPrintedTest(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>inputDescriptionDetails for printed Test", driver);
			
			if(Element.verify("Description", driver, "ID", "ag_type6")){
				Radiobutton.select("Printed Test",rdobtn4 , driver);
				String strAssignId = dataMap.get("AsgntID");
				String strAssignName= dataMap.get("AsgntName");
				String strAssignDescr= dataMap.get("AsgntDescribtion");
				TextBox.enterValue("AsgntID", txtAssignId, strAssignId, driver);
				TextBox.enterValue("AsgntName", txtAssignName, strAssignName, driver);
				TextBox.enterValue("AsgntDescribtion", txtDescrib, strAssignDescr, driver);
				if(Checkbox.isChecked("Display to Students", chkboxDisplay, driver)){
					Checkbox.unCheck("Display to Students", chkboxDisplay, driver);
					Checkbox.check("Display to Students", chkboxDisplay, driver);
				}
				else{
					Checkbox.check("Display to Students", chkboxDisplay, driver);
				}
				
			}
		}
		
		public void unCheckAllQuestion(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>unCheckallQuestion", driver);
			if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllQuestions, driver)){
				Checkbox.check("CheckAll", chkboxCheckAllQuestions, driver);
				Checkbox.unCheck("CheckAll", chkboxCheckAllQuestions, driver);
			}
			else{
				Checkbox.unCheck("CheckAll", chkboxCheckAllQuestions, driver);
			}
		}
		
		public void verifyChangeValuesRadioButtons(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>checkChangeValuesRadioButtons", driver);
			
			String strChangeValuesXpath= "//td[@class='content-area-top']//tr[./td[text()='Change Values' and text()='(Algorithmic Questions):']]";
			if(Element.verify("Change Values", driver, "xpath", strChangeValuesXpath)){
				WebElement changeValue1 = driver.findElement(By.xpath(strChangeValuesXpath+"//td/input[@id='ag_change_values0']"));
				WebElement changeValue2 = driver.findElement(By.xpath(strChangeValuesXpath+"//td/input[@id='ag_change_values1']"));
				WebElement changeValue3 = driver.findElement(By.xpath(strChangeValuesXpath+"//td/input[@id='ag_change_values2']"));
				if(changeValue1.isEnabled()){
					ResultUtil.report("MESSAGE", "Use Same Values Radio button is enabled", driver);
				}
				else{
					ResultUtil.report("MESSAGE", "Use Same Values Radio button is disabled", driver);
				}
				if(changeValue2.isEnabled()){
					ResultUtil.report("MESSAGE", "Use New Values Radio button is enabled", driver);
				}
				else{
					ResultUtil.report("MESSAGE", "Use New Values Radio button is disabled", driver);
				}
				if(changeValue3.isEnabled()){
					ResultUtil.report("MESSAGE", "Use Static Values Radio button is enabled", driver);
				}
				else{
					ResultUtil.report("MESSAGE", "Use Static Values Radio button is disabled", driver);
				}				
			}
		}
		
		public void verifyQuestionPolicies(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyQuestionPolicies", driver);
			WebElement questionAttempts=driver.findElement(By.xpath("//tr[./td[.='Question Attempts:']]//tr[./td]"));
			if(Element.verify("Question Attempts", questionAttempts, driver)){
				ResultUtil.report("MESSAGE",questionAttempts.getText(),driver);
				ResultUtil.report("PASS", "Question Attempt is displayed", driver);	
			}
			else{
				ResultUtil.report("FAIL", "Question Attempt is not displayed", driver);
			}
			WebElement questionFeedback=driver.findElement(By.xpath("//tr[./td[.='Question Feedback:']]//td[3]"));
			if(Element.verify("Question Feedback", questionFeedback, driver)){	
				ResultUtil.report("MESSAGE",questionFeedback.getText(),driver);
				ResultUtil.report("PASS", "Question Feedback is displayed", driver);
			}
			else{
				ResultUtil.report("FAIL", "Question Feedback is not displayed", driver);
			}
			WebElement changeValues=driver.findElement(By.xpath("//tr[./td[.='Question Assistance:']]//td[3]"));
			if(Element.verify("Change Values", changeValues, driver)){
				ResultUtil.report("MESSAGE",changeValues.getText(),driver);
				ResultUtil.report("PASS", "Change Values is displayed", driver);
			}
			else{
				ResultUtil.report("FAIL", "Change Values is not displayed", driver);
			}
			WebElement potentialPolicy=driver.findElement(By.xpath("//tr[./td[.='Point Potential Policy:']]//td[3]"));
			if(Element.verify("Change Values", potentialPolicy, driver)){
				ResultUtil.report("MESSAGE",potentialPolicy.getText(),driver);
				ResultUtil.report("PASS", "Potential Policy  is Enabled", driver);
			}
			else{
				ResultUtil.report("FAIL", "Potential Policy  is not Enabled", driver);
			}
			WebElement showWork=driver.findElement(By.xpath("//tr[./td[.='Show Work:']]//td[3]"));
			if(Element.verify("Change Values", showWork, driver)){
				ResultUtil.report("MESSAGE",showWork.getText(),driver);
				ResultUtil.report("PASS", "Potential Policy  is Enabled", driver);
			}
			else{
				ResultUtil.report("FAIL", "Potential Policy is not Enabled", driver);
			}
		}
		
		public void verifyElementPresent(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyElementPresent", driver);
			String strAllSection = dataMap.get("AllClassSection");
			WebElement allClassSection= driver.findElement(By.xpath(strContentTableXpath+"//tr[./td/b[.='"+strAllSection+"']]//td/input[@type='checkbox']"));
			Checkbox.isChecked("All Class Section", allClassSection, driver);			
			String strClassAssignment = dataMap.get("ClassName");
			WebElement classSection = driver.findElement(By.xpath(strContentTableXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));
			Checkbox.isChecked("Class Section", classSection, driver);
						
		}
		
		public void checkAllClassSection(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>checkAllClassSection", driver);
			String strAllSection = dataMap.get("AllClassSection");
			WebElement chkAllClassSection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strAllSection+"']]//td/input[@type='checkbox']"));
			Checkbox.check(strAllSection, chkAllClassSection, driver);
			String strClassAssignment = dataMap.get("ClassName");
			WebElement chkClassSelection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));
			Checkbox.isChecked(strClassAssignment, chkClassSelection, driver);
		}
		
		public void unCheckAllClassSection(Map<String,String>dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>checkAllClassSection", driver);
			String strAllSection = dataMap.get("AllClassSection");
			WebElement chkAllClassSection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strAllSection+"']]//td/input[@type='checkbox']"));
			Checkbox.unCheck(strAllSection, chkAllClassSection, driver);
			String strClassAssignment = dataMap.get("ClassName");
			WebElement chkClassSelection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));
			Checkbox.isChecked(strClassAssignment, chkClassSelection, driver);
		}
		
		public List<WebElement> uncheckSelectedClassSection(Map<String,String>dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>checkAllClassSection", driver);
			List<WebElement> elemntClassselections= new ArrayList<WebElement>();			
			List<WebElement> elemntClassList = driver.findElements(By.xpath(strContentAreaXpath+"//tr[./td/b]"));
			elemntClassList.size();
			for(int i=1; i<elemntClassList.size();i++){
				WebElement elemntClassselection= driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b]["+i+"]//td/input[@type='checkbox']"));
				elemntClassselections.add(elemntClassselection);
				if(Checkbox.isChecked("Class is Checked", elemntClassselection, driver)){
					Checkbox.unCheck("Class is unchecked", elemntClassselection, driver);
				}
			}
			return elemntClassselections;
		}
		
		public StudentLoginpage selectSubmitButton(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectSubmitButton", driver);
			Button.click("Submit Button", btnSubmit, driver);	
			
			return PageFactory.initElements(driver, StudentLoginpage.class);	
		}
		
		
		public void verifyAlertMessageClassSection(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyAlertMessageClassSection", driver);
			driver.findElement(By.id("Submit")).click();
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("Alert", alert.getText(), driver);			
			alert.accept();
		}
		
		
		public void closeWindow(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>closeWindow", driver);
			this.driver.close();
			ResultUtil.report("PASS", "Window Closed", driver);
		}
		
		public void verifyDefaultValueDate(Map<String,String>dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyDefaultValueDate", driver);
			String strClassAssignment = dataMap.get("ClassName");
			WebElement classAssignments = driver.findElement(By.xpath(strContentTableXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));
			Checkbox.check(strClassAssignment, classAssignments, driver);
			Element.verify("Start Date", driver, "xpath", strContentTableXpath+"//tr[./td[.='Start Date:']]");
			String strStartDate = driver.findElement(By.xpath(strContentTableXpath+"//input[@name='SDate']")).getAttribute("Value");						
			ResultUtil.report("MESSAGE- Start Date: ", strStartDate, driver);
			Element.verify("Due Date", driver, "xpath", strContentTableXpath+"//tr[./td[.='Due Date:']]");
			String strEndDate = driver.findElement(By.xpath(strContentTableXpath+"//input[@name='SDate']")).getAttribute("Value");			
			ResultUtil.report("MESSAGE",strEndDate, driver);			
		}
		
		public void verifycalender(Map<String,String>dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyDefaultValueDate", driver);
			//Verifying Start Date calendar
			String strClassAssignment = dataMap.get("ClassName");
			WebElement startDateCalender= driver.findElement(By.xpath(strContentTableXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//parent::tr//following-sibling::tr[1]//input[@class='small']"));
			startDateCalender.click();
			driver.switchTo().frame(0);
			Element.verify("Calender", driver, "ID", "monthcontainer");
			
			//Verifying Due date calendar
			WebElement dueDateCalender= driver.findElement(By.xpath(strContentTableXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//parent::tr//following-sibling::tr[2]//input[@class='small']"));
			dueDateCalender.click();
			driver.switchTo().frame(0);
			Element.verify("Calender", driver, "ID", "monthcontainer");
			
		}
		
		
		public void verifyDefaultValueTime(Map<String,String>dataMap){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyDefaultValueTime", driver);			
			String strClassAssignment = dataMap.get("ClassName");
			WebElement classAssignments = driver.findElement(By.xpath(strContentTableXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));			
			Checkbox.check(strClassAssignment, classAssignments, driver);	
			String strStartDateXpath= "//table[@class='content-area']//tr[./td[.='Start Date:']]";
			List <WebElement> startTime = driver.findElements(By.xpath(strStartDateXpath+"//tr/td[2]/select"));
			for(WebElement list:startTime){
				ResultUtil.report("MESSAGE- Time:  ", list.getText(), driver);
			}			
			List <WebElement> startZone = driver.findElements(By.xpath(strStartDateXpath+"//tr[./td[.='Start Date:']]//tr/td[3]/select"));			
			for(WebElement zone:startZone){
				ResultUtil.report("MESSAGE- Zone:  ", zone.getText(), driver);
			}
			String strDueDAteXpath="//table[@class='content-area']//tr[./td[.='Due Date:']]";
			List <WebElement> endTime = driver.findElements(By.xpath(strDueDAteXpath+"//tr/td[2]/select"));
			for(WebElement timeList:endTime){
				ResultUtil.report("MESSAGE- Time:  ", timeList.getText(), driver);
			}			
			List <WebElement> endZone = driver.findElements(By.xpath(strDueDAteXpath+"//tr/td[3]/select"));
			for(WebElement zoneList:endZone){
				ResultUtil.report("MESSAGE- Zone:  ", zoneList.getText(), driver);
			}			
		}
		
	
		public void verifyStudentAccess(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyStudentAccess", driver);			
			Element.verify("Student Access after the Due Date ", driver, "xpath", strContentAreaXpath+"//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr[./td]");		
			Radiobutton.select("Yes View only", studentAccess2, driver);			
			Checkbox.isDisabled(lateSubmission, "Late Submission", driver);			
			Combobox.isDisabled(reduceScore, "Reduce Score DropDown is Disabled", driver);			
			Radiobutton.select("Yes. View With Assistance", studentAccess3, driver);			
			Checkbox.isDisabled(lateSubmission, "Late Submission", driver);			
			Combobox.isDisabled(reduceScore, "Reduce Score DropDown is Disabled", driver);			
			Radiobutton.select("No", studentAccess4, driver);			
			Checkbox.isDisabled(lateSubmission, "Late Submission", driver);			
			Combobox.isDisabled(reduceScore, "Reduce Score DropDown is Disabled", driver);			
			Radiobutton.select("Yes. Attempts after Due Date will be Marked Late", studentAccess1, driver);			
		}
		
		public void selectStudentAccessViewOnly(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectStudentAccessViewOnly", driver);			
			Radiobutton.select("Yes View only", studentAccess2, driver);			
			Checkbox.check("Late Submission is Disabled", lateSubmission, driver);
			Combobox.isDisabled(reduceScore, "Reduce Score DropDown is Disabled", driver);			
		}
		
		public void selectStudentAccessViewWithAssistance(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectStudentAccessViewWithAssistance", driver);			
			Radiobutton.select("Yes. View With Assistance", studentAccess3, driver);			
			Checkbox.check("Late Submission is Disabled", lateSubmission, driver);
			Combobox.isDisabled(reduceScore, "Reduce Score DropDown is Disabled", driver);		
		}
				
		public void verifyAlertMessageInAssignPage(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyAlertMessageInAssignPage", driver);			
			driver.findElement(By.id("Submit")).click();			
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			driver.switchTo().alert().accept();
		}
			
		public void verifyAssignmentScoring(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyAssignmentScoring", driver);		
			Element.verify("Assignment Scoring:", driver, "xpath", strContentTableXpath+"//table[.//span[contains(text(),'Scoring')]]//tr/td/span[contains(text(),'Scoring:')]");			
			Radiobutton.isEnabled(gradedAssignment, "Graded Assignment", driver);			
			Radiobutton.isEnabled(unGradedAssignment, "Ungraded Assignment", driver);		
		}
		
		public void verifyUnGradedAssignment(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyUnGradedAssignment", driver);			
			Radiobutton.select("Ungraded Assignment", unGradedAssignment, driver);			
			Checkbox.isDisabled(timedAssignment, "Timed Assignment is Disabled", driver);			
			Checkbox.isDisabled(timeOnTask, "Time on Task is Disabled", driver);
		}
		
		
		public void verifyCurrentDate(){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyCurrentDate", driver);		
			WebElement currentDate = driver.findElement(By.xpath("//td//span[@class='textGrey']"));			
			Element.verify("current Date", currentDate, driver);			
			ResultUtil.report("MESSAGE",currentDate.getText(),driver);			
		}
				
		public void verifyUseGenericQuestionTitles(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyCurrentDate", driver);			
			Element.verify("Use Generic Question Titles", driver, "xpath", strContentTableXpath+"//table[.//span[contains(text(),'Scoring')]]//tr/td/span[contains(text(),'Titles:')]");			
			Checkbox.verify("Un Checked Generic Question Title", useGenericQuestionTitles, driver);
		}
			
		public void quesitonLinkMove(){
			WebElement question=driver.findElement(By.xpath(strContentTableXpath+"//tr[2]//td[1]//a"));
			Actions builder=new Actions(driver);
			builder.moveToElement(question).perform();
			
			builder.moveByOffset(100, 200);
			Link.click("Question link", question, driver);
			
		}
		
		public void questionLinkMoveInConfirmation(){
			WebElement question=driver.findElement(By.xpath(strContentTableXpath+"//tr[2]//a"));
			Actions builder=new Actions(driver);
			builder.moveToElement(question).perform();
			
			builder.moveByOffset(100, 200);
			Link.click("Question link", question, driver);
		}

		public void selectUseGenericQuestionTitle(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectUseGenericQuestionTitle", driver);			
			if(Checkbox.isUnchecked("Un Checked Generic Question Title", useGenericQuestionTitles, driver)){				
				Checkbox.check("Generic Question Title", useGenericQuestionTitles, driver);
			}			
		}
		
		public void verifyAllowPrinting(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyAllowPrinting", driver);			
			Element.verify("Use Generic Question Titles", driver, "xpath", strContentTableXpath+"//table[.//span[contains(text(),'Printing')]]//tr/td/span[contains(text(),'Printing:')]");			
			Checkbox.unCheck("Un- Checked Print Assignment", printCheckbox, driver);		
		}
		
		public void selectAllowPrinting(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectAllowPrinting", driver);			
			if(Checkbox.isUnchecked("Un- Checked Print Assignment", printCheckbox, driver)){
				Checkbox.check("Allow Printing Assignment", printCheckbox, driver);				
			}			
		}
				
		public void verifyTimedAssignment(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyTimedAssignment", driver);
			
			if(Element.verify("Timed Assignment", driver, "xpath", strContentTableXpath+"//table[.//span[contains(text(),'assignment')]]//tr/td/span[contains(text(),'assignment:')]")){
				Checkbox.isChecked("Student Limit", timedAssignment, driver);				
				Checkbox.check("Student Limit", timedAssignment, driver);				
				Combobox.isEnabled(timeLimit, "Time Limit is Displayed", driver);				
				List <WebElement> listTimeLimit = driver.findElements(By.xpath("//select[@id='time_limit_select']//option"));				
				for(WebElement limitList: listTimeLimit){
					ResultUtil.report("MESSAGE",limitList.getText(),driver);					
				}							
			}			
		}
		
		public AssignmentResultsPage verifyTimeOnTask(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyTimeOnTask", driver);			
			if(Element.verify("Time on Task", driver, "xpath", strContentTableXpath+"//table[.//span[contains(text(),'task')]]//tr/td/span[contains(text(),'task:')]")){				
				Checkbox.isChecked("Student Limit", timeOnTask, driver);				
			}			
			return PageFactory.initElements(driver, AssignmentResultsPage.class);
		}
		
		public void selectTimeOnTask(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectTimeOnTask", driver);
			Checkbox.check("Student Limit", timeOnTask, driver);			
		}
				
		public void verifyLateSubmission(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyLateSubmission", driver);
			String strStudenAccessXpath="//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr";
			Element.verify("Student Access after the Due Date ", driver, "xpath", strStudenAccessXpath+"[./td]");			
			Radiobutton.isSelected("Yes, Attempt After Due Date", studentAccess1, driver);			
			Checkbox.isUnchecked("Late Submission is Disabled", lateSubmission, driver);			
			Combobox.isDisabled(reduceScore, "Reduce Score DropDown is Disabled", driver);			
		}
		
		public void selectLateSubmission(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>selectLateSubmission", driver);
			String strStudenAccessXpath="//table[@class='content-area']//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr";
			Radiobutton.isSelected("Yes, Attempt After Due Date", studentAccess1, driver);			
			Checkbox.check("Late Submission is Disabled", lateSubmission, driver);			
			Combobox.isEnabled(reduceScore, "Reduce Score DropDown is Disabled", driver);			
			List<WebElement> reduceScorePenality = driver.findElements(By.xpath(strStudenAccessXpath+"/td//select"));			
			for(WebElement listReduceScore:reduceScorePenality )			
			{
				ResultUtil.report("MESSAGE",listReduceScore.getText(),driver);			
			}			
		}
		
		public void verifyAndCheckDueDate(Map<String,String> dataMap){			
			ResultUtil.report("INFO", "CreateEditAssignment>>>>>verifyAndCheckDueDate", driver);
			String strClassname=dataMap.get("ClassName");
			WebElement noDueDate = driver.findElement(By.xpath(strContentAreaXpath+"//tr/td[.='"+strClassname+"']//parent::tr//following-sibling::tr[2]//input[@type='checkbox']"));			
			if(Checkbox.isUnchecked("No Due Date", noDueDate, driver)){				
				Checkbox.check("No Due Date", noDueDate, driver);
			}
			else{				
				Checkbox.unCheck("No Due Date", noDueDate, driver);
			}			
		}
		
		public void verifyAndCheckStudyObjective(){			
			ResultUtil.report("INFO", "CreateEditAssignment>>>>>verifyAndCheckStudyObjective", driver);			
			Element.verify("Study Objective", driver, "xpath", "verifyAndCheckStudyObjective");			
			if(Checkbox.isUnchecked("Study Objective", studyObjective, driver)){				
				Checkbox.check("Study Objective", studyObjective, driver);
			}
		}
		
		public void verifyQuestionFeedbackCheckbox(){			
			ResultUtil.report("INFO", "CreateEditAssignment>>>>>verifyQuestionFeedbackCheckbox", driver);						
			if(Checkbox.isChecked("Question Feedback", checkboxQuestionFeedback, driver)){				
				Checkbox.check("Question Feedback", checkboxQuestionFeedback, driver);
			}			
		}
		
		public List<WebElement> DuplicateQuestion()		{
			List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
			List<WebElement> elmntQuestionScore = new ArrayList<WebElement>();			
			//List of rows displayed
			List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
			elmntQuestionsDisplayed.size();			
			//Adding question name and the question score in arrays
			for(int i=1;i<elmntQuestionsDisplayed.size()-2;i=i+1)
			{
				WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
				elmntQuestionNames.add(elmntQuestionName);
				ResultUtil.report("MESSAGE",elmntQuestionName.getText(),driver);				
				WebElement elmntScoreValue = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[./a[not(text()='Remove' or text()='Duplicate')]]]["+i+"]/td//a[.='Duplicate']"));
				elmntQuestionScore.add(elmntScoreValue);
				Link.click("Duplicate", elmntScoreValue, driver);					
			}	
			return elmntQuestionNames;
		}
			
		public void AddNewQuestions(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestions", driver);			
			List<WebElement> listcheckbox = driver.findElements(By.xpath(strPlainTableXpath+"//tr//input[@type='checkbox']"));
			listcheckbox.size();				
			for(int i=1;i<=listcheckbox.size();i++)			{
				//Remove the not equals condition and add checkbox condition
				if((i==7 || i==8 || i==9))				{
					WebElement checkboxclick = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
					checkboxclick.click();
					String questionName=driver.findElement(By.xpath(strPlainTableXpath+"/tbody/tr["+i+"]//td[2]")).getText();
					questionNames.append(questionName);					
				}
			}						
		}
		
		public void unCheckfewQuestion() {
			if(Checkbox.isChecked("CheckQuetion", chkboxQuestions, driver)){				
				Checkbox.unCheck("Uncheck", chkboxUncheck, driver);
			}
					
		}
		
		public void VerifyScoreColumn() {			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>>VerifyScoreColumn", driver);
			List<WebElement> scoreColumn=driver.findElements(By.xpath("//input[@name='score']"));
			for(WebElement scoreList:scoreColumn){
				String strscore=scoreList.getAttribute("value");
				if(strscore.equals("1.0")){
					ResultUtil.report("PASS", "Score is"+strscore+"as Expecteed", driver);
				}else{
					ResultUtil.report("FAIL", "Score is"+strscore+" is not as Expected", driver);
				}				
				try{
					scoreList.sendKeys("2.0");
					scoreList.clear();
					ResultUtil.report("FAIL", "Score Value is Enabled", driver);
				}catch(Exception e){
					ResultUtil.report("PASS", "Score Value is Disabled as expected", driver);
				}
			}
			
		}
		
        public void setAttempts(Map<String,String> dataMap){		
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>setAttempts", driver);		
		List<WebElement> elmntattempts = new ArrayList<WebElement>();					
		List<WebElement> elmntAttemptsDisplayed = driver.findElements(By.xpath(strQuestionAtempts));
		elmntAttemptsDisplayed.size();		
		//Adding question name and the question score in arrays
		for(int i=1;i<6;i++){
			String strSetQuestionAttempts = dataMap.get("SetQuestionAttempts");
			WebElement elmntattempt = driver.findElement(By.xpath(strQuestionAtempts+"//option["+strSetQuestionAttempts+"]"));
			elmntattempts.add(elmntattempt);
			ResultUtil.report("MESSAGE",elmntattempt.getText(),driver);
			Combobox.selectItemByIndex("Select Attempts", elmntattempt, i, driver);				
			}   
        }
        public void verifyAlertMessageInChangeAttempts(){			
			ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyAlertMessageInChangeAttempts", driver);			
			Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
		
			driver.switchTo().alert().accept();
		}
        
        public void uncheckNumberQuestions()       {
        	ResultUtil.report("INFO", "CreateEditAssignmentPage>>checkNumberQuestions", driver);
        	Window.focusWindow("question previe window", driver, driver.getWindowHandles().toArray()[1].toString());
        	WebElement numberquestions=driver.findElement(By.id("number_questions"));
        	Checkbox.unCheck("Number Questions", numberquestions, driver);
        	
        }
        
        public void checkHideQuestionTitle()       {
        	ResultUtil.report("INFO", "CreateEditAssignmentPage>>checkHideQuestionTitle", driver);
        	Window.focusWindow("question previe window", driver, driver.getWindowHandles().toArray()[1].toString());
        	WebElement HideQuestions=driver.findElement(By.id("hide_titles"));
        	Checkbox.check("Hide question title", HideQuestions, driver);
        	
        }

        public void chooseAlgorithmQuestionPreview(Map<String,String> dataMap) {
			String questionSelectionWindow=driver.getWindowHandles().toArray()[0].toString();
			driver.switchTo().window(questionSelectionWindow);			
			String algorthimQuestion = dataMap.get("AlgorthimQuestions");
			WebElement linkText = driver.findElement(By.xpath(strPlainTableXpath+"//tr//td/a[.='"+algorthimQuestion+"']"));
			linkText.click();
        }
		
		public void selectReportContent(){
			String questionPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
			driver.switchTo().window(questionPreviewWindow);
			WebElement report = driver.findElement(By.xpath("//table[@id='change_value_labels_1']//tr//td//a[2]"));
			report.click();
		}
		
        public void SelectCancel(){    			
			Button.click("Cancel", cnclBtn,driver);			
			
        }
        
        public void selectNo(){    			
			Button.click("No",NoBtn, driver);			
        }
        
        public void selectYes(){	
			Button.click("Yes",YesBtn, driver);			
        }
                   
	    public void VerifyAlertmessageinQuestionPreview(){
	    	ResultUtil.report("INFO", "CreateEditAssignmentPage>>VerifyAlertmessageinQuestionPreview", driver);			
	    	driver.findElement(By.id("Submit")).click();
	    	Alert alert = driver.switchTo().alert();
			ResultUtil.report("MESSAGE", alert.getText(), driver);		
			
			driver.switchTo().alert().accept();
	    }
       
       /*public void verifylongReportcomments(Map<String,String> dataMap) {		
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifylongReportcomments", driver);
		
    	   if(Element.verify("Report Description", driver, "xpath", "/html/body/div[4]/form/div[2]/div/table/tbody/tr[2]/td")){
    		   String lngreportCmnt = dataMap.get("LongReportComments");			
    		   TextBox.enterValue("Report Comment", RptCmnt, lngreportCmnt, driver);			
    	   }		
    	   driver.findElement(By.id("Submit")).click();		
    	   Alert alert = driver.switchTo().alert();
   		ResultUtil.report("Alert Message", alert.getText(), driver);		
   		Sync.waitForSeconds(5, driver);
   		driver.switchTo().alert().accept();
       }

       public void verifyReportcomments(Map<String,String> dataMap) {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyReportcomments", driver);
  		   if(Element.verify("Report Description", driver, "xpath", "/html/body/div[4]/form/div[2]/div/table/tbody/tr[2]/td")){
  			   String reportCmnt = dataMap.get("ReportComment");
  			   TextBox.enterValue("Report Comment", RptCmnt, reportCmnt, driver);	
  		   }
  		   driver.findElement(By.id("Submit")).click();
  		   Alert alert = driver.switchTo().alert();
  		   ResultUtil.report("Alert Message", alert.getText(), driver);		
  		   Sync.waitForSeconds(5, driver);
  		   driver.switchTo().alert().accept();
       }*/
       
       public void verifyQuestionPoliciesTab(){
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyQuestionPoliciesTab", driver);
    	   Element.verify("Set Question Policies", driver, "XPATH", "//div[contains(.,'Policies')]");
       }
       
       public void selectAlgorthmicQuestionforChangeValue(Map<String,String> dataMap) {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAlgorthmicQuestion", driver);
    	   String strquestionName=dataMap.get("AlgorithmicQuestion").trim();
    	   WebElement algoQues=driver.findElement(By.xpath("//table[contains(@class,'plain-table')]//a[.='"+strquestionName+"']"));
    	   Link.click("Algorithmic question",algoQues , driver);
       }
       
       public void doNotShareWithOthers(){
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>doNotShareWithOthers", driver);   	   
    	   Radiobutton.select("Do Not Share With Other Instructor", sharingRdobtn2, driver);   	   
       }
       
       public void workInDraftMode(){   	   
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>workInDraftMode", driver);    	   
    	   Radiobutton.select("Work In Draft Mode", sharingRdobtn3, driver);
       }
       
       public void clickChangeValues()       {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>clickChangeValues", driver); 
    	   Sync.waitForObject(driver, "Change Value", "XPATH", "//a[.='Change Values']");
    	   WebElement changeValue=driver.findElement(By.xpath("//a[.='Change Values']"));
    	   Link.click("Change Value", changeValue, driver);
    	   Sync.waitForSeconds(2, driver);
       }
       
       public void moveOnQuestion()       {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>moveOnQuestion", driver);
    	   WebElement question=driver.findElement(By.xpath(strPlainTableXpath+"//tr[3]//td[2]//a"));
    	   Link.mouseOver("Question",  question, 5, driver);
       }
       
       public void selectQuestionNameTriangle()       {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionNameTriangle", driver);
    	   WebElement quesName=driver.findElement(By.xpath(strPlainTableXpath+"//tr[1]//td[2]//img"));
    	   Button.click("Question Name triangle", quesName, driver);
    	   
       }
       
       public void selectTextAssociationTriangle()     {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectTextAssociationTriangle", driver);
    	   WebElement textAsso=driver.findElement(By.xpath(strPlainTableXpath+"//tr[1]//td[3]//img"));
    	   Button.click("Text Association Triangle", textAsso, driver);
    	   
       }
       
       public void selectQuestionTypeTriangle()      {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionTypeTriangle", driver);
       	   WebElement quesType=driver.findElement(By.xpath(strPlainTableXpath+"//tr[1]//td[4]//img"));
    	   Button.click("Question Type Triangle", quesType, driver);
    	   
       }
       
       public void selectQuestionAssistanceTriangle()       {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionAssistanceTriangle", driver);
       	   WebElement quesAssist=driver.findElement(By.xpath(strPlainTableXpath+"//tr[1]//td[4]//img"));
    	   Button.click("Question Assistance Triangle", quesAssist, driver);
    	   
       }
       
       public void selectDifficultyTriangle()       {   
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectDifficultyTriangle", driver);
       	   WebElement difficult=driver.findElement(By.xpath(strPlainTableXpath+"//tr[1]//td[4]//img"));
    	   Button.click("Difficulty Triangle", difficult, driver);
    	   
       }
       
       public void selectSourceTriangle()      {
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectSourceTriangle", driver);
       	   WebElement source=driver.findElement(By.xpath(strPlainTableXpath+"//tr[1]//td[4]//img"));
    	   Button.click("Source Triangle", source, driver);
    	  
       }
          
       public List<WebElement>verifyRemoveAndDuplicateLink(){       	
    	   ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyRemoveAndDuplicate", driver);   
    	   List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
    	   List<WebElement> elmntRemoveDupicates = new ArrayList<WebElement>();  			
  			//List of rows displayed
  			List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
  			elmntQuestionsDisplayed.size();			
  			//Adding question name and the question score in arrays
  			for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++) 			{
  				WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
  				elmntQuestionNames.add(elmntQuestionName);  				
  				ResultUtil.report("MESSAGE", elmntQuestionName.getText(), driver); 				
  				WebElement elmntRemoveDuplicate = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//following-sibling::td[./a]"));
  				elmntRemoveDupicates.add(elmntRemoveDuplicate);
  				ResultUtil.report("MESSAGE", elmntRemoveDuplicate.getText(), driver); 				
  			}		
  			return elmntQuestionNames;       	  
     }
       
     public void verifySourceList(){    	         	 
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySourceList", driver);    	     	 
    	 List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
    	 int tableSize= tableList.size();    	 
    	 for(int i=1;i<tableSize;i++){   		 
    		WebElement sourcelist = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]//td[7]"));    		 
    		 ResultUtil.report("MESSAGE",sourcelist.getText(), driver);
    	 }    	
     }
       
     public void verifyQuestionNameList(){
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyQuestionNameList", driver);   	 
    	 List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
    	 int tableSize= tableList.size();    	 
    	 for(int i=1;i<tableSize;i++){    		 
    		WebElement questionNameList = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]//td[2]"));    		 
    		ResultUtil.report("MESSAGE",questionNameList.getText(), driver);
    	 }   	 
     }
         
     public void verifyTextAssociationList(){    	 
    	 ResultUtil.report("INFO", "CreateEditAssignment>>>VerifyTextAssociation", driver);   	 
    	 List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
    	 int tableSize= tableList.size();    	 
    	 for(int i=1;i<tableSize;i++){    		 
    		WebElement textAssociationList = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]//td[3]"));    		 
    		ResultUtil.report("MESSAGE",textAssociationList.getText(), driver);
    	 }
     }
     
     public void verifyQuestionTypeList(){   	
    	 ResultUtil.report("INFO", "CreateEditAssignment>>>verifyQuestionType", driver);    	 
    	 List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
    	 int tableSize= tableList.size();    	 
    	 for(int i=1;i<tableSize;i++){   		 
    		WebElement questionTypeList = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]//td[4]"));    		 
    		 ResultUtil.report("MESSAGE",questionTypeList.getText(), driver);
    	 }   	 
     }
     
     public void verifyQuestionAssistanceList(){    	 
    	 ResultUtil.report("INFO", "CreateEditAssignment>>>verifyQuestionAssistanceList", driver);    	 
    	 List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
    	 int tableSize= tableList.size();    	 
    	 for(int i=1;i<tableSize;i++){    		 
    		WebElement questionAssistanceList = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]//td[5]"));    		 
    		ResultUtil.report("MESSAGE",questionAssistanceList.getText(), driver);
    	 }    	 
     }
     
     public void verifyDifficultyList(){    	 
    	 ResultUtil.report("INFO", "CreateEditAssignment>>>verifyDifficultyList", driver);    	 
    	 List<WebElement> tableList = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
    	 int tableSize= tableList.size();    	 
    	 for(int i=1;i<tableSize;i++){    		 
    		WebElement DifficultyList = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]//td[6]"));   		 
    		ResultUtil.report("MESSAGE",DifficultyList.getText(), driver);
    	 }    	 
     }
     
     //Disable Feedback checkbox
     public void disableFeedback(){    	 
    	ResultUtil.report("INFO ", "CreateEditAssignmentPage>>>diableFeedback", driver);    	         
    	Checkbox.check("Question Feedback", checkboxQuestionFeedback, driver);    	 
     }
         
     //MultiSelect Chapter and Level
     public void mulitiSelectChapter(Map<String,String> dataMap){ 
    	ResultUtil.report("INFO", "CreateEditAssignmentPage>>>mulitiSelectChapter", driver);    	 
    	WebElement chapter = driver.findElement(By.xpath("//tr//select[@name='association']"));
    	String strchapter = dataMap.get("MultiChapters");
    	ResultUtil.report("MESSAGE",strchapter,driver);
    	Listbox.deselectAll(chapter, "Deselect All", driver);
 		Listbox.selectItems("Select Multiple Chapter", chapter, strchapter, driver);
		 			
     }
     
     //MultiSelect Level and Source
     public void multiSelectLevel(Map<String,String> dataMap){   	 
    	ResultUtil.report("INFO", "CreateEditAssignmentPage>>>multiSelectLevel", driver);    	 
    	WebElement level = driver.findElement(By.xpath("//tr//select[@name='difficulty']"));		
		String strLevel = dataMap.get("MultiLevels");		
		Listbox.deselectAll(level, "Deselect All", driver);		
		Listbox.selectItems("Select Multiple Level", level, strLevel, driver);		
			
     }
     
     //verify Table displayed
     public void verifyTableDisplayed(){    	
    	ResultUtil.report("INFO", "CreateEditAssignment>>>verifyTableDisplayed", driver); 
		List <WebElement> getCountdisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[3]"));
		int counts=getCountdisplayed.size();
				
     }
     
     //Multi Select Source
     public void multiSelectSource(Map<String,String> dataMap){   	 
    	ResultUtil.report("INFO", "CreateEditAssignmentPage>>>multiSelectSource", driver);    	 
    	WebElement sources = driver.findElement(By.xpath("//tr//select[@name='owner']"));		
		String strSource= dataMap.get("MultiSources");    	
		Listbox.deselectAll(sources, "Deselect All", driver);		
		Listbox.selectItems("Select Multiple Source", sources, strSource, driver);		
     }
     
     //Multi Select Section
     public void multiSelectSection(Map<String,String> dataMap){
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>multiSelectSection", driver);
    	 if(Element.verify("Section Menu", driver, "xpath", "//tr//select[@id='section']")){
    	 WebElement section= driver.findElement(By.xpath("//tr//select[@id='section']"));
    	 String strSection= dataMap.get("MultiSection");
    	 Listbox.deselectAll(section, "Deselect All", driver);
    	 Listbox.selectItems("Select Multiple Section", section, strSection, driver);
    	 }else{
    		 
    		 ResultUtil.report("MESSAGE", "Section Menu is not displayed", driver);
    	 }
     }
     
     //Click Go Button
     public void selectGoBtn(){   	 
    	ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectGoBtn", driver);   	
    	Button.click("Go Button", gobtn, driver);		
    	
     }
       
     //Select Same Values
     public void selectSameValuesRadioButton(){    	 
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectSameValuesRadioButton", driver);    	 
    	 WebElement changeValue1 = driver.findElement(By.xpath(strChangeValueXpath+"//td/input[@id='ag_change_values0']"));    	 
    	 Radiobutton.select("Same Values Radio Button", changeValue1, driver);
     }
     
     //select New Values
     public void selectNewValuesRadioButton(){    	 
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectNewValuesRadioButton", driver);   	 
    	 WebElement changeValue2 = driver.findElement(By.xpath(strChangeValueXpath+"//td/input[@id='ag_change_values1']"));   	 
    	 Radiobutton.select("New Values Radion Button", changeValue2, driver);   	 
     }
     
     //select static Values
     public void selectStaticValuesRadioButton(){   	 
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectStaticValuesRadioButton", driver);   	 
    	 WebElement changeValue3 = driver.findElement(By.xpath(strChangeValueXpath+"//td/input[@id='ag_change_values2']"));		
    	 if(Radiobutton.isEnabled(changeValue3, "Static Values Radio Button", driver)){   		 
    		 Radiobutton.select("Static Values Radio Button", changeValue3, driver);   		 
    	 }    	 
     }
     
     public void selectNumericQuestions(){
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectNumericQuestions", driver);
    	 WebElement numeric=driver.findElement(By.xpath("//td[.='GO Problem, Section 3.6']//preceding-sibling::td//input[3]"));
    	 WebElement numericUnits=driver.findElement(By.xpath("//td[.='GO Problem, Section 1.4, Question 48']//preceding-sibling::td//input[3]"));
    	 Checkbox.check("Numeric Question", numeric, driver);
    	 Checkbox.check("Numeric Question with units", numericUnits, driver);   	 
    }
     
     public void selectConfigureNumericPolicies()    {
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectConfigureNumericPolicies", driver);
    	 WebElement configure=driver.findElement(By.xpath("//a[contains(.,' Numeric ')]"));
    	 Link.click("Configure Numeric Policies", configure, driver);
    		 
     }
     
     public void verifyConfigureNumericPoliciesWindow(Map<String,String> dataMap)   {
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyConfigureWindow", driver);
    	 String windowTitle=driver.getTitle();
    	 ResultUtil.report("MESSAGE", windowTitle, driver);
    	 String assgnType=driver.findElement(By.xpath("//h1")).getText();
    	 ResultUtil.report("MESSAGE", assgnType, driver);
    	 String assgnTitle=driver.findElement(By.xpath("//div[@class='popup-body']/div/strong")).getText();
    	 ResultUtil.report("MESSAGE", assgnTitle, driver);
    	 WebElement enableSD=driver.findElement(By.name("sdenable_checkbox"));
    	 Checkbox.check("Enable Significant Digits", enableSD, driver);
    	 WebElement customInstruct=driver.findElement(By.name("sd_custom_text"));
    	 String customInstruction=dataMap.get("100Characters").trim();
    	 TextBox.enterValue("Custom instructions", customInstruct, customInstruction, driver);
    	 ResultUtil.report("PASS", "User is not allowed to enter more than 100 characters", driver);
     }
     
     public void focusMainWindow()    {
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>focusMainWindow", driver);
    	 Window.focusWindow("Main Window", driver, driver.getWindowHandles().toArray()[0].toString());
     }
     
     public void chooseNumericQuestionChapter(){   	 
     	ResultUtil.report("INFO", "CreateEditAssignmentPage>>>chooseNumericQuestionChapter", driver);    	 
     	WebElement chapter = driver.findElement(By.xpath("//tr//select[@name='association']"));
      	String strchapter = "Chapter 0. Prerequisites and Review;Chapter 1. Equations and Inequalities;Chapter 3. Functions and Their Graphs;Chapter 6. Systems of Equations and Inequalities";     	
      	Listbox.deselectAll(chapter, "Deselect All", driver);
 		Listbox.selectItems("Select Multiple Chapter", chapter, strchapter, driver);
		 	 
      }
      
      public void verifyDefaultToleranceValue(){
       	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyDefaultToleranceValue", driver);     	 
     	 List<WebElement> toleranceValue = driver.findElements(By.name("tolerance"));
     	 for(WebElement values: toleranceValue){     		 
     		 ResultUtil.report("MESSAGE", values.getText(), driver);
     	 }    	 
      }
      
      public void verifyEnableSignificantDigitsQuestionTolerance(){    	 
     	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyEnableSignificantDigits", driver);     	 
     	 WebElement significantDigits = driver.findElement(By.name("sdenable_checkbox"));
     	 WebElement questionTolerance = driver.findElement(By.name("tlenable_checkbox"));     	 
     	 Checkbox.isUnchecked("Enable Significate Digits", significantDigits, driver);
     	 Checkbox.isUnchecked("Enable Question Tolerance", questionTolerance, driver);
      }
      
      public void selectEnableSignificantDigitsQuestionTolerance(){    	 
     	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectEnableSignificantDigitsQuestionTolerance", driver);    	 
     	 WebElement significantDigits = driver.findElement(By.name("sdenable_checkbox"));
     	 WebElement questionTolerance = driver.findElement(By.name("tlenable_checkbox"));     	 
     	 Checkbox.check("Enable Significate Digits", significantDigits, driver);
     	 Checkbox.check("Enable Question Tolerance", questionTolerance, driver);
      }
      
      public void selectUpdateButton(){   	 
     	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectUpdateButton", driver);    	 
     	 Button.click("Update Button", updateButton, driver);   
      }
      
      public void verifyHelpToleranceAndSignificantDigit(){    	 
    	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyHelpToleranceAndSignificantDigit", driver);     	 
     	 Checkbox.isUnchecked("Hide Tolerance", hideTolerance, driver);     	 
     	 WebElement sdiText = driver.findElement(By.xpath("//input[contains(@id,'sditext')]"));
     	 WebElement sdHelp = driver.findElement(By.xpath("//input[contains(@id,'sdhelp')]"));
     	 Radiobutton.isEnabled(sdiText, "Significant Digit Instructor", driver);    	 
     	 Radiobutton.isEnabled(sdHelp, "Significant Digit Help", driver);    	 
      } 
            
      public void selectHelpToleranceAndSignificantDigit(){     	 
     	 ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectHelpToleranceAndSignificantDigit", driver);     	 
     	 Checkbox.check("Hide Tolerance", hideTolerance, driver);     	 
     	 Radiobutton.select("Select Generic Instruction", genericInstruction, driver);
     	 Radiobutton.select("Active Help", activeHelp, driver);     	
      }
            
      public void gradebookWeightingSetting(){    	  
    	  ResultUtil.report("INFO", "CreateEditAssignmentPage>>>gradebookWeightingSetting", driver);   	  
    	  String strWeightingSetting = "Question (50%)";   	  
    	  Combobox.isEnabled(weightingSetting, strWeightingSetting, driver);    	  
    	  Combobox.selectItemByValue("Gradebook Weighting", weightingSetting, strWeightingSetting, driver);    	  
      }
      
  	public void selectChapterForQuestionPreview(Map<String,String> dataMap) {		
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
		for(WebElement list:chapter ){
			ResultUtil.report("MESSAGE",list.getText(),driver);
		}
		Listbox.deselectAll(listAssociation,"Chapter", driver);
		Listbox.selectItemByIndex("Chapter", listAssociation, 0, driver);
		Button.click("Go Button", gobtn, driver);  
    	} 
	
  	public void verifyOrganizeQuestions(){
  		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyOrganizeQuestions", driver);
  		List <WebElement>questionsName= driver.findElements(By.xpath(strPlainTableXpath+"//td[.='Question Name']//parent::tr//following-sibling::tr/td[1]"));
  		for(WebElement questionList: questionsName){
  			
  			ResultUtil.report("MESSAGE", questionList.getText(), driver);
  		}
  	}
  	
  	public void selectQuestionsForFirstAssignmentInPre(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionsForSubmitPre", driver);
		String strQuestionCount=dataMap.get("QuestionCount1");
		int questionLenght=Integer.parseInt(strQuestionCount);
		for(int i=1;i<=questionLenght;i++){
		String strQuestion=dataMap.get("Questions"+i);
		String strQuestionsXpath= "//a[.='"+strQuestion+"']//parent::td//preceding-sibling::td//input[@type='checkbox']";
		WebElement questions=driver.findElement(By.xpath(strQuestionsXpath));
		Checkbox.check("Question selected-" +strQuestion, questions, driver);
		}
  	}	
  	
 	public void selectQuestionsForSecondAssignmentInPre(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionsForSubmitPre", driver);
		String strQuestionCount=dataMap.get("QuestionCount2");
		int questionLenght=Integer.parseInt(strQuestionCount);
		for(int i=9;i<(questionLenght+9);i++){
		String strQuestion=dataMap.get("Questions"+i);
		String strQuestionsXpath= "//a[.='"+strQuestion+"']//parent::td//preceding-sibling::td//input[@type='checkbox']";
		WebElement questions=driver.findElement(By.xpath(strQuestionsXpath));
		Checkbox.check("Question selected-" +strQuestion, questions, driver);
		}
  	}	
 	
 	public void clickCloseButton(){
 		
 		ResultUtil.report("INFO", "CreateEditAssignment>>>clickCloseButton", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Button.click("Close Button", close, driver);
		
 	}
 	
 	public void gradeBookWeightedButton(){
 		ResultUtil.report("INFO", "CreateEditAssignment>>>gradeBookWeighted", driver); 		
 		Button.click("GradeBook Weighting", btnGradeBookWeighting, driver);
 		 		
 	}
 	
 	public void setGradebookWeighted(Map<String,String> dataMap){
 		
 		ResultUtil.report("INFO", "CreateEditAssignment>>>gradeBookWeighted", driver); 
 		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
 		String strQuestionType= dataMap.get("QuestionWeightage"); 		
 		TextBox.clearValue("ClearQuestionType", questionType, driver);
 		TextBox.enterValue("Enter Question Type", questionType, strQuestionType, driver);
 		String strPrecentage= dataMap.get("Percentage");
 		TextBox.clearValue("Clear Percentage", questionPercentage, driver);
 		TextBox.enterValue("Enter Percentage", questionPercentage, strPrecentage, driver);	 		 		
 	}

 	//Description: Deselect All Chapter
 	public void deselectAllChapter(){ 
    	ResultUtil.report("INFO", "CreateEditAssignmentPage>>>deselectAllChapter", driver);    	 
    	WebElement chapter = driver.findElement(By.xpath("//tr//select[@name='association']"));
    	Listbox.deselectAll(chapter, "Deselect All", driver);
 	}
 	
 	//Description: Select Question For SubmitEdit Score PreCondition
 	public void selectQuestionsForSubmitScoreEditPre(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectQuestionsForSubmitPre", driver);
		String strQuestionCount=dataMap.get("QuestionCountSubmitScoreEdit");
		int questionLenght=Integer.parseInt(strQuestionCount);
		for(int i=1;i<=questionLenght;i++){
		String strQuestion=dataMap.get("QuestionsSubmitScoreEdit"+i);
		String strQuestionsXpath= "//a[.='"+strQuestion+"']//parent::td//preceding-sibling::td//input[@type='checkbox']";
		WebElement questions=driver.findElement(By.xpath(strQuestionsXpath));
		Checkbox.check("Question selected-" +strQuestion, questions, driver);
		}
  	}	
  	
 	public void select100Question(){
 		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>select100Question", driver);
 		
 		List<WebElement> listcheckbox = driver.findElements(By.xpath(strPlainTableXpath+"//tr//input[@type='checkbox']"));
		listcheckbox.size();			
		for(int i=2;i<=listcheckbox.size();i++)
		{
			if((i<=100)){
				WebElement checkboxclick = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
				Checkbox.isEnabled(checkboxclick, "verify Checkbox", driver);
				Checkbox.check("Select Questions", checkboxclick, driver);
				String questionName=driver.findElement(By.xpath(strPlainTableXpath+"/tbody/tr["+i+"]//td[2]")).getText();
				questionNames.append(questionName);
			}
		}
		Element.verify("Search Questions", driver, "XPATH", "//select[contains(@name,'showperpage')]");
 	}
 	
 	
 	public void selectAssistanceShowAlways(Map<String,String> dataMap){
 		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectAssistance", driver);
 		String strShowAlways= "always visible";
 		Combobox.selectItemByValue("Show Links", drpShowLinks, strShowAlways, driver);
 		Combobox.selectItemByValue("Show Solutions", drpShowSolution, strShowAlways, driver);
 		Combobox.selectItemByValue("Show Answer", drpShowAnswer, strShowAlways, driver); 		
 	}
 	
 	public void selectfutureDate(Map<String,String> dataMap){
 		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectfutureDate", driver);
 		
 		driver.switchTo().frame(0);
 		
 		WebElement txtStartDate= driver.findElement(By.xpath("//input[contains(@name,'sdt')]"));
 		txtStartDate.click(); 		
 		
 		String strMonth= dataMap.get("Month");
 		String strDate= dataMap.get("Date");
 		
 		WebElement futureDate= driver.findElement(By.xpath("//div[@class='month']//div[contains(text(),'"+strMonth+"')]//following-sibling::div[2]//div[.='"+strDate+"']"));
 		
 		Link.mouseClick("Future Date", futureDate, driver);	
 		
 	}

 	public void selectSpecificQuestion(Map<String,String> dataMap, String strQuestionType){
 		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectSpecificQuestion", driver);
 		String strQuestionTypes=dataMap.get(strQuestionType);
 		List<WebElement> questions=driver.findElements(By.xpath("//table[@class='plain-table']//td[contains(.,'"+strQuestionTypes+"')]//parent::td//preceding-sibling::td[3]//input"));
 		int a=0;
 		if(questions.size()>5)
 		{

 			for(WebElement trueQuestion:questions)
 			{ 			
 				Checkbox.check("Question Link", trueQuestion, driver);
 				a=a+1;
 				if(a==5)
 				{
 					break;
 				}
 			}
 		}
 	}
 	
 	public void verifyDescriptionDetailsScreenshot(){
 		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>selectSpecificQuestion", driver);
 		
 		//ImageUtil.compareImage("Description Page", "document/Assignment/E4_4717.png", driver); 		
 	}
 	
 	public void verifyPrintedTestScreenshots(){
 		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyTenVersionScreenshots", driver);
 		
 		//ImageUtil.compareImage("Description Page", "document/Assignment/E4_4717.png", driver);
 		
 	}
}

           
        