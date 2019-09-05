package uimap;

import org.openqa.selenium.By;

public class ProductDetailsPage {

	
	public static final By imgProductDetails = By.xpath("//*[@id='product-media']/div[1]/div[1]/div[1]//img");
	public static final By lblOutofStock = By.xpath("//div[@class='Product-summary__info_box']/span");
	public static final By btnAddtoCartPDP = By.xpath("//button[@title='Add to Cart']");
	public static final By selectColorPDP = By.xpath("//div[@id='option']");
	public static final By btnWhereToBy = By.xpath("//div[@aria-label='Where to Buy']");
	public static final By btnViewCartCheckoutPDP = By.xpath("//*[@id='interstitial-container']/div/div[3]/div[2]/button[2]/span/span");
		
	public static final By selectFirstConfigureOptionPDP = By.xpath("//div[@class='configurable-swatch-list list clearfix']/a[1]/div");

	public static final By lblModelNumber = By.xpath("//h5[@class='Product-summary__model']");
	public static final By selectQuantity = By.xpath("//select[@id='qty']");
	public static final By lblProductDescription = By.xpath("//div[@class='Product-summary__description']/p");
	public static final By lblProductName = By.xpath("//h1[@class='Product-summary__name']");
	
	public static final By lblProductNameOfPriceSpider = By.xpath("//div[@class='ps-product-details-title']");
	
	//public static final By btnWhereToBuy = By.xpath("//span[@class='ps-button-label']"); 
	
	public static final By subMenuSpecification = By.xpath("//div[@id='product-drawers']/div[1]");
	public static final By subMenuRatingReviews = By.xpath("//div[@id='product-drawers']/div[2]");
	public static final By subMenuQuestionAnswers = By.xpath("//div[@id='product-drawers']/div[3]");
	public static final By subMenuPartofGrills = By.xpath("//div[@id='product-drawers']/div[4]");
	public static final By subMenuGuideManuals = By.xpath("//div[@id='product-drawers']/div[5]");
	
	
	
	//********************************** 11th Jan ************************************************************
	
	public static final By lblProductHeader = By.xpath("//h1[@class='Product-summary__name']");
	
	
	
	public static final By brdcmbFirst = By.xpath("//ul[@class='breadcrumbs__list']/li[1]/a");
	public static final By brdcmbSecond = By.xpath("//ul[@class='breadcrumbs__list']/li[2]/a");
	public static final By brdcmbThird = By.xpath("//ul[@class='breadcrumbs__list']/li[3]/a");
	
	
	
	
	public static final By btnPartsForThisGrillSubmenu = By.xpath("//div[@class='drawer__title' and @id='parts']");
	public static final By btnSeeAllPartsofTheGrill = By.xpath("//a[contains(text(),'See All Parts For This Grill')]");
	public static final By lblPartsForThisGrill = By.xpath("//div[@class='page-title']/h1");
	public static final By lnkYoutubeThumbnail = By.xpath("//ul[@class='product-media__thumbnail-container']/li/img[contains(@alt,'YouTubeId')]");
	public static final By imgYoutube = By.xpath("//a[@class='popup-youtube']");
	public static final By frameYoutube = By.xpath("//iframe[contains(@src,'youtube')]");
	public static final By btnGuideManualsSubmenu = By.xpath("//div[@class='drawer__title' and @id='guides']");
	public static final By lnkManualPDF = By.xpath("//a[contains(@href,'pdf')]");
	
	
	public static final By btnSpecificationsSubmenu = By.xpath("//div[@id='product-drawers']/div[1]/div[1]/div");
	public static final By btnRatingsReviewSubmenu = By.xpath("//div[@id='product-drawers']/div[2]/div[1]/div");
	public static final By btnQuestionAndAnswersSubmenu = By.xpath("//div[@id='product-drawers']/div[3]/div[1]/div");
	
	
	public static final By lblSpecificationsSubmenuDetails = By.xpath("//div[@id='product-drawers']/div[1]/div[2]/div");
	
	public static final By lblFrequentlyBoughtTogether = By.xpath("//div[@class='box-title bought-together__header']");
	public static final By chkFrequentlyBoughtTogetherItem = By.xpath("//ul[@class='box-content bought-together__list']/li[1]/div//input");
	
	
	public static final By btnAddAllToCart = By.xpath("//span[contains(text(),'Add All To Cart')]");
	
	public static final By btnWhereToBuy = By.xpath("//span[contains(text(),'WHERE TO BUY')]");
	
	public static final By divOnlineSeller = By.xpath("//div[@class='ps-online-seller-listings']");
	
	public static final By lstContentBoughtTogether = By.xpath("//ul[@class='box-content bought-together__list']/li");
	
	/*************************************************************************************************************************************/
	
	
	
	public static final By chkAllPartsPDP = By.xpath("//input[@type='checkbox']");
	public static final By WebElementProductsInCart = By.xpath("//div[@class='cart__item cart-item']");
	public static final By WebElementFindParts = By.xpath("//div[@class='partfinder-tab__anchor-desktop__top']/i");
	public static final By txtFindPart = By.xpath("//input[@name='partfinder-request']");
	public static final By btnSearchFindPart = By.xpath("//div[@class='partfinder__input--submit']");
	public static final By lnkZoomPDP = By.xpath("//div[@class='product-media__zoom']/i");
	public static final By lnkZoomModalPDP = By.xpath("//div[@class='modal-content']");
	
	
	
	
	
	
	public static final By divRatingAndReviewCustomerImageList = By.xpath("//div[@class='fm-output fm-modern']/div//img");
	public static final By lnkRatingAndReviewExpand = By.xpath("//div[contains(text(),'Ratings & Reviews')]/div/div");
	
	public static final By priceSpiderCharbroil = By.xpath("//div[@class='ps-header-left']/img");
	
	
	
	
	public static final By lblAlsoInThisSeries = By.xpath("//h1[contains(text(),'Also in this Series')]");
	public static final By alsoInThisSeriesElements = By.xpath("(//div[contains(@id,'productSeriesCarousel')])[1]/div/div");
	
	
	public static final By linkExpandGuidesManuals = By.cssSelector("#guides > div >div");
	public static final By ddlColorOptions = By.cssSelector("#option");
	public static final By ddlColorOptionStainlessSteel = By.cssSelector("#option1268");
	public static final By ddlBodyStyleOptions = By.cssSelector("#attribute533");
	

	public static final By lnkSpecificationsPDP = By.xpath("//*[@id='specifications']");
	public static final By lblWarning = By.xpath("//*[text()='WARNING']");
	
	
	/******************************************** CHARBROIL EUROPE ****************************************************************************************************************/
	
	
	
	public static final By lnkCharcoalSupport = By.xpath("//div[@class='header__column']//a[contains(@href,'charcoal-support')]");
	public static final By lnkElectricGrillSupport = By.xpath("//div[@class='header__column']//a[contains(@href,'electric-grill-support')]");
	public static final By lnkGasGrillSupport = By.xpath("//div[@class='header__column']//a[contains(@href,'gas-grill-support')]");
	public static final By lnkSmokerRoasterSupport = By.xpath("//div[@class='header__column']//a[contains(text(),'Smoker & Roaster Support')]");
	public static final By lnkAccessorySupport = By.xpath("//div[@class='header__column']//a[contains(text(),'Accessory Support')]");
	
	
	
	public static final By lblCharcoalSupport = By.xpath("//h1[contains(text(),'CHARCOAL SUPPORT')]");
	public static final By lblElectricGrillSupport = By.xpath("//h1[contains(text(),'ELECTRIC GRILL SUPPORT')]");
	public static final By lblgasGrillSupport = By.xpath("//h1[contains(text(),'GAS GRILL SUPPORT')]");
	public static final By lblSmokerRoasterSupport = By.xpath("//h1[contains(text(),'SMOKER & ROASTER SUPPORT')]");
	
	
	public static final By lnkSupport_EU = By.xpath("//li[@class='nav-item nav-mega-right dropdown menu-large']/a");
	
	public static final By lblPageTitle_EU = By.xpath("//div[@class='page-title']");
	
	public static final By divsSupportSection = By.xpath("//div[@class='example-help-tile']");
	
	
	/******************* Tips EU*********************************************************/
	public static final By sublnksHeaderMenuTips = By.xpath("//ul[@class='nav navbar-nav']/li[3]//ul[@class='header__list']/li/a");
	
	public static String sublnksHeaderMenuTipsText = "//ul[@class='nav navbar-nav']/li[3]//ul[@class='header__list']/li/a";
	
	public static final By lnkHeaderMenuTips = By.xpath("//ul[@class='nav navbar-nav']/li[3]/a");
	
	public static final By lblTipsLinkPageHeader = By.xpath("//div[@class='collection__label callout__label-container']");
	
	public static final By divsTipsPage = By.xpath("//div[@class='carousel__wrapper swiper-wrapper visual-nav__wrapper']/div");
	
	
	
	
	public static final By whyCharBroilBreadCrumb_2 = By.xpath("//ul[@class='breadcrumbs__list']/li[2]");
	public static final By whyCharBroilBreadCrumb_1 = By.xpath("//ul[@class='breadcrumbs__list']/li[1]/a");
	
	public static final By whyCharBroilHeroImage = By.xpath("//div[@class='Secondary-cms__hero']");
	
	
	
	public static final By lblPromotionPolicyDiscountDetails = By.xpath("//div[@class='std']/ul[1]");
	public static final By lblPromotionShippingDetails = By.xpath("//div[@class='std']/ul[2]");
	public static final By lblPromotionShippingDetailsDK = By.xpath("//div[@class='std']/ul");
	public static final By lblPromotionPolicyPricingTermDetails = By.xpath("//div[@class='std']/ul[3]");
	
	
	public static final By lblPromotionShippingHeader = By.xpath("//div[@class='std']/h3[1]");
	public static final By lblPromotionShippingHeaderDK = By.xpath("(//div[@class='std']//h3)[1]");
	public static final By lblPromotionGeneralPricingTermHeader = By.xpath("//div[@class='std']/h3[2]");
	public static final By lblPromotionGeneralPricingTermHeaderDK = By.xpath("(//div[@class='std']//h3)[2]");
	
	public static final By lblSectionRatingAndReview = By.xpath("//div[@id='ratings']");
	
	
	
	
	
	
}
