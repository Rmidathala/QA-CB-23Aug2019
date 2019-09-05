package businesscomponents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import componentgroups.CommonFunctions;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.ContactUsPage;

public class ContactUsPageComponents extends ReusableLibrary {

	WebDriverUtil wdu = new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	CommonFunctions commonFunctions = new CommonFunctions(scriptHelper);
	
	public ContactUsPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	public void invokeNonUSApplication() {
		try	{
			String applicationURL = dataTable.getData("General_Data", "ApplicationURL");
			report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
					applicationURL, Status.DONE);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.get(applicationURL);
			driver.manage().window().maximize();		
			
			wdu.waitUntilPageReadyStateComplete(120);		
			System.out.println("Test Script Execution Started.........");
		}	catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void navigateToContactUsPage() {
		try {
			String url = dataTable.getData("General_Data", "ContactUsPageURL");
			driver.navigate().to(url);
			if(driver.getCurrentUrl().contains(url)) {
				report.updateTestLog("Verify User navigated to Contact Us Page", "User Successfully navigated to Contact Us Page", Status.PASS);
			}else {
				report.updateTestLog("Verify User navigated to Contact Us Page", "User NOT navigated to Contact Us Page", Status.FAIL);
			}
			if(driver.getCurrentUrl().contains("contact-us")) {
			if(wdu.objectExists(ContactUsPage.btnAcceptCookies)) {
				driver.findElement(ContactUsPage.btnAcceptCookies).click();
				report.updateTestLog("Click on Accept Cookies button", "Accept Cookies Button is successfully clicked", Status.PASS);
			}
			} else {
				if(wdu.objectExists(ContactUsPage.nonUKAcceptCookies)) {
					driver.findElement(ContactUsPage.nonUKAcceptCookies).click();
					report.updateTestLog("Click on Accept Cookies button", "Accept Cookies Button is successfully clicked", Status.PASS);
				}
			}
		}catch(Exception e) {
			
		}
	}
	
	
	public void verifySubmitContactInformation() {
		try {
			String modelNumber = dataTable.getData("General_Data", "ModelNumber");
			String purchaseDate = dataTable.getData("General_Data", "PurchaseDate");
			String requiredPart = dataTable.getData("General_Data", "RequiredPart");
			String firstName = dataTable.getData("General_Data", "FirstName");
			String lastName = dataTable.getData("General_Data", "LastName");
			String addrLine1 = dataTable.getData("General_Data", "StreetAddressLine1");
			String country = dataTable.getData("General_Data", "Country");
			String city = dataTable.getData("General_Data", "City");
			String state = dataTable.getData("General_Data", "State");
			String zipCode = dataTable.getData("General_Data", "PostalCode");
			String phone = dataTable.getData("General_Data", "Telephone");
			String email = dataTable.getData("General_Data", "Email");
			String subject = dataTable.getData("General_Data", "Subject");
			String message = dataTable.getData("General_Data", "Message");
			String successMsg = dataTable.getData("General_Data", "SuccessMessage");
			
			Select typeOfSupport = new Select(driver.findElement(ContactUsPage.drpDownTypeOfSupport));
			typeOfSupport.selectByIndex(1);
			
			Select typeOfGrill = new Select(driver.findElement(ContactUsPage.drpDownTypeOfGrill));
			typeOfGrill.selectByIndex(1);
			
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxModelNumber), modelNumber, "Contact Us Page - Text Box Model Number");
			//driver.findElement(ContactUsPage.txtBoxPurchaseDate).sendKeys(purchaseDate);
			/*
			 * JavascriptExecutor jexe = (JavascriptExecutor) driver.getWebDriver();
			 * 
			 * jexe.executeScript("document.getElementById('purchase_date').value='"+
			 * purchaseDate+"';");
			 */
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxPurchaseDate), purchaseDate, "Contact Us Page - Text Box Purchase Date");
			commonFunctions.selectAnyElement(driver.findElement(ContactUsPage.drpDownNameOfRetailer), 1, "Contact Us Page - Drop Down - Name of the Retailer");
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxPartRequired), requiredPart, "Contact Us Page - Text Box Required Part");
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxFirstName), firstName, "Contact Us Page - Text Box First Name");
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxLastName), lastName, "Contact Us Page - Text Box Last Name");
			
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxStreetAddrLine1), addrLine1, "Contact Us Page - Text Box Street Address Line 1");
			if(driver.getCurrentUrl().contains("kontakt-os")) {
				country="DK";
				Select drpDowncountry = new Select(driver.findElement(ContactUsPage.drpDownCountry));
				drpDowncountry.selectByValue(country);
				
			} else if(driver.getCurrentUrl().contains("nous-contacter")) {
				country="FR";
				Select drpDowncountry = new Select(driver.findElement(ContactUsPage.drpDownCountry));
				drpDowncountry.selectByValue(country);
				
			} else {
				Select drpDowncountry = new Select(driver.findElement(ContactUsPage.drpDownCountry));
				drpDowncountry.selectByValue(country);
				commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxStateOther), state, "Contact Us Page - Text Box State");
			}
			
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxCity), city, "Contact Us Page - Text Box City");
			
			
			
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxPostalCode), zipCode, "Contact Us Page - Text Postal Code");
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxPhone), phone, "Contact Us Page - Text Box Phone");
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxEmail), email, "Contact Us Page - Text Box Email");
			
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtBoxSubject), subject, "Contact Us Page - Text Box Subject");
			
			commonFunctions.clearAndEnterText(driver.findElement(ContactUsPage.txtAreaMessage), message, "Contact Us Page - Text Area Message");
			
			commonFunctions.clickIfElementPresent(driver.findElement(ContactUsPage.btnSubmit), "Contact Us Page - Submit Button");
			
			commonFunctions.clickIfElementPresent(driver.findElement(ContactUsPage.btnClosePopUp), "Contact Us Page - Close pop up");
			gc.scrollToElement(ContactUsPage.btnSubmit);
			/*
			 * commonFunctions.clickIfElementPresent(driver.findElement(ContactUsPage.
			 * btnSubmit), "Contact Us Page - Submit Button");
			 * 
			 * if(driver.findElement(ContactUsPage.msgSuccess).getText().contains(successMsg
			 * )) { report.updateTestLog("Verify contact us Page is submitted successfully",
			 * "User is able to submit the contact Us Page Successfully", Status.PASS);
			 * }else {
			 * report.updateTestLog("Verify contact us Page is submitted successfully",
			 * "User is NOT able to submit the contact Us Page Successfully", Status.FAIL);
			 * }
			 */
			
		}catch(Exception e) {
			report.updateTestLog("Exception", "Something went Wrong"+e.toString(), Status.FAIL);
		}
	}
}
