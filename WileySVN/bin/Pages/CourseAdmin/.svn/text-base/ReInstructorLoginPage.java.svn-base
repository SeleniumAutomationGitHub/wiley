package Pages.CourseAdmin;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Toolbox.Button;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class ReInstructorLoginPage
{
	private final WebDriver driver;

@FindBy(how = How.NAME, using = "name")
	private WebElement txtEmail;

@FindBy(how = How.NAME, using = "password")
	private WebElement txtPassword;

@FindBy(how = How.ID, using = "mwp-login-button")
private WebElement btnLogin;

	public ReInstructorLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void reInstructorLogin(Map<String,String> dataMap) throws InterruptedException
	{
		ResultUtil.report("INFO", "ReInstructorLoginPage>reInstructorLogin", driver);
		String _userName=dataMap.get("RemoveInstructorMailID");
	    String _password=dataMap.get("RemoveInstrutorPwd");
	    TextBox.enterValue("Email", txtEmail, _userName, driver);
	    TextBox.enterValue("Password", txtPassword, _password, driver);
	    Button.click("Click Button", btnLogin, driver);
	    WebElement elmntAccessVerify = driver.findElement(By.xpath("//p[text()='You do not have access to this Course.']"));
	    String strNoAccess = "You do not have access to this Course.";
	    Element.verify("Course access", elmntAccessVerify, strNoAccess, driver);	    
	}
}
