package Pages.Common;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Pages.Assignments.CreateNewQuestionPage;
import Pages.Assignments.CreateQuestionPoolPage;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Listbox;
import Toolbox.ResultUtil;
import Toolbox.Window;

public class QuestionPage extends Initializer {
			
	@FindBy(how = How.ID, using = "Create_Question")
	private WebElement btnNewQuestion;
	
	@FindBy(how = How.ID, using = "Create_Question_Pool")
	private WebElement btnQuestionPool;
	
	@FindBy(how = How.NAME, using = "owner")
	private WebElement optionSource;
	
	@FindBy(how = How.NAME, using = "showperpage")
	private WebElement drpdownShowPerPage;
	
	@FindBy(how = How.ID, using = "applyFilters")
	private WebElement btnGo;
		
	public QuestionPage(WebDriver driver){
		super(driver);
	}
	
	String strTableClass="//table[contains(@class,'plain-table')]//tr";
	
	//Description: Go to Create NEw Question
	public CreateNewQuestionPage goToCreateNewQuestion(){
		ResultUtil.report("INFO", "QuestionPage>>>>goToCreateNewQuestion", driver);
		Button.click("Create New Question", btnNewQuestion, driver);
		return PageFactory.initElements(driver, CreateNewQuestionPage.class);
	}
	
	//Description: Go to Create Question Pool
	public CreateQuestionPoolPage goToCreateQuestionPool(){
		ResultUtil.report("INFO", "QuestionPage>>>>goToCreateQuestionPool", driver);
		Button.click("Create Question Pool", btnQuestionPool, driver);
		return PageFactory.initElements(driver, CreateQuestionPoolPage.class);
	}
	
	//Description: Go to Question List
	public void goToQuestionList(Map<String,String> dataMap){
		
		if(Element.verify("Source", driver, "NAME", "owner")){
			Listbox.deselectAll(optionSource, "All Sources", driver);		
			Listbox.selectItemByValue("Me", optionSource, "Me", driver);
		}
		String AllQuestionPerPage = dataMap.get("ShowperpageAll");
		Combobox.selectItemByValue("ShowperpageAll", drpdownShowPerPage, AllQuestionPerPage, driver);
		Button.click("Click Go", btnGo, driver);
	}
	
	//Description: verify Question DropDown
	public void verifyQuestionDropDown(){
		ResultUtil.report("INFO", "QuestionPage>>>verifyQuestionDropDown", driver);
		List<WebElement>chooseQuestion = driver.findElements(By.xpath(strTableClass));
		for(int i=2; i<chooseQuestion.size(); i++){
			WebElement previewquestion = driver.findElement(By.xpath(strTableClass+"["+i+"]//following-sibling::td//select[@class='action_combobox']"));
			String strpreview = "Preview Question";
			Combobox.selectItemByValue("Preview Question", previewquestion, strpreview, driver);
			WebElement questionGo = driver.findElement(By.xpath(strTableClass+"["+i+"]//following-sibling::td//a"));
			Button.click("Go Button", questionGo, driver);
			Window.focusWindow("Question Preview", driver, driver.getWindowHandles().toArray()[1].toString());
			this.driver.close();
		}
	}
	
	public void verifyQuestionPage(){
		ResultUtil.report("INFO", "QuestionPage>>>>verifyQuestionPage", driver);
		Button.verify("Create New Question", btnNewQuestion, driver);
		Button.verify("Create Question Pool", btnQuestionPool, driver);
	}
}
