package Pages.WPBlackboardIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.GradeBookPage;
import Pages.Common.Initializer;
import Pages.Common.StudentHomepage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.BBPublicContentPage;
import Toolbox.Browser;
//import Pages.SnapwizIntegration.BBPublicContentPage;
//import screens.Button;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Util.PropertyUtil;

public class BlackBoardIntegrationPage  extends Initializer
{

	public WebElement element;

	public BlackBoardIntegrationPage(WebDriver driver){
		super(driver);
		getContent( );
	}

	@FindBy(how = How.NAME, using = "user_id")
	private WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement btnLogin;

	@FindBy(how = How.NAME, using = "name")
	private WebElement txtwpEmail;

	@FindBy(how = How.NAME, using = "passwordText")
	private WebElement txtwpPassword;

	@FindBy(how = How.NAME, using = "//div[@id='login-btn']")
	private WebElement btnwpLogin;

	@FindBy(how = How.XPATH, using = "//a//span[@title='Tools']")
	private WebElement lnktools;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Assignments')]")
	private WebElement lnkclickwileyplusassign;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'WileyPLUS Homepage')]")
	private WebElement lnkclickwileyplusHome;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS')]")
	private WebElement lnkwileyplus;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Gradebook (archived)')]")
	private WebElement lnkArchive;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Diagnostics')]")
	private WebElement lnkDiagnostic;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Roster Information')]")
	private WebElement lnkRoster;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Help & Support')]")
	private WebElement lnkHelp;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Gradebook')]")
	private WebElement lnkwileyplusGB;

	@FindBy(how = How.XPATH, using = "//ul[@id='content_listContainer']//span[text()='future']")
	private WebElement lnkWPfutureassign;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Content: Tools')]")
	private WebElement lnkContentTools;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Content: tools')]")
	private WebElement lnkContenttools;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Content Refresh')]")
	private WebElement lnkWileyRefresh;

	@FindBy(how = How.XPATH, using = "//a[./span[text()='Content 2']]//span[text()='Content 2']")
	private WebElement lnkselcontent2;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Content: assignments')]")
	private WebElement lnkselectassignments;

	@FindBy(how = How.XPATH, using = "//div[@id='_3978_1']")
	private WebElement lnkclickzeroassignments;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'WileyPLUS Assignments')]")
	private WebElement lnkWPAssignments;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'question no due date')]")
	private WebElement lnknoduedate;

	@FindBy(how = How.XPATH, using = "//a[@id='Go_To_Student_View']")
	private WebElement lnkstudentView;

	@FindBy(how = How.XPATH, using = "//a[@id='Gocls333314']")
	private WebElement lnkAGCoursego;

	@FindBy(how = How.XPATH, using = "//a[@id='Instructor_View']")
	private WebElement lnkinstructorview;

	@FindBy(how = How.XPATH, using = "//a[@id='lti-return-button']")
	private WebElement lnkReturntoBB;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'WileyPLUS Gradebook')]")
	private WebElement lnkGradebook;

	@FindBy(how = How.XPATH, using = "//a[.='WileyPLUS System Announcements']")
	private WebElement lnkSysAnouncements;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Read')]")
	private WebElement lnkRSP;

	@FindBy(how = How.XPATH, using = "//div[@class='shadow']//a[.='WileyPLUS Total Score']")
	private WebElement lnkTotalScore;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Roster')]")
	private WebElement lnkWPRoster;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'kunal')]")
	private WebElement lnkWPaccount;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Chapter 02 Practice')]")
	private WebElement lnkWPPractice;

	@FindBy(how = How.XPATH, using = "//table//tbody//tr//a[contains(.,'Chapter 02 Practice')]")
	private WebElement lnkInstructorWP02Practice;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Finish WileyPLUS Class')]")
	private WebElement lnkWPFinish;

	@FindBy(how = How.XPATH, using = "//div[@class='lti-right-arrow-button']")
	private WebElement lnkPressFinish;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Users and')]")
	private WebElement lnkUsersandGroups;

	@FindBy(how = How.XPATH, using = "//div[@class='navPaletteContent']//a[text()='Users']")
	private WebElement lnkUsers;

	@FindBy(how = How.XPATH, using = "//div[@id='actionbar']//ul//li//a[starts-with(.,'Enroll')]")
	private WebElement lnkEnrollUsers;

	@FindBy(how = How.XPATH, using = "//div[@id='actionbar']//ul//li//a[starts-with(.,'Find')]")
	private WebElement lnkFindUsers;

	@FindBy(how = How.XPATH, using = "//a[.='Personal Information']")
	private WebElement lnkPersonalInfo;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Edit Personal')]")
	private WebElement lnkEditPersonalInfo;

	@FindBy(how = How.NAME, using = "firstName")
	private WebElement txtfname;

	@FindBy(how = How.NAME, using = "lastName")
	private WebElement txtlastname;

	@FindBy(how = How.NAME, using = "top_Submit")
	private WebElement btnsubmit;

	@FindBy(how = How.XPATH, using = "//div[@id='_3985_1']//span[contains(text(),'unassigned')]")
	private WebElement lnkWPUnassign;

	@FindBy(how = How.XPATH, using = "//div[@id='_3981_1']//span[text()='mastery']")
	private WebElement lnkWPmastery;

	@FindBy(how = How.XPATH, using = "//a[.='timed - 20 min']")
	private WebElement lnkTimedassign;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'view only')]")
	private WebElement  lnkreadonly;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'with assistance')]")
	private WebElement  lnkreadwith;

	@FindBy(how = How.XPATH, using = "//table//tr[2]//td//h1[@class='error']")
	private WebElement  lblferror;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'WileyPLUS Total Score')]")
	private WebElement lnkFinishedTotalScore;

	@FindBy(how = How.ID, using = "lti-return-button")
	private WebElement btnReturnBlackBoard;

	@FindBy(how = How.XPATH, using = "//span[@title='Content']")
	private WebElement lnkselcontent;

	@FindBy(how = How.XPATH, using = "//span[@title='content']")
	private WebElement lnksmallercasecontent;

	@FindBy(how = How.XPATH, using = "//a/span[text()='Chapter 01 Continuing Case Video Quiz']")
	private WebElement lnkCase;

	@FindBy(how = How.XPATH, using = "//a[text()='Publisher Content']")
	private WebElement elmntPublishContent;

	@FindBy(how = How.XPATH, using = "//div[@class='navPaletteContent']//a[.='Grade Center']")
	private WebElement elmntGradecenter;

	@FindBy(how = How.XPATH, using = "//li[@class='favorite']//a[contains(.,'Assignments')]")
	private WebElement elmntGCassignments;

	@FindBy(how = How.XPATH, using = "//a[@id='lti-return-button']//ins[@class='c']")
	private WebElement returnbutton;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Configuration')]")
	private WebElement elmntSelConfig;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'LTI Content Discovery')]")
	private WebElement elmntLTI;

	@FindBy(how = How.XPATH, using = "//table//td[1]//span[contains(text(),'Tools Links')]")
	private WebElement elmntTools;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Finished Class')]")
	private WebElement elmntFinish;

	@FindBy(how = How.XPATH, using = "//table//tr[1]//a[contains(text(),'WileyPLUS')]")
	private WebElement elmntAdminWileyPLus;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Support/Help Links')]")
	private WebElement elmntSupportHelp;

	@FindBy(how = How.NAME, using = "bottom_Submit")
	private WebElement btnwileysubmit;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Delete')]")
	private WebElement btnDelete;

	@FindBy(how = How.XPATH, using = "//span[text()='System Admin']")
	private WebElement elmntSystemAdmin;

	@FindBy(how = How.XPATH, using = "//a[@id='nav_pa_ext' and text()='Building Blocks']")
	private WebElement elmntbuildingblocksLink;

	@FindBy(how = How.ID, using = "unfilteredList_showAllButton")
	private WebElement elmntShowAllBtn;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Show All')]")
	private WebElement elmntkunalShowAllBtn;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'WileyPLUS Read, Study & Practice')]")
	private WebElement lnkReadStudyPractice;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'WileyPLUS Training & How-To')]")
	private WebElement lnkTraining;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Read, Study & Practice')]")
	private WebElement elmntInstructorReadStudyLink;

	@FindBy(how = How.LINK_TEXT, using = "Help")
	private WebElement lnkhelp;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'System Announcements')]")
	private WebElement lnksysannounce;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),' WileyPlus Testing Add content')]")
	private WebElement addcontent;

	@FindBy(how = How.XPATH, using = "//a[@id='controlpanel.grade.center_groupExpanderLink']")
	private WebElement gradecenter;

	@FindBy(how = How.XPATH, using = "//a[@title='Assignments']")
	private WebElement assignments;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Gocls333498']")
	private WebElement lnkgo;

	private Map<String,String> contentMap;
	
	String strdivSection = "//div[@id='div_4_1']";

	String strTableSection = "//table[@id='listContainer_datatable']//td";
	

	private void getContent( ){
		contentMap = PropertyUtil.getPropAsHashMap("document/contents.properties");
	}	

	//Description:provides login details
	public BlackBoardIntegrationPage BBInstructorLogin(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>BBInstructorLogin",driver);
		WebElement txtEmail=Sync.waitForObject(driver, "Email", "id", "user_id");
		TextBox.enterValue("Enter Username", txtEmail, dataMap.get("BBInstructorUsername"), driver);
		TextBox.enterValue("Enter Password", txtPassword, dataMap.get("BBInstructorPassword"), driver);
		Button.click("ClickonLogin", btnLogin,driver);	
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);	
	}

	//Description:BB Student Login
	public BlackBoardIntegrationPage BBStudentLogin(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>BBStudentLogin",driver);
		TextBox.enterValue("Enter Username", txtEmail, dataMap.get("BBStudentUsername"), driver);
		TextBox.enterValue("Enter Password", txtPassword, dataMap.get("BBStudentPassword"), driver);
		Button.click("ClickonLogin", btnLogin,driver);	
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);	
	}

	//Description:BB Admin Login
	public BlackBoardIntegrationPage BBAdminLogin(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>BBAdminLogin",driver);
		TextBox.enterValue("Enter Username", txtEmail, dataMap.get("BBAdminUsername"), driver);
		TextBox.enterValue("Enter Password", txtPassword, dataMap.get("BBAdminPassword"), driver);
		Button.click("ClickonLogin", btnLogin, driver);	
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);	
	}

	//Description:WP Admin Login
	public BlackBoardIntegrationPage WPAdminLogin(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>WPAdminLogin",driver);
		TextBox.enterValue("Enter Username", txtwpEmail, dataMap.get("WPAdminEmail"), driver);
		TextBox.enterValue("Enter Password", txtwpPassword, dataMap.get("WPAdminPassword"), driver);
		Button.click("ClickonLogin", btnwpLogin, driver);	
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);	
	}

	//Description:verify gb link archive
	public void wPGBLinkArchive() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>GBLinkArchive",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe frame", "contentFrame", 6);
		Link.verify("Select WPGBLinkArchive", lnkArchive, "WileyPLUS Gradebook (archived)",driver);
	}

	//Description:verify diagnosticlink
	public void wPLinkDiagnostic() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>GBLinkArchive",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe frame", "contentFrame", 6);
		Link.verify("Select WPLinkDiagnostic", lnkDiagnostic, "WileyPLUS Diagnostic",driver);

	}

	//Description:click on link roster
	public void wPLinkRoster() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>GBLinkArchive",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe frame", "contentFrame", 6);
		Link.verify("Select WPLinkRoster", lnkRoster, "WileyPLUS Roster Information",driver);

	}

	//Description:click on helplink
	public void wPLinkHelp() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>GBLinkArchive",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe frame", "contentFrame", 6);
		Link.verify("Select  WPLinkHelp",lnkHelp, "WileyPLUS Help & Support",driver);

	}
	//Description:select wp home page
	public void selectWPHomePage() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectWPHomePage",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe frame", "contentFrame", 6);
		Link.click("Select AG Test course", lnkclickwileyplusHome,driver);

	}
	//Description:enter personal into bb 
	public void personalInfo() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>PersonalInfo",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe frame", "contentFrame", 6);
		Link.click("click on Personal INformation", lnkPersonalInfo,driver);
		Link.click("click on edit Personal INformation", lnkEditPersonalInfo,driver);
	}

	//Description:click on tools link of kunal course
	public void tools() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>Tools",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("click on tools", lnktools,driver);
	}

	//Description:click on wileyplus
	public BlackboardToolsWileyPlusPage wileyplus() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplus",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "content", 6);
		Link.click("Click on Wiley PLus", lnkwileyplus,driver);
		return PageFactory.initElements(driver, BlackboardToolsWileyPlusPage.class);
	}

	//Description:select content2 link of sw course
	public void selectcontent2() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectcontent",driver);
		switchToContentFrame();
		Link.click(" Select content 2", lnkselcontent2, driver);				
	}

	//Description:click on wiley plus assignment link
	public void wileyplusassign() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplus",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus WPUnassign", lnkclickwileyplusassign,driver);
		Sync.waitForSeconds(3,driver);
	}

	//Description:click on mastery assignment present in agt test course 1
	public void wPmasteryAssignment() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplus",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus WPUnassign", lnkWPmastery,driver);
	}
	//Description:click on timed assignment present in ag courses
	public void wPTimedAssignment() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplus",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus timed assignment", lnkTimedassign,driver);
	}
	//Description:click on wiley plus 
	public void wileyplusunassign() throws Exception
	{

		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplusunassign",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus",lnkWPUnassign,driver);
	}
	//Description:mastery assignment
	public void wileyplusmasteryassign() throws Exception
	{

		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplusmasteryassign",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on wileyplusmasteryassign",lnkWPmastery,driver);
	}

	//Description:wiley plus due date
	public void wileyPlusnoduedate() throws Exception
	{

		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplusnoduedate",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on wileyplusnoduedate",lnknoduedate,driver);
	}

	//Description:read with assitance
	public void readWithAssistance() throws Exception
	{

		ResultUtil.report("INFO", "BlackBoardIntegrationPage>ReadWithAssistance",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on ReadWithAssistance",lnkreadwith,driver);
	}

	//Description:wiley plus gradebook
	public void wileyplusGB() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyplusGB",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "content", 6);
		Link.click("CLick on Wiley PLus Gradebook", lnkwileyplusGB,driver);
	}

	//Description:capital T...contentTools
	public void contentTools() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>contentTools",driver);
		Sync.waitForFrame(driver, "Content frame", "content", 6);
		Link.click("Click on Content Tools", lnkContentTools,driver);
	}

	//Description:click on tools which has small T
	public void contenttools() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>contenttools",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("Click on Content tools", lnkContenttools,driver);
	}

	//Description:smartContent
	public void smartContent() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>smartContent",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "content", 6);
		Link.click("CLick on Wiley PLus Refresh Content", lnkWileyRefresh,driver);		
	}

	//Description:SubmitRefresh
	public void SubmitRefresh() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>SubmitRefresh",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "content", 6);
		Button.click("Submit for Refresh ", btnwileysubmit,driver);
	}

	//Description:ContentAssignments
	public void contentAssignments() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>ContentAssignments",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("Content : Assignments", lnkselectassignments,driver);
	}

	//Description:click on zeroassignments
	public void zeroAssignments() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>ContentAssignments",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("Assignment zero",lnkclickzeroassignments,driver);
	}

	//Description:click onwpassignments
	public void wPAssignments() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> WPAssignments",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "content", 6);
		Link.click("wiley plus assignment link ", lnkWPAssignments,driver);

	}

	//Description:click on futureassignments
	public void futureAssignments() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> FutureAssignments",driver);	
		switchToContentFrame();
		Link.click("wiley plus assignment link ", lnkWPfutureassign,driver);
	}

	//Description:click on readonly assignments
	public void readOnlyAssignments() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> ReadOnlyAssignments",driver);
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("wiley plus assignment link ", lnkreadonly,driver);
	}

	//Description:cllick on wiley plus
	public void clickwileyplus() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickwileyplus",driver);		
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);		
		Link.click("CLick on Wiley PLus", lnkwileyplus,driver);
	}

	//Description:clickon gradebook
	public void clickGradebook() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickGradebook",driver);		
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus Gradebook", lnkGradebook,driver);
	}

	//Description:click on systemannouncements
	public void clickWPSystemAnnouncements() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickWPSystemAnnouncements",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus Gradebook", lnkSysAnouncements,driver);
	}

	//Description:click on wprsp
	public void clickWPRSP() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickWPRSP",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus ReadStudeyPractice", lnkRSP,driver);
	}

	//Description:click on totalscore
	public void clickTotalScore() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickTotalScore",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus clickTotalScore", lnkTotalScore,driver);
	}

	//Description:click on student view
	public void studentView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>studentView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);		
		Button.click("Click on Go To Student View", lnkstudentView,driver);
	}

	//Description:click on student view
	public void verifystudentView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>studentView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Button.verify("Click on Go To Student View", lnkstudentView,driver);

	}
	//Description:click on student view present in headframe
	public void headframestudentView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>headframestudentView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);
		Button.click("Click on Go To Student View", lnkstudentView,driver);
	}

	public void verifyheadframestudentView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>headframestudentView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);
		Button.verify("Click on Go To Student View", lnkstudentView,driver);
	}

	//Description:verify blackboard button present or not
	public void verifyBlackBoard() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>verifyBlackBoard",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Button.verify("Return to BlackBoard", returnbutton,driver);
	}

	//Description:bb is present in head frame
	public void verifyheadframeBlackBoard() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>verifyBlackBoard",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		try{
			Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);			
		}
		catch(Exception e) {}
		Button.verify("Return to BlackBoard", returnbutton,driver);
	}

	//Description:instructor view
	public void instructorView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>instructorView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Button.click("click on instructor view", lnkinstructorview,driver);
	}

	//Description:instructor view
	public void verifyinstructorView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>verifyinstructorView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Button.verify("click on instructor view", lnkinstructorview,driver);
		Sync.waitForSeconds(4,driver);
	}

	//Description:click on instructorview
	public void headframeinstructorView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>headframeinstructorView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		try{
			Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);
		}
		catch(Exception e) {}
		Button.click("click on instructor view", lnkinstructorview,driver);
	}

	public void verifyheadframeinstructorView()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>headframeinstructorView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		try{
			Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);
		}
		catch(Exception e) {}
		Button.verify("click on instructor view", lnkinstructorview,driver);
	}

	
	//Description:click on AG coursego
	public void clickAGCourseGo() throws Exception
	{
		ResultUtil.report("INFO", "clickGo>studentView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Button.click("Click on Go", lnkAGCoursego,driver);
	}

	//Description:click on wiley rosterinfo
	public void wileyRosterinfo() 
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>WileyRosterinfo",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "ContentFrame Frame", "contentFrame", 6);		
		Link.click("CLick on Wiley PLus WileyRosterinfo", lnkWPRoster,driver);
	}

	//Description:click on wp finished class
	public void wPFinishedClass()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>WileyRosterinfo",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "ContentFrame Frame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus WileyRosterinfo", lnkWPFinish,driver);		
	}

	//Description:click on verify Finsihclass
	public void verifyFinishClass() 
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>verifyFinishClass",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "container Frame", "container", 6);
		WebElement returnbutton = lnkPressFinish;
		Button.verify("Yes, finish it!", returnbutton,driver);
	}

	//Description:click on wileyplusaccount
	public void wileyPlusAccount() 
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>WileyPlusAccount",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "contentFrame", 6);
		Link.click("CLick on WileyPlusAccount kunal sra", lnkWPaccount,driver);
	}

	//Description: click on wiley plusp ractice
	public void wileyPlusPractice() 
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>WileyPlusPractice",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "contentFrame", 6);
		Link.click("CLick on WileyPlus Practiceassignment", lnkWPPractice,driver);
	}

	//Description: view enroll users option
	public void viewEnrollUsersOption() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>WileyPlusPractice",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "contentFrame", 6);		
		Link.click("CLick on WileyPlus UsersandGroups", lnkUsersandGroups, driver);
		Link.click("Click on Wiley Users", lnkUsers,driver);
		Link.click("Click on Enroll Users", lnkEnrollUsers,driver);
		Link.click("Click on Enroll Users", lnkFindUsers,driver);
	}

	//Description: enter personal info
	public void enterPersonalInfo() throws Exception
	{
		TextBox.enterValue("firstname",txtfname ,"kunal1",driver);
		TextBox.enterValue("LastName", txtlastname,"sra1",driver);
		Button.click("Clickon submitbutton", btnsubmit,driver);	
	}

	//Description:closebrowser
	public void closeBrowser()  throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>>>closeBrowser",driver);
		driver.quit();
	}

	//Description:select verify un assigned
	public void verifyUnassignedAssignment()
	{

		ResultUtil.report("INFO", "BlackBoardIntegrationPage>>>verifyUnassignedAssignment",driver);
		driver.switchTo().defaultContent();
		switchFrameCourseListTable();
		WebElement verifyUnassigned=driver.findElement(By.xpath("//table//table//td[contains(.,'This assignment')]"));
		String strUnassigned=verifyUnassigned.getText().trim();
		String strUnassignedCheck="This assignment is not assigned to your class. Please use the content refresh tool to reassign it.";
		if(strUnassigned.equalsIgnoreCase(strUnassignedCheck))
		{
			Element.verify("Unassigned Text",verifyUnassigned,driver);
		}
	}

	//Description: select switch frame course
	public void switchFrameCourseListTable(){
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "ag_nav_top frame", "ag_nav_top", 6);
	}

	//Description:verify finish error 
	public void Finisherror() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>Finisherror",driver);
		Element.verify("Check Error", lblferror, "Sorry!",driver);
	}

	//Description:select return to black board
	public void returnToBlackboard() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>ReturnToBlackboard",driver);		
		try{			
			Sync.waitForFrame(driver, "Frame index", 0, 6);
			Sync.waitForFrame(driver, "Container frame", "container", 6);
		}
		catch(Exception e){}
		Button.click("Return to BlackBoard", btnReturnBlackBoard,driver);
	}

	//Description:select total score  off bb link
	public void clickFinishTotalScore() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickFinishTotalScore",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "ContentFrame", "contentFrame", 6);
		Link.click("CLick on Wiley PLus clickTotalScore", lnkFinishedTotalScore,driver);
	}

	//Description:Select the course name from the dataMap 
	public void selectCourseName(Map<String,String> dataMap){
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectCourseName",driver);
		switchToContentFrame();	
		String strCourseName = dataMap.get("CourseName").trim().toString();
		Sync.waitForObject(driver, "Course Name", "XPATH", "//a[contains(.,'"+strCourseName+"')]");
		WebElement elemntCourseElement=driver.findElement(By.xpath("//a[contains(.,'"+strCourseName+"')]"));
		Link.click("Course link",elemntCourseElement ,driver);
	}

	//Description:Select WileyPlus home page link 
	public CourseHomePage selectWPHomePageLink()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectWPHomePageLink",driver);
		switchToContentFrame();
		Link.mouseOver("WileyPlus Home page", driver.findElement(By.xpath("//li[starts-with(@id,'contentListItem')]//span[text()='WileyPLUS Homepage']")), driver);
		Link.click("WileyPlus Home page", driver.findElement(By.xpath("//a[span[text()='WileyPLUS Homepage']]")),driver);
		return PageFactory.initElements(driver, CourseHomePage.class);
	}

	//Description:Go to wiley plus assignments page 
	public AssignmentPage goToWileyPlusAssignment() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> goToWileyPlusAssignment",driver);
		switchToContentFrame();
		Link.click("wiley plus assignment link ", lnkWPAssignments,driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}

	//Description:Switch to Content frame
	public void switchToContentFrame()
	{
		try
		{
			driver.switchTo().window(driver.getWindowHandle().toString());
		}
		catch(Exception e) {}	
		Sync.waitForFrame(driver, "Content Frame", "content", 6);
	}

	//Description:select content
	public void selectcontent() 
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectcontent",driver);	
		Sync.waitForFrame(driver, "Content", "content", 6);
		Link.click(" Select content 2", lnkselcontent,driver);				
	}

	//Description:select smaller case content
	public void selectsmallercasecontent()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectcontent",driver);			
		Sync.waitForFrame(driver, "Content", "content", 6);
		Link.click(" Select content 2", lnksmallercasecontent,driver);						
	}

	//Description:click on continuing case quiz
	public void selectCaseQuiz() 
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectCaseQuiz",driver);		
		switchToContentFrame();
		Link.click(" Select content 2", lnkCase,driver);					
	}

	//Description:selecting AG testcourse 1
	public void selectCourseName2(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectCourseName2",driver);		
		String strCourseName = dataMap.get("CourseName2").trim();
		switchToContentFrame();
		Link.click("Course link", driver.findElement(By.xpath(strdivSection+"//a[contains(text(),'"+strCourseName+"')]")),driver);	
	}

	//Description:selecting AG testcourse 2
	public void selectCourseName3(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectCourseName3",driver);
		switchToContentFrame();
		String strCourseName = dataMap.get("CourseName3").trim().toString();
		Link.click("Course link", driver.findElement(By.xpath("//a[contains(.,'"+strCourseName+"')]")),driver);			
	}

	//Description:selecting kunal course
	public void selectCourseName4(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectCourseName4",driver);		
		switchToContentFrame();
		String strCourseName = dataMap.get("CourseName4").trim().toString();
		WebElement elemntCourseElement=driver.findElement(By.xpath(strdivSection+"//a[contains(.,'"+strCourseName+"')]"));
		Link.click("Course link",elemntCourseElement ,driver);		
	}

	//Description:selecting SW course
	public void selectCourseName5(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectCourseName",driver);
		switchToContentFrame();
		String strCourseName = dataMap.get("CourseName4").trim().toString();
		Link.click("Course link", driver.findElement(By.xpath(strdivSection+"//a[contains(.,'"+strCourseName+"')]")),driver);	
	}

	//Description:Select the wileyplus link in student blackboard page 
	public StudentHomepage selectStudentWPHomePageLink()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectWPHomePageLink", driver);
		switchToContentFrame();
		Link.click("WileyPlus Home page", driver.findElement(By.xpath("//span[text()='WileyPLUS Homepage']")),driver);		
		return PageFactory.initElements(driver, StudentHomepage.class);
	}

	//Description:Goto Publish content
	public BBPublicContentPage selectPublishContent()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectPublishContent", driver);
		switchToContentFrame();
		Actions action = new Actions(driver);
		action.moveToElement(elmntPublishContent).perform();
		return PageFactory.initElements(driver, BBPublicContentPage.class);
	}

	//Description:select grade center
	public void selectGradeCenter()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectGradeCenter",driver);		
		switchToContentFrame();
		Link.click("Course link", elmntGradecenter,driver);			
	}

	//Description:select gc assign
	public void selectGCAssign()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectGCAssign",driver);
		switchToContentFrame();	
		Link.click("Course link", elmntGCassignments,driver);		
	}

	//Description:select configuaration of admin
	public void selectconfiguaration()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectconfiguaration",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main frame ", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame ", "userframe", 6);
		Sync.waitForFrame(driver, "navigator frame ", "navigator", 6);		
		Link.click("Configuaration link", elmntSelConfig,driver);			
	}

	//Description:select on lti content of admin
	public void selectLTIContent()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectLTIContent",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main frame ", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame ", "userframe", 6);
		Sync.waitForFrame(driver, "navigator frame ", "navigator", 6);
		Link.click("Configuaration link", elmntLTI,driver);			
	}

	//Description:select tools link of WP Admin
	public void selectToolsLink()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectToolsLink",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main frame ", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame ", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame ", "workframe", 6);
		Link.click("Configuaration link", elmntTools,driver);			
	}

	//Description:select finished class of wp admin
	public void selectFinishedClass()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectFinishedClass",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main frame ", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame ", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame ", "workframe", 6);
		Link.click("Finishedclass", elmntFinish,driver);			
	}

	//Description:click on admin
	public void selectAdminWileyPLus()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectAdminWileyPLus",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main frame ", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame ", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame ", "workframe", 6);
		Link.click("selectAdminWileyPLus", elmntAdminWileyPLus,driver);			
	}

	//Description:click on wiley help
	public void elmntSupportHelp()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>elmntSupportHelp",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main frame ", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame ", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame ", "workframe", 6);
		Link.click("elmntSupportHelp", elmntSupportHelp,driver);		
	}

	//Description:Validate wileyplus home page
	public void wileyPlusHomePage()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>wileyPlusHomePage",driver);
		Element.verify("Wileyplus logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
		Element.verify("Instructor welcome message", driver, "XPATH", "//div[text()='You are the Instructor for:']");
	}

	//Description:Validate "Open wileyplus window" is set to "No"
	public void validateWileyPlusWindowSettings()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>validateWileyPlusWindowSettings",driver);
		//Validate the radio button of open window settings to "No"
		Radiobutton.isSelected("No-Radio button is selected", driver.findElement(By.xpath("//li[./div[contains(text(),'New Window')]]//input[@value='false']")), driver);		
	}

	//Description:Go to Wileyplus Integration Blackboard  Settings
	public void goToWPIBlackboardSettings()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToWPIBlackboardSettings",driver);
		//Click "Show all" button
		Button.click("Showall", elmntShowAllBtn, driver);		
		Sync.waitForObject(driver, "Wiley plus integration link", "XPATH", "//th[normalize-space(.)='WileyPLUS Integration by Blackboard']");
		Browser.scrollToObject("Wielyplus link", driver.findElement(By.xpath("//th[normalize-space(.)='WileyPLUS Integration by Blackboard']")), driver);		
	}

	//Description:Go to Installed tools
	public void goToInstalledTools()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToInstalledTools",driver);
		//Click "Installed tools" link
		Link.click("Installed tools", driver.findElement(By.xpath("//a[contains(text(),'Installed Tools')]")), driver);		
	}

	//Description:Go to System admin page
	public void goToSystemAdmin()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToSystemAdmin",driver);	
		//Navigate to nav frame
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Nav frame", "navFrame", 6);
		//Click System admin link
		Link.click("System admin", elmntSystemAdmin, driver);			
	}

	//Description:Go to Building blocks
	public void goToBuildingBlocks()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToSystemAdmin",driver);
		//Navigate to Content frame
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "contentFrame", 6);
		//Click "Building blocks" link
		Link.click("Building blocks", elmntbuildingblocksLink, driver);	
	}
	//Description:show all links
	public void showAll()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>showAll",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "content Frame", "content", 6);			
		Button.click("showAll", elmntkunalShowAllBtn, driver);	
	}

	//Description:Go to  student wiley plus assignments page 
	public StudentAssignmentPage goToStudentWileyPlusAssignment() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> goToStudentWileyPlusAssignment",driver);
		switchToContentFrame();
		Link.click("wiley plus assignment link ", lnkWPAssignments,driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}

	//Description:Go to  student wiley plus read study page 
	public StudentAssignmentPage goToStudentWileyPlusReadStudy() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> goToStudentWileyPlusAssignment",driver);
		switchToContentFrame();
		Link.click("wiley plus Read study practice  link ", lnkReadStudyPractice,driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}

	//Description:Go to  student wiley plus Gradebook  page 
	public StudentAssignmentPage goToStudentWileyPlusGradebook() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToStudentWileyPlusGradebook",driver);
		switchToContentFrame();
		Link.click("Click on Wiley PLus Gradebook", lnkGradebook,driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}

	//Description:Go to  student wiley plus System announcements page 
	public StudentAssignmentPage goToStudentWileyPlusSysAnnouncements() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToStudentWileyPlusSysAnnouncements",driver);
		switchToContentFrame();
		Link.click("CLick on Wiley PLus SysAnnouncements", lnkSysAnouncements,driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);

	}

	//Description:Go to  student wiley plus System announcements page 
	public StudentAssignmentPage goToStudentWileyPlusTraining() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToStudentWileyPlusTraining",driver);
		switchToContentFrame();
		Link.click("CLick on WileyPlus Training", lnkTraining,driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);	
	}

	//Description:Go to  student wiley plus total score page 
	public StudentAssignmentPage goToStudentWileyPlusTotalscore() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>goToStudentWileyPlusTotalscore",driver);
		switchToContentFrame();
		Link.click("CLick on Wiley PLus clickTotalScore", lnkTotalScore,driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);	
	}

	//Description:Validate student content page
	public void validateStudentContentPage()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>validateStudentContentPage",driver);
		switchToContentFrame();
		Element.verify("Homepage link", driver, "XPATH", "//span[text()='WileyPLUS Homepage']");
		Element.verify("Assignments link", driver, "XPATH", "//span[text()='WileyPLUS Assignments']");
		Element.verify("Read-study-practice link", driver, "XPATH", "//span[text()='WileyPLUS Read, Study & Practice']");
		Element.verify("Gradebook link", driver, "XPATH", "//span[text()='WileyPLUS Gradebook']");
		Element.verify("System Announcements link", driver, "XPATH", "//span[text()='WileyPLUS System Announcements']");
		Element.verify("Total Score link", driver, "XPATH", "//span[text()='WileyPLUS Total Score']");	
	}

	//Description:Instructor Gradebook page
	public GradeBookPage validateInstructorGradebookPage()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>validateInstructorGradebookPage",driver);
		try{
			switchToContentFrame();
		}
		catch(Exception e){}

		try{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container frame", "container", 6);		
		}
		catch(Exception e){}
		return PageFactory.initElements(driver, GradeBookPage.class);
	}

	//Description:Student Gradebook page
	public StudentGradeBookPage validateStudentGradebookPage()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>validateStudentGradebookPage",driver);
		switchToContentFrame();
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}

	//Description:Select student name in Wileyplus roster page
	public GradeBookPage selectStudentWileyplusRoster(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>selectStudentWileyplusRoster",driver);
		switchToContentFrame();
		String strStudentRosterAccount = dataMap.get("WileyPlusRosterAccount");
		if(Link.verify("Wiley plus student account", driver.findElement(By.xpath(strTableSection+"/a[contains(text(),'"+strStudentRosterAccount+"')]")), driver))
		{
			ResultUtil.report("PASS", "Student WP Roster  account is displayed", driver);
			Link.click("Wiley plus student account", driver.findElement(By.xpath(strTableSection+"/a[contains(text(),'"+strStudentRosterAccount+"')]")), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Student WP Roster account is  not displayed", driver);	
		}	
		return PageFactory.initElements(driver, GradeBookPage.class);
	}
	//Description:log out of BB
	public void logoutBB()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>logoutBB",driver);
		Link.click("logoutbb", driver.findElement(By.xpath("//a[@title='Logout']")), driver);	
	}

	//Description:click on assignment practice
	public void clikwp02pratice()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clikwp02pratice",driver);
		Sync.waitForFrame(driver, "frame index", 0, 6);
		Link.click("clikwp02pratice", lnkInstructorWP02Practice, driver);	
	}
	//Description:click on assign next
	public void clickassignNext() throws Exception
	{

		ResultUtil.report("INFO", "MapleGraphPage>clickmapleNext",driver);
		String str = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(str);
		Sync.waitForFrame(driver, "Mainframe frmae", "mainframe", 6);
		Sync.waitForFrame(driver, "ag_nav_top frmae", "ag_nav_top", 6);
		Button.click("click on Next",driver.findElement(By.id("Next")),driver);

	}

	//Description:switct parent
	public void switchtoparent() throws Exception
	{

		String str = driver.getWindowHandles().toArray()[0].toString();
		driver.switchTo().window(str);

	}
	//Description:close dialog window
	public void windowclose() throws Exception
	{
		ResultUtil.report("INFO", "MapleGraphPage>windowclose",driver);
		String str = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(str);
		driver.close();	
	}

	//Description:Student Gradebook page - BB course
	public StudentGradeBookPage validateBBStudentGradebookPage()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>validateBBStudentGradebookPage",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}

	//Description:Go to  Instructor wiley plus read study page 
	public void goToWileyPlusReadStudy() throws Exception
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> goToInstructorWileyPlusReadStudy",driver);
		switchToContentFrame();
		Link.click("wiley plus Read study practice  link ", elmntInstructorReadStudyLink,driver);
	}

	//Description:Blackboard Instructor Eula
	public void bbInstructorEula()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> bbInstructorEula",driver);

		try{
			driver.switchTo().defaultContent();

			Sync.waitForFrame(driver, "Container Frame", "container", 6);
			Sync.waitForFrame(driver, "Frame index", 0, 6);				

			//Eula Text
			Element.verify("Instructor Eula text", driver, "XPATH", "//h3[text()='INSTRUCTOR & DEVELOPER LICENSE AGREEMENT']");
			String strlicenseAgreeheadtext = driver.findElement(By.xpath("//span[starts-with(text(),'This License Agreement')]")).getText();
			System.out.println(strlicenseAgreeheadtext);
			if(contentMap.get("LICENSE_AGREEMENTINSTUCTOR").contains(strlicenseAgreeheadtext)){
				ResultUtil.report("PASS", "The licence Agreement page text found", driver);
			}
			else{
				ResultUtil.report("FAIL","The Licence Agreement page text Not found", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='LICENSED RIGHTS']");
			Element.verify("Added Eula text", driver, "XPATH", "//p/span[contains(.,'You agree that any profile information that you provide to Wiley (name and email) may be shared with Wiley')]");
			String strlicensedrightscontaintext = driver.findElement(By.xpath("//p/span[contains(.,'You agree that any profile information that you provide to Wiley (name and email) may be shared with Wiley')]")).getText(); 
			System.out.println(strlicensedrightscontaintext);
			if(contentMap.get("LICENSE_AGREEMENTTOADD").contains(strlicensedrightscontaintext)){
				ResultUtil.report("PASS", "Added Eula text PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL","Added Eula text PAGE TEXT NOT FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='TERM AND TERMINATION']");
			Element.verify("Terms and conditions", driver, "XPATH", "//li[.//u[text()='TERM AND TERMINATION']]//span[contains(text(),'Wiley will maintain the Modified Program on its server during')]");
			String strTermsandconditioncontaintext = driver.findElement(By.xpath("//li[.//u[text()='TERM AND TERMINATION']]//span[contains(text(),'Wiley will maintain the Modified Program on its server during')]")).getText();
			System.out.println(strTermsandconditioncontaintext);
			if(contentMap.get("LICENSE_AGREEMENTTERMANDTERMINATION").contains(strTermsandconditioncontaintext)){
				ResultUtil.report("PASS", "TERM AND CONDITION PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL","TERM AND CONDITION PAGE TEXT not FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='OWNERSHIP']");
			Element.verify("Ownership", driver, "XPATH", "//li[.//u[text()='OWNERSHIP']]//span[contains(text(),'the content contained therein are and will remain the sole and exclusive property of Wiley')]");
			String strownershipcontaintext = driver.findElement(By.xpath("//li[.//u[text()='OWNERSHIP']]//span[contains(text(),'the content contained therein are and will remain the sole and exclusive property of Wiley')]")).getText();
			System.out.println(strownershipcontaintext);
			if(contentMap.get("LICENSE_AGREEMENTOWNERSHIP1").contains(strownershipcontaintext)){
				ResultUtil.report("PASS", "OWNERSHIP1 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL","OWNERSHIP1  PAGE TEXT not FOUND", driver);
			}
			Element.verify("Ownership part 2", driver, "XPATH", "//li[.//u[text()='OWNERSHIP']]//span[contains(text(),'Except as set forth in paragraph')]");
			String strownershippart2containtext = driver.findElement(By.xpath("//li[.//u[text()='OWNERSHIP']]//span[contains(text(),'Except as set forth in paragraph')]")).getText();
			System.out.println(strownershippart2containtext);
			if(contentMap.get("LICENSE_AGREEMENTOWNERSHIP2").contains(strownershippart2containtext)){
				ResultUtil.report("PASS", "OWNERSHIP2 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL","OWNERSHIP2  PAGE TEXT not FOUND", driver);
			}
			Element.verify("Ownership part 3", driver, "XPATH", "//li[.//u[text()='OWNERSHIP']]//span[contains(text(),'you have no right to use the Modified Program containing the originally created Instructor Content except')]");
			String strownershippart3containtext = driver.findElement(By.xpath("//li[.//u[text()='OWNERSHIP']]//span[contains(text(),'you have no right to use the Modified Program containing the originally created Instructor Content except')]")).getText();
			System.out.println(strownershippart3containtext);
			if(contentMap.get("LICENSE_AGREEMENTOWNERSHIP3").contains(strownershippart3containtext)){
				ResultUtil.report("PASS", "OWNERSHIP3 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL","OWNERSHIP3  PAGE TEXT not FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='INDEMNIFICATION']");
			Element.verify("indemnification", driver, "XPATH", "//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),'you harmless from and against all liability and expense')]");
			String strindemnificationcontaintext = driver.findElement(By.xpath("//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),'you harmless from and against all liability and expense')]")).getText();
			System.out.println(strindemnificationcontaintext);
			if(contentMap.get("LICENSE_INDEMNIFICATION1").contains(strindemnificationcontaintext)){
				ResultUtil.report("PASS", "Indemnification1 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", "Indemnification1 PAGE  not TEXT FOUND", driver);
			}
			Element.verify("indemnification2", driver, "XPATH", "//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),'otherwise for any claim or action alleging infringement based upon')]");
			String strindemnification2containtext = driver.findElement(By.xpath("//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),'otherwise for any claim or action alleging infringement based upon')]")).getText();
			System.out.println(strindemnification2containtext);
			if(contentMap.get("LICENSE_INDEMNIFICATION2").contains(strindemnification2containtext)){
				ResultUtil.report("PASS", "Indemnification2 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", "Indemnification2 PAGE not TEXT FOUND", driver);
			}
			Element.verify("indemnification3", driver, "XPATH", "//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),'successors and assigns from and against all liability and')]");
			String strindemnification3containtext = driver.findElement(By.xpath("//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),'successors and assigns from and against all liability and')]")).getText();
			System.out.println(strindemnification3containtext);
			if(contentMap.get("LICENSE_INDEMNIFICATION3").contains(strindemnification3containtext)){
				ResultUtil.report("PASS", "Indemnification3 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", "Indemnification3 PAGE not TEXT FOUND", driver);
			}
			Element.verify("indemnification4", driver, "XPATH", "//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),' THE ENTIRE LIABILITY AND OBLIGATIONS OF EACH')]");
			String strindemnification4containtext = driver.findElement(By.xpath("//li[.//u[text()='INDEMNIFICATION']]//span[contains(text(),' THE ENTIRE LIABILITY AND OBLIGATIONS OF EACH')]")).getText();
			System.out.println(strindemnification4containtext);
			if(contentMap.get("LICENSE_INDEMNIFICATION4").contains(strindemnification4containtext)){
				ResultUtil.report("PASS", "Indemnification4 PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", "Indemnification4 PAGE not TEXT FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='DISCLAIMERS']");
			Element.verify("Added Eula text", driver, "XPATH", "//p/span[contains(text(),'as to the accuracy or completeness of any content on the Licensed')]");
			String strdisclaimerscontaintext = driver.findElement(By.xpath("//p/span[contains(text(),'as to the accuracy or completeness of any content on the Licensed')]")).getText();
			System.out.println(strdisclaimerscontaintext);
			if(contentMap.get("LICENSE_DISCLAIMERS").contains(strdisclaimerscontaintext)){
				ResultUtil.report("PASS", " DISCLAIMERS PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " DISCLAIMERS PAGE TEXT not FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='LIMITATION OF LIABILITY']");
			Element.verify("Added Eula text", driver, "XPATH", "//p/span[contains(text(),'LICENSED PROGRAM SHALL BE LIABLE')]");
			String strlimitationcontaintext = driver.findElement(By.xpath("//p/span[contains(text(),'LICENSED PROGRAM SHALL BE LIABLE')]")).getText();
			System.out.println(strlimitationcontaintext);
			if(contentMap.get("LICENSE_LIMITATION").contains(strlimitationcontaintext)){
				ResultUtil.report("PASS", " LIMITATION OF LIABILITY PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " LIMITATION OF LIABILITY PAGE TEXT not FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='INJUNCTIVE RELIEF']");	
			Element.verify("Added Eula text", driver, "XPATH","//p/span[contains(text(),' intellectual property rights will result in irreparable injury')]");
			String strinjunctivecontaintype = driver.findElement(By.xpath("//p/span[contains(text(),' intellectual property rights will result in irreparable injury')]")).getText();
			System.out.println(strinjunctivecontaintype);
			if(contentMap.get("LICENSE_INJUNCTIVE").contains(strinjunctivecontaintype)){
				ResultUtil.report("PASS", " INJUNCTIVE RELIEF PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " INJUNCTIVE RELIEF PAGE TEXT not FOUND", driver);
			}
			Element.verify("Licensed rights", driver, "XPATH", "//u[text()='MISCELLANEOUS']");
			Element.verify("Licensed rights", driver, "XPATH","//p/span[contains(text(),'by a term or provision that is valid and enforceable and that comes')]" );
			String strmiscellaneouscontaintext = driver.findElement(By.xpath("//p/span[contains(text(),'by a term or provision that is valid and enforceable and that comes')]")).getText();
			System.out.println(strmiscellaneouscontaintext);
			if(contentMap.get("LICENSE_MISCELLANEOU").contains(strmiscellaneouscontaintext)){
				ResultUtil.report("PASS", " MISCELLANEOUS PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " MISCELLANEOUSPAGE TEXT not FOUND", driver);
			}
		}
		catch(Exception e)
		{

		}
	}

	//Description:Eula welcome page
	public void bbEulaWelcomePage()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> bbEulaWelcomePage",driver);
		if(Element.verify("Welcome screen", driver, "ID", "finishLater"))
		{
			ResultUtil.report("REPORT", "EULA Welcome page is displayed", driver);
			Link.click("Close", driver.findElement(By.id("finishLater")), driver);
		}
		else
		{
			ResultUtil.report("REPORT", "EULA Welcome page is not displayed", driver);
		}
	}

	//Description:Accept privacy information and acknowledgement
	public void acceptPrivacyInformation()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> acceptPrivacyInformation",driver);
		//	switchToContentFrame();
		if(Element.verify("User privacy information", driver, "XPATH", "//input[@value='true' and @name='agree']"))
		{
			ResultUtil.report("MESSAGE", "Launch Wileyplus page is displayed", driver);
			Radiobutton.select("User Agree", driver.findElement(By.xpath("//input[@value='true' and @name='agree']")), driver);
		}
		else
		{
			ResultUtil.report("MESSAGE", "Launch Wileyplus page is not  displayed", driver);
		}

		if(Element.verify("Do not show checkbox", driver, "XPATH", "//input[@type='checkbox' and @name='dontshow']"))
		{
			ResultUtil.report("MESSAGE", "Launch Wileyplus page is displayed", driver);
			Checkbox.check("Select checkbox", driver.findElement(By.xpath("//input[@type='checkbox' and @name='dontshow']")), driver);

		}

		if(Element.verify("Launch Button", driver, "XPATH", "//input[@name='bottom_wplaunchsubmit']"))
		{
			Button.click("Launch Button", driver.findElement(By.xpath("//input[@name='bottom_wplaunchsubmit']")), driver);
		}	
	}

	//Description:Blackboard Student Eula
	public void bbStudentEula()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage> bbStudentEula",driver);
		try{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container frame", "container", 6);
			Sync.waitForFrame(driver, "Frame index", 0, 5);

			//Eula Text
			Element.verify("Limited end user Eula text", driver, "XPATH", "//h3[text()='Limited Use End User License Agreement']");
			Element.verify("Limited end user Eula text", driver, "XPATH", "//span[contains(text(),'This is the John Wiley and Sons')]");
			String strlicenseagrement = driver.findElement(By.xpath("//span[contains(text(),'This is the John Wiley and Sons')]")).getText();
			System.out.println(strlicenseagrement);
			if(contentMap.get("LICENSE_AGREEMENTLIMITEDSTUDENT").contains(strlicenseagrement)){
				ResultUtil.report("PASS", " STUDENT LICENSE PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " STUDENT LICENSE PAGE TEXT not FOUND", driver);
			}
			Element.verify("Limited end user Eula text", driver, "XPATH", "//span[contains(text(),'Licensed Program indicates')]");
			String strlicenseagrement1 = driver.findElement(By.xpath("//span[contains(text(),'Licensed Program indicates')]")).getText();
			System.out.println(strlicenseagrement1);
			if(contentMap.get("LICENSE_STUDENTPROG").contains(strlicenseagrement1)){
				ResultUtil.report("PASS", "LICENSE PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " LICENSE PAGE TEXT not FOUND", driver);
			}
			Element.verify("Limited end user Eula text", driver, "XPATH", "//p/span[contains(text(),'License:')]");
			String strlicenseagrement2 = driver.findElement(By.xpath("//p/span[contains(text(),'License:')]")).getText();
			System.out.println(strlicenseagrement2);
			if(contentMap.get("LICENSE_STUDENTLIC").contains(strlicenseagrement2)){
				ResultUtil.report("PASS", "WILEYGRANTS PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " WILEYGRANTS PAGE TEXT not FOUND", driver);
			}
			Element.verify("Limited end user Eula text", driver, "XPATH", "//p/span[contains(text(),'The Licensed Program')]");
			String strlicenseagrement4 = driver.findElement(By.xpath("//p/span[contains(text(),'The Licensed Program')]")).getText();
			System.out.println(strlicenseagrement4);
			if(contentMap.get("LICENSE_STUDENTPER").contains(strlicenseagrement4)){
				ResultUtil.report("PASS", "WILEY PROGRAM PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " WILEY PROGRAM  PAGE TEXT not FOUND", driver);
			}
			Element.verify("Limited end user Eula text", driver, "XPATH", "//p/span[contains(text(),' may use the Licensed Program for')]");
			String strlicenseagrement5 = driver.findElement(By.xpath("//p/span[contains(text(),' may use the Licensed Program for')]")).getText();
			System.out.println(strlicenseagrement5);
			if(contentMap.get("LICENSE_STUDENTREG").contains(strlicenseagrement5)){
				ResultUtil.report("PASS", "REGISTER USER PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " REGISTER USER  PAGE TEXT not FOUND", driver);
			}
			Element.verify("Limited end user Eula text", driver, "XPATH", "//p/span[contains(text(),'Program on more than one computer system')]");
			String strlicenseagrement6 = driver.findElement(By.xpath("//p/span[contains(text(),'Program on more than one computer system')]")).getText();
			System.out.println(strlicenseagrement6);
			if(contentMap.get("LICENSE_STUDENTONE").contains(strlicenseagrement6)){
				ResultUtil.report("PASS", "REGISTER PROGRAM PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " REGISTER PROGRAM PAGE TEXT not FOUND", driver);
			}
			Element.verify("Limited end user Eula text", driver, "XPATH", "//p/span[contains(text(),'Term:')]");
			String strlicenseagrement7 = driver.findElement(By.xpath("//p/span[contains(text(),'Term:')]")).getText();
			System.out.println(strlicenseagrement7);
			if(contentMap.get("LICENSE_STUDENTTERM").contains(strlicenseagrement7)){
				ResultUtil.report("PASS", "TERM PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " TERM PAGE TEXT not FOUND", driver);
			}
			Element.verify("Added Eula text", driver, "XPATH", "//p/span[contains(.,'You agree that any profile information that you provide to Wiley (name and email) may be shared with Wiley')]");
			String strlimiteduseendusercontaintext = driver.findElement(By.xpath("//p/span[contains(.,'You agree that any profile information that you provide to Wiley (name and email) may be shared with Wiley')]")).getText();
			System.out.println(strlimiteduseendusercontaintext);
			if(contentMap.get("LICENSE_STUDENTRIGHTS").contains(strlimiteduseendusercontaintext)){
				ResultUtil.report("PASS", "RIGHTS PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " RIGHTS PAGE TEXT not FOUND", driver);
			}
			Element.verify("DISCLAIMER", driver, "XPATH", "//span[contains(text(),'DISCLAIMER')]");
			String strdisclaimer = driver.findElement(By.xpath("//span[contains(text(),'DISCLAIMER')]")).getText();
			System.out.println(strdisclaimer);
			if(contentMap.get("LICENSE_STUDENTDISCLAIMER").contains(strdisclaimer)){
				ResultUtil.report("PASS", "DISCLAIMER PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " DISCLAIMER  PAGE TEXT not FOUND", driver);
			}
			Element.verify("GENERAL", driver, "XPATH", "//p/span[contains(text(),'General')]");
			String strgeneralcontaintext = driver.findElement(By.xpath("//p/span[contains(text(),'General')]")).getText();
			System.out.println(strgeneralcontaintext);
			if(contentMap.get("LICENSE_STUDENTGeneral").contains(strgeneralcontaintext)){
				ResultUtil.report("PASS", "GENERAL PAGE TEXT FOUND", driver);
			}
			else{
				ResultUtil.report("FAIL", " GENERAL  PAGE TEXT not FOUND", driver);
			}
		}
		catch(Exception e)
		{

		}
	}

	//Description:Goto Publish content click
	public BBPublicContentPage clickPublishContent()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickPublishContent", driver);
		switchToContentFrame();
		try
		{
			Actions action = new Actions(driver);
			Sync.waitForObject(driver," Publisher content", "XPATH", "//a[starts-with(@href,'#actionitembutton')]");
			Browser.scrollToObject(" Publisher content", driver.findElement(By.xpath("//a[starts-with(@href,'#actionitembutton')]")), driver);
			Sync.waitForObject(driver," Publisher content", "XPATH", "//a[starts-with(@href,'#actionitembutton')]");
			action.moveToElement(driver.findElement(By.xpath("//a[starts-with(@href,'#actionitembutton')]"))).moveToElement(driver.findElement(By.xpath("//li[@class='actionMenuItem']//a[text()='WileyPLUS']"))).click().build().perform();			
		}
		catch(Exception e)
		{

		}

		try
		{
			Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//a[starts-with(@href,'#actionitembutton')]"));
			Mouse mouse = ((HasInputDevices) driver).getMouse();
			mouse.mouseMove(hoverItem.getCoordinates());
			Sync.waitForObject(driver," Publisher content", "XPATH", "//a[starts-with(@href,'#actionitembutton')]");
			Browser.scrollToObject(" Publisher content", driver.findElement(By.xpath("//a[starts-with(@href,'#actionitembutton')]")), driver);
			hoverItem = (Locatable) driver.findElement(By.xpath("//a[starts-with(@href,'#actionitembutton')]"));
			driver.findElement(By.xpath("//li[@class='actionMenuItem']//a[text()='WileyPLUS']")).click();
		}
		catch(Exception e){} 
		return PageFactory.initElements(driver, BBPublicContentPage.class);
	}

	//Instructor Eula acceptance
	public void instructorEulaAcceptance()
	{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>instructorEulaAcceptance", driver);
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container frame", "container", 6);
			Button.click("Accept Eula", driver.findElement(By.id("lti-accept-button")), driver);			
		}
		catch(Exception e)
		{

		}
	}

	//verify help link in the wp page
	public void verifyhelplink()
	{
		ResultUtil.report("INFO", "blackboardpage > verifyhelplink", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Frame index", 0, 6);
		Link.verify("verified", lnkhelp, "Help", driver);
	}

	//verify system announcement in WP page
	public void verifysystemannouncement()
	{
		ResultUtil.report("INFO", "blackboardpage > verify system announcement", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container Frame", "container", 6);
		if(Link.verify("verify system announcement ",lnksysannounce ,"System Announcements", driver))
		{
			System.out.println("passed");
		}
	}

	//click on gradecenter
	public void clickGradecenter()
	{
		ResultUtil.report("INFO", "blackboardpage > clickGradecenter", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "content", 6);
		Link.click("verify clickGradecenter ",gradecenter ,driver);
	}		    

	//click on assignments
	public void clickassignments()
	{
		ResultUtil.report("INFO", "blackboardpage > clickassignments", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "content", 6);
		Link.click("verify clickassignments ",assignments ,driver);
	}

	//Description:click on go
	public void clickGo() throws Exception
	{
		ResultUtil.report("INFO", "clickGo>studentView",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
		Button.click("Click on Go", lnkgo,driver);
	}

}

