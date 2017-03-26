package Pages.WPBlackboardIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class LTIContentDiscoveryContentLinksPage
{	
		private final WebDriver driver;
		
@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='Content Links']")
private WebElement elmntContentLink;
		
@FindBy(how = How.XPATH, using = "//input[@value='Add Content']")
private WebElement elmntAddContentBtn;
		
@FindBy(how = How.NAME, using = "name")
private WebElement elmntNameTextBox;
		
@FindBy(how = How.NAME, using = "description")
private WebElement elmntDescriptionTextBox;
		
@FindBy(how = How.ID, using = "parent")
private WebElement elmntParentDropdown;
		
@FindBy(how = How.ID, using = "type-wp4-navigationalLinks")
private WebElement elmntItemTypeDropdown;
		
@FindBy(how = How.ID, using = "all")
private WebElement elmntVisibilityAllRadioButton;
		
@FindBy(how = How.ID, using = "instructors")
private WebElement elmntVisibilityInstructorRadioButton;
		
@FindBy(how = How.ID, using = "students")
private WebElement elmntVisibilityStudentRadioButton;
		
@FindBy(how = How.XPATH, using = "//input[@type='file']")
private WebElement elmntFileUploadbtn;
		
@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Tools Links']")
private WebElement elmntToolsLinkTab;
		
@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Support/Help Links']")
private WebElement elmntSupportHelpTab;
		
@FindBy(how = How.XPATH, using = "//span[@class='accessbtn' and text()='Static BB Targets']")
private WebElement elmntStaticTargetTab;
		
@FindBy(how = How.XPATH, using = "//input[@type='submit']")
private WebElement elmntSavebtn;
		
@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
private WebElement elmntCancelbtn;
		
@FindBy(how = How.XPATH, using = "//select[starts-with(@name,'order_')]")
private WebElement elmntOrderDropdown;
		
		
public LTIContentDiscoveryContentLinksPage(WebDriver driver)
{
			this.driver=driver;
		}
		
		//Description:
public void contentLinksHomePage()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>contentLinksHomePage", driver);
			Sync.waitForSeconds(3, driver);
			try
			{
				switchFrameCourseListTable();
			}
			catch(Exception e){}
		}
		
		//Description:Click "Add Content" button
public void goToAddContent()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>goToAddContent", driver);
			switchFrameCourseListTable();
			Button.click("Add Content", elmntAddContentBtn, driver);
			Sync.waitForSeconds(7, driver);
		}	
		
		//Description:Validate Add content GUI page
public void validateAddContenPage()
		{			
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>validateAddContenPage", driver);
			Element.verify("Name Textbox", elmntNameTextBox, driver);
			Element.verify("Description textbox", elmntDescriptionTextBox, driver);
			Element.verify("Parent dropdown", elmntParentDropdown, driver);
			Element.verify("Item type dropdown", elmntItemTypeDropdown, driver);
			Element.verify("File Upload", elmntFileUploadbtn, driver);			
			//Icon image
			Element.verify("Icon", driver.findElement(By.id("default_icon")), driver);
		}
		
		//Description:Enter valid credentials in add content area
public void addContentAreaValues(Map<String,String> dataMap) throws InterruptedException
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>addContentAreaValues", driver);
			String strName = dataMap.get("AddContentName");
			String strDescription = dataMap.get("AddContentDescription");
			String strParentDropdown = dataMap.get("ParentDropdown");
			String strItemTypeDropdown = dataMap.get("ItemtypeDropdown");
			String strIconPath = dataMap.get("IconPath");			
			
			TextBox.enterValue("Name", elmntNameTextBox, strName, driver);
			TextBox.enterValue("Description", elmntDescriptionTextBox, strDescription, driver);
			Combobox.selectItemByValue("Parent", elmntParentDropdown, strParentDropdown, driver);
			Combobox.selectItemByValue("Item type", elmntItemTypeDropdown, strItemTypeDropdown, driver);
			chooseFile(dataMap.get("IconPath"));
			String strEnteredName = dataMap.put("EnteredName", elmntNameTextBox.getText());
		}
		
		//Description:Choose file functionality
public void chooseFile(String strPathName) throws InterruptedException
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>chooseFile", driver);
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(strPathName);
			Sync.waitForSeconds(7, driver);			
			}
		
		//Description:Verify the value in content link table
public void validateContentLinkTable(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>validateContentLinkTable", driver);
			String strEnteredName = dataMap.get("EnteredName");
			String strName = dataMap.get("AddContentName");
			String strParentDropdown = dataMap.get("ParentDropdown");
			String strItemTypeDropdown = dataMap.get("ItemtypeDropdown");
			if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
			{
				ResultUtil.report("PASS", "Added content is displayed in the content table", driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]/td[text()='"+strItemTypeDropdown+"']")), driver);				
			}
			else
			{
				ResultUtil.report("Fail", "Added content is not displayed in the content table", driver);
			}
		}
		
		//Description:Click content link to edit
public void editContentLink(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>editContentLink", driver);	
			String strEnteredName = dataMap.get("EnteredName");
			String strName = dataMap.get("AddContentName");
			switchFrameCourseListTable();
			if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
			{
				ResultUtil.report("PASS", "Link is displayed to Edit", driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
				Link.click("content link", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
				Sync.waitForSeconds(7, driver);
			}
			else
			{
				ResultUtil.report("Fail", "Link is not displayed to Edit", driver);
			}
		}
		
		//Description:Validate Edit content area function
public void editContentValues(Map<String,String> dataMap) throws InterruptedException
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>editContentValues", driver);
			String strName = dataMap.get("EditContentName");
			String strDescription = dataMap.get("EditContentDescription");
			String strParentDropdown = dataMap.get("EditParentDropdown");
			String strItemTypeDropdown = dataMap.get("EditItemtypeDropdown");
			String strIconPath = dataMap.get("EditIconPath");			
			
			TextBox.clearValue("Clear the name", elmntNameTextBox, driver);			
			Sync.waitForSeconds(5, driver);
			TextBox.enterValue("Name", elmntNameTextBox, strName, driver);
			TextBox.clearValue("Description", elmntDescriptionTextBox, driver);			
			Sync.waitForSeconds(3, driver);
			TextBox.enterValue("Description", elmntDescriptionTextBox, strDescription, driver);
			Combobox.selectItemByValue("Parent", elmntParentDropdown, strParentDropdown, driver);
			Combobox.selectItemByValue("Item type", elmntItemTypeDropdown, strItemTypeDropdown, driver);
			chooseFile(dataMap.get("EditIconPath"));
			String strEnteredName = dataMap.put("EnteredName", elmntNameTextBox.getText());
		}
		
		//Description:Verify the value in content link table
public void validateEditContentLinkTable(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>validateEditContentLinkTable", driver);
			String strName = dataMap.get("EditContentName");
			String strDescription = dataMap.get("EditContentDescription");
			String strParentDropdown = dataMap.get("EditParentDropdown");
			String strItemTypeDropdown = dataMap.get("EditItemtypeDropdown");
			String strEnteredName = dataMap.get("EnteredName");
			String strIconPath = dataMap.get("EditIconPath");	
			if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
			{
				ResultUtil.report("PASS", "Edited content is displayed in the content table", driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]/td[text()='"+strItemTypeDropdown+"']")), driver);				
			}
			else
			{
				ResultUtil.report("FAIL", "Edited content is not displayed in the content table", driver);
			}
	}
				
		//Description:Save Settings
public void saveSettings()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>saveSettings", driver);
			Button.click("Save", elmntSavebtn, driver);
			Sync.waitForSeconds(5, driver);
		}
		
		//Description:Cancel Settings
public void cancelSettings()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>cancelSettings", driver);
			Button.click("Cancel", elmntCancelbtn, driver);
			Sync.waitForSeconds(5, driver);
		}
		
		//Description:Navigate to Tools link
public LTIContentDiscoveryToolsLinksPage goToToolsLinkTab()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>goToToolsLink", driver);
			switchFrameCourseListTable();
			Button.click("Tools Link", elmntToolsLinkTab, driver);
			Sync.waitForSeconds(5, driver);
			return PageFactory.initElements(driver, LTIContentDiscoveryToolsLinksPage.class);
		}
		
		//Description:Navigate to Support/Help link
public LTIContentDiscoverySupportHelpPage goToSupportHelpTab()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>goToSupportHelpTab", driver);
			switchFrameCourseListTable();
			Button.click("Support Help tab", elmntSupportHelpTab, driver);
			Sync.waitForSeconds(5, driver);
			return PageFactory.initElements(driver, LTIContentDiscoverySupportHelpPage.class);
		}
		
		//Description:Navigate to Static BB targets link
public LTIContentDiscoveryStaticTargetPage goToStaticTargetTab()
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>goToStaticTargetTab", driver);
			switchFrameCourseListTable();
			Button.click("Static target tab", elmntStaticTargetTab, driver);
			Sync.waitForSeconds(5, driver);
			return PageFactory.initElements(driver, LTIContentDiscoveryStaticTargetPage.class);
		}
		
		//Description:Reordering functions
public void ContentLinkReordering(Map<String,String> dataMap,String strAddedContentLinkOrder , String strEditedContentLinkOrder)
{
			ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>toolLinkReordering", driver);

			if(strAddedContentLinkOrder.equalsIgnoreCase(strEditedContentLinkOrder))
			{
				ResultUtil.report("FAIL", "The Order doesn't change.", driver);
			}
			else
			{
				ResultUtil.report("PASS", "The Order has change.", driver);
			}
		}
		
		//Description:Delete the content
public void deleteContent(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>deleteContent", driver);
			String strName = dataMap.get("EditContentName");
			Link.click("Delete", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='Delete']")), driver);
			Sync.waitForSeconds(7, driver);
		}
		
		//Description:Switch to Work frame table
public void switchFrameCourseListTable()
{
			driver.switchTo().defaultContent();
			WebDriver myFrame = driver.switchTo().frame("mainframe");
			myFrame = myFrame.switchTo().frame("userframe");
			myFrame = myFrame.switchTo().frame("workframe");
		}
		
		//Description:Change the content links order
public void changeContentLinksOrder()
		{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>changeContentLinksOrder", driver);
			switchFrameCourseListTable();
		}

		//Description:Verify the value in content link table
public void validateContentLinkTableOnCancel(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIContentDiscoveryContentLinksPage>validateContentLinkTableOnCancel", driver);
			String strEnteredName = dataMap.get("EnteredName");
			String strName = dataMap.get("AddContentName");
			String strParentDropdown = dataMap.get("ParentDropdown");
			String strItemTypeDropdown = dataMap.get("ItemtypeDropdown");
			if(Element.notVerify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strEnteredName+"']]"))
			{
				ResultUtil.report("PASS", "Added content is displayed in the content table", driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strEnteredName+"']]//a[text()='"+strName+"']")), driver);
				Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strEnteredName+"']]/td[text()='"+strItemTypeDropdown+"']")), driver);				
			}
			else
			{
				ResultUtil.report("Fail", "Added content is not displayed in the content table", driver);
			}
		}


		//Description:Get added content order status
public String orderAddedContentLink(Map<String,String> dataMap)
		{
			ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>orderAddedToolLink", driver);
			String strName = dataMap.get("AddContentName");
			Select selectContent = new Select(driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//select[starts-with(@name,'order_')]")));
			WebElement selectOptionByDefault = selectContent.getFirstSelectedOption();
			String strAddedToolLinkOrder = selectOptionByDefault.getText();
			return strAddedToolLinkOrder;
		}
		
		//Description:Get Edited content order status
public String orderEditedContentLink(Map<String,String> dataMap)
		{
			ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>orderEditedToolLink", driver);
			String strName = dataMap.get("EditContentName");
			Combobox.selectRandomItem("Order dropdown", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//td[.//select[starts-with(@name,'order_')]]/select")), driver);
			Sync.waitForSeconds(8, driver);
			Select selectEditContent = new Select(driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//select[starts-with(@name,'order_')]")));
			WebElement selectOptionByChange = selectEditContent.getFirstSelectedOption();
			String strEditedToolLinkOrder = selectOptionByChange.getText();
			return strEditedToolLinkOrder;
		}




}
