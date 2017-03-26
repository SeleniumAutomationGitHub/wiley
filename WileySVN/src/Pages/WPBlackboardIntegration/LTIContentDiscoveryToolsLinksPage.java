package Pages.WPBlackboardIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class LTIContentDiscoveryToolsLinksPage
{
private final WebDriver driver;
	
@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='Content Links']")
private WebElement elmntContentLink;
	
@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='Active Class']")
private WebElement elmntActiveClassLink;
	
@FindBy(how = How.XPATH, using = "//input[@value='Add Content']")
private WebElement elmntAddContentBtn;
	
@FindBy(how = How.NAME, using = "name")
private WebElement elmntNameTextBox;
	
@FindBy(how = How.NAME, using = "description")
private WebElement elmntDescriptionTextBox;
	
@FindBy(how = How.ID, using = "parent")
private WebElement elmntParentDropdown;
	
@FindBy(how = How.ID, using = "type-wp4-tools")
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
	
@FindBy(how = How.XPATH, using = "//input[@type='submit']")
private WebElement elmntSavebtn;
	
@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
private WebElement elmntCancelbtn;
	
@FindBy(how = How.XPATH, using = "//select[starts-with(@name,'order_')]")
private WebElement elmntOrderDropdown;
	
	    public LTIContentDiscoveryToolsLinksPage(WebDriver driver){
		this.driver=driver;
	    }
	
	//Description:Tool links - Active class sub tab
public void toolsLinkActiveClassHomePage()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>toolsLinkActiveClassHomePage", driver);
		Element.verify("Active class Tab", elmntActiveClassLink, driver);
	    }
	
	//Description:Click Add content button
public void goToAddContent()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>addContentButton", driver);
		switchFrameCourseListTable();
		Button.click("Add Content", elmntAddContentBtn, driver);
		Sync.waitForSeconds(7, driver);
	    }
	
	//Description:Validate Add content GUI page for Active class add content
public void validateAddContenPage(Map<String,String> dataMap)
	    {			
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>validateAddContenPage", driver);
		Element.verify("Name Textbox", elmntNameTextBox, driver);
		Element.verify("Description textbox", elmntDescriptionTextBox, driver);
		Element.verify("Parent dropdown", elmntParentDropdown, driver);
		Element.verify("Item type dropdown", elmntItemTypeDropdown, driver);
		Element.verify("File Upload", elmntFileUploadbtn, driver);			
		//Icon image
		Element.verify("Icon", driver.findElement(By.id("default_icon")), driver);
	    }
	
	//Description:Enter valid credentials in add content area
public void addToolAreaValues(Map<String,String> dataMap) throws InterruptedException
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>addToolAreaValues", driver);
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
		String strNameEntered = elmntNameTextBox.getText();
		String strEnteredName = dataMap.put("EnteredName", strNameEntered);
	    }
			
	//Description:Save Settings
public void saveSettings()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>saveSettings", driver);
		Button.click("Save", elmntSavebtn, driver);
		Sync.waitForSeconds(5, driver);
	    }
			
	//Description:Cancel Settings
public void cancelSettings()
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>cancelSettings", driver);
		Button.click("Cancel", elmntCancelbtn, driver);
		Sync.waitForSeconds(5, driver);
	    }
			
	//Description:Verify the value in content link table
public void validateActiveClassTable(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>validateActiveClassTable", driver);
		String strEnteredName = dataMap.get("EnteredName");
		String strName = dataMap.get("AddContentName");
		String strParentDropdown = dataMap.get("ParentDropdown");
		String strItemTypeDropdown = dataMap.get("ItemtypeDropdown");
		if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
		{
		ResultUtil.report("PASS", "Added content is displayed in the Active class  table", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
		Element.verify("Item drop down", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]/td[text()='"+strItemTypeDropdown+"']")), driver);				
		}
		else
		{
		ResultUtil.report("Fail", "Added content is not displayed in the Active class  table", driver);
		}
	    }
	
	//Description:Click tool link to edit
public void editToolLink(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>editContentLink", driver);			
		String strName = dataMap.get("AddContentName");
		if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
		{
		ResultUtil.report("PASS", "Link is displayed to Edit", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
		Link.click("Tool link", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
		Sync.waitForSeconds(7, driver);
		}
		else
		{
		ResultUtil.report("Fail", "Added content is not displayed in the content table", driver);
		}
	    }
	
	//Description:Validate Edit Tool area function
public void editToolLinkValues(Map<String,String> dataMap) throws InterruptedException
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>editContentValues", driver);
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
		chooseFile(dataMap.get("EditIconPath"));
		String strEnteredName = dataMap.put("EnteredName", elmntNameTextBox.getText());
	    }
	
	//Description:Verify the value in Tool  link table
public void validateEditToolsLinkTable(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>validateEditToolsLinkTable", driver);
		String strName = dataMap.get("EditContentName");
		String strDescription = dataMap.get("EditContentDescription");
		String strParentDropdown = dataMap.get("EditParentDropdown");
		String strItemTypeDropdown = dataMap.get("EditItemtypeDropdown");
		String strEnteredName = dataMap.get("EnteredName");
		String strIconPath = dataMap.get("EditIconPath");	
		if(Element.verify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
		{
		ResultUtil.report("PASS", "Edited content is displayed in the active class table", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
			/**commented the fields is not editable mode**/
			//Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strEnteredName+"']]/td[text()='"+strItemTypeDropdown+"']")), driver);				
		}
		else
		{
			ResultUtil.report("Fail", "Edited content is not displayed in the active class  table", driver);
		}
        }
	
	//Description:Choose file functionality
public void chooseFile(String strPathName) throws InterruptedException
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>chooseFile", driver);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(strPathName);
		Sync.waitForSeconds(7, driver);			
	    }
	
	//Description:Reordering functions
public void toolLinkReordering(Map<String,String> dataMap,String strAddedToolLinkOrder , String strEditedToolLinkOrder)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>toolLinkReordering", driver);
        if(strAddedToolLinkOrder.equalsIgnoreCase(strEditedToolLinkOrder))
		{
		ResultUtil.report("FAIL", "The Order doesn't change.", driver);
		}
		else
		{
		ResultUtil.report("PASS", "The Order has change.", driver);
		}
        }

	//Description:Delete the content
public void deleteToolLink(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>deleteToolLink", driver);
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
	
	//Description:Get added content order status
public String orderAddedToolLink(Map<String,String> dataMap)
	    {
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>orderAddedToolLink", driver);
		String strName = dataMap.get("AddContentName");
		Select selectContent = new Select(driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//select[starts-with(@name,'order_')]")));
		WebElement selectOptionByDefault = selectContent.getFirstSelectedOption();
		String strAddedToolLinkOrder = selectOptionByDefault.getText();
		return strAddedToolLinkOrder;
	    }
	
	//Description:Get Edited content order status
public String orderEditedToolLink(Map<String,String> dataMap)
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
	
	//Description:Verify the value in content link table on cancel
public void validateActiveClassTableOnCancel(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>validateActiveClassTableOnCancel", driver);
		String strName = dataMap.get("AddContentName");
		String strParentDropdown = dataMap.get("ParentDropdown");
		String strItemTypeDropdown = dataMap.get("ItemtypeDropdown");
		if(Element.notVerify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
		{
		ResultUtil.report("FAIL", "Added content is displayed in the Active class  table", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
		Element.verify("Item drop down", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]/td[text()='"+strItemTypeDropdown+"']")), driver);				
		}
		else
		{
		ResultUtil.report("PASS", "Added content is not displayed in the Active class  table", driver);
		}
		}
		
		//Description:Verify the value in Tool  link table
public void validateEditToolsLinkTableOnCancel(Map<String,String> dataMap)
{
		ResultUtil.report("INFO", "LTIContentDiscoveryToolsLinksPage>validateEditToolsLinkTableOnCancel", driver);
		String strName = dataMap.get("EditContentName");
		String strDescription = dataMap.get("EditContentDescription");
		String strParentDropdown = dataMap.get("EditParentDropdown");
		String strItemTypeDropdown = dataMap.get("EditItemtypeDropdown");
		String strEnteredName = dataMap.get("EnteredName");
		String strIconPath = dataMap.get("EditIconPath");	
		if(Element.notVerify("Content", driver, "XPATH", "//table/tbody/tr[.//a[text()='"+strName+"']]"))
		{
		ResultUtil.report("FAIL", "Edited content is displayed in the active class table", driver);
		Element.verify("Name", driver.findElement(By.xpath("//table/tbody/tr[.//a[text()='"+strName+"']]//a[text()='"+strName+"']")), driver);
		}
		else
		{
		ResultUtil.report("PASS", "Edited content is not displayed in the active class  table", driver);
		}
	}
}
