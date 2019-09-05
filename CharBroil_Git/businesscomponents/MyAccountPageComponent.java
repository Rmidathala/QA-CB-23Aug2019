
package businesscomponents;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.HomePage;
import uimap.MyAccountPage;

public class MyAccountPageComponent extends ReusableLibrary{
	
	WebDriverUtil wdu=new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);


	public MyAccountPageComponent(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	
	
/************************************* Creating new Account *********************************************************/
	
	public void createAccountNewUser() 
	{
		
		try {
			
			String dynamicEmail = "Test_"+System.currentTimeMillis()+"_user@gmail.com";
			System.out.println(dynamicEmail);
			
			String firstname = dataTable.getData("General_Data", "FirstName");
			String lastname = dataTable.getData("General_Data", "LastName");
			String pass = dataTable.getData("General_Data", "Password");
		
			driver.findElement(HomePage.lnkMyAccount).click();
			
			
			wdu.waitUntilPageReadyStateComplete(20);
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 20);
			gc.scrollToElement(HomePage.lnkCreateAccount);
			driver.findElement(HomePage.lnkCreateAccount).click();
			
			
			wdu.waitUntilPageReadyStateComplete(30);
			wdu.waitUntilElementEnabled(MyAccountPage.txtFirstnameMA, 30);
		
			gc.scrollToElement(MyAccountPage.txtFirstnameMA);
			driver.findElement(MyAccountPage.txtFirstnameMA).sendKeys(firstname);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtLastnameMA).sendKeys(lastname);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtEmailMA).sendKeys(dynamicEmail);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtPasswordMA).sendKeys(pass);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtPassowrdCnfMA).sendKeys(pass);
			Thread.sleep(1000);
			
			driver.findElement(MyAccountPage.btnRegisterNewAcc).click();
			wdu.waitUntilElementEnabled(MyAccountPage.lblMyDashboard, 30);
			if(driver.findElement(MyAccountPage.lblMyDashboard).isDisplayed())
			{
				report.updateTestLog("Create Account", "New Account creation is successful", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Create Account", "New Account creation is not successful", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Creating New Account", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	


/************************************* Creating new Account with invalid email *********************************************************/
	
	public void createAccountInvalidUser() 
	{
		
		try {
			
			
			
			String firstname = dataTable.getData("General_Data", "FirstName");
			String lastname = dataTable.getData("General_Data", "LastName");
			
			String email = dataTable.getData("General_Data", "Email");
			String pass = dataTable.getData("General_Data", "Password");
		
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 15);
		
			driver.findElement(HomePage.lnkCreateAccount).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtFirstnameMA, 15);
		
			driver.findElement(MyAccountPage.txtFirstnameMA).sendKeys(firstname);
			driver.findElement(MyAccountPage.txtLastnameMA).sendKeys(lastname);
			driver.findElement(MyAccountPage.txtEmailMA).sendKeys(email);
			driver.findElement(MyAccountPage.txtPasswordMA).sendKeys(pass);
			driver.findElement(MyAccountPage.txtPassowrdCnfMA).sendKeys(pass);
			
			driver.findElement(MyAccountPage.btnRegisterNewAcc).click();
			if(driver.findElement(MyAccountPage.lblInvalidEmailErrorMsg).isDisplayed())
			{
				report.updateTestLog("Create Account Invalid user", "Account creation is not possible with invalid email id", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Create Account Invalid user", "New account created with same email id", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Creating New Account", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	

	

/************************************* Login Existing Customer *********************************************************/
	
	public void loginExistingCustomer() 
	{
		
		try {
				
			
			String email = dataTable.getData("General_Data", "Email");
			String pass = dataTable.getData("General_Data", "Password");
		
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 15);
		
			Thread.sleep(2000);
			driver.findElement(MyAccountPage.txtEmailReg).sendKeys(email);
			Thread.sleep(2000);
			driver.findElement(MyAccountPage.txtPasswordReg).sendKeys(pass);
			
			
			driver.findElement(MyAccountPage.btnLoginRegUser).click();
			wdu.waitUntilElementEnabled(MyAccountPage.lnkAddNewAddress, 50);
			
			if(driver.findElement(MyAccountPage.lnkAddNewAddress).isDisplayed())
			{
				report.updateTestLog("Login Existing Customer", "Registered User Login Successful", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Login Existing Customer", "Registered User Login is not Successful", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Log in Activity using Registered user credentials", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	

	

	
	
/************************************* Add Address to My Account *********************************************************/
	
	public void addAddressToMyAccount() 
	{
		
		try {
			
			String firstname = dataTable.getData("General_Data", "FirstName");
			String lastname = dataTable.getData("General_Data", "LastName");
			String company = dataTable.getData("General_Data", "Company");
			String address1 = dataTable.getData("General_Data", "Address1");
			String zip = dataTable.getData("General_Data", "Zip");
			String city = dataTable.getData("General_Data", "City");
			String country = dataTable.getData("General_Data", "Country");
			String state = dataTable.getData("General_Data", "State");
			String telephone = dataTable.getData("General_Data", "Telephone");
			
			
			driver.findElement(MyAccountPage.lnkAddNewAddress).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtFirstnameAA, 15);
			
			driver.findElement(MyAccountPage.txtFirstnameAA).clear();
			driver.findElement(MyAccountPage.txtFirstnameAA).sendKeys(firstname);
			driver.findElement(MyAccountPage.txtLastnameAA).clear();
			driver.findElement(MyAccountPage.txtLastnameAA).sendKeys(lastname);
			driver.findElement(MyAccountPage.txtCompanyAA).sendKeys(company);
			driver.findElement(MyAccountPage.txtTelephoneAA).sendKeys(telephone);
			driver.findElement(MyAccountPage.txtAddress1AA).sendKeys(address1);
			driver.findElement(MyAccountPage.txtZipAA).sendKeys(zip);
			driver.findElement(MyAccountPage.txtCityAA).sendKeys(city);
			driver.findElement(MyAccountPage.selectCountryAA).sendKeys(country);
			driver.findElement(MyAccountPage.selectStateAA).sendKeys(state);
			driver.findElement(MyAccountPage.btnSaveAddressAA).click();
						
			
			wdu.waitUntilElementEnabled(MyAccountPage.lnkAddNewAddress, 50);
			
			if(driver.findElement(MyAccountPage.lnkAddNewAddress).isDisplayed())
			{
				report.updateTestLog("Address Adding", "Address is added Successfully", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Address Adding", "Address is not added Successfully", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in adding Address", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	

	

	
/*************************************************** Validating My account Link *****************************************************************/
	
	public void validateMyAccountLink() 
	{
		
		try {
			
					
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 30);
		
			if(driver.findElement(HomePage.lnkCreateAccount).isDisplayed())
			{
				report.updateTestLog("My Account Link", "Page Navigation to Create Account / Sign in page is successful", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("My Account Link", "Page Navigation to Create Account / Sign in page is not successful", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Clicking on My Account Link", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************************************/	



	
/************************************* Creating new Account with same email *********************************************************/
	
	public void createAccountSameEmail() 
	{
		
		try {
			
			
			
			String firstname = dataTable.getData("General_Data", "FirstName");
			String lastname = dataTable.getData("General_Data", "LastName");
			
			String email = dataTable.getData("General_Data", "Email");
			String pass = dataTable.getData("General_Data", "Password");
		
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 15);
		
			driver.findElement(HomePage.lnkCreateAccount).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtFirstnameMA, 15);
		
			driver.findElement(MyAccountPage.txtFirstnameMA).sendKeys(firstname);
			driver.findElement(MyAccountPage.txtLastnameMA).sendKeys(lastname);
			driver.findElement(MyAccountPage.txtEmailMA).sendKeys(email);
			driver.findElement(MyAccountPage.txtPasswordMA).sendKeys(pass);
			driver.findElement(MyAccountPage.txtPassowrdCnfMA).sendKeys(pass);
			
			driver.findElement(MyAccountPage.btnRegisterNewAcc).click();
			
			wdu.waitUntilElementEnabled(MyAccountPage.lblErrorMsgSameEmail, 30);
			if(driver.findElement(MyAccountPage.lblErrorMsgSameEmail).getText().contains("There is already an account with this email address"))
			{
				report.updateTestLog("Create Account Invalid user", "Account creation is not possible with same email id", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Create Account Invalid user", "New account created with same email id failed", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Creating New Account", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	

	
	
	
	
/*************************************************** Validating My account landing Page *****************************************************************/
	
	public void validateMyAccountLandingPage() 
	{
		
		try {
			
					
		
			wdu.waitUntilElementEnabled(MyAccountPage.lblAddressBook, 30);
		
			if(driver.findElement(MyAccountPage.lblContactInformation).isDisplayed() && driver.findElement(MyAccountPage.lblEmailPreferences).isDisplayed() && 
					driver.findElement(MyAccountPage.lblAddressBook).isDisplayed() && 
					driver.findElement(MyAccountPage.lnkAddNewAddress).isDisplayed())
			{
				report.updateTestLog("My Account Validation", "My Account Landing page validation is successful", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("My Account Validation", "My Account Landing page validation is not successful", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Validating My account landing page", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************************************/	
	

	
	
	
/*************************************************** Validating Email Preference Link *****************************************************************/
	
	public void validateEmailPreferencesLink() 
	{
		
		try {
			
					
		
			wdu.waitUntilElementEnabled(MyAccountPage.lblAddressBook, 30);
		
			if(driver.findElement(MyAccountPage.lnkEditEmailPreferences).isDisplayed())
			{
				
				driver.findElement(MyAccountPage.lnkEditEmailPreferences).click();
				wdu.waitUntilElementEnabled(MyAccountPage.lblNewsletterSubscription, 30);
				
				
				if(driver.findElement(MyAccountPage.lblNewsletterSubscription).isDisplayed())
				{
					report.updateTestLog("Email Preference Validation", "Email Preference page navigation is successful", Status.PASS);
				}
				
				
				else
				{
					report.updateTestLog("Email Preference Validation", "Email Preference page navigation is not successful", Status.FAIL);
				}
				
				
			}
			
			
			else
			{
				report.updateTestLog("Email Preference Validation", "Email Preference edit link is not displayed", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Validating Email Preference", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************************************/	
	

		
/*************************************************** Validating Registration look up page *****************************************************************/
	
	public void validateProductRegistrationLookup() 
	{
		
		try {
			
					
		
			wdu.waitUntilElementEnabled(MyAccountPage.lblAddressBook, 30);
		
			if(driver.findElement(MyAccountPage.lnkRegistrationLookup).isDisplayed())
			{
				
				driver.findElement(MyAccountPage.lnkRegistrationLookup).click();
				wdu.waitUntilElementEnabled(MyAccountPage.lblProductRegistrationLookup, 30);
				
				
				if(driver.findElement(MyAccountPage.lblProductRegistrationLookup).isDisplayed())
				{
					report.updateTestLog("Product Registration look up Validation", "Page navigation of Product registration look up is successful", Status.PASS);
				}
				
				
				else
				{
					report.updateTestLog("Product Registration look up Validation", "Page navigation of Product registration look up is not successful ", Status.FAIL);
				}
				
				
			}
			
			
			else
			{
				report.updateTestLog("Product Registration look up Validation", "Registration look up link is not displayed", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Validating Product Registration look up", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************************************/	
		
	

	
/************************************* Creating new Account with same email *********************************************************/
	
	public void changePasswordNewUser() 
	{
		try {
			String pass = dataTable.getData("General_Data", "Password");
			String Newpass = dataTable.getData("General_Data", "NewPassword");
		
			driver.findElement(MyAccountPage.lnkChangePassword).click();
			
			String emailacc = driver.findElement(MyAccountPage.txtEmailAcc).getAttribute("value");
			
			wdu.waitUntilElementEnabled(MyAccountPage.txtCurrentPassword, 40);
		
			Thread.sleep(5000);
		
			driver.findElement(MyAccountPage.txtCurrentPassword).sendKeys(pass);
			driver.findElement(MyAccountPage.txtNewPassword).sendKeys(Newpass);
			driver.findElement(MyAccountPage.txtConfirmNewPassword).sendKeys(Newpass);
			
			driver.findElement(MyAccountPage.btnSaveNewPassword).click();
			
			Thread.sleep(5000);
			wdu.waitUntilElementEnabled(MyAccountPage.lnkChangePassword, 40);
			
			driver.findElement(MyAccountPage.lnkLogout).click();
			
			Thread.sleep(10000);
			//wdu.waitUntilElementEnabled(HomePage.lnkMyAccount, 40);
			
			driver.findElement(HomePage.lnkMyAccount).click();
			Thread.sleep(5000);
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 40);
		
			Thread.sleep(2000);
			driver.findElement(MyAccountPage.txtEmailReg).sendKeys(emailacc);
			Thread.sleep(2000);
			driver.findElement(MyAccountPage.txtPasswordReg).sendKeys(Newpass);
			driver.findElement(MyAccountPage.btnLoginRegUser).click();
			Thread.sleep(5000);
			wdu.waitUntilElementEnabled(MyAccountPage.lnkAddNewAddress, 50);
			
			if(driver.findElement(MyAccountPage.lnkAddNewAddress).isDisplayed())
			{
				report.updateTestLog("Change Password", "Passowrd Change and login with new password is successful", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Change Password", "Passowrd Change and login with new password is not successful", Status.FAIL);
			}

		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Changing password", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	
	
	
	

	
	
/************************************* Validation of text fields in Create Account *********************************************************/
	
	public void createAccountFieldValidations() 
	{
		
		try {
			
			
		
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 40);
		
			driver.findElement(HomePage.lnkCreateAccount).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtFirstnameMA, 40);
		
			
			driver.findElement(MyAccountPage.btnRegisterNewAcc).click();
			
			
			Thread.sleep(7000);
		
			if(!wdu.objectExists(MyAccountPage.lblMyProduct))
			{
				report.updateTestLog("Create Account Field Validation", "Validation of create account filed is successful", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Create Account Field Validation", "Validation of create account field is not successful", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating Create New Account", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	

		
	

/************************************* Creating new Account with newsletter sign up *********************************************************/
	
	public void createAccountNewUserNewsLetterSignUp() 
	{
		
		try {
			
			String dynamicEmail = "Test_"+System.currentTimeMillis()+"_user@gmail.com";
			System.out.println(dynamicEmail);
			
			String firstname = dataTable.getData("General_Data", "FirstName");
			String lastname = dataTable.getData("General_Data", "LastName");
			String pass = dataTable.getData("General_Data", "Password");
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(HomePage.lnkCreateAccount, 30);
		
			driver.findElement(HomePage.lnkCreateAccount).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtFirstnameMA, 30);
		
			driver.findElement(MyAccountPage.txtFirstnameMA).sendKeys(firstname);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtLastnameMA).sendKeys(lastname);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtEmailMA).sendKeys(dynamicEmail);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtPasswordMA).sendKeys(pass);
			Thread.sleep(1000);
			driver.findElement(MyAccountPage.txtPassowrdCnfMA).sendKeys(pass);
			Thread.sleep(1000);
			
			driver.findElement(MyAccountPage.checkboxNewsLetter).click();
			
			driver.findElement(MyAccountPage.btnRegisterNewAcc).click();
			wdu.waitUntilElementEnabled(MyAccountPage.lblMyDashboard, 40);
			if(driver.findElement(MyAccountPage.lblMyDashboard).isDisplayed() && driver.findElement(MyAccountPage.lblNewsletter).getText().contains("You are currently subscribed"))
			{
				report.updateTestLog("Create Account", "New Account creation is successful with newsletter sign up checkbox checked", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Create Account", "New Account creation is not successful with newsletter sign up checkbox checked", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Creating New Account", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	


	
	
	
	
/************************************* Edit Address to My Account *********************************************************/
	
	public void editAddressMyAccount() 
	{
		
		try {
			
			
			String company = "Company_"+System.currentTimeMillis()+"_LTD";
			
			driver.findElement(HomePage.lnkMyAccount).click();
			wdu.waitUntilElementEnabled(MyAccountPage.lblAddressBook, 30);
			
			gc.scrollToElement(MyAccountPage.editThirdAddress);
			
			driver.findElement(MyAccountPage.editThirdAddress).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtCompanyAA, 30);
			
			driver.findElement(MyAccountPage.txtCompanyAA).clear();
			driver.findElement(MyAccountPage.txtCompanyAA).sendKeys(company);
			
			
			driver.findElement(MyAccountPage.btnSaveAddress).click();
			wdu.waitUntilElementEnabled(MyAccountPage.txtCompanyAA, 30);
			
			String pageSourceContent = driver.getPageSource();
			
			
			if(pageSourceContent.contains(company))
			{
				report.updateTestLog("Edit Address My Account", "Address is Edited Successfully", Status.PASS);
			}
			
			
			else
			{
				report.updateTestLog("Edit Address My Account", "Address is not Edited Successfully", Status.FAIL);
			}
			
			
				
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Editing Address", "Exception is " + e, Status.FAIL);
		}
		
		
	}
/*************************************************************************************************************************/	

		
	

	
	/************************************************************************************************************************
     * Function Name: validateRegisterProduct Objective: To validate register product functionality
     * Created On: 07/01/2015 Created By: Arka Dasgupta
     * Automation Team Last Modified On: 02/13/2018 
     * Last Modified By: Arka Dasgupta
     ************************************************************************************************************************/
	
	public void validateRegisterProduct() 
	{

		try {

			String purchaseAmount = "199.99";
			
			wdu.waitUntilElementEnabled(MyAccountPage.lnkRegisterAProduct, 30);
			driver.findElement(MyAccountPage.lnkRegisterAProduct).click();
			Thread.sleep(2000);
			wdu.waitUntilElementEnabled(MyAccountPage.txtPurchaseAmount, 30);
			driver.findElement(MyAccountPage.txtPurchaseAmount).sendKeys(purchaseAmount);
			driver.findElement(MyAccountPage.btnRegisterProduct).click();
			
			wdu.waitUntilPageReadyStateComplete(20);
			
					
			if(!driver.findElement(MyAccountPage.errorPurchaseAmount).isDisplayed())
			{
				report.updateTestLog("Register Product Validation", "Register Product validation is successful", Status.PASS);
			}
			
			else
			{
				report.updateTestLog("Register Product Validation", "Register Product validation is not successful", Status.FAIL);
			}
			
			




		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating Registering Product Functionality", "Exception is " + e, Status.FAIL);
		}


	}		
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
