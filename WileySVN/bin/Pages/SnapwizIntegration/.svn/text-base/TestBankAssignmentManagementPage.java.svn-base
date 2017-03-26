package Pages.SnapwizIntegration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class TestBankAssignmentManagementPage extends Initializer
{	
	@FindBy(how = How.ID, using = "applyAGListSetings")
	private WebElement elmntgoBtn;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Assignment Management']")
	private WebElement elmntTestBankAssignmentManagementLink;
	
	@FindBy(how = How.NAME, using = "chapter")
	private WebElement elmntAssignmentListBox;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Assignments']")
	private WebElement elmntAssignmentLink;
	
	
	public TestBankAssignmentManagementPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Validate the ORION assignments in Assignment Management page
	public void validateAssignmentsAssignmentManagement()
	{		
		ResultUtil.report("INFO", "TestBankAssignmentManagementPage>validateAssignmentsAssignmentManagement", driver);
		switchFrameContentUpdatePage();
		//Click Go button in the assignment list by default chapter
		Button.click("Go", elmntgoBtn, driver);
		if(Element.verify("Orion assignment", driver, "XPATH", "//table[@class='plain-table']//tr[.//span[text()='ORION']]")){
			ResultUtil.report("MESSAGE", "Orion assignment is displayed in assignment management page in content update page", driver);
		}
		else{
			ResultUtil.report("MESSAGE", "Orion assignment is not displayed in assignment management page. Continuing searching orion assigment for another chapter ", driver);
			orionAssignments();			
		}
	}
	
	//Find orion assignments
	public void orionAssignments()
	{
		ResultUtil.report("INFO", "TestBankAssignmentManagementPage>orionAssignments", driver);		
		switchFrameContentUpdatePage();
		//Select the assignments randomly
		Combobox.selectRandomItem("Assignment List box", elmntAssignmentListBox, driver);				
		//Click Go button in the assignment list
		Button.click("Go", elmntgoBtn, driver);
		//Verify that any other orion assignment is displayed.
		Element.verify("Orion assignment", driver, "XPATH", "//table[@class='plain-table']//tr[.//span[text()='ORION']]");
	}
	
	//Click Properties Link  on orion assignments
	public void selectOrionAssignments()
	{
		ResultUtil.report("INFO", "TestBankAssignmentManagementPage>selectOrionAssignments", driver);
		String strAsssignmentXpath= "//table[@class='plain-table']//tr[.//span[text()='ORION']]";
		if(Element.verify("Orion assignment", driver, "XPATH", strAsssignmentXpath)){
			ResultUtil.report("PASS", "ORION assignment is displayed", driver);
			Link.click("Properties Link", driver.findElement(By.xpath(strAsssignmentXpath+"[1]//a[text()='Properties']")), driver);		}
		else{
			ResultUtil.report("FAIL", "ORION assignment is not displayed", driver);
		}
	}
	
	//Validate assignment properties page
	public void validateAssignmentPropertiesPage()
	{
		ResultUtil.report("INFO", "TestBankAssignmentManagementPage>validateAssignmentPropertiesPage", driver);
		switchFrameContentUpdatePage();
		Element.verify("Assignment Name", driver, "XPATH", "//tr//span[text()='Assignment Name:']");
		Element.verify("ORION Name", driver, "XPATH", "//tr[.//span[text()='Assignment Name:']]/td/span[contains(text(),'ORION')]");
		
		Element.verify("Assignment Type", driver, "XPATH", "//tr//span[text()='Assignment Type:']");
		Element.verify("ORION Type", driver, "XPATH", "//tr[.//span[text()='Assignment Type:']]/td/span[contains(text(),'ORION')]");
		
		Element.verify("Assignment ID", driver, "XPATH", "//tr//span[text()='Assignment ID:']");
		Element.verify("ORION ID", driver, "XPATH", "//tr[.//span[text()='Assignment Type:']]/td/span[contains(text(),'orion')]");
		
		Element.verify("Associate with", driver, "XPATH", "//tr//span[text()='Associate with:']");
		Element.verify("Chapter", driver, "XPATH", "//tr[.//span[text()='Associate with:']]//td[contains(text(),'Chapter')]");
		
		Element.verify("Associate with", driver, "XPATH", "//tr//span[text()='Source:']");
		Element.verify("Chapter", driver, "XPATH", "//tr[.//span[text()='Source:']]//span[text()='Wiley']");
		
		Element.verify("Associate with", driver, "XPATH", "//tr//span[text()='Sharing:']");
		Element.verify("Chapter", driver, "XPATH", "//tr[.//span[text()='Sharing:']]//span[text()='Available to other instructors']");
	}
	
	//Go to assignments page
	public void goToAssignmentsPage()
	{
		ResultUtil.report("INFO", "TestBankAssignmentManagementPage>validateAssignmentPropertiesPage", driver);
		switchFrameContentUpdatePage();
		Link.click("Assignments", elmntAssignmentLink, driver);
	}

	//Switch to courseworkframe
	public void switchFrameContentUpdatePage()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "MainFrame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe", "userframe", 5);
		Sync.waitForFrame(driver, "Workframe", "workframe", 4);
	}
}
