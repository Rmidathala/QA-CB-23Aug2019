package businesscomponents;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.Landing70Anniversary;

public class Landing70AnniversaryComponents extends ReusableLibrary {

	WebDriverUtil wdu=new WebDriverUtil(driver);

	public Landing70AnniversaryComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);		
	}

	public void validateAnniversary()	{
		try	{
			//validate header section title
			wdu.waitUntilElementLocated(Landing70Anniversary.lblAnniversaryTitle, 10);
			String title = driver.findElement(Landing70Anniversary.lblAnniversaryTitle).getText();
			if(title.equalsIgnoreCase("You Could Win!"))
				report.updateTestLog("Anniversary header validation", "Anniversary title displayed as - "+title, Status.PASS);
			else
				report.updateTestLog("Anniversary header validation", "Anniversary title displayed as - "+title, Status.FAIL);

			//Validate presence of anniversary body section
			if(driver.findElements(Landing70Anniversary.lblAnniversaryBody).size()==2)
				report.updateTestLog("Anniversary body validation", "Anniversary body section is present.", Status.PASS);
			else
				report.updateTestLog("Anniversary body validation", "Anniversary body section is not present.", Status.FAIL);

			if(driver.findElement(Landing70Anniversary.lblAnniversaryBodyLeft).isDisplayed())	{
				String text = driver.findElement(Landing70Anniversary.lblAnniversaryBodyLeft).getText();
				report.updateTestLog("Anniversary body left section validation", "Anniversary body section left is present. "
						+ "Content displayed as - "+text, Status.PASS);
			}	else
				report.updateTestLog("Anniversary body left section validation", "Anniversary body left section content is not displayed.", Status.FAIL);

			if(driver.findElement(Landing70Anniversary.lblAnniversaryBodyRight).isDisplayed())
				report.updateTestLog("Anniversary body right section validation", "Anniversary body right section is displayed.", Status.PASS);
			else
				report.updateTestLog("Anniversary body right section validation", "Anniversary body right section is not displayed.", Status.FAIL);
		}	catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Validate Anniversary Page Header section", "Exception is - "+e.getMessage(), Status.FAIL);
		}
	}

	public void validateAnniversaryPager()	{
		try	{
			//validate anniversary pager title
			wdu.waitUntilElementLocated(Landing70Anniversary.lblAnniversaryPagerTitle, 10);
			String title = driver.findElement(Landing70Anniversary.lblAnniversaryPagerTitle).getText();
			if(title.equalsIgnoreCase("You could win"))
				report.updateTestLog("Anniversary pager title validation", "Anniversary pager title is displayed as - "+title, Status.PASS);
			else
				report.updateTestLog("Anniversary pager title validation", "Anniversary pager title is displayed as - "+title+
						" . Expected is - 'You could win'", Status.FAIL);

			List<WebElement> anniversaryPaginatonBullets = driver.findElements(Landing70Anniversary.lblAnniversaryPaginationBullet);
			List<WebElement> anniversaryPagerSwipper = driver.findElements(Landing70Anniversary.lblAnniversaryPagerSwipperSlider);
			for(int i=0 ; i<anniversaryPaginatonBullets.size() ; i++)	{
				anniversaryPaginatonBullets.get(i).click();
				Thread.sleep(1000);
				report.updateTestLog("Anniversary pagination validation", "Clicked on page link - "+(i+1), Status.DONE);
				if(anniversaryPagerSwipper.get(i).isDisplayed())
					report.updateTestLog("Anniversary pager swipper validation", "Anniversary pager swipper - "+(i+1)+" is displayed.", Status.PASS);
				else
					report.updateTestLog("Anniversary pager swipper validation", "Anniversary pager swipper - "+(i+1)+" is not displayed.", Status.FAIL);

			}
		}	catch (Exception e) {
			e.printStackTrace();
			report.updateTestLog("Validate Anniversary Page pager section", "Exception is - "+e.getMessage(), Status.FAIL);
		}
	}
	
	
	
	
	
	public void validateNicelyDonePageFunctionality()	{
		try	{
			
			
			
			long finish = 0;
			wdu.waitUntilPageReadyStateComplete(30);
			long start = System.currentTimeMillis();
			String currentURL = driver.getCurrentUrl();
			
			for(int a=1;a<30;a++)
			{
				Thread.sleep(1000);
				if(!driver.getCurrentUrl().contains(currentURL))
				{
					finish = System.currentTimeMillis();
					break;
				}
			}
			
			
			String URLNew = driver.getCurrentUrl();
			long totalTime = finish - start; 
			long finalLoadTime = totalTime/1000;
			
			report.updateTestLog("Nicely Done Page Validation", "The URL at 1st Load time is: "+currentURL, Status.PASS);
			report.updateTestLog("Nicely Done Page Validation", "The URL after "+finalLoadTime+" Seconds is: "+URLNew, Status.PASS);
			
			

			
		}	catch (Exception e) {
			
			report.updateTestLog("Nicely Done Page Validation", "Exception is - "+e, Status.FAIL);
		}
	}
		
	
}
