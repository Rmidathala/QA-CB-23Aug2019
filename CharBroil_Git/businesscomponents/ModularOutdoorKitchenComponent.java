package businesscomponents;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.ModularOutdoorKitchen;

public class ModularOutdoorKitchenComponent extends ReusableLibrary {


	WebDriverUtil obj=new WebDriverUtil(driver);



	public ModularOutdoorKitchenComponent(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}





	/******************************************** Validate panel expand Functionality and content Validation *****************************************************************/	
	public void validatePanelExpand(){

		try{


			driver.findElement(ModularOutdoorKitchen.panel1Expand).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.txtPanel1, 20);
			if(driver.findElement(ModularOutdoorKitchen.txtPanel1).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkClosePanel).click();
				report.updateTestLog("Panel Expand Validation", "Panel Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Panel Expand Validation", "Panel Content Details is not displayed.", Status.PASS);
			}

			Thread.sleep(1000);
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.panel2Expand, 20);
			driver.findElement(ModularOutdoorKitchen.panel2Expand).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.txtPanel2, 20);
			if(driver.findElement(ModularOutdoorKitchen.txtPanel2).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkClosePanel).click();
				report.updateTestLog("Panel Expand Validation", "Panel Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Panel Expand Validation", "Panel Content Details is not displayed.", Status.PASS);
			}
			Thread.sleep(1000);
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.panel3Expand, 20);
			driver.findElement(ModularOutdoorKitchen.panel3Expand).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.txtPanel3, 20);
			if(driver.findElement(ModularOutdoorKitchen.txtPanel3).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkClosePanel).click();
				report.updateTestLog("Panel Expand Validation", "Panel Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Panel Expand Validation", "Panel Content Details is not displayed.", Status.PASS);
			}


		}
		catch(Exception e){
			report.updateTestLog("Panel Expand Validation", "Exception while validating panel expand link functioanlity", Status.FAIL);

		}

	}

	/********************************************************************************************************************************************************************************************/


	/******************************************** Validate Banner expand Functionality and content Validation *****************************************************************/	
	public void validateBannerExpand(){

		try{


			driver.findElement(ModularOutdoorKitchen.lnkBannerExpand1).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lblBannerExpandText1, 20);
			if(driver.findElement(ModularOutdoorKitchen.lblBannerExpandText1).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkBannerExpand1Close).click();
				report.updateTestLog("Banner Expand Validation", "Banner Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Banner Expand Validation", "Banner Content Details is not displayed.", Status.PASS);
			}
			Thread.sleep(1000);	
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lnkBannerExpand2, 20);
			driver.findElement(ModularOutdoorKitchen.lnkBannerExpand2).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lblBannerExpandText2, 20);
			if(driver.findElement(ModularOutdoorKitchen.lblBannerExpandText2).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkBannerExpand2Close).click();
				report.updateTestLog("Banner Expand Validation", "Banner Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Banner Expand Validation", "Banner Content Details is not displayed.", Status.PASS);
			}
			Thread.sleep(1000);
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lnkBannerExpand3, 20);
			driver.findElement(ModularOutdoorKitchen.lnkBannerExpand3).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lblBannerExpandText3, 20);
			if(driver.findElement(ModularOutdoorKitchen.lblBannerExpandText3).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkBannerExpand3Close).click();
				report.updateTestLog("Banner Expand Validation", "Banner Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Banner Expand Validation", "Banner Content Details is not displayed.", Status.PASS);
			}
			Thread.sleep(1000);
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lnkBannerExpand4, 20);
			driver.findElement(ModularOutdoorKitchen.lnkBannerExpand4).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lblBannerExpandText4, 20);
			if(driver.findElement(ModularOutdoorKitchen.lblBannerExpandText4).isDisplayed())
			{
				driver.findElement(ModularOutdoorKitchen.lnkBannerExpand4Close).click();
				report.updateTestLog("Banner Expand Validation", "Banner Detail is expanding properly after clicking on Expand link. Content Validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Banner Expand Validation", "Banner Content Details is not displayed.", Status.PASS);
			}


		}
		catch(Exception e){
			report.updateTestLog("Banner Expand Validation", "Exception while validating Banner expand link functioanlity", Status.FAIL);

		}

	}

	/********************************************************************************************************************************************************************************************/



	/******************************************** Validate modular Product Expand Functionality *****************************************************************/	
	public void validateModularProductExpand(){

		try{

			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lnkModularProduct1Expand, 20);
			//driver.findElement(ModularOutdoorKitchen.lnkModularProduct1Expand).click();
			//obj.waitUntilElementEnabled(ModularOutdoorKitchen.lblModularProduct1ExpandContent, 20);
			if(driver.findElement(ModularOutdoorKitchen.lnkModularProduct1Expand).isDisplayed())
			{
				Thread.sleep(2000);
				report.updateTestLog("Modular Product Expand Validation", "Modular Product link validation is successful ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Modular Product Expand Validation", "Modular Product link validation is not successful ", Status.FAIL);
			}




		}
		catch(Exception e){
			report.updateTestLog("Modular Product Expand Validation", "Exception while validating Modular Product expand link functioanlity. Exception - "+e, Status.FAIL);

		}

	}

	/********************************************************************************************************************************************************************************************/




	/******************************************** Validate shop modular outdoor Kitchen button Functionality *****************************************************************/	
	public void validateShopModularOutdoorKitchenButton(){

		try{

			obj.waitUntilElementEnabled(ModularOutdoorKitchen.btnShopModularOutdoorKitchen, 20);
			driver.findElement(ModularOutdoorKitchen.btnShopModularOutdoorKitchen).click();
			obj.waitUntilElementEnabled(ModularOutdoorKitchen.lblModularOutdoorKitchen, 20);
			if(driver.findElement(ModularOutdoorKitchen.lblModularOutdoorKitchen).isDisplayed())
			{
				Thread.sleep(2000);
				report.updateTestLog("Modular Outdoor Kitchen Button Validation", "Modular Outdoor kitchen page is displayed properly after clicking on shop modular outdoor kitchen button. ", Status.PASS);
			}

			else
			{
				report.updateTestLog("Modular Outdoor Kitchen Button Validation", "Modular Outdoor kitchen page is not displayed properly.", Status.PASS);
			}




		}
		catch(Exception e){
			report.updateTestLog("Modular Outdoor Kitchen Button Validation", "Exception while validating Modular Outdoor kitchen button functionality", Status.FAIL);

		}

	}

	/********************************************************************************************************************************************************************************************/





}
