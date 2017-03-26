
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

public class RenameToGraphingMapleInstructor {

	//Test Case E4-4899: Rename to Graphing-Maple - Instructor - Questions tab	
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_4899(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.createReport("RenameToGraphingMapleInstructor-E4_4899",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		mapleGraphPage.GraphingMapleInstructorlogin(dataMap);
		
		//click on Go
		mapleGraphPage.clickAssignmentTab();

		//click on mg question
		mapleGraphPage.clickMGQuestion();

		//click on mg properties
		mapleGraphPage.clickmgproperties();

		//element gm
		mapleGraphPage.elementGM();

		//close browser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4902: Rename to Graphing-Maple - Instructor - Question Assignment
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_4902(Map<String,String> dataMap) throws Exception{
		System.out.println("E4_4902");
		ResultUtil.createReport("RenameToGraphingMapleInstructor-E4_4902",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		mapleGraphPage.GraphingMapleInstructorlogin(dataMap);
		
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		mapleGraphPage.clickCreateAssignment();
		
		//click on Go
		mapleGraphPage.describeAssignment(dataMap);

		//click on question go
		//mapleGraphPage.clickQuestionGo();

		//click on next
		mapleGraphPage.clickNext();

		//element gm
		mapleGraphPage.elementGM();

		//click on next
		mapleGraphPage.clickNext();

		//click on next
		mapleGraphPage.clickNext();

		//assign later
		mapleGraphPage.assignLater();
		
		//close the browser
		mapleGraphPage.closeBrowser();

	}

	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	//Test Case E4-4905: Rename to Graphing-Maple - Instructor - Printed Test Assignment
	public void E4_4905(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.createReport("RenameToGraphingMapleInstructor-E4_4905",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.GraphingMapleInstructorlogin(dataMap);
		
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on mg question
		mapleGraphPage.clickMGQuestion();

		//click on mg properties
		mapleGraphPage.clickmgproperties();

		//element gm
		mapleGraphPage.elementGM();

		//close the browser
		mapleGraphPage.closeBrowser();



	}

	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	//Test Case E4-4906: Rename to Graphing-Maple - Student
	public void E4_4906(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.createReport("RenameToGraphingMapleInstructor-E4_4906",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		mapleGraphPage.GraphingMapleStudentlogin(dataMap);
		
		//click on student gradebook
		mapleGraphPage.clickStuGMGradebook();

		//click on maple link
		mapleGraphPage.clickonmaplelink();

		//element gm
		mapleGraphPage.elementGM();

		//close the browser
		mapleGraphPage.closeBrowser();


	}

}