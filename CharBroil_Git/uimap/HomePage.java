package uimap;

import org.openqa.selenium.By;

/**
 * UI Map for MasterPage 
 */
public class HomePage {

	//Links
	public static final By linkContactUs = By.xpath("(//a[text()='Contact us'])[1]");
	public static final By linkChatWith = By.xpath("//a[text()='Chat During Business Hours (9AM-9PM EST)']");
	public static final By linkTelephone = By.xpath("(//a[text()='1-866-239-6777'])[1]");
	public static final By linkProductReg = By.xpath("(//a[text()='Product Registration'])[1]");
	public static final By linkMyAcnt = By.xpath("(//a[text()='My Account'])[1]");
	public static final By linkShop = By.xpath("//li[@id='dropdown-shop']/a");
	public static final By linkCook = By.xpath("//li[@id='dropdown-cook']/a");
	public static final By linkLearn = By.xpath("//li[@id='dropdown-learn']/a");
	public static final By linkSupport = By.xpath("//*[@id='charbroil-collapse']/ul/li[5]/a");

	public static final By linkResultsProductsTab = By.id("instant-search-button-product");
	public static final By linkResultsRecipesTab = By.id("instant-search-button-recipe");
	public static final By linkResultsHowToTab = By.id("instant-search-button-howto");
	public static final By linkResultsSupportTab = By.id("instant-search-button-support");

	//Links for What's Hot portion
	public static final By linkFeaturedWhatsHot = By.xpath("//h2[text()='Featured']");
	public static final By linkGrillForEveryGriller = By.xpath("//h1[text()='A Grill For Every Griller']");
	public static final By linkGrillionYearsOfInnovation = By.xpath("(//div[@class='timeline__background '])[1]");

	//Links for A GRILL FOR EVERY GRILLER section
	public static final By linkGrillForEveryGrillerCharcoal = By.cssSelector("p.grillcarousel__type--text");
	public static final By btnGrillForEveryGrillerCharcoal = By.cssSelector("a.shop-button");

	public static final By linkGrillForEveryGrillerElectric = By.cssSelector("#electric-carousel > p.grillcarousel__type--text");
	public static final By btnGrillForEveryGrillerElectric = By.cssSelector("div.grillcarousel__grills--container.electric-carousel > div.grillcarousel__grills--shop > a.shop-button");

	public static final By linkGrillForEveryGrillerGas = By.cssSelector("#gas-carousel > p.grillcarousel__type--text");
	public static final By btnGrillForEveryGrillerGas = By.xpath("//a[contains(text(),'Shop All\n                        Gas                        Grills                                                                            (39)')]");

	public static final By linkGrillForEveryGrillerPortable = By.cssSelector("#portable-carousel > p.grillcarousel__type--text");
	public static final By btnGrillForEveryGrillerPortable = By.xpath("//a[contains(text(),'Shop All\n                        Portable                        Grills                                                                            (8)')]");

	public static final By linkGrillForEveryGrillerSmokers = By.cssSelector("#smokers-carousel > p.grillcarousel__type--text");
	public static final By btnGrillForEveryGrillerSmokers = By.xpath("//a[contains(text(),'Shop All\n                        Smokers & Fryers                                                                                                    (22)')]");

	//Links for Now You're Cookin section
	public static final By linkGiftsForEveryGriller = By.xpath("//h2[text()='Featured']");

	public static final By linkGiftsForEveryGrillerShopNow = By.xpath("(//a[contains(text(),'Shop Now')])[3]");
	public static final By linkInfraredGrillsLearnMore = By.xpath("(//a[contains(text(),'Learn More')])[2]");
	public static final By linkHolidayRecipesFindOut = By.xpath("(//a[contains(text(),'Find out more')])[3]");
	public static final By linkWinterizeGrillShopNow = By.xpath("(//a[contains(text(),'Shop Now')])[4]");
	public static final By linkGlazedHamFindOutMore = By.xpath("(//a[contains(text(),'Find out more')])[4]");

	public static final By linkNowCookinElement2 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div[3]/span[2]");
	public static final By linkNowCookinElement3 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div[3]/span[3]");
	public static final By linkNowCookinElement4 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div[3]/span[4]");
	public static final By linkNowCookinElement5 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div[3]/span[5]");

	//Links for Whats Hot section
	public static final By imgWhatsHotRed = By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[3]/div/div/div[3]/div[2]/div[2]/div[2]");
	public static final By linkWhatsHotRedPlus1 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[3]/div[2]/div[2]/div[2]/div[1]");
	public static final By linkWhatsHotRedPlus2 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[3]/div[2]/div[2]/div[2]/div[2]");
	public static final By linkWhatsHotRedPlus3 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[3]/div[2]/div[2]/div[2]/div[3]");
	public static final By linkWhatsHotRedPlus4 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[3]/div[2]/div[2]/div[2]/div[4]");
	public static final By linkWhatsHotRedPlus5 = By.xpath("//html[@id='top']/body/div/div/div[3]/div/div/div[3]/div[2]/div[2]/div[2]/div[5]");

	//public static final By linkExploreBigEasyFryer = By.xpath("//a[text()='Explore the big easy® fryer']");
	public static final By linkCheckOutModularKitchen = By.xpath("//a[text()='Check it out']"); 

	//Arka
	public static final By txtSearchItemHomePage = By.xpath("//div[@class='desktop-search']//span[1]/input");
	public static final By lnkMyAccount = By.xpath("(//a[@title='My Account'])[1]");
	public static final By lnkCreateAccount = By.xpath("//a[@title='Create an Account']");



	//Swarnava
	public static final By linkHeaderLogo = By.xpath("//a[@class='header__logo']");
	public static final By linkPortableGrills = By.linkText("Portable Grills");

	//Links at footer
	public static final By linkContactNo = By.cssSelector("li.contact__phone > a");
	public static final By linkSendEmail = By.linkText("Send an Email");
	//	public static final By linkProductHelp = By.linkText("Product Help");
	public static final By linkProductHelp = By.xpath("//div[@class='footer__list']/ul/li/a[text()='Product Help']");	
	public static final By linkProductHelpTitle = By.cssSelector("h2.callout__title");
	public static final By linkFormsInformation = By.linkText("Forms & Information");
	public static final By linkFormsInformationTitle = By.cssSelector("div.form-information-block > h2");
	public static final By linkSupportCenters = By.linkText("Support Centers");
	public static final By linkReplacementParts = By.linkText("Replacement Parts");
	public static final By linkAboutUs = By.xpath("//a[text()='About Us']");
	public static final By linkAboutUsContentFirst = By.cssSelector("h2");
	public static final By linkCareers = By.linkText("Careers");
	public static final By linkCbGear = By.linkText("Char-Broil� Gear");
	public static final By linkSaberGrills = By.xpath("//a[contains(text(),'Saber') or contains(text(),'SABER')]");
	public static final By linkDancookGrills = By.xpath("//a[contains(text(),'Dancook')]");
	public static final By linkOklahomaJoeSmokers = By.xpath("//a[contains(@href,'http://www.oklahomajoes')]");
	public static final By linkIdeaSubmission = By.xpath("//section[@id='footer-company']/div/ul/li[6]/a");
	public static final By linkPrivacyPolicy = By.linkText("Privacy Policy");
	public static final By linkTermsOfUse = By.xpath("(//a[contains(text(),'Terms of Use')])[2]");
	
	public static final By linkAccessibility = By.linkText("Accessibility");


	public static final By linkTermsOfUseAtHome = By.linkText("Terms of Use"); 

	public static final By linkCaTransparencySupplyChains = By.linkText("CA Transparency in Supply Chains Act");
	public static final By linkPageHeader = By.cssSelector("h1");

	//Links for Social Media at footer
	public static final By linkFacebookAtFooter = By.linkText("Facebook");
	public static final By linkPinterestAtFooter = By.linkText("Pinterest");
	public static final By linkInstagramAtFooter = By.linkText("Instagram");
	public static final By linkYoutubeAtFooter = By.linkText("YouTube");
	public static final By linkTwitterAtFooter = By.linkText("Twitter");

	//TextBox
	public static final By txtSearch = By.xpath("(//input[@id='search_desktop'])");
	public static final By txtSearchResult = By.xpath("//*[@id='algolia-autocomplete-listbox-0']/div/div[1]/div/div/div[1]");
	public static final By txtFindAPartSearch = By.xpath("//input[@name='partfinder-request']");	
	//div[text()='Find A Part']//parent::div/div[2]/input
	
	//Buttons
	public static final By btnFindAPart = By.xpath("//div[@class='partfinder-tab__anchor-desktop__top']/i");	
	public static final By btnFindAPartSearch = By.xpath("//div[@class='partfinder__input--submit']/i");
	public static final By linkFindMyModel = By.xpath("//a[text()='How to find the model number on your grill']");
	public static final By lstSortBy = By.xpath("//*[@id='parts-sort-by']");
	public static final By lnkAddToCart = By.xpath("(//*[text()='Add to Cart'])[2]");          //*[@id='parts-list-table']//tbody/tr[2]/td[3]/a[2]
	public static final By lnkGuidesSection = By.xpath("//span[@class='guides__manual--title']");
	public static final By lblGuideSectionHeader = By.xpath("(//div[@class='partfinder__header'])[2]");
	public static final By lblProductSectionHeader = By.xpath("(//div[@class='partfinder__header'])[1]");
	public static final By lblAddToCartSuccessMsg = By.xpath("//li[@class='success-msg']");
	
		
	
	
	public static final By linkGrills = By.xpath("//li/a[text()='Grills']");
	public static final By linkSmokersFryers = By.xpath("//li/a[text()='Smokers & Fryers']");
	public static final By linkAccessories = By.xpath("//li/a[text()='Accessories']");
	public static final By linkParts = By.xpath("//a[@class='partfinder-tab__anchor-desktop']");
	public static final By linkBreadCrumb = By.xpath("//ul[@class='breadcrumbs__list']/li[3]");

	//Links at Shop landing page
	public static final By linkShopMenuTitle = By.cssSelector("div.shopmenu__title");

	//************************************************************ Arka *****************************************************************************
	public static final By lnkCart = By.xpath("//span[@class='header__cart-count']");


	public static final By txtMyAccLink = By.linkText("My Account");

	//public static final By CountryDropdown=By.xpath("//*[@class='language-switcher']");
	public static final By CountryDropdown=By.xpath("//*[@class='language-switcher dropdown']");

	//*************************************************************************************************************************************************/


	public static final By lnkLiveChat=By.xpath("//div[@class='top-links hidden-md-down']/div/div[1]//a");

	//Find A Part results section
	public static final By lblFindAPartResultHeader = By.cssSelector("div.page-title > h1");
	public static final By lblPartFinderHeader = By.cssSelector("div.partfinder__header");
	public static final By linkGuideForPartsName = By.cssSelector("a.guides__link > div.guides__link--title");
	public static final By linkGuideManualTitle = By.cssSelector("span.guides__manual--title");
	public static final By txtFindAPart = By.xpath("//input[@name='partfinder-request']");
	public static final By btnFindAPartSearchSubmit = By.xpath("//div[@class='partfinder__input--submit']/i");


	//========================================================//
	//		*********EU methods*************				  //
	//========================================================//


	public static final By btnAcceptCookies = By.cssSelector("a.optanon-allow-all");
	public static final By linkContactUsForCountries = By.xpath("(//a[@class='top-links__anchor'])[1]");
	public static final By linkContactUsHeaderEU = By.xpath("//h1[text()='Contact Us']");
	public static final By linkContactUsHeaderFR = By.xpath("//h1[text()='Nous contacter']");
	public static final By linkContactUsHeaderDE = By.xpath("//h1[text()='Kontakt']");
	public static final By linkContactUsHeaderDK = By.xpath("//h1[text()='Kontakt Os']");
	public static final By linkProductRegForCountries = By.xpath("(//a[@class='top-links__anchor'])[2]");
	public static final By linkHomeFlagDropdown = By.xpath("(//div[@id=\"dropdownMenuLink\"]/span)[1]");
	public static final By linkFlagDropdownOptions = By.cssSelector("#dropdownMenulinks");
	public static final By linkFlagDansk = By.xpath("(//div[@id='dropdownMenulinks']/a[1])[1]");
	public static final By linkFlagDeutsch = By.xpath("(//div[@id='dropdownMenulinks']/a[2])[1]");
	public static final By linkFlagFrancais = By.xpath("(//div[@id='dropdownMenulinks']/a[3])[1]");
	public static final By linkFlagUSA = By.xpath("(//div[@id='dropdownMenulinks']/a[4])[1]");

	//public static final By linkProductsEU = By.xpath("(//a[text()='Products'])[1]");
	//public static final By linkRecipesEU = By.xpath("(//a[text()='Recipes'])[1]");
	//public static final By linkTipsEU = By.xpath("(//a[text()='Tips'])[1]");
	public static final By linkProductsForCountries = By.cssSelector("ul.nav.navbar-nav > li:nth-child(1) > a");
	public static final By linkRecipesForCountries = By.cssSelector("ul.nav.navbar-nav > li:nth-child(2) > a");
	public static final By linkTipsForCountries = By.cssSelector("ul.nav.navbar-nav > li:nth-child(3) > a");
	public static final By linkSupportForCountries = By.cssSelector("ul.nav.navbar-nav > li:nth-child(5) > a");

	public static final By txtSearchItem = By.xpath("(//input[@id='search'])[1]");
	public static final By linkWhatsHotRedPlusEU1 = By.cssSelector("div.featured-product__actions > div:nth-child(1)");
	public static final By linkWhatsHotRedPlusEU2 = By.cssSelector("div.featured-product__actions > div:nth-child(2)");
	public static final By linkWhatsHotRedPlusEU3 = By.cssSelector("div.featured-product__actions > div:nth-child(3)");
	public static final By linkWhatsHotRedPlusEU4 = By.cssSelector("div.featured-product__actions > div:nth-child(4)");
	public static final By linkWhatsHotRedPlusEU5 = By.cssSelector("div.featured-product__actions > div:nth-child(5)");
	public static final By linkExploreGrillButtonEU = By.cssSelector("a.featured-product__button.button");
	public static final By linkGrillForEveryGrillerCharcoalEU = By.cssSelector("div.grillcarousel__types > div:nth-child(1) >p");
	public static final By linkGrillForEveryGrillerElectricEU = By.cssSelector("div.grillcarousel__types > div:nth-child(2) >p");
	public static final By linkGrillForEveryGrillerGasEU = By.cssSelector("div.grillcarousel__types > div:nth-child(3) >p");
	public static final By linkGrillForEveryGrillerPortableEU = By.cssSelector("div.grillcarousel__types > div:nth-child(4) >p");
	public static final By linkGrillForEveryGrillerSmokersEU = By.cssSelector("div.grillcarousel__types > div:nth-child(5) >p");
	public static final By btnDiscoverCharcoalGrillsEU = By.xpath("(//div[@class='grillcarousel__grills--shop'])[1]/a");
	public static final By btnDiscoverElectricGrillsEU = By.xpath("(//div[@class='grillcarousel__grills--shop'])[2]/a");
	public static final By btnDiscoverGasGrillsEU = By.xpath("(//div[@class='grillcarousel__grills--shop'])[3]/a");
	public static final By btnDiscoverPortableGrillsEU = By.xpath("(//div[@class='grillcarousel__grills--shop'])[4]/a");
	public static final By btnDiscoverSmokersGrillsEU = By.xpath("(//div[@class='grillcarousel__grills--shop'])[5]/a");

	public static final By linkFooterContactSendEmailEU = By.cssSelector("ul.contact > li:nth-child(1) > a");
	public static final By linkFooterImprintEU = By.cssSelector("ul.contact > li:nth-child(2) > a");
	//public static final By lblImprintHeaderEU = By.xpath("//h1[text()='Imprint']");
	public static final By lblImprintHeaderForCountries = By.cssSelector("div.page-title > h1");
	//public static final By linkProductHelpEU = By.xpath("(//a[text()='Product Help'])[2]");
	public static final By linkProductHelpForCountries = By.xpath("(//div[@class='footer__list'])[2]/ul/li/a");
	public static final By lblPageTitleEU = By.cssSelector("div.page-title > h1");
	public static final By linkCompanyDancookEU = By.cssSelector("#footer-company > div > ul >li:nth-child(1)");
	public static final By linkCompanyMagazineEU = By.cssSelector("#footer-company > div > ul >li:nth-child(2)");

	public static final By linkDataSubjectAccessRequest = By.xpath("//a[text()='Data Subject Access Request']");

}