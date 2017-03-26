package Pages.CourseAdmin;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class AddClassSectionPage extends Initializer{
	
	@FindBy(how = How.ID, using = "section-input")
	private WebElement elmntClassNameBox;

	@FindBy(how = How.ID, using = "term-input")
	private WebElement elmntTermBox;
	
	@FindBy(how = How.XPATH, using = "//tr[./td[.='Designate yourself as an instructor in this class section']]//input")
	private WebElement elmntDesignateCheckbox;
	
	@FindBy(how = How.ID, using = "edt")
	private WebElement elmntClassSectionEndDate;
	
	@FindBy(how = How.ID, using = "Submit")
	private WebElement elmntSubmit;

	public AddClassSectionPage(WebDriver driver){
		super(driver);
	}
	
	//Enter the values in the new class section page
	public CourseAdminClassSectionPage addClassSectionName(Map<String,String> dataMap, String strClassName, String strClassTerm, String strClassEndDate) throws InterruptedException
	{
		ResultUtil.report("INFO", "AddClassSectionPage>addClassSectionName", driver);
		String strClassSectionName = dataMap.get(strClassName);
		String strClassSectionTerm = dataMap.get(strClassTerm);
		String strClassSectionEndDate = dataMap.get(strClassEndDate);
		TextBox.enterValue("Enter clas section name", elmntClassNameBox, strClassSectionName, driver);
		TextBox.enterValue("Enter Class Section Term", elmntTermBox, strClassSectionTerm, driver);
		TextBox.JSEnterValue("Enter Calendar Section end date", driver, elmntClassSectionEndDate, strClassSectionEndDate);
		if(Checkbox.isUnchecked("Validate checkbox is checked", elmntDesignateCheckbox, driver))
		{
			Checkbox.check("Select the checkbox", elmntDesignateCheckbox, driver);
		}
		else
		{
			ResultUtil.report("MESSAGE", "Designate instructor checkbox is checked already", driver);			
		}		
		Button.click("Click Submit button", elmntSubmit, driver);
		return PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
	}
	
	public void validateAddclassSectionscreen()
	{
		ResultUtil.report("INFO", "AddClassSectionPage>validateAddclassSectionscreen", driver);
		Element.verify("Add class section screen", driver, "XPATH", "//b[contains(.,'Add Class Section')]");
	}

}
