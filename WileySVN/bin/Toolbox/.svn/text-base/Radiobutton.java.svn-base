package Toolbox;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

public class Radiobutton {
	public static boolean select(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						element.click();
						blResult=true;
						ResultUtil.report("PASS", "Selected <<"+strLogicalName+">> radiobutton",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select <<"+strLogicalName+">> radioButton Exception occurred:"+e.getMessage(),driver);
					}
				}
				else{
					ResultUtil.report("FAIL", "Unable to select-<<"+strLogicalName+">> radioButton is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select-<<"+strLogicalName+">> radioButton does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select-<<"+strLogicalName+">> radioButton does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean JSSelect(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						JavascriptExecutor javaScriptExecutor=((JavascriptExecutor)driver);
						javaScriptExecutor.executeScript("arguments[0].click",element);
						blResult=true;
						ResultUtil.report("PASS", "Selected <<"+strLogicalName+">> radiobutton",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to select <<"+strLogicalName+">> radioButton Exception occurred:"+e.getMessage(),driver);
					}
				}
				else{
					ResultUtil.report("FAIL", "Unable to select-<<"+strLogicalName+">> radioButton is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to select-<<"+strLogicalName+">> radioButton does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to select-<<"+strLogicalName+">> radioButton does not exist",driver);
		}
		return blResult;
	}

	public static boolean mouseClick(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Mouse mouse=((HasInputDevices)driver).getMouse();
						mouse.mouseDown(((Locatable)element).getCoordinates());
						try{Thread.sleep(500);}catch(Exception e){}
						mouse.mouseUp(((Locatable)element).getCoordinates());
						blResult=true;
						ResultUtil.report("PASS", "Clicked <<"+strLogicalName+">> radioButton",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to click <<"+strLogicalName+">> radioButton Exception occurred:"+e.getMessage(),driver);
					}	
				}
				else{
					ResultUtil.report("FAIL", "Unable to click-<<"+strLogicalName+">> radioButton is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to click-<<"+strLogicalName+">> radioButton does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to click-<<"+strLogicalName+">> radioButton does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean verify(String strLogicalName,WebElement element,WebDriver driver){		
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				try{
					element.click();
					blResult=true;
					ResultUtil.report("PASS", "Verified <<"+strLogicalName+">> radiobutton",driver);
					
				}
				catch(Exception e){
					ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> radiobutton Exception occurred:" +e.getMessage(),driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> radiobutton does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> radiobutton does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean isSelected(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult = false;
		if(element!=null){
			if (element.isDisplayed()) {
				try {
					if (element.isSelected()) {
						blResult = true;
						ResultUtil.report("PASS", "<<"+strLogicalName+">> radiobutton is selected",driver);
					}
				} catch (Exception e) {
					ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+ ">> radiobutton selection mode Exception occurred:" + e.getMessage(),driver);
				}
			} else {
				ResultUtil.report("FAIL", "Unable to verify selection mode-<<"+strLogicalName+ ">> radiobutton does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to verify selection mode-<<"+strLogicalName+ ">> radiobutton does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean isEnabled(WebElement element, String strLogicalName,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						blResult=true;
						ResultUtil.report("PASS", "<<"+strLogicalName+">> radiobutton is enabled",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> radiobutton enable mode Exception occurred:"+e.getMessage(),driver);
					}
				}
				else{
					ResultUtil.report("FAIL", "Unable to verify enable mode-<<"+strLogicalName+">> radiobutton is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify enable mode-<<"+strLogicalName+">> radiobutton does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to verify enable mode-<<"+strLogicalName+">> radiobutton does not exist",driver);
		}
		return blResult;
	 }
}
