package Pages.SnapwizIntegration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import Pages.Common.Initializer;
import Pages.WPBlackboardIntegration.InstructorAssignmentAccessPage;
import Toolbox.Browser;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.Window;

public class BBPublicContentPage extends Initializer
{

	Random rand = new Random();
	
	@FindBy(how = How.XPATH, using = "//li[@class='actionMenuItem']//a[text()='WileyPLUS']")
	private WebElement elmntPublishContentWileyPlus;
	
	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS Homepage']")
	private WebElement elmntWileyPlusHomepage;	
		
	@FindBy(how = How.XPATH, using = "//a[@id='lti-return-button']")
	private WebElement btnReturnBlackBoard;
	
	@FindBy(how = How.ID, using = "Go_To_Student_View")
	private WebElement elmntStudentViewbtn;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Help']")
	private WebElement elmntHelpLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='System Announcements ']")
	private WebElement elmntSystemAnnouncementsLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add WileyPLUS Tools Links')]")
	private WebElement elmntAddWPtoolLink;
	
	@FindBy(how = How.NAME, using = "Cancel")
	private WebElement elmntCancelbtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add WileyPLUS Readings and Assignments')]")
	private WebElement elmntAddWPReadAssignLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add WileyPLUS Readings')]")
	private WebElement elmntAddWPReadingLink;
	
	@FindBy(how = How.XPATH, using = "//input[starts-with(@id,'inventory_list_checked')]")
	private WebElement elmntReadingsCheckbox;	
	
	@FindBy(how = How.NAME, using = "Submit")
	private WebElement elmntSubmitbtn;	

	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS Assignments']")
	private WebElement elmntWPAssignmentLink;
	
	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS Read, Study & Practice']")
	private WebElement elmntWPReadStudyPracticeLink;
	
	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS Gradebook']")
	private WebElement elmntWPGradebookLink;
	
	@FindBy(how = How.ID, using = "Printer_version")
	private WebElement elmntPrinterVersionbtn;
	
	@FindBy(how = How.ID, using = "Export_Grades")
	private WebElement elmntExportGradebtn;
	
	@FindBy(how = How.ID, using = "Refresh_Gradebook")
	private WebElement elmntRefreshGradebookbtn;
	
	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS Prepare & Present']")
	private WebElement elmntWPPreparePresentLink;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Resources']")
	private WebElement elmntResourcesbtn;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Presentations']")
	private WebElement elmntPresentationbtn;
	
	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS Class Section Info']")
	private WebElement elmntWPClassSectionInfoLink;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Students']")
	private WebElement elmntStudentsbtn;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Class Section Properties']")
	private WebElement elmntClassSectionPropertiesbtn;
	
	@FindBy(how = How.XPATH, using = "//span[text()='WileyPLUS System Announcements']")
	private WebElement elmntWPSystemAnnouncementsLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Go To Student View']")
	private WebElement elmntStudentsViewbtn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'WileyPLUS Total Score')]")
	private WebElement elmntTotalScoreLink;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Expand Grade Center']")
	private WebElement elmntGradeCenterExpand;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add WileyPLUS Assignments')]")
	private WebElement selectAddwileyAssignments;
	
	public BBPublicContentPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Variables
	StringBuffer getDefaultOrder=new StringBuffer();
	StringBuffer getChangeOrder=new StringBuffer();
	
	//Arrays
	ArrayList<String> selectTitle = new ArrayList<String>();
	ArrayList<String> contentTitle = new ArrayList<String>();
	
	//Click wileyplus link in publish content
	public void selectWileyPlusPublicContent()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyPlusPublicContent", driver);
		switchToContentFrame();
		Link.click("Wileyplus", elmntPublishContentWileyPlus, driver);
	}
	
	//Wileyplus Readings and assignments
	public void selectReadingsAndAssignments()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectPublishContent", driver);
		switchToContentFrame();
		Link.click("Add Readings and Assignments", driver.findElement(By.xpath("//a[contains(text(),'Add WileyPLUS Readings and Assignments')]")), driver);		
	}
	
	//Click Add wileyplus assignments
	public void selectAddWileyplusAssignments()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectPublishContent", driver);
		switchToContentFrame();		
		Link.click("Add Readings and Assignments", driver.findElement(By.xpath("//a[contains(text(),'Add WileyPLUS Assignments')]")), driver);		
	}
	
	//Validate orion assignments not present
	public void validateOrionAssignment()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateOrionAssignment", driver);
		switchToContentFrame();		
		if(Element.notVerify("Orion assignments", driver, "XPATH", "//table[@id='inventory_list_datatable']//tr[./td[contains(text(),'ORION')]]"))
		{
			ResultUtil.report("FAIL", "ORION assignment is displayed", driver);	
		}
		else
		{
			ResultUtil.report("PASS", "ORION assignment is not displayed", driver);
		}
		
	}
	
	//Switch to Content frame
	public void switchToContentFrame()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Contentframe Frame", "contentFrame", 6);		
	}
	
	//Select "WileyPlus Homepage"
	public void selectWileyplusHomePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusHomePage", driver);
		switchToContentFrame();	
		Link.click("WP homepage", elmntWileyPlusHomepage, driver);		
	}
	
	//Validate edugen - qa home page
	public void validateWileyPlusHomePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateWileyPlusHomePage", driver);		
		switchtoContainerFrame();
		Element.verify("Return to blackboard", btnReturnBlackBoard, driver);
		Element.verify("Student view", elmntStudentViewbtn, driver);
		Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
		Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
		Element.verify("Help Link", elmntHelpLink, driver);
	}
	
	//Return to Blackboard
	public void returnToBlackboard() throws Exception
	{
		ResultUtil.report("INFO", "BBPublicContentPage>returnToBlackboard",driver);
		switchtoContainerFrame();
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container frame", "container", 6);			
			Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);			
		}
		catch(Exception e)
		{
			
		}
		Element.verify("Return to Blackboard", btnReturnBlackBoard, driver);
		Button.click("Return to BlackBoard", btnReturnBlackBoard,driver);
	}
	
	//Return to Blackboard - Present validation
	public void returnToBlackboardPresent()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>returnToBlackboardPresent",driver);
		switchtoContainerFrame();
		//Validate Return to blackbboard and it is  displayed
		if(Element.verify("Return to blackboard", driver, "XPATH","//ins[text()='Return to Blackboard']")){
			ResultUtil.report("PASS", "Return to blackboard is displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Return to blackboard is not displayed", driver);
		}
	}
	
	//Return to Blackboard - Absent validation
	public void returnToBlackboardAbsent()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>returnToBlackboardAbsent",driver);
		switchtoContainerFrame();
		//Validate Return to blackbboard and it is not displayed
		if(Element.verify("Return to blackboard", driver, "XPATH","//ins[text()='Return to Blackboard']")){
			ResultUtil.report("FAIL", "Return to blackboard is displayed", driver);
		}
		else
		{
			ResultUtil.report("PASS", "Return to blackboard is not displayed", driver);
		}
	}

	//Validate Wileyplus material page
	public void validateWileyPlusMaterial()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>returnToBlackboard",driver);
		switchToContentFrame();
		Element.verify("Add wileyplus tool links", driver, "XPATH", "//a[contains(text(),'Add WileyPLUS Tools Links')]");
		Element.verify("Add WileyPLUS Readings and Assignments", driver, "XPATH", "//a[contains(text(),'Add WileyPLUS Readings and Assignments')]");
		Element.verify("WileyPLUS Homepage", driver, "XPATH", "//a[contains(text(),'WileyPLUS Homepage')]");
		Element.verify("WileyPLUS Total Score", driver, "XPATH", "//a[contains(text(),'WileyPLUS Total Score')]");
	}
	
	//Select Add wileyplus tool links
	public void selectAddWPTool()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectAddWPTool",driver);
		switchToContentFrame();
		Link.click("Add WP tool link", elmntAddWPtoolLink, driver);
	}
	
	//Validate add wileyplus tools links page
	public void validateAddWileyplusToolsPage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateAddWileyplusToolsPage",driver);
		switchToContentFrame();
		Element.verify("Add WileyPLUS Tools Links", driver, "XPATH", "//span[contains(text(),' Add WileyPLUS Tools Links')]");		
		List<WebElement> wpToolsTable = driver.findElements(By.xpath("//table[@id='inventory_list_datatable']//tr"));
		for(int i=1;i<=wpToolsTable.size();i++)
		{
			WebElement tablerows = driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//tr["+i+"]"));
			ResultUtil.report("Status", tablerows.getText(), driver);
		}
	}
	
	//Cancel settings
	public void cancelSettings()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>cancelSettings",driver);
		switchToContentFrame();
		Button.click("Cancel", elmntCancelbtn, driver);
		try
		{
			Alert alert  = driver.switchTo().alert();
			alert.accept();		
		}
		catch(Exception e)
		{
			
		}
	}
	
	//Select Add assingments and readings
	public void selectAddAssignmentsReadings()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectAddAssignmentsReadings",driver);
		switchToContentFrame();
		Link.click("Add assignments and Reading", elmntAddWPReadAssignLink, driver);
	}
	
	//Validate Add Assignments and reading page
	public void validateAddAssignmentReadingPage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateAddAssignmentReadingPage",driver);
		switchToContentFrame();
		Element.verify("Add WileyPLUS Readings ", driver, "XPATH", "//a[contains(text(),'Add WileyPLUS Readings')]");
		Element.verify("Add WileyPLUS Assignments ", driver, "XPATH", "//a[contains(text(),'Add WileyPLUS Assignments')]");
	}
	
	//Select "Add WileyPLUS Readings " link
	public void selectAddWPReadingLink()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectAddWPReadingLink",driver);
		switchToContentFrame();
		Link.click("Add wileyplus reading", elmntAddWPReadingLink, driver);
	}
	
	//Validate Add wileyplus readings table
	public void validateWPReadingsPage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateWPReadingsPage",driver);
		switchToContentFrame();		
		List<WebElement> wpToolsTable = driver.findElements(By.xpath("//table[@id='inventory_list_datatable']//tr"));
		for(int i=1;i<=wpToolsTable.size();i++)
		{
			WebElement title = driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//tr[starts-with(@id,'inventory_list')]["+i+"]//a"));
			ResultUtil.report("Status", title.getText(), driver);
			Link.click("Select title", title, driver);
			validateTitlePage();
			if(i==3 || i==wpToolsTable.size())
			{
				break;
			}			
		}		
	}
	
	//Validate the title page
	public void validateTitlePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateTitlePage",driver);
		
		//Switch to another window
		String getWindow = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("Wileyplus window", driver, getWindow);
		
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container frame", "container", 6);			
			Sync.waitForFrame(driver, "Headframe frame", "headframe", 6);			

		}
		catch(Exception e)
		{
			
		}
		Element.verify("Help link", elmntHelpLink, driver);
		Element.verify("System announcement link", elmntSystemAnnouncementsLink, driver);
		Browser.closeDriver(driver);
		switchToContentFrame();
	}
	
	//Select checkbox for the given title
	public void selectTitleCheckbox()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectTitleCheckbox",driver);
		switchToContentFrame();		
		int selectCheckbox;
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//tr//input[starts-with(@id,'inventory_list_checked')]"));
		for(int i=1;i<=checkBoxList.size();i++)
		{
			selectCheckbox = rand.nextInt(checkBoxList.size());
			 if((selectCheckbox==0))
				 selectCheckbox =selectCheckbox+1;
			WebElement checkbox = driver.findElement(By.xpath("//tr["+selectCheckbox+"]//input[starts-with(@id,'inventory_list_checked')]"));
			checkbox.click();
			Sync.waitForSeconds(4, driver);
			WebElement checkboxTitle = driver.findElement(By.xpath("//tr[.//input[starts-with(@id,'inventory_list_checked')]]["+i+"]//th"));
			String strTitleName = checkboxTitle.getText();
			selectTitle.add(strTitleName);
			//selectedTitle.append(strTitleName);
			ResultUtil.report("REPORT", "title is added", driver);
			if(selectCheckbox==checkBoxList.size())
				break;
		}		
	}
	
	//Save settings
	public void submitSettings()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>submitSettings",driver);
		switchToContentFrame();
		Button.click("Submit", elmntSubmitbtn, driver);
		try
		{
			Alert alert  = driver.switchTo().alert();
			alert.accept();		
		}
		catch(Exception e)
		{
			
		}
	}
	
	//Validate content area title with readings title page
	public void validateTitles()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateTitles",driver);
		switchToContentFrame();
		
		for(int i=0;i<=selectTitle.size();i++)
		{
			String strTitleValue = selectTitle.get(i);
			String strTitleXpath= "//li[starts-with(@id,'contentListItem')]//a[.//span]";
			Element.verify("Title Selected", driver, "XPATH", strTitleXpath+"/span[text()='"+strTitleValue+"']");
			if(i==selectTitle.size())
			{
				Link.click("Select Chapter", driver.findElement(By.xpath(strTitleXpath+"/span[text()='"+strTitleValue+"']")), driver);
			}
		}			
	}
	
	//Select Wileyplus assignment link in "Add Wileyplus tool links" page
	public void goToWPAssignment()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>goToWPAssignmentPage",driver);
		switchToContentFrame();
		Link.click("Wileyplus assingment", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS Assignments')]")), driver);
	}
	
	//Handle Windows
	public void handleWindows()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>handleWindows",driver);
		//Switch to another window
		String getWindow = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow(driver.getTitle(), driver, getWindow);
	}
	
	//Select Wileyplus assignments link in "Add Wileyplus tool links" page
	public void selectWPAssignmentLink()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPAssignmentLink",driver);
		switchToContentFrame();
		String strAssignmentXpath= "//table[@id='inventory_list_datatable']//tr[.//a[contains(text(),'WileyPLUS Assignments')]]//input";
		if(Checkbox.isUnchecked("Wileyplus assignments", driver.findElement(By.xpath(strAssignmentXpath)), driver))
		{
			Checkbox.check("Wileyplus assignment", driver.findElement(By.xpath(strAssignmentXpath)), driver);
		}
	}
	
	//Navigate to wiley plus assignment page -  Content page
	public void selectWileyplusAssignmentLink()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusAssignmentLink", driver);
		switchToContentFrame();
		Link.click("WileyPlus Assignment", elmntWPAssignmentLink, driver);
	}
	
	//Select WileyPlus read, study and practice link in "Add wiley plus tool" page
	public void goToWPReadStudyPractice()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>goToWPReadStudyPractice",driver);
		switchToContentFrame();
		Link.click("Wileyplus Read-Study-Practice", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS Read, Study & Practice')]")), driver);
	}
	
	//Select Wileyplus Read-Study-Practice link in "Add Wileyplus tool links" page
	public void selectWPReadStudyPractice()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPReadStudyPractice",driver);
		switchToContentFrame();
		String strReadStudyXpath="//table[@id='inventory_list_datatable']//tr[.//a[contains(text(),'WileyPLUS Read, Study & Practice')]]//input";
		if(Checkbox.isUnchecked("Wileyplus ReadStudyPractice", driver.findElement(By.xpath(strReadStudyXpath)), driver))
		{
			Checkbox.check("Wileyplus ReadStudyPractice", driver.findElement(By.xpath(strReadStudyXpath)), driver);
		}
	}
			
	//Navigate to WileyPLUS Read, Study & Practice -  Content page
	public void selectWileyplusReadStudyPracticeLink()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusReadStudyPracticeLink", driver);
		switchToContentFrame();
		Link.click("WileyPlus Read Study Practice", elmntWPReadStudyPracticeLink, driver);
	}
	
	//Select WileyPlusGradebook link in "Add wiley plus tool" page
	public void goToWPGradebook()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>goToWPGradebook",driver);
		switchToContentFrame();
		Link.click("Wileyplus Read-Study-Practice", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS Gradebook')]")), driver);
	}
		
	//Select Wileyplus Gradebook link in "Add Wileyplus tool links" page
	public void selectWPGradebook()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPGradebook",driver);
		switchToContentFrame();
		String strGradeBookXpath="//table[@id='inventory_list_datatable']//tr[.//a[contains(text(),'WileyPLUS Gradebook')]]//input";
		if(Checkbox.isUnchecked("Wileyplus Gradebook", driver.findElement(By.xpath(strGradeBookXpath)), driver))
		{
			Checkbox.check("Wileyplus Gradebook", driver.findElement(By.xpath(strGradeBookXpath)), driver);
		}
	}
	
	//Navigate to WileyPLUS Gradebook -  Content page
	public void selectWileyplusGradebookLink()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusGradebookLink", driver);
		switchToContentFrame();
		Link.click("WileyPlus Gradebook", elmntWPGradebookLink, driver);
	}
	
	//Validate Gradebook in wileyplus page
	public void validateGradebookWileyplus()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateGradebookWileyplus", driver);
		switchtoContainerFrame();
		Button.verify("Printer version", elmntPrinterVersionbtn, driver);
		Button.verify("Export grades", elmntExportGradebtn, driver);
		Button.verify("Refresh gradebook", elmntRefreshGradebookbtn, driver);		
	}
	
	
	//Click WileyPlusPrepare & Present link in "WileyPLUS Prepare & Present" page
	public void WPPreparePresent()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>WPPreparePresent",driver);
		switchToContentFrame();
		Link.click("WileyPLUS Prepare & Present", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS Prepare & Present')]")), driver);
	}
	
	//Select Wileyplus Prepare & Present link in "WileyPLUS Prepare & Present" checkbox
	public void selectWPPreparePresent()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPPreparePresent",driver);
		switchToContentFrame();
		String strPrepareXpath= "//table[@id='inventory_list_datatable']//tr[.//a[contains(text(),'WileyPLUS Prepare & Present')]]//input";
		if(Checkbox.isUnchecked("Wileyplus Prepare & Present", driver.findElement(By.xpath(strPrepareXpath)), driver))
		{
			Checkbox.check("Wileyplus Prepare & Present", driver.findElement(By.xpath(strPrepareXpath)), driver);
		}
	}
	
	//Navigate to WileyPLUS Prepare & Present -  Content page
	public void selectWileyplusPreparePresent()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusPreparePresent", driver);
		switchToContentFrame();
		Link.click("WileyPLUS Prepare & Present", elmntWPPreparePresentLink, driver);
	}
	
	
	//Validate WileyPLUS Prepare & Present - qa home page
	public void validateWPPreparePresentHomePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateWPPreparePresentHomePage", driver);		
		switchtoContainerFrame();
		if(Element.verify("WP Prepare & Present", driver, "XPATH", "//li[text()='Prepare & Present']"))
		{	
			Element.verify("Return to blackboard", btnReturnBlackBoard, driver);
			Element.verify("Resources", elmntResourcesbtn, driver);
			Element.verify("Presentation", elmntPresentationbtn, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help Link", elmntHelpLink, driver);
		}
	}
	
	//Click WileyPlusClass Selection link in "WileyPLUS Class Section Info" page
	public void WPClassSectionInfo()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>WPClassSectionInfo",driver);
		switchToContentFrame();
		Link.click("WileyPLUS Class Section Info", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS Class Section Info')]")), driver);
		Sync.waitForFrame(driver, "container Frame", "container", 6);
	}
	
	//Select Wileyplus Class Selection link in "WileyPLUS Class Section Info" checkbox
	public void selectWPClassSectionInfo()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPClassSectionInfo",driver);
		switchToContentFrame();
		String strClassSectionXpath= "//table[@id='inventory_list_datatable']//tr[.//a[contains(text(),'WileyPLUS Class Section Info')]]//input";
		if(Checkbox.isUnchecked("WileyPLUS Class Section Info", driver.findElement(By.xpath(strClassSectionXpath)), driver))
		{
			Checkbox.check("WileyPLUS Class Section Info", driver.findElement(By.xpath(strClassSectionXpath)), driver);
		}
	}
	
	
	//Navigate to WileyPLUS Class Section Info -  Content page
	public void selectWileyplusClassSectionInfo()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusClassSectionInfo", driver);
		switchToContentFrame();
		Link.click("WileyPLUS Class Section Info", elmntWPClassSectionInfoLink, driver);
		Sync.waitForFrame(driver, "container Frame", "container", 6);
	}
	
	//Validate WileyPLUS Class Section Info - qa home page
	public void validateWPClassSectionInfoHomePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateWPClassSectionInfoHomePage", driver);	
		switchtoContainerFrame();
		if(Element.verify("WP Prepare & Present", driver, "XPATH", "//li[text()='Class Section Info']"))
		{	
			Element.verify("Return to blackboard", btnReturnBlackBoard, driver);
			Element.verify("Students", elmntStudentsbtn, driver);
			Element.verify("Class Section Properties", elmntClassSectionPropertiesbtn, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help Link", elmntHelpLink, driver);
		}
	}
	
	//Click WileyPlus Course Administration link in "WileyPLUS CourseAdministration" page
	public void WPCourseAdministration()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>WPCourseAdministration",driver);
		switchToContentFrame();
		Link.click("WileyPLUS Class Section Info", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS Course Administration')]")), driver);
	}
	
	
	//Click WileyPlus Course Administration link in "WileyPLUS CourseAdministration" page
	public void WPSystemannouncements()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>WPSystemannouncements",driver);
		switchToContentFrame();
		Link.click("WileyPLUS Class Section Info", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'WileyPLUS System Announcements')]")), driver);
	}
	
	//Select Wileyplus System Announcements link in "WileyPLUS Class Section Info" checkbox
	public void selectWPSystemAnnouncements()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPSystemAnnouncements",driver);
		switchToContentFrame();
		String strSystemAnnoucements= "//table[@id='inventory_list_datatable']//tr[.//a[contains(text(),'WileyPLUS System Announcements')]]//input";
		if(Checkbox.isUnchecked("Wileyplus System Announcements", driver.findElement(By.xpath(strSystemAnnoucements)), driver))
		{
			Checkbox.check("Wileyplus System Announcements", driver.findElement(By.xpath(strSystemAnnoucements)), driver);
		}
	}
	
	//Navigate to WileyPLUS System Announcements -  Content page
	public void selectWileyplusSystemAnnouncements()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWileyplusSystemAnnouncements", driver);
		switchToContentFrame();
		Link.click("WileyPLUS Class Section Info", elmntWPSystemAnnouncementsLink, driver);
	}
	
	//Validate WileyPLUS System announcements - qa home page
	public void validateWPSystemannouncementsHomePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateWPSystemannouncementsHomePage", driver);
		switchtoContainerFrame();
		if(Element.verify("WP Prepare & Present", driver, "XPATH", "//span[text()='System Announcements']"))
		{	
			Element.verify("Return to blackboard", btnReturnBlackBoard, driver);
			Element.verify("Students view", elmntStudentsViewbtn, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help Link", elmntHelpLink, driver);
		}
	}
	
	//Validate Course Administration page
	public void validateCourseAdministrationpage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>ValidateCourseAdministrationpage", driver);
		Element.verify("WP Prepare & Present", driver, "XPATH", "//p[contains (text(),'This tool is only accessible to your')]");
	}
	
	//Validate addition of content link
	public void validateAdditionContentLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateAdditionContentLink", driver);
		String strAddedContentLink = dataMap.get("AddContentName");
		String strAddContentXpath= "//table[@id='inventory_list_datatable']//a[contains(text(),'"+strAddedContentLink+"')]";
		Element.verify("Added Content Link", driver, "XPATH", strAddContentXpath);
		if(Element.verify("Added Content Link", driver, "XPATH", strAddContentXpath))
		{
			Link.verify("Added ", driver.findElement(By.xpath(strAddContentXpath)), strAddedContentLink, driver);		
			Sync.waitForFrame(driver, "container Frame", "container", 6);
		}
	}
	
	//Edit addition of content link
	public void validateeditAdditionContentLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateeditAdditionContentLink", driver);
		String editAddedContentLink = dataMap.get("EditContentName");
		String strContentLink= "//table[@id='inventory_list_datatable']//a[contains(text(),'"+editAddedContentLink+"')]";
		Element.verify("Added Content Link", driver, "XPATH", strContentLink);
		if(Element.verify("Added Content Link", driver, "XPATH", strContentLink))
		{
			Link.verify("Edit ", driver.findElement(By.xpath(strContentLink)), editAddedContentLink, driver);		
		}
	}	
	
	//Get the default displayed order value
	public void getToolsLinkDefaultOrder()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>getToolsLinkDefaultOrder", driver);
		switchToContentFrame();
		List<WebElement> toolsLinkDefaultOrder = driver.findElements(By.xpath("//table[@id='inventory_list_datatable']//tbody//th/a"));
		System.out.println(toolsLinkDefaultOrder.size());
		for(WebElement link:toolsLinkDefaultOrder)
		{
			String strDefaultLinks=link.getText();
			getDefaultOrder.append(strDefaultLinks);
			ResultUtil.report("REPORT", "Default order is added in buffer", driver);
		}
	}
	
	//Get the Changed displayed order value
	public void getToolsLinkChangedOrder()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>getToolsLinkChangedOrder", driver);
		switchToContentFrame();
		List<WebElement> toolsLinkChangedOrder = driver.findElements(By.xpath("//table[@id='inventory_list_datatable']//tbody//th/a"));
		System.out.println(toolsLinkChangedOrder.size());
		for(WebElement link:toolsLinkChangedOrder)
		{
			String strChangeLinks=link.getText();
			getChangeOrder.append(strChangeLinks);
			ResultUtil.report("REPORT", "Default order is added in buffer", driver);
		}
	}

	//verify the Wiley plus tools links order names
	public void validateBBWileyToolsLinksOrder()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateBBWileyLinksOrder", driver);
		switchToContentFrame();
		if(getDefaultOrder.toString().equals(getChangeOrder.toString()))
		{
			ResultUtil.report("FAIL", "The Order has not changed after the order has changed in super admin page", driver);
		}
		else
		{
			ResultUtil.report("PASS", "The Order has changed after the order has changed in super admin page", driver);
		}
	}
	
	//Validate the deleted link
	public void validateDeleteAddContentLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateDeleteAddContentLink", driver);
		switchToContentFrame();
		
		String strAddedContentLink = dataMap.get("AddContentName");
		String editAddedContentLink = dataMap.get("EditContentName");
		if(Element.notVerify("Added Content Link", driver, "XPATH", "//table[@id='inventory_list_datatable']//a[contains(text(),'"+strAddedContentLink+"')]"))
		{
			//Link.verify("Added ", driver.findElement(By.xpath("//table[@id='inventory_list_datatable']//a[contains(text(),'"+strAddedContentLink+"')]")), strAddedContentLink, driver);		
			ResultUtil.report("PASS", "Deleted Add content link is not displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Deleted Add content link is  displayed", driver);
		}
		
		if(Element.notVerify("Edited Content Link", driver, "XPATH", "//table[@id='inventory_list_datatable']//a[contains(text(),'"+editAddedContentLink+"')]"))
		{						
			ResultUtil.report("PASS", "Deleted Edit content link is not displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Deleted Edit content link is  displayed", driver);
		}
	}
	
	//click "WileyPlus Total score" link
	public void selectWPTotalScore()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPTotalScore", driver);
		switchToContentFrame();
		Link.click("Total score", elmntTotalScoreLink, driver);
		//Validate the gradebook alert
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Assert.assertEquals(alert.getText(), "A link to at least one WileyPLUS Assignment already exists in your Blackboard course.  Adding a link to WileyPLUS Total Score will cause scores to be duplicated in the Blackboard Grade Center.  Do you still want to continue?");
			driver.switchTo().alert().accept();
			switchToContentFrame();
			Link.click("Total score", elmntTotalScoreLink, driver);
		}
		catch(Exception e)
		{
			
		}
	}
	
	//Validate the total score page
	public void validateWPTotalScorePage()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateWPTotalScorePage", driver);
		switchtoContainerFrame();
		if(Element.verify("WP Prepare & Present", driver, "XPATH", "//li[text()='Prepare & Present']"))
		{	
			Button.verify("Printer version", elmntPrinterVersionbtn, driver);
			Button.verify("Export grades", elmntExportGradebtn, driver);
			Button.verify("Refresh gradebook", elmntRefreshGradebookbtn, driver);	
			Element.verify("Return to blackboard", btnReturnBlackBoard, driver);
			Element.verify("Students view", elmntStudentsViewbtn, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help Link", elmntHelpLink, driver);
		}
	}

	//Click "Grade center" tab in side bar
	public void goToGradeCenter()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>goToGradeCenter", driver);
		if(Element.verify("Grade center", driver, "XPATH", "//a[@title='Expand Grade Center']"))
		{
			Link.click("Grade Center", elmntGradeCenterExpand, driver);
		}
	}
	
	//Click FullGradeCenter --"Grade center" tab in side bar
	public void goToFullGradeCenter()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>goToFullGradeCenter", driver);
		if(Element.verify("Grade center", driver, "XPATH", "//a[@title='Full Grade Center']"))
		{
			Link.click("Grade Center", driver.findElement(By.xpath("//a[@title='Full Grade Center']")), driver);
		}
	}		
	
	//Validate the Wileyplus total score column in full grade center 
	public void validateTotalScoreFullGradeCenter()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateTotalScoreFullGradeCenter", driver);
		Element.verify("Total score column", driver, "XPATH", "//div[text()='WileyPLUS Total Score']");
	}
	
	//Select add wileyplus assignment link
	public void selectWPAssignmentLinkReadAssignment()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectWPAssignmentReadAssignment", driver);
		Link.click("Add Wileyplus assignment", selectAddwileyAssignments, driver);
	}
	
	//Select the given assignment link
	public void selectAssignmentLink(Map<String,String> dataMap, String strAssignment)
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectAssignmentLink", driver);
		switchToContentFrame();
		String strAssignmentName = dataMap.get(strAssignment);			
		Link.click("Assignment name link", driver.findElement(By.xpath("//a[text()='"+strAssignmentName+"']")), driver);
	}
	
	//Return to instructor assignment access page
	public InstructorAssignmentAccessPage instructorAssignmenAccess()
	{
		ResultUtil.report("INFO", "BBPublicContentPage>instructorAssignmenAccess", driver);
		return PageFactory.initElements(driver, InstructorAssignmentAccessPage.class);
	}
	
	//Select the assignment
	public void selectAssignment(Map<String,String> dataMap, String strAssignment){
		ResultUtil.report("INFO", "BBPublicContentPage>selectAssignment", driver);
		switchToContentFrame();
		String strAssignmentName = dataMap.get(strAssignment);
		String strAssignmentCheckXpath= "//table[.//a[text()='"+strAssignmentName+"']]//input[starts-with(@id,'inventory_list_checked')]";
		if(Checkbox.isUnchecked("Assignment check", driver.findElement(By.xpath(strAssignmentCheckXpath)), driver))
		{
		Checkbox.check("Assignment checkbox", driver.findElement(By.xpath(strAssignmentCheckXpath)), driver);
		}
	}
	
	//Validate the assignment link in BB content area
	public void validateAssignmentBBArea(Map<String,String> dataMap, String strAssignment)
	{
		ResultUtil.report("INFO", "BBPublicContentPage>validateAssignmentBBArea", driver);
		switchToContentFrame();
		String strAssignmentName = dataMap.get(strAssignment);
		String strAssignmentLinkXpath="//a/span[text()='"+strAssignmentName+"']";
		Sync.waitForObject(driver, "Assignment Link", "XPATH", strAssignmentLinkXpath);
		Link.verify("Assignment link", driver.findElement(By.xpath(strAssignmentLinkXpath)), driver);
	}
	
	//Click Assignment link in Bb content area
	public void selectAssignmentBBLink(Map<String,String> dataMap, String strAssignment)
	{
		ResultUtil.report("INFO", "BBPublicContentPage>selectAssignmentBBLink", driver);
		switchToContentFrame();
		String strAssignmentName = dataMap.get(strAssignment);
		String strAssignmentLinkXpath="//a/span[text()='"+strAssignmentName+"']";
		Sync.waitForObject(driver, "Assignment Link", "XPATH", strAssignmentLinkXpath);
		Link.click("Assignment link", driver.findElement(By.xpath(strAssignmentLinkXpath)), driver);
	}
	
	public void switchtoContainerFrame()
	{
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container frame", "container", 6);			
		}
		catch(Exception e)
		{
			
		}
	}
}



