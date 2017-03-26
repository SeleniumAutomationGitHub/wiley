package Scripts.Assignments;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import Pages.Assignments.AssignmentPage;
import Pages.Assignments.CreateEditAssignmentPage;
import Pages.Assignments.CreateReadingsAssignment;
import Pages.Assignments.OpenAssignment;
import Pages.Assignments.StudentAssignmentPage;
import Pages.Common.CourseHomePage;
import Pages.Common.CourseSelectionPage;
import Pages.Common.HomePage;
import Pages.Common.LogoutSessionPage;
import Pages.Common.StudentHomepage;
import Pages.Common.StudentLoginpage;
import Scripts.Misc.Prerequsite;
import Toolbox.Browser;
import Toolbox.ResultUtil;
import Util.AssignmentsDataProviderUtil.staticProviderClass;


public class AssignmentReadingsResources {
	
	WebDriver driver=null;
	Map<String,String> dataMap =null;
	
	@Factory(dataProvider="AssignmentReadingsResources",dataProviderClass=staticProviderClass.class)
	public AssignmentReadingsResources(Map<String,String> dataMap){
		this.dataMap=dataMap;
	}
	
	@Test
	public void assignmentReadingsResourcesPrerequisite() throws Exception{

		ResultUtil.report("INFO", "AssignmentPrintedTest-assignmentReadingsResourcesPrerequisite", driver);

		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");

		//Launch URL
		driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);

		//Login
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		CourseSelectionPage courseSelectionPage=home.login(dataMap);

		//Select Course
		CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);

		//GoTo Assignment page
		driver =courseHomePage.goToAssigmentPage().getDriver();

	}
	
	/****Test Case E4-395: Assignment - Assignment Creator - Readings/Resources Assignment. Create new Assignment****/
	@Test
	public void E4_395(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_395", driver);
		
		AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Reading Assignment page
		CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
		
		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
		
		//Description: Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Description: Choose Chapter  in Select Resource screen
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Description: Select Resources displayed in Select Resource screen
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Description: Remove one Resource 
		createReadingsAssignmentPage.removeOneResource();
		
		//Description: Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Description: Select Assign to class button
		createReadingsAssignmentPage.SelectAssignToClass();
		
		//Description: Select Class from the Select Assign to class screen
		createReadingsAssignmentPage.assigntoclass(dataMap);
		
		//Close window
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();
		
		//Description: Navigate to Assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Description: Verify the created assignment is displayed in Assignment list
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		driver= assignmentPage.getDriver();		
	}
	
	/***Test Case E4-987: Assignments - AC - R/R Assignment - Step 1. Symbols count limit****/
    @Test   
    public void E4_987(Map<String,String> dataMap) throws Exception{
    	
    	ResultUtil.report("INFO", "AssignmentPrintedTest-E4_987", driver);
		
    	AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		//Goto Create Edit Assignment page    	
    	CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
    			
    	CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
    			
		//Description: Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//verify Long Name Alert Message	
		createEditAssignmentPage.verifyLongAssignmentName(dataMap);
		
		//Verify Long ID Alert Message
		createEditAssignmentPage.verifyLongAssignmentID(dataMap);
		
		//Verify Long Description Alert Message
		createEditAssignmentPage.verifyLongDescription(dataMap);
		
		//Verify Long Assignment Name and ID Alert Message
		createEditAssignmentPage.verifyLongAssignmentNameAndID(dataMap);
		
		//Verify Long Assignment ID and Description Alert Message
		createEditAssignmentPage.verifyLongAssignmentIDAndDescription(dataMap);
		
		//Verify Long Assignment Name and Description Alert Message
		createEditAssignmentPage.verifyLongAssignmentNameAndDescription(dataMap);

		//Verify Long Assignment ID, Name and Description Alert Message
		createEditAssignmentPage.verifyLondIdNameAndDescription(dataMap);
		
		//Click Assigment Link
		createEditAssignmentPage.assignmentLink();
		
		driver = createEditAssignmentPage.getDriver();
		
    }
    
    /***Test Case E4-988: Assignments - AC - R/R Assignment - Step 1. Required fields****/
    @Test    
    public void E4_988(Map<String,String> dataMap) throws Exception{
    	
       	ResultUtil.report("INFO", "AssignmentPrintedTest-E4_988", driver);
		
       	AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		driver = assignmentPage.getDriver();
		
		//Goto Create Edit Assignment page    	
    	CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
    			
    	CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
    			
		//Description: Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
						
		//Verifying Untitled Alert Message		
		createEditAssignmentPage.verifyAssignmentisUntitledAlert(dataMap);
		
		//Verify Assignment Id Empty Alert Message
		createEditAssignmentPage.verifyAssignmentIDEmptyAlert(dataMap);
		
		//Verify Assignment Name Untitled Alert Message 
		createEditAssignmentPage.verifyAssignmentUntitledAlert(dataMap);		
		
		//Click Assigment Link
		createEditAssignmentPage.assignmentLink();
		
		driver = createEditAssignmentPage.getDriver();
		
    }
    
    /**********Test Case E4-1371: Assignments - AC - R/R Assignment - Step 2. "Show per page" drop-down***********/	
    @Test    
    public void E4_1371(Map<String,String> dataMap) throws Exception{
    	
    	ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1371", driver);
    	
		AssignmentPage assignmentPage = PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Edit Assignment page    	
    	CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
    			
    	CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
    			
		//Description: Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
						
		//Select Next button to Navigate
		createEditAssignmentPage.selectNextButton();
		
		//Select Question Screen Verifying the 10 questions displayed.		
		createEditAssignmentPage.selectTenQuestionsPerPage(dataMap);
		
		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();
		
		//Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
		
		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();
		
		//Verifying 20 questions displayed
		createEditAssignmentPage.selectTwentyQuestionPerPage(dataMap);
		
		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();
		
		//Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
				
		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();
		
		//Verifying 30 questions displayed
		createEditAssignmentPage.selectThirtyQuestionsPerPage(dataMap);
		
		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();
		
		//Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
				
		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();
		
		//Verifying 50 questions displayed
		createEditAssignmentPage.selectFiftyQuestionsPerPage(dataMap);
		
		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();
		
		//Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
				
		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();
		
		//Verifying 100 questions displayed
		createEditAssignmentPage.selectHundredQuestionPerPage(dataMap);
		
		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();
		
		//Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
				
		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();
		
		//Verifying All questions displayed
		createEditAssignmentPage.selectAllQuestionPerPage(dataMap);
		
		//select go
		createEditAssignmentPage.selectGo();
		
		//Verify The size of the table present
		createEditAssignmentPage.verifySizeOfTable();
		
		//Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
				
		//Select Save and Find More Question button
		createEditAssignmentPage.selectSaveAndFindButton();
		
		createEditAssignmentPage.assignmentLink();	
		
		driver = assignmentPage.getDriver();
		
    }
    
    /******Test Case E4-1763: Assignments - AC - R/R Assignment - Step 2. Multiselection menus******/
    @Test   
    public void E4_1763(Map<String,String> dataMap) throws Exception{
    	
    	ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1763", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);	
		
		//Goto Create Reading Assignment page
		CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
		
		CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
		
		//Input
	    createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		///Verify the Chapter Menu present from the list
		createReadingsAssignmentPage.verifyChapterMenuPresent(dataMap);
		
		//Verify the level Menu present from the list
		createReadingsAssignmentPage.verifySourceMenu(dataMap);
		
		//Verify Source Menu present from the list
		createReadingsAssignmentPage.verifyResourceMenuPresent(dataMap);
		
		createEditAssignmentPage.assignmentLink();
		
		driver=assignmentPage.getDriver();
	 }

    /*****Test Case E4-1911: Assignments - AC - R/R Assignment - Step 2. Resource search - single selection******/
    @Test    
    public void E4_1911(Map<String,String> dataMap) throws Exception{
	
    	ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1911", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
		
		//Goto Create Reading Assignment page
		CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 	   
		
		//Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select one Chapter from the list and verify the table
		createReadingsAssignmentPage.selectSingleChapter(dataMap);
		
		//Select Source from the list and verify the table
		createReadingsAssignmentPage.selectSingleSource(dataMap);
		
		//Select level from the list and verify the table
		createReadingsAssignmentPage.selectSingleResource(dataMap);
				
    	//Select Chapter, Level and Source from the list and verify the table
		createReadingsAssignmentPage.selectSingleChapterSingleResourceSingleSource(dataMap);
				
		driver= createReadingsAssignmentPage.getDriver();		
	}
    
    /*****Test Case E4-1372: Assignments - AC - R/R Assignment - Step 2. Navigation buttons*****/ 
	@Test
	public void E4_1372(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1372", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
		//Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Description: Select Back button Navigate to Select Questions screen
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);
		
		//Enter Description details
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Description: Select Cancel button and navigate Assignment Page
		createReadingsAssignmentPage.selectCancelButton(dataMap);
		
		//Re- Select Create Readings Assignment page
		assignmentPage.goToCreateReadingsAssignment();
				
		//Re-Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
				
		//Re-Enter Select Chapter from the list
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select resources from the list displayed
		createReadingsAssignmentPage.selectResources(dataMap);
	    
		//Description: Add some resources and click 'save and exit' button
		createReadingsAssignmentPage.selectSaveAndExitButton(dataMap);
		
		//Re- Select Create Readings Assignment page
		assignmentPage.goToCreateReadingsAssignment();
						
	    //Re-Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
						
		//Re-Enter Select Chapter from the list
		createReadingsAssignmentPage.chooseChapter(dataMap);
				
		//Select resources from the list displayed
		createReadingsAssignmentPage.selectResources(dataMap);	
		
		//Navigate to Describe Assignment Page
	    createReadingsAssignmentPage.navigateToDescribeAssignmentTab();
	    
	    //Verify Describe Assignment Page
	    createReadingsAssignmentPage.verifyDescribeAssignmentTab();
	    
	    driver= createReadingsAssignmentPage.getDriver();
	}
	
	/*****Test Case E4-1373: Assignments - AC - R/R Assignment - Step 2. Page Navigator drop-down*******/
	@Test
	public void E4_1373(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1373", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	 	//Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select Chapter from the list
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Check Page Navigator
		createReadingsAssignmentPage.checkPageNavigator();
			
		//Verify Page Navigator
		createReadingsAssignmentPage.verifyPageNavigator(dataMap);
		
		driver= createReadingsAssignmentPage.getDriver();
		
	}
	
	/******Test Case E4-1374: Assignments - AC - R/R Assignment - Step 2. Resources checkboxes*******/
	@Test
	public void E4_1374(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1373", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    //Enter Description details
	    createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select Chapter from the list
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select resources from the list displayed
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Select Next button to Navigate
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select Back button Navigate to Select Resources screen
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);		
		
		//Select AllQuestion Checkbox
		createReadingsAssignmentPage.selectAllResources(dataMap);
		
		//Select Next button to Navigate
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
	    //Select Back button Navigate to Select Questions screen
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);
				
		//Un-Check few Questions from the Question list
		createReadingsAssignmentPage.unCheckResources();
		
		//Select Next button to Navigate
		createReadingsAssignmentPage.SelectNextButton(dataMap);
	
		//Select Back button Navigate to Select Questions screen
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);		
				
		//Uncheck All Resources from the list
		createReadingsAssignmentPage.UnCheckAllResources();
		
		driver= createReadingsAssignmentPage.getDriver();
		
	}
	
	/*****Test Case E4-1375: Assignments - AC - R/R Assignment - Step 2. Select all Resources******/
	@Test	
	public void E41375(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1373", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
		//Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select Chapter from the list
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select AllQuestion Checkbox
		createReadingsAssignmentPage.selectAllResourcesCheckBox(dataMap);
		
		//Uncheck the Question and verify the Select All Checkbox
		createReadingsAssignmentPage.unCheckResources(dataMap);

		//Select Question which is Unselected in previous step
		createReadingsAssignmentPage.selectUnselectedResources(dataMap);
		
		//Navigate to next page of the Resoures list and Click next button
		createReadingsAssignmentPage.navigateToNextPage(dataMap);
		
		driver= createReadingsAssignmentPage.getDriver();
	}
	
	/****Test Case E4-1912: Assignments - AC - R/R Assignment - Step 2. Resource search - multiselect - single field***/
	@Test
	public void E4_1912(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1912", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select few chapters
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		
		//Select Go button
		createEditAssignmentPage.selectGoBtn();		
		
		//Save and Find more Resource
		createReadingsAssignmentPage.saveAndFindResource();
		
		//Select few resources
		createReadingsAssignmentPage.multiSelectResource(dataMap);
		
		//Select Go button
		createEditAssignmentPage.selectGoBtn();	
		
		//Save and Find more Resource
		createReadingsAssignmentPage.saveAndFindResource();
		
		//Select few chapters few sources
		//Select few chapters
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		
		//Select few sources
		createReadingsAssignmentPage.multiSelectSource(dataMap);
		
		//Select Go button
		createEditAssignmentPage.selectGoBtn();
		
		//Save and Find more Resource
		createReadingsAssignmentPage.saveAndFindResource();
		
		driver=createReadingsAssignmentPage.getDriver();
		
	}
	
	/****Test Case E4-1913: Assignments - AC - R/R Assignment - Step 2. Resource search - intersection - 2 fields****/
	@Test
	public void E4_1913(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1912", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//Enter Description details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select one chapter one resource
		createReadingsAssignmentPage.selectOneChapterOneResource(dataMap);
		 
		//Select one chapter one source
		createReadingsAssignmentPage.selectOneChapterOneSource(dataMap);
		
		//Select one resource one source
		createReadingsAssignmentPage.selectOneSourceOneResource(dataMap);
					
		//Select few chapters few resources
		//Select few chapters
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		
		//Select few resources
		createReadingsAssignmentPage.multiSelectResource(dataMap);
		
		//Select Go button
		createEditAssignmentPage.selectGoBtn();
		
		//Save and Find more Resource
		createReadingsAssignmentPage.saveAndFindResource();
	
	    //Select few chapters few sources
		//Select few chapters
		createEditAssignmentPage.mulitiSelectChapter(dataMap);
		
		//Select few sources
		createReadingsAssignmentPage.multiSelectSource(dataMap);
		
		//Select Go button
		createEditAssignmentPage.selectGoBtn();
		
		//Save and Find more Resource
		createReadingsAssignmentPage.saveAndFindResource();
		
		//select few resource and source
		//Select few resources
		createReadingsAssignmentPage.multiSelectResource(dataMap);
		
		//Select few sources
		createReadingsAssignmentPage.multiSelectSource(dataMap);
		
		//Select Go button
		createEditAssignmentPage.selectGoBtn();
		
		driver= assignmentPage.getDriver();	
		
	}
	
	/*****Test Case E4-1932: Assignments - AC - R/R Assignment - Step 4. Navigation between steps******/
	@Test
	public void E4_1932(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1932", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
		//Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
														
		//Select Chapter from the list
		createReadingsAssignmentPage.chooseChapter(dataMap);
				
		//Select Questions from the list
		createReadingsAssignmentPage.selectResources(dataMap);
								
		//Select Next button to Navigate
		createReadingsAssignmentPage.SelectNextButton(dataMap);
								
		//Navigate to Describe Assignment Tab	
		createReadingsAssignmentPage.navigateToDescribeAssignmentTab();
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Verify Select reources tab
		createReadingsAssignmentPage.verifySelectResourcestab();
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Navigate to select Resources tab		
		createReadingsAssignmentPage.navigateToSelectResourcesTab();
		
		//Verify the selected resources
		createReadingsAssignmentPage.verifySelectedResources();
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Navigate to Organize Resources tab
		createReadingsAssignmentPage.navigateToOrganizeResourcesTab();
		
		//Verify the Resource order
		createReadingsAssignmentPage.verifyResourceOrder(dataMap);
		
		driver= assignmentPage.getDriver();
	}
	
	/*****Test Case E4-1929: Assignments - AC - R/R Assignment - Step 3. Navigation****/
	@Test
	public void E41929(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1932", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
		
	    //Enter details in Describe assignments tab
        createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapters
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Verify the OrganiseResource tab			
		createReadingsAssignmentPage.verifyOrganizeResourcesTab();
		
		//Select back button
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select cancel button
		createReadingsAssignmentPage.selectCancelButton(dataMap);
		
		//Go to assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Verify if the created assignment is displayed in the list
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Go to create new assignment
		assignmentPage.goToCreateReadingsAssignment();
		
		//Enter the input detains in describe assignment tab
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Verify the Organize Resource tab		
		createReadingsAssignmentPage.verifyOrganizeResourcesTab();
		
		//Select save and exit button
		createReadingsAssignmentPage.selectSaveAndExitButton(dataMap);
		
		//Go to assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Verify if the created assignment in displayed in the list
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Go to create new assignment
		assignmentPage.goToCreateReadingsAssignment();
		
		//Enter the input detains in describe assignment tab
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Verify the Organize Resource tab		
		createReadingsAssignmentPage.verifyOrganizeResourcesTab();		
			
		//Navigate to Describe assignment tab
		createReadingsAssignmentPage.navigateToDescribeAssignmentTab();
		
		//Verify the describe assignment tab
		createReadingsAssignmentPage.verifyDescription(dataMap);
		
		//Select the next button
        createReadingsAssignmentPage.SelectNextButton(dataMap);
		
        //Select the next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Navigate to Select Resource tab
		createReadingsAssignmentPage.navigateToSelectResourcesTab();
		
		//Verify Select resource tab
		createReadingsAssignmentPage.verifySelectedResources();
		
		driver= assignmentPage.getDriver();
	}
	
	/******Test Case E4-1931: Assignments - AC - R/R Assignment - Step 4. Navigation buttons******/
	@Test
	public void E4_1931(Map<String,String> dataMap) throws Exception{		
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1932", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//Enter input details in describe assignments tab
	    createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
				
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select back button
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select cancel button
		createReadingsAssignmentPage.selectCancelButton(dataMap);
		
		//Go to create new assignment
		assignmentPage.goToCreateReadingsAssignment();
		
		//Enter input details in describe assignment tab
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
	    //Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Verify Organize resources tab
		createReadingsAssignmentPage.verifyOrganizeResourcesTab();
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select assign later
		createReadingsAssignmentPage.AssignLater();
		
		//Click create new assignment
		assignmentPage.goToCreateReadingsAssignment();
		
		//Enter the input details in describe assignment tab
        createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select assign to class
		createReadingsAssignmentPage.SelectAssignToClass();
		
		//Assign the assignment to class
		createReadingsAssignmentPage.assigntoclass(dataMap);
		
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();
		
		//Click create new assignment button
		assignmentPage.goToCreateReadingsAssignment();
		
		//Enter the input details in describe assignment tab
        createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select Preview assignment
		createReadingsAssignmentPage.PreviewAssignment();
		
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();
		
		driver= assignmentPage.getDriver();
	}
	
	 /*****Test Case E4-1930: Assignments - AC - R/R Assignment - Step 4. Assignment Description****/
	@Test
	public void E4_1930(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1930", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
    	//Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);

		//Enter Input Details
        createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
        //Select chapter 
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);		
		
		//navigate back to describe tab
		createEditAssignmentPage.navigateToDescribeAssignmentTab();
		
		//change value of assignment id and name
		createEditAssignmentPage.changeAssignmentNameAndId(dataMap);
		
		//Select Next button
		createEditAssignmentPage.selectNextButton();
		
		//Select Next button
		createEditAssignmentPage.selectNextButton();
		
		//Select Next button
		createEditAssignmentPage.selectNextButton();
		
		//verify the modified assignment name and id
		createEditAssignmentPage.verifyAssignmentNameAndId(dataMap, "AsgntID");
		
		driver= assignmentPage.getDriver();
	}
	
	/****Test Case E4-1927: Assignments - AC - R/R Assignment - Step 3. Actions****/
	/****TO DO PENDING*****
	@Test
	public void E4_1927(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1927", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
		//Enter input details in describe assignment tab
        createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
        //Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Verify Remove link
		
		createReadingsAssignmentPage.verifyRemovelink();
		
		//Remove one resource
		createReadingsAssignmentPage.removeOneResource();
		
		//Remove all resources
	    createReadingsAssignmentPage.removeAllResources();
	    
	    driver= assignmentPage.getDriver();
	}****/
	
	/*****Test Case E4-1928: Assignments - AC - R/R Assignment - Step 3. Order****/
	/****TO DO PENDING****
	@Test
	public void E4_1928(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1928", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//Enter input details in describe assignment tab
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Verify Resource order tab
		createReadingsAssignmentPage.verifyResourceOrder(dataMap);
		
		//Verify the order values
		createReadingsAssignmentPage.checkPossibleValues(dataMap);
		
		//Change the order 
		createEditAssignmentPage.changeOrderOfThirdQuestion();
		
		//Click save and exit button
		createReadingsAssignmentPage.selectSaveAndExitButton(dataMap);
		
		//Goto Assignment List
		assignmentPage.goToAssignmentList(dataMap);
		
		//Select Edit assignment
		assignmentPage.selectActionsEditAssignment(dataMap, "AsgntName");
			
		//Verify alert message
		assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Check the order value
		createReadingsAssignmentPage.checkPossibleValues(dataMap);
		
		driver= assignmentPage.getDriver();
	}******/
	
	/*****Test Case E4-991: Assignments - AC - R/R Assignment - Step 1. Date and Source****/
	/****TO DO PENDING**** 
	@Test
	public void E4_991(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_991", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//verify date
		createReadingsAssignmentPage.verifyDate(dataMap);
		
		//verify source
	    createReadingsAssignmentPage.verifySource(dataMap);
		
		//click my profile
		//createReadingsAssignmentPage.MyProfile(dataMap);
		
		//click Assignment tab
		createEditAssignmentPage.assignmentLink();
		
		//Click create new assignment
		assignmentPage.goToCreateReadingsAssignment();
		
		//verify modified source name
		//createReadingsAssignmentPage.verifyModifiedSource(dataMap);
		
		driver=assignmentPage.getDriver();
	}******/
	
	/*****Test Case E4-2031: Assignments - AC - R/R Assignment - Assign R/R page. Access after the Due Date****/
	@Test
	public void E4_2031(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_991", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//Enter the input details in describe assignment tab
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Select Next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select Assign to class button
		createReadingsAssignmentPage.SelectAssignToClass();
		
		//Select Attempts marked late radio button
		createReadingsAssignmentPage.AttemptsmarkedLate(dataMap);
		
		createEditAssignmentPage.focusMainWindow();
			
		//Navigate to assignment list		
        assignmentPage.goToAssignmentList(dataMap);
		
        //Verify if created assignment is displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Select the assignment
		assignmentPage.selectAssignmentLink(dataMap);
		
		//Verify the student access in preview window
		assignmentPage.verifyStudentAccessSettingInPreviewWindow();
		
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();		
		
		//Select Edit availability option
		assignmentPage.selectActionsEditAvailability(dataMap, "AsgntName");
		
		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");
		
		//Select access view only radio button
		createEditAssignmentPage.selectStudentAccessViewOnly();
		
		//Select submit button
		createReadingsAssignmentPage.selectSubmitButton();
		
		//Verify the alert message displayed
		createReadingsAssignmentPage.verifyAlertMessageInAssignPage();
		
		createEditAssignmentPage.focusMainWindow();
		
		//Navigate to the assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Verify if the created assignment is displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Select the assignment
		assignmentPage.selectAssignmentLink(dataMap);
		
		//Verify the  access settings in assignment preview window
		assignmentPage.verifyStudentAccessSettingInPreviewWindow();
		
		//Close the preview window
		createEditAssignmentPage.closeWindow1();
		
		createEditAssignmentPage.focusMainWindow();
		
		//Select edit availability option
		assignmentPage.selectActionsEditAvailability(dataMap, "AsgntName");
		
		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");
		
		//Select access with view assistance radio button
		createEditAssignmentPage.selectStudentAccessViewWithAssistance();
		
		//Select submit button
		createReadingsAssignmentPage.selectSubmitButton();
		
		//Verify the alert message displayed
		createReadingsAssignmentPage.verifyAlertMessageInAssignPage();
		
		createEditAssignmentPage.focusMainWindow();
		
		//Navigate to the assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Verify if the created assignment is displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Select the assignment
		assignmentPage.selectAssignmentLink(dataMap);
		
		//Verify the  access settings in assignment preview window
		assignmentPage.verifyStudentAccessSettingInPreviewWindow();
		
		//Close the preview window
		createEditAssignmentPage.closeWindow();
		
		driver= assignmentPage.getDriver();
	}
	
	/****Test Case E4-2030: Assignments - AC - R/R Assignment - Assign R/R page. Select Class Sections****/
	@Test
	public void E4_2030(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_2030", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
		//Enter input details in describe assignment page
	    createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select Resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Click assign to class button
		createReadingsAssignmentPage.SelectAssignToClass();
	
	    //Select all class sections
		createReadingsAssignmentPage.checkAllClassSection(dataMap);
	
	    //Uncheck all class section
		createReadingsAssignmentPage.unCheckAllClassSection(dataMap);
		
		//Uncheck a class section
		createReadingsAssignmentPage.uncheckSelectedClassSection(dataMap);
		
		//Select submit button
		createReadingsAssignmentPage.selectSubmitButton();
	
	    //Verify alert message
		createReadingsAssignmentPage.verifyAlertMessageClassSection();
		
		driver= assignmentPage.getDriver();
	}
		
	/****Test Case E4-2032: Assignments - AC - R/R Assignment - Assign R/R page. Current date****/	
	@Test
	public void E4_2032(Map<String,String> dataMap) throws Exception{
			
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_2032", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
		
		//Enter input details in describe assignment page
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
		
		//Select chapter
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//Select resources
		createReadingsAssignmentPage.selectResources(dataMap);
		
		//Click next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Click assign to class button
		createReadingsAssignmentPage.SelectAssignToClass();
		
		//Verify the current date
		createReadingsAssignmentPage.VerifyCurrentDate();
		
		driver= assignmentPage.getDriver();
	}
	
	/***Test Case E4-424: Assignment - Assignment Creator - Reading/Resources Assignment. Edit Assignment****/
	/*****TO DO PENDING*****
	@Test
	public void E4_424(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_424", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

    	//Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage = PageFactory.initElements(driver, CreateReadingsAssignment.class);
		
		//Goto assignment list		
        assignmentPage.goToAssignmentList(dataMap);
		
        //Verify if assignment is displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Select assignment in list
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");
		
		//Slect go button
		assignmentPage.selectAssignmentGobutton(dataMap, "AsgntName");
		
		//Verfiy edit assignment alert message
		assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
		
		//Verify describe assignment tab
		createReadingsAssignmentPage.verifyDescribeAssignmentTab();
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Verify selected resources
		createReadingsAssignmentPage.verifySelectedResources();
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Remove one resource
		createReadingsAssignmentPage.removeOneResource();
		
		//Select save and exit button
		createReadingsAssignmentPage.selectSaveAndExitButton(dataMap);
		
		driver= assignmentPage.getDriver();
	}***/
	
	/****Test Case E4-1283: Assignment - AC - Reading/Resources Assignment. Edit Assignment. Not Assigned.***/
	/******TO DO PENDING****
	@Test
	public void E4_1283(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_424", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage = PageFactory.initElements(driver, CreateReadingsAssignment.class); 
	
		//Goto assignment list
        assignmentPage.goToAssignmentList(dataMap);
		
        //Verify if assignment is displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Select assignment from list
		assignmentPage.selectAssingmentInList(dataMap, "AsgntName");
		
		//Select go button
		assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);
		
		//Verfiy edit assignment alert message
		assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
		
		//Verify describe assignment tab
		createReadingsAssignmentPage.verifyDescribeAssignmentTab();
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Verify selected resources
		createReadingsAssignmentPage.verifySelectedResources();
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Remove one resources
		createReadingsAssignmentPage.removeOneResource();
		
		//Select save and exit button
		createReadingsAssignmentPage.selectSaveAndExitButton(dataMap);
	
		driver= assignmentPage.getDriver();
	}*****/
	
	/****Test Case E4-429: Assignment Player - Instructor - Readings/Resources Assignment****/
	
	@Test(dependsOnMethods={"E4_395"})
	public void E4_429(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_429", driver);
			
		/****PRECONDITION*****/
		E4_395(dataMap);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);

	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage = PageFactory.initElements(driver, CreateReadingsAssignment.class); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		createEditAssignmentPage.assignmentLink();
		
		//Goto assignment list
		assignmentPage.goToAssignmentList(dataMap);
					
		//Select assignment link
		assignmentPage.selectAssignmentLink(dataMap);
		
		//Select next button
		createReadingsAssignmentPage.SelectNextButton(dataMap);
		
		//Select back button
		createReadingsAssignmentPage.selectBackButtonNavigate(dataMap);
		
		//Select preview progress
		createReadingsAssignmentPage.selectReviewProgress();
		
		driver= assignmentPage.getDriver();
	}
	
	/*******Test Case E4-1926: Assignments - AC - R/R Assignment - Step 2. Resource list sorting*******/
	@Test
	public void E4_1926(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_1926", driver);
		
    	AssignmentPage assignmentPage= PageFactory.initElements(driver, AssignmentPage.class);
    	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
		//Description: Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
			
		//Description: Choose Chapter  in Select Question screen
		createReadingsAssignmentPage.chooseChapter(dataMap);
		
		//select and verify sorting triangle
		createReadingsAssignmentPage.selectResourceNameTriangle();
		
		//Verify Resource Name list
		createReadingsAssignmentPage.verifyResourceNameList();
		
		//Select Resource File Type	List	
		createReadingsAssignmentPage.SelectResourceFileType();
		
		//verify Resource File Type List
		createReadingsAssignmentPage.verifyResourceFileType();
		
		//Select Associated chapter List
		createReadingsAssignmentPage.selectAssociatedChapterTriangle();
		
		//Verify Associated chapter List
		createReadingsAssignmentPage.verifyAssociatedChapterTriangle();
		
		//Navigate to assignment page
		createEditAssignmentPage.assignmentLink(); 
		
		createEditAssignmentPage.selectSourceTriangle();
		
		//close driver
	    Browser.closeDriver(driver);
	    
		driver= assignmentPage.getDriver();
	}
	
	 /*****Test Case E4-990: Assignments - AC - R/R Assignment - Step 1. Sharing******/
	@Test
	public void E4_990(Map<String,String> dataMap) throws Exception{
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_990", driver);
		
    	String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		
		//Launch URL
	   WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
			
	    //Login
	    HomePage home=PageFactory.initElements(driver, HomePage.class);
	    CourseSelectionPage courseSelectionPage=home.login(dataMap);
	
	    //Select Course
	    CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
	
	    //GoTo Assignment page
	    AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
	    CreateEditAssignmentPage createEditAssignmentPage = PageFactory.initElements(driver, CreateEditAssignmentPage.class);
	
	    LogoutSessionPage logoutSessionPage = PageFactory.initElements(driver, LogoutSessionPage.class);
		
		//Select Make available to Other Instructor Radio Button
		
		//Description: Enter details in Describe Assignment details
		createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
	
		//Description: Choose Chapter  in Select Resources screen
	    createReadingsAssignmentPage.chooseChapter(dataMap);
	
	    //Description: Select Questions displayed in Select Resources screen
	    createReadingsAssignmentPage.selectResources(dataMap);
	
	    //Description: Select Organize Resources Screen
	    createReadingsAssignmentPage.organizeResources(dataMap);
	   
	    //Description:Select Assign Later button
	    createReadingsAssignmentPage.AssignLater();
	   
	    //Logout as Instructor A
	    logoutSessionPage.logOutSession();
	   
	    logoutSessionPage.handleCourseAdminAlert();
	   
	    //Login as Instructor B	    
	    Browser.navigateURL(driver, strURL);
	   
   	    home.loginB(dataMap);
	
   	    //Select the course
	    courseSelectionPage.selectCourse(dataMap);
	
	    //Select Assignment tab and go to assignment page
	    courseHomePage.goToAssigmentPage();
	
	    //Go to Assignment list
	    assignmentPage.goToAssignmentList(dataMap);
	
	    //Verify if the assignment creatred by Instructor A is displayed in the list
	    assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
	
	    //Logout as Instructor B
	    logoutSessionPage.logOutSession();
	   
	    logoutSessionPage.handleCourseAdminAlert();
	   
	    //Login as Instructor A	   
	    Browser.navigateURL(driver, strURL);
	    
	    home.login(dataMap);
		
	    //Select the course
	    courseSelectionPage.selectCourse(dataMap);
		
	    //Select the assignment tab and go to assignment page
	    courseHomePage.goToAssigmentPage();
		
	    //Go to assignment list
	    assignmentPage.goToAssignmentList(dataMap);
		
	    //Select the assignment from list and Edit Assignment
	    assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);
	    		
   	    //Verify alert
	    assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
		
	    //Change the sharing radio button to 'Do not share'
	    createEditAssignmentPage.doNotShareWithOthers();
		
	    //Select the next button
	    createEditAssignmentPage.selectNextButton();
	   
	    //Select Save and Exit button
	    createReadingsAssignmentPage.saveAndExit(dataMap);
	   
	    //Logout as Instuctor A
	    logoutSessionPage.logOutSession();
	   
	    logoutSessionPage.handleCourseAdminAlert();
	   
	    //Relaunch the URL	
	    Browser.navigateURL(driver, strURL);
	    
	    //Login as Instructor B
		home.loginB(dataMap);
		
		//Select the course
		courseSelectionPage.selectCourse(dataMap);
		
		//Select the assignment tab and goto assignment page
		courseHomePage.goToAssigmentPage();
		
		//Goto assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Verify if the assignment is displayed
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Logout as Instructor B
		logoutSessionPage.logOutSession();
		
		logoutSessionPage.handleCourseAdminAlert();
		
		//Relaunch the URL		
		Browser.navigateURL(driver, strURL);
		
		//Selecting Work In Draft Mode Radio Button
	   
		//Login as Instructor A
		home.login(dataMap);
		
		//Select the course
		courseSelectionPage.selectCourse(dataMap);
		
		//Select the assignment tab and go to assignment page
		courseHomePage.goToAssigmentPage();
		
		//Go to assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Select the assignment from the list and edit the assignment
		assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);
				
		//Verify alert
		assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
		
		//Change the sharing to Work in draft mode
		createEditAssignmentPage.workInDraftMode();
		
		//Select next button
		createEditAssignmentPage.selectNextButton();
		
		//Select save and exit button
		createReadingsAssignmentPage.saveAndExit(dataMap);
		 
		//Logout as Instructor A
		logoutSessionPage.logOutSession();
		
		logoutSessionPage.handleCourseAdminAlert();
		
		//Relaunch the URL		
		Browser.navigateURL(driver, strURL);
		
		//Login as Instructor B
		home.loginB(dataMap);
		
		//Select the course
		courseSelectionPage.selectCourse(dataMap);
		
		//Select the assignment tab and go to assignment page
		courseHomePage.goToAssigmentPage();
		
		// Go to assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Verify if the assignment is displayed in the list
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Logout as Instructor B
		logoutSessionPage.logOutSession();
		
		logoutSessionPage.handleCourseAdminAlert();
		
		//Relaunch the URL
		Browser.navigateURL(driver, strURL);
		
		//Assign to class and verify
		//Login as Instructor A
		home.login(dataMap);
		
		//Select the course
		courseSelectionPage.selectCourse(dataMap);
		
		//select the assignm,ent tab and go to assignment page
		courseHomePage.goToAssigmentPage();
		
		//Go to assignment list
		assignmentPage.goToAssignmentList(dataMap);
		
		//Select the assignment to Edit the assignment
		assignmentPage.selectAssignmentEditNotAssignedToClass(dataMap);
		
		//Verify alert
		assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
		
		//Select the next button
		createEditAssignmentPage.selectNextButton();
		
		//Verify the Select Resource tab
		createReadingsAssignmentPage.verifySelectResourcestab();
		
		//Select next button
		createEditAssignmentPage.selectNextButton();
		
		//Verify Organize Resources tab
		createReadingsAssignmentPage.verifyOrganizeResourcesTab();
		
		//Select Assign to class button
		createReadingsAssignmentPage.selectAssignToClassButton();
		
		//Assign the assignment to any class
		createReadingsAssignmentPage.assigntoclass(dataMap);
		
		//Select submit button
		createReadingsAssignmentPage.selectSubmitButton();
		
		//Logout as Instructor A
		logoutSessionPage.logOutSession();
		
		logoutSessionPage.handleCourseAdminAlert();
		
		//Relaunch the URL		
		Browser.navigateURL(driver, strURL);
		
		//Login as Instructor B
		home.loginB(dataMap);
		
		//Select the course
		courseSelectionPage.selectCourse(dataMap);
		
		//Select the assignment tab and go to assignment page
		courseHomePage.goToAssigmentPage();
		
		//Go to assignment list
		assignmentPage.goToAssignmentList(dataMap);
			
		//Verify if the assignment created by Instructor A is dispalyed in the list
		assignmentPage.verifyAssignmentDisplayed(dataMap, "AsgntName");
		
		//Logout as Instructor B	
		logoutSessionPage.logOutSession();
		
		logoutSessionPage.handleCourseAdminAlert();
		
		Browser.navigateURL(driver, strURL);
		
        home.login(dataMap);
		
		//Select the course
		courseSelectionPage.selectCourse(dataMap);
		
		//select the assignm,ent tab and go to assignment page
		courseHomePage.goToAssigmentPage();
		
		driver= assignmentPage.getDriver();		
	}
	
	/******Test Case E4-807: Assignments - AC - R/R Assignment - Step 1. "Display to students" checkbox********/
	@Test
	public void E4_807(Map<String,String> dataMap) throws Exception{
		
		ResultUtil.report("INFO", "AssignmentPrintedTest-E4_807", driver);
	
		String strEnv=Prerequsite.configMap.get("ENV");
		String strURL=Prerequsite.configMap.get(strEnv+".EDUGEN_URL");
		String strStudentURL = Prerequsite.configMap.get(strEnv+".STUDENTEDUGEN_URL");

		//Launch URL
	   WebDriver driver=Browser.launchURL(dataMap.get("Machine"), dataMap.get("Port"), dataMap.get("Browser"), strURL);
			
	    //Login
	    HomePage home=PageFactory.initElements(driver, HomePage.class);
	    CourseSelectionPage courseSelectionPage=home.login(dataMap);
	
	    //Select Course
	    CourseHomePage courseHomePage = courseSelectionPage.selectCourse(dataMap);
	
	    //GoTo Assignment page
	    AssignmentPage assignmentPage = courseHomePage.goToAssigmentPage();
	
	    //Goto Create Reading Assignment page
	    CreateReadingsAssignment createReadingsAssignmentPage =assignmentPage.goToCreateReadingsAssignment(); 
	
		//Description: Enter details in Describe Assignment details
	    createReadingsAssignmentPage.inputDescrptionDetails(dataMap);
	
	    //Description: Choose Chapter  in Select Resource screen
	    createReadingsAssignmentPage.chooseChapter(dataMap);
	
	    //Description: Select Questions displayed in Select Resource screen
	    createReadingsAssignmentPage.selectResources(dataMap);
	
	    //Description: Select Organize resource Screen
	    createReadingsAssignmentPage.organizeResources(dataMap);
	
	    //Description: Select Class from the Select Assign to class screen
	    createReadingsAssignmentPage.assigntoclass(dataMap);
	 
	    StudentLoginpage studentLoginpage=	PageFactory.initElements(driver, StudentLoginpage.class);
		
	    Browser.navigateURL(driver, strStudentURL);
		
		//Login Page
		StudentHomepage studentHomepage= studentLoginpage.loginPage(dataMap);
		
		//Go to Student Home page  
		StudentAssignmentPage studentAssignmentPage = studentHomepage.studentHomeScreen(dataMap);
		
		//Selecting the assignment link
		OpenAssignment openAssignment= studentAssignmentPage.selectAssignment(dataMap, "AsgntName");
		
		///openAssignment.switchFrames();
		
		//Verify the Description/Instructions is displayed in the assignment screen
		openAssignment.verifyDescription(dataMap);
		
		//openAssignment.selectTest(dataMap);
		
		Browser.navigateURL(driver, strURL);
		
		home.login(dataMap);
		
		courseSelectionPage.selectCourse(dataMap);
		
		courseHomePage.goToAssigmentPage();
	
	    //Re-login as Instructor and selecting assignment list from Assignment page
	    assignmentPage.goToAssignmentList(dataMap);
	
	    //Description: Selecting Assignment and Editing the Assignment
	    // assignmentPage.selectAssingmentInList(dataMap);
	    
	    //Description: Selecting Assignment and Editing the Assignment
	    assignmentPage.selectActionsEditAssignment(dataMap, "AsgntName");
	    
	    assignmentPage.EditAssignmentAlertMessage(dataMap, "AsgntName");
	
	    //Description: Un-check Display to Students Check box and click Next
	    createReadingsAssignmentPage.unselectDisplayStudentCheckbox(dataMap);
	
	    //Save and Exit the Edit Assignment Page
	    createReadingsAssignmentPage.saveAndExit(dataMap);
	   
	    Browser.navigateURL(driver, strStudentURL);
		
		//Login Page
		studentLoginpage.loginPage(dataMap);
		
		//Go to Student Home page  
		studentHomepage.studentHomeScreen(dataMap);
		
		//Selecting the assignment link
		studentAssignmentPage.selectAssignment(dataMap, "AsgntName");
		
		//openAssignment.switchFrames();
		
		//Verify the Description/Instructions is displayed in the assignment screen
		openAssignment.verifyDescription(dataMap);
		
		Browser.navigateURL(driver, strURL);
		
		home.login(dataMap);
		
		courseSelectionPage.selectCourse(dataMap);
		
		courseHomePage.goToAssigmentPage();
		
		//close driver
	    Browser.closeDriver(driver);		
					
	}
			
}

