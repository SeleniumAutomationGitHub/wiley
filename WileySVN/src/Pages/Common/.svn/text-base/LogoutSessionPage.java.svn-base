package Pages.Common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.CourseAdmin.ReInstructorLoginPage;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class LogoutSessionPage extends Initializer{
		
	public LogoutSessionPage(WebDriver driver){
		super(driver);
	}	
	
	//Description: Logout Session
	public void logOutSession(){
		ResultUtil.report("INFO","LogoutSessionPage >>> logOutSession", driver);
		try{
			driver.switchTo().window(driver.getWindowHandle().toString());
			Sync.waitForFrame(driver, "IFrame",0, 2);
		}
		catch(Exception e){}
		Sync.waitForObject(driver, "Logout Link", "XPATH", "//a[.='Log Out']");
		driver.findElement(By.xpath("//a[.='Log Out']")).click();
		driver.switchTo().alert().accept();
		Browser.clearAllCookies(driver);
	}
		
	//Description: Alert Handling without clear cookies and closing driver
	public ReInstructorLoginPage handleCourseAdminAlert(){
		ResultUtil.report("INFO","LogoutSessionPage >>> handleCourseAdminAlert", driver);
		Alert alert = driver.switchTo().alert();
		ResultUtil.report("MESSAGE", alert.getText(), driver);
		Assert.assertEquals(alert.getText(), "Are you sure you want to log out?");
		alert.accept();		
		return PageFactory.initElements(driver, ReInstructorLoginPage.class);
	}
}
