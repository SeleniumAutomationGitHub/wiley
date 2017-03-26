package Pages.Common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import Toolbox.ResultUtil;

public class SnapwizLogoutPage extends Initializer {
			
	@FindBy(how = How.XPATH, using = "//a[.='Log Out']")
	private WebElement elmntLogoutLink;

	public SnapwizLogoutPage(WebDriver driver){
		super(driver);
	}	
	
	//Description: LogOut Session
	public void logOutSession(){
		switchFramelogout();
		JavascriptExecutor javascriptExecutor=((JavascriptExecutor)driver);		
		javascriptExecutor.executeScript("uni_logout();");		
	}
	
	//Description: Handling Snapwiz alert
	public void SnapwizLoginPagealertHandling() throws InterruptedException{
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);
		Assert.assertEquals(alert.getText(), "Are you sure you want to log out?");
		alert.accept();		
	}
	
	//Description: Close the driver
	public void closeDriver(){
		driver.close();
	}
	
	//Description: Clear All Cookies
	public void clearAllCookies(){
		 driver.manage().deleteAllCookies();
	}
	
	//Description: Switch to userline frame for logout
	public void switchFramelogout(){
		driver.switchTo().defaultContent();
		WebDriver myFrame = driver.switchTo().frame("mainframe");
		myFrame = myFrame.switchTo().frame("userline");
	}
}
