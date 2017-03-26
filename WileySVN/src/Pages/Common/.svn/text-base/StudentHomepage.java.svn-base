package Pages.Common;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Assignments.StudentAssignmentPage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.GradeBookStudyObjectivePage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.SnapwizOrionDashboardPage;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class StudentHomepage extends Initializer {
	
	@FindBy(how = How.XPATH, using = "//li[@title='Assignment']")
	private WebElement tabAssignment;

	@FindBy(how = How.XPATH, using = "//li[@title='Gradebook']")
	private WebElement tabGradebook;

	@FindBy(how = How.XPATH, using = "//li[@title='Study Objectives']")
	private WebElement lnkStudyObjectives;

	@FindBy(how = How.XPATH, using = "//li[@title='ORION']")
	private WebElement elmntOriontab;

	@FindBy(how=How.XPATH,using="//li[.='Home']")
	private WebElement btnHometab;

	@FindBy(how = How.XPATH, using = "//li[@title= 'Read, Study & Practice']")
	private WebElement tabReadStudyPractice;	

	@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
	private WebElement elmntReturnBlackboard;

	@FindBy(how = How.XPATH, using = "//a[text()='Help']")
	private WebElement elmntHelpLink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'System Announcements')]")
	private WebElement elmntSystemAnnouncementsLink;
	
	@FindBy(how = How.ID, using = "acceptlicense")
	private WebElement licenseCheckbox;
	
	@FindBy(how = How.ID, using = "mwp-continue-button")
	private WebElement elmntContinueButton;

	public StudentHomepage(WebDriver driver){
		super(driver);
	}

	//Description: Verifying the title in Home screen and select the assignment tab
	public StudentAssignmentPage studentHomeScreen(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO","StudentHomePage>>>studentHomeScreen", driver);
		driver.switchTo().window(driver.getWindowHandle().toString());		
		Sync.waitForFrame(driver, "First IFrame", 0, 3);
				
		if(driver.findElement(By.xpath("//div[@id='course-title']")).isDisplayed()){
			ResultUtil.report("PASS", "Course Title Validated", driver);	
		}
		else{
			ResultUtil.report("FAIL", "Course Title Not Validated", driver);
		}
		Button.click("Assignment Tab", tabAssignment, driver);	
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
		}

	//Description: Go To GradeBook
	public StudentGradeBookPage goToGradeBook(){
		ResultUtil.report("INFO","StudentHomePage>>>goToGradeBook", driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0).getCurrentUrl();
		boolean btnGradeBook=Button.verify("Student Grade Book Tab", tabGradebook, "Gradebook", driver);
		
		if(btnGradeBook){
			Button.click("Student Grade Book Tab", tabGradebook, driver);
		}
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}

	//Description: Go To AssignmentResult Page
	public AssignmentResultsPage getAssignmentResult(Map<String,String> dataMap){
		ResultUtil.report("INFO","StudentHomePage>>>getAssignmentResult", driver);
		String assignmentName="po";
		WebElement lnkAssingmentlink = driver.findElement(By.xpath("//table[@class='plain-table']//tr//td/a[text()='"+assignmentName+"']"));
		boolean lnkAssignmentName=Button.verify("Assingment Link Name", lnkAssingmentlink, assignmentName, driver);
		
		if(lnkAssignmentName){
			Link.click("Any Assignment Link", lnkAssingmentlink, driver);
		}
		return PageFactory.initElements(driver, AssignmentResultsPage.class);
	}

	//Description: Click Study Objectives link 
	public GradeBookStudyObjectivePage clickStudyObjectivesPage() throws Exception {
		ResultUtil.report("INFO", "StudentHomePage>>>clickStudyObjectivesPage", driver);
		boolean blStudyObjectivesLink = Button.verify("Grade Book Study Objectives link", lnkStudyObjectives, "Study Objectives", driver);
		
		if(blStudyObjectivesLink){
			Button.click("Grade Book Study Objectives link", lnkStudyObjectives, driver);
		}
		return PageFactory.initElements(driver, GradeBookStudyObjectivePage.class);
	}
	
	//Description: Go To Assignment
	public StudentAssignmentPage goToAssignment(){
		ResultUtil.report("INFO","StudentHomePage>>>goToAssignment", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "IFrame",0, 2);
		Sync.waitForObject(driver, "Student Assignment tab", "XPATH", "//li[@title='Assignment']");
		Button.click("Student Assignment Tab", tabAssignment, driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}

	//Description: Goto Home Page
	public void goToHome(){
		ResultUtil.report("INFO","StudentHomePage>>>goToHome", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "IFrame",0, 2);
		boolean btnHome=Button.verify("Student Home Tab",btnHometab, driver);
		if(btnHome){
			btnHometab.click();
		}
	}
	
	//Description:Click Instructor - Student view- Assignment tab 
	public StudentAssignmentPage goToStudentViewAssignmentTab(){
		driver.switchTo().defaultContent().getCurrentUrl();
		Sync.waitForFrame(driver, "IFrame",0, 2);
		Button.click("Assignment Tab", tabAssignment, driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}

	//Description: Go to student view button
	public SnapwizOrionDashboardPage goToStudentViewOrionTab(){
		driver.switchTo().defaultContent().getCurrentUrl();
		Sync.waitForFrame(driver, "frame", 0, 6);
		Button.click("Orion  Tab", elmntOriontab, driver);
		return PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
	}
	
	//Description: Go to Orion tab
	public SnapwizOrionDashboardPage goToStudentOrionTab(){
		driver.switchTo().defaultContent().getCurrentUrl();
		Sync.waitForFrame(driver, "frame", 0, 6);
		Button.click("Orion  Tab", elmntOriontab, driver);
		return PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
	}
	
	//Description: Go to Read, Study and practice tab
	public void goToReadStudyPracticeTab(){
		driver.switchTo().defaultContent().getCurrentUrl();
		Sync.waitForFrame(driver, "frame", 0, 6);
		Button.click("Read Study Practice", tabReadStudyPractice, driver);		
	}
	
	//Description: Student Eula page
	public void studentEula(){
		
		if(Element.verify("License Agreement", driver, "XPATH", "//div[@id='mwp-main-layout']/h1[text()='License Agreement']")){
			driver.findElement(By.xpath("//div[@id='mwp-main-layout']/h1[text()='License Agreement']"));
			WebElement coursedetailssection = driver.findElement(By.id("mwp-class-informer"));
			coursedetailssection.findElement(By.xpath("//h2"));
			WebElement courseinfo = coursedetailssection.findElement(By.id("mwp-class-info-wrapper"));
			//Class and course title
			WebElement coursedetail = courseinfo.findElement(By.id("mwp-class-informer-detail"));
			coursedetail.findElement(By.xpath("//ul/li[@class='mwp-class-title']"));
			coursedetail.findElement(By.xpath("//ul/li[@class='mwp-course-title']"));
			//Book logo, title and author details
			WebElement coursebook = courseinfo.findElement(By.id("mwp-class-informer-book"));
			WebElement booklogocontainer =coursebook.findElement(By.id("mwp-book-container"));
			booklogocontainer.findElement(By.xpath("//img[@src[normalize-space(.)!= '']]"));
			coursebook.findElement(By.xpath("//ul/li[@class='mwp-book-title'][normalize-space(.)!='']"));
			coursebook.findElement(By.xpath("//ul/li[@class='mwp-book-author'][normalize-space(.)!='']"));
			driver.switchTo().frame("license-window");
			driver.findElement(By.xpath("//table/tbody/tr/td/p/span[@class[normalize-space(.)!='']]"));
			//Details on License
			List<WebElement> licensedetails = driver.findElements(By.xpath("//table/tbody/tr/td/ol/li")); 
			ResultUtil.report("MESSAGE", "List of license details are:"+licensedetails.size(), driver);			
			for(int l=1;l<=licensedetails.size();l++)
				{
				WebElement agreementheading = driver.findElement(By.xpath("//table/tbody/tr/td/ol/li["+l+"]/p[1]/span[@class='license']"));
				agreementheading.getText();
				Sync.waitForSeconds(5, driver);							
				}
			driver.switchTo().defaultContent();
			WebElement agreecheckbox = driver.findElement(By.xpath("//div[@id='mwp-license-bottom']//input[@id='acceptlicense']"));
			driver.findElement(By.xpath("//div[@id='mwp-license-bottom']/label[normalize-space(.)!='']"));
			agreecheckbox.click();
			ResultUtil.report("PASS", "License agreement page is displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "No License agreement page is displayed", driver);
		}
	}
	
	//Description: Student Orion Icon
	public void StudentOrionIcon(){
		ResultUtil.report("Report", "Orion icon displayed in Student home page", driver);
	}
	
	//Description: Validate wiley plus Homepage - Blackboard
	public void validateBBWPGradebookPage(){
		ResultUtil.report("INFO", "StudentHomepage>>>>>validateBBWPGradebookPage", driver);
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.id("container")));
		}
		catch(Exception e){}
		
		if(Element.verify("Home page", driver, "XPATH", "//li[text()='Home']")){
			Element.verify("Home tab", driver, "XPATH", "//li[text()='Home']");
			Element.verify("Read Tab", driver, "XPATH", "//li[text()='Read, Study & Practice']");
			Element.verify("Assignment tab", driver, "XPATH", "//li[text()='Assignment']");
			Element.verify("Gradebook tab", driver, "XPATH", "//li[text()='Gradebook']");
			Element.verify("Return to blackboard", elmntReturnBlackboard, driver);
			Element.verify("WP logo", driver, "XPATH", "//img[@alt='WileyPlus Logo']");
			Element.verify("System announcement", elmntSystemAnnouncementsLink, driver);
			Element.verify("Help link", elmntHelpLink, driver);
		}
	}
	
	//Description: Validate Orion Icon
	public void validateOrionIcon(){
		ResultUtil.report("INFO", "CourseHomePage>>validateOrionIcon", driver);
		driver.switchTo().defaultContent();
		try{
			Sync.waitForFrame(driver, "IFrame",0, 2);
		}
		catch(Exception e){
			
		}
		if(Element.verify("ORION Icon", driver, "XPATH", "//li[.//span[text()='ORION']]//img")){
			ResultUtil.report("PASS", "ORION Icon displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "ORION Icon not displayed", driver);
		}
	}
	
	//Accept student Eula
	public void acceptStudentEula()
	{
		ResultUtil.report("INFO", "CourseHomePage>>acceptStudentEula", driver);
		Checkbox.check("Select License checkbox", licenseCheckbox, driver);
		Sync.waitForObject(driver, "Continue button"," ID", "mwp-continue-button");
		Button.click("Click Continue", elmntContinueButton, driver);
	}
}
