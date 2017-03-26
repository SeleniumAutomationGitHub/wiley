package Pages.LMSIntegration;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import Pages.Assignments.AssignmentPage;
import Pages.Common.GradeBookPage;
import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;

public class InstructorPage extends Initializer
{
	public WebElement element;

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

	@FindBy(how = How.LINK_TEXT, using = "Help")
	private WebElement lnkhelp;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'System Announcements')]")
	private WebElement lnksysannounce;

	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Add Participants')]")
	private WebElement addparticipants;

	@FindBy(how=How.XPATH,using ="//tbody/tr/td[1]/a[11]")
	private WebElement accesscontent;

	@FindBy(how=How.XPATH,using ="//a[@title='Classlist']")
	private WebElement selectclassList;

	@FindBy(how=How.XPATH,using ="//a[@class='topwnu' and @title='Content']")
	private WebElement elmntContentLink;

	@FindBy(how=How.XPATH,using ="//a[@title='Create and enroll a new user']")
	private WebElement clicknewuser;

	@FindBy(how=How.ID,using ="applyRosterSetings")
	private WebElement LMSGo;

	@FindBy(how=How.ID,using ="applyAGListSetings")
	private WebElement assignGO;

	@FindBy(how=How.ID,using ="applyGBSetings")
	private WebElement ClickGbgo;

	@FindBy(how=How.ID,using ="applyRosterSetings")
	private WebElement RosterGo;

	@FindBy(how=How.ID,using ="applyFilters")
	private WebElement QuestionGo;
	
	@FindBy(how=How.XPATH,using ="//a[.='Roster']")
	private WebElement accessRoster;

	@FindBy(how=How.XPATH,using ="//a[.='Presentations']")
	private WebElement accessPresentations;

	@FindBy(how=How.ID,using ="applyFilters")
	private WebElement accessPresentationsGo;

	@FindBy(how=How.XPATH,using ="//a[.='Resources']")
	private WebElement accessResources;

	@FindBy(how=How.XPATH,using ="//b[.='Assignments']")
	private WebElement lnkassignments;

	@FindBy(how=How.XPATH,using ="//tr[14]/td[2]/nobr/a")
	private WebElement acessilearn;

	@FindBy(how=How.XPATH,using ="//p[.='Find Resources']")
	private WebElement verifyresources;

	@FindBy(how=How.ID,using ="Add_New_Resource")
	private WebElement clickresource;

	@FindBy(how=How.XPATH,using ="//p[.='Class  Roster']")
	private WebElement verifyroster;

	@FindBy(how=How.XPATH,using ="//p[.='Find Questions']")
	private WebElement verifyquestions;

	@FindBy(how=How.XPATH,using ="//p[.='Find Presentations']")
	private WebElement verifypresent;

	@FindBy(how=How.XPATH,using ="//b[.='Gradebook']")
	private WebElement verifyGB;

	@FindBy(how=How.XPATH,using ="//select[@id='z_t']")
	private WebElement selectrole;
	
	@FindBy(how=How.XPATH,using ="//button[@id='z_bb']")
	private WebElement userrole;
	
	@FindBy(how=How.XPATH,using ="//span[@class='introduction']")
	private WebElement lblchapter;
	
	@FindBy(how=How.XPATH,using ="//span[@title='Student Study Guide']")
	private WebElement lnkstudy;
	
	@FindBy(how=How.XPATH,using ="//span[@title='Interactive Learningware']")
	private WebElement lnkilearn;
	
	
	//Description:Instructor Page
	public InstructorPage(WebDriver driver)
	{
		super(driver);
	}

	//Description:instructor login
	public InstructorPage instructorLogin(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "InstructorPage>login",driver);
		String _userName = dataMap.get("Username");
		String _password = dataMap.get("Password");
		TextBox.enterValue("Email", txtEmail, _userName,driver);
		TextBox.enterValue("Email", txtPassword, _password,driver);
		Button.click("enter user details",btnLogin, driver);
		return PageFactory.initElements(driver, InstructorPage.class);
	}

	//Description:select a math course
	public void  selectCourse(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>selectCourse",driver);
		Sync.waitForFrame(driver, "wait for frame",1,4);
		String strCourselink = dataMap.get("course");
		WebElement pathselectcourse =driver.findElement(By.xpath("//a[.='"+strCourselink+"']"));
		Link.click("selectcourse",pathselectcourse, driver);				
	}

	//Description:click add participants
	public void clickAddParticipants()throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>clickAddParticipants",driver);
		Sync.waitForFrame(driver, "wait for frame",1,4);
		Link.click("clickaddparticipants", addparticipants,driver);
	}

	//Description:method to access content link in the main window,Navigate to the Content Tool).
	public void accessContent() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessContent",driver);
		Sync.waitForFrame(driver, "wait for frame",0,4);
		Link.click("contentLInk", accesscontent,driver);
		driver.switchTo().defaultContent();
	}
	//Description:Click on AccessHalliday GB
	public void accessHallidaygb(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessHalliday",driver);
		String strhallidaygb = dataMap.get("lnkhallidaygb");
		Sync.waitForFrame(driver, "wait for frame",1,4);
		WebElement lnkhallidaygb = driver.findElement(By.xpath("//a[@title='"+strhallidaygb+"']"));
		Link.click("clickhalliday",lnkhallidaygb,driver);
	}

	//Description:click on access halliday
	public void accessHallidayCH1(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessHallidayCH1",driver);
		String strhallidaych1 = dataMap.get("lnkhallidaych1");
		Sync.waitForFrame(driver, "wait for frame",1,4);
		WebElement lnkhallidaych1 = driver.findElement(By.xpath("//a[@title='"+strhallidaych1+"']"));
		Link.click("clickhallidaylink",lnkhallidaych1,driver);
	}

	//Description:method to click on Interactive Learning and verifying the content
	public void accessILearning() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessILearning",driver);	
		Sync.waitForFrame(driver, "wait for frame",4,4);
		Link.click("access ilearning", acessilearn, driver);
	}

	//Description:click on class list link
	public void selectClassList() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>selectClassList",driver);
		Sync.waitForFrame(driver, "wait for frame",0,4);
		Link.click("clickclasslistlink",selectclassList,driver);	
		driver.switchTo().defaultContent();
	}

	//Description:new user
	public void clickNewUser()throws Exception
	{	
		ResultUtil.report("INFO", "InstructorPage>clickNewUser",driver);
		Sync.waitForFrame(driver, "wait for frame",2,4);	
		Link.click("newUser",clicknewuser,driver);
	}


		//Description:Clicking on roster section of instructor login
	public void clickLMSRosterGo() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>clickLMSRosterGo",driver);
		String strwindowhandle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strwindowhandle);
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Button.click("ClickLMSRosterGo", LMSGo,driver);
	}

	//Description:click on go
	public void assignClickGo() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>assignClickGo",driver);
		String strwindowhandle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strwindowhandle);
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.click("clickassignGO",assignGO,driver);
	}

	//Description:click on gradebook go
	public void gbClickGo() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>gbClickGo",driver);
		String strwindowhandle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strwindowhandle);
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.click("ClickGBGo",ClickGbgo,driver);
	}

	//Description:click on roster go
	public void rosterClickGo() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>rosterClickGo",driver);
		String strwindowhandle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strwindowhandle);
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.click("ClickRosterGo",RosterGo,driver);
	}

	//Description:click on questions go
	public void questionsClickGo() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>questionsClickGo",driver);
		String strwindowhandle = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strwindowhandle);
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.click("ClickQuestionsGo",QuestionGo,driver);
	}

	
	//Description:Clicking on roster section of instructor login
	public void accessRoster() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessRoster",driver);
		Sync.waitForFrame(driver, "wait for frame","content",4);
		Link.click("Roster",accessRoster,driver);
	}

	//Description:method for clicking on E4-QA: Halliday, 7e - Presentations" 
	public void accessPresentations() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessPresentations",driver);
		Sync.waitForFrame(driver, "wait for frame",1,4);
		Link.click("presentations",accessPresentations,driver);	
	}

	//Description:click on go
	public void clickPresentationsGo() throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>clickPresentationsGo",driver);
		String str = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(str);
		Sync.waitForFrame(driver, "wait for frame",0,4);
		Link.click("presentationsgo", accessPresentationsGo,driver);	
	}

	//Description:E4-QA: Halliday, 7e - Resources
	public void accessResources(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessResources",driver);
		Sync.waitForFrame(driver, "wait for frame",1,4);
		Link.click("resources", accessResources,driver);
	}


	//Description:E4-QA: Halliday, 7e - Create Questions 
	public void accessQuestions(Map<String,String> dataMap) throws Exception
	{
		ResultUtil.report("INFO", "InstructorPage>accessQuestions",driver);
		String strhalliday = dataMap.get("lnkquestions");
		Sync.waitForFrame(driver, "wait for frame",1,4);
		WebElement lnkhallidayquestions = driver.findElement(By.xpath("//a[@title='"+strhalliday+"']"));
		Link.click("accessQuestions",lnkhallidayquestions,driver);
	}
	//Description:enter Instructor Details
	public void enterInstructorDetails(Map<String,String> dataMap) throws Exception
	{		
		ResultUtil.report("INFO", "InstructorPage>enterInstructorDetails",driver);
		String fname = dataMap.get("Ifname");
		TextBox.enterValue("First name", tboxFname, fname,driver);
		String lname = dataMap.get("Ilname");
		TextBox.enterValue("last name", tboxlname, lname,driver);
		String orgid = dataMap.get("Iorgid");
		TextBox.enterValue("orgid", tboxorgid, orgid,driver);	
		Combobox.selectItemByValue("select user role",selectrole ,"Instructor", driver);
		Button.click("click on role",userrole, driver);	 	
	}	

	//Description:Select the content link in the top menu area
	public void selectContentLink()
	{
		ResultUtil.report("INFO", "InstructorPage>selectContentLink",driver);
		switchToNavigationFrame();
		Link.click("Content", elmntContentLink,driver);
	}
	//Description:Assignment Page select Snapwiz Assignment LinkUnit
	public AssignmentPage selectSnapwizAssignmentLinkUnit(Map<String,String> dataMap)
	{
		switchToContentFrame();
		String strAssignmentNameLink = dataMap.get("AssignmentNameLink");
		Link.click("Snapwiz assignment link", driver.findElement(By.xpath("//td[.//a[.='"+strAssignmentNameLink+"']]/a")),driver);
		switchToHandleWindows();
		switchToContentFileFrame();
		return PageFactory.initElements(driver, AssignmentPage.class);
	}

	//Description:switch To HandleWindows
	public void switchToHandleWindows()
	{
		String strWindow=driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(strWindow);
	}
	
	//Description:switch To Paren tWindow
	public void switchToParentWindow()
	{
		String parentWindow=driver.getWindowHandles().toArray()[0].toString();
		driver.switchTo().window(parentWindow);
	}

	//Description:close Browser
	public void closeBrowser()  throws Exception
	{
		driver.quit();
		ResultUtil.report("INFO", "InstructorPage>closeBrowser",driver);
	}

	//Description:Select the course
	public void selectCourseName(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "InstructorPage>selectCourseName",driver);
		switchToContentFrame();
		String strCourseName = dataMap.get("CourseName");
		String strcourseNameXpath="//a[contains(text(),'"+strCourseName+"')]";
		Link.verify("Course Name", driver.findElement(By.xpath(strcourseNameXpath)), driver);
		Link.click("Course name", driver.findElement(By.xpath(strcourseNameXpath)), driver);
	}

	//Description:Select the gradebook 
	public GradeBookPage selectSnapwizGradebookLink(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "InstructorPage>selectSnapwizGradebookLink",driver);
		switchToContentFrame();
		String strGradebookNamelink = dataMap.get("GradebookNameLink");
		Link.click("Snapwiz Gradebook link", driver.findElement(By.xpath("//td[.//a[.='"+strGradebookNamelink+"']]/a")),driver);
		switchToHandleWindows();
		switchToContentFileFrame();
		return PageFactory.initElements(driver, GradeBookPage.class);
	}

	//Description:Switch to Content frame 
	public void switchToContentFrame()
	{
		ResultUtil.report("INFO", "InstructorPage>switchToContentFrame",driver);
		Sync.waitForFrame(driver, "wait for frame","content",4);
	}

	//Description:Switch to Navigation frame 
	public void switchToNavigationFrame()
	{
		ResultUtil.report("INFO", "InstructorPage>switchToNavigationFrame",driver);
		Sync.waitForFrame(driver, "wait for frame","nav",4);
	}

	//Description:Switch to AssignmentFrame
	public void switchToContentFileFrame()
	{
		ResultUtil.report("INFO", "InstructorPage>switchToAssignmentFrame",driver);
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
	}

	//Description:Switch to  window
	public void switchToWindow()
	{
		ResultUtil.report("INFO", "AngelHomePage > switchToWindow", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		String strWindowName = driver.getTitle();
		ResultUtil.report("Message", strWindowName, driver);
		driver.manage().window().maximize();
	}

	//Description:Switch to  parent window
	public void switchBackToParentWindow()
	{
		ResultUtil.report("INFO", "AngelHomePage > switchBackToParentWindow", driver);
		try
		{				
			driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			String strWindowName = driver.getTitle();
			ResultUtil.report("Message", strWindowName, driver);
			driver.close();
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		}
		catch(Exception e){}
		finally
		{
			driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
			String strWindowName = driver.getTitle();
			ResultUtil.report("Message", strWindowName, driver);
		}
	}		

	//verify help link in the wp application
	public void verifyhelplink()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyhelplink", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.verify("verified", lnkhelp, "Help", driver);
	}
	
	//verify system announcement link in the WP application
	public void verifysystemannouncement()
	{
		ResultUtil.report("INFO", "InstructorPage > verify system announcement", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.verify("verify system announcement ",lnksysannounce , driver);
	}

	//verify the assignments label
	public void verifyassignments()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyassignments", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.verify("verify system announcement ",lnkassignments , driver);
	}

	//verify resources label
	public void verifyresources()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyresources", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Link.verify("verifyresources ",verifyresources , driver);
	}

	//verify roster info
	public void verifyroster()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyresources", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Element.verify("verifyresources ",verifyroster , driver);
	}
	//verify questions label
	public void verifyquestions()
	{
		ResultUtil.report("INFO", "InstructorPage > verifyquestions", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Element.verify("verifyquestions ",verifyquestions , driver);
	}
	//verify presentations label
	public void verifypresentations()
	{
		ResultUtil.report("INFO", "InstructorPage > verifypresent", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Element.verify("verifyquestions ",verifypresent , driver);
	}
	//verify gradeboook label
	public void verifygradebook()
	{
		ResultUtil.report("INFO", "InstructorPage > verifygradebook", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Element.verify("verifygradebook ",verifyGB , driver);
	}
	//click resources button
	public void clickaddresources()
	{
		ResultUtil.report("INFO", "InstructorPage > clickaddresources", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Button.click("clickaddresources ",clickresource , driver);
	}

	//click on assignments link 
	public void clickassignments(Map<String,String> dataMap)
	{
		ResultUtil.report("INFO", "InstructorPage > clickassignments", driver);
		String strassignments = dataMap.get("lnkassignments");
		Sync.waitForFrame(driver, "wait for frame","content",4);
		WebElement lnkhallidayassignments = driver.findElement(By.xpath("//a[@title='"+strassignments+"']"));
		Link.click("clickassignments ",lnkhallidayassignments , driver);
	}
	//click verify chapter
	public void verifychapter()
	{
		ResultUtil.report("INFO", "InstructorPage > verifychapter", driver);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Sync.waitForFrame(driver, "wait for frame","frameContentFile",4);
		Sync.waitForFrame(driver, "wait for frame","mainframe",4);
		Sync.waitForFrame(driver, "wait for frame","c_moduleframes",4);
		Sync.waitForFrame(driver, "wait for frame","c_content",4);
		Element.verify("verifygradebook ",lblchapter , driver);
	}
	//click studyguide
	public void clickstudyguide()
	{
		ResultUtil.report("INFO", "InstructorPage > clickstudyguide", driver);
		switchtocorg();
		Link.click("clickassignments ",lnkstudy , driver);
	}
	
	public void switchtocorg()
	{
		driver.switchTo().defaultContent();
		WebDriver myframe= driver.switchTo().frame("frameContentFile");
		myframe= myframe.switchTo().frame("mainframe");
		myframe=myframe.switchTo().frame("c_moduleframes");
		myframe.switchTo().frame("c_org");
		
	}
	//click ilearn
	public void clicklearn()
	{
		ResultUtil.report("INFO", "InstructorPage > clicklearn", driver);
		switchtocorg();
		Link.click("clickassignments ",lnkstudy , driver);
	}
	
}


