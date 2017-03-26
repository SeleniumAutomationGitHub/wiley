package Pages.SnapwizIntegration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Assignments.AssignmentPage;
import Pages.Common.Initializer;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;

public class ORIONAssignmentPropertiesPage extends Initializer
{	
	@FindBy(how = How.ID, using = "Submit")
	private WebElement elmntSubmitButton;
	
	@FindBy(how = How.ID, using = "Cancel")
	private WebElement elmntCancelButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Assignments']")
	private WebElement elmntAssignmentLink;
	
	@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
	private WebElement elmntReturnBlackboard;

	public ORIONAssignmentPropertiesPage(WebDriver driver){
		super(driver);
	}	

	//Validating Assignment description section in assignment properties pageS
	public void validateAssignmentDescription()
	{
		ResultUtil.report("INFO", "ORIONAssignmentPropertiesPage>validateAssignmentDescription ", driver);
		Element.verify("Description heading", driver.findElement(By.xpath("//td[text()='Assignment Description']")), driver);	
	}

	public void validateClassSectionAssignment() throws InterruptedException
	{
		ResultUtil.report("INFO", "ORIONAssignmentPropertiesPage>validateClassSectionAssignment ", driver);
		Element.verify("Class Section Heading", driver.findElement(By.xpath("//td/b[text()='Class Section Assignments']")), driver);
	}

	public void ValidateButtonDisplay()
	{
		ResultUtil.report("INFO", "ORIONAssignmentPropertiesPage>ValidateButtonDisplay ", driver);
		Button.verify("Submit Button", elmntSubmitButton, driver);
		Button.verify("Cancel button", elmntCancelButton, driver);		
	}
	
	//Navigate to Assignment list page
	public AssignmentPage gotoAssignmentList()
	{
		ResultUtil.report("INFO", "ORIONAssignmentPropertiesPage>gotoAssignmentList ", driver);
		Link.click("Assignment", elmntAssignmentLink, driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Return to Blackboard page 
	public BlackBoardIntegrationPage returnToBlackboard()
	{
		ResultUtil.report("INFO", "ORIONAssignmentPropertiesPage>returnToBlackboard ", driver);
		Button.click("Return to Blackboard", elmntReturnBlackboard, driver);
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
	}
}
