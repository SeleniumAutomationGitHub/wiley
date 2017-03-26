package Util;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class GradeBookDataProviderUtil {
	
	public static class staticProviderClass{
		
		@DataProvider(name="GradeBookInstructors",parallel=false)
		public static Iterator<Object[]> gradeBookInstructors(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input.xls", "GradeBookInstructors");
			return testData;
		}
		
		@DataProvider(name="GradeBookStudent",parallel=false)
		public static Iterator<Object[]> gradeBookStudent(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input.xls", "GradeBookStudent");
			return testData;
		}
		
		
		@DataProvider(name="SpecificQuestions",parallel=false)
		public static Iterator<Object[]> specificQuestions()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","SpecificQuestions");
			return testData;
		}
		
		@DataProvider(name="SubmitPreconditions",parallel=false)
		public static Iterator<Object[]> submitPreconditions()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","SubmitPreconditions");
			return testData;
		}
		
		@DataProvider(name="StudentGradeBook",parallel=false)
		public static Iterator<Object[]> studentGradeBook()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","StudentGradeBook");
			return testData;
		}

		@DataProvider(name="EditOneStudPreCondition",parallel=false)
		public static Iterator<Object[]> editOneStudPreCondition()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","EditOneStudPreCondition");
			return testData;
		}
		
		@DataProvider(name="SubmitScoreEditedPreCondition",parallel=false)
		public static Iterator<Object[]> submitScoreEditedPreCondition()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","SubmitScoreEditedPreCondition");
			return testData;
		}
		
		@DataProvider(name="EditALLStudPreCondition",parallel=false)
		public static Iterator<Object[]> editALLStudPreCondition()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","EditALLStudPreCondition");
			return testData;
		}
		
		@DataProvider(name="Preconditions",parallel=false)
		public static Iterator<Object[]> preconditions()
		{
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/GradeBook/QA-Input1.xls","Preconditions");
			return testData;
		}



		
	}
}
