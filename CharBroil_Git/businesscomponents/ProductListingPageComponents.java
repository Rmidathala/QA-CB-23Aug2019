package businesscomponents;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.ProductDetailsPage;
import uimap.ProductListingPage;

public class ProductListingPageComponents extends ReusableLibrary {

	WebDriverUtil wdu = new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);
	LocalTime liveTime = LocalTime.now(ZoneId.of("America/New_York"));

	public ProductListingPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/************************************************************************************************************************
	 * Function Name: selectRandomSimpleProductFromPLP_OLD Objective: To select
	 * Simple available product from PLP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void selectRandomSimpleProductFromPLP_OLD() {
		try {

			String AppURL = properties.getProperty("ApplicationUrl");

			Thread.sleep(3000);

			if (AppURL.contains("https://www.charbroil.com")) {
				int i = 1;

				while (i <= 15) {

					Thread.sleep(1000);
					wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);

					gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
					wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

					Thread.sleep(2000);
					driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
					Thread.sleep(3000);

					wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

					// if(driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed()==false)

					if (!wdu.objectExists(ProductDetailsPage.lblOutofStock)) {
						Thread.sleep(2000);
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
								report.updateTestLog("Product Details Page",
										"Product Details Page is Displayed after selecting product from PLP",
										Status.PASS);
								break;
							}
						} else {
							driver.navigate().back();
						}
					} else {
						driver.navigate().back();
					}
					i++;
				}

			}

			else if (AppURL.contains("https://stagingshop.charbroil.com")) {
				int i = 1;

				while (i <= 15) {

					Thread.sleep(1000);
					wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);

					gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
					wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

					Thread.sleep(2000);
					driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
					Thread.sleep(3000);

					wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);
					if (!wdu.objectExists(ProductDetailsPage.lblOutofStock)) {
						Thread.sleep(2000);
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
								report.updateTestLog("Product Details Page",
										"Product Details Page is Displayed after selecting product from PLP",
										Status.PASS);
								break;
							}
						} else {
							driver.navigate().back();
						}
					} else {
						driver.navigate().back();
					}
					i++;
				}
			}

			Thread.sleep(1000);
			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}
	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: selectRandomConfigurableProductFromPLP_OLD Objective: To
	 * select Configurable available product from PLP Created On: 07/01/2015 Created
	 * By: Arka Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified
	 * By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void selectRandomConfigurableProductFromPLP_OLD() {

		try {

			String AppURL = properties.getProperty("ApplicationUrl");

			Thread.sleep(3000);

			if (AppURL.contains("https://www.charbroil.com")) {
				int i = 1;

				while (i <= 15) {

					Thread.sleep(1000);
					wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
					gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
					wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

					Thread.sleep(2000);
					driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
					Thread.sleep(2000);

					wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);
					if (driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed() == false)
					// if(!wdu.objectExists(ProductDetailsPage.lblOutofStock))
					{
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == true) {
							Thread.sleep(2000);
							wdu.waitUntilPageReadyStateComplete(30);
							gc.scrollToElement(ProductDetailsPage.selectColorPDP);
							driver.findElement(ProductDetailsPage.selectColorPDP).click();
							driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();

							if (driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed() == false) {
								if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
									report.updateTestLog("Product Details Page",
											"Product Details Page is Displayed after selecting product from PLP",
											Status.PASS);
									break;
								}
							}

							else {
								driver.navigate().back();
							}

						}

						else {

							driver.navigate().back();
						}
					}

					else {
						report.updateTestLog("Product Details Page", "Product " + i + " of the PLP is out of stock.",
								Status.PASS);
						driver.navigate().back();
					}

					i++;
				}

			}

			else if (AppURL.contains("https://stagingshop.charbroil.com")) {
				int i = 1;

				while (i <= 15) {

					Thread.sleep(1000);
					wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
					gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
					wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

					Thread.sleep(2000);
					driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
					Thread.sleep(2000);

					wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

					if (!driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed())
					// if(!wdu.objectExists(ProductDetailsPage.lblOutofStock))
					{
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == true) {
							Thread.sleep(2000);
							wdu.waitUntilPageReadyStateComplete(30);
							gc.scrollToElement(ProductDetailsPage.selectColorPDP);
							driver.findElement(ProductDetailsPage.selectColorPDP).click();

							driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();

							if (driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed() == false) {
								if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
									report.updateTestLog("Product Details Page",
											"Product Details Page is Displayed after selecting product from PLP",
											Status.PASS);
									break;
								}
							}

							else {
								driver.navigate().back();
							}

						}

						else {

							driver.navigate().back();
						}
					}

					else {
						report.updateTestLog("Product Details Page", "Product " + i + " of the PLP is out of stock.",
								Status.PASS);
						driver.navigate().back();
					}

					i++;
				}

			}

			Thread.sleep(1000);

			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: validateRandomConfigurableProductFromPLP_OLD Objective: To
	 * select and validate available configurable product PDP Created On: 07/01/2015
	 * Created By: Arka Dasgupta Automation Team Last Modified On: 02/13/2018 Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validateRandomConfigurableProductFromPLP_OLD() {

		try {

			String AppURL = properties.getProperty("ApplicationUrl");

			Thread.sleep(5000);

			if (AppURL.contains("https://www.charbroil.com")) {

				int i = 1;

				while (i <= 15) {

					Thread.sleep(1000);
					wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
					gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
					wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

					Thread.sleep(2000);
					driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
					Thread.sleep(2000);

					wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

					if (driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed() == false)

					{
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == true) {

							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

								wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 15);

								if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
										&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
										// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
										driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is successful", Status.PASS);
									break;
								} else {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is not successful", Status.FAIL);
								}

							}

						}

						else {
							driver.navigate().back();
						}
					}

					else {
						driver.navigate().back();
					}

					i++;
				}

			}

			else if (AppURL.contains("https://stagingshop.charbroil.com")) {
				int i = 1;

				while (i <= 15) {

					Thread.sleep(1000);
					wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
					gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
					wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

					Thread.sleep(2000);
					driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
					Thread.sleep(2000);

					wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

					if (!driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed())
					// if(!wdu.objectExists(ProductDetailsPage.lblOutofStock))

					{
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == true) {

							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

								wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 15);

								if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
										&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
										// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
										driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is successful", Status.PASS);
									break;
								} else {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is not successful", Status.FAIL);
								}

							}

						}

						else {
							driver.navigate().back();
						}
					}

					else {
						driver.navigate().back();
					}

					i++;
				}
			}

			Thread.sleep(1000);

			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating PDP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: validateRandomSimpleProductPDP_OLD Objective: To select and
	 * validate available product PDP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void validateRandomSimpleProductPDP_OLD() {

		try {

			Thread.sleep(5000);

			int i = 1;

			while (i <= 15) {

				wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
				gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
				Thread.sleep(1000);

				wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);
				if (wdu.objectExists(ProductDetailsPage.lblOutofStock) == false)

				{
					if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
						if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

							// driver.findElement(ProductDetailsPage.selectColorPDP).click();
							// driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();
							//
							// Thread.sleep(3000);
							wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 30);

							if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
									&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
									&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
									// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
									driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
									&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
								report.updateTestLog("Product Details Page",
										"Product Details Page validation is successful", Status.PASS);
								break;
							} else {
								report.updateTestLog("Product Details Page",
										"Product Details Page validation is not successful", Status.FAIL);
							}
						}
					}

					else {
						driver.navigate().back();
					}
				}

				else {
					driver.navigate().back();
				}

				i++;
			}

			Thread.sleep(1000);

			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: selectRandomProduct Objective: To select a product from PLP
	 * after navigationm form the menu Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void selectRandomProduct() {
		try {

			wdu.waitUntilElementEnabled(ProductListingPage.imgProductPLPViaMenu, 30);
			driver.findElement(ProductListingPage.imgProductPLPViaMenu).click();
			report.updateTestLog("Product Selection", "Clicked on first random product.", Status.DONE);
			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

			if (driver.findElement(ProductDetailsPage.lblProductHeader).isDisplayed()) {
				report.updateTestLog("Product Selection", "Product Selecting is successful", Status.PASS);
			}

			else {
				report.updateTestLog("Product Selection", "Product Selecting is not successful", Status.FAIL);
			}

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}
	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: selecOutOfStockProductFromPLP Objective: To select Out of
	 * stock product from PLP Created On: 07/01/2015 Created By: Arka Dasgupta
	 * Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void selecOutOfStockProductFromPLP() {

		try {

			Thread.sleep(3000);

			int i = 1;

			while (i <= 10) {

				wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
				gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
				Thread.sleep(1000);
				wdu.waitUntilElementVisible(ProductDetailsPage.lblModelNumber, 30);
				
				gc.scrollToElement(ProductDetailsPage.btnWhereToBuy);
				try {
					if (driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed() == true)
					// if(!wdu.objectExists(ProductDetailsPage.lblOutofStock))
					{
						report.updateTestLog("Product Details Page",
								"Out of Stock: Product Details Page is Displayed after selecting product from PLP", Status.PASS);
						break;

					}

					else {
						report.updateTestLog("Product Details Page",
								"Product " + i + " of the PLP is not out of stock.", Status.PASS);
						driver.navigate().back();
					}

				} catch (Exception e) {
					report.updateTestLog("Product Details Page", "Product " + i + " of the PLP is not out of stock.",
							Status.PASS);
					driver.navigate().back();
				}

				i++;
			}

			Thread.sleep(1000);

			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting out of stock product from PLP", "Exception is " + e,
					Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: selectRandomConfigurableProductFromPLP Objective: To select
	 * Configurable available product from PLP Created On: 07/01/2015 Created By:
	 * Arka Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By:
	 * Arka Dasgupta
	 ************************************************************************************************************************/
	public void selectRandomConfigurableProductFromPLP() {

		try {
			// Thread.sleep(3000);
			int i = 1;

			while (i <= 15) {
				if (liveTime.getHour() >= 9 & liveTime.getHour() <= 21) {
					gc.LiveChatPopUpHandle();
				}

				// Thread.sleep(1000);
				wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
				gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

				// Thread.sleep(2000);
				driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
				// Thread.sleep(2000);
				wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);
				try {

					if (!driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed())
					// if(!wdu.objectExists(ProductDetailsPage.lblOutofStock))
					{
						/*
						 * if(wdu.objectExists(ProductDetailsPage.selectColorPDP)==true) {
						 * Thread.sleep(2000); wdu.waitUntilPageReadyStateComplete(30);
						 * gc.scrollToElement(ProductDetailsPage.selectColorPDP);
						 * driver.findElement(ProductDetailsPage.selectColorPDP).click();
						 * driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();
						 * 
						 * Thread.sleep(3000);
						 */

						if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
							report.updateTestLog("Product Details Page",
									"Product Details Page is Displayed after selecting product from PLP", Status.PASS);
							break;
						}

						else {
							driver.navigate().back();
						}

						/*
						 * }
						 * 
						 * else {
						 * 
						 * driver.navigate().back(); }
						 */
					}

					else {

						report.updateTestLog("Product Details Page", "Product " + i + " of the PLP is out of stock.",
								Status.PASS);
						driver.navigate().back();
					}

				} catch (Exception e) {

					try {
						/*
						 * if(wdu.objectExists(ProductDetailsPage.selectColorPDP)==true) {
						 * Thread.sleep(2000); wdu.waitUntilPageReadyStateComplete(30);
						 * gc.scrollToElement(ProductDetailsPage.selectColorPDP);
						 * driver.findElement(ProductDetailsPage.selectColorPDP).click();
						 * driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();
						 * 
						 */
						Thread.sleep(2000);
						if (liveTime.getHour() >= 9 & liveTime.getHour() <= 21) {
							gc.LiveChatPopUpHandle();
						}

						if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
							report.updateTestLog("Product Details Page",
									"Product Details Page is Displayed after selecting product from PLP", Status.PASS);
							break;
						}

						else {
							driver.navigate().back();
						}

						/*
						 * }
						 * 
						 * else {
						 * 
						 * driver.navigate().back(); }
						 */

					} catch (Exception e2) {
						report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e2,
								Status.FAIL);

					}

				}

				i++;
			}

			// Thread.sleep(1000);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: selectRandomSimpleProductFromPLP Objective: To select Simple
	 * available product from PLP Created On: 07/01/2015 Created By: Arka Dasgupta
	 * Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void selectRandomSimpleProductFromPLP() {
		try {

			int i = 1;

			while (i <= 15) {

				Thread.sleep(1000);
				wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);

				gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

				Thread.sleep(2000);
				driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
				Thread.sleep(3000);

				wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

				// if(!wdu.objectExists(ProductDetailsPage.lblOutofStock))

				try {

					if (!driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed()) {
						Thread.sleep(2000);
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
								report.updateTestLog("Product Details Page",
										"Product Details Page is Displayed after selecting product from PLP",
										Status.PASS);
								break;
							}
						} else {
							driver.navigate().back();
						}
					} else {
						report.updateTestLog("Product Details Page", "Product " + i + " of the PLP is out of stock.",
								Status.PASS);
						driver.navigate().back();
					}

				} catch (Exception e) {

					try {
						Thread.sleep(2000);
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {
								report.updateTestLog("Product Details Page",
										"Product Details Page is Displayed after selecting product from PLP",
										Status.PASS);
								break;
							}
						} else {
							driver.navigate().back();
						}

					} catch (Exception e2) {
						report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e2,
								Status.FAIL);

					}

				}

				i++;
			}

			Thread.sleep(1000);
			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}
	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: validateRandomConfigurableProductFromPLP Objective: To select
	 * and validate available configurable product PDP Created On: 07/01/2015
	 * Created By: Arka Dasgupta Automation Team Last Modified On: 02/13/2018 Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validateRandomConfigurableProductFromPLP() {

		try {

			Thread.sleep(5000);

			int i = 1;

			while (i <= 15) {

				Thread.sleep(1000);
				wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
				gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

				Thread.sleep(2000);
				driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
				Thread.sleep(2000);

				wdu.waitUntilPageReadyStateComplete(20);

				wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

				try {
					if (!driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed()) {
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == true) {

							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

								wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 15);

								if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
										&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
										// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
										driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()) {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is successful", Status.PASS);
									break;
								} else {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is not successful", Status.FAIL);
								}

							}

						}

						else {
							driver.navigate().back();
						}
					}

					else {
						driver.navigate().back();
					}

				} catch (Exception e) {

					try {
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == true) {

							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

								wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 15);

								if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
										&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
										// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
										driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()) {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is successful", Status.PASS);
									break;
								} else {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is not successful", Status.FAIL);
								}

							} else {
								driver.navigate().back();
							}

						} else {
							driver.navigate().back();
						}

					} catch (Exception e2) {
						report.updateTestLog("Exception in validating PDP", "Exception is " + e2, Status.FAIL);

					}

				}

				i++;
			}

			Thread.sleep(1000);

			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validating PDP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: validateRandomSimpleProductPDP Objective: To select and
	 * validate available product PDP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void validateRandomSimpleProductPDP() {

		try {

			Thread.sleep(5000);

			int i = 1;

			while (i <= 15) {

				wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);
				gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));
				wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a"));

				Thread.sleep(2000);
				driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + i + "]/div/a")).click();
				Thread.sleep(2000);

				wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

				try {
					if (!driver.findElement(ProductDetailsPage.lblOutofStock).isDisplayed())

					{
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

								// driver.findElement(ProductDetailsPage.selectColorPDP).click();
								// driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();
								//
								// Thread.sleep(3000);
								wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 30);

								if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
										&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
										// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
										driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is successful", Status.PASS);
									break;
								} else {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is not successful", Status.FAIL);
								}
							} else {
								driver.navigate().back();
							}
						}

						else {
							driver.navigate().back();
						}
					}

					else {
						driver.navigate().back();
					}

				} catch (Exception e) {

					try {
						if (wdu.objectExists(ProductDetailsPage.selectColorPDP) == false) {
							if (wdu.objectExists(ProductDetailsPage.btnAddtoCartPDP) == true) {

								// driver.findElement(ProductDetailsPage.selectColorPDP).click();
								// driver.findElement(ProductDetailsPage.selectFirstConfigureOptionPDP).click();
								//
								// Thread.sleep(3000);
								wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 30);

								if (driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
										&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
										// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
										driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
										&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is successful", Status.PASS);
									break;
								} else {
									report.updateTestLog("Product Details Page",
											"Product Details Page validation is not successful", Status.FAIL);
								}
							}
						}

						else {
							driver.navigate().back();
						}
					} catch (Exception e2) {

						report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e2,
								Status.FAIL);

					}

				}

				i++;
			}

			Thread.sleep(1000);

			// report.updateTestLog("Product Details Page", "Product Details Page is not
			// Displayed after selecting product from PLP", Status.FAIL);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: selectProductFromPLPWithIndex Objective: To select a product
	 * from the PLP using index Created On: 07/01/2015 Created By: Arka Dasgupta
	 * Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void selectProductFromPLPWithIndex() {
		try {

			String index = dataTable.getData("General_Data", "ProductIndex");
			;

			Thread.sleep(1000);
			wdu.waitUntilElementEnabled(ProductListingPage.lblSortBy, 30);

			gc.scrollToElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + index + "]/div/a"));
			wdu.highlightElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + index + "]/div/a"));

			driver.findElement(By.xpath(ProductListingPage.lnkProductPLP + "div[" + index + "]/div/a")).click();

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblProductHeader, 30);

			if (driver.findElement(ProductDetailsPage.btnAddtoCartPDP).isDisplayed()) {
				report.updateTestLog("Product Details Page",
						"Product Details Page is Displayed after selecting product from PLP", Status.PASS);
			}

			else {
				report.updateTestLog("Product Details Page",
						"Add to cart button is not Displayed after selecting product from PLP", Status.FAIL);
			}

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Selecting product from PLP", "Exception is " + e, Status.FAIL);
		}
	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: validateSimpleProductPDP_Direct Objective: To validate simple
	 * product directly in PDP Created On: 07/01/2015 Created By: Arka Dasgupta
	 * Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validateSimpleProductPDP_Direct() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.lblModelNumber, 20);

			if (driver.findElement(ProductDetailsPage.btnAddtoCartPDP).isDisplayed()
					&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
					&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
					&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
					// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
					driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
					&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()) {
				report.updateTestLog("Product Details Page", "Product Details Page validation is successful",
						Status.PASS);

			} else {
				report.updateTestLog("Product Details Page", "Product Details Page validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Validating product in PDP", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: validateConfigurableProductPDP_Direct Objective: To validate
	 * Configurable product directly in PDP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void validateConfigurableProductPDP_Direct() {

		try {

			wdu.waitUntilElementEnabled(ProductDetailsPage.btnAddtoCartPDP, 20);

			if (driver.findElement(ProductDetailsPage.btnAddtoCartPDP).isDisplayed()
					&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
					&& driver.findElement(ProductDetailsPage.lblModelNumber).isDisplayed()
					&& driver.findElement(ProductDetailsPage.selectQuantity).isDisplayed() &&
					// driver.findElement(ProductDetailsPage.btnWhereToBuy).isDisplayed() &&
					driver.findElement(ProductDetailsPage.imgProductDetails).isDisplayed()
					&& driver.findElement(ProductDetailsPage.lblProductDescription).isDisplayed()
			// && driver.findElement(ProductDetailsPage.selectColorPDP).isDisplayed()
			) {
				report.updateTestLog("Product Details Page", "Product Details Page validation is successful",
						Status.PASS);

			} else {
				report.updateTestLog("Product Details Page", "Product Details Page validation is not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in Validating Configurable product in PDP", "Exception is " + e,
					Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/************************************************************************************************************************
	 * Function Name: goToURL Objective: To get a URL Created On: 07/01/2015 Created
	 * By: Arka Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified
	 * By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void goToURL() {

		try {

			// Thread.sleep(3000);
			// String sURL = dataTable.getData("General_Data", "URL");
			// driver.get(sURL);
			// wdu.waitUntilPageReadyStateComplete(30);
			//
			// report.updateTestLog("Load URL", "Page Loading is successful..",
			// Status.PASS);
			//
			//

			String prodURL = dataTable.getData("General_Data", "URL");
			String stgURL = dataTable.getData("General_Data", "URL_STG");

			String AppURL = properties.getProperty("ApplicationUrl");
			Thread.sleep(2000);
			if (AppURL.contains("charbroil.com")) {
				driver.get(prodURL);
				Thread.sleep(2000);
			}

			else if (AppURL.contains("https://stagingshop.charbroil.com")) {
				driver.get(stgURL);
			}

			wdu.waitUntilPageReadyStateComplete(30);
			report.updateTestLog("URL Navigation", "Navigation to Product Details Page is successful", Status.PASS);

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception loading the webpage", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validateConfigurableProductPDP_Direct Objective: To validate
	 * Configurable product directly in PDP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void validateOnSalePage() {

		try {

			wdu.waitUntilElementEnabled(ProductListingPage.lblOnlineSale, 20);

			if (driver.findElement(ProductListingPage.lblOnlineSale).isDisplayed()
					&& driver.findElement(ProductListingPage.divLeftNavigationPane).isDisplayed()
					&& driver.findElement(ProductListingPage.divRightNavigationPane).isDisplayed())

			{
				report.updateTestLog("Online Sale Page", "Online Sale page loading is successful", Status.PASS);

			} else {
				report.updateTestLog("Online Sale Page", "Online Sale page loading is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in while loading Online Sale page", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validateConfigurableProductPDP_Direct Objective: To validate
	 * Configurable product directly in PDP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void validateEllenShowPage() {

		try {

			wdu.waitUntilElementEnabled(ProductListingPage.lblEllenShowHeader, 20);

			if (driver.findElement(ProductListingPage.lblEllenShowHeader).isDisplayed()
					&& driver.findElement(ProductListingPage.btnSelectEllenShow).isDisplayed())

			{
				report.updateTestLog("Ellen Show Page", "Ellen Show page loading is successful", Status.PASS);

			} else {
				report.updateTestLog("Ellen Show Page", "Ellen Show page loading is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in while loading Ellen Show page", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validateConfigurableProductPDP_Direct Objective: To validate
	 * Configurable product directly in PDP Created On: 07/01/2015 Created By: Arka
	 * Dasgupta Automation Team Last Modified On: 02/13/2018 Last Modified By: Arka
	 * Dasgupta
	 ************************************************************************************************************************/
	public void validateHoliday2017Page() {

		try {

			wdu.waitUntilElementEnabled(ProductListingPage.lblHoliday2017, 20);

			if (driver.findElement(ProductListingPage.lblHoliday2017).isDisplayed()
					&& driver.findElement(ProductListingPage.divLeftNavigationPane).isDisplayed()
					&& driver.findElement(ProductListingPage.divRightNavigationPane).isDisplayed())

			{
				report.updateTestLog("Holiday 2017 Page", "Holiday 2018 page loading is successful", Status.PASS);

			} else {
				report.updateTestLog("Holiday 2017 Page", "Holiday 2018 page loading is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in while loading Holiday 2017 page", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/******************************************
	 * Charbroil Europe Component
	 ********************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: goToPLPfromMenu Objective: To go to PLP page from navigation
	 * menu Crteated On: 08/03/2018 Created By: Arka Dasgupta Automation Team Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void goToPLPfromMenu() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);

			wdu.waitUntilElementEnabled(ProductListingPage.lnk1stMenuNav, 20);

			wdu.mouseHoverJScript(driver.findElement(ProductListingPage.lnk1stMenuNav));
			Thread.sleep(2000);
			driver.findElement(ProductListingPage.lnk1stMenuNavSubMenu2ndLink).click();
			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);
			if (wdu.objectExists(ProductListingPage.lblPLPHeaderLeftPaneYellowBkgrnd)) {

				report.updateTestLog("PLP Page Navigation", "PLP  Navigation is successful", Status.PASS);
			}

			else {
				report.updateTestLog("PLP Page Navigation", "PLP  Navigation is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while navigating to the PLP ", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validatePLPHeader Objective: To Validate PLP Header menu
	 * Crteated On: 08/03/2018 Created By: Arka Dasgupta Automation Team Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validatePLPHeader() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);
			if (wdu.objectExists(ProductListingPage.lblPLPHeaderLeftPaneYellowBkgrnd)) {

				report.updateTestLog("PLP Header Validation", "PLP Header Validation is successful", Status.PASS);
			}

			else {
				report.updateTestLog("PLP Header Validation", "PLP Header Validation not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating PLP Header", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validatePLPHeader Objective: To Validate PLP BreadCrumb menu
	 * Crteated On: 08/03/2018 Created By: Arka Dasgupta Automation Team Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validatePLPBreadCrumb() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);
			if (wdu.objectExists(ProductListingPage.lnkHomeBreadCrumb)
					&& wdu.objectExists(ProductListingPage.lnlProductBreadCrumb)
					&& wdu.objectExists(ProductListingPage.lnkCategoryBreadCrumb)) {

				report.updateTestLog("PLP BreadCrumb Validation", "PLP BreadCrumb Validation is successful",
						Status.PASS);
			}

			else {
				report.updateTestLog("PLP BreadCrumb Validation", "PLP BreadCrumb Validation not successful",
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating PLP BreadCrumb", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validatePLPProductCount Objective: To Validate PLP Product
	 * Count menu Crteated On: 08/03/2018 Created By: Arka Dasgupta Automation Team
	 * Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validatePLPProductCount() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);
			if (wdu.objectExists(ProductListingPage.lblPLPHeaderLeftPaneYellowBkgrnd)) {

				List<WebElement> products = driver.findElements(ProductListingPage.lnkPLPProducts);

				int productCount = products.size();

				if (productCount > 0) {
					report.updateTestLog("PLP Product count Validation",
							"PLP Product count Validation is successful. Number of PLP Products is: " + productCount,
							Status.PASS);
				}

				else {
					report.updateTestLog("PLP Product count Validation",
							"PLP Product count Validation is not successful. Number of PLP Products is: "
									+ productCount,
							Status.FAIL);
				}

				report.updateTestLog("PLP Product count Validation", "PLP is displayed successfully", Status.PASS);
			}

			else {
				report.updateTestLog("PLP Product count Validation", "PLP is not loaded successfully", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating PLP Product count", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validatePLPHeader Objective: To Validate PLP BreadCrumb menu
	 * Crteated On: 08/03/2018 Created By: Arka Dasgupta Automation Team Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validateViewInPLP() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);

			wdu.waitUntilElementEnabled(ProductListingPage.lnkGridView, 40);

			driver.findElement(ProductListingPage.lnkGridView).click();
			wdu.waitUntilPageReadyStateComplete(40);

			if (driver.findElement(ProductListingPage.lnkListView).getAttribute("class").contains("inactive")) {
				report.updateTestLog("PLP View Validation", "PLP Grid View selection is successful", Status.PASS);
			} else {
				report.updateTestLog("PLP View Validation", "PLP Grid View selection is not successful", Status.FAIL);
			}

			wdu.waitUntilElementEnabled(ProductListingPage.lnkListView, 40);

			driver.findElement(ProductListingPage.lnkListView).click();
			wdu.waitUntilPageReadyStateComplete(40);

			if (driver.findElement(ProductListingPage.lnkGridView).getAttribute("class").contains("inactive")) {
				report.updateTestLog("PLP View Validation", "PLP List View selection is successful", Status.PASS);
			} else {
				report.updateTestLog("PLP View Validation", "PLP List View selection is not successful", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating PLP View selection", "Exception is " + e, Status.FAIL);
		}

	}

	/***************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validateShowMoreResults Objective: To Validate show more
	 * button functionality validation menu Crteated On: 08/03/2018 Created By: Arka
	 * Dasgupta Automation Team Last Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validateShowMoreResults() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);
			if (wdu.objectExists(ProductListingPage.lblKeywordSearchHeaderPLP)) {

				report.updateTestLog("PLP Product count Validation", "PLP is displayed successfully", Status.PASS);

				List<WebElement> products = driver.findElements(ProductListingPage.lnkPLPProducts);

				int productCount = products.size();

				if (productCount > 0) {
					report.updateTestLog("PLP Product count Validation",
							"PLP Product count Validation is successful. Number of PLP Products is: " + productCount,
							Status.PASS);
				}

				else {
					report.updateTestLog("PLP Product count Validation",
							"PLP Product count Validation is not successful. Number of PLP Products is: "
									+ productCount,
							Status.FAIL);
				}

				driver.findElement(ProductListingPage.btnShowMoreResults).click();
				wdu.waitUntilPageReadyStateComplete(40);
				Thread.sleep(4000);

				List<WebElement> products1 = driver.findElements(ProductListingPage.lnkPLPProducts);

				int productCount1 = products1.size();

				if (productCount1 > productCount) {
					report.updateTestLog("PLP Show More Button Validation",
							"PLP Show More Button Validation is successful. Number of PLP Products is: "
									+ productCount1,
							Status.PASS);
				}

				else {
					report.updateTestLog("PLP Show More Button Validation",
							"PLP Show More Button Validation is not successful. Number of PLP Products is: "
									+ productCount1,
							Status.FAIL);
				}

			}

			else {
				report.updateTestLog("PLP Product count Validation", "PLP is not loaded successfully", Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating PLP Product count", "Exception is " + e, Status.FAIL);
		}

	}

	/**************************************************************************************************************************************************************************/

	/***************************************************************************************************************************************
	 * Function Name: validateSortBy Objective: To Validate sort by option in PLP
	 * menu Crteated On: 08/03/2018 Created By: Arka Dasgupta Automation Team Last
	 * Modified By: Arka Dasgupta
	 ************************************************************************************************************************/
	public void validateSortBy() {

		try {

			wdu.waitUntilPageReadyStateComplete(40);
			Thread.sleep(3000);

			wdu.waitUntilElementEnabled(ProductListingPage.selectSortByPLP, 40);
			gc.selectDropDownByIndexValue(ProductListingPage.selectSortByPLP, 1);

			List<WebElement> products = driver.findElements(ProductListingPage.lnkPLPProducts);

			int productCount = products.size();

			if (productCount > 0) {
				report.updateTestLog("PLP Sort by Validation",
						"PLP Sort by Validation is successful. Number of PLP Products is: " + productCount,
						Status.PASS);
			}

			else {
				report.updateTestLog("PLP Sort by Validation",
						"PLP Sort By Validation is not successful. Number of PLP Products is: " + productCount,
						Status.FAIL);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception while validating PLP Sort By Option", "Exception is " + e, Status.FAIL);
		}

	}
	/***************************************************************************************************************************************/

}
