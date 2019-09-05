package uimap;

import org.openqa.selenium.By;

public class ProductListingPage {

	public static final By lblSortByPLP = By.xpath("//*[@id='filter-header']/div/div/div[2]/div[2]");
	public static final By lnkFirstProductPLP = By.xpath("//*[@id='instant-search-results-container']/div/div[1]/div[1]/div/a");
	public static final By divAllPLP = By.xpath("//*[@id='instant-search-results-container']/div/div[1]");

	public static final String lnkProductPLP = "//*[@id='instant-search-results-container-product']/div/div[1]/";
	public static final By lblSortBy = By.xpath("//div[contains(text(),'SORT BY')]");

	

	public static final By imgProductPLPViaMenu = By.xpath("//div[@class='ais-infinite-hits']/div[1]//a/div");



	public static final By lblOnlineSale = By.xpath("//h1[contains(text(),'On Sale')]");
	public static final By divLeftNavigationPane = By.xpath("//div[@id='algolia-left-container']");
	public static final By divRightNavigationPane = By.xpath("//div[@id='algolia-right-container']");

	public static final By lblEllenShowHeader = By.xpath("//div[@class='std']/h1");
	public static final By btnSelectEllenShow = By.xpath("//a[contains(text(),'Select')]");


	public static final By lblHoliday2017 = By.xpath("//h1[contains(text(),'Holiday 2018')]");


	//========================================================//
	//		*********EU methods*************				  //
	//========================================================//

	public static final By lblSortByPLPEU = By.xpath("//*[@id='filter-header']/div/div/div[2]/div[2]");
	public static final By linkResultsProductsTabEU = By.cssSelector("a.searchtabs__button.searchtabs__button--product");
	public static final By linkResultsRecipesTabEU = By.cssSelector("a.searchtabs__button.searchtabs__button--recipe");
	public static final By linkResultsHowToTabEU = By.cssSelector("a.searchtabs__button.searchtabs__button--howto");
	public static final By linkResultsSupportTabEU = By.cssSelector("a.searchtabs__button.searchtabs__button--support");
	public static final By lblPageHeaderTitle = By.cssSelector("h2.page-header__title");
	public static final By lblNoResultHeader = By.cssSelector("h2.algolia-result-none__title");
	public static final By lblPLPBreadcrumb = By.cssSelector("ul.breadcrumbs__list");

	public static final By lblRecipesByIngredientsSublinks = By.xpath("(//ul[@class='dropdown-menu megamenu row'])[2]/div[1]/ul/li/a");
	public static final By lblRecipeCollectionsSublinks = By.xpath("(//ul[@class='dropdown-menu megamenu row'])[2]/div[2]/ul/li/a");
	public static final By lblRecipesFilterName = By.cssSelector("div.ais-current-refined-values--item > a");
	public static final By lblRecipeCollectionHeader = By.cssSelector("h1.collection__title.callout__title");

	public static final By lblProductsSublinks = By.xpath("(//ul[@class='dropdown-menu megamenu row'])[1]/div[1]/ul/li/a");
	public static final By lblAccessoriesSublinks = By.xpath("(//ul[@class='dropdown-menu megamenu row'])[1]/div[2]/ul/li/a");
	public static final By lblProductsLanderHeader = By.cssSelector("div.lander-hero__content.lander-hero__content--vertical-center > h1");

	public static final By lblProductLinkForCountries = By.xpath("((//ul[@class='dropdown-menu megamenu row'])[1]/div[1]/ul/li/a)[1]");
	public static final By lblShopMenuHeader = By.cssSelector("div.shopmenu__title");
	public static final By lblAccessoriesLinkForCountries = By.xpath("((//ul[@class='dropdown-menu megamenu row'])[1]/div[2]/ul/li/a)[1]");

	public static final By lblProductsMainMenuDiffIcons = By.cssSelector("div.shopmenu > div >div");
	public static final By lblRecipePageHeader = By.cssSelector("div.rightinner > div:nth-child(3)");
	
	
	//********************************************** CB EU 08/03 *******************************************************************************/	
	
	public static final By lnk1stMenuNav = By.xpath("//ul[@class='nav navbar-nav']/li[1]/a");
	public static final By lnk1stMenuNavSubMenu2ndLink = By
			.xpath("//ul[@class='nav navbar-nav']/li[1]/ul/div[1]/ul/li[3]/a");

	public static final By lblPLPHeaderLeftPaneYellowBkgrnd = By
			.xpath("//div[@class='lander-hero__content lander-hero__content--vertical-center']/h1");

	public static final By lblPromotionShippingHeader = By.xpath("//div[@class='std']/h3[1]");
	public static final By lblPromotionGeneralPricingTermHeader = By.xpath("//div[@class='std']/h3[2]");
	public static final By lnkHomeBreadCrumb = By.xpath("//li[@class='home breadcrumbs__crumb']/a");
	public static final By lnlProductBreadCrumb = By.xpath("//ul[@class='breadcrumbs__list']/li[2]");
	public static final By lnkCategoryBreadCrumb = By.xpath("//ul[@class='breadcrumbs__list']/li[4]");
	public static final By lnkPLPProducts = By.xpath("//div[@class='ais-infinite-hits']/div");
	public static final By lnkGridView = By.xpath("//div[@id='plp-grid-button']"); // hits--grid-button |
																					// hits--grid-button hits--inactive
	public static final By lnkListView = By.xpath("//div[@id='plp-list-button']"); // hits--list-button hits--inactive |
																					// hits--list-button
	public static final By btnShowMoreResults = By.xpath("//div[@class='ais-infinite-hits--showmore']/button");
	public static final By selectSortByPLP = By.xpath("//select[@class='ais-sort-by-selector']");
	
	
	
	public static final By lblKeywordSearchHeaderPLP = By.xpath("//span[@class='page-header__quotes']");

	//************************************************************************************************************************************************/	
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
