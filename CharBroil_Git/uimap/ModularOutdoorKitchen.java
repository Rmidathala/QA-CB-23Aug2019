package uimap;

import org.openqa.selenium.By;

public class ModularOutdoorKitchen {
	
	
	public static final By panel1Header = By.xpath("//ul[@class='easy-to__panel-list']/li[1]/h2");
	public static final By panel1Expand = By.xpath("(//div[@class='easy-ko__plus'])[1]");
	//public static final By txtPanel1 = By.xpath("//p[contains(text(),'Choose between 3 or 5 burner grill options')]");
	public static final By txtPanel1 = By.xpath("//span[contains(text(),'Choose between a 3 or 5 burner')]");
	public static final By lnkClosePanel = By.xpath("//button[@class='easy-ko__controls-close']");
	public static final By lblPanel2Header = By.xpath("//h2[contains(text(),'Premium Construction')]");
	public static final By panel2Expand = By.xpath("(//div[@class='easy-ko__plus'])[2]");
	public static final By txtPanel2 = By.xpath("//span[contains(text(),'stainless steel frame')]");
	public static final By panel3Expand = By.xpath("(//div[@class='easy-ko__plus'])[3]");
	public static final By txtPanel3 = By.xpath("//span[contains(text(),'The Modular Outdoor Kitchen is customizable')]");
	public static final By lblPanel3Header = By.xpath("//h2[contains(text(),'The most Forgiving Grills On Earth')]");
	public static final By lnkBannerExpand1 = By.xpath("//div[@class='g2c-explorable-image__trigger'][3]");
	public static final By lnkBannerExpand2 = By.xpath("//div[@class='g2c-explorable-image__trigger'][4]");
	public static final By lnkBannerExpand3 = By.xpath("//div[@class='g2c-explorable-image__trigger'][1]");
	public static final By lnkBannerExpand4 = By.xpath("//div[@class='g2c-explorable-image__trigger'][2]");
	public static final By lblBannerExpandText1 = By.xpath("//div[contains(text(),'So Many Ways To Cook')]");
	public static final By lblBannerExpandText2 = By.xpath("//div[contains(text(),'TRU-Infrared™ Cooking Technology')]");
	public static final By lblBannerExpandText3 = By.xpath("//div[contains(text(),'Made to Entertain')]");
	public static final By lblBannerExpandText4 = By.xpath("//div[contains(text(),'Light up the Night')]");
	public static final By lnkBannerExpand1Close = By.xpath("//div[@id='g2c-explorable-image__panel__burger']/div[1]/img");
	public static final By lnkBannerExpand2Close = By.xpath("//div[@id='g2c-explorable-image__panel__corn']/div[1]/img");
	public static final By lnkBannerExpand3Close = By.xpath("//div[@id='g2c-explorable-image__panel__sideburner']/div[1]/img");
	public static final By lnkBannerExpand4Close = By.xpath("//div[@id='g2c-explorable-image__panel__bastor']/div[1]/img");
	public static final By lnkModularProduct1Expand = By.xpath("//div[@class='line-up__content content-desktop']/div[1]/a/div[3]");
	//public static final By lblModularProduct1ExpandContent = By.xpath("//*[@id='campaign-top']/div[8]/div[2]/div[3]/ul/div/div/li[2]/div");
	
	public static final By lblModularProduct1ExpandContent = By.xpath("//*[@id='campaign-top']/div[8]/div[2]/div[3]/ul/div/div/li[2]/div/div[2]/p");
	
	
	public static final By btnShopModularOutdoorKitchen = By.xpath("//a[@class='shop-now__button']");
	public static final By lblModularOutdoorKitchen = By.xpath("//h1[contains(text(),'Modular Outdoor Kitchen')]");
	
	
	/**********************OutdoorKitchen*****************/
	
	public static final By titleOutdoorKitchen =By.xpath("//div[@class='page-title']/h1");
	public static final By sectionBuiltInKitchen =By.xpath("(//div[@class='col-lg-6 portfolio-item'])[1]");
	public static final By sectionModularOutdoorKitchen =By.xpath("(//div[@class='col-lg-6 portfolio-item'])[2]");
	public static final By buttonExploreBuiltInKitchen =By.xpath("(//a[@class='featured-product__button button'])[1]");
	public static final By buttonExploreModularOutdoorKitchen =By.xpath("(//a[@class='featured-product__button button'])[2]");
	
	
	
	/**********BuiltIn kItchen***********/
	
	public static final By titleBuiltInKitchen =By.xpath("//div[@class='nyc-hero__headliner nyc-hero__headliner_text']");
	public static final By plusButtonBuiltYourWay =By.xpath("(//div[@class='easy-to__trigger'])[1]");
	public static final By plusButtonPremiumConstruction =By.xpath("(//div[@class='easy-to__trigger'])[2]");
	public static final By plusButtonZonalCooking =By.xpath("(//div[@class='easy-to__trigger'])[3]");
	public static final By buttonCloseDetails=By.xpath("(//div[@class='easy-to__close'])");
	public static final By buttonShopBuiltInKitchen=By.xpath("//a[@class='shop-now__button']");
	public static final By titleButtonBuiltYourWay =By.xpath("(//*[@class='easy-to__slide-copy']/h4)[1]");
	public static final By titleButtonPremiumConstruction =By.xpath("(//*[@class='easy-to__slide-copy']/h4)[2]");
	public static final By titleButtonZonalCooking =By.xpath("(//*[@class='easy-to__slide-copy']/h4)[3]");
}
