package Pages.Common;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Toolbox.Button;
import Toolbox.Sync;
import Toolbox.TextBox;

public class StudentLoginpage extends Initializer{
		
	@FindBy (how = How.NAME, using= "name")
	private WebElement txtEmail;
	
	@FindBy (how = How.NAME, using = "password")
	private WebElement txtPassword;
	
	@FindBy (how = How.ID, using = "mwp-login-button")
	private WebElement btnLogin;
		
	public StudentLoginpage(WebDriver driver){
		super(driver);
	}
	
	//Description: Login to the student page
	public StudentHomepage loginPage(Map<String,String> dataMap) throws Exception{
		String _email = dataMap.get("StudentUsername");
		String _password = dataMap.get("StudentPassword");
		WebElement txtEmail = Sync.waitForObject(driver, "Student Email TextBox","XPATH", "//input[@name='name']");
		TextBox.enterValue("Email", txtEmail, _email, driver);
		Sync.waitForObject(driver, "Student Password TextBox","XPATH", "//input[@name='password']");
		txtPassword.click();		
		TextBox.enterValue("Password", txtPassword, _password, driver);
		Button.click("Login", btnLogin, driver);		
		return PageFactory.initElements(driver, StudentHomepage.class);		
	}
	
	//Description: Student Login Page
	public StudentHomepage loginPageStudent(Map<String,String> dataMap,String strEmail,String strPassword) throws Exception{
		String email = dataMap.get(strEmail);
		String password = dataMap.get(strPassword);
		Sync.waitForObject(driver, "Email Field", "XPATH", "//input[@name='name']");
		TextBox.enterValue("Email", txtEmail, email, driver);
		Sync.waitForObject(driver, "Password Field", "XPATH", "//input[@name='password']");
		TextBox.enterValue("Password", txtPassword, password, driver);
		Button.click("Login", btnLogin, driver);
		return PageFactory.initElements(driver, StudentHomepage.class);		
	}
}
