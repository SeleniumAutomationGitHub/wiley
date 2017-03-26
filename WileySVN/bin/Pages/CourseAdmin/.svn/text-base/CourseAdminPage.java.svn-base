package Pages.CourseAdmin;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Pages.Common.LogoutSessionPage;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class CourseAdminPage extends Initializer{
	
	public WebElement tblInstructorName;
	static String a="1";
	
	String strSection="//table[@class='plain-table']//tr";
	
	String strFirstname;
	String strLastname;
	String strInstructorName;
	
	public CourseAdminPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(how = How.ID, using = "Email_Selected")
private WebElement btnEmailSelected;

@FindBy(how = How.XPATH, using = "//li[@title='Class Sections']")
private WebElement tabClassSections;

@FindBy(how = How.XPATH, using = "//li[@title='Course Properties']")
private WebElement tabCourseProperties;

@FindBy(how = How.XPATH, using = "//li[@title='Instructors']")
private WebElement tabInstructors;
	
	public GoToAddInstructorPage validateInstructorList(Map<String,String>dataMap,String strFirstName,String strLastName)	
	{		
		ResultUtil.report("INFO", "CourseAdminPage>validateInstructorList", driver);
				
		Sync.waitForObject(driver, "Instrutor text", "XPATH", "//b[text()='Instructors']", 30);
						
		if(Element.verify("No instrutors text", driver, "XPATH", "//b[text()='There are no instructors.']"))
		{
			ResultUtil.report("MESSAGE", "There are no instructor in the list", driver);
		}
		else
		{
			String strInstructorName = concatName(dataMap,strFirstName,strLastName);
			Element.verify("Instructor name", driver, "XPATH", strSection+"//td[.//a[text()='"+strInstructorName+"']]");
		}
		
		//To DO
		return PageFactory.initElements(driver, GoToAddInstructorPage.class);	
	}
	
	//Verifying the instructor name in the list
	public void validateInstructorNameDisplay(Map<String,String> dataMap,String strFirstName,String strLastName) throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminPage>validateInstructorNameDisplay", driver);
		List<WebElement> instructorsList = driver.findElements(By.xpath("//table[@class='plain-table']//tr"));
		for(int i=2;i<instructorsList.size();i++)
		{				
			//Verify instructor name is same as data map
			strFirstname = dataMap.get(strFirstName);
			strLastname = dataMap.get(strLastName);
			strInstructorName = concatName(dataMap,strFirstname,strLastname);
			tblInstructorName = driver.findElement(By.xpath(strSection+"//td[.//a[.='"+strInstructorName+"']]"));
			Element.verify("New instructor", tblInstructorName, strInstructorName, driver);			
		}
	}	
	
	//Verify the class section is "1" before update
	public void validateDefaultClassSection(Map<String,String> dataMap,String strFirstName,String strLastName)
	{
		ResultUtil.report("INFO", "CourseAdminPage>validateDefaultClassSection", driver);
		strFirstname = dataMap.get(strFirstName);
		strLastname = dataMap.get(strLastName);
		strInstructorName = concatName(dataMap,strFirstname,strLastname);		
		WebElement elmntClassSectionValue = driver.findElement(By.xpath(strSection+"[.//a[.='"+strInstructorName+"']]//td[3]"));
		Element.verify("Class Section Value", elmntClassSectionValue, a, driver);
	}
	
	//Verifying the class section is "0" after the update
	public void validateUpdatedClassSection(Map<String,String> dataMap,String strFirstName,String strLastName)
	{
		ResultUtil.report("INFO", "CourseAdminPage>validateUpdatedClassSection", driver);
		a="0";
		strFirstname = dataMap.get(strFirstName);
		strLastname = dataMap.get(strLastName);
		strInstructorName = concatName(dataMap,strFirstname,strLastname);	
		WebElement elmntClassSectionValue = driver.findElement(By.xpath(strSection+"[.//a[.='"+strInstructorName+"']]//td[3]"));
		Element.verify("Class Section Value", elmntClassSectionValue, a, driver);		
	}
	
	//Verify class sections changes
	public void validateClassSectionsValue(Map<String,String> dataMap,String inClassSectionvalue,String strFirstName,String strLastName)
	{
		ResultUtil.report("INFO", "CourseAdminPage>validateClassSectionsValue", driver);
		strFirstname = dataMap.get(strFirstName);
		strLastname = dataMap.get(strLastName);
		strInstructorName = concatName(dataMap,strFirstname,strLastname);	
		WebElement elmntClassSectionValue = driver.findElement(By.xpath(strSection+"[.//a[.='"+strInstructorName+"']]//td[3]"));
		System.out.println(elmntClassSectionValue.getText());
		System.out.println("Pre:"+inClassSectionvalue);
		Element.verify("Class Section Value", elmntClassSectionValue, inClassSectionvalue, driver);
	}
	
	//click instructor link in instructor list is class section is 1
	public NewInstructorPage selectDesignateClassSectionViaName(Map<String,String> dataMap,String strFirstName,String strLastName) throws InterruptedException
	{		
		    ResultUtil.report("INFO", "CourseAdminPage>selectDesignateClassSectionViaName", driver);
			strFirstname = dataMap.get(strFirstName);
			strLastname = dataMap.get(strLastName);
			strInstructorName = concatName(dataMap,strFirstname,strLastname);	
			tblInstructorName = driver.findElement(By.xpath(strSection+"[.//td[.="+a+"]]//td[.//a[.='"+strInstructorName+"']]//a"));		
			//click on instructor name
			Link.click("Instrutor name", tblInstructorName, driver);
			Sync.waitForObject(driver, "Instructor Profile", "XPATH", "//b[contains(text(),'Instructor Profile')]");
			return PageFactory.initElements(driver, NewInstructorPage.class);
		}	
		
	//Select the instructor using edit link
	public NewInstructorPage selectDesignateClassSectionViaEdit(Map<String,String> dataMap, String strFirstName,String strLastName) throws InterruptedException
	{
			ResultUtil.report("INFO", "CourseAdminPage>selectDesignateClassSectionViaEdit", driver);
			strFirstname = dataMap.get(strFirstName);
			strLastname = dataMap.get(strLastName);
			 strInstructorName = concatName(dataMap,strFirstname,strLastname);
			WebElement tblInstructorEdit = driver.findElement(By.xpath(strSection+"[./td[.='"+strInstructorName+"']]//a[.='Edit']"));		
			//click on instructor name
			Link.click("Instrutor Edit", tblInstructorEdit, driver);						
			return PageFactory.initElements(driver, NewInstructorPage.class);
		}
	
	//Verify email selected option
	public void selectEmailSelectedButton() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminPage>selectEmailSelectedButton", driver);
		List<WebElement> instructorsList = driver.findElements(By.xpath(strSection+"[.//input[starts-with(@id,'usr')]]"));
		int inSeveralCheck = instructorsList.size();
		for(int i=2;i<inSeveralCheck;i++)
		{
			WebElement elmntInstructorCheckbox = driver.findElement(By.xpath(strSection+"[.//input[starts-with(@id,'usr')]]["+i+"]//td//input"));
			Checkbox.check("Instructor checkbox", elmntInstructorCheckbox, driver);
		}
		btnEmailSelected.click();
		Thread.sleep(2000);
		for(int i=2;i<inSeveralCheck;i++)
		{
			WebElement elmntInstructorCheckbox = driver.findElement(By.xpath(strSection+"[.//input[starts-with(@id,'usr')]]["+i+"]//td//input"));
			Checkbox.unCheck("Instructor checkbox", elmntInstructorCheckbox, driver);
		}		
	}
	
	//Remove Instructors
	public void removeInstructors(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminPage>removeInstructors", driver);
		String strRemoveInstructorFirstName =  dataMap.get("RemoveInstructorFirstName");
		String strRemoveInstructorLastName = dataMap.get("RemoveInstructorLastName");
		String strRemoveName = strRemoveInstructorFirstName.concat((" " + strRemoveInstructorLastName));
		WebElement tblInstructorRemove = driver.findElement(By.xpath(strSection+"[./td[.='"+strRemoveName+"']]//a[.='Remove']"));
		Link.click("Remove instructor ", tblInstructorRemove, driver);
		Thread.sleep(3000);
		
	}
	
	//Click Class Sections Tab
	public CourseAdminClassSectionPage navigateClassSectionTab() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminPage>navigateClassSectionTab", driver);
		Button.click("Class section tab", tabClassSections, driver);
		return PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
	}
	
	//Click Course properties Tab
	public CoursePropertiesPage navigateCoursePropertiesTab() throws InterruptedException 
	{
		ResultUtil.report("INFO", "CourseAdminPage>navigateCoursePropertiesTab", driver);
		Button.click("Course properties", tabCourseProperties, driver);				
		return PageFactory.initElements(driver, CoursePropertiesPage.class);
	}
	
	//concatenation function for first and last name
	public String concatName(Map<String,String> dataMap, String FirstName, String LastName)
	{
		//String strFirstName =  dataMap.get("FirstName");
		//String strLastName = dataMap.get("LastName");
		String strInstructorName = FirstName.concat((" " + LastName));	
		return strInstructorName;
	}
	
	//Verifying the removed instructor is displayed in instructor  page
	public  LogoutSessionPage validateRemovedInstructor(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminPage>validateRemovedInstructor", driver);
		String strRemoveInstructorFirstName =  dataMap.get("RemoveInstructorFirstName");
		String strRemoveInstructorLastName = dataMap.get("RemoveInstructorLastName");
		String strRemoveName = strRemoveInstructorFirstName.concat((" " + strRemoveInstructorLastName));			
		if(Element.notVerify("Removed Instructor", driver, "XPATH", "//table[@class='plain-table']//td[.//a[.='"+strRemoveName+"']]//a[.='"+strRemoveName+"']"))
		{
			ResultUtil.report("PASS", "Given instructor name is  removed", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Given instructor name is not removed", driver);
		}
		return PageFactory.initElements(driver, LogoutSessionPage.class);
	}
	
	//Go to instructor page
	public void goToInstructorPage()
	{
		ResultUtil.report("INFO", "CourseAdminPage>goToInstructorPage", driver);
		Button.click("Instructors", tabInstructors, driver);
	}
	
	public void validateEditLink(){
		ResultUtil.report("INFO", "CourseAdminPage>validateEditLink", driver);
		
		List<WebElement> listOfInstructors = driver.findElements(By.xpath(strSection+"[.//a]"));
		for(int i=1;i<listOfInstructors.size();i++)
		{
			Element.verify("Edit Link", driver, "XPATH", strSection+"[.//a]["+i+"]//a[text()='Edit']");
		}
	}
}
