package Pages.GradeBook;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class GradeBookStudyObjectivePage extends Initializer {
				
	public GradeBookStudyObjectivePage(WebDriver driver){
		super(driver);
	}
	
	String strTableClass="//table[contains(@class,'plain-table')]";
	String strTableId="//table[contains(@id,'syncTbl')]";
	
	@FindBy(how = How.ID, using = "applyGBSetings")
	private WebElement btnGo;
	
	@FindBy(how = How.ID, using = "classid")
	private WebElement elmntClassSelectorCombo;
	
	@FindBy(how = How.ID, using = "chapterSelector")
	private WebElement elmntAssignmentList;
	
	@FindBy(how=How.XPATH, using="//div[@id='breadcrumb-content']//a[.='Gradebook']")
	private WebElement gradeBookbreadcrumb;
	
	@FindBy(how=How.XPATH,using="//table[2]//tr[1]/td[3]")
	private WebElement elmntMaximumPointPotentialScore;
	
	@FindBy(how=How.XPATH,using="//table[2]//tr[2]/td[3]")
	private WebElement elmntPointsEarnedScore;
	
	@FindBy(how=How.XPATH, using="//a[.='Go']")
	private WebElement btnGoStudy;
	
	@FindBy(how = How.ID, using = "classid")
	private WebElement elmntComboClassSelector;
	
	@FindBy(how=How.ID, using="ids")
	private WebElement studComboforQuesLink;
	
	@FindBy(how=How.XPATH,using="//input[@name='mark']")
	private WebElement textEditScore;
	
	@FindBy(how=How.XPATH,using="//a[.='Preview Question']")
	private WebElement previewQuestionLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='breadcrumb-content']//a[2]")
	private WebElement breadCrumbStudentObjective;
	
	@FindBy(how=How.XPATH,using="//input[@name='search']")
	private WebElement searchTextBox;
	
	@FindBy(how = How.ID, using = "classid")
	private WebElement classDropDownStudyObjective;
	
	@FindBy(how=How.XPATH,using="//li[.='Home']")
	private WebElement btnHometab;

	
    //Description:Check All Students - Total Diagnostic Results  Gradebook
	public GradeBookStudyObjectivePage showTotalDiagnosticResults(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> showTotalDiagnosticResults", driver);
		Button.verify("verify the Grade Book Go Button", btnGo, "GO", driver);
		Button.click("Grade Book Go Button", btnGo, driver);
		return PageFactory.initElements(driver, GradeBookStudyObjectivePage.class);
	}
	
	//Description:Show the results for any class Section and Any study objective
	public GradeBookStudyObjectivePage showResultsForAnyClassAndStudyObjective() {
		ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> showResultsForAnyClassAndStudyObjective", driver);
		Combobox.selectRandomItem("Select Any Class Selection", elmntClassSelectorCombo, driver);
		Combobox.selectRandomItem("Select Any study objective", elmntAssignmentList, driver);
		Button.verify("verify the Grade Book Go Button", btnGo, "GO", driver);
		Button.click("Grade Book Go Button", btnGo, driver);
		return PageFactory.initElements(driver, GradeBookStudyObjectivePage.class);
	}
	
	//Description:Show the results for selected class Section and selected study objective
	public GradeBookStudyObjectivePage showResultsForSelectedClassSelectedStudyObjective(Map<String,String> dataMap) {
		ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> showResultsForSelectedClassSelectedStudyObjective", driver);
	    String strClassSelection = dataMap.get("StudyObjectiveStudentName");
	    String strStudyObjective = dataMap.get("StudyobjectiveChapter");
		Combobox.selectItemByValue("Select One Class Selection", elmntClassSelectorCombo,strClassSelection, driver);
		Combobox.selectItemByValue("Select One Study Objective", elmntAssignmentList, strStudyObjective, driver);
		Button.verify("verify the Grade Book Go Button", btnGo, "GO", driver);
		Button.click("Grade Book Go Button", btnGo, driver);
		return PageFactory.initElements(driver, GradeBookStudyObjectivePage.class);
	}

	//Description:Click StudyObjective student's name link
	public StudentGradeBookResultPage clickStudyObjectiveStudentNameLink(Map<String,String> dataMap) {
    	ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> clickStudyObjectiveStudentNameLink", driver);
    	String strStudentNameLink=dataMap.get("StudyObjectiveStudentNameLink");
    	driver.switchTo().defaultContent();
    	Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 5);
    	Sync.waitForFrame(driver,"gblev1frames2h" , "gblev1frames2h", 2);
    	Sync.waitForFrame(driver,"gblev1st" , "gblev1st", 2);
	    WebElement lnkStudentName=driver.findElement(By.xpath(strTableId+"//a[contains(.,'"+strStudentNameLink+"')]"));
	    Link.verify("Verify the Student Name Link", lnkStudentName, strStudentNameLink, driver);
    	Link.click("Student Name Link ",lnkStudentName, driver);
    	return PageFactory.initElements(driver, StudentGradeBookResultPage.class);
	 }
    
	//Description:Click Study Objectives link 
	public void clickStudyObjectivesLink(Map<String,String> dataMap) {
       	ResultUtil.report("INFO", "GradeBookStudentStudyObject >>> clickStudyObjectivesLink", driver);
    	String strStudyObjectivesLink = dataMap.get("StudentStudyObjectivesLink");
    	String strStudyObjective=strTableClass+"//a[.='"+strStudyObjectivesLink+"']";
    	Sync.waitForObject(driver, "Study Objective Link", "XPATH",strStudyObjective );
    	WebElement lnkStudyObjectivelink = driver.findElement(By.xpath(strStudyObjective));
    	Link.verify("StudyObjectivelink- "+strStudyObjectivesLink,lnkStudyObjectivelink , strStudyObjectivesLink, driver);
    	Link.click("StudyObjectivesLink- "+strStudyObjectivesLink, lnkStudyObjectivelink, driver);
	}
    
    //Description:Click Study Objectives Question link 
    public void clickStudyObjectivesQuestionLink(Map<String,String> dataMap){
    	ResultUtil.report("INFO", "GradeBookStudentStudyObject >>> clickStudyObjectivesQuestionLink", driver);
    	String strStudyObjectivesQuestionLink = dataMap.get("StudentStudyObjectivesQuestionLink");
    	String strStudyobjective=strTableClass+"//a[.='"+strStudyObjectivesQuestionLink+"']";
    	Sync.waitForObject(driver, "Student StudyObjectives Question Link","XPATH",strStudyobjective);
    	WebElement lnkQuestionName = driver.findElement(By.xpath(strStudyobjective));
    	Link.verify("Student StudyObjectives Question Link", lnkQuestionName, strStudyObjectivesQuestionLink, driver);
    	Link.click("Student StudyObjectives Question Link", lnkQuestionName, driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	this.driver.close();
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }

    //Description:verify List Study Objectives
    public void verifyListStudyObjectives(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyListStudyObjectives", driver);
    	driver.switchTo().defaultContent();
    	String strStudyObjective=strTableClass+"//td//a[1]";
    	Sync.waitForObject(driver, "List of Study Objectives", "XPATH",strStudyObjective );
    	List <WebElement> lnkStudyObjective=driver.findElements(By.xpath(strStudyObjective));
    	for(WebElement studyObjective:lnkStudyObjective){
    		String strStudyObjList=studyObjective.getText();
    		Link.verify("Study Objective Link List",studyObjective, driver);
    		ResultUtil.report("MESSAGE","Study Objective- "+strStudyObjList, driver);
    	}
    }
    
    //Description:verify Result Column
    public void verifyResultColumn(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyResultColumn", driver);
    	String strResultColumn=strTableClass+"//td[./a]//following-sibling::td[6]";
    	Sync.waitForObject(driver,"List of Result Column", "XPATH",strResultColumn );
    	List<WebElement> ResultColumn=driver.findElements(By.xpath(strResultColumn));
    	for(WebElement eleResult:ResultColumn){
    		String strResult=eleResult.getText();
    		ResultUtil.report("MESSAGE","Result Column Value- "+strResult, driver);
    	}	
    }
    
    //Description:verify Total ResultColumn
    public void verifyTotalResultColumn(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyTotalResultColumn", driver);
    	String strTotal=strTableClass+"//td[./strong[.='Total Score:']]//following-sibling::td[2]//strong";
    	Sync.waitForObject(driver, "Total Result Column After Clicking Study Objective Name", "XPATH", strTotal);
    	WebElement ResultColumn=driver.findElement(By.xpath(strTotal));
    	String strResult=ResultColumn.getText();
    	ResultUtil.report("MESSAGE","Total Score- "+strResult, driver);	
    }
    
    //Description:verif yQuestion Name
    public void verifyQuestionName(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyQuestionName", driver);
    	List<WebElement> questionName=driver.findElements(By.xpath(strTableClass+"//tr//td[4]"));
    	for(WebElement questionNameverify:questionName){
    		String strQuestionName=questionNameverify.getText();
    		ResultUtil.report("MESSAGE","Question Name- "+strQuestionName, driver);
    		Element.verify("Question names on Study objective",questionNameverify, driver);
    	}
    }
    
    //Description:verify Assigned Name StudyObjective
    public void verifyAssignedNameStudyObjective(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyAssignedNameStudyObjective", driver);
    	List<WebElement> assignedName=driver.findElements(By.xpath(strTableClass+"//td[6]"));
    	for(WebElement assignedNameStudy:assignedName){
    		String strAssignedName=assignedNameStudy.getText();
    		ResultUtil.report("MESSAGE","Assignment Value- "+strAssignedName, driver);
    		Element.verify("Assigned Name on Study Objective",assignedNameStudy, driver);
    	}
    }
    
    //Description:verify Attempts
    public void verifyAttempts(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyAttempts", driver);
    	List<WebElement> verifyAttemptele=driver.findElements(By.xpath(strTableClass+"//tr//td[8]"));
    	for(WebElement verifyattemptcount:verifyAttemptele){
    		String strAttempt=verifyattemptcount.getText();
    		ResultUtil.report("MESSAGE","Attempt Value- "+strAttempt, driver);
    		Element.verify("Attempt Value",verifyattemptcount, driver);
    	}	
    }
    
    //Description:verify Result Column inside StudyObjective
    public void verifyResultColumninsideStudyObjective(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyResultColumninsideStudyObjective", driver);
    	List<WebElement> verifyResult=driver.findElements(By.xpath(strTableClass+"//tr//td[10]"));
    	for(WebElement verifyResultField:verifyResult){
    		String strResult=verifyResultField.getText();
    		ResultUtil.report("MESSAGE","Attempt Value- "+strResult, driver);
    		Element.verify("Attempt Value",verifyResultField, driver);
    	}
   }
    
    //Description:click GradeBook Breadcrumb
    public void clickGradeBookBreadcrumb(){
    	ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> clickGradeBookBreadcrumb", driver);
    	Link.verify("GradeBookBreadCrumb",gradeBookbreadcrumb, driver);
    	Link.click("GradeBookBreadCrumb",gradeBookbreadcrumb, driver);
    }
    
    //Description:click All Study Objectives
    public void clickAllStudyObjectives(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> ClickAllStudyObjectives", driver);
    	String strStudyObjective=strTableClass+"//tr";
    	List<WebElement> linksStudyObjective=driver.findElements(By.xpath(strStudyObjective));
    	for(int i=2;i<linksStudyObjective.size()-8;i++){
    		WebElement link=driver.findElement(By.xpath(strStudyObjective+"["+i+"]//a[1]"));
    		Link.click("Study Objective Result Column",link, driver);
    		verifyQuestionName();
    		verifyAssignedNameStudyObjective();
    		verifyAttempts();
    		verifyResultColumninsideStudyObjective();
    		clickGradeBookBreadcrumb();
    	}
    }
    	
    //Description:verify Maximum Point Potential Score
	public void verifyMaximumPointPotentialScore(){
		ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> verifyMaximumPointPotentialScore", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	String strMaxPotential=driver.findElement(By.xpath("elmntMaximumPointPotentialScore")).getText().trim();
    	if(strMaxPotential.equals("1 || 1.0")){
    		ResultUtil.report("PASS", "Maximum Point Potential Score is set to Default value", driver);
    	}
    	else{
    		ResultUtil.report("FAIL","Maximum Point Potential Score is set to value"+strMaxPotential, driver);
    	}
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}

	//Description:verify Points Earned Score
    public void verifyPointsEarnedScore(){
    	ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> verifyPointsEarnedScore", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	String strPointsEarnedScore = elmntPointsEarnedScore.getText();
    	
    	if(strPointsEarnedScore.equalsIgnoreCase("0")){
    		ResultUtil.report("MESSAGE", "Student not Earned score - ["+strPointsEarnedScore+"]", driver);
		}
    	else{
			ResultUtil.report("MESSAGE", "Student Earned some score - ["+strPointsEarnedScore+"]", driver);
		}
    	this.driver.close();
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}
    
    //Description:verify Points Earned Without ClosingDriver
    public void verifyPointsEarnedWithoutClosingDriver(){
    	ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> verifyPointsEarnedWithoutClosingDriver", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	String strPointsEarnedScore = elmntPointsEarnedScore.getText();
    	
    	if(strPointsEarnedScore.equals("0")){
    		ResultUtil.report("PASS", "Student not Earned score - ["+strPointsEarnedScore+"]", driver);
		}
    	else{
			ResultUtil.report("FAIL", "Student Earned some score - ["+strPointsEarnedScore+"]", driver);
		}
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}
    
    //Description:click Go Button
    public void clickGoButton(){
		ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickGoButton", driver);
		Button.verify("Instructor GradeBok Tab", btnGoStudy, driver);
		Button.click("Instructor Grade Book Tab", btnGoStudy, driver);
	}
   
    //Description: select Class From Combo Study Objective
    public void selectClassFromComboStudyObjective(Map<String,String> dataMap, String strClassSection){
	   ResultUtil.report("INFO","GradeBookPage >>> selectClassFromComboStudyObjective", driver);
		driver.switchTo().defaultContent();
		String  strClassName = dataMap.get(strClassSection).trim();
		Combobox.selectItemByValue("Select the Class", elmntComboClassSelector, strClassName, driver);
		ResultUtil.report("PASS",strClassName+" Class is Selected", driver);
    }
    
   	//Description: Verify class section Name 
    public void verifyClassSectionName(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyClassSectionName", driver);
    	driver.switchTo().window(driver.getWindowHandle().toString());
    	Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 5);
    	Sync.waitForFrame(driver,"gblev1frames2h" , "gblev1frames2h", 2);
    	Sync.waitForFrame(driver,"gblev1st" , "gblev1st", 2);
    	String strClass=strTableId+"//a";
	    Sync.waitForObject(driver, "Question Links","XPATH",strClass);
    	List<WebElement> classSectionName=driver.findElements(By.xpath(strClass));
    	for(WebElement eleclassSectionName:classSectionName){
    		String strStudent=eleclassSectionName.getText();
    		Link.verify("Student Name Link- "+strStudent,eleclassSectionName, driver);
    	}
    }
    
    //Description:verify Study ObjectiveId
    public void verifyStudyObjectiveId(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyStudyObjectiveId", driver);
    	driver.switchTo().window(driver.getWindowHandle().toString());
    	Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 5);
    	Sync.waitForFrame(driver,"gblev1frames2h" , "gblev1frames2h", 2);
    	Sync.waitForFrame(driver,"gblev1ag" , "gblev1ag", 2);
	    List<WebElement> studyObjective=driver.findElements(By.xpath(strTableId+"//td[4]//span"));
	    for(WebElement elestudyObjective:studyObjective){
	    	String strstudy=elestudyObjective.getText();
	    	Element.verify("Study Objective ID- "+strstudy,elestudyObjective, driver);
	    }  
    }
    
    //Description:select Summary By Class Section ComboBox
    public void selectSummaryByClassSectionComboBox(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> selectSummaryByClassSectionComboBox", driver);
    	driver.switchTo().defaultContent();
    	String strClass="//select[@id='classid']";
    	Sync.waitForObject(driver, "Class Drop Down ", "XPATH",strClass);
    	WebElement classSectionCombo=driver.findElement(By.xpath(strClass));
    	Combobox.selectItemByValue("Summary By Class Section", classSectionCombo, "Summary by Class Section", driver);
    }
    
   //Description:verify Total Diagnostic Result
    public void verifyTotalDiagnosticResult(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyTotalDiagnosticResult", driver);
    	driver.switchTo().window(driver.getWindowHandle().toString());
    	Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 5);
    	Sync.waitForFrame(driver,"gblev1frames2h" , "gblev1frames2h", 2);
    	List<WebElement> elmnTotalDiagnostic=driver.findElements(By.xpath(strTableId+"//td[6]//span"));
    	for(WebElement verifyTotalDiagnostic:elmnTotalDiagnostic){
    		String strTotalDiagnostic=verifyTotalDiagnostic.getText();
    		Element.verify("Total Diagnostic Result- "+strTotalDiagnostic,verifyTotalDiagnostic, driver);
    	}
    }
    
    //Description:click Study ObjectiveID
    public void clickStudyObjectiveID(Map<String,String> dataMap){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickStudyObjectiveID", driver);
    	driver.switchTo().window(driver.getWindowHandle().toString());
    	Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 5);
    	Sync.waitForFrame(driver,"gblev1frames2h" , "gblev1frames2h", 2);
    	Sync.waitForFrame(driver,"gblev1ag" , "gblev1ag", 2);
	    String strStudyObjectiveID=dataMap.get("StudyObjectiveID");
	    WebElement objectiveId=driver.findElement(By.xpath(strTableId+"//a[.='"+strStudyObjectiveID+"']"));
	    Link.verify("Study Objective ID ",objectiveId, driver);
	    Link.click("Study Objective ID ",objectiveId, driver);
    } 
    
   //Description:verify StudCombo forQuestionLink
    public void verifyStudComboforQuestionLink(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyStudComboforQuestionLink", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	Combobox.isEnabled(studComboforQuesLink,"Student List Combo Box", driver);
    	Combobox.verifySelectedItem("Selected Option in ComboBox", studComboforQuesLink, "ALL STUDENTS", driver);
    	Select selCombobox=new Select(studComboforQuesLink);
    	WebElement elmntStudentCombo=selCombobox.getFirstSelectedOption();
    	String strStudentCombo=elmntStudentCombo.getText().trim();
    	
    	if(strStudentCombo.equals("ALL STUDENTS")){
    		ResultUtil.report("PASS", "All student option is Selected in Student Combo box", driver);
    	}
    	else{
    		ResultUtil.report("FAIL", "All Student Option is not Selected in Student Combo box", driver);
    	}
    	this.driver.close();
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
     }
    
    //Description:verify Edited ScoreBox
    public void verifyEditedScoreBox(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyEditedScorePage", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	TextBox.verifyValue("Edited Sore ",textEditScore ,"", driver);
    	if(textEditScore==null){
    		ResultUtil.report("PASS", "The Edited Score Field is Empty", driver);
    	}
    	else{
    		ResultUtil.report("FAIL", "The Edited Score Field Contain Value: "+textEditScore.getText(), driver);
    	}
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }
    
   //Description:click Preview QuestionLink
    public void clickPreviewQuestionLink(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickPreviewQuestionLink", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	Link.verify("Preview Question Link",previewQuestionLink, driver);
    	Link.click("Preview Question Link",previewQuestionLink, driver);
    	this.driver.close();
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
   	}
    
    //Description:focus Togblev2frames2htop  
    public void focusTogblev2frames2htop(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> focusTogblev2frames2htop", driver);
    	driver.switchTo().window(driver.getWindowHandle().toString());
    	Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 2);
    	Sync.waitForFrame(driver,"gblev2frames2htop" , "gblev2frames2htop", 2);
    }
    
    //Description:click All QuestionLink
    public void clickAllQuestionLink(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickAllQuestionLink", driver);
    	focusTogblev2frames2htop();
    	String strQuestionLink="//table[@class='plain-table headline']//a//b";
    	Sync.waitForObject(driver,"List Of Questions", "XPATH",strQuestionLink );
    	List<WebElement> questionLink=driver.findElements(By.xpath(strQuestionLink));
    	for(WebElement eleQuestionLink:questionLink){
    		String strQuestion=eleQuestionLink.getText();
    		Link.verify("Question Link- "+strQuestion,eleQuestionLink, driver);
    		Link.click("Question Link- "+strQuestion, eleQuestionLink, driver);
    		verifyStudComboforQuestionLink();
    		verifyEditedScoreBox();
    		verifyMaximumPointPotentialScore();
    		verifyPointsEarnedWithoutClosingDriver();
    		clickPreviewQuestionLink();
    		focusTogblev2frames2htop();
    	}
    }
    
    //Description:verify Result For Student
    public void verifyResultForStudent(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyResultForStudent", driver);
    	String strResult=strTableClass+"//td[6]//span";
    	Sync.waitForObject(driver, "ResultScore Field", "XPATH",strResult );
    	WebElement verifyResult=driver.findElement(By.xpath(strResult));
    	String strverifyResult=verifyResult.getText();
    	Element.verify("Result Score Field- "+strverifyResult,verifyResult, driver);
    }
    
    //Description:click bread Crumb StudyObjective
    public void clickbreadCrumbStudyObjective(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickbreadCrumbStudyObjective", driver);
    	Link.verify("BreadCrumbLink ",breadCrumbStudentObjective, driver);
    	Link.click("BreadCrumbLink",breadCrumbStudentObjective, driver);
    }
    
    //Description:click Question AttemptsLink
    public void clickQuestionAttemptsLink(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickQuestionAttemptsLink", driver);
    	List<WebElement> elmntquestion=driver.findElements(By.xpath(strTableClass+"//td[8]//a"));
    	for(WebElement questionAttempts:elmntquestion){
    		Link.verify("Question Attempt Link ",questionAttempts, driver);
    		Link.click("Question Attempt Link ",questionAttempts, driver);
    		verifyStudComboforQuestionLink();
    		verifyEditedScoreBox();
    		verifyMaximumPointPotentialScore();
    		verifyPointsEarnedScore();
      	}	
    }
    
    //Description:verify Find Student TextBox
    public void verifyFindStudentTextBox(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyFindStudentTextBox", driver);
    	Sync.waitForObject(driver, "Find Student TextBox", "XPATH","//input[@name='search']");
    	Element.verify("Find Student TextBox ", searchTextBox, driver);
    }
    
    //Description:verify Class DropDown
    public void verifyClassDropDown(){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> verifyClassDropDown", driver);
    	Combobox.isEnabled(classDropDownStudyObjective, "Class Section Drop Down", driver);
    }
    
    //Description:select Chapter DropDown
    public void selectChapterDropDown(Map<String,String> dataMap, String strAssignment){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> selectChapterDropDown", driver);
    	String strAssignmentName=dataMap.get(strAssignment);
    	Combobox.selectItemByValue("Select One Study Objective", elmntAssignmentList, strAssignmentName, driver);
    	ResultUtil.report("PASS",strAssignmentName+" Chapter Selected", driver);
    }
        
    //Description:click Question Link
    public void clickQuestionLink(Map<String,String> dataMap){
    	ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> clickQuestionLink", driver);
    	String strQuestion=dataMap.get("QuestionName");
    	WebElement questionLink=driver.findElement(By.xpath(strTableClass+"//td[4]//a[.='"+strQuestion+"']"));
    	Link.verify("Study Objective Question",questionLink, driver);
    	Link.click("Study Objective Question", questionLink, driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	this.driver.close();
      	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());	
    }
    
    //Description:verify Total Result StudyObjective
    public void verifyTotalResultStudyObjective(){
    	ResultUtil.report("INFO", "GradeBookStudyObjectivePage >>> verifyTotalResultStudyObjective", driver);
    	WebElement eleResult=driver.findElement(By.xpath(strTableClass+"//td[./strong[.='Total']]//following-sibling::td[2]//strong"));
    	String strResult=eleResult.getText();
    	ResultUtil.report("MESSAGE", "Total Result- "+strResult, driver);	
    }
    
    //Description:goTo StudentHome
	public void goToStudentHome(){
		ResultUtil.report("INFO","GradeBookStudyObjectivePage >>> goToStudentHome", driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver,"instructorGbFrame" , 0, 2);
 		Sync.waitForObject(driver,"Home Tab", "XPATH", "//li[@title='Home']");
 		Button.verify("Student Home Tab",btnHometab, driver);
 		Button.click("Student Home Tab", btnHometab, driver);
	}
	
	//Description: Select Summary by Class Section
	public void summaryByClassSection(Map<String,String> dataMap,String strClassSection){
		ResultUtil.report("INFO","GradeBookPage >>> summaryByClassSection", driver);
		driver.switchTo().defaultContent();
		String  strClassName = dataMap.get(strClassSection).trim();
		Combobox.selectItemByValue("Select the Class", elmntComboClassSelector, strClassName, driver);
		ResultUtil.report("PASS",strClassName+" Class is Selected", driver);
	}
	
	//Description: Click Question Link From Study Objective ID
	public void clickQuestionLinkObjectiveID(Map<String,String> dataMap){
		ResultUtil.report("INFO","GradeBookPage >>> clickQuestionLinkObjectiveID", driver);
		String strQuestionAssignmentID=dataMap.get("StudyObjectiveQuestionName");
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver,"instructorGbFrame" , "instructorGbFrame", 2);
		Sync.waitForFrame(driver,"gblev2frames2htop" , "gblev2frames2htop", 2);
		WebElement elmntQuestionLink=driver.findElement(By.xpath(strTableId+"//tr[2]//a[.='"+strQuestionAssignmentID+"']"));
		Link.verify("Question Link in Study Objective", elmntQuestionLink, driver);
		Link.click("Question Link in Study Objective", elmntQuestionLink, driver);
	}
	
	//Description: Validate New Window
	public void validateQuestionModalwindow(Map<String,String>dataMap){
		ResultUtil.report("INFO","GradeBookPage >>> validateQuestionModalwindow", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		String strStudyObjectivesQuestionLink = dataMap.get("StudentStudyObjectivesQuestionLink");
		String strPageTitle=driver.getTitle();
		if(strPageTitle.equals(strStudyObjectivesQuestionLink)){
			ResultUtil.report("PASS", "New Modal Window Opened with one Item"+"Question Name:-"+strPageTitle, driver);
		}	
		else{
			ResultUtil.report("FAIL","No Window Opened For Student", driver);
			}
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}
}
