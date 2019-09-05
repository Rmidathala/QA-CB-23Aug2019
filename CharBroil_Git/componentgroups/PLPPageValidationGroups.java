package componentgroups;

import com.cognizant.framework.Status;
import businesscomponents.HomePageComponents;
import businesscomponents.PLPCookPageComponents;
import businesscomponents.PLPLearnPageComponents;
import businesscomponents.PLPShopPageComponents;
import supportlibraries.*;

public class PLPPageValidationGroups extends ReusableLibrary{


	/**
	 * Constructor to initialize the component group library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */

	public PLPPageValidationGroups(ScriptHelper scriptHelper) {
		super(scriptHelper);	
	}

	/*
	 * Method for validating PLP page under SHOP sub menu 
	 */
	public void validatePLPPageForShopSubMenu()	{
		try	{
			PLPShopPageComponents plp = new PLPShopPageComponents(scriptHelper);
			//plp.validateSubMenuPageHeader();
			plp.validateBreadCrumb();
			plp.validateProductCountInPLP();
			//plp.validateFilterNameInPLP();
			plp.validateSortByPriceInPLP();

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validatePLPPageForShopSubMenu", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating PLP page under COOK sub menu 
	 */
	public void validatePLPPageForCookSubMenu()	{
		try	{
			PLPCookPageComponents plp = new PLPCookPageComponents(scriptHelper);
			//plp.validateCookSubMenuPageHeader();			
			plp.validateProductCountInCookPLP();
			plp.validateFilterNameInCookPLP();

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validatePLPPageForCookSubMenu", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating PLP page under LEARN sub menu 
	 */
	public void validatePLPPageForLearnSubMenu()	{
		try	{
			PLPLearnPageComponents plp = new PLPLearnPageComponents(scriptHelper);
			//plp.validateLearnSubMenuPageHeader();			
			plp.validateCountLessons();
			plp.validateLearnMorePart();
			plp.validatePopularArticles();

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validatePLPPageForLearnSubMenu", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate Shop sub categories landing pages
	 */
	public void validateSubCatgShopLanderPage()	{
		try		{
			HomePageComponents home = new HomePageComponents(scriptHelper);
			PLPShopPageComponents plpShop = new PLPShopPageComponents(scriptHelper);
			home.hoverMenuTabInHome();
			home.selectShopSubCategory();
			plpShop.validateSubMenuPageHeader();
			plpShop.validateBreadCrumb();
			
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateSubCatgGrillLanderPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate Learn sub categories landing page
	 */
	public void validateLearnSubCatgLanderPage()	{
		try		{
			HomePageComponents home = new HomePageComponents(scriptHelper);
			home.hoverMenuTabInHome();
			home.selectShopSubCategory();
			validatePLPPageForLearnSubMenu();
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateLearnSubCatgLanderPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate sub links of RECIPES BY INGREDIENTS under COOK menu
	 */
	public void validateCookRecipesByIngredientsSub()	{
		try		{
			HomePageComponents home = new HomePageComponents(scriptHelper);
			PLPCookPageComponents plpCook = new PLPCookPageComponents(scriptHelper);
			
			home.hoverMenuTabInHome();
			home.selectShopSubCategory();
			//plpCook.validateCookSubMenuPageHeader();
			plpCook.validateFilterNameInCookPLP();
			plpCook.validateRecipesByLinkNavigation();
			home.navigateToHomePage();
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateCookRecipesByIngredientsSub", "Exception is " + e, Status.FAIL);
		}
	}
}
