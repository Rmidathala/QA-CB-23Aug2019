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
import uimap.MyAccountPage;
import uimap.ProductDetailsPage;
import uimap.ShoppingCartPage;

public class CheckOutComponents extends ReusableLibrary {

	WebDriverUtil wdu = new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public CheckOutComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/*************************************
	 * Adding Billing and Shippng Address
	 *********************************************************/

	public void addAddressToBillingShipping() {

		try {

			String firstname = dataTable.getData("General_Data", "FirstName");
			String lastname = dataTable.getData("General_Data", "LastName");
			String company = dataTable.getData("General_Data", "Company");
			String email = dataTable.getData("General_Data", "Email");
			String address1 = dataTable.getData("General_Data", "Address1");
			String zip = dataTable.getData("General_Data", "Zip");
			String city = dataTable.getData("General_Data", "City");
			String country = dataTable.getData("General_Data", "Country");
			String state = dataTable.getData("General_Data", "State");
			String telephone = dataTable.getData("General_Data", "Telephone");

			driver.findElement(CheckOutPage.txtFirstname).sendKeys(firstname);
			driver.findElement(CheckOutPage.txtLastname).sendKeys(lastname);
			driver.findElement(CheckOutPage.txtCompany).sendKeys(company);
			driver.findElement(CheckOutPage.txtEmail).sendKeys(email);
			driver.findElement(CheckOutPage.txtAddress1).sendKeys(address1);
			driver.findElement(CheckOutPage.txtZip).sendKeys(zip);
			driver.findElement(CheckOutPage.txtCity).sendKeys(city);
			driver.findElement(CheckOutPage.txtCountry).sendKeys(country);
			// driver.findElement(CheckOutPage.txtState).sendKeys(state);
			gc.selectDropDown(CheckOutPage.txtState, state);
			driver.findElement(CheckOutPage.txtTelephone).sendKeys(telephone);
			// Thread.sleep(5000);

			// Point p = driver.findElement(CheckOutPage.btnContinue).getLocation();

			// List<WebElement> element = driver.findElements(CheckOutPage.btnContinue);
			// int sz = element.size();
			// WebElement el;
			// foreach(el in element)
			// {
			//
			// }
			// Actions ac = new Actions((WebDriver) driver);
			// ac.moveToElement(element).click().perform();
			// driver.findElement(CheckOutPage.btnContinue);

			try {
				driver.findElement(CheckOutPage.btnContinue).click();
			} catch (Exception e) {
				System.out.println(e);
			}

			wdu.waitUntilPageReadyStateComplete(40);
			wdu.waitUntilElementEnabled(CheckOutPage.lblShippingMethod, 15);

			if (driver.findElement(CheckOutPage.lblShippingMethod).isDisplayed()) {
				report.updateTestLog("Address Adding", "Address is added Successfully", Status.PASS);
			}

			else {
				report.updateTestLog("Address Adding", "Address is not added Successfully", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in adding Address", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * Select Shipping Method
	 *********************************************************/

	public void selectShippingMethod() {

		try {

			String shippingMethod = dataTable.getData("General_Data", "ShippingMethod");
			gc.scrollToElement(CheckOutPage.lblShippingMethodShippingPge);
			wdu.waitUntilElementEnabled(CheckOutPage.btnContinueShippingMethod, 15);

			if (wdu.objectExists(By
					.xpath(CheckOutPage.radioShippingMethod + "'" + shippingMethod + "')]/preceding-sibling::input"))) {

				driver.findElement(By.xpath(
						CheckOutPage.radioShippingMethod + "'" + shippingMethod + "')]/preceding-sibling::input"))
						.click();
			}
			driver.findElement(CheckOutPage.btnContinueShippingMethod).click();
			wdu.waitUntilElementEnabled(CheckOutPage.lblPaymentInformation, 15);

			if (driver.findElement(CheckOutPage.lblPaymentInformation).isDisplayed()) {
				report.updateTestLog("Shipping Method", "shipping method selected successfully", Status.PASS);
			} else {
				report.updateTestLog("Shipping Method", "shipping method not selected", Status.FAIL);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting Shipping Method", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * Adding Billing Information
	 *********************************************************/

	public void addingBillingInformation() {

		try {

			String cardnumber = dataTable.getData("General_Data", "CreditCardNumber");
			//String cardtype = dataTable.getData("General_Data", "CreditCardType");
			String verificationNumber = dataTable.getData("General_Data", "CreditCardVerificationNumber");
			String expirationMonth = dataTable.getData("General_Data", "CCExpirationMonth");
			String expirationYear = dataTable.getData("General_Data", "CCExpirationYear");

			driver.findElement(CheckOutPage.radioCreditCard).click();
			Thread.sleep(1000);
			driver.findElement(CheckOutPage.btnContinuePayment).click();
			wdu.waitUntilPageReadyStateComplete(20);
			driver.switchTo().frame(driver.findElement(CheckOutPage.iframeCreditCardInput))	;
			wdu.waitUntilElementLocated(CheckOutPage.txtCreditCardNumber, 15);
			driver.findElement(CheckOutPage.txtCreditCardNumber).sendKeys(cardnumber);
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			// driver.findElement(CheckOutPage.selectCreditCardType).sendKeys(cardtype);

			//gc.selectDropDown(CheckOutPage.selectCreditCardType, cardtype);
			//Thread.sleep(1000);
			driver.findElement(CheckOutPage.txtVerificationNumber).sendKeys(verificationNumber);
			Thread.sleep(1000);
			gc.selectDropDown(CheckOutPage.selectExpirationMonth, expirationMonth);
			Thread.sleep(1000);
			// driver.findElement(CheckOutPage.selectExpirationMonth).sendKeys(expirationMonth);
			// driver.findElement(CheckOutPage.selectExpirationYear).sendKeys(expirationYear);
			gc.selectDropDown(CheckOutPage.selectExpirationYear, expirationYear);
			
			gc.scrollToElement(CheckOutPage.btnPlaceOrder);
			wdu.waitUntilElementEnabled(CheckOutPage.btnPlaceOrder, 15);
			if (driver.findElement(CheckOutPage.btnPlaceOrder).isDisplayed()) {
				report.updateTestLog("Billing Information", "Billing information is added successfully", Status.PASS);
			}

			else {
				report.updateTestLog("Billing Information", "Billing information is not added", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in setting payment method", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * Placing order
	 *********************************************************/

	public void placeOrder() {

		try {

			Thread.sleep(5000);
			wdu.waitUntilElementEnabled(CheckOutPage.btnPlaceOrder, 40);

			driver.findElement(CheckOutPage.btnPlaceOrder).click();

			wdu.waitUntilPageReadyStateComplete(20);

			wdu.waitUntilElementEnabled(CheckOutPage.lblConfirmPurchase, 50);

			if (driver.findElement(CheckOutPage.lblConfirmPurchase).isDisplayed()) {

				String ordernumberlbl = driver.findElement(CheckOutPage.lblOrderNumber).getText();
				String orderNumber = ordernumberlbl.substring(ordernumberlbl.indexOf(":") + 2);

				report.updateTestLog("Place Order",
						"Order has been placed Successfully with the order number: " + orderNumber, Status.PASS);
			}
			else {
				report.updateTestLog("Place Order", "Placing order is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in clicking place order button", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * login with registered user while checkout
	 *********************************************************/

	public void loginRegisteredUserCheckout() {

		try {

			String uname = dataTable.getData("General_Data", "Username");
			String password = dataTable.getData("General_Data", "Password");
			Thread.sleep(3000);
			gc.scrollToElement(CheckOutPage.lnkLoginFromCheckout);
			wdu.waitUntilElementVisible(CheckOutPage.lnkLoginFromCheckout, 50);
			driver.findElement(CheckOutPage.lnkLoginFromCheckout).click();
			wdu.waitUntilElementVisible(CheckOutPage.txtUserNameCheckout, 50);

			driver.findElement(CheckOutPage.txtUserNameCheckout).sendKeys(uname);
			Thread.sleep(1000);
			driver.findElement(CheckOutPage.txtPasswordCheckout).sendKeys(password);
			driver.findElement(CheckOutPage.btnLoginCheckout).click();
			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(30);
			gc.scrollToElement(ShoppingCartPage.lblCheckout);
			//wdu.waitUntilElementEnabled(ShoppingCartPage.lblCheckout, 50);

			if (driver.findElement(ShoppingCartPage.lblCheckout).isDisplayed()) {
				report.updateTestLog("login Checkout", "Login while checkout with registered user is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("login Checkout", "Login while checkout with registered user is not successful",
						Status.FAIL);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in login with registered user", "Exception is " + e, Status.FAIL);
		}
	}

	/*************************************************************************************************************************/

	/*************************************
	 * Setting Billing Info using Paypal
	 *********************************************************/

	public void billingInfoUsingPaypal() {

		try {

			wdu.waitUntilElementEnabled(CheckOutPage.radioPayPal, 30);
			driver.findElement(CheckOutPage.radioPayPal).click();
			driver.findElement(CheckOutPage.btnContinuePayment).click();

			// wdu.waitUntilPageLoaded(15);

			Thread.sleep(12000);

			wdu.waitUntilPageReadyStateComplete(50);
			String urlPaypal = driver.getCurrentUrl();
			if (urlPaypal.contains("paypal")) {
				report.updateTestLog("Paypal Payment",
						"Payment using Paypal method navigated to paypal site successfully", Status.PASS);
			}

			else {
				report.updateTestLog("Paypal Payment",
						"Payment using Paypal method not navigated to paypal site successfully", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in using paypal method", "Exception is " + e, Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/******************************************************************
	 * Validate Checkout Page BreadCumb
	 *****************************************************/

	public void validateCheckoutPageBreadCumb() {

		try {

			wdu.waitUntilElementEnabled(CheckOutPage.lnkBreadCrumbHome, 30);
			driver.findElement(CheckOutPage.lnkBreadCrumbHome).click();

			// wdu.waitUntilPageLoaded(15);
			wdu.waitUntilElementEnabled(CheckOutPage.imgHeroHome, 30);

			if (driver.findElement(CheckOutPage.imgHeroHome).isDisplayed()) {
				report.updateTestLog("Checkout page Breadcumb Validation",
						"Validation of Checkout Page Breadcumb is Successful", Status.PASS);
			}

			else {
				report.updateTestLog("Checkout page Breadcumb Validation",
						"Validation of Checkout Page Breadcumb is not Successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Checkout page breadcumb", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Billing Info alignment guest user
	 *****************************************************/

	public void validateBillingInfoAlignmentGuestUser() {

		try {

			driver.findElement(CheckOutPage.radioCreditCard).click();
			driver.findElement(CheckOutPage.btnContinuePayment).click();
			driver.switchTo().frame(driver.findElement(CheckOutPage.iframeCreditCardInput))	;
			wdu.waitUntilElementEnabled(CheckOutPage.txtCreditCardNumber, 15);
			driver.switchTo().defaultContent();
			//wdu.waitUntilElementEnabled(CheckOutPage.selectCreditCardType, 15);
			wdu.waitUntilElementEnabled(CheckOutPage.selectExpirationMonth, 15);
			wdu.waitUntilElementEnabled(CheckOutPage.selectExpirationYear, 15);
			report.updateTestLog("Validate Billing info alignment",
					"Validation of billing info alignment is Successful", Status.PASS);
			// gc.validateImage(System.getProperty("user.dir") +
			// "\\images\\BillingInfoGuest.png", "Billing Info Page", "Billing Info Image
			// Guest User");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating billing info page alignment", "Exception is " + e,
					Status.FAIL);
		}
		
	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Validate Billing Info alignment registered user
	 *****************************************************/

	public void validateBillingInfoAlignmentRegUser() {

		try {

			driver.findElement(CheckOutPage.radioCreditCard).click();
			driver.findElement(CheckOutPage.btnContinuePayment).click();
			driver.switchTo().frame(driver.findElement(CheckOutPage.iframeCreditCardInput))	;
			wdu.waitUntilElementEnabled(CheckOutPage.txtCreditCardNumber, 15);
			driver.switchTo().defaultContent();
			//wdu.waitUntilElementEnabled(CheckOutPage.selectCreditCardType, 15);
			wdu.waitUntilElementEnabled(CheckOutPage.selectExpirationMonth, 15);
			wdu.waitUntilElementEnabled(CheckOutPage.selectExpirationYear, 15);
			report.updateTestLog("Validate Billing info alignment",
					"Validation of billing info alignment is Successful", Status.PASS);
			// gc.validateImage(System.getProperty("user.dir") +
			// "\\images\\BillingInfoRegisteered.png", "Billing Info Page", "Billing Info
			// Image Registered User");

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating billing info page alignment", "Exception is " + e,
					Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/*************************************
	 * To Add product to Cart
	 *********************************************************/

	public void addProductViewBagCheckout() {

		try {

			driver.findElement(ProductDetailsPage.btnAddtoCartPDP).click();
			wdu.waitUntilElementEnabled(ProductDetailsPage.btnViewCartCheckoutPDP, 30);
			driver.findElement(ProductDetailsPage.btnViewCartCheckoutPDP).click();
			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			if (driver.findElement(CheckOutPage.btnProceedToCheckout).isDisplayed()) {
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
	 * To Add Multi Quantity product to Cart
	 *********************************************************/

	public void addMultipleProductViewBagCheckout() {

		try {

			String qty = dataTable.getData("General_Data", "Quantity");

			gc.selectDropDown(ProductDetailsPage.selectQuantity, qty);

			driver.findElement(ProductDetailsPage.btnAddtoCartPDP).click();
			wdu.waitUntilElementEnabled(ProductDetailsPage.btnViewCartCheckoutPDP, 30);
			driver.findElement(ProductDetailsPage.btnViewCartCheckoutPDP).click();
			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			if (driver.findElement(CheckOutPage.btnProceedToCheckout).isDisplayed()) {
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

	/******************************************************************
	 * Validate Shopping cart Alignment
	 *****************************************************/

	public void validateShoppingCartAlignment() {

		try {

			// wdu.waitUntilElementEnabled(ShoppingCartPage.lblShoppingCart, 15);
			// gc.validateImage(System.getProperty("user.dir") +
			// "\\images\\ShoppingCart.png", "Shopping Cart Page", "Shopping Cart Page
			// Validation");

			wdu.waitUntilElementEnabled(ShoppingCartPage.continueShopping, 30);
			wdu.waitUntilElementEnabled(CheckOutPage.btnProceedToCheckout, 30);

			report.updateTestLog("Shopping Cart Validation", "Shopping cart validation is successful.", Status.PASS);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Shopping cart page alignment", "Exception is " + e,
					Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Continue to Checkout
	 *****************************************************/

	public void continueCheckout() {

		try {

			wdu.waitUntilPageReadyStateComplete(30);

			Thread.sleep(7000);

			wdu.waitUntilElementEnabled(CheckOutPage.btnContinueCheckout, 30);

			Thread.sleep(10000);

			driver.findElement(CheckOutPage.btnContinueCheckout).click();

			wdu.waitUntilPageReadyStateComplete(20);
			wdu.waitUntilElementEnabled(CheckOutPage.lblShippingMethod, 30);

			if (driver.findElement(CheckOutPage.lblShippingMethod).isDisplayed()) {
				report.updateTestLog("Navigation to Shipping Method", "Navigation to shipping method is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("Navigation to Shipping Method", "Navigation to shipping method is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while clicking on continue checkout button", "Exception is " + e,
					Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/******************************************************************
	 * Clear cart with registered user
	 *****************************************************/

	public void clearCart_LoginExistingCustomer() {

		try {

			String email = dataTable.getData("General_Data", "Email");
			String pass = dataTable.getData("General_Data", "Password");

			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilPageReadyStateComplete(15);
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 15);

			Thread.sleep(2000);
			driver.findElement(MyAccountPage.txtEmailReg).sendKeys(email);
			Thread.sleep(2000);
			driver.findElement(MyAccountPage.txtPasswordReg).sendKeys(pass);

			driver.findElement(MyAccountPage.btnLoginRegUser).click();
			wdu.waitUntilPageReadyStateComplete(15);
			gc.scrollToElement(MyAccountPage.lnkAddNewAddress);
			// wdu.waitUntilElementEnabled(MyAccountPage.lnkAddNewAddress, 50);
			if(wdu.objectExists(ShoppingCartPage.cartCount)) {
			gc.scrollToElement(ShoppingCartPage.iconShoppingCart);
			wdu.waitUntilElementEnabled(ShoppingCartPage.iconShoppingCart, 30);
			gc.scrollToElement(ShoppingCartPage.iconShoppingCart);
			driver.findElement(ShoppingCartPage.iconShoppingCart).click();

			wdu.waitUntilPageReadyStateComplete(15);
			wdu.waitUntilElementEnabled(ShoppingCartPage.lblShoppingCart, 30);

			if (wdu.objectExists(ShoppingCartPage.lblEmptyShoppingCart)) {
				report.updateTestLog("Clear ShoppingCart", "Shopping Cart is Empty", Status.PASS);
			}

			else {
				List<WebElement> listItem = driver.findElements(ShoppingCartPage.listSHoopingCartItem);
				int size = listItem.size();
				int i = 0;
				for (i = 0; i < (size-1); i++) {

					wdu.waitUntilElementEnabled(ShoppingCartPage.lnkDeleteFirstProduct, 30);
					if (wdu.objectExists(ShoppingCartPage.lnkDeleteFirstProduct)) {
						driver.findElement(ShoppingCartPage.lnkDeleteFirstProduct).click();
						report.updateTestLog("Clear ShoppingCart", "Product Deletion Successful", Status.PASS);

					}

					else {
						report.updateTestLog("Clear ShoppingCart", "Product Deletion not Successful", Status.FAIL);
					}
				}

				wdu.waitUntilPageReadyStateComplete(20);
				if (wdu.objectExists(ShoppingCartPage.shopicon)) {
					report.updateTestLog("Clear ShoppingCart", "Shopping Cart is Empty", Status.PASS);
				} else {
					report.updateTestLog("Clear ShoppingCart", "Shopping Cart is still not empty", Status.FAIL);
				}

			}
			}else {
				report.updateTestLog("Clear ShoppingCart", "Shopping Cart is Empty", Status.PASS);
			}
			Thread.sleep(1000);

			driver.findElement(MyAccountPage.lnkLogout).click();

			wdu.waitUntilPageReadyStateComplete(15);

			Thread.sleep(8000);

			wdu.waitUntilPageReadyStateComplete(15);

			//wdu.waitUntilElementEnabled(HomePage.lnkMyAccount, 30);
			Thread.sleep(10000);

			wdu.waitUntilPageReadyStateComplete(15);
			if (!wdu.objectExists(MyAccountPage.lnkLogout)) {
				report.updateTestLog("Logout", "Log out successful", Status.PASS);
			}

			else {
				report.updateTestLog("Logout", "Log out is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Clearing Shopping Cart", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/*************************************************************************
	 * Clear Cart
	 ***************************************************************************************/

	public void clearCart() {

		try {
			if(wdu.objectExists(ShoppingCartPage.cartCount)) {
				
			
			wdu.waitUntilElementEnabled(ShoppingCartPage.iconShoppingCart, 30);

			driver.findElement(ShoppingCartPage.iconShoppingCart).click();

			wdu.waitUntilElementEnabled(ShoppingCartPage.lblShoppingCart, 30);

			if (wdu.objectExists(ShoppingCartPage.lblEmptyShoppingCart)) {
				report.updateTestLog("Clear ShoppingCart", "Shopping Cart is Empty", Status.PASS);
			}

			else {
				List<WebElement> listItem = driver.findElements(ShoppingCartPage.listSHoopingCartItem);
				int size = listItem.size();
				int i = 0;
				for (i = 0; i < (size - 1); i++) {

					wdu.waitUntilElementEnabled(ShoppingCartPage.lnkDeleteFirstProduct, 30);
					if (wdu.objectExists(ShoppingCartPage.lnkDeleteFirstProduct)) {
						driver.findElement(ShoppingCartPage.lnkDeleteFirstProduct).click();
						report.updateTestLog("Clear ShoppingCart", "Product Deletion Successful", Status.PASS);

					}

					else {
						report.updateTestLog("Clear ShoppingCart", "Product Deletion not Successful", Status.FAIL);
					}
				}

				wdu.waitUntilPageReadyStateComplete(20);
				if (wdu.objectExists(ShoppingCartPage.shopicon)) {
					report.updateTestLog("Clear ShoppingCart", "Shopping Cart is Empty", Status.PASS);
				} else {
					report.updateTestLog("Clear ShoppingCart", "Shopping Cart is still not empty", Status.FAIL);
				}

			}

		}
			else {
				report.updateTestLog("Clear ShoppingCart", "Shopping Cart is Empty", Status.PASS);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Clearing Shopping Cart", "Exception is " + e, Status.FAIL);
		}

	}

	/**********************************************************************************************************************************************************************/

	/*************************************
	 * login with invalid user while checkout
	 *********************************************************/

	public void loginInvalidUserCheckout() {

		try {

			String uname = dataTable.getData("General_Data", "Username");
			String password = dataTable.getData("General_Data", "Password");

			wdu.waitUntilElementEnabled(CheckOutPage.lnkLoginFromCheckout, 50);
			driver.findElement(CheckOutPage.lnkLoginFromCheckout).click();
			wdu.waitUntilElementEnabled(CheckOutPage.txtUserNameCheckout, 50);

			driver.findElement(CheckOutPage.txtUserNameCheckout).sendKeys(uname);
			Thread.sleep(1000);
			driver.findElement(CheckOutPage.txtPasswordCheckout).sendKeys(password);
			driver.findElement(CheckOutPage.btnLoginCheckout).click();

			Thread.sleep(5000);
			wdu.waitUntilElementEnabled(CheckOutPage.lblErrorMsg, 50);

			if (wdu.objectExists(CheckOutPage.lblErrorMsg)) {
				report.updateTestLog("Invalid user login Checkout",
						"Error message is displayed while trying to login with invalid user", Status.PASS);

				System.out.println();
			}

			else {
				report.updateTestLog("Invalid user login Checkout",
						"Error message is not diplayed while trying to login with invalid user", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Invalid user login with registered user", "Exception is " + e,
					Status.FAIL);
		}

	}

	/*************************************************************************************************************************/

	/*************************************
	 * Validate Price in Checkout
	 *********************************************************/

	public void validateTotalPrice() {

		try {

			String uname = dataTable.getData("General_Data", "Username");
			String password = dataTable.getData("General_Data", "Password");

			wdu.waitUntilElementEnabled(CheckOutPage.lnkLoginFromCheckout, 50);
			driver.findElement(CheckOutPage.lnkLoginFromCheckout).click();
			wdu.waitUntilElementEnabled(CheckOutPage.txtUserNameCheckout, 50);

			driver.findElement(CheckOutPage.txtUserNameCheckout).sendKeys(uname);
			Thread.sleep(1000);
			driver.findElement(CheckOutPage.txtPasswordCheckout).sendKeys(password);
			driver.findElement(CheckOutPage.btnLoginCheckout).click();

			Thread.sleep(5000);
			wdu.waitUntilElementEnabled(CheckOutPage.lblErrorMsg, 50);

			if (wdu.objectExists(CheckOutPage.lblErrorMsg)) {
				report.updateTestLog("Invalid user login Checkout",
						"Error message is displayed while trying to login with invalid user", Status.PASS);

			}

			else {
				report.updateTestLog("Invalid user login Checkout",
						"Error message is not diplayed while trying to login with invalid user", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Invalid user login with registered user", "Exception is " + e,
					Status.FAIL);
		}

	}
	/*************************************************************************************************************************/

}
