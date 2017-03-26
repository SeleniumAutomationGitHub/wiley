package Pages.WPBlackboardIntegration;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Pages.Common.Initializer;
import Pages.CourseAdmin.ReInstructorLoginPage;
import Toolbox.Browser;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class LTIConfigurationPage extends Initializer
{	

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='LTI Configuration']")
	private WebElement elmntLTIConfigurationTab;

	@FindBy(how = How.ID, using = "lti-add-consumer-button")
	private WebElement elmntAddConsumerbtn;

	@FindBy(how = How.ID, using = "lti-consumer-list")
	private WebElement elmntTabledesign;

	@FindBy(how = How.ID, using = "lti-consumer-dialog-ok")
	private WebElement elmntConsumerOkbtn;

	@FindBy(how = How.ID, using = "lti-consumer-dialog-cancel")
	private WebElement elmntConsumerCancelbtn;

	@FindBy(how = How.ID, using = "lmsType")
	private WebElement elmntLMSTypeDropdown;

	@FindBy(how = How.ID, using = "consumerKey")
	private WebElement elmntConsumerKeyTextbox;

	@FindBy(how = How.ID, using = "consumerSecret")
	private WebElement elmntConsumerSecretTextbox;

	@FindBy(how = How.ID, using = "validTime")
	private WebElement elmntValidtimeTextbox;

	@FindBy(how = How.ID, using = "institutionName")
	private WebElement elmntInstitutuionNameTextbox;

	@FindBy(how = How.ID, using = "timeZone")
	private WebElement elmnttimeZoneDropdown;	

	@FindBy(how = How.ID, using = "adminFirstName")
	private WebElement elmntFirstnameTextbox;	

	@FindBy(how = How.ID, using = "adminLastName")
	private WebElement elmntLastnameTextbox;

	@FindBy(how = How.ID, using = "adminEmail")
	private WebElement elmntEmailTextbox;

	@FindBy(how = How.ID, using = "ficeCode")
	private WebElement elmntFicecodeTextbox;

	@FindBy(how = How.ID, using = "countryCode")
	private WebElement elmntcountryCodeTextbox;

	@FindBy(how = How.ID, using = "installationType")
	private WebElement elmntinstallationTypeDropdown;	

	@FindBy(how = How.XPATH, using = "//a[text()='LTI Configuration']")
	private WebElement elmntLTIConfigurationLink;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='Blackboard Consumers']")
	private WebElement elmntBlackBoardConsumersSubTab;

	@FindBy(how = How.XPATH, using = "//span[@class='pagetitle']")
	private WebElement txtLTIConfiguration;

	String strerrormessage="//div[@id='adminEmailError' and text()='Some symbol(s) you entered are not supported; please try again.']";
	String strIntegratedConsumertable="//table[@id='lti-consumer-list']/tbody[@id='lti-consumer-list-body']/tr";	
	String strParam = "/div[text()='Required parameter is missing or empty.']";

	public LTIConfigurationPage(WebDriver driver)
	{
		super(driver);
	}

	//Description:LTI Configurationm home page
	public void LTIConfigurationDefaultPage()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>LTIConfigurationDefaultPage", driver);
		switchFrameCourseListTable();
		Element.verify("LTI Configuration page", txtLTIConfiguration, "LTI Configuration", driver);		
	}

	//Description:Go to Blackboard consumers sub tab
	public LTIConfigurationBlackboardConsumersPage goToBlackboardConsumersSubTab()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToBlackboardConsumersSubTab", driver);
		switchFrameCourseListTable();
		Button.click("Blackboard consumers", elmntBlackBoardConsumersSubTab, driver);
		return PageFactory.initElements(driver, LTIConfigurationBlackboardConsumersPage.class);
	}

	//Description:Validate LTI configuration page - LTI sub tab
	public void validateLTIConfigurationGUIPage(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>validateLTIConfigurationGUIPage", driver);
		switchFrameCourseListTable();
		Sync.waitForObject(driver, "table List", "ID", "lti-consumer-list", 15);
		WebElement systemSettings=driver.findElement(By.xpath("//h3[text()='System Settings']"));

		//Hardcode text System settings
		Element.verify("System Settings",systemSettings, driver);

		//LTI url new hard code text
		Element.verify("New url hardcode text", driver.findElement(By.xpath("//dt[contains(text(),'new')]")), "LTI URL (new):", driver);

		//New url
		Element.verify("New URL", driver, "XPATH", "//dl[./dt[contains(text(),'new')]]/dd[contains(text(),'/edugen/imsblti/provider')]");

		//Old url hard code text
		Element.verify("Old url hardcode text", driver.findElement(By.xpath("//dt[contains(text(),'old')]")), "LTI URL (old):", driver);

		//Old url
		Element.verify("New URL", driver, "XPATH", "//dl[./dt[contains(text(),'old')]]/dd[contains(text(),'/edugen/blti')]");

		//Guest consumer key hardcode text
		Element.verify("Guest Consumer key", driver.findElement(By.xpath("//dt[text()='Guest Consumer Key:']")), driver);

		//WPguest text		
		Element.verify("wpguest", driver.findElement(By.xpath("//dl[./dt[text()='Guest Consumer Key:']]/dd[text()='wpguest']")), driver);		

		//Guest consumer secret hardcode text
		Element.verify("Guest consumer secret ", driver.findElement(By.xpath("//dt[text()='Guest Consumer Secret:']")), driver);

		//wp4gst text		
		Element.verify("wp4gst", driver.findElement(By.xpath("//dl[./dt[text()='Guest Consumer Secret:']]/dd[text()='WP4GST']")), driver);

		//Wiley consumer and notification text
		Element.verify("Wiley consumer and notification text ", driver.findElement(By.xpath("//dt[contains(text(),'Wiley Consumer Notification E-mail List:')]")), driver);

		//List is empty text
		Element.verify("List is empty ", driver.findElement(By.xpath("//div[text()='List is empty']")), driver);

		//Edit list text
		Element.verify("Edit list", driver.findElement(By.xpath("//a[text()='Edit List']")), driver);		

		//Integrated consumers text
		Element.verify("Integratyed consumers", driver.findElement(By.xpath("//h3[text()='Integrated Consumers']")), driver);

		//Total consumers
		Element.verify("Total Consumers", driver.findElement(By.xpath("//p[text()='Total consumers: ']")), driver);

		//Total consumers count
		Element.verify("Total consumers count", driver.findElement(By.xpath("//p[@class='total' and text()='Total consumers: ']/span")), driver);

		//Add Consumer button
		Element.verify("Add consumer button", elmntAddConsumerbtn, driver);

		//Verify table		
		Element.verify("validate the table presence", elmntTabledesign, driver);

		//Verify the table header
		Element.verify("LMS Type", driver.findElement(By.xpath("//th[text()='LMS Type']")), driver);
		Element.verify("Consumer Key", driver.findElement(By.xpath("//th[text()='Consumer Key']")), driver);
		Element.verify("Consumer secret", driver.findElement(By.xpath("//th[text()='Consumer Secret']")), driver);
		Element.verify("Time of validity", driver.findElement(By.xpath("//th[contains(text(),'Time of Validity')]")), driver);
		Element.verify("InstitutionName", driver.findElement(By.xpath("//th[text()='Institution Name']")), driver);
		Element.verify("Admin email", driver.findElement(By.xpath("//th[text()='Admin E-mail']")), driver);
		Element.verify("Actions", driver.findElement(By.xpath("//th[text()='Actions']")), driver);	

		//Count of total consumers vs table value
		List<WebElement> totalTablerows = driver.findElements(By.xpath(strIntegratedConsumertable));

		//Links in Action column
		Element.verify("View details link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[1]//a[contains(@href,'view_details')]")), driver);
		Element.verify("View details link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[1]//a[contains(@href,'view_domains')]")), driver);
		Element.verify("Edit link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[1]//a[@class='lms-update' and text()='Edit']")), driver);
		Element.verify("Delete", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[1]//a[@class='lms-delete' and text()='Delete']")), driver);
		Element.verify("Generate report", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[1]//span[contains(text(),'Generate')]")), driver);		
	}

	//Description:Click "Add New Consumers" button
	public void goToAddNewConsumers()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToAddNewConsumers", driver);
		switchFrameCourseListTable();
		Sync.waitForObject(driver, "Add consumer buttn", "ID", "lti-add-consumer-button",20);
		Button.click("Add New Consumer", elmntAddConsumerbtn, driver);
	}

	//Description:
	public void validateCreateNewConsumerGUI()
	{
		//Verify the title
		Element.verify("Navigation title", driver.findElement(By.xpath("//span[contains(text(),'Create New Consumer')]")), driver);

		//Specify consumer information
		Element.verify("Verify headin text", driver.findElement(By.xpath("//div[text()='Specify consumer information:']")), driver);

		//verify cancel and ok button
		Element.verify("Cancel", elmntConsumerCancelbtn, driver);
		Element.verify("Ok", elmntConsumerOkbtn, driver);		

		//Verify LMS type text
		Element.verify("LMS type text", driver.findElement(By.xpath("//label[text()='LMS Type:']")), driver);

		//verify LMS dropdown
		Element.verify("LMS type dropdown", elmntLMSTypeDropdown, driver);

		//Verify Consumer key text
		Element.verify("Consumer Key text", driver.findElement(By.xpath("//label[text()='Consumer Key ']")), driver);

		//Verify Consumer key textbox
		Element.verify("Consumer key textbox", elmntConsumerKeyTextbox, driver);

		//Verify Consumer Secret text
		Element.verify("Consumer secret text", driver.findElement(By.xpath("//label[text()='Consumer Secret ']")), driver);

		//Verify Consumer Secret textbox
		Element.verify("Consumer Secret textbox ", elmntConsumerSecretTextbox, driver);

		//Verify valididty  text
		Element.verify("Time of validity text", driver.findElement(By.xpath("//label[contains(text(),'Time of Validity')]")), driver);

		//Verify valididty  textbox 
		Element.verify("Validaity textbox", elmntValidtimeTextbox, driver);

		//Verify institutional name  text
		Element.verify("Institution name text", driver.findElement(By.xpath("//label[text()='Institution Name:']")), driver);

		//Verify institutional name  textbox 
		Element.verify("Institutional name", elmntInstitutuionNameTextbox, driver);

		//Verify time zone  text
		Element.verify("Time zone text", driver.findElement(By.xpath("//label[text()='Time Zone:']")), driver);

		//Verify Timezon dropdown
		Element.verify("Time zone", elmnttimeZoneDropdown, driver);

		//Verify first name  text
		Element.verify("Admin first name text", driver.findElement(By.xpath("//label[text()='Admin First Name:']")), driver);

		//Verify firstname textbox 
		Element.verify("Admin first name", elmntFirstnameTextbox, driver);

		//Verify last name  text
		Element.verify("Admin last name text", driver.findElement(By.xpath("//label[text()='Admin Last Name:']")), driver);

		//Verify last name  textbox
		Element.verify("Admin last name textbox", elmntLastnameTextbox, driver);

		//Verify Email  text
		Element.verify("Admin email text", driver.findElement(By.xpath("//label[text()='Admin E-mail:']")), driver);

		//Verify Email  textbox
		Element.verify("Email textbox", elmntEmailTextbox, driver);

		//Verify FICE code text
		Element.verify("Fice code text", driver.findElement(By.xpath("//label[text()='FICE Code ']")), driver);

		//Verify FICE code textbox
		Element.verify("FICE code textbox", elmntFicecodeTextbox, driver);

		//Verify Country text
		Element.verify("Country code  text", driver.findElement(By.xpath("//label[text()='Country Code ']")), driver);

		//Verify Country textbox
		Element.verify("Country code textbox", elmntcountryCodeTextbox, driver);

		//Verify installation text
		Element.verify("Installation type text", driver.findElement(By.xpath("//label[text()='Installation Type:']")), driver);

		//Verify installation dropdown
		Element.verify("Installation type", elmntinstallationTypeDropdown, driver);

		//Validate the LMS type dropdown
		ResultUtil.report("Report", "LMS Type dropdown", driver);
		Select selectLMSTYPE = new Select(elmntLMSTypeDropdown);
		List<WebElement> LMStypedropdownValue = selectLMSTYPE.getOptions();
		for(WebElement type:LMStypedropdownValue)
		{
			ResultUtil.report("LMS TYPE", type.getText(), driver);
		}

		//Validate installation type dropdown
		ResultUtil.report("Report", "Installation  dropdown", driver);
		Select selectInstallation = new Select(elmntinstallationTypeDropdown);
		List<WebElement> installationValue = selectInstallation.getOptions();
		for(WebElement type:installationValue)
		{
			ResultUtil.report("Installation  TYPE", type.getText(), driver);
		}

		//Validate the Time zone
		ResultUtil.report("Report", "Time zone", driver);
		Select selectTimeZone = new Select(elmnttimeZoneDropdown);
		List<WebElement> timeZoneValue = selectTimeZone.getOptions();
		for(WebElement type:timeZoneValue)
		{
			ResultUtil.report("Time zone  TYPE", type.getText(), driver);
		}

		//Verify the time zone default selected
		Combobox.selectItemByValue("GMT-05:00 Eastern Time", elmnttimeZoneDropdown, "GMT-05:00 Eastern Time", driver);

		//Verify the default FICE code
		TextBox.verifyValue("FICE Code	", elmntFicecodeTextbox, "B03302001", driver);

		//Verify the country code
		TextBox.verifyValue("Country code", elmntcountryCodeTextbox, "840", driver);

		//FICE code field
		Element.verify("Default FICE CODE Text", driver.findElement(By.xpath("//div[text()='Default FICE Code: B03302001 [WILEY LMS INTEGRATION]']")), driver);

		//Country code
		Element.verify("Country code Text", driver.findElement(By.xpath("//div[text()='Default Country Code: 840 [USA]']")), driver);		
	}

	//Description:Select Edit link on any consumer
	public void selectEditLink()
	{
		List<WebElement> totalTablerows = driver.findElements(By.xpath(strIntegratedConsumertable));
		for(int i=1;i<totalTablerows.size();i++)
		{
			Link.click("Edit", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr["+i+"]//a[@class='lms-update' and text()='Edit']")), driver);
			if(Element.verify("Edit consumer", driver, "XPATH", "//span[contains(text(),'Edit Consumer')]"))
			{
				break;
			}				
		}
	}

	//Description:Validate the Edit consumer GUI
	public void validateEditNewConsumerGUI()
	{

		Sync.waitForObject(driver, "table List", "ID", "lti-consumer-list", 15);

		//Verify the title
		Element.verify("Navigation title", driver.findElement(By.xpath("//span[contains(text(),'Edit Consumer')]")), driver);

		//Specify consumer information
		Element.verify("Verify headin text", driver.findElement(By.xpath("//div[text()='Specify consumer information:']")), driver);

		//verify cancel and ok button
		Element.verify("Cancel", elmntConsumerCancelbtn, driver);
		Element.verify("Ok", elmntConsumerOkbtn, driver);		

		//Verify LMS type text
		Element.verify("LMS type text", driver.findElement(By.xpath("//label[text()='LMS Type:']")), driver);

		//verify LMS dropdown
		Element.verify("LMS type dropdown", elmntLMSTypeDropdown, driver);

		//Verify Consumer key text
		Element.verify("Consumer Key text", driver.findElement(By.xpath("//label[text()='Consumer Key ']")), driver);

		//Verify Consumer key textbox
		Element.verify("Consumer key textbox", elmntConsumerKeyTextbox, driver);

		//Verify Consumer Secret text
		Element.verify("Consumer secret text", driver.findElement(By.xpath("//label[text()='Consumer Secret ']")), driver);

		//Verify Consumer Secret textbox
		Element.verify("Consumer Secret textbox ", elmntConsumerSecretTextbox, driver);

		//Verify valididty  text
		Element.verify("Time of validity text", driver.findElement(By.xpath("//label[contains(text(),'Time of Validity')]")), driver);

		//Verify valididty  textbox 
		Element.verify("Validaity textbox", elmntValidtimeTextbox, driver);

		//Verify institutional name  text
		Element.verify("Institution name text", driver.findElement(By.xpath("//label[text()='Institution Name:']")), driver);

		//Verify institutional name  textbox 
		Element.verify("Institutional name", elmntInstitutuionNameTextbox, driver);

		//Verify time zone  text
		Element.verify("Time zone text", driver.findElement(By.xpath("//label[text()='Time Zone:']")), driver);

		//Verify Timezon dropdown
		Element.verify("Time zone", elmnttimeZoneDropdown, driver);

		//Verify first name  text
		Element.verify("Admin first name text", driver.findElement(By.xpath("//label[text()='Admin First Name:']")), driver);

		//Verify firstname textbox 
		Element.verify("Admin first name", elmntFirstnameTextbox, driver);

		//Verify last name  text
		Element.verify("Admin last name text", driver.findElement(By.xpath("//label[text()='Admin Last Name:']")), driver);

		//Verify last name  textbox
		Element.verify("Admin last name textbox", elmntLastnameTextbox, driver);

		//Verify Email  text
		Element.verify("Admin email text", driver.findElement(By.xpath("//label[text()='Admin E-mail:']")), driver);

		//Verify Email  textbox
		Element.verify("Email textbox", elmntEmailTextbox, driver);

		//Verify FICE code text
		Element.verify("Fice code text", driver.findElement(By.xpath("//label[text()='FICE Code ']")), driver);

		//Verify FICE code textbox
		Element.verify("FICE code textbox", elmntFicecodeTextbox, driver);

		//Verify Country text
		Element.verify("Country code  text", driver.findElement(By.xpath("//label[text()='Country Code ']")), driver);

		//Verify Country textbox
		Element.verify("Country code textbox", elmntcountryCodeTextbox, driver);

		//Verify installation text
		Element.verify("Installation type text", driver.findElement(By.xpath("//label[text()='Installation Type:']")), driver);

		//Verify installation dropdown
		Element.verify("Installation type", elmntinstallationTypeDropdown, driver);

		//Validate the LMS type dropdown
		ResultUtil.report("Report", "LMS Type dropdown", driver);
		Select selectLMSTYPE = new Select(elmntLMSTypeDropdown);
		List<WebElement> LMStypedropdownValue = selectLMSTYPE.getOptions();
		for(WebElement type:LMStypedropdownValue)
		{
			ResultUtil.report("LMS TYPE", type.getText(), driver);
		}

		//Validate installation type dropdown
		ResultUtil.report("Report", "Installation  dropdown", driver);
		Select selectInstallation = new Select(elmntinstallationTypeDropdown);
		List<WebElement> installationValue = selectInstallation.getOptions();
		for(WebElement type:installationValue)
		{
			ResultUtil.report("Installation  TYPE", type.getText(), driver);
		}

		//Validate the Time zone
		ResultUtil.report("Report", "Time zone", driver);
		Select selectTimeZone = new Select(elmnttimeZoneDropdown);
		List<WebElement> timeZoneValue = selectTimeZone.getOptions();
		for(WebElement type:timeZoneValue)
		{
			ResultUtil.report("Time zone  TYPE", type.getText(), driver);
		}

		//Verify the time zone default selected
		Combobox.selectItemByValue("GMT-05:00 Eastern Time", elmnttimeZoneDropdown, "GMT-05:00 Eastern Time", driver);

		//Verify the synchronize checkbox is unchecked
		Checkbox.isUnchecked("Synchronize", driver.findElement(By.xpath("//div[contains(text(),'Synchronize all consumer domains')]/input")), driver);

		//Verify the default FICE code
		TextBox.verifyValue("FICE Code	", elmntFicecodeTextbox, "B03302001", driver);

		Element.verify("Default FICE CODE Text", driver.findElement(By.xpath("//div[text()='Default FICE Code: B03302001 [WILEY LMS INTEGRATION]']")), driver);

		//Verify the country code
		TextBox.verifyValue("Country code", elmntcountryCodeTextbox, "840", driver);

		//Country code
		Element.verify("Country code Text", driver.findElement(By.xpath("//div[text()='Default Country Code: 840 [USA]']")), driver);		

	}

	//Description:Back to LTI configuration - LTI sub tab
	public void goToLTIConfigurationLTISubTab()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToLTIConfiguration", driver);
		Sync.waitForFrame(driver, "Head Frame", "headframe", 3);
		Sync.waitForFrame(driver, "User Frame", "userframe", 3);
		Sync.waitForFrame(driver, "Work Frame", "workframe", 3);
		Link.click("LTI Configuration Link", elmntLTIConfigurationLink, driver);
		//Sync.waitForSeconds(9, driver);
	}

	//Description:Input Field Restriction - Clear Values
	public void noValueInputFieldrestriction(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>noValueInputFieldrestriction", driver);
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		String strConsumerSecret = dataMap.get("ValidConsumerSecret");
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");

		//Enter the textbox field 
		TextBox.enterValue("Consumer Key", elmntConsumerKeyTextbox, strConsumerKey, driver);
		TextBox.enterValue("Consumer Secret", elmntConsumerSecretTextbox, strConsumerSecret, driver);
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, strValidityTime, driver);
		TextBox.enterValue("FICE Code", elmntFicecodeTextbox, strFICECode, driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, strCountryCode, driver);

		//Clear the values
		TextBox.clearValue("Consumer Key", elmntConsumerKeyTextbox, driver);
		TextBox.clearValue("Consumer Secret", elmntConsumerSecretTextbox, driver);
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("FICE Code", elmntFicecodeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);

		//Enter Ok button
		Button.click("Ok", elmntConsumerOkbtn, driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", strParam))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Consumer Key error meesage", driver.findElement(By.xpath("//div[./input[@id='consumerKey']]"+strParam)), driver);
			Element.verify("Consumer Secret error meesage", driver.findElement(By.xpath("//div[./input[@id='consumerSecret']]"+strParam)), driver);
			Element.verify("Valid time error meesage", driver.findElement(By.xpath("//div[./input[@id='validTime']]"+strParam)), driver);
			Element.verify("FICE code  error meesage", driver.findElement(By.xpath("//div[./input[@id='ficeCode']]"+strParam)), driver);
			Element.verify("Country code error meesage", driver.findElement(By.xpath("//div[./input[@id='countryCode']]"+strParam)), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}
	}

	//Description:Input Field Restriction - Unique Parameter of existing consumers
	public void exisitingConsumerInputFieldRestriction(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>noValueInputFieldrestriction", driver);
		String strExisitingConsumerKey = dataMap.get("ExisitingConsumerKey");
		String strConsumerSecret = dataMap.get("ValidConsumerSecret");
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");

		//Enter the Exisitng consumer key value
		TextBox.enterValue("Consumer Key", elmntConsumerKeyTextbox, strExisitingConsumerKey, driver);
		TextBox.enterValue("Consumer Secret", elmntConsumerSecretTextbox, strConsumerSecret, driver);
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, strValidityTime, driver);
		TextBox.enterValue("FICE Code", elmntFicecodeTextbox, strFICECode, driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, strCountryCode, driver);

		//Enter Ok button
		Button.click("Ok", elmntConsumerOkbtn, driver);

		String strOne = "//div[text()='The consumer key is already used. Please choose another one.']";

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH",strOne ))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Consumer Key error meesage", driver.findElement(By.xpath(strOne)), driver);				
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Consumer Key", elmntConsumerKeyTextbox, driver);
		TextBox.clearValue("Consumer Secret", elmntConsumerSecretTextbox, driver);
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("FICE Code", elmntFicecodeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);
	}

	//Description:Input Field Restriction -Special characters
	public void specialCharactersInputFieldRestriction(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>specialCharactersInputFieldRestriction", driver);
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");

		//Enter the Special characters consumer key value
		TextBox.enterValue("Consumer Key", elmntConsumerKeyTextbox, "!@#$%^&*()><:1234ABC", driver);
		TextBox.enterValue("Consumer Secret", elmntConsumerSecretTextbox, "123DEC)(*&%^$@!@#", driver);
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, strValidityTime, driver);
		TextBox.enterValue("FICE Code", elmntFicecodeTextbox, strFICECode, driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, strCountryCode, driver);

		//Enter Ok button
		Button.click("Ok", elmntConsumerOkbtn, driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'Please edit the Consumer Key and try again.')]"))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Consumer Key error meesage", driver.findElement(By.xpath("//div[./input[@id='consumerKey']]/div[text()='The Consumer Key can contain alphanumerical symbols only.  Please edit the Consumer Key and try again.']")), driver);				
			Element.verify("Consumer Key error meesage", driver.findElement(By.xpath("//div[./input[@id='consumerSecret']]/div[text()='The Consumer Secret can contain alphanumerical symbols only.  Please edit the Consumer Key and try again.']")), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Consumer Key", elmntConsumerKeyTextbox, driver);
		TextBox.clearValue("Consumer Secret", elmntConsumerSecretTextbox, driver);
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("FICE Code", elmntFicecodeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);		
	}

	//Description:Input Field Restriction -Special characters in country code and validity time
	public void specialCharactersOtherInputFieldRestriction(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>specialCharactersOtherInputFieldRestriction", driver);

		String strConsumerKey = dataMap.get("ValidConsumerKey");
		String strConsumerSecret = dataMap.get("ValidConsumerSecret");
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");

		/*********************************Scenario 1: Value with characters*******************************************************/
		System.out.println("Scenario 1");
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "Test Validity time", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "Test country code", driver);

		//Enter Ok button
		Button.click("Ok", elmntConsumerOkbtn, driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again.')]"))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Validity time error meesage", driver.findElement(By.xpath("//div[./input[@id='validTime']]/div[text()='The Time of Validity can contain numeric symbols only. Please edit the Time of Validity and try again.']")), driver);				
			Element.verify("Country code", driver.findElement(By.xpath("//div[./input[@id='countryCode']]/div[text()='The Country Code can contain numeric symbols only. Please edit the Country Code and try again.']")), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);	

		/*********************************Scenario 2: Value with numeric values*******************************************************/		
		System.out.println("Scenario 2");
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "123456", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "123456", driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again.')]"))
		{			
			ResultUtil.report("PASS", "Error Message is displayed", driver);					
		}
		else
		{
			ResultUtil.report("FAIL", " No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);	

		/*********************************Scenario 3: Value with numeric values with 0*******************************************************/	
		System.out.println("Scenario 3");
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "0123456", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "0123456", driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again.')]"))
		{			
			ResultUtil.report("PASS", "Error Message is displayed", driver);					
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);	

		/***************************************************Scenario 4: Special characters*******************************************************/
		System.out.println("Scenario 4");
		//Scenario 4:
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "#$%@#$#", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "^&%^&%^&%", driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again.')]"))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Validity time error meesage", driver.findElement(By.xpath("//div[./input[@id='validTime']]/div[text()='The Time of Validity can contain numeric symbols only. Please edit the Time of Validity and try again.']")), driver);				
			Element.verify("Country code", driver.findElement(By.xpath("//div[./input[@id='countryCode']]/div[text()='The Country Code can contain numeric symbols only. Please edit the Country Code and try again.']")), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);	

		/*****************************************Scenario 5: decimal characters*******************************************************/
		System.out.println("Scenario 5");
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "1.25632", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "6.25365", driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again.')]"))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Validity time error meesage", driver.findElement(By.xpath("//div[./input[@id='validTime']]/div[text()='The Time of Validity can contain numeric symbols only. Please edit the Time of Validity and try again.']")), driver);				
			Element.verify("Country code", driver.findElement(By.xpath("//div[./input[@id='countryCode']]/div[text()='The Country Code can contain numeric symbols only. Please edit the Country Code and try again.']")), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);	

		/*****************************************Scenario 6: decimal characters*******************************************************/
		System.out.println("Scenario 6");
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "-698956", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "-2656633", driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again.')]"))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Validity time error meesage", driver.findElement(By.xpath("//div[./input[@id='validTime']]/div[text()='The Time of Validity can contain numeric symbols only. Please edit the Time of Validity and try again.']")), driver);				
			Element.verify("Country code", driver.findElement(By.xpath("//div[./input[@id='countryCode']]/div[text()='The Country Code can contain numeric symbols only. Please edit the Country Code and try again.']")), driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);	

		/*****************************************Clear all the values*******************************************************/
		//Clear the values
		TextBox.clearValue("Consumer Key", elmntConsumerKeyTextbox, driver);
		TextBox.clearValue("Consumer Secret", elmntConsumerSecretTextbox, driver);
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("FICE Code", elmntFicecodeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);		
	}

	//Description:Input Field restriction - Empty space
	public void emptySpaceCharacters()
	{
		//Enter the Exisitng consumer key value
		TextBox.enterValue("Consumer Key", elmntConsumerKeyTextbox, "   TestEmptySpace", driver);
		TextBox.enterValue("Consumer Secret", elmntConsumerSecretTextbox, "Empty Space Test      ", driver);
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, "       211111", driver);
		TextBox.enterValue("FICE Code", elmntFicecodeTextbox, "02525    ", driver);
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, "    063552", driver);

		//Enter Ok button
		Button.click("Ok", elmntConsumerOkbtn, driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", "//div[contains(text(),'try again')]"))
		{			
			ResultUtil.report("PASS", "Required parameter is missing or empty.", driver);
			Element.verify("Consumer Key error message", driver.findElement(By.xpath("//div[./input[@id='consumerKey']]/div[text()='The Consumer Key can contain alphanumerical symbols only.  Please edit the Consumer Key and try again.']")), driver);				
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
		}

		//Clear the values
		TextBox.clearValue("Consumer Key", elmntConsumerKeyTextbox, driver);
		TextBox.clearValue("Consumer Secret", elmntConsumerSecretTextbox, driver);
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);
		TextBox.clearValue("FICE Code", elmntFicecodeTextbox, driver);
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);
	}

	//Description:Validate the Email address format
	public void validateEmailAddressFormat(Map<String,String> dataMap, String strInvalidAddress)
	{

		String strEmailaddress = dataMap.get(strInvalidAddress);
		TextBox.enterValue("Email Address format", elmntEmailTextbox, strEmailaddress, driver);

		//Enter Ok button
		Sync.waitForObject(driver, "Consumer Ok button", "ID", "lti-consumer-dialog-ok", 15);
		Button.click("Ok", elmntConsumerOkbtn, driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", strerrormessage))
		{			
			ResultUtil.report("PASS", "Some symbol(s) you entered are not supported; please try again.']", driver);
			Element.verify("Email Address", driver.findElement(By.xpath(strerrormessage)), driver);				
			TextBox.clearValue("Email Address format", elmntEmailTextbox, driver);
		}
		else
		{
			ResultUtil.report("FAIL", "No Error Message is displayed", driver);
			TextBox.clearValue("Email Address format", elmntEmailTextbox, driver);
		}	

	}

	//Description:Add Consumers
	public void createAddConsumers(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>createAddConsumers", driver);
		String strLmsType = dataMap.get("LmsType");
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		String strConsumerSecret = dataMap.get("ValidConsumerSecret");
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strInstituteName = dataMap.get("InstitutionName");
		String strAdminFirstName = dataMap.get("AdminFirstName");
		String strAdminLastName = dataMap.get("AdminLastName");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");
		String strEmailAddress = dataMap.get("ValidTestEmailAddress");
		String strInstallationtype = dataMap.get("InstallationType");

		//Select LMS Type
		Combobox.selectItemByValue("DataMap LMS Type", elmntLMSTypeDropdown, strLmsType, driver);

		//Consumer Key
		TextBox.enterValue("Consumer Key", elmntConsumerKeyTextbox, strConsumerKey, driver);

		//Consumer Secret
		TextBox.enterValue("Consumer Secret", elmntConsumerSecretTextbox, strConsumerSecret, driver);

		//Validity time
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, strValidityTime, driver);

		//Institute Name
		TextBox.enterValue("Institute name", elmntInstitutuionNameTextbox, strInstituteName, driver);

		//Select time zone
		Combobox.selectRandomItem("Time zone", elmnttimeZoneDropdown, driver);

		//First name
		TextBox.enterValue("First name", elmntFirstnameTextbox, strAdminFirstName, driver);

		//Last Name
		TextBox.enterValue("Last Name", elmntLastnameTextbox, strAdminLastName, driver);

		//Email Address
		TextBox.enterValue("Email address", elmntEmailTextbox, strEmailAddress, driver);

		//FICE code
		TextBox.enterValue("FICE Code", elmntFicecodeTextbox, strFICECode, driver);

		//Country code
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, strCountryCode, driver);

		//Installation type
		Combobox.selectItemByValue("Installation type", elmntinstallationTypeDropdown, strInstallationtype, driver);
	}

	//Description:Created Integrated Consumer Table
	public void createdConsumerIntegratedTable(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>integratedConsumerTable", driver);
		String strLmsType = dataMap.get("LmsType");
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		String strConsumerSecret = dataMap.get("ValidConsumerSecret");
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strInstituteName = dataMap.get("InstitutionName");
		String strAdminFirstName = dataMap.get("AdminFirstName");
		String strAdminLastName = dataMap.get("AdminLastName");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");
		String strEmailAddress = dataMap.get("ValidTestEmailAddress");
		String strInstallationtype = dataMap.get("InstallationType");

		String[] strLmsTypes = strLmsType.split(" - ");
		String strLmsTypeShort = strLmsTypes[1].trim();

		//Count of total consumers vs table value
		List<WebElement> totalTablerows = driver.findElements(By.xpath(strIntegratedConsumertable));

		//Total consumers count
		Element.verify("Total consumers count", driver.findElement(By.xpath("//p[@class='total' and text()='Total consumers: ']/span")), driver);

		if(Element.verify("Consumer Table", driver, "XPATH", strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]")){
			ResultUtil.report("PASS", "Created Consumer is displayed in Integrated consumer table", driver);

			//LMS type			
			Element.verify("Lms Type", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[contains(text(),'"+strLmsTypeShort+"')]")), driver);

			//consumer key
			Element.verify("Consumer key", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strConsumerKey+"']")), driver);			

			//consumer secret
			Element.verify("Consumer Secret", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strConsumerSecret+"']")), driver);			

			//Time
			Element.verify("Time Validity", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strValidityTime+"']")), driver);			

			//Inst name
			Element.verify("Institution name", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strInstituteName+"']")), driver);			

			//admin email
			Element.verify("Admin email", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strEmailAddress+"']")), driver);			
		}
		else
		{
			ResultUtil.report("FAIL", "New Consumer is not created", driver);
		}
	}

	//Description:Click "Edit" link for newly created consumer
	public void goToEditLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToEditLink", driver);
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		Element.verify("Edit link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-update' and text()='Edit']")), driver);
		Link.click("Edit", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-update' and text()='Edit']")), driver);
	}

	//Description:Click "View Details" link for newly created consumer
	public void goToViewDetailsLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToViewDetailsLink", driver);
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		Element.verify("Edit link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[contains(@href,'view_details')]")), driver);
		Link.click("Edit", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[contains(@href,'view_details')]")), driver);
	}

	//Description:Click "Edit" link for edited consumer
	public void goToEditedConsumerEditLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToEditedConsumerEditLink", driver);
		String strConsumerKey = dataMap.get("EditValidConsumerKey");
		Element.verify("Edit link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-update' and text()='Edit']")), driver);
		Link.click("Edit", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-update' and text()='Edit']")), driver);
	}

	//Description:Click "Delete" Link
	public void goToDeleteLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToDeleteLink", driver);
		String strConsumerKey = dataMap.get("EditValidConsumerKey");
		Element.verify("Edit link", driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-delete' and text()='Delete']")), driver);

		if(Element.verify("Delete link", driver, "XPATH", "//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-delete' and text()='Delete']"))
		{			
			ResultUtil.report("PASS","Delete link clicked",driver);
			driver.findElement(By.xpath("//table[@id='lti-consumer-list']//tr[./td[text()='"+strConsumerKey+"']]//a[@class='lms-delete' and text()='Delete']")).click();
		}
		else
		{
			ResultUtil.report("FAIL","Delete link is not clicked",driver);
		}

	}

	//Description:Validate "View Details" link
	public void validateViewDetailsScreen()
	{
		//Auto Grade Refresh Status:
		Element.verify("Refresh status", driver.findElement(By.xpath("//td[text()='Auto Grade Refresh Status:']")), driver);
		Element.verify("Status", driver.findElement(By.xpath("//td[text()='Allowed' or text()='Blocked']")), driver);

		//Auto Grade Refresh, next scheduled run:
		Element.verify("Scheduled run", driver.findElement(By.xpath("//td[text()='Auto Grade Refresh, next scheduled run:']")), driver);

		//Auto Grade Refresh, frequency
		Element.verify("frequency", driver.findElement(By.xpath("//td[text()='Auto Grade Refresh, frequency:']")), driver);
	}

	//Description:
	public void validateCreatedConsumerValue(Map<String,String> dataMap)
	{
		String strLmsType = dataMap.get("LmsType");
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		String strConsumerSecret = dataMap.get("ValidConsumerSecret");
		String strValidityTime = dataMap.get("ValidTimeOfValidity");
		String strInstituteName = dataMap.get("InstitutionName");
		String strAdminFirstName = dataMap.get("AdminFirstName");
		String strAdminLastName = dataMap.get("AdminLastName");
		String strFICECode = dataMap.get("ValidFICECode");
		String strCountryCode = dataMap.get("ValidCountryCode");
		String strEmailAddress = dataMap.get("ValidTestEmailAddress");
		String strInstallationtype = dataMap.get("InstallationType");

		//Consumer Key
		TextBox.verifyValue("Consumer Key", elmntConsumerKeyTextbox, strConsumerKey, driver);

		//Consumer Secret
		TextBox.verifyValue("Consumer Secret", elmntConsumerSecretTextbox, strConsumerSecret, driver);

		//Validity time
		TextBox.verifyValue("Validity time", elmntValidtimeTextbox, strValidityTime, driver);

		//Institute Name
		TextBox.verifyValue("Institute name", elmntInstitutuionNameTextbox, strInstituteName, driver);

		//Select time zone
		//Combobox.selectRandomItem("Time zone", elmnttimeZoneDropdown);

		//First name
		TextBox.verifyValue("First name", elmntFirstnameTextbox, strAdminFirstName, driver);

		//Last Name
		TextBox.verifyValue("Last Name", elmntLastnameTextbox, strAdminLastName, driver);

		//Email Address
		TextBox.verifyValue("Email address", elmntEmailTextbox, strEmailAddress, driver);

		//FICE code
		TextBox.verifyValue("FICE Code", elmntFicecodeTextbox, strFICECode, driver);

		//Country code
		TextBox.verifyValue("Country code", elmntcountryCodeTextbox, strCountryCode, driver);

		//Installation type
		//Combobox.selectItemByValue("Installation type", elmntinstallationTypeDropdown, strInstallationtype);
	}
	//Description:
	public void editConsumer(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>createAddConsumers", driver);
		String strLmsType = dataMap.get("EditLmsType");
		String strConsumerKey = dataMap.get("EditValidConsumerKey");
		String strConsumerSecret = dataMap.get("EditValidConsumerSecret");
		String strValidityTime = dataMap.get("EditValidTimeOfValidity");
		String strInstituteName = dataMap.get("EditInstitutionName");
		String strAdminFirstName = dataMap.get("EditAdminFirstName");
		String strAdminLastName = dataMap.get("EditAdminLastName");
		String strFICECode = dataMap.get("EditValidFICECode");
		String strCountryCode = dataMap.get("EditValidCountryCode");
		String strEmailAddress = dataMap.get("EditValidTestEmailAddress");
		String strInstallationtype = dataMap.get("EditInstallationType");

		//Select LMS Type
		Combobox.selectItemByValue("DataMap LMS Type", elmntLMSTypeDropdown, strLmsType, driver);

		//Clear Textbox Consumer Key
		TextBox.clearValue("Consumer Key", elmntConsumerKeyTextbox, driver);		

		//Consumer Key
		TextBox.enterValue("Consumer Key", elmntConsumerKeyTextbox, strConsumerKey, driver);

		//Clear Textbox Consumer Secret
		TextBox.clearValue("Consumer Secret", elmntConsumerSecretTextbox, driver);				

		//Consumer Secret
		TextBox.enterValue("Consumer Secret", elmntConsumerSecretTextbox, strConsumerSecret, driver);

		//Clear Textbox Validity time		
		TextBox.clearValue("Validity time", elmntValidtimeTextbox, driver);		

		//Validity time
		TextBox.enterValue("Validity time", elmntValidtimeTextbox, strValidityTime, driver);

		//Clear Textbox Institute Name
		TextBox.clearValue("Institute name", elmntInstitutuionNameTextbox, driver);		

		//Institute Name
		TextBox.enterValue("Institute name", elmntInstitutuionNameTextbox, strInstituteName, driver);

		//Select time zone
		Combobox.selectRandomItem("Time zone", elmnttimeZoneDropdown, driver);

		//Clear Textbox First name
		TextBox.clearValue("First name", elmntFirstnameTextbox, driver);

		//First name
		TextBox.enterValue("First name", elmntFirstnameTextbox, strAdminFirstName, driver);

		//Clear Textbox Last name
		TextBox.clearValue("Last Name", elmntLastnameTextbox, driver);

		//Last Name
		TextBox.enterValue("Last Name", elmntLastnameTextbox, strAdminLastName, driver);

		//Clear Textbox Email Address 
		TextBox.clearValue("Email address", elmntEmailTextbox, driver);

		//Email Address
		TextBox.enterValue("Email address", elmntEmailTextbox, strEmailAddress, driver);

		//Clear Textbox FICE code
		TextBox.clearValue("FICE Code", elmntFicecodeTextbox, driver);

		//FICE code		
		TextBox.enterValue("FICE Code", elmntFicecodeTextbox, strFICECode, driver);

		//Clear Textbox Country code
		TextBox.clearValue("Country code", elmntcountryCodeTextbox, driver);

		//Country code
		TextBox.enterValue("Country code", elmntcountryCodeTextbox, strCountryCode, driver);

		//Installation type
		Combobox.selectItemByValue("Installation type", elmntinstallationTypeDropdown, strInstallationtype, driver);
	}	

	//Description:Edited Integrated Consumer Table
	public void editedConsumerIntegratedTable(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>editedConsumerIntegratedTable", driver);
		String strLmsType = dataMap.get("EditLmsType");
		String strConsumerKey = dataMap.get("EditValidConsumerKey");
		String strConsumerSecret = dataMap.get("EditValidConsumerSecret");
		String strValidityTime = dataMap.get("EditValidTimeOfValidity");
		String strInstituteName = dataMap.get("EditInstitutionName");
		String strAdminFirstName = dataMap.get("EditAdminFirstName");
		String strAdminLastName = dataMap.get("EditAdminLastName");
		String strFICECode = dataMap.get("EditValidFICECode");
		String strCountryCode = dataMap.get("EditValidCountryCode");
		String strEmailAddress = dataMap.get("EditValidTestEmailAddress");
		String strInstallationtype = dataMap.get("EditInstallationType");

		String[] strLmsTypes = strLmsType.split(" - ");
		String strLmsTypeShort = strLmsTypes[1].trim();


		//Count of total consumers vs table value
		List<WebElement> totalTablerows = driver.findElements(By.xpath(strIntegratedConsumertable+"/tr"));

		//Total consumers count
		Element.verify("Total consumers count", driver.findElement(By.xpath("//p[@class='total' and text()='Total consumers: ']/span")), driver);

		if(Element.verify("Consumer Table", driver, "XPATH", strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]")){
			ResultUtil.report("PASS", "Edited Consumer is displayed in Integrated consumer table", driver);

			//LMS type			
			Element.verify("Lms Type", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[contains(text(),'"+strLmsTypeShort+"')]")), driver);

			//consumer key
			Element.verify("Consumer key", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strConsumerKey+"']")), driver);			

			//consumer secret
			Element.verify("Consumer Secret", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strConsumerSecret+"']")), driver);			

			//Time
			Element.verify("Time Validity", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strValidityTime+"']")), driver);			

			//Inst name
			Element.verify("Institution name", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strInstituteName+"']")), driver);			

			//admin email
			Element.verify("Admin email", driver.findElement(By.xpath(strIntegratedConsumertable+"/tr[./td[text()='"+strConsumerKey+"']]/td[text()='"+strEmailAddress+"']")), driver);			
		}
		else
		{
			ResultUtil.report("FAIL", "Edited Consumer is not created", driver);
		}
	}


	//Description:Click "Ok" button
	public void selectOkButton()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>selectOkButton", driver);
		Button.click("Ok", elmntConsumerOkbtn, driver);
	}

	//Description:Click "Cancel" button
	public void selectCancelButton()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>selectCancelButton", driver);
		Button.click("Cancel", elmntConsumerCancelbtn, driver);
	}

	//Description:Delete link -alert handling by dismiss
	public void dismissAlertHandling() throws InterruptedException
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>dismissAlertHandling", driver);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "Are you sure you want to remove this consumer?");
		alert.dismiss();			
	}

	//Description:Delete link -alert handling by accept
	public void acceptAlertHandling() throws InterruptedException
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>acceptAlertHandling", driver);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), "Are you sure you want to remove this consumer?");
		alert.accept();			
	}

	//Description:Switch to Work frame table
	public void switchFrameCourseListTable()
	{
		driver.switchTo().defaultContent();
		WebDriver myFrame = driver.switchTo().frame("mainframe");
		myFrame = myFrame.switchTo().frame("userframe");
		myFrame = myFrame.switchTo().frame("workframe");
	}

	//Description:Validate created consumer key status
	public void consumerCreatedSuessStatus(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>consumerCreatedSuessStatus", driver);
		String strConsumerKey = dataMap.get("ValidConsumerKey");
		Element.verify("Consumer Key Created", driver, "XPATH", "//span[text()='New Customer "+strConsumerKey+" sucessfully created.']");
	}

	//Description:Back to LTI configuration Page
	public void selectLTIconfigurationLink()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>selectLTIconfigurationLink", driver);
		switchFrameCourseListTable();
		Link.click("LTI Configuration", elmntLTIConfigurationLink, driver);
	}

	//Description:Validate edited consumer key status
	public void consumerEditedSuessStatus(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>consumerEditedSuessStatus", driver);
		String strConsumerKey = dataMap.get("EditValidConsumerKey");
		Element.verify("Consumer Key Created", driver, "XPATH", "//span[text()='Customer "+strConsumerKey+" sucessfully updated.']");
	}
	public void integratedConsumers (Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>integratedConsumers", driver);
		switchFrameCourseListTable();
		Sync.waitForObject(driver, "Integrated consumer table", "XPATH", strIntegratedConsumertable, 15);
		List<WebElement> elmntintegrate = driver.findElements(By.xpath(strIntegratedConsumertable));	
		if(elmntintegrate.size()>0)
		{
			ResultUtil.report("MESSAGE", "Records are already displayed in Integrated consumer table", driver);
		}
		else
		{
			LTIConfigurationPage ltiConfigurationPage = PageFactory.initElements(driver, LTIConfigurationPage.class);

			ResultUtil.report("MESSAGE", "No records in Integrated consumer table. Creating new consumer", driver);

			//Click Add new consumers button
			ltiConfigurationPage.goToAddNewConsumers();

			//Create new consumers
			ltiConfigurationPage.createAddConsumers(dataMap);

			//Ok button
			ltiConfigurationPage.selectOkButton();

			//Success message is displayed
			ltiConfigurationPage.consumerCreatedSuessStatus(dataMap);

			//Back to Configuration page
			ltiConfigurationPage.selectLTIconfigurationLink();
		}
	}
	public void validateValidEmailAddressFormat(Map<String,String> dataMap, String strvalidAddress)
	{

		String strEmailaddress = dataMap.get(strvalidAddress);
		TextBox.enterValue("Email Address format", elmntEmailTextbox, strEmailaddress, driver);

		//Enter Ok button
		Sync.waitForObject(driver, "Consumer Ok button", "ID", "lti-consumer-dialog-ok", 15);
		Button.click("Ok", elmntConsumerOkbtn, driver);

		//Validate the Error message
		if(Element.verify("Error Message", driver, "XPATH", strerrormessage))
		{	
			ResultUtil.report("FAIL", "Some symbol(s) you entered are not supported; please try again.']", driver);	
			Element.verify("Email Address", driver.findElement(By.xpath(strerrormessage)), driver);
			TextBox.clearValue("Email Address format", elmntEmailTextbox, driver);
		}
		else
		{				
			ResultUtil.report("PASS", "No Error Message is displayed", driver);	
			TextBox.clearValue("Email Address format", elmntEmailTextbox, driver);
		}

	}	

}

