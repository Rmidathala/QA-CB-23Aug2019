package businesscomponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.HomePage;
import uimap.PLPCookPage;
import uimap.PLPShopPage;
import uimap.ProductListingPage;

public class PLPCookPageComponents extends ReusableLibrary {

	WebDriverUtil wdu=new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public PLPCookPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	/*
	 * Method for validating sub category landing page header 
	 */
	public void validateCookSubMenuPageHeader()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");

			//Validate image of the sub category
			//gc.validateImage(System.getProperty("user.dir")+"\\images\\Recipes.png", shopSubCatg, shopSubCatg + " image");
			String breadcrumb=driver.findElement(PLPShopPage.breadcrumbList).getText().toLowerCase();
			if(breadcrumb.contains("recipes"))
			{
			report.updateTestLog("Shop Submenu", "Navigation to "+shopSubCatg+" is successful", Status.PASS);	
			}
			else
			{
				report.updateTestLog("Shop Submenu", "Navigation to "+shopSubCatg+" is not successful", Status.FAIL);
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateCookSubMenuPageHeader", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating filter name in Cook PLP pages 
	 */
	public void validateFilterNameInCookPLP()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");						

			//validate filter name
			if(wdu.objectExists(PLPShopPage.txtFilterName))	{

				gc.scrollToElement(PLPShopPage.txtFilterName);
				wdu.highlightElement(PLPShopPage.txtFilterName);
				String filterName = driver.findElement(PLPShopPage.txtFilterName).getText();
				if(filterName.equalsIgnoreCase(shopSubCatg))
					report.updateTestLog(shopSubCatg + " screen", "Filter criteria matched.", Status.PASS);
				else
					report.updateTestLog(shopSubCatg + " screen", "Filter criteria not matched.", Status.FAIL);
			}	else
				report.updateTestLog(shopSubCatg + " screen", "Filter is not showing correctly.", Status.FAIL);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateFilterNameInCookPLP", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating header product count in Cook PLP pages 
	 */
	public void validateProductCountInCookPLP()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");			
			String NoOfItems = driver.findElement(PLPShopPage.txtHeaderProdCount).getText().replace(" Items", "");

			//Validate count of products after matching with no of items mentioned in header
			wdu.highlightElement(PLPShopPage.txtHeaderProdCount);
			wdu.waitUntilElementEnabled(PLPShopPage.linkProducts, 10);
			if(wdu.objectExists(PLPShopPage.linkProducts))	{

				gc.loadMoreResults();
				int actualNoOfProducts = driver.findElements(PLPShopPage.linkProducts).size();
				if(Integer.parseInt(NoOfItems) == actualNoOfProducts)
					report.updateTestLog(shopSubCatg + " screen", shopSubCatg + " product count - "+actualNoOfProducts + " matched.", Status.PASS);
				else
					report.updateTestLog(shopSubCatg + " screen", shopSubCatg + " product count - "+actualNoOfProducts + " not matched.", Status.FAIL);
			}	else	{
				report.updateTestLog(shopSubCatg + " screen", shopSubCatg + " products are not available.", Status.FAIL);
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateProductCountInCookPLP", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate View All Recipes button in Cook page
	 */
	public void validateViewAllRecipes()	{
		try		{
			//Click on Cook link in the home page
			wdu.highlightElement(HomePage.linkCook);
			report.updateTestLog("Home Page", "Cook link is present.", Status.PASS);
			gc.clickItem(HomePage.linkCook, "Home", "Cook");

			//Scroll to and click on View All Recipes button
			wdu.waitUntilPageReadyStateComplete(20);
			wdu.waitUntilElementEnabled(PLPCookPage.btnViewAllRecipes, 10);
			gc.scrollToElement(PLPCookPage.btnViewAllRecipes);
			wdu.highlightElement(PLPCookPage.btnViewAllRecipes);
			driver.findElement(PLPCookPage.btnViewAllRecipes).click();			
			report.updateTestLog("Home Page", "Clicked on View All Recipes button.", Status.DONE);
			Thread.sleep(2000);

			//Validate navigated to Recipes Page
			for(int count=1 ; count<=5 ; count++ )	{
				if(driver.getCurrentUrl().contains("/recipes/"))	{
					report.updateTestLog("Recipes screen", "Navigated to Recipes screen.", Status.PASS);
					break;
				}
				else if(count == 5)
					report.updateTestLog("Recipes screen", "Navigation to Recipes screen failed.", Status.FAIL);
				else	{
					report.updateTestLog("Recipes screen", "Not navigated to Recipes screen in 3 seconds. Will retry in another 3 seconds.", Status.DONE);
					Thread.sleep(3000);
				}
			}			

			//Validate Recipes page header
			//gc.validateImage(System.getProperty("user.dir")+"\\images\\Recipes.png", "Recipes", "Recipes image");
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateViewAllRecipes", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating RECIPES BY INGREDIENTS sub links are navigating to proper URL
	 */
	public void validateRecipesByLinkNavigation()	{
		try		{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			String url = driver.getCurrentUrl().toLowerCase();

			if(url.contains("chicken"))			
				report.updateTestLog("Recipes screen", "Navigated to "+shopSubCatg+" page.", Status.PASS);
			else
				report.updateTestLog("Recipes screen", "Not navigated to "+shopSubCatg+" page.", Status.FAIL);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipesByLinkNavigation", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Sub links header of RECIPE COLLECTIONS under COOK
	 */
	public void validateSubRecipeCollectionsHeader()	{
		try		{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			String currentUrl;
			String expectedUrl;

			switch (shopSubCatg) {
			case "Digital Electric Smoker":
				expectedUrl = "/collections/digital-electric-smoker-recipes-collection/";
				break;

			case "Easter Feast":
				expectedUrl = "/collections/easter-feast/";
				break;

			case "Keep it Lean":
				expectedUrl = "/collections/keep-it-lean/";
				break;

			case "Burger Hall of Fame":
				expectedUrl = "collections/burger-hall-of-fame/";
				break;

			case "Top-Notch Tacos":
				expectedUrl = "collections/top-notch-tacos/";
				break;

			default:
				expectedUrl = "";
				break;
			}

			/*if(shopSubCatg.equalsIgnoreCase("Digital Electric Smoker"))		{
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\DigitalElectricSmoker.png", shopSubCatg, shopSubCatg + " image");
				if(currentUrl.contains("/collections/digital-electric-smoker-recipes-collection/"))
					report.updateTestLog(shopSubCatg+" screen", "Navigated to correct URL containing - "+currentUrl, Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Not navigated to correct URL containing - "+currentUrl, Status.FAIL);
			}
			else if(shopSubCatg.equalsIgnoreCase("Holiday Recipes"))	{
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\HolidayRecipes.png", shopSubCatg, shopSubCatg + " image");
				if(currentUrl.contains("/collections/holiday-recipes/"))
					report.updateTestLog(shopSubCatg+" screen", "Navigated to correct URL containing - "+currentUrl, Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Not navigated to correct URL containing - "+currentUrl, Status.FAIL);
			}
			else if(shopSubCatg.equalsIgnoreCase("The Big Easy®"))		{
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\TheBigEasy.png", shopSubCatg, shopSubCatg + " image");
				if(currentUrl.contains("/collections/the-big-easy-oilless-fryer-recipes/"))
					report.updateTestLog(shopSubCatg+" screen", "Navigated to correct URL containing - "+currentUrl, Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Not navigated to correct URL containing - "+currentUrl, Status.FAIL);
			}
			else if(shopSubCatg.equalsIgnoreCase("Thanksgiving"))	{
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\Thanksgiving.png", shopSubCatg, shopSubCatg + " image");
				if(currentUrl.contains("/collections/thanksgiving-collection/"))
					report.updateTestLog(shopSubCatg+" screen", "Navigated to correct URL containing - "+currentUrl, Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Not navigated to correct URL containing - "+currentUrl, Status.FAIL);
			}*/


			for(int count=1 ; count<=5 ; count++ )	{
				currentUrl = driver.getCurrentUrl();
				if(driver.getCurrentUrl().contains(expectedUrl))	{
					report.updateTestLog(shopSubCatg+" screen", "Navigated to correct URL containing - "+currentUrl, Status.PASS);
					break;
				}
				else if(count == 5)
					report.updateTestLog(shopSubCatg+" screen", "Not navigated to correct URL containing - "+currentUrl, Status.FAIL);
				else	{
					report.updateTestLog(shopSubCatg+" screen", "Not navigated to expected URL in 3 seconds. Will retry in another 3 seconds.", Status.DONE);
					Thread.sleep(3000);
				}
			}


		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipesByLinkNavigation", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating Cook Landing page
	 */
	public void validateCookLandingPage()	{
		try		{
			wdu.highlightElement(HomePage.linkCook);
			report.updateTestLog("Home Page", "Cook link is present.", Status.PASS);
			gc.clickItem(HomePage.linkCook, "Home", "Cook");

			//Validate Cook page header image
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Cook.png", "Cook", "Cook image");

			//Validate Browse Recipes section
			wdu.waitUntilElementEnabled(PLPCookPage.linkBrowseRecipes, 10);
			gc.scrollToElement(PLPCookPage.linkBrowseRecipes);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\CookBrowseRecipes.png", "Cook", "Browse Recipes section image");

			//Validate COOKIN WITH THE DIGITAL ELECTRIC SMOKER
			wdu.waitUntilElementEnabled(PLPCookPage.linkCookinWithElecSmoker, 10);
			gc.scrollToElement(PLPCookPage.linkCookinWithElecSmoker);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\CookinWithElectricSmoker.png", "Cook", "Cookin With Digital Electric Smoker section image");

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateCookLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating YOU MIGHT ALSO LIKE TAGS in RECIPE page
	 */
	public void validateAlsoLikeTags()	{
		try		{
			//Select first recipe
			wdu.waitUntilElementEnabled(PLPCookPage.linkCookFirstRecipe, 10);
			gc.scrollToElement(PLPCookPage.linkCookFirstRecipe);
			wdu.highlightElement(PLPCookPage.linkCookFirstRecipe);
			driver.findElement(PLPCookPage.linkCookFirstRecipe).click();
			report.updateTestLog("Select Recipe screen", "Clicked on the first recipe.", Status.PASS);

			//Navigate to and validate "You Might Also Like" title
			wdu.waitUntilElementEnabled(PLPCookPage.linkRecipeYouMightAlsoLikeTitle, 10);
			gc.scrollToElement(PLPCookPage.linkRecipeYouMightAlsoLikeTitle);
			wdu.highlightElement(PLPCookPage.linkRecipeYouMightAlsoLikeTitle);
			if(driver.findElement(PLPCookPage.linkRecipeYouMightAlsoLikeTitle).getText().equalsIgnoreCase("View More Recipes Like This"))
				report.updateTestLog("Recipe screen", "You Might Also Like these recipes section is showing.", Status.PASS);
			else
				report.updateTestLog("Recipe screen", "You Might Also Like these recipes section is not showing.", Status.FAIL);


			//Click on "You Might Also Like" tags
			wdu.waitUntilElementEnabled(PLPCookPage.linkRecipeYouMightAlsoLikeTags, 10);
			gc.scrollToElement(PLPCookPage.linkRecipeYouMightAlsoLikeTags);
			List<WebElement> findElements = driver.findElements(PLPCookPage.linkRecipeYouMightAlsoLikeTags);
			for (int i=0;i<findElements.size();i++) {
				String tagName = findElements.get(i).getText();
				
				findElements.get(i).click();
				Thread.sleep(2000);
				report.updateTestLog("Recipe page", "Clicked on tag - "+tagName, Status.PASS);
				driver.navigate().back();
				findElements = driver.findElements(PLPCookPage.linkRecipeYouMightAlsoLikeTags);
				/*if(driver.getCurrentUrl().contains("Fruit"))
					report.updateTestLog("Recipe page", "Navigated to page associated with tag "+tagName, Status.PASS);
				else
					report.updateTestLog("Recipe page", "Not navigated to page associated with tag "+tagName, Status.FAIL);
				}
				else
				{
					report.updateTestLog("Recipe page", "Didnot click  on tag - "+tagName, Status.FAIL);
				}*/
			}
			

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateAlsoLikeTags", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate Tag Category on the left side
	 */
	public void validateTagCategory()	{
		try		{
			wdu.highlightElement(HomePage.linkCook);
			report.updateTestLog("Home Page", "Cook link is present.", Status.PASS);
			gc.clickItem(HomePage.linkCook, "Home", "Cook");

			//View and click on 'VIEW ALL RECIPES' button
			wdu.waitUntilElementEnabled(PLPCookPage.btnViewAllRecipes, 10);
			gc.scrollToElement(PLPCookPage.btnViewAllRecipes);
			wdu.highlightElement(PLPCookPage.btnViewAllRecipes);
			driver.findElement(PLPCookPage.btnViewAllRecipes).click();
			report.updateTestLog("Cook page", "Clicked on View All Recipes button.", Status.PASS);

			/*
			 * //Verify 'TAG' category is present
			 * wdu.waitUntilElementEnabled(PLPCookPage.linkTagCategory, 10);
			 * gc.scrollToElement(PLPCookPage.linkTagCategory);
			 * wdu.highlightElement(PLPCookPage.linkTagCategory);
			 * report.updateTestLog("Cook page", "Category Tag is present in the screen.",
			 * Status.PASS);
			 */

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateTagCategory", "Exception is " + e, Status.FAIL);
		}
	}






	//========================================================//
	//		*********EU methods*************				  //
	//========================================================//

	public void validateRecipesByIngredientsSublinksForCountries()	{
		try	{
			String linkName = "";
			wdu.waitUntilElementEnabled(HomePage.linkRecipesForCountries, 10);
			int size = driver.findElements(ProductListingPage.lblRecipesByIngredientsSublinks).size();
			report.updateTestLog("Recipe By Ingredients sub-links validation", "Recipes by ingredients sublinks are present. Total no of sublinks are - "
					+size, Status.DONE);

			for(int i=1 ; i<=size ; i++)	{

				wdu.waitUntilElementEnabled(HomePage.linkRecipesForCountries, 10);
				wdu.mouseOver(HomePage.linkRecipesForCountries);
				Thread.sleep(2000);
				report.updateTestLog("Recipe By Ingredients sub-links validation", "Hover on recipes link.", Status.DONE);

				By locator = By.xpath("((//ul[@class='dropdown-menu megamenu row'])[2]/div[1]/ul/li/a)["+i+"]");
				wdu.waitUntilElementEnabled(locator, 5);
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				report.updateTestLog("Recipe By Ingredients sub-links validation", "Clicked on sub link - " + linkName, Status.DONE);

				validateRecipeFilterEurope(linkName);
				driver.navigate().back();
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipesByIngredientsSublinksForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}
	
	private void validateRecipeFilterEurope(String linkName)	{
		try	{
			String filterName ="";
			wdu.waitUntilElementEnabled(ProductListingPage.lblRecipesFilterName, 10);
			filterName = driver.findElement(ProductListingPage.lblRecipesFilterName).getText();
			if(filterName.toUpperCase().contains(linkName.toUpperCase()))
				report.updateTestLog("Recipe By Ingredients sub-links validation", "Page opened with following filter name - " + filterName, Status.PASS);
			else
				report.updateTestLog("Recipe By Ingredients sub-links validation", "Page opened with following filter name - " + filterName +
						". Expected filter name - "+linkName, Status.FAIL);
			Thread.sleep(1000);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipeFilterEurope", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void validateRecipeCollectionsSublinksForCountries()	{
		try	{
			String linkName = "", collectionHeaderName ="";
			wdu.waitUntilElementEnabled(HomePage.linkRecipesForCountries, 10);
			int size = driver.findElements(ProductListingPage.lblRecipeCollectionsSublinks).size();
			report.updateTestLog("Recipe Collections sub-links validation", "Recipe collections sublinks are present. Total no of sublinks are - "
					+size, Status.DONE);

			for(int i=1 ; i<=size ; i++)	{

				wdu.mouseOver(HomePage.linkRecipesForCountries);
				Thread.sleep(1000);
				report.updateTestLog("Recipe Collections sub-links validation", "Hover on recipes link.", Status.DONE);

				By locator = By.xpath("((//ul[@class='dropdown-menu megamenu row'])[2]/div[2]/ul/li/a)["+i+"]");
				wdu.waitUntilElementEnabled(locator, 5);
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				report.updateTestLog("Recipe Collections sub-links validation", "Clicked on sub link - " + linkName, Status.DONE);

				wdu.waitUntilElementEnabled(ProductListingPage.lblRecipeCollectionHeader, 10);
				collectionHeaderName = driver.findElement(ProductListingPage.lblRecipeCollectionHeader).getText();
				if(collectionHeaderName.trim().contains(linkName.toUpperCase()))
					report.updateTestLog("Recipe By Ingredients sub-links validation", "Page opened with following collection header name - " + 
							collectionHeaderName, Status.PASS);
				else
					report.updateTestLog("Recipe By Ingredients sub-links validation", "Page opened with following collection header name - " + 
							collectionHeaderName + ". Expected filter name - "+linkName, Status.FAIL);
				Thread.sleep(1000);

				driver.navigate().back();
				report.updateTestLog("Recipe Collections sub-links validation", "Clicked on back button to navigate to last page.", Status.DONE);
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipeCollectionsSublinksForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void validateRecipeLandingEurope()	{
		try	{			
			String text = "";
			wdu.waitUntilElementEnabled(HomePage.linkRecipesForCountries, 10);
			//driver.findElement(HomePage.linkRecipesForCountries).click();
			gc.clickOnElementByJScript(driver.findElement(HomePage.linkRecipesForCountries));
			report.updateTestLog("Recipe landing validation", "Clicked on recipe button at the main menu.", Status.DONE);
			Thread.sleep(2000);
			
			//Validate recipe container section validation
			wdu.waitUntilElementLocated(PLPCookPage.lblRecipeContainer, 10);
			text = driver.findElement(PLPCookPage.lblRecipeContainer).getText();
			if(driver.findElement(PLPCookPage.lblRecipeContainer).isDisplayed())
				report.updateTestLog("Recipe landing container validation", "Following text is displayed - "+text, Status.PASS);
			else
				report.updateTestLog("Recipe landing container validation", "Visual navigatio conatiner header is not displayed.", Status.FAIL);
			
			//check view all recipes button
			viewAllRecipesButtonEurope();
			
			//Check recipe collection page
			wdu.highlightElement(PLPCookPage.lblRecipeCollectionPod);
			report.updateTestLog("Recipe landing container validation", "Recipe landing collection pods are present.", Status.PASS);
			
			//check view collection button
			viewCollectionRecipeEurope();
			
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipeLandingEurope", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}
	
	public void viewAllRecipesButtonEurope()	{
		try	{
			
			//validate view all recipes button
			wdu.waitUntilElementEnabled(PLPCookPage.btnRecipeViewAll, 10);
			if(driver.findElement(PLPCookPage.btnRecipeViewAll).isDisplayed())
				report.updateTestLog("Recipe view all button validation", "View all recipes button is displayed in the recipe landing section.", Status.PASS);
			else
				report.updateTestLog("Recipe view all button validation", "View all recipes button is not displayed in the recipe landing section.", Status.FAIL);
			
			driver.findElement(PLPCookPage.btnRecipeViewAll).click();
			report.updateTestLog("Recipe view all button validation", "Clicked on view all recipes button", Status.DONE);
			
			wdu.waitUntilElementLocated(PLPCookPage.lblViewAllRecipeBreadcrumb, 10);
			report.updateTestLog("Recipe view all button validation", "Recipes breadcrumb is getting displayed.", Status.PASS);
			
			//Check collection header is getting displayed in recipe landing page
			wdu.highlightElement(PLPCookPage.lblViewAllRecipeCollection);
			if(driver.findElement(PLPCookPage.lblViewAllRecipeCollection).isDisplayed())
				report.updateTestLog("Recipe view all button validation", "Collection filter heading is getting displayed.", Status.PASS);
			else
				report.updateTestLog("Recipe view all button validation", "Collection filter heading is not getting displayed.", Status.FAIL);
			
			//check ingredients header is getting displayed in recipe landing page
			wdu.highlightElement(PLPCookPage.lblViewAllRecipeIngredient);
			if(driver.findElement(PLPCookPage.lblViewAllRecipeIngredient).isDisplayed())
				report.updateTestLog("Recipe view all button validation", "Ingredient filter heading is getting displayed.", Status.PASS);
			else
				report.updateTestLog("Recipe view all button validation", "Ingredient filter heading is not getting displayed.", Status.FAIL);
			
			driver.navigate().back();
			Thread.sleep(1000);
			report.updateTestLog("Recipe view all button validation", "Clicked on back button.", Status.DONE);
			
			
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in viewAllRecipesButtonValidation", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void viewCollectionRecipeEurope()	{
		try	{
			//validate view collection button
			wdu.waitUntilElementEnabled(PLPCookPage.btnRecipeViewCollection, 10);
			wdu.highlightElement(PLPCookPage.btnRecipeViewCollection);
			report.updateTestLog("Recipe landing collection validation", "Recipe view collection button is present.", Status.PASS);
			
			driver.findElement(PLPCookPage.btnRecipeViewCollection).click();
			report.updateTestLog("Recipe landing collection validation", "Clicked on view collection button in recipe page.", Status.DONE);
			
			wdu.waitUntilElementLocated(PLPCookPage.lblRecipeCollectionPod, 10);
			report.updateTestLog("Recipe landing collection validation", "Recipes pods are displayed after cliked on view collection button.", Status.PASS);
			
			driver.navigate().back();
			Thread.sleep(1000);
			report.updateTestLog("Recipe landing collection validation", "Clicked on back button.", Status.DONE);
			
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipeLandingEurope", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	/*
	 * Method to validate recipe tags available inside recipe lander page
	 */
	public void recipeTagsEurope()	{
		try	{
			String text = "";
			wdu.waitUntilElementEnabled(HomePage.linkRecipesForCountries, 10);
			//driver.findElement(HomePage.linkRecipesForCountries).click();
			gc.clickOnElementByJScript(driver.findElement(HomePage.linkRecipesForCountries));
			report.updateTestLog("Recipe landing validation", "Clicked on recipe button at the main menu.", Status.DONE);
			
			wdu.waitUntilElementLocated(PLPCookPage.linkTagsRecipeEurope, 10);
			int cnt = driver.findElements(PLPCookPage.linkTagsRecipeEurope).size();
			for(int i=1 ; i<=cnt ; i++)	{
				
				By pageNavigator = By.cssSelector("div.carousel__pagination > span:nth-child("+i+")");
				wdu.waitUntilElementEnabled(pageNavigator, 10);
				driver.findElement(pageNavigator).click();
				report.updateTestLog("Recipe landing validation", "Clicked on recipe lander cook tags pagination - "+i, Status.DONE);
				
				By locator = By.cssSelector("div.carousel__wrapper > div:nth-child("+i+") > a");				
				wdu.waitUntilElementEnabled(locator, 10);
				WebElement ele = driver.findElement(locator);
				text = ele.getText();
				ele.click();
				report.updateTestLog("Recipe landing validation", "Clicked on tags available inside recipe - "+text, Status.DONE);
				
				validateRecipeFilterEurope(text);
				driver.navigate().back();
			}
			
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateRecipeLandingEurope", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}
}
