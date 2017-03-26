package Pages.GradeBook;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Pages.Common.Initializer;
import Toolbox.Link;
import Toolbox.ResultUtil;

public class StudentGradeBookResultPage extends Initializer{
			
	public StudentGradeBookResultPage(WebDriver driver){
		super(driver);
	}

	// Description:Show the Students Question Result Page
	public AssignmentResultsPage clickStudentNameLink(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO","StudentGradeBookResultPage >>> clickStudentNameLink", driver);
		String strAssignmentName=dataMap.get("StudyObjectiveAssignmentName");
		WebElement lnkAssignmentName = driver.findElement(By.xpath("//a[contains(.,'"+strAssignmentName+"')]"));
		Link.verify("Assignment Link in Second Column", lnkAssignmentName, strAssignmentName,driver);
		Link.click("Assignment Link in Second Column", lnkAssignmentName,driver);
		return PageFactory.initElements(driver, AssignmentResultsPage.class);
	}

	//Description:Show the Study Objective Students Question Result Page
	public void clickStudyObjectiveStudentNameLink(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO","StudentGradeBookResultPage >>> clickStudyObjectiveStudentNameLink", driver);
		String strAssignmentName=dataMap.get("StudyObjectiveAssignmentName");
		WebElement lnkAssignmentName = driver.findElement(By.xpath("//a[contains(.,'"+strAssignmentName+"')]"));
		Link.verify("Assignment Link in Second Column", lnkAssignmentName, strAssignmentName,driver);
		Link.click("Assignment Link in Second Column", lnkAssignmentName,driver);
	}
}
