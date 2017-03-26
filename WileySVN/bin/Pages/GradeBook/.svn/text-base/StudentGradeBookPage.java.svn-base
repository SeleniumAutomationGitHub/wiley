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
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class StudentGradeBookPage extends Initializer {
		
	public StudentGradeBookPage(WebDriver driver){
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//li[@title='Study Objectives']")
	private WebElement lnkStudyObjectives;
	
	@FindBy(how=How.XPATH,using="//span[@class='breadcrumb']//a[.='Gradebook']")
	private WebElement gradeBookLinkBreadCrumb;
	
	String raw=null;
	String strTableClass="//table[contains(@class,'plain-table')]";
	
	//Description: Select Assignment
	public AssignmentResultsPage selectAssignmentGradeBook(Map<String,String> dataMap, String strAssignmentName) throws Exception{
		ResultUtil.report("INFO","StudentGradeBookPage >>> selectAssignmentGradeBook",driver);
		String assignmentNames = dataMap.get(strAssignmentName);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		WebElement assignmentName=driver.findElement(By.xpath("//a[.='" + assignmentNames + "']"));
		Link.verify("Assignment Name ", assignmentName, driver);
		Link.click("Assignment Name ", assignmentName, driver);
		return PageFactory.initElements(driver,AssignmentResultsPage.class);
	}

	//Description:Go To AssignmentResult Page
	public AssignmentResultsPage getAssignmentResult(Map<String,String> dataMap){
		ResultUtil.report("INFO","StudentGradeBookPage >>> getAssignmentResult",driver);
		String strassignmentName=dataMap.get("FirstAssignmentName");
		Sync.waitForObject(driver, "Assignment Link", "XPATH", "//a[.='"+strassignmentName+"']");
		WebElement lnkAssingmentlink = driver.findElement(By.xpath("//a[.='"+strassignmentName+"']"));
		Link.verify("Assignment Name ", lnkAssingmentlink, driver);
		Link.click("Any Assignment Link", lnkAssingmentlink,driver);
		return PageFactory.initElements(driver, AssignmentResultsPage.class);
	}

	//Description:Click Study Objectives link 
	public GradeBookStudyObjectivePage clickStudyObjectivesPage() throws Exception {
		ResultUtil.report("INFO", "StudentGradeBookPage >>> clickStudyObjectivesPage",driver);
		Button.verify("Grade Book Study Objectives link", lnkStudyObjectives, "Study Objectives",driver);
		Button.click("Grade Book Study Objectives link", lnkStudyObjectives,driver);
		return PageFactory.initElements(driver, GradeBookStudyObjectivePage.class);
	}

	//Description:verify First Assignment Students Result
	public void verifyAssignmentStudentsResult(Map<String,String> dataMap, String strAssignmentName,String strAssignmentEarnedPoints, String strAssginmentMaximumPoints ) throws Exception{
		ResultUtil.report("INFO", "StudentGradeBookPage >>> verifyAssignmentStudentsResult",driver);
		String strFirstAssignmentName = dataMap.get(strAssignmentName);
		String strAssignment="//a[.='"+strFirstAssignmentName+"']//parent::td/following-sibling::td";
		WebElement progres=driver.findElement(By.xpath(strAssignment+"[6]//span"));
		String strprogres=progres.getText();
		System.out.println("Progress Displayed:  "+strprogres);
		if(strprogres.equals(dataMap.get("Progress"))){
			ResultUtil.report("PASS","Expected:"+dataMap.get("Progress")+"\tActual:"+strprogres, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+dataMap.get("Progress")+"\tActual:"+strprogres, driver);
		}
		WebElement  elmntRawScore=driver.findElement(By.xpath(strAssignment+"[10]//span[@class='textBlack']"));
		String strRawScore=elmntRawScore.getText();
		String[] strraw=strRawScore.split("\\/");
		String stractualScore=strraw[0];
		String strPointsActual=dataMap.get(strAssignmentEarnedPoints);
		String strMaxScore=strraw[1];
		String strPointsTotal=dataMap.get(strAssginmentMaximumPoints);
		
		//Actual Score
		if(stractualScore.equals(strPointsActual)){
			ResultUtil.report("PASS","Expected:"+strPointsActual+"\tActual:"+stractualScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+strPointsActual+"\tActual:"+stractualScore, driver);
		}
		
		//Potential Score
		if(strMaxScore.equals(strPointsTotal)){
			ResultUtil.report("PASS","Expected:"+strPointsTotal+"\tActual:"+strMaxScore, driver);
		}
		else{
			ResultUtil.report("FAIL","Expected:"+strPointsTotal+"\tActual:"+strMaxScore, driver);
		}
	}

	//Description: Back To the grade Book
	public StudentGradeBookPage clickGradeBookLink(){
		ResultUtil.report("INFO","StudentGradeBookPage >>> clickGradeBookLink",driver);
		Link.verify("GradeBook Link in BreadCrumb",gradeBookLinkBreadCrumb,driver);
		Link.click("GradeBook Link in BraedCrumb",gradeBookLinkBreadCrumb,driver);
		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}
	
    //Description:verify Progress
	public void verifyProgress(){
		ResultUtil.report("INFO","StudentGradeBookPage >>> verifyProgress",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		List<WebElement> progressGradeBookValue=driver.findElements(By.xpath(strTableClass+"//td[8]//span"));
		for(WebElement progressValue:progressGradeBookValue){
			String progress=progressValue.getText();
			ResultUtil.report("MESSAGE","Progress Value- "+progress, driver);		
		}                                 
	}
	
	//Description:verify Raw Score GradeBook
	public void verifyRawScoreGradeBook(){
		ResultUtil.report("INFO","StudentGradeBookPage >>> verifyRawScoreGradeBook",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		List<WebElement> rawScoreValue=driver.findElements(By.xpath(strTableClass+"//td[12]//span//span"));
		for(WebElement rawScore:rawScoreValue){
			
			String rawValue=rawScore.getText().trim();
			ResultUtil.report("MESSAGE","RawScore- "+rawValue, driver);
		}
	}

	//Description:verify Total Raw ScoreGradeBook
	public void verifyTotalRawScoreGradeBook(){
		ResultUtil.report("INFO","StudentGradeBookPage >>> verifyTotalRawScoreGradeBook",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		String strRawScore=strTableClass+"//tr";
		List<WebElement> totalrawScore=driver.findElements(By.xpath(strRawScore));
		int i=totalrawScore.size();
		WebElement totalRawScoreValue=driver.findElement(By.xpath(strRawScore+"["+i+"]//td[12]"));
		String strTotalRawScore=totalRawScoreValue.getText().trim();
		ResultUtil.reportWithoutScreenshot("MESSAGE","Total Raw Score- "+strTotalRawScore);
	}

	//Description:Show the result for StudyObjective  One Question
	public void clickStudyObjectiveQuestionLink(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "StudentGradeBookPage >>> clickStudyObjectiveQuestionLink",driver);
		String strQuestionName=dataMap.get("StudyobjectiveQuestionName");
		WebElement lnkQuestionName = driver.findElement(By.xpath("//a[text()='"+strQuestionName+"']"));
		Link.verify("Assignment Link in Second Column", lnkQuestionName, strQuestionName,driver);
		Link.click("Assignment Link in Second Column", lnkQuestionName,driver);
	}

	//Description:Validate the modify course mapping id process
	public void validateModifyAssignment(Map<String,String> dataMap, String strAssignmentName){
		ResultUtil.report("INFO","StudentGradeBookPage >>> validateModifyAssignment",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		String strAssignment = dataMap.get(strAssignmentName);
		
		if(Element.verify("Assignment attempt", driver, "XPATH", "//a[text()='"+strAssignment+"']")){
		ResultUtil.report("PASS", "Assignment attempted is displayed even after the course mapping Id is modified", driver);
		}
		else{
		ResultUtil.report("FAIL", "Assignment attempted is not displayed even after the course mapping Id is modified", driver);
		}
	}

	//Description:Validate the delete course mapping id process
	public void validateDeletedAssignment(Map<String,String> dataMap, String strAssignmentName){
		ResultUtil.report("INFO","StudentGradeBookPage >>> validateDeletedAssignment",driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		String strAssignment = dataMap.get(strAssignmentName);
		
		if(Element.notVerify("Assignment attempt", driver, "XPATH", "//a[text()='"+strAssignment+"']")){
			ResultUtil.report("PASS", "Assignment attempted is not displayed even after the course mapping Id is deleted", driver);
		}
		else{
			ResultUtil.report("FAIL","Assignment attempted is displayed even after the course mapping Id is deleted" , driver);
		}
	}

	public void verifyTotalRawScore(){
		ResultUtil.report("INFO","StudentGradeBookPage >>> verifyRawScoreGradeBook",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
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

	}
	
	
	//Description: Verify the Student gradeBook Tab
	public void ValidateGradeBookTab(){
		ResultUtil.report("INFO","StudentGradeBookPage >>> ValidateGradeBookTab",driver);
		driver.switchTo().window(driver.getWindowHandle().toString());
		Sync.waitForFrame(driver, "First Iframe", 0, 2);
		List<WebElement> elmntAssignment=driver.findElements(By.xpath(strTableClass+"//td[2]//a"));
		int AssignmentCount=elmntAssignment.size();
		
		if(AssignmentCount>=1){
			ResultUtil.report("PASS", "GradeBook Page opened With List of Assignment", driver);
		}
		else{
			ResultUtil.report("FAIL", "GradeBook Page opened without list of Assignment", driver);
		}
	}
	
	
}
