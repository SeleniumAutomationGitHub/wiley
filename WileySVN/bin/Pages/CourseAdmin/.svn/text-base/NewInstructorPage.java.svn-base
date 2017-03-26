package Pages.CourseAdmin;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class NewInstructorPage extends Initializer
{	
	Random random = new Random();
		
		
	@FindBy(how = How.NAME, using = "addCopyClass")
	private WebElement btnAddCopy;
	
	private WebElement elmntSelectDesignate;
	
	@FindBy(how = How.ID, using = "Update")
	private WebElement btnUpdate;
		
	@FindBy(how = How.ID, using = "Cancel")
	private WebElement btnCancel;
	
	@FindBy(how = How.ID, using = "Send_E-mail")
	private WebElement elmntMail;	
	
	@FindBy(how = How.XPATH, using = "//li[@title='Class Sections']")
	private WebElement tabClassSections;
	
	@FindBy(how = How.XPATH, using = "//li[@title='Instructors']")
	private WebElement tabInstructors;
	
	@FindBy(how = How.XPATH, using = "//span[@class='alert']")
	private WebElement notification;
	
	String strClassTableSection = "//table[@class='plain-table']//tr[.//td[text()='Active']]";
	
	public NewInstructorPage(WebDriver driver){
		super(driver);
	}
	
	//Capturing Notification text
	public void validateNotificationMessage()
	{
		ResultUtil.report("INFO", "NewInstructorPage>validateNotificationMessage", driver);
		if(Element.verify("Notification Element", notification, driver))
		{
			if(notification.getText().equals("New instructor added to course. Notification has been sent to instructor's e-mail address."))
			{
				ResultUtil.report("PASS", "Notification message is displayed", driver);
			}
			else
			{
				ResultUtil.report("FAIL", "Notification message is NOT displayed", driver);
			}
		}
		else
		{
			ResultUtil.report("FAIL", "Notification Element is not displayed", driver);
		}
		
		//Notification message for instructor displayed
		driver.findElement(By.xpath(".//*/td/span[contains(text(),'New instructor added to course.')]"));
	}
	
	//Profile Details section in instructor added screen
	public void validateProfileDetailsSection(Map<String,String> dataMap, String strFirstName, String strLastName, String strEmail, String strPhone) throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>validateProfileDetailsSection", driver);
		
		Sync.waitForObject(driver, "Instructor Profile", "XPATH", "//b[contains(text(),'Instructor Profile')]");
		
		//Verifying profile details Heading and labels
		Element.verify("Profile details heading", driver, "XPATH", "//h6[text()='Profile Details']");
		Element.verify("First Name", driver, "XPATH", "//td[contains(text(),'First Name')]");
		Element.verify("Last Name", driver, "XPATH", "//td[contains(text(),'Last Name')]");
		Element.verify("Email", driver, "XPATH", "//td[contains(text(),'E-mail')]");
		Element.verify("Phone", driver, "XPATH", "//td[contains(text(),'Phone')]");

		WebElement elmntFirstName = driver.findElement(By.xpath("//tr[.//td[contains(text(),'First Name:')]]//span[text()='"+dataMap.get(strFirstName)+"']"));
		WebElement elmntLastName = driver.findElement(By.xpath("//tr[.//td[contains(text(),'First Name:')]]//span[text()='"+dataMap.get(strLastName)+"']"));
		WebElement elmntEmailaddress = driver.findElement(By.xpath("//tr[.//td[contains(text(),'First Name:')]]//span[text()='"+dataMap.get(strEmail)+"']"));
		WebElement elmntPhone = driver.findElement(By.xpath("//tr[.//td[contains(text(),'First Name:')]]//span[text()='"+dataMap.get(strPhone)+"']"));
		
		//Verify the element is displayed
		if(elmntFirstName.isDisplayed())
		{
			ResultUtil.report("PASS", "First name element is displayed", driver);
			if(elmntLastName.isDisplayed()){
				ResultUtil.report("PASS", "Last name element is displayed", driver);
				if(elmntEmailaddress.isDisplayed()){
					ResultUtil.report("PASS", "Email address element is displayed", driver);
					if(elmntPhone.isDisplayed()){
						ResultUtil.report("PASS", " Phone element is displayed", driver);
					}
					else	{
						ResultUtil.report("FAIL", " Phone element is NOT displayed", driver);
					}
				}
				else	{
					ResultUtil.report("FAIL", "Email address element is NOT displayed", driver);
				}
			}
			else	{
				ResultUtil.report("FAIL", "Last name element is NOT displayed", driver);
			}
		}
		else	{
			ResultUtil.report("FAIL", "First name element is NOT displayed", driver);
		}
		
		//Verify the label element is not in editing mode
		if(elmntFirstName.isEnabled())
		{
			ResultUtil.report("FAIL", "First name element is in EDITABLE mode", driver);
			if(elmntLastName.isEnabled()){
				ResultUtil.report("FAIL", "Last name element is in EDITABLE mode", driver);
				if(elmntEmailaddress.isEnabled()){
					ResultUtil.report("FAIL", "Email address element is in EDITABLE mode", driver);
					if(elmntPhone.isEnabled()){
						ResultUtil.report("FAIL", " Phone element is in EDITABLE mode", driver);
					}
					else	{
						ResultUtil.report("PASS", " Phone element is NOT in EDITABLE mode", driver);
					}
				}
				else	{
					ResultUtil.report("PASS", "Email address element is NOT in EDITABLE mode", driver);
				}
			}
			else	{
				ResultUtil.report("PASS", "Last name element is NOT in EDITABLE mode", driver);
			}
		}
		else	{
			ResultUtil.report("PASS", "First name element is NOT in EDITABLE mode", driver);
		}
		
		//Verify send email button
		Button.verify("Send Email Button", elmntMail, driver);
	}                   
	
	//Verify send email button and verify it works
	public void selectSendEmailButton() throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>selectSendEmailButton", driver);		
		Button.click("Send Email button", elmntMail, driver);		
	}
	
	//Assign class section in instructor added screen
	public void validateAssignClassSection(Map<String,String> dataMap) throws Exception
	{		
		ResultUtil.report("INFO", "NewInstructorPage>validateAssignClassSection", driver);
		
		//Verifying Assign class section heading and labels
		Element.verify("Assign class section label", driver, "XPATH", "//h6[text()='Assign Class Sections']");
		Element.verify("Class section name", driver, "XPATH", "//th[contains(text(),'Class Section Name')]");
		Element.verify("Designate label", driver, "XPATH", "//th[contains(text(),'Designate')]");
		List<String> elmntClass = getClassNames(dataMap);
		List<String> listInsAssignClass = new ArrayList<String>();
		//List of class section
		List<WebElement> listAssignClass = driver.findElements(By.xpath("//input[@name='class']//parent::td//preceding-sibling::td[2]"));
		for(WebElement classNameInstructor:listAssignClass)
		{			
			String insAssignClass=classNameInstructor.getText(); 
			listInsAssignClass.add(insAssignClass);
			ResultUtil.report("MESSAGE", insAssignClass, driver);
		}	
		
		for(int i=1;i<listAssignClass.size();i++)
		{
			String se=elmntClass.get(i);
			System.out.println(se);
			String es = listInsAssignClass.get(i);
			System.out.println(es);
			if(se.equals(es))
			{
					ResultUtil.report("PASS", "ACTIVE Class is displayed", driver);
			}
			else
			{
				ResultUtil.report("FAIL", "FINISHED Class is displayed", driver);
			}
		}
		
		List<WebElement> listCheckBox = driver.findElements(By.xpath("//input[@name='class']"));
		
		if(listAssignClass.size()==listCheckBox.size())
		{
			ResultUtil.report("PASS", "Checkbox is displayed for all the Active class sections", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Checkbox is NOT displayed for all the Active class sections", driver);
		}
	}
	
	//Select single checkbox in designate column
	public CourseAdminPage selectDesignate(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>selectDesignate", driver);
		String strClassSection = dataMap.get("NewChangeClassName");
		
		//select the check box given class section data map
		elmntSelectDesignate = driver.findElement(By.xpath("//table[./tbody/tr/th[.='Class Section Name']]//tr[.//td[.='"+strClassSection+"']]//input[@name='class']"));
		Checkbox.check("Check designate", elmntSelectDesignate, driver);
		submitSettings();		
		return PageFactory.initElements(driver, CourseAdminPage.class);
	}	
	
	//Unselect single checkbox in designate column
	public CourseAdminPage uncheckDesignate(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>uncheckDesignate", driver);
		String strClassSection = dataMap.get("NewChangeClassName");		
		//Unselect the check box given class section data map
		elmntSelectDesignate = driver.findElement(By.xpath("//table[./tbody/tr/th[.='Class Section Name']]//tr[.//td[.='"+strClassSection+"']]//input[@name='class']"));
		Checkbox.unCheck("Uncheck designate", elmntSelectDesignate, driver);
		submitSettings();
		return PageFactory.initElements(driver, CourseAdminPage.class);
	}
	
	public String selectMultiDesignateCheckBox(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "NewInstructorPage>selectMultiDesignateCheckBox", driver);
		int a =0;
		//List<WebElement> designCheckbox = driver.findElements(By.xpath("//input[@name='class']")) ;
		
		if(Element.verify("Checkbox checked", driver, "XPATH", "//input[@checked='checked']"))
		{			
			a=a+1;
		}
		
		for(int i=3;i<4;i++)
		{			
			WebElement elmntSelectCheckbox = driver.findElement(By.xpath("//table[./tbody/tr/th[.='Class Section Name']]//tr["+i+"]//input"));
			if(Checkbox.isUnchecked("Unchecked Checkbox", elmntSelectCheckbox, driver))
			{
				Checkbox.check("Select class section in instrutor page", elmntSelectCheckbox, driver);				
			}
			else
			{
				Checkbox.isChecked("Checked Checkbox", elmntSelectCheckbox, driver);
			}			
			a=a+1;		
		}

		String value =String.valueOf(a);
		System.out.println(a);
		return value;
	}
	
	public CourseAdminPage cancelSettings() throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>cancelSettings", driver);
		Button.click("Cancel Button", btnCancel, driver);
		Thread.sleep(2000);
		return PageFactory.initElements(driver, CourseAdminPage.class);
	}
	
	public CourseAdminPage submitSettings() throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>submitSettings", driver);
		Button.click("Submit Button", btnUpdate, driver);
		Thread.sleep(2000);
		return PageFactory.initElements(driver, CourseAdminPage.class);
	}
	
	public List<String>  getClassNames(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "NewInstructorPage>getClassNames", driver);
		Button.click("Class section tab", tabClassSections, driver);
		List<String> elmntclassNames = new ArrayList<String>();
		List<WebElement> listOfActiveClasses = driver.findElements(By.xpath("//table[@class='plain-table']//tr[.//td[text()='Active']]//preceding-sibling::td[./a]"));
		for(WebElement className:listOfActiveClasses)
		{
			//WebElement elmntclassName = driver.findElement(By.xpath(strClassTableSection+"//td["+i+"]/a"));
			String classSectioName=className.getText(); 
			elmntclassNames.add(classSectioName);
			ResultUtil.report("MESSAGE", classSectioName, driver);
		}		
		
		Button.click("Instructor tab", tabInstructors, driver);
		CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
		courseAdminPage.selectDesignateClassSectionViaEdit(dataMap, "MoreFirstName", "MoreLastName");		
		
		return elmntclassNames;
	}
}
