package Pages.SnapwizIntegration;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class SnapwziCoursesListPage extends Initializer 
{
	public SnapwziCoursesListPage(WebDriver driver)
	{
		super(driver);
	}
	
	public CoursePropertiesPage validateCoursesList(Map<String,String> dataMap)
	{	
		ResultUtil.report("INFO", "SnapwziCoursesListPage>validateCoursesList", driver);
		String strCourseName = dataMap.get("CourseName");
		switchFrameCourseListTable();
		String strListofCoursesXpath= "//table//tbody[./tr/td[.='Course Name']]/tr[not(.//td[.//img])]";
		List<WebElement>  elmntlistOfCourses = driver.findElements(By.xpath(strListofCoursesXpath));
		//Selecting the given course
		for(int i=3;i<elmntlistOfCourses.size();i++)
		{
			WebElement elmntCourseNameList = driver.findElement(By.xpath(strListofCoursesXpath+"["+i+"]//td[2]"));
			if(elmntCourseNameList.getText().equals(strCourseName))
			{
				WebElement elmntCourseName = driver.findElement(By.xpath("//table//tbody[./tr/td[.='Course Name']]/tr[./td[@class='admtd']]/td[./a]/a[text()='"+strCourseName+"']"));
				elmntCourseName.click();		
				break;
			}	
		}
		return PageFactory.initElements(driver, CoursePropertiesPage.class);
	}
	
	//Switch to Work frame table
	public void switchFrameCourseListTable()
	{
		Sync.waitForFrame(driver, "MainFrame", "mainframe", 6);
		Sync.waitForFrame(driver, "userframe", "userframe", 5);
		Sync.waitForFrame(driver, "Workframe", "workframe", 4);
	}
}
