package Pages.SnapwizIntegration;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Pages.Common.StudentHomepage;
import Toolbox.Button;
import Toolbox.Element;
import Toolbox.ResultUtil;


public class StudentViewChooseClassSection extends Initializer 
{

	public StudentViewChooseClassSection(WebDriver driver)
	{
		super(driver);
	}
	
	public StudentHomepage chooseClassSection(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "StudentViewChooseClassSection>chooseClassSection", driver);
		//list of class sections
		String strClassSectionName = dataMap.get("ClassSection");
		String strSectionXpath= "//table[./tbody[./tr/td[text()='"+strClassSectionName+"']]]//tr";
		List<WebElement> classSectionslist = driver.findElements(By.xpath(strSectionXpath));
		System.out.println(classSectionslist.size());
		
		if(Element.verify("Class Section Name", driver, "XPATH", strSectionXpath+"[./td[text()='"+strClassSectionName+"']]/td[2]"))
		{
			ResultUtil.report("PASS", "Class section name is displayed", driver);
			WebElement elmntGoButton = driver.findElement(By.xpath(strSectionXpath+"[./td[text()='"+strClassSectionName+"']]//a"));
			Button.click("Go", elmntGoButton, driver);
			
		}
		else
		{
			ResultUtil.report("FAIL", "Class section name is not displayed", driver);
		}
		return PageFactory.initElements(driver, StudentHomepage.class);
	}
}
