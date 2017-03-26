package Pages.SnapwizIntegration;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Pages.Common.SnapwizLogoutPage;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class CoursePropertiesPage extends Initializer
{	
	@FindBy(how = How.XPATH, using = "//tr[.//div[text()='Enable ORION']]//tr[.//div[@id='existing_default_statusORION']]/td/a")
	private WebElement elmntOrionCurrentModifyLink;
	
	@FindBy(how = How.XPATH, using = "//tr[.//div[@id='new_default_statusORION']]/td/a")
	private WebElement elmntOrionDefaultModifyLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Update']")
	private WebElement elmntCourseMappingIDUpdateLink;
	
	@FindBy(how = How.XPATH, using = "//input[@id='modifyExistingDomainsRadioEnabledORION']")
	private WebElement elmntCurrentOrionEnableButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='modifyExistingDomainsRadioDisabledORION']")
	private WebElement elmntCurrentOrionDisableButton;
		
	@FindBy(how = How.XPATH, using = "//input[@id='modifyNewDomainsRadioEnabledORION']")
	private WebElement elmntDefaultOrionEnableButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='modifyNewDomainsRadioDisabledORION']")
	private WebElement elmntDefaultOrionDisableButton;
	
	@FindBy(how = How.XPATH, using = "//tr[@id='modifyExistingDomainsBlockORION']//input[@type='button' and @value='Update']")
	private WebElement elmntOrionCurrentUpdateButton;
	
	@FindBy(how = How.XPATH, using = "//tr[@id='modifyExistingDomainsBlockORION']//input[@type='button' and @value='Cancel']")
	private WebElement elmntOrionCurrentCancelButton;
	
	@FindBy(how = How.XPATH, using = "//tr[@id='modifyNewDomainsBlockORION']//input[@type='button' and @value='Update']")
	private WebElement elmntOrionDefaultUpdateButton;
	
	@FindBy(how = How.XPATH, using = "//tr[@id='modifyNewDomainsBlockORION']//input[@type='button' and @value='Cancel']")
	private WebElement elmntOrionDefaultCancelButton;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Domains']")
	private WebElement elmntDomainSubTab;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Content Updates']")
	private WebElement elmntContentUpdatesSubTab;
	
	@FindBy(how = How.XPATH, using = "//input[@name='mapping']")
	private WebElement elmntCourseMappingBrowseBtn;	
	
	@FindBy(how = How.XPATH, using = "//input[@value='Upload']")
	private WebElement elmntCourseMappingUploadBtn;	
	
	@FindBy(how = How.NAME, using = "submit")
	private WebElement elmntsaveButton;
	
	@FindBy(how = How.ID, using = "show_work_chb")
	private WebElement checkAllowShowWork;
	
	@FindBy(how=How.XPATH, using="//input[@name='show_alter_answers_allowed']")
	private WebElement checkShowAlternativeAnswer;
	
	@FindBy(how = How.XPATH, using="//table//div[contains(.,'Multi')]/input")
	private WebElement multiVariableCalculus;
	
	@FindBy(how = How.XPATH, using= "//table//div[contains(.,'Chemistry')]/input")
	private WebElement chemistryTools;
	
	@FindBy(how = How.ID, using= "mappingFileLink")
	private WebElement lnkMappingLink;
	
	@FindBy(how = How.XPATH, using= "//tr[.//div[text()='Enable ORION']]/following-sibling::tr[.//tr/td//div[text()='Current State for Existing Domains: ']][1]//div[text()='Current State for Existing Domains: ']")
	private WebElement elmntOrionCurrentStateText;
	
	@FindBy(how = How.XPATH, using= "//tr[.//div[text()='Enable ORION']]/following-sibling::tr[.//tr/td//div[text()='Current State for Existing Domains: ']][2]//div[text()='Current State for Existing Domains: ']")
	private WebElement elmntQuantumCurrentStateText;
	
	@FindBy(how= How.XPATH, using="//table//tr//td[contains(text(),'duplicating algorithmic ')]//following-sibling::td/input")
	private WebElement duplicatingQuestions;
	
	public CoursePropertiesPage(WebDriver driver){
		super(driver);			
	}
	
	//Validating course properties page
	public void validateCourseProperties()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>validateCourseProperties", driver);
		switchFrameCoursePropertiesPage();		
		//validating hardcoded text - Integrated LTI Tool Providers
		Element.verify("//Strong[text()='Integrated LTI Tool Providers", driver.findElement(By.xpath("//Strong[text()='Integrated LTI Tool Providers']")), driver);
		
		//Validating checkbox with text - Orion +  text
		String strOrionXpath="//div[text()='Enable ORION']";
		String strOrionCheckboxXpath="//tr[.//div[text()='Enable ORION']]";
		Element.verify("Enable Orion text", driver.findElement(By.xpath(strOrionXpath)), driver);
		Element.verify("Enable Orion Checkbox", driver.findElement(By.xpath(strOrionCheckboxXpath+"//input[@value='ORION']")), driver);
		
		//Validating system status - ORION
		Element.verify("System status for ORION", driver.findElement(By.xpath(strOrionXpath+"/ancestor::tr[1]/following-sibling::tr[1]//div[text()='System Status: Available']")), driver);
		
		//Validating current status of ORION tool
		//Element.verify("Current state for Existing domains text", driver.findElement(By.xpath("//tr[.//div[text()='Enable ORION']]/following-sibling::tr[.//tr/td//div[text()='Current State for Existing Domains: ']][1]//div[text()='Current State for Existing Domains: ']")), driver);
		Element.verify("Current state for Existing domains text", elmntOrionCurrentStateText, driver);
		Element.verify("Status", driver.findElement(By.xpath("//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusORION']")), driver);
		Element.verify("Modify", driver.findElement(By.xpath(strOrionCheckboxXpath+"//tr[.//div[@id='existing_default_statusORION']]/td/a")), driver);
				
		//Validating  default  status of  ORION tool
		Element.verify("Default State for Newly Added Domains text", driver.findElement(By.xpath(strOrionCheckboxXpath+"//tr[.//tr/td//div[text()='Current State for Existing Domains: ']][1]//div[text()='Default State for Newly Added Domains: ']")), driver);
		Element.verify("Status", driver.findElement(By.xpath("//tr[.//tr/td//div[text()='Default State for Newly Added Domains: ']]//div[@id='new_default_statusORION']")), driver);
		Element.verify("Modify", driver.findElement(By.xpath("//tr[.//div[@id='new_default_statusORION']]/td/a")), driver);
				
		//Update link for ORION tool
		Element.verify("Update", driver.findElement(By.xpath("//a[text()='Update']")), driver);			
		
		//Course Mapping tool link
		Element.verify("Course mapping id", driver.findElement(By.xpath("//div[contains(text(),'Course ID Mapping:')]")), driver);
		Link.verify("Course mapping link", lnkMappingLink, driver);
		
		//Validating checkbox with text - Quantum Adaptive Learning and Assessment +  text
		Element.verify("Enable Quantum Adaptive Learning and Assessment ", driver.findElement(By.xpath("//div[text()='Enable Quantum Adaptive Learning and Assessment']")), driver);
		Element.verify("Enable Quantum Adaptive Learning and Assessment ", driver.findElement(By.xpath("//tr[.//div[text()='Enable Quantum Adaptive Learning and Assessment']]//input[@value='QUANTUM_TUTORS']")), driver);
		
		//Validating system status - Quantum Adaptive Learning and Assessment
		Element.verify("System status for Quantum Adaptive Learning and Assessment", driver.findElement(By.xpath("//div[text()='Enable Quantum Adaptive Learning and Assessment']/ancestor::tr[1]/following-sibling::tr[1]//div[text()='System Status: Available']")), driver);
	
	}
	
	//Enable the checkbox option
	public void enableOrionCheckboxOption()
	{		
		ResultUtil.report("INFO", "CoursePropertiesPage>enableOrionCheckboxOption", driver);
		switchFrameToworkframe();
		switchFrameCoursePropertiesPage();
		//Enable the ORION option to be selected
		String strOrionCheckboxXpath="//tr[.//div[text()='Enable ORION']]//input[@value='ORION']";
		if(Element.verify("Enable ORION", driver, "XPATH", strOrionCheckboxXpath))
		{
			if(Checkbox.isUnchecked("Enable ORION", driver.findElement(By.xpath(strOrionCheckboxXpath)), driver))
			{
				Checkbox.check("Enable ORION", driver.findElement(By.xpath(strOrionCheckboxXpath)), driver);
			}								
		}
		
		Checkbox.isChecked("Verify the checkbox is checked", driver.findElement(By.xpath(strOrionCheckboxXpath)), driver);
	}
	
	//Disable the checkbox option
	public void disableOrionCheckboxOption()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>disableOrionCheckboxOption", driver);
		switchFrameCoursePropertiesPage();
		//Enable the ORION option to be unselected
		String strOrionCheckboxXpath="//tr[.//div[text()='Enable ORION']]//input[@value='ORION']";
		if(Element.verify("Enable ORION", driver, "XPATH", strOrionCheckboxXpath))
		{
			if(Checkbox.isChecked("Enable ORION", driver.findElement(By.xpath(strOrionCheckboxXpath)), driver))
			{
				Checkbox.unCheck("Enable ORION", driver.findElement(By.xpath(strOrionCheckboxXpath)), driver);
				ResultUtil.report("MESSAGE", "ORION is disabled for the product", driver);
			}								
		}	
	}
	
	//Validating the current state settings of ORION ALL Enabled
	public void validateEnabledCurrentStateOrion()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>validateEnabledCurrentStateOrion", driver);
		String strCurrentStateXpath= "//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusORION']";
		if(Element.verify("Current State", driver, "XPATH", strCurrentStateXpath))
		{
			if(Element.verify("All Enable", driver.findElement(By.xpath(strCurrentStateXpath)), "All Enabled", driver))
			{
				ResultUtil.report("MESSAGE", "Current state for Exisiting domains is ALL ENABLED", driver);
			}
			else{
				changeOrionCurrentstateSettingsToEnable();
			}						
		}
	}
	
	//Validating the current state settings of ORION - ALL disabled
		public void validateDisabledCurrentStateOrion()
		{
			ResultUtil.report("INFO", "CoursePropertiesPage>validateDisabledCurrentStateOrion", driver);
			switchFrameCoursePropertiesPage();
			Sync.waitForSeconds(5, driver);
			String strCurrentStateXpath= "//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusORION']";
			if(Element.verify("Current State", driver, "XPATH", strCurrentStateXpath))
			{
				if(Element.verify("All Disable", driver.findElement(By.xpath(strCurrentStateXpath)), "All Disabled", driver))
				{
					ResultUtil.report("MESSAGE", "Current state for Exisiting domains is ALL DISABLED", driver);
				}
				else{
					changeOrionCurrentstateSettingsToDisable();
				}
			}
		}
	
	//Validating default state settings of ORION
	public void validateEnableDefaultStateOrion()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>validateEnableDefaultStateOrion", driver);
		switchFrameCoursePropertiesPage();
		String strDefaultStatXpath= "//tr[.//tr/td//div[text()='Default State for Newly Added Domains: ']]//div[@id='new_default_statusORION']";
		if(Element.verify("Default State", driver, "XPATH", strDefaultStatXpath))
		{
			if(Element.verify("Enabled", driver.findElement(By.xpath(strDefaultStatXpath)), "Enabled", driver))
			{
				ResultUtil.report("MESSAGE", "Default state for Exisiting domains is ENABLED", driver);
			}
			else{
				changeOrionDefaultSettingsToEnable();
			}						
		}
	}
	
	//Validating default state settings of ORION
	public void validateDisableDefaultStateOrion()
		{
			ResultUtil.report("INFO", "CoursePropertiesPage>validateDisableDefaultStateOrion", driver);
			String strDefaultStateXpath= "//tr[.//tr/td//div[text()='Default State for Newly Added Domains: ']]//div[@id='new_default_statusORION']";
			if(Element.verify("Default  State", driver, "XPATH", strDefaultStateXpath))
			{
				if(Element.verify("Disabled", driver.findElement(By.xpath(strDefaultStateXpath)), "Disabled", driver))
				{
					ResultUtil.report("MESSAGE", "Default state for Exisiting domains is  DISABLED", driver);
				}
				else{
					changeOrionDefaultSettingsToDisable();
				}
			}
		}
	
	//Change the current state settings to enable mode in ORION
	public void changeOrionCurrentstateSettingsToEnable()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>changeOrionCurrentstateSettingsToEnable", driver);
		String strCurrentStateXpath= "//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusORION']";
		if(Element.verify("Current State", driver, "XPATH", strCurrentStateXpath))
		{
			if(Element.verify("All Disable", driver.findElement(By.xpath(strCurrentStateXpath)), "All Disabled", driver))
			{
				ResultUtil.report("MESSAGE", "Current state for Exisiting domains is ALL DISABLED", driver);
				Link.click("Modify", elmntOrionCurrentModifyLink, driver);
				Radiobutton.select("Enabled", elmntCurrentOrionEnableButton, driver);
				Button.click("Update", elmntOrionCurrentUpdateButton, driver);
				ResultUtil.report("MESSAGE", "ALL DISABLED > ALL ENABLED", driver);
				//Validate the current status is ALL ENABLED
				Element.verify("Current state for Existing domains text", elmntOrionCurrentStateText, driver);
				Element.verify("ALL ENABLED", driver.findElement(By.xpath(strCurrentStateXpath)), "All Enabled", driver);
			}
		}
	}
	
	//Change the current state settings to disable mode in ORION
	public void changeOrionCurrentstateSettingsToDisable()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>changeOrionCurrentstateSettingsToDisable", driver);
		ResultUtil.report("MESSAGE", "Current state for Exisiting domains is ALL DISABLED", driver);
		String strCurrentStateXpath= "//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusORION']";
		if(Element.verify("Current State", driver, "XPATH", strCurrentStateXpath))
		{
			if(Element.verify("All Enable", driver.findElement(By.xpath(strCurrentStateXpath)), "All Enabled", driver))
			{
				ResultUtil.report("MESSAGE", "Current state for Exisiting domains is ALL ENABLED", driver);
				Link.click("Modify", elmntOrionCurrentModifyLink, driver);
				Radiobutton.select("Disabled", elmntCurrentOrionDisableButton, driver);
				Button.click("Update", elmntOrionCurrentUpdateButton, driver);
				ResultUtil.report("MESSAGE", "ALL ENABLED > ALL DISABLED", driver);
			}
		}
	}
	
	//Change the default settings to enable mode in ORION
	public void changeOrionDefaultSettingsToEnable()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>changeOrionDefaultSettingsToEnable", driver);
		String strDefaultXpath= "//tr[.//tr/td//div[text()='Default State for Newly Added Domains: ']]//div[@id='new_default_statusORION']";
		if(Element.verify("Current State", driver, "XPATH", strDefaultXpath))
		{
			if(Element.verify("Disable", driver.findElement(By.xpath(strDefaultXpath)), "Disabled", driver))
			{
				ResultUtil.report("MESSAGE", "Default  state for Exisiting domains is  DISABLED", driver);
				Link.click("Modify", elmntOrionDefaultModifyLink, driver);
				Radiobutton.select("Enabled", elmntDefaultOrionEnableButton, driver);
				Button.click("Update", elmntOrionDefaultUpdateButton, driver);
				ResultUtil.report("MESSAGE", "DISABLED >  ENABLED", driver);
			}
		}
	}
	
	//Change the default setting to diable mode in ORION
	public void changeOrionDefaultSettingsToDisable()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>changeOrionDefaultSettingsToDisable", driver);
		String strNewlyAddedXpath= "//tr[.//tr/td//div[text()='Default State for Newly Added Domains: ']]//div[@id='new_default_statusORION']";
		if(Element.verify("Current State", driver, "XPATH", strNewlyAddedXpath))
		{
			if(Element.verify("Enabled", driver.findElement(By.xpath(strNewlyAddedXpath)), "Enabled", driver))
			{
				ResultUtil.report("MESSAGE", "Default  state for Exisiting domains is  ENABLED", driver);
				Link.click("Modify", elmntOrionDefaultModifyLink, driver);
				Radiobutton.select("Enabled", elmntDefaultOrionDisableButton, driver);
				Button.click("Update", elmntOrionDefaultUpdateButton, driver);
				ResultUtil.report("MESSAGE", " ENABLED > DISABLED", driver);
			}
		}
	}	
	
	//Click Update link for course mapping id
	public void goToUpdateLink()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>goToUpdateLink", driver);
		switchFrameCoursePropertiesPage();
		Link.click("Update", elmntCourseMappingIDUpdateLink, driver);
	
	}
	
	//validate Course Mapping ID
	public void validateCourseMappingID()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>courseMappingIDUpdate", driver);
		switchFrameCoursePropertiesPage();
		Element.verify("CourseMappingID Popup", driver.findElement(By.id("mappingUploadORION")), driver);
		Sync.waitForFrame(driver, "frame index", 0, 6);
		Element.verify("Popup heading", driver.findElement(By.xpath("//strong[text()='Upload Course ID Mapping File']")), driver);
		Element.verify("File upload heading", driver.findElement(By.xpath("//table[@class='course-mapping-upload']//td[contains(text(),'File:')]")), driver);
		Element.verify("Course Mapping ID Upload btn", elmntCourseMappingUploadBtn, driver);
	}
	
	//Upload course mapping id
	public void uploadCourseMappingID(Map<String,String> dataMap, String strCourseMapPath) throws InterruptedException
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>uploadCourseMappingID", driver);
		//switchFrameCoursePropertiesPage();
		String strPathName = dataMap.get(strCourseMapPath);
		//Button.click("Browse", elmntCourseMappingBrowseBtn, driver);
		chooseFile(strPathName);
		if(Element.verify("Error", driver, "XPATH", "//span[text()='The mapping file is not valid XML. Please fix the issue and try again.']"))
		{
			ResultUtil.report("FAIL", "The mapping file is not valid XML. Please fix the issue and try again.", driver);
		}
		else
		{
			ResultUtil.report("PASS", "The mapping file is upload", driver);
		}
	}
	
	//Choose file functionality
	public void chooseFile(String strPathName) throws InterruptedException
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>chooseFile", driver);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(strPathName);
		Button.click("Click Upload", elmntCourseMappingUploadBtn, driver);
	}
	
	//Navigate to Domain(Sub) tab
	public SnapwizSubDomainPage gotoDomainSubTab()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>gotoDomainSubTab", driver);
		switchFrameCoursePropertiesSubTabs();
		Button.click("Domain (Sub tab)", elmntDomainSubTab, driver);
		return PageFactory.initElements(driver, SnapwizSubDomainPage.class);
	}
	
	//Navigate to Content Updates(Sub) tab
	public SnapwizCourseContentUpdatePage gotoContentUpdatesTab()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>gotoContentUpdatesTab", driver);
		switchFrameCoursePropertiesSubTabs();
		Button.click("Course Updates  (Sub tab)", elmntContentUpdatesSubTab, driver);
		return PageFactory.initElements(driver, SnapwizCourseContentUpdatePage.class);
	}

	//Save Settings
	public CoursePropertiesPage saveSettings()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>saveSettings", driver);
		switchFrameToworkframe();
		switchFrameCoursePropertiesPage();
		Button.click("Save",elmntsaveButton, driver);
		return PageFactory.initElements(driver, CoursePropertiesPage.class);
	}
	
	//goto Logout Page
	public SnapwizLogoutPage gotoLogoutPage()
	{
		return PageFactory.initElements(driver, SnapwizLogoutPage.class);
	}
	
	//Switch to courseworkframe
	public void switchFrameCoursePropertiesPage()
	{
		try
		{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame", "workframe", 6);
		Sync.waitForFrame(driver, "courseworkframe frame", "courseworkframe", 6);
		}
		catch(Exception e){}
	}

	//Switch to coursenav
	public void switchFrameCoursePropertiesSubTabs()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame", "workframe", 6);
		Sync.waitForFrame(driver, "coursenav frame", "coursenav", 6);
	}
	
	public void verifyAllowShowWorkFrame()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>>>verifyAllowShowWorkFrame", driver);
		switchFrameCoursePropertiesPage();		
		if(Checkbox.isChecked("Allow Show Work", checkAllowShowWork, driver)){			
			List<WebElement> showWorkTools = driver.findElements(By.xpath("//div[@id='radio-btn-holder']"));
			for(WebElement listTools: showWorkTools){				
				ResultUtil.report("Show List of Tools", listTools.getText(), driver);
			}
		}		
	}
	
	public void checkShowAlternativeAnswers()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>>>verifyAllowShowWorkFrame", driver);
		switchFrameCoursePropertiesPage();
		if(Checkbox.isChecked("Show Alternative Answers",checkShowAlternativeAnswer, driver)){
			Checkbox.unCheck("Show Alternative answer", checkShowAlternativeAnswer, driver);
		}
		else
		{
			Checkbox.check("Show Alternative answer", checkShowAlternativeAnswer, driver);
		}		
	}
	
	public void selectMultiVariableCalculusTools()
	{		
		ResultUtil.report("INFO", "CoursePropertiesPage>>>selectMultiVariableCalculusTools", driver);		
		Radiobutton.select("Multi-variable 	Calculus Tools", multiVariableCalculus, driver);		
	}
	
	public void selectChemistryTools()
	{		
		ResultUtil.report("INFO", "CoursePropertiesPage>>>selectChemistryTools", driver);		
		Radiobutton.select("Chemistry Tools", chemistryTools, driver);		
	}
	
	//Switch to workframe
	public void switchFrameToworkframe()
	{
		try
		{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "workframe frame", "workframe", 6);
		}
		catch(Exception e){}
	}
	
	//Validate master course properties status - new
	public void validateMasterPropertyStatus()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>>>validateMasterPropertyStatus", driver);
		Element.verify("Master course status", driver, "XPATH", "//span[contains(text(),'Master Course Properties Updated')]");
	}

	//Validate the current state is All Enabled by default
	public void validateCurrentStateEnabled(){
		ResultUtil.report("INFO", "CoursePropertiesPage>validateCurrentStateEnabled", driver);
		if(Element.verify("Current State All Enable", driver.findElement(By.xpath("//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusORION']")), "All Enabled", driver))
		{
			ResultUtil.report("PASS", "Current state for Exisiting domains is ALL ENABLED", driver);
		}
		else{
			ResultUtil.report("FAIL", "Current state for Exisiting domains is NOT ALL ENABLED", driver);
		}						
	}
	
	//Validate the default state is All Enabled by default
	public void validateDefaultStateEnabled(){
		ResultUtil.report("INFO", "CoursePropertiesPage>validateDefaultStateEnabled", driver);
		if(Element.verify("Enabled", driver.findElement(By.xpath("//tr[.//tr/td//div[text()='Default State for Newly Added Domains: ']]//div[@id='new_default_statusORION']")), "Enabled", driver))
		{
			ResultUtil.report("PASS", "Default state for Exisiting domains is ENABLED", driver);
		}
		else{
			ResultUtil.report("FAIL", "Default state for Exisiting domains is NOT ENABLED", driver);
		}						
	}
	
	//Verify Quatum tutors Mixed state
	public void validateQuatumTutorsMixed()
	{
		ResultUtil.report("INFO", "CoursePropertiesPage>validateQuatumTutorsMixed", driver);
		if(Element.verify("Current State All Enable", driver.findElement(By.xpath("//tr[.//tr/td//div[text()='Current State for Existing Domains: ']]//div[@id='existing_default_statusQUANTUM_TUTORS']")), "Mixed", driver))
		{
			ResultUtil.report("PASS", "Current state for Exisiting domains is MIXED", driver);
		}
		else{
			ResultUtil.report("FAIL", "Current state for Exisiting domains is NOT MIXED", driver);
		}
	}
	
	public void duplicatingAlgorthimicQuestion(){
		ResultUtil.report("INFO", "CoursePropertiesPage>>>duplicatingAlgorthimicQuestion", driver);
		
		switchFrameCoursePropertiesPage();
		if(Checkbox.isChecked("Duplicating Questions", duplicatingQuestions, driver)){
			
			ResultUtil.report("Message", "Duplicating Question Checkbox is Checked", driver);
		}else{
			Checkbox.check("Duplicating Questions", duplicatingQuestions, driver);
		}
		
	}
	
}
