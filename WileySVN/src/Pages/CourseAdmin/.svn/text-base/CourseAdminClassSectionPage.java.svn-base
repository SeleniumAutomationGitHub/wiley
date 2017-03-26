package Pages.CourseAdmin;


import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.Common.Initializer;
import Pages.Common.LogoutSessionPage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Toolbox.Window;

public class CourseAdminClassSectionPage extends Initializer {


@FindBy(how = How.CLASS_NAME,using="titlink")
private WebElement elmntAbtCourseAdmin;

@FindBy(how = How.ID, using = "Show_Finished_Class_Sections")
private WebElement elmntShow;

@FindBy(how = How.ID, using = "Hide_Finished_Class_Sections")
private WebElement elmntHide;

@FindBy(how = How.ID, using = "Add_Class_Section")
private WebElement elmntAddClass;

@FindBy(how = How.ID, using = "Add_Another_Day/Time")
private WebElement elmntAddDay;

@FindBy(how = How.ID, using = "Import_Roster")
private WebElement elmntImportRoster;

@FindBy(how = How.XPATH, using = "//td[./table//tr]//tr[./td[.='Designate yourself as an instructor in this class section']]/td[./input]")
private WebElement elmntDesignateCheckbox;

@FindBy(how = How.XPATH, using = "//td[contains(text(),'Class Section Name')]")
private WebElement elmntClassSectionHeader;;

@FindBy(how = How.XPATH, using = "//td[contains(text(),'Instructor(s)')]")
private WebElement elmntInstructorsHeader;

@FindBy(how = How.XPATH, using = "//td[contains(text(),'Class Section URL (Student Login)')]")
private WebElement elmntStudentHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][1]")
private WebElement elmntClassStatusHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][2]")
private WebElement elmntAccessibleHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][3]")
private WebElement elmntSelfRegHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][4]")
private WebElement elmntRoasterHeader;

@FindBy(how = How.XPATH, using = "//span[@class='breadcrumb']")
private WebElement elmntBreadCrumb;

@FindBy(how = How.XPATH, using = "//table//tr[./td[./span[.='Finished']]]//span[text()='Finished']")
private WebElement elmntFinishedClassSection;

@FindBy(how = How.XPATH, using = "//td[contains(text(),'Actions')]")
private WebElement elmntActionHeader;

@FindBy(how = How.XPATH, using = "//input[@value='finished']")
private WebElement elmntFinishRadiobutton;

@FindBy(how = How.ID, using = "Submit")
private WebElement btnSubmit;

@FindBy(how = How.ID, using = "edt")
private WebElement elmntClassSectionEndDate;

@FindBy(how = How.ID, using = "main-text")
private WebElement elmntCourseWarningmessage;

@FindBy(how = How.ID, using = "okay-btn-text")
private WebElement elmntOkaybtn;

String strClassSectionName;

String strTableName = "//table[@class='plain-table']//tr";

WebElement elmntStudentUrl=null;

public CourseAdminClassSectionPage(WebDriver driver){
	super(driver);
}

	//Verifying the removed instructor is displayed in class section  page
	public  LogoutSessionPage validateRemovedClassSection(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateRemovedClassSection", driver);
		String strRemoveInstructorFirstName =  dataMap.get("RemoveInstructorFirstName");
		String strRemoveInstructorLastName = dataMap.get("RemoveInstructorLastName");
		String strRemoveName = strRemoveInstructorLastName.concat((", " + strRemoveInstructorFirstName));
		
		if(Element.notVerify("Remove instructor -Link", driver, "XPATH", "//table[@class='plain-table']//td[./span[nobr='"+strRemoveName+"']]//span/nobr[contains(.,'"+strRemoveName+"')]"))
		{
			ResultUtil.report("PASS", "Given instructor name is  removed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Given instructor name is not removed", driver);
		}		
		return PageFactory.initElements(driver, LogoutSessionPage.class);
	}
	
	//UI of the class section page
	public void validateClassSectionUI(Map<String,String> dataMap) throws InterruptedException
	{		
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateClassSectionUI", driver);
		
		strClassSectionName = dataMap.get("AddClassName");
		
		//Verifying the about course admin link
		Link.verify("About course admin", elmntAbtCourseAdmin, "About Course Admin", driver);
		
		//Verify Show finished Class Section button
		Button.verify("Show finished class section", elmntShow, "Show Finished Class Sections", driver);
		
		//Verify Add class section button
		Button.verify("Add Class Section", elmntAddClass, "Add Class Section", driver);
		
		//Verify the header text in table
		String strClassSection = elmntClassSectionHeader.getText();
		Element.verify("Class section header", elmntClassSectionHeader, strClassSection, driver);
		String strInstructorHeader = elmntInstructorsHeader.getText();
		Element.verify("Instructor header", elmntInstructorsHeader, strInstructorHeader, driver);
		String strStudentHeader = elmntStudentHeader.getText();
		Element.verify("Student header", elmntStudentHeader, strStudentHeader, driver);
		String strClassStatusText = elmntClassStatusHeader.getText();
		Element.verify("Class status header", elmntClassStatusHeader, strClassStatusText, driver);
		String strAccessibleText = elmntClassStatusHeader.getText();
		Element.verify("Accessible header", elmntAccessibleHeader, strAccessibleText, driver);
		String strSelfregText = elmntClassStatusHeader.getText();
		Element.verify("Self free header", elmntSelfRegHeader, strSelfregText, driver);
		String strRoasterText = elmntClassStatusHeader.getText();
		Element.verify("Roaster", elmntRoasterHeader, strRoasterText, driver);
		String strActionText = elmntActionHeader.getText();
		Element.verify("Roaster", elmntActionHeader, strActionText, driver);
		
		//Verify the column names
		Element.verify("Class Section Column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[1]");
		Element.verify("Instructor column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[2]");
		if(Element.verify("Class Section URL column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[3]"))
		{
			 elmntStudentUrl = driver.findElement(By.xpath(strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[3]"));
			ResultUtil.report("Student url", elmntStudentUrl.getText(), driver);
		}
		Element.verify("Class Status column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[4]");
		Element.verify("Accessible to Student column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[5]");
		Element.verify("Student Self Reg", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[6]");
		Element.verify("Student Roaster column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[7]");
		Element.verify("Action column- Edit link", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[8]");
		Element.verify("Action column- Copy link", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[9]");
		
		finishedClassValidation(dataMap,elmntStudentUrl);
	}
	
	//UI of the Edit class section
	public CourseAdminClassSectionEditPage selectDefaultClassSectionEditlink(Map<String,String> dataMap, String strClassName) throws InterruptedException
	{		
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>selectDefaultClassSectionEditlink", driver);
		String strEditClassSection = dataMap.get(strClassName);
		
		//click on the edit link for given class section
		WebElement elmntEditClassSection = driver.findElement(By.xpath(strTableName+"[./td='"+strEditClassSection+"']/td[.//a[.='Edit']]//a")); 
		Link.click("Edit Link", elmntEditClassSection, driver);
		//Verify Breadcrumb
		Element.verify("BreadCrumb text", elmntBreadCrumb, "Class Sections > Edit Class Section ", driver);
		return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
	}
	
	//Validate the course finder window is opened
	public void validateCourseFinderWindow()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateCourseFinderWindow", driver);
		String currentWindowHandle = driver.getWindowHandle();
		System.out.println(driver.getTitle());
		Set<String> openWindows = driver.getWindowHandles();
		String popupWindow = null;
		for(String windowHandle:openWindows)
		{
			if(!windowHandle.equals(currentWindowHandle))
				{
				ResultUtil.report("INFO", "Additional window is displayed", driver);
				popupWindow = windowHandle;
				driver.switchTo().window(popupWindow);
				System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(currentWindowHandle);
				}
			else{				
				ResultUtil.report("INFO", "Parent window alone displayed", driver);
			}
		}
		
	}
	
		//Click "Copy" link in new created class section name
		public CourseAdminClassSectionEditPage goToCopyLink(Map<String,String> dataMap, String strClassName) throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSectionPage>goToCopyLink", driver);
			
			String strClassSection = dataMap.get(strClassName);			
			driver.findElement(By.xpath(strTableName+"[./td='"+strClassSection+"']/td[.//a[.='Copy']]//a")).click();
			try
			{
				ResultUtil.report("MESSAGE", "Copy edit is disabled. No Assignment warning message is displayed", driver);
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				Assert.assertEquals(alert.getText(), "There are no assignments available to copy from the class section selected. Please select another section to copy assignments or create a new blank class section.");
				alert.accept();									
			}
			catch(Exception e)
			{
				
			}		
			
			return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
		}
	
	
	public AddClassSectionPage gotoAddClassSection() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>gotoAddClassSection", driver);
		Button.click("Add class section", elmntAddClass, driver);		
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForObject(driver, "Modal popup", "ID", "modal", 20);
		try
		{	
			Element.verify("Modal dialog", driver, "ID", "modal");
			WebElement modalPopupContinue= driver.findElement(By.id("Continue"));
			Button.click("Click continue", modalPopupContinue, driver);
		}
		catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
		return PageFactory.initElements(driver, AddClassSectionPage.class);
	}
	
	//Validate the class section name on cancel
	public void validateClassSectionOnCancel(Map<String,String> dataMap, String strClassName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateClassSectionOnCancel", driver);
		Sync.waitForObject(driver, "Class section page", "XPATH", "//b[text()='Class Sections']");
		strClassSectionName = dataMap.get(strClassName);
		Element.verify("Class section name", driver.findElement(By.xpath(strTableName+"[.//a[.='"+strClassSectionName+"']]/td/a[.='"+strClassSectionName+"']")), strClassSectionName, driver);
		Element.verify("Domain owner name", driver, "XPATH", "//td[./a='"+strClassSectionName+"']//following-sibling::td[1]");
	}
	
	//Validate the class section name on submit
	public void validateClassSectionOnSubmit(Map<String,String> dataMap, String strClassName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateClassSectionOnSubmit", driver);
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();							
		}
		catch(Exception e)
		{
			
		}
		finally{
		strClassSectionName = dataMap.get(strClassName);
		
		//Verifying the class section page
		Sync.waitForObject(driver, "Class section page", "XPATH", "//b[text()='Class Sections']");
		Element.verify("Class section name", driver.findElement(By.xpath(strTableName+"[.//a[.='"+strClassSectionName+"']]/td/a[.='"+strClassSectionName+"']")), strClassSectionName, driver);
			if(Element.notVerify("Domain owner name", driver, "XPATH", "//td[./a='"+strClassSectionName+"']//following-sibling::td[1]"))
			{
				ResultUtil.report("PASS", "Domain owner name is not displayed - first case", driver);			
			}
			else
			{
				ResultUtil.report("FAIL", "Domain owner name is displayed - second case", driver);
			}
		}
	}
	
	//Validate after the add class functionality
	public void validateCourseOnAddClass(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateCourseOnAddClass", driver);
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();							
		}
		catch(Exception e)
		{
			
		}
		String changeClassName = dataMap.get("NewChangeClassName");

		String domainOwnerName= concatDomainOwnerName(dataMap);
		Element.verify("Class section name", driver.findElement(By.xpath(strTableName+"[.//a[.='"+changeClassName+"']]/td/a[.='"+changeClassName+"']")), changeClassName, driver);
		Element.verify("Class instructor name", driver.findElement(By.xpath(strTableName+"[.//span[.='"+domainOwnerName+"']]//nobr[.='"+domainOwnerName+"']")), changeClassName, driver);
	}
	
	//Validate the student roaster number in class section table
	public void validateStudentRoasterValue(Map<String,String> dataMap, String strClassName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateStudentRoasterValue", driver);
		String dftClassname = dataMap.get(strClassName);	
		String strRoasterValue = dataMap.get("Total Roaster");
		WebElement tableroaster = driver.findElement(By.xpath(strTableName+"[./td[.='"+dftClassname+"']]//td[7]/span"));
		System.out.println(tableroaster.getText() +"---"+strRoasterValue);
		Element.verify("Roaster value", driver.findElement(By.xpath(strTableName+"[./td[.='"+dftClassname+"']]//td[7]/span")), strRoasterValue, driver);
	}
	
	//Get the student course url
	public String getStudentClassSectionUrl(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>>getStudentClassSectionUrl", driver);
		String strClassName = dataMap.get("ClassSection");
		List<WebElement> classSectionList = driver.findElements(By.xpath(strTableName+""));
		String studentDomainUrl=null;
		if(classSectionList.size()>=5)
		{
			WebElement fifthClassSectionUrl = driver.findElement(By.xpath(strTableName+"[5]//td[3]/span"));
			studentDomainUrl=dataMap.put("StudentUrl", fifthClassSectionUrl.getText());		
		}
		else{			
			
			WebElement RandomClassSectionUrl = driver.findElement(By.xpath(strTableName+"[.//a[contains(text(),'"+strClassName+"')]]//td[3]//span[1]"));
			studentDomainUrl=dataMap.put("StudentUrl", RandomClassSectionUrl.getText());
		}
		return studentDomainUrl;
	}
	
	//Validate the copy created class section
	public void validateNewCopyClassSection(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>>validateNewCopyClassSection", driver);
		String strCopyClassname = dataMap.get("CopyclassSection");		
		Element.verify("Newly copy created Class section", driver, "XPATH", strTableName+"[./td]//td/a[.='"+strCopyClassname+"']");
	}
	
	public String concatDomainOwnerName(Map<String,String> dataMap)
	{
		String domainOwnerFirstName = dataMap.get("DomainownerFirstName");
		String domainOwnerSecondName = dataMap.get("DomainownerSecondName");
		String domainowner = domainOwnerSecondName.concat(", "+domainOwnerFirstName);
		return domainowner;
	}
	
	//Validate the Orion Icon
	public LogoutSessionPage logoutFromCourseAdminClassSectionPage()
	{
		ResultUtil.report("MESSAGE", "Go to logout page for logout", driver);
		return PageFactory.initElements(driver, LogoutSessionPage.class);
	}

	//Validate the class section name
	public void validateClassSection(Map<String,String> dataMap, String strClassName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateClassSection", driver);
		strClassSectionName = dataMap.get(strClassName);
		Element.verify("Class Section page", driver, "XPATH", "//b[text()='Class Sections']");
		Element.verify("Class section name", driver.findElement(By.xpath(strTableName+"[.//a[.='"+strClassSectionName+"']]/td/a[.='"+strClassSectionName+"']")), strClassSectionName, driver);
	}
	
	public void validateClassSectionPage()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateClassSectionPage", driver);
		Element.verify("Class section page", driver, "XPATH", "//b[text()='Class Sections']");
		Element.verify("Class Section List", driver, "XPATH", "//table[@class='plain-table']//following-sibling::td[.='Active']//preceding-sibling::td[./a]");
	}
	
	public void finishedClassValidation(Map<String,String> dataMap, WebElement elmntStudentUrl) throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>finishedClassValidation", driver);
		
		strClassSectionName = dataMap.get("AddClassName");	
		dataMap.put("StudentUrl", elmntStudentUrl.getText());
		String strClassEndDate =dataMap.get("AddClassSectionEndDate");		
		//Select class section to select the finish button
		selectDefaultClassSectionEditlink(dataMap,"StudentUrl");	
		//End value
		TextBox.JSEnterValue("Enter Calendar Section end date", driver, elmntClassSectionEndDate,strClassEndDate);		
		//Select radio button		
		Radiobutton.JSSelect("Select Finish Radiobutton", elmntFinishRadiobutton, driver);
		//Accept the alert
		Alert alert =driver.switchTo().alert();
		alert.accept();		
		
		//click on Submit button
		Button.click("Submit button", btnSubmit, driver);		
		//Click "Show finished class section"
		Button.click("Show finished class", elmntShow, driver);								
		//Verify the Hide finished class section button is displayed
		Button.verify("Hide finished button", elmntHide, "Hide Finished Class Sections", driver);		
		//Verify the hide finish class text 
		Element.verify("Hide Finished button text", elmntHide, "Hide Finished Class Sections", driver);		
	
		//Verify finished class section is displayed 
		Element.verify("Finished class secton", elmntFinishedClassSection, "Finished", driver);		
		//Click "hide finished button"
		Button.click("Hide finished Button", elmntHide, driver);
		//Verify Show finished Class Section button
		Button.verify("Show finished class section", elmntShow, "Show Finished Class Sections", driver);		
		//Verify the class section is disappeared.		
		if(Element.notVerify("Finsihed Class Section", driver, "XPATH", "//td[.='"+dataMap.get("StudentUrl")+"']//preceding-sibling::td[2]"))
		{
			ResultUtil.report("PASS", "Finished class section is NOT displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Finished class section is displayed", driver);
		}
	}
	
	//Validate the class section name on submit
	public void validateClassSectionInstructor(Map<String,String> dataMap, String strClassName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>validateClassSectionInstructor", driver);
		try
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();							
		}
		catch(Exception e)
		{
			
		}
		finally{
		strClassSectionName = dataMap.get(strClassName);
		
		//Verifying the class section page
		Sync.waitForObject(driver, "Class section page", "XPATH", "//b[text()='Class Sections']");
		Element.verify("Class section name", driver.findElement(By.xpath(strTableName+"[.//a[.='"+strClassSectionName+"']]/td/a[.='"+strClassSectionName+"']")), strClassSectionName, driver);
			if(Element.notVerify("Domain owner name", driver, "XPATH", "//tr[3]/td[./input[@type='checkbox']]//preceding-sibling::td[2]"))
			{
				ResultUtil.report("PASS", "Instrutor name is  displayed - first case", driver);			
			}
			else
			{
				ResultUtil.report("FAIL", "Instrutor name  is not displayed - second case", driver);
			}
		}
	}
	
	//Validate courseFinder preview window
	public void verifyCourseFinderWindow()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>verifyCourseFinderWindow", driver);
		Window.focusWindow("Course finder windoe", driver, driver.getWindowHandles().toArray()[1].toString());
		ResultUtil.report("Windows name", driver.getTitle(), driver);
		if(Element.verify("Warning window", elmntCourseWarningmessage, driver))
		{
			ResultUtil.report("PASS", "Warning window is displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Warning window is NOT displayed", driver);
		}
		if(Element.verify("Warning window button", elmntOkaybtn, driver))
		{
			ResultUtil.report("PASS", "Warning window button is displayed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Warning window button is NOT displayed", driver);
		}
		this.driver.close();
		Window.focusWindow("Course finder windoe", driver, driver.getWindowHandles().toArray()[0].toString());
	}
	
	//Get the student url
	public WebElement getStudentUrl(Map<String,String>dataMap, String strClassName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionPage>getStudentUrl", driver);
		String strClassSectionName= dataMap.get(strClassName);
		
		if(Element.verify("Class Section URL column", driver, "XPATH", strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[3]"))
		{
			 elmntStudentUrl = driver.findElement(By.xpath(strTableName+"[.//a[text()='"+strClassSectionName+"']]//td[3]"));
			ResultUtil.report("Student url", elmntStudentUrl.getText(), driver);
		}
		dataMap.put("StudentUrl", elmntStudentUrl.getText());
		return elmntStudentUrl;
	}
}

	