package Pages.Common;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Toolbox.*;

public class CourseSelectionPage extends Initializer{
		
	public CourseSelectionPage(WebDriver driver){
		super(driver);
	}
		
	//Description: Select Course
	public CourseHomePage selectCourse(Map<String,String> dataMap) throws InterruptedException{
		ResultUtil.report("INFO", "CourseSelectionPage>Select Course", driver);
		driver.switchTo().defaultContent();
		String CourseName=dataMap.get("DomainName");
		Sync.waitForObject(driver, CourseName, "xpath", "//a[contains(.,'"+CourseName+"')]");
		WebElement lnkCourse=driver.findElement(By.xpath("//a[contains(.,'"+CourseName+"')]"));
		Toolbox.Link.click("Course Name", lnkCourse, driver);
		return PageFactory.initElements(driver, CourseHomePage.class);
	}
}
