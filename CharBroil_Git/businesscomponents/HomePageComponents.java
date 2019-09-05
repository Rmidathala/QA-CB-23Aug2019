package businesscomponents;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.Browser;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.*;
import uimap.HomePage;
import uimap.MyAccountPage;
import uimap.PartFinderPage;
import uimap.ProductListingPage;
import uimap.ProductRegistrationPage;

/**
 * Class for storing general purpose business components
 * 
 * @author Cognizant
 */
public class HomePageComponents extends ReusableLibrary {

	WebDriverUtil wdu = new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public HomePageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	/*
	 * Method for validating contact us link
	 */
	public void validateContactUs() {
		try {
			// wdu.waitUntilElementEnabled(HomePage.linkContactUs, 10);
			wdu.waitUntilElementEnabled(HomePage.linkChatWith, 10);
			if (driver.findElement(HomePage.linkChatWith).isDisplayed())
				report.updateTestLog("Home Page", "Chat during business hours link is present.", Status.PASS);
			else
				report.updateTestLog("Home Page", "Chat during business hours link is not present.", Status.FAIL);
			wdu.highlightElement(HomePage.linkChatWith);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateContactUs", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating telephone number link
	 */
	public void validateTelephone() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkTelephone, 10);
			if (driver.findElement(HomePage.linkTelephone).isDisplayed())
				report.updateTestLog("Home Page", "Telephone link is present.", Status.PASS);
			else
				report.updateTestLog("Home Page", "Telephone link is not present.", Status.FAIL);
			wdu.highlightElement(HomePage.linkTelephone);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateTelephone", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating product registration link
	 */
	public void validateProductRegistration() {
		try {
			String mainWindowHandle = driver.getWindowHandle();

			wdu.waitUntilElementEnabled(HomePage.linkProductReg, 10);
			wdu.highlightElement(HomePage.linkProductReg);
			report.updateTestLog("Home Page", "Product Registration link is present.", Status.PASS);
			driver.findElement(HomePage.linkProductReg).click();
			report.updateTestLog("Home Page", "Clicked on Product Registration link.", Status.DONE);

			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					gc.scrollToElement(ProductRegistrationPage.lblProductRegistration);
					wdu.highlightElement(ProductRegistrationPage.lblProductRegistration);
					report.updateTestLog("Home Page", "Product Registration label is present.", Status.PASS);
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateProductRegistration", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating my account link
	 */
	public void validateMyAccount() {
		try {

			Thread.sleep(5000);
			wdu.highlightElement(HomePage.linkMyAcnt);
			report.updateTestLog("Home Page", "My Account link is present.", Status.PASS);
			gc.clickItem(HomePage.linkMyAcnt, "Home", "My Account");

			gc.scrollToElement(MyAccountPage.lblCreateAccount);
			wdu.highlightElement(MyAccountPage.lblCreateAccount);
			report.updateTestLog("Home Page", "Create Account label is present.", Status.PASS);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateMyAccount", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating shop link
	 */
	public void validateShopLink() {
		try {

			wdu.highlightElement(HomePage.linkShop);
			report.updateTestLog("Home Page", "Shop link is present.", Status.PASS);
			gc.clickItem(HomePage.linkShop, "Home", "Shop");
			// gc.validateImage(System.getProperty("user.dir") + "\\images\\Shop.png",
			// "Shop", "Shop image");
			String cookurl = driver.getCurrentUrl().toLowerCase();
			if (cookurl.contains("shop"))
				report.updateTestLog("Shop Page", "Navigation to Shop page is successful", Status.PASS);
			else
				report.updateTestLog("Shop Page", "Navigation to Shop page is not successful", Status.FAIL);

			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateShopLink", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating cook link
	 */
	public void validateCookLink() {
		try {

			wdu.highlightElement(HomePage.linkCook);
			report.updateTestLog("Home Page", "Cook link is present.", Status.PASS);
			gc.clickItem(HomePage.linkCook, "Home", "Cook");
			// gc.validateImage(System.getProperty("user.dir") + "\\images\\Cook.png",
			// "Cook", "Cook image");
			String cookurl = driver.getCurrentUrl().toLowerCase();
			if (cookurl.contains("cook"))
				report.updateTestLog("Cook Page", "Navigation to Cook page is successful", Status.PASS);
			else
				report.updateTestLog("Cook Page", "Navigation to Cook page is not successful", Status.FAIL);

			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateCookLink", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating learn link
	 */
	public void validateLearnLink() {
		try {

			wdu.highlightElement(HomePage.linkLearn);
			report.updateTestLog("Home Page", "Learn link is present.", Status.PASS);
			gc.clickItem(HomePage.linkLearn, "Home", "Learn");
			// gc.validateImage(System.getProperty("user.dir") + "\\images\\Learn.png",
			// "Learn", "Learn image");
			String cookurl = driver.getCurrentUrl().toLowerCase();
			if (cookurl.contains("learn"))
				report.updateTestLog("Learn Page", "Navigation to Learn page is successful", Status.PASS);
			else
				report.updateTestLog("Learn Page", "Navigation to Learn page is not successful", Status.FAIL);
			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateLearnLink", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for select Support Link
	 */
	public void selectSupportLink() {
		try {
			wdu.highlightElement(HomePage.linkSupport);
			gc.clickItem(HomePage.linkSupport, "Home", "Support");
			report.updateTestLog("Home Page", "Support link is clicked.", Status.DONE);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in selectSupportLink", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating support link
	 */
	public void validateSupportLink() {
		try {

			wdu.highlightElement(HomePage.linkSupport);
			report.updateTestLog("Home Page", "Support link is present.", Status.PASS);
			gc.clickItem(HomePage.linkSupport, "Home", "Support");
			Thread.sleep(3000);
			// gc.validateImage(System.getProperty("user.dir") + "\\images\\Support.png",
			// "Support", "Support image");
			// gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSupportLink", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating CharBroil Logo
	 */
	public void validateCharbroilLogo() {
		try {
			// gc.validateImage(System.getProperty("user.dir") + "\\images\\CbLogo.png",
			// "Home", "Charbroil logo image");

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSupportLink", "Exception is " + e, Status.FAIL);
		}
	}

	public void searchItemFromHomePage() {
		try {
			String item = dataTable.getData("General_Data", "ProductModel");
			Browser browser = driver.getTestParameters().getBrowser();

			driver.findElement(HomePage.txtSearchItemHomePage).sendKeys(item);
			if (browser.equals(Browser.INTERNET_EXPLORER) || browser.equals(Browser.IE)) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);

			} else {
				driver.findElement(HomePage.txtSearchItemHomePage).sendKeys(Keys.ENTER);
			}
			//Thread.sleep(8000);
			wdu.waitUntilElementVisible(ProductListingPage.lblSortByPLP, 30);

			if (driver.findElement(ProductListingPage.lblSortByPLP).isDisplayed()) {
				report.updateTestLog("Product Listing Page",
						"Product Listing Page is Displayed after search for: " + item, Status.PASS);
			} else {
				report.updateTestLog("Product Listing Page",
						"Product Listing Page is not Displayed after search for: " + item, Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Searching product from search box homepage", "Exception is " + e,
					Status.FAIL);
		}
	}

	/*
	 * Method for searching an product in Home Page
	 */
	public void searchProductInHomePage() {
		try {
			String searchText = dataTable.getData("General_Data", "SearchTextInHome");
			wdu.highlightElement(HomePage.txtSearch);
			report.updateTestLog("Home Page", "Search textbox is present inside home page.", Status.PASS);
			driver.findElement(HomePage.txtSearch).clear();
			driver.findElement(HomePage.txtSearch).sendKeys(searchText);
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in searchProductInHomePage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating invalid product search result in home page
	 */
	public void validateInvalidProdSearchInHome() {
		try {
			String searchText = dataTable.getData("General_Data", "SearchTextInHome");
			String expectedResult = "No products for query \"" + searchText + "\"";
			wdu.waitUntilElementVisible(HomePage.txtSearchResult, 10);
			if (driver.findElement(HomePage.txtSearchResult).getText().equalsIgnoreCase(expectedResult))
				report.updateTestLog("Home Page", "Proper message displayed against search.", Status.PASS);
			else
				report.updateTestLog("Home Page", "Proper message not displayed against search.", Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateInvalidProdSearchInHome", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for search using find a part in home page
	 */
	public void validateFindAPartInHome() {
		try {
			String modelNo = dataTable.getData("General_Data", "ModelNo").split("-")[1];

			wdu.waitUntilPageReadyStateComplete(20);
			wdu.waitUntilElementEnabled(HomePage.btnFindAPart, 10);
			driver.findElement(HomePage.btnFindAPart).click();
			report.updateTestLog("Home Page", "Clicked on find a part button.", Status.PASS);

			// wdu.waitUntilPageReadyStateComplete(10);
			//wdu.waitUntilElementEnabled(HomePage.txtFindAPartSearch, 10);
			driver.findElement(HomePage.txtFindAPartSearch).clear();
			driver.findElement(HomePage.txtFindAPartSearch).sendKeys(modelNo);
			report.updateTestLog("Home Page", "Entered model no for search - " + modelNo, Status.PASS);
			driver.findElement(HomePage.btnFindAPartSearch).click();
			report.updateTestLog("Home Page", "Clicked on find a part button.", Status.PASS);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFindAPartInHome", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating result after find a part
	 */
	public void validateFindAPartResult() {
		try {
			String modelType = dataTable.getData("General_Data", "ModelNo").split("-")[0];
			String modelNo = dataTable.getData("General_Data", "ModelNo").split("-")[1];

			if (modelType.equalsIgnoreCase("valid")) {
				if (wdu.objectExists(PartFinderPage.linkResultProducts))
					report.updateTestLog("Find A Part Result for valid product",
							"Results displayed against the searched model " + modelNo, Status.PASS);
				else
					report.updateTestLog("Find A Part Result for valid product",
							"Results not displayed against the searched model " + modelNo, Status.FAIL);
			} else if (modelType.equalsIgnoreCase("invalid")) {
				if (wdu.objectExists(PartFinderPage.linkResultProductsNotFound)) {
					if (driver.findElement(PartFinderPage.linkResultProductsNotFound).getText()
							.contains("Oh no! Our bots couldn’t find it.")
							&& driver.findElement(PartFinderPage.linkResultProductsNotFound).getText()
									.contains("Surely our humans can.")
							&& driver.findElement(PartFinderPage.linkResultProductsNotFound).getText()
									.contains("Call us at 1-866-239-6777")
							&& driver.findElement(PartFinderPage.linkResultProductsNotFound).getText()
									.contains("Monday-Friday 9a-7p (EST)")
							&& driver.findElement(PartFinderPage.linkResultProductsNotFound).getText()
									.contains("Saturday 9a-3p (EST)"))
						report.updateTestLog("Find A Part Result for invalid product",
								"Message displayed against invalid product search.", Status.PASS);
					else
						report.updateTestLog("Find A Part Result for invalid product",
								"Message not displayed against search.", Status.FAIL);
				} else
					report.updateTestLog("Find A Part Result for invalid product",
							"Message not displayed against search.", Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFindAPartResult", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating HOW TO FIND MODEL NO ON YOUR GRILL
	 */
	public void validateFindMyModel() {
		try {
			wdu.waitUntilPageReadyStateComplete(10);
			wdu.waitUntilElementEnabled(HomePage.btnFindAPart, 10);
			driver.findElement(HomePage.btnFindAPart).click();
			report.updateTestLog("Home Page", "Clicked on find a part button.", Status.PASS);

			wdu.waitUntilElementEnabled(HomePage.linkFindMyModel, 20);
			wdu.highlightElement(HomePage.linkFindMyModel);
			driver.findElement(HomePage.linkFindMyModel).click();
			report.updateTestLog("Home Page", "Clicked on link for How to find the model number on your grill.",
					Status.DONE);

			// Wait for the page to be loaded
			Thread.sleep(2000);
			// wdu.waitUntilElementEnabled(SupportPage.linkWhereIsModelNumber, 30);
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("/find-my-model")) {
					report.updateTestLog("Home Page", "Landed on Find-my-model page.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page", "Not landed on Find-my-model page.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated on Find-my-model page in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFindMyModel", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for navigating to home page
	 */
	public void navigateToHomePage() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkHeaderLogo, 10);
			driver.findElement(HomePage.linkHeaderLogo).click();
			report.updateTestLog("Header logo", "Clicked on CharBroil logo.", Status.DONE);
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in navigateToHomePage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for hover on Main Menu tab in Home Page
	 */
	public void hoverMenuTabInHome() {
		try {
			String tabName = dataTable.getData("General_Data", "MainMenuName");
			wdu.waitUntilPageReadyStateComplete(20);
			Thread.sleep(5000);
			if (tabName.equalsIgnoreCase("Shop")) {
				wdu.waitUntilElementEnabled(HomePage.linkShop, 10);
				// gc.scrollToElement(HomePage.linkShop);
				wdu.mouseOver(HomePage.linkShop);
				// wdu.mouseOver(HomePage.linkShop);
			} else if (tabName.equalsIgnoreCase("Cook")) {
				wdu.waitUntilElementEnabled(HomePage.linkCook, 10);
				// gc.scrollToElement(HomePage.linkCook);
				wdu.mouseOver(HomePage.linkCook);

			} else if (tabName.equalsIgnoreCase("Learn")) {
				wdu.waitUntilElementEnabled(HomePage.linkLearn, 10);
				// wdu.mouseHoverJScript(driver.findElement(HomePage.linkLearn));
				wdu.mouseOver(HomePage.linkLearn);
			}
			report.updateTestLog("Home screen", "Mouse hover on " + tabName + " link.", Status.PASS);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in hoverMenuTabInHome", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for selecting sub category in menu tab
	 */
	public void selectShopSubCategory() {
		try {
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			// if(shopSubCatg.equalsIgnoreCase("Portable Grills")) {
			wdu.waitUntilElementEnabled(By.linkText(shopSubCatg), 10);
			driver.findElement(By.linkText(shopSubCatg)).click();
			Thread.sleep(2000);
			// }
			report.updateTestLog("Home screen", "Clicked on " + shopSubCatg + " link.", Status.DONE);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in selectShopSubCategory", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating home page footer links presence for smoke suite
	 */
	public void validateFooterLinksPresence() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkContactNo, 10);
			gc.scrollToElement(HomePage.linkContactNo);

			if (driver.findElement(HomePage.linkContactNo).getText().equalsIgnoreCase("1-866-239-6777")
					&& driver.findElement(HomePage.linkProductHelp).isDisplayed()
					&& driver.findElement(HomePage.linkFormsInformation).isDisplayed()
					&& driver.findElement(HomePage.linkSupportCenters).isDisplayed()
					&& driver.findElement(HomePage.linkReplacementParts).isDisplayed()
					&& driver.findElement(HomePage.linkAboutUs).isDisplayed()
					&& driver.findElement(HomePage.linkCareers).isDisplayed()
					&& driver.findElement(HomePage.linkSaberGrills).isDisplayed()
					&& driver.findElement(HomePage.linkDancookGrills).isDisplayed()
					&& driver.findElement(HomePage.linkOklahomaJoeSmokers).isDisplayed()
					&& driver.findElement(HomePage.linkIdeaSubmission).isDisplayed()
					&& driver.findElement(HomePage.linkPrivacyPolicy).isDisplayed()
					&& driver.findElement(HomePage.linkTermsOfUseAtHome).isDisplayed()
					&& driver.findElement(HomePage.linkCaTransparencySupplyChains).isDisplayed()) {

				report.updateTestLog("Footer links validation", "All footer links are displayed.", Status.PASS);

			} else {
				report.updateTestLog("Footer links validation", "All footer links are not displayed.", Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Footer links validation", "Footer links are not showing.", Status.FAIL);
			report.updateTestLog("Exception in validateFooterLinksPresence", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating contact sub links in home page footer
	 */
	public void validateFooterContactSublinks() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkContactNo, 10);
			gc.scrollToElement(HomePage.linkContactNo);
			wdu.highlightElement(HomePage.linkContactNo);
			if (driver.findElement(HomePage.linkContactNo).getText().equalsIgnoreCase("1-866-239-6777"))
				report.updateTestLog("Home screen", "Contact no is showing correct at the homepage footer.",
						Status.PASS);
			else
				report.updateTestLog("Home screen", "Contact no is not showing correct at the homepage footer.",
						Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFooterContactSublinks", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating customer support sub links in home page footer
	 */
	public void validateFooterCustomerSupportSublinks() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkProductHelp, 30);

			// Product help link validation
			gc.scrollToElement(HomePage.linkProductHelp);
			wdu.highlightElement(HomePage.linkProductHelp);
			driver.findElement(HomePage.linkProductHelp).click();
			report.updateTestLog("Home screen", "Clicked Product Help link.", Status.DONE);
			wdu.highlightElement(HomePage.linkProductHelpTitle);
			if (driver.findElement(HomePage.linkProductHelpTitle).getText().equalsIgnoreCase("Product Help"))
				report.updateTestLog("Home screen", "Product help heading is showing.", Status.PASS);
			else
				report.updateTestLog("Home screen", "Product help heading is not showing.", Status.FAIL);

			// Forms & Information link validation
			gc.scrollToElement(HomePage.linkFormsInformation);
			wdu.highlightElement(HomePage.linkFormsInformation);
			driver.findElement(HomePage.linkFormsInformation).click();
			Thread.sleep(3000);
			report.updateTestLog("Home screen", "Clicked on Forms & Information link.", Status.DONE);
			wdu.highlightElement(HomePage.linkFormsInformationTitle);
			if (driver.findElement(HomePage.linkFormsInformationTitle).getText()
					.equalsIgnoreCase("Forms & Information"))
				report.updateTestLog("Home screen", "Forms & Information heading is showing.", Status.PASS);
			else
				report.updateTestLog("Home screen", "Forms & Information heading is not showing.", Status.FAIL);

			// Support Center link validation
			gc.scrollToElement(HomePage.linkSupportCenters);
			wdu.highlightElement(HomePage.linkSupportCenters);
			driver.findElement(HomePage.linkSupportCenters).click();
			report.updateTestLog("Home screen", "Support Centers link clicked.", Status.DONE);
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("support.charbroil.com")) {
					report.updateTestLog("Home Page screen", "Navigated to Support Centers link.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to Support Centers link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to Support Centers link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}

			// Replacement Parts link validation
			gc.scrollToElement(HomePage.linkReplacementParts);
			wdu.highlightElement(HomePage.linkReplacementParts);
			driver.findElement(HomePage.linkReplacementParts).click();
			report.updateTestLog("Home screen", "Replacement Parts link clicked.", Status.DONE);
			// gc.validateImage(System.getProperty("user.dir") + "\\images\\Parts.png",
			// "Home", "Parts image");
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("charbroil.com/parts")) {
					report.updateTestLog("Home Page screen", "Navigated to Parts link.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to Parts link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to Parts link in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFooterCustomerSupportSublinks", "Exception is " + e,
					Status.FAIL);
		}
	}

	/*
	 * Method for validating company sub links in home page footer
	 */
	public void validateFooterCompanySublinks() {
		String mainWindow;
		try {
			wdu.waitUntilElementEnabled(HomePage.linkAboutUs, 5);

			// Validate About Us link
			gc.scrollToElement(HomePage.linkAboutUs);
			wdu.highlightElement(HomePage.linkAboutUs);
			driver.findElement(HomePage.linkAboutUs).click();
			Thread.sleep(3000);
			report.updateTestLog("Home screen", "Clicked on About Us link.", Status.DONE);
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("charbroil.com/why-charbroil")) {
					report.updateTestLog("Home screen", "Navigated to About Us link correctly.", Status.PASS);

					// Check first line of the ABOUT US page
					wdu.waitUntilElementEnabled(HomePage.linkAboutUsContentFirst, 15);
					if (driver.findElement(HomePage.linkAboutUsContentFirst).getText()
							.equalsIgnoreCase("Innovating Since Day One"))
						report.updateTestLog("Home screen", "About Us content is showing.", Status.PASS);
					else
						report.updateTestLog("Home screen", "About Us content is not showing.", Status.FAIL);

					driver.navigate().back();
					break;
				} else if (count == 5)
					report.updateTestLog("Home screen", "Navigation to About Us link failed.", Status.FAIL);
				else {
					report.updateTestLog("Home screen",
							"Not navigated to About Us link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}

			// Validate Careers link
			gc.scrollToElement(HomePage.linkCareers);
			wdu.highlightElement(HomePage.linkCareers);
			driver.findElement(HomePage.linkCareers).click();
			report.updateTestLog("Home screen", "Clicked on Careers link.", Status.DONE);
			Thread.sleep(2000);
			
			if(driver.getCurrentUrl().contains("www")) {
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().equalsIgnoreCase("https://jobs.wcbradley.com/")) {
					report.updateTestLog("Home screen", "Navigated to careers link correctly.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home screen", "Navigation to careers link failed.", Status.FAIL);
				else {
					report.updateTestLog("Home screen",
							"Not navigated to Careers link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			// driver.navigate().back();
			
			driver.close();
			driver.switchTo().window(mainWindow);
			} else {
				for (int count = 1; count <= 5; count++) {
					if (driver.getCurrentUrl().equalsIgnoreCase("https://jobs.wcbradley.com/")) {
						report.updateTestLog("Home screen", "Navigated to careers link correctly.", Status.PASS);
						break;
					} else if (count == 5)
						report.updateTestLog("Home screen", "Navigation to careers link failed.", Status.FAIL);
					else {
						report.updateTestLog("Home screen",
								"Not navigated to Careers link in 2 seconds. Will retry in another 2 seconds.",
								Status.DONE);
						Thread.sleep(2000);
					}
				}
				driver.navigate().back();
			}

			// Validate Saber Grills link
			gc.scrollToElement(HomePage.linkSaberGrills);
			wdu.highlightElement(HomePage.linkSaberGrills);
			driver.findElement(HomePage.linkSaberGrills).click();
			report.updateTestLog("Home screen", "Clicked on Saber Grills link.", Status.DONE);
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("www.sabergrills.com")) {
					report.updateTestLog("Home screen", "Navigated to Saber Grills link correctly.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home screen", "Navigation to Saber Grills link failed.", Status.FAIL);
				else {
					report.updateTestLog("Home screen",
							"Not navigated to Saber Grills link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			// driver.navigate().back();
			driver.close();
			driver.switchTo().window(mainWindow);

			// Validate Dancook Grills link
			gc.scrollToElement(HomePage.linkDancookGrills);
			wdu.highlightElement(HomePage.linkDancookGrills);
			driver.findElement(HomePage.linkDancookGrills).click();
			report.updateTestLog("Home screen", "Clicked on Dancook Grills link.", Status.DONE);
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("www.dancookusa.com")) {
					report.updateTestLog("Home screen", "Navigated to Dancook Grills link correctly.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home screen", "Navigation to Dancook Grills link failed.", Status.FAIL);
				else {
					report.updateTestLog("Home screen",
							"Not navigated to Dancook Grills link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			// driver.navigate().back();
			driver.close();
			driver.switchTo().window(mainWindow);

			// Validate Oklahoma link
			gc.scrollToElement(HomePage.linkOklahomaJoeSmokers);
			wdu.highlightElement(HomePage.linkOklahomaJoeSmokers);
			driver.findElement(HomePage.linkOklahomaJoeSmokers).click();
			report.updateTestLog("Home screen", "Clicked on Oklahoma link.", Status.DONE);
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("www.oklahomajoes.com")) {
					report.updateTestLog("Home screen", "Navigated to Oklahoma link correctly.", Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home screen", "Navigation to Oklahoma link failed.", Status.FAIL);
				else {
					report.updateTestLog("Home screen",
							"Not navigated to Oklahoma link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			// driver.navigate().back();
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFooterCompanySublinks", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating footer links
	 */
	public void validateFooterLinks() {
		try {

			// validate privacy policy
			gc.scrollToElement(HomePage.linkPrivacyPolicy);
			wdu.highlightElement(HomePage.linkPrivacyPolicy);
			driver.findElement(HomePage.linkPrivacyPolicy).click();
			Thread.sleep(5000);
			wdu.highlightElement(HomePage.linkPageHeader);
			if (driver.findElement(HomePage.linkPageHeader).getText().equalsIgnoreCase("Privacy Policy"))
				report.updateTestLog("Privacy policy screen", "Privacy policy header showing correctly.", Status.PASS);
			else
				report.updateTestLog("Privacy policy screen", "Privacy policy header not showing correctly.",
						Status.FAIL);

			if (driver.getCurrentUrl().contains("/privacy-policy"))
				report.updateTestLog("Privacy policy screen", "Navigated to Privacy policy link correctly.",
						Status.PASS);
			else
				report.updateTestLog("Privacy policy screen", "Navigation to Privacy policy link failed.", Status.FAIL);

			// validate terms of use
			gc.scrollToElement(HomePage.linkTermsOfUse);
			wdu.highlightElement(HomePage.linkTermsOfUse);
			driver.findElement(HomePage.linkTermsOfUse).click();
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("/terms-of-use")) {
					report.updateTestLog("Terms of Use screen", "Navigated to Terms of Use link correctly.",
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Terms of Use screen", "Navigation to Terms of Use link failed.", Status.FAIL);
				else {
					report.updateTestLog("Terms of Use screen",
							"Not navigated to Terms of Use link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			wdu.highlightElement(HomePage.linkPageHeader);
			if (driver.findElement(HomePage.linkPageHeader).getText().equalsIgnoreCase("Terms of Use"))
				report.updateTestLog("Terms of Use screen", "Terms of Use header showing correctly.", Status.PASS);
			else
				report.updateTestLog("Terms of Use screen", "Terms of Use header not showing correctly.", Status.FAIL);

			// validate ca transparency in supply chains act
			gc.scrollToElement(HomePage.linkCaTransparencySupplyChains);
			wdu.highlightElement(HomePage.linkCaTransparencySupplyChains);
			driver.findElement(HomePage.linkCaTransparencySupplyChains).click();
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("/supply-chains-act/")) {
					report.updateTestLog("Supply chains act screen", "Navigated to Supply chains act link correctly.",
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Supply chains act screen", "Navigation to Supply chains act link failed.",
							Status.FAIL);
				else {
					report.updateTestLog("Supply chains act screen",
							"Not navigated to Supply chains act link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			wdu.highlightElement(HomePage.linkPageHeader);
			String text = "Char-Broil, LLC Disclosure Pursuant to California's Transparency in Supply Chains Act 2010";
			if (driver.findElement(HomePage.linkPageHeader).getText().equalsIgnoreCase(text))
				report.updateTestLog("Supply chains act screen", "Supply chains act header showing correctly.",
						Status.PASS);
			else
				report.updateTestLog("Supply chains act screen", "Supply chains act header not showing correctly.",
						Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFooterLinks", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating search results tabs after search item from home page
	 */
	public void validateSearchResultsTab() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkResultsProductsTab, 5);
			// Verify Product tab
			if (driver.findElement(HomePage.linkResultsProductsTab).getText().toLowerCase().contains("products"))
				report.updateTestLog("Search Results Screen", "Products tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "Products tab is not displayed.", Status.FAIL);

			// Verify Recipes tab
			wdu.highlightElement(HomePage.linkResultsRecipesTab);
			driver.findElement(HomePage.linkResultsRecipesTab).click();
			Thread.sleep(1000);
			if (driver.findElement(HomePage.linkResultsRecipesTab).getText().toLowerCase().contains("recipes"))
				report.updateTestLog("Search Results Screen", "Recipes tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "Recipes tab is not displayed.", Status.FAIL);

			// Verify How To tab
			wdu.highlightElement(HomePage.linkResultsHowToTab);
			driver.findElement(HomePage.linkResultsHowToTab).click();
			Thread.sleep(1000);
			if (driver.findElement(HomePage.linkResultsHowToTab).getText().toLowerCase().contains("how to"))
				report.updateTestLog("Search Results Screen", "How To tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "How To tab is not displayed.", Status.FAIL);

			// Verify Support tab
			wdu.highlightElement(HomePage.linkResultsSupportTab);
			driver.findElement(HomePage.linkResultsSupportTab).click();
			Thread.sleep(1000);
			if (driver.findElement(HomePage.linkResultsSupportTab).getText().toLowerCase().contains("support"))
				report.updateTestLog("Search Results Screen", "Support tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "Support tab is not displayed.", Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSearchResultsTab", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating hero image inside home page
	 */
	public void validateHeroImage() {
		try {
			if (driver.getCurrentUrl().contains("stagingshop")) {
				gc.validateImage(System.getProperty("user.dir") + "\\images\\HeroImage_Staging.png", "Home",
						"Hero image");
			} else {
				gc.validateImage(System.getProperty("user.dir") + "\\images\\HeroImage.png", "Home", "Hero image");
			}
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateHeroImage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating What's Hot portion inside home page
	 */
	public void validateWhatsHotPortion() {
		try {
			if (wdu.objectExists(HomePage.linkFeaturedWhatsHot)) {
				gc.scrollToElement(HomePage.linkFeaturedWhatsHot);
				if (driver.getCurrentUrl().contains("stagingshop")) {
					gc.validateImage(System.getProperty("user.dir") + "\\images\\WhatsHot_Stagingshop.png", "Home",
							"What's Hot image ");
				} else {
					gc.validateImage(System.getProperty("user.dir") + "\\images\\WhatsHot.png", "Home",
							"What's Hot image ");
				}
			} else
				report.updateTestLog("Home screen", "Featured link is not available inside What's Hot portion.",
						Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateWhatsHotPortion", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Grill For Every Year portion inside home page
	 */
	public void validateGrillForEveryYear() {
		try {
			if (wdu.objectExists(HomePage.linkGrillForEveryGriller)) {
				gc.scrollToElement(HomePage.linkGrillForEveryGriller);
				gc.validateImage(System.getProperty("user.dir") + "\\images\\GrillForEveryGriller.png", "Home",
						"A Grill For Every Griller text ");
			} else
				report.updateTestLog("Home screen", "A Grill For Every Griller link is not available.", Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateGrillForEveryYear", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Grillion Years Of Innovation portion inside home page
	 */
	public void validateGrillionYearsOfInnovation() {
		try {
			if (wdu.objectExists(HomePage.linkGrillionYearsOfInnovation)) {
				gc.scrollToElement(HomePage.linkGrillionYearsOfInnovation);
				gc.validateImage(System.getProperty("user.dir") + "\\images\\GrillionYearsOfInnovationImg1.png", "Home",
						"A Grillion Years Of Innovaton image ");
			} else
				report.updateTestLog("Home screen", "A Grillion Years Of Innovaton is not available.", Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateGrillionYearsOfInnovation", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Now You're Cookin section
	 */
	public void validateNowYouCookinContent() {
		try {
			// gc.scrollDown(0, 1000);
			// Thread.sleep(5000);

			wdu.waitUntilElementEnabled(HomePage.linkGiftsForEveryGrillerShopNow, 5);

			// Validate after click on 1st item in Now You're Cookin Section
			gc.scrollToElement(HomePage.linkGiftsForEveryGrillerShopNow);
			wdu.highlightElement(HomePage.linkGiftsForEveryGrillerShopNow);
			driver.findElement(HomePage.linkGiftsForEveryGrillerShopNow).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Holiday2017.png", "Home",
					"Holiday 2017 image ");
			driver.navigate().back();

			// Validate after click on 2nd item in Now You're Cookin Section
			gc.scrollToElement(HomePage.linkNowCookinElement2);
			driver.findElement(HomePage.linkNowCookinElement2).click();
			gc.scrollToElement(HomePage.linkInfraredGrillsLearnMore);
			wdu.highlightElement(HomePage.linkInfraredGrillsLearnMore);
			driver.findElement(HomePage.linkInfraredGrillsLearnMore).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\TruInfrared.png", "Home",
					"TRU Infrared image ");
			driver.navigate().back();

			// Validate after click on 3rd item in Now You're Cookin Section
			gc.scrollToElement(HomePage.linkNowCookinElement3);
			driver.findElement(HomePage.linkNowCookinElement3).click();
			gc.scrollToElement(HomePage.linkHolidayRecipesFindOut);
			wdu.highlightElement(HomePage.linkHolidayRecipesFindOut);
			driver.findElement(HomePage.linkHolidayRecipesFindOut).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\HolidayRecipes.png", "Home",
					"Holiday Recipes image ");
			driver.navigate().back();

			// Validate after click on 4th item in Now You're Cookin Section
			gc.scrollToElement(HomePage.linkNowCookinElement4);
			driver.findElement(HomePage.linkNowCookinElement4).click();
			gc.scrollToElement(HomePage.linkWinterizeGrillShopNow);
			wdu.highlightElement(HomePage.linkWinterizeGrillShopNow);
			driver.findElement(HomePage.linkWinterizeGrillShopNow).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\GrillCovers.png", "Home",
					"Grill Covers image ");
			driver.navigate().back();

			// Validate after click on 5th item in Now You're Cookin Section
			gc.scrollToElement(HomePage.linkNowCookinElement5);
			driver.findElement(HomePage.linkNowCookinElement5).click();
			gc.scrollToElement(HomePage.linkGlazedHamFindOutMore);
			wdu.highlightElement(HomePage.linkGlazedHamFindOutMore);
			driver.findElement(HomePage.linkGlazedHamFindOutMore).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\GlazedHam.png", "Home", "Glazed Ham image ");
			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateNowYouCookinContent", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating What's Hot section
	 */
	public void validateWhatsHot() {	
		try {
			wdu.waitUntilElementEnabled(HomePage.imgWhatsHotRed, 5);
			gc.scrollToElement(HomePage.imgWhatsHotRed);
			wdu.highlightElement(HomePage.linkWhatsHotRedPlus1);
			driver.findElement(HomePage.linkWhatsHotRedPlus1).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\WhatsHotRedPlus1.png", "Home",
					"Whats Hot details image ");

			wdu.highlightElement(HomePage.linkWhatsHotRedPlus2);
			driver.findElement(HomePage.linkWhatsHotRedPlus2).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\WhatsHotRedPlus2.png", "Home",
					"Whats Hot details image ");

			wdu.highlightElement(HomePage.linkWhatsHotRedPlus3);
			driver.findElement(HomePage.linkWhatsHotRedPlus3).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\WhatsHotRedPlus3.png", "Home",
					"Whats Hot details image ");

			wdu.highlightElement(HomePage.linkWhatsHotRedPlus4);
			driver.findElement(HomePage.linkWhatsHotRedPlus4).click();
			gc.validateImage(System.getProperty("user.dir") + "\\images\\WhatsHotRedPlus4.png", "Home",
					"Whats Hot details image ");

			wdu.highlightElement(HomePage.linkCheckOutModularKitchen);
			driver.findElement(HomePage.linkCheckOutModularKitchen).click();
			// gc.validateImage(System.getProperty("user.dir") +
			// "\\images\\BigEasyFryer.png", "Home", "Big Easy Fryer image ");
			if (driver.getCurrentUrl().contains("charbroil.com/modularoutdoorkitchen"))
				report.updateTestLog("Check out link in whats hot section", "Navigated to modular kitchen page.",
						Status.PASS);
			else
				report.updateTestLog("Check out link in whats hot section", "Not navigated to modular kitchen page.",
						Status.FAIL);

			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateWhatsHot", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating buttons in A GRILL FOR EVERY GRILLER section
	 */
	public void validateGrillForEveryGrillerButtons() {
		try {

			// validate Charcoal grills in Grills for every griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerCharcoal, 20);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerCharcoal);
			wdu.highlightElement(HomePage.linkGrillForEveryGrillerCharcoal);
			driver.findElement(HomePage.linkGrillForEveryGrillerCharcoal).click();
			report.updateTestLog("Home Page", "Clicked on CHARCOAL link in Grill for every griller section.",
					Status.DONE);

			gc.scrollToElement(HomePage.btnGrillForEveryGrillerCharcoal);
			wdu.highlightElement(HomePage.btnGrillForEveryGrillerCharcoal);
			driver.findElement(HomePage.btnGrillForEveryGrillerCharcoal).click();
			report.updateTestLog("Home Page", "Clicked on CHARCOAL shop button in Grill for every griller section.",
					Status.DONE);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Charcoal Grills.png", "Home",
					"Charcoal Grills image ");

			driver.navigate().back();

			// validate Electric grills in Grills for every griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerElectric, 20);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerElectric);
			wdu.highlightElement(HomePage.linkGrillForEveryGrillerElectric);
			driver.findElement(HomePage.linkGrillForEveryGrillerElectric).click();
			report.updateTestLog("Home Page", "Clicked on ELECTRIC link in Grill for every griller section.",
					Status.DONE);

			gc.scrollToElement(HomePage.btnGrillForEveryGrillerElectric);
			wdu.highlightElement(HomePage.btnGrillForEveryGrillerElectric);
			driver.findElement(HomePage.btnGrillForEveryGrillerElectric).click();
			report.updateTestLog("Home Page", "Clicked on ELECTRIC shop button in Grill for every griller section.",
					Status.DONE);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Electric Grills.png", "Home",
					"Electric Grills image ");

			driver.navigate().back();

			// validate Gas grills in Grills for every griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerGas, 20);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerGas);
			wdu.highlightElement(HomePage.linkGrillForEveryGrillerGas);
			driver.findElement(HomePage.linkGrillForEveryGrillerGas).click();
			report.updateTestLog("Home Page", "Clicked on GAS link in Grill for every griller section.", Status.DONE);

			gc.scrollToElement(HomePage.btnGrillForEveryGrillerGas);
			wdu.highlightElement(HomePage.btnGrillForEveryGrillerGas);
			driver.findElement(HomePage.btnGrillForEveryGrillerGas).click();
			report.updateTestLog("Home Page", "Clicked on GAS shop button in Grill for every griller section.",
					Status.DONE);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Gas Grills.png", "Home", "Gas Grills image ");

			driver.navigate().back();

			// validate Portable grills in Grills for every griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerPortable, 20);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerPortable);
			wdu.highlightElement(HomePage.linkGrillForEveryGrillerPortable);
			driver.findElement(HomePage.linkGrillForEveryGrillerPortable).click();
			report.updateTestLog("Home Page", "Clicked on PORTABLE link in Grill for every griller section.",
					Status.DONE);

			gc.scrollToElement(HomePage.btnGrillForEveryGrillerPortable);
			wdu.highlightElement(HomePage.btnGrillForEveryGrillerPortable);
			driver.findElement(HomePage.btnGrillForEveryGrillerPortable).click();
			report.updateTestLog("Home Page", "Clicked on PORTABLE shop button in Grill for every griller section.",
					Status.DONE);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Portable Grills.png", "Home",
					"Portable Grills image ");

			driver.navigate().back();

			// validate Smokers & Fryers in Grills for every griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerSmokers, 20);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerSmokers);
			wdu.highlightElement(HomePage.linkGrillForEveryGrillerSmokers);
			driver.findElement(HomePage.linkGrillForEveryGrillerSmokers).click();
			report.updateTestLog("Home Page", "Clicked on SMOKERS & FRYERS link in Grill for every griller section.",
					Status.DONE);

			gc.scrollToElement(HomePage.btnGrillForEveryGrillerSmokers);
			wdu.highlightElement(HomePage.btnGrillForEveryGrillerSmokers);
			driver.findElement(HomePage.btnGrillForEveryGrillerSmokers).click();
			report.updateTestLog("Home Page",
					"Clicked on SMOKERS & FRYERS shop button in Grill for every griller section.", Status.DONE);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Smokers&Fryers.png", "Home",
					"Smokers & Fryers image ");

			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateGrillForEveryGrillerButtons", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating social media links at footer
	 */
	public void validateSocialMediaLinksFooter() {
		try {
			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.com")) {

				footerPintrestValidation();
				footerTwitterValidation();
				footerFacebookValidation();
				footerInstagramValidation();
				footerYoutubeValidation();

			} else if (AppURL.contains("charbroil.eu") || AppURL.contains("charbroil.fr")
					|| AppURL.contains("charbroil.de") || AppURL.contains("charbroil.dk")) {

				footerFacebookValidation();
				footerInstagramValidation();
				footerYoutubeValidation();
			} else {
				report.updateTestLog("Footer validation", "Nothing to validate for the application url.", Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSocialMediaLinksFooter", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void footerFacebookValidation() {
		try {
			String mainWindow = "";

			wdu.waitUntilElementEnabled(HomePage.linkFacebookAtFooter, 20);
			gc.scrollToElement(HomePage.linkFacebookAtFooter);
			wdu.highlightElement(HomePage.linkFacebookAtFooter);
			driver.findElement(HomePage.linkFacebookAtFooter).click();
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://www.facebook.com/")) {// charbroil
					report.updateTestLog("Home Page screen", "Navigated to facebook link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to facebook link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to facebook link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in footerFacebookValidation", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void footerPintrestValidation() {
		try {
			String mainWindow = "";

			wdu.waitUntilElementEnabled(HomePage.linkPinterestAtFooter, 20);
			gc.scrollToElement(HomePage.linkPinterestAtFooter);
			wdu.highlightElement(HomePage.linkPinterestAtFooter);
			driver.findElement(HomePage.linkPinterestAtFooter).click();
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://www.pinterest.com/charbroil/")) {
					report.updateTestLog("Home Page screen", "Navigated to Pinterest link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to Pinterest link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to Pinterest link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in footerPintrestValidation", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void footerInstagramValidation() {
		try {
			String mainWindow = "";

			wdu.waitUntilElementEnabled(HomePage.linkInstagramAtFooter, 20);
			gc.scrollToElement(HomePage.linkInstagramAtFooter);
			wdu.highlightElement(HomePage.linkInstagramAtFooter);
			driver.findElement(HomePage.linkInstagramAtFooter).click();
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://www.instagram.com/")) {// charbroilgrills/
					report.updateTestLog("Home Page screen", "Navigated to Instagram link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to Instagram link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to Instagram link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in footerInstagramValidation", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void footerYoutubeValidation() {
		try {
			String mainWindow = "";

			wdu.waitUntilElementEnabled(HomePage.linkYoutubeAtFooter, 20);
			gc.scrollToElement(HomePage.linkYoutubeAtFooter);
			wdu.highlightElement(HomePage.linkYoutubeAtFooter);
			driver.findElement(HomePage.linkYoutubeAtFooter).click();
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://www.youtube.com/")) {// user/charbroil/featured
					report.updateTestLog("Home Page screen", "Navigated to YouTube link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to YouTube link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to YouTube link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in footerYoutubeValidation", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void footerTwitterValidation() {

		try {
			String mainWindow = "";

			wdu.waitUntilElementEnabled(HomePage.linkTwitterAtFooter, 20);
			gc.scrollToElement(HomePage.linkTwitterAtFooter);
			wdu.highlightElement(HomePage.linkTwitterAtFooter);
			driver.findElement(HomePage.linkTwitterAtFooter).click();
			Thread.sleep(2000);
			mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));
			for (int count = 1; count <= 5; count++) {
				if (driver.getCurrentUrl().contains("https://twitter.com/charbroil")) {
					report.updateTestLog("Home Page screen", "Navigated to twitter link - " + driver.getCurrentUrl(),
							Status.PASS);
					break;
				} else if (count == 5)
					report.updateTestLog("Home Page screen", "Not navigated to twitter link.", Status.FAIL);
				else {
					report.updateTestLog("Home Page screen",
							"Not navigated to twitter link in 2 seconds. Will retry in another 2 seconds.",
							Status.DONE);
					Thread.sleep(2000);
				}
			}
			driver.close();
			driver.switchTo().window(mainWindow);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in footerTwitterValidation", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating Grills landing page under Shop menu tab
	 */
	public void validateGrillsLandingPage() {
		try {
			// Wait and click on Grills link
			wdu.waitUntilElementEnabled(HomePage.linkGrills, 10);
			driver.findElement(HomePage.linkGrills).click();

			// Validate Grills page heading
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Grills.png", "Grills", "Grills image");

			// Validate Grills bread crumb
			wdu.highlightElement(HomePage.linkBreadCrumb);
			String breadCrumb = driver.findElement(HomePage.linkBreadCrumb).getText();
			if (breadCrumb.equalsIgnoreCase("Grills"))
				report.updateTestLog("Grills screen", "Bread crumb showing correct.", Status.PASS);
			else
				report.updateTestLog("Grills screen", "Bread crumb showing wrong.", Status.FAIL);

			// Validate Shop page different grills images
			wdu.waitUntilElementEnabled(HomePage.linkShopMenuTitle, 10);
			gc.scrollToElement(HomePage.linkShopMenuTitle);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\GrillsMenu.png", "Shop", "Grills menu image");

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateGrillsLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating SMOKERS & FRYERS landing page under Shop menu tab
	 */
	public void validateSmokersFryersLandingPage() {
		try {
			// Wait and click on Smokers & Fryers link
			wdu.waitUntilElementEnabled(HomePage.linkSmokersFryers, 10);
			driver.findElement(HomePage.linkSmokersFryers).click();

			// Validate Smokers & Fryers page heading
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Smokers&Fryers.png", "Smokers & Fryers",
					"Smokers & Fryers image");

			// Validate Smokers & Fryers bread crumb
			wdu.highlightElement(HomePage.linkBreadCrumb);
			String breadCrumb = driver.findElement(HomePage.linkBreadCrumb).getText();
			if (breadCrumb.equalsIgnoreCase("Smokers & Fryers"))
				report.updateTestLog("Smokers & Fryers screen", "Bread crumb showing correct.", Status.PASS);
			else
				report.updateTestLog("Smokers & Fryers screen", "Bread crumb showing wrong.", Status.FAIL);

			// Validate Shop page different Smokers and Fryers images
			wdu.waitUntilElementEnabled(HomePage.linkShopMenuTitle, 10);
			gc.scrollToElement(HomePage.linkShopMenuTitle);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Smokers&FryersMenu.png", "Shop",
					"Smokers & Fryers menu image");

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSmokersFryersLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Accessories landing page under Shop menu tab
	 */
	public void validateAccessoriesLandingPage() {
		try {
			// Wait and click on Grills link
			wdu.waitUntilElementEnabled(HomePage.linkAccessories, 10);
			driver.findElement(HomePage.linkAccessories).click();

			// Validate Accessories page heading
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Accessories.png", "Accessories",
					"Accessories image");

			// Validate Accessories bread crumb
			wdu.highlightElement(HomePage.linkBreadCrumb);
			String breadCrumb = driver.findElement(HomePage.linkBreadCrumb).getText();
			if (breadCrumb.equalsIgnoreCase("Accessories"))
				report.updateTestLog("Accessories screen", "Bread crumb showing correct.", Status.PASS);
			else
				report.updateTestLog("Accessories screen", "Bread crumb showing wrong.", Status.FAIL);

			// Validate Shop page different Accessories images
			wdu.waitUntilElementEnabled(HomePage.linkShopMenuTitle, 10);
			gc.scrollToElement(HomePage.linkShopMenuTitle);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\AccessoriesMenu.png", "Shop",
					"Accessories menu image");

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateAccessoriesLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Parts landing page under Shop menu tab
	 */
	public void validatePartsLandingPage() {
		try {
			// Wait and click on Parts link
			wdu.waitUntilElementEnabled(HomePage.linkParts, 10);
			driver.findElement(HomePage.linkParts).click();

			// Validate Parts page heading
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Parts.png", "Parts", "Parts image");

			// Validate Parts bread crumb
			wdu.highlightElement(HomePage.linkBreadCrumb);
			String breadCrumb = driver.findElement(HomePage.linkBreadCrumb).getText();
			if (breadCrumb.equalsIgnoreCase("Parts"))
				report.updateTestLog("Parts screen", "Bread crumb showing correct.", Status.PASS);
			else
				report.updateTestLog("Parts screen", "Bread crumb showing wrong.", Status.FAIL);

			// Validate Shop page different Parts images
			wdu.waitUntilElementEnabled(HomePage.linkShopMenuTitle, 10);
			gc.scrollToElement(HomePage.linkShopMenuTitle);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\PartsMenu.png", "Shop", "Parts menu image");

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validatePartsLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Shop landing page
	 */
	public void validateShopLandingPage() {
		try {
			// Wait and click on Shop link
			wdu.waitUntilElementEnabled(HomePage.linkShop, 10);
			driver.findElement(HomePage.linkShop).click();
			report.updateTestLog("Home page screen", "Clicked on Shop link.", Status.DONE);

			// Validate Shop page heading
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Shop.png", "Shop", "Shop image");

			// Validate Shop page different grills images
			wdu.waitUntilElementEnabled(HomePage.linkShopMenuTitle, 10);
			gc.scrollToElement(HomePage.linkShopMenuTitle);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\ShopMenu.png", "Shop", "Shop menu image");

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateShopLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	public void validateMyAccLink() {
		try {
			driver.findElement(HomePage.txtMyAccLink).isDisplayed();
			wdu.highlightElement(HomePage.txtMyAccLink);
			report.updateTestLog("My Account", "My account link is available", Status.PASS);

		} catch (Exception e) {
			report.updateTestLog("My Account", "validation of My account  link is unsuccessfull", Status.FAIL);
		}
	}

	public void validateCountrydropdown() {
		try {
			driver.findElement(HomePage.CountryDropdown).isDisplayed();
			wdu.highlightElement(HomePage.CountryDropdown);
			driver.findElement(HomePage.CountryDropdown).click();
			// obj.pause("2");
			report.updateTestLog("Country Dropdown", "Country Dropdown link is available", Status.PASS);

		} catch (Exception e) {
			report.updateTestLog("CountryDropdown", "validation Country Dropdown link is unsuccessfull", Status.FAIL);
		}
	}

	public void validateLiveChatLinkHeader() {
		try {

			wdu.objectExists(HomePage.lnkLiveChat);
			driver.findElement(HomePage.lnkLiveChat).isDisplayed();
			wdu.highlightElement(HomePage.lnkLiveChat);

			report.updateTestLog("Live CHat Link Validation", "Live chat link in the Header is Validated", Status.PASS);

		} catch (Exception e) {
			report.updateTestLog("Live CHat Link Validation", "Live chat validation is not successful", Status.FAIL);
		}
	}

	public void validateTrueInfra_URL() {
		try {

			wdu.waitUntilPageReadyStateComplete(20);
			String currentURL = driver.getCurrentUrl();
			String expectedText = "tru-infrared";
			if (currentURL.contains(expectedText)) {
				report.updateTestLog("URL content Validation", "URL is containing the expected text: " + expectedText,
						Status.PASS);
			}

			else

			{
				report.updateTestLog("URL content Validation",
						"URL is not containing the expected text: " + expectedText, Status.FAIL);
			}

		} catch (Exception e) {
			report.updateTestLog("URL content Validation", "Exception while validating URL Content. Exception is: " + e,
					Status.FAIL);
		}
	}

	/*
	 * Method to validate find a part results
	 */
	public void checkFindAPartResults() {
		try {
			// Wait and click on Parts link
			wdu.waitUntilElementEnabled(HomePage.linkParts, 10);
			driver.findElement(HomePage.linkParts).click();

			// Enter data in parts link and search
			String partNumber = "463346017";
			wdu.waitUntilElementEnabled(HomePage.txtFindAPart, 10);
			driver.findElement(HomePage.txtFindAPart).sendKeys(partNumber);
			report.updateTestLog("Find A Part result validation", "Entered part no as - " + partNumber, Status.DONE);
			driver.findElement(HomePage.btnFindAPartSearchSubmit).click();

			// check the header
			wdu.waitUntilElementLocated(HomePage.lblFindAPartResultHeader, 10);
			String expectedHeader = "Part Results For : " + partNumber;
			String actualHeader = driver.findElement(HomePage.lblFindAPartResultHeader).getText();
			if (expectedHeader.equalsIgnoreCase(actualHeader))
				report.updateTestLog("Find A Part result validation",
						"Results header is displayed as - " + actualHeader, Status.PASS);
			else
				report.updateTestLog("Find A Part result validation",
						"Results header is displayed as - " + actualHeader, Status.FAIL);

			// check the name of the product
			String prodName = driver.findElement(HomePage.lblPartFinderHeader).getText().split(":")[1].trim();
			report.updateTestLog("Find A Part result validation", "Product name is diaplyed as - " + prodName,
					Status.DONE);

			// check register, warranty, support links
			List<WebElement> guideElements = driver.findElements(HomePage.linkGuideForPartsName);
			int size = guideElements.size();
			for (int i = 0; i < size; i++) {
				guideElements = driver.findElements(HomePage.linkGuideForPartsName);
				WebElement webElement = guideElements.get(i);
				String text = webElement.getText();
				webElement.click();
				Thread.sleep(1000);
				report.updateTestLog("Find A Part result validation", "Clicked on Guide section link - " + text,
						Status.DONE);
				String currUrl = driver.getCurrentUrl();

				String expectedUrl = "";
				if (text.equalsIgnoreCase("REGISTER"))
					expectedUrl = "support.charbroil.com/product-registration";
				else if (text.equalsIgnoreCase("WARRANTY"))
					expectedUrl = "charbroil.com/help/warranty";
				else if (text.equalsIgnoreCase("SUPPORT"))
					expectedUrl = "support.charbroil.com";

				if (currUrl.contains(expectedUrl))
					report.updateTestLog("Find A PArt result validation", "Navigated to URL - " + currUrl, Status.PASS);
				else
					report.updateTestLog("Find A PArt result validation", "Navigated to URL - " + currUrl, Status.FAIL);

				driver.navigate().back();
			}

			// check guide and manual links opening pdf file
			List<WebElement> guideManualElements = driver.findElements(HomePage.linkGuideManualTitle);
			size = guideManualElements.size();
			for (int i = 0; i < size; i++) {
				guideManualElements = driver.findElements(HomePage.linkGuideManualTitle);
				WebElement webElement = guideManualElements.get(i);

				String text = webElement.getText();
				webElement.click();
				Thread.sleep(1000);
				report.updateTestLog("Find A Part result validation", "Clicked on Guide section link - " + text,
						Status.DONE);

				/*
				 * String mainWindow = driver.getWindowHandle(); driver.switchTo().window(new
				 * ArrayList<>(driver.getWindowHandles()).get(1));
				 */

				String currUrl = driver.getCurrentUrl();
				if (currUrl.contains(".pdf"))
					report.updateTestLog("Find A PArt result validation", "Navigated to URL - " + currUrl, Status.PASS);
				else
					report.updateTestLog("Find A PArt result validation", "Navigated to URL - " + currUrl, Status.FAIL);

				/*
				 * driver.close(); driver.switchTo().window(mainWindow);
				 */
				driver.navigate().back();
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Find A Part results validation", "Exception is " + e, Status.FAIL);
		}
	}

	// ========================================================//
	// *********EU methods************* //
	// ========================================================//

	/*
	 * Method for validating contact us link
	 */
	public void validateContactUsEU() {
		try {
			String currUrl = "", expectedUrl = "", header = "";

			wdu.waitUntilElementEnabled(HomePage.linkContactUsForCountries, 10);
			if (driver.findElement(HomePage.linkContactUsForCountries).isDisplayed())
				report.updateTestLog("Home Page", "Contact us link is present.", Status.PASS);
			else
				report.updateTestLog("Home Page", "Contact us link is not present.", Status.FAIL);
			wdu.highlightElement(HomePage.linkContactUsForCountries);

			// click on contact us link
			driver.findElement(HomePage.linkContactUsForCountries).click();
			report.updateTestLog("Home Page", "Clicked on contact us link.", Status.DONE);
			Thread.sleep(2000);

			// validate navigated to contact us page
			/*
			 * wdu.waitUntilElementLocated(HomePage.linkContactUsHeaderEU, 5); header =
			 * driver.findElement(HomePage.linkContactUsHeaderEU).getText();
			 * report.updateTestLog("Contact us link validation",
			 * "Contact us header is present. Showing as - "+header, Status.PASS);
			 */
			currUrl = driver.getCurrentUrl();
			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.com"))
				expectedUrl = "charbroil.eu/contact-us/";
			else if (AppURL.contains("charbroil.eu")) {
				wdu.waitUntilElementLocated(HomePage.linkContactUsHeaderEU, 5);
				header = driver.findElement(HomePage.linkContactUsHeaderEU).getText();
				expectedUrl = "charbroil.eu/contact-us/";
			} else if (AppURL.contains("charbroil.fr")) {
				wdu.waitUntilElementLocated(HomePage.linkContactUsHeaderFR, 5);
				header = driver.findElement(HomePage.linkContactUsHeaderFR).getText();
				expectedUrl = "charbroil.fr/nous-contacter/";
			} else if (AppURL.contains("charbroil.de")) {
				wdu.waitUntilElementLocated(HomePage.linkContactUsHeaderDE, 5);
				header = driver.findElement(HomePage.linkContactUsHeaderDE).getText();
				expectedUrl = "charbroil.de/kontakt/";
			} else if (AppURL.contains("charbroil.dk")) {
				wdu.waitUntilElementLocated(HomePage.linkContactUsHeaderDK, 5);
				header = driver.findElement(HomePage.linkContactUsHeaderDK).getText();
				expectedUrl = "charbroil.dk/kontakt-os/";
			}
			report.updateTestLog("Contact us link validation", "Contact us header is present. Showing as - " + header,
					Status.PASS);

			if (currUrl.contains(expectedUrl))
				report.updateTestLog("Contact us link validation", "Navigated to expected URL - " + currUrl,
						Status.PASS);
			else
				report.updateTestLog("Contact us link validation", "Not navigated to expected URL - " + currUrl,
						Status.FAIL);

			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateContactUs", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating product registration link
	 */
	public void validateProductRegistrationEU() {
		try {
			By prodRegistrationHeader = null;
			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				prodRegistrationHeader = ProductRegistrationPage.lblProductRegistrationEU;
			else if (AppURL.contains("charbroil.fr"))
				prodRegistrationHeader = ProductRegistrationPage.lblProductRegistrationFR;
			else if (AppURL.contains("charbroil.de"))
				prodRegistrationHeader = ProductRegistrationPage.lblProductRegistrationDE;
			else if (AppURL.contains("charbroil.dk"))
				prodRegistrationHeader = ProductRegistrationPage.lblProductRegistrationDK;

			wdu.waitUntilElementEnabled(HomePage.linkProductRegForCountries, 10);
			wdu.highlightElement(HomePage.linkProductRegForCountries);
			report.updateTestLog("Home Page", "Product Registration link is present.", Status.PASS);
			driver.findElement(HomePage.linkProductRegForCountries).click();
			Thread.sleep(2000);
			report.updateTestLog("Home Page", "Clicked on Product Registration link.", Status.DONE);

			String mainWindowHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					gc.scrollToElement(prodRegistrationHeader);
					wdu.highlightElement(prodRegistrationHeader);
					report.updateTestLog("Product registration link validation",
							"Product Registration label is present.", Status.PASS);
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateProductRegistration", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	/*
	 * Method for check presence of flag drop down in home page
	 */
	public void validateFlagDropdownEU() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkHomeFlagDropdown, 10);
			wdu.mouseHoverJScript(driver.findElement(HomePage.linkHomeFlagDropdown));
			Thread.sleep(1000);
			report.updateTestLog("Home page validation", "Hover on flag menu dropdown", Status.PASS);

			if (driver.findElement(HomePage.linkFlagDropdownOptions).isDisplayed())
				report.updateTestLog("Home page validation", "Flag menus are getting displayed.", Status.PASS);
			else
				report.updateTestLog("Home page validation", "Flag menus are not getting displayed.", Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFlagDropdownEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validate flag navigations from home page
	 */
	public void validateFlagNavigation() {
		try {
			String currUrl = "", mainWindowHandle = "";

			wdu.waitUntilElementEnabled(HomePage.linkHomeFlagDropdown, 10);
			wdu.mouseHoverJScript(driver.findElement(HomePage.linkHomeFlagDropdown));
			Thread.sleep(1000);
			report.updateTestLog("Home page validation", "Hover on flag menu dropdown", Status.DONE);

			// Validate flag "DANSK" link
			driver.findElement(HomePage.linkFlagDansk).click();
			Thread.sleep(2000);
			report.updateTestLog("Flag link validation", "Clicked on DANSK link.", Status.DONE);
			mainWindowHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					for (int i = 0; i < 5; i++) {
						currUrl = driver.getCurrentUrl();
						if (currUrl.contains("charbroil.dk")) {
							report.updateTestLog("Flag DANSK link validation", "Navigated to correct URL - " + currUrl,
									Status.PASS);
							break;
						} else if (i == 4)
							report.updateTestLog("Flag DANSK link validation",
									"Not navigated to correct URL. Opened url - " + currUrl, Status.FAIL);
						else
							Thread.sleep(2000);
					}
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);

			// Validate flag "DEUTSCH" link
			wdu.mouseHoverJScript(driver.findElement(HomePage.linkHomeFlagDropdown));
			Thread.sleep(1000);
			driver.findElement(HomePage.linkFlagDeutsch).click();
			Thread.sleep(2000);
			report.updateTestLog("Flag link validation", "Clicked on DEUTSCH link.", Status.DONE);
			mainWindowHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					for (int i = 0; i < 5; i++) {
						currUrl = driver.getCurrentUrl();
						if (currUrl.contains("charbroil.de")) {
							report.updateTestLog("Flag DEUTSCH link validation",
									"Navigated to correct URL - " + currUrl, Status.PASS);
							break;
						} else if (i == 4)
							report.updateTestLog("Flag DEUTSCH link validation",
									"Not navigated to correct URL. Opened url - " + currUrl, Status.FAIL);
						else
							Thread.sleep(2000);
					}
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);

			// Validate flag "FRANCAIS" link
			wdu.mouseHoverJScript(driver.findElement(HomePage.linkHomeFlagDropdown));
			Thread.sleep(1000);
			driver.findElement(HomePage.linkFlagFrancais).click();
			Thread.sleep(2000);
			report.updateTestLog("Flag link validation", "Clicked on FRANCAIS link.", Status.DONE);
			mainWindowHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					for (int i = 0; i < 5; i++) {
						currUrl = driver.getCurrentUrl();
						if (currUrl.contains("charbroil.fr")) {
							report.updateTestLog("Flag FRANCAIS link validation",
									"Navigated to correct URL - " + currUrl, Status.PASS);
							break;
						} else if (i == 4)
							report.updateTestLog("Flag FRANCAIS link validation",
									"Not navigated to correct URL. Opened url - " + currUrl, Status.FAIL);
						else
							Thread.sleep(2000);
					}
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);

			// Validate flag "USA" link
			wdu.mouseHoverJScript(driver.findElement(HomePage.linkHomeFlagDropdown));
			Thread.sleep(1000);
			driver.findElement(HomePage.linkFlagUSA).click();
			Thread.sleep(2000);
			report.updateTestLog("Flag link validation", "Clicked on USA link.", Status.DONE);
			mainWindowHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					for (int i = 0; i < 5; i++) {
						currUrl = driver.getCurrentUrl();
						if (currUrl.contains("charbroil.com")) {
							report.updateTestLog("Flag USA link validation", "Navigated to correct URL - " + currUrl,
									Status.PASS);
							break;
						} else if (i == 4)
							report.updateTestLog("Flag USA link validation",
									"Not navigated to correct URL. Opened url - " + currUrl, Status.FAIL);
						else
							Thread.sleep(2000);
					}
					driver.close();
				}
			}
			driver.switchTo().window(mainWindowHandle);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFlagNavigation", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating products link for EU
	 */
	public void validateProductsLinkEU() {
		try {
			String currUrl = "", expectedUrl = "";

			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				expectedUrl = "charbroil.eu/shop/";
			else if (AppURL.contains("charbroil.fr"))
				expectedUrl = "charbroil.fr/shop/";
			else if (AppURL.contains("charbroil.de"))
				expectedUrl = "charbroil.de/shop/";
			else if (AppURL.contains("charbroil.dk"))
				expectedUrl = "charbroil.dk/shop/";

			wdu.highlightElement(HomePage.linkProductsForCountries);
			report.updateTestLog("Home Page", "Products link is present.", Status.PASS);
			// gc.clickItem(HomePage.linkProductsForCountries, "Home",
			// driver.findElement(HomePage.linkProductsForCountries).getText());
			driver.findElement(HomePage.linkProductsForCountries).click();
			// gc.clickOnElementByJScript(driver.findElement(HomePage.linkProductsForCountries));
			report.updateTestLog("Home Page", "Clicked on Products link.", Status.DONE);
			Thread.sleep(2000);

			currUrl = driver.getCurrentUrl();
			if (currUrl.contains(expectedUrl))
				report.updateTestLog("Products link validation",
						"Navigated to expected url. Current url is - " + currUrl, Status.PASS);
			else
				report.updateTestLog("Products link validation",
						"Not navigated to expected url. Current url is - " + currUrl, Status.FAIL);

			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateShopLink", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating Recipes link for EU
	 */
	public void validateRecipesLinkEU() {
		try {
			String currUrl = "", expectedUrl = "";

			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				expectedUrl = "charbroil.eu/recipes";
			else if (AppURL.contains("charbroil.fr"))
				expectedUrl = "charbroil.fr/recettes";
			else if (AppURL.contains("charbroil.de"))
				expectedUrl = "charbroil.de/rezepte";
			else if (AppURL.contains("charbroil.dk"))
				expectedUrl = "charbroil.dk/opskrifter";

			wdu.highlightElement(HomePage.linkRecipesForCountries);
			report.updateTestLog("Home Page", "Recipes link is present.", Status.PASS);
			gc.clickItem(HomePage.linkRecipesForCountries, "Home",
					driver.findElement(HomePage.linkRecipesForCountries).getText());
			Thread.sleep(2000);

			currUrl = driver.getCurrentUrl();
			if (currUrl.contains(expectedUrl))
				report.updateTestLog("Recipes link validation",
						"Navigated to expected url. Current url is - " + currUrl, Status.PASS);
			else
				report.updateTestLog("Recipes link validation",
						"Not navigated to expected url. Current url is - " + currUrl, Status.FAIL);

			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipesLinkEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating tips link for EU
	 */
	public void validateTipsLinkEU() {
		try {
			String currUrl = "", expectedUrl = "";

			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				expectedUrl = "charbroil.eu/tips";
			else if (AppURL.contains("charbroil.fr"))
				expectedUrl = "charbroil.fr/conseils";
			else if (AppURL.contains("charbroil.de"))
				expectedUrl = "charbroil.de/tipps";
			else if (AppURL.contains("charbroil.dk"))
				expectedUrl = "charbroil.dk/tips";

			wdu.highlightElement(HomePage.linkTipsForCountries);
			report.updateTestLog("Home Page", "Tips link is present.", Status.PASS);
			gc.clickItem(HomePage.linkTipsForCountries, "Home",
					driver.findElement(HomePage.linkTipsForCountries).getText());
			Thread.sleep(2000);

			currUrl = driver.getCurrentUrl();
			if (currUrl.contains(expectedUrl))
				report.updateTestLog("Tips link validation", "Navigated to expected url. Current url is - " + currUrl,
						Status.PASS);
			else
				report.updateTestLog("Tips link validation",
						"Not navigated to expected url. Current url is - " + currUrl, Status.FAIL);

			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateTipsLinkEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating support link for EU
	 */
	public void validateSupportLinkEU() {
		try {
			String currUrl = "", expectedUrl = "";

			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				expectedUrl = "charbroil.eu/help/";
			else if (AppURL.contains("charbroil.fr"))
				expectedUrl = "charbroil.fr/help/";
			else if (AppURL.contains("charbroil.de"))
				expectedUrl = "charbroil.de/help/";
			else if (AppURL.contains("charbroil.dk"))
				expectedUrl = "charbroil.dk/help/";

			wdu.highlightElement(HomePage.linkSupportForCountries);
			report.updateTestLog("Home Page", "Support link is present.", Status.PASS);
			gc.clickItem(HomePage.linkSupportForCountries, "Home",
					driver.findElement(HomePage.linkSupportForCountries).getText());
			Thread.sleep(2000);

			currUrl = driver.getCurrentUrl();
			if (currUrl.contains(expectedUrl))
				report.updateTestLog("Support link validation",
						"Navigated to expected url. Current url is - " + currUrl, Status.PASS);
			else
				report.updateTestLog("Support link validation",
						"Not navigated to expected url. Current url is - " + currUrl, Status.FAIL);

			gc.navigateToBack();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSupportLinkEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Search item from header search function
	 */
	public void searchFromHomeEU() {
		try {
			String item = dataTable.getData("General_Data", "ProductModel");
			Browser browser = driver.getTestParameters().getBrowser();

			driver.findElement(HomePage.txtSearchItem).sendKeys(item);
			if (browser.equals(Browser.INTERNET_EXPLORER)) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);

			} else {
				driver.findElement(HomePage.txtSearchItem).sendKeys(Keys.ENTER);
			}
			Thread.sleep(2000);

			if (driver.findElement(ProductListingPage.lblSortByPLPEU).isDisplayed()) {
				report.updateTestLog("Product Listing Page", "Product Listing Page is Displayed after search",
						Status.PASS);
			} else {
				report.updateTestLog("Product Listing Page", "Product Listing Page is not Displayed after search",
						Status.FAIL);
			}
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Searching product from search box homepage",
					"Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method for validating search results tabs after search item from home page
	 */
	public void validateSearchResultsTabEU() {
		try {
			String searchResult = "", expectedProductTab = "", expectedRecipesTab = "", expectedTipsTab = "",
					expectedSupportTab = "";

			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu")) {
				expectedProductTab = "Products";
				expectedRecipesTab = "Recipes";
				expectedTipsTab = "Tips";
				expectedSupportTab = "Support";
			} else if (AppURL.contains("charbroil.fr")) {
				expectedProductTab = "Produits";
				expectedRecipesTab = "Recettes";
				expectedTipsTab = "Conseils";
				expectedSupportTab = "Assistance";
			} else if (AppURL.contains("charbroil.de")) {
				expectedProductTab = "Artikel";
				expectedRecipesTab = "Rezepte";
				expectedTipsTab = "Tipps";
				expectedSupportTab = "Support";
			} else if (AppURL.contains("charbroil.dk")) {
				expectedProductTab = "Produkter";
				expectedRecipesTab = "Opskrifter";
				expectedTipsTab = "Tips";
				expectedSupportTab = "Hjælp";
			}

			wdu.waitUntilElementEnabled(ProductListingPage.linkResultsProductsTabEU, 5);
			// Verify Product tab
			if (driver.findElement(ProductListingPage.linkResultsProductsTabEU).getText()
					.equalsIgnoreCase(expectedProductTab))
				report.updateTestLog("Search Results Screen", "Products tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "Products tab is not displayed.", Status.FAIL);

			searchResult = driver.findElement(ProductListingPage.lblPageHeaderTitle).getText();
			report.updateTestLog("Search result screen validation", "Displaying search result as - " + searchResult,
					Status.PASS);

			// Verify Recipes tab
			wdu.highlightElement(ProductListingPage.linkResultsRecipesTabEU);
			driver.findElement(ProductListingPage.linkResultsRecipesTabEU).click();
			Thread.sleep(1000);
			if (driver.findElement(ProductListingPage.linkResultsRecipesTabEU).getText()
					.equalsIgnoreCase(expectedRecipesTab))
				report.updateTestLog("Search Results Screen", "Recipes tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "Recipes tab is not displayed.", Status.FAIL);

			searchResult = driver.findElement(ProductListingPage.lblPageHeaderTitle).getText();
			report.updateTestLog("Search result screen validation", "Displaying search result as - " + searchResult,
					Status.PASS);

			// Verify How To tab
			wdu.highlightElement(ProductListingPage.linkResultsHowToTabEU);
			driver.findElement(ProductListingPage.linkResultsHowToTabEU).click();
			Thread.sleep(1000);
			if (driver.findElement(ProductListingPage.linkResultsHowToTabEU).getText()
					.equalsIgnoreCase(expectedTipsTab))
				report.updateTestLog("Search Results Screen", "How To tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "How To tab is not displayed.", Status.FAIL);

			searchResult = driver.findElement(ProductListingPage.lblPageHeaderTitle).getText();
			report.updateTestLog("Search result screen validation", "Displaying search result as - " + searchResult,
					Status.PASS);

			// Verify Support tab
			wdu.highlightElement(ProductListingPage.linkResultsSupportTabEU);
			driver.findElement(ProductListingPage.linkResultsSupportTabEU).click();
			Thread.sleep(1000);
			if (driver.findElement(ProductListingPage.linkResultsSupportTabEU).getText()
					.equalsIgnoreCase(expectedSupportTab))
				report.updateTestLog("Search Results Screen", "Support tab is displayed.", Status.PASS);
			else
				report.updateTestLog("Search Results Screen", "Support tab is not displayed.", Status.FAIL);

			searchResult = driver.findElement(ProductListingPage.lblPageHeaderTitle).getText();
			report.updateTestLog("Search result screen validation", "Displaying search result as - " + searchResult,
					Status.PASS);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateSearchResultsTab", "Exception is " + e, Status.FAIL);
		}
	}

	public void validateInvalidProdSearchEU() {
		try {
			String item = dataTable.getData("General_Data", "ProductModel");
			Browser browser = driver.getTestParameters().getBrowser();

			driver.findElement(HomePage.txtSearchItem).sendKeys(item);
			if (browser.equals(Browser.INTERNET_EXPLORER)) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);

			} else {
				driver.findElement(HomePage.txtSearchItem).sendKeys(Keys.ENTER);
			}
			Thread.sleep(2000);

			wdu.waitUntilElementLocated(ProductListingPage.lblNoResultHeader, 10);
			String result = driver.findElement(ProductListingPage.lblNoResultHeader).getText();
			if (result.contains("0 RESULTS FOR "))
				report.updateTestLog("Validate invalid search result",
						"Invalid search result is displayed as - " + result.trim(), Status.PASS);
			else
				report.updateTestLog("Validate invalid search result",
						"Expected result to contain - '0 RESULTS FOR ' text. "
								+ "Invalid search result is displayed as - " + result.trim(),
						Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateInvalidProdSearchEU", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void validateWhatsHotEU() {
		try {
			wdu.waitUntilElementLocated(HomePage.linkWhatsHotRedPlusEU4, 5);
			gc.scrollToElement(HomePage.linkWhatsHotRedPlusEU4);
			driver.findElement(HomePage.linkWhatsHotRedPlusEU4).click();
			// gc.clickOnElementByJScript(driver.findElement(HomePage.linkWhatsHotRedPlusEU4));
			report.updateTestLog("Whats Hot section validation", "Clicked on red color plus sign.", Status.DONE);

			driver.findElement(HomePage.linkWhatsHotRedPlusEU1).click();
			report.updateTestLog("Whats Hot section validation", "Clicked on red color plus sign.", Status.DONE);

			driver.findElement(HomePage.linkWhatsHotRedPlusEU2).click();
			report.updateTestLog("Whats Hot section validation", "Clicked on red color plus sign.", Status.DONE);

			driver.findElement(HomePage.linkWhatsHotRedPlusEU3).click();
			report.updateTestLog("Whats Hot section validation", "Clicked on red color plus sign.", Status.DONE);

			driver.findElement(HomePage.linkWhatsHotRedPlusEU5).click();
			report.updateTestLog("Whats Hot section validation", "Clicked on red color plus sign.", Status.DONE);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateWhatsHotEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void validateExploreGrillButton() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkExploreGrillButtonEU, 10);
			driver.findElement(HomePage.linkExploreGrillButtonEU).click();
			Thread.sleep(1000);
			report.updateTestLog("Whats Hot section validation", "Clicked on Explore Our Hydrid Grill button.",
					Status.DONE);

			String currUrl = "", expectedUrl = "";
			currUrl = driver.getCurrentUrl();
			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				expectedUrl = "charbroil.eu/gas2coal-140-723";
			else if (AppURL.contains("charbroil.fr"))
				expectedUrl = "charbroil.fr/gas2coal-fr-140-723";
			else if (AppURL.contains("charbroil.de"))
				expectedUrl = "charbroil.de/gas2coal-de-140-721";
			else if (AppURL.contains("charbroil.dk"))
				expectedUrl = "charbroil.dk/gas2coal-dk-140-723";

			if (currUrl.contains(expectedUrl))
				report.updateTestLog("Whats Hot section validation", "Navigated to expected url.", Status.PASS);
			else
				report.updateTestLog("Whats Hot section validation", "Not navigated to expected url.", Status.FAIL);

			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateExploreGrillButton", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void validateBreadcrumbEU(String prodCatg) {
		try {
			String breadcrumbtext = "";
			wdu.waitUntilElementLocated(ProductListingPage.lblPLPBreadcrumb, 10);
			breadcrumbtext = driver.findElement(ProductListingPage.lblPLPBreadcrumb).getText();

			if (breadcrumbtext.toUpperCase().contains(prodCatg.toUpperCase()))
				report.updateTestLog(prodCatg + " products page validation",
						"Breadcrumb is displayed as - " + breadcrumbtext, Status.PASS);
			else
				report.updateTestLog(prodCatg + " products page validation",
						"Breadcrumb is displayed as - " + breadcrumbtext + ". Expected to contain text - " + prodCatg,
						Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateBreadcrumbEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void validateGrillForEveryGrillerEU() {
		try {
			String btnText = "";
			WebElement ele;

			// Validate Charcoal Grills button in A Grill for every Griller section
			wdu.waitUntilElementLocated(HomePage.linkGrillForEveryGrillerCharcoalEU, 10);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerCharcoalEU);
			ele = driver.findElement(HomePage.linkGrillForEveryGrillerCharcoalEU);
			btnText = ele.getText();
			ele.click();
			report.updateTestLog("Grills for every griller section validation", "Clicked on Charcoal Grills button.",
					Status.PASS);
			wdu.waitUntilElementLocated(HomePage.btnDiscoverCharcoalGrillsEU, 5);
			gc.clickOnElementByJScript(driver.findElement(HomePage.btnDiscoverCharcoalGrillsEU));
			// driver.findElement(HomePage.btnDiscoverCharcoalGrillsEU).click();
			report.updateTestLog("Grills for every griller section validation",
					"Clicked on Shop All Charcoal Grills button.", Status.DONE);
			validateBreadcrumbEU(btnText);
			driver.navigate().back();
			driver.navigate().back();

			// Validate Electric Grills button in A Grill for every Griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerElectricEU, 10);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerElectricEU);
			ele = driver.findElement(HomePage.linkGrillForEveryGrillerElectricEU);
			btnText = ele.getText();
			ele.click();
			report.updateTestLog("Grills for every griller section validation", "Clicked on Electric Grills button.",
					Status.PASS);
			wdu.waitUntilElementLocated(HomePage.btnDiscoverElectricGrillsEU, 5);
			gc.clickOnElementByJScript(driver.findElement(HomePage.btnDiscoverElectricGrillsEU));
			// driver.findElement(HomePage.btnDiscoverElectricGrillsEU).click();
			report.updateTestLog("Grills for every griller section validation",
					"Clicked on Shop All Electric Grills button.", Status.DONE);
			validateBreadcrumbEU(btnText);
			driver.navigate().back();
			driver.navigate().back();

			// Validate Gas Grills button in A Grill for every Griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerGasEU, 10);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerGasEU);
			ele = driver.findElement(HomePage.linkGrillForEveryGrillerGasEU);
			btnText = ele.getText();
			ele.click();
			report.updateTestLog("Grills for every griller section validation", "Clicked on Gas Grills button.",
					Status.PASS);
			wdu.waitUntilElementLocated(HomePage.btnDiscoverGasGrillsEU, 5);
			gc.clickOnElementByJScript(driver.findElement(HomePage.btnDiscoverGasGrillsEU));
			// driver.findElement(HomePage.btnDiscoverGasGrillsEU).click();
			report.updateTestLog("Grills for every griller section validation",
					"Clicked on Shop All Gas Grills button.", Status.DONE);
			validateBreadcrumbEU(btnText);
			driver.navigate().back();
			driver.navigate().back();

			// Validate Portable Grills button in A Grill for every Griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerPortableEU, 10);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerPortableEU);
			ele = driver.findElement(HomePage.linkGrillForEveryGrillerPortableEU);
			btnText = ele.getText();
			ele.click();
			report.updateTestLog("Grills for every griller section validation", "Clicked on Portable Grills button.",
					Status.PASS);
			wdu.waitUntilElementLocated(HomePage.btnDiscoverPortableGrillsEU, 5);
			gc.clickOnElementByJScript(driver.findElement(HomePage.btnDiscoverPortableGrillsEU));
			// driver.findElement(HomePage.btnDiscoverPortableGrillsEU).click();
			report.updateTestLog("Grills for every griller section validation",
					"Clicked on Shop All Portable Grills button.", Status.DONE);
			validateBreadcrumbEU(btnText);
			driver.navigate().back();
			driver.navigate().back();

			// Validate Smokers Grills button in A Grill for every Griller section
			wdu.waitUntilElementEnabled(HomePage.linkGrillForEveryGrillerSmokersEU, 10);
			gc.scrollToElement(HomePage.linkGrillForEveryGrillerSmokersEU);
			ele = driver.findElement(HomePage.linkGrillForEveryGrillerSmokersEU);
			btnText = ele.getText();
			ele.click();
			report.updateTestLog("Grills for every griller section validation", "Clicked on Smokers Grills button.",
					Status.PASS);
			wdu.waitUntilElementLocated(HomePage.btnDiscoverSmokersGrillsEU, 5);
			gc.clickOnElementByJScript(driver.findElement(HomePage.btnDiscoverSmokersGrillsEU));
			// driver.findElement(HomePage.btnDiscoverSmokersGrillsEU).click();
			report.updateTestLog("Grills for every griller section validation",
					"Clicked on Shop All Smokers Grills button.", Status.DONE);
			validateBreadcrumbEU(btnText);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateGrillForEveryGriller", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void validateContactFooterEU() {
		try {

			String expectedSendEmailText = "";
			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("charbroil.eu"))
				expectedSendEmailText = "send an email";
			else if (AppURL.contains("charbroil.fr"))
				expectedSendEmailText = "Envoyez-nous un e-mail";
			else if (AppURL.contains("charbroil.de"))
				expectedSendEmailText = "Sende uns eine E-Mail";
			else if (AppURL.contains("charbroil.dk"))
				expectedSendEmailText = "Send os en e-mail";

			wdu.waitUntilElementLocated(HomePage.linkFooterContactSendEmailEU, 10);
			gc.scrollToElement(HomePage.linkFooterContactSendEmailEU);
			if (driver.findElement(HomePage.linkFooterContactSendEmailEU).getText()
					.equalsIgnoreCase(expectedSendEmailText))
				report.updateTestLog("Footer contact validation", "Send An Email option is present", Status.PASS);
			else
				report.updateTestLog("Footer contact validation", "Send An Email option is not present", Status.FAIL);

			driver.findElement(HomePage.linkFooterImprintEU).click();
			report.updateTestLog("Footer contact validation", "Clicked on imprint option in footer contacr section.",
					Status.DONE);
			Thread.sleep(1000);
			wdu.waitUntilElementLocated(HomePage.lblImprintHeaderForCountries, 10);
			if (driver.findElement(HomePage.lblImprintHeaderForCountries).isDisplayed())
				report.updateTestLog("Footer contact validation", "Imprint header is displayed as - "
						+ driver.findElement(HomePage.lblImprintHeaderForCountries).getText(), Status.PASS);
			else
				report.updateTestLog("Footer contact validation", "Imprint header is not displayed.", Status.FAIL);

			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateContactFooterEU", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void validateCustomerSupportFooterEU() {
		try {

			wdu.waitUntilElementEnabled(HomePage.linkProductHelpForCountries, 10);
			gc.scrollToElement(HomePage.linkProductHelpForCountries);
			driver.findElement(HomePage.linkProductHelpForCountries).click();
			report.updateTestLog("Footer customer support validation",
					"Clicked on product help option in footer support section.", Status.DONE);
			Thread.sleep(1000);

			wdu.waitUntilElementLocated(HomePage.lblPageTitleEU, 10);
			// String expectedHeader = "We're here to help.";
			String actualHeader = driver.findElement(HomePage.lblPageTitleEU).getText();
			if (driver.findElement(HomePage.lblPageTitleEU).isDisplayed())
				report.updateTestLog("Footer customer support validation",
						"Product help header is displayed as - " + actualHeader, Status.PASS);
			else
				report.updateTestLog("Footer customer support validation",
						"Product header is not displayed as expected. " + "Header displayed as - " + actualHeader,
						Status.FAIL);

			driver.navigate().back();

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateCustomerSupportFooterEU", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void validateCompanyFooterEU() {
		try {

			wdu.waitUntilElementEnabled(HomePage.linkCompanyDancookEU, 10);
			gc.scrollToElement(HomePage.linkCompanyDancookEU);
			driver.findElement(HomePage.linkCompanyDancookEU).click();
			report.updateTestLog("Footer company validation",
					"Clicked on Dancook Grills option in footer support section.", Status.DONE);
			Thread.sleep(1000);

			String actualUrl = driver.getCurrentUrl();
			if (actualUrl.contains("www.dancook.dk/"))
				report.updateTestLog("Footer company validation", "Navigated to dancook grills page.", Status.PASS);
			else
				report.updateTestLog("Footer company validation",
						"Not navigated to dancook grills page. " + "Landed to following url - " + actualUrl,
						Status.FAIL);

			driver.navigate().back();

			wdu.waitUntilElementEnabled(HomePage.linkCompanyMagazineEU, 10);
			gc.scrollToElement(HomePage.linkCompanyMagazineEU);
			driver.findElement(HomePage.linkCompanyMagazineEU).click();
			report.updateTestLog("Footer customer support validation",
					"Clicked on Magazine option in footer support section.", Status.DONE);
			Thread.sleep(2000);

			String mainWindowHandle = driver.getWindowHandle();
			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(mainWindowHandle)) {
					driver.switchTo().window(handle);
					if (driver.getCurrentUrl().contains("pdf"))
						report.updateTestLog("Footer customer support validation",
								"Magazine opened pdf file in new tab.", Status.PASS);
					else
						report.updateTestLog("Footer customer support validation",
								"Magazine not opened a pdf file in new tab.", Status.FAIL);
					driver.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateCustomerSupportFooterEU", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	/*
	 * validate 'DATA SUBJECT ACCESS REQUEST' at footer section in home page
	 */
	public void validateDataAccessRewustFooterEurope() {
		try {
			wdu.waitUntilElementEnabled(HomePage.linkDataSubjectAccessRequest, 10);
			wdu.highlightElement(HomePage.linkDataSubjectAccessRequest);
			driver.findElement(HomePage.linkDataSubjectAccessRequest).click();
			Thread.sleep(2000);
			report.updateTestLog("Data Subject Access link validation in footer",
					"Clicked on data subject access request link.", Status.DONE);
			String mainWindow = driver.getWindowHandle();
			driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(1));

			String url = driver.getCurrentUrl();
			for (int i = 0; i < 5; i++) {
				if (url.contains("app.onetrust.com")) {
					report.updateTestLog("Data Subject Access link validation in footer",
							"Navigated to expected url - " + url, Status.PASS);
					break;
				} else if (i == 4)
					report.updateTestLog("Data Subject Access link validation in footer",
							"Not navigated to expected url. Expected url to "
									+ "contain 'app.onetrust.com'. Actual url - " + url,
							Status.FAIL);
				else
					Thread.sleep(2000);
			}

			driver.close();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateDataAccessRewustFooterEurope", "Exception is " + e.getMessage(),
					Status.FAIL);
		}
	}

	public void validateFindAPartPage() {
		String sortvalue = dataTable.getData("General_Data", "SortBy");
		try {
			if (driver.findElement(HomePage.lstSortBy).isDisplayed()) {
				report.updateTestLog("Find A Part Page", "Sort by drop down is present as expected", Status.PASS);
				wdu.selectListItem(HomePage.lstSortBy, sortvalue);
				Thread.sleep(2000);
				report.updateTestLog("Find A Part Page", sortvalue + " value selected from the drop down menu",
						Status.DONE);
				if (driver.findElement(HomePage.lnkAddToCart).isDisplayed()) {
					driver.findElement(HomePage.lnkAddToCart).click();

					report.updateTestLog("Find A Part Page", "Add to cart button is clicked", Status.PASS);
					if (driver.findElement(HomePage.lblAddToCartSuccessMsg).isDisplayed()) {
						String str = driver.findElement(HomePage.lblAddToCartSuccessMsg).getText();
						report.updateTestLog("Shopping Cart", str, Status.PASS);
						if (driver.findElement(HomePage.lnkGuidesSection).isDisplayed()) {
							report.updateTestLog("Find A Part page",
									"Guide and Manual section link is displayed as expected", Status.PASS);
							driver.findElement(HomePage.lnkGuidesSection).click();
							String url = driver.getCurrentUrl().toLowerCase();
							if (url.contains("manual"))
								report.updateTestLog("Guide and manual page",
										"Navigation to product manual page is successful", Status.PASS);
							else
								report.updateTestLog("Guide and manual page",
										"Navigation to product manual page is not successful", Status.FAIL);
						} else {
							report.updateTestLog("Find A Part page",
									"Guide and Manual section link is not displayed as expected", Status.FAIL);
						}

					} else
						report.updateTestLog("Shopping Cart", "Item not added to shopping cart", Status.FAIL);

				} else {
					report.updateTestLog("Find A Part Page", "Add to cart button is not clicked", Status.FAIL);
				}
			} else {
				report.updateTestLog("Find A Part Page", "Sort by drop down is not present as expected", Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFindAPartInHome", "Exception is " + e, Status.FAIL);
		}
	}

	public void validateLearnPage() {

		try {
			if (driver.findElement(HomePage.linkShop).isDisplayed()) {

				String pageurl = driver.getCurrentUrl().toLowerCase();
				if (pageurl.contains("charcoal-grill-basics")) {
					report.updateTestLog("Learn Page", "Navigated to Learn Page as expected", Status.PASS);
				} else {
					report.updateTestLog("Learn Page", "Navigation to Learn Page is not successful", Status.FAIL);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateFindAPartInHome", "Exception is " + e, Status.FAIL);
		}
	}

	public void refreshPage() {
		try {

			driver.findElement(HomePage.linkHeaderLogo).click();
			Thread.sleep(3000);

		} catch (Exception e) {

		}

	}

}