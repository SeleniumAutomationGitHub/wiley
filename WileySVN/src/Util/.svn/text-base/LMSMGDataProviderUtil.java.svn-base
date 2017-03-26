package Util;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class LMSMGDataProviderUtil {
	
	public static class staticProviderClass{
		@DataProvider(name="InstructorPage",parallel=false)
		public static Iterator<Object[]> ContactUs2(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/LMSIntegration/QA-Input.xls", "InstructorPage");
			return testData;
		}
		
		@DataProvider(name="StudentPage",parallel=false)
		public static Iterator<Object[]> ContactUs3(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/LMSIntegration/QA-Input.xls", "StudentPage");
			return testData;
		}	
		
		@DataProvider(name="MapleGraph",parallel=false)
		public static Iterator<Object[]> ContactUs4(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/MapleGraph/QA-Input.xls", "MapleGraph");
			return testData;
		}
		
		@DataProvider(name="MapleGraphIntegration",parallel=false)
		public static Iterator<Object[]> mapleGraphIntegration(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/MapleGraph/QA-Input.xls", "MapleGraphIntegration");
			return testData;
		}
		
		@DataProvider(name="StudentGraphIntegration",parallel=false)
		public static Iterator<Object[]> studentGraphIntegration(){
			Iterator<Object[]> testData=ExcelUtil.getTestData("input/MapleGraph/QA-Input.xls", "StudentGraphIntegration");
			return testData;
		}
				
	}
}
