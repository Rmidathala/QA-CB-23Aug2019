package businesscomponents;


import supportlibraries.*;
import uimap.HomePage;
import uimap.PLPShopPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;


/**
 * Class for storing general purpose business components
 * @author Cognizant
 */
public class GeneralComponents extends ReusableLibrary {

	WebDriverUtil wdu=new WebDriverUtil(driver);
	private static final String GENERAL_DATA = "General_Data";

	public GeneralComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public void invokeApplication() {
		try	{
			report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
					properties.getProperty("ApplicationUrl"), Status.DONE);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get(properties.getProperty("ApplicationUrl"));
			driver.manage().window().maximize();		
			
			wdu.waitUntilPageReadyStateComplete(120);		
			System.out.println("Test Script Execution Started.........");
		}	catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public void invokeStagingApplication() {
		try	{
			report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
					properties.getProperty("StagingApplicationUrl"), Status.DONE);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get(properties.getProperty("StagingApplicationUrl"));
			driver.manage().window().maximize();		
			
			wdu.waitUntilPageReadyStateComplete(120);		
			System.out.println("Test Script Execution Started.........");
		}	catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void acceptCookies()	{
		try {
			for(int i=0 ; i<15 ; i++)	{
				if(driver.findElements(HomePage.btnAcceptCookies).size()>0)	{
					wdu.waitUntilElementEnabled(HomePage.btnAcceptCookies, 30);
					Thread.sleep(1000);
					driver.findElement(HomePage.btnAcceptCookies).click();
					break;
				}				
				Thread.sleep(2000);
			}
		}	catch (Exception e) {
			report.updateTestLog("Exception in acceptCookies", "Error is - "+e.getMessage(), Status.FAIL);
		}
	}

	public void invokeTestURL(){		
		String url = dataTable.getData(GENERAL_DATA, "URL");
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
				url, Status.DONE);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		wdu.waitUntilPageReadyStateComplete(120);
	}

	public void scrollToElement(By locator)	{
		JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver();
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
		report.updateTestLog("Scroll Down ", "Scroll To Element successfull", Status.DONE);
	}

	/*
	 * Method for validating image in UI 
	 */
	public boolean validateImage(String path, String screenName, String imageDesc)	{

		try {
			Screen screen = new Screen();
			Pattern pattern = new Pattern(path);
			screen.wait(pattern, 8);			

			//JavascriptExecutor executor = (JavascriptExecutor) driver.getWebDriver();
			//executor.executeScript("arguments[0].style.border=''", pattern);

			if (screen.exists(pattern) != null)	{
				report.updateTestLog(screenName + " page validation", imageDesc + " validation is successful", Status.PASS);
				return true;
			}
			else	{
				report.updateTestLog(screenName + " page validation", imageDesc + " validation is not successful", Status.FAIL);
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in validateImage", "Exception is - " + e, Status.FAIL);
			return false;
		}		
	}

	/*
	 * Method to click back in UI 
	 */
	public void navigateToBack()	{
		try	{
			driver.navigate().back();
			report.updateTestLog("Navigate back", "Clicked on back button.", Status.DONE);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in navigateToBack", "Exception is - " + e, Status.FAIL);
		}
	}

	/*
	 * Method to click item in UI 
	 */
	public void clickItem(By by, String screenName, String linkName)		{
		try	{
			wdu.waitUntilElementEnabled(by, 15);
			driver.findElement(by).click();
			report.updateTestLog(screenName + " page", "Clicked on " + linkName, Status.DONE);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in clickItem", "Exception is - " + e, Status.FAIL);
		}
	}


	/*
	 * Method for click on load more results until all the results get loaded
	 */
	public void loadMoreResults()	{
		try	{
			while(wdu.objectExists(PLPShopPage.btnLoadMoreResults))	{
				if(driver.findElement(PLPShopPage.btnLoadMoreResults).isEnabled())	{
					scrollToElement(PLPShopPage.btnLoadMoreResults);				
					driver.findElement(PLPShopPage.btnLoadMoreResults).click();
				}	else	{
					break;
				}

				Thread.sleep(5000);
			}
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in loadMoreResults", "Exception is " + e, Status.FAIL);
		}
	}


	/************************** Method to Select a dropdown by value(Arka) ***************************************************/

	public void selectDropDown(By by, String ddvalue)		{
		try	{
			Select sc = new Select(driver.findElement(by));
			wdu.waitUntilElementEnabled(by, 15);

			sc.selectByValue(ddvalue);

			report.updateTestLog(ddvalue + " value", "selected ", Status.DONE);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in seelcting Drop down", "Exception is - " + e, Status.FAIL);
		}
	}

	/****************************************************************************************************************************/	

	/************************** Method to Select a dropdown by index(Arka) ***************************************************/

	public void selectDropDownByIndexValue(By by, int index)		{
		try	{
			Select sc = new Select(driver.findElement(by));
			wdu.waitUntilElementEnabled(by, 15);

			sc.selectByIndex(index);

			report.updateTestLog(index + " value", "selected ", Status.DONE);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in seelcting Drop down", "Exception is - " + e, Status.FAIL);
		}
	}

	/****************************************************************************************************************************/	

	public void scrollDown(int x, int y){

		JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver();
		jse.executeScript("window.scrollBy("+x+","+y+")", "");

	}

	/************************** Method to the First Selected Value in the DropDown ***************************************************/

	public String getFirstSelectedValue(By by)		{


		String selectedOptionText = null;

		try	{
			Select sc1 = new Select(driver.findElement(by));
			wdu.waitUntilElementEnabled(by, 15);

			WebElement seletedOption = sc1.getFirstSelectedOption();

			selectedOptionText = seletedOption.getAttribute("value");
			//String selectedOptionText = seletedOption.getText();




			report.updateTestLog(selectedOptionText + " value", "is selected ", Status.DONE);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in getting selected calue", "Exception is - " + e, Status.FAIL);
		}


		return selectedOptionText;

	}

	/****************************************************************************************************************************/

	/************************************* To Handle Live chat Pop up *********************************************************/

	public void LiveChatPopUpHandle() 
	{

		try {


			//boolean flag_Popup = "True";



			if(wdu.objectExists(By.xpath("//iframe[@id='inqChatStage']")))
			{
				driver.switchTo().frame("inqChatStage");

				Thread.sleep(2000);


				try {

					if(driver.findElement(By.xpath("//input[@title='Close']")).isDisplayed())
					{
						driver.findElement(By.xpath("//input[@title='Close']")).click();

						driver.switchTo().defaultContent();


						report.updateTestLog("Pop Up Handle", "Live CHat Pop up Appeared and closed Successfully", Status.PASS);


					}
				} 

				catch (Exception e) {
					driver.switchTo().defaultContent();
					report.updateTestLog("Pop Up Handle", "Live CHat Pop up did not appear", Status.PASS);
				}


			}

			else
			{
				report.updateTestLog("Pop Up Handle", "No pop up iframe is present", Status.PASS);
			}



		}

		catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Exception in adding product in cart", "Exception is " + e, Status.FAIL);
		}


	}
	/*************************************************************************************************************************/	

	public boolean isElementDisplayed(By by, String page,String elementName, String elementType)		{
		boolean element = false;
		try
		{
			element =driver.findElement(by).isDisplayed();
			if(element ==true)
			{
				scrollToElement(by);
				wdu.highlightElement(by);
				report.updateTestLog(page, elementName+" "+ elementType + " is displaying on "+page +" page.", Status.PASS);
			}
			else
			{
				report.updateTestLog(page, elementName +" "+ elementType +" is present in DOM but not displaying on "+page+" page.", Status.FAIL);
			}}
		catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in "+elementName+" "+elementType,"Exception is: Webelement of " + elementName +" "+ elementType +" could not find in DOM"+" on " +page +" page.", Status.FAIL);

		}
		return element;
	}

	public void verifyText(By by, String page,String elementName, String elementType,String expectedText,String expectedURL)		{
		String text=null;
		String currentURL=null;
		try
		{
			currentURL=driver.getCurrentUrl();
			if(driver.findElement(by).isDisplayed())
			{			
				text =driver.findElement(by).getText();
				if(text.equals(expectedText) && currentURL.equals(expectedURL))

				{
					scrollToElement(by);
					wdu.highlightElement(by);
					report.updateTestLog(page, elementName+" "+ elementType + " text is matching with expected text on "+page +" page."+elementName+" "+ elementType + " text is "+text, Status.PASS);
				}
				else
				{
					report.updateTestLog(page, elementName+" "+ elementType + " text is matching with expected text on "+page +" page.", Status.PASS);
				}
			}
			else
			{
				report.updateTestLog(page, elementName +" "+ elementType +" is present in DOM but not displaying on "+page+" page.", Status.FAIL);
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in "+elementName+" "+elementType,"Exception is: Webelement of " + elementName +" "+ elementType +" could not find in DOM"+" on " +page +" page.", Status.FAIL);

		}

	}

	public void clickOnElementByJScript(WebElement element)    {
		JavascriptExecutor jse = (JavascriptExecutor)driver.getWebDriver();
		jse.executeScript("arguments[0].click();", element);    
	}
	
   
	
	
	public void mouseOver(By by) {
        try  {
             Actions actions = new Actions(driver.getWebDriver());
             actions.moveToElement(driver.findElement(by)).build().perform();
        }    catch(Exception e)    {
             e.printStackTrace();
        }
  }

	
	
}