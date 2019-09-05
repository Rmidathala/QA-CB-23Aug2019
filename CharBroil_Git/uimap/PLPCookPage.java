package uimap;

import org.openqa.selenium.By;

public class PLPCookPage {

	//Links
	public static final By btnViewAllRecipes = By.cssSelector("button.button.visual-nav__button");
	public static final By linkBrowseRecipes = By.cssSelector("h3.visual-nav__title.title");
	public static final By linkCookinWithElecSmoker = By.cssSelector("h2.lander-collection__title.title");
	public static final By linkCookFirstRecipe = By.xpath("//div[contains(@class,'ais-infinite-hits--item')]/div/a");
	public static final By linkRecipeYouMightAlsoLikeTitle = By.cssSelector("div.wprecipe__alsolike--title");
	public static final By linkRecipeYouMightAlsoLikeTags = By.xpath("//div[@class='wprecipe__alsolike--tags']/a");
	public static final By linkTagCategory = By.xpath("//div[text()='Tag']");


	//====================================================//
	//		*********EUROPE*************				  //
	//====================================================//
	
	
	public static final By lblRecipeContainer = By.cssSelector("div.visual-nav__container > h3");
	public static final By btnRecipeViewAll = By.cssSelector("div.visual-nav__container > div > button");
	public static final By lblViewAllRecipeBreadcrumb = By.cssSelector("li.recipes.breadcrumbs__crumb");
	public static final By lblViewAllRecipeCollection = By.cssSelector("#instant-search-facets-container > div:nth-child(4) > div > div");
	public static final By lblViewAllRecipeIngredient = By.cssSelector("#instant-search-facets-container > div:nth-child(5) > div > div:nth-child(1)");
	public static final By lblRecipeCollectionPod = By.cssSelector("a.content-pod");
	public static final By btnRecipeViewCollection = By.cssSelector("section.lander-collection > div:nth-child(2) > a");
	public static final By linkTagsRecipeEurope = By.cssSelector("div.carousel__wrapper > div");
	
}
