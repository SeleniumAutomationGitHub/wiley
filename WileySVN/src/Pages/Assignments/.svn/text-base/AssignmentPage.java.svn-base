package Pages.Assignments;


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

import Pages.Common.Initializer;
import Pages.Common.QuestionPage;
import Pages.SnapwizIntegration.AssignOrionPage;
import Pages.SnapwizIntegration.ORIONAssignmentPropertiesPage;
import Pages.SnapwizIntegration.StudentViewChooseClassSection;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Toolbox.Browser;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Listbox;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.Window;

public class AssignmentPage extends Initializer {
	
	String strSection="//table[contains(@class,'plain-table')]/tbody[./tr/td[.='ORION']]";
	String strAssignmentPolicesXPath="//tr[./td[.='Assignment Policies']]";
	
	@FindBy(how = How.ID, using = "Create_New_Assignment")
	private WebElement btnCreatenewassignment;	
	
	@FindBy(how = How.NAME, using= "author")
	private WebElement optionSource;		
	
	@FindBy(how = How.ID, using = "applyAGListSetings")
	private WebElement btnGo;
			
	@FindBy(how = How.NAME, using = "showperpage")
	private WebElement drpdownShowPerPage;
	
	@FindBy(how = How.ID, using = "Go_To_Student_View")
	private WebElement elmntGotoStudentViewbtn;
	
	@FindBy(how= How.XPATH, using = "//tr[.//td/b[.='Late Score Policy']]//following-sibling::span[2]")
	private WebElement scoreReduction;
	
	@FindBy(how = How.XPATH, using = "//li[.='Questions']")
	private WebElement linkQuestion;
	
	@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
	private WebElement elmntReturnBlackboard;
	
	@FindBy(how = How.NAME, using= "stauts")
	private WebElement StatusOption;
	
	@FindBy(how=How.NAME, using="class")
	private WebElement classListBox;
	
	@FindBy(how=How.NAME,using="showperpage")
	private WebElement ShowPerPage;
	
	@FindBy(how=How.ID_OR_NAME, using="Submit")
	private WebElement btnSubmit;
	
	String strContentAreaXpath="//table[@class='content-area']";
	
	public AssignmentPage(WebDriver driver){
		super(driver);
	}
	
	
	//Description: Clicking on Create New Assignment button from the Assignment page
	public CreateEditAssignmentPage goToCreateEditAssignmentPage() throws Exception {
		ResultUtil.report("INFO", "AssignmentPage>goToCreateEditAssignmentPage", driver);
		Button.click("Create New Assignment", btnCreatenewassignment, driver);
		
		return PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	}
	
	//Description: Clicking on Create New Assignment button from the Assignment page
	public CreateReadingsAssignment goToCreateReadingsAssignment() {
		ResultUtil.report("INFO", "AssignmentPage>goToCreateReadingsAssignment", driver);
		btnCreatenewassignment.click();
		return PageFactory.initElements(driver, CreateReadingsAssignment.class);
	}
	
	/*public void goToSurveyPage() {
		btnCreatenewassignment.click();
		
	}*/
	
	//Description: Re-login as Instructor and selecting assignment list from Assignment page
	public void goToAssignmentList(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO","AssignmentPage >>> goToAssignmentList", driver);
		
		if(driver.findElement(By.name("author")).isDisplayed()){			
			Listbox.deselectAll(optionSource, "All Sources", driver);		
			Listbox.selectItemByValue("Me", optionSource, "Me", driver);
		}
		
		String AllQuestionPerPage = dataMap.get("ShowperpageAll");
		Combobox.selectItemByValue("ShowperpageAll", drpdownShowPerPage, AllQuestionPerPage, driver);
		Button.click("Click Go", btnGo, driver);
		
	}
	
	//Description: Selecting Assignment and Editing the Assignment
	public void  selectAssingmentInList(Map<String,String> dataMap,String strAssignmentNames) throws Exception{
		String strAssignmentName = dataMap.get(strAssignmentNames);
		String strClassName = dataMap.get("ClassName");		
		WebElement editAssignment=driver.findElement(By.xpath("//table[2]//a[.='"+strAssignmentName+"']//parent::td//following-sibling::td[.='"+strClassName+"']//following-sibling::td[2]//select"));
		String strEditAssignment = "Edit Assignment";
		Combobox.selectItemByValue("Edit Assignment",editAssignment, strEditAssignment, driver);
	}
	
	//Description:Selecting Assignment which is not assigned to class
	public void selectAssignmentEditNotAssignedToClass(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>selectAssignmentEditNotAssignedToClass", driver);
		String strAssignmentName = dataMap.get("AsgntName");
		String strSourceName = dataMap.get("SourceName");		
		WebElement editAssignment=driver.findElement(By.xpath("//table[2]//a[.='"+strAssignmentName+"']//parent::td//following-sibling::td[.='"+strSourceName+"']//following-sibling::td[4]//select"));
		String strEditAssignment = "Edit Assignment";
		Combobox.selectItemByValue("Edit Assignment",editAssignment, strEditAssignment, driver);
		
	}
	//Description: Clicking Edit Assignment on Go Action Button
	public void selectGoActionButton(Map<String,String> dataMap,String strAssignment){
		ResultUtil.report("INFO", "AssignmentPage>>>selectGoActionButton", driver);
		String strAssignmentName = dataMap.get(strAssignment);
		String strClassName = dataMap.get("ClassName");		
		WebElement btnGoEditAssignment=driver.findElement(By.xpath("//table[2]//a[.='"+strAssignmentName+"']//parent::td//following-sibling::td[.='"+strClassName+"']//following-sibling::td[2]//a[.='Go']"));
		Button.click("Edit Assignment", btnGoEditAssignment, driver);
		
	}
	
	//Description: Clicking Edit Assignment on Go Action Button where the assignment is not assigned to class
	public void selectGoActionButtonNotAssignedToClass(Map<String,String>dataMap, String strAssignmnetsName){
		ResultUtil.report("INFO", "AssignmentPage>>>selectGoActionButtonNotAssignedToClass", driver);
		String strAssignmentName = dataMap.get(strAssignmnetsName);
		String strSourceName = dataMap.get("SourceName");		
		WebElement btnGoEditAssignment=driver.findElement(By.xpath("//table[2]//a[.='"+strAssignmentName+"']//parent::td//following-sibling::td[.='"+strSourceName+"']//following-sibling::td[4]//a[.='Go']"));
		Button.click("Edit Assignment", btnGoEditAssignment, driver);
		
	}
	
	//Description: Verifying the alert message
	public void EditAssignmentAlertMessage(Map<String,String> dataMap,String strAssignmentName){
		ResultUtil.report("INFO", "AssignmentPage>>>EditAssignmentAlertMessage", driver);
		String strAssgnName= dataMap.get(strAssignmentName).trim();
		driver.findElement(By.xpath("//a[.='"+strAssgnName+"']//parent::td//following-sibling::td[.='Assigned']//following-sibling::td[3]//div[@title='Go']")).click();
		Sync.waitForSeconds(2, driver);
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);		
		
		driver.switchTo().alert().accept();
	}
	
	//Description: Verify Assignment is created and displayed
	public void verifyAssignmentDisplayed(Map<String,String> dataMap, String strAssignmentNames) throws Exception{
		ResultUtil.report("INFO", "AssignmentPage>>>verifyAssignmentDisplayed", driver);
		String strAssignmentName = dataMap.get(strAssignmentNames);
		String strClassName = dataMap.get("ClassName");
		
		if (Element.verify("Assignment", driver, "xpath", "//table[2]//td[.='"+strClassName+"']//parent::tr//a[.='"+strAssignmentName+"']")){			
			ResultUtil.report("PASS", "Assignment is created and displayed", driver);
		}
		else if(Element.verify("Assignment", driver, "xpath", "//table[2]//tr//a[.='"+strAssignmentName+"']")){
			ResultUtil.report("PASS", "Assignment is created and displayed", driver);
			
		}else{
			ResultUtil.report("FAIL", "Assignment is not created", driver);
		}
	}
	
	//Description: SelectAssignment 
	public void selectAssignmentLink(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPage>>>selectAssignmentLink", driver);
		String strAssignmentName = dataMap.get("AsgntName");
		String strClassName = dataMap.get("ClassName");
		Browser.scrollToObject("Assignment Name",driver.findElement(By.xpath("//table[2]//td[.='"+strClassName+"']//parent::tr//a[.='"+strAssignmentName+"']")), driver);
		WebElement assignmentCreated = driver.findElement(By.xpath("//table[2]//td[.='"+strClassName+"']//parent::tr//a[.='"+strAssignmentName+"']"));		
		Link.click(strAssignmentName, assignmentCreated, driver);
		
	}
	
	//Description: Verify the preview window and total score earned
	public void verifyPreviewWindowAndTotalScore() {
		ResultUtil.report("INFO", "AssignmentPage>>>verifyPreviewWindowAndTotalScore", driver);
		String strAssignmentPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentPreviewWindow);
		focusAglistframe();
		WebElement reviewScoreLink = driver.findElement(By.xpath("//a[@name='report']"));
		Link.verify("View Score Link", reviewScoreLink, driver);
		Link.click("Review Score Link", reviewScoreLink, driver);
		
		focusAgbodyFrame();
		WebElement totalScoreValue = driver.findElement(By.xpath("//table[@id='selenium_review_score_table']//tr[.//td//b[.='TOTAL SCORE']]//td[.//b[@id='selenium_total_max_score']]"));
		ResultUtil.report("PASS", totalScoreValue.getText(), driver);
	}
	
	
	
	//Description: Validate the Orion Assignment
	public int validateOrionAssignments(){
		ResultUtil.report("INFO", "AssignmentPage>>>validateOrionAssignments", driver);
		
		switchContentFrame();
		
		WebElement elmntOrionRowValue = null;
		 
		int i = 0; 
		try{
		List<WebElement> elmntListOrionAssignments = driver.findElements(By.xpath(strSection+"//tr[./td/span[.='ORION']]"));
		
			for(i=1;i<elmntListOrionAssignments.size();)
			{
				elmntOrionRowValue = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]["+i+"]"));
				WebElement elmntAssignmentName = elmntOrionRowValue.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]["+i+"]//td[contains(.,'ORION')][1]"));
				ResultUtil.report("PASS", elmntAssignmentName.getText(), driver);
				Element.verify("Action dropdown", driver, "XPATH", strSection+"//tr[./td/span[.='ORION']]["+i+"]/td/select[@class='action_combobox']");
				validateOrionActionDropdown(i);
				break;
			}
		}
		catch(Exception e){}
		return i;
	}	
	
	//Description: Validates the Orion Action Dropdown
	public void validateOrionActionDropdown(int intOrionAssignmentValue){
		ResultUtil.report("INFO", "AssignmentPage>>>validateOrionActionDropdown", driver);
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frContentFile");
		}
		catch(Exception e){}
		WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]["+intOrionAssignmentValue+"]/td/select[@class='action_combobox']"));
		Select select = new Select(elmntActionDropdown);
		List<WebElement> actionsValuesDropdown = select.getOptions();
		for(WebElement actionvalue:actionsValuesDropdown)
		{
			ResultUtil.report("PASS", actionvalue.getText(), driver);
			
			//Assign and Properties menu should display in "Action" dropdown.
			Element.verify("Assign", actionvalue, "Assign", driver);
			Element.verify("Properties", actionvalue, "Properties", driver);

			//Preview Assignment, Copy & Edit  and Delete Assignment menu should not display in "Action" dropdown.
			Element.verify("Preview Assignment", actionvalue, "Preview Assignment", driver);
			Element.verify("Copy & Edit", actionvalue, "Copy & Edit", driver);
			Element.verify("Delete Assignment", actionvalue, "Delete Assignment", driver);	
		}
	}
	
	//Description: Clicking on Properties in Action dropdown in Orion Assignment Properties Page
	public ORIONAssignmentPropertiesPage selectActionsByProperties(String strActionValue, int intOrionAssignmentValue) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsByProperties", driver);
		if(strActionValue.equals("Properties"))
		{
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]["+intOrionAssignmentValue+"]/td/select[@class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]["+intOrionAssignmentValue+"]//a[text()='Go']"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}
		return PageFactory.initElements(driver, ORIONAssignmentPropertiesPage.class);
	}

	private void switchContentFrame(){
		driver.switchTo().defaultContent();
		
		try{driver.switchTo().frame("container");}catch(Exception e){}
		
		try{driver.switchTo().frame("frameContentFile");}catch(Exception e){}
		
		try{driver.switchTo().frame("contentFrame");}catch(Exception e){}
	}
	
	//Description: Filtering unassigned assignments 
	public void validateUnassignedAssignments(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>validateUnassignedAssignments", driver);
		int i=0;
		
		switchContentFrame();
		
		try{
			List<WebElement> elmntUnassignedOrionAssignments = driver.findElements(By.xpath(strSection+"//tr[./td/span[.='ORION']]//td[./span[text()='-']]"));
			for( i=1;i<elmntUnassignedOrionAssignments.size();i++)
			{
				WebElement elmntChooseChapter = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION'] and ./td[./span[text()='-']]]["+i+"]/td[1]"));			
				ResultUtil.report("MESSAGE", elmntChooseChapter.getText(), driver);
				if((i==1))
				dataMap.put("Chapter Choosed", elmntChooseChapter.getText());

				if((i==2))
					dataMap.put("First Assignment", elmntChooseChapter.getText());
				
				if((i==3))
					dataMap.put("Second Assignment", elmntChooseChapter.getText());
				
				if((i==4))
					dataMap.put("Fourth Assignment", elmntChooseChapter.getText());	
				System.out.println("!!!");				
			}
		}
		catch(Exception e){}		
	}
	
	//Description: Clicking on Assign in Action dropdown in Assign orion Page
	public AssignOrionPage selectActionsByAssign(String strActionValue, int intOrionAssignmentValue, Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsByAssign", driver);
		String strAssignmentName=dataMap.get("Chapter Choosed");
		
		if(strActionValue.equals("Assign")) {
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//select[./option[text()='Assign'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//td[.//select[./option[text()='Assign']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}
		
		return PageFactory.initElements(driver, AssignOrionPage.class);
	}
	
	//Description: Validate Assigned Assignments
	public void validateAssignedAssignments(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>validateAssignedAssignments", driver);
		String strAssignmentName=dataMap.get("Chapter Choosed");
		Sync.waitForObject(driver, "Assignment table", "XPATH", "//table[contains(@class,'plain-table')]");
		Element.verify("Assignment Name", driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]/td[.='"+strAssignmentName+"']")), driver);
		Element.verify("Assigned Assignment", driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION']]/td[.='"+strAssignmentName+"']/following-sibling::td[4]")), "Assigned", driver);			
	}
	
	//Description: Clicking on Edit Availability in Action dropdown in Assign orion Page
	public AssignOrionPage selectActionsByEditAvailability(String strActionValue, int intOrionAssignmentValue, Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsByEditAvailability", driver);
		 String strAssignmentName=dataMap.get("Chapter Choosed");
		 
		 if(strActionValue.equals("Edit Availability")){
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//select[./option[text()='Edit Availability'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//td[.//select[./option[text()='Edit Availability']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}
		 
		return PageFactory.initElements(driver, AssignOrionPage.class);
	}
	
	//Description: Select the Action dropdown by selecting unassign option
	public void selectActionsByUnassign(String strActionValue, int intOrionAssignmentValue, Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsByUnassign", driver);
		 String strAssignmentName=dataMap.get("Chapter Choosed");
		 
		 if(strActionValue.equals("Unassign")){
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//select[./option[text()='Unassign'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//td[.//select[./option[text()='Unassign']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}		
	}
	
	//Description: Validate Warning message
	public void unassignedWarningMessage(){
		ResultUtil.report("INFO", "AssignmentPage>>>unassignedWarningMessage", driver);
		Element.verify("Unassigned warning", driver.findElement(By.xpath("//span[@class='alert']")), driver);
	}
			
	//Description: Navigate to student view page bu clicking go to student view button
	public StudentViewChooseClassSection goToStudentView() {
		elmntGotoStudentViewbtn.click();
		return PageFactory.initElements(driver, StudentViewChooseClassSection.class);
	}
	
	//Description: Validating Orion Assignment on Disabled assignments
	public void validateOrionAssignmentOnDisableUnassign(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>validateOrionAssignmentOnDisableUnassign", driver);
		String strAssignmentName=dataMap.get("Chapter Choosed");
		Element.verify("Assignment Name", driver, "XPATH", strSection+"//tr[./td/span[.='ORION']]/td[.='"+strAssignmentName+"']");
	}
	
	//Description: Focusing Main Frame
	private void focusMainframe(){
		ResultUtil.report("INFO", "AssignmentPage>>>focusMainframe", driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		driver.switchTo().frame("mainframe");
		ResultUtil.report("PASS","Focused to MainFrame", driver);
	}
	
	//Description: Focusing Ag_Nav_Top Frame
	private void focusAg_nav_top(){
		ResultUtil.report("INFO", "AssignmentPage>>>focusAg_nav_top", driver);
		focusMainframe();
		driver.switchTo().frame("ag_nav_top");
	}
	
	//Description: Focusing Ag_Body Frmae
	private void focusAgbodyFrame(){
		ResultUtil.report("INFO", "AssignmentPage>>>focusAgbodyFrame", driver);
		focusMainframe();
		driver.switchTo().frame("agrootframe");
		driver.switchTo().frame("agarea");
		driver.switchTo().frame("agbody");
	}
	
	//Description: Focusing Ag_List Frame
	private void focusAglistframe(){
		ResultUtil.report("INFO", "AssignmentPage>>>focusAglistframe", driver);
		focusMainframe();
		driver.switchTo().frame("agrootframe");
		driver.switchTo().frame("aglist");
		ResultUtil.report("PASS","Focused to Aglist Frame", driver);
	}
	
	//Description: Verifies the Student Access setting in Preview window
	public void verifyStudentAccessSettingInPreviewWindow(){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyStudentAccessSettingInPreviewWindow", driver);
		String strAssignmentPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentPreviewWindow);
		focusAgbodyFrame();
		Element.verify("Student Access Setting", driver, "xpath", "//tr[./td//b[text()='Student Access Settings']]");
		String strStudentAccessLate = "Yes. Attempts after Due Date will be Marked Late";
		String strStudentAccessView = "Yes. View Only";
		String strStudentAccessAssistance = "Yes. View with Assistance";
		WebElement studentAccessSetting = driver.findElement(By.xpath("//tr[./td[.='Student Access After Due Date:']]//following-sibling::td[3]"));
					
		if(Element.verify("Verify", studentAccessSetting, strStudentAccessLate, driver)){
			ResultUtil.report("MESSAGE","Student Access After Due Date:", driver);
		}
		else if(Element.verify("Verify", studentAccessSetting, strStudentAccessView, driver)){
			ResultUtil.report("MESSAGE","Student Access After Due Date:", driver);
		}
		else if(Element.verify("Verify", studentAccessSetting, strStudentAccessAssistance, driver)){
			ResultUtil.report("MESSAGE","Student Access After Due Date:", driver);
		}
	}
		
	//Description: Verifies the Graded Assignment Policies
	public void verifyGradedAssignmentPolicies(){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyGradedAssignmentPolicies", driver);
		String strAssignmentPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentPreviewWindow);
		focusAgbodyFrame();
		Element.verify("Verify Graded Value", driver, "xpath", strAssignmentPolicesXPath+"//following-sibling::tr[.//td[.='Graded:']]");
		WebElement gradedValue = driver.findElement(By.xpath(strAssignmentPolicesXPath+"//following-sibling::tr[.//td[.='Graded:']]"));
		ResultUtil.report("PASS",gradedValue.getText(), driver);	
	}
	
	//Description: Verifying the Timed Assignment is displayed		
	public void verifyTimedAssignmentDisplayed(){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyTimedAssignmentDisplayed", driver);			
		String strTimedAssignmentName = "TestAutomation (Timed)";
		
		if (driver.findElement(By.xpath("//table[2]//a[.='"+strTimedAssignmentName+"']")).isDisplayed()){	
			ResultUtil.report("PASS","TestAutomation (Timed) is created", driver);
		}
		else{
			ResultUtil.report("FAIL","TestAutomation (Timed) is not created", driver);
		}
	}
	
	//Description: Verifies the late score policies
	public void verifyLateScorePolicy(){
		ResultUtil.report("INFO", "AssignmentPage>>>VerifyLateScorePolicy", driver);
		String strAssignmentPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentPreviewWindow);
		focusAgbodyFrame();
		
		if(Element.verify("Late Score Policy", driver, "xpath", strAssignmentPolicesXPath+"//following-sibling::tr//td/b[.='Late Score Policy']")){
			Element.verify("Reduce Score", scoreReduction, driver);
			ResultUtil.report("PASS",scoreReduction.getText(), driver);	
		}
		else{
			ResultUtil.report("FAIL","Late Score Policy is not Displayed", driver);
		}	
	}
	
	//Description: Verifies the due date
	public void verifyDueDate(){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyDueDate", driver);
		String strAssignmentPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentPreviewWindow);
		focusAgbodyFrame();
		
		String strDueDateXPath="//tr[./td[.='Student Access Settings']]//following-sibling::tr//td[.='Due Date:']//following-sibling::td//span";
		if(Element.verify("Due Date", driver, "xpath", strDueDateXPath)){
			WebElement dueDate = driver.findElement(By.xpath(strDueDateXPath));
			String strUnlimited = "Unlimited";
			Element.verify("Verify", dueDate, strUnlimited, driver);
		}	
	}
	
	//Description: Verifies the study objective enabled
	public void verifyStudyObjectiveEnabled(){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyStudyObjectiveEnabled", driver);
		String strAssignmentPreviewWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentPreviewWindow);
		focusAgbodyFrame();
		String strStudyObjectiveReportingXPath="//tr[./td[.='Assignment Policies']]//following-sibling::tr[.//td[.='Study Objective Reporting:']]";
		if(Element.verify("Study Objective Reporting", driver, "xpath", strStudyObjectiveReportingXPath)){			
			WebElement reportingEnabled = driver.findElement(By.xpath(strStudyObjectiveReportingXPath+"//following-sibling::td/span"));			
			String strEnabled = "Enabled";
			Element.verify("Study Objective", reportingEnabled, strEnabled, driver);	
		}
		else{
			ResultUtil.report("FAIL","Study Objective is not Selected", driver);
		}	
	}
	
	//Description: Selects Question link in Question Page
	public QuestionPage selectionQuestionLink(){
		ResultUtil.report("INFO", "CreateEditAssignment>>>>selectionQuestionLink", driver);
		Link.click("Question link", linkQuestion, driver);
		return PageFactory.initElements(driver, QuestionPage.class);
	}
	
	//Description: Navigates to Assignment window
	public void navigateToAssignmentWindow(){
		ResultUtil.report("INFO", "AssignmentPage>>>clickNext", driver);
		String strWindowHandle=driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("Assignment window", driver, strWindowHandle );	
	}
	
	//Description: Closes main window
	public void closeWindow(){
		ResultUtil.report("INFO", "AssignmentPage>>>closeWindow", driver);
		this.driver.close();
	}
	
	//Description: Verifies new assignment displayed
	public void verifyNewAssignmentDisplayed(Map<String,String> dataMap) throws Exception{
		String strAssignmentName = dataMap.get("NewAssignName");
		if (driver.findElement(By.xpath("//table[2]//a[.='"+strAssignmentName+"']")).isDisplayed()){			
			ResultUtil.report("PASS","Assignment is created and displayed", driver);
		}
		else{
			ResultUtil.report("FAIL","Assignment is not created", driver);
		}
	}
	
	//Description:	Return to Blackboard page
	public BlackBoardIntegrationPage returnToBlackboard(){
		ResultUtil.report("INFO", "AssignmentPage>>>returnToBlackboard", driver);
		Button.click("Return to Blackboard", elmntReturnBlackboard, driver);
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
	}
			
	//Description: Navigate to Student Assignment Page
	public StudentAssignmentPage goToStudentAssignmentPage(){
		ResultUtil.report("INFO", "AssignmentPage>>>goToStudentAssignmentPage", driver);
		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}
	
	//Description: Verifies the editable due date
	public void verifyEditableDueDate(){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyEditableDueDate", driver);
		String pastDueDate=driver.findElement(By.xpath("//div[contains(@id,'inputs_pastdd')]")).getText();
		Element.verify("Editable due date", driver, "XPATH", "//input[contains(@class,'small')]");
		ResultUtil.report("PASS","The past due date is " +pastDueDate , driver);		
	}
	
	//Description: Selects test matching assignment
	public void selectTestMatchingAssignment(Map<String, String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>selectTestMatchingAssignment", driver);
		String strAssignmentName = dataMap.get("AsgntNameMatching");
		String strClassName = dataMap.get("ClassName");
		WebElement assignmentCreated = driver.findElement(By.xpath("//table[2]//td[.='"+strClassName+"']//parent::tr//a[.='"+strAssignmentName+"']"));		
		Link.click(strAssignmentName, assignmentCreated, driver);
	}

	//Description: Focus on assignment window
	public void focusAssignmentWindow(){
		ResultUtil.report("INFO", "AssignmentPage>>>focusAssignmentWindow", driver);
		Window.focusWindow("Assignment Window", driver, driver.getWindowHandles().toArray()[1].toString());
	}
	
	//Description: verifies alternative answers are displayed
	public void verifyAlternativeAnswer(){
		ResultUtil.report("INFO", "AssignmentPAge>>>verifyAlternativeAnswer",driver);
		focusAgbodyFrame();
		WebElement asterik=driver.findElement(By.xpath("//div[@id='_intjsTooltip_1__CLIENT_']"));
		
		if(Element.verify("Alternative Answer Asterik", asterik, driver)){
			Element.mouseOver("Alternative Answer Asterik", asterik, driver);
		}
		else{
			ResultUtil.report("FAIL", "Alternative Answer Asterik does Not Exist", driver);
		}
	}
	
	//Description: Clicking on Go button
	public void clickGo(){
		ResultUtil.report("INFO", "AssignmentPAge>>clickGo",driver);
		Button.click("GO", btnGo, driver);
	}
	
	//Description: clicking on not assigned assignment link
	public void selectNotAssignedAssignmentLink(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPAge>>>selectNotAssignedAssignmentLink",driver);
		String strAssignmentName = dataMap.get("AsgntName").trim();
		WebElement assignmentCreated = driver.findElement(By.xpath("//a[.='"+strAssignmentName+"']"));	
		Link.click(strAssignmentName, assignmentCreated, driver);
	}
	
	//Description: Select Assignment go button
    public void selectAssignmentGobutton(Map<String,String> dataMap, String strAssignmentName){
   	 ResultUtil.report("INFO", "AssignmentPage>>>selectAssignmentGobtn", driver);
   	 String assgnName=dataMap.get(strAssignmentName);
   	 WebElement go=driver.findElement(By.xpath("//a[.='"+assgnName+"']//parent::td//following-sibling::td[.='Assigned']//following-sibling::td[3]//div[@title='Go']"));
   	 Button.click("Go", go, driver);
    }
    
    //Description: select edit assignment in actions dropdown
	public void selectActionsEditAssignment(Map<String,String> dataMap, String strAssignmentName){
		 ResultUtil.report("INFO", "AssignmentPAge>>>selectActionsEditAssignment", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement editAssignment=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[.='Assigned']//following-sibling::td[3]//select"));
		Combobox.selectItemByValue("Edit Assignment",editAssignment, "Edit Assignment", driver);
	}
	
	//Description: select Properties in actions dropdown
	public void selectActionsAssignmentProperties(Map<String,String> dataMap, String strAssignmentName){
		ResultUtil.report("INFO", "AssignmentPAge>>>selectActionsAssignmentProperties", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement assignmentProperties=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[7]//select"));
		Combobox.selectItemByValue("Properties", assignmentProperties, "Properties", driver);
	}
	
	//Description: select Generate Printed Test in actions dropdown
	public void selectActionsGeneratePrintedTest(Map<String,String> dataMap,  String strAssignmentName ){
		ResultUtil.report("INFO", "AssignmentPAge>>>selectActionsGeneratePrintedTest", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement assignmentProperties=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[7]//select"));
		Combobox.selectItemByValue("Generate Printed Test", assignmentProperties, "Generate Printed Test", driver);
	}
	
	//Description: Verify not assigned assignment is displayed
	public void verifyNotAssignedAssignmentDisplayed(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPAge>>>verifyNotAssignedAssignmentDisplayed", driver);
		String strAssignmentName = dataMap.get("AsgntName");
		
		    if (driver.findElement(By.xpath("//table[2]//parent::tr//a[.='"+strAssignmentName+"']")).isDisplayed()){			
				ResultUtil.report("PASS", "Assignment is created and displayed", driver);
		    }
			else{
				ResultUtil.report("FAIL", "Assignment is not displayed", driver);
			}
	}
	
	//Description: select Edit Availability in actions dropdown
	public void selectActionsEditAvailability(Map<String,String> dataMap,  String strAssignmentName ){
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsEditAvailability", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement assignmentProperties=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[7]//select"));
		Combobox.selectItemByValue("Edit Availability", assignmentProperties, "Edit Availability", driver);
	}
	
	//Description: select Assign in actions dropdown
	public void selectActionsAssign(Map<String,String> dataMap,String strAssignmentName){
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsAssign", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement assignmentProperties=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[7]//select"));
		Combobox.selectItemByValue("Assign", assignmentProperties, "Assign", driver);
	}
	
	//Description: select Delete Assignment in actions dropdown
	public void selectActionsDeleteAssignment(Map<String,String> dataMap,String strAssignmentName){
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsDeleteAssignment", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement assignmentProperties=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[7]//select"));
		Combobox.selectItemByValue("Delete Assignment", assignmentProperties, "Delete Assignment", driver);			
	}
	
	//Description: select Unassign in actions dropdown
	public void selectActionsUnAssign(Map<String,String> dataMap,String strAssignmentName){
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsUnAssign", driver);
		String assign=dataMap.get(strAssignmentName);
		WebElement assignmentProperties=driver.findElement(By.xpath("//table[2]//a[.='"+assign+"']//parent::td//following-sibling::td[7]//select"));
		Combobox.selectItemByValue("Unassign", assignmentProperties, "Unassign", driver);	
		
	}
		
	//Description: Select Assignment table
	public void goToOrionAssignmentTable(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPage>>>goToOrionAssignmentTable", driver);
		try{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Frame index", 0, 5);			
		}
		catch(Exception e){}
		
		if(driver.findElement(By.name("author")).isDisplayed()){
			Listbox.selectItemByValue("Select All Sources", optionSource, "All Sources", driver);		
		}			
		Combobox.selectItemByValue("Show page", drpdownShowPerPage, "All", driver);
		Button.click("Click Go", btnGo, driver);			
	}
	
	//Description: Retrieves first assignment name in assign orion page
	public AssignOrionPage getFirstAssignmentName(String strActionValue, int intOrionAssignmentValue, Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>getFirstAssignmentName", driver);
		String strFirstAssignmentName = dataMap.get("First Assignment");
					
		if(strActionValue.equals("Assign"))
		 {
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strFirstAssignmentName+"']]//select[./option[text()='Assign'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strFirstAssignmentName+"']]//td[.//select[./option[text()='Assign']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}
		return PageFactory.initElements(driver, AssignOrionPage.class);
	}
	
	//Description: Retrieves second assignment name in assign orion page
	public AssignOrionPage getSecondAssignmentName(String strActionValue, int intOrionAssignmentValue, Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>getSecondAssignmentName", driver);
		String strSecondAssignmentName = dataMap.get("Second Assignment");
		
		if(strActionValue.equals("Assign"))
		 {
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strSecondAssignmentName+"']]//select[./option[text()='Assign'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strSecondAssignmentName+"']]//td[.//select[./option[text()='Assign']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}
		return PageFactory.initElements(driver, AssignOrionPage.class);
	}
	
	//Description: Retrieves fourth assignment name in assign orion page
	public AssignOrionPage getFourthAssignmentName(String strActionValue, int intOrionAssignmentValue, Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>getFourthAssignmentName", driver);

		String strFourthAssignmentName = dataMap.get("Fourth Assignment");
		
		if(strActionValue.equals("Assign")){
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strFourthAssignmentName+"']]//select[./option[text()='Assign'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strFourthAssignmentName+"']]//td[.//select[./option[text()='Assign']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);
		}
		return PageFactory.initElements(driver, AssignOrionPage.class);
	}
	
	
	//Description:Selecting Assignment which is not assigned to class
	public void selectEditAvailabilityAssignedToClass(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>selectAssignmentEditNotAssignedToClass", driver);
		String strAssignmentName = dataMap.get("AsgntName");
		String strAssignedXPath="//table[2]//a[.='"+strAssignmentName+"']//parent::td//following-sibling::td[.='Assigned']//following-sibling::td[3]";
		WebElement editAssignment=driver.findElement(By.xpath(strAssignedXPath+"//select"));
		String strEditAssignment = "Edit Availability";
		Combobox.selectItemByValue("Edit Availability",editAssignment, strEditAssignment, driver);
		WebElement go=driver.findElement(By.xpath(strAssignedXPath+"//a"));
		Button.click("Assignment Go", go, driver);	
	}

	//Description:Validate assignment presenece
	public void validateAssignmentPresent(Map<String,String> dataMap, String Assignment){
		ResultUtil.report("INFO", "AssignmentPage>>>validateAssignmentPresent", driver);
		String strAssignmentName = dataMap.get(Assignment);
		
		if(Element.verify("Assignment Present", driver, "XPATH", "//table[contains(@class,'plain-table')]//td[text()='"+strAssignmentName+"']")){
			ResultUtil.report("PASS", "Assignment is displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "Assignment is not displayed", driver);
		}
	}

	//Description:Validate assignment absence
	public void validateAssignmentAbsent(Map<String,String> dataMap, String Assignment){
		ResultUtil.report("INFO", "AssignmentPage>>>validateAssignmentAbsent", driver);
		String strAssignmentName = dataMap.get(Assignment);
		
		if(Element.notVerify("Assignment Present", driver, "XPATH", "//table[contains(@class,'plain-table')]//td[text()='"+strAssignmentName+"']")){
			ResultUtil.report("FAIL", "Assignment is displayed", driver);
		}
		else{
			ResultUtil.report("PASS", "Assignment is not displayed", driver);
		}
	}

	//Description:Validate assignments
	public void validateAssignedOrionAssignments(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>validateAssignedOrionAssignments", driver);
		int i=0;
		try{
			if(Element.verify("Assigned Orion", driver, "XPATH", strSection+"//tr[./td/span[.='ORION']]//td[./span[text()='Assigned']]")){
				ResultUtil.report("PASS", "Assigned orion assigments are displayed", driver);
				List<WebElement> elmntUnassignedOrionAssignments = driver.findElements(By.xpath(strSection+"//tr[./td/span[.='ORION']]//td[./span[text()='Assigned']]"));
				for( i=1;i<elmntUnassignedOrionAssignments.size();i++)
				{
					WebElement elmntChooseChapter = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION'] and ./td[./span[text()='Assigned']]]["+i+"]/td[1]"));			
					ResultUtil.report("Orion Chapters", elmntChooseChapter.getText(), driver);
					if((i==1))
					dataMap.put("Chapter Choosed", elmntChooseChapter.getText());
					if((i==2))
						dataMap.put("Second Chapter Choosed", elmntChooseChapter.getText());
										
				}
			}
			else{
				ResultUtil.report("FAIL", "Assigned orion assigments are not displayed", driver);
			}
		}
		catch(Exception e){}		
	}
	
	//Description: Select class from List Box
	public void selectClassAssignedList(Map<String,String> dataMap){
  		ResultUtil.report("INFO", "AssignmentPage>>>selectClassAssignedList", driver);
  		String strClass=dataMap.get("ClassName");
  		Sync.waitForObject(driver, "Class Section","NAME", "class");
  		Listbox.selectItemByValue("Class Section",classListBox , strClass, driver);
  	}
	
	//Description: Select All from Show Per Page
	public void SelectShowPerPage(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>SelectShowPerPage", driver);
		String strShowPerPage=dataMap.get("ShowPerPage");
		Sync.waitForObject(driver, "Show Per Page", "NAME", "showperpage");
		Combobox.selectItemByValue("Show Per Page", ShowPerPage, strShowPerPage, driver);
	}
	
	//Description: Verify Assignment is Assigned to class
	public void verifyAssignedStatusAndDelete(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>verifyAssignedStatusAndDelete", driver);
		String strAssignmentName=dataMap.get("AsgntName1");
		Sync.waitForObject(driver, "Assignment","XPATH", "//a[.='"+strAssignmentName+"']");
		String strAssignmentXPath="//a[.='"+strAssignmentName+"']//parent::td";
		WebElement elmntAssignmentStatus=driver.findElement(By.xpath("//following-sibling::td[4]"));
		String strAssignmentStatus=elmntAssignmentStatus.getText();
		
		if(strAssignmentStatus.equals("Assigned")){
			ResultUtil.report("MESSAGE", "The Assignment is Assigned to Class Section", driver);
			WebElement elmntUnassign=driver.findElement(By.xpath(strAssignmentXPath+"//following-sibling::td[7]//select"));
			Combobox.selectItemByValue("Unassign Assignment", elmntUnassign, "Unassign", driver);
			WebElement elmntGoButton=driver.findElement(By.xpath(strAssignmentXPath+"//following-sibling::td[7]//a[.='Go']"));
			Button.click("Go",elmntGoButton, driver);
			String strClassName=dataMap.get("ClassName");
			WebElement elmntClass=driver.findElement(By.xpath("//label[.='"+strClassName+"']//parent::td//input[@type='checkbox']"));
			Checkbox.check("Class Section",elmntClass , driver);
			Button.click("Submit",btnSubmit, driver);
			WebElement elmntUnassigned=driver.findElement(By.xpath("//span[contains(.,'Assignment has been unassigned successfully;')]"));
			Element.verify("Assignment UnAssigned Message", elmntUnassigned, driver);
		}
		else{
			ResultUtil.report("MESSAGE","The Assignment is not Assigned to Any Class Section", driver);
		}
	}
	
	
	//Description: Assign Assignments
	public void assignAssignments(Map<String,String> dataMap){
		ResultUtil.report("INFO", "AssignmentPage>>>assignAssignments", driver);
		int i=0;
		switchContentFrame();
		
		try{
			List<WebElement> elmntUnassignedOrionAssignments = driver.findElements(By.xpath(strSection+"//tr[./td/span[.='ORION']]//td[./span[text()='-']]"));
			for( i=1;i<elmntUnassignedOrionAssignments.size();i++)
			{
				WebElement elmntChooseChapter = driver.findElement(By.xpath(strSection+"//tr[./td/span[.='ORION'] and ./td[./span[text()='-']]]["+i+"]/td[1]"));			
				ResultUtil.report("Orion Chapters", elmntChooseChapter.getText(), driver);
				if((i==1))
					dataMap.put("First Assignment", elmntChooseChapter.getText());
				
				if((i==2))
					dataMap.put("Second Assignment", elmntChooseChapter.getText());
				
				if((i==3))
					dataMap.put("Third Assignment", elmntChooseChapter.getText());
				
				if((i==4))
					dataMap.put("Fourth Assignment", elmntChooseChapter.getText());								
			}
		}
		catch(Exception e){}		
	}
	
	//Choose Assign option
	public AssignOrionPage selectActionsByAssign(String strActionValue, Map<String,String> dataMap, String Assignment) throws InterruptedException{
		ResultUtil.report("INFO", "AssignmentPage>>>selectActionsByAssign", driver);
		String strAssignmentName=dataMap.get(Assignment);
		
		if(strActionValue.equals("Assign")) {
			WebElement elmntActionDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//select[./option[text()='Assign'] and @class='action_combobox']"));
			WebElement elmntGoBtnDropdown = driver.findElement(By.xpath(strSection+"//tr[.//td[text()='"+strAssignmentName+"']]//td[.//select[./option[text()='Assign']]]//a"));
			Select select = new Select(elmntActionDropdown);
			select.selectByVisibleText(strActionValue);	
			Button.click("Go", elmntGoBtnDropdown, driver);			
		}		
		return PageFactory.initElements(driver, AssignOrionPage.class);
	}
	
	//close the operation status window
	public void closeOperationWindow(){		
		ResultUtil.report("INFO", "AssignmentPage>>>closeOperationWindow", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		this.driver.close();	
		Window.focusWindow("Main window", driver, driver.getWindowHandles().toArray()[0].toString());
	}
	
	//Description: Select Class from the Select Assign to class screen
	public void assigntoclasssection(Map<String,String> dataMap, String strClassSection) {
		ResultUtil.report("INFO", "CreateEditAssignmentPage>>>assigntoclass", driver);
		String strClassAssignment = dataMap.get(strClassSection);			
		if(Element.verify("Class", driver, "XPATH", strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]")){	
		WebElement classChecbox = driver.findElement(By.xpath(strContentAreaXpath+"//tr[./td/b[.='"+strClassAssignment+"']]//td/input[@type='checkbox']"));	
			if(Checkbox.isUnchecked("Class Selection",classChecbox , driver)){
				Checkbox.check("Class Selection", classChecbox, driver);
			}	
		}
	}
}