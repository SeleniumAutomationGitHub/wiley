//1.9.3. Test Suite : Support Printing
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

public class SupportPrinting {


	//Test Case E4-4924: Support Printing - Instructor - Printed Test
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)

	public void E4_4924(Map<String,String> dataMap) throws Exception{
	
		ResultUtil.createReport("SupportDisabledStudentBeforeDueDate-E4_4924",dataMap);

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
		
		//click on assignment go
		mapleGraphPage.clickAssignmentGo();

		//click on properties assignment
		mapleGraphPage.propertiesAssignment(dataMap);

		//clicko n print assign
		mapleGraphPage.clickonPrintAssign();

		//open print dialog
		mapleGraphPage.openprintdialog();
		
		mapleGraphPage.closeBrowser();


	}

	//Test Case E4-4948: Support Printing - Instructor - Print Assignment
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_4948(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.createReport("SupportDisabledStudentBeforeDueDate-E4_4948",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGINS_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.GraphingMapleInstructorlogin(dataMap);
		
		//click on assign ment tab
		mapleGraphPage.clickAssignmentTab();

		//click on assignment go
		mapleGraphPage.clickAssignmentGo();

		//click on properties assignment
		mapleGraphPage.propertiesAssignment(dataMap);

		//click on print assing
		mapleGraphPage.clickonPrintAssign();

		//open print dialog
		mapleGraphPage.openprintdialog();

		//close the browser
		mapleGraphPage.closeBrowser();

	}
	
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	//Test Case E4-4938: Support Printing - Student - Printer Version
	public void E4_4938(Map<String,String> dataMap) throws Exception{

		ResultUtil.createReport("SupportDisabledStudentBeforeDueDate-E4_4938",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.GraphingMapleStudentlogin(dataMap);
		
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on maple link
		mapleGraphPage.clickonmaplelink();

		//click on maple next
		mapleGraphPage.clickmapleNext();

		//click on printer tab
		mapleGraphPage.clickPrinterTab();

		//open print dialog
		mapleGraphPage.openprintdialog();

		//close the bropwser
		mapleGraphPage.closeBrowser();

	}

	//Test Case E4-4942: Support Printing - Student - Print a Blank Copy
	@Test(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public void E4_4942(Map<String,String> dataMap) throws Exception{
		System.out.println("E4_4942");
		ResultUtil.createReport("SupportDisabledStudentBeforeDueDate-E4_4942",dataMap);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".MGSTU_URL");

		//Launch URL
		WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		driver.manage().window().maximize();

		MapleGraphPage home=PageFactory.initElements(driver, MapleGraphPage.class);

		//click on login user name
		MapleGraphPage mapleGraphPage = home.GraphingMapleStudentlogin(dataMap);
				
		//click on assignment tab
		mapleGraphPage.clickAssignmentTab();

		//click on maple link
		mapleGraphPage.clickonmaplelink();

		//open print dialog
		mapleGraphPage.openprintdialog();

		//close browser
		mapleGraphPage.closeBrowser();



	}
}