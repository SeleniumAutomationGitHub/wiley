package Pages.WPBlackboardIntegration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.CourseAdmin.ReInstructorLoginPage;
import Toolbox.Browser;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;


public class LTIConfigurationBlackboardConsumersPage
{
		
private final WebDriver driver;
	
@FindBy(how = How.XPATH, using = "//span[contains(@class,'accessbtn') and text()='LTI Configuration']")
private WebElement elmntLTIConfigurationTab;

@FindBy(how = How.XPATH, using = "//a[text()='View all']")
private WebElement elmntViewAllLink;

@FindBy(how = How.XPATH, using = "//a[text()='Block all']")
private WebElement elmntBlockAllLink;

@FindBy(how = How.XPATH, using = "//a[text()='Allow all']")
private WebElement elmntAllowAllLink;

@FindBy(how = How.ID, using = "sdt")
private WebElement elmntStartDate;

@FindBy(how = How.ID, using = "edt")
private WebElement elmntEndDate;

@FindBy(how = How.XPATH, using = "//input[@type='submit']")
private WebElement elmntShowbtn;

@FindBy(how = How.XPATH, using = "//input[@value='Cancel']")
private WebElement elmntCancelbtn;

@FindBy(how = How.XPATH, using = "//a[@class='titlink' and contains(text(),'Blackboard Consumers')]")
private WebElement elmntBBConsumerBackLink;

@FindBy(how = How.ID, using = "current_option")
private WebElement elmntPageLinkDropdown;


//Arrays
ArrayList<String> selectTableorder = new ArrayList<String>();
ArrayList<String> contentTableorder = new ArrayList<String>();
	
public LTIConfigurationBlackboardConsumersPage(WebDriver driver)
{
		this.driver=driver;
}		
		
		//Description:Blackboard consumers page
public void blackboardConsumersHomePage()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>blackboardConsumersHomePage", driver);
		}
		
		//Description:Blackboard consumers validation 
public void blackboardConsumersGUIvalidation(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>blackboardConsumersGUIvalidation", driver);
			String strConfirmConsumerKey = dataMap.get("ConfirmConsumerKeyFormat");
			String strConfirmInstitutionName = dataMap.get("ConfirmInstitutionNameFormat");
			String strConfirmInstallationType = dataMap.get("ConfirmConsumerKeyFormat");
			String strEmailFormat = dataMap.get("ConfirmEmailFormat");			
			//Header verification
			Element.verify("Header text", driver.findElement(By.xpath("//span[@class='pagetitle']")), "LTI (Blackboard Consumers)", driver);
			
			//Blackboard consumers 
			Element.verify("Total blackboard consumer text", driver.findElement(By.xpath("//td[contains(text(),'Total Blackboard Consumers: ')]")), driver);
			
			//Table header text			
			Element.verify("Consumer key text", driver.findElement(By.xpath("//th/strong[.='Consumer Key']")), driver);
			Element.verify("Institution Name text", driver.findElement(By.xpath("//th/strong[.='Institution Name']")), driver);
			Element.verify("Installation type text", driver.findElement(By.xpath("//th/strong[.='Installation Type']")), driver);
			Element.verify("Admin e-mail text", driver.findElement(By.xpath("//th/strong[.='Admin E-mail']")), driver);
			Element.verify("Run text", driver.findElement(By.xpath("//th/strong[.='Next Auto Grade Refresh Run']")), driver);
			Element.verify("Frequency text", driver.findElement(By.xpath("//th/strong[.='Auto Grade Refresh Frequency']")), driver);
			Element.verify("Actions  text", driver.findElement(By.xpath("//th/strong[.='Auto Grade Refresh Actions']")), driver);			
			
			//View link
			Element.verify("View Link", driver.findElement(By.xpath("//a[@class='consumer_view' and text()='View']")), driver);
			
			//Block link
			Element.verify("Block  Link", driver.findElement(By.xpath("//a[@class='consumer_block' and text()='Block']")), driver);
			
			//View all link
			Element.verify("View all Link", driver.findElement(By.xpath("//a[text()='View all']")), driver);
			
			//Block all link
			Element.verify("Block  all Link", driver.findElement(By.xpath("//a[text()='Block all']")), driver);
			
			//Allow all link
			Element.verify("Allow  all Link", driver.findElement(By.xpath("//a[text()='Allow all']")), driver);
			
			//Validate the consumer key column
			Element.verify("Consumer Key", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td[.='"+strConfirmConsumerKey+"']]/td[.='"+strConfirmConsumerKey+"']")), driver);
			
			//Validate the institution name
			Element.verify("Institution Name ", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td[.='"+strConfirmConsumerKey+"']]/td[.='"+strConfirmInstitutionName+"']")), driver);
			
			//Validate the institution name
			Element.verify("Installation type ", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td[.='"+strConfirmConsumerKey+"']]/td[.='"+strConfirmInstallationType+"']")), driver);
			
			//Validate the Email format
			Element.verify("Email format ", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td[.='"+strConfirmConsumerKey+"']]/td[.='"+strEmailFormat+"']")), driver);
			
			//Total blackboard consumer screen
			WebElement elmntTotalBBConsumerScreen = driver.findElement(By.xpath("//tr[./td[contains(text(),'Total Blackboard Consumers: ')]]//strong[1]"));
			
			//Validating the count of the consumer in table and the text in screen
			if(elmntTotalBBConsumerScreen.getText().equalsIgnoreCase(dataMap.get("TableSize")))
				{
					ResultUtil.report("PASS", "Total number of column is matches with total BB consumers", driver);
				}
			else
			{
					ResultUtil.report("FAIL", "Total number of column is not matches with total BB consumers", driver);
			}			
		}	
		
		//Description:Validate View all link
public void selectViewAllLink()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>selectViewAllLink", driver);
			Link.click("View All", elmntViewAllLink, driver);
			Sync.waitForSeconds(2, driver);
		}
		
		//Description:Validate Block All link
public void selectBlockAllLink()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>selectBlockAllLink", driver);
			Sync.waitForObject(driver, "Block All", "XPATH","//a[text()='Block all']");
			if(Element.verify("Block All", driver, "XPATH", "//a[text()='Block all']"))
			{
				ResultUtil.report("PASS","Clicked Blok All", driver);
				driver.findElement(By.xpath("//a[text()='Block all']")).click();
			}
			else
			{
				ResultUtil.report("FAIL","Block All is not clicked", driver);	
			}
			Sync.waitForSeconds(4, driver);
		}
		
		//Description:Validate Allow  All link
public void selectAllowAllLink()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>selectAllowAllLink", driver);
			//Link.click("Block All", elmntAllowAllLink, driver);
			if(Element.verify("Show All", driver, "XPATH", "//a[text()='Allow all']"))
			{
				ResultUtil.report("PASS","Clicked Show All", driver);
				driver.findElement(By.xpath("//a[text()='Allow all']")).click();
			}
			else
			{
				ResultUtil.report("FAIL","Show All is not clicked", driver);	
			}
			Sync.waitForSeconds(4, driver);
		}
		
		//Description:Validate Consumer View  link
public void selectConsumerViewLink(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>selectConsumerViewLink", driver);
			String strConsumerKey = dataMap.get("ConfirmConsumerKeyFormat");
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>selectConsumerViewLink", driver);
			Link.click("View", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td='"+strConsumerKey+"']//a[@class='consumer_view' and text()='View']")), driver);
			Sync.waitForSeconds(5, driver);
		}
		
		//Description:Validate view popup gui
public void validateViewPopup(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>selectConsumerViewLink", driver);
			String strConsumerKey = dataMap.get("ConfirmConsumerKeyFormat");
			Element.verify("Auto grade refresh text", driver.findElement(By.xpath("//div[@id='periodPanelTitle']/strong")), "View completed Auto Grade Refreshes from "+strConsumerKey+"", driver);
			//From
			Element.verify("From label", driver.findElement(By.xpath("//td[.='From:']")), driver);
			Element.verify("Start date", elmntStartDate, driver);
			Element.verify("Start date calendar image", driver.findElement(By.xpath("//td[./input[@id='sdt']]//img[@alt='Calendar']")), driver);
			//To
			Element.verify("From label", driver.findElement(By.xpath("//td[.='To:']")), driver);
			Element.verify("End date", elmntEndDate, driver);
			Element.verify("End date calendar image", driver.findElement(By.xpath("//td[./input[@id='edt']]//img[@alt='Calendar']")), driver);
			
			//Show button
			Element.verify("Show", elmntShowbtn, driver);
			
			//Cancel button
			Element.verify("Cancel", elmntCancelbtn, driver);
		}
		
		//Description:Enter the values in calendar field
public void enterCalendarData(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>enterCalendarData", driver);
			String strStartDate = dataMap.get("ViewAllStartDate");
			String strEndDate = dataMap.get("ViewAllEndDate");
			TextBox.JSEnterValue("Start Date", driver, elmntStartDate, strStartDate);
			Sync.waitForSeconds(5, driver);
			TextBox.JSEnterValue("End Date", driver, elmntEndDate, strEndDate);
			Sync.waitForSeconds(5, driver);			
		}
		
		//Description:Click Show button in calendar
public void clickShowButton()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>clickShowButton", driver);
			Sync.waitForSeconds(5, driver);	
			Button.click("Show", elmntShowbtn, driver);
			Sync.waitForSeconds(5, driver);
		}
		
		//Description:Click Show button in calendar
public void clickCancelButton()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>clickCancelButton", driver);
			Button.click("Cancel", elmntCancelbtn, driver);
			Sync.waitForSeconds(5, driver);
		}

		//Description:Validate view completed Auto grade refresh
public void validateViewCompletedAutoGradeRefresh(Map<String,String> dataMap)
		{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>validateViewCompletedAutoGradeRefresh", driver);
			//switchFrameCourseListTable();
			Element.verify("View Completed text", driver, "XPATH", "//span[@class='pagetitle' and text()=' >> View Completed Auto Grade Refreshes']");
			
			if(Element.verify("View Auto grade refresh table", driver, "XPATH", "//table[@class='grhList']//tr[./td]"))
			{
				String strStartDate = dataMap.get("ViewAllStartDate").trim();
				String strEndDate = dataMap.get("ViewAllEndDate").trim();
				String strConsumerKey = dataMap.get("ConfirmConsumerKeyFormat").trim();
				String strConfirmInstitutionName = dataMap.get("ConfirmInstitutionNameFormat");
				WebElement startDate = driver.findElement(By.xpath("//strong[text()='"+strStartDate+"']"));
				WebElement endDate = driver.findElement(By.xpath("//strong[text()='"+strEndDate+"']"));
				ResultUtil.report("REPORT", "Auto Grade Refresh from" +startDate.getText()+ "to" +endDate.getText()+ "is displayed", driver);
				
				//Header
				Element.verify("Request type header", driver.findElement(By.xpath("//tr[./th]//strong[text()='Request Type']")), driver);
				Element.verify("Start date header", driver.findElement(By.xpath("//tr[./th]//strong[text()='Start Date']")), driver);
				Element.verify("Duration  header", driver.findElement(By.xpath("//tr[./th]//strong[text()='Duration']")), driver);
				Element.verify("Status  header", driver.findElement(By.xpath("//tr[./th]//strong[text()='Status']")), driver);
				Element.verify("Consumer Key", driver.findElement(By.xpath("//tr[./th]//strong[text()='Consumer Key']")), driver);
				Element.verify("Institution Name", driver.findElement(By.xpath("//tr[./th]//strong[text()='Institution Name']")), driver);
				Element.verify("Class section Name", driver.findElement(By.xpath("//tr[./th]//strong[text()='Class Section Name']")), driver);
				
				//Request type
				Element.verify("Request type", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td]/td[text()='Gradebook Activity' or text()='Grades Update']")), driver);
				Element.verify("Start date", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td]/td[2]")), driver);
				Element.verify("Duration", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td]/td[3]")), driver);
				Element.verify("Status", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td]/td[text()='Completed']")), driver);
				Element.verify("Consumer ", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td]/td[text()='"+strConsumerKey+"']")), driver);
				Element.verify("Institution ", driver.findElement(By.xpath("//table[@class='grhList']//tr[./td]/td[text()='"+strConfirmInstitutionName+"']")), driver);
				
			}
			else
			{
				ResultUtil.report("REPORT", "No data's are displayed", driver);
			}
		}
		
		//Description:Back to Blackboard consumer link
public void gotoLTIBlackBoardConsumerScreen()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>gotoLTIBlackBoardConsumerScreen", driver);
			try
			{
				switchFrameCourseListTable();
			}
			catch(Exception e)
			{
				
				
			}
			Link.click("LTI (Blackboard Consumers)", elmntBBConsumerBackLink, driver);
			Sync.waitForSeconds(5, driver);
		}		
		
		//Description:Validate the consumer table
public void validateBlackboardConsumerTable(Map<String,String> dataMap)
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>validateBlackboardConsumerTable", driver);
			try
			{
				switchFrameCourseListTable();
			}
			catch(Exception e)
			{
				
			}
			
			List<WebElement> bbConsumerTable = driver.findElements(By.xpath("//table[@class='grhList']//tr[./td]"));
			String strtableSize = Integer.toString(bbConsumerTable.size());
			String strBBConsumerTableSize = dataMap.put("TableSize", strtableSize);
		}
		
		//Description:BlockAll warning Message
public void blockAllBlockedMessage() throws InterruptedException
		{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>BlockAllBlockedMessage", driver);
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			Assert.assertEquals(alert.getText(), "Are you sure you want to block auto grade refreshes for all consumers?");
			alert.accept();		
			Sync.waitForSeconds(7, driver);
			if(Element.verify("Blocked Message", driver, "XPATH", "//b[text()='Auto grade refreshes are blocked for all consumers.']"))
			{
				Element.verify("Pass", driver.findElement(By.xpath("//b[text()='Auto grade refreshes are blocked for all consumers.']")), driver);
				ResultUtil.report("PASS", "Blocked message is displayed", driver);
			}
			else
			{
				ResultUtil.report("FAIL", "No Blocked message is displayed", driver);
			}
		}
		
		//Description:Validate Allow all text
public void allowedMessage()
{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>allowedMessage", driver);
			if(Element.verify("Allowed Message", driver, "XPATH", "//b[text()='Auto grade refreshes are allowed for all consumers.']"))
			{
				Element.verify("Pass", driver.findElement(By.xpath("//b[text()='Auto grade refreshes are allowed for all consumers.']")), driver);
				ResultUtil.report("PASS", "Allowed message is displayed", driver);
			}
			else
			{
				ResultUtil.report("FAIL", "No Allowed message is displayed", driver);
			}
		}
		//Description:Switch to Work frame table
public void switchFrameCourseListTable()
{
			WebDriver myFrame = driver.switchTo().frame("mainframe");
			myFrame = myFrame.switchTo().frame("userframe");
			myFrame = myFrame.switchTo().frame("workframe");
		}
		
		//Description:Validate the navigation link
public void validatePaginationLink()
		{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>validatePaginationLink", driver);
			
			if(Element.verify("Pagination", driver, "XPATH", "//div[@id='pagination']"))
			{
				ResultUtil.report("PASS", "Pagination button displayed", driver);		
				validatePaginationPagebyDefault();
				validatebuttons();				
			}
			else
			{
				ResultUtil.report("FAIL", "Pagination button is not displayed", driver);
			}
		}
		
		//Description:Validate pagination filed by default
public void validatePaginationPagebyDefault()
		{
			ResultUtil.report("INFO", "LTIConfigurationBlackboardConsumersPage>validatePaginationPagebyDefault", driver);
			
			//By default			
			//No-1 shoud be in dropdown
			Combobox.isEnabled(elmntPageLinkDropdown, "Pagination dropdown", driver);
			Combobox.verifySelectedItem("Selected item", elmntPageLinkDropdown, "1", driver);			
			Link.verify("Second value", driver.findElement(By.xpath("//a[text()='2']")), "2", driver);
			getDefaultAutoGradeTableOrder();
			
			//Change the dropdown to the next value, say 2
			Combobox.selectItemByIndex("Select the value by index", elmntPageLinkDropdown, 1, driver);
			Combobox.verifySelectedItem("Selected item", elmntPageLinkDropdown, "2", driver);
			Sync.waitForSeconds(4, driver);
			getChangedAutoGradeTableOrder();
			validateOrder();
			Link.verify("Second value", driver.findElement(By.xpath("//a[text()='1']")), "1", driver);
		}
		
		//Description:Get the order of the wiley plus links
public void getDefaultAutoGradeTableOrder()
		{
			ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>getDefaultWileyLinksOrder", driver);
			switchFrameCourseListTable();
			List<WebElement> autoGrade= driver.findElements(By.xpath("//table[@class='grhList']//tr"));
			System.out.println(autoGrade.size());
			for(WebElement link:autoGrade)
			{
				String defaultLinks=link.getText();
				selectTableorder.add(defaultLinks);
				ResultUtil.report("REPORT", "Default order is added in buffer", driver);
			}
		}
		
		//Description:Get the order of the wiley plus links
public void getChangedAutoGradeTableOrder()
			{
				ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>getChangedAutoGradeTableOrder", driver);
				switchFrameCourseListTable();
				List<WebElement> autoGrade= driver.findElements(By.xpath("//table[@class='grhList']//tr"));
				System.out.println(autoGrade.size());
				for(WebElement link:autoGrade)
				{
					String changedLinks=link.getText();
					contentTableorder.add(changedLinks);
					ResultUtil.report("REPORT", "Default order is added in buffer", driver);
				}
			}
			
			//Description:Validate the order
public void validateOrder()
			{
				ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validateOrder", driver);
				switchFrameCourseListTable();
				if(selectTableorder.toString().equals(contentTableorder.toString()))
				{
					ResultUtil.report("FAIL", "Order doesn't changed", driver);
				}
				else
				{
					ResultUtil.report("PASS", "Order has changed", driver);
				}
			}
			
			//Description:Validate previous/next button
public void validatebuttons()
			{
				ResultUtil.report("INFO", "BlackboardToolsWileyPlusPage>validatebuttons", driver);
				switchFrameCourseListTable();

				//Click Previous button
				Browser.runScript(driver, "paginationSwitch('1')");
				Sync.waitForSeconds(4, driver);
				
				//Verify 1 should be in dropdown
				Combobox.verifySelectedItem("Selected item", elmntPageLinkDropdown, "1", driver);			
				
				//Click Next button
				Browser.runScript(driver, "paginationSwitch('2')");
				Sync.waitForSeconds(4, driver);
				
				//Verify 2 should be in dropdown
				Combobox.verifySelectedItem("Selected item", elmntPageLinkDropdown, "2", driver);
			}
}
