package uimap;

import org.openqa.selenium.By;

public class CBSignature {
	
	public static final By ShopNowBtn = By.xpath("//*[text()='Shop Now']");
	
	public static final By ProdutBreadCrumb = By.xpath("//*[@class='breadcrumbs__list']");
	
	public static final By ProdutBreadCrumbText = By.xpath("//*[@class='breadcrumb breadcrumbs']/p");
	
	//section[@id="message-404"]
	
	public static final By MainContainer = By.xpath("//div[@class='main-container col1-layout']/div/div/section");
	
	public static final By ProdutEntryTitle = By.xpath("//*[@class='single-title entry-title']");
	
	public static final By ProdutPageTitle = By.xpath("//*[@class='page-title']");
	
	public static final By BackToTopArrow = By.xpath("//a[@class='back-to-top active']");
	
	public static final By SignatureSeriestext = By.xpath("//*[@id='amshopby-page-container']/ul/li/h2");
	
	//public static final By StickyBar = By.xpath("//*[@id='campaign-top']/div[@class='sticky-shop-now__trigger']");
	//public static final By StickyBar = By.xpath("//*[@class='sticky-shop-now']");
	public static final By StickyBar = By.xpath("//a[contains(text(),'Shop Now')]");
	
	public static final By StickyBarTitle = By.xpath("//div[@class='sticky-shop-now__title']");
	
	public static final By BigImage = By.xpath("//*[@class='nyc-hero']");
	
	public static final By BigImageOnImageSection = By.xpath("//img[@class='nyc-hero__img--desktop']");
	
	//public static final By HeadLinerBigImage = By.xpath("//div[@class='nyc-hero__headliner']");
	
	public static final By HeadLinerBigImage = By.xpath("//div[@class='nyc-hero__half nyc-hero__half--left']");
	
	public static final By BigImageHeadliner = By.xpath("//*[text()='IN THE ZONE']");
	
	public static final By Explorelink = By.xpath("//*[@class='nyc-hero']/div/a[text()='Explore']");
	
	public static final By MadeforConveneenceImages = By.xpath("//*[@id='easy-to']/div[2]/ul");
	
	public static final By plusSignOn1stImage = By.xpath("//*[@id='easy-to']/div[2]/ul/li[1]/div[2]");
	
	public static final By plusSignOn2ndImage = By.xpath("//*[@id='easy-to']/div[2]/ul/li[2]/div[2]");
	
	public static final By plusSignOn3rdImage = By.xpath("//*[@id='easy-to']/div[2]/ul/li[3]/div[2]");
	
	public static final By crossSignOnExpanImage = By.xpath("//*[@id='easy-to']/div[2]/div/div[3]");
	
	public static final By Prevlink = By.xpath("//div[@class='easy-to__prev']");
	
	public static final By Nextlink = By.xpath("//div[@class='easy-to__next']");
	
	public static final By MadeFlavBigImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]/img");
	
	//public static final By MadeFlavAnmImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]");
	public static final By MadeFlavAnmImage = By.cssSelector("div.g2c-explorable-image__trigger");
	
	public static final By MadeFlavAnmplusSignOn1stImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]/div[1]");
	
	public static final By MadeFlavAnmplusClose1stImage = By.xpath("//div[@id='explorable-image__panel__sideburner']/div[@class='explorable-image__panel__close']");
	
	//public static final By MadeFlavAnmplusTitle1stImage = By.xpath("//div[@id='explorable-image__panel__sideburner']/div/div[@class='explorable-image__panel__title']");
	public static final By MadeFlavAnmplusTitle1stImage = By.cssSelector("#g2c-explorable-image__panel__sideburner > div.g2c-explorable-image__panel__content > div.g2c-explorable-image__panel__title");
	
	//public static final By MadeFlavAnmpluslink1stImage = By.xpath("//div[@id='explorable-image__panel__sideburner']/div/a[@class='explorable-image__panel__cta']");
	public static final By MadeFlavAnmpluslink1stImage = By.xpath("//a[contains(text(),'See Details')]");
	
	public static final By MadeFlavAnmplus2ndImage = By.xpath("//*[@id='explorable-image__panel__bastor']/div[@class='explorable-image__panel__img']/a/div");
	
	public static final By MadeFlavAnmplusvideo2ndImage = By.xpath("//div[@class='fancybox-skin']");
	
	public static final By MadeFlavAnmplusvideoclose2ndImage = By.xpath("//a[@title='Close']");
	
	public static final By MadeFlavAnmplusSignOn2ndImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]/div[2]");
	
	public static final By MadeFlavAnmplusClose2ndImage = By.xpath("//div[@id='explorable-image__panel__bastor']/div[@class='explorable-image__panel__close']");
	
	public static final By MadeFlavAnmplusTitle2ndImage = By.xpath("//div[@id='g2c-explorable-image__panel__bastor']/div/div[@class='g2c-explorable-image__panel__title']");
	
	public static final By MadeFlavAnmpluslink2ndImage = By.xpath("//div[@id='g2c-explorable-image__panel__bastor']/div/a[@class='g2c-explorable-image__panel__cta']");
	
	public static final By MadeFlavAnmplusSignOn3rdImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]/div[3]");
	
	public static final By MadeFlavAnmplusClose3rdImage = By.xpath("//div[@id='explorable-image__panel__burger']/div[@class='explorable-image__panel__close']");
	
	//public static final By MadeFlavAnmplusTitle3rdImage = By.xpath("//div[@id='explorable-image__panel__burger']/div/div[@class='explorable-image__panel__title']");
	public static final By MadeFlavAnmplusTitle3rdImage = By.xpath("(//div[@class='g2c-explorable-image__panel__title'])[1]");
	public static final By MadeFlavAnmpluslink3rdImage = By.xpath("//div[@id='explorable-image__panel__burger']/div/a[@class='explorable-image__panel__cta']");
	
	public static final By MadeFlavAnmplusSignOn4thImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]/div[4]");
	
	public static final By MadeFlavAnmplusClose4thImage = By.xpath("//div[@id='explorable-image__panel__corn']/div[@class='explorable-image__panel__close']");
	
	//public static final By MadeFlavAnmplusTitle4thImage = By.xpath("//div[@id='explorable-image__panel__corn']/div/div[@class='explorable-image__panel__title']");
	public static final By MadeFlavAnmplusTitle4thImage = By.xpath("(//div[@class='g2c-explorable-image__panel__title'])[2]");
	
	
	public static final By MadeFlavAnmplusSignOn5thImage = By.xpath("//*[@id='campaign-top']/div[6]/div[2]/div[5]");
	
	public static final By MadeFlavAnmplusClose5thImage = By.xpath("//div[@id='explorable-image__panel__spatula']/div[@class='explorable-image__panel__close']");
	
	//public static final By MadeFlavAnmplusTitle5thImage = By.xpath("//div[@id='explorable-image__panel__spatula']/div/div[@class='explorable-image__panel__title']");
	public static final By MadeFlavAnmplusTitle5thImage = By.xpath("(//div[@class='g2c-explorable-image__panel__title'])[5]");
	
	//public static final By MadeFlavAnmpluslink5thImage = By.xpath("//div[@id='explorable-image__panel__spatula']/div/a[@class='explorable-image__panel__cta']");
	public static final By MadeFlavAnmpluslink5thImage = By.xpath("//a[contains(text(),'Learn How')]");
	
	public static final By FullLineUpImages = By.xpath("//*[@class='line-up__content content-desktop']");
	public static final By FullLineUpImagesIcons = By.xpath("//*[@class='line-up__content content-desktop']/div");
	
	public static final By FullLineUpExclusiveImages = By.xpath("//*[@class='line-up__content content-desktop']");
	
	public static final By ShopAllSignGrillsBtn = By.xpath("//a[@class='shop-now__button' and contains(text(), 'Shop All Signature™ Grills')]");
	
	//public static final By ShopGas2CoalBtn = By.xpath("//a[@class='shop-now__button' and contains(text(), 'SHOP GAS-2-COAL')]");
	
	public static final By SignupMailtxt = By.xpath("//*[@id='eloquaemail']");
	
	public static final By SignupBtn = By.xpath("//button[@class='sticky-signup__submit submit']/span/span[text()='Sign Up']");
	
	public static final By ThankuMsg = By.xpath("//*[text()='Thank you for subscribing.']");

}
