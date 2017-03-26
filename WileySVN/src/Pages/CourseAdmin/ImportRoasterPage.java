package Pages.CourseAdmin;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.Window;

public class ImportRoasterPage
{
	private final WebDriver driver;

@FindBy(how = How.XPATH, using = "//a[@id='Import_Roster_File']")
private WebElement elmntImportRoaster;

@FindBy(how = How.XPATH, using = "//input[@type='file']")
private WebElement elmntBrowseButton;

@FindBy(how = How.XPATH, using = "Get_Roster_File_Template")
private WebElement elmntRoasterFileTemplate;

@FindBy(how = How.ID, using = "Submit_Bottom")
private WebElement elmntSubmitButton;

@FindBy(how = How.ID, using = "Cancel_Bottom")
private WebElement elmntCancelButton;

@FindBy(how = How.XPATH, using = "//a[.='Class Sections']")
private WebElement elmntClassSectionsBreadCrumb;

@FindBy(how = How.XPATH, using = "//a[.='Edit Class Sections']")
private WebElement elmntEditClassSectionsBreadCrumb;

@FindBy(how = How.XPATH, using = "//b[.='Class Sections']")
private WebElement elmntClassSectionsheader;

@FindBy(how = How.XPATH, using = "//b[contains(.,'Edit Class Section')]")
private WebElement elmntEditClassSectionsheader;

@FindBy(how = How.XPATH, using = "//pre")
private WebElement conditions;


public ImportRoasterPage(WebDriver driver)
{
	this.driver=driver;
}

	//Check the roaster settings for invalid roaster template
	public CourseAdminClassSectionEditPage validateInvalidRoasterTemplate(Map<String, String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "ImportRoasterPage>validateInvalidRoasterTemplate", driver);
		clickImportRoasterFile();
		validateAlert();
		Element.notVerify("No Students Added", driver, "XPATH", "//table[@class='plain-table']");
		chooseFile(dataMap.get("InValidRoasterPath"));
		String roasterValue=validateErrorMessage();		
		Button.click("Click Cancel button", elmntCancelButton, driver);
		dataMap.put("Total Roaster", roasterValue);
		return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
	}

	//Check the roaster settings for valid roaster template
	public CourseAdminClassSectionEditPage validatevalidRoasterTemplate(Map<String, String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "ImportRoasterPage>validatevalidRoasterTemplate", driver);
		chooseFile(dataMap.get("ValidRoasterPath"));
		String roasterValue=validateSuccessMessage();		
		Button.click("Submit", elmntSubmitButton, driver);
		dataMap.put("Total Roaster", roasterValue);
		return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
	}
	
	//Click "Import roaster" button
	public void clickImportRoasterFile() throws InterruptedException
	{
		ResultUtil.report("INFO", "ImportRoasterPage>clickImportRoasterFile", driver);
		//Button.click("Import roaster file", elmntImportRoaster, driver);
		JavascriptExecutor javascriptExecutor=((JavascriptExecutor)driver);		
		javascriptExecutor.executeScript("importRosterFile();");
		Sync.waitForSeconds(8, driver);		
	}
	
	//Valdiate UI Import roaster functionality
	public void validateUIImportRoaster()
	{
		ResultUtil.report("INFO", "ImportRoasterPage>validateUIImportRoaster", driver);
		Button.verify("Validate get roaster template button", elmntRoasterFileTemplate, "Get Roster File Template", driver);
		//Button.verify("Validate choose file button", elmntBrowseButton, "Get Roster File Template");
		Button.verify("Validateimport roaster file button", elmntImportRoaster, "Import Roster File", driver);
	}
	
	//Validate the alert displayed if not information provided
	public void validateAlert() throws InterruptedException 
	{
		ResultUtil.report("INFO", "ImportRoasterPage>validateAlert", driver);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "Please, provide all required information");
		alert.accept();		
		Sync.waitForSeconds(8, driver);
	}
	
	//Choose file functionality
	public void chooseFile(String strPathName) throws InterruptedException
	{
		ResultUtil.report("INFO", "ImportRoasterPage>chooseFile", driver);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(strPathName);
		Sync.waitForSeconds(5, driver);
		Button.click("Click Import Roaster file", elmntImportRoaster, driver);
		//JavascriptExecutor javascriptExecutor=((JavascriptExecutor)driver);		
		//javascriptExecutor.executeScript("importRosterFile();");
		Sync.waitForSeconds(5, driver);
		}
	
	public String validateErrorMessage()
	{
		ResultUtil.report("INFO", "ImportRoasterPage>validateErrorMessage", driver);
		String strValue="This student record cannot be added. There is invalid data in the imported roster; please revise and try again.";
		Element.verify("Invalid symbols used in the Text file", driver.findElement(By.xpath("//table[@class='plain-table']//tr//span[contains(text(),'This student record cannot be added.')]")), strValue, driver);
		Button.verify("Submit button display", elmntSubmitButton, "Submit", driver);
		Button.verify("Cancel button display", elmntCancelButton, "Cancel", driver);
		
		//List of student roster
		List<WebElement> elmntStudentRecords = driver.findElements(By.xpath("//table[@class='plain-table']//tr//span[contains(text(),'This student record cannot be added.')]"));
		String totalStudentsRoster = new Integer(elmntStudentRecords.size()).toString();
		return totalStudentsRoster;		
	}
	
	//Validate the notification message after creating the import file
		public String validateSuccessMessage()
		{
			ResultUtil.report("INFO", "ImportRoasterPage>validateSuccessMessage", driver);
			if(Element.verify("Account created Message", driver, "XPATH", "//table[@class='plain-table']//tr//td[./span[contains(text(),'account created')]]/span"))
			{
				String strValue="WileyPLUS account created. A confirmation email will be sent to the student after adding the imported roster to a Class Section.";
				Element.verify("Successfully created", driver.findElement(By.xpath("//table[@class='plain-table']//tr//td[./span[contains(text(),'account created')]]/span")), strValue, driver);
			}
			else if(Element.verify("This student has a WileyPLUS account", driver, "XPATH", "//table[@class='plain-table']//tr//td[./span[contains(text(),'This student has')]]/span"))
			{
				String strValue="This student has a WileyPLUS account and will be added to the course with their saved profile information. A confirmation email will be sent to the student after adding the imported roster to a Class Section.";
				Element.verify("Successfully created", driver.findElement(By.xpath("//table[@class='plain-table']//tr//td[./span[contains(text(),'This student has')]]/span")), strValue, driver);
			}
			else
			{
				ResultUtil.report("REPORT", "Failed to verify the success message", driver);
			}
			//List of student roster
			List<WebElement> elmntStudentRecords = driver.findElements(By.xpath("//table[@class='plain-table']//tr//td[./span[contains(text(),'account created')]]/span"));
			String totalStudentsRoster = new Integer(elmntStudentRecords.size()).toString();
			return totalStudentsRoster;			
		}
		
		//Validate importRoaster UI
		public void roasterUI(Map<String,String> dataMap) throws InterruptedException
		{
			ResultUtil.report("INFO", "ImportRoasterPage>roasterUI", driver);
			Element.verify("Import Roster text", driver, "XPATH", "//b[.='Import Roster File']");
			
			//Verify the  class section and edit class sectionbreadcrumbs
			Element.verify("Class Sections", elmntClassSectionsBreadCrumb, driver);
			Element.verify("Edit Class Section", elmntEditClassSectionsBreadCrumb, driver);
			
			//Go to class section page and verify the class section header
			Link.click("Class section link", elmntClassSectionsBreadCrumb, driver);
			Element.verify("Class section header", elmntClassSectionsheader, driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage=courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "AddClassName");
			
			//Click "Import Roaster" button
			 courseAdminClassSectionEditPage.gotoImportRoasterPage();
			
			//Go to edit class section and verify the edit class section header
			Link.click("Edit class section", elmntEditClassSectionsBreadCrumb, driver);
			Element.verify("Edit class section", elmntEditClassSectionsheader, driver);
			
			//go to impot roster page
			courseAdminClassSectionEditPage.gotoImportRoasterPage();
			
			//Verify teh 3 buttons are displayed.
			Button.verify("Get roster file template", elmntRoasterFileTemplate, driver);
			Button.verify("Browse button", elmntBrowseButton, driver);
			Button.verify("Import roster file", elmntImportRoaster, driver);			
		}
		
		//Click "Get roster file template"
		public void clickRosterTemplate()
		{
			ResultUtil.report("INFO", "ImportRoasterPage>clickRosterTemplate", driver);
			Button.click("Get Roster file", elmntRoasterFileTemplate, driver);
		}
		
		//Validate the get roster instructions
		public void getRosterInstructions()
		{
			ResultUtil.report("INFO", "ImportRoasterPage>getRosterInstructions", driver);
			Window.focusWindow("Instruction window", driver, driver.getWindowHandles().toArray()[1].toString());
			Element.verify("Roster conditions", conditions, driver);
			ResultUtil.report("MESSAGE", conditions.getText(), driver);
			this.driver.close();
			Window.focusWindow("Instruction window", driver, driver.getWindowHandles().toArray()[0].toString());
		}
}
