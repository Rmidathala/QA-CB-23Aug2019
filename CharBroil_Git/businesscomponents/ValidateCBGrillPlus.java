package businesscomponents;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.CBGrillPlus;

public class ValidateCBGrillPlus extends ReusableLibrary {

	GeneralComponents gc = new GeneralComponents(scriptHelper);
	WebDriverUtil wdu = new WebDriverUtil(driver);

	public ValidateCBGrillPlus(ScriptHelper scriptHelper) {
		super(scriptHelper);		
	}

	public void validateGrillsSection()	{
		try	{
			verifyGrillsImageTextAtTop();
			verifyExploreButton();
		}	catch(Exception e)	{
			report.updateTestLog("Validate Grills Section", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void validateNextLevelGrillingSection()	{
		try	{
			validateNextLevelGrillingText();
			verifyNextLevelGrillingImageCount();
			verifyNextLevelGrillingScrollButton();
			verifyNextLevelGrillingPlusButton();
		}	catch(Exception e)	{
			report.updateTestLog("Validate Next Level Grilling Section", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void validateGiveFlavorAPlusSection()	{
		try	{
			verifyGiveAFlavorPlusText();
			verifyFlavorPlusBtnCount();
			verifyFlavorPlusButtons();

		}	catch(Exception e)	{
			report.updateTestLog("Validate Give Flavor A Plus Section", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyGrillsImageTextAtTop()	{
		try	{
			String text = driver.findElement(CBGrillPlus.linkGrillsImageText).getText();
			wdu.highlightElement(CBGrillPlus.linkGrillsImageText);
			if(text.contains("ADDITION") && text.contains("BY SATISFACTION"))
				report.updateTestLog("Verify Grills Image Text", "Grills image text matched.", Status.PASS);
			else
				report.updateTestLog("Verify Grills Image Text", "Grills image text not matched.", Status.FAIL);
		}	catch(Exception e)	{
			report.updateTestLog("Validate Grills image text", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyExploreButton()	{
		try	{
			wdu.highlightElement(CBGrillPlus.linkExplore);
			driver.findElement(CBGrillPlus.linkExplore).click();
			report.updateTestLog("Validate Explore Button", "Clicked on Explore button.", Status.DONE);
		}	catch(Exception e)	{
			report.updateTestLog("Validate Explore Button", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void validateNextLevelGrillingText()	{
		try	{
			gc.scrollToElement(CBGrillPlus.linkNextLevelGrillingHeader);
			wdu.highlightElement(CBGrillPlus.linkNextLevelGrillingHeader);
			String text = driver.findElement(CBGrillPlus.linkNextLevelGrillingHeader).getText();
			if(text.equalsIgnoreCase("NEXT-LEVEL GRILLING"))
				report.updateTestLog("Validate Next Level Grilling Text", "Validation passed. Following text exist - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Text", "Validation passed. Text in header section not matched", Status.PASS);

			wdu.highlightElement(CBGrillPlus.linkNextLevelGrilling);
			text = driver.findElement(CBGrillPlus.linkNextLevelGrilling).getText();
			if(text.equalsIgnoreCase("Introducing the Char-Broil® Grill+ System™. A collection of grilling secret weapons "
					+ "that will help you get more out of the food you cook. More variety. More flavor. More high-fives "
					+ "from your impressed friends."))
				report.updateTestLog("Validate Next Level Grilling Text", "Validation passed. Following text exist - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Text", "Validation passed. Text in header section not matched", Status.PASS);
		}	catch(Exception e)	{
			report.updateTestLog("Validate Next Level Grilling Text", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyNextLevelGrillingImageCount()	{
		try	{
			if(driver.findElements(CBGrillPlus.linkNextLevelGrillingImage).size() == 3)
				report.updateTestLog("Verify image count under Next Level Grilling", "Image count macthed. No of images - 3", Status.PASS);
			else
				report.updateTestLog("Verify image count under Next Level Grilling", "Image count not macthed.", Status.FAIL);
		}	catch(Exception e)	{
			report.updateTestLog("Validate Next Level Grilling Text", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyNextLevelGrillingPlusButton()	{
		try	{
			//Click and validate Second plus button
			wdu.highlightElement(CBGrillPlus.linkNextLevelSecondImagePlus);
			driver.findElement(CBGrillPlus.linkNextLevelSecondImagePlus).click();
			Thread.sleep(1000);
			String text = driver.findElement(CBGrillPlus.linkNextLevelSecondImageMainText).getText();
			if(text.equalsIgnoreCase("TASTE"))
				report.updateTestLog("Validate Next Level Grilling Second Image Text after clicking on plus icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Second Image Text after clicking on plus icon", "Validation failed.", Status.FAIL);

			driver.findElement(CBGrillPlus.btnNextLevelImageClose).click();

			//Click and validate Third plus button
			wdu.highlightElement(CBGrillPlus.linkNextLevelThirdImagePlus);
			driver.findElement(CBGrillPlus.linkNextLevelThirdImagePlus).click();
			Thread.sleep(1000);
			text = driver.findElement(CBGrillPlus.linkNextLevelThirdImageMainText).getText();
			if(text.equalsIgnoreCase("FUNCTIONALITY"))
				report.updateTestLog("Validate Next Level Grilling Third Image Text after clicking on plus icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Third Image Text after clicking on plus icon", "Validation failed.", Status.FAIL);

			driver.findElement(CBGrillPlus.btnNextLevelImageClose).click();

		}	catch(Exception e)	{
			report.updateTestLog("Validate Next Level Grilling Text after clicking on plus icon", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyNextLevelGrillingScrollButton()	{
		try	{
			driver.findElement(CBGrillPlus.linkNextLevelFirstImagePlus).click();
			Thread.sleep(1000);

			//Verify First Image Text
			wdu.highlightElement(CBGrillPlus.linkNextLevelFirstImageMainText);
			String text = driver.findElement(CBGrillPlus.linkNextLevelFirstImageMainText).getText();
			//if(text.equalsIgnoreCase("Designed for Deliciousness"))
			if(text.equalsIgnoreCase("VERSATILITY"))
				report.updateTestLog("Validate Next Level Grilling First Image Text after clicking on plus icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling First Image Text after clicking on plus icon", "Validation failed.", Status.FAIL);

			text = driver.findElement(CBGrillPlus.linkNextLevelFirstImageSubText).getText();
			/*if(text.equalsIgnoreCase("Stainless steel construction and intuitive design make the Grill+ System™ durable "
					+ "and easy to use."))*/
			if(text.equalsIgnoreCase("Smoke, roast, bake, steam and more with the Grill+ Accessory System™."))
				report.updateTestLog("Validate Next Level Grilling First Image Text after clicking on plus icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling First Image Text after clicking on plus icon", "Validation failed.", Status.FAIL);

			wdu.highlightElement(CBGrillPlus.btnNextLevelImageNext);
			driver.findElement(CBGrillPlus.btnNextLevelImageNext).click();
			Thread.sleep(1000);


			//Verify Second Image Text			
			wdu.highlightElement(CBGrillPlus.linkNextLevelSecondImageMainText);
			text = driver.findElement(CBGrillPlus.linkNextLevelSecondImageMainText).getText();
			//if(text.equalsIgnoreCase("Versatile"))
			if(text.equalsIgnoreCase("TASTE"))
				report.updateTestLog("Validate Next Level Grilling Second Image Text after clicking on the next icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Second Image Text after clicking on the next icon", "Validation failed.", Status.FAIL);

			text = driver.findElement(CBGrillPlus.linkNextLevelSecondImageSubText).getText();
			/*if(text.equalsIgnoreCase("From ribs to peppers to veggies and more, the Grill+ System™ helps you "
					+ "take any dish to the next level."))*/
			if(text.equalsIgnoreCase("From ribs to peppers to veggies and more, the Grill+ Accessory System™ helps you take any dish to the next level."))
				report.updateTestLog("Validate Next Level Grilling Second Image Text after clicking on the next icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Second Image Text after clicking on the next icon", "Validation failed.", Status.FAIL);

			wdu.highlightElement(CBGrillPlus.btnNextLevelImageNext);
			driver.findElement(CBGrillPlus.btnNextLevelImageNext).click();
			Thread.sleep(1000);

			//Verify Third Image Text
			wdu.highlightElement(CBGrillPlus.linkNextLevelThirdImageMainText);
			text = driver.findElement(CBGrillPlus.linkNextLevelThirdImageMainText).getText();
			//if(text.equalsIgnoreCase("Dishwasher Safe"))
			if(text.equalsIgnoreCase("FUNCTIONALITY"))
				report.updateTestLog("Validate Next Level Grilling Third Image Text after clicking on the next icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Third Image Text after clicking on the next icon", "Validation failed.", Status.FAIL);

			text = driver.findElement(CBGrillPlus.linkNextLevelThirdImageSubText).getText();
			/*if(text.equalsIgnoreCase("No elbow grease required. Every part of the Grill+ System™ is dishwasher safe "
					+ "and a breeze to clean."))*/
			if(text.equalsIgnoreCase("With stainless-steel construction and intuitive design, the Grill+ Accessory System™ is durable and easy-to-use."))
				report.updateTestLog("Validate Next Level Grilling Third Image Text after clicking on the next icon", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Validate Next Level Grilling Third Image Text after clicking on the next icon", "Validation failed.", Status.FAIL);

			wdu.highlightElement(CBGrillPlus.btnNextLevelImageNext);
			driver.findElement(CBGrillPlus.btnNextLevelImageNext).click();
			Thread.sleep(1000);
			wdu.highlightElement(CBGrillPlus.btnNextLevelImageClose);
			driver.findElement(CBGrillPlus.btnNextLevelImageClose).click();
			Thread.sleep(1000);

		}	catch(Exception e)	{
			report.updateTestLog("Validate Next Level Grilling Text", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyGiveAFlavorPlusText()	{
		try	{
			gc.scrollToElement(CBGrillPlus.linkFlavorText);
			wdu.highlightElement(CBGrillPlus.linkFlavorText);
			String flavorText = driver.findElement(CBGrillPlus.linkFlavorText).getText();
			//if(flavorText.equalsIgnoreCase("Give Flavor A Plus"))
			if(flavorText.equalsIgnoreCase("GIVE FLAVOR A HAND"))
				report.updateTestLog("Verify Flavor section header text", "Validation passed. Following text found - "+flavorText, Status.PASS);
			else
				report.updateTestLog("Verify Flavor section header text", "Validation failed.", Status.FAIL);

			flavorText = driver.findElement(CBGrillPlus.linkFlavorSubText).getText();
			if(flavorText.equalsIgnoreCase("The Grill+ Accessory System™ lends convenience to prepping, cooking and cleaning, "
					+ "giving you more time to enjoy the moment and savor tasty results."))
				report.updateTestLog("Verify Flavor section sub text", "Validation passed. Following text found - "+flavorText, Status.PASS);
			else
				report.updateTestLog("Verify Flavor section sub text", "Validation failed.", Status.FAIL);
		}	catch(Exception e)	{
			report.updateTestLog("Validate Next Level Grilling Text", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyFlavorPlusBtnCount()	{
		try	{
			if(driver.findElements(CBGrillPlus.btnFlavorImagePlusIcon).size() == 4)
				report.updateTestLog("Verify image count under GIVE A FLAVOR PLUS", "Image count macthed. No of images - 4", Status.PASS);
			else
				report.updateTestLog("Verify image count under GIVE A FLAVOR PLUS", "Image count not macthed.", Status.FAIL);
		}	catch(Exception e)	{
			report.updateTestLog("Verify image count under GIVE A FLAVOR PLUS", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

	public void verifyFlavorPlusButtons()	{
		try	{

			//Verify first plus button image and text in Flavor section
			wdu.highlightElement(CBGrillPlus.btnFlavorFirstPlusIcon);
			driver.findElement(CBGrillPlus.btnFlavorFirstPlusIcon).click();

			Thread.sleep(5000);
			wdu.highlightElement(CBGrillPlus.linkFlavorFirstImagePanelTitle);
			String text = driver.findElement(CBGrillPlus.linkFlavorFirstImagePanelTitle).getText();
			//if(text.equalsIgnoreCase("Kebabs that go kaboom"))
			if(text.equalsIgnoreCase("SWEET & SPICY GRILLED PORK AND PINEAPPLE KEBABS"))
				report.updateTestLog("Verify Flavor Plus button first image title", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button first image title", "Validation failed.", Status.FAIL);

			wdu.highlightElement(CBGrillPlus.linkFlavorFirstImagePanelDesc);
			text = driver.findElement(CBGrillPlus.linkFlavorFirstImagePanelDesc).getText();
			/*if(text.equalsIgnoreCase("With Grill+ Sliding Skewers, prepping, cooking and removing food "
					+ "from your kebabs is easier than ever."))*/
			if(text.equalsIgnoreCase("Looking for an explosion of flavor? Load up the Grill+ Sliding Skewers with sweet and spicy grilled pork and pineapple."))
				report.updateTestLog("Verify Flavor Plus button first image decsription", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button first image decsription", "Validation failed.", Status.FAIL);

			driver.findElement(CBGrillPlus.btnFlavorClosePanelFirstImage).click();
			Thread.sleep(5000);
			
			
			//Verify Second plus button image and text in Flavor section
			wdu.highlightElement(CBGrillPlus.btnFlavorSecondPlusIcon);
			driver.findElement(CBGrillPlus.btnFlavorSecondPlusIcon).click();

			wdu.highlightElement(CBGrillPlus.linkFlavorSecondImagePanelTitle);
			text = driver.findElement(CBGrillPlus.linkFlavorSecondImagePanelTitle).getText();
			//if(text.equalsIgnoreCase("Simple Lemon and garlic asparagus"))
			if(text.equalsIgnoreCase("STIR-FRY, BOIL & MORE"))
				report.updateTestLog("Verify Flavor Plus button second image title", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button second image title", "Validation failed.", Status.FAIL);

			//			wdu.highlightElement(CBGrillPlus.linkFlavorSecondImagePanelDesc);
			//			text = driver.findElement(CBGrillPlus.linkFlavorSecondImagePanelDesc).getText();
			//			if(text.equalsIgnoreCase("Cooked with our Grill+ System™, this fresh asparagus recipe will have everyone "
			//					+ "asking for seconds."))
			//				report.updateTestLog("Verify Flavor Plus button second image decsription", "Validation passed. Following text found - "+text, Status.PASS);
			//			else
			//				report.updateTestLog("Verify Flavor Plus button second image decsription", "Validation failed.", Status.FAIL);

			driver.findElement(CBGrillPlus.btnFlavorClosePanelSecondImage).click();
			Thread.sleep(5000);
			
			
			//Verify Third plus button image and text in Flavor section
			wdu.highlightElement(CBGrillPlus.btnFlavorThirdPlusIcon);
			driver.findElement(CBGrillPlus.btnFlavorThirdPlusIcon).click();
			Thread.sleep(5000);
			wdu.highlightElement(CBGrillPlus.linkFlavorThirdImagePanelTitle);
			text = driver.findElement(CBGrillPlus.linkFlavorThirdImagePanelTitle).getText();
			if(text.equalsIgnoreCase("Put some pep in those peppers"))			
				report.updateTestLog("Verify Flavor Plus button third image title", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button third image title", "Validation failed.", Status.FAIL);

			wdu.highlightElement(CBGrillPlus.linkFlavorThirdImagePanelDesc);
			text = driver.findElement(CBGrillPlus.linkFlavorThirdImagePanelDesc).getText();
			/*if(text.equalsIgnoreCase("The Grill+ Double Pepper Roaster will help make your stuffed peppers the stuff "
					+ "legends are made of."))*/
			if(text.equalsIgnoreCase("Use the Grill+ Double Pepper Roaster with the Grill+ Deep Dish to add a smoky twist to your stuffed peppers."))
				report.updateTestLog("Verify Flavor Plus button third image decsription", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button third image decsription", "Validation failed.", Status.FAIL);

			driver.findElement(CBGrillPlus.btnFlavorClosePanelThirdImage).click();
			Thread.sleep(5000);
			
			

			//Verify Fourth plus button image and text in Flavor section
			wdu.highlightElement(CBGrillPlus.btnFlavorFourthPlusIcon);
			driver.findElement(CBGrillPlus.btnFlavorFourthPlusIcon).click();
			Thread.sleep(5000);
			wdu.highlightElement(CBGrillPlus.linkFlavorFourthImagePanelTitle);
			text = driver.findElement(CBGrillPlus.linkFlavorFourthImagePanelTitle).getText();
			//if(text.equalsIgnoreCase("The Right Way To Cut Corners"))
			if(text.equalsIgnoreCase("CUT CORNERS THE RIGHT WAY"))
				report.updateTestLog("Verify Flavor Plus button fourth image title", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button fourth image title", "Validation failed.", Status.FAIL);

			wdu.highlightElement(CBGrillPlus.linkFlavorFourthImagePanelDesc);
			text = driver.findElement(CBGrillPlus.linkFlavorFourthImagePanelDesc).getText();
			/*if(text.equalsIgnoreCase("The Grill+ Roasting Dish & Cutting Board offers a sturdy 14” x 8.5” stainless "
					+ "steel pan, complete with a cutting board lid. A prep, cooking and storage space, all in one."))*/
			if(text.equalsIgnoreCase("The Grill+ Deep Dish & Cutting Board is a prep, cook and storage space, all in one."))
				report.updateTestLog("Verify Flavor Plus button fourth image decsription", "Validation passed. Following text found - "+text, Status.PASS);
			else
				report.updateTestLog("Verify Flavor Plus button fourth image decsription", "Validation failed.", Status.FAIL);

			driver.findElement(CBGrillPlus.btnFlavorClosePanelFourthImage).click();
			Thread.sleep(4000);
		}	catch(Exception e)	{
			report.updateTestLog("Validate Flavor Section", "Validation failed. Exception - "+e, Status.FAIL);
		}
	}

}
