package businesscomponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.CBSignature;



public class ValidateCBSignature extends ReusableLibrary{

	WebDriverUtil objWebd=new WebDriverUtil(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver();
	private static final String GENERAL_DATA = "General_Data";

	public ValidateCBSignature(ScriptHelper scriptHelper) {
		super(scriptHelper);

	}

	public void validateSignGasGrillSection(){
		try{
			System.out.println("/*------------------Signature™ Gas Grills section--------------------------*/");
			objWebd.isTextPresent("Signature™ Gas Grills");
			report.updateTestLog("Validate Texts under Signature™ Gas Grills section ", "The  Text  Validation Successfull", Status.PASS);
			System.out.println("Signature™ Gas Grills text available");
			HomePageComponents obj=new HomePageComponents(scriptHelper);
			obj.validateMyAccLink();
			//obj.validateLoginLink();
			obj.validateCountrydropdown();
			validateBacktoTopArrow();
			validateStickybar();
			validateSignGasGrillImage();
			validateSmallImgsOnImageSection();
			validateBigImageOnImageSection();
			validateShopNow();
			validateExploreLink();
		}
		catch(Exception e){
			report.updateTestLog("Validate For Signature Gas Grill section  ", "Few Validation Failed,Check the Report,", Status.FAIL);
		}


	}

	public void validateSignMadeforConvenienceSection(){
		System.out.println("/*------------------Signature -Made For Convenience section--------------------------*/");
		objWebd.isTextPresent("MADE FOR CONVENIENCE");
		objWebd.isTextPresent("Enjoy the convenience of gas and the great flavor of charcoal in one convertible grill.");
		report.updateTestLog("Validate Texts under MADE FOR CONVENIENCE section ", "Both the  Text line Validation Successfull", Status.DONE);

		validateMadeforConvImageCount();
		validatePlusIcon();

	}

	public void validateSignMadeForFlavorSection(){
		try{
			jse.executeScript("window.scrollBy(0,650)", "");
			System.out.println("/*------------------Signature-Made For Flavor section--------------------------*/");
			objWebd.isTextPresent("MADE FOR FLAVOR");
			report.updateTestLog("Validate Texts under MADE FOR FLAVOR section  ", "Text Validation successfull", Status.DONE);
			System.out.println("MADE FOR FLAVOR text available");
			validateMadeForFlavorImage();
			validateMadeForFlavorImageCount();
			validateMadeForFlavorAnimatedImages();

			report.updateTestLog("Validate Made for Flavor section  ", " Validation successfull", Status.DONE);
		}
		catch(Exception e){
			report.updateTestLog("Validate Made for Flavor section  ", " Validation successfull", Status.FAIL);
		}

	}

	public void validateSignFullLineUpSectionSection(){
		try{

			jse.executeScript("window.scrollBy(0,650)", "");
			objWebd.isTextPresent("The Full Line-Up");
			report.updateTestLog("Validate Texts under The Full Line-Up section  ", "Text Validation successfull", Status.DONE);
			System.out.println("/*------------------Signature-The Full Line Up -------------------------*/");
			validateFullLineUpImageCount();
			validateFullLineUpExclusiveImageCount();
			objWebd.isTextPresent("Lowe's Exclusive");
			report.updateTestLog("Validate Texts Lowe's Exclusive under The Full Line-Up section  ", "Text Validation successfull", Status.DONE);
			validateShopAllSignatureGrillsBtn();

		}
		catch(Exception e)
		{
			report.updateTestLog("Validate The Full Line-Up section  ", "Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateSignSignUp(){
		try{
			jse.executeScript("window.scrollBy(0,250)", "");
			String Confirmationmsg = dataTable.getData(GENERAL_DATA, "SignUpConfirmationMessage");
			String emailid = dataTable.getData(GENERAL_DATA, "Username");
			jse.executeScript("window.scrollBy(0,250)", "");
			System.out.println("/*------------------Signature-Sign Up--------------------------*/");
			objWebd.highlightElement(CBSignature.SignupMailtxt);
			driver.findElement(CBSignature.SignupMailtxt).sendKeys(emailid);
			objWebd.highlightElement(CBSignature.SignupBtn);
			driver.findElement(CBSignature.SignupBtn).click();
			Thread.sleep(300);
			objWebd.highlightElement(CBSignature.ThankuMsg);
			String ActualConfirmationmsg=driver.findElement(CBSignature.ThankuMsg).getText();
			if (ActualConfirmationmsg.equalsIgnoreCase(Confirmationmsg)){

				System.out.println("Subscription confirmation :"+ ActualConfirmationmsg  );
				report.updateTestLog("Validate Sign Up ", "Subscription confirmation msg:"+ ActualConfirmationmsg, Status.PASS);	
			}
			else{
				report.updateTestLog("Validate Sign Up ", "Confirmation msg is different", Status.DONE);

			}

		}
		catch(Exception e){
			report.updateTestLog("Validate Sign Up ", "Sign Up Validation unsuccessfull", Status.FAIL);
		}


	}

	public void validateBacktoTopArrow(){
		try{
			jse.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(500);
			if(driver.findElement(CBSignature.BackToTopArrow).isDisplayed())
				report.updateTestLog("Back to Top Arrow ", "Back to Top Arrow displayed", Status.PASS);
			else
				report.updateTestLog("Back to Top Arrow ", "Back to Top Arrow not displayed", Status.FAIL);
			objWebd.highlightElement(CBSignature.BackToTopArrow);
			driver.findElement(CBSignature.BackToTopArrow).click();
			if(driver.findElement(CBSignature.Explorelink).isDisplayed())	{
				objWebd.highlightElement(CBSignature.Explorelink);
				report.updateTestLog("Validate Back to Top Arrow ", "Validation successfull", Status.PASS);
			}	else
				report.updateTestLog("Validate Back to Top Arrow ", "Validation not successfull", Status.FAIL);

		}
		catch(Exception e){
			report.updateTestLog("Validate Back to Top Arrow ", "Validation unsuccessfull", Status.FAIL);
		}
	}

	public void validateStickybar(){
		try{
			jse.executeScript("window.scrollBy(0,1000)", "");
			if(driver.findElement(CBSignature.StickyBar).isDisplayed())		{
				objWebd.highlightElement(CBSignature.StickyBar);
				String StickybarTitle=driver.findElement(CBSignature.StickyBarTitle).getText();
				//System.out.println("The sticky bar under Signature™ Gas Grills Section section is available ");
				report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation successfull,The sticky bar title is :"+StickybarTitle , Status.PASS);
			}	else
				report.updateTestLog("Validate Sticky bar ", "Sticky bar is not available.", Status.FAIL);
		}	catch(Exception e){
			//System.out.println("The Sticky bar under Gas-2-CoalSection section is not available ");
			report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation unsuccessfull", Status.FAIL);
		}
	}

	public void validateSignGasGrillImage(){
		if(driver.findElement(CBSignature.BigImage).isDisplayed()==true){

			System.out.println("The Image under Signature™ Gas Grills section is available ");
			report.updateTestLog("Validate Image under Signature™ Gas Grills section  ", "Validation successfull", Status.PASS);
		}
		else{
			System.out.println("The Image under Signature™ Gas Grills section is not available ");
			report.updateTestLog("Validate Image under Signature™ Gas Grills section  ", "Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateSmallImgsOnImageSection(){
		try{
			List<WebElement> Images = (driver.findElement(CBSignature.HeadLinerBigImage)).findElements(By.className("nyc-hero__headliner"));
			int count =  Images.size();
			if((Images.size())==3){
				System.out.println("No of Headliner Text image validation on the bIg image successfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate Headliner Images Images count under Signature Gas Grill  Image Section ", "Headliner Images under Gas-2-Coal Image Section availability Validation successfull"+ count , Status.PASS);
			}	else	{
				System.out.println("No of Headliner Text image validation on the bIg image unsuccessfull: Image count -" +Images.size()  );
				report.updateTestLog("Validate Headliner Images Images count under Signature Gas Grill  Image Section ", "Headliner Images under Gas-2-Coal Image Section availability Validation unsuccessfull"+ count , Status.FAIL);
			}
		}	catch(Exception e){
			report.updateTestLog("No of Headliner Text image validation under Big image of Signature Gas Grill section ", "Validation failed", Status.FAIL);
		}

	}

	public void validateBigImageOnImageSection(){

		if(driver.findElement(CBSignature.BigImageOnImageSection).isDisplayed()==true){

			try {
				objWebd.highlightElement(CBSignature.BigImageOnImageSection);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("The big Image under Signature Gas Grill  Image section is available ");
			report.updateTestLog("Validate Big Image under Signature Gas Grill Image Section ", "Big Image under Gas-2-Coal Image Section availability Validation successfull", Status.PASS);
		}
		else{
			System.out.println("The Image under Signature Gas Grill   section is not available ");
			report.updateTestLog("Validate Big Image under Signature Gas Grill  Image Section ", "Big Image under Gas-2-Coal Image Section  availability Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateShopNow(){
		try{
			jse.executeScript("window.scrollBy(0,1000)", "");
			if(driver.findElement (CBSignature.ShopNowBtn).isDisplayed()==true){
				objWebd.highlightElement(CBSignature.ShopNowBtn);
				driver.findElement (CBSignature.ShopNowBtn).click();
				report.updateTestLog("Shop Now button validation", "Clicked on 'SHOP NOW' button", Status.DONE);
				System.out.println("Shop Now button is available and clicked");
				Thread.sleep(3000);				
				/*objWebd.highlightElement(CBSignature.SignatureSeriestext);
				objWebd.isTextPresent("Signature Series™ Grills");
				objWebd.isTextPresent("Signature Series™");
				report.updateTestLog("Validation of Signature Series™ Grills and Signature Series™ Text", "validation successfull", Status.PASS);*/
				for(int count=1 ; count<=5 ; count++ )	{
					String url=driver.getCurrentUrl();
					if(url.contains("https://www.charbroil.com/grills/"))	{
						System.out.println("Url navigate :"+url);
						report.updateTestLog("Validation of SHOP Now button Navigation", "Navigate to Correct Url, validation successfull :" + url, Status.PASS);
						break;
					}	else if(count==5)	{
						System.out.println("Url validation fails :"+url);
						report.updateTestLog("Validation of SHOP Now button Navigation", "Not navigate to Correct Url, validation unsuccessfull :" + url, Status.FAIL);
					}	else	{
						report.updateTestLog("Validation of SHOP Now button Navigation", "Not navigated to correct URL in 3 seconds. Will retry in another 2 seconds.", Status.DONE);
						Thread.sleep(3000);
					}
				}
				//validateBreadCrumbLink();
				driver.navigate().back();
			}
		}
		catch(Exception e){
			report.updateTestLog("Validate Shop Now Button  ", "Validation failed. Exception - "+e.getMessage(), Status.FAIL);
			driver.navigate().back();
		}

	}

	public void validateExploreLink(){
		try{
			driver.findElement(CBSignature.Explorelink).isDisplayed();
			driver.findElement(CBSignature.Explorelink).isEnabled();
			objWebd.highlightElement(CBSignature.Explorelink);
			driver.findElement(CBSignature.Explorelink).click();
			//objWebd.wait();
			objWebd.isTextPresent("MADE FOR CONVENIENCE");
			System.out.println("Explore link is validated successfully");
			report.updateTestLog("Validate EXplore Link  ", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			System.out.println("Explore link  validation unsuccessfully");
			report.updateTestLog("Validate EXplore Link  ", "Validation unsuccessful", Status.FAIL);
		}

	}

	public void validateMadeforConvImageCount(){
		try{
			List<WebElement> Images = (driver.findElement(CBSignature.MadeforConveneenceImages)).findElements(By.tagName("li"));
			int Count=Images.size();
			System.out.println("No. of Images under Made for Conveneence section : "+Images.size());
			if((Images.size())==3){

				report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "No of image validation successfull : Image count -" +Count , Status.PASS);
				System.out.println("No of image validation successfull : Image count -" +Images.size()  );
			}
			else{
				report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "No of image validation Unsuccessfull : Image count -" +Count , Status.FAIL);
				System.out.println("No of image validation unsuccessfull : Image count -" +Images.size()  );
			}

			/*for (int i = 0; i < Images.size(); i++)
			{
			    System.out.println(Images.get(i).getText());
			}*/

		}


		catch(Exception e){
			report.updateTestLog("Verify Made for Conveneence setion ", "Validation failed", Status.FAIL);
		}
	}

	public void validatePlusIcon(){
		try{
			objWebd.highlightElement(CBSignature.plusSignOn1stImage);
			objWebd.highlightElement(CBSignature.plusSignOn2ndImage);
			objWebd.highlightElement(CBSignature.plusSignOn3rdImage);

			System.out.println("All plus icons are available");

			driver.findElement(CBSignature.plusSignOn1stImage).click();
			Thread.sleep(300);

			//driver.wait();
			if (driver.findElement(CBSignature.crossSignOnExpanImage).isDisplayed()==true){

				objWebd.highlightElement(CBSignature.crossSignOnExpanImage);

				System.out.println("Cross sign available on expand image");
				report.updateTestLog("Validate Cross icons under Made For Flavor Section  ", "Cross sign available on expand image", Status.PASS);
				driver.findElement(CBSignature.crossSignOnExpanImage).click();
				Thread.sleep(300);
				driver.findElement(CBSignature.plusSignOn2ndImage).click();
				Thread.sleep(300);
				report.updateTestLog("Validation of 2nd image  ", "Validation successfull", Status.PASS);
				driver.findElement(CBSignature.crossSignOnExpanImage).click();
				Thread.sleep(200);
				driver.findElement(CBSignature.plusSignOn3rdImage).click();
				Thread.sleep(300);
				report.updateTestLog("Validation of 3rd image  ", "Validation successfull", Status.PASS);


				if(driver.findElement(CBSignature.Prevlink).isDisplayed()==true){

					objWebd.highlightElement(CBSignature.Prevlink);
					objWebd.highlightElement(CBSignature.Nextlink);

					System.out.println("Previous and Next arrow link avaialble on expand image");
					report.updateTestLog("Previous and Next arrow link  icons under Made For Flavor Section  ", "Previous and Next arrow link avaialble on expand image", Status.PASS);
					driver.findElement(CBSignature.Nextlink).click();
					Thread.sleep(300);
					driver.findElement(CBSignature.Nextlink).click();
					Thread.sleep(300);
					driver.findElement(CBSignature.crossSignOnExpanImage).click();
					Thread.sleep(300);
					System.out.println("clicked on Cross sign available on expand image");
				}

			}

			report.updateTestLog("Validation of plus,previous and Next arrow  icons under MADE FOR FLAVOR section  ", "validation successfull" , Status.PASS);

		}
		catch(Exception e){

		}
		report.updateTestLog("Validation of different iconsunder MADE FOR FLAVOR section  ", "Validation unsuccessfull" , Status.PASS);
	}

	public void validateMadeForFlavorImage(){
		if(driver.findElement(CBSignature.MadeFlavBigImage).isDisplayed()==true){

			System.out.println("The Image under Made For Flavor section is available ");
			report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "Image validation successfull" , Status.PASS);
		}
		else{
			System.out.println("The Image under Made For Flavor section is not available ");
			report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "Image validation unsuccessfull" , Status.FAIL);
		}

	}

	public void validateMadeForFlavorImageCount(){
		try{
			objWebd.waitUntilElementEnabled(CBSignature.MadeFlavAnmImage, 20);
			int size = driver.findElements(CBSignature.MadeFlavAnmImage).size();
			//List<WebElement> AnimatedImages = (driver.findElement(CBSignature.MadeFlavAnmImage)).findElements(By.tagName("div"));			
			System.out.println("No of images under section Made for Flavor :"+ size);
			if(size==5){
				report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "No of image validation successfull : Image count -" +size , Status.PASS);
				System.out.println("No of image validation successfull : Image count -" +size  );
			}
			else{
				report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "No of image validation Unsuccessfull : Image count -" +size, Status.FAIL);
				System.out.println("No of image validation unsuccessfull : Image count -" +size);
			}
		}


		catch(Exception e){
			report.updateTestLog("Verify Made for Conveneence setion ", "Validation failed", Status.FAIL);
		}
	}

	public void validateMadeForFlavorAnimatedImages(){

		try{

			validate1stAnmImage();

			validate2ndAnmImage();

			validate3rdAnmImage();

			validate4thAnmImage();

			validate5thAnmImage();

			//report.updateTestLog("Verify all Animated Images ", "Validation successfull", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Verify all Animated Images", "Validation failed for few images,check report", Status.FAIL);
		}



	}

	public void validate1stAnmImage(){
		try{
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn1stImage).isDisplayed();
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn1stImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBSignature.MadeFlavAnmplusTitle1stImage);
			String Title1=driver.findElement(CBSignature.MadeFlavAnmplusTitle1stImage).getText();
			if (Title1.equalsIgnoreCase("Tong Tied")){
				report.updateTestLog("1st image Title validation", "Validation successful :"+ Title1, Status.PASS);
			}
			else{
				report.updateTestLog("1st image Title validation", "Validation unsuccessful :"+ Title1, Status.FAIL);
			}
			report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);
			objWebd.highlightElement(CBSignature.MadeFlavAnmpluslink1stImage);
			driver.findElement(CBSignature.MadeFlavAnmpluslink1stImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(5000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));			

			for(int count=1 ; count<=5 ; count++ )	{
				String url=driver.getCurrentUrl();
				if(url.equalsIgnoreCase("https://www.charbroil.com/tongs"))		{
					System.out.println("Url navigate :"+ url );
					report.updateTestLog("Validate Link Navigation-1st image", "Navigate to correct Url :"+ url , Status.PASS);
					break;
				}	else if(count==5)	{
					report.updateTestLog("Validate Link Navigation-1st image", "Navigate to correct Url :"+ url , Status.FAIL);
				}	else	{
					report.updateTestLog("Recipes screen", "Not navigated to Recipes screen in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}


			validateBreadCrumbLink();

			driver.close();
			driver.switchTo().window(mainwindowHandle);	
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn1stImage).click();
			Thread.sleep(100);
			//report.updateTestLog("1st Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("1st Animated Image validation", "Validation unsuccessful", Status.FAIL);
		}
	}

	public void validate2ndAnmImage(){
		try{
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn2ndImage).click();
			Thread.sleep(200);

			objWebd.highlightElement(CBSignature.MadeFlavAnmplusTitle2ndImage);
			String Title2=driver.findElement(CBSignature.MadeFlavAnmplusTitle2ndImage).getText();
			if (Title2.equalsIgnoreCase("Cherry Cola Sliders")){
				report.updateTestLog("2nd image Title validation", "Validation successful :"+ Title2, Status.PASS);
			}
			else{
				report.updateTestLog("2nd image Title validation", "Validation unsuccessful :"+ Title2, Status.FAIL);
			}
			objWebd.highlightElement(CBSignature.MadeFlavAnmpluslink2ndImage);

			driver.findElement(CBSignature.MadeFlavAnmplus2ndImage).click();

			//driver.findElement(CBSignature.MadeFlavAnmpluslink2ndImage).click();[Need to incorporate when the image mapping wuith video resolved]

			Thread.sleep(500);

			if(driver.findElement(CBSignature.MadeFlavAnmplusvideo2ndImage).isDisplayed()){
				report.updateTestLog("2nd image link validation", "Validation successful : video appears", Status.PASS);
				driver.findElement(CBSignature.MadeFlavAnmplusvideoclose2ndImage).click();
			}
			else{

				report.updateTestLog("2nd image link validation", "Validation unsuccessful", Status.FAIL);
			}

			driver.findElement(CBSignature.MadeFlavAnmplusSignOn2ndImage).click();
			Thread.sleep(100);
			//report.updateTestLog("2nd Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("2nd Animated Image validation", "Validation usuccessful", Status.PASS);
		}
	}

	public void validate3rdAnmImage(){
		try{
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn3rdImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBSignature.MadeFlavAnmplusTitle3rdImage);
			String Title3=driver.findElement(CBSignature.MadeFlavAnmplusTitle3rdImage).getText();
			if (Title3.equalsIgnoreCase("Stainless Steel Grates")){
				report.updateTestLog("3rd image Title validation", "Validation successful :"+ Title3, Status.PASS);
			}
			else{
				report.updateTestLog("3rd image Title validation", "Validation unsuccessful :"+ Title3, Status.FAIL);
			}
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn3rdImage).click();
			Thread.sleep(100);
			//report.updateTestLog("3rd Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("3rd Animated Image validation", "Validation usuccessful", Status.FAIL);
		}
	}

	public void validate4thAnmImage(){
		try{
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn4thImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBSignature.MadeFlavAnmplusTitle4thImage);
			String Title4=driver.findElement(CBSignature.MadeFlavAnmplusTitle4thImage).getText();
			if (Title4.equalsIgnoreCase("Keeping It Warm")){
				report.updateTestLog("4th image Title validation", "Validation successful :"+ Title4, Status.PASS);
			}
			else{
				report.updateTestLog("4th image Title validation", "Validation unsuccessful :"+ Title4, Status.FAIL);
			}
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn4thImage).click();
			Thread.sleep(2000);
			//report.updateTestLog("4th Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("4th Animated Image validation", "Validation unsuccessful", Status.FAIL);
		}
	}

	public void validate5thAnmImage(){
		try{
			driver.findElement(CBSignature.MadeFlavAnmplusSignOn5thImage).click();
			Thread.sleep(1000);
			objWebd.highlightElement(CBSignature.MadeFlavAnmplusTitle5thImage);
			String Title5=driver.findElement(CBSignature.MadeFlavAnmplusTitle5thImage).getText();
			if (Title5.equalsIgnoreCase("How to grill brats to the perfect temperature")){
				report.updateTestLog("5th image Title validation", "Validation successful :"+ Title5, Status.PASS);
			}
			else{
				report.updateTestLog("5th image Title validation", "Validation unsuccessful :"+ Title5, Status.FAIL);
			}
			objWebd.highlightElement(CBSignature.MadeFlavAnmpluslink5thImage);
			driver.findElement(CBSignature.MadeFlavAnmpluslink5thImage).click();
			Thread.sleep(10000);
			String mainwindowHandle = driver.getWindowHandle();
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));
			for(int count=1 ; count<=5 ; count++ )	{
				String url=driver.getCurrentUrl();
				if(url.equalsIgnoreCase("https://www.charbroil.com/learn/how-to-grill-brats-temperature")){
					System.out.println("Url navigate :"+ url );
					report.updateTestLog("Validate Link Navigation-5th image  ", "Navigate to correct Url :"+ url , Status.PASS);
					break;
				}	else if(count==5)	{
					report.updateTestLog("Validate Link Navigation-5th image  ", "Navigate to correct Url :"+ url , Status.FAIL);
				}	else	{
					report.updateTestLog("Recipes screen", "Not navigated to Recipes screen in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
					Thread.sleep(2000);
				}
			}
			//validateEntryTitle();
			driver.close();
			driver.switchTo().window(mainwindowHandle);	
			//driver.findElement(CBSignature.MadeFlavAnmplusClose5thImage).click();
			Thread.sleep(100);
			//report.updateTestLog("5th Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("5th Animated Image validation", "Validation usuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validateEntryTitle(){

		try{
			driver.findElement(CBSignature.ProdutEntryTitle).isDisplayed();
			objWebd.highlightElement(CBSignature.ProdutEntryTitle);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBSignature.ProdutEntryTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "validation successfull for Productpage Title :" + text, Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBSignature.ProdutPageTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "Validation unsuccessfull:"+ Value, Status.FAIL);
		}  

	}

	public void validateFullLineUpImageCount(){

		try	{
			objWebd.waitUntilElementLocated(CBSignature.FullLineUpImages, 10);
			List<WebElement> Images = driver.findElements(CBSignature.FullLineUpImagesIcons);
			int Count=Images.size();
			//System.out.println("No. of Images under Made for Full Line Up Image section : "+Images.size());

			if((Images.size())==5){
				report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "No of image validation successfull : Image count -" +Count , Status.PASS);
				System.out.println("No of image validation successfull : Image count -" +Images.size()  );
			}
			else{
				report.updateTestLog("image validation under MADE FOR FLAVOR section  ", "Expected image count 5. No of image validation Unsuccessfull : Image count -" +Count , Status.FAIL);
				System.out.println("No of image validation unsuccessfull : Image count -" +Images.size()  );
			}

			/*for (int i = 0; i < Images.size(); i++)
			{
				 //WebElement linkElement = driver.findElement(By.xpath("//*[@class='line-up__content content-desktop']/div[" + i + "]/a[2]"));
				 //objWebd.highlightElement(Images[i]);
			    //System.out.println(linkElement.getText());
			}*/

		}


		catch(Exception e){
			report.updateTestLog("Validation of Images under Full Line Up Section", "Validation failed", Status.FAIL);
		}

	}

	public void validateFullLineUpExclusiveImageCount(){

		try{
			//List<WebElement> Elements = (driver.findElement(CBSignature.FullLineUpImages)).findElements(By.tagName("div"));
			List<WebElement> Elements = driver.findElements(CBSignature.FullLineUpImagesIcons);
			System.out.println("No of images under section The Full Line Up :"+ Elements.size());
			int count=0;
			for(int i=1; i <= Elements.size(); i++)
			{
				//WebElement linkElement = driver.findElement(By.xpath("//*[@class='line-up__content content-desktop']/div[" + i + "]/a[2]"));
				WebElement linkElement = driver.findElement(By.xpath("//*[@class='line-up__content content-desktop']/div["+i+"]/a/div[2]"));
				if(linkElement.getText().equalsIgnoreCase("Lowe's Exclusive")){
					count++;

				} 
			}
			if(count==2){
				report.updateTestLog("Validation of Exclusive images Images under Full Line Up Section", "Validation successfull"+count, Status.PASS);
				System.out.println("Validation of Exclusive images Images under section The Full Line Up :"+ count);
			}

		}


		catch(Exception e){
			report.updateTestLog("Validation of Exclusive images Images under Full Line Up Section", "Validation failed", Status.FAIL);
		}

	}

	public void validateShopAllSignatureGrillsBtn(){
		try{
			if(driver.findElement (CBSignature.ShopAllSignGrillsBtn).isDisplayed()==true){
				objWebd.highlightElement(CBSignature.ShopAllSignGrillsBtn);
				String Btnname=driver.findElement (CBSignature.ShopAllSignGrillsBtn).getText();
				driver.findElement (CBSignature.ShopAllSignGrillsBtn).click();
				System.out.println("SHOP All Signature Grill button is available and clicked "+ Btnname);
				Thread.sleep(500);

				/*objWebd.highlightElement(CBSignature.SignatureSeriestext);
				objWebd.isTextPresent("Signature Series™ Grills");
				objWebd.isTextPresent("Signature Series™");
				report.updateTestLog("Validation of Signature Series™ Grills and Signature Series™ Text", "validation successfull", Status.PASS);*/
				for(int count=1 ; count<=5 ; count++ )	{
					String url=driver.getCurrentUrl();
					if(url.contains("https://www.charbroil.com/grills/gas-grills")){
						System.out.println("Url navigate :"+url);
						report.updateTestLog("Validation of SHOP All Signature Grill button Navigation", "Navigate to Correct Url,validation successfull" + url, Status.PASS);
						break;
					}else if(count==5)
						report.updateTestLog("Validation of SHOP All Signature Grill button Navigation", "Not navigated to correct URL.", Status.FAIL);
					else	{
						report.updateTestLog("Validation of SHOP All Signature Grill button Navigation", "Not navigated to correct URL in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
						Thread.sleep(2000);
					}
				}

				//validateBreadCrumbLink();
				driver.navigate().back();
			}
			else{
				report.updateTestLog("Validate Shop All Signature Grill Button Validation  ", "Validation failed", Status.FAIL);
			}

		}
		catch(Exception e){
			report.updateTestLog("Validation of SHOP All Signature Grill button Navigation", "Validation failed. Exception - "+e , Status.FAIL);
			driver.navigate().back();
		}

	}

	public void validateBreadCrumbLink(){

		try{
			driver.findElement(CBSignature.ProdutBreadCrumb).isDisplayed();
			objWebd.highlightElement(CBSignature.ProdutBreadCrumb);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBSignature.ProdutBreadCrumb).getText();
			report.updateTestLog("Breadcumb link Validation", "validation successfull for Breadcumb Link:" + text, Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBSignature.MainContainer).getAttribute("id");
			report.updateTestLog("Breadcumb link Validation", "Validation unsuccessfull:"+ Value, Status.FAIL);
		}  
	}

}
