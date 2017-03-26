package Pages.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Assignments.AssignmentPage;
import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class AssignOrionPage extends Initializer
{	
	public AssignOrionPage(WebDriver driver){
		super(driver);
	}
	
	String strOrionXpath= "//b[text()='Assign ORION']";

	@FindBy(how = How.XPATH, using = "//input[contains(@name,'_sdt')]")
	private WebElement elmntStartDate;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'_edt')]")
	private WebElement elmntEndDate;
	
	@FindBy(how = How.ID, using = "Close")
	private WebElement elmntCloseButton;
	
	@FindBy(how = How.ID, using = "Submit")
	private WebElement elmntSubmitButton;
	
	//Assign date to the Assignment
	public AssignmentPage assignOrionAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "AssignOrionPage>assignOrionAssignment", driver);
		String strStartDate = dataMap.get("StartDate");
		String strEndDate = dataMap.get("EndDate");
		//Validate the orion page
		Element.verify("Assign ORION", driver.findElement(By.xpath(strOrionXpath)), driver);
		//Warning message
		Element.verify("Warning message", driver.findElement(By.xpath("//span[contains(text(),'Please Note')]")), "Please Note: Setting a start and end date for this ORION assignment does not prohibit students from accessing the ORION chapter from other areas in WileyPLUS and ORION.", driver);
		//Assign the assignment to the class section
		assignClassSection(dataMap);
		//Assign Date
		TextBox.JSEnterValue("Start Date", driver, elmntStartDate, strStartDate);
		TextBox.JSEnterValue("Due Date", driver, elmntEndDate, strEndDate);
		Button.click("Submit", elmntSubmitButton, driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Edit Due date to the Assignment
	public AssignmentPage editDateAssignOrionAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "AssignOrionPage>editDateAssignOrionAssignment", driver);
		String strDueDate = dataMap.get("DueDate");		
		//Validate the orion page
		Element.verify("Assign ORION", driver.findElement(By.xpath(strOrionXpath)), driver);
		//Warning message
		Element.verify("Warning message", driver.findElement(By.xpath("//span[contains(text(),'Please Note')]")), "Please Note: Setting a start and end date for this ORION assignment does not prohibit students from accessing the ORION chapter from other areas in WileyPLUS and ORION.", driver);
		//Assign the assignment to the class section
		TextBox.JSEnterValue("Due Date", driver, elmntEndDate, strDueDate);
		((JavascriptExecutor)driver).executeScript("assignAG()");
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();		
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Validate the assignment is assigned to the class section
	public void assignClassSection(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "AssignOrionPage>assignClassSection", driver);
		String strClassSection = dataMap.get("ClassSection");
		if(Checkbox.isChecked("Class section", driver.findElement(By.xpath("//tr[./td/b[text()='"+strClassSection+"']]//input[@type='checkbox']")), driver))
		{
			ResultUtil.report("MESSAGE", "Assignment is assigned to class section", driver);
		}
		else
		{
			Checkbox.check("Class Section", driver.findElement(By.xpath("//tr[./td/b[text()='"+strClassSection+"']]//input[@type='checkbox']")), driver);
		}		
	}

	
	//Assign date to the Assignment
	public AssignmentPage assignBBOrionAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "AssignOrionPage>assignBBOrionAssignment", driver);
		String strStartDate = dataMap.get("StartDate");
		String strEndDate = dataMap.get("EndDate");
		String strClassSection = dataMap.get("ClassSection");
		//Validate the orion page
		Element.verify("Assign ORION", driver.findElement(By.xpath(strOrionXpath)), driver);
		//Warning message
		Element.verify("Warning message", driver.findElement(By.xpath("//span[contains(text(),'Please Note')]")), "Please Note: Setting a start and end date for this ORION assignment does not prohibit students from accessing the ORION chapter from other areas in WileyPLUS and ORION.", driver);
		//Assign the assignment to the class section
		assignClassSection(dataMap);
		//Assign Date			
		TextBox.JSEnterValue("Start Date", driver, driver.findElement(By.xpath("//tr[.//td/b[text()='"+strClassSection+"']]/following-sibling::tr[//input[contains(@name,'_sdt')]]//table//td/input[contains(@name,'_sdt')]")), strStartDate);
		TextBox.JSEnterValue("Due Date", driver, driver.findElement(By.xpath("//tr[.//td/b[text()='"+strClassSection+"']]/following-sibling::tr[//input[contains(@name,'_sdt')]]//table//td/input[contains(@name,'_edt')]")), strEndDate);
		Button.click("Submit", elmntSubmitButton, driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
	
	//Edit Due date to the Assignment
	public AssignmentPage editBBDateAssignOrionAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "AssignOrionPage>editBBDateAssignOrionAssignment", driver);
		String strDueDate = dataMap.get("DueDate");		
		//Validate the orion page
		Element.verify("Assign ORION", driver.findElement(By.xpath(strOrionXpath)), driver);
		//Warning message
		Element.verify("Warning message", driver.findElement(By.xpath("//span[contains(text(),'Please Note')]")), "Please Note: Setting a start and end date for this ORION assignment does not prohibit students from accessing the ORION chapter from other areas in WileyPLUS and ORION.", driver);
		//Assign the assignment to the class section
		TextBox.JSEnterValue("Due Date", driver, elmntEndDate, strDueDate);
		((JavascriptExecutor)driver).executeScript("assignAG()");
		Sync.waitForSeconds(8, driver);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();		
		Sync.waitForSeconds(8, driver);
		return PageFactory.initElements(driver, AssignmentPage.class);
	}
}
