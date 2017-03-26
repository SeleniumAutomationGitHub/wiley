package Scripts.SnapwizIntegration;

import java.net.MalformedURLException;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


import Pages.Common.SnapwizLoginPage;
import Pages.SnapwizIntegration.CoursePropertiesPage;
import Pages.SnapwizIntegration.SnapwizHomePage;
import Pages.SnapwizIntegration.SnapwizSubDomainPage;
import Pages.SnapwizIntegration.SnapwizSubDomainPropertiesPage;
import Pages.SnapwizIntegration.SnapwziCoursesListPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class SnapwizIntegrationSetUp {

	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="SnapwizIntegrationSetUp",dataProviderClass=staticProviderClass.class)
	public SnapwizIntegrationSetUp(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	//Login into Admin interface, select a product
	public  void SnapwizIntegrationSetUp_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("SnapwizIntegration-SnapwizIntegrationSetUp", dataMap);
		ResultUtil.report("INFO", "SnapwizIntegration>loginPrerequisite", driver);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".WPADMIN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		SnapwizLoginPage snapwizloginPage = PageFactory.initElements(driver, SnapwizLoginPage.class);
		SnapwizHomePage snapwizHomePage = PageFactory.initElements(driver, SnapwizHomePage.class);
		SnapwziCoursesListPage snapwziCoursesListPage =PageFactory.initElements(driver, SnapwziCoursesListPage.class);
		
		//Login in to Wileyplus admin
		snapwizloginPage.snapLogin(dataMap);
		
		//Verifying snapwiz homepage is displayed
		snapwizHomePage.validateSnapwizHomepage();
				 		 
		//Navigate to Course tab
		snapwizHomePage.gotoCoursesTab();
		 
		//Validate the list of courses in the course list
		driver = snapwziCoursesListPage.validateCoursesList(dataMap).getDriver();
	}
	
	/********************************Test Case E4-5477: SW Int. Product Properties. Available Integration. GUI*************************/	
	/********************************TODO:PENDING
	@Test	
	public void E4_5477() throws MalformedURLException, Exception
	{		 
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5477", driver);
		CoursePropertiesPage coursePropertiesPage =PageFactory.initElements(driver, CoursePropertiesPage.class);
		
		driver= coursePropertiesPage.getDriver();
		
		//Validate the course properties page of the particular course.
		coursePropertiesPage.validateCourseProperties();		
	}***************************/
	
	/********************************Test Case E4-5478: SW Int. Product. Orion option. Default****************************************/
	@Test	
	public void E4_5478() throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5478", driver);
		
		CoursePropertiesPage coursePropertiesPage =PageFactory.initElements(driver, CoursePropertiesPage.class);
		SnapwizSubDomainPropertiesPage snapwizSubDomainPropertiesPage =PageFactory.initElements(driver, SnapwizSubDomainPropertiesPage.class);
		SnapwizSubDomainPage snapwizSubDomainPage =PageFactory.initElements(driver, SnapwizSubDomainPage.class);
		
		driver = coursePropertiesPage.getDriver();
		
		//As a precondition, Click Update link to upload the mapping id
		coursePropertiesPage.goToUpdateLink();
	
		//Validate the course mapping ID
		coursePropertiesPage.validateCourseMappingID();
		
		//As a precondition, upload Course Mapping ID
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPath");
		
		//Enable ORION option
		coursePropertiesPage.enableOrionCheckboxOption();
		 
		//"Current State for Existing Domains:" option = "All enabled";
		coursePropertiesPage.validateCurrentStateEnabled();
		 
		//"Default State for Newly Added Domains:" = "Enabled";
		coursePropertiesPage.validateDefaultStateEnabled();
		 
		//Navigate to Course-Domain page
		coursePropertiesPage.gotoDomainSubTab();
				 
		//Validate the given domain and select the domain name
		snapwizSubDomainPropertiesPage.selectSeveralDomainNamesOnEnableOrion(dataMap);
		 
		//Navigate to course porperties page
		snapwizSubDomainPage.gotoPropertiesTab();
		 
		//Uncheck the orion checkbox
		coursePropertiesPage.disableOrionCheckboxOption();
		 
		//Save the settings
		coursePropertiesPage.saveSettings();
		 
		//Navigate to Domain page
		coursePropertiesPage.gotoDomainSubTab();
		 
		//Select the domain name
		snapwizSubDomainPropertiesPage.selectSeveralDomainNamesOnDisableOrion(dataMap);
	}

	/***************************Test Case E4-5479: SW Int. Product. Existing domains option*******************************************/
	/***************************TODO:PENDING
	@Test	
	public void E4_5479() throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5479", driver);
		
		CoursePropertiesPage coursePropertiesPage =PageFactory.initElements(driver, CoursePropertiesPage.class);
		SnapwizSubDomainPropertiesPage snapwizSubDomainPropertiesPage =PageFactory.initElements(driver, SnapwizSubDomainPropertiesPage.class);
		SnapwizSubDomainPage snapwizSubDomainPage =PageFactory.initElements(driver, SnapwizSubDomainPage.class);
		
		//As a precondition, Click Update link to upload the mapping id
		coursePropertiesPage.goToUpdateLink();
		
		coursePropertiesPage.validateCourseMappingID();
		
		//As a precondition, upload Course Mapping ID
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPath");
		
		//As a precondtion, enable the orion checkbox for the product
		coursePropertiesPage.enableOrionCheckboxOption();
		
		//Validate and set Current State for Exisitng domain as - ALL ENABLED
		coursePropertiesPage.validateEnabledCurrentStateOrion();
		 
		//Click Save setting button
		coursePropertiesPage.saveSettings();
		 
		//Navigate to Course Domain(Sub) Page.
		coursePropertiesPage.gotoDomainSubTab();
		 
		//Select the domain from the dataMap
		snapwizSubDomainPage.selectDomainName(dataMap);
		 
		//Validate checkbox is unselected after changing ALL Enabled option in properties page
		snapwizSubDomainPropertiesPage.validateDisableIntegrationOption();	 
		 
		//Click "Course Details domain" link
		snapwizSubDomainPropertiesPage.gotoCoursesDetailsDomainLink();
		 
		//Navigate to course porperties page
		snapwizSubDomainPage.gotoPropertiesTab();		 

		//Validate and set Current State for Exisitng domain as - ALL ENABLED
		coursePropertiesPage.validateDisabledCurrentStateOrion();
			 
		//Navigate to Course Domain(Sub) Page.
		coursePropertiesPage.gotoDomainSubTab();
			 
		//Select the domain from the dataMap
		snapwizSubDomainPage.selectDomainName(dataMap);
			 
		//Validate checkbox is unselected after changing ALL Enabled option in properties page
		snapwizSubDomainPropertiesPage.validateEnableIntegrationOption();
		
		//Disable the quantum tutors
		snapwizSubDomainPropertiesPage.disableQuantumTutors();
		
		//Click "Course Details domain" link
		snapwizSubDomainPropertiesPage.gotoCoursesDetailsDomainLink();
		 
		//Navigate to course porperties page
		snapwizSubDomainPage.gotoPropertiesTab();	
		
		//Validate the quantum tutors is Mixed
		coursePropertiesPage.validateQuatumTutorsMixed();
	}***************************/

	/***************************Test Case E4-5480: SW Int. Product. New domains option************************************************/
	/****************************TODO:PENDING
	@Test	
	public void E4_5480() throws MalformedURLException, Exception
	{
		ResultUtil.report("INFO", "SnapwizIntegration>E4_5480", driver);
		
		CoursePropertiesPage coursePropertiesPage =PageFactory.initElements(driver, CoursePropertiesPage.class);
		SnapwizSubDomainPropertiesPage snapwizSubDomainPropertiesPage =PageFactory.initElements(driver, SnapwizSubDomainPropertiesPage.class);
		SnapwizSubDomainPage snapwizSubDomainPage =PageFactory.initElements(driver, SnapwizSubDomainPage.class);
		
		//As a precondition, Click Update link to upload the mapping id
		coursePropertiesPage.goToUpdateLink();
		
		coursePropertiesPage.validateCourseMappingID();
				
		//As a precondition, upload Course Mapping ID
		coursePropertiesPage.uploadCourseMappingID(dataMap, "CourseMappingIDPath");
				
		//Enable ORION option
		coursePropertiesPage.enableOrionCheckboxOption();
				 
		//Validate and set default State for Exisitng domain as - ALL ENABLED
		coursePropertiesPage.validateEnableDefaultStateOrion();
				 
		//Save the settings
		coursePropertiesPage.saveSettings();
				 
		//Navigate to Course Domain(Sub) Page.
		coursePropertiesPage.gotoDomainSubTab();
				 
		//Select the domain from the dataMap
		snapwizSubDomainPage.selectDomainName(dataMap);
				 
		//Validate checkbox is unselected after changing ALL Disabled option in properties page
		snapwizSubDomainPropertiesPage.validateDisableIntegrationOption();	 
				 
		//Click "Course Details domain" link
		snapwizSubDomainPropertiesPage.gotoCoursesDetailsDomainLink();		 
				 
		//Navigate to course porperties page
		snapwizSubDomainPage.gotoPropertiesTab();
				 
		//Validate and set default State for Exisitng domain as - ALL DISABLED
		coursePropertiesPage.validateDisableDefaultStateOrion();
				 
		//Save the settings
		coursePropertiesPage.saveSettings();
				 
		//Navigate to Course Domain(Sub) Page.
		coursePropertiesPage.gotoDomainSubTab();
				 
		//Select the domain from the dataMap
		snapwizSubDomainPage.selectDomainName(dataMap);
				 
		//Validate checkbox is unselected after changing ALL Enabled option in properties page
		snapwizSubDomainPropertiesPage.validateEnableIntegrationOption();
				 
	}*******************/
}
