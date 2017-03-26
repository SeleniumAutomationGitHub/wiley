package Scripts.SnapwizIntegration;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;


import Pages.Common.GradeBookPage;
import Pages.GradeBook.AssignmentResultsPage;
import Pages.GradeBook.StudentGradeBookPage;
import Pages.LMSIntegration.InstructorPage;
import Pages.LMSIntegration.StudentPage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.SnapwizIntegrationDataProviderUtil.staticProviderClass;

public class ORIONAssignmentOldLTIStudent {
	WebDriver driver = null;
	Map<String,String> dataMap=null;
	
	@Factory(dataProvider="ORIONAssignmentOldLTI",dataProviderClass=staticProviderClass.class)
	public ORIONAssignmentOldLTIStudent(Map<String,String> dataMap)
	{
		this.dataMap=dataMap;
	}
	
	@Test
	public void d2l_Prerequisite() throws Exception
	{		
		ResultUtil.createReport("ORIONAssignmentOldLTI-d2l_Prerequisite", dataMap);
		
		String strEnv=Prerequsite.configMap.get("ENV");
		String strLMS_URL=Prerequsite.configMap.get(strEnv+".LMS_URL");
		
		//Launch URL				
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strLMS_URL);
	}
	
	
	/*******************************Test Case E4-5507: SW Int. Old LTI. Instructor UI - Gradebook**************************************/
	/*******************************TODO:PENDING
	@Test
	public void E4_5507() throws Exception
	{
		InstructorPage instructor =PageFactory.initElements(driver, InstructorPage.class);
					
		//Create a Instructor login
		instructor=instructor.instructorLogin(dataMap);
			
		//select a "WP QA Hoboken Regression Testing Section
		instructor.selectCourseName(dataMap);
		
		//Select content link
		instructor.selectContentLink();
		
		//Select gradebook link
		GradeBookPage gradeBookPage = instructor.selectSnapwizGradebookLink(dataMap);
		
		//Click "Go" button
		gradeBookPage.showAllStudentsAssignment(dataMap);		
		
		//Select orion class section
		gradeBookPage.selectOrionClassSection(dataMap);
		
		//Click Student Name Link
		gradeBookPage.clickStudentNameLink(dataMap, "StudentNameLink");
		
		//Validate the orion assignments are displayed and validate each assignments
		//gradeBookPage.validateOrionAssignments();
		
		//Click Assignment Name Link
		gradeBookPage.selectOrionAssignment(dataMap, "First Assignment");
				
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
		
		instructor.switchBackToParentWindow();
		
		//Clear cookies
		Browser.clearAllCookies(driver);
		
		//Close the driver
		Browser.closeDriver(driver);
		
	}***********************************/
	
	/*******************************Test Case E4-5509: SW Int. Old LTI. Student UI - Gradebook	 * @throws Exception ************************************/
	/******************************TODO:PENDING
	@Test
	public void E4_5509() throws Exception
	{
		//Get login class
		StudentPage home=PageFactory.initElements(driver, StudentPage.class);
		
		//creating new object for student login
		StudentPage studentPage=home.studentLogin(dataMap);
		
		//select a "WP QA Hoboken Regression Testing Section
		studentPage.selectCourseName(dataMap);
		
		//Select the content link in student login
		studentPage.selectContentLink();
		
		StudentGradeBookPage studentGradeBookPage = studentPage.selectGradebookLink(dataMap);
		
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
		
		//Switch to parent window
		studentPage.switchToParentWindow();
	}****************************/	
}
