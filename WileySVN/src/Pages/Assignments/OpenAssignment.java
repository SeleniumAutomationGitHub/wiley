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
import Pages.GradeBook.StudentGradeBookPage;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;

import Toolbox.Link;
import Toolbox.Listbox;
import Toolbox.Radiobutton;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Toolbox.Window;
import Util.CommonUtil;
import Util.ExcelUtil;

public class OpenAssignment extends Initializer {
	
	String strQtiPresentXpath="//table[@class='qti-presentation-feedback']";
	String strPlainTableXpath= "//table[contains(@class,'plain-table')]";
	String strReviewTotalScore= "//table[@id='selenium_review_score_table']";
	String strQuestionPresentation= "//div[@class='qti-presentation']//input";
	String strMaximumPointsXpath= "//span[@class='selenium_points_maximum']";
	String strQuestionAttempts= "//span[@class='selenium_question_attempts']";
	
	
	@FindBy(how=How.XPATH, using="//a[@id='Next']")
	private WebElement nextbtn;
	
	@FindBy(how=How.XPATH, using="//a[@id='Back']")
	private WebElement backbtn;
	
	@FindBy(how=How.XPATH, using="//div[@class='visualGradingContainer']//table[1]//tr/td[1]//input")
	private WebElement rdobtnFirst;
	
	@FindBy(how=How.XPATH, using="//div[@class='visualGradingContainer']//table[2]//tr/td[1]//input")
	private WebElement rdobtnSecond;
	
	@FindBy(how=How.XPATH, using="//div[@title='Submit Answer']//a[@id='saveanswerbutId']")
	private WebElement submitAnswer;
	
	@FindBy(how=How.XPATH, using="//div[@id='breadcrumb-content']//a[.='Assignment']")
	private WebElement assignLink;

	@FindBy(how=How.XPATH, using="//div[contains(@id,'answerbut')]//a[@id='Show_Answer']")
	private WebElement shwansBtn;
	
	@FindBy(how=How.XPATH, using="//table[3]//a[contains(@class,'linkmodule switcher')]")
	private WebElement reviewscore;
	
	@FindBy(how=How.XPATH, using="//div[@id='createShowWork']")
	private WebElement openShowWork;
	
	@FindBy(how=How.XPATH, using="//table[2]//a[@id='Show_Hint']")
	private WebElement shwhintBtn;
	
	@FindBy(how=How.XPATH, using="//table[2]//a[@id='Show_Solution']")
	private WebElement shwsolutionBtn;
	
	@FindBy(how=How.ID, using="Printer_Version")
	private WebElement printerBtn;
	
	@FindBy(how=How.ID, using="Open_calculator")
	private WebElement calculatorBtn;

	@FindBy(how=How.ID, using="Full_Screen_-_Hide_navigation")
	private WebElement fullscreenBtn;
	
	@FindBy(how=How.ID, using="Standard_View_-_Show_navigation")
	private WebElement standardviewBtn;
	
	@FindBy(how=How.XPATH, using="//a[@id='Save_for_later']")
	private WebElement saveForLaterBtn;
	
	@FindBy(how=How.NAME, using="timewarnhide")
	private WebElement dntshow;
	
	@FindBy(how=How.ID, using="Close")
	private WebElement closeBtn;
	
	@FindBy(how=How.ID, using="submitWarningForm")
	private WebElement goBtn;
	
	@FindBy(how=How.XPATH, using="//a[@name='report']")
	private WebElement reviewProgress;
	
	@FindBy(how= How.XPATH,using="//div[@id='createShowWork']/a")
	private WebElement showworklink;
	
	@FindBy(how= How.XPATH, using= "//div//a[.='Open blank Show Work']")
	private WebElement blankShowWorkLink;
	
	@FindBy(how = How.XPATH, using= "//div//a[.='Copy Show Work from Previous attempt']")
	private WebElement previousAttemptShowWork;

	StringBuffer questionNames = new StringBuffer();
	StringBuffer questionNamesInReview = new StringBuffer();

	public OpenAssignment(WebDriver driver){
		super(driver);	
	}
	
	//Description: Focus on Main Frame
	private void focusMainframe(){
		driver.switchTo().window(driver.getWindowHandle().toString());
		driver.switchTo().frame(0);
		if(Element.verify("Frame", driver, "Name", "studentLwsFrame")){
			driver.switchTo().frame("studentLwsFrame");
			driver.switchTo().frame("mainframe");
		}else{
			
			driver.switchTo().frame("mainframe");		
		}
		
		ResultUtil.report("PASS","Focused to MainFrame",driver);
	}
	
	//Description: Focus on Navigate top Frame
	private void focusAg_nav_top(){
		focusMainframe();
		driver.switchTo().frame("ag_nav_top");
		ResultUtil.report("PASS","Focused to Agnavtop Frmae",driver);
	
	}
	
	//Description: Focus on Body Frame 
	private void focusAgbodyFrame(){
		focusMainframe();
		driver.switchTo().frame("agrootframe");
		driver.switchTo().frame("agarea");
		driver.switchTo().frame("agbody");
		ResultUtil.report("PASS","Focused to Agbody frame",driver);
	}
	
	//Description: Focus List of Assignment Frame
	private void focusAglistframe(){
		focusMainframe();
		driver.switchTo().frame("agrootframe");
		driver.switchTo().frame("aglist");
		ResultUtil.report("PASS","Focused to Aglist Frame",driver);
		
	}
	
	//Description: Verify the Description/Instructions for the student is displayed
	public void verifyDescription(Map<String,String> dataMap)  {		
		ResultUtil.report("INFO","OpenAssignment>>>verifyDescription",driver);
		driver.switchTo().defaultContent();		
		try
		{
			focusAgbodyFrame();			
		 	if(Element.verify("Verify Describtion", driver, "xpath", "//b[.='Description/Instructions']")){
		 		WebElement strText = driver.findElement(By.xpath("//span[.='Description/Instructions']//ancestor-or-self::tr//following-sibling::tr[2]//span"));
		 		ResultUtil.report("Description:", strText.getText(), driver);		 		
		 		
		 	}
		 	else{
		 		ResultUtil.report("Message", "Description is not Displayed.", driver);
		 	}

		}
		catch(Exception e){}		 	
	 	
	}
	
	
	//Description: Go To Review Score page Left Panel
	public void clickReviewScore(){
		
		ResultUtil.report("INFO", "OpenAssignment>>>clickReviewScore",driver);		
		focusAglistframe();
	 	Link.click("Review score Link", reviewscore,driver);
	 	
	}
	
	//Description: Verifying Show Work Link is Present 
	public void verifyShowWorkLink(){
		ResultUtil.report("INFO","OpenAssignment>>>verifyShowWorkLink",driver);
		
		if(Element.verify("Open Show Work", driver, "xpath", "//div[@class='showWork']/a[.='Open Show Work']")){
			ResultUtil.report("Message", "Open Show Work is Displayed", driver);
			
		}else{
			ResultUtil.report("Message", "Open Show Work is Absent", driver);
			
		}
		
	}
	
	//Description: click next to attend test
	public void clickNext()
	{
		ResultUtil.report("INFO", "OpenAssignment>>clickNext",driver);		
		focusAg_nav_top();
		Button.verify("Next", nextbtn,driver );		
		Button.click("Next", nextbtn,driver);
	}
	
	//Description: Select First answer of true or false
	public void selectFirstAnswerInTrueFalse()
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectFirstAnswerInTrueFalse",driver);
		focusAgbodyFrame();
		
		if(Radiobutton.isEnabled(rdobtnFirst, "Radio button first answer", driver)){
		Radiobutton.select("Radio button first answer", rdobtnFirst,driver);			
		}
	}
	
	//Description: Select Submit Answer button
	public void selectSubmitAnswer()
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectSubmitAnswer", driver);
		focusAgbodyFrame();		
		Element.verify("Submit Answer", driver, "xpath", "//div[@title='Submit Answer']//a[@id='saveanswerbutId']");				
		Button.click("Submit", submitAnswer, driver);
	}
	
	//Description: Verifying Result of the Assignment
	public void verifyResult()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyResult",driver);
		String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
		
		if(answerColumn.contains("Correct"))
		{
			ResultUtil.report("PASS", "The answer is correct",driver);
		}
		else
		{
			ResultUtil.report("FAIL", "The answer is wrong",driver);
		}
	}
	
	//Description: Selecting the Second Answer in the Assignment
	public void selectSecondAnswerInTrueFalse()
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectSecondAnswerInTrueFalse",driver);
		focusAgbodyFrame();		
		Button.click("Radio Button Second Answer", rdobtnSecond,driver);
	}
	
	//Description: Selecting Assignment Link from the Assignment Page
	public void selectAssignmentLink()
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectAssignmentLink",driver);		
		driver.switchTo().defaultContent();
		focus_I_Frame();			
		assignLink.click();		
	}
	
	//Description: Select MultiChoice Assignment from the Assignment List
	public void selectmultiChoiceAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectmultiChoiceAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameMulti");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		
		Link.click("Test-MultipleChoice", selectAssignment,driver);
	}
	
	//Description: Verify Multiple Choice Answer Result
	public void verifyMultipleChoiceAnswer()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyMultipleChoiceAnswer",driver);
		focusAgbodyFrame();
		WebElement rdobtnmulti=driver.findElement(By.xpath("//div[@class='visualGradingContainer']//table[1]//input"));
		if(Radiobutton.isEnabled(rdobtnmulti, "Radio Button", driver)){
			Radiobutton.select("Radio button", rdobtnmulti,driver);
		}
		if(Element.verify("Submit Button", driver, "xpath", "//div[@title='Submit Answer']//a[@id='saveanswerbutId']")){
			submitAnswer.click();
			driver.switchTo().alert().accept();
			
		}else
		{	
			ResultUtil.report("Message", "Submit Answer button is not Visible",driver);
		}
		String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
		if(answerColumn.trim().contains("Your answer is correct."))
		{
			ResultUtil.report("PASS", "Your Answer is correct",driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Your Answer is incorrect",driver);
		}
	}
	
	//Description: Selecting Text Entry Type Assignment
	public void selectTextEntryAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectTextEntryAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNametxtentry");		
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Text Entry Assignment", selectAssignment,driver);		
	}
	
	//Description: Verifying Text Entry Answers
	public void verifyTextEntryAnswer(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyTextEntryAnswer",driver);
		focusAgbodyFrame();
		List<WebElement> textEntry=driver.findElements(By.xpath("//div[@class='qti-presentation']//input"));
		for(WebElement txt:textEntry)
		{
			TextBox.clearValue("Answer", txt, driver);
			TextBox.enterValue("Answers", txt, dataMap.get("AnswersFortxtentry"),driver);
			Button.click("submit Answer", submitAnswer,driver);
			String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
			if(answerColumn.trim().contains("Your answer is correct."))
			{
				ResultUtil.report("PASS", "Your Answer is correct",driver);
			}
			else
			{
				ResultUtil.report("FAIL", "Your Answer is incorrect",driver);
			}
		}
	}
	
	//Description: Selecting TextEntry Numeric Type Assignment
	public void selectTextEntryNumericWithUnits(Map<String,String> dataMap,String strToleranceAssignment)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectTextEntryNumericWithUnits",driver);
		String strAssignmentNames = dataMap.get(strToleranceAssignment);
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-textentry with units", selectAssignment,driver);
	}
	
	//Description: Verifying Text Entry Numeric Assignment
	public void verifyTextEntryWithNumericUnits(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyTextEntryWithNumericUnits",driver);
		focusAgbodyFrame();
		List<WebElement> textEntry=driver.findElements(By.xpath(strQtiPresentXpath+"//input"));
		for(WebElement txt:textEntry)
		{
			TextBox.clearValue("Numeric Answer", txt, driver);
			TextBox.enterValue("NumericAnswers", txt, dataMap.get("AnswersFortxtentryNumeric"),driver);
		}
		
		Button.click("submit Answer", submitAnswer,driver);
		String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
		if(answerColumn.trim().contains("Your answer is correct."))
		{
			ResultUtil.report("PASS", "Your Answer is correct",driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Your Answer is incorrect",driver);
		}
	}
	
	//Description: Select TextEntry With Drop down Type Assignment
	public void selectTextEntryWithDropdown(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectTextEntryWithDropdown",driver);
		String strAssignmentNames = dataMap.get("AsgntNametxtEntryWithdrpdwn");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-textentry with dropdown", selectAssignment,driver);	

	}
	
	//Description: Verifying TextEntry With Dropdown Assignment
	public void verifyTextEntryWithDropdown(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyTextEntryWithDropdown",driver);
		focusAgbodyFrame();
		WebElement textEntry=driver.findElement(By.xpath(strQtiPresentXpath+"//input"));
		
		TextBox.enterValue("NumericAnswers", textEntry, dataMap.get("AnswersFortxtentryNumeric"),driver);
		
		Button.click("submit Answer", submitAnswer,driver);
		String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
			
		if(answerColumn.trim().contains("Your answer is correct."))
		{
			ResultUtil.report("PASS", "Your Answer is correct",driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Your Answer is incorrect",driver);
		}
	}
	
	//Description: Selecting Matching Type Assignment
	public void selectMatching(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectMatching",driver);
		String strAssignmentNames = dataMap.get("AsgntNameMatching");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);		
		Link.click("Test-Matching", selectAssignment,driver);			
		Sync.waitForObject(driver, "Next Button", "xpath", "//a[@id='Next']");
	}
	
	//Description: Verifying Matching Assignment
	public void verifyMatching()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyMatching",driver);
		focusAgbodyFrame();
		List<WebElement> mtchdrpdwn=driver.findElements(By.xpath(strQtiPresentXpath+"//select"));
		for(WebElement matching: mtchdrpdwn)
		{
			Combobox.selectRandomItem("Answer dropdown", matching,driver);
		}
		if(Element.verify("Submit Button", driver, "xpath", "//div[@title='Submit Answer']//a[@id='saveanswerbutId']")){
		Button.click("submit Answer", submitAnswer,driver);
		}
		String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
		if(answerColumn.trim().contains("Incorrect."))
		{
			ResultUtil.report("FAIL", "Your Answer is incorrect",driver);
		
		}
		else if(answerColumn.trim().contains("partially correct."))
		{
			ResultUtil.report("PASS", "Your Answer is partially correct.",driver);
		}else
		{
			ResultUtil.report("PASS", "Your Answer is correct.",driver);
		}
	}
	
	//Description: Verifying Maximum Potential Points 
	public void verifyMaximumPotential()
    {
		ResultUtil.report("INFO","OpenAssignment>>>verifyMaximumPotential",driver);
    	focusAgbodyFrame();
    	String strMaxPotentialXpath="//table[@id='selenium_review_score_table']//span[@class='selenium_points_maximum']";
    	Sync.waitForObject(driver,"Maximum Potential Point ", "XPATH", strMaxPotentialXpath);
    	List<WebElement> maxPotential=driver.findElements(By.xpath(strMaxPotentialXpath));
    	for(WebElement getMaxPotential:maxPotential)
    	{
    		String strMaxPotential=getMaxPotential.getText().trim();
    		ResultUtil.report("MESSAGE","Maximum Potential Point- "+strMaxPotential, driver);    			
    	}    	
    }
	
	//Description: Selecting Show Answer Link
	public void selectShowAnswer()
	{
		ResultUtil.report("INFO","OpenAssignment>>>selectShowAnswer",driver);
		focusAgbodyFrame();
		Button.click("Show Answer", shwansBtn,driver);
	}
	
	//Description: Selecting Various Setting Assignment from the list
	public void selectVariousSettingsAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>> selectVariousSettingsAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameVariousSettings");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-VariousSettings", selectAssignment,driver);	
		Sync.waitForObject(driver, "Next Button", "xpath", "//a[@id='Next']");
	}
	
	//Description: Verifying Various Setting Assignment
	public void verifyAssignmentName(Map<String,String> dataMap)
	{		
		ResultUtil.report("INFO", "OpenAssignment>> verifyAssignmentName",driver);
		focusAglistframe();
		String assgnName=driver.findElement(By.xpath("//table//table[1]//td//span")).getText();
		if(assgnName.equals(dataMap.get("AsgntNameVariousSettings")))
		{
			ResultUtil.report("PASS", "The assignment name" +assgnName,driver);
		}
		else
		{
			ResultUtil.report("FAIL", "The assignment name is not equal",driver);
		}
	}
	
	//Description: Selecting Back Button
	public void clickBack()
	{
		ResultUtil.report("INFO", "OpenAssignment>>clickBack",driver);
		focusAg_nav_top();
		Button.verify("Back", backbtn,driver);
		Button.click("Back", backbtn,driver);
	}
	
	//Description: Verifying Current Date Displayed in the Assignment
	public void verifyCurrentDate()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyCurrentDate",driver);		
		focusAgbodyFrame();
		String currentDate=driver.findElement(By.xpath("//table//tr[8]//td[4]//span")).getText();
		if(currentDate.equals("Current date: September 14, 2013, 03:28 AM"))
		{
			ResultUtil.report("PASS", "The current date is" +currentDate,driver);
		}
		else
		{
			ResultUtil.report("FAIL", "The current date is" +currentDate,driver);
		}
	}
	
	//Description: Selecting Study Objecting of Assignment
	public void selectStudyObjectiveAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectStudyObjectiveAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameStudyObjective");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);	
		Link.click("Test-StudyObjective", selectAssignment,driver);		
		Sync.waitForObject(driver, "Next Button", "xpath", "//a[@id='Next']");

	}
	
	//Description: Verifying and Clicking Review Study objective link
	public void verifyAndClickReviewStudyObjective()
	{
		ResultUtil.reportWithoutScreenshot("INFO","OpenAssignment >>> verifyAndClickReviewStudyObjective");
		focusAglistframe();
		WebElement studyobjective=driver.findElement(By.xpath("//table//table[4]//tr[2]//td"));
		String studyObj=studyobjective.getText();
		Link.verify("Review Results by study objective", studyobjective, studyObj,driver);
		Link.click("Review Results by study objective", studyobjective,driver);
	}
	
	//Description: Verifying Results for Assignment
	public void verifyResultsColumn()
	{
		ResultUtil.reportWithoutScreenshot("INFO","OpenAssignment >>> verifyResultsColumn");
		focusAgbodyFrame();
		String strElementResultXpath="//table//table//tr//td[2]";
		Sync.waitForObject(driver,"Result Column", "XPATH",strElementResultXpath);
		List<WebElement> eleResult=driver.findElements(By.xpath(strElementResultXpath));
		for(WebElement eleResultsColumn:eleResult)
		{
			String strResults=eleResultsColumn.getText().trim();
			Element.verify("Result Column ", eleResultsColumn, driver);
			ResultUtil.reportWithoutScreenshot("MESSAGE- ",strResults);
		}
			
	}
	
	//Description: Get all Questions
	public StudentGradeBookPage getAllQuestions(){
		
		ResultUtil.report("INFO", "OpenAssignment >>> getAllQuestions",driver);
		focusAgbodyFrame();
		String strQuestionsXpath= "//table[@id='selenium_review_score_table']//span[@class='selenium_question']";
		Sync.waitForObject(driver,"List of Questions", "XPATH",strQuestionsXpath);
		List<WebElement> questions=driver.findElements(By.xpath(strQuestionsXpath));
		int totalMaxScore =0;
		for(WebElement getQuestions:questions)
		{
			totalMaxScore++;
			String questionName=getQuestions.getText();
			checkMaximumPointPotential(questionName);
			checkPointsEarned(questionName);
			checkQuestionAttempts(questionName);
			checkAnswered(questionName);
		}
		checkTotalMaxScore(totalMaxScore);
		checkTotalScore();
		
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}
			
	//Description: check Total Max Score
	public void checkTotalMaxScore(int totalMaxscore){
		
		ResultUtil.report("INFO", "OpenAssignment >>> checkMaximumPointPotential",driver);
		WebElement elmntFirstAssingment = driver.findElement(By.xpath("//b[@id='selenium_total_max_score']"));
		String strScore= elmntFirstAssingment.getText();
		
		int blTotalScore = CommonUtil.convertToInt(strScore);
		
		if(blTotalScore == totalMaxscore){
			ResultUtil.report("PASS", "Total Max score is equal",driver);
		}else{
			ResultUtil.report("FAIL", "Total Max score is not equal",driver);
		}
	}
	
	//Description: check Total Score
	public void checkTotalScore(){
		
		ResultUtil.report("INFO", "OpenAssignment >>> checkMaximumPointPotential",driver);
		WebElement elmTotalScore=driver.findElement(By.xpath("//b[@id='selenium_total_score']"));
		String strTotalScore = elmTotalScore.getText();
		boolean blTotalScore = CommonUtil.isNumeric(strTotalScore);
		if(blTotalScore){
			ResultUtil.report("MESSAGE", "["+strTotalScore+"]",driver);
		}
	}
	
	//Description: check Maximum PointPotential for one question
	public void checkMaximumPointPotential(String question){
		
		ResultUtil.report("INFO", "OpenAssignment >>> checkMaximumPointPotential",driver);
		WebElement elmMaxPotential=driver.findElement(By.xpath(strReviewTotalScore+"//tr[.//span[.='"+question+"']]//span[@class='selenium_points_maximum']"));
		String strMaxPotential=elmMaxPotential.getText();
		if(strMaxPotential.equals("1.0"))
		{
			ResultUtil.report("PASS","Question Name:"+question+" Maximum Point Potential value is Equal to 1.0",driver);
		}
		else
		{
			ResultUtil.report("FAIL","Question Name:"+question+" Maximum Point Potential value is not Equal to 1.0",driver);
		}
	}
	
	//Description: check Points Earned for one question
	public void checkPointsEarned(String question){
		
		ResultUtil.report("INFO", "OpenAssignment >>> checkPointsEarned",driver);
		WebElement elmPointsEarned=driver.findElement(By.xpath(strReviewTotalScore+"//tr[.//span[.='"+question+"']]//span[@class='selenium_points_earned']"));
		ResultUtil.report("INFO","Question Name:"+question+"Points Earned value is "+elmPointsEarned.getText(),driver);
	}
	
	//Description: Check the Question Attempts column for one question
	public void checkQuestionAttempts(String question){
		
		ResultUtil.report("INFO", "OpenAssignment >>> checkQuestionAttempts",driver);
		WebElement elmQuestionAttempt=driver.findElement(By.xpath(strReviewTotalScore+"//tr[.//span[.='"+question+"']]//span[@class='selenium_question_attempts']"));
		ResultUtil.report("INFO","Question Name:"+question+"Check the Question Attempts column value is "+elmQuestionAttempt.getText(),driver);
	}
	
	//Description: Check Answered column  for one question
	public void checkAnswered(String question){
		
		ResultUtil.report("INFO", "OpenAssignment >>> checkAnswered",driver);
		WebElement elmAnswered=driver.findElement(By.xpath(strReviewTotalScore+"//tr[.//span[.='"+question+"']]//span[@class='selenium_answered']"));
		ResultUtil.report("INFO","Question Name:"+question+"Check the Answered column value is "+elmAnswered.getText(),driver);
	}
	
	
	//Description: select 100 Question Assignment
	public void select100QuestionAssignment(Map<String,String> dataMap)
	{		
		ResultUtil.report("INFO", "OpenAssignment >>> selectStudyObjectiveAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntName100Question");
		WebElement selectAssignment = driver.findElement(By.xpath("strPlainTableXpath//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-StudyObjective", selectAssignment,driver);	
		
		Sync.waitForObject(driver, "Next Button", "xpath", "//a[@id='Next']");
	}
	
	//Description: Verifying the size of Questions
	public void verifyQuestionSize()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifyQuestionSize",driver);
		focusAglistframe();
		List<WebElement> questions=driver.findElements(By.xpath("//table[2]//tr"));
		int questionSize=questions.size();
		ResultUtil.report("PASS", "The tree-control contains" +questionSize+ "questions",driver);
	}
	
	//Description: Getting the Total Score
	public void getTotalScore()
	{		
		ResultUtil.report("INFO", "OpenAssignment >>> getTotalScore",driver);
		focusAgbodyFrame();
		List<WebElement> earnedscore=driver.findElements(By.xpath("//table[@id='selenium_review_score_table']//tr"));
		int rowsize=earnedscore.size();
		String earnedScore=driver.findElement(By.xpath(strReviewTotalScore+"//tr["+rowsize+"]//td[5]")).getText();
		String totalScore=driver.findElement(By.xpath(strReviewTotalScore+"//tr["+rowsize+"]//td[7]")).getText();
		ResultUtil.report("MESSAGE", "Earned score =" +earnedScore+ "Total score =" +totalScore,driver);
	}

	//Description: Selecting the Show Work from the Assignment
	public void selectShowWork()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectShowWork",driver);
		focusAgbodyFrame();		
		Link.click("Open Show Work", showworklink,driver);
	}
	
	//Description: Selecting Question Pool Type Assignment
	public void selectQuestionpoolAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectQuestionpoolAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameQuestionPool");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-StudyObjective", selectAssignment,driver);
		
		Sync.waitForObject(driver, "Next Button", "xpath", "//a[@id='Next']");

	}
	
	//Description: Verifying the Question Pool Assignment
	public void verifyQuestionsInPool()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifyQuestionsInPool",driver);
		focusAglistframe();		
		List<WebElement> questions=driver.findElements(By.xpath("//table[2]//tr"));		
		int questionSize=questions.size();
		ResultUtil.report("PASS", "The tree-control contains" +questionSize+ "questions",driver);
		
		for(WebElement question:questions)
		{
			String questionName=question.getText();
			ResultUtil.report("MESSAGE", "The questions are" +questionName,driver);
			questionNames.append(questionName);		
		}
		WebElement reviewScore=driver.findElement(By.xpath("//table[3]//a[contains(@class,'linkmodule switcher')]"));
		Link.click("Review Score", reviewScore,driver);
		focusAgbodyFrame();
		List<WebElement> questionsInReview=driver.findElements(By.xpath(strReviewTotalScore+"//tr"));
		int size=questionsInReview.size()-4;
		for(int i=3;i<=size;i++)
		{
			List<WebElement> questionsReview=driver.findElements(By.xpath(strReviewTotalScore+"//tr["+i+"]//td[1]"));
			for(WebElement questionReview:questionsReview)
			{
				String questionss=questionReview.getText();
				if(questionNames.equals(questionss))
				{
					ResultUtil.report("MESSAGE", "The questions are" +questionss,driver);
				}
				else
				{
						ResultUtil.report("MESSAGE", "The questions are" +questionss,driver);
				}
			}
		}
	}
	
	//Description: Verifying Order of Questions
	public void verifyOrderOfQuestions()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifyOrderOfQuestions",driver);
		focusAglistframe();
		List<WebElement> questions=driver.findElements(By.xpath("//table[2]//tr"));
		
		for(WebElement question:questions)
		{
			String questionName=question.getText();
			questionNames.append(questionName);
		}
		clickReviewScore();
		focusAgbodyFrame();
		List<WebElement> questionInreview=driver.findElements(By.xpath(strReviewTotalScore+"//tr"));
		int size=questionInreview.size()-4;
		
		for(int i=3;i<=size;i++)
		{
			List<WebElement> questionsReview=driver.findElements(By.xpath(strReviewTotalScore+"//tr["+i+"]//td[1]"));
			for(WebElement questionReview:questionsReview)
			{
				String questionss=questionReview.getText();
				questionNamesInReview.append(questionss);
			}
		}
		if(questionNames.equals(questionNamesInReview))
		{
			ResultUtil.report("PASS", "The order of the questions are validated",driver);
		}
		else
		{
			ResultUtil.report("FAIL", "The order of the questions are changed",driver);

		}

	}
	
	//Description: Selecting MultiStep Type Assignment
	public void selectMultiStepAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectMultiStepAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameMultistep");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-MultipleChoice", selectAssignment,driver);	
		Sync.waitForObject(driver, "Next Button", "xpath", "//a[@id='Next']");
	}
	
	//Description: Verify Submit Answer Button
	public void verifySubmitanswer()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifySubmitanswer",driver);
		focusAgbodyFrame();
		Element.verify("Submit Button", driver, "xpath", "//div[@title='Submit Answer']//a[@id='saveanswerbutId']");
		Element.verify("Save For Later", driver, "XPATH", "//a[@id='Save_for_later']");
	}

	//Description: Verifying Multiple Attempts in MultiStep Assignment
	public void exhaustAttemptsForMultistep(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>exhaustAttemptsForMultistep",driver);
		String value=dataMap.get("Values");
		focusAgbodyFrame();
		List<WebElement> inputAnswer=driver.findElements(By.xpath("//div[@class='qti-presentation']//input"));
		
		for(WebElement input:inputAnswer)
		{
		TextBox.enterValue("Answers", input, value,driver);
		}
		Button.click("Submit Answer", submitAnswer,driver);
	}
	
	//Description: Selecting Submit Answer for Unlimited Times
	public void clickSubmitAnswerForUnlimited()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> clickSubmitAnswerForUnlimited",driver);
		
		if(Element.verify("Submit Answer", driver, "xpath", "//div[@title='Submit Answer']//a[@id='saveanswerbutId']")){
			for(int i=0;i<10;i++)
			{			
				Button.click("Submit Answer", submitAnswer,driver);
			
			}
		}
	}
	
	//Description: Verify Points Earned Column
	public void verifyPointsEarned()
	{
		
		ResultUtil.report("INFO","OpenAssignment >>> verifyPointsEarned",driver);
		focusAgbodyFrame();
		List<WebElement> pointsEarned=driver.findElements(By.xpath(strReviewTotalScore+"//span[@class='selenium_points_earned']"));
		for(WebElement points:pointsEarned)
		{
			String strPointsEarned=points.getText().trim();
			ResultUtil.report("MESSAGE","Points Earned- "+strPointsEarned, driver);
		}
	}
	
	//Description: Verify Question Attempts Column
	public void verifyQuestionAttempts()
	{		
		ResultUtil.report("INFO", "OpenAssignment >>> verifyQuestionAttempts",driver);
		focusAgbodyFrame();
		List<WebElement> verifyQuestion=driver.findElements(By.xpath(strReviewTotalScore+"//span[@class='selenium_question_attempts']"));
		for(WebElement verifyQtnAttempts:verifyQuestion)
		{
			String verifyQuestions=verifyQtnAttempts.getText();
			ResultUtil.report("MESSAGE", "Question Attempts- "+verifyQuestions, driver);
		}
	}
	
	//Description: Verify Answered Column
	public void verifyCheckAnsweredColumn()
	{
		ResultUtil.report("INFO","OpenAssignment >>> verifyCheckAnsweredColumn",driver);
		focusAgbodyFrame();
		List<WebElement> verifyCheckAnswered=driver.findElements(By.xpath(strReviewTotalScore+"//span[@class='selenium_answered']"));
		for(WebElement verifyCheckAnswer:verifyCheckAnswered)
		{
			String verifyCheck=verifyCheckAnswer.getText().trim();
			
			if(verifyCheck.equals("Unanswered"))
			{
				ResultUtil.report("MESSAGE","The Question is not Attempted",driver);
				ResultUtil.report("MESSAGE","Question Title Icon is not displayed",driver);
			}
			else if(verifyCheck.equals("incorrect"))
			{
				ResultUtil.report("MESSAGE","The Attempted Question is INCORRECT",driver);
				ResultUtil.report("MESSAGE","Red Cross is displayed in Question Title icon",driver);
			}
			else if(verifyCheck.equals("partially correct"))
			{
				ResultUtil.report("MESSAGE","The Attempted Question is PARTIALLY CORRECT",driver);
				ResultUtil.report("MESSAGE","Orange slash is displayed in Question Title icon",driver);
			}
			else
			{
				ResultUtil.report("MESSAGE","The Attempted Question is CORRECT",driver);
				ResultUtil.report("MESSAGE","Green Tick is displayed in Question Title icon",driver);
			}
		}		
	}
	
	//Description: Verifying Immediate Feedback Assignment
	public void verifyImmediateFeedback()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifyImmediateFeedback",driver);
		focusAgbodyFrame();
		Radiobutton.select("Radio button first answer", rdobtnFirst,driver);
		Button.click("submit Answer", submitAnswer,driver);
		
		String answerColumn=driver.findElement(By.xpath(strQtiPresentXpath+"//tr[2]//td[2]")).getText();
		
		if(answerColumn.contains("saved"))
		{
			ResultUtil.report("PASS", "Immediate feedback is disabled",driver);
		}
		else
		{
			ResultUtil.report("FAIL", answerColumn, driver);
		}
	}
	
	//Description: Verifying Assistance Buttons in Assignment
	public void verifyAssistanceButtons()
	{
		
		focusAgbodyFrame();
		Element.verify("Show hint", driver, "XPATH", "//a[@id='Show_Answer']");
		Element.verify("LinkTotext", driver, "XPATH", "//a[@id='Link_to_Resource_1']");
		Element.verify("Show solutions", driver, "XPATH", "//a[@id='Show_Solution']");
		Element.verify("Submit Answer", submitAnswer,driver);		
	}
	
	//Description: Select and Close Print a Blank Copy window
	public void clickAndClosePrintABlankCopy()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>clickAndClosePrintABlankCopy", driver);
		focusAg_nav_top();
		WebElement print=driver.findElement(By.xpath("//table//a[contains(@id,'Printer')]"));
		Link.click(" print a blank copy", print,driver);
		
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		this.driver.close();		
	}
	
	//Description: Verifying Print Assignment
	public void verifyPrintAssignment(){
		ResultUtil.report("INFO","OpenAssignment >>> verifyPrintAssignment",driver);		
		focusAgbodyFrame();
		
		if(Element.verify("Print Assignment", driver, "xpath", "//td[.='Print Assignment']")){
			
			Element.verify("Print Blank Copy", driver, "xpath", "//td//a[.='print a blank copy']");
			
			ResultUtil.report("Message", "Print A Blank Copy Link is Present", driver);
			
			
		}else{
			
			ResultUtil.report("Message", "Print Assignment is not Visible", driver);
			
		}
	}
	
	//Description: Selecting the First Question from the list
	public void clickOnFirstQuestion()
	{
		ResultUtil.report("INFO","OpenAssignment >>> clickOnFirstQuestion",driver);
		
		focusAglistframe();
		WebElement firstqn=driver.findElement(By.xpath("//table[2]//tr[1]//a"));
		firstqn.click();
	}
	
	//Description: Click Close Button
	public void clickClose()
	{
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		WebElement close=driver.findElement(By.id("Close"));
		Element.verify("Warning close Button", close, driver);
		Button.click("Close", close,driver);
	}
	
	//Description: Select Go Button
	public void clickGo()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>clickGo", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		
		if(Element.verify("Go Button", driver, "id", "submitWarningForm")){		
			WebElement go=driver.findElement(By.id("submitWarningForm"));
			Button.click("Go", go,driver);			
		}
	}
	
	//Description: Selecting Show Hint link
	public void selectShowHint()
	{
		ResultUtil.report("INFO","OpenAssignment >>> selectShowHint",driver);
		focusAgbodyFrame();
		Button.click("Show Hint", shwhintBtn,driver);
	}
	
	//Description: Selecting Show Solution Button
	public void selectShowSolution()
	{
		ResultUtil.report("INFO","OpenAssignment >>> selectShowSolution",driver);
		focusAgbodyFrame();
		Button.click("Show Answer", shwsolutionBtn,driver);
	}
	
	//Description: Closing the window 
	public void closeWindow()
	{
		this.driver.close();
	}
	
	//Description: Selecting View only Type Assignment
	public void selectViewonlyAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectViewonlyAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameViewOnly");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);		
		Link.click("Test-View Only", selectAssignment,driver);	
	}
	
	//Description: Select View Assistance Type Assignment
	public void selectViewAssistanceAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectViewAssistanceAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameViewAssistance");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		Link.click("Test-viewAssistance", selectAssignment,driver);	
	}
	
	//Description: Select No Due Type Assignment
	public void selectNoDueAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectNoDueAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameNoDue");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		Link.verify("Test-NoDue", selectAssignment,driver);
		Link.click("Test-NoDue", selectAssignment,driver);	
	}
	
	//Description: Verifying Hided Question Title
	public void verifyHidedQuestionTitle()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifyHidedQuestionTitle",driver);
		focusAglistframe();
		List<WebElement> questions=driver.findElements(By.xpath("//table[2]//tr"));
		for(WebElement question:questions)
		{
			String questionName=question.getText();
			ResultUtil.report("PASS", "The question Title" +questionName,driver);
		}
		clickReviewScore();
		focusAgbodyFrame();
		List<WebElement> questionInreview=driver.findElements(By.xpath(strReviewTotalScore+"//tr"));
		int size=questionInreview.size()-4;
		
		for(int i=3;i<=size;i++)
		{
			List<WebElement> questionsReview=driver.findElements(By.xpath(strReviewTotalScore+"//tr["+i+"]//td[1]"));
			for(WebElement questionReview:questionsReview)
			{
				String questionss=questionReview.getText();
				ResultUtil.report("PASS", "The question Title" +questionss,driver);
			}
		}
		focusAglistframe();
		verifyAndClickReviewStudyObjective();	
		ResultUtil.report("PASS", "The question Title are hided",driver);
		clickOnFirstQuestion();
		clickBack();
		clickAndClosePrintABlankCopy();
	}
	
	//Description: Click Print Version Link
	public void clickPrinterVersion()
	{
		focusAg_nav_top();		
		Button.click("Printer version", printerBtn,driver);
	}
	
	//Description: Verify Print Version Element in Print window
	public void verifyPrinterVersionElement()
	{
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Element.verify("Question", driver, "XPATH", "//span[@class='qprintitem']");	
		this.driver.close();
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());		
	}
	
	//Description: Navigating to Description Page
	public void navigateToDescription()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>navigateToDescription", driver);
		focusAglistframe();
		WebElement description=driver.findElement(By.xpath("//table//table[1]//tr//td//a"));
		Link.click("Assignment name", description,driver);
	}
	
	//Description: Clicking Calculator button
	public void clickCalculator()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>clickCalculator", driver);
		focusAg_nav_top();
		Button.click("Calculator", calculatorBtn,driver);
	}
	
	//Description: Click Full screen
	public void clickFullscreen()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>clickFullscreen", driver);
		focusAg_nav_top();
		Button.click("Full Screen",fullscreenBtn,driver);
	}
	
	//Description: Click Standard view of Assginment
	public void clickStandarView()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>clickStandarView", driver);
		focusAg_nav_top();	
		standardviewBtn.click();
	}
	
	//Description: Edit in Show work Window
	public void editInShowWork()
	{	
		ResultUtil.report("INFO", "OpenAssignment>>>editInShowWork", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		WebElement textbtn=driver.findElement(By.xpath("//div[@id='button_text']"));
		Button.click("Text Button", textbtn,driver);
		WebElement submitbtn=driver.findElement(By.xpath("//div[@id='button_submit']"));
		Button.click("Submit button", submitbtn,driver);
	}
	
	//Description: Selecting Save for later Button
	public void selectSaveForLater()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>selectSavaForLater", driver);
		focusAgbodyFrame();
		Button.click("Save for later", saveForLaterBtn,driver);		
	}
	
	//Description: Select Assignment From the List
	public void selectAssignment(Map<String, String> dataMap,String strAssignment)
	{
		ResultUtil.report("INFO", "OpenAssignment >>>selectAssignment",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		driver.switchTo().frame(0);		
		String strAssignmentNames = dataMap.get(strAssignment);
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Assignment Name", selectAssignment.getText(), driver);
		Link.verify("Assignment", selectAssignment,driver);
		Link.click("Assignment", selectAssignment,driver);	
		Sync.waitForObject(driver, "Next", "XPATH", "//a[@id='Next']");
	}
	
	//Description: Checking Don't Show in Timed Assignment
	public void checkDntShowInTimedAssignment()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> checkDntShow",driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Checkbox.check("Dont show", dntshow,driver);
		Button.click("Close", closeBtn,driver);
	}
	
	//Description: Check and click go in Timed Assignment
	public void checkAndGoInTimedAssignment()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> checkAndGo",driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Checkbox.check("Dont show", dntshow,driver);
		Button.click("Go", goBtn,driver);

	}
		
	//Description: Check Don't show in Potential Assignment
	public void checkDntShowInPotentialAssignment()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> checkDntShowInPotentialAssignment",driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		WebElement dntshowP=driver.findElement(By.name("penaltywarnhide"));
		Checkbox.check("Dont show", dntshowP,driver);
		Button.click("Close", closeBtn,driver);
	}
	
	//Description: Check and Go Potential Assignment
	public void checkAndGoInPotentialAssignment()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> checkAndGoInPotentialAssignment",driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
				
		if(Element.verify("Go Button", driver, "ID", "submitWarningForm"))
		{
			WebElement dntshowP=driver.findElement(By.name("penaltywarnhide"));
			Checkbox.check("Dont show", dntshowP,driver);
			WebElement go=driver.findElement(By.id("submitWarningForm"));
			Button.click("Go", go,driver);
		}else{
			
			Button.click("Close", closeBtn,driver);
		}
	}
	
	//Description: Selecting Reading Resources Assignment
	public void selectReadingResourceAssignment(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectReadingResourceAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameReadingResource");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-MultipleChoice", selectAssignment,driver);	
	}
	
	//Description: Verifying Feedback column from the Assignment
	public void verifyFeedbackColumn()
	{
		ResultUtil.report("INFO", "OpenAssignment >>> verifyFeedbackColumn",driver);
		focusAglistframe();
		WebElement feedback=driver.findElement(By.xpath("//table[2]//tr[1]//td[1]//img"));
		Element.verify("Feedback image", feedback,driver);
		//ImageUtil.compareImage("Green Tick", "document/GradeBook/greenTick.png", driver);
		System.out.println("Image");
	}
	
	//Description: Clicking Review Progress link
	public void clickReviewProgress()
	{
		focusAglistframe();
		Link.click("Review Progress", reviewProgress,driver);
	}
	
	//Description: Verifying Question Study Objective Page
	public void verifyQuestionStudyObjective()
	{
		ResultUtil.report("INFO","OpenAssignment >>> verifyQuestionStudyObjective", driver);
		focusAgbodyFrame();
		String strQuestionStudyObjectiveXpath= "//table//table//tr//td[1]//span"; 
		Sync.waitForObject(driver, "List of Questions in Study Objective ", "XPATH", strQuestionStudyObjectiveXpath);
		List<WebElement> questionStudyObjective=driver.findElements(By.xpath(strQuestionStudyObjectiveXpath));
		for(WebElement questionStudy:questionStudyObjective)
		{
			String questionVerify=questionStudy.getText();
			ResultUtil.report("PASS",questionVerify, driver);
			Element.verify("Question column in Study Objective",questionStudy,questionVerify, driver);
		}
	}
	
	//Description: Click on Study Objective link
	public void clickStudyObjectiveLink(Map<String,String>dataMap)
	{
		ResultUtil.report("INFO","OpenAssignment >>> clickStudyObjectiveLink", driver);
		focusAglistframe();
		String strStudyObjective=dataMap.get("StudentStudyObjectivesLink");
		String strStudyObjectiveXpath= "//table//table//tr//td[1]";
		Sync.waitForObject(driver, "Study Objective Link", "XPATH", strStudyObjectiveXpath+"//a[1]");
		WebElement eleStudyObjective=driver.findElement(By.xpath(strStudyObjectiveXpath+"//a[contains(.,'"+strStudyObjective+"')]"));	
		eleStudyObjective.click();	
	}
	
	//Description: Verifying Print A Blank copy Link
	public void verifyPrintABlankCopy()
	{
		ResultUtil.report("INFO","OpenAssignment >>> verifyPrintABlankCopy", driver);
		focusAgbodyFrame();
		WebElement print=driver.findElement(By.xpath("//table//a"));
		Link.verify(" print a blank copy", print,driver);	
	}
	
	//Description: Verify Time counter label
	public void verifyTimeCounter()
	{
		ResultUtil.report("INFO","OpenAssignment >>>  verifyTimeCounter", driver);
		focusAg_nav_top();
		Element.verify("Timer", driver, "ID", "Timer");
	}
	
	//Description: Verify Question Title of the Assignemnt
	public void verifyQuestionTitle()
	{			
		ResultUtil.report("INFO", "OpenAssignment >>> verifyQuestionTitle",driver);
		focusAglistframe();
		List<WebElement> questions=driver.findElements(By.xpath("//table[2]//tr"));
		
		for(WebElement question:questions)
		{
			String questionName=question.getText();
			ResultUtil.report("PASS", "The question Title" +questionName,driver);
		}
	}
	
	//Description: Verifying Alternative Answer
	public void verifyAlternativeAnswer()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyAlternativeAnswer",driver);
		Window.focusWindow("Show Answer Window", driver, driver.getWindowHandles().toArray()[1].toString());
		WebElement asterik=driver.findElement(By.xpath("//div[@id='_intjsTooltip_1__CLIENT_']"));
		if(Element.verify("Alternative Answer Asterik", asterik, driver))
		{
			Element.mouseOver("Alternative Answer Asterik", asterik, driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Element does not exists", driver);
		}
	}
	
	//Description: Verifying Assignment Displayed in the list
	public void verifyAssignmentIsDisplayed(Map<String, String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyAssignmentIsDisplayed",driver);				
		String assgnmentName=dataMap.get("AsgntNameFuture");
		
		if(Element.verify("Assignment Displayed", driver, "xpath", strPlainTableXpath+"//tr//td[1]//a["+assgnmentName+"]"))
		{
			ResultUtil.reportWithoutScreenshot("Assignment exists in List", assgnmentName);
		}
		else
		{
			ResultUtil.reportWithoutScreenshot("Assignment does not exists in List", assgnmentName);
		}
	}
	
	//Description: Verify Show work
	public void verifyShowWork()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>verifyShowWork", driver);		
		focusAgbodyFrame();		
		String strOpenShowwork = "Open Show Work";
		String strOpenShowWorkXpath="//div[@class='showWork']//a[.='"+strOpenShowwork+"']";
		if(Element.verify("Open Show Work", driver, "xpath", strOpenShowWorkXpath)){
			
			WebElement showworklink = driver.findElement(By.xpath(strOpenShowWorkXpath));
						
			Link.click(strOpenShowwork, showworklink, driver);
			
			
		}else{
			
			String strModifyAssignment= "Modify Show Work";			
			
			WebElement modifyShowWorklink = driver.findElement(By.xpath("//div[@class='showWork']//a[.='"+strModifyAssignment+"']"));
			
			Link.click(strModifyAssignment, modifyShowWorklink, driver);
		}	
	}
	
	//Description: Verifying Show Work Link After Submitting the Answer	
	public void verifyShowWorkLinkAfterSubmittingAnswer(){
		
		ResultUtil.report("INFO", "OpenAssignment>>>verifyShowWorkLinkAfterSubmittingAnswer", driver);		
		String strOpenBlankShowWork = "Open blank Show Work";								
		Element.verify("Open Blank Show work", blankShowWorkLink, strOpenBlankShowWork, driver);		
		String strPreviousAttempt = "Copy Show Work from Previous attempt";						
		Element.verify("Copy Show Work", previousAttemptShowWork, strPreviousAttempt, driver);		
	}
	
	//Description: Selecting Open Blank show work link
	public void selectOpenBlankShowWork(){
		
		ResultUtil.report("INFO", "OpenAssignment>>>selectOpenBlankShowWork", driver);
		
		String strOpenBlankShowWork = "Open blank Show Work";
		
		Link.click(strOpenBlankShowWork, blankShowWorkLink, driver);
		
	}
	
	//Description: selecting Copy Show work Previous attempt link
	public void selectCopyShowWorkPreviousAttempt(){		
		ResultUtil.report("INFO", "OpenAssignment>>>selectCopyShowWorkPreviousAttempt", driver);		
		String strPreviousAttempt = "Copy Show Work from Previous attempt";			
		Link.click(strPreviousAttempt, previousAttemptShowWork, driver);		
	}
	
	//Description: Selecting Practice Question Assignment
	public void selectPracticeQuestion(Map<String,String> dataMap){
		
		ResultUtil.report("INFO", "OpenAssignment>>selectPracticeQuestion",driver);
		String strAssignmentNames = dataMap.get("AsgntNamePractice");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);	
		Link.click("Test-Practice Assignment", selectAssignment,driver);
	}
	
	//Description: Accept Alert
	public void alertAccept()
	{
		ResultUtil.report("INFO", "OpenAssignment>>alertAccept",driver);
		try{
		Alert alert=driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);
		driver.switchTo().alert().accept();		
		}
		catch(Exception e){}
	}
	
	//Description: Cancel Alert
	public void alertDismiss()
	{
		ResultUtil.report("INFO", "OpenAssignment>>alertDismiss",driver);
		Alert alert=driver.switchTo().alert();
		driver.switchTo().alert().dismiss();
	}
	
	//Description: Clicking Time Counter
	public void clickTimeCounter()
	{
		ResultUtil.report("INFO","OpenAssignment>>>clickTimeCounter", driver);
		Element.verify("Timer", driver, "ID", "Timer");
		WebElement timer=driver.findElement(By.id("Timer"));
		Button.click("Timer", timer, driver);
	}
	
	//Description: wait for 10 minutes 
	public void waitFor10Minutes()
	{
		ResultUtil.report("INFO","OpenAssignment>>>waitFor10Minutes", driver);
		Sync.waitForSeconds(600, driver);
	}

	
	//Description: verify all Questions
	public void verifyAllQuestions(){
		
		ResultUtil.report("INFO", "OpenAssignment >>> verifyAllQuestions",driver);
		focusAgbodyFrame();
		List<WebElement> questions=driver.findElements(By.xpath(strReviewTotalScore+"//span[@class='selenium_question']"));
		for(WebElement getQuestions:questions)
		{
			String questionName=getQuestions.getText();
			checkMaximumPointPotential(questionName);
			checkPointsEarned(questionName);
			checkQuestionAttempts(questionName);
			checkAnswered(questionName);
		}
	}
	
	//Description: Enter Answer for Tolerance question
	public void enterExactAnswerForTolerance(Map<String, String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>>enterExactAnswerForTolerance",driver);
		focusAgbodyFrame();
		String strAnswer=dataMap.get("ToleranceValue").trim();
		WebElement txtEnterAnswer=driver.findElement(By.xpath(strQuestionPresentation));
		TextBox.enterValue("Answer textBox", txtEnterAnswer, strAnswer, driver);
	}
	
	//Description: Move on to Entry Field
	public void moveOnEntryField()
	{
		ResultUtil.report("INFO", "OpenAssignment >>>moveOnEntryField",driver);
		focusAgbodyFrame();
		WebElement txtEnterAnswer=driver.findElement(By.xpath(strQuestionPresentation));
		Element.mouseOver("Answer Field", txtEnterAnswer, 5, driver);
	}
	
	//Description: Verifying Repeat With New Values
	public void verifyRepeatWithNewValues()
	{
		ResultUtil.report("INFO", "OpenAssignment >>>verifyRepeatWithNewValues",driver);
		focusAgbodyFrame();
		
		if(Element.verify("Repeat Question", driver, "xpath", "//a[contains(.,'Repeat question')]"))
		{
			ResultUtil.report("PASS", "Repeat Question With New Values Button exists", driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Repeat Question With New Values Button does not appeared", driver);
		}
	}
	
	//Description: Select Repeat question With New values
	public void selectRepeatWithNewValues()
	{
		ResultUtil.report("INFO", "OpenAssignment >>>verifyRepeatWithNewValues",driver);
		focusAgbodyFrame();
		
		if(Element.verify("Repeat Question", driver, "xpath", "//a[contains(.,'Repeat question')]")){
			WebElement btnRepeatQuesiton=driver.findElement(By.xpath("//a[contains(.,'Repeat question')]"));
			Button.click("Repeat Question With New Values",  btnRepeatQuesiton, driver);
		}else{
			
			ResultUtil.report("FAIL", "Repeat Question With New Values Button does not appeared", driver);
		}
		
	}
	
	//Description: Verify Change Values in the Assignment
	public void verifyChangeValue()
	{
		ResultUtil.report("INFO", "OpenAssignment >>>verifyChangeValue",driver);
		focusAgbodyFrame();
		WebElement changeValue=driver.findElement(By.xpath("//a[.='Change Values']"));
		Link.verify("Change Values", changeValue, driver);
	}

	
	//Description: Answer the question without show answer 
	public void answerQuestions(){
		
		ResultUtil.report("INFO", "OpenAssignment>>>answerQuestion", driver);
		focusAgbodyFrame();
		String strQtiPresentationFeedback="//div[contains(@class,'qti-presentation')]";
		List<WebElement> answerText = driver.findElements(By.xpath(strQtiPresentationFeedback+"//tr"));
		
		for(int i=1; i<=answerText.size(); i++)
		{	
			if(Element.verify("Verify Element", driver, "xpath", strQtiPresentationFeedback+"//tr["+i+"]/td//input[@class='rightinput']"))
			{
				WebElement answerQuestion = driver.findElement(By.xpath(strQtiPresentationFeedback+"//tr["+i+"]/td//input[@class='rightinput']"));
			
				String strAnswerValue = "1110000";
			
				TextBox.clearValue("Enter Answer", answerQuestion, driver);
				TextBox.enterValue("Enter Answer", answerQuestion, strAnswerValue, driver);
			}
		}
	}
	
	//Description: Verify Element Present
	public void verifyComment(){
		
		ResultUtil.report("INFO", "OpenAssignment>>>verifyComment", driver);
		
		driver.switchTo().defaultContent();
		
		focusAgbodyFrame();
		
		if(Element.verify("Verify Text", driver, "xpath", "//tr[2]/td[contains(.,'Gradebook')]")){
			
			String strCommentText = "Your answer has been saved and sent for grading. See Gradebook for score details.";
			WebElement verifyComment = driver.findElement(By.xpath("//tr[2]/td[contains(.,'Gradebook')]"));
			
			Element.verify("Verify", verifyComment, strCommentText, driver);
		
		}else{
			
			WebElement verifyComment = driver.findElement(By.xpath("//tr[2]/td[contains(.,'Gradebook')]"));
			
			ResultUtil.report("FeedBack", verifyComment.getText(), driver);
		}
	}
	
	//Description: Select Multiple Answers for the Assignment
	public void selectMultipleAnswers()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>selectMultipleAnswers", driver);
		WebElement answers=driver.findElement(By.xpath("//select[@id='resp_str_c01q_4_10_part_1_13']"));
		Select drpdwn=new Select(answers); 
		if(drpdwn.isMultiple())
		{
			String strItems="December 31, 2010;For the Year Ended December 31, 2010";
			Listbox.selectItems("Answer dropdown",answers, strItems, driver);
		}
		else
		{
			ResultUtil.report("FAIL", "Multiple selection is not enabled in" +answers, driver);
		}
		
	}
	
	//Description: Verifying Description Page
	public void verifyDescriptionPage()
	{
		ResultUtil.report("INFO", "OpenAssignment>>>verifyDescriptionPage", driver);
		
		focusAgbodyFrame();
		String strAssignmentTypeXpath="//table//tr[4]//td[2]/span";
		if(Element.verify("Assignme Type", driver, "xpath", strAssignmentTypeXpath)){
			WebElement assgnType=driver.findElement(By.xpath(strAssignmentTypeXpath));
			Element.verify("Assignment Type", assgnType, driver);
			String strAssgnTypeValue=assgnType.getText();
			ResultUtil.report("PASS", "Assignment Type: "+strAssgnTypeValue, driver);
		}
		String strStartDateXpath= "//table//tr[10]/td[4]//span";
		if(Element.verify("StartDate", driver, "xpath", strStartDateXpath)){
			WebElement startDate=driver.findElement(By.xpath(strStartDateXpath));
			Element.verify("Start Date", startDate, driver);
			String strstartDate=startDate.getText();
			ResultUtil.report("PASS", "Start Date: "+strstartDate, driver);
		}
		String strDueDateXpath= "//table//tr[11]/td[4]//span";
		if(Element.verify("DueDate", driver, "xpath", strDueDateXpath)){
			WebElement dueDate=driver.findElement(By.xpath(strDueDateXpath));
			Element.verify("Due Date", dueDate, driver);
			String strdueDate= dueDate.getText();
			ResultUtil.report("PASS", "Start Date: "+strdueDate, driver);
		}
		String strStudentAccessXpath="//table//tr[12]/td[4]//span";
		if(Element.verify("Student Access", driver, "xpath", strStudentAccessXpath)){
			
			WebElement stdntAccess=driver.findElement(By.xpath(strStudentAccessXpath));
			Element.verify("Student Access", stdntAccess, driver);
			String strstdntAccess=stdntAccess.getText();
			ResultUtil.report("PASS", "Student Access After Due Date: "+strstdntAccess, driver);
		}
		String strAssignmentPoliciesXpath= "//table//tr[18]//td[4]//span";
		if(Element.verify("Assignment Policies", driver, "xpath", strAssignmentPoliciesXpath)){
			WebElement assgnPolicies=driver.findElement(By.xpath(strAssignmentPoliciesXpath));
			Element.verify("Assignment Policies", assgnPolicies, driver);
			String strassgnPolicies=assgnPolicies.getText();
			ResultUtil.report("PASS", "Graded "+strassgnPolicies, driver);
		}
		String strQuestionPoliciesXpath= "//table//tr[24]//td[4]//span";
		if(Element.verify("Question Policies", driver, "xpath", strQuestionPoliciesXpath)){
		
			WebElement qnPolicies=driver.findElement(By.xpath(strQuestionPoliciesXpath));
			Element.verify("Question Policies", qnPolicies, driver);
			String strqnPolicies=qnPolicies.getText();
			ResultUtil.report("PASS", "Attempts per question: "+strqnPolicies, driver);
		}
	}
	
	
	//Description: verify the questions
	public void verifyQuestions(){
		
		ResultUtil.report("INFO", "OpenAssignment>>>verifyQuestions", driver);		
		focusAgbodyFrame();		
		String strQuestionTextXpath= "//div[@class='qti-presentation']";
		List<WebElement> questionText = driver.findElements(By.xpath(strQuestionTextXpath+"//tr"));
		
		for(int i=1; i< questionText.size(); i++)
		{
			WebElement answerQuestion = driver.findElement(By.xpath(strQuestionTextXpath+"//tr["+i+"]"));
			
			ResultUtil.report("Message", answerQuestion.getText(), driver);			
		}		
	}
	
	//Description: Select Multiple Question Assignment 1
	public void selectMultipleQuestionAssignment1(Map<String, String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectMultipleQuestionAssignment1",driver);
		String strAssignmentNames = dataMap.get("AsgntNameAsgnt1").trim();
		
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);		
		Link.click("Test-Multiple Question", selectAssignment,driver);
		
	}
	
	//Description: Select Multiple Question Assignment 2
	public void selectMultipleQuestionAssignment2(Map<String, String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment>>selectMultipleQuestionAssignment1",driver);
		String strAssignmentNames = dataMap.get("AsgntNameAsgnt2").trim();
		
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		Link.click("Test-MultipleChoice", selectAssignment,driver);
	}
	
	//Description: Verifying Due Date Stamp in the Assignment
	public void verifyDueDateStamp()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifyDueDateStamp",driver);
		WebElement DuedateStamp=driver.findElement(By.xpath(strReviewTotalScore+"//following-sibling::table//td[1]"));
		Element.verify("Due date stamp", DuedateStamp, driver);
		String dueDate=DuedateStamp.getText();
		ResultUtil.report("PASS", dueDate, driver);
	}
	
	//Description: Verify saved To GardeBook Stamp in the assignment 
	public void verifySavedToGradeBookStamp()
	{
		ResultUtil.report("INFO", "OpenAssignment>>verifySavedToGradeBookStamp",driver);
		focusAgbodyFrame();
		WebElement GradeBookStamp=driver.findElement(By.xpath(strReviewTotalScore+"//following-sibling::table//td[3]"));
		Element.verify("Due date stamp", GradeBookStamp, driver);
		String GradeBook=GradeBookStamp.getText();
		ResultUtil.report("PASS", GradeBook, driver);
	}

	//Description: Focus on Iframe 
	private void focus_I_Frame(){
		driver.switchTo().frame(0);
	}	
	
	//Description: Selecting Mastery Assignment from the List
	public void selectMasteryAssignment(Map<String,String> dataMap){		
		ResultUtil.report("INFO", "OpenAssignment >>> selectMasteryAssignment",driver);
		String strAssignmentNames = dataMap.get("MasteryAssignment");
		
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("INFO", selectAssignment.getText(), driver);
		Link.click("MasteryAssignment", selectAssignment,driver);
	}
	
	//Description: Verifying the Mastery Assignment Questions
	public void verifyMasteryQuestion(){		
		ResultUtil.report("INFO", "OpenAssignment>>verifyMasteryQuestion",driver);
		focusAgbodyFrame();
		String strTextEntryXpath= "//div[@class='qti-presentation']";
		List<WebElement> textEntry=driver.findElements(By.xpath(strTextEntryXpath+"//table"));
		for(int i=1; i<textEntry.size();i++)
		{
			WebElement checkAnswer = driver.findElement(By.xpath(strTextEntryXpath+"//table["+i+"]//input"));
			
			if(i==5){
				
				Checkbox.check("Answer Question", checkAnswer, driver);
				Button.click("submit Answer", submitAnswer,driver);
				
				String answerColumn=driver.findElement(By.xpath(strTextEntryXpath+"//tr[2]//td[2]")).getText();
				if(answerColumn.trim().contains("correct"))
				{
					ResultUtil.report("MESSAGE", "Your Answer is correct",driver);
				}
				else if(answerColumn.trim().contains("Incorrect"))
				{
					ResultUtil.report("MESSAGE", "Your Answer is incorrect",driver);
				}
				else{
					
					ResultUtil.report("MESSAGE", "Your Answer is partially correct",driver);
				}
			}
		}		
	}
	
	//Description: Verify Mastery Score 
	public void verifyMasteryScore(){
		
		ResultUtil.report("INFO", "OpenAssignment >>> verifyMasteryScore",driver);
		focusAgbodyFrame();
		
		String masteryScore=driver.findElement(By.xpath("//table[2]//td[.='Mastery Points:']//following-sibling::td[./b]")).getText();
		
		ResultUtil.report("MESSAGE", "Mastery Points:" +masteryScore,driver);
	}
	
	//Description: Getting total score for the specific question
	public void getTotalScoreSpecificQuestions()
	{		
		ResultUtil.report("INFO", "OpenAssignment >>> getTotalScoreSpecificQuestions",driver);
		focusAgbodyFrame();
		List<WebElement> earnedscore=driver.findElements(By.xpath(strReviewTotalScore+"//tr"));
		int rowsize=earnedscore.size();
		String earnedScore=driver.findElement(By.xpath(strReviewTotalScore+"//tr["+(rowsize-4)+"]//td[5]")).getText();
		String totalScore=driver.findElement(By.xpath(strReviewTotalScore+"//tr["+(rowsize-4)+"]//td[7]")).getText();
		ResultUtil.report("MESSAGE", "Earned score =" +earnedScore+ "Total score =" +totalScore,driver);
	}
		
	//Description: Selecting Multiple Immediate Feedback Assignment 
	public void selectMultistepImmediatefeedback(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "OpenAssignment >>> selectMultiStepAssignment",driver);
		String strAssignmentNames = dataMap.get("AsgntNameMultistepImmediatefeedback");
		
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("MESSAGE", selectAssignment.getText(), driver);
		Link.click("Test-MultipleImmediateFeedback", selectAssignment,driver);	
	}
	
	//Description: Answering Incorrect
	public void answerIncorret(Map<String,String> dataMap){
		ResultUtil.report("INFO", "OpenAssignment >>> answerMultiPartQuestion",driver);
		focusAgbodyFrame();
		List<WebElement> txtAnswer=driver.findElements(By.xpath("//input[@type='text']"));
		for(WebElement answer:txtAnswer){
			TextBox.clearValue("Wrong Answer", answer, driver);
			TextBox.enterValue("Wrong Answer", answer, "Incorrect Answer", driver);
		}
	}

	
	//Description: Answer fill questions
	public void answerFillQuestion(Map<String,String> dataMap){
		ResultUtil.report("INFO", "OpenAssignment >>> answerFirstQuestionPre",driver);
		focusAgbodyFrame();
		String strAnswer1=dataMap.get("FillAnswer1");
		WebElement answer1=driver.findElement(By.xpath("//div[contains(.,'0 decimal')]//input[@type='text']"));
		TextBox.clearValue("Answer", answer1, driver);
		TextBox.enterValue("Answer", answer1, strAnswer1, driver);
		String strAnswer2=dataMap.get("FillAnswer2");
		WebElement answer2=driver.findElement(By.xpath("//div[contains(.,'2 decimal')]//input[@type='text']"));
		TextBox.clearValue("Answer", answer2, driver);
		TextBox.enterValue("Answer", answer2, strAnswer2, driver);
	}
	
	//Description: select third answer in multi choice
	public void selectThirdAnswerInMultiChoice(){
		ResultUtil.report("INFO", "OpenAssignment >>> selectThirdAnswerInMultiChoice",driver);
		focusAgbodyFrame();
		WebElement rdobtnthridAnswer=driver.findElement(By.xpath("//div[@class='visualGradingContainer']//table[3]//tr/td[1]//input"));
		if(Radiobutton.isEnabled(rdobtnthridAnswer, "Third Answer", driver)){
			Radiobutton.select("Third Answer", rdobtnthridAnswer, driver);
		}
	}
		
	//Description: select third answer in multi choice
	public void selectSecondAnswerInMultiChoice(){
		ResultUtil.report("INFO", "OpenAssignment >>> selectThirdAnswerInMultiChoice",driver);
		focusAgbodyFrame();
		WebElement rdobtnsecondAnswer=driver.findElement(By.xpath("//div[@class='visualGradingContainer']//table[2]//tr/td[1]//input"));
		if(Radiobutton.isEnabled(rdobtnsecondAnswer, "Second Answer", driver)){
			Radiobutton.select("Second Answer", rdobtnsecondAnswer, driver);
		}
	}
	
	//Description: Get Answered Column from assignment 
	public void getAnsweredColumnAsgntA(Map<String, String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getAnsweredColumn",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> answeredColumn=driver.findElements(By.xpath("//span[@class='selenium_answered']"));
		int i=1;
		for(WebElement answered:answeredColumn){
			String strAnswered=answered.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "Answered"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+"inserted in input sheet", driver);
			i=i+1;
		}

	}
	
	//Description: Get Answered Column from assignment 
	public void getAnsweredColumnAsgntB(Map<String, String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getAnsweredColumn",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> answeredColumn=driver.findElements(By.xpath("//span[@class='selenium_answered']"));
		int i=9;
		for(WebElement answered:answeredColumn){
			String strAnswered=answered.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "Answered"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}
	
	//Description: Get Points earned from assignment
	public void getPointsEarnedAsgntA(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getPointsEarnedAsgntA",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> pointsEarned=driver.findElements(By.xpath("//span[@class='selenium_points_earned']"));
		int i=1;
		for(WebElement points:pointsEarned){
			String strAnswered=points.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "PointsEarned"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}
	
	//Description: Get Points earned from assignment
	public void getPointsEarnedAsgntB(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getPointsEarnedAsgntB",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> pointsEarned=driver.findElements(By.xpath("//span[@class='selenium_points_earned']"));
		int i=9;
		for(WebElement points:pointsEarned){
			String strAnswered=points.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "PointsEarned"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}

	//Description: Get Maximum points from assignment
	public void getMaximumPointsAsgntA(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getMaximumPointsAsgntA",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> maximumPoints=driver.findElements(By.xpath(strMaximumPointsXpath));
		int i=1;
		for(WebElement points:maximumPoints){
			String strAnswered=points.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "MaxPoints"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}
	
	//Description: Get Maximum points from assignment
	public void getMaximumPointsAsgntB(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getMaximumPointsAsgntB",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> maximumPoints=driver.findElements(By.xpath(strMaximumPointsXpath));
		int i=9;
		for(WebElement points:maximumPoints){
			String strAnswered=points.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "MaxPoints"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}
	
	//Description: Get Total earned and maximum score
	public void getTotalEarnedAndMaxScoreAsgntA(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getMaximumPointsAsgntB",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		WebElement totalPoints=driver.findElement(By.xpath("//b[@id='selenium_total_score']"));
		String strTotalPoints=totalPoints.getText();
		ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "TotalPointsEarned1", strTotalPoints);
		ResultUtil.report("PASS", strTotalPoints+" inserted in input sheet", driver);
		WebElement totalMax=driver.findElement(By.xpath("//b[@id='selenium_total_max_score']"));
		String strTotalMax=totalMax.getText();
		ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "TotalMaxScore1", strTotalMax);
		ResultUtil.report("PASS", strTotalMax+" inserted in input sheet", driver);
	}

	//Description: Get Total earned and maximum score
	public void getTotalEarnedAndMaxScoreAsgntB(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getMaximumPointsAsgntB",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		WebElement totalPoints=driver.findElement(By.xpath("//b[@id='selenium_total_score']"));
		String strTotalPoints=totalPoints.getText();
		ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "TotalPointsEarned2", strTotalPoints);
		ResultUtil.report("PASS", strTotalPoints+" inserted in input sheet", driver);
		WebElement totalMax=driver.findElement(By.xpath("//b[@id='selenium_total_max_score']"));
		String strTotalMax=totalMax.getText();
		ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "TotalMaxScore2", strTotalMax);
		ResultUtil.report("PASS", strTotalMax+" inserted in input sheet", driver);
	}

	//Description: Verify Show Work Links
	public void verifyShowWorkLinks(){
		ResultUtil.report("INFO", "OpenAssignment >>>verifyShowWorkLinks",driver);
		if(Element.verify("Show Work Links", driver, "xpath", "//table//tr//span[contains(text(),'Show Links')]")){
			ResultUtil.report("PASS", "Show links text is available", driver);
		}else{
			ResultUtil.report("FAIL", "Show links text is not available", driver);			
		}
		
	}
	
	//Description: Get Question attempts from assignment
	public void getQuestionAttemptsAsgntA(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getMaximumPointsAsgntB",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> qnAttempt=driver.findElements(By.xpath(strQuestionAttempts));
		int i=1;
		for(WebElement attempts:qnAttempt){
			String strAnswered=attempts.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "QnAttempts"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}
	
	//Description: Get Question attempts from assignment
	public void getQuestionAttemptsAsgntB(Map<String,String> dataMap,String strWorkSheetName){
		ResultUtil.report("INFO", "OpenAssignment >>> getMaximumPointsAsgntB",driver);
		String strWorkbook="input/GradeBook/QA-Input1.xls";
		String strSheet=dataMap.get(strWorkSheetName);
		focusAgbodyFrame();
		List<WebElement> qnAttempt=driver.findElements(By.xpath(strQuestionAttempts));
		int i=9;
		for(WebElement attempts:qnAttempt){
			String strAnswered=attempts.getText();
			ExcelUtil.updateTestData(strWorkbook, strSheet, "1", "QnAttempts"+i, strAnswered);
			ResultUtil.report("PASS", strAnswered+" inserted in input sheet", driver);
			i=i+1;
		}
	}
	
	//Description: Attempt questions for Brief-Exercise 11-11
	public void attemptQuestionBriefExcercise11(Map<String,String>dataMap){
		ResultUtil.report("INFO", "OpenAssignment >>> attemptQuestionBriefExcercise11",driver);
		focusAgbodyFrame();
		String strQuestion=dataMap.get("QuestionAnswer1");
		String strAnswer1=dataMap.get("AnswerSubmitEditScore1");
		WebElement elmntAnswer1=driver.findElement(By.xpath("//td[.='"+strQuestion+"']//following-sibling::td[2]//input"));
		TextBox.enterValue("Answer For First Question", elmntAnswer1,strAnswer1 , driver);
		String strAnswer2=dataMap.get("AnswerSubmitEditScore");
		WebElement elmntAnswer2=driver.findElement(By.xpath("//td[.='"+strQuestion+"']//following-sibling::td[4]//input"));
		TextBox.enterValue("Answer For First Question", elmntAnswer2,strAnswer2 , driver);
	}
	
	//Description: Attempt Manually graded Questions
	public void attemptIFRSquestion(Map<String,String>dataMap){
		ResultUtil.report("INFO", "OpenAssignment >>> attemptIFRSquestion",driver);
		focusAgbodyFrame();
		List<WebElement> elmntQuestionList=driver.findElements(By.xpath("//div[@class='qti-presentation']/textarea"));
		int i=2;
		for(WebElement elmntQuestion:elmntQuestionList){
			String strAnswer=dataMap.get("QuestionAnswer"+i);
			TextBox.enterValue("TextArea Content", elmntQuestion,strAnswer , driver);
			i++;
		}
	}
	
	//Description: select Disable Immediate feedback assignment
	public void selectDisableAssignment(Map<String,String> dataMap){
		ResultUtil.report("INFO", "OpenAssignment>>selectDisableAssignment",driver);
		String strAssignmentNames = dataMap.get("DisbleFeedback");
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		
		Link.click("Disable Assignment", selectAssignment,driver);
	}
	
	//Description: Select Assistance Show Always assignment
	public void selectAssistanceShowalways(Map<String,String>dataMap){
		ResultUtil.report("INFO", "OpenAssignment>>selectAssistanceShowalways",driver);
		String strAssignmentNames = dataMap.get("ShowAlways");
		Sync.waitForObject(driver, "Assignment Tablw", "xpath", strPlainTableXpath);
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		
		Link.click("ShowAlwaysAssignment", selectAssignment,driver);
	}
	//Description: Select DueDate selector Assignment
	public void selectDueDateSelector(Map<String,String> dataMap){
		ResultUtil.report("INFO", "OpenAssignment>>selectDueDateSelector",driver);
		
		String strAssignmentNames = dataMap.get("DueDateSelector");
		Sync.waitForObject(driver, "Assignment Table", "xpath", strPlainTableXpath);
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		
		Link.click("Due Date Selector", selectAssignment,driver);
		
		
	}
	//Description: Attempt Assigment Zero, Question 20
	public void attemptAssignmentQuestion20(Map<String,String>dataMap){
		ResultUtil.report("INFO", "OpenAssignment >>> attemptAssignmentQuestion20",driver);
		focusAgbodyFrame();
		List<WebElement> elmntQuestionList=driver.findElements(By.xpath("//span//input"));
		int i=3;
		for(WebElement elmntQuestion:elmntQuestionList){
			String strAnswer=dataMap.get("AnswerSubmitEditScore"+i);
			TextBox.enterValue("TextBox Value", elmntQuestion, strAnswer, driver);
			selectSubmitAnswer();
			i++;
		}
	}
		
	//Description: Attempt Problem 1-2A(Essay)
	public void attemptProblem12A(Map<String,String>dataMap){
		ResultUtil.report("INFO", "OpenAssignment >>> attemptProblem12A",driver);
		focusAgbodyFrame();
		List<WebElement> elmntQuestionList=driver.findElements(By.xpath("//textarea"));
		int i=5;
		for(WebElement elmntQuestion:elmntQuestionList){
			String strAnswer=dataMap.get("AnswerSubmitEditScore"+i);
			TextBox.enterValue("TextBox value",elmntQuestion, strAnswer, driver);
			i++;
		}
	}
	
	//Description: select Multi Question Assignment
	public void selectMultiQuestionAssignment(Map<String,String>dataMap){
		
		ResultUtil.report("INFO", "OpenAssignment>>>selectMultiQuestionAssignment", driver);
		
		String strAssignmentNames = dataMap.get("AsgntSubmitScoreEditName1");
		Sync.waitForObject(driver, "Assignment Table", "xpath", strPlainTableXpath);
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		
		Link.click("Asgnt Submit Score Edit Name1", selectAssignment,driver);
		
	}
	
	//Description: Verify Review Score Study Objective image 
	public void verifyReviewScoreStudyObjectiveScreenshot(){
		ResultUtil.report("INFO", "OpenAssignment>>>verifyReviewScoreScreenshot", driver);
		
		//ImageUtil.compareImage("Review Score", "document/Assignment/E4_4510.png", driver);
		
	}
	
	//Description: Verify Review Score Screenshot
	public void verifyReviewScoreScreenShot(){
		ResultUtil.report("INFO", "OpenAssignment>>>verifyReviewScoreScreenShot", driver);
		//ImageUtil.compareImage("Review Score", "document/Assignment/E4_4565.png", driver);
		
	}
	
	//Description: select Describe Assignment
	public void selectDescribeAssignment(Map<String,String> dataMap){
		ResultUtil.report("INFO", "OpenAssignment>>>selectDescribeAssignment", driver);
		
		String strAssignmentNames = dataMap.get("DescribeAssignment");
		Sync.waitForObject(driver, "Assignment Table", "xpath", strPlainTableXpath);
		WebElement selectAssignment = driver.findElement(By.xpath(strPlainTableXpath+"//a[.='" + strAssignmentNames + "']"));
		ResultUtil.report("Message", selectAssignment.getText(), driver);
		
		Link.click("Describe Assignment", selectAssignment,driver);
		
	}
	
	public void verifyDescribeAssignmentScreenShot(){
		ResultUtil.report("INFO", "OpenAssignment>>>verifyReviewScoreScreenShot", driver);
		//ImageUtil.compareImage("Review Score", "document/Assignment/E4_4504.png", driver);
		
	}

}
	
