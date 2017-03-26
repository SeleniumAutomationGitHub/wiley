package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Common.EcollegeLoginPage;
import Pages.Common.GradeBookPage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.SnapwizIntegration.EcollegeHomePage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentEcollegeStudent {
	
	WebDriver driver=null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="EcollegeAssignmentLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentEcollegeStudent(Map<String,String> dataMap) {
		this.dataMap=dataMap;
	}

	@Test
	public void ecollegeLogin_Prerequisite(Map<String,String> dataMap ) throws Exception
	{
		ResultUtil.createReport("ORIONAssignmentEcollegeStudent-ecollege_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strECOLLEGE_URL=Prerequsite.configMap.get(strEnv+".ECOLLEGE_URL");
		
		//Launch URL				
		 driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strECOLLEGE_URL);
	}
	
	/*********************************************TODO:PENDING
	@Test
	public void E4_5517() throws Exception{
		 
		EcollegeLoginPage ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		EcollegeHomePage ecollegeHomePage = ecollegeLoginPage.eCollegeInstructorLogin(dataMap);
		
		//Validate the home page
		ecollegeHomePage.ecollegeHomePage();
		
		//Go to academinc PSH tab
		ecollegeHomePage.goToAcademicsPshTab();
		
		//Select any course
		ecollegeHomePage.selectCourse(dataMap);
		
		//Validate course home page
		ecollegeHomePage.validateCourseHomePage();
		
		//Go to gradebook page
		ecollegeHomePage.goToGradebookPage();
		
		//Switch to window
		ecollegeHomePage.switchtToWindow();
		
		//Go to Instrucotr gradebook page
		GradeBookPage gradeBookPage = ecollegeHomePage.eCollegeInstructorGradebookPage();
		
		//Click "Go" button
		gradeBookPage.showAllStudentsAssignment(dataMap);		
		
		//Select orion class section
		gradeBookPage.selectOrionClassSection(dataMap);
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");
		
		//Validate the orion assignments are displayed and validate each assignments
		//gradeBookPage.validateOrionAssignments();
		
		//Click Assignment Name Link
		gradeBookPage.selectOrionAssignment(dataMap, "First Assignment");;
				
		//Verify Complete Status
		gradeBookPage.verifyCompleteStatus();
		
		//Verify Assignment Type
		gradeBookPage.verifyAssignmentType();
		
		//Verify Assignment Name
		gradeBookPage.verifyAssignmentName();
		
		//Verify Due and Start Date
		gradeBookPage.verifyStartandDueDate();

		//Click "Result of" link
		gradeBookPage.resultsbreadcrumb();
		
		//Click Second Assignment Name Link
		gradeBookPage.selectOrionAssignment(dataMap,"Second Assignment");
		
		//Verify Complete Status
		gradeBookPage.verifyCompleteStatus();
		
		//Verify Assignment Type
		gradeBookPage.verifyAssignmentType();
		
		//Verify Assignment Name
		gradeBookPage.verifyAssignmentName();
		
		//Verify Due and Start Date
		gradeBookPage.verifyStartandDueDate();
		
		//Click BreadCrumb GradeBook
		gradeBookPage.clickGradeBookBreadCrumb();
		
		//Click Printer version button
		gradeBookPage.clickPrinterVersion();
		
		//Validate the printer page
		gradeBookPage.validatePrinterPage(dataMap);

		//Click Export Grades button
		gradeBookPage.clickExportGrades();		
		
		//Close the Gradebook window
		Browser.closeDriver(driver);
		
		ecollegeHomePage.switchBackToParentWindow();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);		
	}**********************************/
	
	/**********************************TODO:PENDING
	 @Test
	public void E4_5518() throws Exception
	{
		EcollegeLoginPage ecollegeLoginPage = PageFactory.initElements(driver, EcollegeLoginPage.class);
		EcollegeHomePage ecollegeHomePage =ecollegeLoginPage.eCollegeStudentLogin(dataMap);
		 
		//Validate the home page
		ecollegeHomePage.ecollegeStudentHomePage();
			
		//Go to academinc PSH tab
		ecollegeHomePage.goToAcademicsPshTab();
			
		//Select any course
		ecollegeHomePage.selectCourse(dataMap);
			
		//Validate course home page
		ecollegeHomePage.validateStudentsCourseHomePage();
		 
		//Go to gradebook page
		ecollegeHomePage.goToGradebookPage();
	 
		//Ecollege Student gradebook page
		StudentGradeBookPage studentGradeBookPage =ecollegeHomePage.eCollegeStudentGradebookPage();
		
		//Switch assignment window
		ecollegeHomePage.switchtToWindow();
		 
		//Click the First Assignment Link
		AssignmentResultsPage assignmentResultPage=studentGradeBookPage.selectAssignmentGradeBook(dataMap, "First Assignment");
		
		//Verify the Assignment Name
		assignmentResultPage.verifyAssignmentName();
		
		//verify the Assignment Type
		assignmentResultPage.verifyAssignmentType();
		
		//Verify the Start and Due date
		assignmentResultPage.verifyStartandDueDate();
		
		//Verify the Complete Status
		assignmentResultPage.verifyCompleteStatus();
		
		//Click GradeBookBreadCrumb
		assignmentResultPage.clickGradeBookBreadCrumb();
		
		//Click Second Assignment Name
		studentGradeBookPage.selectAssignmentGradeBook(dataMap, "Second Assignment");
		
		//Verify the Assignment Name
		assignmentResultPage.verifyAssignmentName();
		
		//verify the Assignment Type
		assignmentResultPage.verifyAssignmentType();
		
		//Verify the Start and Due date
		assignmentResultPage.verifyStartandDueDate();
		
		//Verify the Complete Status
		assignmentResultPage.verifyCompleteStatus();
			
		//Click BreadCrumb GradeBook
		assignmentResultPage.clickGradeBookBreadCrumb();				 
		 
		//Close the Gradebook window driver
		Browser.closeDriver(driver);
			
		ecollegeHomePage.switchBackToParentWindow();		
	
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);	
	}************************************************/

}