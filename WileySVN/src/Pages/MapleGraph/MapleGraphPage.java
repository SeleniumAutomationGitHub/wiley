package Pages.MapleGraph;
	
	
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Pages.Common.Initializer;
import Toolbox.Button;
import Toolbox.Checkbox;
import Toolbox.Combobox;
import Toolbox.Element;
import Toolbox.Link;
import Toolbox.ResultUtil;
import Toolbox.Sync;
import Toolbox.TextBox;
import Toolbox.Window;

public class MapleGraphPage extends Initializer
{
	
	@FindBy(how = How.NAME, using = "name")
	private WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "passwordText")
	private WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement txtAdminPassword;
	
	@FindBy(how = How.NAME, using = "loginbut")
	private WebElement btnAdminLogin;
	
	@FindBy(how = How.XPATH, using = "//div[@id='login-btn']/a")
	private WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//div[@id='mwp-login-button-wrapper']/a")
	private WebElement btnGMLogin;
	
	@FindBy(how = How.ID, using = "applyGBSetings")
	private WebElement GradebookGo;
	
	@FindBy(how = How.XPATH, using = "//*[@id='applyGBSetings']")
	private WebElement clickStudent;
	
	@FindBy(how = How.XPATH, using = "//*[@id='wp-page-header-top']/div[2]/a[4]")
	private WebElement reportError;
	
	@FindBy(how = How.ID, using = "Go_To_Student_View")
	private WebElement studentView;
	
	@FindBy(how = How.ID, using = "applyAGListSetings")
	private WebElement btnfindassignGo;
	
	@FindBy(how = How.XPATH, using = "//span[@class='alert']")
	private WebElement lbltext;
	
	@FindBy(how = How.XPATH, using = "//table/tbody/tr/td[1]/ul/li[3]")
	private WebElement assignLink;
	
	@FindBy(how = How.XPATH, using = "//li[@title='Assignment']")
	private WebElement lnkstuassign;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Section 2.1 Practice')]")
	private WebElement clickassignnameLink;
	
	@FindBy(how = How.ID, using = "Next")
	private WebElement clickNext;
	
	@FindBy(how = How.ID, using = "Assign_to_Class_Section(s)")
	private WebElement btnassign;
	
	@FindBy(how=How.XPATH,using="//iframe[@id='lwsFrame']")
	private WebElement clicknextbtn;
	
	@FindBy(how = How.XPATH, using = "//table/tbody/tr/td[1]/ul/li[4]")
	private WebElement studentGradebook;
	
	@FindBy(how = How.XPATH, using = "//table[1]/tbody/tr/td[2]/div[1]/a")
	private WebElement showWork;
	
	@FindBy(how = How.ID, using = "Save_for_later")
	private WebElement SaveButton;
	
	@FindBy(how = How.XPATH, using = "//li[@title='Gradebook']")
	private WebElement clickstuGradeBook;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]//parent::td//following-sibling::td[7]//select")
	private WebElement cmbboxunassignName;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]//parent::td//following-sibling::td[7]//select")
	private WebElement cmbboxrestorename;
	
	@FindBy(how = How.XPATH, using = "//li[@title='Gradebook']")
	private WebElement clickGB;
	
	@FindBy(how = How.ID, using = "clsSelector")
	private WebElement cmbgbbox;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]")
	private WebElement cmbeditbox;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]//parent::td//following-sibling::td[7]//select")
	private WebElement cmbdeletebox;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'correctionadditions')]//parent::td//following-sibling::td[7]//select")
	private WebElement cmdeditavailassign;
	
	@FindBy(how = How.ID, using = "Assign_Later")
	private WebElement assignlater;
	
	@FindBy(how = How.ID, using = "//a[.='Chapter 0 Instructor Diagnostic Assignment']")
	private WebElement lnkdiagnostic;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]//parent::td//following-sibling::td[7]//select")
	private WebElement cmbeditavail;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Courses']")
	private WebElement lnkcourses;
	
	@FindBy(how = How.XPATH, using = "//table//tbody//tr//a[contains(.,'REGRESSION')]")
	private WebElement lnkcourse;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Content Updates']")
	private WebElement btncontent;
	
	@FindBy(how = How.XPATH, using = "//table[2]//strong//a")
	private WebElement btntestbank;
	
	@FindBy(how = How.NAME, using = "association")
	private WebElement lbquestions;
	
	@FindBy(how = How.XPATH, using = "//table//tbody//tr//td[.='Graphing-Maple']")
	private WebElement eleGM;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Configuration')]")
	private WebElement elmConficurationTab;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Server')]")
	private WebElement elmServerTab;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Blackboard')]")
	private WebElement elmBlackboardTab;
	
	@FindBy(how = How.NAME, using = "mngSharedSecret")
	private WebElement elmMngSharedSecret;
	
	@FindBy(how = How.NAME, using = "submit")
	private WebElement btnApply;
	
	@FindBy(how = How.ID, using = "Save_for_later")
	private WebElement savelater;
	
	@FindBy(how = How.ID, using = "Print_Assignment")
	private WebElement printassign;
	
	@FindBy(how = How.ID, using = "Close")
	private WebElement closedialog;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Get help answering Graphing-Maple questions.')]")
	private WebElement elehelplink;
	
	@FindBy(how = How.ID, using = "Next")
	private WebElement btnNext;
	
	@FindBy(how = How.ID, using = "applyFilters")
	private WebElement btnGo;
	
/*	@FindBy(how = How.XPATH, using = "//div[@ id='_4020_1']//span[text()='WileyPLUS Read, Study & Practice']")
	private WebElement lnkRSP;
*/	
	@FindBy(how = How.XPATH, using = "//li[@title='Read, Study & Practice']")
	private WebElement lnkimageRSP;
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Console Practice')]")
	private WebElement lnkassignment;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Printer_Version']")
	private WebElement lnkprinttab;
	
	@FindBy(how = How.ID, using = "Cancel")
	private WebElement btnassignedcancel;
	
	@FindBy(how = How.XPATH, using = "//ul[@id='wp-page-header-subtabs']//li[2]")
	private WebElement btnmgquestions;
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'Save for later')]")
	private WebElement btnsaveforlater;
	
	@FindBy(how = How.XPATH, using = "//div[@class='right-part']//a[contains(.,'Report')]")
	private WebElement lnkreport;
	
	@FindBy(how = How.XPATH, using = "//input[@id='hide_question_titles_chbox']")
	private WebElement chkhide;
/*	
	@FindBy(how = How.XPATH, using = "//input[@id='cls335947_ag_state']")
	private WebElement chkclass;
*/	
	@FindBy(how = How.XPATH, using = "//a[@id='Submit']")
	private WebElement classsubmit;
	
	@FindBy(how=How.XPATH,using= "//table//tbody//tr//td//a[contains(.,'Maple')]")
	private WebElement lnkassignname;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Next']")
	private WebElement lnknext;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr/td/table[1]/tbody/tr/td/img")
	private WebElement lnkmaple;
	
	@FindBy(how = How.XPATH, using = "//table//tbody//tr//td//a[contains(.,'Maple')]")
	private WebElement lnkmapleassign;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'1. Describe Assignment')]")
	private WebElement btndescassign;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'2. Select Questions')]")
	private WebElement btnselquestion;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'3. Organize & Score Questions')]")
	private WebElement btnorganize;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'4. Set Question Policies')]")
	private WebElement btnsetqpolicy;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'5. Confirmation')]")
	private WebElement btnconfirm;
	
	@FindBy(how = How.XPATH, using = "//a[.='Report a Content Error']")
	private WebElement btnreport;
	
	@FindBy(how = How.XPATH, using = "//*[@id='wp-page-header-subtabs']/li[2]")
	private WebElement btnheader;
	
	@FindBy(how = How.ID, using = "Create_Question_Pool")
	private WebElement btnpool;
	
	@FindBy(how = How.ID, using = "Next")
	private WebElement btnnext;
	
	@FindBy(how = How.XPATH, using = "//table//tbody//tr//td//li[@title='Gradebook']")
	private WebElement btngb;
	
	@FindBy(how = How.ID, using = "Go_To_Student_View")
	private WebElement btnstudentview;
	
	@FindBy(how = How.ID, using = "Submit")
	private WebElement btnhidesubmit;
	
	@FindBy(how = How.XPATH, using = "//table//tbody//tr//td//a[contains(.,'DisableImmediate')]")
	private WebElement lnkdisableimmediate;
	
	@FindBy(how = How.ID, using = "Create_Question")
	private WebElement btncreatequest;
	
	@FindBy(how = How.ID, using = "Cancel")
	private WebElement btncancel;
	
	@FindBy(how = How.ID, using = "Create_Question_Pool")
	private WebElement btnquestpool;
	
	@FindBy(how = How.XPATH, using = "//a[contains(.,'mapleClass')]")
	private WebElement lnkmapleclass;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]//parent::td//following-sibling::td[7]//a")
	private WebElement btngeneralGo;
	
	@FindBy(how = How.XPATH, using = "//table[2]//a[contains(.,'Maple')]//parent::td//following-sibling::td[7]//select")
	private WebElement cmbgeneralbox;
	
	@FindBy(how = How.ID, using = "Create_New_Assignment")
	private WebElement btncreate;
	
	@FindBy(how = How.NAME, using = "ag_use_penalties_control")
	private WebElement applypotential;
	
/*	@FindBy(how = How.NAME, using = "chk_quest2404171")
	private WebElement chkquest;
*/	
	String strMapleGraphingSharedSecretKey =null;
	
	public MapleGraphPage(WebDriver driver){
		super(driver);
	}
	
	//Description:login as Wiley plus as instructor
	public MapleGraphPage MGInstructorlogin(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>MGInstructorlogin",driver);
		String _userName=dataMap.get("MGInstructorUsername");
	    String _password=dataMap.get("MGInstructorPassword");
	    TextBox.enterValue("Email", txtEmail, _userName,driver);
	    TextBox.enterValue("Password", txtPassword, _password,driver);
	    Button.click("Click Button", btnLogin,driver);
	    return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	
	//Description:login as Wiley plus as instructor
	public MapleGraphPage MGEdugenlogin(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>MGInstructorlogin",driver);
		String _userName=dataMap.get("MGInstructorUsername");
	    String _password=dataMap.get("MGInstructorPassword");
	    TextBox.enterValue("Email", txtEmail, _userName,driver);
	    TextBox.enterValue("Password", txtPassword, _password,driver);
	    Button.click("Click Button", btnLogin,driver);
	    return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	
	//Description:login as Wiley plus as student
	public MapleGraphPage MGStudentlogin(Map<String,String> dataMap){
		String _userName=dataMap.get("MGStudentUsername");
		String _password=dataMap.get("MGStudentPassword");
		TextBox.enterValue("Email", txtEmail, _userName,driver);
	    TextBox.enterValue("Password", txtPassword, _password,driver);
		Button.click("ClickonLogin", btnLogin,driver);	
		return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	
	//Description:login as Wiley plus admin app as admin
	public MapleGraphPage MGAdminlogin(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>Adminlogin",driver);
		txtEmail.sendKeys(dataMap.get("MGAdminUsername"));
		txtAdminPassword.sendKeys(dataMap.get("MGAdminPassword"));
		Button.click("ClickonLogin", btnAdminLogin,driver);	
		return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	
	//Description:login to graphing maplea questions login as instructor
	public MapleGraphPage GraphingMapleInstructorlogin(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>MGInstructorlogin",driver);
		String _userName=dataMap.get("GMInstructorUsername");
	    String _password=dataMap.get("GMInstructorPassword");
	    TextBox.enterValue("Email", txtEmail,_userName,driver);
	    TextBox.enterValue("Password", txtAdminPassword, _password,driver);
	    Button.click("Click Button", btnGMLogin,driver);
	    return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	//Description:login to graphing maplea questions login as student
	public MapleGraphPage GraphingMapleStudentlogin(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>Studentlogin",driver);
		String strUserName = dataMap.get("MGStudentUsername");
		String strPassword = dataMap.get("MGStudentPassword");
		WebElement elmUserName = driver.findElement(By.name("name"));
		WebElement elmPassword = driver.findElement(By.name("password"));
		TextBox.enterValue("Email", elmUserName,strUserName,driver);
		TextBox.enterValue("Password", elmPassword, strPassword,driver);
		Button.click("ClickonLogin", btnGMLogin,driver);	
		return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	
	//Description:login to support disable functionality login as student
	public MapleGraphPage SupportDisableStudentlogin(Map<String,String> dataMap){
		txtEmail.sendKeys(dataMap.get("SupportDisableStudentUsername"));
		txtAdminPassword.sendKeys(dataMap.get("SupportDisableStudentPassword"));
		Button.click("ClickonLogin", btnGMLogin,driver);	
		return PageFactory.initElements(driver, MapleGraphPage.class);
	}
	//Description:clickDomainUser
	public void clickstuDomainUser(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>clickDomainUser",driver);
		String lnkstucourse = dataMap.get("stucourse");
		WebElement lnkstuClickCourse = driver.findElement(By.xpath("//a[contains(text(),'"+lnkstucourse+"')]"));
		Link.click("Clicko n Domain", lnkstuClickCourse, driver);
	}
	
	//Description: click on domain user
	public void clickInsDomainUser(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>clickInsDomainUser",driver);
		String lnkinscourse = dataMap.get("inscourse");
		WebElement lnkinsClickCourse = driver.findElement(By.xpath("//a[contains(text(),'"+lnkinscourse+"')]"));
		Link.click("Clicko n Domain", lnkinsClickCourse, driver);
	}
	
	public void clickcorrectionaddDomainUser(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>clickcorrectionaddDomainUser",driver);
		String lnkinscorcourse = dataMap.get("inscorcourse");
		WebElement lnkcorClickCourse = driver.findElement(By.xpath("//a[contains(text(),'"+lnkinscorcourse+"')]"));
		Link.click("Clicko n Domain", lnkcorClickCourse, driver);
	}
	
	//Description:clickAssignment
	public void clickAssignmentTab(){
		ResultUtil.report("INFO", "MapleGraphPage>clickAssignment",driver);
		Link.click("click Assignment tab",lnkstuassign, driver);
	}
	
	//Description:clickAssignmentGo
	public void clickAssignmentGo(){
		ResultUtil.report("INFO", "MapleGraphPage>clickAssignmentGo",driver);
		Button.click("Click on Assignment Go",btnfindassignGo,driver);
	}
	
	//Description:acceptalert
	public void acceptalert() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>acceptalert",driver);
		Robot r = new  Robot();
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//Description:click on cancel alert
	public void dismissalert() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>dismissalert",driver);
		Robot r = new  Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	
	//Description:clickNext
	public void clickNext(){
		ResultUtil.report("INFO", "MapleGraphPage>clickNext",driver);
		Link.click("click on Next",clickNext,driver);
	}
	
	//Description: acceptalert
	public void assignLater(){
		ResultUtil.report("INFO", "MapleGraphPage>acceptalert",driver);
		Button.click("click on other assign later",assignlater ,driver);
	}
	
	//Description:clickCreateAssignment
	public void clickCreateAssignment(){
		ResultUtil.report("INFO", "MapleGraphPage>clickCreateAssignment",driver);
		WebElement createNewAsgn=driver.findElement(By.id("Create_New_Assignment"));
		Button.click("CreateNewAssignment", createNewAsgn, driver);
	}
	
	//Description:describeAssignment
	public void describeAssignment(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>describeAssignment",driver);
		//entering assignment id
		WebElement asgnID=driver.findElement(By.name("ag_refcode"));
		String strAsgnId=dataMap.get("assignid");
		TextBox.enterValue("Assignment ID", asgnID, strAsgnId, driver);
		//enter name
		WebElement AsgnName=driver.findElement(By.name("ag_name"));
		String strAsgnName=dataMap.get("assignname");
		TextBox.enterValue("Assignment Name", AsgnName, strAsgnName, driver);
		//click on next
		WebElement next=driver.findElement(By.id("Next"));
		Button.click("Next", next, driver);
	}
	
	//Description:clickAssignName
	public void clickAssignName(){
		ResultUtil.report("INFO", "MapleGraphPage>clickAssignName",driver);
		Sync.waitForObject(driver,"click assignment link" , "XPATH","lnkassignname");
		Link.click("click the link", lnkassignname, driver);
	}
	
	//Description:clickMapleGraph
	public void clickMapleGraph() throws Exception  {
		ResultUtil.report("INFO", "MapleGraphPage>clickMapleGraph",driver);
		switchWindow1();
		Button.click("click on next", lnknext, driver);
		Link.verify("image", lnkmaple,driver);
	}
	
	//Description: close browser
	public void closeBrowser()   {
		ResultUtil.report("INFO", "MapleGraphPage>closeBrowser",driver);
		driver.quit();
	}
	
	//Description:editAssignment also set strGo1 in input xl sheet according to the assignment name go in list of assignments
	public void editAssignment(Map<String,String> datamap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>editAssignment",driver);
		Combobox.selectItemByValue("select edit assignment..", cmbeditbox, "Edit Assignment", driver);
		Button.click("click on go",btngeneralGo,driver);
		clickCancelbtn();
	}
	
	//Description:hidecheck assignment
	public void hidechkAssignment() {
		ResultUtil.report("INFO", "MapleGraphPage>hideAssignment",driver);
		Checkbox.check("check hide", chkhide, driver);
	}
	
	//Description:delete assignment
	public void deleteAssignment(Map<String,String> datamap){
		ResultUtil.report("INFO", "MapleGraphPage>deleteAssignment",driver);
		Combobox.verifySelectedItem("select edeleteAssignment..", cmbdeletebox, "Delete Assignment", driver);
		Button.click("click on go",btngeneralGo,driver);
	}
	
	//Description:editAssignment
	public void copyeditAssignment(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>editAssignment",driver);
		Combobox.selectItemByValue("select edit assignment..", cmbdeletebox, "Copy & Edit", driver);
		Button.click("click on go",btngeneralGo,driver);
	}
	
	//Description:restoreAssignment
	public void restoreAssignment(){
		ResultUtil.report("INFO", "MapleGraphPage>restoreAssignment",driver);
		Combobox.verifySelectedItem("select Restore",cmbboxrestorename,"Restore",driver);
	}
	
	//Description:unassignrestore
	public void unAssignrestoreAssignment() {
		ResultUtil.report("INFO", "MapleGraphPage>unAssignrestoreAssignment",driver);
		Combobox.selectItemByValue("Select Restore in drop down", cmbboxrestorename,"Unassign",driver);
	}
	
	//Description: ClearAssignment
	public void ClearAssignment(){
		ResultUtil.report("INFO", "MapleGraphPage>ClearAssignment",driver);
		Combobox.verifySelectedItem("select Restore",cmbboxrestorename,"Clear",driver);
	}
	
	//Description:editAssignment
	public void verifyText(){
		ResultUtil.report("INFO", "MapleGraphPage>editAssignment",driver);
		Element.verify("verify text", lbltext,driver);
	}
	
	//Description:clickActionsGo,change strgo value in the input xl 
	public void clickActionsGo(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>clickActionsGo",driver);
		String strGo = dataMap.get("clickactionsgo");
		WebElement btnactionsGo= driver.findElement(By.id(strGo));
		Button.click("Click Go after ", btnactionsGo, driver);
	}
	
	//Description:click on restore go button,change the strgo2 value in the input sheet
	public void clickRestoreGo(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>clickRestoreGo",driver);
		Button.click("Click Go after ", btngeneralGo, driver);
	}
	
	//Description:click on assigngo button
	public void clickassignGo() {
		ResultUtil.report("INFO", "MapleGraphPage>clickassignGo",driver);
		Button.click("Click Go after ", btngeneralGo, driver);
	}
	
	//Description:unAssignAssignment
	public void unAssignAssignment(Map<String,String> dataMap) throws Exception {
		ResultUtil.report("INFO", "MapleGraphPage>unassignAssignment",driver);
		switchWindow0();
		Combobox.selectItemByValue("Select unassign from drop down", cmbgeneralbox,"Unassign", driver);
		Button.click("Click Go after unassign ", btngeneralGo, driver);
	}		
		
	//Description:click on editavail assignment
	public void editavailAssignment(Map<String,String> dataMap) {
		ResultUtil.report("INFO", "MapleGraphPage>editAvailabilityAssignment",driver);
		Combobox.selectItemByValue("select edit availablility", cmbgeneralbox, "Edit Availability", driver);
		Button.click("Click Go after unassign ", btngeneralGo, driver);
	}	
		
	//Description:click on hide assignment
	public void hideassignAssignment(Map<String,String> dataMap) {
		ResultUtil.report("INFO", "MapleGraphPage>hideassignAssignment",driver);
		Combobox.selectItemByValue("Select assign from drop down", cmbgeneralbox,"Assign", driver);
		Button.click("availedit", btngeneralGo, driver);
	}
	
	//Description:click on hideunassign
	public void hideunassignAssignment(Map<String,String> dataMap) {
		ResultUtil.report("INFO", "MapleGraphPage>hideunassignAssignment",driver);
		Combobox.selectItemByValue("Select unassign from drop down", cmbgeneralbox,"UnAssign", driver);
		Button.click("availedit", btngeneralGo, driver);
	}
	
	//Description:select assign option from combe box
	public void assignAssignment(Map<String,String> dataMap) {
		ResultUtil.report("INFO", "MapleGraphPage>assignAssignment",driver);
		Combobox.selectItemByValue("Select assign from drop down", cmbgeneralbox,"Assign", driver);
		Button.click("click and go",btngeneralGo , driver);
	}
	
	//Description:click on assign cancel button
	public void assigncancel() {
		ResultUtil.report("INFO", "MapleGraphPage>assignAssignment",driver);
		Sync.waitForObject(driver, "wait for cancel","XPATH", "btnassignedcancel");
		Button.click("select cancel",btnassignedcancel,driver);
	}
	
	//Description:assigngoSubmit
	public void assigngoSubmit() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>assigngoSubmit",driver);
		Checkbox.check("check class section", driver.findElement(By.id("cls335947_ag_state")), driver);
		WebElement submit=driver.findElement(By.id("Submit"));
		Button.click("submit", submit, driver);
		switchWindow1();
		WebElement close=driver.findElement(By.xpath("//a[@id='Close']"));
		Button.click("close", close, driver);
	}
	
/*	//Description: Check Box in Maple
	public void checkboxMaple(){
		ResultUtil.report("INFO", "MapleGraphPage>checkboxMaple",driver);
		Checkbox.check("check class section", driver.findElement(By.xpath("//input[@id='cls335947_ag_state']")), driver);
	}
*/	
	//Description: Click Assign Combo Box
	public void clickassigncomboboxgo(Map<String,String> dataMap) {
		ResultUtil.report("INFO", "MapleGraphPage>clickassigncomboboxgo",driver);
		String strgo = dataMap.get("strcopyeditassignment");
		Button.click("click go", driver.findElement(By.id(strgo)), driver);
	}
	
	//Description: Click Submit maple
	public void clickMaplesubmit() throws Exception{
		WebElement submit=driver.findElement(By.id("Submit"));
		Button.click("submit", submit, driver);
		switchWindow1();
		WebElement close=driver.findElement(By.xpath("//a[@id='Close']"));
		Button.click("close", close, driver);
	}
	
	//Description:for tc edit availability,assigning a course as a precondition,3rd element should be assigned
	public void editAvailabilityAssignment(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>editAvailabilityAssignment",driver);
		switchWindow0();
		Combobox.selectItemByValue("select edit availablility", cmbgeneralbox, "Edit Availability", driver);
		clickassignGo();
		WebElement submit=driver.findElement(By.id("Submit"));
		Button.click("submit", submit, driver);
		switchWindow1();
		WebElement close=driver.findElement(By.xpath("//a[@id='Close']"));
		Button.click("close", close, driver);
	}
	
	//Description:selectQuestion
	public void selectQuestion() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>selectQuestion",driver);
		clickNext();
		//go to organize and score questions
		clickNext();
		//click on apply point potential
		Checkbox.check("apply point",applypotential, driver);
		//click on check box of apply potential
		clickNext();
	}
	
	//Description: verify tabs text
	public void verifyTabsText(){
		ResultUtil.report("INFO", "MapleGraphPage>verifyTabsText",driver);
		Button.verify("select describe tab", btndescassign, driver);
		Button.verify("select describe tab", btnselquestion, driver);
		Button.verify("select describe tab", btnorganize, driver);
		Button.verify("select describe tab", btnsetqpolicy, driver);
		Button.verify("select describe tab", btnconfirm, driver);
	}
	
/*	//Description:Test Case E4-4438: Create a new question pool including a MG question
	public void clickQuestion() {
		ResultUtil.report("INFO", "MapleGraphPage>clickQuestion",driver);
		Button.click("header", btnheader, driver);
		Button.click("click question pool" , btnpool , driver);
		Button.click("click next", btnnext, driver);
		driver.findElement(By.id("applyFilters")).click();
		Checkbox.check("check quest",chkquest, driver);
		driver.findElement(By.id("Next")).click();
	}
*/	
	//Description:click on questions tab of demo-instructor login
	public void clickMGQuestion() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickmgQuestion",driver);
		Sync.waitForObject(driver, "click mg questions","XPATH", "btnmgquestions");
		Button.click("click on questions", btnmgquestions, driver);
		Button.click("questions", driver.findElement(By.id("applyFilters")), driver);
	}	
	
	//Description:to access gradebook
	public void accessGradebook() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>accessGradebook",driver);
		Sync.waitForObject(driver, "click gradebook","XPATH", "clickGB");
		Button.click("click gradebook",clickGB, driver);
		Combobox.selectItemByValue("select class section", cmbgbbox, "sectiontest12-started", driver);
		Button.click("applyGBSetings", driver.findElement(By.id("applyGBSetings")), driver);
	}
	
	//Description:click on gradebook
	public void clickGradebook() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickGradebook",driver);
		Button.click("click gradebook",clickGB, driver);
	}
	
/*	//Description:edit properties of student view login
	public void manualEditstudentView() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>manualEditstudentView",driver);
		Sync.waitForObject(driver, "click gradebook","ID", "stringstudentview");
		Button.click("click on student view",btnstudentview, driver);
		driver.findElement(By.id("Gocls334372")).click()
	}
*/	
	//Description:click on question mgmt link
	public void questionsMgmt() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>questionsMgmt",driver);
		Button.click("Header",btnheader, driver);
		Button.click("Question Pool",btnpool, driver);
		Button.click("Next",btnnext, driver);
	}
	
	//Description:click on gradebook link
	public void gradebookGo() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>gradebookGo",driver);
		Button.click("ClickGradebookGo", GradebookGo,driver);
	}
	
	//Description:student grade link
	public void studentgrade() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>studentgrade",driver);
		Link.click("StudentHyperLink", clickStudent,driver);
	}
	
	//Description:click on report content
	public void reportContent() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>reportContent",driver);
		Link.click("Reporterror", reportError,driver);
	}
	
	//Description: student view 
	public void studentView(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>studentView",driver);
		Sync.waitForFrame(driver, "IFrame", 0, 4);
		Button.click("StudentLoginformtirumala", studentView,driver);
		String studentviewgo= dataMap.get("studentviewgo");
		WebElement studentViewGo = driver.findElement(By.id(studentviewgo));
		Button.click("StudentloginViewGo",studentViewGo,driver);
		Sync.waitForFrame(driver, "IFrame", 0, 4);
		Link.click("assignment", assignLink,driver);
		Link.click("assignmentclick", clickassignnameLink,driver);
		Button.click("studentgb", studentGradebook,driver);
	}
	
	//click on student view 
	public void gotostudentview(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>studentLogin",driver);
		String studentviewgo= dataMap.get("studentviewgo");
		WebElement studentViewGo = driver.findElement(By.id(studentviewgo));
		Button.click("GO TO STUDENT VIEW", studentView,driver);
		Button.click("StudentloginViewGo",studentViewGo,driver);
	}
	
	//Test Case E4-4442: Manipulate a Maple worksheet to construct a correct answer
	public void studentLogin(Map<String,String> dataMap) throws Exception{
		gotostudentview(dataMap);
		clickstudentassign();
	}
	
	//Description:access diagnostic info
	public void clickINstructordiagnosticassignments(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickstudentassign",driver);
		Link.click("click on assignment", lnkstuassign,driver);
		Link.click("click ion diagnostic", lnkdiagnostic,driver);
		gotoinstructorview();
		focusAg_nav_top();
		clickNext();
		driver.findElement(By.id("saveanswerbutId")).click();
		Button.click("click on assignment", lnkstuassign,driver);
		clickAssignmentGo();
		unAssignAssignment(dataMap);
	}
	
	//Description:go to instructor view
	public void gotoinstructorview() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>gotoinstructorview",driver);
		driver.findElement(By.id("Instructor_View")).click();
	}
	
	//Description:in student login click on assign
	public void clickstudentassign() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickstudentassign",driver);
		Button.click("click on assignment", lnkstuassign,driver);
		Link.click("assignment", clickassignnameLink,driver);
		focusAg_nav_top();
		Link.click("Next Question", clickNext,driver);
		Link.click("Next Question", clickNext,driver);
		Link.click("Next Question", clickNext,driver);
	}
	
	//Description:click on button which has submit answer
	public void submitAnswer() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>submitAnswer",driver);
		focusAgbodyFrame();
		Button.click("Submit Answer", SaveButton,driver);
	}
	
	//Description:gradebook in student login
	public void clickstudentGradeBook() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickstudentGradeBook",driver);
		Sync.waitForFrame(driver, "IFrame", 0, 4);
		Button.click("Gradebook", clickstuGradeBook,driver);
	}
	
	//Description:click on printer version tab
	public void clickPrinterTab() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickPrinterTab",driver);
		focusAg_nav_top();
		Button.click("click on print version",lnkprinttab,driver);
	}
	
	//Description:click on course in admin login
	public void adminCourses() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>adminCourses",driver);
		switchFrameCourseListTable();
		Link.click("click on courses", lnkcourses,driver);
	}
	
	//Description:select switch frame course
	public void switchFrameCourseListTable(){
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe", "mainframe", 4);
		Sync.waitForFrame(driver, "userframe", "userframe", 4);
		Sync.waitForFrame(driver, "navigator", "navigator", 4);
	}
	
	//Description:switch frames
	public void switchFrameRegression(){
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "Mainframe", "mainframe", 4);
		Sync.waitForFrame(driver, "userframe", "userframe", 4);
		Sync.waitForFrame(driver, "workframe", "workframe", 4);
	}
	
	//Description:switch frames
	public void switchFrameContent(){
		switchFrameRegression();
		Sync.waitForFrame(driver, "coursenav", "coursenav", 4);
	}
	
	//Description:select course
	public void accessCourse(){
		switchFrameRegression();
	 	ResultUtil.report("INFO", "MapleGraphPage>accessCourse",driver);
		Link.click("click on regression", lnkcourse,driver);
	}
	
	//Description:click on content updates 
	public void contentUpdates(){
		ResultUtil.report("INFO", "MapleGraphPage>contentUpdates",driver);
		switchFrameContent();
		Link.click("click on content updates",btncontent,driver);
	}
	
	//Description:click on testbanks link
	public void clicktestbanks(){
		switchFrameRegression();
		Sync.waitForFrame(driver, "courseworkframe", "courseworkframe", 4);
		ResultUtil.report("INFO", "MapleGraphPage>contentUpdates",driver);
		Link.click("click on content updates", btntestbank,driver);
	}
	
	//Description:click on question mgmt
	public void clickquestionmgmt(){
		switchFrameRegression();
		Sync.waitForFrame(driver, "courseworkframe", "courseworkframe", 4);
		ResultUtil.report("INFO", "MapleGraphPage>clickquestionmgmt",driver);
		Link.click("Questions Management", driver.findElement(By.xpath("//a[@title='Questions Management']")), driver);
	}
	
	//Description:click on mg properties
	public void clickmgproperties(){
		ResultUtil.report("INFO", "MapleGraphPage>clickmgproperties",driver);
		Combobox.selectItemByValue("select properties",cmbgeneralbox ,"Properties",driver);
		Button.click("mgproperties", btngeneralGo, driver);
	}
	
	//Description:click on element GM
	public void elementGM() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>elementGM",driver);
		Element.verify("check graphing maple",eleGM,"Graphing-Maple",driver);
	}
	
/*	//Description:click on go
	public void clickQuestionGo() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>elementGM",driver);
		Button.click("Go", btnGo, driver);
		Checkbox.check("select questions after go", driver.findElement(By.name("chk_quest2463022")), driver)
	}
*/	
	//Description:click ConfigurationTab
	public void clickConfigurationTab () throws Exception{
		switchFrameCourseListTable();
	 	ResultUtil.report("INFO", "MapleGraphPage>clickConfigurationTab",driver);
		Link.click("click on Configuration", elmConficurationTab,driver);
	}
	
	//Description:save MapleGraphingSharedSecretKey value into local variable
	public void saveMapleGraphingSharedSecretKey () throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>saveMapleGraphingSharedSecret",driver);
		switchFrameRegression();
		strMapleGraphingSharedSecretKey = elmMngSharedSecret.getAttribute("value");
		ResultUtil.report("MESSAGE", "MapleGraphingSharedSecretKey["+elmMngSharedSecret.getText()+"]",driver);
	}
	
	//Description:verify MGSharedSecretKey text box after navigate the another tab
	public void verifyMGSharedSecretKeyWithoutApply(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>verifyMGSharedSecretKeyWithoutApply-a",driver);
		switchFrameRegression();
		TextBox.clearValue("MG Shared Secret Key Value", elmMngSharedSecret, driver);
		TextBox.enterValue("MG Shared Secret Key Temp Value", elmMngSharedSecret, dataMap.get("MGSharedSecretKey"), driver);
		clickBlockBoardImTab();
		clickServerTab();
		switchFrameRegression();
		if(!dataMap.get("MGSharedSecretKey").equalsIgnoreCase(elmMngSharedSecret.getAttribute("value"))){
			ResultUtil.report("MESSAGE", "Data Input["+dataMap.get("MGSharedSecretKey")+"]    MapleGraphingSharedSecretKey["+elmMngSharedSecret.getText()+"]   Both are not equal",driver);
		}
	}
	
	//Description:verify MGSharedSecretKey text box after click Apply button
	public void verifyMGSharedSecretKeyWithApply(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>verifyMGSharedSecretKeyWithApply",driver);
		switchFrameRegression();
		TextBox.clearValue("MG Shared Secret Key Value", elmMngSharedSecret, driver);
		TextBox.enterValue("MG Shared Secret Key Temp Value", elmMngSharedSecret, dataMap.get("MGSharedSecretKey"), driver);
		Button.click("Maple Graph Page Apply", btnApply, driver);
		clickBlockBoardImTab();
		clickServerTab();
		switchFrameRegression();
		String strSharedSecretKey = elmMngSharedSecret.getAttribute("value");
		if(dataMap.get("MGSharedSecretKey").equalsIgnoreCase(strSharedSecretKey)){
			ResultUtil.report("MESSAGE", "Data Input["+dataMap.get("MGSharedSecretKey")+"]    MapleGraphingSharedSecretKey["+strSharedSecretKey+"]   Both are not equal",driver);
		}
	}
	
	//Description:click BlockBoardIm Tab
	public void clickBlockBoardImTab(){
		ResultUtil.report("INFO", "MapleGraphPage>clickBlockBoardImTab",driver);
		switchFrameCourseListTable();
		Sync.waitForObject(driver, "BlockBoardImTab", "XPATH", "//span[contains(.,'Blackboard')]");
		Button.click("BlockBoardIm Tab", elmBlackboardTab, driver);
	}
	
	//Description:click ServerTab
	public void clickServerTab(){
		ResultUtil.report("INFO", "MapleGraphPage>clickServerTab",driver);
		switchFrameCourseListTable();
		Button.click("Server Tab", elmServerTab, driver);
	}
	
	//Description:save Initial MapleGraphingSharedSecret Key
	public void saveIntialMapleGraphingSharedSecretKey () throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>saveIntialMapleGraphingSharedSecretKey",driver);
		switchFrameRegression();
		String strSecretKey = elmMngSharedSecret.getAttribute("value");
		if(!strSecretKey.equalsIgnoreCase(strMapleGraphingSharedSecretKey)){
			TextBox.clearValue("Modified MG Shared Secret Key Value", elmMngSharedSecret, driver);
			TextBox.enterValue("Intial MapleGraphing Shared SecretKey", elmMngSharedSecret, strMapleGraphingSharedSecretKey, driver);
			Button.click("Maple Graph Page Apply", btnApply, driver);
		}
		ResultUtil.report("MESSAGE", "MapleGraphingSharedSecretKey["+strSecretKey+"]",driver);
	}
	
	//Description:click on GM Assign link
	public void clickGMAssignlink() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickGMAssignlink",driver);
		Button.click("Maple Class", driver.findElement(By.xpath("//a[.='mapleClass']")), driver);
	}
	
	//Description:click on student gradebook
	public void clickStuGMGradebook() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickStuGMGradebook",driver);
		Sync.waitForFrame(driver, "iframe", "iframe", 4);
		Button.click("click on gradebook",btngb , driver);
	}
	
	//Description:click on GMcourse
	public void clickonGMcourse(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickonGMcourse",driver);
		String strcourse = dataMap.get("strcourse");
		Button.click("click on course",driver.findElement(By.xpath("//a[contains(.,'"+strcourse+"')]")) , driver);
	}
	
	//Description:click on maple link
	public void clickonmaplelink() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickonmaplelink",driver);
		Link.click("click on maple", lnkmapleassign, driver);
	}
	
	//Description:click on maple due past
	public void clickonmapleduepast() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickonmapleduepast",driver);
		Link.click("click on maple class", lnkmapleclass ,driver);
	}
	
	//Description:click on maple next
	public void clickmapleNext() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickmapleNext",driver);
		driver.switchTo().defaultContent();
		focusAg_nav_top();
		Button.click("click on Next",driver.findElement(By.xpath("//a[@id='Next']")),driver);
	}
	
	//Description:click on save for later
	public void clickdisabledsaveForLater() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickdisabledsaveForLater",driver);
		driver.switchTo().defaultContent();
		focusAgbodyFrame();
		Link.click("click on clickdisabledsaveForLater",savelater,driver);
	}
	
	//Description:click on gradebook
	public void clickonGradebook() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickonGradebook",driver);
		Sync.waitForObject(driver, "select gradebutton","XPATH", "clickGB");
		Button.click("click on Next",clickGB,driver);
	}
	
	//Description:click on properties assignment,
	public void propertiesAssignment(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>propertiesAssignment",driver);
		String strgo = dataMap.get("propertiescombo");
		WebElement cmbpropbox = driver.findElement(By.id(strgo));
		Combobox.selectItemByValue("select properties of assignment..", cmbpropbox, "Properties", driver);
		String strgo1 = dataMap.get("propertiesgo");
		WebElement cmbpropbox2 = driver.findElement(By.id(strgo1));
		Button.click("click on go",cmbpropbox2,driver);
	}
	
	//Description:click on print assign
	public void clickonPrintAssign() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickonPrintAssign",driver);
		Button.click("click on clickonPrintAssign",printassign,driver);
	}
	
	//Description:click on closed dialog
	public void clickclosedialog() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickclosedialog",driver);
		String strWindowHandle = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("Dialog", driver, strWindowHandle);
		driver.manage().window().maximize();
		Button.click("click on clickclosedialog",closedialog,driver);
		String strMainWindow = driver.getWindowHandles().toArray()[0].toString();
		Window.focusWindow("Main", driver, strMainWindow);
	}
	
	//Description:click on verify help
	public void verifyHelp() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>verifyHelp",driver);
		String strWindowHandle = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("Dialog", driver, strWindowHandle);
		Element.verify("check help text", elehelplink, "Get help answering Graphing-Maple questions.", driver);
	}
	
	//Description:click on verifyhelp
	public void verifystuHelp() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>verifystuHelp",driver);
		try{
			Sync.waitForFrame(driver, "IFrame", 0, 4);
		}
		catch(Exception e){}
		driver.findElement(By.xpath("//a[contains(.,'Help')]")).click();
	}
	
	//Description:closing window pop up
	public void windowclose() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>windowclose",driver);
		switchWindow1();
		driver.close();
	}
	
	//Description:maple graph question pool btn
	public void clickMGQuestionPoolbtn() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>MGQuestionPoolbtn",driver);
		Sync.waitForObject(driver, "select create quest","ID", "btnpool");
		Button.click("click on pool", btnpool, driver);
	}
	
	//Description:click on cancel button
	public void clickCancelbtn() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickCancelbtn",driver);
		Sync.waitForObject(driver, "select create quest","ID", "btncancel");
		Button.click("click on button", btncancel, driver);
	}
	
	//Description:click on mg create question
	public void clickMGCreateQuestion() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickCancelbtn",driver);
		Sync.waitForObject(driver, "select create quest","ID", "btncreatequest");
		Button.click("click mg question",btncreatequest , driver);
	}
	
	//Description:click on gradebook maple graph questions
	public void clickGBMG() throws Exception{
		Sync.waitForFrame(driver, "instructorGbFrame", "instructorGbFrame", 4);
		Sync.waitForFrame(driver, "gblev1frames2h", "gblev1frames2h", 4);
		ResultUtil.report("INFO", "MapleGraphPage>clickGBMG",driver);
		driver.findElement(By.xpath("//a[contains(.,'Instructor, Demo')]")).click();
	}
	
	//Description:click CoursesName Link
	public void clickCoursesNameLink(Map<String,String> dataMap) throws Exception{
		switchFrameRegression();
		ResultUtil.report("INFO", "MapleGraphPage>clickCoursenamelink",driver);
		String strCoursesName=dataMap.get("CoursesName");
		WebElement lnkCoursesName = driver.findElement(By.xpath("//a[contains(.,'"+strCoursesName+"')]"));
		Link.click("click on Courses Name", lnkCoursesName,driver);
	}
	
	//Description:click Assignment Management Link
	public void clickAssignmentManagementLink() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickAssignmentManagementLink",driver);
		switchquestionmgmtFrame();
		WebElement lnkCoursesName = driver.findElement(By.xpath("//a[@title='Assignment Management']"));
		Link.click("click on Courses Name", lnkCoursesName,driver);
	}
	
	//Description:click Create Question Pool button
	public void clickCreateQuestionPool() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickCreateQuestionPool",driver);
		switchFrameRegression();
		WebElement lnkCoursesName = driver.findElement(By.xpath("//a[contains(.,'Create Question Pool')]"));
		Link.click("click on Courses Name", lnkCoursesName,driver);
	}
	
	//Description:click Next button
	public void clickFrameNextButton() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickNextButton",driver);
		switchFrameRegression();
		Link.click("click on Courses Name", btnNext,driver);
	}
	
	//Description: Click Next button
	public void clickNextButton() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickNextButton",driver);
		Link.click("click NextButton", btnNext,driver);
	}
	
	//Description:click Next button
	public void clickGoButton() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickGoButton",driver);
		switchFrameRegression();
		Link.click("click on Courses Name", btnGo,driver);
	}
	
	//Description:click on switch frame
	public void switchFrameCoursework(){
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "mainframe", "mainframe", 4);
		Sync.waitForFrame(driver, "userframe", "userframe", 4);
		Sync.waitForFrame(driver, "workframe", "workframe", 4);
		Sync.waitForFrame(driver, "qmanagerhead", "qmanagerhead", 4);
	}
	
	//Description: Switch to Course Work frame
	public void switchquestionmgmtFrame(){
		driver.switchTo().defaultContent();
		Sync.waitForFrame(driver, "mainframe", "mainframe", 4);
		Sync.waitForFrame(driver, "userframe", "userframe", 4);
		Sync.waitForFrame(driver, "workframe", "workframe", 4);
		Sync.waitForFrame(driver, "courseworkframe", "courseworkframe", 4);
	}
	
	//Description:click on assignment link
	public void clickAssignmentlink(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickonmaplelink",driver);
		String strAssignmentName=dataMap.get("AssignmentName");
		WebElement lnkAssignmentName = driver.findElement(By.xpath("//a[contains(.,'"+strAssignmentName+"')]"));
	    Link.click("Click Assignment Name", lnkAssignmentName, driver);
	}
	
	//Description:edit MGShared SecretKey Value
	public void editMGSharedSecretKeyValue(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>editMGSharedSecretKeyValue",driver);
		switchFrameRegression();
		TextBox.clearValue("MG Shared Secret Key Value", elmMngSharedSecret, driver);
		TextBox.enterValue("MG Shared Secret Key Temp Value", elmMngSharedSecret, dataMap.get("MGSharedSecretKey"), driver);
		Button.click("Maple Graph Page Apply", btnApply, driver);
	}
	
	//Description:click Submit Answer
	public void clickSubmitAnswer() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickSubmitAnswer",driver);
		driver.switchTo().defaultContent();
		focusAgbodyFrame();
		Button.click("click on Next",driver.findElement(By.xpath("//a[@id='saveanswerbutId']")),driver);
	}
	
	//Description:click on maple gradebook
	public void clickMapleStudentGradebook() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>accessGradebook",driver);
		Sync.waitForFrame(driver, "iframe", "iframe", 4);
		Button.click("click gradebook",clickGB, driver);
	}
	
	//Description:verify Roll Over PopupWindow 
	public void verifyRollOverPopupWindow(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>verifyRollOverPopupWindow",driver);
		switchFrameRegression();
		String strMappleGraphLinkName="Multistep Maple";
		WebElement lnkMappleGraphLinkName = driver.findElement(By.xpath("//table[@class='plain-table']//a[contains(text(),'"+strMappleGraphLinkName+"')]"));
	    Link.mouseOver("MappleGraph LinkName", lnkMappleGraphLinkName, 3, driver);
	}
	
/*	//Description:click on WPRSP
	public void clickWPRSP() throws Exception{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickWPRSP",driver);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("contentFrame")));
		Link.click("CLick on Wiley PLus ReadStudeyPractice", lnkRSP,driver);
	}
*/	
	//Description:click image placeholder
	public void clickImagePlaceholderWPRSP() throws Exception{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickWPRSP",driver);
		Sync.waitForFrame(driver, "iframe", "iframe", 4);
		Link.click("CLick on Wiley PLus ReadStudeyPractice", lnkimageRSP,driver);
	}
	
	//Description:click Create Question Pool button
	public void clickCreateQuestionPoolInstructor() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickCreateQuestionPoolInstructor",driver);
		Sync.waitForObject(driver, "click course","XPATH", "lnkCoursesName");
		WebElement lnkCoursesName = driver.findElement(By.xpath("//a[contains(.,'Create Question Pool')]"));
		Link.click("click on Courses Name", lnkCoursesName,driver);
	}
	
	//Description:click Next button
	public void clickNextButtonInstructor() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickNextButtonInstructor",driver);
		Sync.waitForObject(driver, "click course","XPATH", "btnNext");
		Link.click("click on Courses Name", btnNext,driver);
	}
	
	//Description:click Go button
	public void clickGoButtonInstructor() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickGoButtonInstructor",driver);
		Sync.waitForObject(driver, "click btn","XPATH", "btnGo");
		Link.click("click on Courses Name", btnGo,driver);
	}
	
	//Description:verify Roll Over PopupWindow 
	public void verifyRollOverPopupWindowInstructor(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>verifyRollOverPopupWindowInstructor",driver);
		String strMappleGraphLinkName=dataMap.get("MappleGraphLinkName");
		WebElement lnkMappleGraphLinkName = driver.findElement(By.xpath("//a[contains(.,'"+strMappleGraphLinkName+"')]"));
	  Link.mouseOver("MappleGraph LinkName", lnkMappleGraphLinkName, 3, driver);
	}
	
	//Description:select CheckBox
	public void selectCheckBox(Map<String,String> dataMap){
		ResultUtil.report("INFO", "MapleGraphPage>verifyRollOverPopupWindowInstructor",driver);
	  	String strMappleGraphLinkName=dataMap.get("MappleGraphLinkName");
		WebElement lnkMappleGraphLinkName = driver.findElement(By.xpath("//a[contains(.,'"+strMappleGraphLinkName+"')]"));
	  Checkbox.check("MappleGraph LinkName", lnkMappleGraphLinkName, driver);
	}
	
	//Description:for image place holder
	public void clickIPHNext() throws Exception{
		ResultUtil.report("INFO", "BlackBoardIntegrationPage>clickIPHNext",driver);
		focusAg_nav_top();
		Button.click("click on Next",driver.findElement(By.id("Next")),driver);
	}
	
	//Description:clickDisableImmediateassign
	public void clickDisableImmediateassign() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickDisableImmediateassign",driver);
		Sync.waitForObject(driver, "link click","XPATH", "lnkdisableimmediate");
		Link.click("disable immediate", lnkdisableimmediate, driver);
	}
	
	//Description:click SaveForLater
	public void clickSaveForLater() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickSaveForLater",driver);
		driver.switchTo().defaultContent();
		focusAgbodyFrame();
		Button.click("click on SaveForLater",btnsaveforlater,driver);
	}
	
	//Description:Verify Save For Later
	public void VerifySaveForLater() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickmapleNext",driver);
		focusAgbodyFrame();
		Button.isEnabled(driver.findElement(By.xpath("//a[@id='Save_for_later']")) ,"SaveForLater is enabled",driver);
	}
	
	//Description:Verify Submit Answer
	public void VerifySubmitAnswer() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickmapleNext",driver);
		focusAgbodyFrame();
		Button.isEnabled(driver.findElement(By.xpath("//a[@id='saveanswerbutId']")) ,"SaveForLater is enabled",driver);
	}
	
	//Description:click Assignment Management Link
	public void clickQuestionsManagementLink() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickquestionmgmt",driver);
		switchquestionmgmtFrame();
		WebElement lnkCoursesName = driver.findElement(By.xpath("//a[@title='Questions Management']"));
		Link.click("click on question mgmt ", lnkCoursesName,driver);
	}
	
	//Description: click Assignment Management Link
	public void selectChapter(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>selectchapter",driver);
		switchFrameCoursework();
		WebElement elmchapterName = driver.findElement(By.xpath("//select[@name='chapter']"));
		Combobox.selectItemByValue("Select the Chapter", elmchapterName, "Chapter 1. Chapter 1 Title", driver);
	}
	
	//Description:click Go Image
	public void clickGoImage() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>goimage",driver);
		switchFrameCoursework();
		WebElement btngo = driver.findElement(By.name("gobut"));
		Link.click("click on go", btngo,driver);
	}
	
	//Description:click AssignmentLink
	public void clickAssignmentChapterLink(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickContantTab",driver);
		switchFrameCoursework();
		WebElement lnkCoursesName = driver.findElement(By.xpath("//p[contains(.,'Questions Management')]"));
		Link.click("click on Courses Name", lnkCoursesName,driver);
	}
	
	//Description:read studey practice
	public void clickRSPquestion() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickWPRSP",driver);
		driver.switchTo().frame("studentLwsFrame");
		Link.click("CLick on question", lnkassignment,driver);
		
	}
	
	//Description:open print dialog
	public void openprintdialog() throws Exception{
		Robot r = new  Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_P);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CANCEL);
	}
	
	//Description:read studey practice
	public void clickreportcontent() throws Exception{
		
		ResultUtil.report("INFO", "MapleGraphPage>clickreportcontent",driver);
		Sync.waitForObject(driver, "report error","XPATH", "lnkreport");
		Link.click("CLick on question", lnkreport,driver);
	}
	
	//Description:switchwindow
	public void switchWindow1() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>switchWindow",driver);
		String strWindowHandle = driver.getWindowHandles().toArray()[1].toString();
		Window.focusWindow("First", driver, strWindowHandle);
	}
	
	//Description:switchwindow
	public void switchWindow0() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>switchWindow",driver);
		String strWindowHandle = driver.getWindowHandles().toArray()[0].toString();
		Window.focusWindow("First", driver, strWindowHandle);
	}
	//Description: verify report error
	public void verifyReporterror() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>verifyReporterror",driver);
		Sync.waitForObject(driver, "report error","XPATH", "btnreport");
		Element.verify("report content error page", btnreport, "Report a Content Error", driver);
	}
	
	//Description:press enter
	public void pressEnter() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>pressEnter",driver);
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//Description:hidesubmit
	public void hidesubmit() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>hidesubmit",driver);
		JavascriptExecutor javascriptExecutor=((JavascriptExecutor)driver);		
		javascriptExecutor.executeScript("assignAG();");	
	}
	
	//Description:hideunchecksubmit
	public void hideunchecksubmit() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>hidesubmit",driver);
		Button.click("submit",btnhidesubmit, driver);
	}
	
	//Description:hideuncheck
	public void hideuncheck() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>hideuncheck",driver);
		Checkbox.unCheck("uncheck", chkhide, driver);
	}
	
/*	//Description:checkclasssection
	public void checkclasssection() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>checkclasssection",driver);
		Checkbox.check("checkclasssection", chkclass, driver);
	}
*/	
	//Description:click class submit
	public void clickclasssubmit() throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickclasssubmit",driver);
		Button.click("clickclasssubmit", classsubmit, driver);
	}
	
	//Description:assign verify
	public void assignverify(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>clickclasssubmit",driver);
		Sync.waitForObject(driver, "select assign","XPATH", "cmbboxassignName");
		Combobox.verifySelectedItem("verify assign in drop down",cmbgeneralbox,"Assign", driver);
	}
	
	//Description: create Assignment
	public void createAssignment(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "MapleGraphPage>createAssignment",driver);
		Button.click("create",btncreate,driver);
		TextBox.enterValue("enter value", driver.findElement(By.xpath("//input[@name='ag_refcode']")), dataMap.get("assignid"), driver);
		TextBox.enterValue("enter value", driver.findElement(By.xpath("//input[@name='ag_name']']")), dataMap.get("assignname"), driver);
		Button.click("click next", clickNext ,driver);
		Button.click("click go", btnGo, driver);
		Checkbox.check("click check",driver.findElement(By.xpath("//input[@name='chk_quest2404171']")) , driver);
		Button.click("click next", clickNext ,driver);
		Button.click("click next", clickNext ,driver);
		Button.click("click next", clickNext ,driver);
		Button.click("click assign", driver.findElement(By.id("Assign_to_Class_Section(s)")), driver);
	}
	
	//Description: Focus on Main Frame
	private void focusMainframe(){
		driver.switchTo().window(driver.getWindowHandle().toString());
		driver.switchTo().frame(0);
		if(Element.verify("Frame", driver, "Name", "studentLwsFrame")){
			driver.switchTo().frame("studentLwsFrame");
			driver.switchTo().frame("mainframe");
		}else{
			driver.switchTo().frame("mainframe");		
		}
		ResultUtil.report("PASS","Focused to MainFrame",driver);
	}
	
	//Description: Focus on Navigate top Frame
	private void focusAg_nav_top(){
		focusMainframe();
		driver.switchTo().frame("ag_nav_top");
		ResultUtil.report("PASS","Focused to Agnavtop Frmae",driver);
	}
	
	//Description: Focus on Body Frame 
	private void focusAgbodyFrame(){
		focusMainframe();
		driver.switchTo().frame("agrootframe");
		driver.switchTo().frame("agarea");
		driver.switchTo().frame("agbody");
		ResultUtil.report("PASS","Focused to Agbody frame",driver);
	}
}
	
	
	
	
	
