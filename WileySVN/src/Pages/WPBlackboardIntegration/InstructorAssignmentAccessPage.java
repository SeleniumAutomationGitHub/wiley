package Pages.WPBlackboardIntegration;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class InstructorAssignmentAccessPage 
{
	private final WebDriver driver;
	
@FindBy(how = How.ID, using = "Go_To_Student_View")
private WebElement elmntGotoStudentViewbtn;
	
@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
private WebElement elmntReturnBlackboard;
	
@FindBy(how = How.ID, using = "Instructor_View")
private WebElement elmntGotoInstructorViewbtn;
	
public InstructorAssignmentAccessPage(WebDriver driver){
		this.driver=driver;	
	}	
	
	//Description:Click wileyplus link in publish content
public void validateInstructorAssignmentWindow()
	{
		ResultUtil.report("INFO", "InstructorAssignmentAccessPage>validateInstructorAssignmentWindow", driver);
		Sync.waitForSeconds(5, driver);
		Element.verify("Student view ", driver, "ID", "Go_To_Student_View");
		Element.notVerify("Return to Blackboard", driver, "XPATH", "//ins[text()='Return to Blackboard']");		
	}

	//Description:Navigate to Parent window
public void switchToParentWindow()
	{
		ResultUtil.report("INFO", "InstructorAssignmentAccessPage>switchToParentWindow", driver);
		try
		{				
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			String strWindowName = driver.getTitle();
			ResultUtil.report("Window Name", strWindowName, driver);
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
			ResultUtil.report("Window Name", strWindowName, driver);
			Sync.waitForSeconds(3, driver);
		}
	}
	//Description:verify description page
public void verifyDescriptionPage()
	{		
		ResultUtil.report("INFO", "InstructorAssignmentAccessPage>>>verifyDescriptionPage", driver);
				
		try
		{
			driver.switchTo().defaultContent();
			WebDriver myFrame = driver.switchTo().frame("container");
			myFrame = myFrame.switchTo().frame("mainframe");
			myFrame = myFrame.switchTo().frame("agrootframe");
			myFrame = myFrame.switchTo().frame("agarea");
			myFrame = myFrame.switchTo().frame("agbody");
			Sync.waitForSeconds(3, myFrame);
		}
		catch(Exception e){}
		
		WebElement assgnType=driver.findElement(By.xpath("//table//tr[4]//td[2]/span"));
		Element.verify("Assignment Type", assgnType, driver);
		String strAssgnTypeValue=assgnType.getText();
		ResultUtil.report("PASS", "Assignment Type: "+strAssgnTypeValue, driver);
		
		WebElement startDate=driver.findElement(By.xpath("//table//tr[10]/td[4]//span"));
		Element.verify("Start Date", startDate, driver);
		String strstartDate=startDate.getText();
		ResultUtil.report("PASS", "Start Date: "+strstartDate, driver);
		
		WebElement dueDate=driver.findElement(By.xpath("//table//tr[11]/td[4]//span"));
		Element.verify("Due Date", dueDate, driver);
		String strdueDate= dueDate.getText();
		ResultUtil.report("PASS", "Start Date: "+strdueDate, driver);
		
		WebElement stdntAccess=driver.findElement(By.xpath("//table//tr[12]/td[4]//span"));
		Element.verify("Student Access", stdntAccess, driver);
		String strstdntAccess=stdntAccess.getText();
		ResultUtil.report("PASS", "Student Access After Due Date: "+strstdntAccess, driver);

		WebElement assgnPolicies=driver.findElement(By.xpath("//table//tr[18]//td[4]//span"));
		Element.verify("Assignment Policies", assgnPolicies, driver);
		String strassgnPolicies=assgnPolicies.getText();
		ResultUtil.report("PASS", "Graded "+strassgnPolicies, driver);
		
		WebElement qnPolicies=driver.findElement(By.xpath("//table//tr[.//b[text()='Question Policies']]//span/b[text()='Question Policies']"));
		Element.verify("Question Policies", qnPolicies, driver);
		String strqnPolicies=qnPolicies.getText();
		ResultUtil.report("PASS", "Attempts per question: "+strqnPolicies, driver);
	}
	
	//Description:click on first question
public void clickOnFirstQuestion()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> clickOnFirstQuestion",driver);
		Sync.waitForSeconds(5,driver);
		focusAglistframe();
		WebElement firstqn=driver.findElement(By.xpath("//table[2]//tr[1]//a"));
		Link.click("First Question", firstqn,driver);
		Sync.waitForSeconds(7,driver);
	}
	
	//Description:focusaglist
private void focusAglistframe(){
		driver.switchTo().defaultContent();
		WebDriver myFrame = driver.switchTo().frame("container");
		myFrame = myFrame.switchTo().frame("mainframe");
		myFrame = myFrame.switchTo().frame("agrootframe");
		myFrame = myFrame.switchTo().frame("aglist");
		Sync.waitForSeconds(5, myFrame);		
	}

	//Description:Validate description page
public void validateDescriptionPage()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> validateDescriptionPage",driver);
		
		try
		{
			driver.switchTo().defaultContent();
			WebDriver myFrame = driver.switchTo().frame("container");
			myFrame = myFrame.switchTo().frame("headframe");
			Sync.waitForSeconds(3, myFrame);
		}
		catch(Exception e){}
		Element.verify("Student View button", driver, "ID", "Go_To_Student_View");
		Element.verify("Return to blackboard button", driver, "XPATH", "//ins[text()='Return to Blackboard']");
	}
	
	//Description:validate questions page
public void validateQuestionsPage()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> validateQuestionsPage",driver);
		try
		{
			driver.switchTo().defaultContent();
			WebDriver myFrame = driver.switchTo().frame("container");
			myFrame = myFrame.switchTo().frame("mainframe");
			myFrame = myFrame.switchTo().frame("agrootframe");
			myFrame = myFrame.switchTo().frame("agarea");
			myFrame = myFrame.switchTo().frame("agbody");
			Sync.waitForSeconds(5, myFrame);
		}
		catch(Exception e){}
		Element.verify("Report content error", driver, "XPATH", "//table[@class='changeValueLabelsContainer']//a[contains(text(),'Report')]");
		Link.verify("Report content link", driver.findElement(By.xpath("//table[@class='changeValueLabelsContainer']//a[contains(text(),'Report')]")), "Report Content Error", driver);
	}
	
	//Description:Go to Student view
public void gotoStudentView()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> gotoStudentView",driver);
		Button.click("Go to Student view", elmntGotoStudentViewbtn, driver);
		Sync.waitForSeconds(7, driver);
	}
	
	//Description:Validate student view description page
public void validateStudentViewDescriptionPage()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> validateStudentViewDescriptionPage",driver);
		
		try
		{
			driver.switchTo().defaultContent();
			WebDriver myFrame = driver.switchTo().frame("container");
			myFrame = myFrame.switchTo().frame("headframe");
			Sync.waitForSeconds(3, myFrame);
		}
		catch(Exception e){}
		Element.verify("Instructor  View button", driver, "ID", "Instructor_View");
		Element.verify("Return to blackboard button", driver, "XPATH", "//ins[text()='Return to Blackboard']");
	}
	
	//Description:Validate student view description page
public void selectQuestions()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> selectQuestions",driver);
		try
		{
			driver.switchTo().defaultContent();
			WebDriver myFrame = driver.switchTo().frame("container");
			myFrame = myFrame.switchTo().frame("mainframe");
			myFrame = myFrame.switchTo().frame("agrootframe");
			myFrame = myFrame.switchTo().frame("agarea");
			myFrame = myFrame.switchTo().frame("agbody");
			Sync.waitForSeconds(5, myFrame);
		}
		catch(Exception e){}
		
		if(Radiobutton.isEnabled(driver.findElement(By.xpath("//input[@type='Radio']")), "Questions options", driver))
		{
			Radiobutton.select("Select a Radio button", driver.findElement(By.xpath("//input[@type='Radio']")), driver);
			Sync.waitForSeconds(3, driver);
			Radiobutton.isSelected("Select a Radio button is selected", driver.findElement(By.xpath("//input[@type='Radio']")), driver);
		}

	}
	//Description:Go to instructor view
public void gotoInstructorView()
	{
		ResultUtil.report("INFO","InstructorAssignmentAccessPage >>> gotoInstructorView",driver);
		Button.click("Go to instructor view", elmntGotoInstructorViewbtn, driver);
		Sync.waitForSeconds(7, driver);
	}
}
