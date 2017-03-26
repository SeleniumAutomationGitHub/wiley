package Toolbox;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import Misc.DateUtil;
import Misc.FileUtil;
import Misc.XMLUtil;
import Scripts.Misc.Prerequsite;

public class ResultUtil {
public static Map<String,String> reportFilesMap;
public static String strResultFolder;
public static String strCSS=".datagrid table { border-collapse: collapse; text-align: left; width: 100%; }"+ 

".datagrid {font: normal 12px/150% Arial, Helvetica, sans-serif; background: "+

"#fff; overflow: hidden; border: 1px solid #006699; -webkit-border-radius: "+

"3px; -moz-border-radius: 3px; border-radius: 3px; }.datagrid table td, "+

".datagrid table th { padding: 3px 10px; }.datagrid table thead th "+

"{background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, "+

"#006699), color-stop(1, #00557F) );background:-moz-linear-gradient( center "+

"top, #006699 5%, #00557F 100% "+

");filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699', "+

"endColorstr='#00557F');background-color:#006699; color:#FFFFFF; font-size: "+

"12px; font-weight: bold; border-left: 1px solid #0070A8; } .datagrid table "+

"thead th:first-child { border: none; }.datagrid table tbody td { color: "+

"#00557F; border-left: 2px solid #E1EEF4;font-size: 12px;font-weight: normal; "+

"}.datagrid table tbody .alt td { background: #E1EEf4; color: #00557F; "+

"}.datagrid table tbody td:first-child { border-left: none; }.datagrid table "+

"tbody tr:last-child td { border-bottom: none; }.datagrid table tfoot td div { "+

"border-top: 1px solid #006699;background: #E1EEf4;} .datagrid table tfoot td "+

"{ padding: 0; font-size: 12px } .datagrid table tfoot td div{ padding: 2px; "+

"}.datagrid table tfoot td ul { margin: 0; padding:0; list-style: none; "+

"text-align: right; }.datagrid table tfoot  li { display: inline; }.datagrid "+

"table tfoot li a { text-decoration: none; display: inline-block;  padding: "+

"2px 8px; margin: 1px;color: #FFFFFF;border: 1px solid "+

"#006699;-webkit-border-radius: 3px; -moz-border-radius: 3px; border-radius: "+

"3px; background:-webkit-gradient( linear, left top, left bottom, "+

"color-stop(0.05, #006699), color-stop(1, #00557F) "+

");background:-moz-linear-gradient( center top, #006699 5%, #00557F 100% "+

");filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#006699', "+

"endColorstr='#00557F');background-color:#006699; }.datagrid table tfoot "+

"ul.active, .datagrid table tfoot ul a:hover { text-decoration:"+

"none;border-color: #00557F; color: #FFFFFF; background: none;"+

"background-color:#006699;}";


public synchronized static void report(String strStatus,String strDesc,WebDriver driver){
	String strModuleName=System.getProperty("MODULE");
	String strThreadID=""+Thread.currentThread().getId();
	String strReportFile=reportFilesMap.get(strThreadID);
	Map<String,String> linkMap=new HashMap();
	Map<String,String> attrMap=new HashMap();
	String strScreenshotFile;
	
	XMLUtil.addNode(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody", "tr");
	//XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td","-");
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td",strDesc);
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td",strStatus);
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td",DateUtil.getCurrentDate("yyyy/MM/dd HH:mm:sss"));
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td","");
	
	String strSCREENSHOT=Prerequsite.configMap.get("SCREENSHOT");
	
	if(strSCREENSHOT.equalsIgnoreCase("ONFAILURE") && strStatus.equals("FAIL")){
		WebDriver augmentedDriver = new Augmenter().augment(driver);
	
        try{
        	File screenshot = ((TakesScreenshot)augmentedDriver).
                    getScreenshotAs(OutputType.FILE);

        	strScreenshotFile="Screenshot/"+"screen-"+java.util.UUID.randomUUID().toString()+".png";
        	FileUtils.copyFile(screenshot, new File(strResultFolder+"/"+strScreenshotFile));
        	linkMap.put("href",strScreenshotFile);
    		XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]/td[4]", "a","Link");
    		XMLUtil.addAttributes(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]/td[4]/a", linkMap);
        
        }catch(Exception e){}
	}
	else if(strSCREENSHOT.equalsIgnoreCase("ALWAYS") && !(strStatus.equals("INFO"))){
		WebDriver augmentedDriver = new Augmenter().augment(driver);	
        try{
        	 File screenshot = ((TakesScreenshot)augmentedDriver).
                     getScreenshotAs(OutputType.FILE);
 
        	 strScreenshotFile="Screenshot/"+"screen-"+java.util.UUID.randomUUID().toString()+".png";
        	FileUtils.copyFile(screenshot, new File(strResultFolder+"/"+strScreenshotFile));
        	linkMap.put("href",strScreenshotFile);
    		XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]/td[4]", "a","Link");
    		XMLUtil.addAttributes(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]/td[4]/a", linkMap);
        
        }catch(Exception e){}
	}
	
	System.out.println(strStatus+"-"+strDesc);
	
	if(strStatus.equalsIgnoreCase("FAIL")){
		XMLUtil.addText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+FilenameUtils.getBaseName(strReportFile)+"']/td[5]","FAIL");
		XMLUtil.addText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+FilenameUtils.getBaseName(strReportFile)+"']/td[5]","FAIL");
	}
	
	if(strStatus.equalsIgnoreCase("INFO")){
		System.out.println("");
		attrMap.put("style", "background-color:#ADD8E6;");
		XMLUtil.addAttributes(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", attrMap);
	}
	
}

public synchronized static void reportWithoutScreenshot(String strStatus,String strDesc){
	String strModuleName=System.getProperty("MODULE");
	String strThreadID=""+Thread.currentThread().getId();
	String strReportFile=reportFilesMap.get(strThreadID);
	Map<String,String> linkMap=new HashMap();
	Map<String,String> attrMap=new HashMap();
	String strScreenshotFile;
	
	XMLUtil.addNode(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody", "tr");
	//XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td","-");
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td",strDesc);
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td",strStatus);
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td",DateUtil.getCurrentDate("yyyy/MM/dd HH:mm:sss"));
	XMLUtil.addNodeWithText(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", "td","");
	
	System.out.println(strStatus+"-"+strDesc);
	
	if(strStatus.equalsIgnoreCase("FAIL")){
		XMLUtil.addText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+FilenameUtils.getBaseName(strReportFile)+"']/td[5]","FAIL");
		XMLUtil.addText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+FilenameUtils.getBaseName(strReportFile)+"']/td[5]","FAIL");
	}
	
	if(strStatus.equalsIgnoreCase("INFO")){
		attrMap.put("style", "background-color:#ADD8E6;");
		XMLUtil.addAttributes(strResultFolder+"/"+strReportFile, "//table[@id='tblDetail']/tbody/tr[last()]", attrMap);
	}
	
}

public synchronized static void createReport(String strTestCaseName,Map<String,String> dataMap){
	String strModuleName=System.getProperty("MODULE");
	String strThreadID=""+Thread.currentThread().getId();
	String strReportFileName=strTestCaseName+"-"+strThreadID+"-"+DateUtil.getCurrentDate("yyyy_MM_dd_HH_mm_sss");
	String strReportFile=strReportFileName+".html";
	reportFilesMap.put(strThreadID, strReportFile);
	String strDetailContent="<html><head><style>"+ResultUtil.strCSS+"</style></head>"+
			"<body><div class='datagrid'><table id='tblDetail'><thead>"+
			"<tr><th>Description</th><th>Status</th><th>Timestamp</th><th>Screenshot</th></tr>"+
			"</thead><tbody></tbody></table></div></body></html>";
	FileUtil.createFileWithContent(strResultFolder+"/"+strReportFile, strDetailContent);
	
	Map<String,String> attributeMap=new HashMap();
	attributeMap.put("id", strThreadID+"-"+strReportFileName);
	//Summary
	XMLUtil.addNodeWithAttributes(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody", "tr",attributeMap);
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",strTestCaseName);
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",dataMap.get("Machine"));
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",dataMap.get("Browser"));
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",DateUtil.getCurrentDate("yyyy/MM/dd HH:mm:sss"));
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td","PASS");
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td","");
	
	
	Map<String,String> linkMap=new HashMap();
	linkMap.put("href",strReportFile);
	XMLUtil.addNodeWithText(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']/td[6]", "a","Link");
	XMLUtil.addAttributes(strResultFolder+"/Summary.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']/td[6]/a", linkMap);
	
	//Emailable Result
	XMLUtil.addNodeWithAttributes("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody", "tr",attributeMap);
	XMLUtil.addNodeWithText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",strTestCaseName);
	XMLUtil.addNodeWithText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",dataMap.get("Machine"));
	XMLUtil.addNodeWithText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",dataMap.get("Browser"));
	XMLUtil.addNodeWithText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td",DateUtil.getCurrentDate("yyyy/MM/dd HH:mm:sss"));
	XMLUtil.addNodeWithText("emailResult/"+strModuleName+"-Emailable-Result.html", "//table[@id='tblSummary']/tbody/tr[@id='"+strThreadID+"-"+strReportFileName+"']", "td","PASS");
}
}
