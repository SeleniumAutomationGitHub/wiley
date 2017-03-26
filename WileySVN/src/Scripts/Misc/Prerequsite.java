package Scripts.Misc;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import Misc.DateUtil;
import Misc.FileUtil;
import Toolbox.ResultUtil;

public class Prerequsite {
	public static Map<String,String> configMap;
@BeforeSuite
public void initialize(ITestContext context){
	createReportSummary(context);
	getExecutionConfig();
}

private void createReportSummary(ITestContext context){
	String strSuiteName=context.getCurrentXmlTest().getSuite().getName();
	String strReportFolder="result/"+strSuiteName+"-"+DateUtil.getCurrentDate("yyyy_MM_dd_HH_mm_ss");
	System.setProperty("MODULE",  context.getCurrentXmlTest().getName());
	ResultUtil.strResultFolder=strReportFolder;
	File.createFolder(strReportFolder);
	FileUtil.createFolder(strReportFolder+"/Screenshot");
	String strSummaryContent="<html><head><style>"+ResultUtil.strCSS+"</style></head>"+
			"<body><div class='datagrid'><table id='tblSummary'><thead>"+
			"<tr><th>Script Name</th><th>Machine</th><th>Browser</th><th>Start Time</th><th>Status</th><th>Link</th></tr>"+
			"</thead><tbody></tbody></table></div></body></html>";
	FileUtil.createFileWithContent(strReportFolder+"/Summary.html", strSummaryContent);
	ResultUtil.reportFilesMap=new HashMap();
}

public void getExecutionConfig(){
	try{
		Properties prop = new Properties();
		prop.load(new FileInputStream("config/ExecutionConfig.properties"));
		configMap = new HashMap<String, String>();
		for (String key : prop.stringPropertyNames()) {
			configMap.put(key, prop.getProperty(key));
		}
	}
	catch(Exception e){
		
	}
}
}
