package Pages.CourseAdmin;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class CourseFinderPreviewPage
{
	private final WebDriver driver; 	
	
	
@FindBy(how = How.ID, using = "dont-show-input")
private WebElement elmntShowCheckbox;

@FindBy(how = How.XPATH, using = "//div[@id='left-btn']")
private WebElement elmntByCourse;

@FindBy(how = How.XPATH, using = "//div[@id='right-btn']")
private WebElement elmntByInstructor;

@FindBy(how = How.ID, using = "first-column")
private WebElement elmntTermSection;

@FindBy(how = How.ID, using = "second-column")
private WebElement elmntInstructorsName;

@FindBy(how = How.ID, using = "third-column")
private WebElement elmntSectionName;

@FindBy(how = How.ID, using = "fourth-column")
private WebElement elmntMeetingTime;

@FindBy(how = How.ID, using = "descr-link")
private WebElement elmntWileyPlusLink;

@FindBy(how = How.XPATH, using = "//div[contains(text(),'Choose your class section for')]")
private boolean elmntCourseSectionText;

	
	public CourseFinderPreviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Validating the class name , class section meeting and Class term in course finder preview page.
	public CourseAdminClassSectionEditPage validateClassSectionChanges(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseFinderPreviewPage>validateClassSectionChanges", driver);
		String changeClassName = dataMap.get("NewChangeClassName");		
		String strTerm = concatName(dataMap);		
		
		//Verify the term 
		Element.verify("Term and Year", elmntTermSection, strTerm, driver);
		
		//Verify the class section name
		Element.verify("Section Name", elmntSectionName, changeClassName, driver);
		Sync.waitForSeconds(3, driver);
		this.driver.close();
		String parentWindow=driver.getWindowHandles().toArray()[0].toString();
		driver.switchTo().window(parentWindow);
		return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
	}	
	
	//Validate teh course finder page 
	public void validateCourseFinderPreview() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseFinderPreviewPage>validateCourseFinderPreview", driver);
		//Verify do not show checkbox
		Element.verify("Do not show checkbox message", driver.findElement(By.xpath("//div[contains(text(),'Do not show me this again')]")), "Do not show me this again", driver);
	
		//Verify the tabs displayed
		Button.verify("By Course tab", elmntByCourse, "By Course", driver);
		Button.verify("By Instructor tab", elmntByInstructor, "By Instructor", driver);
		
		//Verify the Bycourse section header
		Element.verify("Term Header text", driver.findElement(By.xpath("//td[text()='Term']")), "Term", driver);
		Element.verify("Instructors Header text", driver.findElement(By.xpath("//td[text()='Instructor(s)']")), "Instructor(s)", driver);
		Element.verify("Section name Header text", driver.findElement(By.xpath("//td[text()='Section Name']")), "Section Name", driver);
		Element.verify("Meeting time Header text", driver.findElement(By.xpath("//td[text()='Meeting Time']")), "Meeting Time", driver);
		
		//Verify Wileyplus link
		Link.verify("Wiley plus link", elmntWileyPlusLink, "wileyplus.com", driver);
		
		/*//Click "Wileyplus" link in by course tab
		elmntWileyPlusLink.click();
		Thread.sleep(5000);
		navigateToWileyPlusSite();*/
		
		//Select By Instructo tab
		Button.click("Click ", elmntByInstructor, driver);
		Sync.waitForSeconds(2, driver);
		Assert.assertFalse(elmntCourseSectionText);	
	}
	
	//Validating "do not show checkbox"
	public CourseAdminClassSectionEditPage validateCourseFinderCheckbox()
	{
		ResultUtil.report("INFO", "CourseFinderPreviewPage>validateCourseFinderCheckbox", driver);
		if(!(elmntShowCheckbox.isSelected()))
		{
			Checkbox.check("Select the checkbox", elmntShowCheckbox, driver);					
		}
		else
		{
			Checkbox.unCheck("Unselect the checkbox", elmntShowCheckbox, driver);
		}
		String parentWindow=driver.getWindowHandles().toArray()[0].toString();
		driver.switchTo().window(parentWindow);
		return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
	}
	
	public void navigateToWileyPlusSite()
	{
		ResultUtil.report("INFO", "CourseFinderPreviewPage>navigateToWileyPlusSite", driver);
		driver.switchTo().window(" Home / Log In - WileyPlus    ").getCurrentUrl();
		driver.findElement(By.xpath("//div[@class='logo']//img[@alt='WileyPLUS - accessible, affordable, active learning']"));
	}
	
	//concatenation function for first and last name
	public String concatName(Map<String,String> dataMap)
	{
		String classNameTerm = dataMap.get("NewClassSectionTerm");
		String classTermYear = dataMap.get("NewClassSectionTermYear");
		String strInstructorName = classNameTerm.concat((" " + classTermYear));	
		return strInstructorName;
	}

}
