package Pages.Common;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.SnapwizIntegration.EcollegeHomePage;
import Toolbox.Button;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class EcollegeLoginPage extends Initializer {

	@FindBy(how = How.NAME, using = "Username")
	private WebElement txtEcollegeEmail;

	@FindBy(how = How.NAME, using = "Password")
	private WebElement txtEcollegePassword;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement btnEcollegeLogin;

	public EcollegeLoginPage(WebDriver driver){
	super(driver);
	}

	//Description: Login as instructor in Ecollege course
	public EcollegeHomePage eCollegeInstructorLogin(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "EcollegeLoginPage>eCollegeLogin", driver);
		String strUserName=dataMap.get("EcollegeInstructorUsername");
	    String strPassword=dataMap.get("EcollegeInstructorPassword");
	    Link.click("Login Link", driver.findElement(By.xpath("//a[text()='Login']")), driver);
	    TextBox.enterValue("Email", txtEcollegeEmail, strUserName, driver);
	    TextBox.enterValue("Password", txtEcollegePassword, strPassword, driver);
	    Button.click("Click Button", btnEcollegeLogin, driver);
	    return PageFactory.initElements(driver, EcollegeHomePage.class);
	}
	
	//Description: Login as Student in Ecollege course
	public EcollegeHomePage eCollegeStudentLogin(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "EcollegeLoginPage>eCollegeStudentLogin", driver);
		String strUserName=dataMap.get("EcollegeStudentUsername");
	    String strPassword=dataMap.get("EcollegeStudentPassword");	    
	    Link.click("Login Link", driver.findElement(By.xpath("//a[text()='Login']")), driver);
	    TextBox.enterValue("Email", txtEcollegeEmail, strUserName, driver);
	    TextBox.enterValue("Password", txtEcollegePassword, strPassword, driver);
	    Button.click("Click Button", btnEcollegeLogin, driver);
	    return PageFactory.initElements(driver, EcollegeHomePage.class);
	}
}
