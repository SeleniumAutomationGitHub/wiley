package Pages.Assignments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Pages.Common.Initializer;
import Pages.Common.StudentLoginpage;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Listbox;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class CreateReadingsAssignment extends Initializer {

	Random rand = new Random();

	String strContentTableXpath ="//td[@class='content-area-top']";
	String strPlainTableXpath= "//table[contains(@class,'plain-table')]";
	String strPaddinglistXpath= "//td[contains(@class,'pagination-padding list-item-padding')]";
	String strTotalScoreXpath="//table[contains(@class,'plain-table')]//tr[.//td/b[.='Total score:']]//td[./input[@class='readonly']]//input";
	String strQuestionAtempts= "//tr[./td[.='Question Attempts:']]//td//select[@id='ag_attempts']";
	String strPossibleAttempts="//tr[./td[.='Attempt Policy:']]//td//select[@name='ag_assistance_apolicy']";
	String strChangeValueXpath= "//td[@class='content-area-top']//tr[./td[text()='Change Values' and text()='(Algorithmic Questions):']]";
	String strContentAreaXpath="//table[@class='content-area']";


	@FindBy(how = How.CLASS_NAME, using = "titlink")
	private WebElement crtngAssignmentLink; 

	@FindBy(how = How.ID, using = "Create_New_Assignment")
	private WebElement btnCreatenewassignment;

	@FindBy(how = How.CLASS_NAME, using = "input100")
	private WebElement txtAssignId;

	@FindBy(how = How.CLASS_NAME, using = "input200")
	private WebElement txtAssignName;

	@FindBy(how = How.ID, using = "Next")
	private WebElement btnNext;

	@FindBy(how = How.NAME, using = "ag_descr")
	private WebElement txtDescrib;

	@FindBy(how = How.ID, using = "ag_type3")
	private WebElement rdobutton;

	@FindBy(how = How.ID, using = "sharing1")
	private WebElement rdiobutton1;

	@FindBy(how = How.ID, using = "sharing2")
	private WebElement rdiobutton;

	@FindBy(how = How.ID, using = "sharing3")
	private WebElement radiobutton;

	@FindBy(how = How.ID, using = "radio1")
	private WebElement radiobutton1;

	@FindBy(how = How.ID, using = "radio2")
	private WebElement radiobutton2;

	@FindBy(how = How.ID, using = "radio3")
	private WebElement radiobutton3;

	@FindBy(how = How.ID, using = "radio4")
	private WebElement radiobutton4;

	@FindBy(how = How.ID, using = "ag_descr1")
	private WebElement chkboxDisplay;

	@FindBy(how = How.ID, using = "applyFilters")
	private WebElement gobtn;

	@FindBy(how = How.ID, using = "applyFilterObjectives")
	private WebElement btnLearningObjective;

	@FindBy(how = How.ID, using = "applyFilterPages")
	private WebElement btngoPageNavigator;

	@FindBy(how = How.NAME, using ="ag_use_penalties_control")
	private WebElement chkboxpotential;

	@FindBy(how= How.ID, using ="ag_attempts")
	private WebElement drpAttempts;

	@FindBy(how= How.ID, using ="Assign_to_Class_Section(s)")
	private WebElement btnAssigntoClass;

	@FindBy(how= How.ID, using ="Assign_Later")
	private WebElement btnAssignlater;

	@FindBy(how= How.ID, using ="Preview_Assignment")
	private WebElement btnPreviewAssign;

	@FindBy(how = How.ID, using= "cls332816_ag_state")
	private WebElement chkboxClass;

	@FindBy(how = How.ID, using= "Submit")
	private WebElement btnSubmit;		

	@FindBy(how = How.NAME, using= "author")
	private WebElement optionME;

	@FindBy(how = How.ID, using = "applyAGListSetings")
	private WebElement btnGo;

	@FindBy(how = How.ID, using = "Save_and_Exit")
	private WebElement btnSaveandExit;

	@FindBy(how = How.NAME, using ="r_showperpage")
	private WebElement drpShowPerPage;

	@FindBy(how = How.ID, using = "Find_more_Resources")
	private WebElement btnSaveAndFind;

	@FindBy(how = How.XPATH, using ="//tr//select[@name='association']")
	private WebElement listAssociation;

	@FindBy(how = How.ID, using = "Show_Solution")
	private WebElement btnShowSolution;

	@FindBy(how = How.ID, using = "Link_to_Resource_1")
	private WebElement btnLinktoResource;

	@FindBy(how = How.NAME, using = "objective")
	private WebElement drpLearningObjectives;

	@FindBy(how = How.ID, using = "Back")
	private WebElement btnBack;

	@FindBy(how = How.ID, using = "Cancel")
	private WebElement btnCancel;

	@FindBy(how = How.NAME, using = "page")
	private WebElement drpdownPageNavigator;

	@FindBy(how=How.XPATH, using="//div[.='3. Organize Resources']")
	private WebElement organizeTab;

	@FindBy(how=How.XPATH, using="//div[.='1. Describe Assignment']")
	private WebElement describeassgmnttab;

	@FindBy(how=How.XPATH, using="//div[.='2. Select Resources']")
	private WebElement selectresourcetab;

	@FindBy(how=How.XPATH, using="//table[contains(@class,'plain-table')]//tr[2]//select")
	private WebElement order;

	@FindBy(how=How.XPATH, using="//table[contains(@class,'plain-table')]/tbody/tr[2]/td[7]")
	private WebElement remove;

	@FindBy(how=How.XPATH, using="//table[contains(@class,'plain-table')]//a[.='Remove']")
	private WebElement removeAll;

	@FindBy(how = How.XPATH, using ="//table[contains(@class,'plain-table')]//tr//input[@name='chk_pres_resource_all']")
	private WebElement chkboxCheckAllResources;

	@FindBy(how = How.XPATH, using ="//table[contains(@class,'plain-table')]//tr[8]/td/input[@type='checkbox']")
	private WebElement chkboxUncheck;

	@FindBy(how=How.ID, using="sharing1")
	private WebElement sharingRdobtn1;

	@FindBy(how=How.ID, using="sharing2")
	private WebElement sharingRdobtn2;

	@FindBy(how=How.ID, using="sharing3")
	private WebElement sharingRdobtn3;

	@FindBy(how=How.XPATH, using="//label[@for='sharing1']")
	private WebElement sharingText1;

	@FindBy(how=How.XPATH, using="//label[@for='sharing2']")
	private WebElement sharingText2;

	@FindBy(how=How.XPATH, using="//label[@for='sharing3']")
	private WebElement sharingText3;

	@FindBy(how=How.XPATH, using="//div[@class='right-part']//a[2]")
	private WebElement myprofilebtn;

	@FindBy(how=How.NAME, using="lastname")
	private WebElement lastName;

	@FindBy(how=How.XPATH, using="//a[.='Update']")
	private WebElement updateMyProfile;

	@FindBy(how = How.NAME, using = "report")
	private WebElement reviewprogress;



	public CreateReadingsAssignment(WebDriver driver){
		super(driver);
	}

	public CreatingAssignmentHelpPage gotToCreatingAssignmentHelpPage(Map<String,String> dataMap) {
		crtngAssignmentLink.click();
		return PageFactory.initElements(driver, CreatingAssignmentHelpPage.class);
	}

	//Description: Verifying Alert Message in Assignment Name column by giving more than 256 characters from Assignment page
	public void verifyLongAssignmentName(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongAssignmentName ",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[3]/td[@class='label']")).isDisplayed()){
			String _longAsignName=dataMap.get("LongCharacAsgntName");
			String _assignID=dataMap.get("AsgntID");
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, _longAsignName,driver);
			TextBox.verifyValue("LongCharacAsgntName", txtAssignName, _longAsignName,driver);
			TextBox.enterValue("AsgntID", txtAssignId, _assignID,driver);
			TextBox.verifyValue("AsgntID", txtAssignId, _assignID,driver);	       
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();

		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);		
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);		
	}

	//Description: Verifying Alert Message in Assignment ID column by giving more than 100 characters from Assignment page
	public void verifyLongAssignmentID(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongAssignmentID",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[2]/td[@class='label']")).isDisplayed()){
			String _longAssignID = dataMap.get("LongCharacAsgntID");
			String _assignName = dataMap.get("AsgntName");
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, _longAssignID,driver);
			TextBox.verifyValue("LongCharacAsgntID", txtAssignId, _longAssignID,driver);
			TextBox.enterValue("AsgntName", txtAssignName, _assignName,driver);
			TextBox.verifyValue("AsgntName", txtAssignName, _assignName,driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);		
	}

	//Description: Verifying Alert Message in Assignment Description column by giving more than 2048 characters from Assignment page
	public void verifyLongDescription(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongDescription",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[4]/td[@class='label']")).isDisplayed()){
			String _longDescrib = dataMap.get("LongCharacAsgntDescribtion");
			String _assignId = dataMap.get("AsgntID");
			String _assignName = dataMap.get("AsgntName");
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
			TextBox.verifyValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
			TextBox.enterValue("AsgntID", txtAssignId, _assignId,driver);
			TextBox.verifyValue("AsgntID", txtAssignId, _assignId,driver);
			TextBox.enterValue("AsgntName", txtAssignName, _assignName,driver);
			TextBox.verifyValue("AsgntName", txtAssignName, _assignName,driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Description", txtDescrib, driver);
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);		
	}

	//Description: Verifying Alert Message in Assignment Name and ID column by giving more than 100 and 256 characters from Assignment page
	public void verifyLongAssignmentNameAndID(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongAssignmentNameAndID",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[2]/td[@class='label']")).isDisplayed()){
			String _longAssignID = dataMap.get("LongCharacAsgntID");
			String _longAsignName = dataMap.get("LongCharacAsgntName");
			String _assignDescrib = dataMap.get("AsgntDescribtion");
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, _longAssignID,driver);
			TextBox.verifyValue("LongCharacAsgntID", txtAssignId, _longAssignID,driver);
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, _longAsignName,driver);
			TextBox.verifyValue("LongCharacAsgntName", txtAssignName, _longAsignName,driver);
			TextBox.enterValue("AsgntDescribtion", txtDescrib, _assignDescrib,driver);
			TextBox.verifyValue("AsgntDescribtion", txtDescrib, _assignDescrib,driver);	
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);		
		TextBox.clearValue("Clear Description", txtDescrib, driver);
	}

	//Description: Verifying Alert Message in Assignment ID and Description column by giving more than 100 and 2048 characters from Assignment page
	public void verifyLongAssignmentIDAndDescription(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongAssignmentIDAndDescription",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[2]/td[@class='label']")).isDisplayed()){
			String _longAssignID = dataMap.get("LongCharacAsgntID");
			String _longDescrib = dataMap.get("LongCharacAsgntDescribtion");
			String _assignName = dataMap.get("AsgntName");
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, _longAssignID,driver);
			TextBox.verifyValue("LongCharacAsgntID", txtAssignId, _longAssignID,driver);
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
			TextBox.verifyValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
			TextBox.enterValue("AsgntName", txtAssignName, _assignName,driver);
			TextBox.verifyValue("AsgntName", txtAssignName, _assignName,driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Description", txtDescrib, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);	
	}

	//Description: Verifying Alert Message in Assignment Name and Description column by giving more than 256 and 2048 characters from Assignment page
	public void verifyLongAssignmentNameAndDescription(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongAssignmentNameAndDescription",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath("//td[@class='content-area-top']//tr[2]/td[@class='label']")).isDisplayed()){
			String _longAsignName = dataMap.get("LongCharacAsgntName");
			String _longDescrib = dataMap.get("LongCharacAsgntDescribtion");
			String _assignId = dataMap.get("AsgntID");
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, _longAsignName,driver);
			TextBox.verifyValue("LongCharacAsgntName", txtAssignName, _longAsignName,driver);
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
			TextBox.verifyValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
			TextBox.enterValue("AsgntID", txtAssignId, _assignId,driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Description", txtDescrib, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);	
	}

	//Description: Verifying Alert Message in Assignment ID, Name and Description column by giving more than 100, 256 and 2048 characters from Assignment page
	public void verifyLondIdNameAndDescription(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLondIdNameAndDescription",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[2]/td[@class='label']")).isDisplayed()){
			String _longAsignID = dataMap.get("LongCharacAsgntID");
			String _longAssignName= dataMap.get("LongCharacAsgntName");
			String _longDescrib = dataMap.get("LongCharacAsgntDescribtion");
			TextBox.enterValue("LongCharacAsgntID", txtAssignId, _longAsignID,driver);
			TextBox.enterValue("LongCharacAsgntName", txtAssignName, _longAssignName,driver);
			TextBox.enterValue("LongCharacAsgntDescribtion", txtDescrib, _longDescrib,driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
		TextBox.clearValue("Clear Description", txtDescrib, driver);
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);	
	}

	//Description: Verifying the alert when the assignment Name is untitled
	public void verifyAssignmentisUntitledAlert(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyAssignmentisUntitledAlert",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[1]/td[@class='label']")).isDisplayed()){
			Radiobutton.select("Readings/Resources",rdobutton,driver );
			ResultUtil.report("PASS", "Readings/Resources is Selected ", driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();

		Alert alert = driver.switchTo().alert();
		ResultUtil.report("PASS", alert.getText(), driver);
		driver.switchTo().alert().accept();
	}		

	//Description: Verifying the alert when the assignment Id is empty
	public void verifyAssignmentIDEmptyAlert(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyAssignmentIDEmptyAlert",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[2]/td[@class='label']")).isDisplayed()){
			String _assignName= dataMap.get("AsgntName");
			TextBox.enterValue("AsgntName", txtAssignName, _assignName,driver);				
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();

		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign Name", txtAssignName, driver);	
	}

	//Description: Verifying the alert 	
	public void verifyAssignmentUntitledAlert(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyAssignmentUntitledAlert",driver);
		Radiobutton.select("Readings/Resources", rdobutton,driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[3]/td[@class='label']")).isDisplayed()){
			String _assignId = dataMap.get("AsgntID");
			TextBox.enterValue("AsgntID", txtAssignId, _assignId,driver);
		}

		driver.findElement(By.xpath("//div[./a[@id='Next']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);
		driver.switchTo().alert().accept();
		TextBox.clearValue("Clear Assign ID", txtAssignId, driver);
	}

	//Description: Enter details in Describe Assignment details	
	public void inputDescrptionDetails(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>inputDescrptionDetails",driver);

		if(driver.findElement(By.id("ag_descr1")).isDisplayed()){
			Radiobutton.select("Readings/Resources",rdobutton ,driver);
			String _assignId = dataMap.get("AsgntID");
			String _assignName= dataMap.get("AsgntName");
			String _assignDescr= dataMap.get("AsgntDescribtion");	
			TextBox.enterValue("AsgntID", txtAssignId, _assignId,driver);
			TextBox.enterValue("AsgntName", txtAssignName, _assignName,driver);
			TextBox.enterValue("AsgntDescribtion", txtDescrib, _assignDescr,driver);

			if(Checkbox.isChecked("Display to Students", chkboxDisplay,driver)){
				Checkbox.unCheck("Display to Students", chkboxDisplay,driver);
				Checkbox.check("Display to Students", chkboxDisplay,driver);
			}
			else{
				Checkbox.check("Display to Students", chkboxDisplay,driver);
			}
		}
		Button.click("NextButton", btnNext,driver);
	}

	public void verifyDescription(Map<String,String> dataMap){

		Radiobutton.isSelected("Readings/Resources",rdobutton ,driver);
		String _assignId = dataMap.get("AsgntID");
		String _assignName= dataMap.get("AsgntName");
		String _assignDescr= dataMap.get("AsgntDescribtion");	
		TextBox.verifyValue("AsgntID", txtAssignId, _assignId,driver);
		TextBox.verifyValue("AsgntName", txtAssignName, _assignName,driver);
		TextBox.verifyValue("AsgntDescribtion", txtDescrib, _assignDescr,driver);

	}

	//Description: Choose Chapter  in Select Resources screen
	public void chooseChapter(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>chooseChapter",driver);

		if(driver.findElement(By.xpath(strPaddinglistXpath)).isDisplayed()){
			driver.findElement(By.name("association"));
			WebElement select=driver.findElement(By.name("association"));    
			List<WebElement> allOptions = select.findElements(By.tagName("option"));
			allOptions.size(); 
			String _show10PerPage = dataMap.get("Showperpage10");
			Combobox.selectItemByValue("Showperpage10", drpShowPerPage, _show10PerPage,driver);
			Button.click("Go Button", gobtn,driver);
		}		
		Sync.waitForObject(driver, "Wait for Element", "xpath", strPaddinglistXpath);
	}

	//Description: Select resources displayed in Select Resources screen
	public void selectResources(Map<String,String> dataMap)throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectResources",driver);
		List<WebElement> listcheckbox = driver.findElements(By.xpath(strContentTableXpath+"//tr//input[@type='checkbox']"));
		listcheckbox.size();				
		for(int i=1;i<=listcheckbox.size();i++)
		{
			if((i==2 || i==3 || i==4)){
				WebElement checkboxclick = driver.findElement(By.xpath(strContentTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
				checkboxclick.click();
				Checkbox.isEnabled(checkboxclick, "Select Resource", driver);
				Checkbox.check("Select Resource", checkboxclick, driver);
			}
		}
		Button.click("NextButton", btnNext,driver);
		WebElement organizeResources = driver.findElement(By.xpath("//div[@class='title'][text()='3. Organize Resources']")); 
		Assert.assertTrue(organizeResources.getText().equals("3. Organize Resources"));
	}

	//Description: Select Organize Resources Screen
	public void organizeResources(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>organizeResources",driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr")).isDisplayed()){
			Button.click("NextButton", btnNext,driver);

		}			
	}

	//Description: Select Assign to class button
	public void selectAssignToClassButton(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectAssignToClass", driver);
		Button.click("Assign To Class" , btnAssigntoClass,driver);
	}

	//Description: Select Class from the Select Assign to class screen
	public void assigntoclass(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>assigntoclass",driver);	
		String strClassAssignment = dataMap.get("ClassName");			
		String strClassAssignmentXpath= "//table[@class='content-area']//tr[./td/b[.='"+strClassAssignment+"']]";
		if(Element.verify("Class", driver, "XPATH", strClassAssignmentXpath)){	
			WebElement classChecbox = driver.findElement(By.xpath(strClassAssignmentXpath+"//td/input[@type='checkbox']"));
			if(Checkbox.isUnchecked("Class Selection",classChecbox,driver )){		
				Checkbox.check("Class Selection", classChecbox,driver);
				Button.click("Submit Button", btnSubmit,driver);	

			}
		}		
	}

	//Description: Re-login as Instructor and selecting assignment list from Assignment page
	public void goToAssignmentList(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>goToAssignmentList",driver);

		if(optionME.isDisplayed()){		
			Select sel = new Select(optionME);
			sel.getOptions();
			sel.deselectAll();
			sel.selectByVisibleText("Me");
		}
		Button.click("Click Go", btnGo,driver);
	}

	//Description: Uncheck Display to Students Check box and click Next
	public void unselectDisplayStudentCheckbox(Map<String,String> dataMap) throws Exception {
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>unselectDisplayStudentCheckbox",driver);

		if (driver.findElement(By.id("ag_type3")).isEnabled()){	
			Radiobutton.select("Readings/Resources", rdobutton,driver);
		}

		if(driver.findElement(By.id("ag_descr1")).isDisplayed()){	
			if(Checkbox.isChecked("Display to Students", chkboxDisplay,driver)){
				Checkbox.unCheck("Display to Students", chkboxDisplay,driver);
			}
		}
		Button.click("NextButton", btnNext,driver);
	}

	//Description: Verify Description Assignment
	public void verifyDescribeAssignmentTab() throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyDescribeAssignmentTab",driver);
		WebElement selectResource = driver.findElement(By.xpath("//div[@class='title'][.='1. Describe Assignment']"));
		Assert.assertTrue(selectResource.getText().equals("1. Describe Assignment"));
	}

	//Description: Verify SelectQuestionscreen
	public void verifySelectResourcestab() throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifySelectResourcestab",driver);		
		WebElement selectResource = driver.findElement(By.xpath("//div[@class='title'][.='2. Select Resources']"));
		Assert.assertTrue(selectResource.getText().equals("2. Select Resources"));
	}

	//Description: Verify Organize and Score Questions Screen
	public void verifyOrganizeResourcesTab(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyOrganizeResourcesTab",driver);
		WebElement organizeResources = driver.findElement(By.xpath("//div[@class='title'][text()='3. Organize Resources']")); 
		Assert.assertTrue(organizeResources.getText().equals("3. Organize Resources"));

		if(driver.findElement(By.xpath("//table[contains(@class,'plain-table')]//tr")).isDisplayed()){
			ResultUtil.report("PASS", "Resource Table Displayed", driver);
		}					
	}

	//Description: Save and Exit the Edit Assignment Page
	public void saveAndExit(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>saveAndExit",driver);
		driver.findElement(By.xpath("//div[./a[@id='Save_and_Exit']]")).click();
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);
		Assert.assertEquals(alert.getText(),"Please confirm that the changes to this Assignment are acceptable before going forward. Editing this Assignment could take some time; please be patient.");
		driver.switchTo().alert().accept();
	}

	//Description: Step 2 of Create/Edit Assignment Page in Select Question Screen Verifying the 10 questions displayed.
	public void selectTenResourcesPerPage(Map<String,String> dataMap)throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectTenResourcesPerPage",driver);

		if(driver.findElement(By.xpath("//td[contains(@class,'pagination-padding list-item-padding')]")).isDisplayed()){
			String _show10PerPage = dataMap.get("Showperpage10");
			Combobox.selectItemByValue("Showperpage10", drpShowPerPage, _show10PerPage,driver);
			Button.click("Go Button", gobtn,driver);	

		}			
	}

	//Description: Verifying 20 questions displayed
	public void selectTwentyResourcesPerPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectTwentyResourcesPerPage",driver);

		if(driver.findElement(By.xpath("//td[contains(@class,'pagination-padding list-item-padding')]")).isDisplayed()){
			String _show20PerPage = dataMap.get("Showperpage20");
			Combobox.selectItemByValue("Showperpage20", drpShowPerPage, _show20PerPage,driver);
			Button.click("Go Button", gobtn,driver);	

		}			
	}

	//Description: Verifying 30 question displayed
	public void selectThirtyResourcesPerPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectThirtyResourcesPerPage",driver);

		if(driver.findElement(By.xpath(strPlainTableXpath)).isDisplayed()){
			String _show30PerPage = dataMap.get("Showperpage30");
			Combobox.selectItemByValue("Showperpage30", drpShowPerPage, _show30PerPage,driver);
			Button.click("Go Button", gobtn,driver);	

		}	
	}

	//Description: Verifying 50 question displayed
	public void selectFiftyResourcesPerPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectFiftyResourcesPerPage",driver);

		if(driver.findElement(By.xpath(strPlainTableXpath)).isDisplayed()){
			String _show50PerPage = dataMap.get("Showperpage50");
			Combobox.selectItemByValue("Showperpage50", drpShowPerPage, _show50PerPage,driver);
			Button.click("Go Button", gobtn,driver);	

		}	
	}		

	//Description: Verifying 100 question displayed
	public void selectHundredResourcesPerPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectHundredResourcesPerPage",driver);
		if(driver.findElement(By.xpath(strPlainTableXpath)).isDisplayed()){

			String _show100PerPage = dataMap.get("Showperpage100");
			Combobox.selectItemByValue("Showperpage100", drpShowPerPage, _show100PerPage,driver);
			Button.click("Go Button", gobtn,driver);

		}	
	}

	//Description: Verifying All question displayed
	public void selectAllResourcesPerPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectAllResourcesPerPage",driver);

		if(driver.findElement(By.xpath(strPlainTableXpath)).isDisplayed()){
			String _showAllPerPage = dataMap.get("ShowperpageAll");
			Combobox.selectItemByValue("ShowperpageAll", drpShowPerPage, _showAllPerPage,driver);
			Button.click("Go Button", gobtn,driver);	

		}	
	}

	//Description: Verifying size of the table
	public void verifySizeOfTable() throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifySizeOfTable",driver);
		List<WebElement> getCountdisplayed = driver.findElements(By.xpath(strContentTableXpath+"//tr"));
		getCountdisplayed.size();
		WebElement learnObjectives = driver.findElement(By.xpath("//td[.='Resources Associated with Study Objective:']"));
		ResultUtil.report("PASS", learnObjectives.getText(), driver);
	}

	//Description: Clicking save and find button
	public void selectSaveAndFindButton() throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectSaveAndFindButton",driver);
		Button.click("Save and Find More Questions", btnSaveAndFind,driver);
	}

	//Description: Step2: Verify the Chapter Menu present from the list
	public void verifyChapterMenuPresent(Map<String,String> dataMap)throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyChapterMenuPresent",driver);

		if(driver.findElement(By.xpath(strPaddinglistXpath)).isDisplayed()){
			List<WebElement> chapter = driver.findElements(By.xpath(strPaddinglistXpath+"//tr//select[@name='association']"));
			for(WebElement list:chapter ){
				ResultUtil.report("PASS", list.getText(), driver);
			}	
		} else{
			ResultUtil.report("FAIL", "Chapter Menu Absent", driver);
		}
	}

	//Description: Verify the level Menu present from the list
	public void verifyResourceMenuPresent(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyResourceMenuPresent",driver);

		if(driver.findElement(By.xpath(strPaddinglistXpath)).isDisplayed()){
			List<WebElement> Resource = driver.findElements(By.xpath(strPaddinglistXpath+"//tr//select[@name='category']"));
			for(WebElement list:Resource ){
				ResultUtil.report("PASS", list.getText(), driver);
			}	
		}else{
			ResultUtil.report("FAIL", "Resource Menu Absent", driver);
		}	
	}

	//Description: Verify Source Menu present from the list
	public void verifySourceMenu(Map<String,String> dataMap)throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifySourceMenu",driver);

		if(driver.findElement(By.xpath(strPaddinglistXpath)).isDisplayed()){
			List<WebElement> source = driver.findElements(By.xpath(strPaddinglistXpath+"//tr//select[@name='owner']"));
			for(WebElement list:source ){
				ResultUtil.report("PASS", list.getText(), driver);
			}
		}
	}

	//Description: Select Chapter from the list and verify the table
	public void selectSingleChapter(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectSingleChapter",driver);
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
		for(WebElement list:chapter ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.deselectAll(list, "Chapter List", driver);
			Listbox.selectItemByIndex("Chapter List", list, 2, driver);			
		}
		Button.click("Go Button", gobtn,driver);
		String strQuestionChapter=dataMap.get("QuestionChapter");
		String strQuestionChapterXpath= "//table[contains(@class,'plain-table')]//tr//td[.='"+strQuestionChapter+"']";
		Sync.waitForObject(driver, "Wait for Element", "xpath", strQuestionChapterXpath);	

		driver.findElements(By.xpath(strQuestionChapterXpath));
		Combobox.isEnabled(drpLearningObjectives,"LearningObjectives",driver);
		Button.click("Find more Resources", btnSaveAndFind,driver);	
	}

	//Description: Select Source from the list and verify the table
	public void selectSingleSource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectSingleSource",driver);
		List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
		for(WebElement listsource:source ){
			ResultUtil.report("MESSAGE", listsource.getText(), driver);
			Listbox.deselectAll(listsource, "Source List", driver);
			Listbox.selectItemByIndex("Source List", listsource, 3, driver);
		}
		Button.click("Go Button", gobtn,driver);
		String ResourceSource = dataMap.get("AssignmentSource");
		Sync.waitForObject(driver, "Wait for Element", "xpath", strContentTableXpath);
		driver.findElements(By.xpath(strContentTableXpath+"//tr//td[.='"+ResourceSource+"']"));
		Combobox.isEnabled(drpLearningObjectives,"Learning Objectives",driver);
		Button.click("Find more Resources", btnSaveAndFind,driver);
	}

	//Description:Select resource from the list and verify the table
	public void selectSingleResource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectSingleResource",driver);
		List<WebElement> resource = driver.findElements(By.xpath("//tr//select[@name='category']"));
		for(WebElement listresource:resource ){
			ResultUtil.report("MESSAGE", listresource.getText(), driver);
			Listbox.deselectAll(listresource, "ReSource List", driver);
			Listbox.selectItemByIndex("reSource List", listresource, 0, driver);
		}
		Button.click("Go Button", gobtn,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", strContentTableXpath);	
		driver.findElements(By.xpath(strContentTableXpath+"//tr//td[.='All Resource Types']"));
		Combobox.isEnabled(drpLearningObjectives,"Learning Objectives",driver);
		Button.click("Find more Resources", btnSaveAndFind,driver);
	}

	//Description: Select Chapter, resource and Source from the list and verify the table
	public void selectSingleChapterSingleResourceSingleSource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectSingleChapterSingleResourceSingleSource",driver);
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
		for(WebElement list:chapter ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.deselectAll(list, "ReSource List", driver);
			Listbox.selectItemByIndex("reSource List", list, 0, driver);			
		}
		List<WebElement> Resource = driver.findElements(By.xpath("//tr//select[@name='category']"));
		for(WebElement listResource:Resource ){
			ResultUtil.report("MESSAGE", listResource.getText(), driver);
			Listbox.deselectAll(listResource, "ReSource List", driver);
			Listbox.selectItemByIndex("reSource List", listResource, 1, driver);
		}
		List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
		for(WebElement listsource:source ){
			ResultUtil.report("MESSAGE", listsource.getText(), driver);
			Listbox.deselectAll(listsource, "Source List", driver);
			Listbox.selectItemByIndex("Source List", listsource, 3, driver);
		}
		Button.click("Go Button", gobtn,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", strPlainTableXpath);	
		String ResourceSource = dataMap.get("AssignmentSource");
		driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+ResourceSource+"']"));
		Button.click("Find more Resources", btnSaveAndFind,driver);	
	}

	//Description: Select Chapter, Resource and Source from the list and Select Learn Objective from the dropdown
	public void SelectLearningObjective(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>SelectLearningObjective",driver);
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
		for(WebElement list:chapter ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.deselectAll(list, "ReSource List", driver);
			Listbox.selectItemByIndex("reSource List", list, 0, driver);

		}
		List<WebElement> Resource = driver.findElements(By.xpath("//tr//select[@name='category']"));
		for(WebElement listResource:Resource ){
			ResultUtil.report("MESSAGE", listResource.getText(), driver);
			Listbox.deselectAll(listResource, "ReSource List", driver);
			Listbox.selectItemByIndex("reSource List", listResource, 1, driver);
		}
		List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
		for(WebElement listsource:source ){
			ResultUtil.report("MESSAGE", listsource.getText(), driver);
			Listbox.deselectAll(listsource, "Source List", driver);
			Listbox.selectItemByIndex("Source List", listsource, 3, driver);
		}
		Button.click("Go Button", gobtn,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", strPlainTableXpath);	
		String ResourceSource = dataMap.get("AssignmentSource");
		driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+ResourceSource+"']"));
		Combobox.isEnabled(drpLearningObjectives,"Learning Objectives",driver);
		Combobox.selectItemByIndex("Learning Objective", drpLearningObjectives, 3,driver);
		Button.click("Go Button", btnLearningObjective,driver);

		driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='"+ResourceSource+"']"));
		Button.click("Find more Resources", btnSaveAndFind,driver);
	}

	//Description: Select Back button Navigate to Select Questions screen
	public void selectBackButtonNavigate(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectBackButtonNavigate",driver);
		Button.click("BackButton", btnBack,driver);				
	}

	//Description: Select Cancel button and navigate Assignment Page
	public void selectCancelButton(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectCancelButton",driver);
		Button.click("Cancel Button", btnCancel,driver);
	}

	//Description: Add some resources and click 'save and exit' button
	public void selectSaveAndExitButton(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectSaveAndExitButton",driver);
		Button.click("Save and Exit",btnSaveandExit,driver);				
	}

	//Description: click 'next' button
	public void SelectNextButton(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>SelectNextButton",driver);
		Button.click("Next", btnNext,driver);		
	}

	//Description: Create new assignment
	public void createNewAssignment(Map<String, String> dataMap) {
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>createNewAssignment",driver);
		Button.click("Create new assignment",btnCreatenewassignment,driver);			
	}

	//Description: Verify Page navigator after selecting the 
	public void verifyPageNavigator(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyPageNavigator",driver);
		Combobox.selectItemByIndex("PageNavigator1", drpdownPageNavigator, 0,driver);
		List<WebElement> listcheckbox = driver.findElements(By.xpath(strContentTableXpath+"//tr//input[@type='checkbox']"));
		listcheckbox.size();				
		for(int i=1;i<=listcheckbox.size();i++)
		{
			if((i==2 || i==3 || i==4))
			{
				WebElement checkboxclick = driver.findElement(By.xpath(strContentTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
				checkboxclick.click();
			}	
		}
		Combobox.selectItemByIndex("PageNavigator2", drpdownPageNavigator, 1,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", strContentTableXpath);				
		Combobox.selectItemByIndex("PageNavigator1", drpdownPageNavigator, 0,driver);	
	}

	//Description: Select All questions displayed in the list
	public void selectAllResources(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectAllResources",driver);
		Checkbox.check("CheckAll", chkboxCheckAllResources,driver);
		Button.click("NextButton", btnNext,driver);
	}

	//Description: UnCheck few question from the list
	public void unCheckResources() throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>unCheckResources",driver);
		int removecolumn;
		List<WebElement>scoreElement = driver.findElements(By.xpath("//tr"));
		for(int i=1;i<=scoreElement.size();i++)
		{
			List<WebElement> scorecolumn = driver.findElements(By.xpath(strContentTableXpath+"//tr["+i+"]/td"));
			for(int j=1;j<=scorecolumn.size();j++)
			{
				WebElement displayedscoretext = driver.findElement(By.xpath(strContentTableXpath+"//tr["+i+"]/td["+j+"]"));
			}        	
		}			
		scoreElement.size();
		int removeelement = (scoreElement.size())-2;
		if((scoreElement.size())==4){
			Button.click("NextButton", btnNext,driver);
		}
		else{
			removecolumn = rand.nextInt(removeelement);
			ResultUtil.report("MESSAGE", "Choosed remove column:"+removecolumn, driver);

			if(!(removecolumn==0 || removecolumn==1)){
				WebElement removelink = driver.findElement(By.xpath("//table[contains(@class,'plain-table')]//tr["+removecolumn+"]/td/input[@type='checkbox']"));
				removelink.click();
				Button.click("NextButton", btnNext,driver);
			}
			else{				
				if((removecolumn==0))
					removecolumn =removecolumn+2;
				if((removecolumn==1))
					removecolumn =removecolumn+1;
				WebElement removelink = driver.findElement(By.xpath("//table[contains(@class,'plain-table')]//tr["+removecolumn+"]/td/input[@type='checkbox']"));
				removelink.click();
			}
		}
	}

	//Describe: Uncheck All Questions from the list
	public void unCheckAllResources(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>unCheckAllResources",driver);
		if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllResources,driver)){
			Checkbox.check("CheckAll", chkboxCheckAllResources,driver);

			Checkbox.unCheck("CheckAll", chkboxCheckAllResources,driver);
		}
		else{
			Checkbox.unCheck("CheckAll", chkboxCheckAllResources,driver);
		}
	}

	//Describe: Verifying resource selection alert
	public void ResourceselectionAlert(){
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);	
		alert.accept();					
	}

	//Description: Verify select All checkbox in the question table
	public void selectAllResourcesCheckBox(Map<String,String> dataMap)throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectAllResourcesCheckBox",driver);

		if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllResources,driver)){
			Checkbox.check("CheckAll", chkboxCheckAllResources,driver);
		}

	}

	//Description: Uncheck question from the list
	public void unCheckResources(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>unCheckResources",driver);

		if(Checkbox.isChecked("CheckAll", chkboxCheckAllResources,driver)){
			Checkbox.unCheck("Uncheck", chkboxUncheck,driver);
		}

	}

	//Description: Select Question which is Unselected in previous step
	public void selectUnselectedResources(Map<String,String> dataMap) throws Exception {
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectUnselectedResources",driver);

		if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllResources,driver)){
			Checkbox.check("Uncheck", chkboxUncheck,driver);
		}
		Checkbox.isChecked("CheckAll", chkboxCheckAllResources,driver);
	}

	//Description: Navigate to next page of the question list and Click next button
	public void navigateToNextPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>navigateToNextPage",driver);

		if(Checkbox.isChecked("CheckAll", chkboxCheckAllResources,driver)){			
			Combobox.selectItemByIndex("Page 2", drpdownPageNavigator, 1,driver);			
		}
		Checkbox.isUnchecked("CheckAll", chkboxCheckAllResources,driver);	
	}

	//Description: Navigate to previous page to validate Select All Check box 
	public void navigateToPreviousPage(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>navigateToPreviousPage",driver);

		if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllResources,driver)){
			Combobox.selectItemByIndex("Page 1", drpdownPageNavigator, 0,driver);			
		}
	}

	//Description: Select one chapter one resource from the list
	public void selectOneChapterOneResource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectOneChapterOneResource",driver);
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
		for(WebElement list:chapter ){
			ResultUtil.report("PASS", list.getText(), driver);
			Listbox.selectItemByIndex("Level", list, 0,driver);
		}
		List<WebElement> resource = driver.findElements(By.xpath("//tr//select[@name='category']"));
		for(WebElement listresource:resource ){
			ResultUtil.report("Message", listresource.getText(), driver);
			Listbox.selectItemByIndex("Level", listresource, 1,driver);
		}
		Button.click("Go Button", gobtn,driver);

		List <WebElement> getCountdisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='Chapter 1. Accounting in Action']"));
		for(WebElement list:getCountdisplayed){
			list.getSize();
		}
		Button.click("Save and Find More Resources", btnSaveAndFind,driver);	
	}

	//Description: Select one chapter one source from the  list
	public void selectOneChapterOneSource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectOneChapterOneSource",driver);
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='association']"));
		for(WebElement list:chapter ){
			ResultUtil.report("Message", list.getText(), driver);
			Listbox.selectItemByIndex("Level", list, 0,driver);
		}
		List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));
		for(WebElement listsource:source ){
			ResultUtil.report("Message", listsource.getText(), driver);
			Listbox.selectItemByIndex("Level", listsource, 3,driver);
		}
		Button.click("Go Button", gobtn,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", strPlainTableXpath);	
		List<WebElement> getCountdisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='Chapter 1. Accounting in Action']"));
		for(WebElement list:getCountdisplayed){
			list.getSize();
		}
		Button.click("Save and Find More Resources", btnSaveAndFind,driver);
	}

	//Description: Select one source one chapter from the  list
	public void selectOneSourceOneResource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectOneSourceOneResource",driver);
		List<WebElement> source = driver.findElements(By.xpath("//tr//select[@name='owner']"));			
		for(WebElement listsource:source ){
			ResultUtil.report("Message", listsource.getText(), driver);
			Listbox.selectItemByIndex("Level", listsource, 3,driver);
		}
		List<WebElement> resource = driver.findElements(By.xpath("//tr//select[@name='category']"));
		for(WebElement listresource:resource ){
			ResultUtil.report("Message", listresource.getText(), driver);
			Listbox.selectItemByIndex("Level", listresource, 1,driver);	
		}
		Button.click("Go Button", gobtn,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", strPlainTableXpath);	
		List<WebElement> getCountdisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr//td[.='Student Resource']"));
		for(WebElement list:getCountdisplayed){
			list.getSize();
		}
		Button.click("Save and Find More Resources", btnSaveAndFind,driver);
	}

	//Description: Navigate to select resource tab
	public void navigateToSelectResourcesTab() throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>navigateToSelectResourcesTab",driver);
		WebElement selectResource = driver.findElement(By.xpath("//div[@class='title'][.='2. Select Resources']"));
		Button.click("Navigate To Select Resources Tab", selectResource ,driver);	
		Sync.waitForObject(driver, "Wait for Element", "xpath", "//div[@class='title'][.='2. Select Resources']");	
	}

	//Description:  Navigate to  Organize Resources tab
	public void navigateToOrganizeResourcesTab() throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>navigateToOrganizeResourcesTab",driver);
		WebElement organizeResources = driver.findElement(By.xpath("//div[@class='title'][text()='3. Organize Resources']")); 
		Button.click("Navigate To Organzie Resources Tab", organizeResources,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", "//div[@class='title'][text()='3. Organize Resources']");

	}

	//Description: Verify Selected Resources
	public void verifySelectedResources() throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>verifySelectedResources",driver);
		List<WebElement> listcheckbox = driver.findElements(By.xpath(strPlainTableXpath+"//tr//input[@type='checkbox']"));
		listcheckbox.size();				
		for(int i=1;i<=listcheckbox.size();i++)
		{
			if((i==2 || i==3 || i==4 ||i==5 ||i==6))
			{
				WebElement checkboxclick = driver.findElement(By.xpath(strPlainTableXpath+"//tr["+i+"]/td/input[@type='checkbox']"));
				ResultUtil.report("MESSAGE",checkboxclick.getText(), driver);	
			}
		}
	}

	//Description: navigate to describe assignment tab
	public void navigateToDescribeAssignmentTab() throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>navigateToDescribeAssignmentTab",driver);
		WebElement DescribeAssignment = driver.findElement(By.xpath("//div[@class='title'][.='1. Describe Assignment']"));
		Button.click("Navigate To Describe Assignment", DescribeAssignment,driver);
		Sync.waitForObject(driver, "Wait for Element", "xpath", "//div[@class='title'][.='1. Describe Assignment']");
	}

	//Description: click on do not share
	public void selectDoNotShare() throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>selectDoNotShare",driver);
		Radiobutton.select("Do not share with other instructors", rdiobutton,driver);
	}

	//Description: click on work in draft mode
	public void selectWorkInDraftMode() throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>selectWorkInDraftMode",driver);
		Radiobutton.select("Work in draft mode", radiobutton,driver);
	}

	//Description: verifying order
	public void verifyOrder(){
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>verifyOrder",driver);
		Combobox.isDisabled(order, "order",driver);
	}

	//Description: Verify Order of the questions
	public List<WebElement> verifyResourceOrder(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "createReadingsAssignmentPage>>>verifyResourceOrder",driver);
		List<WebElement> elmntResourceNames = new ArrayList<WebElement>();
		List<WebElement> elmntResourcesDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
		elmntResourcesDisplayed.size();
		for(int i=1;i<elmntResourcesDisplayed.size()-2;i++)
		{
			WebElement elmntResourceName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
			elmntResourceNames.add(elmntResourceName);
			ResultUtil.report("MESSAGE",elmntResourceName.getText(), driver);		
		}		
		return elmntResourceNames;
	}

	//Description: Check the possible value of the order like if 5 question are selected then order dropdown also should display 5
	public List<WebElement> checkPossibleValues(Map<String,String> dataMap) throws Exception{
		List<WebElement> elmntResourceNames = new ArrayList<WebElement>();
		List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
		elmntQuestionsDisplayed.size();
		for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++)
		{
			WebElement elmntResourceName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
			elmntResourceNames.add(elmntResourceName);
			ResultUtil.report("MESSAGE",elmntResourceName.getText(), driver);
		}		
		return elmntResourceNames;
	}

	//Description: Change Third Question order 3 to 1
	public void changeResourceOrder(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>changeResourceOrder",driver);
		List<WebElement> elmntQuestionNames = new ArrayList<WebElement>();
		List<WebElement> elmntQuestionsDisplayed = driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
		elmntQuestionsDisplayed.size();
		for(int i=1;i<elmntQuestionsDisplayed.size()-2;i++)
		{
			WebElement elmntQuestionName = driver.findElement(By.xpath(strPlainTableXpath+"//tr[./td[.//option]]["+i+"]//a[not(text()='Remove' or text()='Duplicate')]"));
			elmntQuestionNames.add(elmntQuestionName);
			ResultUtil.report("MESSAGE", elmntQuestionName.getText(), driver);

			if(i==3){					
				String strOrderValue = dataMap.get("ResourceOrder");
				Combobox.selectItemByValue("Order 1", elmntQuestionName, strOrderValue,driver);
				break;
			}
			else{
				ResultUtil.report("MESSAGE",elmntQuestionName.getText(), driver);
			}
		}			
	} 

	//Description: To remove all Resources
	public void removeAllResources(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>removeAllResources",driver);
		List<WebElement>resources=driver.findElements(By.xpath(strPlainTableXpath+"//tr"));
		int res=resources.size()-1;
		for(int i=1;i<=res;i++)
		{
			Link.click("Remove", removeAll,driver);
		}
	}

	//Description: To remove only one Resource
	public void removeOneResource(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>removeOneResource",driver);
		Link.click("Remove", remove,driver);

	}	           

	//Description: Assign Assignment Later
	public void AssignLater(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>AssignLater",driver);
		Button.click("Assign Later",btnAssignlater,driver);

	}

	//Description: Preview the Assignment
	public void PreviewAssignment(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>PreviewAssignment",driver);
		Button.click("Preview Assignment",btnPreviewAssign,driver);	
	}

	//Description: Select an Assignment to Class
	public void SelectAssignToClass(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>SelectAssignToClass",driver);
		Button.click("Assign To Class" , btnAssigntoClass,driver);		
	}

	//Description: Verify the Description of Assignment
	public void verifyAssignmentDescription(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>Confirmation>>verifyAssignmentDescription",driver);
		String strAssignXpath= "//table[2]//preceding-sibling::table//table";
		String assgnType=driver.findElement(By.xpath(strAssignXpath+"//tr[2]/td[3]")).getText();

		if(assgnType.equals("Readings/Resources")){
			ResultUtil.report("PASS", "The assignment type is Readings/Resources",driver);
		}
		else{
			ResultUtil.report("FAIL", "The assignment type is Readings/Resources",driver);
		}
		String assgnId=driver.findElement(By.xpath(strAssignXpath+"//tr[3]/td[3]")).getText();

		if(assgnId.equals(dataMap.get("AsgntID").trim())){
			ResultUtil.report("PASS", "The assignment ID" +assgnId+ "and" +dataMap.get("AsgntID")+ "are same",driver);
		}
		else{
			ResultUtil.report("FAIL", "The assignment ID is" +assgnId,driver);
		}
		String assgnName=driver.findElement(By.xpath(strAssignXpath+"//tr[4]/td[3]")).getText();

		if(assgnName.equals(dataMap.get("AsgntName").trim())){
			ResultUtil.report("PASS", "The assignment Name is" +assgnName+ "and" +dataMap.get("AsgntName")+ "are same",driver);
		}
		else{
			ResultUtil.report("FAIL", "The assignment Name is" +assgnName,driver);
		}
		String desc=driver.findElement(By.xpath(strAssignXpath+"//tr[5]/td[3]")).getText();

		if(desc.equals("Display to students ")){
			ResultUtil.report("PASS", "The display to students is checked",driver);
		}
		else{
			ResultUtil.report("FAIL", "The display to students is  not checked",driver);
		}
		String associatedwith=driver.findElement(By.xpath(strAssignXpath+"//tr[6]/td[3]")).getText();

		if(associatedwith.equals("Chapter 1. Accounting in Action")){
			ResultUtil.report("PASS", "The selected chapter is" +associatedwith,driver);
		}
		else{
			ResultUtil.report("FAIL", "Some other chapter is selected",driver);
		}
		String source=driver.findElement(By.xpath(strAssignXpath+"//tr[7]/td[3]")).getText();

		if(source.equals(dataMap.get("Source"))){
			ResultUtil.report("PASS", "The Source Name" +source+ "and" +dataMap.get("Source")+ "are same",driver);
		}
		else{
			ResultUtil.report("FAIL", "The Source Name" +source,driver);
		}
		String date=driver.findElement(By.xpath(strAssignXpath+"//tr[8]/td[3]")).getText();

		if(date.equals("September 12, 2013, 05:06 AM")){
			ResultUtil.report("PASS", "The created Date is" +date,driver);
		}
		else{
			ResultUtil.report("FAIL", "The created Date is" +date,driver);
		}
		String sharing=driver.findElement(By.xpath(strAssignXpath+"//tr[9]/td[3]")).getText();

		if(sharing.equals("Make available to other instructors")){
			ResultUtil.report("PASS", "The sharing policy selected is" +sharing,driver);
		}
		else{
			ResultUtil.report("FAIL", "The sharing policy selected is" +sharing,driver);
		}
	}

	//Description: Uncheck All Resources
	public void UnCheckAllResources(){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>UnCheckAllQuestion",driver);

		if(Checkbox.isUnchecked("CheckAll", chkboxCheckAllResources,driver)){
			Checkbox.check("CheckAll", chkboxCheckAllResources,driver);
			Checkbox.unCheck("CheckAll", chkboxCheckAllResources,driver);
		}
		else{
			Checkbox.unCheck("CheckAll", chkboxCheckAllResources,driver);
		}

		Alert alert = driver.switchTo().alert();
		ResultUtil.report("Message", alert.getText(), driver);			
		driver.switchTo().alert().accept();
	}

	//Description: Change Assignment Name and ID
	public void changeAssignmentNameAndId(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>changeAssignmentNameAndId",driver);
		TextBox.clearValue("Assignment ID", txtAssignId,driver);
		TextBox.enterValue("AssignmentID", txtAssignId, dataMap.get("NewAssginId"),driver);
		TextBox.clearValue("Assignment Name", txtAssignName,driver);
		TextBox.enterValue("Assignment Name", txtAssignName, dataMap.get("NewAssignName"),driver);
	}

	//Description: Verify the Sharing
	public void verifySharing(){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySharing",driver);
		Radiobutton.verify("Sharing RadioButton 1", sharingRdobtn1,driver);
		Radiobutton.isSelected("Sharing RadioButton 1", sharingRdobtn1,driver);
		Radiobutton.verify("Sharing RadioButton 2", sharingRdobtn2,driver);
		Radiobutton.verify("Sharing RadioButton 3", sharingRdobtn3,driver);
		String text1=sharingText1.getText();
		String cmptext1="Make available to other instructors";

		if(text1.equals(cmptext1)){
			ResultUtil.report("PASS", "Sharing text 1 is validated",driver);
		}
		String text2=sharingText1.getText();
		String cmptext2="Make available to other instructors";

		if(text2.equals(cmptext2)){
			ResultUtil.report("PASS", "Sharing text 1 is validated",driver);
		}
		String text3=sharingText1.getText();
		String cmptext3="Make available to other instructors";

		if(text3.equals(cmptext3)){
			ResultUtil.report("PASS", "Sharing text 1 is validated",driver);
		}	
	}

	//Description: Verify the Date
	public void verifyDate(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifyDate",driver);
		Radiobutton.select("Readings/Resources",rdobutton ,driver);
		WebElement date=driver.findElement(By.xpath("//td[starts-with(.,'Date')]//following-sibling::td[2]"));
		String Date=date.getText();
		ResultUtil.report("MESSAGE", Date, driver);
		SimpleDateFormat sdfDate = new SimpleDateFormat("M,dd,yyyy,HH:mm,aa");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		ResultUtil.report("MESSAGE", strDate, driver);

		if(Date==strDate){
			ResultUtil.report("MESSAGE", "Date is verified", driver);
		}
	}

	//Description: Verify the Source
	public void verifySource(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>verifySource",driver);
		WebElement source=driver.findElement(By.xpath("//td[starts-with(.,'Source')]//following-sibling::td[2]"));
		String Source=source.getText();
		String actualName=dataMap.get("ActualName");

		if(Source.equals(actualName)){
			ResultUtil.report("PASS", "The Source name is verified",driver);
		}
	}

	//Description: Update MyProfile
	public void MyProfile(Map<String,String> dataMap){
		Button.click("My Profile", myprofilebtn,driver);

		String modifyName=dataMap.get("ModifyName");
		TextBox.enterValue("LastName", lastName, modifyName,driver);	

		Button.click("Update", updateMyProfile,driver);		
	}

	//Description: Verify Modified Source
	public void verifyModifiedSource(Map<String,String> dataMap){
		WebElement source=driver.findElement(By.xpath("//td[starts-with(.,'Source')]//following-sibling::td[2]"));
		String Source=source.getText();
		String modifyName=dataMap.get("ModifyName");

		if(Source.equals(modifyName)){
			ResultUtil.report("PASS", "The Source name is verified",driver);
		}
	}

	//Description: Select Students access radio button
	public void AttemptsmarkedLate (Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>AttemptsmarkedLate",driver);
		String strClassAssignment = dataMap.get("ClassName");			
		String strClassCheckXpath= "//table[@class='content-area']//tr[./td/b[.='"+strClassAssignment+"']]";
		if(Element.verify("Class", driver, "XPATH", strClassCheckXpath)){
			WebElement classChecbox = driver.findElement(By.xpath(strClassCheckXpath+"//td/input[@type='checkbox']"));	

			if(Checkbox.isUnchecked("Class Selection",classChecbox,driver )){
				Checkbox.check("Class Selection", classChecbox,driver);

				Radiobutton.select("Attempts after due date will be marked late",radiobutton1,driver);
			}
			else{

				Radiobutton.select("Attempts after due date will be marked late",radiobutton1,driver);				
			}
			Button.click("submit",btnSubmit,driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			driver.close();
		}
	}	

	//Description: Select Class Status Chapter Source
	public void selectClassStatusChapterSource(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>selectClassStatusChapterSource",driver);
		List<WebElement> section = driver.findElements(By.xpath("//tr//select[@name='class']"));
		for(WebElement list:section ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.selectItemByIndex("Level", list, 1,driver);
		}
		List<WebElement> status = driver.findElements(By.xpath("//tr//select[@name='status']"));
		for(WebElement list:status ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.selectItemByIndex("Level", list, 1,driver);
		}
		List<WebElement> chapter = driver.findElements(By.xpath("//tr//select[@name='chapter']"));
		for(WebElement list:chapter ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.selectItemByIndex("Level", list, 1,driver);
		}
		List<WebElement> author = driver.findElements(By.xpath("//tr//select[@name='author']"));
		for(WebElement list:author ){
			ResultUtil.report("MESSAGE", list.getText(), driver);
			Listbox.selectItemByIndex("Level", list, 0,driver);
		}
		Button.click("Go Button", gobtn,driver);		
	}

	//Description: Access the view only Content	
	public void AccessViewOnly (Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>AccessViewOnly",driver);
		String strClassAssignment = dataMap.get("ClassName");			
		String strClassCheckXpath= "//table[@class='content-area']//tr[./td/b[.='"+strClassAssignment+"']]";
		if(Element.verify("Class", driver, "XPATH", strClassCheckXpath)){
			WebElement classChecbox = driver.findElement(By.xpath(strClassCheckXpath+"//td/input[@type='checkbox']"));

			if(Checkbox.isUnchecked("Class Selection",classChecbox,driver )){
				Checkbox.check("Class Selection", classChecbox,driver);

				Radiobutton.select("Yes view only",radiobutton2,driver);				
			}
			else{
				Radiobutton.select("Yes view only",radiobutton2,driver);				
			}
			Button.click("submit",btnSubmit,driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			driver.close();
		}
	}	

	//Description: Access view With Assistance
	public void AccessViewWithAssisstance(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>AccessViewWithAssisstance",driver);
		String strClassAssignment = dataMap.get("ClassName");			
		String strClassCheckXpath= "//table[@class='content-area']//tr[./td/b[.='"+strClassAssignment+"']]";
		if(Element.verify("Class", driver, "XPATH", strClassCheckXpath)){
			WebElement classChecbox = driver.findElement(By.xpath(strClassCheckXpath+"//td/input[@type='checkbox']"));

			if(Checkbox.isUnchecked("Class Selection",classChecbox,driver )){
				Checkbox.check("Class Selection", classChecbox,driver);

				Radiobutton.select("Yes view only",radiobutton3,driver);				
			}
			else{
				Button.click("Yes view only",radiobutton3,driver);
			}
			Button.click("submit",btnSubmit,driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			driver.close();
		}
	}	

	//Description: Verify the Student Access
	public void verifyStudentAccess(){
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>verifyStudentAccess",driver);
		Element.verify("Student Access after the Due Date ", driver, "xpath", strContentAreaXpath+"//tr[./td[.='Student Access after the Due Date:']]//following-sibling::tr[./td]");
		Radiobutton.select("Yes View only", radiobutton2,driver);
		Radiobutton.select("Yes. View With Assistance", radiobutton3,driver);
		Radiobutton.select("No", radiobutton4,driver);
		Radiobutton.select("Yes. Attempts after Due Date will be Marked Late", radiobutton1,driver);
	}

	//Description: No Access After Due Date
	public void NoAccessAfterDueDate(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>NoAccessAfterDueDate",driver);
		String strClassAssignment = dataMap.get("ClassName");			

		if(Element.verify("Class", driver, "XPATH", strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]")){
			WebElement classChecbox = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));	

			if(Checkbox.isUnchecked("Class Selection",classChecbox,driver )){
				Checkbox.check("Class Selection", classChecbox,driver);

				Radiobutton.select("Yes view only",radiobutton4,driver);
			}
			else{

				Radiobutton.select("Yes view only",radiobutton4,driver);				
			}
			Button.click("submit",btnSubmit,driver);
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			driver.close();	
		}
	}	

	//Description: Check All Class Section
	public void checkAllClassSection(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>checkAllClassSection",driver);
		String strAllSection = dataMap.get("AllClassSection");
		WebElement chkAllClassSection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strAllSection+"']]//td/input[@type='checkbox']"));
		Checkbox.check(strAllSection, chkAllClassSection,driver);
		String strClassAssignment = dataMap.get("ClassName");
		WebElement chkClassSelection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));
		Checkbox.isChecked(strClassAssignment, chkClassSelection,driver);
	}

	//Description: Uncheck All Class Section
	public void unCheckAllClassSection(Map<String,String>dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>unCheckAllClassSection",driver);
		String strAllSection = dataMap.get("AllClassSection");
		WebElement chkAllClassSection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strAllSection+"']]//td/input[@type='checkbox']"));
		Checkbox.unCheck(strAllSection, chkAllClassSection,driver);
		String strClassAssignment = dataMap.get("ClassName");
		WebElement chkClassSelection = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));
		Checkbox.isChecked(strClassAssignment, chkClassSelection,driver);
	}

	//Description: Uncheck Selected Class Section
	public List<WebElement> uncheckSelectedClassSection(Map<String,String>dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>uncheckSelectedClassSection",driver);
		List<WebElement> elemntClassselections= new ArrayList<WebElement>();
		List<WebElement> elemntClassList = driver.findElements(By.xpath(strContentAreaXpath+"//tr[./td/b]"));
		elemntClassList.size();
		for(int i=1; i<elemntClassList.size();i++){
			WebElement elemntClassselection= driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b]["+i+"]//td/input[@type='checkbox']"));
			elemntClassselections.add(elemntClassselection);

			if(Checkbox.isChecked("Class is Checked", elemntClassselection,driver)){
				Checkbox.unCheck("Class is unchecked", elemntClassselection,driver);
			}
		}
		return elemntClassselections;
	}

	//Description: Select Submit Button
	public void selectSubmitButton(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>selectSubmitButton",driver);
		driver.findElement(By.xpath("//div[./a[@id='Submit']]")).click();

	}

	//Description: Verify Alert Message Class Section
	public void verifyAlertMessageClassSection(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>verifyAlertMessageClassSection",driver);
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);
		driver.switchTo().alert().accept();
	}

	//Description: Close Window
	public void closeWindow(){
		driver.close();
	}      		

	//Description: Verify Current Date
	public void VerifyCurrentDate(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>VerifyCurrentDate",driver);
		WebElement currentDate = driver.findElement(By.xpath("//td//span[@class='textGrey']"));
		Element.verify("current Date", currentDate,driver);
		ResultUtil.report("MESSAGE", currentDate.getText(), driver);
	}

	//Description: Select the Review Progress
	public void selectReviewProgress(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>selectReviewProgress",driver);
		Button.click("Review Progress",reviewprogress,driver);
	}

	//Description: Verify the Assignment Type
	public void verifyAssignmentType(){
		ResultUtil.report("INFO", "CreateReadingsAssignment>>verifyRadioButton",driver);
		WebElement radioButton =driver.findElement(By.id("ag_type3"));

		if(radioButton.isSelected()){
			ResultUtil.report("PASS", "The radio button is selected", driver);
		}
		else{
			ResultUtil.report("FAIL", "The radio button is not selected", driver);
		}
	}

	//Description: Verify Description Scrolling
	public void verifyDescriptionScrolling(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "CreateReadingsAssignment>>>verifyLongDescription",driver);

		if(driver.findElement(By.xpath(strContentTableXpath+"//tr[4]/td[@class='label']")).isDisplayed()){
			String _longDescrib = dataMap.get("LongDescriptionscrolling");
			TextBox.enterValue("LongDescriptionscrolling", txtDescrib, _longDescrib,driver);
			TextBox.verifyValue("LongDescriptionscrolling", txtDescrib, _longDescrib,driver);
		}
	}

	//Description: Multi Select Source
	public void multiSelectSource(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>multiSelectSource", driver);
		WebElement sources = driver.findElement(By.xpath("//tr//select[@name='owner']"));
		String strSource= "All Resource Types";
		Listbox.selectItems("Select Multiple Source", sources, strSource, driver);
	}

	//Description: MultiSelect Resource
	public void multiSelectResource(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>multiSelectResource", driver);
		WebElement Resource = driver.findElement(By.xpath("//tr//select[@name='category']"));
		String strResource = "Instructor Resources";
		Listbox.deselectAll(Resource, "Deselect All", driver);
		Listbox.selectItems("Select Multiple Resources", Resource, strResource, driver);

	}

	//Description: Save And Find Resource
	public void saveAndFindResource(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>saveAndFindResource", driver);
		Button.click("Save and Find More Resources", btnSaveAndFind,driver);

	}

	//Description: Verify Alert Message in Assign Page
	public void verifyAlertMessageInAssignPage(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>verifyAlertMessageInAssignPage", driver);
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);		
		driver.switchTo().alert().accept();
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		driver.close();
	}

	//Description: Select Resource Name Triangle
	public void selectResourceNameTriangle(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>selectResourceNameTriangle", driver);
		WebElement quesName=driver.findElement(By.xpath(strContentTableXpath+"//tr[1]//td[2]//img"));
		Button.click("Question Name triangle", quesName, driver);

	}

	//Description: Verify Resource Name List
	public void verifyResourceNameList(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>verifyResourceNameList", driver);
		List<WebElement> tableList = driver.findElements(By.xpath(strContentTableXpath+"//tr"));
		int tableSize= tableList.size();
		for(int i=1;i<tableSize;i++){
			WebElement questionNameList = driver.findElement(By.xpath(strContentTableXpath+"//tr["+i+"]//td[2]"));
			ResultUtil.report("MESSAGE",questionNameList.getText(), driver);
		}
	}

	//Description: Select Resource File Type
	public void SelectResourceFileType(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>SelectResourceFileType", driver);
		WebElement quesAssist=driver.findElement(By.xpath(strContentTableXpath+"//tr[1]//td[4]//img"));
		Button.click("Question Assistance Triangle", quesAssist, driver);

	}

	//Description: Verify Resource File type
	public void verifyResourceFileType(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>verifyResourceFileType", driver);
		List<WebElement> tableList = driver.findElements(By.xpath(strContentTableXpath+"//tr"));
		int tableSize= tableList.size();
		for(int i=1;i<tableSize;i++){
			WebElement questionAssistanceList = driver.findElement(By.xpath(strContentTableXpath+"//tr["+i+"]//td[5]"));
			ResultUtil.report("MESSAGE",questionAssistanceList.getText(), driver);
		}
	}

	//Description: Select Associated Chapter Triangle
	public void selectAssociatedChapterTriangle(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>selectAssociatedChapterTriangle", driver);
		WebElement quesType=driver.findElement(By.xpath(strContentTableXpath+"//tr[1]//td[4]//img"));
		Button.click("Question Type Triangle", quesType, driver);

	}

	//Description: Verify Associated Chapter Triangle
	public void verifyAssociatedChapterTriangle(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>verifyAssociatedChapterTriangle", driver);
		List<WebElement> tableList = driver.findElements(By.xpath(strContentTableXpath+"//tr"));
		int tableSize= tableList.size();
		for(int i=1;i<tableSize;i++){
			WebElement questionTypeList = driver.findElement(By.xpath(strContentTableXpath+"//tr["+i+"]//td[4]"));
			ResultUtil.report("MESSAGE",questionTypeList.getText(), driver);
		}
	}

	public void verifyRemovelink(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>verifyRemovelink", driver);
		Element.verify("Remove",remove,driver);
	}

	public void checkPageNavigator(){
		ResultUtil.report("INFO", "CreateReadingsAssignmentPage>>>verifyRemovelink", driver);
		Element.verify("Paganavigator",drpdownPageNavigator,driver);
	}

}










