package uimap;

import org.openqa.selenium.By;

public class ModularOutdoorKitchen {
	
	
	public static final By panel1Header = By.xpath("//ul[@class='easy-to__panel-list']/li[1]/h2");
	public static final By panel1Expand = By.xpath("//ul[@class='easy-to__panel-list']/li[1]/div[2]");
	//public static final By txtPanel1 = By.xpath("//p[contains(text(),'Choose between 3 or 5 burner grill options')]");
	public static final By txtPanel1 = By.xpath("//p[contains(text(),'Choose between a 3 or 5 burner')]");
	public static final By lnkClosePanel = By.xpath("//div[@class='easy-to__close']");
	public static final By lblPanel2Header = By.xpath("//h2[contains(text(),'Premium Construction')]");
	public static final By panel2Expand = By.xpath("//ul[@class='easy-to__panel-list']/li[2]/div[2]");
	public static final By txtPanel2 = By.xpath("//p[contains(text(),'stainless steel frame')]");
	public static final By panel3Expand = By.xpath("//ul[@class='easy-to__panel-list']/li[3]/div[2]");
	public static final By txtPanel3 = By.xpath("//p[contains(text(),'The Modular Outdoor Kitchen is customizable')]");
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
	
}
