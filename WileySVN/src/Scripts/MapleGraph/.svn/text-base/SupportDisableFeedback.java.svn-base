//1.9.2. Test Suite : Support Disabled Immediate Feedback

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
import org.testng.annotations.Test;

import Pages.MapleGraph.MapleGraphPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;

@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
public class SupportDisableFeedback {


	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	//Test Case E4-4970: Support Disabled Immediate Feedback - Before Due Date - Student
	public void E4_4970(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.createReport("SupportDisableFeedback-E4_4970",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.SupportDisableStudentlogin(dataMap);
		
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on disable immediate assign
		mapleGraphPage.clickDisableImmediateassign();

		//click on maple next
		mapleGraphPage.clickmapleNext();

		//click on disable save for later
		mapleGraphPage.clickdisabledsaveForLater();

		//close the browser
		mapleGraphPage.closeBrowser();
	}

	//Test Case E4-5021: Support Disabled Immediate Feedback - Before Due Date - Instructor

	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_5021_1(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.createReport("SupportDisableFeedback-E4_5021_1",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.SupportDisableStudentlogin(dataMap);
		
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on maple link
		mapleGraphPage.clickonmaplelink();

		//click on maple next
		mapleGraphPage.clickmapleNext();

		//close the browser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-5021: Support Disabled Immediate Feedback - Before Due Date - Instructor
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void  E4_5021_2(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("SupportDisableFeedback-E4_5021_2",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.SupportDisableStudentlogin(dataMap);
		
		//click on student gm
		mapleGraphPage.clickStuGMGradebook();

		mapleGraphPage.closeBrowser();
	}		

	//Test Case E4-5134: Support Disabled Immediate Feedback - After Due Date - Student
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)

	public void E4_5134(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("SupportDisableFeedback-E4_5134",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		MapleGraphPage mapleGraphPage = home.SupportDisableStudentlogin(dataMap);

		mapleGraphPage.clickStuGMGradebook();

		mapleGraphPage.closeBrowser();

	}		

	//Test Case E4-5143: Support Disabled Immediate Feedback - After Due Date - Instructor
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_5143(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("SupportDisableFeedback-E4_5143",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();
		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		MapleGraphPage mapleGraphPage = home.SupportDisableStudentlogin(dataMap);
		//click on login user name

		//click on student gradebook
		mapleGraphPage.clickStuGMGradebook();

		//click on disable immidiate assign
		mapleGraphPage.clickDisableImmediateassign();			

		//close the browser
		mapleGraphPage.closeBrowser();

	}		

}
