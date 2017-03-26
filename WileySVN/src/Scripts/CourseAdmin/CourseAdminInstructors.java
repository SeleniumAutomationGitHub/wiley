package Scripts.CourseAdmin;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.CourseAdmin.AddEmailInstructorPage;
import Pages.CourseAdmin.CourseAdminClassSectionPage;
import Pages.CourseAdmin.CourseAdminPage;
import Pages.CourseAdmin.GoToAddInstructorPage;
import Pages.CourseAdmin.NewInstructorPage;
import Pages.CourseAdmin.ReInstructorLoginPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.CourseAdminDataProviderUtil.staticProviderClass;


public class CourseAdminInstructors {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="CourseAdminInstructors",dataProviderClass=staticProviderClass.class)
	public CourseAdminInstructors(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	@Test
	public void courseAdmin_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("CourseAdminInstructors-courseAdmin_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
		
		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);		
		CourseSelectionPage courseSelectionPage=home.login(dataMap);
		
		//Select course in home page
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
				
		//Select course admin tab
		CourseAdminPage courseAdminPage=courseHomePage.goToCourseAdminTab();
		
		driver = 	courseAdminPage.getDriver();
	}
	
	/******************************Test Case E4-468: Course Admin - Domain Owner - Add Instructor functionality.***********************************/
	@Test
	public void E4_468() throws InterruptedException
	{
		
		CourseAdminClassSections courseAdminClassSections=new CourseAdminClassSections(dataMap,driver);
		
		courseAdminClassSections.E4_469();
		
		ResultUtil.report("INFO", "CourseAdminInstructors>E4_468", driver);
		
		CourseAdminPage courseAdminPage=PageFactory.initElements(driver, CourseAdminPage.class);
		
		//Go to Add instructor page
		courseAdminPage.goToInstructorPage();
		
		//Verifying instructor list page
		GoToAddInstructorPage goToAddInstructorPage = courseAdminPage.validateInstructorList(dataMap, "FirstName", "LastName");
		
		//Select "Add Instructor" button
		AddEmailInstructorPage addEmailInstructorPage = goToAddInstructorPage.gotoAddInstructor();
		
		//Enter New Instructor Email address		
		addEmailInstructorPage.fillInstructorEmail(dataMap, "AddEmailInstructor");
		
		//Validate the forms and field
		addEmailInstructorPage.validateFormField();

		//Adding Name and Password
		NewInstructorPage newInstructorPage =addEmailInstructorPage.fillAddForms(dataMap,"FirstName","LastName","AddEmailInstructor","AddEmailPassword", "Phone");
		
		//Displays Notification message after adding instructor
		newInstructorPage.validateNotificationMessage();
		
		//Select checkbox for assigning class section to instructor
		courseAdminPage = newInstructorPage.selectDesignate(dataMap);
		
		//Verifying whether the created instructor displayed in instructor list
		courseAdminPage.validateInstructorNameDisplay(dataMap, "FirstName", "LastName");
		
		driver=courseAdminPage.getDriver();
	}
	
		
	/******************************Test Case E4-404: Course Admin - Domain Owner - Instructors page***********************************/
	@Test(dependsOnMethods={"E4_468"})
	public void E4_404() throws Exception
		{		
			ResultUtil.report("INFO", "CourseAdminInstructors>E4_404", driver);

			NewInstructorPage newInstructorPage=PageFactory.initElements(driver, NewInstructorPage.class);
			CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
			
			//Validate the instructor page and list
			courseAdminPage.validateInstructorList(dataMap, "FirstName", "LastName");
						
			//Verifying the class section value and clicking on the instructor name
			courseAdminPage.validateDefaultClassSection(dataMap, "FirstName", "LastName");
			
			//Select the instructor name where class section is 1
			courseAdminPage.selectDesignateClassSectionViaName(dataMap,"FirstName", "LastName");
			 
			//Unselect the class designate column			
			newInstructorPage.uncheckDesignate(dataMap);
			
			//Verify the class section is updated to "0"
			courseAdminPage.validateUpdatedClassSection(dataMap,"FirstName", "LastName");
			
			driver=courseAdminPage.getDriver();

		}
		
		
	/****************************** Test Case E4-954: Course Admin - Domain Owner - Instructors tab. Email Selected***********************************/
	/****************************** TO BE DELETED
		@Test
		public void E4_954() throws Exception
		{
			ResultUtil.report("INFO", "CourseAdminInstructors>E4_954", driver);
			

			NewInstructorPage newInstructorPage=PageFactory.initElements(driver, NewInstructorPage.class);
			CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
			
			//Verify Email selected button in instrutor list page
			courseAdminPage.selectEmailSelectedButton();
				
			//Select the instructor name link
			courseAdminPage.selectDesignateClassSectionViaName(dataMap,"FirstName", "LastName");
			
			//Click "Send email" button in instructor profile page
			newInstructorPage.selectSendEmailButton();
			
			//Cancel the settings to return instructor page
			newInstructorPage.cancelSettings();			
		}******/	   		 
		
			
	/********************************** Test Case E4-965: Course Admin - Domain Owner - Instructors tab. Edit Instructors*******************************/
		@Test
		public void E4_965() throws Exception
		{
			ResultUtil.report("INFO", "CourseAdminInstructors>E4_965", driver);			

			NewInstructorPage newInstructorPage=PageFactory.initElements(driver, NewInstructorPage.class);
			CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
			GoToAddInstructorPage goToAddInstructorPage =PageFactory.initElements(driver, GoToAddInstructorPage.class);
			
			//As a preconditions, Add one more instructor and assign to class section and enter the valid value in input sheet
			//Select "Add Instructor" button
			AddEmailInstructorPage addEmailInstructorPage = goToAddInstructorPage.gotoAddInstructor();
			
			//Enter New Instructor Email address		
			addEmailInstructorPage.fillInstructorEmail(dataMap, "MoreEmailInstructor");

			//Adding Name and Password
			addEmailInstructorPage.fillAddForms(dataMap,"MoreFirstName","MoreLastName","MoreEmailInstructor","MoreEmailPassword","MorePhone");
			
			//Select checkbox for assigning class section to instructor
			courseAdminPage = newInstructorPage.selectDesignate(dataMap);
			
			//Verifying whether the created instructor displayed in instructor list
			courseAdminPage.validateInstructorNameDisplay(dataMap,"MoreFirstName","MoreLastName");
			
			//Validate each instructors edit link
			courseAdminPage.validateEditLink();
			
			//Select the "Edit" link for the instructor name
			courseAdminPage.selectDesignateClassSectionViaEdit(dataMap,"MoreFirstName","MoreLastName");
		
			//Verifying Profile details page
			newInstructorPage.validateProfileDetailsSection(dataMap, "MoreFirstName", "MoreLastName", "MoreEmailInstructor", "MorePhone");
			
			//Verifying Assign class section page
			newInstructorPage.validateAssignClassSection(dataMap);
		
			//Select several checkbox in designate column
			String inClassSectionvalue = newInstructorPage.selectMultiDesignateCheckBox(dataMap);
		
			//Click "cancel" button
			newInstructorPage.cancelSettings();
			
			//verifying the class section value in instructor list page
			courseAdminPage.validateClassSectionsValue(dataMap,inClassSectionvalue,"MoreFirstName","MoreLastName");
		
			//Click "Edit" link in the instructor list
			courseAdminPage.selectDesignateClassSectionViaEdit(dataMap,"MoreFirstName","MoreLastName");
			
			//Select several checkbox in designate column
			inClassSectionvalue = newInstructorPage.selectMultiDesignateCheckBox(dataMap);
			
			//Click "Submit" button.	
			newInstructorPage.submitSettings();
			
			//Verifying the value is changed accordingly
			courseAdminPage.validateClassSectionsValue(dataMap,inClassSectionvalue,"MoreFirstName","MoreLastName");
			
			driver=courseAdminPage.getDriver();
		
		}
		
	/***************Test Case E4-970: Course Admin - Domain Owner - Instructors tab. Remove Instructors**************************************/		
		@Test
		public void E4_970() throws Exception
		{
			ResultUtil.report("INFO", "CourseAdminInstructors>E4_970", driver);		
			
			NewInstructorPage newInstructorPage=PageFactory.initElements(driver, NewInstructorPage.class);
			GoToAddInstructorPage goToAddInstructorPage =PageFactory.initElements(driver, GoToAddInstructorPage.class);
			
			//As a preconditions, Add one more instructor and assign to class section and enter the valid value in input sheet
			AddEmailInstructorPage addEmailInstructorPage = goToAddInstructorPage.gotoAddInstructor();
			
			//Enter New Instructor Email address		
			addEmailInstructorPage.fillInstructorEmail(dataMap, "RemoveInstructorMailID");

			//Adding Name and Password
			addEmailInstructorPage.fillAddForms(dataMap,"RemoveInstructorFirstName","RemoveInstructorLastName","RemoveInstructorMailID","RemoveInstrutorPwd","RemovePhone");
			
			//Select checkbox for assigning class section to instructor
			CourseAdminPage courseAdminPage = PageFactory.initElements(driver, CourseAdminPage.class);
			courseAdminPage = newInstructorPage.selectDesignate(dataMap);
			
			//Verifying whether the created instructor displayed in instructor list
			courseAdminPage.validateInstructorNameDisplay(dataMap,"RemoveInstructorFirstName","RemoveInstructorLastName");
						
			//Remove the instructor mention in datamap
			courseAdminPage.removeInstructors(dataMap);
		 
			//Validate the removed instructors
			courseAdminPage.validateRemovedInstructor(dataMap);		 
		 	 
			//navigate to class section tab
			CourseAdminClassSectionPage removedInstructorPage =courseAdminPage.navigateClassSectionTab();
						
			//Verify the instructor is not displayed in class section page
			LogoutSessionPage logoutSessionPage = removedInstructorPage.validateRemovedClassSection(dataMap);
		
			//Logout from the page
			logoutSessionPage.logOutSession();
		
			ReInstructorLoginPage reInstructorLoginPage = PageFactory.initElements(driver, ReInstructorLoginPage.class);		
		
			//Login again with removed instructor credentials
			reInstructorLoginPage.reInstructorLogin(dataMap);		
			
	}	
}

