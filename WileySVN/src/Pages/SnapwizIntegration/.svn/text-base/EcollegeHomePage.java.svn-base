package Pages.SnapwizIntegration;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.GradeBookPage;
import Pages.Common.Initializer;
import Pages.GradeBook.StudentGradeBookPage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;


public class EcollegeHomePage extends Initializer{
	
	@FindBy(how = How.XPATH, using = "//a[@title='Academics PSH']")
	private WebElement elmntAcademicsPSHtab;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Assignments')]")
	private WebElement elmntAssignmentLink;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Gradebook')]")
	private WebElement elmntGradebookLink;	
	
	public EcollegeHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Validating ecollegeHomePage
	public void ecollegeHomePage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > ecollegeHomePage", driver);
		if(Element.verify("Logged in message", driver, "XPATH", "//table[.//td[@class='WelcomeMessageBody']]//font[contains(text(),'Welcome WileyQA Instructor')]"))
		{
			ResultUtil.report("PASS", "Successfully logged in", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Login failed", driver);
		}		
	}
	
	//Go to Academics PSH
	public void goToAcademicsPshTab()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > goToAcademicsPshTab", driver);
		Button.click("Academics", elmntAcademicsPSHtab, driver);
	}
	
	//Select course
	public void selectCourse(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "EcollegeHomePage > selectCourse", driver);
		String strCourseName = dataMap.get("CourseName");
		Link.click("Select course", driver.findElement(By.xpath("//a[contains(text(),'"+strCourseName+"')]")), driver);
	}
	
	//Validate Course Home page
	public void validateCourseHomePage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > validateCourseHomePage", driver);
		switchToContentFrame();
		Element.verify("Course home header", driver.findElement(By.xpath("//div[text()='Course Home']")), driver);
	}
	
	//Go to ecollege Assginment page
	public void goToAssignmentPage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > goToAssignmentPage", driver);
		switchToTreeFrame();
		Link.click("Assignment link", elmntAssignmentLink, driver);
	}
	
	//Switch to assignment window
	public void switchtToWindow()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > switchAssignmentWindow", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		String strWindowName = driver.getTitle();
		ResultUtil.report("MESSAGE", strWindowName, driver);
		driver.manage().window().maximize();
	}
	
	//Ecollege assignment Instructor home page
	public AssignmentPage eCollegeInstructorAssignmentPage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > eCollegeAssignmentPage", driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Ecollege assignment Student home page
	public StudentAssignmentPage eCollegeStudentAssignmentPage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > eCollegeAssignmentPage", driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}
	
	//Switch to Content frame
	public void switchToContentFrame()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main Frame", "Main	", 6);
		Sync.waitForFrame(driver, "Content Frame", "Content	", 6);
	}
	
	//Switch to Tree frame
	public void switchToTreeFrame()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Main Frame", "Main	", 6);
		Sync.waitForFrame(driver, "Tree Frmae", "Tree	", 6);				
	}
	
	//Go to ecollege Gradebook page
	public void goToGradebookPage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > goToGradebookPage", driver);
		switchToTreeFrame();
		Link.click("Gradebook link", elmntGradebookLink, driver);
	}
	
	//Ecollege Gradebook Instructor home page
	public GradeBookPage eCollegeInstructorGradebookPage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > eCollegeInstructorGradebookPage", driver);
		return PageFactory.initElements(driver, GradeBookPage.class);
	}
	
	//Ecollege Gradebook Student home page
	public StudentGradeBookPage eCollegeStudentGradebookPage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > eCollegeAssignmentPage", driver);
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}
	
	//Switch to  window
	public void switchBackToParentWindow()
	{
		ResultUtil.report("INFO", "AngelHomePage > switchBackToParentWindow", driver);
		try
		{				
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			String strWindowName = driver.getTitle();
			ResultUtil.report("MESSAGE", strWindowName, driver);
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
			String strWindowName = driver.getTitle();
			ResultUtil.report("MESSAGE", strWindowName, driver);
		}
	}
	
	//Validate Students Course Home page
	public void validateStudentsCourseHomePage()
	{
		ResultUtil.report("INFO", "EcollegeHomePage > validateStudentsCourseHomePage", driver);
		switchToContentFrame();
		Element.verify("Student Course home header", driver.findElement(By.xpath("//h1[text()='Course Home']")), driver);
	}
	
	//Validate student home page
	public void ecollegeStudentHomePage(){
		ResultUtil.report("INFO", "EcollegeHomePage > ecollegeHomePage", driver);
		if(Element.verify("Logged in message", driver, "XPATH", "//table[.//td[@class='WelcomeMessageBody']]//font[contains(text(),'Welcome WileyQA Student')]"))
		{
			ResultUtil.report("PASS", "Successfully logged in", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Login failed", driver);
		}		
	}
}
