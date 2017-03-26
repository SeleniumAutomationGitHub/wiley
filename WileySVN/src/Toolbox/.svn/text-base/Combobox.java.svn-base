package Toolbox;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Combobox {
	
	public static boolean selectItemByValue(String strLogicalName,WebElement element,String strValue,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						sel.selectByVisibleText(strValue);
						blResult=true;
						ResultUtil.report("PASS", "Selected [["+strValue+"]] value in <<"+strLogicalName+">> comboBox",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select [["+strValue+"]] value in <<"+strLogicalName+">> comboBox Exception occurred:"+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to select [["+strValue+"]] value-<<"+strLogicalName+">> comboBox is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select [["+strValue+"]] value-<<"+strLogicalName+">> comboBox does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select [["+strValue+"]] value-<<"+strLogicalName+">> comboBox does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean selectItemByIndex(String strLogicalName,WebElement element,int itemIndex,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						sel.selectByIndex(itemIndex);
						blResult=true;
						ResultUtil.report("PASS", "Selected [["+itemIndex+"]] item in <<"+strLogicalName+">> comboBox",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select [["+itemIndex+"]] item in <<"+strLogicalName+">> comboBox Exception occurred:"+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to select [["+itemIndex+"]] item-<<"+strLogicalName+">> comboBox is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select [["+itemIndex+"]] item-<<"+strLogicalName+">> comboBox does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select [["+itemIndex+"]] item-<<"+strLogicalName+">> comboBox does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean selectFirstItem(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						sel.selectByIndex(1);
						blResult=true;
						ResultUtil.report("PASS", "Selected first item in <<"+strLogicalName+">> combobox",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select first item in <<"+strLogicalName+">> combobox Exception occurred:"+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to select first item-<<"+strLogicalName+">> combobox is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select first item-<<"+strLogicalName+">> combobox does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select first item-<<"+strLogicalName+">> combobox does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean selectLastItem(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		
		int size =0;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						sel.selectByIndex(sel.getOptions().size());
						blResult=true;
						ResultUtil.report("PASS", "Selected last item in <<"+strLogicalName+">> combobox",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select last item in <<"+ strLogicalName+">> combobox Exception occurred:"+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to select last item-<<"+strLogicalName+">> is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select last item-<<"+strLogicalName+">> does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select last item-<<"+strLogicalName+">> does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean selectRandomItem(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		int size =0;
		int index = 0;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Select sel = new Select(element);
						index=getRandomIndex(sel.getOptions().size());
						sel.selectByIndex(index);
						blResult=true;
						ResultUtil.report("PASS", "Selected [["+index+"]] random item in <<"+ strLogicalName+">> combobox",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select [["+index+"]] random item in <<"+strLogicalName+">> combobox Exception occurred:"+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to select [["+index+"]] random item-<<"+strLogicalName+">> combobox is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select [["+index+"]] random item-<<"+strLogicalName+">> combobox does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select [["+index+"]] random item-<<"+strLogicalName+">> combobox does not exist",driver);
		}
		return blResult;
	}

	public static boolean isEnabled(WebElement element , String strLogicalName,WebDriver driver){
        boolean blResult=false;
        if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						blResult = true;
						ResultUtil.report("PASS", "<<"+strLogicalName+">> combobox is enabled",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> combobox enable status Exception occurred: "+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to verify enable status-<<"+strLogicalName+">> comobox is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify enable status-<<"+strLogicalName+">> comobox does not exist",driver);
			}
        }
        else{
        	ResultUtil.report("FAIL", "Unable to verify enable status-<<"+strLogicalName+">> comobox does not exist",driver);
        }
		return blResult;
	}
	
	public static boolean isDisabled(WebElement element , String strLogicalName,WebDriver driver){
        boolean blResult=false;
        if(element!=null){
			if(element.isDisplayed()){
				if(!element.isEnabled()){
					try{
						blResult = true;
						ResultUtil.report("PASS", "<<"+strLogicalName+">> combobox is disabled",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> combobox disable status Exception occurred: "+e.getMessage(),driver);
					}
					
				}
				else{
					ResultUtil.report("FAIL", "Unable to verify disable status-<<"+strLogicalName+">> comobox is disabled",driver);
					System.out.println();
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify disable status-<<"+strLogicalName+">> comobox does not exist",driver);
			}
        }
        else{
        	ResultUtil.report("FAIL", "Unable to verify disable status-<<"+strLogicalName+">> comobox does not exist",driver);
        }
		return blResult;
	}
	
	public static int getRandomIndex(int size){
		int random =new Random().nextInt(size+1);
		if(random==0){random++;}
		return random;
	}
	
	public static boolean verifySelectedItem(String strLogicalName,WebElement element,String strValue,WebDriver driver){
		boolean blResult=false;
		 if(element!=null){
			if(element.isDisplayed()){
				try{
					Select sel = new Select(element);
					if(sel.getFirstSelectedOption().getText().equalsIgnoreCase(strValue)){
						blResult=true;
						ResultUtil.report("PASS", "Verifed selected item in <<"+strLogicalName+">> combobox Selected item:[["+strValue+"]]",driver);
					}
					else{
						ResultUtil.report("FAIL", "Verifed selected item in <<"+strLogicalName+">> combobox Selected item:[["+sel.getFirstSelectedOption().getText()+"]]",driver);
					}
				}
				catch(Exception e){
					ResultUtil.report("FAIL", "Unable to verify selected item in <<"+strLogicalName+">> combobox Exception occurred:"+e.getMessage(),driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify selected item in <<"+strLogicalName+">> combobox does not exist",driver);
			}
		 }
		 else{
			 ResultUtil.report("FAIL", "Unable to verify selected item in <<"+strLogicalName+">> combobox does not exist",driver);
		 }
		return blResult;
	}

}
