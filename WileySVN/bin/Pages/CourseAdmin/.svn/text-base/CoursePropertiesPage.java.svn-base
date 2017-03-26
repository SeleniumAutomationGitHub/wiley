package Pages.CourseAdmin;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.LogoutSessionPage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class CoursePropertiesPage
{
	private final WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//b[text()='Course Properties']")
	private WebElement lblCourseheading;
	
	@FindBy(how = How.ID, using = "Submit")
	private WebElement btnSubmit;
	
	@FindBy(how = How.NAME, using = "name")
	private WebElement txtCourseName;
	
	@FindBy(how = How.XPATH, using = ".//*/span[contains(text(),'Master Course Properties Updated')]")
	private WebElement lblUpdatedCopy;
	
	public CoursePropertiesPage(WebDriver driver){
		this.driver=driver;
	}
	
	public LogoutSessionPage changeCourseName(Map<String, String> dataMap) throws InterruptedException
	{		
		ResultUtil.report("INFO", "CoursePropertiesPage>changeCourseName", driver);
		Element.verify("Course Properties", lblCourseheading, "Course Properties", driver);
		String chgCourseName = dataMap.get("ChangeCourse");
		TextBox.clearValue("Clear the course name", txtCourseName, driver);
		TextBox.enterValue("Change course name", txtCourseName, chgCourseName, driver);
		Button.click("Submit button", btnSubmit, driver);	
		Sync.waitForObject(driver, "Course Properties", "XPATH", "//b[text()='Course Properties']");
		Element.verify("Updated master copy", lblUpdatedCopy, "Master Course Properties Updated", driver);
		
		//Change the course name to default one
		resetCourseName(dataMap);
		
		return PageFactory.initElements(driver, LogoutSessionPage.class);
	}
	
	public void resetCourseName(Map<String, String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>resetCourseName", driver);
		String dftCourseName = dataMap.get("Course");
		TextBox.clearValue("Clear the course name", txtCourseName, driver);
		TextBox.enterValue("Change course name", txtCourseName, dftCourseName, driver);
		Button.click("Submit button", btnSubmit, driver);
		Sync.waitForObject(driver, "Course Properties", "XPATH", "//b[text()='Course Properties']");
		Element.verify("Updated master copy", lblUpdatedCopy, "Master Course Properties Updated", driver);
	}
}
