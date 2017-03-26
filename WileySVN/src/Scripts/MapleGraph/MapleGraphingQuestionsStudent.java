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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.MapleGraph.MapleGraphPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;



public class MapleGraphingQuestionsStudent {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public MapleGraphingQuestionsStudent(Map<String,String> dataMap)
	{

		this.dataMap=dataMap;

	}
	public void MapleGraphingQuestionsStudentPrerequisite() throws Exception{

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();
		
		//Login
		MapleGraphPage mapleGraphPage = PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGStudentlogin(dataMap);

		//Navigate to instructor page
		driver=mapleGraphPage.getDriver();
	}

	//Test Case E4_4633: Student assignment player
	@Test
	public void E4_4633() throws Exception{

		ResultUtil.createReport("MapleGraphingQuestionsStudent-E4_4633",dataMap);

		MapleGraphingQuestionsStudentPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on domain user
		mapleGraphPage.clickstuDomainUser(dataMap);

		//login as instructor and go to student view	
		mapleGraphPage.clickAssignmentTab();

		//close the browser
		mapleGraphPage.closeBrowser();
	}

	//Test Case E4-4442: Manipulate a Maple worksheet to construct a correct answer
	@Test
	public void E4_4442() throws Exception{

		ResultUtil.createReport("MapleGraphingQuestionsStudent-E4_4442",dataMap);

		//presiquite to launch the application
		MapleGraphingQuestionsStudentPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click the domain user
		mapleGraphPage.clickstuDomainUser(dataMap);

		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on maple link
		mapleGraphPage.clickonmaplelink();

		//close the browser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4443: Save entries into a MG response field
	@Test
	public void E4_4443() throws Exception{

		ResultUtil.createReport("MapleGraphingQuestionsStudent-E4_4442",dataMap);

		MapleGraphingQuestionsStudentPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//closing browser
		mapleGraphPage.clickstuDomainUser(dataMap);
		
		//assignment tab
		mapleGraphPage.clickAssignmentTab();

		//clickon maple link
		mapleGraphPage.clickonmaplelink();

		//click on maple next
		mapleGraphPage.clickmapleNext();

		//click on save for later
		mapleGraphPage.clickSaveForLater();
	
		//close the browser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4444: Submit entries in the MG response field
	@Test
	public void E4_4444() throws Exception{
		System.out.println("E4_4444");

		ResultUtil.createReport("MapleGraphingQuestionsStudent-E4_4444",dataMap);
		MapleGraphingQuestionsStudentPrerequisite();


		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on the domain user
		mapleGraphPage.clickstuDomainUser(dataMap);

		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on maple link
		mapleGraphPage.clickonmaplelink();

		//click on next
		mapleGraphPage.clickmapleNext();

		//click on submit answer
		mapleGraphPage.clickSubmitAnswer();

		//close the browser
		mapleGraphPage.closeBrowser();

	}
	@Test
	public void E4_4445() throws Exception{

		ResultUtil.createReport("MapleGraphingQuestionsStudent-E4-4445",dataMap);

		//launching the browser as pre requisite
		MapleGraphingQuestionsStudentPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on domain user
		mapleGraphPage.clickstuDomainUser(dataMap);

		//click on student grade
		mapleGraphPage.clickstudentGradeBook();

		//click on maple
		mapleGraphPage.clickonmaplelink();

		//closing the browser
		mapleGraphPage.closeBrowser();

	}
	@Test
	//Test Case E4-4446: Print MG questions
	public void E4_4446() throws Exception{
		
		ResultUtil.createReport("mapleGraphPage-E4_4426",dataMap);
		
		MapleGraphingQuestionsStudentPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		mapleGraphPage.clickstuDomainUser(dataMap);

		//click on Go
		//click on create assignment
		mapleGraphPage.clickAssignmentTab();

		//enter details on the assignment
		mapleGraphPage.clickonmaplelink();
		
		//CLICK ON maple next
		mapleGraphPage.clickmapleNext();

		//printer dialog
		mapleGraphPage.openprintdialog();
		
		//close the browser
		mapleGraphPage.closeBrowser();

	}
}
