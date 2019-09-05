package businesscomponents;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.framework.Status;
import com.cognizant.framework.selenium.WebDriverUtil;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.CBNowYoureCookin;

public class ValidateCBNowYoureCookin extends ReusableLibrary{

	WebDriverUtil objWebd=new WebDriverUtil(driver);
	HomePageComponents obj=new HomePageComponents(scriptHelper);
	GeneralComponents gc = new GeneralComponents(scriptHelper);
	JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver();
	private static final String GENERAL_DATA = "General_Data";

	public ValidateCBNowYoureCookin(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	public void validateHeaderOption(){
		obj.validateMyAccLink();
		//obj.validateLoginLink();
		obj.validateCountrydropdown();

	}

	public void validateVideo(){

		try{
			driver.findElement(CBNowYoureCookin.Video).isDisplayed();
			Thread.sleep(1000);
			report.updateTestLog("Validate Video ", "Video available" , Status.PASS);
			objWebd.mouseOver(CBNowYoureCookin.Video);
			driver.findElement(By.xpath("//*[@id='pause']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='pause']")).click();
			report.updateTestLog("Validate Video Play-pause,mute -unmute options", "Validation successfull" , Status.PASS);
			driver.findElement(By.xpath("//*[@id='mute']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='mute']")).click();
			Thread.sleep(300);
			jse.executeScript("window.scrollBy(0,500)", "");

			Thread.sleep(300);

		}
		catch(Exception e){
			report.updateTestLog("Validate Video ", "Video validation failed" , Status.FAIL);
		}
	}

	public void validateHorzSliderImageCount(){
		try{


			objWebd.highlightElement(CBNowYoureCookin.SwipperPage);
			List<WebElement> Images = (driver.findElement(CBNowYoureCookin.SwipperPage)).findElements(By.tagName("a"));
			int Count=Images.size();
			System.out.println("No. of Images in CB -slider under Video section : "+Images.size());
			if((Images.size())==5){

				report.updateTestLog("Horizontal Slider  Image count validation under Video section ", "No of image validation successfull : Image count -" +Count , Status.PASS);
				System.out.println("Horizontal Slider  Image count validation under Video successfull : Image count -" +Images.size()  );
			}
			else{
				report.updateTestLog("Horizontal Slider  Image count validation under Video", "No of image validation Unsuccessfull : Image count -" +Count , Status.FAIL);
				System.out.println("No of image validation unsuccessfull : Image count -" +Images.size()  );
			}

			/*for (int i = 0; i < Images.size(); i++)
			{
			    System.out.println(Images.get(i).getText());
			}*/

		}
		catch(Exception e){
			report.updateTestLog("Horizontal Slider  Image count validation", "Validation failed", Status.FAIL);
		}
	}

	public void validateSeeWhatsNewLink(){
		try{
			if(driver.findElement(CBNowYoureCookin.seeWhatsNewLink).isDisplayed()==true){
				objWebd.highlightElement(CBNowYoureCookin.seeWhatsNewLink);
				driver.findElement(CBNowYoureCookin.seeWhatsNewLink).click();
				Thread.sleep(300);
				driver.findElement(CBNowYoureCookin.NowYourImg).isDisplayed();
				report.updateTestLog("See What's New Link validation", "Validation Successful", Status.PASS);	
			}
			else{
				report.updateTestLog("See What's New Link validation", "Validation Unsuccessful", Status.FAIL);
			}

		}
		catch(Exception e){
			report.updateTestLog("See What's New Link validation", "Validation Unsuccessful,Check the report", Status.FAIL);
		}
	}

	public void validateProductcardContainer(){
		try{
			//WebElement ele=driver.findElement(CBNowYoureCookin.Productcard);
			//List<WebElement> Images = (driver.findElement(CBNowYoureCookin.ProductcardsContainer)).findElements(By.tagName("div"));
			List<WebElement> Images = (driver.findElement(CBNowYoureCookin.ProductcardsContainer)).findElements(CBNowYoureCookin.Productcard);
			int Count=Images.size();
			System.out.println("No. of products available under Now You are section : "+Images.size());
			if((Images.size())==6){

				report.updateTestLog("Product count validation under Now You are section ", "Product count validation successfull : Image count -" +Count , Status.PASS);
				System.out.println("No. of products available under Now You are section successfull : Image count -" +Images.size()  );
			}
			else{
				report.updateTestLog("Horizontal Slider  Image count validation under Video", "No of image validation Unsuccessfull : Image count -" +Count , Status.FAIL);
				System.out.println("No of image validation unsuccessfull : Image count -" +Images.size()  );
			}


		}
		catch(Exception e){
			report.updateTestLog("Product count validation under Now You are section ", "Product count validation unsuccessfull : Check report-", Status.FAIL);
		}
	}

	public void validateProduct(){
		validate1stProduct();
		validate2ndProduct();
		validate3rdProduct();

		validate4thProduct();
		validate5thProduct();
		validate6thProduct();


	}

	public void validate1stProduct(){
		try{

			gc.scrollToElement(CBNowYoureCookin.frstProduct);
			objWebd.highlightElement(CBNowYoureCookin.frstProduct);

			objWebd.highlightElement(CBNowYoureCookin.LearnMorelink1stImagefront);
			objWebd.mouseOver(CBNowYoureCookin.frstProductImage);

			Thread.sleep(1000);
			objWebd.highlightElement(CBNowYoureCookin.ShopNowlink1stImageBack);
			driver.findElement(CBNowYoureCookin.ShopNowlink1stImageBack).click();
			Thread.sleep(5000);
			String url=driver.getCurrentUrl();

			if(url.contains("https://www.charbroil.com/grills/gas-grills"))
			{			
				System.out.println("Url navigate :"+url);
				report.updateTestLog("Validate Shop Now link  Navigation-first product", "Navigate to correct Url :"+ url, Status.PASS);
			}	else	{
				report.updateTestLog("Validate Shop Now link  Navigation-first product ", "Navigation unsuccessful "+url, Status.FAIL);
			}

			driver.navigate().back();			
			Thread.sleep(2000);
		}
		catch(Exception e){
			report.updateTestLog("First product validation", "validation unsuccessfull", Status.FAIL);
		}
	}

	public void validate2ndProduct(){
		try{

			objWebd.highlightElement(CBNowYoureCookin.SecProduct);
			/*objWebd.isTextPresent("In the zone");
			objWebd.isTextPresent("Signature");
			objWebd.isTextPresent("Gas Grill"); 
			objWebd.isTextPresent("GREAT STAINLESS STEEL GRILL WITH EVEN HEATING!");*/

			objWebd.highlightElement(CBNowYoureCookin.LearnMorelink2ndImagefront);
			objWebd.mouseOver(CBNowYoureCookin.SecProductImage);
			//objWebd.mouseHoverJScript(driver.findElement(CBNowYoureCookin.SecProductImage));
			Thread.sleep(1000);
			objWebd.highlightElement(CBNowYoureCookin.ShopNowlink2ndImageBack);
			driver.findElement(CBNowYoureCookin.ShopNowlink2ndImageBack).click();
			Thread.sleep(5000);
			String url=driver.getCurrentUrl();
			//driver.navigate().refresh();
			//Thread.sleep(100);
			//objWebd.highlightElement(CBNowYoureCookin.SignatureSeriestext);
			//if(url.equalsIgnoreCase("https://www.charbroil.com/signature-series-3-burner-gas-grill"))
			if(url.equalsIgnoreCase("https://www.charbroil.com/commercial-tru-infrared-double-header-3-burner-gas-grill"))
			{
				//objWebd.isTextPresent("Signature Series™ Grills");
				//report.updateTestLog("Validate the text Signature Series™ Grills", "validation successful" , Status.DONE);

				System.out.println("Url navigate :"+url);
				report.updateTestLog("Validate Shop Now link  Navigation-2nd Product   ", "Navigate to correct Url  :"+ url   , Status.PASS);
			}

			else{
				report.updateTestLog("Validate Shop Now link  Navigation-2nd Product ", "Navigation unsuccessful ", Status.FAIL);
			}
			validateBreadCrumbLink();
			driver.navigate().back();
			Thread.sleep(2000);

			//report.updateTestLog("Second product validation    ", "validation successfull", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Second product validation", "validation unsuccessfull. Exception - "+e, Status.FAIL);
		}
	}

	public void validate3rdProduct(){
		try{

			objWebd.highlightElement(CBNowYoureCookin.ThirdProduct);
			/*objWebd.isTextPresent("Signature");
			objWebd.isTextPresent("TRU-Infrared");
			objWebd.isTextPresent(" Gas Grill"); 
			objWebd.isTextPresent("SO EASY TO GRILL PERFECTLY!!");*/

			objWebd.highlightElement(CBNowYoureCookin.LearnMorelink3rdImagefront);
			objWebd.mouseOver(CBNowYoureCookin.ThirdProductImage);
			//objWebd.mouseHoverJScript(driver.findElement(CBNowYoureCookin.ThirdProductImage));
			Thread.sleep(1000);
			objWebd.highlightElement(CBNowYoureCookin.ShopNowlink3rdImageBack);
			driver.findElement(CBNowYoureCookin.ShopNowlink3rdImageBack).click();
			Thread.sleep(5000);
			String url=driver.getCurrentUrl();

			Thread.sleep(1000);
			if(url.contains("https://www.charbroil.com/modularoutdoorkitchen"))
			{				
				System.out.println("Url navigate :"+url);
				report.updateTestLog("Validate Shop Now link  Navigation-3rd product   ", "Navigate to correct Url "+ url   , Status.PASS);
			}
			else	{
				report.updateTestLog("Validate Shop Now link  Navigation-3rd product ", "Navigation unsuccessful ", Status.FAIL);
			}

			driver.navigate().back();
			Thread.sleep(3000);
		}
		catch(Exception e){
			report.updateTestLog("Third product validation", "validation unsuccessfull,Check the Screenshot. Exception - "+e, Status.FAIL);
			driver.navigate().back();
		}
	}

	public void validate4thProduct(){
		try{
			jse.executeScript("window.scrollBy(0,650)", "");
			Thread.sleep(2000);

			//validateStickySignup();
			objWebd.highlightElement(CBNowYoureCookin.ForthProduct);
			/*objWebd.isTextPresent("In total control");
			objWebd.isTextPresent("SmartChef");
			objWebd.isTextPresent("Gas Grill"); 
			objWebd.isTextPresent("The SmartChef Gas Grill… freeing you from the chains of watchfulness that usually accompany a barbeque");*/
			objWebd.highlightElement(CBNowYoureCookin.LearnMorelink4thImagefront);
			objWebd.mouseOver(CBNowYoureCookin.ForthProductImage);
			//objWebd.mouseHoverJScript(driver.findElement(CBNowYoureCookin.ForthProductImage));
			Thread.sleep(1000);
			objWebd.highlightElement(CBNowYoureCookin.ShopNowlink4thImageBack);
			driver.findElement(CBNowYoureCookin.ShopNowlink4thImageBack).click();
			Thread.sleep(5000);
			String url=driver.getCurrentUrl();

			if(url.contains("https://www.charbroil.com/gas2coal"))
			{				
				System.out.println("Url navigate :"+url);
				report.updateTestLog("Validate Shop Now link  Navigation-4th product   ", "Navigate to correct Url and product name :"+ url, Status.PASS);
			}	else	{
				report.updateTestLog("Validate Shop Now link  Navigation-4th product", "Navigation successful ", Status.PASS);
			}			
			driver.navigate().back();
			Thread.sleep(2000);
			//report.updateTestLog("Forth product validation    ", "validation Completed", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Forth product validation", "validation unsuccessfull. Exception - "+e, Status.FAIL);
			driver.navigate().back();

		}
	}

	public void validate5thProduct(){
		try{

			objWebd.highlightElement(CBNowYoureCookin.FifthProduct);
			/*objWebd.isTextPresent("Makin’ it Easy");
			objWebd.isTextPresent("Patio Bistro");
			objWebd.isTextPresent("Electric Grill");
			objWebd.isTextPresent("...REALLY replicates an actual grill, complete with grill marks!");*/
			objWebd.highlightElement(CBNowYoureCookin.LearnMorelink5thImagefront);
			objWebd.mouseOver(CBNowYoureCookin.FifthProductImage);
			//objWebd.mouseHoverJScript(driver.findElement(CBNowYoureCookin.FifthProductImage));
			Thread.sleep(1000);
			objWebd.highlightElement(CBNowYoureCookin.ShopNowlink5thImageBack);
			driver.findElement(CBNowYoureCookin.ShopNowlink5thImageBack).click();
			Thread.sleep(5000);
			String url=driver.getCurrentUrl();			
			if(url.equalsIgnoreCase("https://www.charbroil.com/patio-bistro-electric-grill-2017"))
			{				
				System.out.println("Url navigate :"+url);
				report.updateTestLog("Validate Shop Now link  Navigation-5th product   ", "Navigate to correct Url "+ url   , Status.PASS);
			}	else	{
				report.updateTestLog("Validate Shop Now link  Navigation-5th product ", "Navigation unsuccessful ", Status.FAIL);
			}
			validateBreadCrumbLink();
			//closeCharbroilpopup();
			driver.navigate().back();
			Thread.sleep(2000);
		}
		catch(Exception e){
			report.updateTestLog("Fifth product validation", "validation unsuccessfull. Exception-"+e, Status.FAIL);
			driver.navigate().back();

		}
	}

	public void validate6thProduct(){
		try{
			objWebd.highlightElement(CBNowYoureCookin.SixthProduct);
			/*objWebd.isTextPresent("Gettin’ People Talking");
			objWebd.isTextPresent("Kamander");
			objWebd.isTextPresent(" Charcoal Grill");
			objWebd.isTextPresent("All the features of the big boys, at a value price");*/
			objWebd.highlightElement(CBNowYoureCookin.LearnMorelink6thImagefront);
			objWebd.mouseOver(CBNowYoureCookin.SixthProductImage);
			//objWebd.mouseHoverJScript(driver.findElement(CBNowYoureCookin.SixthProductImage));
			Thread.sleep(1000);
			objWebd.highlightElement(CBNowYoureCookin.ShopNowlink6thImageBack);
			driver.findElement(CBNowYoureCookin.ShopNowlink6thImageBack).click();
			Thread.sleep(5000);
			String url=driver.getCurrentUrl();

			if(url.contains("https://www.charbroil.com/portable-grill2go-reg-x200-gas-grill"))
			{
				System.out.println("Url navigate :"+url);
				report.updateTestLog("Validate Shop Now link  Navigation-6th product   ", "Navigate to correct Url "+ url   , Status.PASS);
			}	else	{
				report.updateTestLog("Validate Shop Now link  Navigation-6th product  ", "Navigation unsuccessful ", Status.FAIL);
			}
			//driver.navigate().refresh();
			validateBreadCrumbLink();
			driver.navigate().back();
			Thread.sleep(2000);
			//report.updateTestLog("Fifth product validation    ", "validation Completed", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Sixth product validation", "validation unsuccessfull. Exception - "+e, Status.FAIL);
			driver.navigate().back();
		}
	}

	public void validateBreadCrumbLink(){

		try{
			driver.findElement(CBNowYoureCookin.ProdutBreadCrumb).isDisplayed();
			objWebd.highlightElement(CBNowYoureCookin.ProdutBreadCrumb);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBNowYoureCookin.ProdutBreadCrumb).getText();
			report.updateTestLog("Breadcumb link Validation", "validation successfull for Breadcumb Link:" + text, Status.PASS);			
		}
		catch(Exception e){
			String Value=driver.findElement(CBNowYoureCookin.MainContainer).getAttribute("id");
			report.updateTestLog("Breadcumb link Validation", "Validation unsuccessfull :"+ Value, Status.FAIL);
			//if(Value=="message-404"){
			//report.updateTestLog("Page validation", "Page Not found :"+Value, Status.FAIL);
			//}
			//else{
			//	report.updateTestLog("Page validation", "Page Not found ,check the screenshot" , Status.FAIL);
			//}
		}
	}

	public void validateStickySignup(){
		try{
			//jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(500);
			driver.findElement(CBNowYoureCookin.StickySignup).isDisplayed();
			objWebd.highlightElement(CBNowYoureCookin.StickySignup);
			driver.findElement(CBNowYoureCookin.StickySignupClose).isDisplayed();
			objWebd.highlightElement(CBNowYoureCookin.StickySignupClose);
			driver.findElement(CBNowYoureCookin.StickySignupClose).click();
			report.updateTestLog("Sticky sign up Validation", "Validation successful", Status.PASS);

		}
		catch(Exception e){

			report.updateTestLog("Sticky sign up Validation", "Validation Unsuccessful", Status.FAIL);
		}
	}

	public void validateFindyourGrillsection(){
		try{
			jse.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(200);
			jse.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(200);
			objWebd.isTextPresent("find the grill for you");
			objWebd.isTextPresent("Not sure what grill is right for you? Take our quick quiz to find out.");
			report.updateTestLog("Validate The Texts  ", "Text Validation successfull", Status.PASS);
			objWebd.highlightElement(CBNowYoureCookin.GetStartedLink);
			driver.findElement(CBNowYoureCookin.GetStartedLink).click();
			String mainwindowHandle = driver.getWindowHandle();
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(10000);
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase("http://findyourcharbroil.com/")){
				System.out.println("Url navigate :"+ url );
				report.updateTestLog("Validate Get Started Link Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);
			}	else	{
				report.updateTestLog("Validate Get Started Link Navigation  ", "Navigate to correct Url :"+ url , Status.FAIL);
			}
			validateFindcharbroilpage();
			driver.close();
			driver.switchTo().window(mainwindowHandle);
		}
		catch(Exception e){
			report.updateTestLog("Validate Find Your Grill Section ", "Validation failed.check the error report" , Status.FAIL);
		}

	}

	public void validateFindcharbroilpage(){
		try{
			//driver.navigate().refresh();
			Thread.sleep(500);
			driver.findElement(CBNowYoureCookin.FindCharbroillogo).isDisplayed();
			report.updateTestLog("Validate Find Your Charbroil Page ", "Logo appears", Status.PASS);
		}	catch(Exception e){
			report.updateTestLog("Validate Find Your Charbroil Page ", "Logo does not appear", Status.FAIL);
		}
	}

	public void validateNowYouAreCookinLink(){
		try{
			//closeCharbroilpopup();
			jse.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(1000);
			/*driver.findElement(CBNowYoureCookin.NowYrCookinLink).isDisplayed();
			objWebd.highlightElement(CBNowYoureCookin.NowYrCookinLink);*/
			objWebd.waitUntilElementLocated(CBNowYoureCookin.NowYrCookinLink, 10);
			driver.findElement(CBNowYoureCookin.NowYrCookinLink).click();
			Thread.sleep(300);
			objWebd.isTextPresent("Follow Us On Instagram");
			System.out.println("Validation Now you are cookin link successfull");
			report.updateTestLog("Validate NOW YOU'RE COOKIN Link ", "Scroll the window to Follow us on instagram section", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Validate NOW YOU'RE COOKIN Link ", "Validation unsuccessful. Exception is - "+e.getMessage(), Status.FAIL);

		}
	}

	public void validateInstagramSection(){
		try{

			System.out.println("/*------------------Follow us on Instagram-------------------------*/");
			driver.findElement(CBNowYoureCookin.FollowUsOnInstagram).isDisplayed();
			objWebd.highlightElement(CBNowYoureCookin.FollowUsOnInstagram);
			//objWebd.isTextPresent("Follow Us On Instagram");
			report.updateTestLog("Follow Us On Instagram  validation ", "validation Successfull", Status.PASS);

			List<WebElement> Images = (driver.findElement(CBNowYoureCookin.InstgrmGrid)).findElements(By.tagName("div"));
			int Count=Images.size();
			//System.out.println("No. ofinstagram posts available under Follow us on Instagram section : "+Images.size());
			if((Images.size())==15){

				report.updateTestLog("Instagram post count validation under Follow us on Instagram section ", "Product count validation successfull : Image count -" +Count , Status.PASS);
				System.out.println("No. of Instagram post available under Follow us on Instagram section successfull : posts count -" +Images.size()  );
			}
			else{
				report.updateTestLog("Instagram post count validation under Follow us on Instagram section ", "Product count validation successfull : Image count -" +Count , Status.FAIL);
				System.out.println("No of Instagram postvalidation unsuccessfull : Image count -" +Images.size()  );
			}
		}
		catch(Exception e){

		}
	}

	public void validateNowYouCookSignUp(){
		try{
			//jse.executeScript("window.scrollBy(0,1500)", "");
			String Confirmationmsg = dataTable.getData(GENERAL_DATA, "SignUpConfirmationMessage");
			String emailid = dataTable.getData(GENERAL_DATA, "Username");
			//jse.executeScript("window.scrollBy(0,250)", "");
			System.out.println("/*------------------Now Your Cookin-Sign Up--------------------------*/");
			objWebd.highlightElement(CBNowYoureCookin.SignupMailtxt);
			driver.findElement(CBNowYoureCookin.SignupMailtxt).sendKeys(emailid);
			objWebd.highlightElement(CBNowYoureCookin.SignupBtn);
			driver.findElement(CBNowYoureCookin.SignupBtn).click();
			Thread.sleep(300);
			objWebd.highlightElement(CBNowYoureCookin.ThankuMsg);
			String ActualConfirmationmsg=driver.findElement(CBNowYoureCookin.ThankuMsg).getText();
			if (ActualConfirmationmsg.equalsIgnoreCase(Confirmationmsg)){

				System.out.println("Subscription confirmation :"+ ActualConfirmationmsg  );
				report.updateTestLog("Validate Sign Up ", "Subscription confirmation msg:"+ ActualConfirmationmsg, Status.PASS);	
			}
			else{
				report.updateTestLog("Validate Sign Up ", "Confirmation msg is different", Status.SCREENSHOT);

			}

		}
		catch(Exception e){
			report.updateTestLog("Validate Sign Up ", "Sign Up Validation unsuccessfull. Exception is - "+e.getMessage(), Status.FAIL);
		}


	}

	public void validateProductContainerCount(){
		try{
			List<WebElement> Images = (driver.findElement(CBNowYoureCookin.ProductcardContainer)).findElements(By.tagName("div"));
			int Count=Images.size();
			System.out.println("No. of Images under Made for Conveneence section : "+Images.size());
			if((Images.size())==6){

				report.updateTestLog("Product count validation under Now You Are Section ", "No of product validation successfull : Image count -" +Count , Status.PASS);
				System.out.println("Horizontal Slider  Image count validation under Video successfull : Image count -" +Images.size()  );
			}
			else{
				report.updateTestLog("Product count validation under Now You Are Section", "No of image validation Unsuccessfull : Image count -" +Count , Status.FAIL);
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

	public void closeCharbroilpopup(){

		try{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			//driver.findElement(CBNowYoureCookin.CharbroilPopupCloseBtn).isDisplayed();
			driver.switchTo().frame("inqChatStage");
			//objWebd.waitUntilElementVisible(CBNowYoureCookin.CharbroilPopupCloseBtn, 30);
			driver.findElement(CBNowYoureCookin.CharbroilPopupCloseBtn).isDisplayed();
			//driver.findElement(CBNowYoureCookin.CharbroilPopup).isDisplayed();
			//objWebd.highlightElement(CBNowYoureCookin.CharbroilPopup);
			driver.findElement(CBNowYoureCookin.CharbroilPopupCloseBtn).click();
			Thread.sleep(300);
			report.updateTestLog("Charbroil Pop up window", "Pop up window Closed", Status.PASS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch(Exception e){
			report.updateTestLog("Charbroil Pop up window ", "No pop up window available", Status.SCREENSHOT);
		}
	}

	public void messageHandler() throws InterruptedException{

		//driver.navigate().refresh();
		boolean popupChck= false;
		try
		{
			popupChck = popChecker().isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("Feedback Pop up not found");
		}

		if(popupChck == true)
		{
			popChecker().click();
			Thread.sleep(4000);
			System.out.println("Feedback Pop up found and closed");
		}


	}

	public WebElement popChecker(){
		//WebElement popUp=driver.findElement(By.cssSelector("#oo_close_prompt>span"));
		//WebElement popUp=driver.findElement(By.xpath(".//*[@id='oo_close_prompt']"));
		WebElement popUp=driver.findElement(CBNowYoureCookin.CharbroilPopupCloseBtn);
		return popUp;
	}

}
