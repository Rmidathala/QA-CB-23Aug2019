package businesscomponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.HomePage;
import uimap.PLPLearnPage;

public class PLPLearnPageComponents extends ReusableLibrary {

	WebDriverUtil wdu=new WebDriverUtil(driver);
	GeneralComponents gc = new GeneralComponents(scriptHelper);

	public PLPLearnPageComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Method for validating Learn sub category landing page header 
	 */
	public void validateLearnSubMenuPageHeader()	{
		try	{
			String currurl=driver.getCurrentUrl().toLowerCase();
			if(currurl.contains("steak"))
			{
				report.updateTestLog("Learn SubMenu", "Navigation to Steak-101 submenu page is successful", Status.PASS);	
			}
			else
			{
				report.updateTestLog("Learn SubMenu", "Navigation to Steak-101 submenu page is not successful.", Status.FAIL);		
			}

			//Validate image of the sub category
			/*if(shopSubCatg.equalsIgnoreCase("Gas Grill Basics"))
				gc.validateImage(System.getProperty("user.dir")+"\\images\\GasGrillBasics.png", shopSubCatg, shopSubCatg + " image");
				
			else if(shopSubCatg.equalsIgnoreCase("Steak 101"))
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\Steak101.png", shopSubCatg, shopSubCatg + " image");
			else if(shopSubCatg.equalsIgnoreCase("Smoking with the DES"))
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\Smoking with the DES.png", shopSubCatg, shopSubCatg + " image");
			else if(shopSubCatg.equalsIgnoreCase("Charcoal Grill Basics"))
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\Charcoal Grill Basics.png", shopSubCatg, shopSubCatg + " image");
			else if(shopSubCatg.equalsIgnoreCase("Grilling 101"))
				//gc.validateImage(System.getProperty("user.dir")+"\\images\\Grilling 101.png", shopSubCatg, shopSubCatg + " image");
*/
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateLearnSubMenuPageHeader", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating count of lessons
	 */
	public void validateCountLessons()	{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			if(wdu.objectExists(PLPLearnPage.linkLessons))	{
				gc.scrollToElement(PLPLearnPage.linkLessons);
				int countLessons = driver.findElements(PLPLearnPage.linkLessons).size(); 
				report.updateTestLog(shopSubCatg+" screen", countLessons+" no of lessons loaded in "+shopSubCatg+" page.", Status.PASS);
			}	else
				report.updateTestLog(shopSubCatg+" screen", "Lessons are not showing in "+shopSubCatg+" page.", Status.FAIL);

		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateCountLessons", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating learn more part
	 */
	public void validateLearnMorePart()		{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");
			if(wdu.objectExists(PLPLearnPage.linkLearnMore))	{
				gc.scrollToElement(PLPLearnPage.linkLearnMore);
				wdu.highlightElement(PLPLearnPage.linkLearnMore);
				if(driver.findElement(PLPLearnPage.linkLearnMore).getText().equalsIgnoreCase("Want To Learn More?"))
					report.updateTestLog(shopSubCatg+" screen", "Want to learn more part loaded in "+shopSubCatg+" page.", Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Want to learn more part text is incorrect in "+shopSubCatg+" page.", Status.FAIL);
			}
			else
				report.updateTestLog(shopSubCatg+" screen", "Want to learn more part not loaded in "+shopSubCatg+" page.", Status.FAIL);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateLearnMorePart", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method for validating popular articles part
	 */
	public void validatePopularArticles()		{
		try	{
			String shopSubCatg = dataTable.getData("General_Data", "SubMenuName");

			if(wdu.objectExists(PLPLearnPage.linkPopularArticles))	{
				
				gc.scrollToElement(PLPLearnPage.linkPopularArticles);
				wdu.highlightElement(PLPLearnPage.linkPopularArticles);
				if(driver.findElement(PLPLearnPage.linkPopularArticles).getText().equalsIgnoreCase("Popular Articles"))
					report.updateTestLog(shopSubCatg+" screen", "Popular articles part loaded in "+shopSubCatg+" page.", Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Popular articles part not loaded in "+shopSubCatg+" page.", Status.FAIL);

				wdu.highlightElement(PLPLearnPage.linkPopularArticlesSubHeading);
				if(driver.findElement(PLPLearnPage.linkPopularArticlesSubHeading).getText().equalsIgnoreCase("Check out what your fellow grillers are reading."))
					report.updateTestLog(shopSubCatg+" screen", "Popular articles part sub-heading loaded in "+shopSubCatg+" page.", Status.PASS);
				else
					report.updateTestLog(shopSubCatg+" screen", "Popular articles part sub-heading not loaded in "+shopSubCatg+" page.", Status.FAIL);
			}
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validatePopularArticles", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate Learn landing page
	 */
	public void validateLearnLandingPage()		{
		try		{
			//Validate Learn page header image
			wdu.highlightElement(HomePage.linkLearn);
			report.updateTestLog("Home Page", "Learn link is present.", Status.PASS);
			gc.clickItem(HomePage.linkLearn, "Home", "Learn");			
			gc.validateImage(System.getProperty("user.dir") + "\\images\\Learn.png", "Learn", "Learn image");
			
			//Validate Welcome to CharBroil University
			wdu.waitUntilElementEnabled(PLPLearnPage.linkLearnWelcomeCbUniversity, 10);
			gc.scrollToElement(PLPLearnPage.linkLearnWelcomeCbUniversity);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\LearnWelcomeToCbUniversity.png", "Learn", "Welcome to CharBroil University image");
			
			//Validate Hot Courses in CharBroil learn page
			wdu.waitUntilElementEnabled(PLPLearnPage.linkLearnHotCourses, 10);
			gc.scrollToElement(PLPLearnPage.linkLearnHotCourses);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\LearnHotCourses.png", "Learn", "Learn Hot Courses image");
			
			//Validate Brush Up On Your Skills
			wdu.waitUntilElementEnabled(PLPLearnPage.linkLearnBrushUpYourSkills, 10);
			gc.scrollToElement(PLPLearnPage.linkLearnBrushUpYourSkills);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\LearnBrushUpSkills.png", "Learn", "Learn Brush Up Your Skills image");
						
			//Validate Popular Articles
			wdu.waitUntilElementEnabled(PLPLearnPage.linkLearnPopularArticles, 10);
			gc.scrollToElement(PLPLearnPage.linkLearnPopularArticles);
			gc.validateImage(System.getProperty("user.dir") + "\\images\\LearnPopularArticles.png", "Learn", "Learn Popular Articles image");
			
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateLearnLandingPage", "Exception is " + e, Status.FAIL);
		}
	}

	/*
	 * Method to validate Email Sign Up in Learn page
	 */
	public void validateEmailSignUpInLearn()	{
		try		{			
			//Click on Learn link in HomePage
			wdu.highlightElement(HomePage.linkLearn);
			report.updateTestLog("Home Page", "Learn link is present.", Status.PASS);
			gc.clickItem(HomePage.linkLearn, "Home", "Learn");
			report.updateTestLog("Home Page", "Clicked on Learn link.", Status.DONE);
			
			//Navigate to Email Sign Up link in learn page
			wdu.waitUntilElementEnabled(PLPLearnPage.txtLearnEmailSignUp, 10);
			gc.scrollToElement(PLPLearnPage.txtLearnEmailSignUp);
			Thread.sleep(1000);
			
			//Creating dynamic email id
			DateFormat dateFormat = new SimpleDateFormat("hhmm");
			Calendar calendar = Calendar.getInstance();
			String email = "test" + dateFormat.format(calendar.getTime()) + "@wcbradley.com";
			
			//Type to Email Sign Up
			driver.findElement(PLPLearnPage.txtLearnEmailSignUp).clear();
			Thread.sleep(1000);
			driver.findElement(PLPLearnPage.txtLearnEmailSignUp).sendKeys(email);
			Thread.sleep(1000);
			report.updateTestLog("Learn Page", "Email Id entered as - "+email+".", Status.PASS);
			
			//Click on Sign-up button
			wdu.highlightElement(PLPLearnPage.btnLearnEmailSignUp);
			driver.findElement(PLPLearnPage.btnLearnEmailSignUp).click();
			Thread.sleep(3000);
			report.updateTestLog("Learn Page", "Clicked on Sign Up button.", Status.DONE);
			
			//Validate Successful subscription message			
			wdu.waitUntilElementEnabled(PLPLearnPage.linkLearnEmailSignUpSuccessMsg, 30);
			gc.scrollToElement(PLPLearnPage.linkLearnEmailSignUpSuccessMsg);
			Thread.sleep(1000);
			if(driver.findElement(PLPLearnPage.linkLearnEmailSignUpSuccessMsg).getText().equalsIgnoreCase("Thank you for your subscription."))
				report.updateTestLog("Learn Page", "Subscription message displayed.", Status.PASS);
			else
				report.updateTestLog("Learn Page", "Subscription message not displayed.", Status.FAIL);
		}	catch(Exception e)	{
			e.printStackTrace();
			report.updateTestLog("Exception in validateEmailSignUpInLearn", "Exception is " + e, Status.FAIL);
		}
	}
}
