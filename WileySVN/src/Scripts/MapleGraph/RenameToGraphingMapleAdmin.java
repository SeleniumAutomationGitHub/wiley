//1.9. Test Suite : [PC-447] Phase 2 of Maple Graphing/WP integration
//1.9.1. Test Suite : Rename to Graphing-Maple


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
import Util.LMSMGDataProviderUtil.staticProviderClass;

public class RenameToGraphingMapleAdmin {

	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public RenameToGraphingMapleAdmin(Map<String,String> dataMap)
	{

		this.dataMap=dataMap;
	}
	public void RenameToGraphingMapleAdminPrerequisite() throws Exception{

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		//Login
		MapleGraphPage mapleGraphPage =PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGAdminlogin(dataMap);

		//Navigate to  page
		driver=mapleGraphPage.getDriver();
	}
	@Test
	public void E4_4908() throws Exception{

		System.out.println("E4_4908");
		ResultUtil.createReport("mapleGraphPage-E4_4908",dataMap);

		RenameToGraphingMapleAdminPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);
	
		//admin courser
		mapleGraphPage.adminCourses();
		
		//click on Go
		mapleGraphPage.accessCourse();

		//click on content updates
		mapleGraphPage.contentUpdates();

		//click on testbanks
		mapleGraphPage.clicktestbanks();

		
		mapleGraphPage.clickquestionmgmt();

			
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4913: Rename to Graphing-Maple - Admin - Question Assignment
	@Test
	public void E4_4913() throws Exception{
		
		ResultUtil.createReport("AdminQuestionAssignmentGrpahingMaple-E4_4913",dataMap);
		
		RenameToGraphingMapleAdminPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		//admin courses
		mapleGraphPage.adminCourses();
		
		//click on Go
		mapleGraphPage.accessCourse();

		//click on content updates
		mapleGraphPage.contentUpdates();

		//click on test banks
		mapleGraphPage.clicktestbanks();

		//click on question mgmt
		mapleGraphPage.clickquestionmgmt();
		
		//close the browser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4918: Rename to Graphing-Maple - Admin - Practice Assignment
	@Test
	public void AdminPracticeAssignmentGrpahingMaple() throws Exception{
		
		ResultUtil.createReport("AdminPracticeAssignmentGrpahingMaple-E4_4918",dataMap);

		RenameToGraphingMapleAdminPrerequisite();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.adminCourses();

		//click on Go
		mapleGraphPage.accessCourse();

		//clcik on content updates
		mapleGraphPage.contentUpdates();
		
		//click on test banks
		mapleGraphPage.clicktestbanks();

		//click on question mgmt
		mapleGraphPage.clickquestionmgmt();
		
		//close the browser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4922: Rename to Graphing-Maple - Admin - Printed Test Assignment

	@Test
	public void AdminPrintedTestAssignmentGrpahingMaple() throws Exception{

		System.out.println("E4_4922");
		ResultUtil.createReport("AdminPrintedTestAssignmentGrpahingMaple-E4_4922",dataMap);
		RenameToGraphingMapleAdminPrerequisite();


		MapleGraphPage mapleGraphPage = PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.adminCourses();

		//	click on access course
		mapleGraphPage.accessCourse();

		//click on content updates
		mapleGraphPage.contentUpdates();

		//click on test banks
		mapleGraphPage.clicktestbanks();

		//click on question
		mapleGraphPage.clickquestionmgmt();

		//close the browser
		mapleGraphPage.closeBrowser();

	}

}
