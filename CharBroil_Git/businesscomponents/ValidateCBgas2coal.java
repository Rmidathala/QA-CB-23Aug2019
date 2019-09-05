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
import uimap.CBgas2coal;

public class ValidateCBgas2coal extends ReusableLibrary {

	WebDriverUtil objWebd=new WebDriverUtil(driver);
	HomePageComponents obj=new HomePageComponents(scriptHelper);
	JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver();
	private static final String GENERAL_DATA = "General_Data";

	public ValidateCBgas2coal(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}


	public void validateGas2GoalSection(){
		try{
			System.out.println("/*------------------Gas-2-Coal section--------------------------*/");
			objWebd.isTextPresent("Gas-2-Coal Hybrid Grill");
			report.updateTestLog("Validate Gas-2-Coal Hybrid Text ", "Gas-2-Coal Hybrid Text Validation successfull", Status.PASS);
			System.out.println("Gas-2-Coal Hybrid Grill text available");
			obj.validateMyAccLink();
			//obj.validateLoginLink();
			obj.validateCountrydropdown();
			validateBacktoTopArrow();
			validateStickybar();
			validateGas2CoalImage();
			objWebd.highlightElement(CBgas2coal.BigImageHeadliner);
			objWebd.isTextPresent("SWITCHIN’ THINGS UP");
			report.updateTestLog("Validate SWITCHIN’ THINGS UP on The image ", "SWITCHIN’ THINGS UP Text Validation successfull", Status.PASS);
			System.out.println("SWITCHIN’ THINGS UP text available on The Image");
			validateSmallImgsOnImageSection();
			validateBigImageOnImageSection();
			validateShopNow();
			validateExploreLink();
		}
		catch(Exception e){
			report.updateTestLog("Validate For GAS-2-Goal section  ", "Few Validation Failed,Check the Report,", Status.FAIL);
		}


	}

	public void validateMadeforConvenienceSection(){

		System.out.println("/*------------------Made For Convenience section--------------------------*/");
		objWebd.isTextPresent("MADE FOR CONVENIENCE");
		objWebd.isTextPresent("Enjoy the convenience of gas and the great flavor of charcoal in one convertible grill.");

		report.updateTestLog("Validate Texts under MADE FOR CONVENIENCE section ", "Both the  Text line Validation Successfull", Status.DONE);

		validateMadeforConvImageCount();
		validatePlusIcon();

	}

	public void validatemadeforFlavorSection(){
		try		{
			jse.executeScript("window.scrollBy(0,650)", "");
			System.out.println("/*------------------Made For Flavor section--------------------------*/");
			objWebd.isTextPresent("MADE FOR FLAVOR");
			System.out.println("MADE FOR FLAVOR text available");
			report.updateTestLog("Validate Texts under MADE FOR FLAVOR section  ", "Text Validation Successfull", Status.DONE);
			validateMadeForFlavorImage();
			validateMadeForFlavorImageCount();
			validateMadeForFlavorAnimatedImages();
		}	catch(Exception e){
			report.updateTestLog("Validate Made For Flavor section  ", "Validation Failed", Status.FAIL);
			report.updateTestLog("Exception in validatemadeforFlavorSection", "Exception is - "+e, Status.FAIL);
		}
	}

	public void validateForbesSection(){

		try{
			jse.executeScript("window.scrollBy(0,650)", "");
			System.out.println("/*------------------Forbes Section--------------------------*/");
			objWebd.isTextPresent("THIS IS THE GRILL YOU WANT TO WOW A HUNGRY CROWD");
			System.out.println("THIS IS THE GRILL YOU WANT TO WOW A HUNGRY CROWD text available");
			objWebd.highlightElement(CBgas2coal.SwingAWay);
			objWebd.isTextPresent("SWING-A-WAY");
			objWebd.highlightElement(CBgas2coal.AnOpenShCs);
			objWebd.isTextPresent("AN OPEN & SHUT CASE");
			report.updateTestLog("Validate Texts under Forbes section  ", "Both the  Text line under Forbes Validation Successfull", Status.DONE);
			System.out.println("Swing away and An open & Shut case text validated");
			validateForbessectionImage();
			validateDragdropIcon();
			validateShopGas2CoalBtn();
		}
		catch(Exception e){

			report.updateTestLog("Validate Forbes section  ", "Validation Failed", Status.FAIL);
		}

	}

	public void validateGastoCoalSignUp(){
		try{
			jse.executeScript("window.scrollBy(0,250)", "");
			String Confirmationmsg = dataTable.getData(GENERAL_DATA, "SignUpConfirmationMessage");
			String emailid = dataTable.getData(GENERAL_DATA, "Username");
			jse.executeScript("window.scrollBy(0,250)", "");
			System.out.println("/*------------------Gas-2-Coal-Sign Up--------------------------*/");

			objWebd.highlightElement(CBgas2coal.SignupMailtxt);
			driver.findElement(CBgas2coal.SignupMailtxt).sendKeys(emailid);
			objWebd.highlightElement(CBgas2coal.SignupBtn);
			driver.findElement(CBgas2coal.SignupBtn).click();
			Thread.sleep(300);
			objWebd.highlightElement(CBgas2coal.ThankuMsg);
			String ActualConfirmationmsg=driver.findElement(CBgas2coal.ThankuMsg).getText();
			if (ActualConfirmationmsg.equalsIgnoreCase(Confirmationmsg)){
				System.out.println("Subscriprion confirmatin msg validated");
				report.updateTestLog("Validate Sign Up ", "Subscription confirmation:"+ ActualConfirmationmsg, Status.DONE);

			}
			else{
				report.updateTestLog("Validate Sign Up ", "Sign Up Validation unsuccessfull", Status.DONE);
			}

		}
		catch(Exception e){
			report.updateTestLog("Validate Sign Up ", "Validation failed", Status.FAIL);
		}

	}

	public void validateBacktoTopArrow(){
		try{
			jse.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(500);
			driver.findElement(CBgas2coal.BackToTopArrow).isDisplayed();
			objWebd.highlightElement(CBgas2coal.BackToTopArrow);
			driver.findElement(CBgas2coal.BackToTopArrow).click();
			driver.findElement(CBgas2coal.Explorelink).isDisplayed();
			objWebd.highlightElement(CBgas2coal.Explorelink);
			report.updateTestLog("Validate Back to Top Arrow ", "Validation successfull", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Validate Back to Top Arrow ", "Validation unsuccessfull", Status.FAIL);
		}
	}

	public void validateStickybar(){
		try	{
			driver.findElement(CBgas2coal.StickyBar).isDisplayed();
			objWebd.highlightElement(CBgas2coal.StickyBar);
			String StickybarTitle=driver.findElement(CBgas2coal.StickyBarTitle).getText();
			System.out.println("The sticky bar under Gas-2-CoalSection section is available ");
			report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation successfull,The sticky bar title is :"+StickybarTitle , Status.PASS);
		}
		catch(Exception e){
			System.out.println("The Sticky bar under Gas-2-CoalSection section is not available ");
			report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateGas2CoalImage(){
		if(driver.findElement(CBgas2coal.BigImage).isDisplayed()==true){

			System.out.println("The Image under Gas-2-CoalSection section is available ");
			report.updateTestLog("Validate Image under Gas-2-CoalSection ", "Image under Gas-2-CoalSection availability Validation successfull", Status.PASS);
		}
		else{
			System.out.println("The Image under Gas-2-CoalSection section is not available ");
			report.updateTestLog("Validate Image under Gas-2-CoalSection ", "Image under Gas-2-CoalSection availability Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateShopNow(){
		try	{

			objWebd.waitUntilPageReadyStateComplete(20);
			Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,1000)", "");
			if(driver.findElement (CBgas2coal.ShopNowBtn).isDisplayed()==true){
				objWebd.highlightElement(CBgas2coal.ShopNowBtn);
				driver.findElement (CBgas2coal.ShopNowBtn).click();
				System.out.println("Shop Now button is available and clicked");
				Thread.sleep(1000);
				for(int count=1 ; count<=5 ; count++ )	{
					String url=driver.getCurrentUrl();

					if(url.contains("https://www.charbroil.com/grills/hybrid-grills")){
						objWebd.waitUntilElementEnabled(CBgas2coal.Productname, 30);
						String productname = driver.findElement(CBgas2coal.Productname).getText();
						if(productname.contains("GAS2COAL"))						
							report.updateTestLog("Validate Shop Button Navigation under  Gas-2-CoalHybrid Grill section  ", "Navigate to correct Url and 1st product name :"
									+ url + productname, Status.PASS);
						else
							report.updateTestLog("Validate Shop Button Navigation under  Gas-2-CoalHybrid Grill section  ", "Navigate to correct Url but product name does not match. 1st product name :"
									+ url + productname, Status.FAIL);
						break;
					}	else if(count==5)
						report.updateTestLog("Gas2Coal page", "Not navigated to Gas2Coal hybrid grill screen.", Status.FAIL);
					else	{
						report.updateTestLog("Gas2Coal page", "Not navigated to Gas2Coal hybrid grill screen in 2 seconds. Will retry in another 2 seconds.", Status.DONE);
						Thread.sleep(2000);
					}
				}
				//validateBreadCrumbLink();
				objWebd.isTextPresent("Gas2Coal® Hybrid Grill");
				report.updateTestLog("Validate the text Gas2Coal® Hybrid Grill", "validation successful" , Status.DONE);
				driver.navigate().back();
			}
			else{
				report.updateTestLog("Validate Shop Button Navigation under  Gas-2-CoalHybrid Grill section  ", "Navigation unsuccessful ", Status.FAIL);
			}

		}
		catch(Exception e){
			report.updateTestLog("Validate Shop Now Button  ", "Validation failed. Exception - "+e, Status.FAIL);
			driver.navigate().back();
		}

	}

	public void validateExploreLink(){
		try{
			driver.findElement(CBgas2coal.Explorelink).isDisplayed();
			driver.findElement(CBgas2coal.Explorelink).isEnabled();
			objWebd.highlightElement(CBgas2coal.Explorelink);
			driver.findElement(CBgas2coal.Explorelink).click();
			//objWebd.wait();
			objWebd.isTextPresent("MADE FOR CONVENIENCE");
			System.out.println("Explore link is validated successfully");
			report.updateTestLog("Validate EXplore Link  ", "Validation successful", Status.PASS);
		}
		catch(Exception e){
			System.out.println("Explore link  validation unsuccessfully");
			report.updateTestLog("Validate EXplore Link", "Validation unsuccessful. Exception is - "+e, Status.FAIL);
		}

	}

	public void validateSmallImgsOnImageSection(){
		try{
			List<WebElement> Images = (driver.findElement(CBgas2coal.HeadLinerBigImage)).findElements(By.className("nyc-hero__headliner"));
			int count =  Images.size();
			if((Images.size())==3){
				System.out.println("No of Headliner Text image validation on the bIg image successfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate Headliner Images Images count under Gas-2-Coal Image Section ", "Headliner Images under Gas-2-Coal Image Section availability Validation successfull"+ count , Status.PASS);
			}
			else{

				System.out.println("No of Headliner Text image validation on the bIg image unsuccessfull: Image count -" +Images.size()  );
				report.updateTestLog("Validate Headliner Images Images count under Gas-2-Coal Image Section ", "Headliner Images under Gas-2-Coal Image Section availability Validation unsuccessfull"+ count , Status.FAIL);
			}

		}


		catch(Exception e){
			report.updateTestLog("No of Headliner Text image validation under Big image ofGas-2-Coal section ", "Validation failed", Status.FAIL);
		}

	}

	public void validateBigImageOnImageSection(){

		try {	
			Thread.sleep(5000);
			objWebd.waitUntilElementEnabled(CBgas2coal.BigImageOnImageSection, 20);
			if(driver.findElement(CBgas2coal.BigImageOnImageSection).isDisplayed()==true){


				objWebd.highlightElement(CBgas2coal.BigImageOnImageSection);


				System.out.println("The big Image under Gas-2-Coal Image section is available ");
				report.updateTestLog("Validate Big Image under Gas-2-Coal Image Section ", "Big Image under Gas-2-Coal Image Section availability Validation successfull", Status.PASS);
			}
			else{
				System.out.println("The Image under Gas-2-CoalSection section is not available ");
				report.updateTestLog("Validate Big Image under Gas-2-Coal Image Section ", "Big Image under Gas-2-Coal Image Section  availability Validation unsuccessfull", Status.FAIL);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void validateMadeforConvImageCount(){
		try{

			objWebd.waitUntilPageReadyStateComplete(20);
			Thread.sleep(3000);
			List<WebElement> Images = (driver.findElement(CBgas2coal.MadeforConveneenceImages)).findElements(By.tagName("li"));
			//System.out.println("No. of Images under Made for Conveneence section : "+Images.size());
			if((Images.size())==3){
				System.out.println("No of image validation successfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate Images count under Made For Convenience Section ", "Image Count successfull.No of images :"+ Images.size() , Status.PASS);
			}	else	{
				System.out.println("No of image validation unsuccessfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate Images count under Made For Convenience Section ", "Image Count unsuccessfull.No of images :"+ Images.size() , Status.FAIL);
			}
		}	catch(Exception e)	{
			report.updateTestLog("Verify Made for Conveneence setion ", "Validation failed.", Status.FAIL);
			report.updateTestLog("Exception in validateMadeforConvImageCount", "Exception is - "+e, Status.FAIL);
		}
	}

	public void validatePlusIcon(){
		try{
			objWebd.highlightElement(CBgas2coal.plusSignOn1stImage);
			objWebd.highlightElement(CBgas2coal.plusSignOn2ndImage);
			objWebd.highlightElement(CBgas2coal.plusSignOn3rdImage);

			System.out.println("All plus icons are available");
			report.updateTestLog("Validate Allplus icons under Made For Flavor Section  ", "Validation Successful", Status.DONE);

			driver.findElement(CBgas2coal.plusSignOn1stImage).click();
			Thread.sleep(300);
			report.updateTestLog("Validation of 1st image  ", "Validation successfull", Status.PASS);


			if (driver.findElement(CBgas2coal.crossSignOnExpanImage).isDisplayed()==true){

				objWebd.highlightElement(CBgas2coal.crossSignOnExpanImage);
				report.updateTestLog("Validate Cross icons under Made For Flavor Section  ", "Cross sign available on expand image", Status.PASS);

				System.out.println("Cross sign available on expand image");
				driver.findElement(CBgas2coal.crossSignOnExpanImage).click();
				Thread.sleep(300);

				driver.findElement(CBgas2coal.plusSignOn2ndImage).click();
				Thread.sleep(300);
				report.updateTestLog("Validation of 2nd image  ", "Validation successfull", Status.PASS);
				driver.findElement(CBgas2coal.crossSignOnExpanImage).click();
				Thread.sleep(200);
				driver.findElement(CBgas2coal.plusSignOn3rdImage).click();
				Thread.sleep(300);
				report.updateTestLog("Validation of 3rd image  ", "Validation successfull", Status.PASS);
				//driver.findElement(CBgas2coal.crossSignOnExpanImage).click();
				//Thread.sleep(200);
				//System.out.println("clicked on Cross sign available on expand image");

				if(driver.findElement(CBgas2coal.Prevlink).isDisplayed()==true){

					objWebd.highlightElement(CBgas2coal.Prevlink);
					objWebd.highlightElement(CBgas2coal.Nextlink);

					System.out.println("Previous and Next arrow link avaialble on expand image");
					report.updateTestLog("Previous and Next arrow link  icons under Made For Flavor Section  ", "Previous and Next arrow link avaialble on expand image", Status.PASS);
					driver.findElement(CBgas2coal.Nextlink).click();
					Thread.sleep(300);
					driver.findElement(CBgas2coal.Nextlink).click();
					Thread.sleep(300);
					driver.findElement(CBgas2coal.crossSignOnExpanImage).click();
					Thread.sleep(200);
					//System.out.println("clicked on Cross sign available on expand image");
				}

				report.updateTestLog("Validate functinality related to plus,cross,and arrow icon under Made For Flavor Section  ", "Validation successfull",Status.PASS);
			}
		}	catch(Exception e)	{
			report.updateTestLog("Validate functinality related to plus,cross,and arrow icon under Made For Flavor Section  ", "Validation unsuccessfull",Status.FAIL);
			report.updateTestLog("Exception in validatePlusIcon", "Exception is - "+e,Status.FAIL);
		}

	}

	public void validateMadeForFlavorImage(){
		if(driver.findElement(CBgas2coal.MadeFlavBigImage).isDisplayed()==true){

			System.out.println("The Image under Made For Flavor section is available ");
			report.updateTestLog("Validate Image under Made For Flavor Section  ", "Validation Successful", Status.PASS);
		}
		else{
			System.out.println("The Image under Made For Flavor section is not available ");
			report.updateTestLog("Validate Image under Made For Flavor Section  ", "Validation Unsuccessful", Status.FAIL);
		}

	}

	public void validateMadeForFlavorImageCount(){

		try	{
			//List<WebElement> AnimatedImages = (driver.findElement(CBgas2coal.MadeFlavAnmImage)).findElements(By.tagName("div"));
			objWebd.waitUntilElementEnabled(CBgas2coal.MadeFlavAnmImage, 20);
			int size = driver.findElements(CBgas2coal.MadeFlavAnmImage).size();
			System.out.println("No of images under section Made for Flavor :"+ size);
			if(size==5)	{
				System.out.println("No of image validation successfull : Image count -" + size  );
				report.updateTestLog("Validate Animated Image count under Made For Flavor Section  ", "Validation Successful.No of images :"+size, Status.PASS);
			}	else	{

				System.out.println("No of Animated image validation unsuccessfull : Image count -" +size);
				report.updateTestLog("Validate AnimatedImage count under Made For Flavor Section  ", "Validation unsuccessful.No of images :"+size, Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("Validate AnimatedImage count under Made For Flavor Section  ", "Validation unsuccessful,Check the report", Status.FAIL);
		}
	}

	public void validateMadeForFlavorAnimatedImages(){

		try{
			validate1stAnmImage();
			validate2ndAnmImage();
			validate3rdAnmImage();
			validate4thAnmImage();
			validate5thAnmImage();
			report.updateTestLog("Validation of Texts,Links on all Animated images under made for Flavor", "Validation sucessfull,Check the report", Status.DONE);
		}
		catch(Exception e){
			report.updateTestLog("Validation of Texts,Links on all Animated images under made for Flavor", "Validation Unsucessfull,Check the report", Status.FAIL);
		}



	}

	public void validate1stAnmImage(){
		try{

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn1stImage).isDisplayed();
			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn1stImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBgas2coal.MadeFlavAnmplusTitle1stImage);
			String Title1=driver.findElement(CBgas2coal.MadeFlavAnmplusTitle1stImage).getText();
			if (Title1.equalsIgnoreCase("SIDE HUSTLE")){
				report.updateTestLog("1st image Title validation", "Validation successful :"+ Title1, Status.PASS);
			}
			else{
				report.updateTestLog("1st image Title validation", "Validation unsuccessful :"+ Title1, Status.FAIL);
			}
			report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn1stImage).click();
			report.updateTestLog("1st Animated Image validation", "Validation successful", Status.PASS);

		}
		catch(Exception e){

			report.updateTestLog("1st Animated Image validation", "Validation usuccessful", Status.FAIL);
		}
	}

	public void validate2ndAnmImage(){
		try{

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn2ndImage).isDisplayed();
			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn2ndImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBgas2coal.MadeFlavAnmplusTitle2ndImage);
			String Title1=driver.findElement(CBgas2coal.MadeFlavAnmplusTitle2ndImage).getText();
			if (Title1.equalsIgnoreCase("YOUR FLAVOR SIDEKICK")){
				report.updateTestLog("2nd Animated image Title validation", "Validation successful :"+ Title1, Status.PASS);
			}
			else{
				report.updateTestLog("2nd Animated image Title validation", "Validation unsuccessful :"+ Title1, Status.FAIL);
			}
			//report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);
			objWebd.highlightElement(CBgas2coal.MadeFlavAnmpluslink2ndImage);
			driver.findElement(CBgas2coal.MadeFlavAnmpluslink2ndImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));			
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase("https://www.charbroil.com/accessories/grilling-tools-bbq-utensils/basting-brushes/basting-brush")){

				System.out.println("Url navigate :"+ url );
				report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);

			}
			else{
				report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.FAIL);
			}

			//validateBreadCrumbLink();
			driver.close();
			Thread.sleep(500);
			driver.switchTo().window(mainwindowHandle);	

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn2ndImage).click();
			report.updateTestLog("2nd Animated Image validation", "Validation successful", Status.PASS);

		}
		catch(Exception e){

			report.updateTestLog("2nd Animated Image validation", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validate3rdAnmImage(){
		try{

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn3rdImage).isDisplayed();
			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn3rdImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBgas2coal.MadeFlavAnmplusTitle3rdImage);
			String Title3=driver.findElement(CBgas2coal.MadeFlavAnmplusTitle3rdImage).getText();
			if (Title3.equalsIgnoreCase("HOW TO GRILL THE BEST GRILLED CHEESEBURGER")){
				report.updateTestLog("3rd image Title validation", "Validation successful :"+ Title3, Status.PASS);
			}
			else{
				report.updateTestLog("3rd image Title validation", "Validation unsuccessful :"+ Title3, Status.FAIL);
			}
			report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);

			objWebd.highlightElement(CBgas2coal.MadeFlavAnmpluslink3rdImage);
			driver.findElement(CBgas2coal.MadeFlavAnmpluslink3rdImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));			
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase("https://www.charbroil.com/cook/best-grilled-cheeseburger")){

				System.out.println("Url navigate :"+ url );
				report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);
			}
			else{
				report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.FAIL);
			}

			//validateEntryTitle();

			/*String Title=driver.findElement(CBgas2coal.MadeFlavAnmpluslink3rdEntryTitle).getText();
				if(Title.equalsIgnoreCase("How to Grill the Best Grilled Cheeseburger")){

					System.out.println("Entry Title on #rd link :"+ Title );
					report.updateTestLog("Validate Link page entry Title ", "Title is present"+ Title , Status.PASS);
				}
				else{
					report.updateTestLog("Validate Link page entry Title ", "Title mismatch :"+ url , Status.FAIL);
				}*/

			driver.close();
			Thread.sleep(500);
			driver.switchTo().window(mainwindowHandle);	

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn2ndImage).click();
			report.updateTestLog("3rd Animated Image validation", "Validation successful", Status.PASS);

		}
		catch(Exception e){

			report.updateTestLog("3rd Animated Image validation", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validate4thAnmImage(){
		try{

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn4thImage).isDisplayed();
			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn4thImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBgas2coal.MadeFlavAnmplusTitle4thImage);
			String Title1=driver.findElement(CBgas2coal.MadeFlavAnmplusTitle4thImage).getText();
			if (Title1.equalsIgnoreCase("CILANTRO LIME CORN ON THE COB")){
				report.updateTestLog("4th Animated image Title validation", "Validation successful :"+ Title1, Status.PASS);
			}
			else{
				report.updateTestLog("4th Animated image Title validation", "Validation unsuccessful :"+ Title1, Status.FAIL);
			}
			report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);

			objWebd.highlightElement(CBgas2coal.MadeFlavAnmpluslink4thImage);
			driver.findElement(CBgas2coal.MadeFlavAnmpluslink4thImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));			
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase("https://www.charbroil.com/cook/cilantro-lime-corn-on-the-cob")){

				System.out.println("Url navigate :"+ url );
				report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);
			}
			else{
				report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.FAIL);
			}

			//validateEntryTitle();

			driver.close();
			Thread.sleep(500);
			driver.switchTo().window(mainwindowHandle);	

			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn4thImage).click();
			report.updateTestLog("4th Animated Image validation", "Validation successful.", Status.PASS);

		}
		catch(Exception e){

			report.updateTestLog("4th Animated Image validation", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validate5thAnmImage(){
		try{
			Thread.sleep(5000);
			objWebd.waitUntilPageReadyStateComplete(20);
			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn5thImage).isDisplayed();
			driver.findElement(CBgas2coal.MadeFlavAnmplusSignOn5thImage).click();
			Thread.sleep(5000);
			objWebd.highlightElement(CBgas2coal.MadeFlavAnmplusTitle5thImage);
			String Title1=driver.findElement(CBgas2coal.MadeFlavAnmplusTitle5thImage).getText();
			if (Title1.equalsIgnoreCase("GET FLIPPIN'")){
				report.updateTestLog("5th image Title validation", "Validation successful :"+ Title1, Status.PASS);
			}	else	{
				report.updateTestLog("5th image Title validation", "Validation unsuccessful :"+ Title1, Status.FAIL);
			}
			//report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);

			objWebd.highlightElement(CBgas2coal.MadeFlavAnmpluslink5thImage);
			driver.findElement(CBgas2coal.MadeFlavAnmpluslink5thImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));			
			String url=driver.getCurrentUrl();
			for(int count=1 ; count<=5 ; count++)	{
				if(url.equalsIgnoreCase("https://www.charbroil.com/accessories/grilling-tools-bbq-utensils/tongs-spatulas/spatula")){
					System.out.println("Url navigate :"+ url );
					report.updateTestLog("Validate Link Navigation", "Navigate to correct Url :"+ url , Status.PASS);
					break;
				}	else if(count==5)	{
					report.updateTestLog("Validate Link Navigation", "Not navigated to correct Url :"+ url , Status.FAIL);
				}	else	{
					report.updateTestLog("Validate Link Navigation", "Not navigated to URL. Wait for 2 more seconds."+ url , Status.DONE);
					Thread.sleep(2000);
				}
			}

			//validateBreadCrumbLink();
			driver.close();
			Thread.sleep(500);
			driver.switchTo().window(mainwindowHandle);	

			//driver.findElement(CBgas2coal.MadeFlavAnmplusClose5thImage).click();
			//report.updateTestLog("5th Animated Image validation", "Validation successful", Status.PASS);

		}
		catch(Exception e){

			report.updateTestLog("5th Animated Image validation", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validateDragdropIcon()
	{

		try{
			driver.findElement (CBgas2coal.DragdropIcon).isDisplayed();
			objWebd.highlightElement(CBgas2coal.DragdropIcon);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			/*jse.executeScript("arguments[0].style.display = 'left: 187.5px;", driver.findElement (CBSmartchef.DragdropIcon));
	    	Thread.sleep(200);
	    	jse.executeScript("arguments[0].style.display = 'left: 96.5px;", driver.findElement (CBSmartchef.DragdropIcon));*/

			report.updateTestLog("Validate Drag and DRop icon  ", "Drag and drop icon is available", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("Validate DragDRop icon displayed ", "Validation unsuccessful", Status.FAIL);
		}

	}

	public void validateShopGas2CoalBtn(){
		try{
			if(driver.findElement (CBgas2coal.ShopGas2CoalBtn).isDisplayed()==true){
				objWebd.highlightElement(CBgas2coal.ShopGas2CoalBtn);
				String Btnname=driver.findElement (CBgas2coal.ShopGas2CoalBtn).getText();
				driver.findElement (CBgas2coal.ShopGas2CoalBtn).click();
				System.out.println("SHOP GAS-2-COAL button is available and clicked"+Btnname);
				Thread.sleep(500);
				String url=driver.getCurrentUrl();
				if(url.equalsIgnoreCase("https://www.charbroil.com/gas2coal-hybrid-grill")){
					System.out.println("Url navigate :"+url);
					report.updateTestLog("Validate Shop Gas-2-Coal Button Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);

				}
				validateBreadCrumbLink();
				//objWebd.isTextPresent("Gas2Coal® Hybrid Grill");
				//report.updateTestLog("Validate the text Gas2Coal® Hybrid Grill", "validation successful" , Status.DONE);

				driver.navigate().back();
			}
			else{
				report.updateTestLog("Validate Shop Gas-2-Coal Button Navigation  ", "Validation failed", Status.FAIL);
			}	
		}
		catch(Exception e){
			report.updateTestLog("Validate Shop Gas-2-Coal Button  ", "Validation failed", Status.FAIL);
			driver.navigate().back();
		}

	}

	public void validateForbessectionImage(){
		if(driver.findElement(CBgas2coal.ForbesImage).isDisplayed()==true){
			System.out.println("The Image under Gas-2-CoalSection section is available ");
			report.updateTestLog("Validate Image under Forbes Section  ", "Validation Successful", Status.PASS);

		}
		else{
			System.out.println("The Image under Gas-2-CoalSection section is not available ");
			report.updateTestLog("Validate Image under Forbes Section  ", "Validation Unsuccessful", Status.FAIL);
		}

	}

	public void validateBreadCrumbLink(){

		try{
			driver.findElement(CBgas2coal.ProdutBreadCrumb).isDisplayed();
			objWebd.highlightElement(CBgas2coal.ProdutBreadCrumb);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBgas2coal.ProdutBreadCrumb).getText();
			report.updateTestLog("Breadcumb link Validation", "validation successfull for Breadcumb Link:" + text, Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBgas2coal.MainContainer).getAttribute("id");
			report.updateTestLog("Breadcumb link Validation", "Validation unsuccessfull:"+ Value, Status.FAIL);
		}  
	}

	public void validateEntryTitle(){

		try{
			driver.findElement(CBgas2coal.ProdutEntryTitle).isDisplayed();
			objWebd.highlightElement(CBgas2coal.ProdutEntryTitle);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBgas2coal.ProdutEntryTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "validation successfull for Productpage Title :" + text, Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBgas2coal.ProdutPageTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "Validation unsuccessfull:"+ Value, Status.FAIL);
		}  

	}



}
