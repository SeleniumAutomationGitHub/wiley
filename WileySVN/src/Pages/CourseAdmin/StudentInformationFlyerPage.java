package Pages.CourseAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Toolbox.ResultUtil;

public class StudentInformationFlyerPage 
{
	private final WebDriver driver; 
	
	public StudentInformationFlyerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public CourseAdminClassSectionEditPage validateFlyer() throws InterruptedException
	{
		ResultUtil.report("INFO", "StudentInformationFlyerPage>validateFlyer", driver);
		this.driver.close();
		String parentWindow=driver.getWindowHandles().toArray()[0].toString();
		driver.switchTo().window(parentWindow);
		return PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
	}
}
