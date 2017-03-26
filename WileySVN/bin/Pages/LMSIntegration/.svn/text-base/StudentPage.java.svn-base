package Pages.LMSIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.Initializer;
import Pages.GradeBook.StudentGradeBookPage;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class StudentPage extends Initializer
{

	public StudentPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(how = How.NAME, using = "userName")
	private WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	private WebElement txtPassword;

	@FindBy(how = How.NAME, using = "Login")
	private WebElement btnLogin;

	@FindBy(how = How.NAME, using = "fname")
	private WebElement tboxFname;

	@FindBy(how = How.NAME, using = "lname")
	private WebElement tboxlname;

	@FindBy(how = How.NAME, using = "orgdefinedid")
	private WebElement tboxorgid;

	@FindBy(how = How.XPATH, using = "//li[2]/a/span[1]")
	private WebElement lnkParticipents;

	@FindBy(how=How.XPATH,using ="//a[@title='Classlist']")
	private WebElement selectclassList;

	@FindBy(how = How.XPATH, using = "//tbody/tr/td[1]/a[9]")
	private WebElement lnkselaccess;

	@FindBy(how = How.XPATH, using = "//*[@id='d2l_form']/ul/li[3]/a")
	private WebElement lnkNewUser;	

	@FindBy(how=How.XPATH,using ="//a[@class='topwnu' and @title='Content']")
	private WebElement elmntContentLink;

	@FindBy(how=How.XPATH,using ="//b[.='Assignment']")
	private WebElement lnkassignments;

	@FindBy(how = How.LINK_TEXT, using = "Help")
	private WebElement lnkhelp;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'System Announcements')]")
	private WebElement lnksysannounce;

	@FindBy(how=How.XPATH,using ="//b[.='Gradebook']")
	private WebElement verifyGB;
	
	@FindBy(how=How.XPATH,using ="//button[@id='z_bb']")
	private WebElement userrole;
	
	@FindBy(how=How.XPATH,using ="//select[@id='z_t']")
	private WebElement selectrole;

	
	public StudentPage studentLogin(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "StudentPage>login",driver);
		String _userName = dataMap.get("sUsername");
		String _password = dataMap.get("sPassword");
		TextBox.enterValue("Email", txtEmail, _userName,driver);
		TextBox.enterValue("Email", txtPassword, _password,driver);
		Button.click("enter user details",btnLogin, driver);
		return PageFactory.initElements(driver, StudentPage.class);
	}
	
	//Description:Log in as Student -> Navigate to Course 
	public void  selectCourse(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>selectCourse",driver);
		String courselink = dataMap.get("course");
		driver.switchTo().frame(1);
		WebElement pathselectcourse =driver.findElement(By.xpath("//a[.='"+courselink+"']"));
		Link.click("selectcourse",pathselectcourse, driver);			
	}

	//Description:click Add Participants
	public void clickAddParticipants()throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>clickAddParticipants",driver);
		Sync.waitForFrame(driver,"waitfor frame",1, 4);
		Link.click(" Click Participents", lnkParticipents,driver);
	}

	//Description:method to access content link in the main window,Navigate to the Content Tool).
	public void selectClassList() throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>selectClassList",driver);
		Sync.waitForFrame(driver,"waitfor frame",0, 4);
		Link.click("Select Class List", selectclassList,driver);
		driver.switchTo().defaultContent();
	}

	//Description:method to access content link in the main window,Navigate to the Content Tool).
	public void accessContent() throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>accessContent",driver);
		Sync.waitForFrame(driver,"waitfor frame",0, 4);
		Link.click("Select Access Content", lnkselaccess,driver);
	}

	//Description:Click on AccessHalliday rsp
	public void accessHallidayRSP(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>accessHallidayRSP",driver);
		
		String strrsp = dataMap.get("lnkRSP");
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver,"wait for frame","content", 4);
		WebElement lnkhallidayrsp = driver.findElement(By.xpath("//a[.='"+strrsp+"']"));
		Link.click("Access Halliday RSP", lnkhallidayrsp,driver);
		
	}

	//Description:access Halliday
	public void accessHallidayCH1(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>accessHallidayCH1",driver);
		String strrspch1 = dataMap.get("lnkRSPch1");
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver,"wait for frame","content", 4);
		WebElement lnkhallidayrspch1 = driver.findElement(By.xpath("//a[.='"+strrspch1+"']"));
		Link.click("Access Halliday RSP", lnkhallidayrspch1,driver);
	}

	//Description:for TCE4117,clickon Gradebook
	public void accessHallidayGB(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>accessHallidayGB",driver);
		String strrspgb = dataMap.get("lnkRSPgb");
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver,"wait for frame","content", 4);
		WebElement lnkhallidayrspgb = driver.findElement(By.xpath("//a[.='"+strrspgb+"']"));
		Link.click("Access Halliday GB", lnkhallidayrspgb,driver);
	}

	//Description:Clicking on AccessHallidayassign  section of instructor login
	public void accessHallidayassign(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>accessHallidayassign",driver);
		String strassign = dataMap.get("lnkhallidayassign");
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver,"waitfor frame","content", 7);
		WebElement lnkhallidayassign = driver.findElement(By.xpath("//a[.='"+strassign+"']"));
		Link.click("Access Halliday Assign", lnkhallidayassign,driver);
	}

	//Description:click New User
	public void clickNewUser()throws Exception
	{	
		ResultUtil.report("INFO", "StudentPage>clickNewUser",driver);
		Sync.waitForFrame(driver,"waitfor frame",2, 4);
		Link.click("Click New User or Role", lnkNewUser,driver);
	}

	//Description:enter Student Details
	public void enterStudentDetails(Map<String,String> dataMap) throws Exception
	{	
		ResultUtil.report("INFO", "StudentPage>enterStudentDetails",driver);
		String fname = dataMap.get("sfname");
		TextBox.enterValue("First name", tboxFname, fname,driver);
		String lname = dataMap.get("slname");
		TextBox.enterValue("last name", tboxlname, lname,driver);
		String orgid = dataMap.get("sorgid");
		TextBox.enterValue("orgid", tboxorgid, orgid,driver);
		Combobox.selectItemByValue("select user role",selectrole ,"Student", driver);
		Button.click("click on role",userrole, driver);
	}	

	//Description:Select the content link in the top menu area
	public void selectContentLink()
	{
		ResultUtil.report("INFO", "StudentPage>selectContentLink",driver);
		Sync.waitForFrame(driver,"waitfor frame",0, 4);
		Link.click("Content", elmntContentLink,driver);
	}
	
	private void studentPageFrames() {
		try
		{
			switchTocFrame();
		}
		catch(Exception e){}		
	}
	//Description:Student Assignment Page
	public StudentAssignmentPage selectStudentSnapwizAssignmentLinkUnit(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "StudentPage>selectStudentSnapwizAssignmentLinkUnit",driver);
		
		switchToContentFrame();
		
		String strAssignmentNameLink = dataMap.get("AssignmentNameLink");
		Link.click("Snapwiz assignment link", driver.findElement(By.xpath("//td[.//a[.='"+strAssignmentNameLink+"']]/a")),driver);
		switchToHandleWindows();
		try{switchToContentFileFrame();}catch(Exception e){}

		return PageFactory.initElements(driver, StudentAssignmentPage.class);
	}

	//Description:switch To AssignmentWindows
	public void switchToAssignmentWindows()
	{
		ResultUtil.report("INFO", "StudentPage>switchToAssignmentWindows",driver);
		String strAssignmentWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strAssignmentWindow);
	}

	//Description:switch T oParentWindow
	public void switchToParentWindow()
	{
		String parentWindow=driver.getWindowHandles().toArray()[0].toString();
		driver.switchTo().window(parentWindow);
	}

	//Description:close Browser
	public void closeBrowser()  throws Exception
	{
		ResultUtil.report("INFO", "StudentPage>closeBrowser",driver);
		driver.quit();
	}

	//Description:Select the course 
	public void selectCourseName(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "StudentPage>selectCourseName",driver);
		switchToContentFrame();
		String strCourseName = dataMap.get("CourseName");
		String strCourseNameXPath="//a[contains(text(),'"+strCourseName+"')]";
		Link.verify("Course Name", driver.findElement(By.xpath(strCourseNameXPath)), driver);
		Link.click("Course name", driver.findElement(By.xpath(strCourseNameXPath)), driver);
	}

	//Description:Switch to Content frame 
	public void switchToContentFrame()
	{
		ResultUtil.report("INFO", "InstructorPage>switchToContentFrame",driver);
		Sync.waitForFrame(driver,"waitfor frame","content", 4);
	}

	//Description:Switch to AssignmentFrame
	public void switchToContentFileFrame()
	{
		ResultUtil.report("INFO", "InstructorPage>switchToAssignmentFrame",driver);
		Sync.waitForFrame(driver,"waitfor frame","frameContentFile", 4);
	}

	//Description:Handle windows
	public void switchToHandleWindows()
	{
		ResultUtil.report("INFO", "StudentPage>switchToHandleWindows",driver);
		String strWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strWindow);
		String strWindowName = driver.getTitle();
		ResultUtil.report("Window Name", strWindowName, driver);
	}

	//Description:go to gradebook link
	public StudentGradeBookPage selectGradebookLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "StudentPage>selectGradebookLink",driver);

		switchToContentFrame();
		try
		{
			switchTocFrame();
		}catch(Exception e){}
		
		String strGradebookNameLink = dataMap.get("GradebookNameLink");
		Link.click("Snapwiz gradebook link", driver.findElement(By.xpath("//td[.//a[.='"+strGradebookNameLink+"']]/a")),driver);
		
		switchToHandleWindows();
		switchToContentFileFrame();

		return PageFactory.initElements(driver, StudentGradeBookPage.class);
	}

	//verify assignments
	public void verifyassignments()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyassignments", driver);
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver,"waitfor frame","content", 4);
		Sync.waitForFrame(driver,"waitfor frame","ContentFrame", 4);
		Sync.waitForFrame(driver,"waitfor frame","frameContentFile", 4);
		Link.verify("verify verifyassignments ",lnkassignments , driver);
	}

	//verify help link in the Wiley plus page
	public void verifyhelplink()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyhelplink", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver,"waitfor frame","frameContentFile", 4);
		Link.verify("verified", lnkhelp, "Help", driver);
	}

	//verify sysannouncements link in the Wiley plus page
	public void verifysystemannouncement()
	{
		ResultUtil.report("INFO", "InstructorPage > verify system announcement", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver,"waitfor frame","frameContentFile", 4);
		Link.verify("verify system announcement ",lnksysannounce , driver);
	}

	//verify gradebook label in the Wiley plus page
	public void verifygradebook()
	{
		ResultUtil.report("INFO", "InstructorPage > verifygradebook", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Element.verify("verifygradebook ",verifyGB , driver);
	}
	
	public void switchTocFrame()
	{
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Content Frame", "content", 6);
		Sync.waitForFrame(driver, "TOCFrame Frame", "TOCFrame", 6);		
	}
}


