package uimap;

import org.openqa.selenium.By;

public class MyAccountPage {

	//Links
	//public static final By lblCreateAccount = By.xpath("//h1[contains(text(),'Login or Create an Account')]");
	public static final By lblCreateAccount = By.xpath("//h2[contains(text(),'Create An Account')]");
	
	//Arka
	public static final By txtFirstnameMA = By.xpath("//input[@id='firstname']");
	public static final By txtLastnameMA = By.xpath("//input[@id='lastname']");
	public static final By txtEmailMA = By.xpath("//input[@id='email_address']");
	public static final By txtPasswordMA = By.xpath("//input[@id='password']");
	public static final By txtPassowrdCnfMA = By.xpath("//input[@id='confirmation']");
	
	public static final By btnRegisterNewAcc = By.xpath("//button[@class='button']");
	public static final By lblMyDashboard = By.xpath("//*[@class='page-title']/h1");
	public static final By lblInvalidEmailErrorMsg = By.xpath("//li[@class='error-msg']/ul/li/span");
	
	public static final By txtEmailReg = By.xpath("//input[@title='Email Address']");
	public static final By txtPasswordReg = By.xpath("//input[@title='Password']");
	public static final By btnLoginRegUser = By.xpath("//button[@title='Login']/span/span ");     //********old***** //button[@class='button']/span/span
	public static final By lnkAddNewAddress = By.xpath("//a[contains(text(),'Add new address')]");
	
	public static final By txtFirstnameAA = By.xpath("//input[@id='firstname']");
	public static final By txtLastnameAA = By.xpath("//input[@id='lastname']");
	public static final By txtCompanyAA = By.xpath("//input[@id='company']");
	public static final By txtTelephoneAA = By.xpath("//input[@id='telephone']");
	public static final By txtAddress1AA = By.xpath("//input[@id='street_1']");
	public static final By txtAddress2AA = By.xpath("//input[@id='street_2']");
	public static final By txtCityAA = By.xpath("//input[@id='city']");
	
	public static final By selectStateAA = By.xpath("//select[@id='region_id']");
	public static final By txtZipAA = By.xpath("//input[@id='zip']");
	public static final By selectCountryAA = By.xpath("//select[@id='country']");
	
	public static final By btnSaveAddressAA = By.xpath("//button[@title='Save Address']/span/span");
	
	
	public static final By lblErrorMsgSameEmail = By.xpath("//*[@class='error-msg']//span"); //There is already an account with this email address. If you are sure that it is your email address,
	
	
	
	public static final By lblMyAccountInfo = By.xpath("//div[@class='row no-gutters my-account__box-container']");
	public static final By lblContactInformation = By.xpath("//h3[contains(text(),'Contact Information')]");
	public static final By lblEmailPreferences = By.xpath("//h3[contains(text(),'Email Preferences')]");
	public static final By lblAddressBook = By.xpath("(//*[@class='my-account__section-heading'])[2]");
	
	public static final By lnkRegistrationLookup = By.xpath("//a[contains(text(),'Registration Lookup')]");
	public static final By lblProductRegistrationLookup = By.xpath("//h1[contains(text(),'Product Registration Lookup')]");
	 
	
	public static final By lnkChangePassword = By.xpath("//a[contains(text(),'Change Password')]");
	public static final By txtCurrentPassword = By.xpath("//input[@title='Current Password']");
	public static final By txtNewPassword = By.xpath("//input[@title='New Password']");
	public static final By txtConfirmNewPassword = By.xpath("//input[@title='Confirm New Password']");
	public static final By btnSaveNewPassword = By.xpath("//button[@title='Save']/span");
	public static final By lnkEditEmailPreferences = By.xpath("//a[contains(@href,'newsletter/manage')]");
	public static final By lblNewsletterSubscription = By.xpath("//h2[contains(text(),'Newsletter Subscription')]");
	public static final By txtEmailAcc = By.xpath("//input[@id='email']");
	//public static final By lnkLogout = By.xpath("//div[@class='top-links hidden-md-down']/div/div[5]/a");
	public static final By lnkLogout = By.xpath("(//a[text()='Logout'])[1]");
	
	public static final By lblBlankFirstNameError = By.xpath("//li[@class='error-msg']//li[1]/span");
	public static final By lblBlankLastNameError = By.xpath("//li[@class='error-msg']//li[3]/span");
	public static final By lblBlankEmailNameError = By.xpath("//li[@class='error-msg']//li[5]/span");
	public static final By checkboxNewsLetter = By.xpath("//input[@title='Sign Up for Newsletter']");
	public static final By lblNewsletter = By.xpath("(//*[@class='my-account__box__content'])[2]/p");
	
	
	
	
	public static final By editThirdAddress = By.xpath("//div[@class='my-account__section my-account__section--address-book']/div[1]/div[3]//a[contains(text(),'Edit')]");
	
	public static final By btnSaveAddress = By.xpath("//button[@title='Save Address']/span/span");
	
	
	public static final By lblMyProduct = By.xpath("//h2[@class='my-account__section-heading'][1]");
	
	
	public static final By errorPurchaseAmount = By.xpath("//small[contains(text(),'The purchase amount is required')]");
	
	public static final By txtPurchaseAmount = By.xpath("//input[@id='txtPurchaseAmount']");
	public static final By lnkRegisterAProduct = By.xpath("//a[contains(text(),'Register A Product')]");
	public static final By btnRegisterProduct = By.xpath("//input[@id='btnRegister']");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
