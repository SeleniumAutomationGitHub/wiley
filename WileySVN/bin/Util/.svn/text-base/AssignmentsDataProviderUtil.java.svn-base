package Util;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class AssignmentsDataProviderUtil {
	
	public static class staticProviderClass{
		@DataProvider(name="AssignmentInstructor",parallel=false)
		public static Iterator<Object[]> assignmentInstructor(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-Input.xls", "AssignmentInstructor");
			return testData;
		}
		
		@DataProvider(name="StudentAssignment",parallel=false)
		public static Iterator<Object[]> studentAssignment(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-Input1.xls", "StudentAssignment");
			return testData;
		}
		
		@DataProvider(name="AssignmentPrintedTest",parallel=false)
		public static Iterator<Object[]> assignmentPrintedTest(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-Input1.xls", "AssignmentPrintedTest");
			return testData;
		}
		
		@DataProvider(name="AssignmentReadingsResources",parallel=false)
		public static Iterator<Object[]> assignmentReadingsResources(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-Input2.xls", "AssignmentReadingsResources");
			return testData;
		}
		
		@DataProvider(name="AssignmentSurvey",parallel=false)
		public static Iterator<Object[]> assignmentSurvey(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-Input.xls", "AssignmentSurvey");
			return testData;
		}
		
		@DataProvider(name="AssignmentDemo",parallel=true)
		public static Iterator<Object[]> assignmentDemo(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-InputDemo.xls", "AssignmentDemo");
			return testData;
		}
		
		
		@DataProvider(name="MathEnhancement",parallel=false)
		public static Iterator<Object[]> mathEnhancement(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/Assignments/QA-Input.xls", "MathEnhancement");
			return testData;
		}

	}
}
