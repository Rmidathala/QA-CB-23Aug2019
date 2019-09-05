package uimap;

import org.openqa.selenium.By;

public class CBGrillPlus {
	
	public static final By linkGrillsImageText = By.xpath("//div[@id='campaign-top']/div[3]/div/div[2]");
	//public static final By linkExplore = By.linkText("Explore");
	public static final By linkExplore = By.xpath("//a[contains(text(),'Explore')]");
	public static final By linkNextLevelGrillingHeader = By.cssSelector("h3");
	public static final By linkNextLevelGrilling = By.cssSelector("div.easy-to__heading.panel-heading > p");
	public static final By linkNextLevelGrillingImage = By.cssSelector("div.easy-to__image-wrapper");
	
	public static final By linkNextLevelFirstImagePlus = By.cssSelector("div.easy-to__trigger");
	public static final By linkNextLevelSecondImagePlus = By.cssSelector("li.easy-to__panel.easy-to__panel--1 > div.easy-to__trigger");
	public static final By linkNextLevelThirdImagePlus = By.cssSelector("li.easy-to__panel.easy-to__panel--2 > div.easy-to__trigger");
	
	public static final By linkNextLevelFirstImageMainText = By.cssSelector("div.easy-to__slide-copy > h4");
	public static final By linkNextLevelFirstImageSubText = By.cssSelector("div.easy-to__slide-copy > p");
	public static final By linkNextLevelSecondImageMainText = By.xpath("//div[@id='easy-to']/div[2]/div/ol/li[2]/div/h4");
	public static final By linkNextLevelSecondImageSubText = By.xpath("//div[@id='easy-to']/div[2]/div/ol/li[2]/div/p");
	public static final By linkNextLevelThirdImageMainText = By.xpath("//div[@id='easy-to']/div[2]/div/ol/li[3]/div/h4");
	public static final By linkNextLevelThirdImageSubText = By.xpath("//div[@id='easy-to']/div[2]/div/ol/li[3]/div/p");
	
	public static final By btnNextLevelImageNext = By.cssSelector("div.easy-to__next");
	public static final By btnNextLevelImageClose = By.cssSelector("div.easy-to__close");
	
	public static final By linkFlavorText = By.cssSelector("div.made-for-flavor__heading");
	public static final By linkFlavorSubText = By.cssSelector("div.made-for-flavor__desc");
	
	public static final By btnFlavorFirstPlusIcon = By.xpath("//div[@id='campaign-top']/div[6]/div[2]/div[3]");
	public static final By btnFlavorSecondPlusIcon = By.xpath("//div[@id='campaign-top']/div[6]/div[2]/div[4]");
	public static final By btnFlavorThirdPlusIcon = By.cssSelector("div.g2c-explorable-image__trigger");
	public static final By btnFlavorFourthPlusIcon = By.xpath("//div[@id='campaign-top']/div[6]/div[2]/div[2]");
	
	public static final By btnFlavorImagePlusIcon = By.cssSelector("div.g2c-explorable-image__trigger");
	
	//public static final By btnFlavorClosePanelFirstImage = By.cssSelector("img[alt=\"Close Panel\"]");
	public static final By btnFlavorClosePanelFirstImage = By.xpath("(//img[@alt='Close Panel'])[1]");
	public static final By btnFlavorClosePanelSecondImage = By.xpath("(//img[@alt='Close Panel'])[2]");
	public static final By btnFlavorClosePanelThirdImage = By.xpath("(//img[@alt='Close Panel'])[3]");
	public static final By btnFlavorClosePanelFourthImage = By.xpath("(//img[@alt='Close Panel'])[4]");
	
	public static final By linkFlavorFirstImagePanelTitle = By.cssSelector("div.g2c-explorable-image__panel__title");
	public static final By linkFlavorFirstImagePanelDesc = By.cssSelector("div.g2c-explorable-image__panel__desc");
	
	public static final By linkFlavorSecondImagePanelTitle = By.cssSelector("#g2c-explorable-image__panel__corn > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__title");
	public static final By linkFlavorSecondImagePanelDesc = By.cssSelector("#g2c-explorable-image__panel__corn > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__desc");
	
	public static final By linkFlavorThirdImagePanelTitle = By.cssSelector("#g2c-explorable-image__panel__sideburner > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__title");
	public static final By linkFlavorThirdImagePanelDesc = By.cssSelector("#g2c-explorable-image__panel__sideburner > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__desc");
	
	public static final By linkFlavorFourthImagePanelTitle = By.cssSelector("#g2c-explorable-image__panel__bastor > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__title");
	public static final By linkFlavorFourthImagePanelDesc = By.cssSelector("#g2c-explorable-image__panel__bastor > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__desc");

}
