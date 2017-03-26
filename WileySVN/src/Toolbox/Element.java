package Toolbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

public class Element {
	public static boolean verify(String strLogicalName,WebElement element,String strValue,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						String textValue=element.getText();
						if(textValue.equalsIgnoreCase(strValue)){
							blResult=true;
							ResultUtil.report("PASS", "Verified <<"+strLogicalName+">> element",driver);
						}
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> element Exception occurred:"+e.getMessage(),driver);
					}
				}
				else{
					ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean mouseOver(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Mouse mouse=((HasInputDevices)driver).getMouse();
						mouse.mouseMove(((Locatable)element).getCoordinates());
						blResult=true;
						ResultUtil.report("PASS", "Mouse-overed on <<"+strLogicalName+">> element",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to mouseover <<"+strLogicalName+">> element Exception occurred:"+e.getMessage(),driver);
					}
				}
				else{
					ResultUtil.report("FAIL", "Unable to mouseover-<<"+strLogicalName+">> element is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to mouseover-<<"+strLogicalName+">> element does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to mouseover-<<"+strLogicalName+">> element does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean mouseOver(String strLogicalName,WebElement element,int inWait,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
				if(element.isEnabled()){
					try{
						Mouse mouse=((HasInputDevices)driver).getMouse();
						mouse.mouseMove(((Locatable)element).getCoordinates());
						try{Thread.sleep(inWait*1000);}catch(Exception e){}
						blResult=true;
						ResultUtil.report("PASS", "Mouse-overed on <<"+strLogicalName+">> element",driver);
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to mouseover <<"+strLogicalName+">> element Exception occurred:"+e.getMessage(),driver);
					}
				}
				else{
					ResultUtil.report("FAIL", "Unable to mouseover-<<"+strLogicalName+">> element is disabled",driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to mouseover-<<"+strLogicalName+">> element does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to mouseover-<<"+strLogicalName+">> element does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean verify(String strLogicalName,WebElement element,WebDriver driver){
		boolean blResult=false;
		if(element!=null){
			if(element.isDisplayed()){
					try{
						blResult=true;
						ResultUtil.report("PASS", "Verified <<"+strLogicalName+">> element",driver);
						
					}
					catch(Exception e){
						ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> element Exception occurred:"+e.getMessage(),driver);
					}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element does not exist",driver);
		}
		return blResult;
	}
	
	public static boolean verify(String strLogicalName,WebDriver driver,String strLocatorType,String strLocatorValue){
		boolean blResult=false;
		
		WebElement element=Object.getElement(driver, strLocatorType, strLocatorValue);
		
		if(!(element==null)){
			if(element.isDisplayed()){
				try{
					blResult=true;
					ResultUtil.report("PASS", "Verified <<"+strLogicalName+">> element",driver);
					
				}
				catch(Exception e){
					ResultUtil.report("FAIL", "Unable to verify <<"+strLogicalName+">> element Exception occurred:"+e.getMessage(),driver);
				}
			}
			else{
				ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element does not exist",driver);
			}
		}
		else{
			ResultUtil.report("FAIL", "Unable to verify-<<"+strLogicalName+">> element does not exist",driver);
		}
			
		return blResult;
	}
	
	public static boolean notVerify(String strLogicalName,WebDriver driver,String strLocatorType,String strLocatorValue){
		boolean blResult=false;
		
		WebElement element=Object.getElement(driver, strLocatorType, strLocatorValue);
		
		if(element==null){
			ResultUtil.report("PASS", "<<"+strLogicalName+">> element is not displayed as expected", driver);
			blResult=true;
		}
		else{
			ResultUtil.report("FAIL", "<<"+strLogicalName+">> element is displayed", driver);	
		}
			
		return blResult;
	}
}
