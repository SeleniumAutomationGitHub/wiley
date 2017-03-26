package Pages.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Pages.CourseAdmin.AddEmailInstructorPage;

public class GoToAddInstructorPage extends Initializer {
		
	@FindBy(how = How.ID, using = "Add_Instructor")
	private WebElement btnAddInstructor;
	
	public GoToAddInstructorPage(WebDriver driver){
		super(driver);
	}
	
	//Description: Go to Add Instructor
	public AddEmailInstructorPage gotoAddInstructor() throws InterruptedException{
		btnAddInstructor.click();		
		return PageFactory.initElements(driver, AddEmailInstructorPage.class);
	}
}
