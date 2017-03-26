package Scripts.MapleGraph;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.MapleGraph.MapleGraphPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.LMSMGDataProviderUtil.staticProviderClass;

public class CorrectionsAdditions {
	WebDriver driver=null;
	Map<String,String> dataMap=null;

	@Factory(dataProvider="MapleGraph",dataProviderClass=staticProviderClass.class)
	public CorrectionsAdditions(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}

	public void CorrectionsAdditionsPrerequiste() {

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		MapleGraphPage mapleGraphPage =PageFactory.initElements(driver, MapleGraphPage.class);

		//Navigate to instructor page
		driver=mapleGraphPage.getDriver();
	}

	/******************Work in Progress****************************
	//1.9.6. Test Suite : Corrections/Additions
	//Test Case E4-5471: Corrections/Additions - Report Content Error Details
	@Test
	public void E4_5471() throws Exception{

		ResultUtil.createReport("CorrectionsAdditions-E4_5471",dataMap);

		//calling the prerequiste
		CorrectionsAdditionsPrerequiste();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGEdugenlogin(dataMap);
		
		//click on login user name
		mapleGraphPage.clickInsDomainUser(dataMap);

		//click on report content
		mapleGraphPage.clickreportcontent();

		//switch the window
		mapleGraphPage.switchWindow1();

		//verify the report error
		mapleGraphPage.verifyReporterror();
		
		//close
	//	mapleGraphPage.closeBrowser();

	}*/

	@Test
	public void E4_5470() throws Exception{

		ResultUtil.createReport("MapleGraph-E4_5470",dataMap);

		CorrectionsAdditionsPrerequiste();

		MapleGraphPage mapleGraphPage=PageFactory.initElements(driver, MapleGraphPage.class);

		mapleGraphPage.MGInstructorlogin(dataMap);
		//click on login user name
		mapleGraphPage.clickcorrectionaddDomainUser(dataMap);
		//
		//click on assignments tab
		mapleGraphPage.clickAssignmentTab();

		//click on go
		mapleGraphPage.clickAssignmentGo();

		//click on hide assign
		mapleGraphPage.hideassignAssignment(dataMap);

		//check the assignment
		mapleGraphPage.hidechkAssignment();

		//select the class section check box
		//mapleGraphPage.checkclasssection();

		//click on submit
		mapleGraphPage.hidesubmit();

		//edit availability
		mapleGraphPage.editavailAssignment(dataMap);

		//uncheck the option
		mapleGraphPage.hideuncheck();

		//submit on click
		mapleGraphPage.clickCancelbtn();

		//hide unassign
		mapleGraphPage.hideunassignAssignment(dataMap);

		//close
		mapleGraphPage.closeBrowser();

	}
}

