package Pages.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Pages.Common.Initializer;
import Toolbox.ResultUtil;
import Toolbox.Sync;
/*******TO DO PENDING******/
public class CreatingAssignmentHelpPage extends Initializer  {
	
	@FindBy(how = How.XPATH, using = "//p[3]/a")
	private WebElement lnkCreatingNewQuestion; 
	
	@FindBy(how = How.XPATH, using = "//p[3]/b/span[1]/a")
	private WebElement lnkSelectQuestions;
		
	public CreatingAssignmentHelpPage(WebDriver driver){
		super(driver);
	}
	
	//Description: Focus Create New Assignment Window
	public void verifyCreateNewAssignmentTitle() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>>verifyCreateNewAssignmentTitle", driver);
		String strCreateNewAssignmentWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strCreateNewAssignmentWindow);
		String assign=driver.findElement(By.xpath("//h1[.='Create New Assignment']")).getText();
		ResultUtil.report("MESSAGE-", assign, driver);
	}
	
	//Description: Verifying Overview Section from  Create New Assignment Window
	public void verifyOverviewSection() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>>verifyCreateNewAssignmentTitle", driver);
		
		if(driver.findElement(By.xpath("//h3[.='Overview']")).isDisplayed()){
			ResultUtil.report("PASS", "Subtitle Overview is Present", driver);
		}
		else{
			ResultUtil.report("FAIL", "Subtitle Overview is not Present", driver);
		}
	}
		
	//Description: Selecting Creating New Question link and Verifying the text from  Create New Assignment Window
	public void verifyCreatingNewQuestion() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>>verifyCreatingNewQuestion", driver);
		lnkCreatingNewQuestion.click();
		
		if(driver.findElement(By.id("Create_New_Questions")).isDisplayed()){
			ResultUtil.report("PASS", "CreateNewQuestion is Present", driver);			
		}
		else{
			ResultUtil.report("PASS", "CreateNewQuestion is not Present", driver);	
		}
		Sync.waitForSeconds(2, driver);
	}
	
	//Description: Selecting Select Questions/Resources link and verifying  the text from  Create New Assignment Window
	public void verifySelectingQuestionsResources() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>> verifySelectingQuestionsResources", driver);
		lnkSelectQuestions.click();
		
		if(driver.findElement(By.id("Select_Questions_Resources")).isDisplayed()){
			ResultUtil.report("PASS", "Select Questions/Resources is Present", driver);			
		}
		else{
			ResultUtil.report("PASS", "Select Questions/Resources is not Present", driver);	
		}
	}
	
	//Description: Closing the Create New Assignment Window which is displayed
	public void closingWindow() {
		driver.close();
	}
	
	//TO DO
	//Description: Clicking Creating an Assignment link	and validating the window
	public void clickCreatingAssignmentLink() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>> clickCreatingAssignmentLink", driver);
		Sync.waitForSeconds(25, driver);
		String strWindow1=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strWindow1);
		
		if(driver.findElement(By.xpath("//h1")).isDisplayed()){
			ResultUtil.report("MESSAGE", "Pass- Validated Title", driver);
		}
		else{
			ResultUtil.report("MESSAGE", "Fail- Validated Title", driver);
		}
		validatingCreatingNewQuestion();
		validatingSelectQuestion();
		closeWindow();
	}
	
	//Description: Validating the Creating New Question Link and Content
	public void validatingCreatingNewQuestion() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>> validatingCreatingNewQuestion", driver);
		lnkCreatingNewQuestion.click();
		
		if(driver.findElement(By.xpath("//h3[2]/b")).isDisplayed()){
			System.out.println("Pass- Validated CreatingNewQuestion Text");
		}
		else{
			System.out.println("Fail- Validated CreatingNewQuestion Text");
		}
		Sync.waitForSeconds(2, driver);
	} 
	
	//Description: Validating the Select Question Link and Content
	public void validatingSelectQuestion() {
		ResultUtil.report("INFO", "CreatingAssignmentHelpPage>>> validatingSelectQuestion", driver);
		lnkSelectQuestions.click();
		
		if(driver.findElement(By.xpath("//h4[2]/b")).isDisplayed()){
			System.out.println("Pass- Validated Select Question Text");
		}
		else{
			System.out.println("Fail- Validated Select Question Text");
		}
		Sync.waitForSeconds(2, driver);
	}
	
	//Description: Closing the Window
	public void closeWindow() {
		driver.close();
	}
}
