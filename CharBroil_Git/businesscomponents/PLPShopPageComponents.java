package businesscomponents;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.HomePage;
import uimap.PLPShopPage;
import uimap.ProductListingPage;

public class PLPShopPageComponents extends ReusableLibrary {

	WebDriverUtil wdu=new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public PLPShopPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	/*
	 * Method for validating sub category landing page header 
	 */
	public void validateSubMenuPageHeader()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			String breadcrumb=driver.findElement(PLPShopPage.breadcrumbList).getText().toLowerCase();
			if(breadcrumb.contains(shopSubCatg.toLowerCase()))
			{
			report.updateTestLog("Shop Submenu", "Navigation to "+shopSubCatg+" is successful", Status.PASS);	
			}
			else
			{
				report.updateTestLog("Shop Submenu", "Navigation to "+shopSubCatg+" is not successful", Status.FAIL);
			}

			//Validate image of the sub category
			//gc.validateImage(System.getProperty("user.dir")+"\\images\\"+shopSubCatg+".png", shopSubCatg, shopSubCatg + " image");

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateSubCategoryPageHeader", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating bread crumb 
	 */
	public void validateBreadCrumb()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			String breadCrumb = driver.findElement(PLPShopPage.txtBreadCrumb).getText();

			//Validate bread crumb
			wdu.highlightElement(PLPShopPage.txtBreadCrumb);
			if(breadCrumb.equalsIgnoreCase(shopSubCatg))
				report.updateTestLog(shopSubCatg + " screen", "Bread crumb showing correct.", Status.PASS);
			else
				report.updateTestLog(shopSubCatg + " screen", "Bread crumb showing wrong.", Status.FAIL);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateBreadCrumb", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating header product count in PLP pages 
	 */
	public void validateProductCountInPLP()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			wdu.waitUntilElementEnabled(PLPShopPage.txtHeaderProdCount, 30);
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
			report.updateTestLog("Exception in validateProductCountInPLP", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating filter name in PLP pages 
	 */
	public void validateFilterNameInPLP()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");						

			//validate filter name
			if(wdu.objectExists(PLPShopPage.txtFilterName))	{

				gc.scrollToElement(PLPShopPage.txtFilterName);
				wdu.highlightElement(PLPShopPage.txtFilterName);
				Thread.sleep(1000);
				String filterName = driver.findElement(PLPShopPage.txtFilterName).getText();
				if(filterName.equalsIgnoreCase(shopSubCatg))
					report.updateTestLog(shopSubCatg + " screen", "Filter criteria matched.", Status.PASS);
				else
					report.updateTestLog(shopSubCatg + " screen", "Filter criteria not matched.", Status.FAIL);
			}	else
				report.updateTestLog(shopSubCatg + " screen", "Filter is not showing correctly.", Status.FAIL);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateFilterNameInPLP", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating sort by price in PLP pages 
	 */
	public void validateSortByPriceInPLP()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");						

			//Validate Sort By option
			wdu.highlightElement(PLPShopPage.ddlSortByOption);
			new Select(driver.findElement(PLPShopPage.ddlSortByOption)).selectByVisibleText("Price Low - High");
			Thread.sleep(5000);
			wdu.waitUntilPageReadyStateComplete(10);
			if(wdu.objectExists(PLPShopPage.linkProducts))	{
				int maxsize = 4;
				List<WebElement> priceList = driver.findElements(PLPShopPage.txtProductPrice);
				int avlSize = priceList.size();

				if(maxsize>avlSize)
					maxsize = avlSize;

				Double oldVal = 0.00;
				for(int i=0;i<maxsize;i++)	{
					WebElement price = priceList.get(i);
					//for (WebElement price : priceList) {
					Double val = Double.parseDouble(price.getText().replace("$", ""));
					if(val >= oldVal)	{
						report.updateTestLog(shopSubCatg + " screen", "Sorting is working fine - PreviousPrice: "+oldVal+"; NextPrice: "+val, Status.PASS);
						oldVal = val;						
					}	else	{
						report.updateTestLog(shopSubCatg + " screen", "Sorting is not working fine - PreviousPrice: "+oldVal+"; NextPrice: "+val, Status.FAIL);	
					}
				}
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateSortByPriceInPLP", "Exception is " + e, Status.FAIL);
		}
	}

	public void validateGridListView()		{

		try		{
			wdu.waitUntilElementEnabled(PLPShopPage.linkListView, 5);
			wdu.highlightElement(PLPShopPage.linkListView);
			driver.findElement(PLPShopPage.linkListView).click();
			report.updateTestLog("Shop PLP Screen", "Clicked on list view icon.", Status.DONE);

			//Verify Grid View Button
			String gridViewCls = driver.findElement(PLPShopPage.linkGridView).getAttribute("class");
			if(gridViewCls.contains("hits--inactive"))
				report.updateTestLog("Shop PLP Screen", "Grid view icon is blurred.", Status.PASS);
			else
				report.updateTestLog("Shop PLP Screen", "Grid view icon is not blurred.", Status.FAIL);


			wdu.highlightElement(PLPShopPage.linkGridView);
			driver.findElement(PLPShopPage.linkGridView).click();
			Thread.sleep(2000);
			report.updateTestLog("Shop PLP Screen", "Clicked on grid view icon.", Status.DONE);
			//Verify Grid View Button
			String listViewCls = driver.findElement(PLPShopPage.linkListView).getAttribute("class");
			if(listViewCls.contains("hits--inactive"))
				report.updateTestLog("Shop PLP Screen", "List view icon is blurred.", Status.PASS);
			else
				report.updateTestLog("Shop PLP Screen", "List view icon is not blurred.", Status.FAIL);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateGridListView", "Exception is " + e, Status.FAIL);
		}
	}

	
	
	
	
	
	//========================================================//
	//			*********EU methods*************			  //
	//========================================================//


	
	
	public void productSubLinksForCountries()	{
		try	{

			String linkName = "", productLanderHeader ="";
			wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
			int size = driver.findElements(ProductListingPage.lblProductsSublinks).size() - 1;
			report.updateTestLog("Products sub-links validation", "Products sublinks are present. Total no of sublinks are - "
					+size, Status.DONE);

			for(int i=1 ; i<=size ; i++)	{

				wdu.mouseOver(HomePage.linkProductsForCountries);
				Thread.sleep(1000);
				report.updateTestLog("Products sub-links validation", "Hover on products link.", Status.DONE);

				By locator = By.xpath("((//ul[@class='dropdown-menu megamenu row'])[1]/div[1]/ul/li/a)["+(i+1)+"]");
				wdu.waitUntilElementEnabled(locator, 5);
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				report.updateTestLog("Products sub-links validation", "Clicked on sub link - " + linkName, Status.DONE);

				wdu.waitUntilElementEnabled(ProductListingPage.lblProductsLanderHeader, 10);
				productLanderHeader = driver.findElement(ProductListingPage.lblProductsLanderHeader).getText();
				if(productLanderHeader.trim().toUpperCase().contains(linkName.toUpperCase()))
					report.updateTestLog("Products sub-links validation", "Page opened with following product lander header name - " + 
							productLanderHeader, Status.PASS);
				else
					report.updateTestLog("Products sub-links validation", "Page opened with following product lander header name - " + 
							productLanderHeader + ". Expected filter name - "+linkName, Status.FAIL);
				Thread.sleep(1000);

				driver.navigate().back();
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in productSubLinksForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void accessoriesSubLinksForCountries()	{
		try	{

			String linkName = "", productLanderHeader ="";
			wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
			int size = driver.findElements(ProductListingPage.lblAccessoriesSublinks).size() - 1;
			report.updateTestLog("Accessories sub-links validation", "Accessories sublinks are present. Total no of sublinks are - "
					+size, Status.DONE);

			for(int i=1 ; i<=size ; i++)	{

				wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
				wdu.mouseOver(HomePage.linkProductsForCountries);
				Thread.sleep(1000);
				report.updateTestLog("Accessories sub-links validation", "Hover on products link.", Status.DONE);

				By locator = By.xpath("((//ul[@class='dropdown-menu megamenu row'])[1]/div[2]/ul/li/a)["+(i+1)+"]");
				wdu.waitUntilElementEnabled(locator, 5);
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				report.updateTestLog("Accessories sub-links validation", "Clicked on sub link - " + linkName, Status.DONE);

				wdu.waitUntilElementEnabled(ProductListingPage.lblProductsLanderHeader, 10);
				productLanderHeader = driver.findElement(ProductListingPage.lblProductsLanderHeader).getText();
				if(productLanderHeader.trim().toUpperCase().contains(linkName.toUpperCase()))
					report.updateTestLog("Accessories sub-links validation", "Page opened with following accessories lander header name - " + 
							productLanderHeader, Status.PASS);
				else
					report.updateTestLog("Accessories sub-links validation", "Page opened with following accessories lander header name - " + 
							productLanderHeader + ". Expected filter name - "+linkName, Status.FAIL);
				Thread.sleep(1000);

				driver.navigate().back();
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in accessoriesSubLinksForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void navigateToProductsForCountries()	{
		try	{

			wdu.mouseOver(HomePage.linkProductsForCountries);
			Thread.sleep(1000);
			report.updateTestLog("Products lander validation", "Hover on products link.", Status.DONE);

			wdu.waitUntilElementEnabled(ProductListingPage.lblProductLinkForCountries, 10);
			driver.findElement(ProductListingPage.lblProductLinkForCountries).click();
			report.updateTestLog("Products link under products menu", "Clicked on products link.", Status.DONE);
			Thread.sleep(1000);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in navigateToProductsForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void productLanderForCountries()	{
		try	{

			String text = "", linkName = "";
			wdu.waitUntilElementEnabled(ProductListingPage.lblShopMenuHeader, 10);

			//Validate product lander page header
			text = driver.findElement(ProductListingPage.lblShopMenuHeader).getText();
			if(driver.findElement(ProductListingPage.lblShopMenuHeader).isDisplayed())
				report.updateTestLog("Products lander page", "Product lander page header is displayed as - "+text, Status.PASS);
			else
				report.updateTestLog("Products lander page", "Product lander page header is not displayed.", Status.FAIL);

			//Validate lander icons
			for(int i=1 ; i<=5 ; i++)	{

				//Select each icon inside product lander
				By locator = By.cssSelector("div.category-nav.page-content > div > div > div > div:nth-child(2) > div:nth-child("+i+") > a");
				wdu.waitUntilElementEnabled(locator, 10);				
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				report.updateTestLog("Products lander page validation", "Clicked on products lander page menu " + linkName, Status.DONE);

				//Validate Grills header
				validateGrillsHeaderForCountries(linkName);
				navigateToProductsForCountries();
				/*driver.navigate().back();
				driver.navigate().back();
				driver.navigate().back();
				report.updateTestLog("Products lander page validation", "Clicked on navigate back button.", Status.DONE);*/
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in productLanderForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	private void validateGrillsHeaderForCountries(String linkName)	{
		try	{
			String productLanderHeader = "";
			wdu.waitUntilElementEnabled(ProductListingPage.lblProductsLanderHeader, 10);
			productLanderHeader = driver.findElement(ProductListingPage.lblProductsLanderHeader).getText();
			if(productLanderHeader.trim().toUpperCase().contains(linkName.toUpperCase()))
				report.updateTestLog("Products lander page validation", "Page opened with following product lander header name - " + 
						productLanderHeader, Status.PASS);
			else
				report.updateTestLog("Products lander page validation", "Page opened with following product lander header name - " + 
						productLanderHeader + ". Expected header name - "+linkName, Status.FAIL);
			Thread.sleep(1000);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateGrillsHeaderForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void navigateToAccessoriesForCountries()	{
		try	{

			wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
			wdu.mouseOver(HomePage.linkProductsForCountries);
			Thread.sleep(1000);
			report.updateTestLog("Accessories lander validation", "Hover on products link.", Status.DONE);

			wdu.waitUntilElementEnabled(ProductListingPage.lblAccessoriesLinkForCountries, 10);
			driver.findElement(ProductListingPage.lblAccessoriesLinkForCountries).click();
			report.updateTestLog("Accessories link under products menu", "Clicked on accessories link.", Status.DONE);
			Thread.sleep(1000);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in navigateToAccessoriesForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void accessoriesLanderForCountries()	{
		try	{

			String text = "", acessoriesLanderHeader = "", linkName = "";
			wdu.waitUntilElementEnabled(ProductListingPage.lblShopMenuHeader, 10);

			//Validate product lander page header
			text = driver.findElement(ProductListingPage.lblShopMenuHeader).getText();
			if(driver.findElement(ProductListingPage.lblShopMenuHeader).isDisplayed())
				report.updateTestLog("Accessories lander page", "Accessories lander page header is displayed as - "+text, Status.PASS);
			else
				report.updateTestLog("Accessories lander page", "Accessories lander page header is not displayed.", Status.FAIL);

			//Validate lander icons
			for(int i=1 ; i<=6 ; i++)	{

				//Select each icon inside product lander
				By locator = By.cssSelector("div.category-nav.page-content > div > div > div > div:nth-child(2) > div:nth-child("+i+") > a");
				wdu.waitUntilElementEnabled(locator, 10);				
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				report.updateTestLog("Accessories lander page validation", "Clicked on accessories lander page menu " + linkName, Status.DONE);

				//Validate header name in the yellow colored box
				wdu.waitUntilElementEnabled(ProductListingPage.lblProductsLanderHeader, 10);
				acessoriesLanderHeader = driver.findElement(ProductListingPage.lblProductsLanderHeader).getText();
				if(acessoriesLanderHeader.trim().toUpperCase().contains(linkName.toUpperCase()))
					report.updateTestLog("Products lander page validation", "Page opened with following accessories lander header name - " + 
							acessoriesLanderHeader, Status.PASS);
				else
					report.updateTestLog("Products lander page validation", "Page opened with following accessories lander header name - " + 
							acessoriesLanderHeader + ". Expected header name - "+linkName, Status.FAIL);
				Thread.sleep(1000);

				navigateToAccessoriesForCountries();
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in accessoriesLanderForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void mostPopularProductsForCountries()	{
		try	{
			String linkName="";

			//Click on header menu products link
			wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
			gc.clickOnElementByJScript(driver.findElement(HomePage.linkProductsForCountries));
			//driver.findElement(HomePage.linkProductsForCountries).click();
			Thread.sleep(2000);
			report.updateTestLog("Most popular products section validation", "Cliked on products link.", Status.DONE);

			//Validate different products links in product lander page
			wdu.waitUntilElementLocated(ProductListingPage.lblProductsMainMenuDiffIcons, 15);
			int size = driver.findElements(ProductListingPage.lblProductsMainMenuDiffIcons).size();
			report.updateTestLog("Most popular product section validation", "Total no of icons available under main product landing page - "+size, Status.PASS);

			for(int i=1 ; i<=size ; i++)	{
				By locator = By.cssSelector("div.shopmenu > div > div:nth-child("+i+") > a");
				WebElement ele = driver.findElement(locator);
				linkName = ele.getText();
				ele.click();
				Thread.sleep(1000);
				report.updateTestLog("Most popular product section validation", "Clicked on - "+linkName, Status.DONE);

				//Validate Grills header
				validateGrillsHeaderForCountries(linkName);

				//Click on header menu products link
				wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
				driver.findElement(HomePage.linkProductsForCountries).click();
				Thread.sleep(1000);
				report.updateTestLog("Most popular products section validation", "Cliked on products link.", Status.DONE);
			}
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in mostPopularProductsForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}

	public void productsRecipeCollectionForCountries()	{
		try	{

			//Click on header menu products link
			wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
			driver.findElement(HomePage.linkProductsForCountries).click();
			Thread.sleep(1000);
			report.updateTestLog("Most popular products section validation", "Cliked on products link.", Status.DONE);

			//Click on each recipe icon
			int size = driver.findElements(By.cssSelector("div.similarrecipe__items > a")).size();
			report.updateTestLog("Discover the charbroil recipe collection", "No recipes displayed under charbroil recipe "
					+ "collection - "+size, Status.PASS);
			for(int i=1 ; i<=size ; i++)	{
				By locator = By.cssSelector("div.similarrecipe__items > a:nth-child("+i+")");
				WebElement ele = driver.findElement(locator);
				String text = ele.getText();
				ele.click();
				report.updateTestLog("Discover the charbroil recipe collection", "Clicked on recipe name - "+text, Status.PASS);

				//Validate recipe page
				wdu.waitUntilElementLocated(ProductListingPage.lblRecipePageHeader, 10);
				String recipeHeader = driver.findElement(ProductListingPage.lblRecipePageHeader).getText();
				if(text.trim().toUpperCase().contains(recipeHeader.trim().toUpperCase()))
					report.updateTestLog("Discover the charbroil recipe collection", "Navigated to correct recipe page. "
							+ "Recipe header name showing as - "+recipeHeader, Status.PASS);
				else
					report.updateTestLog("Discover the charbroil recipe collection", "Not navigated to correct recipe page. "
							+ "Recipe header name showing as - "+recipeHeader, Status.FAIL);

				//Click on header menu products link
				wdu.waitUntilElementEnabled(HomePage.linkProductsForCountries, 10);
				driver.findElement(HomePage.linkProductsForCountries).click();
				Thread.sleep(1000);
				report.updateTestLog("Most popular products section validation", "Cliked on products link.", Status.DONE);
			}

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in recipeCollectionForCountries", "Exception is " + e.getMessage(), Status.FAIL);
		}
	}
}
