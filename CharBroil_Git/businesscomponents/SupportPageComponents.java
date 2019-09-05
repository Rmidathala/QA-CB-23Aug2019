package businesscomponents;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.HomePage;
import uimap.SupportPage;

public class SupportPageComponents extends ReusableLibrary {

	WebDriverUtil wdu=new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public SupportPageComponents(ScriptHelper scriptHelper)	{
		super(scriptHelper);
	}

	/*
	 * Method to validate Register your product in Support link
	 */
	public void validateRegisterYourGrill()		{
		try		{			
			wdu.waitUntilElementEnabled(SupportPage.linkRegisterProduct, 10);
			gc.scrollToElement(SupportPage.linkRegisterProduct);

			//Validate Register your Grill text
			wdu.highlightElement(SupportPage.linkRegisterProduct);
			if(driver.findElement(SupportPage.linkRegisterProduct).getText().equalsIgnoreCase("Register Your Grill"))
				report.updateTestLog("Support Page", "Register your grill text is present.", Status.PASS);
			else
				report.updateTestLog("Support Page", "Register your grill text is not present.", Status.FAIL);

			//Click on Register Product button
			wdu.highlightElement(SupportPage.btnRegisterProduct);
			driver.findElement(SupportPage.btnRegisterProduct).click();
			report.updateTestLog("Support Page", "Clicked on Register Product button.", Status.PASS);

			//Validate product registration page opened up
			wdu.waitUntilElementEnabled(SupportPage.linkRegisterProductHeader, 10);
			gc.scrollToElement(SupportPage.linkRegisterProductHeader);
			wdu.highlightElement(SupportPage.linkRegisterProductHeader);
			if(driver.findElement(SupportPage.linkRegisterProductHeader).getText().equalsIgnoreCase("Product Registration"))
				report.updateTestLog("Support Page", "Product registration text is present.", Status.PASS);
			else
				report.updateTestLog("Support Page", "Product registration text is not present.", Status.FAIL);			

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateRegisterYourGrill", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links under GAS GRILL HELP in support page
	 */
	public void validateGasGrillHelp()		{
		try		{

			//Validate "Gas regulator tripped" link
			wdu.waitUntilElementEnabled(SupportPage.linkGasRegulatorTripped, 10);
			wdu.highlightElement(SupportPage.linkGasRegulatorTripped);
			driver.findElement(SupportPage.linkGasRegulatorTripped).click();
			report.updateTestLog("Support Page", "Clicked on Gas regulator tripped link.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/gas-regulator-tripped/"))	{
					report.updateTestLog("Support Page", "Gas regulator tripped link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Gas regulator tripped link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Gas regulator tripped link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Bad propane tank connection" link
			wdu.waitUntilElementEnabled(SupportPage.linkBadPropaneTankConnection, 10);
			wdu.highlightElement(SupportPage.linkBadPropaneTankConnection);
			driver.findElement(SupportPage.linkBadPropaneTankConnection).click();
			report.updateTestLog("Support Page", "Clicked on Bad propane tank connection link.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/bad-propane-tank-connection/"))	{
					report.updateTestLog("Support Page", "Bad propane tank connection link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Bad propane tank connection link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Bad propane tank connection link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Flames blow out because of wind" link
			wdu.waitUntilElementEnabled(SupportPage.linkFlamesBlowOut, 10);
			wdu.highlightElement(SupportPage.linkFlamesBlowOut);
			driver.findElement(SupportPage.linkFlamesBlowOut).click();
			report.updateTestLog("Support Page", "Clicked on Flames blow out because of wind link.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/flames-blow-out-because-of-wind/"))	{
					report.updateTestLog("Support Page", "Flames blow out because of wind link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Flames blow out because of wind link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Flames blow out because of wind link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateGasGrillHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links under CHARCOAL GRILL HELP in support page
	 */
	public void validateCharcoalGrillHelp()		{
		try		{

			//Validate "Residue in grill" link
			wdu.waitUntilElementEnabled(SupportPage.linkResidueInGrill, 10);
			wdu.highlightElement(SupportPage.linkResidueInGrill);
			driver.findElement(SupportPage.linkResidueInGrill).click();
			report.updateTestLog("Support Page", "Residue in grill link clicked.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/residue-in-grill"))	{
					report.updateTestLog("Support Page", "Residue in grill link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Residue in grill link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();


			//Validate "Charcoal temperature won't regulate" link
			wdu.waitUntilElementEnabled(SupportPage.linkCharcoalTemperature, 10);
			wdu.highlightElement(SupportPage.linkCharcoalTemperature);
			driver.findElement(SupportPage.linkCharcoalTemperature).click();
			report.updateTestLog("Support Page", "Charcoal temperature won't regulate link clicked.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/charcoal-temperature-wont-regulate"))	{
					report.updateTestLog("Support Page", "Charcoal temperature won't regulate link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Charcoal temperature won't regulate link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateCharcoalGrillHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links under ELECTRIC GRILL HELP in support page
	 */
	public void validateElectricGrillHelp()		{
		try		{

			//Validate "Extension cord is wrong" link
			wdu.waitUntilElementEnabled(SupportPage.linkExtensionCord, 10);
			wdu.highlightElement(SupportPage.linkExtensionCord);
			driver.findElement(SupportPage.linkExtensionCord).click();
			report.updateTestLog("Support Page", "Extension cord is wrong link clicked.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/use-an-extension-cord"))	{
					report.updateTestLog("Support Page", "Extension cord is wrong link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Extension cord is wrong link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Grill isn't heating" link
			wdu.waitUntilElementEnabled(SupportPage.linkGrillIsntHeating, 10);
			wdu.highlightElement(SupportPage.linkGrillIsntHeating);
			driver.findElement(SupportPage.linkGrillIsntHeating).click();
			report.updateTestLog("Support Page", "Grill isn't heating link clicked.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/grill-isnt-heating"))	{
					report.updateTestLog("Support Page", "Grill isn't heating link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Grill isn't heating link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Grill stopped working" link
			wdu.waitUntilElementEnabled(SupportPage.linkGrillStoppedWorking, 10);
			wdu.highlightElement(SupportPage.linkGrillStoppedWorking);
			driver.findElement(SupportPage.linkGrillStoppedWorking).click();
			report.updateTestLog("Support Page", "Grill stopped working link clicked.", Status.DONE);
			Thread.sleep(2000);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/grill-stopped-working"))	{
					report.updateTestLog("Support Page", "Grill stopped working link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Grill stopped working link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateElectricGrillHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links under SMOKER & ROASTER GRILL HELP in support page
	 */
	public void validateSmokerRoasterHelp()		{
		try		{

			//Validate "Residue in smoker" link
			wdu.waitUntilElementEnabled(SupportPage.linkResidueInSmoker, 10);
			wdu.highlightElement(SupportPage.linkResidueInSmoker);
			driver.findElement(SupportPage.linkResidueInSmoker).click();
			report.updateTestLog("Support Page", "Residue in smoker link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/residue-in-smoker"))	{
					report.updateTestLog("Support Page", "Residue in smoker link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Residue in smoker link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Water smoker not working" link
			wdu.waitUntilElementEnabled(SupportPage.linkWaterSmoker, 10);
			wdu.highlightElement(SupportPage.linkWaterSmoker);
			driver.findElement(SupportPage.linkWaterSmoker).click();
			report.updateTestLog("Support Page", "Water smoker not working link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/water-smoker-not-working"))	{
					report.updateTestLog("Support Page", "Water smoker not working link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Water smoker not working link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSmokerRoasterHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links under SMARTCHEF GRILL HELP in support page
	 */
	public void validateSmartchefGrillHelp()		{
		try		{

			//Validate "Preventing low flames on your gas grill" link
			wdu.waitUntilElementEnabled(SupportPage.linkPreventingLowFlames, 10);
			wdu.highlightElement(SupportPage.linkPreventingLowFlames);
			driver.findElement(SupportPage.linkPreventingLowFlames).click();
			report.updateTestLog("Support Page", "Preventing low flames on your gas grill link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/use-an-extension-cord"))	{
					report.updateTestLog("Support Page", "Preventing low flames on your gas grill link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Preventing low flames on your gas grill link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Grilling Guides" link
			wdu.waitUntilElementEnabled(SupportPage.linkGrillingGuides, 10);
			wdu.highlightElement(SupportPage.linkGrillingGuides);
			driver.findElement(SupportPage.linkGrillingGuides).click();
			report.updateTestLog("Support Page", "Grilling Guides link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/grill-isnt-heating"))	{
					report.updateTestLog("Support Page", "Grilling Guides link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Grilling Guides link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Digital Electric Smoker SmartChef Operations Guide" link
			wdu.waitUntilElementEnabled(SupportPage.linkDigitalElectricSmoker, 10);
			wdu.highlightElement(SupportPage.linkDigitalElectricSmoker);
			driver.findElement(SupportPage.linkDigitalElectricSmoker).click();
			report.updateTestLog("Support Page", "Digital Electric Smoker SmartChef Operations Guide link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/grill-stopped-working"))	{
					report.updateTestLog("Support Page", "Digital Electric Smoker SmartChef Operations Guide link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Digital Electric Smoker SmartChef Operations Guide link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSmartchefGrillHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links under ACCESSORIES GRILL HELP in support page
	 */
	public void validateAccessoriesGrillHelp()		{
		try		{

			//Validate "Lid won't close on rotisserie" link
			wdu.waitUntilElementEnabled(SupportPage.linkLidWontClose, 10);
			wdu.highlightElement(SupportPage.linkLidWontClose);
			driver.findElement(SupportPage.linkLidWontClose).click();
			report.updateTestLog("Support Page", "Lid won't close on rotisserie link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/lid-wont-close-on-rotisserie"))	{
					report.updateTestLog("Support Page", "Lid won't close on rotisserie link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Lid won't close on rotisserie link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Spit rod not turning" link
			wdu.waitUntilElementEnabled(SupportPage.linkSpitRod, 10);
			wdu.highlightElement(SupportPage.linkSpitRod);
			driver.findElement(SupportPage.linkSpitRod).click();
			report.updateTestLog("Support Page", "Spit rod not turning link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/spit-rod-not-turning"))	{
					report.updateTestLog("Support Page", "Spit rod not turning link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Spit rod not turning link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Validate "Rotisserie overloaded" link
			wdu.waitUntilElementEnabled(SupportPage.linkRotisserieOverloaded, 10);
			wdu.highlightElement(SupportPage.linkRotisserieOverloaded);
			driver.findElement(SupportPage.linkRotisserieOverloaded).click();
			report.updateTestLog("Support Page", "Rotisserie overloaded link clicked.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/rotisserie-overloaded"))	{
					report.updateTestLog("Support Page", "Rotisserie overloaded link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Rotisserie overloaded link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateAccessoriesGrillHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate buttons in ORDER HELP section in support link
	 */
	public void validateButtonsInOrderHelp()		{
		try		{

			//Click SHIPPING INFO button and validate link
			wdu.waitUntilElementEnabled(SupportPage.btnShippingInfo, 10);
			gc.scrollToElement(SupportPage.btnShippingInfo);
			wdu.highlightElement(SupportPage.btnShippingInfo);
			driver.findElement(SupportPage.btnShippingInfo).click();
			report.updateTestLog("Support Page", "Clicked on button SHIPPING INFO.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/shipping-policy"))		{
					report.updateTestLog("Support Page", "Shipping Policy link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Shipping Policy link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Click TRACK AN ORDER button and validate link
			wdu.waitUntilElementEnabled(SupportPage.btnTrackAnOrder, 10);
			gc.scrollToElement(SupportPage.btnTrackAnOrder);
			wdu.highlightElement(SupportPage.btnTrackAnOrder);
			driver.findElement(SupportPage.btnTrackAnOrder).click();
			report.updateTestLog("Support Page", "Clicked on button TRACK AN ORDER.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/wcb_sales/guest/orderLookup/"))	{
					report.updateTestLog("Support Page", "Order Lookup link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Order Lookup link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Click CASE LOOKUP button and validate link
			wdu.waitUntilElementEnabled(SupportPage.btnCaseLookup, 10);
			gc.scrollToElement(SupportPage.btnCaseLookup);
			wdu.highlightElement(SupportPage.btnCaseLookup);
			driver.findElement(SupportPage.btnCaseLookup).click();
			report.updateTestLog("Support Page", "Clicked on button CASE LLOKUP.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/help/caselookup"))	{
					report.updateTestLog("Support Page", "Case Lookup link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Case Lookup link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);


			//Click RETURNS button and validate link
			wdu.waitUntilElementEnabled(SupportPage.btnReturns, 10);
			gc.scrollToElement(SupportPage.btnReturns);
			wdu.highlightElement(SupportPage.btnReturns);
			driver.findElement(SupportPage.btnReturns).click();
			report.updateTestLog("Support Page", "Clicked on button RETURNS.", Status.DONE);

			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/return-policy"))	{
					report.updateTestLog("Support Page", "Return Policy link opened.", Status.PASS);
					break;
				}
				else if(count==5)
					report.updateTestLog("Support Page", "Return Policy link not opened.", Status.FAIL);
				else	{
					report.updateTestLog("Support Page", "Link not opened in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

			driver.navigate().back();
			report.updateTestLog("Support Page", "Clicked on back button.", Status.DONE);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateButtonsInOrderHelp", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate auto suggestion is appearing after text entered in searchbox
	 */
	public void validateAutoSuggestion()	{
		try		{
			//Click on PARTS link under SHOP menu
			//wdu.waitUntilElementEnabled(HomePage.linkParts, 10);
			//driver.findElement(HomePage.linkParts).click();

			//Enter text in searchbox
			String searchText = dataTable.getData("General_Data", "SearchTextInHome");			
			wdu.highlightElement(HomePage.txtSearch);
			report.updateTestLog("Search Text", "Search textbox is present at the top.", Status.DONE);
			driver.findElement(HomePage.txtSearch).clear();
			driver.findElement(HomePage.txtSearch).sendKeys(searchText);
			Thread.sleep(2000);

			wdu.waitUntilElementEnabled(SupportPage.linkAutoSuggestionResults, 10);			
			if(driver.findElements(SupportPage.linkAutoSuggestionResults).size() > 0)
				report.updateTestLog("Search Text", "Auto suggestion results are getting displayed.", Status.PASS);
			else
				report.updateTestLog("Search Text", "Auto suggestion results are not getting displayed.", Status.FAIL);

			//Click on SUPPORTS
			wdu.highlightElement(HomePage.linkSupport);
			report.updateTestLog("Home Page", "Support link is present.", Status.PASS);
			gc.clickItem(HomePage.linkSupport, "Home", "Support");
			Thread.sleep(2000);
			for(int count=1 ; count<=5 ; count++)	{
				if(driver.getCurrentUrl().equalsIgnoreCase("https://support.charbroil.com/"))	{
					report.updateTestLog("Home Page", "Navigated to Support URL.", Status.DONE);
					break;
				}	
				else if(count==5)
					report.updateTestLog("Home Page", "Not navigated to Support URL.", Status.FAIL);
				else	{
					Thread.sleep(3000);
					report.updateTestLog("Home Page", "Not navigated to Support URL. Wait for 3 more seconds.", Status.DONE);
				}
			}

			//Enter text in searchbox
			searchText = dataTable.getData("General_Data", "SearchTextInHome");			
			wdu.highlightElement(HomePage.txtSearch);
			report.updateTestLog("Search Text", "Search textbox is present at the top.", Status.DONE);
			driver.findElement(HomePage.txtSearch).clear();
			driver.findElement(HomePage.txtSearch).sendKeys(searchText);
			Thread.sleep(2000);

			wdu.waitUntilElementEnabled(SupportPage.linkAutoSuggestionResults, 10);			
			if(driver.findElements(SupportPage.linkAutoSuggestionResults).size() > 0)
				report.updateTestLog("Search Text", "Auto suggestion results are getting displayed.", Status.PASS);
			else
				report.updateTestLog("Search Text", "Auto suggestion results are not getting displayed.", Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateAutoSuggestion", "Exception is " + e, Status.FAIL);
		}
	}
}
