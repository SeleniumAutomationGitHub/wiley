package Pages.Assignments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Pages.Common.Initializer;
import Toolbox.Combobox;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class StudentReadStudyPracticePage extends Initializer {
	
	@FindBy(how =How.ID, using = "soSelector")
	private WebElement soSelector;
	
	@FindBy(how =How.ID, using = "browsechapterselector")
	private WebElement  browseChapterSelector;
	
	@FindBy(how = How.XPATH, using ="//tr/td//a[.='Study Objective Exercises']")
	private WebElement soExercises;
	
	public StudentReadStudyPracticePage(WebDriver driver){
		super(driver);
	}
	
	
	//Description: Select Study Objective from the objective list
	public void selectStudyObjective(Map<String,String> dataMap){		
		ResultUtil.report("INFO", "StudentReadStudyPracticePage>>>selectStudyObjective", driver);		
		String strStudyObjective = dataMap.get("StudyObjective");		
		Combobox.selectItemByValue("Study Objectives", soSelector, strStudyObjective, driver);		
	}
	
	//Description: Select chapter from the dropdown
	public void selectBrowseChapter(Map<String,String> dataMap){		
		ResultUtil.report("INFO", "StudentReadStudyPracticePage>>>selectBrowseChapter", driver);		
		String strBrowseChapter = dataMap.get("StudyObjectiveChapter");		
		Combobox.selectItemByValue("Browse Chapter", browseChapterSelector, strBrowseChapter, driver);		
	}
	
	//Description: Select Study Objective link from the chapter list
	public void selectStudyObjectiveLink(){		
		ResultUtil.report("INFO", "StudentReadStudyPracticePage>>>selectStudyObjectiveLink", driver);		
		driver.switchTo().frame("studentLwsFrame");		
		Link.click("Study Objective Exercises", soExercises, driver);		
	}
}
