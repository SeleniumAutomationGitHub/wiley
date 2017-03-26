package Pages.Common;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Pages.Assignments.AssignmentPage;
import Pages.CourseAdmin.CourseAdminPage;
import Pages.SnapwizIntegration.ReadStudyPracticePage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Pages.SnapwizIntegration.WileyPlusOrionPage;
import Toolbox.*;

public class CourseHomePage extends Initializer{
		
	public CourseHomePage(WebDriver driver){
	super(driver);	
	}
	
	@FindBy(how = How.XPATH, using = "//li[@title= 'Assignment']")
	private WebElement tabAssignment; 
	
	@FindBy(how = How.XPATH, using = "//li[@title='Course Admin']")
	private WebElement tabCourseAdmin;
	
	@FindBy(how = How.XPATH, using = "//li[contains(@title,'Gradebook')]")
	private WebElement tabGradeBook;
	
	@FindBy(how = How.XPATH, using = "//li[@title= 'ORION']")
	private WebElement tabOrion;	
	
	@FindBy(how = How.XPATH, using = "//li[@title= 'Read, Study & Practice']")
	private WebElement tabReadStudyPractice;	
	
	@FindBy(how = How.ID, using = "Go_To_Student_View")
	private WebElement elmntGotoStudentViewbtn;
	
	@FindBy(how = How.TAG_NAME, using ="iframe ")
	private WebElement iFrame;
	
	@FindBy(how = How.XPATH, using= "//div[@class='button header-style']//a")
	private WebElement switchToInstructorStudentButton;
	
	@FindBy(how = How.ID, using = "Instructor_View")
	private WebElement elmntGotoInstructorViewbtn;
	
	//Description: Verifying the Course Title displayed on the Home Screen
	public void courseHomeScreen(){
		ResultUtil.report("INFO", "CourseHomePage>>>courseHomeScreen", driver);
		if(driver.findElement(By.xpath("//div[@id='course-title']")).isDisplayed()){
			ResultUtil.report("PASS", "Pass-Validated Course Title", driver);
		}
		else{
			ResultUtil.report("FAIL", "Fail-Validated Course Title", driver);
		}
	}
	
	//Description: Clicking on Assignment Tab button from the Home Screen
	public AssignmentPage goToAssigmentPage() throws Exception{
		ResultUtil.report("INFO", "CourseHomePage>>>goToAssigmentPage", driver);
		driver.switchTo().defaultContent();
		Button.click("Assignment Tab", tabAssignment, driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Description: Go to Course Admin Tab
	public CourseAdminPage goToCourseAdminTab() throws InterruptedException{
		ResultUtil.report("INFO", "CourseHomePage>>>goToCourseAdminTab", driver);
		driver.switchTo().defaultContent();
		Button.click("Course Admin", tabCourseAdmin, driver);
		return PageFactory.initElements(driver, CourseAdminPage.class);
	}
	
	//Description: Go to GradeBook Page
	public GradeBookPage goToGradebookPage() throws Exception{
		ResultUtil.report("INFO", "CourseHomePage>>>goToGradebookPage", driver);
		driver.switchTo().defaultContent();
		Button.verify("Click GradeBook Tab", tabGradeBook, "Gradebook", driver);
		Button.click("Click GradeBook Tab", tabGradeBook, driver);
		return PageFactory.initElements(driver, GradeBookPage.class);
	}
	
	//Description: Go to Orion Tab
	public WileyPlusOrionPage goToOrionTab() throws InterruptedException{
		ResultUtil.report("INFO", "CourseHomePage>>>goToOrionTab", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Switching frame", 0, 5);
		Button.click("Orion tab", tabOrion, driver);
		return PageFactory.initElements(driver, WileyPlusOrionPage.class);
	}
	
	//Description: Go To Read Study Practice Tab
	public ReadStudyPracticePage goToReadStudyPracticeTab() throws InterruptedException{
		ResultUtil.report("INFO", "CourseHomePage>>>goToReadStudyPracticeTab", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Read Practice frame", 0, 6);
		Button.click("Read practice tab", tabReadStudyPractice, driver);
		return PageFactory.initElements(driver, ReadStudyPracticePage.class);
	}
	
	//Description: Navigate to student view page by clicking go to student view button
	public StudentViewChooseClassSection goToStudentView() {
		ResultUtil.report("INFO", "CourseHomePage>>>goToStudentView", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);			
		Button.click("Student view button", elmntGotoStudentViewbtn, driver);
		return PageFactory.initElements(driver, StudentViewChooseClassSection.class);
	}
	
	//Description: Validate the Orion Icon
	public LogoutSessionPage InstructorOrionIcon(){
		ResultUtil.report("Report", "Orion icon displayed in instructor home page", driver);
		return PageFactory.initElements(driver, LogoutSessionPage.class);
	}
	
	//Description: Instructor Eula
	public void InstructorEula(){
		ResultUtil.report("INFO", "CourseHomePage>>InstructorEula", driver);		
		
		if(Element.verify("License Agreement", driver, "XPATH", "//div[@id='mwp-main-layout']/h1[text()='License Agreement']")){
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			//License agreement
			WebElement licenceagreement = driver.findElement(By.xpath("//div[@id='mwp-main-layout']/h1[text()='License Agreement']"));
			WebElement coursedetailssection = driver.findElement(By.id("mwp-class-informer"));
			WebElement coursedetailheading = coursedetailssection.findElement(By.xpath("//h2"));
			WebElement courseinfo = coursedetailssection.findElement(By.id("mwp-class-info-wrapper"));
			//Class and course title
			WebElement coursedetail = courseinfo.findElement(By.id("mwp-class-informer-detail"));
			WebElement classtitle = coursedetail.findElement(By.xpath("//ul/li[@class='mwp-class-title']"));
			WebElement coursetitle = coursedetail.findElement(By.xpath("//ul/li[@class='mwp-course-title']"));
			System.out.println(coursetitle.getText());			
			//Book logo, title and author details
			WebElement coursebook = courseinfo.findElement(By.id("mwp-class-informer-book"));
			WebElement booklogocontainer =coursebook.findElement(By.id("mwp-book-container"));
			booklogocontainer.findElement(By.xpath("//img[@src[normalize-space(.)!= '']]"));
			WebElement booktitle = coursebook.findElement(By.xpath("//ul/li[@class='mwp-book-title'][normalize-space(.)!='']"));
			System.out.println(booktitle.getText());			
			WebElement bookauthor = coursebook.findElement(By.xpath("//ul/li[@class='mwp-book-author'][normalize-space(.)!='']"));
			System.out.println(bookauthor.getText());			
			WebElement instructlicenceagreement = driver.findElement(By.xpath("//form[@id='acceptLicenseForm']/h2[text()='Instructor & Developer License Agreement']"));
			System.out.println(instructlicenceagreement.getText());			
			driver.switchTo().frame("license-window");
			WebElement licencesummary = driver.findElement(By.xpath("//table/tbody/tr/td/p/span[@class[normalize-space(.)!='']]"));
			System.out.println(licencesummary.getText());			
			//Details on License
			List<WebElement> licensedetails = driver.findElements(By.xpath("//table/tbody/tr/td/ol/li")); 
			ResultUtil.report("MESSAGE", "List of license details are:"+licensedetails.size(), driver);
			for(int l=1;l<=licensedetails.size();l++){
				WebElement agreementheading = driver.findElement(By.xpath("//table/tbody/tr/td/ol/li["+l+"]/p[1]/span[@class='license']"));
								
				if(agreementheading.getText().equalsIgnoreCase("OWNERSHIP")||agreementheading.getText().equalsIgnoreCase("INDEMNIFICATION")){
						List<WebElement> agreementpointdesc = driver.findElements(By.xpath("//table/tbody/tr/td/ol/li["+l+"]//ol/li")); 
						ResultUtil.report("MESSAGE", "List of license sub description are:"+agreementpointdesc.size(), driver);
						for(int s=1; s<=agreementpointdesc.size();s++){
								WebElement agreementdesc = driver.findElement(By.xpath("//table/tbody/tr/td/ol/li["+l+"]//ol/li["+s+"]/span[@class='license'][normalize-space(.)!='']"));
								ResultUtil.report("MESSAGE", "Description for "+agreementheading.getText()+":"+agreementdesc.getText(), driver);
						}					
				}
				else{
					WebElement agreementdesc = driver.findElement(By.xpath("//table/tbody/tr/td/ol/li["+l+"]/p[2]/span[@class='license'][normalize-space(.)!='']"));
					ResultUtil.report("MESSAGE", "Description for "+agreementheading.getText()+":"+agreementdesc.getText(), driver);
					}					
			}
			driver.switchTo().defaultContent();
			Element.verify("Agree checkbox", driver.findElement(By.xpath("//div[@id='mwp-license-bottom']//input[@id='acceptlicense']")), driver);
			Checkbox.verify("Agree checkbox",  driver.findElement(By.xpath("//div[@id='mwp-license-bottom']/label[normalize-space(.)!='']")), driver);
			Checkbox.check("Agree checkbox", driver.findElement(By.xpath("//div[@id='mwp-license-bottom']/label[normalize-space(.)!='']")), driver);
			ResultUtil.report("PASS", "License agreement page is displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "No License agreement page is displayed", driver);
		}
	}
	
	//Description: Switch to Student And Instructor View
	public void switchToStudentAndInstructorView(){
		ResultUtil.report("INFO", "CourseHomePage>>>switchToStudentAndInstructorView", driver);
		Button.click("Go To Student Instructor View", switchToInstructorStudentButton, driver);
	}
	
	//Description: Choose Class Section
	public void chooseClassSelection(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CourseHomePage>>>chooseClassSelection", driver);
		String strclassSelection = dataMap.get("ClassName");
		WebElement selectClass = driver.findElement(By.xpath("//table[contains(@class,'plain-table')]//tr/td[.='"+strclassSelection+"']//following-sibling::td//a"));
		Button.click(strclassSelection, selectClass, driver);
	}
	
	//Description: Switch to Frames
	public void switchToFrames(){
		ResultUtil.report("INFO", "CourseHomePage>>>switchToFrames", driver);
		driver.switchTo().frame(driver.findElement(By.tagName("iFrame")));
	}
	
	//Description: Valildate Orion Course Screen
	public void validateOrionCourseScreen(){
		ResultUtil.report("INFO", "CourseHomePage>>validateOrionCourseScreen", driver);
		try{
			switchToFrame();
		}		
		catch(Exception e){
			
		}
		if(driver.findElement(By.xpath("//div[@id='course-title']")).isDisplayed()){
			ResultUtil.report("PASS", "Pass-Validated Course Title", driver);
		}
		else{
			ResultUtil.report("FAIL", "Fail-Validated Course Title", driver);
		}
	}
	
	//Description: Switch to container tab
	public void switchToFrame(){
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);
	}
	
	//Description: Validate Orion Icon
	public void validateOrionIcon(){
		ResultUtil.report("INFO", "CourseHomePage>>validateOrionIcon", driver);
		if(Element.verify("ORION Icon", driver, "XPATH", "//li[.//span[text()='ORION']]//img")){
			ResultUtil.report("PASS", "ORION Icon displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "ORION Icon not displayed", driver);
		}
	}
	
	//Description: Clicking on Assignment Tab button from the Home Screen
	public AssignmentPage goToOrionAssigmentPage() throws Exception{
		ResultUtil.report("INFO", "CourseHomePage>>goToOrionAssigmentPage", driver);
		switchToFrame();
		Button.click("Assignment Tab", tabAssignment, driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Description: Course home screen - orion
	public void OrioncourseHomeScreen(){
		ResultUtil.report("INFO", "CourseHomePage>>OrioncourseHomeScreen", driver);
		switchToFrame();
		if(driver.findElement(By.xpath("//div[@id='course-title']")).isDisplayed()){
			ResultUtil.report("PASS", "Pass-Validated Course Title", driver);
		}
		else{
			ResultUtil.report("FAIL", "Fail-Validated Course Title", driver);
		}
	}
	
	//Description: Click gradebook page - orion
	public GradeBookPage goToOrionGradebookPage() throws Exception{
		ResultUtil.report("INFO", "CourseHomePage>>goToOrionGradebookPage", driver);
		switchToFrame();
		Button.verify("Click GradeBook Tab", tabGradeBook, "Gradebook", driver);
		Button.click("Click GradeBook Tab", tabGradeBook, driver);
		return PageFactory.initElements(driver, GradeBookPage.class);
	}
	
	//Description: Go to Wp Orion Tab
	public WileyPlusOrionPage goToWPOrionTab() throws InterruptedException{
		ResultUtil.report("INFO", "CourseHomePage>>goToWPOrionTab", driver);
		Button.click("Orion tab", tabOrion, driver);
		return PageFactory.initElements(driver, WileyPlusOrionPage.class);
	}
	
	//Description: Navigate to student view page bu clicking go to student view button
	public StudentViewChooseClassSection goToInstructorView() {
		ResultUtil.report("INFO", "CourseHomePage>>goToInstructorView", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container frame", "container", 6);			
		Button.click("Instructor view", elmntGotoInstructorViewbtn, driver);
		return PageFactory.initElements(driver, StudentViewChooseClassSection.class);
	}
	
	//validate the domain user role
	public void validateDomainRole(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CourseHomePage>>validateDomainRole", driver);
		String strDomainFirstName = dataMap.get("DomainOwnerFirstName");
		String strDomainSecondName = dataMap.get("DomainOwnerLastName");
		String strDomainOwnerName = strDomainFirstName.concat(strDomainSecondName);
		
		Sync.waitForObject(driver, "Domain owner name", "XPATH", "//b[text()='"+strDomainOwnerName+"']");
		Element.verify("Domain owner name", driver, "XPATH", "//b[text()='"+strDomainOwnerName+"']");
		Element.verify("Course Admin", driver, "XPATH", "//li[@title='Course Admin']");
		Element.verify("Home page", driver, "XPATH", "//li[@title='Home' and @class='active']");
	}
}

