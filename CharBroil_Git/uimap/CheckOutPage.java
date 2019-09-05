package uimap;

import org.openqa.selenium.By;

public class CheckOutPage {

	public static final By btnProceedToCheckout = By.xpath("//div[@class='cart__intro-cta']/button[2]");
	public static final By txtFirstname = By.xpath("//*[@id='billing:firstname']");
	public static final By txtLastname = By.xpath("//*[@id='billing:lastname']");
	public static final By txtCompany = By.xpath("//*[@id='billing:company']");
	public static final By txtEmail = By.xpath("//*[@id='billing:email']");
	public static final By txtAddress1 = By.xpath("//*[@id='billing:street1']");
	public static final By txtaddress2 = By.xpath("//*[@id='billing:street2']");
	public static final By txtZip = By.xpath("//*[@id='billing:postcode']");
	public static final By txtCity = By.xpath("//*[@id='billing:city']");
	
	public static final By txtCountry = By.xpath("//*[@id='billing:country_id']");
	
	public static final By txtState = By.xpath("//*[@id='billing:region_id']");
	public static final By txtTelephone = By.xpath("//*[@id='billing:telephone']");
	//public static final By btnContinue = By.xpath("//button");
	public static final By btnContinue = By.xpath("//*[@id='billing-buttons-container']/button");
	public static final By lblShippingMethod = By.xpath("//*[@id='opc-shipping_method']/h2");
	public static final By btnContinueShippingMethod = By.xpath("//*[@id='shipping-method-buttons-container']/button");
	public static final By lblShippingMethodShippingPge = By.xpath("//h2[text()='Shipping Method']");
	
	public static final By lblPaymentInformation = By.xpath("//*[@id='opc-payment']/h2");
	
	public static final By txtCreditCardNumber = By.xpath("//input[@name='credit-card-number']");
	public static final By iframeCreditCardInput = By.xpath("//iframe[contains(@id,'flex-microform')]");
	public static final By selectCreditCardType = By.id("cybersourcesop_cc_type");
	public static final By txtVerificationNumber = By.xpath("//input[@title='Card Verification Number']");
	public static final By selectExpirationMonth = By.xpath("//select[@name='payment[cc_exp_month]']");
	public static final By selectExpirationYear = By.xpath("//select[@name='payment[cc_exp_year]']");
	
	public static final By btnContinuePayment = By.xpath("//*[@id='payment-buttons-container']/button");
	
	public static final By btnPlaceOrder = By.xpath("//button[@title='Place Order']");
	public static final By lnkLoginFromCheckout = By.xpath("//a[text()='Login to your account']");
	public static final By txtUserNameCheckout = By.xpath("//input[@id='login-email']");
	public static final By txtPasswordCheckout = By.xpath("//input[@id='login-password']");
	public static final By btnLoginCheckout = By.xpath("//*[@id='login-form']/div[3]/div/div/button");
	public static final By btnContinueCheckout = By.xpath("//button[@title='Continue']");
	
	public static final By radioPayPal = By.xpath("//input[@id='p_method_paypal_express']");
	public static final By radioCreditCard = By.xpath("//input[@title='Credit Card']");	
	
	
	
	public static final String radioShippingMethod = "//label[contains(text(),";
	//Ground')]/preceding-sibling::input
	
	
	public static final By txtCouponCode = By.xpath("//input[@id='coupon_code']");
	public static final By btnApplyCoupon = By.xpath("(//button[@class='button cart__button cart__button--black'])[2]");
	public static final By lblCouponSuccessMsg = By.xpath("//li[@class='success-msg']//span");
	public static final By lblDiscountDetails = By.xpath("//div[@class='cart__totals__discount']");
	
	
	
	public static final By lnkBreadCrumbHome = By.xpath("//a[contains(text(),'Home')]");
	public static final By imgHeroHome = By.xpath("//section[@class='hero hero--desktop']");
	
	
	
	//********************************************* 11th Jan *********************************************************************
	
	public static final By lblCheckoutHeader = By.xpath("//h1[contains(text(),'Checkout')]");
	
	/********************************************************************************************************************************/
	
	public static final By lblConfirmPurchase = By.xpath("//h1[contains(text(),'Thank you for your purchase')]");
	public static final By lblOrderNumber = By.xpath("//p[contains(text(),'#')]");
	
	public static final By lblErrorMsg = By.xpath("//li[@class='error-msg']");
	
	public static final By lstSubTotalCheckout = By.xpath("//div[@class='order-view__summary__subtotal']/span");
	public static final By lblSummaryTotal = By.xpath("//div[@class='order-view__summary__total']/span");
	
	
	
	
	
}
