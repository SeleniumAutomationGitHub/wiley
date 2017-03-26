package Pages.CourseAdmin;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class CourseAdminClassSectionEditPage extends Initializer {
	Random random = new Random();

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

@FindBy(how = How.XPATH, using = ".//*/td[contains(text(),'Class Section Name')]")
private WebElement elmntClassSectionHeader;;

@FindBy(how = How.XPATH, using = ".//*/td[contains(text(),'Instructor(s)')]")
private WebElement elmntInstructorsHeader;

@FindBy(how = How.XPATH, using = ".//*/td[contains(text(),'Class Section URL (Student Login)')]")
private WebElement elmntStudentHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][1]")
private WebElement elmntClassStatusHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][2]")
private WebElement elmntAccessibleHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][3]")
private WebElement elmntSelfRegHeader;

@FindBy(how = How.XPATH, using = ".//*/td[./br][4]")
private WebElement elmntRoasterHeader;

@FindBy(how = How.XPATH, using = "//table//tr[./td[./span[.='Finished']]]//span[text()='Finished']")
private WebElement elmntFinishedClassSection;

@FindBy(how = How.XPATH, using = "//h6[contains(text(),'Class Section Properties')]")
private WebElement elmntClassSectionHeading;

@FindBy(how = How.XPATH, using = "//h6[contains(text(),'Designate Instructors')]")
private WebElement elmntDesignateHeading;

@FindBy(how = How.XPATH, using = "//h6[contains(text(),'Designate Section')]")
private WebElement elmntDesginateSectionHeading;

@FindBy(how = How.XPATH, using = "//a[@id='CourseFinderOpener']")
private WebElement elmntStudentInfmFlyer;

@FindBy(how = How.ID, using = "CourseFinderPreview")
private WebElement elmntCourseFinder;

@FindBy(how = How.ID, using = "Cancel")
private WebElement elmntCancel;

@FindBy(how = How.ID, using = "Submit")
private WebElement elmntSubmit;

@FindBy(how = How.ID, using = "section-input")
private WebElement elmntClassNameBox;

@FindBy(how = How.ID, using = "term-input")
private WebElement elmntTermBox;

@FindBy(how = How.ID, using = "year-input")
private WebElement elmntYearBox;

@FindBy(how = How.NAME, using = "wday")
private WebElement elmntMeetingBox;

@FindBy(how = How.XPATH, using = "//input[not(@checked) and @type='checkbox']")
private WebElement elmntNonMemberCheckbox;

@FindBy(how = How.XPATH, using = "//input[@id='state' and @value='started']")
private WebElement elmntActiveClassSectionStatus;

@FindBy(how = How.XPATH, using = "//input[@id='state' and @value='finished']")
private WebElement elmntFinishedClassSectionStatus;

@FindBy(how = How.XPATH, using = "//input[@id='student-access' and @value='true']")
private WebElement elmntActiveStudentAccess;

@FindBy(how = How.XPATH, using = "//input[@id='student-access' and @value='false']")
private WebElement elmntFinishedStudentAccess;

@FindBy(how = How.XPATH, using = "//input[@id='self-registration' and @value='true']")
private WebElement elmntAllowSelfRegistration;

@FindBy(how = How.XPATH, using = "//input[@id='self-registration' and @value='false']")
private WebElement elmntDeniedSelfRegistration;

@FindBy(how = How.ID, using = "edt")
private WebElement elmntClassSectionEndDate;

@FindBy(how = How.ID, using = "select_assignments")
private WebElement elmntSelectAssignments;

@FindBy(how = How.ID, using = "submit")
private WebElement elmntAssignSubmit;

public CourseAdminClassSectionEditPage(WebDriver driver){
	super(driver);
}

//Validating Edit Class section page 
	public void validateClassSectionProperties(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateClassSectionProperties", driver);
		
		String strCourseName = dataMap.get("Course");
		String strCoursenumber = dataMap.get("CourseNumber");
		
		//Verifying the heading
		Element.verify("Class Section properties", elmntClassSectionHeading, "Class Section Properties", driver);
		
		/*****Verify the fields in class section are displayed*****/
		//Verifying course name
		Element.verify("Course name", driver, "XPATH", "//td[.='Course Name:']");
		WebElement elmntCourseName = driver.findElement(By.xpath("//tr[./td='Course Name:']//td//nobr[.='"+strCourseName+"']"));
		Element.verify("Course Name", elmntCourseName, strCourseName, driver);

		//Verifying course Number
		Element.verify("Course number", driver, "XPATH", "//td[.='Course Number:']");		
		WebElement elmntCourseNumber = driver.findElement(By.xpath("//tr[./td='Course Number:']//nobr[.="+strCoursenumber+"]"));
		Element.verify("Course Number", elmntCourseNumber, strCoursenumber, driver);
		
		//Verifying class section fields
		Element.verify("Classs section name", driver, "XPATH", "//td[contains(text(),'Class Section Name and/or Number')]");
		Element.verify("Classs section name", driver, "ID", "section-input");
				
		//Verifying class code fields
		Element.verify("Class code", driver, "XPATH", "//tr[./td]/td[contains(text(),'Class Code:')]");
		Element.verify("Input", driver, "CLASS", "input200");
				
		//Verifying terms fields
		Element.verify("Term", driver, "XPATH", "//tr[./td]/td[contains(text(),'Term')]");
		Element.verify("Input", driver, "ID", "term-input");
		
		//verifying class sections meeting times
		Element.verify("Meeting times", driver, "XPATH", "//tr[./td]/td[./br]");
		Element.verify("Meeting day", driver, "NAME", "wday");
		Element.verify("Meeting day", driver, "NAME", "hours");
		Element.verify("Meeting day", driver, "NAME", "minutes");
		Element.verify("Meeting day", driver, "NAME", "ampm");
		Button.verify("Add another day", elmntAddDay, "Add Another Day/Time", driver);
		
		//Verifying Students field
		Element.verify("Meeting times", driver, "XPATH", "//tr[./td]/td[text()='Students:']");
		Button.verify("Import Roster button", elmntImportRoster, "Import Roster", driver);
	}
	
	//Validating DesignateInstructor section
	public void validateDesginateInstructors()
	{
		
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateDesginateInstructors", driver);
		//Verifying the heading
		Element.verify("Designate instructors heading", elmntDesignateHeading, "Designate Instructors", driver);
		
		//Verifying the instructor checkbox
		try{
			
		driver.findElement(By.xpath("//td[./table//tr]//td[./input]/input[@type='checkbox' and @checked='checked']"));
		driver.findElement(By.xpath("//td[./table//tr]//td[./input]/input[@type='checkbox']"));				
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		//Verifying the designate instructor checkbox
		driver.findElement(By.xpath("//td[./table//tr]//tr[./td[.='Designate yourself as an instructor in this class section']]/td[./input]"));
	}
	
	//Select the designate-owner checkbox functionality
	public void selectdesignateInstructorCheckbox(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>selectdesignateInstructorCheckbox", driver);
		String strClassSectionEndDate = dataMap.get("NewClassSectionEndDate");
		TextBox.JSEnterValue("Enter Calendar Section end date", driver, elmntClassSectionEndDate, strClassSectionEndDate);
		
		//Verify the designate checkbox uncheked and list of instrutors
		Element.verify("Uncheck checkbox", driver, "XPATH", "//input[not(@checked='checked') and @name='assistant']");
		Element.verify("Instrutcor name", driver, "XPATH", "//input[not(@checked='checked') and @name='assistant']//parent::td//preceding-sibling::td[2]");
				
		if(Checkbox.isChecked("Designate instructor -owner", elmntDesignateCheckbox, driver)){
			ResultUtil.report("MESSAGE", "Designate Instructor owner checkbox is checked", driver);
			Checkbox.unCheck("Designate instructor-owner", elmntDesignateCheckbox, driver);
		}
		else{
			ResultUtil.report("MESSAGE", "Designate Instructor owner checkbox is unchecked", driver);
			Checkbox.isChecked("Designate instructor -owner", elmntDesignateCheckbox, driver);			
		}		
	}
	
	//Select checkbox for added instructor
	public void selectAnotherdesignateInstructorCheckbox()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>selectAnotherdesignateInstructorCheckbox", driver);
		List<WebElement> designateboxList = driver.findElements(By.xpath("//table//tbody[.//th[.='Name']]//input[starts-with(@id,'usr')]"));
		int indesinateCheckbox = designateboxList.size();
		if(indesinateCheckbox==0)
			{
				ResultUtil.report("INFO", "No addtional instructors are assigned to this class section", driver);
			}
		else{
			Checkbox.check("Select additional instructor", driver.findElement(By.xpath("//tr[3]/td[./input[@type='checkbox']]/input")), driver);		
		}
	}

	//Validating Designate section
	public void validateDesignateSection()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateDesignateSection", driver);
		
		//Verifying the heading
		Element.verify("Desginate Section heading", elmntDesginateSectionHeading, "Designate Section", driver);
		
		//Verifying the Designate Section Status & Accessibility fields
		Element.verify("Class section status", driver, "XPATH", "//td[contains(text(),'Class Section Status')]");
		Element.verify("Accessible to Students", driver, "XPATH", "//td[contains(text(),'Accessible to Students:')]");
		Element.verify("Student Self-Registration", driver, "XPATH", "//td[contains(text(),'Student Self-Registration')]");
				
		//Verifying button presence in bottom of the page
		Button.verify("Student information flyer", elmntStudentInfmFlyer, "Student Information Flyer", driver);
		Button.verify("Course finder preview", elmntCourseFinder, "Course Finder Preview", driver);
		Button.verify("Cancel button", elmntCancel, "Cancel", driver);
		Button.verify("Submit", elmntSubmit, "Submit", driver);		
	}	
	
	//Validate the Class section before the changes
	public void preSubmitClassSectionPropertiesSettings(Map<String,String> dataMap, String strClassName, String strClassTerm, String strClassTermYear, String strClassMeeting, String strClassSectionEndDate) throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>preSubmitClassSectionPropertiesSettings", driver);
		
		Element.verify("Edit class section", driver, "XPATH", "//span[@class='breadcrumb']//b[contains(text(),'Edit Class Section')]");
		
		String changeClassName = dataMap.get(strClassName);		
		String classNameTerm = dataMap.get(strClassTerm);
		String classTermYear = dataMap.get(strClassTermYear);
		String classMeetingTimes = dataMap.get(strClassMeeting);
		String classEndDate = dataMap.get(strClassSectionEndDate);
		
		//Clear the class name textbox and entering the new name
		TextBox.clearValue("Clear the className", elmntClassNameBox, driver);
		TextBox.enterValue("Enter the new class name", elmntClassNameBox, changeClassName, driver);

		//Entering the term class section value
		TextBox.clearValue("Clear the term", elmntTermBox, driver);
		TextBox.enterValue("Entering the term ", elmntTermBox, classNameTerm, driver);
		
		Combobox.selectItemByValue("Year", elmntYearBox, classTermYear, driver);
		
		TextBox.JSEnterValue("Enter Calendar Section end date", driver, elmntClassSectionEndDate, classEndDate);
		
		Combobox.selectItemByValue("Meeting times", elmntMeetingBox, classMeetingTimes, driver);		
		
		//Select any checkbox who were not the member of the class section
		Checkbox.check("Designate members", elmntNonMemberCheckbox, driver);						
	}
	
	//Validate the Class section after the changes
	public void postSubmitClassSectionPropertiesSettings(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>postSubmitClassSectionPropertiesSettings", driver);
		String changeClassName = dataMap.get("NewChangeClassName");		
		String classNameTerm = dataMap.get("NewClassSectionTerm");
		String classTermYear = dataMap.get("NewClassSectionTermYear");
		String classMeetingTimes = dataMap.get("NewClassSectionMeeting");
		
		Element.verify("Class Name", elmntClassNameBox, changeClassName, driver);
		Element.verify("Terms", elmntTermBox, classNameTerm, driver);
		
		Combobox.verifySelectedItem("Selected item in combo box", elmntYearBox, classTermYear, driver);
		Element.verify("Selected Meeting time", driver, "XPATH", "//table[.//table//td[contains(.,'Meeting Times:')]]//table//b[text()='"+classMeetingTimes+"']");		
	}
	
		//Create Copy class section
		public void createCopyClassSection(Map<String,String> dataMap) throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>createCopyClassSection", driver);
			String strCopyClassname = dataMap.get("CopyclassSection");
			String classNameTerm = dataMap.get("CopyclassSectionTerm");
			String classTermYear = dataMap.get("CopyClassSectionTermYear");
			String classMeetingTimes = dataMap.get("CopyClassSectionMeeting");
			String strClassSectionEndDate = dataMap.get("NewClassSectionEndDate");

			TextBox.enterValue("Enter the Copy class name", elmntClassNameBox, strCopyClassname, driver);			

			TextBox.enterValue("Entering the term ", elmntTermBox, classNameTerm, driver);
			
			Combobox.selectItemByValue("Year", elmntYearBox, classTermYear, driver);
			
			Combobox.selectItemByValue("Meeting times", elmntMeetingBox, classMeetingTimes, driver);
			
			//Enter the date
			TextBox.JSEnterValue("Enter Calendar Section end date", driver, elmntClassSectionEndDate, strClassSectionEndDate);
			
			//Select any checkbox who were not the member of the class section
			Checkbox.check("Designate members", elmntNonMemberCheckbox, driver);			

		}
	
	//Revert back the class section settings
	public void resetClassSectionProperties(Map<String, String> dataMap)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>resetClassSectionProperties", driver);
		String dftClassname = dataMap.get("ClassName");
		String classNameTerm = dataMap.get("DefaultClassSectionTerm");
		String classTermYear = dataMap.get("DefaultClassSectionTermYear");
		
		//Clear the class name textbox and entering the new name
		TextBox.clearValue("Clear the className", elmntClassNameBox, driver);
		TextBox.enterValue("Enter the new class name", elmntClassNameBox, dftClassname, driver);
		
		//Entering the term class section value
		TextBox.clearValue("Clear the term", elmntTermBox, driver);
		TextBox.enterValue("Entering the term ", elmntTermBox, classNameTerm, driver);
		
		Combobox.selectItemByValue("Year", elmntYearBox, classTermYear, driver);
		
		//Selecting the meeting times
		Combobox.selectItemByValue("Designate members", elmntMeetingBox, "- -", driver);
	}
	
	//Navigate to import roaster page by clicking import roaster button
	public ImportRoasterPage gotoImportRoasterPage() throws InterruptedException
	{		
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>gotoImportRoasterPage", driver);
		Button.click("Click import roaster button", elmntImportRoster, driver);
		return PageFactory.initElements(driver, ImportRoasterPage.class);
	}	
	
	//Validate the success notification after creating the template
	public void validateNotificationOnValidTemplate(Map<String,String> dataMap) throws InterruptedException
	{		
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateNotificationOnValidTemplate", driver);
		String className = dataMap.get("ClassName");
		String confirmationMsg = "Confirmation emails have been sent to the students."; 
		Element.verify("Students message", driver.findElement(By.xpath("//span[@class='alert']/p[contains(text(),'3 students have been added to "+className+".')]")), "3 students have been added to "+className+".", driver);
		Element.verify("Students message", driver.findElement(By.xpath("//span[@class='alert']/p[contains(text(),'Confirmation emails have been sent to the students.')]")), confirmationMsg, driver);		
	} 
	
	//Validate warning message for Finished class section
	public void validateDesignateSectionStatus(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateDesignateSectionStatus", driver);		
			
		//Selecting finished radio button
		driver.findElement(By.xpath("//input[@id='state' and @value='finished']")).click();
		
		Sync.waitForSeconds(3, driver);
		Alert alert = validateWarningMessage();
		alert.dismiss();	
		
		Element.verify("Class section status-Active", driver, "XPATH", "//input[@checked='checked' and @value='started']");
		
		//Finished radio button - Class Section Status
		driver.findElement(By.xpath("//input[@id='state' and @value='finished']")).click();
			
		alert = validateWarningMessage();
		alert.accept();		
		
		//Enter Class section end date 
		String strClassSectionEndDate = dataMap.get("NewClassSectionEndDate");
		TextBox.JSEnterValue("Enter Calendar Section end date", driver, elmntClassSectionEndDate, strClassSectionEndDate);
	}		

	//Click "Submit" button
	public CourseAdminClassSectionPage clickSubmitButton() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>clickSubmitButton", driver);
		Element.verify("Submit button", elmntSubmit, "Submit", driver);
		Button.click("Click Submit", elmntSubmit, driver);		
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());			
			alert.accept();		
		}
		catch(Exception e)
		{
			
		}
		return PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
	}

	//Click "Cancel" button
	public CourseAdminClassSectionPage clickCancelButton() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>clickCancelButton", driver);
		Element.verify("Cancel button", elmntCancel, "Cancel", driver);
		Button.click("Click Cancel", elmntCancel, driver);		
		return PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
	}
	
	//Navigate to course finder preview page
	public CourseFinderPreviewPage gotoCourseFinderPreviewWindow() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>gotoCourseFinderPreviewWindow", driver);
		Button.click("Course finder preview", elmntCourseFinder, driver);
		String strCourseFinderWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strCourseFinderWindow);
		return PageFactory.initElements(driver, CourseFinderPreviewPage.class);
	}
	
	//Navigate to Student information flyer page
	public StudentInformationFlyerPage gotoStudentInformationFlyer() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>gotoStudentInformationFlyer", driver);
		Button.click("Student information flyer", elmntStudentInfmFlyer, driver);		
		String strStudentInformationFlyerWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strStudentInformationFlyerWindow);
		return PageFactory.initElements(driver, StudentInformationFlyerPage.class);
	}
	
	//Validate the alert  warning
	public Alert validateWarningMessage() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateWarningMessage", driver);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());	
		return alert;
	}
	
	
	//Assigning assignment to the copy class section - New functionality added: Oct 05
	public void assignAssigmentCopyClassSection(Map<String,String> dataMap,String strAssignmentName)
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>assignAssigmentCopyClassSection", driver);
		String strAssigment = dataMap.get(strAssignmentName);		
		Checkbox.check("Select the assignment", driver.findElement(By.xpath("//table[@class='plain-table']//tr[.//a[text()='"+strAssigment+"']]//input[@name='ag_sel']")), driver);
	}
	
	public void clickSelectAssignmentsbtn()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>clickSelectAssignmentsbtn", driver);
		Button.click("Select Assignments", elmntSelectAssignments, driver);		
	}
	
	//Click "Submit" button in assignment page
	public CourseAdminClassSectionPage clickAssignmentSubmitButton() throws InterruptedException
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>clickAssignmentSubmitButton", driver);
		Element.verify("Submit button", elmntAssignSubmit, "submit", driver);
		Button.click("Click Submit", elmntAssignSubmit, driver);		
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());			
			alert.accept();			
		}
		catch(Exception e)
		{
			
		}
		return PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
	}
	
	//Validate accessible to students
	public void validateAccessibleStudents()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateAccessibleStudents", driver);		
		//Asccesible to students
		driver.findElement(By.xpath("//input[@id='student-access' and @value='false']")).click();		
	}
	
	//Validate Student Self-Registration
	public void validateStudentSelfRegistration()
	{
		ResultUtil.report("INFO", "CourseAdminClassSectionEditPage>validateStudentSelfRegistration", driver);		
		//Student Self-Registration
		driver.findElement(By.xpath("//input[@id='self-registration' and @value='false']")).click();		
	}
}

	