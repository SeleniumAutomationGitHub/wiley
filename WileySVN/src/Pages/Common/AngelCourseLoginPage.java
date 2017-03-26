package Pages.Common;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Pages.SnapwizIntegration.AngelHomePage;
import Toolbox.Button;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class AngelCourseLoginPage extends Initializer {

	@FindBy(how = How.NAME, using = "username")
	private WebElement txtAngelEmail;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtAngelPassword;

	@FindBy(how = How.XPATH, using = "//input[contains(@value,'Log On')]")
	private WebElement btnAngelLogin;
	
	public AngelCourseLoginPage(WebDriver driver){
		super(driver);
	}

	//Description: Login as instructor in Angel course
	public AngelHomePage angelInstructorLogin(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AngelCourseLoginPage>>>angelInstructorLogin", driver);
		String strUserName=dataMap.get("AngelInstructorUsername");
	    String strPassword=dataMap.get("AngelInstructorPassword");
	    switchFrameToContent();
	    TextBox.enterValue("Email", txtAngelEmail, strUserName, driver);
	    TextBox.enterValue("Password", txtAngelPassword, strPassword, driver);
	    Button.click("Click Button", btnAngelLogin, driver);
	    return PageFactory.initElements(driver, AngelHomePage.class);
	}
	
	//Description: Login as Student in Angel course
	public AngelHomePage angelStudentLogin(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "AngelCourseLoginPage>>>angelStudentLogin", driver);
		String strUserName=dataMap.get("AngelStudentUsername");
	    String strPassword=dataMap.get("AngelStudentPassword");	    
	    switchFrameToContent();
	    TextBox.enterValue("Email", txtAngelEmail, strUserName, driver);
	    TextBox.enterValue("Password", txtAngelPassword, strPassword, driver);
	    Button.click("Click Button", btnAngelLogin, driver);
	    return PageFactory.initElements(driver, AngelHomePage.class);
	}
	
	//Description: Switch to content frame
	public void switchFrameToContent(){
		ResultUtil.report("INFO", "AngelCourseLoginPage>>>switchFrameToContent", driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentWin");
	}
}
