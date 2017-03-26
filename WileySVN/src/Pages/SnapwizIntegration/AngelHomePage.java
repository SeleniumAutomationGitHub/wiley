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


public class AngelHomePage extends Initializer
{
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Assignments')]")
	private WebElement elmntAssignmentLink;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Lessons']")
	private WebElement elmntLessonsTab;	
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Gradebook')]")
	private WebElement elmntGradebookLink;		
	
	public AngelHomePage(WebDriver driver){
		super(driver);
	}
	
	//Validate Angel home page
	public void angelHomePage()
	{
		ResultUtil.report("INFO", "AngelHomePage > angelHomePage", driver);
		switchFrameToAngelContent();
		if(Element.verify("Logged in Message", driver, "XPATH", "//span[@class='pageTitleSpan' and text()='Home']"))
		{
			ResultUtil.report("PASS", "Successfully logged in", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Login failed", driver);
		}		
	}
	
	//Select the course
	public void selectAngelcourse(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "AngelHomePage > selectAngelcourse", driver);
		switchFrameToAngelContent();
		String strCourseName = dataMap.get("CourseName");
		Link.click("Select angel course", driver.findElement(By.xpath("//a[contains(text(),'"+strCourseName+"')]")), driver);
	}
	
	//Select Lesson tab
	public void selectLessonTab()
	{
		ResultUtil.report("INFO", "AngelHomePage > selectLessonTab", driver);
		//Switch the driver to default content
		driver.switchTo().defaultContent();				
		Button.click("Lessons", elmntLessonsTab, driver);
	}
	
	//select Assignmentslink 
	public void selectAssignmentLink()
	{
		ResultUtil.report("INFO", "AngelHomePage > selectAssignmentLink", driver);
		switchFrameToAngelContent();
		Link.click("Assigment", elmntAssignmentLink, driver);
	}
	
	//Switch to  window
	public void switchToWindow()
	{
		ResultUtil.report("INFO", "AngelHomePage > switchToWindow", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		String strWindowName = driver.getTitle();
		ResultUtil.report("MESSAGE", strWindowName, driver);
		driver.manage().window().maximize();
	}
		
	//Angel assignment Instructor home page
	public AssignmentPage angelInstructorAssignmentPage()
	{
		ResultUtil.report("INFO", "AngelHomePage > angelInstructorAssignmentPage", driver);
		switchFrameToContentFrame();
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
		
	//Angel assignment Student home page
	public StudentAssignmentPage angelStudentAssignmentPage()
	{
		ResultUtil.report("INFO", "AngelHomePage > angelStudentAssignmentPage", driver);
		switchFrameToContentFrame();
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}
	
	//Angel Gradebook Instructor home page
	public GradeBookPage angelInstructorGradebookPage()
	{
		ResultUtil.report("INFO", "AngelHomePage > angelInstructorAssignmentPage", driver);
		switchFrameToContentFrame();
		return PageFactory.initElements(driver, GradeBookPage.class);
	}
	
	//Angel Gradebook Student home page
	public StudentGradeBookPage angelStudentGradebookPage()
	{
		ResultUtil.report("INFO", "AngelHomePage > angelStudentGradebookPage", driver);
		switchFrameToContentFrame();
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}
	
	//select Gradebook link 
	public void selectGradebookLink()
	{
		ResultUtil.report("INFO", "AngelHomePage > selectGradebookLink", driver);
		switchFrameToAngelContent();
		Link.click("Gradebook", elmntGradebookLink, driver);
	}
	
	//Switch to content frame
	public void switchFrameToContent()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "ContentWin Frame", "contentWin", 6);
		Sync.waitForFrame(driver, "_yuiResizeMonitor Frame", "_yuiResizeMonitor", 6);		
	}	
	
	//Switch to content frame
	public void switchFrameToContentFrame()
	{
		try{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "ContentFrame Frame", "contentFrame", 6);
		}
		catch(Exception e){}
	}	
	
	//Switch to content frame
	public void switchFrameToAngelContent()
	{
		try
		{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "AngelContent Frame", "AngelContent", 6);
		}
		catch(Exception e){}
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
}