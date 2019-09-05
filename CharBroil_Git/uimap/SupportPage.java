package uimap;

import org.openqa.selenium.By;

public class SupportPage {

	public static final By linkRegisterProduct = By.cssSelector("div.callout__title > h2");
	public static final By btnRegisterProduct = By.xpath("//a[text()='Register Product']");
	public static final By linkRegisterProductHeader = By.cssSelector("h1");
	public static final By linkAutoSuggestionResults = By.cssSelector("span.aa-suggestions > div.aa-suggestion");

	//Links GAS GRILL HELP
	public static final By linkGasRegulatorTripped = By.linkText("Gas regulator tripped");
	public static final By linkBadPropaneTankConnection = By.linkText("Bad propane tank connection");
	public static final By linkFlamesBlowOut = By.linkText("Flames blow out because of wind");
	
	//Links CHARCOAL GRILL HELP
	public static final By linkResidueInGrill = By.linkText("Residue in grill");
	public static final By linkCharcoalTemperature = By.linkText("Charcoal temperature won't regulate");
	
	//Links ELECTRIC GRILL HELP
	public static final By linkExtensionCord = By.linkText("Extension cord is wrong");
	public static final By linkGrillIsntHeating = By.linkText("Grill isn't heating");
	public static final By linkGrillStoppedWorking = By.linkText("Grill stopped working");
	
	//Links SMOKER & ROASTER HELP
	public static final By linkResidueInSmoker = By.linkText("Residue in smoker");
	public static final By linkWaterSmoker = By.linkText("Water smoker not working");
	
	//Links SMARTCHEF HELP
	public static final By linkPreventingLowFlames = By.linkText("Preventing low flames on your gas grill");
	public static final By linkGrillingGuides = By.linkText("Grilling Guides");
	public static final By linkDigitalElectricSmoker = By.linkText("Digital Electric Smoker SmartChef Operations Guide");
	
	//Links ACCESSORIES HELP
	public static final By linkLidWontClose = By.linkText("Lid won't close on rotisserie");
	public static final By linkSpitRod = By.linkText("Spit rod not turning");
	public static final By linkRotisserieOverloaded = By.linkText("Rotisserie overloaded");
	
	//Buttons
	public static final By btnShippingInfo = By.xpath("//a[text()='SHIPPING INFO']");
	public static final By btnTrackAnOrder = By.xpath("//a[text()='TRACK AN ORDER']");
	public static final By btnCaseLookup = By.xpath("//a[text()='CASE LOOKUP']");
	public static final By btnReturns = By.xpath("//a[text()='RETURNS']");
	
	//How to find my model no section
	public static final By linkWhereIsModelNumber = By.xpath("//div[@class='fixed-container']/h1[text()='Where is my Model Number?']");
	
	
	
	//support Sublink Header
	
	public static final By lnkSupportSubLinkTitle = By.xpath("//li[@class='nav-item nav-mega-right dropdown menu-large']/ul//ul/li[@class='header__list--title']/a");
	public static final By lnkSupportSubLinks = By.xpath("//li[@class='nav-item nav-mega-right dropdown menu-large']/ul//ul/li[@class='header__list--links']/a");
	
	
	
	
	
	
	
	
	
	
	
	
}
