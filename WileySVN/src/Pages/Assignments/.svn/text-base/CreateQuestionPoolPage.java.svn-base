package Pages.Assignments;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class CreateQuestionPoolPage extends Initializer {
	
	
	
	
	@FindBy(how = How.XPATH, using ="//table[2]//tr/td[text()='Pool Name']//following-sibling::td[./input[@class= 'input200']]//input")
	private WebElement txtPoolName;
	
	@FindBy(how = How.ID, using = "applyFilters")
	private WebElement btnGo;
	
	public CreateQuestionPoolPage(WebDriver driver){
		super(driver);
	}
	
	//Description: To define input pool
	public void inputDefinePool(Map<String,String> dataMap){
		ResultUtil.report("INFO", "CreateQuestionPoolPage>>>inputDefinePool",driver);
		String strPoolName = dataMap.get("PoolName");
		TextBox.clearValue("Pool Name", txtPoolName,driver);
		TextBox.enterValue("Pool Name", txtPoolName, strPoolName,driver);
	}
	
	//Description: Verifying the select question tab
	public void verifySelectQuestionTab(){
		ResultUtil.report("INFO", "CreateQuestionPoolPage>>>verifySelectQuestion",driver);
		WebElement selectQuestions = driver.findElement(By.xpath("//div[@class='title'][.='2. Select Questions']"));
		String strSelectQuestion = "2. Select Questions";
		Element.verify("Select Question Tab", selectQuestions, strSelectQuestion,driver);
	}
	
	//Description: Clicking on go button
	public void selectQuestionGoButton(){
		ResultUtil.report("INFO", "CreateQuestionPoolPage>>>selectQuestionGoButton",driver);
		Button.click("Go Button", btnGo,driver);
		
	}
	
	//Description: Verifying the organize question tab
	public void verifyOrganizeQuestion(){
		ResultUtil.report("INFO", "CreateQuestionPoolPage>>>verifyOrganizeQuestion",driver);
		WebElement organizeQuestions = driver.findElement(By.xpath("//div[@class='title'][.='3. Organize Questions']"));
		String strOrganizeQuestion = "3. Organize Questions";
		Element.verify("Select Question Tab", organizeQuestions, strOrganizeQuestion,driver);
	}	
}
