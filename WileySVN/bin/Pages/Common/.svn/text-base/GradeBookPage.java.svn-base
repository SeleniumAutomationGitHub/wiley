package Pages.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.GradeBookStudyObjectivePage;
import Pages.WPBlackboardIntegration.BlackBoardIntegrationPage;
import Toolbox.Browser;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.Listbox;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Toolbox.Window;
import Util.CommonUtil;

public class GradeBookPage extends Initializer {
		
	@FindBy(how = How.ID, using = "clsSelector")
	private WebElement elmntComboClassSelector;
	
	@FindBy(how = How.ID, using = "agtypeSelector")
	private WebElement elmntComboActivityType;
	
	@FindBy(how = How.ID, using = "assignments")
	private WebElement elmntAssignmentsType;
		
	@FindBy(how = How.XPATH, using = "//li[@title='Study Objectives']")
	private WebElement lnkStudyObjectives;
		
	@FindBy(how=How.XPATH, using="//a[.='Go']")
	private WebElement btnGo;
	
	@FindBy(how=How.XPATH,using="//span[@class='breadcrumb']//a[.='Gradebook']")
	private WebElement gradeBookLinkBreadCrumb;
	
	@FindBy(how=How.NAME,using="mark")
	private WebElement textEditScore;
	
	@FindBy(how=How.ID,using="Refresh_Gradebook")
	private WebElement btnRefresh;	
		
	@FindBy(how=How.XPATH, using="//select[@id='ids']")
	private WebElement studComboforQuesLink;
	
	@FindBy(how=How.XPATH,using="//td[./b[.='Total']]/following-sibling::td[6]")
	private WebElement elmntTotalScore;
	
	@FindBy(how=How.XPATH,using="//a[.='Preview Question']")
	private WebElement previewQuestionLink;
	
	@FindBy(how = How.XPATH, using = "//select[@id='assignments']")
	private WebElement elmntComboAssignment;
	
	@FindBy(how=How.XPATH, using="//a[.='Submit']")
	private WebElement btnQuestionWindowSubmit;
	
	@FindBy(how=How.XPATH, using="//a[.='Cancel']")
	private WebElement btnQuestionWindowCancel;
	
	@FindBy(how=How.XPATH,using="//li[.='Home']")
	private WebElement btnHometab;
	
	@FindBy(how=How.ID,using="View_Graph")
	private WebElement btnViewGraph;
	
	@FindBy(how=How.XPATH,using="//span[@class='breadcrumb']//a[contains(.,'Results of')]")
	private WebElement elmntResultsBreadCrumb;;
	
	@FindBy(how = How.XPATH, using = "//ins[text()='Return to Blackboard']")
	private WebElement elmntReturnBlackboard;
	
	@FindBy(how=How.NAME, using="search")
	private WebElement findStudentTextBox;
	
	String raw=null;
	String strTableID="//table[contains(@id,'syncTbl')]";
	String strTableClass="//table[contains(@class,'plain-table')]";
	
	public GradeBookPage(WebDriver driver){
		super(driver);
	}
	//Description: focus on frames
	private void focusgblev1frames2hFrame(){
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 2);
		Sync.waitForFrame(driver, "gblev1frames2h", "gblev1frames2h", 2);
		ResultUtil.report("PASS","Focused to gblev1frames2h Frame",driver);
	}
	//Description:focus on frames
	private void focusgblev1agFrame(){
		focusgblev1frames2hFrame();
		Sync.waitForFrame(driver, "gblev1ag", "gblev1ag", 2);
		ResultUtil.report("PASS","Focused to gblevlag Frame",driver);
	}
	//Description:focus on frames
	private void focusgblev2frames2hFrame(){
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 2);
		Sync.waitForFrame(driver, "gblev2frames2h", "gblev2frames2h", 2);
		ResultUtil.report("PASS","Focused to gblev2frames2h Frame", driver);
	}
	//Description:focus on frames
	private void focusgblev2frames2htopFrame(){
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 2);
		Sync.waitForFrame(driver, "gblev2frames2htop", "gblev2frames2htop", 2);
		ResultUtil.report("PASS","Focused to gblev2frames2htop Frame", driver);
	}
	
	//Description: Focus on frames
	private void focus2framegblev1st(){
		focusgblev1frames2hFrame();
		Sync.waitForFrame(driver, "gblev1st", "gblev1st", 2);
		ResultUtil.report("PASS","Focused to gblev1st Frame", driver);
	}
	
	//Description: Focus on frames
	public void focus2gblev1frames2htop(){
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 2);
		Sync.waitForFrame(driver, "gblev1frames2htop", "gblev1frames2htop", 2);
		ResultUtil.report("PASS", "Focused to gblev1frames2htop Frame", driver);
	}
	
	//Description: Go To Parent Window
    public void goToParentWindow() throws InterruptedException {
    	ResultUtil.report("INFO","GradeBookPage >>> goToParentWindow", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }
    
    //Description: Go to First Window
    public void gotoFirstWindow(){
    	ResultUtil.report("INFO","GradeBookPage >>> goToParentWindow", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }
	
	//Description:Show All Students Assignment  
	public GradeBookPage showAllStudentsAssignment(Map<String,String> dataMap) throws Exception {
		ResultUtil.report("INFO","GradeBookPage >>> showAllStudentsAssignment", driver);
		Combobox.isEnabled(elmntComboClassSelector, "Class Selector", driver);
		Combobox.isDisabled(elmntComboActivityType,"Activity Type", driver);
		Button.verify("verify the Grade Book Go Button", btnGo, "GO", driver);
		Button.click("Grade Book Go Button", btnGo, driver);
		return PageFactory.initElements(driver, GradeBookPage.class);
	}
	
	//Description:Check All Students - One Assignment representation in Instructor's Gradebook
	public void assignOneAssignmentToAllStudents(Map<String,String> dataMap, String strClassSection) throws Exception {
		ResultUtil.report("INFO","GradeBookPage >>> assignOneAssignmentToAllStudents", driver);
		driver.switchTo().defaultContent();
		String  strClassName = dataMap.get(strClassSection).trim();
		Combobox.selectItemByValue("Select the student", elmntComboClassSelector, strClassName, driver);
		ResultUtil.report("PASS",strClassName+" Class is Selected", driver);
	}
	
	//Description:Click assignment's ID link
	public void clickAssignmentLink(Map<String,String> dataMap, String strAssignmentNameLink) throws Exception {
		ResultUtil.report("INFO","GradeBookPage >>> clickAssignmentLink", driver);
		String strAssignmentId=dataMap.get(strAssignmentNameLink);
		driver.switchTo().defaultContent();
		Sync.waitForObject(driver, "Assignment Name Link", "XPATH", strTableClass+"//a[.='"+strAssignmentId+"']");
		WebElement lnkAssignmentId=driver.findElement(By.xpath(strTableClass+"//a[.='"+strAssignmentId+"']"));
		Link.verify("Assignment Name", lnkAssignmentId, strAssignmentId, driver);
		Link.click("Assignment Name", lnkAssignmentId, driver);
	}
	
	//Description:click Assignment Id
	public void clickAssignmentId(Map<String,String> dataMap,String strAssignment) throws Exception {
		ResultUtil.report("INFO","GradeBookPage >>> clickAssignmentId", driver);
		String strAssignmentId=dataMap.get(strAssignment);
		driver.switchTo().defaultContent();
		focusgblev1agFrame();
		Sync.waitForObject(driver,"Assignment ID", "XPATH", strTableClass+"//a[.='"+strAssignmentId+"']");
		WebElement lnkAssignmentId=driver.findElement(By.xpath(strTableClass+"//a[.='"+strAssignmentId+"']"));
		Link.verify("Verify the Assignment Link Id", lnkAssignmentId, strAssignmentId, driver);
		Link.click("Assignment Id", lnkAssignmentId, driver);
	}
	
	//Description:Click Student Name Link
	public GradeBookPage clickStudentNameLink(Map<String,String> dataMap,String strStudentName) throws Exception {
		ResultUtil.report("INFO","GradeBookPage >>> clickStudentNameLink", driver);
	    String strStudentNameLink=dataMap.get(strStudentName);
	    driver.switchTo().defaultContent();
	    try{
	    	Sync.waitForFrame(driver, "First Iframe", 0, 3);
	    }
	    catch(Exception e){ }
	    try{
	    	Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 2);
	    }
	    catch(Exception e){}
	    try{
	    	Sync.waitForFrame(driver, "gblev1frames2h", "gblev1frames2h", 2);
	    }
	    catch(Exception e){}
	    try{
	    	Sync.waitForFrame(driver, "gblev1st", "gblev1st", 2);
	    }
	    catch(Exception e){}
	    String strTable=strTableID+"//a[contains(.,'"+strStudentNameLink+"')]";
	    Sync.waitForObject(driver, "Student Name Link","XPATH", strTable);
	    WebElement lnkStudentName=driver.findElement(By.xpath(strTable));
	    Link.verify("Student Name ", lnkStudentName, strStudentNameLink, driver);
	    Link.click("Student Name ", lnkStudentName, driver);
	    return PageFactory.initElements(driver, GradeBookPage.class);
	}
	   
	//Description:Click Study Objectives link 
	public GradeBookStudyObjectivePage clickStudyObjectivesPage() throws Exception{
		ResultUtil.report("INFO","GradeBookPage >>> clickStudyObjectivesPage", driver);
		Button.verify("Grade Book Study Objectives link", lnkStudyObjectives, "Study Objectives", driver);
		Button.click("Grade Book Study Objectives link", lnkStudyObjectives, driver);
		return PageFactory.initElements(driver, GradeBookStudyObjectivePage.class);
	}
    
	//Description:Click the Go Button
	public void clickGoButton(){
		ResultUtil.report("INFO","GradeBookPage >>> clickGoButton", driver);
	   	Button.verify("GO ", btnGo, driver);
		Button.click("GO ", btnGo, driver);
	}
	
	//Description:Click Question Name Link
	public void clickByQuestionName(Map<String,String> dataMap, String strQuestionNameLink){
    	ResultUtil.report("INFO","GradeBookPage >>> clickByQuestionName", driver);
    	driver.switchTo().defaultContent();
    	String strQuestionName=dataMap.get(strQuestionNameLink);
    	String strTable=strTableClass+"//td[@class='selenium_qtitle']//a[.='"+strQuestionName+"']";
    	Sync.waitForObject(driver, "Question Name","XPATH",strTable);
    	WebElement elequestionName=driver.findElement(By.xpath(strTable));
    	Link.verify("Question name",elequestionName, driver);
    	Link.click("Question name", elequestionName, driver);
    }
	
	//Description:Click GradeBook From BreadCrumb
    public void clickGradeBookBreadCrumb(){
    	ResultUtil.report("INFO","GradeBookPage >>> clickGradeBookBreadCrumb", driver);    	
    	driver.switchTo().defaultContent();
    	Sync.waitForObject(driver, "GradeBook BreadCrumb Link","XPATH", "//span[contains(@class,'breadcrumb')]//a[.='Gradebook']");
    	Link.verify("GradeBook Link in BreadCrumb",gradeBookLinkBreadCrumb, driver);
    	Link.click("GradeBook Link in BraedCrumb",gradeBookLinkBreadCrumb, driver);
    }
    
    //Description:Verify the Edited Score TextBox
    public void verifyEditedScoreBox() throws InterruptedException{
       	ResultUtil.report("INFO","GradeBookPage >>> verifyEditedScorePage", driver);
    	gotoFirstWindow();
    	TextBox.verifyValue("Edited Sore ",textEditScore ,"", driver);
    	
    	if(textEditScore==null){
    		ResultUtil.report("PASS", "The Edited Score Field is Empty", driver);
    	}
    	else{
    		ResultUtil.report("FAIL", "The Edited Score Field Contain Value: "+textEditScore.getText(), driver);
    	}
    	goToParentWindow();
    }
    
    //Description:Verify the Question link
    public void questionLinkVerify(){	
    	ResultUtil.report("INFO","GradeBookPage >>> questionLinkVerify", driver);
    	List<WebElement> QuestionAttempts = driver.findElements(By.xpath("//td[contains(@class,'selenium_attempt_1')]/span"));
    	List<String> lstatempts=new ArrayList<String>();
    	for(WebElement qnAttempt:QuestionAttempts){
    		String atemptValue=qnAttempt.getText();
    		lstatempts.add(atemptValue);
    	}
    	List<WebElement> questions=driver.findElements(By.xpath("//td[@class='selenium_qtitle']"));
    	int i=1;
    	for(WebElement txtQustion:questions){
    		String strQuestion=txtQustion.getTagName();
    		String attempts=lstatempts.get(i);
    		if(attempts.contains("-")){
    			if(!strQuestion.equals("a")){
    				ResultUtil.report("PASS", "Unattempted questions are inactive as Expected", driver);
    			}else{
    				ResultUtil.report("FAIL", "Unattempted questions are active", driver);
    			}
    		}
    		if(strQuestion.equals("a")){
				ResultUtil.report("PASS", "Attempted questions are active as Expected", driver);
    		}else{
				ResultUtil.report("FAIL", "Attempted questions are inactive", driver);
			}
    	}
    }
    
    //Description:Click the Refresh GradeBook Button
    public void clickRefreshGradeBook(){	
    	ResultUtil.report("INFO","GradeBookPage >>> clickRefreshGradeBook", driver);
    	driver.switchTo().defaultContent();
    	Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 3);
    	Sync.waitForFrame(driver, "gblev1top", "gblev1top", 3);
    	Button.verify("Refresh GradeBook",btnRefresh, driver);
    	Button.click("Refresh GradeBook",btnRefresh, driver);
    }
    
    //Description:Verify the Maximum Potential Value
    public void verifyMaximumPotential() throws InterruptedException{	
    	ResultUtil.report("INFO","GradeBookPage >>> verifyMaximumPotential", driver);
    	gotoFirstWindow();
    	String strMaxPotential=driver.findElement(By.xpath("//table[2]//tr[1]//td[3]//span")).getText().trim();
    	if(strMaxPotential.equals("1")||strMaxPotential.equals("1.0")){
    		ResultUtil.report("PASS", "Maximum Point Potential Score is set to Default value", driver);
    	}
    	else{
    		ResultUtil.report("FAIL","Maximum Point Potential Score is not set to default value: "+strMaxPotential, driver);
    	}
    	goToParentWindow();
    }
    
    //Description:verify StudCombo for QuestionLink
    public void verifyStudComboforQuestionLink() throws InterruptedException{
    	ResultUtil.report("INFO","GradeBookPage >>> verifyStudComboforQuestionLink", driver);
    	gotoFirstWindow();
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
    	goToParentWindow();
    }
     
    //Description:get Total Score of Assignment
    public void getTotalScore() throws InterruptedException{
      	ResultUtil.report("INFO", "InstructorGradeBookResultPage >>> getTotalScore", driver);
    	String strTotalScore = elmntTotalScore.getText();
    	ResultUtil.report("MESSAGE", "Total Score: ["+strTotalScore+"]", driver);
    }
    
  //Description:click Preview QuestionLink
    public void clickPreviewQuestionLink() throws InterruptedException{
    	ResultUtil.report("INFO","GradeBookPage >>> clickPreviewQuestionLink", driver);
    	gotoFirstWindow();
    	Link.verify("Preview Question Link",previewQuestionLink, driver);
    	Link.click("Preview Question Link",previewQuestionLink, driver);
    	goToParentWindow();	
    }
    
    //Description:select assignment name by value
    public void selectAssignmentName(Map<String,String> dataMap) throws Exception {
		ResultUtil.report("INFO","GradeBookPage >>> selectAssignmentName", driver);
		String  strAssignmentName = dataMap.get("AssignmentName");
		Combobox.selectItemByValue("Select the Assignment", elmntComboAssignment, strAssignmentName, driver);
		ResultUtil.report("PASS","Assignment is Selected", driver);
	}
        
    //Description:Show the Students Question Result Page
    public AssignmentResultsPage clickStudentAssignmentLink(Map<String,String> dataMap) throws InterruptedException{
        String strAssignmentName=dataMap.get("AssignmentName");
       	WebElement lnkAssignmentName = driver.findElement(By.xpath("//a[text()='"+strAssignmentName+"']"));
    	Link.verify("Assignment Link in Second Column", lnkAssignmentName, strAssignmentName, driver);
    	Link.click("Assignment Link in Second Column", lnkAssignmentName, driver);
    	return PageFactory.initElements(driver, AssignmentResultsPage.class);
    }
    
    
    //Description:Enter the Edited Score TextBox
    public void enterEditedScoreBox(Map<String,String> dataMap) throws InterruptedException {
    	String strModifyValue = dataMap.get("ModifyValue");
    	ResultUtil.report("INFO","GradeBookPage >>> enterEditedScoreBox", driver);
    	gotoFirstWindow();
    	TextBox.enterValue("Edited Sore TextBox",textEditScore ,strModifyValue, driver);
    	
    }
    
    //Description: Click Question Window Submit Button
    public void clickQuestionWindowSubmitButton() throws InterruptedException {
    	ResultUtil.report("INFO","GradeBookPage >>> clickQuestionWindowSubmitButton", driver);
    	Button.click("Question Window Submit", btnQuestionWindowSubmit, driver);
    }
    
    //Description:Click Question Window Cancel Button
    public void clickQuestionWindowCancelButton() throws InterruptedException {
    	ResultUtil.report("INFO","GradeBookPage >>> clickQuestionWindowSubmitButton", driver);
    	Button.click("Question Window Cancel", btnQuestionWindowCancel, driver);
    }
            
    //Description:Check the score column values for Updated Question
 	public void verifyUpdatedScore(Map<String,String> dataMap){
 		ResultUtil.report("INFO", "AssignmentResultsPage >>> verifyUpdatedScore", driver);
 		String strquestionName = dataMap.get("QuestionName");
 		WebElement elmntFirstAssingment = driver.findElement(By.xpath("//td[./a[.='"+strquestionName+"']]/following-sibling::td[10]"));
 		String strScore= elmntFirstAssingment.getText();
 		String updatedScore = CommonUtil.getUpdatedScore(strScore);
 		String strModifyValue = dataMap.get("ModifyValue");
 		
 		if(updatedScore.equalsIgnoreCase(strModifyValue)){
 			ResultUtil.report("PASS", "updatedScore from UI ["+updatedScore+"] and xsl sheet ["+strModifyValue+"] is equal", driver);
 		}
 		else{
 			ResultUtil.report("FAIL","updatedScore from UI ["+updatedScore+"] and xsl sheet ["+strModifyValue+"] is not equal", driver);
 		}
 	}
 	
 	//Description:verify First Assignment Students Result
 	public void verifyAssignmentStudentsResult(Map<String,String> dataMap, String strAssignmentName,String strAssignmentEarnedPoints, String strAssginmentMaximumPoints ) throws Exception{
		ResultUtil.report("INFO", "StudentGradeBookPage >>> verifyAssignmentStudentsResult",driver);
		String strFirstAssignmentName = dataMap.get(strAssignmentName);
		WebElement progres=driver.findElement(By.xpath(strTableClass+"//tr[contains(.,'"+strFirstAssignmentName+"')]//td[8]"));
		String strprogres=progres.getText();
		
		if(strprogres.equals(dataMap.get("Progress"))){
			ResultUtil.report("PASS","Expected:"+dataMap.get("Progress")+"Actual:"+strprogres, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+dataMap.get("Progress")+"Actual:"+strprogres, driver);
		}
		WebElement  elmntRawScore=driver.findElement(By.xpath(strTableClass+"//tr[contains(.,'"+strFirstAssignmentName+"')]//td[12]"));
		String strRawScore=elmntRawScore.getText();
		String[] strraw=strRawScore.split("\\/");
		String stractualScore=strraw[0];
		String strPointsActual=dataMap.get(strAssignmentEarnedPoints);
		String strMaxScore=strraw[1];
		String strPointsTotal=dataMap.get(strAssginmentMaximumPoints);
		
		//Actual Score
		if(stractualScore.equals(strPointsActual)){
			ResultUtil.report("PASS","Expected:"+strPointsActual+"Actual:"+stractualScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+strPointsActual+"Actual:"+stractualScore, driver);
		}
		
		//Potential Score
		if(strMaxScore.equals(strPointsTotal)){
			ResultUtil.report("PASS","Expected:"+strPointsTotal+"Actual:"+strMaxScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+strPointsTotal+"Actual:"+strMaxScore, driver);
		}
 	}
 	
 	//Description: total raw Score
 	public void verifyTotalRawScore(Map<String,String> dataMap){
		ResultUtil.report("INFO","StudentGradeBookPage >>> verifyRawScoreGradeBook",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		List<String> lstRawvalues=new ArrayList<String>();
		List<WebElement> rawScoreValue=driver.findElements(By.xpath(strTableClass+"//td[12]//span//span"));
		for(WebElement rawScore:rawScoreValue){
			String rawValue=rawScore.getText().trim();
			lstRawvalues.add(rawValue);
			ResultUtil.report("MESSAGE","RawScore- "+rawValue, driver);
		}
		int size=lstRawvalues.size();
		float actual=0;
		int potential=0;
		for(int i=0;i<size;i++){
			String score=lstRawvalues.get(i);
			if(score.contains("/")){
			String[] splitTotal=score.split("\\/");
			if(!splitTotal[0].contains("-")){
				String stractual=splitTotal[0];
				Float actualValue=Float.parseFloat(stractual);
				actual=actual+actualValue;
			}
			String strPotential=splitTotal[1];
			int potentialValue=Integer.parseInt(strPotential);
			potential=potential+potentialValue;
			}
		}
		String strAct=Float.toString(actual);
		String strPot=Float.toString(potential);
		WebElement totalScoreInActual=driver.findElement(By.xpath("//td[.='Total']//following-sibling::td[6]"));
		String strtotalScoreInActual=totalScoreInActual.getText().trim();
		String[] strSplitActualAndPotential=strtotalScoreInActual.split("\\/");
		String strActualScore=strSplitActualAndPotential[0];
		String strPotentialScore=strSplitActualAndPotential[1];
		if(strActualScore.equals(strAct)){
			ResultUtil.report("PASS","Expected:"+actual+"\tActual:"+strActualScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+actual+"\tActual:"+strActualScore, driver);
		}
		if(strPotentialScore.equals(strPot)){
			ResultUtil.report("PASS","Expected:"+potential+"\tpotential:"+strPotentialScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+potential+"\tpotential:"+strPotentialScore, driver);
		}
		
		WebElement totalProgress=driver.findElement(By.xpath("//td[.='Total']//following-sibling::td[2]"));
		String strTotalProgressActual=totalProgress.getText().trim();
		driver.switchTo().defaultContent();
		Sync.waitForObject(driver, "GradeBook BreadCrumb Link","XPATH", "//span[contains(@class,'breadcrumb')]//a[.='Gradebook']");
    	Link.verify("GradeBook Link in BreadCrumb",gradeBookLinkBreadCrumb, driver);
    	Link.click("GradeBook Link in BraedCrumb",gradeBookLinkBreadCrumb, driver);
    	Sync.waitForFrame(driver, "instructorGbFrame Frame", "instructorGbFrame", 5);
    	Sync.waitForFrame(driver, "gblev1frames2h Frame", "gblev1frames2h", 2);
    	String strStudentName=dataMap.get("StudentNameA");
    	WebElement totalScore=driver.findElement(By.xpath("//a[contains(.,'"+strStudentName+"')]//ancestor-or-self::tr[1]//td[6]//span"));
    	String strTotalScoreExpect=totalScore.getText().trim();
    	String strTotalScoreExpected=strTotalScoreExpect.replace(" ","");
    	WebElement totalProgressValue=driver.findElement(By.xpath("//a[contains(.,'"+strStudentName+"')]//ancestor-or-self::tr[1]//td[8]//span"));
    	String strTotalProgressValue=totalProgressValue.getText().trim();
    	
    	if(strtotalScoreInActual.equals(strTotalScoreExpected)){
    		ResultUtil.report("PASS", "The total Score is Same as in One Student-All assignment Representstion", driver);
    	}
    	else{
    		ResultUtil.report("FAIL","The total Score is not equal as in One Student-All assignment Representation", driver);
    	}
    	
    	if(strTotalProgressActual.equals(strTotalProgressValue)){
    		ResultUtil.report("PASS","The Progress Value is Same as in One Student-All assignment Representation", driver);
    	}
    	else{
    		ResultUtil.report("FAIL","The Progress Value is not equal as in One Student-All assignment Representation", driver);
    	}
   
    	
 	}
 	  	
 	//Description:Course HomePage goToHome
 	public CourseHomePage goToHome(){
 		ResultUtil.report("INFO","GradeBookPage >>> goToHome", driver);
 		driver.switchTo().defaultContent();
 		Sync.waitForObject(driver,"Home Tab", "XPATH", "//li[@title='Home']");
 		Button.verify("Student Home Tab",btnHometab, driver);
 		Button.click("Student Home Tab", btnHometab, driver);
 		return PageFactory.initElements(driver, CourseHomePage.class);
 	}

 	//Description:click View Graph
 	public void clickViewGraph() throws InterruptedException{
 		ResultUtil.report("INFO","GradeBookPage >>> clickViewGraph", driver);	
 		driver.switchTo().defaultContent();
 		Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 3);
 		Sync.waitForFrame(driver, "gblev2top", "gblev2top", 3);
 		Button.verify("Instructor View Graph Button ", btnViewGraph, driver);
 		Button.click("Instructor View Graph Button",btnViewGraph, driver);
 		gotoFirstWindow();
 		this.driver.close();
 		goToParentWindow();	
 	}
 	
 	//Description:verify Question Score Assignment
 	public void verifyQuestionScoreAssignmentID(){
 		ResultUtil.report("INFO","GradeBookPage >>> verifyQuestionScoreAssignmentID", driver);
 		driver.switchTo().defaultContent();
		focusgblev1agFrame();
		List<WebElement> assignmentList=driver.findElements(By.xpath(strTableID+"//a"));
		int numQuestion=assignmentList.size();
		ResultUtil.report("MESSAGE", "Number Of Assignments:"+numQuestion, driver);
		List<WebElement> rowList=driver.findElements(By.xpath(strTableID+"//tr"));
		int rowSize=rowList.size();
		ResultUtil.report("MESSAGE","Number of Rows present: "+(rowSize-5), driver);
		int j=4;
		for(WebElement listAssignment:assignmentList){
			String str=listAssignment.getText().trim();
			ResultUtil.report("PASS",str, driver);
			for(int i=4;i<(rowSize-1);i++){
				String questionScore=driver.findElement(By.xpath(strTableID+"//tr["+i+"]//td["+j+"]")).getText().trim();
				ResultUtil.report("MESSAGE","Question Score- "+questionScore, driver);
			}
			j=j+2;
		}
 	}
 	
 	//Description:verify Assignment Name
 	public void verifyAssignmentName(){
 		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyAssignmentName");
 		WebElement assignmentName=driver.findElement(By.xpath("//table[@class='content-area']//table//table//table//table//tr[1]//td[2]//span"));
 		String strAssignment=assignmentName.getText();
 		ResultUtil.report("MESSAGE",strAssignment, driver);
 	}
 	 	
 	//Description:verify AssignmentType
 	public void verifyAssignmentType(){
 		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyAssignmentType");
 		WebElement assignmentType=driver.findElement(By.xpath("//table[@class='content-area']//table//table//table//table//table//tr[2]//td[2]"));
 		String strAssignmentType=assignmentType.getText();
 		ResultUtil.report("MESSAGE", strAssignmentType, driver);
 	}
 	
 	//Description:verify Startand Due Date
 	public void verifyStartandDueDate(){
 		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyAssignmentType");
 		WebElement eleDueDate=driver.findElement(By.xpath("//table[@class='content-area']//table//table//table//table//tr[3]//tr[1]//td[1]"));
 		String strDueDate=eleDueDate.getText().trim();
 		ResultUtil.report("MESSAGE",strDueDate, driver);
 		WebElement eleStartDate=driver.findElement(By.xpath("//table[@class='content-area']//table//table//table//table//table//tr[6]//td[2]"));
 		String strStartDate=eleStartDate.getText().trim();
 		ResultUtil.report("MESSAGE",strStartDate, driver);	
 	}
 	
 	//Description:select Question Submitted ShowWork
 	public void selectQuestionSubmittedShowWork(Map<String,String> dataMap){
 		ResultUtil.report("INFO","GradeBookPage >>> selectQuestionSubmittedShowWork", driver);
    	driver.switchTo().defaultContent();
    	String strQuestionName=dataMap.get("Question 1");
        WebElement elequestionName=driver.findElement(By.xpath(strTableClass+"//a[.='"+strQuestionName+"']"));
    	Link.verify("Question name",elequestionName, driver);
    	Link.click("Question name", elequestionName, driver);
    }
  	
 	//Description:select Question NoShowWork
 	public void selectQuestionNoShowWork(Map<String,String> dataMap){	
 		ResultUtil.report("INFO","GradeBookPage >>> selectQuestionNoShowWork", driver);
    	driver.switchTo().defaultContent();
    	String strQuestionName=dataMap.get("Question 1");
    	WebElement elequestionName=driver.findElement(By.xpath(strTableClass+"//a[.='"+strQuestionName+"']"));
    	Link.verify("Question name",elequestionName, driver);
    	Link.click("Question name", elequestionName, driver);
    }
 	
 	//Description:switch ToWindow
 	public void switchToWindow(){
 		ResultUtil.reportWithoutScreenshot("INFO", "GradeBookPage>>>switchToWindow");
 		String scoreQuestionWindow=driver.getWindowHandles().toArray()[1].toString();
    	driver.switchTo().window(scoreQuestionWindow);
 	}
 	
 	//Description:select Open Student Show Work
 	public void selectOpenStudentShowWork(){
 		ResultUtil.reportWithoutScreenshot("INFO", "GradeBookPage>>>selectOpenStudentShowWork");
 		String strStudent="//a[contains(.,'Open')]";
 		if(Element.verify("Open Student Show Work", driver, "xpath",strStudent )){
 			WebElement openStudentShowWork = driver.findElement(By.xpath(strStudent));
 			Link.click("Open Student's Show Work", openStudentShowWork, driver);
 		}
 		else{
 			
 			ResultUtil.report("INFO", "Open Student's Show Work is not displayed", driver);
 		}
  	}
 	
 	//Description: verify Student Show WorkWindow
 	public void verifyStudentShowWorkWindow(Map<String,String> dataMap){
 		ResultUtil.reportWithoutScreenshot("INFO", "GradeBookPage>>>verifyStudentShowWork");
 		String strOpenShowWorkWindow = driver.getWindowHandles().toArray()[2].toString();
 		driver.switchTo().window(strOpenShowWorkWindow);
 		
 		if(Element.verify("Verify Show Work", driver, "ID", "viewbar")){
 			String strID = dataMap.get("ID");
 			WebElement ID = driver.findElement(By.xpath("//div[contains(.,'ID:')]"));
 			Element.verify("Element Present or not", ID, strID, driver);	
 		    ResultUtil.report("PASS", "The Show Work Dispklayed", driver);
 		}
 		else{
 			String strFile = "File Not Available";
 			WebElement elementNotFound = driver.findElement(By.xpath("//button[.='File Not Available']"));
 			Element.verify("Element Present or not", elementNotFound, strFile, driver);
 			ResultUtil.report("FAIL", "The Show Work Not Dispklayed", driver);
 		}	
 	}
 	
 	//Description:close Window
 	public void closeWindow(){
  		ResultUtil.reportWithoutScreenshot("INFO", "GradeBookPage>>>closeWindow");
 		this.driver.close();
 		driver.switchTo().defaultContent();
 	}
 	
 	//Description:verify Complet eStatus
 	public void verifyCompleteStatus(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyStartandDueDate");
 		WebElement eleCompleteStatus=driver.findElement(By.xpath("//div[@class='orionProgress']//b"));
 		String strCompleteStatus=eleCompleteStatus.getText().trim();
 		ResultUtil.report("MESSAGE",strCompleteStatus, driver);
	}
 	
 	//Description:click Printer Version
	public void clickPrinterVersion(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> clickPrinterVersion");
		WebElement btnPrinterVersion=driver.findElement(By.xpath("//a[@id='Printer_version']"));
		Button.verify("Printer Version", btnPrinterVersion, driver);
		Button.click("Printer Version", btnPrinterVersion, driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
	}
	
	//Description:click Export Grades
	public void clickExportGrades(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> clickExportGrades");
		try{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "IFrame", 0, 3);
		}
		catch(Exception e){}
		WebElement btnExportGrades=driver.findElement(By.xpath("//a[@id='Export_Grades']"));
		Button.verify("Export Grades", btnExportGrades, driver);
		Button.click("Export grades",btnExportGrades, driver);
	}
	
	//Description:select Question WithoutShowWork	
	public void selectQuestionWithoutShowWork(Map<String,String> dataMap){
		ResultUtil.reportWithoutScreenshot("INFO", "GradeBookPage>>>selectQuestionWithoutShowWork");
		driver.switchTo().defaultContent();
    	String strQuestionName=dataMap.get("Question 3");
      	WebElement elequestionName=driver.findElement(By.xpath(strTableClass+"//a[.='"+strQuestionName+"']"));
    	Link.verify("Question name",elequestionName, driver);
    	Link.click("Question name", elequestionName, driver);
    }
	
	//Description:verify Assignment Link
	public void verifyAssignmentLink(Map<String,String> dataMap, String strAssignment){
		ResultUtil.report("INFO","GradeBookPage >>> verifyAssignmentLink", driver);
		driver.switchTo().defaultContent();
		String strAssignmentMap=dataMap.get(strAssignment);
		focusgblev1agFrame();
		WebElement assignmentLink=driver.findElement(By.xpath(strTableID+"//a[.='"+strAssignmentMap+"']"));
		Element.verify("Assignment Name", assignmentLink, driver);
		ResultUtil.reportWithoutScreenshot("MESSAGE", "ASSIGNMENT- "+strAssignmentMap);
	}
	
	//Description:question Link VerifyAssignment
	public void questionLinkVerifyAssignmentId(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> questionLinkVerifyAssignmentId");
		focusgblev2frames2htopFrame();
		Sync.waitForObject(driver, "List of Question Link","XPATH", strTableID+"//a");
		List <WebElement> eleQuestion=driver.findElements(By.xpath(strTableID+"//a"));
		int size=eleQuestion.size();
		WebElement eleVerticalScroll=driver.findElement(By.xpath(strTableID+"//a[contains(.,'Q3')]"));
		Browser.scrollToObject("Vertical Scroll", eleVerticalScroll, driver);
		ResultUtil.report("MESSAGE","Number of Questions- "+size, driver);
		
		if(size>12){
			WebElement eleScroll=driver.findElement(By.xpath(strTableID+"//a[contains(.,'Q"+size+"')]"));
			Browser.horizontalScrollToObject("Scrolling To Question", eleScroll, driver);
		}
		for(WebElement questionLink:eleQuestion){
			String strQuestion=questionLink.getText().trim();
			Link.verify("Question Link -"+strQuestion,questionLink, "", driver);
			ResultUtil.reportWithoutScreenshot("MESSAGE","Question- "+strQuestion);
		}
	}
	
	//Description:Click Question Link Assignment
	public void ClickQuestionLinkAssignmentId() throws InterruptedException{
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> ClickQuestionLinkAssignmentId");
		focusgblev2frames2htopFrame();
		List <WebElement> eleQuestion=driver.findElements(By.xpath(strTableID+"//a"));
		int size=eleQuestion.size();
		WebElement eleVerticalScroll=driver.findElement(By.xpath(strTableID+"//a[contains(.,'Q3')]"));
		Browser.scrollToObject("Vertical Scroll", eleVerticalScroll, driver);
		ResultUtil.report("MESSAGE","Number of Questions- "+size, driver);
		
		if(size>12){
			WebElement eleScroll=driver.findElement(By.xpath(strTableID+"//a[contains(.,'Q"+size+"')]"));
			Browser.horizontalScrollToObject("Scrolling To Question", eleScroll, driver);
		}
		for(WebElement questionLink:eleQuestion){
			focusgblev2frames2htopFrame();
			String strQuestion=questionLink.getText().trim();
			Link.click("Question Link -"+strQuestion, questionLink, driver);
			verifyMaximumPotential();
    		verifyEditedScoreBox();
    		verifyStudComboforQuestionLink();
    	}
	}
	
	//Description:Select the orion - class section 
	public void selectOrionClassSection(Map<String,String> dataMap) {
		ResultUtil.report("INFO","GradeBookPage >>> selectOrionClassSection", driver);
		try{	
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "IFrame", 0, 3);
		}
		catch(Exception e){}
		String  strClassSection = dataMap.get("ClassSection").trim();
		WebElement elmntClassSection = driver.findElement(By.xpath("//select[@id='clsSelector']/option[contains(text(),'"+strClassSection+"')]"));
		String strClassSectionName = elmntClassSection.getText();
		Combobox.selectItemByValue("Select the class sections", elmntComboClassSelector,strClassSectionName , driver);
		ResultUtil.report("PASS","Class is Selected", driver);
		Button.click("Grade Book Go", btnGo, driver);
	}
	
	//Description:Select the orion - class section - Only for D2L course
	public void selectOrionClassSectionD2L(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO","GradeBookPage >>> selectOrionClassSection", driver);
		driver.switchTo().defaultContent();
		String  strClassSection = dataMap.get("shortClassSection").trim();
		WebElement elmntClassSection = driver.findElement(By.xpath("//select[@id='clsSelector']/option[contains(text(),'"+strClassSection+"')]"));
		String strClassSectionName = elmntClassSection.getText();
		Combobox.selectItemByValue("Select the class sections", elmntComboClassSelector,strClassSectionName , driver);
		ResultUtil.report("PASS","Class is Selected", driver);
		Button.click("Grade Book Go", btnGo, driver);
	}
	
	//Description:results bread crumb
	public void resultsbreadcrumb(){
		ResultUtil.report("INFO","GradeBookPage >>> resultsbreadcrumb", driver);
		
		if(Link.verify("Results of", elmntResultsBreadCrumb, driver)){
			ResultUtil.report("PASS", "Results of link is displayed", driver);
			Link.click("Result of", elmntResultsBreadCrumb, driver);
		}
		else{
			ResultUtil.report("FAIL", "Results of link is not displayed", driver);
		}
	}
	
	//Description:Verify the orion assignments in the gradebook tab of one student
	public void validateOrionAssignments(){
		ResultUtil.report("INFO","GradeBookPage >>> selectOrionClassSection", driver);
		driver.switchTo().defaultContent();
		String strTable=strTableClass+"//tr[.//td//span[text()='ORION']]";
		List<WebElement> listOfOrionAssignments = driver.findElements(By.xpath(strTable));
		if(listOfOrionAssignments.size()==0){
			ResultUtil.report("FAIL", "No Orion assignment are displayed", driver);			
		}
		else{
			ResultUtil.report("PASS", "Orion assignment are displayed", driver);
			for(int i=1;i<=listOfOrionAssignments.size();i++){
				Link.verify("Chapter link", driver.findElement(By.xpath(strTable+"["+i+"]//a")), driver);
				WebElement progressValue = driver.findElement(By.xpath(strTable+"["+i+"]//td//span[text()='100%' or text()='0%']"));
				ResultUtil.report("MESSAGE", "Progress Value: "+progressValue.getText(), driver);		
				Link.click("Chapter link", driver.findElement(By.xpath(strTable+"["+i+"]//a")), driver);
				verifyCompleteStatus();
				verifyAssignmentType();
				verifyAssignmentName();
				verifyStartandDueDate();
				
				if((i==2))
				break;				
				resultsbreadcrumb();				
			}
		}		
	}
	
	//Description:Validate the printer page
	public void validatePrinterPage(Map<String,String> dataMap){
		ResultUtil.report("INFO","GradeBookPage >>> validatePrinterPage", driver);
		String strProductName = dataMap.get("Product");
		String strClassSectionName = dataMap.get("ClassSection");
		Element.verify("Product  Name", driver, "XPATH", "//td[contains(text(),'"+strProductName+"')]");
		Element.verify("Class Section  Name", driver, "XPATH", "//td/span[contains(text(),'"+strClassSectionName+"')]");
		Element.verify("Table Class Section  Name", driver, "XPATH", strTableID+"//span/nobr[text()='"+strClassSectionName+"']");
		driver.close();
		gotoFirstWindow();
	}
	
	//Description:Return to Blackboard page 
	public BlackBoardIntegrationPage returnToBlackboard(){
		ResultUtil.report("INFO", "GradeBookPage>>>>>returnToBlackboard", driver);
		Button.click("Return to Blackboard", elmntReturnBlackboard, driver);
		return PageFactory.initElements(driver, BlackBoardIntegrationPage.class);
	}
	
	//Description:Verify the Question First attempts instructor login
 	public void verifyFirstAttempt(){
 		ResultUtil.report("INFO","GradeBookPage >>> verifyFirstAttempt", driver);
 		driver.switchTo().defaultContent();
    	List<WebElement> firstAttempt=driver.findElements(By.xpath(strTableClass+"//td[contains(@class,'selenium_attempt_1')]"));
    	for(WebElement firstAttemptElement:firstAttempt){
    		String strFirstAttempt=firstAttemptElement.getText();
    		ResultUtil.reportWithoutScreenshot("MESSAGE","First Attempt- "+strFirstAttempt);
    		
    		if(strFirstAttempt.equalsIgnoreCase("-")){
    			ResultUtil.reportWithoutScreenshot("MESSAGE",strFirstAttempt+"- Question Not Attempted");
    		}
    		else{
    			Link.verify("First Question Attempt Link",firstAttemptElement, driver);
    			ResultUtil.reportWithoutScreenshot("MESSAGE",strFirstAttempt+"- Question Attempted");
    		}
    	}
 	}
 	
 	//Description:Verify the Question Second attempts
 	public void verifySecondAttempt(){
 		ResultUtil.report("INFO","GradeBookPage >>> verifySecondAttempt", driver);
 		driver.switchTo().defaultContent();
    	List<WebElement> secondAttempt=driver.findElements(By.xpath(strTableClass+"//td[contains(@class,'selenium_attempt_2')]"));
    	for(WebElement secondAttemptElement:secondAttempt){
    		String strSecondAttempt=secondAttemptElement.getText();
    		ResultUtil.reportWithoutScreenshot("MESSAGE","Second Attempt- "+strSecondAttempt);
    		
    		if(strSecondAttempt.equalsIgnoreCase("-")){
    			ResultUtil.reportWithoutScreenshot("MESSAGE",strSecondAttempt+"- Question Not Attempted");
    		}
    		else{
    			Link.verify("Second Question Attempt Link",secondAttemptElement, driver);
    			ResultUtil.reportWithoutScreenshot("MESSAGE",strSecondAttempt+"- Question Attempted");
    		}
    	}
 	}
 	
 	//Description:Verify the Question third Attempts
 	public void verifyThirdAttempt(){
 		ResultUtil.report("INFO","GradeBookPage >>> verifyThirdAttempt", driver);
 		driver.switchTo().defaultContent();
    	List<WebElement> thirdAttempt=driver.findElements(By.xpath(strTableClass+"//td[contains(@class,'selenium_attempt_3')]"));
    	for(WebElement thirdAttemptElement:thirdAttempt){
    		String strThirdAttempt=thirdAttemptElement.getText();
    		ResultUtil.reportWithoutScreenshot("MESSAGE","Third Attempt- "+strThirdAttempt);
    		if(strThirdAttempt.equalsIgnoreCase("-")){
    			ResultUtil.reportWithoutScreenshot("MESSAGE",strThirdAttempt+"- Question Not Attempted");
    		}
    		else{
    			Link.verify("Third Question Attempt Link",thirdAttemptElement, driver);
    			ResultUtil.reportWithoutScreenshot("MESSAGE",strThirdAttempt+"- Question Attempted");
    		}
    	}
 	}
 	
 	//Description:Verify All the Question Attempt column
 	public void verifyAllQuestionAttempts(){
 		ResultUtil.report("INFO","GradeBookPage >>> verifyAllQuestionAttempts", driver);
 		verifyFirstAttempt();
 		verifySecondAttempt();
 		verifyThirdAttempt();
 	}
	
 	//Description:Verify the Grading type Column
 	public void verifyGradingType(Map<String,String> dataMap){
 	 	ResultUtil.report("INFO","GradeBookPage >>> verifyGradingType", driver);
 	 	driver.switchTo().window(driver.getWindowHandle().toString());
 		Sync.waitForFrame(driver, "First Iframe", 0, 3);
 		String strGrading="//td[@class='selenium_grading_type']//span";
    	Sync.waitForObject(driver, "Grading Type","XPATH",strGrading );
    	List <WebElement> gradingType=driver.findElements(By.xpath(strGrading));
    	for(WebElement elementGradingType:gradingType){
    		String strGradingtype=elementGradingType.getText();
    		
    		if(strGradingtype.contains(dataMap.get("Grading type"))){
        		ResultUtil.report("PASS","Expected: "+dataMap.get("Grading type")+"\tActual: "+strGradingtype, driver);
    		}
    		else{
        		ResultUtil.report("FAIL","Expected: "+dataMap.get("Grading type")+"\tActual: "+strGradingtype, driver);
    		}
    	}
 	 }
 	 	
 	 //Description:Verify the Score Column 
 	 public void verifyScore(Map<String,String> dataMap){
 	 	ResultUtil.report("INFO","GradeBookPage >>> verifyScore", driver);
 	 	driver.switchTo().window(driver.getWindowHandle().toString());
 		Sync.waitForFrame(driver, "First Iframe", 0, 3);
 		String strSeleniumScore="//td[@class='selenium_score']";
    	Sync.waitForObject(driver, "Question Attempts","XPATH", strSeleniumScore);
    	List <WebElement> scoreEveryQn=driver.findElements(By.xpath(strSeleniumScore));
    	for(WebElement score:scoreEveryQn){
    		String strScore=score.getText();
    		String[] splitScore=strScore.split("\\/");
    		String strActual=splitScore[0];
    		String strPotential=splitScore[1];
    		int i=1;
    		if(i<=scoreEveryQn.size()){
    			String strPreActual=dataMap.get("PointsEarned"+i);
    			String strPrePotential=dataMap.get("MaxPoints"+i);
    			if(strPreActual.equals(strActual)){
    				ResultUtil.report("PASS", "Expected: "+strPreActual+"\tActual: "+strActual, driver);
    			}
    			else{
    				ResultUtil.report("FAIL", "Expected: "+strPreActual+"\tActual: "+strActual, driver);
    			}
    			if(strPrePotential.equals(strPotential)){
    				ResultUtil.report("PASS", "Expected: "+strPrePotential+"\tActual: "+strPotential, driver);
    			}
    			else{
    				ResultUtil.report("FAIL", "Expected: "+strPrePotential+"\tActual: "+strPotential, driver);
    			}
    		}
    		i=i+1;
    	}
 	}

    //Description:Verify the Total Score column
 	public void verifyTotalScore(){
 		ResultUtil.report("INFO","GradeBookPage >>> verifyTotalScore", driver);
 		driver.switchTo().window(driver.getWindowHandle().toString());
 		Sync.waitForFrame(driver, "First Iframe", 0, 3);
		List<String> lstScoreEveryQn=new ArrayList<String>();
		String strSeleniumScore="//td[@class='selenium_score']";
		Sync.waitForObject(driver, "Total Score Field", "XPATH",strSeleniumScore );
    	List<WebElement> scoreEveryQn=driver.findElements(By.xpath(strSeleniumScore));
    	for(WebElement score:scoreEveryQn){
    		String strScore=score.getText();
    		lstScoreEveryQn.add(strScore);
    	}
    	int rowsize=scoreEveryQn.size();
		float actual=0;
		int potential=0;
		for(int i=0;i<rowsize;i++){
			String score=lstScoreEveryQn.get(i);
			if(score.contains("/")){
			String[] splitTotal=score.split("\\/");
			if(!splitTotal[0].contains("-")){
				String stractual=splitTotal[0];
				Float actualValue=Float.parseFloat(stractual);
				actual=actual+actualValue;
			}
			String strPotential=splitTotal[1];
			int potentialValue=Integer.parseInt(strPotential);
			potential=potential+potentialValue;
			}
		}
		String strAct=Float.toString(actual);
		String strPot=Float.toString(potential);
		WebElement totalScoreInActual=driver.findElement(By.xpath("//td[.='Total Score:']//following-sibling::td[./b]"));
		String strtotalScoreInActual=totalScoreInActual.getText();
		String[] strSplitActualAndPotential=strtotalScoreInActual.split("\\/");
		String strActualScore=strSplitActualAndPotential[0];
		String strPotentialScore=strSplitActualAndPotential[1];
		if(strActualScore.equals(strAct)){
			ResultUtil.report("PASS","Expected:"+actual+"\tActual:"+strActualScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+actual+"\tActual:"+strActualScore, driver);
		}
		if(strPotentialScore.equals(strPot)){
			ResultUtil.report("PASS","Expected:"+potential+"\tpotential:"+strPotentialScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+potential+"\tpotential:"+strPotentialScore, driver);
		}

    	String strtotalScore=driver.findElement(By.xpath(strTableClass+"["+rowsize+"]//td[10]")).getText();
    	ResultUtil.report("MESSAGE", "Total Score- "+strtotalScore, driver);
 	}
 	
 	//Description:weighted Score
 	public void weightedScore(Map<String,String> dataMap, String strAssignmentName){ 	 		
 		ResultUtil.report("INFO", "GradeBookPage>>>weightedScore", driver); 	 		
 		String strAssignment = dataMap.get(strAssignmentName);
 		WebElement weightedScore = driver.findElement(By.xpath(strTableClass+"//tr//td[./a[contains(.,'"+strAssignment+"')]]//following-sibling::td[6]")); 	 		
 		Element.verify("Weighted Score", weightedScore, driver); 	 		
 	}
 	
 	//Description:verify Student Graded Feedback
 	public void verifyStudentGradedFeedback(){ 	 		
 		ResultUtil.report("INFO", "GradeBookPage>>>verifyStudentGradedFeedback", driver);	 		 	 	
 		WebElement studentGrade = driver.findElement(By.xpath("//table[@class='qti-presentation-feedback']//tr[./td[contains(.,'correct')]]")); 	 		
 		Element.verify("Student Gradebook FeedBack", studentGrade, driver); 	 		
 		ResultUtil.report("MESSAGE","FeedBack"+ studentGrade.getText(), driver);
 	}
 	
 	//Description:Click assignment's Name link
	public void clickFirstAssignmentNameLink(Map<String,String> dataMap) {
		ResultUtil.report("INFO","GradeBookPage >>> clickAssignmentNameLink", driver); 			
		String strFirstAssignmentName=dataMap.get("First Assignment");
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "contentFrame", "contentFrame", 2);
		String strTable=strTableClass+"//a[.='"+strFirstAssignmentName+"']";
		Sync.waitForObject(driver, "Assignment Name Link", "XPATH",strTable );
		WebElement lnkAssignmentName=driver.findElement(By.xpath(strTable));
		Link.verify("Verify the Assignment Link name", lnkAssignmentName, strFirstAssignmentName, driver);
		Link.click("Click the Assignment Link Id", lnkAssignmentName, driver);
	}
 		
 	//Description:Select orion assignment
	public void selectOrionAssignment(Map<String,String> dataMap, String strAssignmentType) {
		ResultUtil.report("INFO","GradeBookPage >>> clickAssignmentNameLink", driver); 			
		String strAssignmentName=dataMap.get(strAssignmentType);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "IFrame", 0, 3);
		String strTable=strTableClass+"//a[.='"+strAssignmentName+"']";
		Sync.waitForObject(driver, "Assignment Name Link", "XPATH", strTable);
		WebElement lnkAssignmentName=driver.findElement(By.xpath(strTable));
		Link.verify("Verify the Assignment Link name", lnkAssignmentName, strAssignmentName, driver);
		Link.click("Click the Assignment Link Id", lnkAssignmentName, driver);
	}
	
    //Description:click All QuestionLink
	public void clickAllQuestionLink() throws InterruptedException{
		ResultUtil.report("INFO","GradeBookPage >>> clickAllQuestionLink", driver);
		driver.switchTo().defaultContent();
		String strTable=strTableClass+"//td[@class='selenium_qtitle']//a";
		Sync.waitForObject(driver, "List of Question links", "XPATH",strTable);
		List<WebElement> eleQuestionLink=driver.findElements(By.xpath(strTable));
		for(WebElement questionLink:eleQuestionLink){
			String strQuestion=questionLink.getText().trim();
			Link.verify("Question Link- "+strQuestion,questionLink, driver);
			Link.click("Question Link- "+strQuestion,questionLink, driver);
			verifyMaximumPotential();
    		verifyEditedScoreBox();
    		verifyStudComboforQuestionLink();
    	}
	}
	
    //Description:verify TotalScore Assignment
	public void verifyTotalScoreAssignmentId(Map<String,String> dataMap,String strstudentName){
		ResultUtil.report("INFO","GradeBookPage >>> verifyTotalScoreAssignmentId", driver);
		focusgblev2frames2hFrame();
		String strstudentNameLink=dataMap.get(strstudentName);
		List<String> lstRawvalues=new ArrayList<String>();
		List <WebElement> rawScoreValue=driver.findElements(By.xpath("//a[contains(.,'"+strstudentNameLink+"')]//ancestor-or-self::tr[1]/span"));
		for(WebElement rawScore:rawScoreValue){
			String rawValue=rawScore.getText().trim();
			lstRawvalues.add(rawValue);
			ResultUtil.report("MESSAGE","RawScore- "+rawValue, driver);
		}
		int size=lstRawvalues.size();
		float actual=0;
		int potential=0;
		for(int i=0;i<size;i++){
			String score=lstRawvalues.get(i);
			
			if(score.contains("/")){
			String[] splitTotal=score.split("\\/");
			
			if(!splitTotal[0].contains("-")){
				String stractual=splitTotal[0];
				Float actualValue=Float.parseFloat(stractual);
				actual=actual+actualValue;
			}
			String strPotential=splitTotal[1];
			int potentialValue=Integer.parseInt(strPotential);
			potential=potential+potentialValue;
			}
		}
		String str=Float.toString(actual);
		String str1=Float.toString(potential);
		WebElement totalScoreInActual=driver.findElement(By.xpath("//a[contains(.,'"+strstudentNameLink+"')]//ancestor-or-self::tr[1]//td[4]"));
		String strtotalScoreInActual=totalScoreInActual.getText();
		String[] strSplitActualAndPotential=strtotalScoreInActual.split("\\/");
		String strActualScore=strSplitActualAndPotential[0];
		String strPotentialScore=strSplitActualAndPotential[1];
		if(strActualScore.equals(str)){
			ResultUtil.report("PASS","Expected:"+actual+"\tActual:"+strActualScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+actual+"\tActual:"+strActualScore, driver);
		}
		if(strPotentialScore.equals(str1)){
			ResultUtil.report("PASS","Expected:"+potential+"\tpotential:"+strPotentialScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+potential+"\tpotential:"+strPotentialScore, driver);
		}
	}
	
 	//Description:Switch to  window
	public void switchBackToParentWindow() throws InterruptedException{
		ResultUtil.report("INFO", "AngelHomePage > switchBackToParentWindow", driver);
		try{				
			gotoFirstWindow();
			String strWindowName = driver.getTitle();
			ResultUtil.report("MESSAGE","Window Name"+ strWindowName, driver);
			driver.close();
			goToParentWindow();
		}
		catch(Exception e){}
		finally{
			goToParentWindow();
			String strWindowName = driver.getTitle();
			ResultUtil.report("MESSAGE","Window Name"+ strWindowName, driver);
		}
	}
	
 	//Description:click WP Grade BookBread Crumb
	public void clickWPGradeBookBreadCrumb(){
    	ResultUtil.report("INFO","GradeBookPage >>> clickGradeBookBreadCrumb", driver);    	
    	Sync.waitForObject(driver, "GradeBook BreadCrumb Link","XPATH", "//span[@class='breadcrumb']//a[.='Gradebook']");
    	Link.verify("GradeBook Link in BreadCrumb",gradeBookLinkBreadCrumb, driver);
    	Link.click("GradeBook Link in BraedCrumb",gradeBookLinkBreadCrumb, driver);
    }
	 
 	//Description:click WPExport Grades
	public void clickWPExportGrades(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> clickExportGrades");
		WebElement btnExportGrades=driver.findElement(By.xpath("//a[@id='Export_Grades']"));
		Button.verify("Export Grades", btnExportGrades, driver);
		Button.click("Export grades",btnExportGrades, driver);
	}
	 
 	//Description:verify Find Student TextBox
	public void verifyFindStudentTextBox(){
		 ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyFindStudentTextBox");
		 Element.verify("Find Student TextBox",findStudentTextBox, driver);
	 }
	
 	 //Description:verify ClassDropDown
	 public void verifyClassDropDown(){
		 ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyClassDropDown");
		 Combobox.isEnabled(elmntComboClassSelector, "Class DropDown List Box", driver);
	 }
 	 //Description:verify Activities DropDown
	 public void verifyActivitiesDropDown(){
		 ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> verifyActivitiesDropDown");
		 Combobox.isDisabled(elmntComboActivityType, "Activities Drop Down", driver);
	 }

	 //Description: Try and catch block for frame
	 public void switchtoZeroFrame(){
		 try{
		    	driver.switchTo().defaultContent();
		    	Sync.waitForFrame(driver, "container", "container", 2);
		    }
		    catch(Exception e){}
	 }
	 
 	 //Description:Click GradeBook From BreadCrumb- Addl
	 public void clickBBGradeBookBreadCrumb(){
	    ResultUtil.report("INFO","GradeBookPage >>> clickGradeBookBreadCrumb", driver);    	
	    switchtoZeroFrame();
    	Sync.waitForObject(driver, "GradeBook BreadCrumb Link","XPATH", "//span[contains(@class,'breadcrumb')]//a[.='Gradebook']");
    	Link.verify("GradeBook Link in BreadCrumb",gradeBookLinkBreadCrumb, driver);
    	Link.click("GradeBook Link in BraedCrumb",gradeBookLinkBreadCrumb, driver);
	 }
	    
	 //Description:Export grades in BB- Addl
	 public void clickBBExportGrades(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> clickBBExportGrades");
		switchtoZeroFrame();
		WebElement btnExportGrades=driver.findElement(By.xpath("//a[@id='Export_Grades']"));
		Button.verify("Export Grades", btnExportGrades, driver);
		Button.click("Export grades",btnExportGrades, driver);
	}
	   
	 //Description:Blackboard printer version- Addl
	 public void clickBBPrinterVersion(){
		ResultUtil.reportWithoutScreenshot("INFO","GradeBookPage >>> clickBBPrinterVersion");
		WebElement btnPrinterVersion=driver.findElement(By.xpath("//a[@id='Printer_version']"));
		Button.verify("Printer Version", btnPrinterVersion, driver);
		Button.click("Printer Version", btnPrinterVersion, driver);
		gotoFirstWindow();
	}
		
	//Description:Validate the printer page - Addl
	public void validateBBPrinterPage(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO","GradeBookPage >>> validateBBPrinterPage", driver);
		String strProductName = dataMap.get("Product");
		String strClassSectionName = dataMap.get("ClassSection");
		Element.verify("Product  Name", driver, "XPATH", "//td[contains(text(),'"+strProductName+"')]");
		Element.verify("Class Section  Name", driver, "XPATH", "//td/span[contains(text(),'"+strClassSectionName+"')]");
		Element.verify("Table Class Section  Name", driver, "XPATH", strTableID+"//span/nobr[text()='"+strClassSectionName+"']");
		driver.close();
		goToParentWindow();
	}
	
	//Description: Validate All Student--All Assignment
	public void validateAllStudentAllAssignment(){
		ResultUtil.report("INFO","GradeBookPage >>> validateAllStudentAllAssignment", driver);
		driver.switchTo().defaultContent();
		focusgblev1agFrame();
		String strTableLink=strTableClass+"//a";
		Sync.waitForObject(driver,"Student Link", "XPATH",strTableLink );
		List<WebElement> lnkAssignmentID=driver.findElements(By.xpath(strTableLink));
		int assignmentIDCount=lnkAssignmentID.size();
		
		if(assignmentIDCount>=1){
			ResultUtil.report("PASS", "Assignment ID is displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "No Assignment is displayed", driver);
		}
		
	    driver.switchTo().defaultContent();
	    focus2framegblev1st();
	    String strTable=strTableID+"//tr[2]//td[@align='center']";
	    Sync.waitForObject(driver, "Student Name Link","XPATH", strTable);
	    List<WebElement> lnkStudentName=driver.findElements(By.xpath(strTable));
	    int studentCount=lnkStudentName.size();
	   
	    if(studentCount>=1){
	    	ResultUtil.report("PASS", "Student Name is Displayed", driver);
	    }
	    else{
	    	ResultUtil.report("FAIL", "No Student Name Displayed", driver);
	    }
	}
	
	//Description: Validate All Student One Assignment
	public void validateAllStudentOneAssignment(){
		ResultUtil.report("INFO","GradeBookPage >>> validateAllStudentOneAssignment", driver);
		WebElement elmntAssignmentName=driver.findElement(By.xpath("//td[.='Assignment Name:']//following-sibling::td//span"));
		
		if(elmntAssignmentName.isDisplayed()){
			ResultUtil.report("PASS", "One Assignment Representation Opened"+"Assignment Name:- "+elmntAssignmentName.getText(), driver);
		}
		else{
			ResultUtil.report("FAIL", "No Assignment Represntation is displayed", driver);
		}
		
		driver.switchTo().defaultContent();
		focusgblev2frames2hFrame();
		List<WebElement>lnkStudentName=driver.findElements(By.xpath("//a"));
		int studentCount=lnkStudentName.size();
		
		if(studentCount>=1){
			ResultUtil.report("PASS", "Student Name is Displayed", driver);
	    }
	    else{
	    	ResultUtil.report("FAIL", "No Student Name Displayed", driver);
	    
		}
	}
	
	//Description: Validate One All Assignment
	public void validateOneStudentAllAssignment(){
		ResultUtil.report("INFO","GradeBookPage >>> validateOneStudentAllAssignment", driver);
		WebElement oneStudent=driver.findElement(By.xpath("//span[@class='breadcrumb']//b"));
		
		if(oneStudent.isDisplayed()){
			ResultUtil.report("PASS", "One Student Representation Opened"+"Student Name: "+oneStudent.getText() , driver);
		}
		else{
			ResultUtil.report("FAIL", "No student is Displayed", driver);
		}
		
		List<WebElement> elmntAssignmentList=driver.findElements(By.xpath(strTableClass+"//td[4]"));
		int countAssignment=elmntAssignmentList.size();
		
		if(countAssignment>=1){
			ResultUtil.report("PASS", "Assignment Name List Dispalyed", driver);
		}
		else{
			ResultUtil.report("FAIL", "Assignment Name is not dispalyed", driver);
		}
	}
	
	//Description: Validate One Student One Assignment
	public void validateOneStudentOneAssignment(){
		ResultUtil.report("INFO","GradeBookPage >>> validateOneStudentOneAssignment", driver);
		WebElement elmntStudentName=driver.findElement(By.xpath("//span[@class='breadcrumb']//a[2]"));
		
		if(elmntStudentName.isDisplayed()){
			ResultUtil.report("PASS", "One Student Representation Opened", driver);
		}
		else{
			ResultUtil.report("FAIL","No student Representation Opened", driver);
		}
		
		WebElement elmntAssignmentName=driver.findElement(By.xpath("//td[.='Assignment Name:']//following-sibling::td//span"));
		
		if(elmntAssignmentName.isDisplayed()){
			ResultUtil.report("PASS", "One Assignment Representation Opened"+"Assignment Name:- "+elmntAssignmentName.getText(), driver);
		}
		else{
			ResultUtil.report("FAIL", "No Assignment Represntation is displayed", driver);
		}
	}
	
	//Description: Validate One Student One Item in New Window 
	public void validateOneStudentOneItem() throws InterruptedException{
		ResultUtil.report("INFO","GradeBookPage >>> validateOneStudentOneItem", driver);
		gotoFirstWindow();
		String strPageTitle=driver.getTitle();
		WebElement elmntStudentName=driver.findElement(By.xpath("//select[@id='ids']//option[@selected='selected']"));
		
		if(elmntStudentName.isDisplayed()){
			ResultUtil.report("PASS", "New Modal Window Opened with one Item"+"Question Name:-"+strPageTitle, driver);
			ResultUtil.report("PASS", "One Student is Displayed Selected in ComboBox"+"Student Name:-"+elmntStudentName.getText(), driver);
		}
		else{
			ResultUtil.report("FAIL","No Window Opened For Student", driver);
		}
		goToParentWindow();
	}
	
	//Description: Validate Total Diagnostic Results
	public void validateAllStudentTotalDiagnostic(){
		ResultUtil.report("INFO","GradeBookPage >>> validateAllStudentTotalDiagnostic", driver);
		focusgblev1frames2hFrame();
		List<WebElement> elmntStudentName=driver.findElements(By.xpath(strTableID+"//td[2]"));
		int studentCount=elmntStudentName.size();
		
		if(studentCount>=1){
			ResultUtil.report("PASS","All Student representation dispalyed", driver);
		}
		else{
			ResultUtil.report("FAIL","No student Representation is not displayed", driver);
		}
		
		List<WebElement> elmntTotalDiagnostic=driver.findElements(By.xpath(strTableID+"//td[6]"));
		int totalDiagnosticCount=elmntTotalDiagnostic.size();
		
		if(totalDiagnosticCount>=1){
			ResultUtil.report("PASS","Total Diagnostic Representation dispalyed", driver);
		}
		else{
			ResultUtil.report("FAIL", "No Total Diagnostic represetation is not displayed", driver);
		}
	}
	
	//Description: Validate All Student All Study objective
	public void validateAllStudentAllStudyObjective(){
		ResultUtil.report("INFO","GradeBookPage >>> validateAllStudentAllStudyObjective", driver);
		driver.switchTo().defaultContent();
		focusgblev1agFrame();
		String strTable=strTableClass+"//a";
		Sync.waitForObject(driver,"Student Link", "XPATH", strTable);
		List<WebElement> lnkStudyObjective=driver.findElements(By.xpath(strTable));
		int studyObjectiveCount=lnkStudyObjective.size();
		
		if(studyObjectiveCount>=1){
			ResultUtil.report("PASS", "Assignment ID is displayed", driver);
		}
		else{
			ResultUtil.report("FAIL", "No Assignment is displayed", driver);
		}
		
	    driver.switchTo().defaultContent();
	    focus2framegblev1st();
	    Sync.waitForObject(driver, "Student Name Link","XPATH", strTableID+"//tr[2]//td[@align='center']");
	    List<WebElement> lnkStudentName=driver.findElements(By.xpath(strTableID+"//tr[2]//td[@align='center']"));
	    int studentCount=lnkStudentName.size();
	   
	    if(studentCount>=1){
	    	ResultUtil.report("PASS", "Student Name is Displayed", driver);
	    }
	    else{
	    	ResultUtil.report("FAIL", "No Student Name Displayed", driver);
	    }
	}
	
	//Description: Verify Score of Assignment ID
	public void verifyScoreAssignmentID(Map<String,String>dataMap,String strStudentNameLink,String strAssignmentEarnedPoints,String strAssginmentMaximumPoints ){
		ResultUtil.report("INFO","GradeBookPage >>> verifyScoreAssignmentID", driver);
		String StrStudentName=dataMap.get(strStudentNameLink);
		focusgblev2frames2hFrame();
		WebElement  elmntRawScore=driver.findElement(By.xpath("//a[contains(.,'"+StrStudentName+"')]//ancestor-or-self::tr[1]//td/span"));
		String strRawScore=elmntRawScore.getText();
		String[] strraw=strRawScore.split("\\/");
		String stractualScore=strraw[0];
		String strPointsActual=dataMap.get(strAssignmentEarnedPoints);
		String strMaxScore=strraw[1];
		String strPointsTotal=dataMap.get(strAssginmentMaximumPoints);
		
		if(stractualScore.equals(strPointsActual)){
			ResultUtil.report("PASS","Expected:"+strPointsActual+"Actual:"+stractualScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+strPointsActual+"Actual:"+stractualScore, driver);
		}
				
		if(strMaxScore.equals(strPointsTotal)){
			ResultUtil.report("PASS","Expected:"+strPointsTotal+"Actual:"+strMaxScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+strPointsTotal+"Actual:"+strMaxScore, driver);
			}
	}
	
	//Description:verify Class Average Assignment
	public void validateClassAverage()
	{
		ResultUtil.report("INFO","GradeBookPage >>> validateClassAverage", driver);
		String strActualValue=new String();
		String strPotentialValue=new String();
		driver.switchTo().defaultContent();
		focusgblev1agFrame();
		List<String> lstActual=new ArrayList<String>();
		List<String> lstPotential=new ArrayList<String>();
 		List<WebElement> scoreList=driver.findElements(By.xpath(strTableID+"//td[@align='center']//nobr/span"));
 		for(WebElement score:scoreList){
 			String strScore=score.getText();
 			String[] splitScore=strScore.split("\\/");
 			lstActual.add(splitScore[0]);
 			lstPotential.add(splitScore[1]);
 		}
 		int rowCount=scoreList.size();
 		int rowSize=rowCount/2;
 		int i=1;
 		float actual=0;
 		float potential=0;
 		for(i=1;i<=rowCount/2;i++){
 			String strActualEarned=lstActual.get(i);
 			if(!strActualEarned.contains("-")){
 				float act=Float.parseFloat(strActualEarned);
 				actual=act+actual;
 			}
 			
 			strActualValue=Float.toString(actual);
 		}
			actual=actual/rowSize;

 		i=rowSize;
 		for(i=rowSize;i<rowCount;i++){
 			String strPotentialEarned=lstPotential.get(i);
 			if(!strPotentialEarned.contains("-")){
 				float pot=Float.parseFloat(strPotentialEarned);
 				potential=pot+potential;
 			}
 			potential=potential/rowSize;
 			strPotentialValue=Float.toString(potential);
 		}
 		List<WebElement> totalScore=driver.findElements(By.xpath(strTableID+"//td[@align='center']//nobr/b"));
 		for(WebElement total:totalScore){
 			String strTotal=total.getText();
 			String[] splitTotal=strTotal.split("\\/");
 			String strActualAverage=splitTotal[0];
 			String strPotentialAverage=splitTotal[1];
 			if(strPotentialValue.equals(strPotentialAverage)){
 	 			ResultUtil.report("PASS", "Expected Average: "+strPotentialAverage+"  Actual Average:"+strPotentialValue, driver);
 			}
 			else{
 	 			ResultUtil.report("FAIL", "Expected Average: "+strPotentialAverage+"  Actual Average:"+strPotentialValue, driver);
 			}
			if(strActualValue.equals(strActualAverage)){
 	 			ResultUtil.report("PASS", "Expected Average: "+strActualAverage+"  Actual Average:"+strActualValue, driver);
 			}
 			else{
 	 			ResultUtil.report("FAIL", "Expected Average: "+strActualAverage+"  Actual Average:"+strActualValue, driver);
 			}
 		}
 	}
	
	//Description:verify Question Score Assignment
 	public void validateScoreValuesForAsgnments(Map<String,String> dataMap, String strStudentNames){
 		ResultUtil.report("INFO","GradeBookPage >>> validateScoreValuesForAsgnments", driver);
 		List<String> lstActual=new ArrayList<String>();
 		List<String> lstPotential=new ArrayList<String>();
 		driver.switchTo().defaultContent();
 		focus2framegblev1st();
 		String strStudentName=dataMap.get(strStudentNames);
 		WebElement stuent=driver.findElement(By.xpath("//a[contains(.,'"+strStudentName+"')]//parent::nobr"));
 		String strStudent=stuent.getText();
 		String[] splitStuent=strStudent.split("\\.");
 		String strStudentNo=splitStuent[0];
		focusgblev1agFrame();
		List<WebElement> rawScore=driver.findElements(By.xpath(strTableID+"//tr[./td[.='"+strStudentNo+".']]//following-sibling::td[@align='center']//span"));
		int count=1;
		for(WebElement raw:rawScore){
			String strRaw=raw.getText();
			String[] splitRaw=strRaw.split("\\/");
			lstActual.add(splitRaw[0]);
			lstPotential.add(splitRaw[1]);
			count=count+1;
		}
		int rowSize=lstActual.size();
 		List<String> lstDpActual=new ArrayList<String>();
 		List<String> lstDpPotential=new ArrayList<String>();
		for(int j=1;j<=rowSize;j++){
			lstDpActual.add(dataMap.get("TotalPointsEarned"+j));
			lstDpPotential.add(dataMap.get("TotalMaxScore"+j));
		}
		for(int i=0;i<rowSize;i++){
			
			String strlstActualEarned=lstActual.get(i); 
			String strlstActualPotential=lstPotential.get(i);
			String strTotalPointsEarned=lstDpActual.get(i);
			String strPotentialPoints=lstDpPotential.get(i);
			if(strTotalPointsEarned.equals(strlstActualEarned)){
				ResultUtil.report("PASS", "Expected: "+strTotalPointsEarned+"  Actual:"+strlstActualEarned, driver);
			}
			else{
				ResultUtil.report("FAIL", "Expected: "+strTotalPointsEarned+"  Actual:"+strlstActualEarned, driver);
			}
			if(strPotentialPoints.equals(strlstActualPotential)){
				ResultUtil.report("PASS", "Expected: "+strPotentialPoints+"  Actual:"+strlstActualPotential, driver);
			}
			else{
				ResultUtil.report("FAIL", "Expected: "+strPotentialPoints+"  Actual:"+strlstActualPotential, driver);
			}
		}
	}		
	
 	//Description: Select AssignmentList
 	public void selectAssignmentList(Map<String,String> dataMap,String strAssignment){
 		ResultUtil.report("INFO","GradeBookPage >>> selectAssignmentList", driver);
 		WebElement Assignment=Sync.waitForObject(driver, "Assignment List", "XPATH", "//select[@id='assignments']");
		Listbox.deselectAll(Assignment, "Assignment", driver);
		String assignments=dataMap.get("AsgntList");
		Listbox.selectItems("Assignment", Assignment, assignments, driver);
 	}
 	
 	//Description: First Question
 	public void clickFirstQuestionAttempt(Map<String,String>dataMap) throws InterruptedException{
 		ResultUtil.report("INFO","GradeBookPage >>> clickFirstQuestionAttempt", driver);
 		String strQuestionFirst=strTableClass+"//tr[3]//td[@class='selenium_attempt_3']";
 		WebElement elmntThird=driver.findElement(By.xpath(strQuestionFirst));
 		Link.click("Third Attempt", elmntThird, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore, dataMap.get("Score1"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 		
 		String strAttemptSecond=strTableClass+"//tr[3]//td[@class='selenium_attempt_2']";
 		WebElement elmntSecond=driver.findElement(By.xpath(strAttemptSecond));
 		Link.click("Third Attempt", elmntSecond, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore, dataMap.get("Score2"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 		
 		String strAttemptFirst=strTableClass+"//tr[3]//td[@class='selenium_attempt_1']";
 		WebElement elmntFirst=driver.findElement(By.xpath(strAttemptFirst));
 		Link.click("Third Attempt", elmntFirst, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore, dataMap.get("Score3"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 	}
 	
 	//Description: Second Question
 	public void clickSecondQuestionAttempt(Map<String,String>dataMap) throws InterruptedException{
 		ResultUtil.report("INFO","GradeBookPage >>> clickSecondQuestionAttempt", driver);
 		String strSecondQuestion=strTableClass+"//tr[4]//td[@class='selenium_attempt_2']";
 		WebElement secondQn=driver.findElement(By.xpath(strSecondQuestion));
 		Link.click("Second attempts", secondQn, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore,  dataMap.get("Score2"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 		
 		String strQuestionFirst=strTableClass+"//tr[4]//td[@class='selenium_attempt_3']";
 		WebElement elmntThird=driver.findElement(By.xpath(strQuestionFirst));
 		Link.click("Third Attempt", elmntThird, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore, dataMap.get("Score1"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 	}
 	
 	//Description: Third Question
 	public void clickThirdQuestionAttempt(Map<String,String>dataMap) throws InterruptedException{
 		ResultUtil.report("INFO","GradeBookPage >>> clickThirdQuestionAttempt", driver);
 		String strThirdQuestion=strTableClass+"//tr[5]//td[@class='selenium_attempt_1']";
 		WebElement thirdQn=driver.findElement(By.xpath(strThirdQuestion));
 		Link.click("First Attempt", thirdQn, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore,  dataMap.get("Score2"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 		
 		String strSecondQuestion=strTableClass+"//tr[5]//td[@class='selenium_attempt_2']";
 		WebElement secondQn=driver.findElement(By.xpath(strSecondQuestion));
 		Link.click("Second attempts", secondQn, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore, dataMap.get("Score1"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 		
 		String strQuestionFirst=strTableClass+"//tr[5]//td[@class='selenium_attempt_3']";
 		WebElement elmntThird=driver.findElement(By.xpath(strQuestionFirst));
 		Link.click("Third Attempt", elmntThird, driver);
 		gotoFirstWindow();
 		TextBox.enterValue("Edit Score", textEditScore, dataMap.get("Score3"), driver);
 		Button.click("Submit", btnQuestionWindowSubmit, driver);
 		this.driver.close();
 		goToParentWindow();
 	}
 	
 	//Description: Click All student Link
 	public void clickAllStudentLink(Map<String,String>dataMap) throws Exception{
 		ResultUtil.report("INFO","GradeBookPage >>> clickAllStudentLink", driver);
 		driver.switchTo().defaultContent();
 		focus2framegblev1st();
 		List<WebElement> elmntStudentlink=driver.findElements(By.xpath("//a"));
 		int size=elmntStudentlink.size();
 		for(int i=1;i<size-1;i++){
 			int j=2+i;
 			WebElement elmntStudent=driver.findElement(By.xpath("//tr["+j+"]//a"));
 			Link.click("Student Link",elmntStudent, driver);
 			clickAssignmentLink(dataMap, "AsgntEditAllName1");
 			clickFirstQuestionAttempt(dataMap);
 			clickGradeBookBreadCrumb();
 			focus2framegblev1st();
 		}
 	}
 	
 	//Description: Edit All Question Link for pre Condition
 	public void editScoreForSubmitPre(Map<String,String> dataMap) throws InterruptedException{
 		ResultUtil.report("INFO","GradeBookPage >>> editScoreForSubmitPre", driver);
 		focusgblev2frames2htopFrame();
 		List<WebElement> elmntQuestionLink=driver.findElements(By.name("mark"));
 		int i=1;
 		for(WebElement elmntQuestion:elmntQuestionLink){
 			Link.click("Question: "+elmntQuestion.getText(),elmntQuestion , driver);
 			gotoFirstWindow();
 			String strEditedScoreValue=dataMap.get("SubmitEditScore"+i);
 			TextBox.clearValue("Edit Score", textEditScore, driver);
 			TextBox.enterValue("Edit Score", textEditScore, strEditedScoreValue, driver);
 			goToParentWindow();
 			focusgblev2frames2htopFrame(); 			
 		}
 	}
 	
 	//Description: validating the raw score values
 	public void validateScoreValues(Map<String,String> dataMap, String strStudentName){
 		ResultUtil.report("INFO","GradeBookPage >>> validateScoreValues", driver);
 		focus2framegblev1st();
 		String strStudentNames=dataMap.get(strStudentName);
 		WebElement stuent=driver.findElement(By.xpath("//a[contains(.,'"+strStudentNames+"')]//parent::nobr"));
 		String strStudent=stuent.getText();
 		String[] splitStuent=strStudent.split("\\.");
 		String strStudentNo=splitStuent[0];
		focusgblev1agFrame();
		List<WebElement> rawScore=driver.findElements(By.xpath(strTableID+"//tr[./td[.='"+strStudentNo+".']]//following-sibling::td[@align='center']//span"));
		for(WebElement raw:rawScore){
			String strRaw=raw.getText();
			if(strRaw.contains("grade")){
				ResultUtil.report("PASS", "To grade is displayed"+strRaw, driver);
			}
			else{
				ResultUtil.report("FAIL", "Score is graded"+strRaw, driver);
			}
			if(!strRaw.contains("grade")){
			String[] splitRaw=strRaw.split("\\/");
				if(splitRaw[0].contains(dataMap.get("Progress"))){
					ResultUtil.report("PASS", "Actual score is "+splitRaw[0]+"/"+splitRaw[1], driver);
				}else{
					ResultUtil.report("FAIL", "Actual score is "+splitRaw[0]+"/"+splitRaw[1], driver);
				}
				}
		}
 	}
 	
 	//Description: Validate the no of question attempts
 	public void validateNoOfAttempts(){
 			ResultUtil.report("INFO","GradeBookPage >>> validateNoOfAttempts", driver);
 	    	driver.switchTo().window(driver.getWindowHandle().toString());
 	    	Sync.waitForFrame(driver, "First Iframe", 0, 3);
 			WebElement qnAttempts=driver.findElement(By.xpath("//td[.='Question Attempts:']//parent::td//following-sibling::td"));
 			String strQnAttempts=qnAttempts.getText();
 			List<WebElement> noOfAttempts=driver.findElements(By.xpath(strTableClass+"[2]//td[./b]"));
 			int noAttempts=noOfAttempts.size();
 			String strno=String.valueOf(noAttempts);
 			if(strQnAttempts.contains(strno)){
 				ResultUtil.report("PASS", "Number of Question Attempts columns is equal to the number of attempts allowed per student"+strno, driver);
 			}
 			else{
 				ResultUtil.report("FAIL", "Number of Question Attempts columns is not equal to the number of attempts allowed per student"+strno, driver);
 			}
 	}
 	
 	//Description: Click on every quetions and Validate question preview modal window
  	public void selectQuestionsAndValidate(Map<String,String> dataMap){
		ResultUtil.report("INFO","GradeBookPage >>> selectQuestionsInPreview", driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 3);
		List<String> lstEarnedPoint=new ArrayList<String>();
		List<String> lstFeedback=new ArrayList<String>();
		List<WebElement> questionName=driver.findElements(By.xpath(strTableClass+"//td[@class='selenium_qtitle']//a"));
		int i=1;
		for(WebElement quest:questionName){
			driver.switchTo().window(driver.getWindowHandle().toString());
			Sync.waitForFrame(driver, "First Iframe", 0, 3);
			Link.click("Question Name "+quest.getText(),quest, driver);
			Window.focusWindow("Assignment Question Preview", driver, driver.getWindowHandles().toArray()[1].toString());
			WebElement feedBack=driver.findElement(By.xpath("//table[@class='qti-presentation-feedback']//td[2]"));
			String strFeedBack=feedBack.getText();
			lstFeedback.add(strFeedBack);
			WebElement maxPoint=driver.findElement(By.xpath("//table[2]//tr[1]//td[3]/span"));
			String strMaxPoint=maxPoint.getText();
			if(strMaxPoint.equals("1.0")){
				ResultUtil.report("PASS", " Maximum point potential is "+strMaxPoint+" as expected", driver);
			}
			else{
				ResultUtil.report("FAIL", " Maximum point potential is "+strMaxPoint+" not as expected", driver);
			}
			WebElement earnedPoint=driver.findElement(By.xpath("//table[2]//tr[2]//td[3]/span"));
			String strEarnedPoint=earnedPoint.getText();
			lstEarnedPoint.add(strEarnedPoint);
			Window.focusWindow("Assignment", driver, driver.getWindowHandles().toArray()[0].toString());
		}
		for(i=1;i<lstEarnedPoint.size();i++){
			String strEarnedPoint=lstEarnedPoint.get(i);
			String strDpEarnedPoint=dataMap.get("PointsEarned"+i);
			if(strEarnedPoint.equals(strDpEarnedPoint)){
				ResultUtil.report("PASS", " Expected Earned Point"+strDpEarnedPoint+"\tActual Earned Point "+strEarnedPoint, driver);
			}else{
				ResultUtil.report("FAIL", " Expected Earned Point"+strDpEarnedPoint+"\tActual Earned Point "+strEarnedPoint, driver);
			}
			String strFeedBack=lstFeedback.get(i);
			String strDpFeedBack=dataMap.get("Answered"+i);
			if(strFeedBack.contains(strDpFeedBack)){
				ResultUtil.report("PASS", " Expected FeedBack"+strDpFeedBack+"\tActual FeedBack  "+strFeedBack, driver);
			}else{
				ResultUtil.report("FAIL", " Expected FeedBack"+strDpFeedBack+"\tActual FeedBack  "+strFeedBack, driver);
			}
		}
	}
 }

    
    
    
    
    
    
    

