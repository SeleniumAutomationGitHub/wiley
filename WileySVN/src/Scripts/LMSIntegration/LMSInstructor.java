package Scripts.LMSIntegration;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import Pages.LMSIntegration.InstructorPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;

public class LMSInstructor {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="InstructorPage",dataProviderClass=staticProviderClass.class)
	public LMSInstructor(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;

	}
	
	public void LMSInstructorPrerequiste() throws Exception{

		ResultUtil.createReport("LMSInstructor-LMSInstructorPrerequiste", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".LMS_URL");
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		//Login
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
		
		//instructor login
		instructorpage.instructorLogin(dataMap);

		//Navigate to instructor page
		driver=instructorpage.getDriver();
		
		
	}

	@Test
	public void Instructorprecondition() throws Exception{

		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
	
		
		instructorpage.selectCourse(dataMap);

		//Navigate to Classlist 
		instructorpage.selectClassList();

		//Press "Add Participants
		instructorpage.clickAddParticipants();

		//-> Press "Create and enroll a new user
		instructorpage.clickNewUser();

		//Fill required fields-> Press "Enroll" button
		instructorpage.enterInstructorDetails(dataMap);

		instructorpage.closeBrowser();
		
		
	}
	//Test Case E4-1223: WP-3rd party LMS - D2L - Instructor - EULA*****to do pending
	/*@Test
	public void E4_1223() throws Exception{

		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
		//select course
		
		instructorpage.selectCourse(dataMap);
		//Navigate to Classlist 

		instructorpage.accessContent();
		//select access halliday

		instructorpage.accessHallidaygb(dataMap);
		//verify help link	

		instructorpage.verifyhelplink();
		//verify system announcements

		instructorpage.verifysystemannouncement();

		//close page
		instructorpage.closeBrowser();

	}
*/
	//Test Case E4-1157: WP-3rd party LMS - D2L - Instructor - Gradebook
	@Test
	public void E4_1157() throws Exception{

		//call instructor page
		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);

			
		//Log in as Instructor -> Navigate to Course ( "WP QA Hoboken Regression Testing Section" is recommended
		instructorpage.selectCourse(dataMap);

		//click on content tool
		instructorpage.accessContent();

		//click on gradebook link
		instructorpage.accessHallidaygb(dataMap);

		instructorpage.verifygradebook();
		//click on go
		instructorpage.gbClickGo();
		
		instructorpage.closeBrowser();

	}

	@Test
	//E4-1158 testcase
	public void E4_1161() throws Exception{
	
		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
	
		//Log in as Instructor -> Navigate to Course ( "WP QA Hoboken Regression Testing Section" is recommended) -> Navigate to the Content Tool).
		instructorpage.selectCourse(dataMap);

		//go to content tool
		instructorpage.accessContent();

		//"E4-QA: Halliday, 7e - Create Questions" 
		instructorpage.accessResources(dataMap);

		//click on verify resources
		instructorpage.verifyresources();

		//click on go as last steps
		instructorpage.questionsClickGo();

		//verify help link
		instructorpage.verifyhelplink();

		//verify system announce ments
		instructorpage.verifysystemannouncement();

		//click add resources
		instructorpage.clickaddresources();


		instructorpage.closeBrowser();
	}

	@Test
	public void E4_1162() throws Exception{
		
		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
		
		//Log in as Instructor -> Navigate to Course ( "WP QA Hoboken Regression Testing Section" is recommended) -> Navigate to the Content Tool).
		instructorpage.selectCourse(dataMap);

		//go to content tool
		instructorpage.accessContent();
		//"E4-QA: Halliday, 7e - Create Questions" 
		instructorpage.accessQuestions(dataMap);

		instructorpage.verifyquestions();

		//clickon go as last steps
		instructorpage.questionsClickGo();

		instructorpage.verifyhelplink();

		instructorpage.verifysystemannouncement();

		instructorpage.closeBrowser();
	}

	@Test
	//E4-1158 testcase
	public void E4_1160() throws Exception{

		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
		
		//Log in as Instructor -> Navigate to Course ( "WP QA Hoboken Regression Testing Section" is recommended) -> Navigate to the Content Tool).
		instructorpage.selectCourse(dataMap);

		//go to content tool
		instructorpage.accessContent();

		//method for clicking on E4-QA: Halliday, 7e - Presentations" 
		instructorpage.accessPresentations();

		instructorpage.verifypresentations();
		
		//verify help link
		instructorpage.verifyhelplink();

		instructorpage.verifysystemannouncement();

			
		instructorpage.closeBrowser();
	}

	@Test
	//E4-1158 testcase
	public void E4_1158() throws Exception
	{
		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);

			//Select Course
		instructorpage.selectCourse(dataMap);
		//select acess content
		instructorpage.accessContent();

		instructorpage.clickassignments(dataMap);

		//click on roster
		instructorpage.assignClickGo();

		//verify assignments
		instructorpage.verifyassignments();

		//access help link
		instructorpage.verifyhelplink();

		//verify sysannouncements
		instructorpage.verifysystemannouncement();

		instructorpage.closeBrowser();
	}
	@Test	
	//E4-1159 testcase
	public void E4_1159() throws Exception{


		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);

		//Log in as Instructor -> Navigate to Course ( "WP QA Hoboken Regression Testing Section" is recommended) -> Navigate to the Content Tool).
		instructorpage.selectCourse(dataMap);

		//go to content tool
		instructorpage.accessContent();

		//method for clicking on E4-QA: Halliday, 7e - roster" 
		instructorpage.accessRoster();
		
		//verify roster
		instructorpage.verifyroster();

		//access LMS roster
		instructorpage.clickLMSRosterGo();

		instructorpage.closeBrowser();
	}

	//Test Case E4-1146: WP-3rd party LMS - D2L - Instructor - RSP**************to do pending
/*
	@Test
	public void E4_1146() throws Exception{

		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);

		//select course
		instructorpage.selectCourse(dataMap);
		
		//access content
		instructorpage.accessContent();

		//access gradebook
		instructorpage.accessHallidaygb(dataMap);

		//access helplink
		instructorpage.verifyhelplink();

		//verify sysannouncements
		instructorpage.verifysystemannouncement();

		instructorpage.closeBrowser();
	}
*/
	//Test Case E4-1208: WP-3rd party LMS - D2L - Instructor - RSP CH
	@Test
	//E4-1208 testcase
	public void E4_1208() throws Exception{
		
		LMSInstructorPrerequiste();
		
		InstructorPage instructorpage =PageFactory.initElements(driver, InstructorPage.class);
		
		//select course
		instructorpage.selectCourse(dataMap);

		//acess content
		instructorpage.accessContent();

		//clickon halliday
		instructorpage.accessHallidayCH1(dataMap);
		
		//access chapter
		instructorpage.verifychapter();
		
		//access studyguide
		instructorpage.clickstudyguide();

		//access ilearn
		instructorpage.clicklearn();

		instructorpage.closeBrowser();
	}



}


