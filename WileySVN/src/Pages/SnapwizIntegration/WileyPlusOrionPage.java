package Pages.SnapwizIntegration;

import java.util.Map;
import java.util.Random;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class WileyPlusOrionPage extends Initializer
{
	Random rand = new Random();
	
	@FindBy(how = How.XPATH, using = "//select[@name='browseclass']")
	private WebElement elmntClassSectionOrionDrowdown;	
	
	@FindBy(how = How.ID, using = "switchClass")
	private WebElement elmntGoBtn;	
	
	public WileyPlusOrionPage(WebDriver driver){
		super(driver);
	}
	
	public SnapwizOrionDashboardPage wileyPlusOrionPage(Map<String, String> dataMap)
	{
		ResultUtil.report("INFO", "WileyPlusOrionPage>wileyPlusOrionPage", driver);
		switchFrameOrionTab();
		if(Element.verify("Class Section Dropdown", driver, "NAME", "browseclass"))
		{
			ResultUtil.report("MESSAGE", "More than one class section is displayed", driver);
			selectClassSection(dataMap);			
		}
		else
		{
			ResultUtil.report("MESSAGE", "Only one class section is displayed", driver);
		}		
		return PageFactory.initElements(driver, SnapwizOrionDashboardPage.class);
	}
	
	public void selectClassSection(Map<String,String> dataMap)
	{
		ResultUtil.report("INOF", "WileyPlusOrionPage>selectClassSection", driver);
		switchFrameOrionTab();
		String strClassName = dataMap.get("ClassSection");
		Combobox.selectItemByValue("Class section orion dropdown", elmntClassSectionOrionDrowdown, strClassName, driver);
		Button.click("Go", elmntGoBtn, driver);
	}

	public void switchFrameOrionTab()
	{
		try{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Container Frame", "container", 6);		
		}
		catch(Exception e){}
	}
}
