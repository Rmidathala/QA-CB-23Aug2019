package businesscomponents;
import supportlibraries.*;
import uimap.TruinfraPage;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;
public class TruInfraRedLandingPageComponent extends ReusableLibrary {

	GeneralComponents gc=new GeneralComponents(scriptHelper);
	WebDriverUtil objWebd=new WebDriverUtil(driver);
	public TruInfraRedLandingPageComponent(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	public void verifyTrueInfraredHeading(){
		try
		{
			gc.verifyText(TruinfraPage.truInfraredHeading, "TRU-INFRARED", "TRU-INFRARED","heading", 
					dataTable.getData("General_Data","TruinfraredHeading"),dataTable.getData("General_Data","URL"));

		}
		catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}

	public void verifytruInfraredHeadlinebarSection(){
		try
		{
			gc.isElementDisplayed(TruinfraPage.truInfraredHeadlinebarTagImage,"TRU-INFRARED", "TRU-INFRARED Headline Bar Tag ","image");
			gc.verifyText(TruinfraPage.truInfraredHeadlinebarTagText, "TRU-INFRARED", "TRU-INFRARED Headline Bar Tag ","text", 
					dataTable.getData("General_Data","TruInfraredHeadlinebarTagText"),dataTable.getData("General_Data","URL"));

		}
		catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}

	public void verifyEMITTERPLATEfeatureSection(){
		try
		{	
			gc.isElementDisplayed(TruinfraPage.eMITTERPLATEfeatureImg,"TRU-INFRARED", "THE EMITTER PLATE ","image");

			gc.verifyText(TruinfraPage.eMITTERPLATEfeatureHeading, "TRU-INFRARED", "THE EMITTER PLATE ","feature heading", 
					dataTable.getData("General_Data","TruInfraredTHEEMITTERPLATEHeading"),dataTable.getData("General_Data","URL"));
			gc.verifyText(TruinfraPage.eMITTERPLATEfeatureContent, "TRU-INFRARED", "THE EMITTER PLATE ","feature", 
					dataTable.getData("General_Data","TruInfraredTHEEMITTERPLATEText"),dataTable.getData("General_Data","URL"));

		}
		catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}

	public void verifypreventsFlareUpsfeatureSection(){
		try
		{		
			gc.isElementDisplayed(TruinfraPage.preventsFlareUpsfeatureImg,"TRU-INFRARED", "PREVENTS FLARE UPS","image");
			gc.verifyText(TruinfraPage.preventsFlareUpsfeatureHeading, "TRU-INFRARED", "PREVENTS FLARE UPS","feature heading", 
					dataTable.getData("General_Data","PreventsFlareUpsHeading"),dataTable.getData("General_Data","URL"));
			gc.verifyText(TruinfraPage.preventsFlareUpsfeatureContent, "TRU-INFRARED", "PREVENTS FLARE UPS","feature", 
					dataTable.getData("General_Data","PreventsFlareUpsHeadingText"),dataTable.getData("General_Data","URL"));

		}
		catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}

	public void verifyeliminatesHotcoldSpotsfeatureSection(){
		try
		{	
			gc.isElementDisplayed(TruinfraPage.eliminatesHotcoldSpotsfeatureImg,"TRU-INFRARED", "ELIMINATES HOT & COLD SPOTS","image");

			gc.verifyText(TruinfraPage.eliminatesHotcoldSpotsfeatureHeading, "TRU-INFRARED", "ELIMINATES HOT & COLD SPOTS","feature heading", 
					dataTable.getData("General_Data","EliminatesHotcoldSpotsfeatureHeading"),dataTable.getData("General_Data","URL"));
			gc.verifyText(TruinfraPage.eliminatesHotcoldSpotsfeatureContent, "TRU-INFRARED", "ELIMINATES HOT & COLD SPOTS","feature", 
					dataTable.getData("General_Data","EliminatesHotcoldSpotsfeatureText"),dataTable.getData("General_Data","URL"));

		}
		catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}

	public void verifymakesFoodJuicerfeatureSection(){
		try
		{	
			gc.isElementDisplayed(TruinfraPage.makesFoodJuicerfeatureImg,"TRU-INFRARED", "MAKES FOOD JUICIER","image");
			gc.verifyText(TruinfraPage.makesFoodJuicerfeatureHeading, "TRU-INFRARED", "MAKES FOOD JUICIER","feature heading", 
					dataTable.getData("General_Data","MakesFoodJuicerfeatureHeading"),dataTable.getData("General_Data","URL"));
			gc.verifyText(TruinfraPage.makesFoodJuicerfeatureContent, "TRU-INFRARED", "MAKES FOOD JUICIER","feature", 
					dataTable.getData("General_Data","MakesFoodJuicerfeatureText"),dataTable.getData("General_Data","URL"));

		}
		catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}

	public void verifyTruInfraredGrills()	{

		gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "Browse Infrared Grills", "heading",
				"BROWSE TRU-INFRARED™ GRILLS", dataTable.getData("General_Data","URL"));

		gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "commercial", "button",
				"Commercial™", dataTable.getData("General_Data","URL"));
		gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "Performance", "button",
				"Performance™", dataTable.getData("General_Data","URL"));
		gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "Signature", "button",
				"Signature™", dataTable.getData("General_Data","URL"));
		gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "Modular Outdoor Kitchen", "button",
				"Modular Outdoor Kitchen™", dataTable.getData("General_Data","URL"));

		/*String text = driver.findElement(TruinfraPage.linkTruInfraredGrillsBtn1).getText();
		if(text.equalsIgnoreCase("Commercial™"))
			report.updateTestLog("TRU-INFRARED GRILLS", "Commercial button is available", Status.PASS);
		else
			report.updateTestLog("TRU-INFRARED GRILLS", "Commercial button is not available", Status.FAIL);*/
	}

	public void verifyTruInfraCommercial()	{

	}

	public void verifyWaterSlides()	{

		try		{
			//Verify title and description part under water slides portion
			gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "Water Slides", "title",
					"Water Slides", dataTable.getData("General_Data","URL"));
			gc.verifyText(TruinfraPage.linkTruInfraredGrills, "TRU INFRARED", "Water Slides", "description","Are Char-Broil® "
					+ "TRU-Infrared™ grills more forgiving than a water slide? Yes. Yes, they are.", dataTable.getData("General_Data","URL"));

			//Verify each and every cell under water slides
			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg1, "TRU INFRARED", "Water Slides", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell1, "TRU INFRARED", "Water Slides", "text",
					"Water Slides", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg2, "TRU INFRARED", "Sunburn", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell2, "TRU INFRARED", "Sunburn", "text",
					"Sunburn", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg3, "TRU INFRARED", "Bees", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell3, "TRU INFRARED", "Bees", "text",
					"Bees", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg4, "TRU INFRARED", "Exes", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell4, "TRU INFRARED", "Exes", "text",
					"Exes", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg5, "TRU INFRARED", "High-fives", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell5, "TRU INFRARED", "High-fives", "text",
					"High-fives", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg6, "TRU INFRARED", "Toddlers", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell6, "TRU INFRARED", "Toddlers", "text",
					"Toddlers", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg7, "TRU INFRARED", "Lounge Chairs", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell7, "TRU INFRARED", "Lounge Chairs", "text",
					"Lounge Chairs", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg8, "TRU INFRARED", "Dry Food", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell8, "TRU INFRARED", "Dry Food", "text",
					"Dry Food", dataTable.getData("General_Data","URL"));

			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg9, "TRU INFRARED", "Flare-ups", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell9, "TRU INFRARED", "Flare-ups", "text",
					"Flare-ups", dataTable.getData("General_Data","URL"));

			driver.findElement(TruinfraPage.linkWaterSlidesNextPage).click();
			Thread.sleep(2000);
			gc.isElementDisplayed(TruinfraPage.linkWaterSlidesImg10, "TRU INFRARED", "Hot and Cold Spots", "image");
			gc.verifyText(TruinfraPage.linkWaterSlidesCell10, "TRU INFRARED", "Hot and Cold Spots", "text",
					"Hot and Cold Spots", dataTable.getData("General_Data","URL"));
		}	catch(Exception e)
		{
			report.updateTestLog("TRU-INFRARED", e.getMessage(), Status.FAIL);
		}
	}
}

