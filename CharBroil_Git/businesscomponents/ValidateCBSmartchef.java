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
import uimap.CBSmartchef;


public class ValidateCBSmartchef extends ReusableLibrary{

	WebDriverUtil objWebd=new WebDriverUtil(driver);
	HomePageComponents obj=new HomePageComponents(scriptHelper);
	JavascriptExecutor jse = (JavascriptExecutor) driver.getWebDriver();
	private static final String GENERAL_DATA = "General_Data";

	public ValidateCBSmartchef(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	public void validateSmartchefGasGrillSection(){
		try{
			System.out.println("/*------------------Smartchef Gas Grill Section --------------------------*/");
			objWebd.isTextPresent("SmartChef® Gas Grill");
			report.updateTestLog("Validate SmartChef® Gas Grill Text ", "SmartChef® Gas Grill Text Validation successfull", Status.PASS);
			System.out.println("SmartChef® Gas Grill  text available");
			obj.validateMyAccLink();
			//obj.validateLoginLink();
			obj.validateCountrydropdown();
			validateBacktoTopArrow();
			validateStickybar();
			validateSmartchefGasGrillImage();
			validateSmallImgsOnImageSection();
			validateBigImageOnImageSection();
			validateShopNow();
			validateExploreLink();
		}
		catch(Exception e){
			report.updateTestLog("Validate For GAS Grill section  ", "Few Validation Failed,Check the Report,", Status.FAIL);
		}

	}

	public void validateSmartchefMadeforConvenienceSection(){

		try {
			System.out.println("/*------------------Made For Convenience section--------------------------*/");

			objWebd.waitUntilPageReadyStateComplete(20);

			Thread.sleep(5000);

			objWebd.isTextPresent("MADE FOR CONVENIENCE");
			Thread.sleep(3000);
			objWebd.isTextPresent("Control and monitor grill temperature, cook times and more using your");

			report.updateTestLog("Validate Texts under MADE FOR CONVENIENCE section ", "Both the  Text line Validation Successfull", Status.DONE);

			validateMadeForConvImageCount();
			validatePlusIcon();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validateSmartchefMadeForFlavorSection(){
		try{
			jse.executeScript("window.scrollBy(0,650)", "");
			System.out.println("/*------------------Made For Flavor section--------------------------*/");
			objWebd.isTextPresent("MADE FOR FLAVOR");
			System.out.println("MADE FOR FLAVOR text available");
			objWebd.isTextPresent("Enjoy your food as much as the occasion with Char-Broil® SmartChef® technology.");
			report.updateTestLog("Validate Texts under MADE FOR FLAVOR section  ", "Text Validation Successfull", Status.PASS);
			validateMadeForFlavorImage();
			validateMadeForFlavorImageCount();
			validateMadeForFlavorAnimatedImages();
		}
		catch(Exception e){

			report.updateTestLog("Validate Made For Flavor section  ", "Validation Failed", Status.FAIL);
		}
	}

	public void validateSmartchefGizmodosSection(){

		try{
			jse.executeScript("window.scrollBy(0,650)", "");
			System.out.println("/*------------------Gizmodos Section--------------------------*/");
			objWebd.isTextPresent("...YOU CAN MONITOR YOUR DINNER WHILE DOING ANYTHING ELSE.");
			System.out.println("...YOU CAN MONITOR YOUR DINNER WHILE DOING ANYTHING ELSE.text available");
			objWebd.isTextPresent("USE THE CLOUD");
			objWebd.highlightElement(CBSmartchef.UseTheCloud);
			objWebd.isTextPresent("Device requirements:");
			objWebd.highlightElement(CBSmartchef.DeviceReq);
			report.updateTestLog("Validate Texts under Forbes section  ", "Both the  Text line under GIZMODO Validation Successfull", Status.DONE);
			System.out.println("Texts under Forbes section validated");
			validateGizmodossectionImage();
			validateDragdropIcon();
			validateShopSmartchefBtn();
		}
		catch(Exception e){

			report.updateTestLog("Validate Forbes section  ", "Validation Failed. Exception - "+e, Status.FAIL);
		}

	}

	public void validateSmartChefSignUp(){
		try{
			jse.executeScript("window.scrollBy(0,250)", "");
			String Confirmationmsg = dataTable.getData(GENERAL_DATA, "SignUpConfirmationMessage");
			String emailid = dataTable.getData(GENERAL_DATA, "Username");
			jse.executeScript("window.scrollBy(0,250)", "");
			System.out.println("/*------------------Smartchef-Sign Up--------------------------*/");

			objWebd.highlightElement(CBSmartchef.SignupMailtxt);
			driver.findElement(CBSmartchef.SignupMailtxt).sendKeys(emailid);
			objWebd.highlightElement(CBSmartchef.SignupBtn);
			driver.findElement(CBSmartchef.SignupBtn).click();
			Thread.sleep(300);
			objWebd.highlightElement(CBSmartchef.ThankuMsg);
			String ActualConfirmationmsg=driver.findElement(CBSmartchef.ThankuMsg).getText();
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
			driver.findElement(CBSmartchef.BackToTopArrow).isDisplayed();
			objWebd.highlightElement(CBSmartchef.BackToTopArrow);
			driver.findElement(CBSmartchef.BackToTopArrow).click();
			Thread.sleep(3000);
			driver.findElement(CBSmartchef.Explorelink).isDisplayed();
			objWebd.highlightElement(CBSmartchef.Explorelink);
			report.updateTestLog("Validate Back to Top Arrow ", "Validation successfull", Status.PASS);

		}
		catch(Exception e){
			report.updateTestLog("Validate Back to Top Arrow ", "Validation unsuccessfull", Status.FAIL);
		}
	}

	public void validateStickybar(){
		try{
			jse.executeScript("window.scrollBy(0,1000)", "");
			Thread.sleep(2000);
			driver.findElement(CBSmartchef.StickyBar).isDisplayed();
			objWebd.highlightElement(CBSmartchef.StickyBar);
			String StickybarTitle=driver.findElement(CBSmartchef.StickyBarTitle).getText();
			System.out.println("The sticky bar under Smartchef Gas Grill section is available ");
			if(StickybarTitle.equalsIgnoreCase("SmartChef® Gas Grill"))
				report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation successfull,The sticky bar title is :"+StickybarTitle , Status.PASS);
			else
				report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation not successfull,The sticky bar title is :"+StickybarTitle , Status.FAIL);
		}
		catch(Exception e){
			System.out.println("The Sticky bar under Smartchef Gas Grill section is not available ");
			report.updateTestLog("Validate Sticky bar ", "Sticky bar availability Validation unsuccessfull. Exception is - "+e, Status.FAIL);
		}

	}

	public void validateSmartchefGasGrillImage(){
		if(driver.findElement(CBSmartchef.BigImage).isDisplayed()==true){

			System.out.println("The Image under Smartchef Gas Grill section is available ");
			report.updateTestLog("Validate Image under Smartchef Gas Grill Section ", "Image  availability Validation successfull", Status.PASS);
		}
		else{
			System.out.println("The Image under Smartchef Gas Grill Section section is not available ");
			report.updateTestLog("Validate Image under Smartchef Gas Grill Section ", "Image  availability Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateSmallImgsOnImageSection(){
		try{
			List<WebElement> Images = (driver.findElement(CBSmartchef.HeadLinerBigImage)).findElements(By.className("nyc-hero__headliner"));
			int count =  Images.size();
			if((Images.size())==3){
				System.out.println("No of Headliner Text image validation on the bIg image successfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate Headliner Images Images count under Gas Grill Image Section ", "Headliner Images under Gas-2-Coal Image Section availability Validation successfull"+ count , Status.PASS);
			}
			else{

				System.out.println("No of Headliner Text image validation on the bIg image unsuccessfull: Image count -" +Images.size()  );
				report.updateTestLog("Validate Headliner Images Images count under Gas Grill Image Section ", "Headliner Images under Gas-2-Coal Image Section availability Validation unsuccessfull"+ count , Status.FAIL);
			}

		}


		catch(Exception e){
			report.updateTestLog("No of Headliner Text image validation under Big image of Gas Grill section ", "Validation failed", Status.FAIL);
		}

	}

	public void validateBigImageOnImageSection(){

		if(driver.findElement(CBSmartchef.BigImageOnImageSection).isDisplayed()==true){

			try {
				objWebd.highlightElement(CBSmartchef.BigImageOnImageSection);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("The big Image under Gas Grill Image section is available ");
			report.updateTestLog("Validate Big Image under Gas Grill Image Section ", "Big Image under Gas-2-Coal Image Section availability Validation successfull", Status.PASS);
		}
		else{
			System.out.println("The Image underGas Grill Section section is not available ");
			report.updateTestLog("Validate Big Image under Gas Grill Image Section ", "Big Image under Gas-2-Coal Image Section  availability Validation unsuccessfull", Status.FAIL);
		}

	}

	public void validateShopNow(){
		try{

			objWebd.waitUntilPageReadyStateComplete(20);
			Thread.sleep(5000);
			if(driver.findElement (CBSmartchef.ShopNowBtn).isDisplayed()==true){
				objWebd.highlightElement(CBSmartchef.ShopNowBtn);
				driver.findElement (CBSmartchef.ShopNowBtn).click();
				System.out.println("Shop Now button is available and clicked");
				Thread.sleep(5000);
				String url=driver.getCurrentUrl();
				String productname = driver.findElement (CBSmartchef.Smartchef1stProduct).getText();
				if(url.equalsIgnoreCase("https://www.charbroil.com/smartchef-tru-infrared-3-burner-gas-grill") 
						&& productname.contains("SMARTCHEF") ){

					System.out.println("Url navigate :"+url+productname);
					report.updateTestLog("Validate Shop Now Button Navigation  ", "Navigate to correct Url and 1st product name :"+ url + productname   , Status.PASS);
				}

				validateBreadCrumbLink();
				//objWebd.isTextPresent("SmartChef®");
				//report.updateTestLog("Validate the text SmartChef® ", "validation successful" , Status.DONE);

				driver.navigate().back();
			}
			else{
				report.updateTestLog("Validate Shop Button Navigation under Smartchef Gas Grill section    ", "Navigation unsuccessful ", Status.FAIL);
			}

		}
		catch(Exception e){
			report.updateTestLog("Validate Shop Now Button  ", "Validation failed", Status.FAIL);
			driver.navigate().back();
		}

	}

	public void validateExploreLink(){
		try{

			objWebd.waitUntilPageReadyStateComplete(20);
			Thread.sleep(5000);

			driver.findElement(CBSmartchef.Explorelink).isDisplayed();
			driver.findElement(CBSmartchef.Explorelink).isEnabled();
			objWebd.highlightElement(CBSmartchef.Explorelink);
			driver.findElement(CBSmartchef.Explorelink).click();
			//objWebd.wait();
			objWebd.isTextPresent("MADE FOR CONVENIENCE");
			System.out.println("Explore link is validated successfully");
			report.updateTestLog("Validate Explore link", "Clicking on it scroll down locatin to made for convenience ", Status.PASS);
		}
		catch(Exception e){
			System.out.println("Explore link  validation unsuccessfully");
			report.updateTestLog("Validate EXplore Link  ", "Validation unsuccessful", Status.FAIL);
		}

	}

	public void validateMadeForConvImageCount(){
		try{
			List<WebElement> Images = (driver.findElement(CBSmartchef.MadeforConveneenceImages)).findElements(By.tagName("li"));
			System.out.println("No. of Images under Made for Conveneence section : "+Images.size());
			if((Images.size())==3){
				System.out.println("No of image validation successfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate image count validation under Made for Convenience ", "Image count validation successfull,No of images : "+ Images.size(), Status.PASS);
			}
			else{

				System.out.println("No of image validation unsuccessfull : Image count -" +Images.size()  );
				report.updateTestLog("Validate image count validation under Made for Convenience ", "Image count validation unsuccessfull,No of images : "+ Images.size(), Status.FAIL);
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
			objWebd.highlightElement(CBSmartchef.plusSignOn1stImage);
			objWebd.highlightElement(CBSmartchef.plusSignOn2ndImage);
			objWebd.highlightElement(CBSmartchef.plusSignOn3rdImage);

			System.out.println("All plus icons are available");
			report.updateTestLog("Validate Allplus icons under Made For Flavor Section  ", "Validation Successful", Status.DONE);

			driver.findElement(CBSmartchef.plusSignOn1stImage).click();
			Thread.sleep(300);
			report.updateTestLog("Validation of 1st image  ", "Validation successfull", Status.PASS);

			//driver.wait();
			if (driver.findElement(CBSmartchef.crossSignOnExpanImage).isDisplayed()==true){

				objWebd.highlightElement(CBSmartchef.crossSignOnExpanImage);
				report.updateTestLog("Validate Cross icons under Made For Flavor Section  ", "Cross sign available on expand image", Status.PASS);

				System.out.println("Cross sign available on expand image");
				driver.findElement(CBSmartchef.crossSignOnExpanImage).click();
				Thread.sleep(300);
				driver.findElement(CBSmartchef.plusSignOn2ndImage).click();
				Thread.sleep(300);
				report.updateTestLog("Validation of 2nd image  ", "Validation successfull", Status.PASS);
				driver.findElement(CBSmartchef.crossSignOnExpanImage).click();
				Thread.sleep(200);
				driver.findElement(CBSmartchef.plusSignOn3rdImage).click();
				Thread.sleep(300);
				report.updateTestLog("Validation of 3rd image  ", "Validation successfull", Status.PASS);


				if(driver.findElement(CBSmartchef.Prevlink).isDisplayed()==true){

					objWebd.highlightElement(CBSmartchef.Prevlink);
					objWebd.highlightElement(CBSmartchef.Nextlink);

					System.out.println("Previous and Next arrow link avaialble on expand image");
					report.updateTestLog("Previous and Next arrow link  icons under Made For Flavor Section  ", "Previous and Next arrow link avaialble on expand image", Status.PASS);
					driver.findElement(CBSmartchef.Nextlink).click();
					Thread.sleep(300);
					driver.findElement(CBSmartchef.Nextlink).click();
					Thread.sleep(300);
					driver.findElement(CBSmartchef.crossSignOnExpanImage).click();
					Thread.sleep(300);
					System.out.println("clicked on Cross sign available on expand image");
				}


				report.updateTestLog("Validate functinality related to plus,cross,and arrow icon under Made For Flavor Section  ", "Validation successfull",Status.PASS);

			}

		}
		catch(Exception e){
			report.updateTestLog("Validate functinality related to plus,cross,and arrow icon under Made For Flavor Section  ", "Validation unsuccessfull",Status.FAIL);
		}

	}

	public void validateMadeForFlavorImage(){
		if(driver.findElement(CBSmartchef.MadeFlavBigImage).isDisplayed()==true){

			System.out.println("The Image under Made For Flavor section is available ");
			report.updateTestLog("Validate Image under Made For Flavor Section  ", "Validation Successful", Status.PASS);
		}
		else{
			System.out.println("The Image under Made For Flavor section is not available ");
			report.updateTestLog("Validate Image under Made For Flavor Section  ", "Validation Unsuccessful", Status.FAIL);
		}

	}

	public void validateMadeForFlavorImageCount(){
		try{
			objWebd.waitUntilElementEnabled(CBSmartchef.MadeFlavAnmImage, 20);
			int size = driver.findElements(CBSmartchef.MadeFlavAnmImage).size();
			//List<WebElement> AnimatedImages = (driver.findElement(CBSmartchef.MadeFlavAnmImage)).findElements(By.tagName("div"));
			System.out.println("No of images under section Made for Flavor :"+ size);

			if(size==4){
				System.out.println("No of image validation successfull : Image count -" +size);
				report.updateTestLog("Validate Animated Image count under Made For Flavor Section  ", "Validation Successful", Status.PASS);
			}	else	{

				System.out.println("No of image validation unsuccessfull : Image count -" +size);
				report.updateTestLog("Validate Animated Image count under Made For Flavor Section  ", "Validation UnSuccessful", Status.FAIL);
			}
		}	catch(Exception e){
			report.updateTestLog("Verify Made for Conveneence setion ", "Validation failed", Status.FAIL);
		}
	}

	public void validateMadeForFlavorAnimatedImages(){

		try{

			validate1stAnmImage();

			validate2ndAnmImage();

			validate3rdAnmImage();

			validate4thImage();
			report.updateTestLog("Verify all Animated Images ", "Validation successfull", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("Verify all Animated Images", "Validation failed for all images,check report", Status.FAIL);
		}

	}

	public void validate1stAnmImage(){
		try{

			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn1stImage).isDisplayed();
			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn1stImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBSmartchef.MadeFlavAnmplusTitle1stImage);
			String Title1=driver.findElement(CBSmartchef.MadeFlavAnmplusTitle1stImage).getText();
			if (Title1.equalsIgnoreCase("COFFEE BOURBON BONE-IN PORK ROAST")){
				report.updateTestLog("1st image Title validation", "Validation successful :"+ Title1, Status.PASS);
			}
			else{
				report.updateTestLog("1st image Title validation", "Validation unsuccessful :"+ Title1, Status.FAIL);
			}
			//report.updateTestLog("Click on Plus icon to display the image", "Page dispalyed sucessfully", Status.DONE);
			objWebd.highlightElement(CBSmartchef.MadeFlavAnmpluslink1stImage);
			driver.findElement(CBSmartchef.MadeFlavAnmpluslink1stImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());			
			driver.switchTo().window(tabs.get(1));

			for(int count=1 ; count<3 ; count++)	{
				String url=driver.getCurrentUrl();
				if(url.contains("https://www.charbroil.com/cook/coffee-bourbon-bone-pork-roast"))	{
					System.out.println("Url navigate :"+ url );
					report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);
				}	else if(count==3)	{
					report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.FAIL);
				}	else	{
					report.updateTestLog("Validate Link Navigation  ", "URL not opened till now. Wait for 3 more seconds.", Status.DONE);
					Thread.sleep(3000);
				}
			}

			//validateEntryTitle();

			driver.close();
			driver.switchTo().window(mainwindowHandle);				
			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn1stImage).click();
			report.updateTestLog("1st Animated Image validation", "Validation successful", Status.PASS);

		}
		catch(Exception e)	{
			report.updateTestLog("1st Animated Image validation", "Validation usuccessful", Status.FAIL);
		}
	}

	public void validate2ndAnmImage(){
		try{
			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn2ndImage).click();
			Thread.sleep(200);

			objWebd.highlightElement(CBSmartchef.MadeFlavAnmplusTitle2ndImage);
			String Title2=driver.findElement(CBSmartchef.MadeFlavAnmplusTitle2ndImage).getText();
			if (Title2.equalsIgnoreCase("How to Grill the Perfect Steak")){
				report.updateTestLog("2nd image Title validation", "Validation successful :"+ Title2, Status.PASS);
			}
			else{
				report.updateTestLog("2nd image Title validation", "Validation unsuccessful :"+ Title2, Status.FAIL);
			}
			objWebd.highlightElement(CBSmartchef.MadeFlavAnmpluslink2ndImage);
			driver.findElement(CBSmartchef.MadeFlavAnmpluslink2ndImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);

			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));

			for(int count=1 ; count<3 ; count++)	{
				String url=driver.getCurrentUrl();
				if(url.equalsIgnoreCase("https://www.charbroil.com/learn/grill-the-perfect-steak")){
					System.out.println("Url navigate :"+ url );
					report.updateTestLog("Validate Link Navigation", "Navigate to correct Url :"+ url , Status.PASS);
				}	else if(count==3)	{
					report.updateTestLog("Validate Link Navigation", "Navigate to correct Url :"+ url , Status.FAIL);
				}	else	{
					report.updateTestLog("Validate Link Navigation", "URL not opened till now. Wait for 3 more seconds.", Status.DONE);
					Thread.sleep(3000);
				}
			}

			//validateEntryTitle();

			driver.close();
			driver.switchTo().window(mainwindowHandle);	
			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn2ndImage).click();
			Thread.sleep(100);
			//report.updateTestLog("2nd Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){

			report.updateTestLog("2nd Animated Image validation", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validate3rdAnmImage(){
		try{
			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn3rdImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBSmartchef.MadeFlavAnmplusTitle3rdImage);
			String Title3=driver.findElement(CBSmartchef.MadeFlavAnmplusTitle3rdImage).getText();
			if (Title3.equalsIgnoreCase("the ultimate control panel")){
				report.updateTestLog("3rd image Title validation", "Validation successful :"+ Title3, Status.PASS);
			}
			else{
				report.updateTestLog("3rd image Title validation", "Validation unsuccessful :"+ Title3, Status.FAIL);
			}
			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn3rdImage).click();
			Thread.sleep(100);
			report.updateTestLog("3rd Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){

			report.updateTestLog("3rd Animated Image validation", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}
	}

	public void validate4thImage(){
		try{

			driver.findElement(CBSmartchef.MadeFlavAnmplusSignOn4thImage).click();
			Thread.sleep(200);
			objWebd.highlightElement(CBSmartchef.MadeFlavAnmplusTitle4thImage);
			String Title4=driver.findElement(CBSmartchef.MadeFlavAnmplusTitle4thImage).getText();
			if (Title4.equalsIgnoreCase("TRU-Infrared™ Technology"))	{
				report.updateTestLog("4th image Title validation", "Validation successful :"+ Title4, Status.PASS);
			}
			else{
				report.updateTestLog("4th image Title validation", "Validation unsuccessful :"+ Title4, Status.FAIL);
			}
			objWebd.highlightElement(CBSmartchef.MadeFlavAnmpluslink4thImage);
			driver.findElement(CBSmartchef.MadeFlavAnmpluslink4thImage).click();
			String mainwindowHandle = driver.getWindowHandle();
			Thread.sleep(10000);
			//Get the list of window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			//System.out.println(tabs.size());
			//Use the list of window handles to switch between windows
			driver.switchTo().window(tabs.get(1));

			for(int count=1 ; count<3 ; count++)	{
				String url=driver.getCurrentUrl();
				if(url.equalsIgnoreCase("https://www.charbroil.com/tru-infrared/")){
					System.out.println("Url navigate :"+ url );
					report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.PASS);
				}	else if(count==3)	{
					report.updateTestLog("Validate Link Navigation  ", "Navigate to correct Url :"+ url , Status.FAIL);
				}	else	{
					report.updateTestLog("Validate Link Navigation  ", "URL not opened till now. Wait for 3 more seconds.", Status.DONE);
					Thread.sleep(3000);
				}				
			}
			//validatepageWrapper();
			driver.close();
			driver.switchTo().window(mainwindowHandle);
			//report.updateTestLog("4th Animated Image validation", "Validation successful", Status.PASS);
		}
		catch(Exception e){

			report.updateTestLog("4th Animated Image validation", "Validation usuccessful", Status.FAIL);
		}
	}

	public void validatepageWrapper(){

		try{
			driver.findElement(CBSmartchef.ProdutPagelogo).isDisplayed();
			objWebd.highlightElement(CBSmartchef.ProdutPagelogo);
			report.updateTestLog("Product Page centally allgined logo Validation", "validation successfull for Productpage logo :", Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBSmartchef.ProdutPageTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "Validation unsuccessfull:"+ Value, Status.FAIL);
		}  

	}

	public void validateGizmodossectionImage(){
		if(driver.findElement(CBSmartchef.GIZMODOImage).isDisplayed()==true){
			System.out.println("The Image under Smart chef-GIZMODO Image section is available ");
			report.updateTestLog("Validate Image under GIZMODO Section  ", "Validation Successful", Status.PASS);

		}
		else{
			System.out.println("The Image under Smart chef-GIZMODO Image section is not available ");
			report.updateTestLog("Validate Image under GIZMODO Section  ", "Validation Unsuccessful.", Status.FAIL);
		}

	}

	public void validateDragdropIcon()
	{

		try{
			driver.findElement (CBSmartchef.DragdropIcon).isDisplayed();
			objWebd.highlightElement(CBSmartchef.DragdropIcon);
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			/*jse.executeScript("arguments[0].style.display = 'left: 187.5px;", driver.findElement (CBSmartchef.DragdropIcon));
    	Thread.sleep(200);
    	jse.executeScript("arguments[0].style.display = 'left: 96.5px;", driver.findElement (CBSmartchef.DragdropIcon));*/

			report.updateTestLog("Validate Drag and DRop icon  ", "Drag and drop icon is available", Status.PASS);
		}
		catch(Exception e){
			report.updateTestLog("Validate DragDRop icon displayed ", "Validation unsuccessful. Exception - "+e, Status.FAIL);
		}

	}

	public void validateShopSmartchefBtn(){
		try		{
			if(driver.findElement (CBSmartchef.ShopSmartChefBtn).isDisplayed()==true){
				objWebd.highlightElement(CBSmartchef.ShopSmartChefBtn);
				String Btnname=driver.findElement (CBSmartchef.ShopSmartChefBtn).getText();
				driver.findElement (CBSmartchef.ShopSmartChefBtn).click();
				System.out.println("Shop SmartChef Button is available and clicked "+ Btnname);
				Thread.sleep(3000);

				for(int i=1 ; i<=3 ; i++)	{
					String url=driver.getCurrentUrl();
					if(url.contains("https://www.charbroil.com/smartchef"))	{
						objWebd.waitUntilElementEnabled(CBSmartchef.Smartchef1stProduct, 20);
						String productname = driver.findElement (CBSmartchef.Smartchef1stProduct).getText();
						objWebd.highlightElement(CBSmartchef.Smartchef1stProduct);
						if(productname.contains("SMARTCHEF") ){
							System.out.println("Url navigate :"+ url + productname);
							report.updateTestLog("Validate Shop SmartChef Button Navigation  ", "Navigate to correct Url and 1st product name :"+ url + productname   , Status.PASS);
						}
						break;
					}	else if(i==3)	{
						report.updateTestLog("Validate Shop SmartChef Button Navigation", "Not navigated to expected URL.", Status.FAIL);
					}	else	{
						report.updateTestLog("Validate Shop SmartChef Button Navigation", "Not navigated to expected URL till now. Wait for 3 more seconds.", Status.DONE);
						Thread.sleep(3000);
					}
				}

				driver.navigate().back();
			}	else	{
				report.updateTestLog("Validate Shop SmartChef Button Navigation  ", "Navigation to correct url fails:Check the report", Status.FAIL);
			}
		}
		catch(Exception e){
			report.updateTestLog("Validation of Shop SmartChef button Navigation  ", "Validation failed. Exception - "+e, Status.FAIL);
			driver.navigate().back();
		}
	}

	public void validateBreadCrumbLink(){

		try{
			driver.findElement(CBSmartchef.ProdutBreadCrumb).isDisplayed();
			objWebd.highlightElement(CBSmartchef.ProdutBreadCrumb);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBSmartchef.ProdutBreadCrumb).getText();
			report.updateTestLog("Breadcumb link Validation", "validation successfull for Breadcumb Link:" + text, Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBSmartchef.MainContainer).getAttribute("id");
			report.updateTestLog("Breadcumb link Validation", "Validation unsuccessfull"+Value, Status.FAIL);
		}  
	}

	public void validateEntryTitle(){

		try{
			driver.findElement(CBSmartchef.ProdutEntryTitle).isDisplayed();
			objWebd.highlightElement(CBSmartchef.ProdutEntryTitle);
			//report.updateTestLog("Breadcumb link Validation", "validation successfull", Status.PASS);
			String text=driver.findElement(CBSmartchef.ProdutEntryTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "validation successfull for Productpage Title :" + text, Status.PASS);			
		}
		catch(Exception e){


			String Value=driver.findElement(CBSmartchef.ProdutPageTitle).getText();
			report.updateTestLog("Product Page Entry Title Validation", "Validation unsuccessfull:"+ Value, Status.FAIL);
		}  

	}

}
