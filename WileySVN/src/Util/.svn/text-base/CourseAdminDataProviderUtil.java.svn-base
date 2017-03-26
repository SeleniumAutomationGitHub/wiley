package Util;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class CourseAdminDataProviderUtil {
	
	public static class staticProviderClass{
		@DataProvider(name="CourseAdminClassSections",parallel=false)
		public static Iterator<Object[]> courseAdminClassSections(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/CourseAdmin/QA-Input.xls", "CourseAdminClassSections");
			return testData;
		}
		
		@DataProvider(name="CourseAdminInstructors",parallel=false)
		public static Iterator<Object[]> courseAdminInstructors(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/CourseAdmin/QA-Input.xls", "CourseAdminInstructors");
			return testData;
		}
		
		@DataProvider(name="CoursePropertiesChange",parallel=false)
		public static Iterator<Object[]> coursePropertiesChange(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/CourseAdmin/QA-Input.xls", "CoursePropertiesChange");
			return testData;
		}
	}
}
