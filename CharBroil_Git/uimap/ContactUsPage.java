package uimap;

import org.openqa.selenium.By;

public class ContactUsPage {
	
	public static final By btnAcceptCookies = By.xpath("//button[@title='Accept Cookies']");

	public static final By drpDownTypeOfSupport = By.xpath("//select[@name='support_type']");
	
	public static final By drpDownTypeOfGrill = By.xpath("//select[@name='type_of_grill']");
	
	public static final By txtBoxModelNumber = By.xpath("//input[@name='model_number']");
	
	public static final By txtBoxFirstName = By.xpath("//input[@name='first_name']");
	
	public static final By txtBoxLastName = By.xpath("//input[@name='last_name']");
	
	public static final By txtBoxPostalCode = By.xpath("//input[@name='postal_code']");
	
	public static final By txtBoxPhone = By.xpath("//input[@name='phone']");
	
	public static final By txtBoxEmail = By.xpath("//input[@name='email']");
	
	public static final By txtBoxSubject = By.xpath("//input[@name='subject']");
	
	public static final By txtAreaMessage = By.xpath("//textarea[@name='message']");
	
	public static final By btnSubmit = By.xpath("//button[@id='contact']");
	
	public static final By drpDownNameOfRetailer = By.xpath("//select[@name='name_of_retailer']");
	
	public static final By txtBoxPartRequired = By.xpath("//input[@name='part_required']");
	
	public static final By txtBoxStreetAddrLine1 = By.xpath("//input[@name='street_address']");
	
	public static final By txtBoxStreetAddrLine2 = By.xpath("//input[@name='street_address_2']");
	
	public static final By drpDownCountry = By.xpath("//select[@name='country']");
	
	public static final By txtBoxCity = By.xpath("//input[@name='city']");
	
	public static final By drpDownState = By.xpath("//select[@name='state']");
	
	public static final By txtBoxStateOther = By.xpath("//input[@name='state_other']");
	
	public static final By popUpModel = By.xpath("//div[@class='contact-us__warranty-modal']");
	
	public static final By txtBoxPurchaseDate = By.xpath("//input[@name='purchase_date']");
	
	public static final By btnClosePopUp = By.xpath("//a[@class='close-pop']");
	
	//Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.
	public static final By msgSuccess = By.xpath("//li[@class='success-msg']/ul/li/span");
	
	public static final By nonUKAcceptCookies =By.xpath("//a[@class='optanon-allow-all']");
	
	
	
}
