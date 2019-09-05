package uimap;

import org.openqa.selenium.By;

public class PLPShopPage {

	//Links
	public static final By linkProducts = By.xpath("//div[@class='algolia-result--result-wrapper']");
	public static final By linkGridView = By.xpath("//div[@id='plp-grid-button']");
	public static final By linkListView = By.xpath("//div[@id='plp-list-button']");
	
	//Text
	public static final By txtHeaderProdCount = By.cssSelector("h2.page-header__title");
	public static final By txtBreadCrumb = By.xpath("//html[@id='top']/body/div/div/div[5]/ul/li[4]");
	public static final By txtFilterName = By.cssSelector("a.ais-current-refined-values--link");
	public static final By txtProductPrice = By.xpath("//div[@class='algolia-result--result-wrapper']/a/div/div[3]/div/div/span[1]");
	
	//DropDownList
	public static final By ddlSortByOption = By.cssSelector("select.ais-sort-by-selector");
	
	//Buttons
	public static final By btnLoadMoreResults = By.cssSelector("div.ais-infinite-hits--showmore > button");
	
	
	public static final By breadcrumbList = By.xpath("//*[@class='breadcrumbs__list']");
	
	
}
