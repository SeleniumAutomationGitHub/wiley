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
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class SnapwizSubDomainPropertiesPage extends Initializer
{
	
	@FindBy(how = How.XPATH, using = "//input[@value='ORION']")
	private WebElement elmntOrionCheckbox;
	
	@FindBy(how = How.XPATH, using = "//a[@class='titlink' and text()='Course Details (Domains)']")
	private WebElement elmntCourseDetailsDomainLink;
	
	@FindBy(how = How.XPATH, using = "//input[@value='QUANTUM_TUTORS']")
	private WebElement elmntQuantumTutorsCheckbox;
	
	@FindBy(how = How.NAME, using = "submit")
	private WebElement btnSaveUpdate;
	
	public SnapwizSubDomainPropertiesPage(WebDriver driver){
		super(driver);
	}
	
	//Validate the orion tool option by default.
	public void  validateOrioToolProviderOptionByDefault()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>validateOrioToolProviderOptionByDefault", driver);
		switchDomainPropertiesTable();
		Element.verify("Disable orion text", driver.findElement(By.xpath("//td[text()='Disable ORION Integration:']")), driver);	
		Checkbox.isUnchecked("ORION CHECKBOX", elmntOrionCheckbox, driver);
	}

	//Click "Course details domain" link
	public SnapwizSubDomainPage gotoCoursesDetailsDomainLink()
	{		
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>gotoCoursesDetailsDomainLink", driver);
		Link.click("Course details domain", elmntCourseDetailsDomainLink, driver);
		return PageFactory.initElements(driver, SnapwizSubDomainPage.class); 
	}

	//Verify the check box is checked
	public void validateEnableIntegrationOption()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>validateEnableIntegrationOption", driver);
		ResultUtil.report("MESSAGE", "ALLDISABLED>Check", driver);
		switchDomainPropertiesTable();
		Element.verify("Disable orion text", driver, "XPATH", "//td[text()='Disable ORION Integration:']");
		Checkbox.isChecked("ORION INTEGRATION", elmntOrionCheckbox, driver);
	}
	
	//Verify the check box is unchecked
	public void validateDisableIntegrationOption()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>validateDisableIntegrationOption", driver);
		ResultUtil.report("MESSAGE", "ALLDISABLED>Check", driver);
		switchDomainPropertiesTable();
		Element.verify("Disable orion text", driver, "XPATH", "//td[text()='Disable ORION Integration:']");
		Checkbox.isUnchecked("ORION INTEGRATION", elmntOrionCheckbox, driver);
	}
	
	//Validate ORION tool checkbox is absent
	public void validateCheckboxDisplay()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>validateCheckboxDisplay", driver);
		ResultUtil.report("MESSAGE", "ALLDISABLED>Check", driver);
		switchDomainPropertiesTable();
		Element.notVerify("Disable orion text", driver, "XPATH", "//td[text()='Disable ORION Integration:']");
		Element.notVerify("Orion checkbox", driver, "XPATH", "//input[@value='ORION']");
	}
	
	//Get the domain URL
	public String getDomainURL(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>getDomainURL", driver);
		switchDomainPropertiesTable();
		WebElement elmntDomainURL = null;
		String strDomainXpath= "//table//tr[./td[.='Domain URI:']]/td[starts-with(text(),'http')]";
		if(Element.verify("Domain URL", driver, "XPATH", strDomainXpath))
		{
		elmntDomainURL=driver.findElement(By.xpath(strDomainXpath));
		dataMap.put("DomainURL", elmntDomainURL.getText());
		}
		return elmntDomainURL.getText();
	}
	
	//Switch to workframe
	public void switchDomainPropertiesTable()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "Userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "Workframe frame", "workframe", 6);
	}
	
	//Switch to course work frame
	public void switchDomainNameTable()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe frame", "mainframe", 6);
		Sync.waitForFrame(driver, "Userframe frame", "userframe", 6);
		Sync.waitForFrame(driver, "Workframe frame", "workframe", 6);
		Sync.waitForFrame(driver, "courseworkframe frame", "courseworkframe", 6);		
	}
	
	//Select several domain names if the orion checkbox is enabled
	public void selectSeveralDomainNamesOnEnableOrion(Map<String,String>dataMap)
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>selectSeveralDomainNamesOnEnableOrion", driver);
		switchDomainNameTable();	
		String strDomainNamesXpath= "//table//tbody[./tr/td]/tr[not(.//td[.//img])]";
		List<WebElement> elmntDomainNames = driver.findElements(By.xpath(strDomainNamesXpath));
		if(elmntDomainNames.size()>4)
		{
			for(int i=2;i<5;i++)
			{	
				try
				{
				//Switching to domain table
				switchDomainNameTable();			
				WebElement elmntDomainName = driver.findElement(By.xpath(strDomainNamesXpath+"["+i+"]//a[not(starts-with(text(),'dmn'))]"));
				Link.click("Domain name", elmntDomainName, driver);
				//Validating the checkbox is present and it is disabled
				validateOrioToolProviderOptionByDefault();			
				//Go back to course details domain link 
				gotoCoursesDetailsDomainLink();	
				}				
				catch(Exception e) {}
			}
		}
	}
		
	
	
	//Select several domain name is the orion checkbox is disabled
	public void selectSeveralDomainNamesOnDisableOrion(Map<String,String>dataMap)
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>selectSeveralDomainNamesOnDisableOrion", driver);		
		switchDomainNameTable();
		String strDomainNamesXpath= "//table//tbody[./tr/td]/tr[not(.//td[.//img])]";
		List<WebElement> elmntDomainNames = driver.findElements(By.xpath(strDomainNamesXpath));
		if(elmntDomainNames.size()>4)
		{			
			for(int i=2;i<5;i++)
			{
				try{
				WebElement elmntDomainName = driver.findElement(By.xpath(strDomainNamesXpath+"["+i+"]//a[not(starts-with(text(),'dmn'))]"));
				Link.click("Domain name", elmntDomainName, driver);			
				//Validating the checkbox is present and it is disabled
				validateCheckboxDisplay();			
				//Go back to course details domain link 
				gotoCoursesDetailsDomainLink();
				}
				catch(Exception e){}
			}
		}
	}
	
	//Disable "Quantum Tutors integration" in domain page
	public void disableQuantumTutors()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>disableQuantumTutors", driver);				
		if(Element.verify("Disable Quantum text", driver, "XPATH", "//td[text()='Disable Quantum Adaptive Learning and Assessment Integration:']"))
		{
			ResultUtil.report("PASS", "Disable Quatum option is displayed", driver);
			if(Checkbox.isChecked("Quantum Tutors", elmntQuantumTutorsCheckbox, driver))
			{	
				//Disable the quantum tutors
				Checkbox.unCheck("Uncheck Quantum tutors", elmntQuantumTutorsCheckbox, driver);
				ResultUtil.report("MESSAGE", "Quatum tutors checkbox ENABLE >> DISABLE", driver);				
			}
			else
			{
				ResultUtil.report("MESSAGE", "Quatum tutors checkbox is in DISABLED state", driver);
			}
		}
		else
		{
			ResultUtil.report("MESSAGE", "Disable Quatum option is NOT displayed", driver);
		}
	}
	
	//Disable the orion domain
	public void disableOrionDomain()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>disableOrionDomain", driver);
		
		if(Element.verify("Disable Orion text", driver, "XPATH", "//td[text()='Disable ORION Integration:']"))
		{
			ResultUtil.report("PASS", "Disable ORION option is displayed", driver);
			if(Checkbox.isChecked("ORION Checkbox", elmntOrionCheckbox, driver))
			{	
				//Disable the quantum tutors
				Checkbox.unCheck("Uncheck ORION tutors", elmntOrionCheckbox, driver);
				ResultUtil.report("MESSAGE", " ORION checkbox ENABLE >> DISABLE", driver);				
			}
			else
			{
				ResultUtil.report("MESSAGE", "ORION checkbox is in DISABLED state", driver);
			}
		}
		else
		{
			ResultUtil.report("FAIL", "Disable ORION is NOT displayed", driver);
		}
	}
	
	//Save settings in domains properties page
	public void saveSettings()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>saveSettings", driver);
		Button.click("Save/Update", btnSaveUpdate, driver);
	}
	
	public void activeClassValidation()
	{
		ResultUtil.report("INFO", "SnapwizSubDomainPropertiesPage>activeClassValidation", driver);		
		List<WebElement> activeClasses  = driver.findElements(By.xpath("//span[contains(.,'(started)')]")); 
		if(activeClasses.size()==1)
		{
			ResultUtil.report("PASS", "Precondition: Only one active class is displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Precondition: More than one active class is displayed", driver);
		}
	}
}
