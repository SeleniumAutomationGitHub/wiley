package Util;

public class CommonUtil {
	
	public static boolean isNumeric(String str)
	{
	    return str.matches(".*\\d.*");
	}
	
	public static boolean qustionStatus(String str)
	{
		boolean result =false;
		if(str.matches(".*\\d.*")){
			result=true;
		}else if(str.matches("-")){
			System.out.println("Is Not attemted");
		}else{
			System.out.println("some text is displayed");
		}
	    return result;
	}
	
	public static int convertToInt(String str)
	{
		Double d = Double.valueOf(str);
		int i = (int) d.doubleValue();
	    return i;
	}
	
	public static String getUpdatedScore(String str)
	{
		String[] score =str.split("/");
	    return score[0];
	}
	
	

}
