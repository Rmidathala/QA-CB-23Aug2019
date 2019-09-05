package businesscomponents;

import java.util.List;

import org.openqa.selenium.WebElement;
import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.CheckOutPage;
import uimap.HomePage;
import uimap.ProductDetailsPage;
import uimap.ShoppingCartPage;

public class ShoppingCartComponents extends ReusableLibrary {

	WebDriverUtil wdu = new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public ShoppingCartComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/*********************************************************
	 * Click Shopping Cart Icon
	 ***************************************************************************************/

	public void clickShoppingCartIcon() {

		try {

			wdu.waitUntilElementEnabled(HomePage.lnkCart, 30);

			driver.findElement(HomePage.lnkCart).click();

			wdu.waitUntilElementEnabled(ShoppingCartPage.lblShoppingCart, 30);

			if (driver.findElement(ShoppingCartPage.lblShoppingCart).isDisplayed()) {
				report.updateTestLog("Click Shopping Cart", "Clicking on Shopping cart icon is Successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Click Shopping Cart", "Clicking on Shopping cart icon is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in clicking on Shopping Cart Icon", "Exception is " + e, Status.FAIL);
		}

	}

	/*******************************************************************************************************************************************************************************/

//*********************************************************** Validate Breadcumb in Shopping cart page ****************************************************************/

	public void validateShoppingCartBreadcumb() {

		try {

			wdu.waitUntilElementEnabled(CheckOutPage.lnkBreadCrumbHome, 30);

			driver.findElement(CheckOutPage.lnkBreadCrumbHome).click();

			wdu.waitUntilElementEnabled(CheckOutPage.imgHeroHome, 30);

			if (driver.findElement(CheckOutPage.imgHeroHome).isDisplayed()) {
				report.updateTestLog("Validate Shopping Cart Breadcumb",
						"Validating Shopping cart Breadcumb is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Click Shopping Cart", "Validating Shopping cart Breadcumb is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Shopping Cart breadcumb", "Exception is " + e, Status.FAIL);
		}

	}

	/***********************************************************************************************************************************************************************/

//*********************************************************** Validate Continue shopping button in Shopping cart page ****************************************************************/

	public void validateContinueShoppingButton() {

		try {

			wdu.waitUntilElementEnabled(ShoppingCartPage.continueShopping, 30);

			driver.findElement(ShoppingCartPage.continueShopping).click();

			wdu.waitUntilElementEnabled(CheckOutPage.imgHeroHome, 30);

			if (driver.findElement(CheckOutPage.imgHeroHome).isDisplayed()) {
				report.updateTestLog("Validate Continue Shopping button",
						"Validating Continue Shopping button is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Continue Shopping button",
						"Validating Continue Shopping button  is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Continue shopping Button", "Exception is " + e, Status.FAIL);
		}

	}

	/**************************************************************************************************************************************************************************************/

//*********************************************************** Validate Continue shopping button in Shopping cart page ****************************************************************/

	public void validateProceedCheckoutButton() {

		try {

			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			driver.findElement(CheckOutPage.btnProceedToCheckout).click();

			wdu.waitUntilElementEnabled(CheckOutPage.lblCheckoutHeader, 30);

			if (driver.findElement(CheckOutPage.lblCheckoutHeader).isDisplayed()) {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button  is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Proceed Checkout Button", "Exception is " + e, Status.FAIL);
		}

	}

	/**************************************************************************************************************************************************************************************/

//*********************************************************** Validate Continue shopping button in Shopping cart page ****************************************************************/

	public void validateProductinShoppingCart() {

		try {

			wdu.waitUntilElementEnabled(ShoppingCartPage.lnkProduct, 30);

			String linkText = driver.findElement(ShoppingCartPage.lnkProduct).getText();
			driver.findElement(ShoppingCartPage.lnkProduct).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 40);

			if (driver.findElement(ProductDetailsPage.lblProductHeader).getText().contains(linkText)) {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button  is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Proceed Checkout Button", "Exception is " + e, Status.FAIL);
		}

	}

	/**************************************************************************************************************************************************************************************/

//*********************************************************** Validate Continue shopping button in Shopping cart page ****************************************************************/

	public void validateProductQuantityinShoppingCart() {

		try {

			String qty = dataTable.getData("General_Data", "Quantity");

			wdu.waitUntilElementEnabled(ShoppingCartPage.selectProductQuantity, 30);

			gc.selectDropDown(ShoppingCartPage.selectProductQuantity, qty);

			Thread.sleep(7000);

//						int quantity = Integer.parseInt(qty);
//						
//						
//						
//						
//						
//						
//						
//						String sPP = driver.findElement(ShoppingCartPage.lblSingleItemPrice).getText();
//						
//						String singleProductPrice1 = sPP.substring(1);
//						
//						String singleProductPrice = singleProductPrice1.trim();
//						
//						int singleProdPrice = Integer.parseInt(singleProductPrice);
//						
//						
//						
//						
//						String sT = driver.findElement(ShoppingCartPage.lblSubTotal).getText();
//						
//						String subTotal1 = sT.substring(1);
//						
//						String subTotal = subTotal1.trim();
//						
//						int subTotalFinal = Integer.parseInt(subTotal);

			String selected = gc.getFirstSelectedValue(ShoppingCartPage.selectProductQuantity);

			if (selected.contains(qty)) {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button  is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Proceed Checkout Button", "Exception is " + e, Status.FAIL);
		}

	}

	/**************************************************************************************************************************************************************************************/

//*********************************************************** Validate delete product in Shopping cart page ********************************************************************/

	public void validateDeleteProductShoppingCart() {

		try {

			wdu.waitUntilElementEnabled(ShoppingCartPage.lnkDeleteProduct, 30);

			driver.findElement(ShoppingCartPage.lnkDeleteProduct).click();

			wdu.waitUntilElementEnabled(ShoppingCartPage.lblEmptyShoppingCart, 40);

			if (driver.findElement(ShoppingCartPage.lblEmptyShoppingCart).isDisplayed()) {
				report.updateTestLog("Validate Delete Product", "Validating Delete product option is Successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Validate Delete Product", "Validating Delete product option is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating delete product option in shopping cart", "Exception is " + e,
					Status.FAIL);
		}

	}

	/********************************************************************************************************************************************************************************/

//*********************************************************** Validate delete product in Shopping cart page ****************************************************************/

	public void validateEstimateShipping() {

		try {

			String country = "US";
			String state = "55";
			String postalCode = "31902";
			String city = "Columbus";

			wdu.waitUntilElementEnabled(ShoppingCartPage.selectCountry, 30);

			gc.selectDropDown(ShoppingCartPage.selectCountry, country);

			Thread.sleep(3000);
			gc.selectDropDown(ShoppingCartPage.selectState, state);
			Thread.sleep(3000);
			driver.findElement(ShoppingCartPage.selectCity).sendKeys(city);
			driver.findElement(ShoppingCartPage.selectPostalCode).sendKeys(postalCode);

			driver.findElement(ShoppingCartPage.btnCalculate).click();

			wdu.waitUntilElementVisible(ShoppingCartPage.lblShippingMethodList, 40);

			if (driver.findElement(ShoppingCartPage.lblShippingMethodList).isDisplayed()) {
				report.updateTestLog("Validate Estimate Shipping", "Validating Estimate Shipping is Successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Validate Estimate Shipping", "Validating Estimate Shipping is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Estimate Shipping in shopping cart", "Exception is " + e,
					Status.FAIL);
		}

	}

	/*****************************************************************************************************************************************************************************/

//*********************************************************** Validate Continue shopping button in Shopping cart page ****************************************************************/

	public void validateProductQuantityinShoppingCartWithPDP() {

		try {

			String qty = dataTable.getData("General_Data", "Quantity");

			wdu.waitUntilElementEnabled(ShoppingCartPage.selectProductQuantity, 30);

			Thread.sleep(7000);

			String selected = gc.getFirstSelectedValue(ShoppingCartPage.selectProductQuantity);

			if (selected.contains(qty)) {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Validate Proceed Checkout button",
						"Validating Proceed Checkout button  is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Proceed Checkout Button", "Exception is " + e, Status.FAIL);
		}

	}

	/*********************************************************
	 * Click Shopping Cart Icon
	 ***************************************************************************************/

	public void validateShoppingCart() {

		try {

			wdu.waitUntilElementEnabled(HomePage.lnkCart, 30);
			int prodcount = Integer.parseInt(driver.findElement(HomePage.lnkCart).getText());
			driver.findElement(HomePage.lnkCart).click();
			wdu.waitUntilElementEnabled(ShoppingCartPage.lblShoppingCart, 30);
			if (driver.findElement(ShoppingCartPage.lblShoppingCart).isDisplayed()) {
				report.updateTestLog("Click Shopping Cart", "Clicking on Shopping cart icon is Successful",
						Status.PASS);
				List<WebElement> rows = driver.findElements(ShoppingCartPage.ShoppingCartCount);
				System.out.println(rows.size());
				if (rows.size() == prodcount) {
					report.updateTestLog("Shopping Cart", "Number of items in Shopping cart : " + prodcount,
							Status.PASS);
				} else {
					report.updateTestLog("Shopping Cart", "Product count mismatch in shopping cart ", Status.FAIL);
				}

				if (driver.findElement(ShoppingCartPage.imgFirstProduct).isDisplayed()) {
					String aligntext = driver.findElement(ShoppingCartPage.imgFirstProduct).getCssValue("text-align")
							.toLowerCase();
					if (aligntext.contains("left"))
						report.updateTestLog("Shopping Cart",
								"Product images are aligned in the " + aligntext + " side of the page", Status.PASS);
					else
						report.updateTestLog("Shopping Cart", "Product images are anot aligned properly", Status.FAIL);
				}

			}

			else {
				report.updateTestLog("Click Shopping Cart", "Clicking on Shopping cart icon is not Successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in clicking on Shopping Cart Icon", "Exception is " + e, Status.FAIL);
		}

	}

	/*******************************************************************************************************************************************************************************/

}
