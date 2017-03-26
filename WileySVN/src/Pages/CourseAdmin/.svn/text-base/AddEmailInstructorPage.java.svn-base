package Pages.CourseAdmin;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Toolbox.Button;
import Toolbox.Element;
import Toolbox.ResultUtil;
import Toolbox.TextBox;

public class AddEmailInstructorPage {
	private final WebDriver driver;
	
@FindBy(how = How.NAME, using = "email")
private WebElement txtinstructorEmail;
	
@FindBy(how = How.ID, using = "Submit")
private WebElement btnSubmit ;

@FindBy(how = How.NAME, using = "firstname")
private WebElement txtFirstName;

@FindBy(how = How.NAME, using = "lastname")
private WebElement txtLastName;

@FindBy(how = How.NAME, using = "email")
private WebElement txtInstructorEmailid;

@FindBy(how = How.NAME, using = "emailConfirm")
private WebElement txtConfirmEmailid;

@FindBy(how = How.NAME, using = "password")
private WebElement txtInstructorPwd;

@FindBy(how = How.NAME, using = "passwordConfirm")
private WebElement txtConfirmPwd;

@FindBy(how = How.NAME, using = "phone")
private WebElement txtPhoneNumber;


	public AddEmailInstructorPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void  fillInstructorEmail(Map<String,String> dataMap, String strEmailId) throws InterruptedException
	{
		ResultUtil.report("INFO", "AddEmailInstructorPage>fillInstructorEmail", driver);
		//Verify the instructor screen
		Element.verify("Instructor Screen", driver, "XPATH", "//b[contains(text(),'Add Instructor')]");
		Element.verify("Email text", driver, "XPATH", "//td[text()='E-mail:']");
		Element.verify("Email textbox", txtinstructorEmail, driver);
		//Adding email address and click submit
		String _addMail = dataMap.get(strEmailId);
		TextBox.enterValue("Instructor Mail id", txtinstructorEmail, _addMail, driver);	
		Button.click("Submit", btnSubmit, driver);	
		}

	public NewInstructorPage fillAddForms(Map<String,String> dataMap, String strFirstName, String strLastName, String strEmailInstructor, String strPassword , String strPhone) //throws InterruptedException
	{
		ResultUtil.report("INFO", "AddEmailInstructorPage>fillAddForms", driver);
		
		// Declaring the value for the input
		String _firstName = dataMap.get(strFirstName);
		String _lastName = dataMap.get(strLastName);
		String _Email = dataMap.get(strEmailInstructor);
		String _confirmEmail = dataMap.get(strEmailInstructor);
		String _password = dataMap.get(strPassword);
		String _confirmPassword = dataMap.get(strPassword);
		String _Phone = dataMap.get(strPhone);
		
		//Entering the value for respective field
		TextBox.enterValue("Instructor First name", txtFirstName, _firstName, driver);
		TextBox.enterValue("Instructor Last name", txtLastName, _lastName, driver);
		TextBox.verifyValue("Email value", txtInstructorEmailid, _Email, driver);
		TextBox.enterValue("Reconfirm email id", txtConfirmEmailid, _confirmEmail, driver);
		TextBox.enterValue("Password", txtInstructorPwd, _password, driver);
		TextBox.enterValue("Re-confirm password", txtConfirmPwd, _confirmPassword, driver);
		TextBox.enterValue("Phone number", txtPhoneNumber, _Phone, driver);
		Button.click("Submit", btnSubmit, driver);
		return PageFactory.initElements(driver, NewInstructorPage.class);
	}
	
	public void validateFormField()
	{
		ResultUtil.report("INFO", "AddEmailInstructorPage>validateFormField", driver);
		
		//Validate the label and its respective field
		Element.verify("First name", driver, "XPATH", "//td[contains(text(),'First Name')]");
		Element.verify("First name textbox", txtFirstName, driver);
		Element.verify("Last name", driver, "XPATH", "//td[contains(text(),'Last Name')]");
		Element.verify("Last name textbox", txtLastName, driver);
		Element.verify("Email", driver, "XPATH", "//td[contains(text(),'E-mail')]");
		Element.verify("Email textbox", txtInstructorEmailid, driver);
		Element.verify("Retype email", driver, "XPATH", "//td[contains(text(),'Re-type E-mail')]");
		Element.verify("Retype email", txtConfirmEmailid, driver);
		Element.verify("Password", driver, "XPATH", "//td[contains(text(),'Password')]");
		Element.verify("Pass word textbox", txtInstructorPwd, driver);
		Element.verify("Retype Password", driver, "XPATH", "//td[contains(text(),'Re-type Password')]");
		Element.verify("Re type Pass word textbox", txtConfirmPwd, driver);
	}
}
