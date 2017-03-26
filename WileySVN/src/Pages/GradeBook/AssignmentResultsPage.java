package Pages.GradeBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;

import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.Window;
import Util.CommonUtil;

public class AssignmentResultsPage extends Initializer{
		
	public AssignmentResultsPage(WebDriver driver){
		super(driver);
	}
	
	String strTableClass="//table[contains(@class,'plain-table')]//tr";
	String strquestionLink="//table[@class='plain-table']//tr//td[@class='selenium_qtitle']"; 
	String strClassContent="//table[@class='content-area']//table//table//table//table";
	
	@FindBy(how=How.XPATH,using="//table[2]//tr[1]/td[3]")
	private WebElement elmntMaximumPointPotentialScore;
	
	@FindBy(how=How.XPATH,using="//table[2]//tr[2]/td[3]")
	private WebElement elmntPointsEarnedScore;
	
	@FindBy(how=How.XPATH,using="//span[@class='breadcrumb']//a[.='Gradebook']")
	private WebElement gradeBookLinkBreadCrumb;
		
	//Description:Show the result for one question Item
	public AssignmentResultsPage getQuestionResult(Map<String,String> dataMap){
		ResultUtil.report("INFO","AssignmentResultsPage >>> getQuestionResult", driver);
		String strQuestionName=dataMap.get("QuestionLink");
		String strQuestion=strTableClass+"//td/a[.='"+strQuestionName+"']";
		Sync.waitForObject(driver,"Question Link" , "XPATH", strQuestion);
		WebElement lnkQuestionName = driver.findElement(By.xpath(strQuestion));
		Link.verify("Question Link- "+strQuestionName, lnkQuestionName, strQuestionName, driver);
		Link.click("Any Question Link- "+strQuestionName, lnkQuestionName, driver);		
		return PageFactory.initElements(driver, AssignmentResultsPage.class);
	}
	
	//Description:Show the total Score
	public StudentGradeBookPage getTotalScore(){
		ResultUtil.report("INFO", "AssignmentResultsPage >>> getTotalScore", driver);	
		WebElement elmntFirstAssingment = driver.findElement(By.xpath("//td[./b[.='Total Score:']]/following-sibling::td[2]"));
		String strTotalScore= elmntFirstAssingment.getText();
		boolean blTotalScore = CommonUtil.isNumeric(strTotalScore);
		
		if(blTotalScore){
			ResultUtil.report("PASS",  "score column values ["+blTotalScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "score column values ["+blTotalScore+"]", driver);
		}
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}
			
	// Description:Check the score column values for each question
	public void verifyScore(String questionName){
		ResultUtil.report("INFO", "AssignmentResultsPage >>> verifyScore", driver);
		WebElement elmntFirstAssingment = driver.findElement(By.xpath("//td[./a[.='"+questionName+"']]/following-sibling::td[10]"));
		String strScore= elmntFirstAssingment.getText();
		boolean blTotalScore = CommonUtil.isNumeric(strScore);
		
		if(blTotalScore){
			ResultUtil.report("PASS", "questionName["+questionName+"]    score column values ["+strScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "questionName["+questionName+"]    score column values ["+strScore+"]", driver);
		}
	}
	
	// Description:Check the score column values for first question
    public void verifyFirstQuestionsAttempt(Map<String,String>dataMap){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> verifyFirstQuestionsAttempt", driver);
    	String strquestionName=dataMap.get("Questions1");
		WebElement elmntFirstQuestion = driver.findElement(By.xpath("//td[./a[.='"+strquestionName+"']]/following-sibling::td[4]"));
		String strScore= elmntFirstQuestion.getText();
		
		if(strScore.equalsIgnoreCase("-") && strScore !=null){
			ResultUtil.report("PASS", "UnAttempted questionName["+strquestionName+"]    score column values ["+strScore+"]", driver);
		}
		else if(strScore.equalsIgnoreCase("0.00") && strScore !=null){
			ResultUtil.report("PASS", "submitted incorrect answer questionName["+strquestionName+"]    score column values ["+strScore+"]", driver);
		}
		else if(strScore.matches(".*\\d.*") && strScore !=null){
			ResultUtil.report("PASS", "submitted correct or partially correct answer questionName["+strquestionName+"]    score column values ["+strScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "Question not Verified", driver);
		}
	}
    
    // Description:Check the score column values for second question
    public void verifySecondQuestionsAttempt(Map<String,String>dataMap){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> verifySecondQuestionsAttempt", driver);
    	String strquestionName=dataMap.get("Questions1");
		WebElement elmntSecondQuestion = driver.findElement(By.xpath("//td[./a[.='"+strquestionName+"']]/following-sibling::td[6]"));
		String strScore= elmntSecondQuestion.getText();
		
		if(strScore.equalsIgnoreCase("-") && strScore !=null){
			ResultUtil.report("PASS", "UnAttempted questionName["+strquestionName+"]    score column values ["+strScore+"]", driver);
		}
		else if(strScore.equalsIgnoreCase("0.00") && strScore !=null){
			ResultUtil.report("PASS", "submitted incorrect answer questionName["+strquestionName+"]    score column values ["+strScore+"]", driver);
		}
		else if(strScore.matches(".*\\d.*") && strScore !=null){
			ResultUtil.report("PASS", "submitted correct or partially correct answer questionName["+strquestionName+"]    score column values ["+strScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "Question not Verified", driver);
		}
	}
    
    // Description:Check the score column values for Third question
    public void verifyThirdQuestionsAttempt(Map<String,String>dataMap){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> verifySecondQuestionsAttempt", driver);
    	String strquestionName=dataMap.get("Questions1");
		WebElement elmntThirdQuestion = driver.findElement(By.xpath("//td[./a[.='"+strquestionName+"']]/following-sibling::td[8]"));
		String strScore= elmntThirdQuestion.getText();
		
		if(strScore.equalsIgnoreCase("-") && strScore !=null){
			ResultUtil.report("PASS", "questionName["+strquestionName+"]    score column value ["+strScore+"]", driver);
		}
		else if(strScore.equalsIgnoreCase("0.00") && strScore !=null){
			ResultUtil.report("PASS", "submitted incorrect answer questionName["+strquestionName+"]    score column value ["+strScore+"]", driver);
		}
		else if(strScore.matches(".*\\d.*") && strScore !=null){
			ResultUtil.report("PASS", "submitted correct or partially correct answer questionName["+strquestionName+"]    score column value ["+strScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "Question not Verified", driver);
		}
	}
    
    //Description: Check Question Name links. 
    public void isQuestionLinkActive(String questionName){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> isQuestionLinkActive", driver);
		WebElement elmntQuestionLink = driver.findElement(By.xpath("//td[./a[.='"+questionName+"']]"));
		Link.verify("Question Link Active", elmntQuestionLink, questionName, driver);
	}
    
    // Description:Check Grading Type column values
    public void checkGradingType(String questionName){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> checkGradingType", driver);
		WebElement elmntFirstAssingment = driver.findElement(By.xpath("//td[./a[.='"+questionName+"']]/following-sibling::td[12]"));
		String strScore= elmntFirstAssingment.getText();
		
		if(strScore.contentEquals("auto") && strScore !=null){
			ResultUtil.report("PASS", "questionName["+questionName+"]    GradingType value ["+strScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "questionName["+questionName+"]    GradingType value ["+strScore+"]", driver);
		}
	}
    
    //Description:Click All question Link and verify the Maximum Point Potential & Points Earned
	public void getAllQuestionLinks(){
		ResultUtil.report("INFO", "AssignmentResultsPage >>> getAllQuestionLinks", driver);
		List<WebElement> questions= new ArrayList<WebElement>();
		List<WebElement> questionName=driver.findElements(By.xpath(strTableClass+"//td[@class='selenium_qtitle']//a"));
		for(WebElement ques:questionName){
			questions.add(ques);
		}		
		for(WebElement quest:questions){
			ResultUtil.reportWithoutScreenshot("MESSAGE","Question- "+quest.getText());
			Link.click("Question Name ",quest, driver);
			verifyMaximumPointPotentialScore();
			verifyPointsEarnedScore();
			Sync.waitForFrame(driver, "First Iframe", 0, 3);
		}
	}
	
	//Description:verify Maximum Point Potential Score
	public void verifyMaximumPointPotentialScore(){
		ResultUtil.report("INFO", "AssignmentResultsPage >>> verifyMaximumPointPotentialScore", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForObject(driver, "Maximum Point Potential","XPATH", "//table[2]//tr[1]/td[3]");
		String strMaximumPointPotentialScore =elmntMaximumPointPotentialScore.getText();
		
		if(strMaximumPointPotentialScore.equalsIgnoreCase("1.0")){
			ResultUtil.report("MESSAGE", "Maximum Point Potential score is equal to default Value : 1.0 ["+strMaximumPointPotentialScore+"]", driver);
		}
		else{
			ResultUtil.report("MESSAGE", "Maximum Point Potential score is not equal to default Value : 1.0 ["+strMaximumPointPotentialScore+"]", driver);
		}
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}

	//Description:verify Points Earned Score
    public void verifyPointsEarnedScore(){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> verifyPointsEarnedScore", driver);
    	driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    	Sync.waitForObject(driver,"Points Earned Score- ","XPATH", "//table[2]//tr[2]/td[3]");
    	String strPointsEarnedScore = elmntPointsEarnedScore.getText();
    	
    	if(strPointsEarnedScore.equalsIgnoreCase("0")){
    		ResultUtil.report("MESSAGE", "Student not Earned score : ["+strPointsEarnedScore+"]", driver);
		}
    	else{
			ResultUtil.report("MESSAGE", "Student Earned some score : ["+strPointsEarnedScore+"]", driver);
		}
    	this.driver.close();
    	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	}
    
    //Description:Click the Question link For Student GradeBook Assignment
    public void clickQuestionLinkGradeBook(Map<String,String> dataMap) throws InterruptedException{
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> clickQuestionLinkGradeBook", driver);
    	String strQuestionName=dataMap.get("QuestionName");
    	WebElement lnkQuestionName = driver.findElement(By.xpath("//a[contains(.,'"+strQuestionName+"')]"));
    	Link.verify("Assignment Link in Second Column", lnkQuestionName, strQuestionName, driver);
   		Link.click("Assignment Link in Second Column", lnkQuestionName, driver);
    }
      
    // Description:Check check TotalTime column values
    public void checkTotalTime(String questionName){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> checkTotalTime", driver);
		WebElement elmntFirstAssingment = driver.findElement(By.xpath("//td[./a[.='"+questionName+"']]/following-sibling::td[12]"));
		String strScore= elmntFirstAssingment.getText();
		
		if(strScore.equalsIgnoreCase("auto") && strScore !=null){
			ResultUtil.report("PASS", "questionName["+questionName+"]    TotalTime value ["+strScore+"]", driver);
		}
		else{
			ResultUtil.report("FAIL", "questionName["+questionName+"]    TotalTime value ["+strScore+"]", driver);
		}
	}
   
    //Description:Verify the Name of the Assignment
    public void verifyAssignmentName(){
 		ResultUtil.reportWithoutScreenshot("INFO","AssignmentResultsPage >>> verifyAssignmentName");
 		WebElement assignmentName=driver.findElement(By.xpath(strClassContent+"//tr[1]//td[2]//span"));
 		String strAssignment=assignmentName.getText();
 		ResultUtil.report("MESSAGE",strAssignment, driver);	
 	}
 	
    //Description:Verify the Type of the Assignment
 	public void verifyAssignmentType(){
 		ResultUtil.reportWithoutScreenshot("INFO","AssignmentResultsPage >>> verifyAssignmentType");
 		WebElement assignmentType=driver.findElement(By.xpath(strClassContent+"//table//tr[2]//td[2]"));
 		String strAssignmentType=assignmentType.getText();
 		ResultUtil.report("MESSAGE", strAssignmentType, driver);
 	}
 	
 	//Description:Verify the Start and Due date of the Assignment
 	public void verifyStartandDueDate(){
 		ResultUtil.reportWithoutScreenshot("INFO","AssignmentResultsPage >>> verifyStartandDueDate");
 		WebElement eleDueDate=driver.findElement(By.xpath(strClassContent+"//tr[3]//tr[1]//td[1]"));
 		String strDueDate=eleDueDate.getText().trim();
 		ResultUtil.report("MESSAGE",strDueDate, driver);
 		WebElement eleStartDate=driver.findElement(By.xpath(strClassContent+"//table//tr[6]//td[2]"));
 		String strStartDate=eleStartDate.getText().trim();
 		ResultUtil.report("MESSAGE",strStartDate, driver);
 	}
 	
 	//Description:Verify the Complete Status Column
 	public void verifyCompleteStatus(){
		ResultUtil.report("INFO","AssignmentResultsPage >>> verifyCompleteStatus", driver);
 		WebElement eleCompleteStatus=driver.findElement(By.xpath("//div[@class='orionProgress']//b"));
 		String strCompleteStatus=eleCompleteStatus.getText().trim();
 		ResultUtil.report("MESSAGE",strCompleteStatus, driver);
	}
 	
 	//Description:Click the GradeBook BreadCrumb
 	public StudentGradeBookPage clickGradeBookBreadCrumb(){
    	ResultUtil.report("INFO","AssignmentResultsPage >>> clickGradeBookBreadCrumb", driver);
    	driver.switchTo().defaultContent();
    	try{
    	Sync.waitForFrame(driver, "IFrame", 0, 3);
    	}
    	catch(Exception e){}
    	Link.verify("GradeBook Link in BreadCrumb",gradeBookLinkBreadCrumb, driver);
    	Link.click("GradeBook Link in BraedCrumb",gradeBookLinkBreadCrumb, driver);
    	return PageFactory.initElements(driver, StudentGradeBookPage.class);
    }
        
 	//Description:Verify the Question First attempts student login
   	public void verifyFirstAttempt(){
   		ResultUtil.report("INFO","AssignmentResultsPage >>> verifyFirstAttempt", driver);
   		driver.switchTo().window(driver.getWindowHandle().toString());
      	driver.switchTo().frame(0);
      	Sync.waitForSeconds(6, driver);
      	List<WebElement> firstAttempt=driver.findElements(By.xpath("//table[contains(@class,'plain-table')]//td[contains(@class,'selenium_attempt_1')]"));
      	for(WebElement firstAttemptElement:firstAttempt){
      		String strFirstAttempt=firstAttemptElement.getText();
      		ResultUtil.report("MESSAGE","First Attempt- "+strFirstAttempt, driver);
      		
      		if(strFirstAttempt.equalsIgnoreCase("-")){
      			ResultUtil.report("MESSAGE",strFirstAttempt+"- Question Not Attempted", driver);
      		}
      		else{
      			Link.verify("First Question Attempt Link",firstAttemptElement, driver);
      			ResultUtil.report("MESSAGE",strFirstAttempt+"- Question Attempted", driver);
      		}
      	}
   	}
 	    
    //Description:Get all Questions
  	public StudentGradeBookPage getAllQuestionsForTotalTime(){
  		ResultUtil.report("INFO", "AssignmentResultsPage >>> getAllQuestionsForTotalTime", driver);
  		List<WebElement> questions=driver.findElements(By.xpath(strquestionLink));
  		for(WebElement getQuestions:questions){ 
  			String questionName=getQuestions.getText();
  			checkTotalTime(questionName);
  		}
  		return PageFactory.initElements(driver, StudentGradeBookPage.class);
  	}
 	
    //Description:Get all Questions verify score values for each question, questionLink , Total score
  	public StudentGradeBookPage getAllQuestionsAndVerifyScore(){
  		ResultUtil.report("INFO", "AssignmentResultsPage >>> getAllQuestionsAndVerifyScore", driver);
  		List<WebElement> questions=driver.findElements(By.xpath(strquestionLink));
  		int totalScore=0;
  		for(WebElement getQuestions:questions){ 
  			totalScore=totalScore+1;
  			String questionName=getQuestions.getText();
  			verifyScore(questionName);
  			isQuestionLinkActive(questionName);
  		}
  	    getTotalScore();
  		return PageFactory.initElements(driver, StudentGradeBookPage.class);
  	}
  	 	 	 	 
 	//Description:Verify the Grading type Column
 	public void verifyGradingType(Map<String,String> dataMap){
 		ResultUtil.report("INFO","AssignmentResultsPage >>> verifyGradingType", driver);
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
 		ResultUtil.report("INFO","AssignmentResultsPage >>> verifyScore", driver);
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
 	
 	//Description:verify The total Score
 	public void verifyTotalScore(){
 		ResultUtil.report("INFO","AssignmentResultsPage >>> verifyTotalScore", driver);
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
 	
 	//Description:click AllQuestion SpecificQuestions
 	public void clickAllQuestionSpecificQuestions(){
		ResultUtil.report("INFO", "AssignmentResultsPage >>> clickAllQuestionSpecificQuestions", driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 3);
		List<WebElement> questions= new ArrayList<WebElement>();
		String strQuestion=strTableClass+"//td[@class='selenium_part_title']//a";
		Sync.waitForObject(driver, "Question Name", "XPATH",strQuestion );
		List<WebElement> questionName=driver.findElements(By.xpath(strQuestion));
		for(WebElement ques:questionName){
			questions.add(ques);
		}		
		for(WebElement quest:questions){
			Sync.waitForObject(driver, "Question Name", "XPATH", strQuestion);
			ResultUtil.reportWithoutScreenshot("MESSAGE","Question- "+quest.getText());
			Link.click("Question Name ",quest, driver);
			verifyMaximumPointPotentialScore();
			verifyPointsEarnedScore();
			Sync.waitForFrame(driver, "First Iframe", 0, 3);
		}
	}
 	
 	//Description:Verify the Question Link is Active or Inactive
    public void questionLinkVerify(){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> questionLinkVerifySpecificQuestions", driver);
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
    
    //Description: Validate One Assignment Representation
    public void validateOneAssignment(){
    	ResultUtil.report("INFO", "AssignmentResultsPage >>> validateOneAssignment", driver);
    	driver.switchTo().window(driver.getWindowHandle().toString());
    	Sync.waitForFrame(driver, "First Iframe", 0, 3);
    	WebElement elmntAssignmentName=driver.findElement(By.xpath("//td[.='Assignment Name:']//following-sibling::td//span"));
    	if(elmntAssignmentName.isDisplayed()){
			ResultUtil.report("PASS", "One Assignment Representation Opened"+"Assignment Name:- "+elmntAssignmentName.getText(), driver);
		}
		else{
			ResultUtil.report("FAIL", "No Assignment Represntation is displayed", driver);
		}
    }
    
    //Description: Validate One Student One Item in New Window 
  	public void validateOneStudentOneItem(){
		ResultUtil.report("INFO","GradeBookPage >>> validateOneStudentOneItem", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		String strPageTitle=driver.getTitle();
		WebElement elmntStudentName=driver.findElement(By.xpath("//select[@id='ids']//option[@selected='selected']"));
		
		if(elmntStudentName.isDisplayed()){
			ResultUtil.report("PASS", "New Modal Window Opened with one Item"+"Question Name:-"+strPageTitle, driver);
			ResultUtil.report("PASS", "One Student is Selected in ComboBox"+"Student Name:-"+elmntStudentName.getText(), driver);
		}
		else{
			ResultUtil.report("FAIL","No Window Opened For Student", driver);
		}
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
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
  	
  	//Description: Question Attempts
  	public void QuestionAttempts(Map<String,String>dataMap){
  		verifyFirstQuestionsAttempt(dataMap);
  		verifySecondQuestionsAttempt(dataMap);
  		verifyThirdQuestionsAttempt(dataMap);
  		
  	}
} 	
