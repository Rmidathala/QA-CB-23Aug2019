package businesscomponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.CheckOutPage;
import uimap.HomePage;
import uimap.ProductDetailsPage;

public class ProductDetailsPageComponents extends ReusableLibrary {

	WebDriverUtil wdu = new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public ProductDetailsPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/*************************************
	 * To Add product to Cart
	 *********************************************************/

	public void addSimpleRandomProduct() {

		try {
			
			gc.scrollToElement(ProductDetailsPage.btnAddtoCartPDP);

			driver.findElement(ProductDetailsPage.btnAddtoCartPDP).click();

			Thread.sleep(2000);

			// gc.LiveChatPopUpHandle();

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnViewCartCheckoutPDP, 30);

			if (driver.findElement(ProductDetailsPage.btnViewCartCheckoutPDP).isDisplayed()) {
				report.updateTestLog("Product Add", "Product added to cart", Status.PASS);
			}

			else {
				report.updateTestLog("Product Add", "Product is not added to cart", Status.FAIL);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in adding product in cart", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * Proceed to checkout
	 *********************************************************/

	public void proceedToCheckout() {

		try {

			driver.findElement(ProductDetailsPage.btnViewCartCheckoutPDP).click();
			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			if (driver.findElement(CheckOutPage.btnProceedToCheckout).isDisplayed()) {

				Thread.sleep(3000);

				gc.scrollToElement(CheckOutPage.btnProceedToCheckout);
				driver.findElement(CheckOutPage.btnProceedToCheckout).click();
				//wdu.waitUntilElementEnabled(CheckOutPage.txtFirstname, 30);
				gc.scrollToElement(CheckOutPage.txtFirstname);
				if (driver.findElement(CheckOutPage.txtFirstname).isDisplayed()) {
					report.updateTestLog("Proceed to Check out", "Proceed to checkout done", Status.PASS);
				}

				else {
					report.updateTestLog("Proceed to Check out", "Proceed to check out not done", Status.FAIL);
				}

			}

			else {
				report.updateTestLog("Proceed to Check out", "Proceed to check out button is not displayed",
						Status.FAIL);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in proceeding to checkout", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * To Validate PDP Submenu
	 *********************************************************/

	public void validatePDPSubmenu() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.subMenuSpecification, 30);

			gc.scrollToElement(ProductDetailsPage.subMenuSpecification);

			if (driver.findElement(ProductDetailsPage.subMenuSpecification).isDisplayed()
					&& driver.findElement(ProductDetailsPage.subMenuRatingReviews).isDisplayed()
					&& driver.findElement(ProductDetailsPage.subMenuQuestionAnswers).isDisplayed()
					&& driver.findElement(ProductDetailsPage.subMenuPartofGrills).isDisplayed()
					&& driver.findElement(ProductDetailsPage.subMenuGuideManuals).isDisplayed())

			{
				report.updateTestLog("PDP Sub Menu", "PDP Sub menu validation is sucessful", Status.PASS);
			}

			else {
				report.updateTestLog("PDP Sub Menu", "PDP Sub menu validation is not sucessful", Status.FAIL);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating PDP Submenu", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * To Validate Home Breadcumb
	 *********************************************************/

	public void validateHomeBreadcumb() {

		try {

			wdu.waitUntilElementEnabled(CheckOutPage.lnkBreadCrumbHome, 30);

			driver.findElement(CheckOutPage.lnkBreadCrumbHome).click();

			wdu.waitUntilElementEnabled(CheckOutPage.imgHeroHome, 30);

			if (driver.findElement(CheckOutPage.imgHeroHome).isDisplayed()) {
				report.updateTestLog("Validate home Breadcumb", "Validating Home Breadcumb is Successful", Status.PASS);

				driver.navigate().back();

			}

			else {
				report.updateTestLog("Validate home Breadcumb", "Validating Home Breadcumb is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Home Breadcumb", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * To Validate Second Breadcumb from PDP
	 *********************************************************/

	public void validateSecondBreadcumb() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.brdcmbSecond, 30);

			String brdcumbTxt = driver.findElement(ProductDetailsPage.brdcmbSecond).getText();
			String brdcumbTxt1 = brdcumbTxt.toLowerCase();

			driver.findElement(ProductDetailsPage.brdcmbSecond).click();

			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();

			if (currentURL.contains(brdcumbTxt1)) {
				report.updateTestLog("Validate Breadcumb", "Validating  Breadcumb is Successful", Status.PASS);

				driver.navigate().back();

			}

			else {
				report.updateTestLog("Validate Breadcumb", "Validating  Breadcumb is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Breadcumb", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * To Validate Third Breadcumb from PDP
	 *********************************************************/

	public void validateThirdBreadcumb() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.brdcmbThird, 30);

			String brdcumbTxt = driver.findElement(ProductDetailsPage.brdcmbThird).getText();
			String brdcumbTxt1 = brdcumbTxt.toLowerCase();

			driver.findElement(ProductDetailsPage.brdcmbThird).click();

			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();

			if (currentURL.contains(brdcumbTxt1)) {
				report.updateTestLog("Validate Breadcumb", "Validating  Breadcumb is Successful", Status.PASS);

				driver.navigate().back();

			}

			else {
				report.updateTestLog("Validate Breadcumb", "Validating  Breadcumb is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Breadcumb", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/******************************************************************
	 * Validate Add to cart button alignment
	 *****************************************************/

	public void validateAddToCartButtonAlignment() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 15);
			gc.scrollToElement(ProductDetailsPage.btnAddtoCartPDP);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\AddToCart.png", "Add to cart button",
					"Add to cart button in PDP Validation");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Add to cart button alignment", "Exception is " + e,
					Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/******************************************************************
	 * Validate Add to cart button alignment
	 *****************************************************/

	public void validateAddToCartButtonAlignment_STG() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 15);
			gc.scrollToElement(ProductDetailsPage.btnAddtoCartPDP);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\AddToCart_STG.png", "Add to cart button",
					"Add to cart button in PDP Validation");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Add to cart button alignment", "Exception is " + e,
					Status.FAIL);
		}

	}
	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Configurable option alignment
	 *****************************************************/

	public void validateConfigureProductAlignment() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 15);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\ConfigurePRD.png", "Add to cart button",
					"Add to cart button in PDP Validation");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Add to cart button alignment", "Exception is " + e,
					Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Where to Buy Button alignment
	 *****************************************************/

	public void validateWhereToBuyButtonAlignment() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 15);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\WhereToBuy.png", "Add to cart button",
					"Add to cart button in PDP Validation");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Add to cart button alignment", "Exception is " + e,
					Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate guide and manual section
	 *****************************************************/

	public void validateGuideManualSection() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnGuideManualsSubmenu, 30);
			gc.scrollToElement(ProductDetailsPage.btnGuideManualsSubmenu);
			driver.findElement(ProductDetailsPage.btnGuideManualsSubmenu).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.lnkManualPDF, 30);

			if (driver.findElement(ProductDetailsPage.lnkManualPDF).isDisplayed()) {
				report.updateTestLog("Validate Guide and Manual Section",
						"Validating  Guide and Manual section is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Guide and Manual Section",
						"Validating  Guide and Manual section is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Guide and Manual section", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate specification section
	 *****************************************************/

	public void validateSpecificationSection() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnSpecificationsSubmenu, 30);
			gc.scrollToElement(ProductDetailsPage.btnSpecificationsSubmenu);
			driver.findElement(ProductDetailsPage.btnSpecificationsSubmenu).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblSpecificationsSubmenuDetails, 30);

			if (driver.findElement(ProductDetailsPage.btnSpecificationsSubmenu).isDisplayed()) {
				report.updateTestLog("Validate Specification Section",
						"Validating  Specification section is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Specification Section",
						"Validating  Specification section is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Specification section", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Parts section
	 *****************************************************/

	public void validatePartsSection() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnPartsForThisGrillSubmenu, 30);
			gc.scrollToElement(ProductDetailsPage.btnPartsForThisGrillSubmenu);
			driver.findElement(ProductDetailsPage.btnPartsForThisGrillSubmenu).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnSeeAllPartsofTheGrill, 30);

			if (driver.findElement(ProductDetailsPage.btnSeeAllPartsofTheGrill).isDisplayed()) {
				report.updateTestLog("Validate Parts Section", "Validating  Parts section is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Parts Section", "Validating  Parts section is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Parts section", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate See all Parts section
	 *****************************************************/

	public void validateSeeAllPartsSection() {

		try {

			String modelPDP = driver.findElement(ProductDetailsPage.lblModelNumber).getText();

			String modelPDP1 = modelPDP.substring(modelPDP.indexOf("#") + 1);

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnPartsForThisGrillSubmenu, 30);
			gc.scrollToElement(ProductDetailsPage.btnPartsForThisGrillSubmenu);
			driver.findElement(ProductDetailsPage.btnPartsForThisGrillSubmenu).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnSeeAllPartsofTheGrill, 30);

			if (driver.findElement(ProductDetailsPage.btnSeeAllPartsofTheGrill).isDisplayed()) {
				report.updateTestLog("Validate see all parts Section", "See all parts button is present", Status.PASS);
				driver.findElement(ProductDetailsPage.btnSeeAllPartsofTheGrill).click();

				wdu.waitUntilElementEnabled(ProductDetailsPage.lblPartsForThisGrill, 30);

				String model = driver.findElement(ProductDetailsPage.lblPartsForThisGrill).getText();
				String model1 = model.substring(model.indexOf(":") + 1);

				if (model1.contains(modelPDP1)) {
					report.updateTestLog("Validate see all parts Section",
							"validation of See all parts button is successful", Status.PASS);
				}

				else {
					report.updateTestLog("Validate see all parts Section",
							"validation of See all parts button is not successful", Status.FAIL);
				}

			}

			else {
				report.updateTestLog("Validate see all parts Section", "See all parts button is not present",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating see all parts section", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate video thumb nail section
	 *****************************************************/

	public void validateThumbNailPDP() {

		try {

			Thread.sleep(2000);

			// driver.get("https://www.charbroil.com/kettleman-charcoal-grill#");

			// wdu.waitUntilElementEnabled(ProductDetailsPage.lnkYoutubeThumbnail, 30);

			// driver.findElement(ProductDetailsPage.imgYoutube).click();

			// wdu.waitUntilElementEnabled(ProductDetailsPage.imgYoutube, 30);

			driver.findElement(ProductDetailsPage.imgYoutube).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.frameYoutube, 30);

			if (driver.findElement(ProductDetailsPage.frameYoutube).isDisplayed()) {
				report.updateTestLog("Validate Youtube Thumbnail", "Validating  Youtube Thumbnail is Successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Validate Youtube Thumbnail", "Validating Youtube Thumbnail is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Youtube Thumbnail", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Frequently Bought Together section
	 *****************************************************/

	public void validateFrequentlyBoughtTogetherSection() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblFrequentlyBoughtTogether, 30);

			wdu.waitUntilElementEnabled(ProductDetailsPage.chkFrequentlyBoughtTogetherItem, 30);

			if (driver.findElement(ProductDetailsPage.chkFrequentlyBoughtTogetherItem).isSelected()) {
				report.updateTestLog("Validate Frequently Bought Together Section",
						"Validating  Frequently Bought Together Section is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Frequently Bought Together Section",
						"Validating Frequently Bought Together Section is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Frequently Bought Together Section", "Exception is " + e,
					Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Where to Buy button
	 *****************************************************/

	public void validateWhereToBuyButton() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnWhereToBuy, 30);

			driver.findElement(ProductDetailsPage.btnWhereToBuy).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.divOnlineSeller, 30);

			if (driver.findElement(ProductDetailsPage.divOnlineSeller).isDisplayed()) {
				report.updateTestLog("Validate Where To buy Button", "Validating  Where To buy Button is Successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Validate Where To buy Button", "Validating Where To buy Button is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Where To buy Button", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate price spider
	 *****************************************************/

	public void validatePriceSpider() {

		try {

			gc.validateImage(System.getProperty("user.dir") + "\\images\\OnlineSellerHeader.png",
					"Price Spider Section", "Price Spider Section Validation");
			gc.validateImage(System.getProperty("user.dir") + "\\images\\PriceSpider.png", "Price Spider Section",
					"Price Spider Section Validation");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Where To buy Button", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: getInStockProductPDP Objective: To land into the PDP of a
	 * instock Product Created On: 07/01/2015 Created By: Arka Dasgupta Automation
	 * Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/

	public void getInStockProductPDP() {

		try {

			String URL = dataTable.getData("General_Data", "PRODUCT_URL");

			driver.get(URL);
			gc.scrollToElement(ProductDetailsPage.btnAddtoCartPDP);
			wdu.waitUntilElementEnabled(ProductDetailsPage.btnAddtoCartPDP, 30);

			if (driver.findElement(ProductDetailsPage.btnAddtoCartPDP).isDisplayed()) {
				report.updateTestLog("PDP Landing", "Landing to PDP is successful", Status.PASS);
			}

			else {
				report.updateTestLog("PDP Landing", "VLanding to PDP is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while landing to PDP", "Exception is " + e, Status.FAIL);
		}

	}

	/************************************************************************************************************************
	 * Function Name: validateAddAllToCart Objective: To validate add all to cart
	 * button in PDP Created On: 07/01/2015 Created By: Arka Dasgupta Automation
	 * Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/

	public void validateAddAllToCart() {

		try {

			List<WebElement> listItem = driver.findElements(ProductDetailsPage.chkAllPartsPDP);
			int checkboxCountSize = listItem.size();

			driver.findElement(ProductDetailsPage.btnAddAllToCart).click();
			wdu.waitUntilElementEnabled(ProductDetailsPage.btnViewCartCheckoutPDP, 30);

			driver.findElement(ProductDetailsPage.btnViewCartCheckoutPDP).click();
			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			List<WebElement> listItem1 = driver.findElements(ProductDetailsPage.WebElementProductsInCart);

			int productCountInCartSize = listItem1.size();

			if (checkboxCountSize + 1 == productCountInCartSize) {
				report.updateTestLog("Add All to cart Validation", "Add all to cart button validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Add All to cart Validation",
						"Add all to cart button validation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating add all to cart button", "Exception is " + e, Status.FAIL);
		}

	}

	/************************************************************************************************************************
	 * Function Name: validateFindPartPDP Objective: To validate Find Part in
	 * Product Details Page Created On: 07/01/2015 Created By: Arka Dasgupta
	 * Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/

	public void validateFindPartPDP() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 30);

			String modelPDP = driver.findElement(ProductDetailsPage.lblModelNumber).getText();

			String modelPDP1 = modelPDP.substring(modelPDP.indexOf("#") + 1);

			Thread.sleep(3000);

			driver.findElement(ProductDetailsPage.WebElementFindParts).click();
			Thread.sleep(1000);
			wdu.waitUntilElementEnabled(ProductDetailsPage.txtFindPart, 30);
			driver.findElement(ProductDetailsPage.txtFindPart).sendKeys(modelPDP1);

			driver.findElement(ProductDetailsPage.btnSearchFindPart).click();
			wdu.waitUntilElementEnabled(ProductDetailsPage.lblPartsForThisGrill, 30);

			String model = driver.findElement(ProductDetailsPage.lblPartsForThisGrill).getText();
			String model1 = model.substring(model.indexOf(":") + 2);

			if (modelPDP1.contains(model1)) {
				report.updateTestLog("Find Part Validation", "Add all to cart button validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Find Part Validation", "Add all to cart button validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating find part", "Exception is " + e, Status.FAIL);
		}

	}

	/************************************************************************************************************************
	 * Function Name: validateZoomFunctionality Objective: To validate Zoom
	 * Functionality in Product Details Page Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/

	public void validateZoomFunctionality() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 30);

			driver.findElement(ProductDetailsPage.lnkZoomPDP).click();
			Thread.sleep(1000);
			wdu.waitUntilElementEnabled(ProductDetailsPage.lnkZoomModalPDP, 30);

			if (driver.findElement(ProductDetailsPage.lnkZoomModalPDP).isDisplayed()) {
				report.updateTestLog("Zoom Functionality Validation", "Zoom Functionality validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Zoom Functionality Validation", "Zoom Functionality validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Zoom Functionality", "Exception is " + e, Status.FAIL);
		}

	}

	public void ratingAndReviewCustomerImagePresenceValidator() {

		try {

			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(40);

			driver.findElement(ProductDetailsPage.lnkRatingAndReviewExpand).click();
			Thread.sleep(5000);

			if (driver.findElement(ProductDetailsPage.lnkZoomModalPDP).isDisplayed()) {
				report.updateTestLog("Zoom Functionality Validation", "Zoom Functionality validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Zoom Functionality Validation", "Zoom Functionality validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Zoom Functionality", "Exception is " + e, Status.FAIL);
		}

	}

	/******************************************************************
	 * Validate Online Buy Price Spider
	 *****************************************************/

	public void validateOnlinePriceSpider() {

		try {

			String productName = driver.findElement(ProductDetailsPage.lblProductName).getText();

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnWhereToBuy, 30);
			driver.findElement(ProductDetailsPage.btnWhereToBuy).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.divOnlineSeller, 30);
			wdu.waitUntilElementEnabled(ProductDetailsPage.priceSpiderCharbroil, 30);
			driver.findElement(ProductDetailsPage.priceSpiderCharbroil).click();
			//wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 20);

			String productNameOnPriceSpider = driver.findElement(ProductDetailsPage.lblProductNameOfPriceSpider).getText();

			if (productName.contains(productNameOnPriceSpider)) {
				report.updateTestLog("Validate Online Price Spider", "Model Number matched", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Online Price Spider", "Model Number is not matched",
						Status.PASS);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating online Price spider", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/*************************************
	 * To validate also in this series section
	 *********************************************************/

	public void validateAlsoInThisSeriesSection() {

		try {

			wdu.waitUntilPageReadyStateComplete(30);

			if (driver.findElement(ProductDetailsPage.lblAlsoInThisSeries).isDisplayed()) {

				List<WebElement> products = driver.findElements(ProductDetailsPage.alsoInThisSeriesElements);

				if (products.size() > 0) {
					report.updateTestLog("Validate Also in This Series",
							"Validation of also in this series is successful", Status.PASS);
				}

				else {
					report.updateTestLog("Validate Also in This Series",
							"No products found in Also in this series section", Status.PASS);
				}
			}

			else {
				report.updateTestLog("Validate Also in This Series", "Also in this series header is not present",
						Status.FAIL);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating also in this series", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	public void validateWarrantyInGuideManual() {
		try {

			/*
			 * //check register, warranty, support links List<WebElement> guideElements =
			 * driver.findElements(HomePage.linkGuideForPartsName); for (WebElement
			 * webElement : guideElements) { String text = webElement.getText();
			 * webElement.click(); Thread.sleep(1000);
			 * report.updateTestLog("Find A Part result validation",
			 * "Clicked on Guide section link - "+text, Status.DONE); String currUrl =
			 * driver.getCurrentUrl(); if(currUrl.contains(text))
			 * report.updateTestLog("Find A PArt result validation",
			 * "Navigated to URL - "+currUrl, Status.PASS); else
			 * report.updateTestLog("Find A PArt result validation",
			 * "Navigated to URL - "+currUrl, Status.FAIL);
			 * 
			 * driver.navigate().back(); }
			 */

			// check register, warranty, support links

			List<WebElement> guideElements = driver.findElements(HomePage.linkGuideForPartsName);
			int size = guideElements.size();
			for (int i = 0; i < size; i++) {
				gc.clickOnElementByJScript(driver.findElement(ProductDetailsPage.linkExpandGuidesManuals));
				Thread.sleep(1000);
				report.updateTestLog("Validate warranty in PDP Guide Manual",
						"Clicked on the expansion link of Guide and Manual", Status.DONE);

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
					expectedUrl = "support.charbroil.com/help";

				if (currUrl.contains(expectedUrl))
					report.updateTestLog("Find A Part result validation", "Navigated to URL - " + currUrl, Status.PASS);
				else
					report.updateTestLog("Find A Part result validation", "Navigated to URL - " + currUrl, Status.FAIL);

				driver.navigate().back();
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in warranty validation in Guide And Manual section",
					"Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void validateWarningInsideSpecification() {
		try {
			Thread.sleep(2000);
			driver.findElement(ProductDetailsPage.lnkSpecificationsPDP).click();
			report.updateTestLog("Warning inside specification validation", "Clicked on Specifications link",
					Status.DONE);
			Thread.sleep(1000);
			if (driver.findElement(ProductDetailsPage.lblWarning).isDisplayed())
				report.updateTestLog("Warning inside specification validation",
						"Warning label is displayed inside Specifications section", Status.PASS);
			else
				report.updateTestLog("Warning inside specification validation",
						"Warning label is not displayed inside Specifications section", Status.FAIL);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in warning message validation inside specifications",
					"Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/**************************************************
	 * CHARBROIL EUROPE SITE
	 *******************************************************************************************/
	/*****************************************************************************************************************************************************************/

	/***********************************************
	 * Validate Description Section
	 *******************************************************************************/
	public void validatePDPDescription_EU() {

		try {

			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductDescription, 20);

			if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
				report.updateTestLog("Product Description Validation", "Product Description validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Product Description Validation",
						"Product Description validation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Product Description", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************************************************/

	/***********************************************
	 * Validate Model Number Section
	 *******************************************************************************/
	public void validatePDPModelNumber_EU() {

		try {

			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 20);

			if (driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()) {
				report.updateTestLog("Product Model Number Validation", "Product Model Number validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Product Model Number Validation",
						"Product Model Number validation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Product Model Number", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************************************************/

	/***********************************************
	 * Validate Product Header Section
	 *******************************************************************************/
	public void validateProductHeader_EU() {

		try {

			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 20);

			if (driver.findElement(ProductDetailsPage.lblProductHeader).isDisplayed()) {
				report.updateTestLog("Product Header Validation", "Product Header validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Product Header Validation", "Product Header validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Product Header", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************************************************/

	/***********************************************
	 * Validate Product Header Section
	 *******************************************************************************/
	public void validateSupportPage_EU() {

		try {

			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductDetailsPage.lnkSupport_EU, 20);
			driver.findElement(ProductDetailsPage.lnkSupport_EU).click();
			wdu.waitUntilPageReadyStateComplete(50);

			List<WebElement> divsSupport = driver.findElements(ProductDetailsPage.divsSupportSection);

			if (divsSupport.size() > 0) {
				report.updateTestLog("Support Page Validation", "Support Page validation is successful", Status.PASS);
			}

			else {
				report.updateTestLog("Support Page Validation", "Support Page validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Support Page", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************************************************/

	/**************************************
	 * Go to Europe URLS
	 ******************************************************************************/
	public void goToURL_EU() {

		try {

			String euURL = dataTable.getData("General_Data", "URL_EU");
			String frURL = dataTable.getData("General_Data", "URL_FR");
			String deURL = dataTable.getData("General_Data", "URL_DE");
			String dkURL = dataTable.getData("General_Data", "URL_DK");

			String AppURL = properties.getProperty("ApplicationUrl");
			if (AppURL.contains("http://www.charbroil.eu")) {
				driver.get(euURL);
			}

			else if (AppURL.contains("http://www.charbroil.fr")) {
				driver.get(frURL);
			} else if (AppURL.contains("http://www.charbroil.de")) {
				driver.get(deURL);
			} else if (AppURL.contains("http://www.charbroil.dk")) {
				driver.get(dkURL);
			}

			wdu.waitUntilPageReadyStateComplete(30);
			report.updateTestLog("URL Navigation", "Navigation to URL is successful", Status.PASS);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception loading the webpage", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/******************************************************************
	 * Validate Tips Section
	 *******************************************************************************/
	public void validateTipsSublinkSection() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			wdu.mouseHoverJScript(driver.findElement(ProductDetailsPage.lnkHeaderMenuTips));
			Thread.sleep(2000);

			List<WebElement> sublinks = driver.findElements(ProductDetailsPage.sublnksHeaderMenuTips);
			int sublinkNumber = sublinks.size();
			int actualSubLinkNumbers = sublinkNumber / 2;

			for (int i = 1; i < sublinkNumber; i = i + 2) {

				wdu.mouseHoverJScript(driver.findElement(ProductDetailsPage.lnkHeaderMenuTips));
				Thread.sleep(2000);
				String linkText = driver
						.findElement(By.xpath("(" + ProductDetailsPage.sublnksHeaderMenuTipsText + ")[" + i + "]"))
						.getText();

				driver.findElement(By.xpath("(" + ProductDetailsPage.sublnksHeaderMenuTipsText + ")[" + i + "]"))
						.click();
				wdu.waitUntilPageReadyStateComplete(40);

				wdu.waitUntilElementEnabled(ProductDetailsPage.lblTipsLinkPageHeader, 30);
				String pageTitle = driver.findElement(ProductDetailsPage.lblTipsLinkPageHeader).getText();

				if (pageTitle.equalsIgnoreCase(linkText)) {
					report.updateTestLog("Tips Sublink Validation",
							"Tips Sublink validation is successful. " + "Total Sublinks available: "
									+ actualSubLinkNumbers + ". Sublink " + linkText
									+ "has landed to next page with page header " + pageTitle,
							Status.PASS);
				}

				else {
					report.updateTestLog("Tips Sublink Validation", "Tips Sublink validation is not successful",
							Status.FAIL);
				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Tips Sublink Page", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Tips Section
	 *******************************************************************************/
	public void validateTipsPageValidation() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			wdu.mouseHoverJScript(driver.findElement(ProductDetailsPage.lnkHeaderMenuTips));
			Thread.sleep(2000);

			List<WebElement> sublinks = driver.findElements(ProductDetailsPage.sublnksHeaderMenuTips);
			int sublinkNumber = sublinks.size();
			int actualSubLinkNumbers = sublinkNumber / 2;

			driver.findElement(ProductDetailsPage.lnkHeaderMenuTips).click();
			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(2000);

			List<WebElement> sublinksSections = driver.findElements(ProductDetailsPage.divsTipsPage);
			int sectionNumber = sublinksSections.size();

			// wdu.waitUntilElementEnabled(ProductDetailsPage.lblTipsLinkPageHeader, 30);

			if (actualSubLinkNumbers == sectionNumber) {
				report.updateTestLog(
						"Tips Validation", "Tips page validation is successful. Sublink numbers: "
								+ actualSubLinkNumbers + ". Sublink section numbers available is: " + sectionNumber,
						Status.PASS);
			}

			else {
				report.updateTestLog("Tips Validation", "Tips validation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Tips Sublink Page", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate why Charbroil url
	 *******************************************************************************/
	public void validateWhyCharBroil() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductDetailsPage.whyCharBroilBreadCrumb_1, 30);

			if (wdu.objectExists(ProductDetailsPage.whyCharBroilBreadCrumb_1)
					&& wdu.objectExists(ProductDetailsPage.whyCharBroilBreadCrumb_2)
					&& wdu.objectExists(ProductDetailsPage.whyCharBroilHeroImage)) {

				report.updateTestLog("Why CharBroil Validation", "Why CharBroil page validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Why CharBroil Validation", "Why CharBroil page validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Why CharBroil Page", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate promotion policy URL
	 *******************************************************************************/
	public void validatePromotionPolicyPage() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			// wdu.waitUntilElementEnabled(ProductDetailsPage.lblPromotionShippingHeader,
			// 30);

			if (wdu.objectExists(ProductDetailsPage.lblPromotionPolicyDiscountDetails)) {

				if (wdu.objectExists(ProductDetailsPage.lblPromotionShippingHeader)
						|| wdu.objectExists(ProductDetailsPage.lblPromotionShippingHeaderDK)) {
					if (wdu.objectExists(ProductDetailsPage.lblPromotionGeneralPricingTermHeader)
							|| wdu.objectExists(ProductDetailsPage.lblPromotionGeneralPricingTermHeaderDK)) {
						report.updateTestLog("Promotion Policy Validation",
								"Promotion Policy page validation is successful", Status.PASS);

						if (wdu.objectExists(ProductDetailsPage.lblPromotionShippingDetails)
								|| wdu.objectExists(ProductDetailsPage.lblPromotionShippingDetailsDK)) {
							report.updateTestLog("Promotion Policy Validation", "Shipping Details Section is displayed",
									Status.PASS);
						}

						else {
							report.updateTestLog("Promotion Policy Validation",
									"Shipping Details Section is not displayed", Status.FAIL);
						}

					} else {
						report.updateTestLog("Promotion Policy Validation",
								"General Pricing Term Header is not displayed", Status.FAIL);
					}
				}

				else {
					report.updateTestLog("Promotion Policy Validation", "Shipping HEader is not displayed",
							Status.FAIL);
				}

			}

			else {
				report.updateTestLog("Promotion Policy Validation",
						"Promotion Policy page validation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Promotion Policy Page", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Bread Crumb PDP
	 *******************************************************************************/
	public void validateBreadCrumbs_EU() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductDetailsPage.brdcmbFirst, 30);

			if (wdu.objectExists(ProductDetailsPage.brdcmbFirst) && wdu.objectExists(ProductDetailsPage.brdcmbSecond)
					&& wdu.objectExists(ProductDetailsPage.brdcmbThird)) {

				report.updateTestLog("Bread Crumb Validation", "Bread Crumb validation is successful", Status.PASS);
			}

			else {
				report.updateTestLog("Bread Crumb Validation", "Bread Crumb validation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Bread Crumb", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Rating section in PDP
	 *******************************************************************************/
	public void validateRatingSectionPDP_EU() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			Thread.sleep(3000);
			if (wdu.objectExists(ProductDetailsPage.lblSectionRatingAndReview)) {

				report.updateTestLog("Rating Section Validation", "Rating Section validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Rating Section Validation", "Rating Section validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Rating Section", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Frequently Bought Together section
	 *****************************************************/

	public void validateFrequentlyBoughtSection() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblFrequentlyBoughtTogether, 30);
			if (driver.findElement(ProductDetailsPage.lblFrequentlyBoughtTogether).isDisplayed()) {
				report.updateTestLog("Validate Frequently Bought Together Section",
						"Frequently Bought Together Section is displayed as expected", Status.PASS);
				List<WebElement> listOfElements = driver.findElements(ProductDetailsPage.lstContentBoughtTogether);
				System.out.println(listOfElements.size());
				if (listOfElements.size() == 3)
					report.updateTestLog("Validate Frequently Bought Together Section",
							"Number of products in frequently bought together section is : " + listOfElements.size(),
							Status.PASS);
				else
					report.updateTestLog("Validate Frequently Bought Together Section",
							"Product count mismatch in frequently bought together section ", Status.FAIL);

				if (driver.findElement(ProductDetailsPage.chkFrequentlyBoughtTogetherItem).isSelected())
					report.updateTestLog("Validate Frequently Bought Together Section",
							"Checkboxes in frequently bought section are all selected", Status.PASS);
				else
					report.updateTestLog("Validate Frequently Bought Together Section",
							"Checkboxes in frequently bought section are not selected", Status.FAIL);

			} else {
				report.updateTestLog("Validate Frequently Bought Together Section",
						"Issues in Frequently bought together section", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Frequently Bought Together Section", "Exception is " + e,
					Status.FAIL);
		}

	}

	/*************************************
	 * Proceed to checkout with prmo codes
	 *********************************************************/

	public void proceedToCheckoutWithPromoCodes() {
		String couponcode = dataTable.getData("General_Data", "CouponCode");
		String discountdetails = null;

		try {

			driver.findElement(ProductDetailsPage.btnViewCartCheckoutPDP).click();
			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			if (driver.findElement(CheckOutPage.btnProceedToCheckout).isDisplayed()) {

				Thread.sleep(3000);
				if (driver.findElement(CheckOutPage.txtCouponCode).isDisplayed()) {
					report.updateTestLog("Check Out Page", "Coupon code text field is displayed as expected",
							Status.PASS);
					driver.findElement(CheckOutPage.txtCouponCode).sendKeys(couponcode);
					report.updateTestLog("Check Out Page", "Coupon code : " + couponcode + " entered", Status.DONE);
					driver.findElement(CheckOutPage.btnApplyCoupon).click();
					report.updateTestLog("Check Out Page", "Apply Coupon button is clicked", Status.DONE);
					Thread.sleep(3000);
					if (driver.findElement(CheckOutPage.lblDiscountDetails).isDisplayed()) {
						String msg = driver.findElement(CheckOutPage.lblCouponSuccessMsg).getText();
						report.updateTestLog("Check Out Page", msg, Status.PASS);
						discountdetails = driver.findElement(CheckOutPage.lblDiscountDetails).getText();
						report.updateTestLog("Check Out Page", "Discount details displayed : " + discountdetails,
								Status.DONE);
					} else {
						report.updateTestLog("Check Out Page", "Promo /Discount not applied", Status.FAIL);
					}
				} else {
					report.updateTestLog("Check Out Page", "Coupon code text field is not displayed as expected",
							Status.FAIL);
				}

				gc.scrollToElement(CheckOutPage.btnProceedToCheckout);
				driver.findElement(CheckOutPage.btnProceedToCheckout).click();
				wdu.waitUntilElementEnabled(CheckOutPage.txtFirstname, 30);

				if (driver.findElement(CheckOutPage.txtFirstname).isDisplayed()) {
					report.updateTestLog("Proceed to Check out", "Proceed to checkout done", Status.PASS);
				}

				else {
					report.updateTestLog("Proceed to Check out", "Proceed to check out not done", Status.FAIL);
				}

			}

			else {
				report.updateTestLog("Proceed to Check out", "Proceed to check out button is not displayed",
						Status.FAIL);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in proceeding to checkout", "Exception is " + e, Status.FAIL);
		}

	}

}
