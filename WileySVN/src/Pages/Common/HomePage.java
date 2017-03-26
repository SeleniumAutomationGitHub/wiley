package Pages.Common;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


//import screens.Button;
import Toolbox.Button;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class HomePage extends Initializer{

	@FindBy(how = How.NAME, using = "name")
	private WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//div[@id='login-btn']/a")
	private WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//div[@id='mwp-login-button-wrapper']/a")
	private WebElement btnStudentLogin;

	@FindBy(how = How.XPATH, using = "//div[@id='mwp-login-button-wrapper']/a")
	private WebElement btnDomainOwnerLogin;
	
	@FindBy(how=How.NAME,using="passwordText")
	private WebElement passwordAfterFocus;

	@FindBy(how=How.XPATH,using="//a[@id='mwp-login-button']")
	private WebElement btnSpecificLogin;

	public HomePage(WebDriver driver){
		super(driver);
	}

	//Description: Edugen login
	public CourseSelectionPage login(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "HomePage>Login", driver);
		String struserName=dataMap.get("Email");
		String strpassword=dataMap.get("Password");
		TextBox.enterValue("Email", txtEmail, struserName, driver);
		TextBox.enterValue("Password", passwordAfterFocus, strpassword, driver);
		Button.click("Click Button", btnLogin, driver);
    	return PageFactory.initElements(driver, CourseSelectionPage.class);
	}

	//Description: Domain owner Login
	public CourseHomePage domainOwnerLogin(Map<String,String> dataMap) throws Exception{	
		String strUserName=dataMap.get("DomainOwner");
		String strPassword=dataMap.get("DomainPwd");
		TextBox.enterValue("Email", txtEmail, strUserName, driver);	 
		TextBox.enterValue("Password", txtPassword, strPassword, driver);
		Button.click(" Button", btnDomainOwnerLogin, driver);
		return PageFactory.initElements(driver, CourseHomePage.class);
	}

	//Description: Student Login
	public StudentHomepage studentLogin(Map<String,String> dataMap, String strUserName, String strPassword) throws InterruptedException{
		String _userName=dataMap.get(strUserName);
		String _password=dataMap.get(strPassword);
		TextBox.enterValue("Email", txtEmail, _userName, driver);
		TextBox.verifyValue("Email", txtEmail, _userName, driver);
		TextBox.enterValue("Password", txtPassword, _password, driver);
		Button.click("Click Button", btnStudentLogin, driver);
		return PageFactory.initElements(driver, StudentHomepage.class);
	}

	//Description: Algorithmic domain login
	public void algorithmicLogin(Map<String,String> dataMap){
		String strUserName=dataMap.get("DomainOwner");
		String strPassword=dataMap.get("DomainPwd");
		TextBox.enterValue("Email", txtEmail, strUserName, driver);	 
		TextBox.enterValue("Password", txtPassword, strPassword, driver);
		Button.click(" Button", btnDomainOwnerLogin, driver);
	}

	//Description: Edugen login
	public void loginB(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "HomePage>>>Login", driver);
		String _userName=dataMap.get("Email B");
		String _password=dataMap.get("Password B");
		TextBox.enterValue("Email", txtEmail, _userName, driver);
		TextBox.enterValue("Password", txtPassword, _password, driver);
		Button.click("Click Button", btnLogin, driver);
	}

	//Description: Specific Instructor Login
	public void specificInstructorLogin(Map<String,String> dataMap){
		ResultUtil.report("INFO","HomePage >>> specificInstructorLogin", driver);
		String strUserName=dataMap.get("InstructorEmail");
		String strPassword=dataMap.get("InstructorPassword");
		Sync.waitForObject(driver, "Email Field", "XPATH", "//input[@name='name']");
		TextBox.enterValue("Email Field",txtEmail, strUserName, driver);
		TextBox.enterValue("Password Field",txtPassword, strPassword, driver);
		Button.click("Log In", btnSpecificLogin, driver);
	}
}
