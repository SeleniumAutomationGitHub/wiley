//Test Case E4-1222: WP-3rd party LMS - D2L - Student - Assignments

package Scripts.LMSIntegration;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import Pages.LMSIntegration.StudentPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;

public class LMSStudent {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="StudentPage",dataProviderClass=staticProviderClass.class)
	public LMSStudent(Map<String,String> dataMap)
	{

		this.dataMap= dataMap;
	}
	
	public void LMSStudentPrerequiste() throws Exception{

		ResultUtil.createReport("LMSStudent-LMSStudentPrerequiste", dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".LMS_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		//Login
		StudentPage studentpage =PageFactory.initElements(driver, StudentPage.class);

		studentpage.studentLogin(dataMap);

		//Navigate to instructor page
		driver=studentpage.getDriver();
	}
	@Test
	public void E4_1222() throws Exception{
		
		
		LMSStudentPrerequiste();
		
		StudentPage studentpage=PageFactory.initElements(driver, StudentPage.class);

		//select a "WP QA Hoboken Regression Testing Section
		studentpage.selectCourse(dataMap);

		//access content tool
		studentpage.accessContent();

		//access halliday
		studentpage.accessHallidayassign(dataMap);

		studentpage.verifyassignments();
		
		studentpage.closeBrowser();
		

	}

	@Test
	public void E4_1417() throws Exception{
			
		LMSStudentPrerequiste();
		
		StudentPage studentpage=PageFactory.initElements(driver, StudentPage.class);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentpage.selectCourse(dataMap);

		//Navigate to Classlist 
		studentpage.accessContent();

		//Press "Add Participants
		studentpage.accessHallidayRSP(dataMap);

		studentpage.closeBrowser();

	}

	@Test
	public void E4_1221() throws Exception{

		
		LMSStudentPrerequiste();
		
		StudentPage studentpage=PageFactory.initElements(driver, StudentPage.class);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentpage.selectCourse(dataMap);

		//access content tool
		studentpage.accessContent();

		//acess halliday
		studentpage.accessHallidayGB(dataMap);
		
		studentpage.closeBrowser();
	}

	@Test
	public void E4_1220() throws Exception{

		LMSStudentPrerequiste();
		
		StudentPage studentpage =PageFactory.initElements(driver, StudentPage.class);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentpage.selectCourse(dataMap);

		//access content tool
		studentpage.accessContent();

		//access student HallidayRSP
		studentpage.accessHallidayCH1(dataMap);

		studentpage.closeBrowser();
	}
	@Test
	public void E4_1209() throws Exception{

		LMSStudentPrerequiste();
		
		StudentPage studentpage=PageFactory.initElements(driver, StudentPage.class);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentpage.selectCourse(dataMap);

		//access content tool
		studentpage.accessContent();

		//access student HallidayRSP
		studentpage.accessHallidayRSP(dataMap);

		studentpage.closeBrowser();

	}
}













































