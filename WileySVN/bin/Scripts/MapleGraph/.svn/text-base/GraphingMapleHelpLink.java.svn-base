//1.9.7. Test Suite : Help Link
package Scripts.MapleGraph;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.MapleGraph.MapleGraphPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.*;

public class GraphingMapleHelpLink {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	//TTest Case E4-4950: Help Link - Instructor
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)	
	public void E4_4950(Map<String,String> dataMap) throws Exception{
		
		
		ResultUtil.createReport("GraphingMapleHelpLink-E4_4950",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//maxiomize window
		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//calling login
		mapleGraphPage.GraphingMapleInstructorlogin(dataMap);

		//click on assignment
		mapleGraphPage.clickAssignmentTab();
		//click on Go
		mapleGraphPage.clickMGQuestion();

		//enter details on the assignment
		mapleGraphPage.clickonmaplelink();

		//verify helplink
		mapleGraphPage.verifyHelp();
		
		//close the browser
	//	mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4955: Help Link - Student
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_4955(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("GraphingMapleHelpLink-E4_4955",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//maximize the window
		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		mapleGraphPage.GraphingMapleStudentlogin(dataMap);
		
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();
		
		//verification help
		mapleGraphPage.verifystuHelp();

		//close the browser
		mapleGraphPage.closeBrowser();

	}

}