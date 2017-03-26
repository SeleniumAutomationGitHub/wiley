package Pages.WPBlackboardIntegration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Toolbox.Button;
import Toolbox.ResultUtil;
import Toolbox.Sync;

public class ConfigurationPage {
	private final WebDriver driver;
	
@FindBy(how = How.XPATH, using = "//td[./span[text()='LTI']]//span")
private WebElement elmntLTISubTab;
	
@FindBy(how = How.XPATH, using = "//td[./span[@class='accesstab']]/span[text()='LTI Content Discovery']")
private WebElement elmntLTIContentDiscoveryTab;
	
public ConfigurationPage(WebDriver driver){
		this.driver=driver;
	}
	
	//Description:Go To LTI Sub-tab
public LTIConfigurationPage goToLTISubTab(){
		ResultUtil.report("INFO", "LTIConfigurationPage>goToLTISubTab", driver);
		switchFrameNavigationBar();
		Button.click("LTI Tab", elmntLTISubTab, driver);
		Sync.waitForSeconds(5, driver);
		return PageFactory.initElements(driver, LTIConfigurationPage.class);
	}
	
	//Description:Go To LTI Content Discovery sub-tab
public LTIContentDiscoveryContentLinksPage goToLTIContentDiscoverySubTab()
	{
		ResultUtil.report("INFO", "LTIConfigurationPage>goToLTIContentDiscoverySubTab", driver);
		switchFrameNavigationBar();
		Button.click("LTI Tab", elmntLTIContentDiscoveryTab, driver);
		Sync.waitForSeconds(5, driver);		
		return PageFactory.initElements(driver, LTIContentDiscoveryContentLinksPage.class);
	}
	
	//Description:Switch to navigator frame
public void switchFrameNavigationBar(){
		WebDriver myFrame = driver.switchTo().frame("mainframe");
		myFrame = myFrame.switchTo().frame("userframe");
		myFrame = myFrame.switchTo().frame("navigator");
	}
}
