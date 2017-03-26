package Pages.Common;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Toolbox.Button;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class SnapwizLoginPage extends Initializer {

	@FindBy(how = How.NAME, using = "name")
	private WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtSnapPassword;

	@FindBy(how = How.NAME, using = "loginbut")
	private WebElement btnSnapLogin;

	public SnapwizLoginPage(WebDriver driver){
		super(driver);
	}

	//Description: Snap Login 
	public SnapwizHomePage snapLogin(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "SnapWizHomePage>SnapWizLogin", driver);
		String strUserName=dataMap.get("AdminUsername");
	    String strPassword=dataMap.get("AdminPassword");
	    TextBox.enterValue("Email", txtEmail, strUserName, driver);
	    TextBox.enterValue("Password", txtSnapPassword, strPassword, driver);
	    Button.click("Click Button", btnSnapLogin, driver);	    		
	    return PageFactory.initElements(driver, SnapwizHomePage.class);
	}
}
