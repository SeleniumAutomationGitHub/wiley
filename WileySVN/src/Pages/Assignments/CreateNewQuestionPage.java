package Pages.Assignments;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Listbox;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class CreateNewQuestionPage extends Initializer {
	
	
		
		@FindBy(how= How.XPATH, using="//table[2]//tr/td[text()='Question Type']//following-sibling::td/select")
		private WebElement questionType;
		
		@FindBy(how = How.XPATH, using = "//table[2]//tr/td[text()='Associate with']//following-sibling::td/select")
		private WebElement associate;
		
		@FindBy(how= How.XPATH, using = "//table[2]//tr/td[text()='Study Objectives']//following-sibling::td/select")
		private WebElement studyObjectives;
		
		@FindBy(how = How.XPATH, using = "//table[2]//tr/td[text()='Difficulty level']//following-sibling::td/select")
		private WebElement difficulty;
		
		@FindBy(how = How.ID, using = "Next")
		private WebElement btnNext;
		
		@FindBy(how = How.XPATH, using = "//table[2]//tr/td[text()='Question Title']//following-sibling::td[./input[@name='q_title']]//input")
		private WebElement txtQuestionTitle;
		
		@FindBy(how = How.XPATH, using = "//table[2]//tr/td[text()='Question Text']//following-sibling::td/textarea")
		private WebElement txtQuestionText;
		
		@FindBy(how = How.ID, using = "Finish")
		private WebElement btnFinsh;
		
		public CreateNewQuestionPage(WebDriver driver){
			super(driver);
		}
	
		public void inputDescribeQuestion(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateNewQuestionPage>>>enterQuestionType",driver);
			Element.verify("Question Type", driver, "xpath", "//table[2]//tr/td[text()='Question Type']");
			String strSurvey = dataMap.get("Question Type");
			String strAssociate = dataMap.get("Associate");
			String strStudyObjectives = dataMap.get("StudyObjectives");
			String strLevel = dataMap.get("Level");
			Combobox.selectItemByValue("Survey", questionType, strSurvey,driver);
			Combobox.selectItemByValue("Associate With", associate, strAssociate,driver);
			Listbox.deselectAll(studyObjectives, "Study Objective",driver);
			Listbox.selectItemByValue("Study Objectives", studyObjectives, strStudyObjectives,driver);
			Combobox.selectItemByValue("Level", difficulty, strLevel,driver);	
		}
		
		public void selectNextButton(){
			ResultUtil.report("INFO", "CreateNewQuestionPage>>>selectNextButton",driver);
			Button.click("NextButton", btnNext,driver);
			
		}
		
		public void inputCreateQuestion(Map<String,String> dataMap){
			ResultUtil.report("INFO", "CreateNewQuestionPage>>>inputCreateQuestion",driver);
			String strQuestionTitle = dataMap.get("QuestionTitle");
			TextBox.enterValue("Question Title", txtQuestionTitle, strQuestionTitle,driver);
			String strQuestionText = dataMap.get("QuestionText");
			TextBox.enterValue("Question Text", txtQuestionText, strQuestionText,driver);
		}
		
		public void verifyQuestionAssistanceTab(){
			WebElement questionAssistance = driver.findElement(By.xpath("//div[@class='title'][.='3. Question Assistance']"));
			String strQuestionAssistance = "3. Question Assistance";
			Element.verify("Question Assistance", questionAssistance, strQuestionAssistance,driver);
		}
		
		public void verifyConfirmation(){
			WebElement confirmation = driver.findElement(By.xpath("//div[@class='title'][.='4. Confirmation']"));
			String strConfirmation = "4. Confirmation";
			Element.verify("Question Assistance", confirmation, strConfirmation,driver);	
		}
	
		public void selectFinishButton(){
			ResultUtil.report("INFO", "CreateNewQuestionPage>>>selectFinishButton",driver);
			Button.click("Finish Button", btnFinsh,driver);
		}
}
