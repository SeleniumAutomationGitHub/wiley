package Pages.CourseAdmin;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Toolbox.Button;
import Toolbox.ResultUtil;


public class GoToAddInstructorPage 
{
	private final WebDriver driver;
	
	@FindBy(how = How.ID, using = "Add_Instructor")
	private WebElement btnAddInstructor;
	
	public GoToAddInstructorPage(WebDriver driver){
		this.driver=driver;
	}
	
public AddEmailInstructorPage gotoAddInstructor() 
{
		ResultUtil.report("INFO", "GoToAddInstructorPage>gotoAddInstructor", driver);
		//Click 'Add instructor' button
		Button.click("Add Instructor", btnAddInstructor, driver);
		return PageFactory.initElements(driver, AddEmailInstructorPage.class);
	}
}
