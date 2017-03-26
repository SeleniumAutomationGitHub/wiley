package Pages.SnapwizIntegration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.CourseHomePage;
import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Sync;

public class ReadStudyPracticePage extends Initializer
{
	@FindBy(how = How.XPATH, using = "//div[@id='wp-page-body']//div[./b]/select")
	private WebElement elmntClassSectiondropdown;
	
	@FindBy(how = How.ID, using = "browsechapterselector")
	private WebElement elmntChooseChapterdropdown;
	
	
	@FindBy(how = How.XPATH, using = "//li[@title= 'ORION']")
	private WebElement tabOrion;	

	public ReadStudyPracticePage(WebDriver driver){
	super(driver);
	}
	
	//select 
	public CourseHomePage selectClassSectionAndChapter()
	{
		try
		{
			driver.switchTo().defaultContent();
			Sync.waitForFrame(driver, "Container Frame", "container", 6);
		}
		catch(Exception e){}	
		Combobox.selectRandomItem("Choose Chapter", elmntChooseChapterdropdown, driver);
		return PageFactory.initElements(driver, CourseHomePage.class);
	}	
	
	public WileyPlusOrionPage goToOrionTab() throws InterruptedException
	{
		try{
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			Sync.waitForFrame(driver, "Orion frame", 0, 6);
		}
		catch(Exception e){}
		Button.click("Orion tab", tabOrion, driver);
		return PageFactory.initElements(driver, WileyPlusOrionPage.class);
	}
	
}
