package uimap;

import org.openqa.selenium.By;

public class ProductRegistrationPage {

	//Links
	public static final By lblProductRegistration = By.xpath("//h1[text()='Product Registration']");
	public static final By lblProductRegistrationEU = By.xpath("//h1[text()='Product Registration']");
	public static final By lblProductRegistrationFR = By.xpath("//h1[text()='Enregistrement produit']");
	public static final By lblProductRegistrationDE = By.xpath("//h1[text()='Produktregistrierung']");
	public static final By lblProductRegistrationDK = By.xpath("//h1[text()='Produkt registrering']");
	
	
	//contents of the page
	public static final By txtBoxFirstName = By.xpath("//*[@id=\'txtFirstName\']");
	public static final By txtBoxLastName = By.xpath("//*[@id=\'txtLastName\']");
	public static final By txtBoxEmail = By.xpath("//*[@id='txtEmail']");
	public static final By txtBoxAddress1 = By.xpath("//*[@id=\'txtAddress1\']");
	public static final By txtBoxAddress2 = By.xpath("//*[@id=\'txtAddress2\']");
	public static final By txtBoxZip = By.xpath("//*[@id=\'txtZip\']");
	public static final By txtBoxCity = By.xpath("//*[@id=\'txtCity\']");
	public static final By drpDownCountry = By.xpath("//*[@id=\'ddlCountry\']");
	public static final By drpDownState = By.xpath("//*[@id=\'ddlState\']");
	public static final By txtBoxPhone = By.xpath("//*[@id=\'txtPhone\']");
	public static final By txtBoxModel = By.xpath("//*[@id=\'txtModelNumber\']");
	public static final By txtBoxPurchaseAmt = By.xpath("//*[@id=\'txtPurchaseAmount\']");
	public static final By txtBoxPurchaseDate = By.xpath("//*[@id=\'datetimePicker1\']");
	public static final By txtBoxSerialNo = By.xpath("//*[@id=\'txtSerialNumber\']");
	public static final By drpDownPurchaseLocation = By.xpath("//*[@id=\'ddlPurchaseLocation\']");
	public static final By btnRegisterYourProduct = By.xpath("//*[@id=\'btnRegister\']");
	

}
