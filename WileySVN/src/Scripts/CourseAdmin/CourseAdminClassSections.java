package Scripts.CourseAdmin;


import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.OpenAssignment;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Pages.CourseAdmin.AddClassSectionPage;
import Pages.CourseAdmin.AddEmailInstructorPage;
import Pages.CourseAdmin.CourseAdminClassSectionEditPage;
import Pages.CourseAdmin.CourseAdminClassSectionPage;
import Pages.CourseAdmin.CourseAdminPage;
import Pages.CourseAdmin.GoToAddInstructorPage;
import Pages.CourseAdmin.ImportRoasterPage;
import Pages.CourseAdmin.NewInstructorPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.CourseAdminDataProviderUtil.staticProviderClass;


public class CourseAdminClassSections {
	
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="CourseAdminClassSections",dataProviderClass=staticProviderClass.class)
	public CourseAdminClassSections(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}	
	
	public CourseAdminClassSections(Map<String,String> dataMap,WebDriver driver){
		this.dataMap=dataMap;
		this.driver=driver;
	}
	
	/***********************************Login - pre- requisite********************************************************************/
	@Test
	public void courseAdmin_Prerequisite() throws InterruptedException
	{
		ResultUtil.createReport("CourseAdminClassSections-courseAdmin_Prerequisite", dataMap);		
		
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
		CourseAdminPage courseAdminPage = courseHomePage.goToCourseAdminTab();	
		
		driver = 	courseAdminPage.navigateClassSectionTab().getDriver();
	}
	
		/***************Test Case E4-976: Course Admin - Domain Owner - UI of Class Sections tab. *************************/
		/************************TODO:PENDING
		@Test
		public void E4_976() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_976", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			
			//Validate the class section page
			courseAdminClassSectionPage.validateClassSectionPage();
			
			//Click "Add Class Section" button
			AddClassSectionPage addClassSectionPage = courseAdminClassSectionPage.gotoAddClassSection();
			
			//Validate the add class section screen
			addClassSectionPage.validateAddclassSectionscreen();
		
			//Create a new class name
			addClassSectionPage.addClassSectionName(dataMap, "AddClassName", "AddClassSectionTerm", "AddClassSectionEndDate");
		
			//Validate the class section after creating it
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, "AddClassName");
		
			//	Verifying UI class Section Page
			courseAdminClassSectionPage.validateClassSectionUI(dataMap);
			
			driver = courseAdminClassSectionPage.getDriver();
		}************************/
		
		/********************Test Case E4-980: Course Admin - Domain Owner - Class Sections tab. UI of Edit class section.******************************/
		
      /**************************TODO:PENIDNG
		public void E4_980() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_980", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
		
			//Select Edit link for given class section		
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
			//Verifying UI in class section properties
			courseAdminClassSectionEditPage.validateClassSectionProperties(dataMap);
		
			//Verifying designate instructors UI section
			courseAdminClassSectionEditPage.validateDesginateInstructors();
		
			//Verifying Designate Section Status & Accessibility UI section
			courseAdminClassSectionEditPage.validateDesignateSection();
		
			//Return to class section page.
			courseAdminClassSectionEditPage.clickCancelButton();
			
			driver = courseAdminClassSectionPage.getDriver();
		}**************************/
	
		/***********************	Test Case E4-982: Course Admin - Domain Owner - Class Sections tab. Edit class section. ************************************/
	
		/*************************TO BE DELETED
	public void E4_982() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_982", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
		
			//Click on the Edit link in class section page
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
			//Validate the pages in Edit class section page
			courseAdminClassSectionEditPage.preSubmitClassSectionPropertiesSettings(dataMap, null, null, null, null, null);
		
			//Click "Course Finder Preview" button		
			CourseFinderPreviewPage courseFinderPreviewPage = 	courseAdminClassSectionEditPage.gotoCourseFinderPreviewWindow();
		
			//Validate Course finder page
			courseFinderPreviewPage.validateClassSectionChanges(dataMap);
		
			//Click "Student Flyer Information" button
			StudentInformationFlyerPage studentInformationFlyerPage = courseAdminClassSectionEditPage.gotoStudentInformationFlyer();
		
			//Validate Student Flyer page
			studentInformationFlyerPage.validateFlyer();
		
			//Click "Cancel" Button
			courseAdminClassSectionEditPage.clickCancelButton();
		
			//Validate the class section page
			courseAdminClassSectionPage.validateClassSectionOnCancel(dataMap);
			
			//Click on the Edit link in class section page
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, null);
			
			//Validate the pages in Edit class section page 
			courseAdminClassSectionEditPage.preSubmitClassSectionPropertiesSettings(dataMap, null, null, null, null, null);
			
			//Click "Submit" button
			courseAdminClassSectionEditPage.clickSubmitButton();
			
			//Validate the class section page on submit functionality
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, null);
			
			//Click on the Edit link in created class section
			courseAdminClassSectionPage.selectNewClassSectionEditlink(dataMap);
			
			//Validate the class section page after submit
			courseAdminClassSectionEditPage.postSubmitClassSectionPropertiesSettings(dataMap);
			
			//Revert back the class section properties to the default one
			courseAdminClassSectionEditPage.resetClassSectionProperties(dataMap);
			
			//Click "Submit" button
			courseAdminClassSectionEditPage.clickSubmitButton();
			
			driver = courseAdminClassSectionPage.getDriver();
		}*****************/
		
	/***************************Test Case E4-469: Course Admin - Domain Owner - Add Class Section functionality.*****************************************/
		@Test
		public void E4_469() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_469", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage = PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			
			//Click "Add Class Section" button
			AddClassSectionPage addClassSectionPage = courseAdminClassSectionPage.gotoAddClassSection();
			
			//Validate the add class section screen
			addClassSectionPage.validateAddclassSectionscreen();
		
			//Create a new class name
			addClassSectionPage.addClassSectionName(dataMap, "NewChangeClassName", "NewClassSectionTerm", "NewClassSectionEndDate");
		
			//Validate the class section after creating it
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, "NewChangeClassName");
			
			driver = courseAdminClassSectionPage.getDriver();
		}
		
		/**************************Test Case E4-1028: Course Admin - Domain Owner - Class Sections tab. Designate Instructors******************/
		
		@Test
		public void E4_1028() throws InterruptedException
		{
		
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_1028", driver);
						
			CourseAdminPage courseAdminPage=PageFactory.initElements(driver, CourseAdminPage.class);
			
			//As a precondition, add 2 instructors
			//Go to Add instructor page
			courseAdminPage.goToInstructorPage();
			
			//Verifying instructor list page
			GoToAddInstructorPage goToAddInstructorPage = PageFactory.initElements(driver, GoToAddInstructorPage.class);
						
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
			
			goToAddInstructorPage.gotoAddInstructor();
			
			//Enter New Instructor Email address		
			addEmailInstructorPage.fillInstructorEmail(dataMap, "MoreEmailInstructor");
			
			//Validate the forms and field
			addEmailInstructorPage.validateFormField();

			//Adding Name and Password
			 newInstructorPage =addEmailInstructorPage.fillAddForms(dataMap,"MoreFirstName","MoreLastName","MoreEmailInstructor","MoreEmailPassword", "MorePhone");
			
			//Displays Notification message after adding instructor
			newInstructorPage.validateNotificationMessage();			
			
			//Click on the edit link for newly created class section		
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
			//Unselect the checkbox in desingnate yourself instructor column - for cancel
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
			courseAdminClassSectionEditPage.selectdesignateInstructorCheckbox(dataMap);
		
			//Click cancel button
			courseAdminClassSectionEditPage.clickCancelButton();
		
			//Validate the class section page - no changes on instrutors
			courseAdminClassSectionPage.validateClassSectionOnCancel(dataMap, "NewChangeClassName" );
		
			//Click on the edit link for newly created class section
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
			//Unselect the checkbox in desingnate yourself instructor column
			courseAdminClassSectionEditPage.selectdesignateInstructorCheckbox(dataMap);
		
			//Click Submit button
			courseAdminClassSectionEditPage.clickSubmitButton();
		
			//Validate the class section page-no instructors
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, "NewChangeClassName");
		
			//Click on the edit link for newly created class section
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
			//Select the checkbox in desingnate yourself instructor column
			courseAdminClassSectionEditPage.selectdesignateInstructorCheckbox(dataMap);
		
			//Select any other instructors checkbox
			courseAdminClassSectionEditPage.selectAnotherdesignateInstructorCheckbox();
		
			//Click Submit button
			courseAdminClassSectionEditPage.clickSubmitButton();
		
			//Validate the class section page-added instructors
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, "NewChangeClassName");			
			
			//Validate the class section page - instructors
			courseAdminClassSectionPage.validateClassSectionInstructor(dataMap, "NewChangeClassName");
			
			//Course finder window
			courseAdminClassSectionPage.verifyCourseFinderWindow();
			
			driver = courseAdminClassSectionPage.getDriver();
		}
		/**************************Test Case E4-983: Course Admin - Domain Owner - Class Sections tab. Import Roster.****************************************/
		/**************************TODO: PENDING
		@Test
		public void E4_983() throws InterruptedException
		{
		
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_983", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
			
			//As a precondition add a class section
			
			//Click "Add Class Section" button
			AddClassSectionPage addClassSectionPage = courseAdminClassSectionPage.gotoAddClassSection();
			
			//Validate the add class section screen
			addClassSectionPage.validateAddclassSectionscreen();
		
			//Create a new class name
			addClassSectionPage.addClassSectionName(dataMap, "AddClassName", "AddClassSectionTerm", "AddClassSectionEndDate");
		
			//Validate the class section after creating it
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap, "AddClassName");
	
			//Click on the Edit link in class section page
			 courseAdminClassSectionEditPage=	courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "AddClassName");
			 
			//Click "Import Roaster" button
			ImportRoasterPage importRoasterPage = courseAdminClassSectionEditPage.gotoImportRoasterPage();
			
			//Validate import roster UI
			importRoasterPage.validateUIImportRoaster();
			
			//Click "Get roster template"
			importRoasterPage.clickRosterTemplate();
			
			//roster instructions window
			importRoasterPage.getRosterInstructions();
			
			//Validate invalid roaster functionality
			importRoasterPage.validateInvalidRoasterTemplate(dataMap);
			
			//Click Submit button for validating the student roaster functionality in class section page
			courseAdminClassSectionEditPage.clickCancelButton();			 
			
			//Validate the student roaster value for invalid template
			//courseAdminClassSectionPage.validateStudentRoasterValue(dataMap, "AddClassName");
			
			//Click Edit link
			//courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "AddClassName");
			
			//Click "Import Roaster" button
			courseAdminClassSectionEditPage.gotoImportRoasterPage();
			
			//Validate Roaster functionality
			importRoasterPage.validatevalidRoasterTemplate(dataMap);
			
			//Validate valid template notification		
			courseAdminClassSectionEditPage.validateNotificationOnValidTemplate(dataMap);
			
			//Select Submit button
			courseAdminClassSectionEditPage.clickSubmitButton();		
			
			//Validate the student roaster value for valid template
			courseAdminClassSectionPage.validateStudentRoasterValue(dataMap,"AddClassName");
			
			//Close  the course finder preview window
			courseAdminClassSectionPage.validateCourseFinderWindow();
			
			driver = courseAdminClassSectionPage.getDriver();
		}******************************/
	  
		/*************************Test Case E4-1040: Course Admin - Domain Owner - Class Sections tab. Course Finder Preview. ****************************************/
		/*************************TODO:PENDING
		public void E4_1040() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_1040", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
			CourseFinderPreviewPage courseFinderPreviewPage = PageFactory.initElements(driver, CourseFinderPreviewPage.class);
			
			//Click on the Edit link in class section page
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
			
			//Navigate to course finder page
			courseFinderPreviewPage = courseAdminClassSectionEditPage.gotoCourseFinderPreviewWindow();
			
			//Validate the course finder page
			courseFinderPreviewPage.validateCourseFinderPreview();
			
			//Validating the "do not show" checkbox functionality
			courseFinderPreviewPage.validateCourseFinderCheckbox();
			
			//Select the submit button
			courseAdminClassSectionEditPage.clickSubmitButton();
			
			//Validate the windows displayed - on select do not show checkbox
			courseAdminClassSectionPage.validateCourseFinderWindow();
			
			//Click on the Edit link in class section page
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
			
			//Navigate to course finder page
			courseAdminClassSectionEditPage.gotoCourseFinderPreviewWindow();
			
			//Validate Course finder page checkbox
			courseFinderPreviewPage.validateCourseFinderCheckbox();
			
			//Select submit button
			courseAdminClassSectionEditPage.clickSubmitButton();
			
			//Validate the windows displayed - on deselect do not show checkbox
			courseAdminClassSectionPage.validateCourseFinderWindow();
			
			driver = courseAdminClassSectionPage.getDriver();
		}****************************/
		
		
		/*************************Test Case E4-1107  - Test Case E4-1112 Course Admin - Domain Owner - Class Sections tab. Finish Class Section. ****************************************/
	@Test(dependsOnMethods={"E4_1028"})
	public void E4_1107() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_1107", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
			
			//Click on the Edit link in created class section
			courseAdminClassSectionEditPage = courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
			//Validate the radio button notification message
			courseAdminClassSectionEditPage.validateDesignateSectionStatus(dataMap);
		
			//Select Submit button
			courseAdminClassSectionEditPage.clickSubmitButton();
		
			//Course finder window
			courseAdminClassSectionPage.verifyCourseFinderWindow();
			
			driver = courseAdminClassSectionPage.getDriver();
	}
	
	/*************************************Test Case E4-1109: Course Admin - Domain Owner - Class Sections tab. Accessible to Students.**********************************************/
	@Test(dependsOnMethods={"E4_1028"})
	public void E4_1109() throws InterruptedException{
		ResultUtil.report("INFO", "CourseAdminClassSections>E4_1109", driver);
		
		CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
				
		//Click on the Edit link in created class section
		CourseAdminClassSectionEditPage	courseAdminClassSectionEditPage = courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
		//accessible student
		courseAdminClassSectionEditPage.validateAccessibleStudents();
		
		//Select Submit button
		courseAdminClassSectionEditPage.clickSubmitButton();
	
		//Course finder window
		courseAdminClassSectionPage.verifyCourseFinderWindow();
	}
	
	/*************************************Test Case E4-1112: Course Admin - Domain Owner - Class Sections tab. Student Self-Registration.**********************************************/
	@Test(dependsOnMethods={"E4_1028"})
	public void E4_1112() throws InterruptedException{
		ResultUtil.report("INFO", "CourseAdminClassSections>E4_1112", driver);
		
		CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
				
		//Click on the Edit link in created class section
		CourseAdminClassSectionEditPage	courseAdminClassSectionEditPage = courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
		
		courseAdminClassSectionEditPage.validateStudentSelfRegistration();
		
		//Select Submit button
		courseAdminClassSectionEditPage.clickSubmitButton();
	
		//Course finder window
		courseAdminClassSectionPage.verifyCourseFinderWindow();
	}
	
		/***************************************Test Case E4-413: Course Admin - Domain Owner - Class Sections page.*********************************************/
		@Test(dependsOnMethods={"E4_469"})
		public void E4_413() throws InterruptedException
		{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_413", driver);
			
			//As a precondition, add a course admin course			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			
			//Validate the class section page
			courseAdminClassSectionPage.validateClassSectionPage();
			
			//Click "Add Class Section" button
			AddClassSectionPage addClassSectionPage = courseAdminClassSectionPage.gotoAddClassSection();
		
			//Create a new class name
			addClassSectionPage.addClassSectionName(dataMap, "AddClassName", "AddClassSectionTerm", "AddClassSectionEndDate");
		
			//Validate the class section after creating it
			courseAdminClassSectionPage.validateClassSectionOnSubmit(dataMap,"EditClassName");
			
			//Click on the Edit link in class section page
			CourseAdminClassSectionEditPage	courseAdminClassSectionEditPage = courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap,"AddClassName");
		
			//Validate the pages in Edit class section page
			courseAdminClassSectionEditPage.preSubmitClassSectionPropertiesSettings(dataMap, "EditClassName", "EditClassSectionTerm", "EditClassSectionMeeting", "EditClassSectionTermYear","EditClassSectionEndDate");
			
			//Click Submit button
			courseAdminClassSectionEditPage.clickSubmitButton();
			
			//Validate the class section page on submit functionality
			courseAdminClassSectionPage.validateClassSection(dataMap, "EditClassName");			
			
			driver = courseAdminClassSectionPage.getDriver();
		}
		
		
		/***************************Test Case E4-5597: Assignments of Class Sections that were copied *************************************************************/
			@Test
			public void E4_5597() throws Exception
			{
			ResultUtil.report("INFO", "CourseAdminClassSections>E4_5597", driver);
			
			CourseAdminClassSectionPage courseAdminClassSectionPage =PageFactory.initElements(driver, CourseAdminClassSectionPage.class);
			CourseAdminClassSectionEditPage courseAdminClassSectionEditPage = PageFactory.initElements(driver, CourseAdminClassSectionEditPage.class);
			
			CreateEditAssignmentPage createEditAssignmentPage= PageFactory.initElements(driver, CreateEditAssignmentPage.class);
			
			AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
			
			//Select assign
			assignmentPage.selectActionsAssign(dataMap, "AssignmentName");
			
			//Assigned to class
			assignmentPage.selectGoActionButtonNotAssignedToClass(dataMap, "AssignmentName");
			
			//Assign to class sections
			assignmentPage.assigntoclasssection(dataMap, "NewChangeClassName");
			
			//Select submit button
			createEditAssignmentPage.selectSubmitButton();
			
			//Select course admin tab
			CourseHomePage courseHomePage=PageFactory.initElements(driver, CourseHomePage.class);
			
			//Select course admin tab
			courseHomePage.goToCourseAdminTab();	
			
			CourseAdminPage courseAdminPage=PageFactory.initElements(driver, CourseAdminPage.class);
			courseAdminPage.navigateClassSectionTab();
			
			//Get Student Url
			courseAdminClassSectionPage.getStudentUrl(dataMap, "NewChangeClassName");
		
			//Go to copy link
			courseAdminClassSectionPage.goToCopyLink(dataMap,"NewChangeClassName");
			
			//Create a copy class section
			courseAdminClassSectionEditPage.createCopyClassSection(dataMap);
			
			//Click "Select Assignment" button
			courseAdminClassSectionEditPage.clickSelectAssignmentsbtn();
			
			//Assign the assignment
			courseAdminClassSectionEditPage.assignAssigmentCopyClassSection(dataMap, "CopyClassAssignment");
			
			//Click "Submit" button
			courseAdminClassSectionEditPage.clickAssignmentSubmitButton();
			
			//Validate new copy created class section
			courseAdminClassSectionPage.validateNewCopyClassSection(dataMap);
			
			//Click Edit link
			courseAdminClassSectionPage.selectDefaultClassSectionEditlink(dataMap, "NewChangeClassName");
			
			//Click "Import Roaster" button
			ImportRoasterPage importRoasterPage = courseAdminClassSectionEditPage.gotoImportRoasterPage();
			
			//Validate Roaster functionality
			importRoasterPage.validatevalidRoasterTemplate(dataMap);
			
			//Validate valid template notification		
			courseAdminClassSectionEditPage.validateNotificationOnValidTemplate(dataMap);
			
			//Select Submit button
			courseAdminClassSectionEditPage.clickSubmitButton();		
			
			//Validate the student roaster value for valid template
			courseAdminClassSectionPage.validateStudentRoasterValue(dataMap,"NewChangeClassName");
			
			Browser.closeDriver(driver);
			
			driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), dataMap.get("StudentUrl"));
			
			//Login
			StudentLoginpage home = PageFactory.initElements(driver, StudentLoginpage.class);
			StudentHomepage studentHomepage=home.loginPage(dataMap);

			//Student Eula
			studentHomepage.studentEula();	
			
			//Accept the eula
			studentHomepage.acceptStudentEula();
		
			//Go to Student Home page  
			studentHomepage.studentHomeScreen(dataMap);
		  
			StudentAssignmentPage studentAssignmentPage = PageFactory.initElements(driver, StudentAssignmentPage.class);

			//Selecting the assignment link
			OpenAssignment openAssignment= PageFactory.initElements(driver, OpenAssignment.class);

			//select assignment
			studentAssignmentPage.selectAssignment(dataMap, "AssignmentName");

			//click next buton to attend test
			openAssignment.clickNext();
				  
			//select first radio button
			openAssignment.answerQuestions();			

			//click submit answer
			openAssignment.selectSubmitAnswer();

			//review answer
			openAssignment.verifyResult();
			
			Browser.closeDriver(driver);

			}	
			
}